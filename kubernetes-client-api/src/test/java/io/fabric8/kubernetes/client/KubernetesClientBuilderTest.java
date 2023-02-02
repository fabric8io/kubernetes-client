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

package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpClient.Factory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KubernetesClientBuilderTest {

  @Test
  void testHttpClientConfiguration() {
    KubernetesClientBuilder builder = new KubernetesClientBuilder(null);
    Factory mockFactory = Mockito.mock(HttpClient.Factory.class);
    HttpClient.Builder mockBuilder = Mockito.mock(HttpClient.Builder.class);
    Mockito.when(mockFactory.newBuilder(Mockito.any())).thenReturn(mockBuilder);
    builder.withHttpClientFactory(mockFactory).withHttpClientBuilderConsumer(b -> b.proxyAuthorization("something"));
    builder.getHttpClient();
    Mockito.verify(mockBuilder).proxyAuthorization("something");
  }

  /**
   * This test is only to check null returned by Thread.currentThread().getContextClassLoader would be handled properly.
   * For this unit test, since io.fabric8.kubernetes.client.impl.KubernetesClientImpl is not loaded in the class path,
   * ClassNotFoundException will be thrown.
   */
  @Test
  void testNullContextClassLoader() {
    ClassLoader currContextClassLoader = Thread.currentThread().getContextClassLoader();
    try {
      Thread.currentThread().setContextClassLoader(null);
      Exception e = assertThrows(KubernetesClientException.class, KubernetesClientBuilder::new);
      Throwable t = e.getCause();
      assertEquals(ClassNotFoundException.class, t.getClass());
      assertEquals("io.fabric8.kubernetes.client.impl.KubernetesClientImpl", t.getMessage());
    } finally {
      Thread.currentThread().setContextClassLoader(currContextClassLoader);
    }
  }
}
