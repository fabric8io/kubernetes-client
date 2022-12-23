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
package io.fabric8.kubernetes.client.dsl.internal.uploadable;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.internal.ExecWebSocketListener;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.impl.BaseClient;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PodUploadTest {

  private HttpClient mockClient;
  private WebSocket mockWebSocket;
  private PodOperationsImpl operation;

  @FunctionalInterface
  public interface PodUploadTester<R> {
    R apply() throws IOException, InterruptedException;
  }

  @BeforeEach
  void setUp() {
    mockClient = mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    mockWebSocket = mock(WebSocket.class, Mockito.RETURNS_DEEP_STUBS);
    when(mockWebSocket.send(any())).thenReturn(true);
    when(mockClient.newBuilder().readTimeout(anyLong(), any(TimeUnit.class)).build()).thenReturn(mockClient);

    BaseClient client = mock(BaseClient.class, Mockito.RETURNS_SELF);
    Mockito.when(client.adapt(BaseClient.class).getExecutor()).thenReturn(CommonThreadPool.get());
    Config config = mock(Config.class, Mockito.RETURNS_DEEP_STUBS);
    when(config.getMasterUrl()).thenReturn("https://openshift.com:8443");
    when(config.getNamespace()).thenReturn("default");
    when(client.getConfiguration()).thenReturn(config);
    when(client.getHttpClient()).thenReturn(mockClient);
    final Pod item = new PodBuilder()
        .withNewMetadata().withName("pod").endMetadata()
        .withNewSpec().addNewContainer().withName("container").endContainer().endSpec()
        .build();
    this.operation = (PodOperationsImpl) new PodOperationsImpl(
        new PodOperationContext(), new OperationContext().withClient(client)).resource(item);
    when(mockClient.sendAsync(Mockito.any(), Mockito.eq(byte[].class)))
        .thenReturn(CompletableFuture.completedFuture(TestHttpResponse.from(200, Serialization.asJson(item))));
  }

  @Test
  @DisplayName("With invalid parameters, should throw exception")
  void uploadInvalidParametersShouldThrowException(@TempDir Path pathToUpload) {
    final Path nonExistentPath = pathToUpload.resolve("non-existent");
    assertThatIllegalArgumentException()
        .isThrownBy(() -> PodUpload.upload(operation, nonExistentPath))
        .withMessage("Provided arguments are not valid (file, directory, path)");
  }

  @Test
  void upload_withFile_shouldUploadFile() throws IOException, InterruptedException {
    final Path toUpload = new File(PodUpload.class.getResource("/upload/upload-sample.txt").getFile())
        .toPath();
    uploadFileAndVerify(() -> PodUpload.upload(operation, toUpload));
  }

  @Test
  void uploadFileData_whenByteArrayInputStreamProvided_shouldUploadFile() throws IOException, InterruptedException {
    InputStream inputStream = new ByteArrayInputStream("test data".getBytes());
    uploadFileAndVerify(() -> PodUpload.uploadFileData(operation, inputStream));
  }

  @Test
  void upload_withDirectory_shouldUploadDirectory() throws Exception {
    final Path toUpload = new File(PodUpload.class.getResource("/upload").getFile())
        .toPath();
    uploadDirectoryAndVerify(() -> PodUpload.upload(operation, toUpload));
  }

  @Test
  void upload_withDirectoryAndLongFileNames_shouldUploadDirectory() throws Exception {
    final Path toUpload = new File(PodUpload.class.getResource("/upload_long").getFile())
        .toPath();
    uploadDirectoryAndVerify(() -> PodUpload.upload(operation, toUpload));
  }

  @Test
  void transferTo() throws Exception {
    final ByteArrayInputStream input = new ByteArrayInputStream("I'LL BE COPIED".getBytes(Charset.defaultCharset()));
    final AtomicReference<String> copiedStream = new AtomicReference<>();
    final InputStreamPumper.Writable consumer = (bytes, offset, length) -> {
      assertThat(length).isEqualTo(14);
      copiedStream.set(new String(Arrays.copyOf(bytes, 14), Charset.defaultCharset()));
    };
    InputStreamPumper.transferTo(input, consumer);
    assertThat(copiedStream).hasValue("I'LL BE COPIED");
  }

  @Test
  void createExecCommandForUpload_withFileInRootPath_shouldCreateValidExecCommandForUpload() {
    // When
    String result = PodUpload.createExecCommandForUpload("/cp.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/' && base64 -d - > '/cp.log'");
  }

  @Test
  void createExecCommandForUpload_withNormalFile_shouldCreateValidExecCommandForUpload() {
    // When
    String result = PodUpload.createExecCommandForUpload("/tmp/foo/cp.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/tmp/foo' && base64 -d - > '/tmp/foo/cp.log'");
  }

  @Test
  void createExecCommandForUpload_withSingleQuoteInPath() {
    // When
    String result = PodUpload.createExecCommandForUpload("/tmp/fo'o/cp.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/tmp/fo\'\\'\'o' && base64 -d - > '/tmp/fo\'\\'\'o/cp.log'");
  }

  @Test
  void createExecCommandForUpload_withMultipleSingleQuotesInPath() {
    // When
    String result = PodUpload.createExecCommandForUpload("/tmp/f'o'o/c'p.log");
    // Then
    assertThat(result).isEqualTo("mkdir -p '/tmp/f\'\\'\'o\'\\'\'o' && base64 -d - > '/tmp/f\'\\'\'o\'\\'\'o/c\'\\'\'p.log'");
  }

  void uploadFileAndVerify(PodUploadTester<Boolean> fileUploadMethodToTest) throws IOException, InterruptedException {
    operation = operation.file("/mock/dir/file");
    WebSocket.Builder builder = mock(WebSocket.Builder.class, Mockito.RETURNS_SELF);
    when(builder.buildAsync(any())).thenAnswer(newWebSocket -> {
      final ExecWebSocketListener wsl = newWebSocket.getArgument(0, ExecWebSocketListener.class);
      // Set ready status
      wsl.onOpen(mockWebSocket);
      wsl.onMessage(mockWebSocket, ByteBuffer.wrap(new byte[] { (byte) 0 }));
      // Set complete status
      Mockito.doAnswer(close -> {
        wsl.onClose(mockWebSocket, close.getArgument(0), close.getArgument(1));
        return null;
      }).when(mockWebSocket).sendClose(anyInt(), anyString());
      return CompletableFuture.completedFuture(mockWebSocket);
    });
    when(mockClient.newWebSocketBuilder()).thenReturn(builder);

    final boolean result = fileUploadMethodToTest.apply();

    assertThat(result).isTrue();
    ArgumentCaptor<URI> captor = ArgumentCaptor.forClass(URI.class);
    verify(builder, times(2)).uri(captor.capture());
    assertEquals(
        "https://openshift.com:8443/api/v1/namespaces/default/pods?fieldSelector=metadata.name%3Dpod&allowWatchBookmarks=true&watch=true",
        captor.getAllValues().get(0).toString());
    assertEquals(
        "https://openshift.com:8443/api/v1/namespaces/default/pods/pod/exec?command=sh&command=-c&command=mkdir%20-p%20%27%2Fmock%2Fdir%27%20%26%26%20base64%20-d%20-%20%3E%20%27%2Fmock%2Fdir%2Ffile%27&container=container&stdin=true&stderr=true",
        captor.getAllValues().get(1).toString());
    verify(mockWebSocket, atLeast(1)).send(any(ByteBuffer.class));
  }

  private void uploadDirectoryAndVerify(PodUploadTester<Boolean> directoryUpload)
      throws IOException, InterruptedException {
    this.operation = operation.dir("/mock/dir");
    WebSocket.Builder builder = mock(WebSocket.Builder.class, Mockito.RETURNS_SELF);
    when(builder.buildAsync(any())).thenAnswer(newWebSocket -> {
      final ExecWebSocketListener wsl = newWebSocket.getArgument(0, ExecWebSocketListener.class);
      // Set ready status
      wsl.onOpen(mockWebSocket);
      wsl.onMessage(mockWebSocket, ByteBuffer.wrap(new byte[] { (byte) 0 }));
      // Set complete status
      Mockito.doAnswer(close -> {
        wsl.onClose(mockWebSocket, close.getArgument(0), close.getArgument(1));
        return null;
      }).when(mockWebSocket).sendClose(anyInt(), anyString());
      return CompletableFuture.completedFuture(mockWebSocket);
    });
    when(mockClient.newWebSocketBuilder()).thenReturn(builder);

    final boolean result = directoryUpload.apply();

    assertThat(result).isTrue();
    ArgumentCaptor<URI> captor = ArgumentCaptor.forClass(URI.class);
    verify(builder, times(2)).uri(captor.capture());
    assertEquals(
        "https://openshift.com:8443/api/v1/namespaces/default/pods?fieldSelector=metadata.name%3Dpod&allowWatchBookmarks=true&watch=true",
        captor.getAllValues().get(0).toString());
    assertEquals(
        "https://openshift.com:8443/api/v1/namespaces/default/pods/pod/exec?command=sh&command=-c&command=mkdir%20-p%20%27%2Fmock%2Fdir%27%20%26%26%20base64%20-d%20-%20%7C%20tar%20-C%20%27%2Fmock%2Fdir%27%20-xzf%20-&container=container&stdin=true&stderr=true",
        captor.getAllValues().get(1).toString());
    verify(mockWebSocket, atLeast(1)).send(any(ByteBuffer.class));
  }

}
