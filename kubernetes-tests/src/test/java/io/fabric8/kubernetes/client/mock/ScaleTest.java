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

import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.autoscaling.v1.ScaleBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class ScaleTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testScale() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1/scale")
        .andReturn(200,
            new ScaleBuilder().withNewSpec().withReplicas(5).endSpec().withNewStatus().withReplicas(1).endStatus().build())
        .always();
    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1").andReturn(200, new ReplicaSetBuilder()
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

    ReplicaSet repl = client.apps().replicaSets().withName("repl1").scale(5);
    assertNotNull(repl);
    assertNotNull(repl.getSpec());
    assertEquals(5, repl.getSpec().getReplicas().intValue());
    assertEquals(1, repl.getStatus().getReplicas().intValue());
  }

  @Test
  void testScaleAndWait() {
    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1/scale")
        .andReturn(200,
            new ScaleBuilder().withNewSpec().withReplicas(1).endSpec().withNewStatus().withReplicas(1).endStatus().build())
        .once();

    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1/scale")
        .andReturn(200,
            new ScaleBuilder().withNewSpec().withReplicas(5).endSpec().withNewStatus().withReplicas(1).endStatus().build())
        .once();

    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1/scale")
        .andReturn(200,
            new ScaleBuilder().withNewSpec().withReplicas(5).endSpec().withNewStatus().withReplicas(5).endStatus().build())
        .once();

    ReplicaSet scaled = new ReplicaSetBuilder()
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
        .build();

    server.expect().withPath("/apis/apps/v1/namespaces/test/replicasets/repl1").andReturn(200, scaled).once();

    ReplicaSet repl = client.apps().replicaSets().withName("repl1").scale(5, true);
    assertNotNull(repl);
    assertNotNull(repl.getSpec());
    assertEquals(5, repl.getSpec().getReplicas().intValue());
    assertEquals(5, repl.getStatus().getReplicas().intValue());
  }

}
