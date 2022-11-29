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

import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class ReplicaSetV1beta1Test {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testCreateOrReplace() {
    ReplicaSet oldReplicaSet = new ReplicaSetBuilder()
        .withApiVersion("extensions/v1beta1")
        .withNewMetadata()
        .withName("test-replicaset")
        .endMetadata()
        .build();

    ReplicaSet newReplicaSet = new ReplicaSetBuilder()
        .withApiVersion("extensions/v1beta1")
        .withNewMetadata()
        .withName("test-deployment")
        .withAnnotations(Collections.singletonMap("newAnnotation", "test"))
        .endMetadata()
        .build();

    server.expect()
        .post()
        .withPath("/apis/extensions/v1beta1/namespaces/test/replicasets")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, oldReplicaSet)
        .once();

    server.expect()
        .get()
        .withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/test-deployment")
        .andReturn(HttpURLConnection.HTTP_OK, oldReplicaSet)
        .times(2);

    server.expect()
        .put()
        .withPath("/apis/extensions/v1beta1/namespaces/test/replicasets/test-deployment")
        .andReturn(HttpURLConnection.HTTP_OK, newReplicaSet)
        .once();

    ReplicaSet result = client.extensions().replicaSets().inNamespace("test").createOrReplace(newReplicaSet);
    assertNotNull(result);
    assertEquals(newReplicaSet, result);
  }

}
