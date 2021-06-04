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
package io.fabric8.kubernetes;

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class DeleteIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ClusterRoleIT.class.getResourceAsStream("/delete-it.yml"));
  }

  @Test
  public void testDeleteNonExistentResource() {
    // Given
    String podName = "i-dont-exist";

    // When
    Boolean isDeleted = client.pods().inNamespace(session.getNamespace()).withName(podName).delete();

    // Then
    assertFalse(isDeleted);
  }

  @Test
  public void testDeleteExistentResource() {
    // Given
    String name = "deleteit-existent";

    // When
    Boolean isDeleted = client.secrets().inNamespace(session.getNamespace()).withName(name).delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<Secret> deleteEntity = new DeleteEntity<>(Secret.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteWithGracePeriod() {
    // Given
    String name = "deleteit-existent-graceperiod";

    // When
    Boolean isDeleted = client.secrets().inNamespace(session.getNamespace()).withName(name).withGracePeriod(0).delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<Secret> deleteEntity = new DeleteEntity<>(Secret.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteWithCascadingEnabled() {
    // Given
    String name = "deleteit-existent-cascading";

    // When
    Boolean isDeleted = client.apps().replicaSets().inNamespace(session.getNamespace()).withName(name).cascading(true).delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<ReplicaSet> deleteEntity = new DeleteEntity<>(ReplicaSet.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteWithPropagationPolicyForeground() {
    // Given
    String name = "deleteit-existent-foreground";

    // When
    Boolean isDeleted = client.apps().replicaSets().inNamespace(session.getNamespace()).withName(name)
      .withPropagationPolicy(DeletionPropagation.FOREGROUND)
      .delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<ReplicaSet> deleteEntity = new DeleteEntity<>(ReplicaSet.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteWithPropagationPolicyBackground() {
    // Given
    String name = "deleteit-existent-background";

    // When
    Boolean isDeleted = client.apps().replicaSets().inNamespace(session.getNamespace()).withName(name)
      .withPropagationPolicy(DeletionPropagation.BACKGROUND)
      .delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<ReplicaSet> deleteEntity = new DeleteEntity<>(ReplicaSet.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteWithPropagationPolicyOrphan() {
    // Given
    String name = "deleteit-existent-orphan";

    // When
    Boolean isDeleted = client.apps().deployments().inNamespace(session.getNamespace()).withName(name)
      .withPropagationPolicy(DeletionPropagation.ORPHAN)
      .delete();

    // Then
    ReplicaSetList replicaSetList = client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("test", name).list();
    assertTrue(isDeleted);
    assertNotNull(replicaSetList);
    assertEquals(1, replicaSetList.getItems().size());
    assertTrue(client.resource(replicaSetList.getItems().get(0)).inNamespace(session.getNamespace()).delete());
  }

  @Test
  public void testDeleteResource() {
    // Given
    String name = "deleteit-resource";

    // When
    ReplicaSet replicaSet = client.apps().replicaSets().inNamespace(session.getNamespace()).withName(name).get();
    Boolean isDeleted = client.resource(replicaSet).inNamespace(session.getNamespace()).delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<ReplicaSet> deleteEntity = new DeleteEntity<>(ReplicaSet.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteResourceCascading() {
    // Given
    String name = "deleteit-resource-cascading";

    // When
    ReplicaSet replicaSet = client.apps().replicaSets().inNamespace(session.getNamespace()).withName(name).get();
    Boolean isDeleted = client.resource(replicaSet).inNamespace(session.getNamespace()).cascading(true).delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<ReplicaSet> deleteEntity = new DeleteEntity<>(ReplicaSet.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteResourcePropagationPolicyBackground() {
    // Given
    String name = "deleteit-resource-background";

    // When
    ReplicaSet replicaSet = client.apps().replicaSets().inNamespace(session.getNamespace()).withName(name).get();
    Boolean isDeleted = client.resource(replicaSet).inNamespace(session.getNamespace())
      .withPropagationPolicy(DeletionPropagation.BACKGROUND)
      .delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<ReplicaSet> deleteEntity = new DeleteEntity<>(ReplicaSet.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteResourcePropagationPolicyForeground() {
    // Given
    String name = "deleteit-resource-foreground";

    // When
    ReplicaSet replicaSet = client.apps().replicaSets().inNamespace(session.getNamespace()).withName(name).get();
    Boolean isDeleted = client.resource(replicaSet).inNamespace(session.getNamespace())
      .withPropagationPolicy(DeletionPropagation.FOREGROUND)
      .delete();

    // Then
    assertTrue(isDeleted);
    DeleteEntity<ReplicaSet> deleteEntity = new DeleteEntity<>(ReplicaSet.class, client, name, session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @Test
  public void testDeleteResourcePropagationPolicyOrphan() {
    // Given
    String name = "deleteit-resource-orphan";

    // When
    Deployment deploy = client.apps().deployments().inNamespace(session.getNamespace()).withName(name).get();
    Boolean isDeleted = client.resource(deploy).inNamespace(session.getNamespace())
      .withPropagationPolicy(DeletionPropagation.ORPHAN)
      .delete();

    // Then
    ReplicaSetList replicaSetList = client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("test", name).list();
    assertTrue(isDeleted);
    assertNotNull(replicaSetList);
    assertEquals(1, replicaSetList.getItems().size());
    assertTrue(client.resource(replicaSetList.getItems().get(0)).inNamespace(session.getNamespace()).delete());
  }
}
