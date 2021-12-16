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


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.ObjIntConsumer;

import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
  private PodOperationContext mockContext;
  private OperationSupport operationSupport;
  private Path mockPathToUpload;
  private WebSocket mockWebSocket;

  @BeforeEach
  void setUp() throws IOException {
    mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    mockContext = Mockito.mock(PodOperationContext.class, Mockito.RETURNS_DEEP_STUBS);
    operationSupport = Mockito.mock(OperationSupport.class, Mockito.RETURNS_DEEP_STUBS);
    mockPathToUpload = Mockito.mock(Path.class, Mockito.RETURNS_DEEP_STUBS);
    mockWebSocket = Mockito.mock(WebSocket.class, Mockito.RETURNS_DEEP_STUBS);

    when(mockClient.newBuilder().readTimeout(anyLong(), any(TimeUnit.class)).build()).thenReturn(mockClient);
    when(operationSupport.getResourceUrl())
      .thenReturn(new URL("https://openshift.com:8443/api/v1/namespaces/default/pods/mock-pod/"));
  }

  @AfterEach
  void tearDown() {
    mockClient = null;
    mockContext = null;
    operationSupport = null;
    mockPathToUpload = null;
  }

  @Test
  void testUploadInvalidParametersShouldThrowException() throws Exception {
    final IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
      () -> PodUpload.upload(mockClient, mockContext, operationSupport, mockPathToUpload));

    assertThat(result.getMessage(),
      equalTo("Provided arguments are not valid (file, directory, path)"));
  }

  @Test
  void testUploadFileHappyScenarioShouldUploadFile() throws Exception {
    when(mockContext.getFile()).thenReturn("/mock/dir/file");
    when(mockPathToUpload.toFile())
      .thenReturn(new File(PodUpload.class.getResource("/upload/upload-sample.txt").getFile()));
    WebSocket.Builder builder = Mockito.mock(WebSocket.Builder.class, Mockito.RETURNS_SELF);
    when(builder.buildAsync(any())).thenAnswer(newWebSocket -> {
      final PodUploadWebSocketListener wsl = newWebSocket.getArgument(0, PodUploadWebSocketListener.class);
      // Set ready status
      wsl.onOpen(mockWebSocket);
      wsl.onMessage(mockWebSocket, ByteBuffer.wrap(new byte[] {(byte) 0}));
      // Set complete status
      Mockito.doAnswer(close -> {
        wsl.onClose(mockWebSocket, close.getArgument(0), close.getArgument(1));
        return null;
      }).when(mockWebSocket).sendClose(anyInt(), anyString());
      return CompletableFuture.completedFuture(mockWebSocket);  
    });
    when(mockClient.newWebSocketBuilder()).thenReturn(builder);

    final boolean result = PodUpload.upload(mockClient, mockContext, operationSupport, mockPathToUpload);

    assertThat(result, equalTo(true));
    verify(mockPathToUpload, atLeast(1)).toFile();
    verify(builder, times(1)).uri(argThat(request -> {
      assertThat(request.toString(), equalTo("https://openshift.com:8443/api/v1/namespaces/default/pods/mock-pod/exec?command=sh&command=-c&command=mkdir+-p+%27%2Fmock%2Fdir%27+%26%26+base64+-d+-+%3E+%27%2Fmock%2Fdir%2Ffile%27&stdin=true&stderr=true"));
      return true;
    }));
    verify(mockWebSocket, atLeast(1)).send(any(ByteBuffer.class));
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
    when(mockContext.getDir()).thenReturn("/mock/dir");
    when(mockPathToUpload.toFile())
      .thenReturn(new File(PodUpload.class.getResource(resourcePath).getFile()));
    WebSocket.Builder builder = Mockito.mock(WebSocket.Builder.class, Mockito.RETURNS_SELF);
    when(builder.buildAsync(any())).thenAnswer(newWebSocket -> {
      final PodUploadWebSocketListener wsl = newWebSocket.getArgument(0, PodUploadWebSocketListener.class);
      // Set ready status
      wsl.onOpen(mockWebSocket);
      wsl.onMessage(mockWebSocket, ByteBuffer.wrap(new byte[] {(byte) 0}));
      // Set complete status
      Mockito.doAnswer(close -> {
        wsl.onClose(mockWebSocket, close.getArgument(0), close.getArgument(1));
        return null;
      }).when(mockWebSocket).sendClose(anyInt(), anyString());
      return CompletableFuture.completedFuture(mockWebSocket);  
    });
    when(mockClient.newWebSocketBuilder()).thenReturn(builder);

    final boolean result = PodUpload.upload(mockClient, mockContext, operationSupport, mockPathToUpload);

    assertThat(result, equalTo(true));
    verify(mockPathToUpload, atLeast(1)).toFile();
    verify(builder, times(1)).uri(argThat(request -> {
      assertThat(request.toString(), equalTo("https://openshift.com:8443/api/v1/namespaces/default/pods/mock-pod/exec?command=sh&command=-c&command=mkdir+-p+%27%2Fmock%2Fdir%27+%26%26+base64+-d+-+%7C+tar+-C+%27%2Fmock%2Fdir%27+-xzf+-&stdin=true&stderr=true"));
      return true;
    }));
    verify(mockWebSocket, atLeast(1)).send(any(ByteBuffer.class));
  }

  @Test
  void testCopy() throws Exception {
    final ByteArrayInputStream input = new ByteArrayInputStream("I'LL BE COPIED".getBytes(Charset.defaultCharset()));
    final ObjIntConsumer<byte[]> consumer = (bytes, length) -> {
      assertThat(length, equalTo(14));
      assertThat(new String(Arrays.copyOf(bytes, 14), Charset.defaultCharset()),
        equalTo("I'LL BE COPIED"));
    };

    PodUpload.copy(input, consumer);
  }

}
