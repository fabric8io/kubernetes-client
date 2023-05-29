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

package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WatchHttpManagerTest {

  @Test
  void testReconnectOnException() throws MalformedURLException, InterruptedException {
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    setupHttpWatch(future, reconnect);

    future.completeExceptionally(new IOException());
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testReconnectOnFailedResponse() throws MalformedURLException, InterruptedException {
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    setupHttpWatch(future, reconnect);

    AsyncBody mockBody = Mockito.mock(AsyncBody.class);
    future.complete(new TestHttpResponse<AsyncBody>().withCode(429).withBody(mockBody));
    Mockito.verify(mockBody).cancel();
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testNoReconnectOnHttpGone() throws MalformedURLException, InterruptedException {
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    setupHttpWatch(future, reconnect);

    AsyncBody mockBody = Mockito.mock(AsyncBody.class);
    future.complete(new TestHttpResponse<AsyncBody>().withCode(HttpURLConnection.HTTP_GONE).withBody(mockBody));
    Mockito.verify(mockBody).cancel();
    assertFalse(reconnect.await(1, TimeUnit.SECONDS));
  }

  private void setupHttpWatch(CompletableFuture<HttpResponse<AsyncBody>> future, CountDownLatch reconnect)
      throws MalformedURLException {
    HttpClient client = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    BaseOperation baseOperation = AbstractWatchManagerTest.mockOperation();
    Mockito.when(baseOperation.getNamespacedUrl()).thenReturn(new URL("http://localhost"));
    Mockito.when(client.consumeBytes(Mockito.any(), Mockito.any())).thenReturn(future);

    WatchHTTPManager<HasMetadata, KubernetesResourceList<HasMetadata>> watch = new WatchHTTPManager(client,
        baseOperation, Mockito.mock(ListOptions.class), Mockito.mock(Watcher.class), 1, 0) {

      @Override
      void scheduleReconnect(WatchRequestState state) {
        reconnect.countDown();
      }
    };
  }

}
