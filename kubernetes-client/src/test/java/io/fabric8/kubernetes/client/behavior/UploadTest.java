/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.behavior;

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.CopyOrReadable;
import io.fabric8.kubernetes.client.dsl.internal.uploadable.PodUpload;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Pod Upload Behavior")
class UploadTest {

  private TestStandardHttpClientFactory factory;
  private KubernetesClient client;
  private TestStandardHttpClient httpClient;

  @BeforeEach
  void setUp() {
    factory = new TestStandardHttpClientFactory();
    client = new KubernetesClientBuilder().withHttpClientFactory(factory).build();
    httpClient = factory.getInstances().iterator().next();
  }

  @Test
  @DisplayName("With non-existent source path, should throw exception")
  void uploadInvalidSourcePathShouldThrowException(@TempDir Path pathToUpload) {
    // Given
    final CopyOrReadable podUpload = client.pods().inNamespace("namespace").withName("pod")
        .file("/target/location");
    final Path nonExistentPath = pathToUpload.resolve("non-existent");
    // When - Then
    assertThatIllegalArgumentException()
        .isThrownBy(() -> podUpload.upload(nonExistentPath))
        .withMessage("Provided arguments are not valid (file, directory, path)");
  }

  @Test
  @DisplayName("With valid source file and Pod with no containers, should throw exception")
  void uploadInvalidTargetPodThrowException(@TempDir Path pathToUpload) throws IOException {
    // Given
    factory.expect("/api/v1/namespaces/namespace/pods", 200, "{\"metadata\": {}}");
    factory.expect("/api/v1/namespaces/namespace/pods/valid-source", 200, "{\"metadata\": {}}");
    final CopyOrReadable podUpload = client.pods().inNamespace("namespace").withName("valid-source")
        .file("/target/location");
    final Path validPath = Files.createFile(pathToUpload.resolve("file.txt"));
    // When - Then
    assertThatThrownBy(() -> podUpload.upload(validPath))
        .isInstanceOf(KubernetesClientException.class)
        .hasMessage("Pod has no containers!");
  }

  @Test
  @DisplayName("With failed upload, attempts to delete temp file")
  void uploadFailureDeletesTemp() {
    // Given
    final WebSocket webSocket = mock(WebSocket.class);
    when(webSocket.send(any())).thenReturn(true);
    final TestStandardHttpClient.WsFutureProvider future = (s, l) -> {
      l.onOpen(webSocket);
      l.onMessage(webSocket, ByteBuffer.wrap("\u0003 ".getBytes(StandardCharsets.UTF_8))); // exit
      return CompletableFuture.completedFuture(new WebSocketResponse(new WebSocketUpgradeResponse(null), webSocket));
    };
    // Upload
    // Delete
    factory.times(2).forEach(i -> {
      informPodReady("failure-pod");
      httpClient.wsExpect("/api/v1/namespaces/.+/pods/failure-pod/exec", future);
    });
    // When
    client.pods().inNamespace("default").withName("failure-pod").file("/target/location")
        .upload(new File(Objects.requireNonNull(PodUpload.class.getResource("/upload/upload-sample.txt")).getFile()).toPath());
    // Then
    assertThat(httpClient.getRecordedBuildWebSocketDirects())
        .element(1)
        .extracting(TestStandardHttpClient.RecordedBuildWebSocketDirect::getStandardWebSocketBuilder)
        .extracting(StandardWebSocketBuilder::asHttpRequest)
        .extracting(StandardHttpRequest::uri)
        .extracting(URI::getQuery).asString()
        .contains("command=rm /tmp/fabric8-");
  }

  @Nested
  @DisplayName("Successful")
  class Success {

    private ScheduledExecutorService executorService;

    private WebSocket webSocket;
    private Path toUpload;

    @BeforeEach
    void setUp() {
      executorService = Executors.newSingleThreadScheduledExecutor();
      final AtomicInteger tarByteCount = new AtomicInteger(0);
      webSocket = mock(WebSocket.class);
      when(webSocket.send(any())).thenAnswer(i -> {
        tarByteCount.addAndGet(i.<ByteBuffer> getArgument(0).remaining() - 1);
        return true;
      });
      final TestStandardHttpClient.WsFutureProvider future = (s, l) -> {
        l.onOpen(webSocket);
        if (s.asHttpRequest().uri().getQuery().contains("command=wc -c")) {
          l.onMessage(webSocket, ByteBuffer.wrap(("\u0001" + tarByteCount.get() + "\n").getBytes(StandardCharsets.UTF_8)));
        }
        // Needs a short delay to be able to process the previous message (TODO: this should be fixed in the production code)
        executorService.schedule(() -> l.onMessage(webSocket, exitZeroEvent()), 100, TimeUnit.MILLISECONDS);
        return CompletableFuture.completedFuture(new WebSocketResponse(new WebSocketUpgradeResponse(null), webSocket));
      };
      // Upload
      // Word Count
      // Extract Tar
      factory.times(3).forEach(i -> {
        informPodReady("success-pod");
        httpClient.wsExpect("/api/v1/namespaces/.+/pods/success-pod/exec", future);
      });
    }

