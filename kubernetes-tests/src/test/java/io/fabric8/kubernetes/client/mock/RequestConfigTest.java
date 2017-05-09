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

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestConfigTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() throws InterruptedException {
   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder()
     .withNewMetadata()
        .withName("testPod")
     .endMetadata()
     .build()).always();

    server.expect().withPath("/api/v1/namespaces/test/pods/pod2").andReturn(200, new PodBuilder()
      .withNewMetadata()
      .withName("testPod")
      .endMetadata()
      .build()).always();

    NamespacedKubernetesClient client = server.getClient();

    Pod pod1 = client.withRequestConfig(new RequestConfigBuilder().withOauthToken("TOKEN").build()).call(new Function<NamespacedKubernetesClient, Pod>() {
      @Override
      public Pod apply(NamespacedKubernetesClient c) {
        return c.pods().inNamespace("test").withName("pod1").get();
      }
    });

    //Let's check that request config actually works
    RecordedRequest request1 = server.getMockServer().takeRequest();
    String authHeader1 = request1.getHeader("Authorization");
    Assert.assertEquals("Bearer TOKEN", authHeader1);

    //Let's also check that we didn't pollute client config.
    Pod pod2 = client.pods().inNamespace("test").withName("pod2").get();
    RecordedRequest request2 = server.getMockServer().takeRequest();
    String authHeader2 = request2.getHeader("Authorization");
    Assert.assertNotEquals("Bearer TOKEN", authHeader2);
  }

}
