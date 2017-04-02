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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.server.mock.OutputStreamMessage;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ResourceListTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();


    @Test
    public void testCreateOrReplace() {
        Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

        server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(404, "").once();
        server.expect().post().withPath("/api/v1/namespaces/test/pods").andReturn(201, pod1).once();

        KubernetesClient client = server.getClient();
        List<HasMetadata> response = client.resourceList(new PodListBuilder().addToItems(pod1).build()).createOrReplace();
        assertTrue(response.contains(pod1));
    }

    @Test
    public void testCreateWithExplicitNamespace() {
        Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

        server.expect().get().withPath("/api/v1/namespaces/ns1/pods/pod1").andReturn(404, "").once();
        server.expect().post().withPath("/api/v1/namespaces/ns1/pods").andReturn(201, pod1).once();

        KubernetesClient client = server.getClient();
        List<HasMetadata> response = client.resourceList(new PodListBuilder().addToItems(pod1).build()).inNamespace("ns1").apply();
        assertTrue(response.contains(pod1));
    }

  @Test
  public void testDelete() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();


    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).times(2);
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).times(2);
    server.expect().withPath("/api/v1/namespaces/any/pods/pod3").andReturn(200, pod3).times(1);

    KubernetesClient client = server.getClient();

    //First time all items should be deleted.
    Boolean deleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).delete();
    assertTrue(deleted);

    //Now we expect pod3 to fail.
    deleted = client.resourceList(new PodListBuilder().withItems(pod1, pod2, pod3).build()).delete();
    assertFalse(deleted);
  }

}