    @AfterEach
    void tearDown() {
      executorService.shutdownNow();
    }

    @Nested
    @DisplayName("File")
    class SingleFile {

      @BeforeEach
      void setUp() {
        toUpload = new File(Objects.requireNonNull(PodUpload.class.getResource("/upload/upload-sample.txt"))
            .getFile()).toPath();
      }

      @Test
      @DisplayName("upload, returns true")
      void uploadReturnsTrue() {
        // When
        final boolean result = client.pods().inNamespace("default").withName("success-pod").file("/target/location")
            .upload(toUpload);
        // Then
        assertThat(result).isTrue();
      }

      @Test
      @DisplayName("creates temp directory and pipes compressed file in server")
      void createsTempDirectoryAndPipesFileInServer() {
        // When
        client.pods().inNamespace("default").withName("success-pod").file("/target/location")
            .upload(toUpload);
        // Then
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .element(0)
            .extracting(TestStandardHttpClient.RecordedBuildWebSocketDirect::getStandardWebSocketBuilder)
            .extracting(StandardWebSocketBuilder::asHttpRequest)
            .extracting(StandardHttpRequest::uri)
            .extracting(URI::getQuery).asString()
            .contains("command=mkdir -p '/tmp' && cat - > '/tmp/fabric8-");
      }

      @Test
      @DisplayName("verifies uploaded tar size in server")
      void verifiesUploadedTarSize() {
        // When
        client.pods().inNamespace("default").withName("success-pod").file("/target/location")
            .upload(toUpload);
        // Then
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .element(1)
            .extracting(TestStandardHttpClient.RecordedBuildWebSocketDirect::getStandardWebSocketBuilder)
            .extracting(StandardWebSocketBuilder::asHttpRequest)
            .extracting(StandardHttpRequest::uri)
            .extracting(URI::getQuery).asString()
            .contains("command=wc -c < '/tmp/fabric8-");
      }

      @Test
      @DisplayName("extracts tar with file to final location in server")
      void extractsTar() {
        // When
        client.pods().inNamespace("default").withName("success-pod").file("/target-dir/location")
            .upload(toUpload);
        // Then
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .element(2)
            .extracting(TestStandardHttpClient.RecordedBuildWebSocketDirect::getStandardWebSocketBuilder)
            .extracting(StandardWebSocketBuilder::asHttpRequest)
            .extracting(StandardHttpRequest::uri)
            .extracting(URI::getQuery).asString()
            .matches(
                ".+command=mkdir -p '/target-dir'; tar -C '/target-dir' -xmf /tmp/fabric8-.+\\.tar; e=\\$\\?; rm /tmp/fabric8-.+");
      }

      @Nested
      @DisplayName("Tar compression")
      class TarCompression {

        private ArgumentCaptor<ByteBuffer> sendCaptor;

        @BeforeEach
        void setUp() {
          sendCaptor = ArgumentCaptor.forClass(ByteBuffer.class);
        }

        @Test
        @DisplayName("Creates a valid Tar archive from file")
        void validTarArchive() throws Exception {
          // When
          client.pods().inNamespace("default").withName("success-pod").file("/target-dir/file-name.txt")
              .upload(toUpload);
          // Then
          verify(webSocket).send(sendCaptor.capture());
          // First byte is the WebSocket Flag (0) (discard it)
          final byte[] tarBytes = new byte[sendCaptor.getValue().remaining() - 1];
          System.arraycopy(sendCaptor.getValue().array(), 1, tarBytes, 0, tarBytes.length);
          final TarArchiveInputStream tar = new TarArchiveInputStream(new ByteArrayInputStream(tarBytes));
          assertThat(tar.getNextTarEntry())
              .hasFieldOrPropertyWithValue("name", "file-name.txt")
              .hasFieldOrPropertyWithValue("size", toUpload.toFile().length());
        }

        @Test
        @DisplayName("Long file names supported (POSIX)")
        void longFileNamesSupported() throws Exception {
          // Given
          final String longFileName = String.format("long-file%-100s.txt", "-");
          // When
          client.pods().inNamespace("default").withName("success-pod")
              .file("/target-dir/" + longFileName)
              .upload(toUpload);
          // Then
          verify(webSocket).send(sendCaptor.capture());
          // First byte is the WebSocket Flag (0) (discard it)
          final byte[] tarBytes = new byte[sendCaptor.getValue().remaining() - 1];
          System.arraycopy(sendCaptor.getValue().array(), 1, tarBytes, 0, tarBytes.length);
          final TarArchiveInputStream tar = new TarArchiveInputStream(new ByteArrayInputStream(tarBytes));
          assertThat(tar.getNextTarEntry())
              .hasFieldOrPropertyWithValue("name", longFileName);
        }

