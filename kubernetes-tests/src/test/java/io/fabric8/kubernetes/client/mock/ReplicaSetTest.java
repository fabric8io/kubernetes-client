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

import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ReplicaSetTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets").andReturn(200, new ReplicaSetListBuilder().build()).once();
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/replicasets").andReturn(200,  new ReplicaSetListBuilder()
      .addNewItem().and()
      .addNewItem().and().build())
      .once();

    KubernetesClient client = server.getClient();
    ReplicaSetList replicaSetList = client.extensions().replicaSets().list();
    assertNotNull(replicaSetList);
    assertEquals(0, replicaSetList.getItems().size());

    replicaSetList = client.extensions().replicaSets().inNamespace("ns1").list();
    assertNotNull(replicaSetList);
    assertEquals(2, replicaSetList.getItems().size());
  }


  @Test
  public void testGet() {
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder().build()).once();
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/replicasets/repl2").andReturn(200, new ReplicaSetBuilder().build()).once();

    KubernetesClient client = server.getClient();

    ReplicaSet repl1 = client.extensions().replicaSets().withName("repl1").get();
    assertNotNull(repl1);

    repl1 = client.extensions().replicaSets().withName("repl2").get();
    assertNull(repl1);

    repl1 = client.extensions().replicaSets().inNamespace("ns1").withName("repl2").get();
    assertNotNull(repl1);
  }


  @Test
  public void testDelete() {
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder() .withNewMetadata()
      .withName("repl1")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .endStatus()
      .build()).once();

   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder() .withNewMetadata()
      .withName("repl1")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(0)
      .endStatus()
      .build()).times(5);

   server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/replicasets/repl2").andReturn(200, new ReplicaSetBuilder() .withNewMetadata()
      .withName("repl2")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(1)
      .endStatus()
      .build()).once();

   server.expect().withPath("/apis/extensions/v1beta1/namespaces/ns1/replicasets/repl2").andReturn(200, new ReplicaSetBuilder() .withNewMetadata()
      .withName("repl2")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(0)
      .endSpec()
      .withNewStatus()
      .withReplicas(0)
      .endStatus()
      .build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().replicaSets().withName("repl1").delete();
    assertNotNull(deleted);

    deleted = client.extensions().replicaSets().withName("repl2").delete();
    assertFalse(deleted);

    deleted = client.extensions().replicaSets().inNamespace("ns1").withName("repl2").delete();
    assertTrue(deleted);
  }

  @Test
  public void testScale() {
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder()
      .withNewMetadata()
      .withName("repl1")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(5)
      .endSpec()
      .withNewStatus()
        .withReplicas(1)
      .endStatus()
      .build()).always();

    KubernetesClient client = server.getClient();
    ReplicaSet repl = client.extensions().replicaSets().withName("repl1").scale(5);
    assertNotNull(repl);
    assertNotNull(repl.getSpec());
    assertEquals(5, repl.getSpec().getReplicas().intValue());
    assertEquals(1, repl.getStatus().getReplicas().intValue());
  }

  @Test
  public void testScaleAndWait() {
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder()
      .withNewMetadata()
      .withName("repl1")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withReplicas(5)
      .endSpec()
      .withNewStatus()
        .withReplicas(1)
      .endStatus()
      .build()).once();

    server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder()
        .withNewMetadata()
        .withName("repl1")
        .withResourceVersion("1")
        .endMetadata()
        .withNewSpec()
        .withReplicas(5)
        .endSpec()
        .withNewStatus()
        .withReplicas(5)
        .endStatus()
        .build()).always();

    KubernetesClient client = server.getClient();
    ReplicaSet repl = client.extensions().replicaSets().withName("repl1").scale(5, true);
    assertNotNull(repl);
    assertNotNull(repl.getSpec());
    assertEquals(5, repl.getSpec().getReplicas().intValue());
    assertEquals(5, repl.getStatus().getReplicas().intValue());
  }

  @Ignore
  @Test
  public void testUpdate() {
    ReplicaSet repl1 = new ReplicaSetBuilder()
      .withNewMetadata()
      .withName("repl1")
      .withNamespace("test")
      .endMetadata()
      .withNewSpec()
        .withReplicas(1)
        .withNewTemplate()
          .withNewMetadata().withLabels(new HashMap<String, String>()).endMetadata()
          .withNewSpec()
            .addNewContainer()
              .withImage("img1")
            .endContainer()
          .endSpec()
        .endTemplate()
      .endSpec()
      .withNewStatus().withReplicas(1).endStatus()
      .build();

   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, repl1).once();
   server.expect().put().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/repl1").andReturn(200, repl1).once();
   server.expect().get().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets").andReturn(200, new ReplicaSetListBuilder().withItems(repl1).build()).once();
   server.expect().post().withPath("/apis/extensions/v1beta1/namespaces/test/replicasets").andReturn(201, repl1).once();
   server.expect().withPath("/apis/extensions/v1beta1/namespaces/test/pods").andReturn(200, new KubernetesListBuilder().build()).once();
    KubernetesClient client = server.getClient();

    repl1 = client.extensions().replicaSets().withName("repl1")
      .rolling()
      .withTimeout(5, TimeUnit.MINUTES)
      .updateImage("");
    assertNotNull(repl1);
  }

}
