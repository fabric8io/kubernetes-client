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
import io.fabric8.kubernetes.client.http.HttpClient.DerivedClientBuilder;
import io.fabric8.kubernetes.client.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WatchHttpManagerTest {

  @Test
  void testReconnectOnException() throws MalformedURLException, InterruptedException {
    HttpClient client = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    DerivedClientBuilder builder = Mockito.mock(HttpClient.DerivedClientBuilder.class, Mockito.RETURNS_SELF);
    Mockito.when(client.newBuilder()).thenReturn(builder);
    Mockito.when(builder.build()).thenReturn(client);
    BaseOperation baseOperation = Mockito.mock(BaseOperation.class);
    Mockito.when(baseOperation.getNamespacedUrl()).thenReturn(new URL("http://localhost"));
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    Mockito.when(client.consumeBytes(Mockito.any(), Mockito.any())).thenReturn(future);

    CountDownLatch reconnect = new CountDownLatch(1);
    WatchHTTPManager<HasMetadata, KubernetesResourceList<HasMetadata>> watch = new WatchHTTPManager(client,
        baseOperation, Mockito.mock(ListOptions.class), Mockito.mock(Watcher.class), 1, 0) {
      @Override
      void scheduleReconnect() {
        reconnect.countDown();
      }
    };

    future.completeExceptionally(new IOException());
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

}
