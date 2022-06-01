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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.internal.ExecWebSocketListener;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.InputStreamPumper.Writable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PodUploadTest {

  private HttpClient mockClient;
  private Path mockPathToUpload;
  private WebSocket mockWebSocket;
  private PodOperationsImpl operation;

  @FunctionalInterface
  public interface PodUploadTester<R> {
    R apply() throws IOException, InterruptedException;
  }

  @BeforeEach
  void setUp() throws IOException {
    mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    mockPathToUpload = Mockito.mock(Path.class, Mockito.RETURNS_DEEP_STUBS);
    mockWebSocket = Mockito.mock(WebSocket.class, Mockito.RETURNS_DEEP_STUBS);
    Mockito.when(mockWebSocket.send(Mockito.any())).thenReturn(true);

    when(mockClient.newBuilder().readTimeout(anyLong(), any(TimeUnit.class)).build()).thenReturn(mockClient);

    BaseClient client = Mockito.mock(BaseClient.class, Mockito.RETURNS_SELF);
    Mockito.when(client.adapt(BaseClient.class).getExecutor()).thenReturn(CommonThreadPool.get());
    Config config = Mockito.mock(Config.class, Mockito.RETURNS_DEEP_STUBS);
    when(config.getMasterUrl()).thenReturn("https://openshift.com:8443");
    when(config.getNamespace()).thenReturn("default");
    when(client.getConfiguration()).thenReturn(config);
    when(client.getHttpClient()).thenReturn(mockClient);
    this.operation = new PodOperationsImpl(new PodOperationContext(), new OperationContext().withClient(client));
  }

  @Test
  void testUploadInvalidParametersShouldThrowException() {
    final IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
        () -> PodUpload.upload(operation, mockPathToUpload));

    assertThat(result.getMessage(),
        equalTo("Provided arguments are not valid (file, directory, path)"));
  }

  @Test
  void upload_whenFilePathProvided_shouldUploadFile() throws IOException, InterruptedException {
    when(mockPathToUpload.toFile())
        .thenReturn(new File(PodUpload.class.getResource("/upload/upload-sample.txt").getFile()));
    uploadFileAndVerify(() -> PodUpload.upload(operation, mockPathToUpload));
    verify(mockPathToUpload, atLeast(1)).toFile();
  }

  @Test
  void uploadFileData_whenByteArrayInputStreamProvided_shouldUploadFile() throws IOException, InterruptedException {
    InputStream inputStream = new ByteArrayInputStream("test data".getBytes());
    uploadFileAndVerify(() -> PodUpload.uploadFileData(operation, inputStream));
  }

  @Test
  void testUploadDirectoryHappyScenarioShouldUploadDirectory() throws Exception {
    uploadDirectoryAndVerify("/upload");
  }

  @Test
  void testUploadDirectoryLongFileNameShouldUploadDirectory() throws Exception {
    uploadDirectoryAndVerify("/upload_long");
  }

  private void uploadDirectoryAndVerify(String resourcePath) throws IOException, InterruptedException {
    this.operation = operation.dir("/mock/dir");
    when(mockPathToUpload.toFile())
        .thenReturn(new File(PodUpload.class.getResource(resourcePath).getFile()));
    WebSocket.Builder builder = Mockito.mock(WebSocket.Builder.class, Mockito.RETURNS_SELF);
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

    final boolean result = PodUpload.upload(operation, mockPathToUpload);

    assertThat(result, equalTo(true));
    verify(mockPathToUpload, atLeast(1)).toFile();
    verify(builder, times(1)).uri(argThat(request -> {
      assertThat(request.toString(), equalTo(
          "https://openshift.com:8443/api/v1/namespaces/default/pods/exec?command=sh&command=-c&command=mkdir%20-p%20%27%2Fmock%2Fdir%27%20%26%26%20base64%20-d%20-%20%7C%20tar%20-C%20%27%2Fmock%2Fdir%27%20-xzf%20-&stdin=true&stderr=true"));
      return true;
    }));
    verify(mockWebSocket, atLeast(1)).send(any(ByteBuffer.class));
  }

  @Test
  void testCopy() throws Exception {
    final ByteArrayInputStream input = new ByteArrayInputStream("I'LL BE COPIED".getBytes(Charset.defaultCharset()));
    final Writable consumer = (bytes, offset, length) -> {
      assertThat(length, equalTo(14));
      assertThat(new String(Arrays.copyOf(bytes, 14), Charset.defaultCharset()),
          equalTo("I'LL BE COPIED"));
    };

    InputStreamPumper.transferTo(input, consumer);
  }

  @Test
  void createExecCommandForUpload_withFileInRootPath_shouldCreateValidExecCommandForUpload() {
    // When
    String result = PodUpload.createExecCommandForUpload("/cp.log");

    // Then
    assertThat(result, equalTo("mkdir -p '/' && base64 -d - > '/cp.log'"));
  }

  @Test
  void createExecCommandForUpload_withNormalFile_shouldCreateValidExecCommandForUpload() {
    // When
    String result = PodUpload.createExecCommandForUpload("/tmp/foo/cp.log");

    // Then
    assertThat(result, equalTo("mkdir -p '/tmp/foo' && base64 -d - > '/tmp/foo/cp.log'"));
  }

  void uploadFileAndVerify(PodUploadTester<Boolean> fileUploadMethodToTest) throws IOException, InterruptedException {
    this.operation = operation.file("/mock/dir/file");
    WebSocket.Builder builder = Mockito.mock(WebSocket.Builder.class, Mockito.RETURNS_SELF);
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

    assertThat(result, equalTo(true));
    verify(builder, times(1)).uri(argThat(request -> {
      assertThat(request.toString(), equalTo(
          "https://openshift.com:8443/api/v1/namespaces/default/pods/exec?command=sh&command=-c&command=mkdir%20-p%20%27%2Fmock%2Fdir%27%20%26%26%20base64%20-d%20-%20%3E%20%27%2Fmock%2Fdir%2Ffile%27&stdin=true&stderr=true"));
      return true;
    }));
    verify(mockWebSocket, atLeast(1)).send(any(ByteBuffer.class));
  }

}
