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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.ImpersonatorInterceptor;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableKubernetesMockClient
class RequestConfigTest {

  KubernetesMockServer server;
  NamespacedKubernetesClient client;

  @Test
  void testImpersonate() throws InterruptedException {
    server.expect()
        .withPath("/api/v1/namespaces/test/pods/pod1")
        .andReturn(200, new PodBuilder()
            .withNewMetadata()
            .withName("testPod")
            .endMetadata()
            .build())
        .always();

    server.expect()
        .withPath("/api/v1/namespaces/test/pods/pod2")
        .andReturn(200, new PodBuilder()
            .withNewMetadata()
            .withName("testPod")
            .endMetadata()
            .build())
        .always();

    client.withRequestConfig(new RequestConfigBuilder().withImpersonateUsername("imposter").build())
        .call(c -> c.pods().inNamespace("test").withName("pod1").get());

    //Let's check that request config actually works
    RecordedRequest request1 = server.takeRequest();
    String impersonate = request1.getHeader(ImpersonatorInterceptor.IMPERSONATE_USER);
    assertEquals("imposter", impersonate);

    //Let's also check that we didn't pollute client config.
    client.pods().inNamespace("test").withName("pod2").get();
    RecordedRequest request2 = server.takeRequest();
    String impersonate2 = request2.getHeader(ImpersonatorInterceptor.IMPERSONATE_USER);
    assertNull(impersonate2);
  }

}
