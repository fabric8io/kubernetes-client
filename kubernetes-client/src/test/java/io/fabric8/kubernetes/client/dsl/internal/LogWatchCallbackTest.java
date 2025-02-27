/*
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

package io.fabric8.kubernetes.client.dsl.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.TestAsyncBody;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.impl.BaseClient;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;

public class LogWatchCallbackTest {
  private OperationContext context;
  private Executor executor = Executors.newFixedThreadPool(2);
  private URL url;
  private HttpClient httpClientMock;

  @BeforeEach
  public void setUp() throws MalformedURLException {
    BaseClient mock = mock(BaseClient.class, Mockito.RETURNS_SELF);
    Mockito.when(mock.adapt(BaseClient.class).getKubernetesSerialization()).thenReturn(new KubernetesSerialization());
    final OperationContext context = new OperationContext().withClient(mock);
    when(mock.getExecutor()).thenReturn(this.executor);
    this.context = context;

    this.url = new URL("http://url_called");
    this.httpClientMock = spy(HttpClient.class);
    var httpRequestMock = mock(HttpRequest.class);
    var builderMock = mock(HttpRequest.Builder.class);

    Mockito.when(httpClientMock.newHttpRequestBuilder()).thenReturn(builderMock);
    Mockito.when(builderMock.url(url)).thenReturn(builderMock);
    Mockito.when(builderMock.build()).thenReturn(httpRequestMock);

  }

  @Test
  public void withOutputStreamCloseEventTest() throws InterruptedException {

    var future = new CompletableFuture<HttpResponse<AsyncBody>>();
    var reached = new CountDownLatch(1);

    Mockito.when(httpClientMock.consumeBytes(Mockito.any(), Mockito.any())).thenReturn(future);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    LogWatchCallback logWatch = new LogWatchCallback(baos, this.context);
    logWatch.callAndWait(httpClientMock, url);

    logWatch.onClose().thenAccept((Throwable t) -> {
      reached.countDown();
    });
    future.complete(
        new TestHttpResponse<AsyncBody>().withCode(HttpURLConnection.HTTP_GONE).withBody(new TestAsyncBody()));

    assertThat(reached.await(1, TimeUnit.SECONDS)).isTrue();
    logWatch.close();
  }

  @Test
  public void withOutputStreamCloseEventOnFailureTest() throws MalformedURLException, InterruptedException {

    var future = new CompletableFuture<HttpResponse<AsyncBody>>();
    var reached = new CountDownLatch(1);

    Mockito.when(httpClientMock.consumeBytes(Mockito.any(), Mockito.any())).thenReturn(future);

    LogWatchCallback logWatch = new LogWatchCallback(new ByteArrayOutputStream(), this.context);
    logWatch.callAndWait(httpClientMock, url);

    final Throwable tReturned[] = new Throwable[1];
    logWatch.onClose().thenAccept((Throwable t) -> {
      tReturned[0] = t;
      reached.countDown();
    });
   
    var th = new Throwable("any exception");
    future.completeExceptionally(th);

    assertThat(reached.await(1, TimeUnit.SECONDS)).isTrue();
    assertThat(tReturned[0]).isEqualTo(th);

    logWatch.close();
  }
}