        @Test
        @DisplayName("Big numbers supported (POSIX)")
        void bigNumbersSupported(@TempDir Path tempDir) throws Exception {
          // When
          final Path toUploadWithModifiedDate = Files.copy(toUpload, tempDir.resolve("upload-sample.txt"));
          toUploadWithModifiedDate.toFile().setLastModified(9999999999999L); // Would trigger IllegalArgumentException: last modification time '9999999999' is too big ( > 8589934591 ).
          client.pods().inNamespace("default").withName("success-pod").file("/target-dir/file-name.txt")
              .upload(toUploadWithModifiedDate);
          // Then
          verify(webSocket).send(sendCaptor.capture());
          // First byte is the WebSocket Flag (0) (discard it)
          final byte[] tarBytes = new byte[sendCaptor.getValue().remaining() - 1];
          System.arraycopy(sendCaptor.getValue().array(), 1, tarBytes, 0, tarBytes.length);
          final TarArchiveInputStream tar = new TarArchiveInputStream(new ByteArrayInputStream(tarBytes));
          assertThat(tar.getNextTarEntry())
              .hasFieldOrPropertyWithValue("name", "file-name.txt")
              .hasFieldOrPropertyWithValue("lastModifiedTime", FileTime.fromMillis(9999999999999L));
        }
      }
    }

    @Nested
    @DisplayName("Directory")
    class Directory {

      @BeforeEach
      void setUp() {
        toUpload = new File(Objects.requireNonNull(PodUpload.class.getResource("/upload_long"))
            .getFile()).toPath();
        assertThat(toUpload).isDirectory();
      }

      @Test
      @DisplayName("upload, returns true")
      void uploadReturnsTrue() {
        // When
        final boolean result = client.pods().inNamespace("default").withName("success-pod").dir("/target/location")
            .upload(toUpload);
        // Then
        assertThat(result).isTrue();
      }

      @Test
      @DisplayName("creates temp directory and pipes compressed directory in server")
      void createsTempDirectoryAndPipesDirInServer() {
        // When
        client.pods().inNamespace("default").withName("success-pod").dir("/target/location")
            .upload(toUpload);
        // Then
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .element(0)
            .extracting(TestStandardHttpClient.RecordedBuildWebSocketDirect::getStandardWebSocketBuilder)
            .extracting(StandardWebSocketBuilder::asHttpRequest)
            .extracting(StandardHttpRequest::uri)
            .extracting(URI::getQuery).asString()
            .contains("command=mkdir -p '/tmp' && cat - > '/tmp/fabric8-");
      }

      @Test
      @DisplayName("verifies uploaded tar size in server")
      void verifiesUploadedTarSize() {
        // When
        client.pods().inNamespace("default").withName("success-pod").dir("/target/location")
            .upload(toUpload);
        // Then
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .element(1)
            .extracting(TestStandardHttpClient.RecordedBuildWebSocketDirect::getStandardWebSocketBuilder)
            .extracting(StandardWebSocketBuilder::asHttpRequest)
            .extracting(StandardHttpRequest::uri)
            .extracting(URI::getQuery).asString()
            .contains("command=wc -c < '/tmp/fabric8-");
      }

      @Test
      @DisplayName("extracts tar with file to final location in server")
      void extractsTar() {
        // When
        client.pods().inNamespace("default").withName("success-pod").dir("/target-dir/location")
            .upload(toUpload);
        // Then
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .element(2)
            .extracting(TestStandardHttpClient.RecordedBuildWebSocketDirect::getStandardWebSocketBuilder)
            .extracting(StandardWebSocketBuilder::asHttpRequest)
            .extracting(StandardHttpRequest::uri)
            .extracting(URI::getQuery).asString()
            .matches(
                ".+command=mkdir -p '/target-dir/location'; tar -C '/target-dir/location' -xmf /tmp/fabric8-.+\\.tar; e=\\$\\?; rm /tmp/fabric8-.+");
      }

    }

  }

  private ByteBuffer exitZeroEvent() {
    final Status success = new StatusBuilder().withStatus("Success").build();
    return ByteBuffer.wrap(("\u0003" + client.getKubernetesSerialization().asJson(success)).getBytes(StandardCharsets.UTF_8));
  }

  private void informPodReady(String podName) {
    final PodList podReadyList = new PodListBuilder()
        .withNewMetadata().endMetadata()
        .addNewItem()
        .withNewMetadata().withName(podName).endMetadata()
        .withNewSpec().addNewContainer().withName(podName).endContainer().endSpec()
        .withNewStatus().addNewCondition().withType("Ready").withStatus("True").endCondition().endStatus()
        .endItem()
        .build();
    factory.expect("/api/v1/namespaces/.+/pods",
        200, client.getKubernetesSerialization().asJson(podReadyList));
  }
}
