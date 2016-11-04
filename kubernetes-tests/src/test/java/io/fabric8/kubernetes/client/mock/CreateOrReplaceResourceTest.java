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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateOrReplaceResourceTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testReplace() throws Exception {
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(200, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).always();

    server.expect().put().withPath("/api/v1/namespaces/test/pods/pod123").andReturn(200, new PodBuilder()
      .withNewMetadata().withResourceVersion("12345").and().build()).once();

    KubernetesClient client = server.getClient();
    assertNotNull(client.resource(new PodBuilder().withNewMetadata().withName("pod123").and().withNewSpec().and().build()).createOrReplace());

    server.getMockServer().takeRequest();
    server.getMockServer().takeRequest();
    RecordedRequest request = server.getMockServer().takeRequest();
    Pod requestPod = new ObjectMapper().readerFor(Pod.class).readValue(request.getBody().inputStream());
    assertEquals("12345", requestPod.getMetadata().getResourceVersion());
  }
}
