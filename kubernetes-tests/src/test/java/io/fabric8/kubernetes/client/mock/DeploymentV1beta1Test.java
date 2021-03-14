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

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollbackBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class DeploymentV1beta1Test {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testCreateOrReplace() {
    Deployment oldDeployment = new DeploymentBuilder()
      .withApiVersion("extensions/v1beta1")
      .withNewMetadata()
      .withName("test-deployment")
      .endMetadata()
      .build();

    Deployment newDeployment = new DeploymentBuilder()
      .withApiVersion("extensions/v1beta1")
      .withNewMetadata()
      .withName("test-deployment")
      .withAnnotations(Collections.singletonMap("newAnnotation", "test"))
      .endMetadata()
      .build();

    server.expect()
      .post()
      .withPath("/apis/extensions/v1beta1/namespaces/test/deployments")
      .andReturn(HttpURLConnection.HTTP_CONFLICT, oldDeployment)
      .once();

    server.expect()
      .get()
      .withPath("/apis/extensions/v1beta1/namespaces/test/deployments/test-deployment")
      .andReturn(HttpURLConnection.HTTP_OK, oldDeployment)
      .times(2);

    server.expect()
      .put()
      .withPath("/apis/extensions/v1beta1/namespaces/test/deployments/test-deployment")
      .andReturn(HttpURLConnection.HTTP_OK, newDeployment)
      .once();


    Deployment result = client.extensions().deployments().inNamespace("test").createOrReplace(newDeployment);
    assertNotNull(result);
    assertEquals(newDeployment, result);
  }

  @Test
  void testRollback() {
    DeploymentRollback deploymentRollback = new DeploymentRollbackBuilder()
      .withName("deployment1")
      .withNewRollbackTo().withRevision(1L).endRollbackTo()
      .withUpdatedAnnotations(Collections.singletonMap("foo", "bar"))
      .build();

    Status status = new StatusBuilder().build();
    server.expect()
      .post()
      .withPath("/apis/extensions/v1beta1/namespaces/test/deployments/deployment1/rollback")
      .andReturn(201, status).once();

    client.extensions().deployments().inNamespace("test").withName("deployment1").rollback(deploymentRollback);
  }

}
