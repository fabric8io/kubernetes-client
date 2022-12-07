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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/delete-it.yml")
class DeleteIT {

  KubernetesClient client;

  @Test
  void testDeleteNonExistentResource() {
    // Given
    String podName = "i-dont-exist";
    // When
    boolean isDeleted = client.pods().withName(podName).delete().size() == 1;
    // Then
    assertFalse(isDeleted);
  }

  @Test
  void testDeleteNonExistentResourceBlocking() {
    // Given
    String podName = "i-dont-exist";
    // When
    long start = System.currentTimeMillis();
    client.pods().withName(podName).withTimeout(10, TimeUnit.MINUTES).delete();
    // Then it shouldn't block
    assertTrue(System.currentTimeMillis() - start < TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES));
  }

  @Test
  void testBlockingDeleteExistentResource() throws Exception {
    // Given
    String name = "deleteit-existent";
    // When
    Resource<Secret> op = client.secrets().withName(name);
    CompletableFuture<List<StatusDetails>> future;
    try {
      op.edit(s -> {
        s.addFinalizer("fabric8.com/blocking");
        return s;
      });
      future = CompletableFuture.supplyAsync(() -> op.withTimeout(60, TimeUnit.SECONDS).delete(), CommonThreadPool.get());

      try {
        future.get(10, TimeUnit.SECONDS);
      } catch (TimeoutException e) {
        // expected - we're waiting for the finalizer
      }
      assertNotNull(op.get().getMetadata().getDeletionTimestamp());
    } finally {
      op.edit(s -> {
        s.getMetadata().setFinalizers(null);
        return s;
      });
    }

    assertEquals(1, future.get(60, TimeUnit.SECONDS).size());
  }

  @Test
  void testDeleteWithGracePeriod() {
    // Given
    String name = "deleteit-existent-graceperiod";
    // When
    boolean isDeleted = client.secrets().withName(name)
        .withGracePeriod(0).delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.secrets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteWithCascadingEnabled() {
    // Given
    String name = "deleteit-existent-cascading";
    // When
    boolean isDeleted = client.apps().replicaSets().withName(name).cascading(true).delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.apps().replicaSets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteWithPropagationPolicyForeground() {
    // Given
    String name = "deleteit-existent-foreground";
    // When
    boolean isDeleted = client.apps().replicaSets().withName(name)
        .withPropagationPolicy(DeletionPropagation.FOREGROUND)
        .delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.apps().replicaSets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteWithPropagationPolicyBackground() {
    // Given
    String name = "deleteit-existent-background";
    // When
    boolean isDeleted = client.apps().replicaSets().withName(name)
        .withPropagationPolicy(DeletionPropagation.BACKGROUND)
        .delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.apps().replicaSets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteWithPropagationPolicyOrphan() {
    // Given
    String name = "deleteit-existent-orphan";
    // When
    boolean isDeleted = client.apps().deployments().withName(name)
        .withPropagationPolicy(DeletionPropagation.ORPHAN)
        .delete().size() == 1;
    // Then
    ReplicaSetList replicaSetList = client.apps().replicaSets().withLabel("test", name).list();
    assertTrue(isDeleted);
    assertNotNull(replicaSetList);
    assertEquals(1, replicaSetList.getItems().size());
    assertTrue(client.resource(replicaSetList.getItems().get(0)).delete().size() == 1);
  }

  @Test
  void testDeleteResource() {
    // Given
    String name = "deleteit-resource";
    // When
    ReplicaSet replicaSet = client.apps().replicaSets().withName(name).get();
    boolean isDeleted = client.resource(replicaSet).delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.apps().replicaSets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteResourceCascading() {
    // Given
    String name = "deleteit-resource-cascading";
    // When
    ReplicaSet replicaSet = client.apps().replicaSets().withName(name).get();
    boolean isDeleted = client.resource(replicaSet).cascading(true).delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.apps().replicaSets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteResourcePropagationPolicyBackground() {
    // Given
    String name = "deleteit-resource-background";
    // When
    ReplicaSet replicaSet = client.apps().replicaSets().withName(name).get();
    boolean isDeleted = client.resource(replicaSet)
        .withPropagationPolicy(DeletionPropagation.BACKGROUND)
        .delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.apps().replicaSets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteResourcePropagationPolicyForeground() {
    // Given
    String name = "deleteit-resource-foreground";
    // When
    ReplicaSet replicaSet = client.apps().replicaSets().withName(name).get();
    boolean isDeleted = client.resource(replicaSet)
        .withPropagationPolicy(DeletionPropagation.FOREGROUND)
        .delete().size() == 1;
    // Then
    assertTrue(isDeleted);
    client.apps().replicaSets().withName(name).waitUntilCondition(Objects::isNull, 60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteResourcePropagationPolicyOrphan() {
    // Given
    String name = "deleteit-resource-orphan";
    // When
    Deployment deploy = client.apps().deployments().withName(name).get();
    boolean isDeleted = client.resource(deploy)
        .withPropagationPolicy(DeletionPropagation.ORPHAN)
        .delete().size() == 1;
    // Then
    ReplicaSetList replicaSetList = client.apps().replicaSets().withLabel("test", name).list();
    assertTrue(isDeleted);
    assertNotNull(replicaSetList);
    assertEquals(1, replicaSetList.getItems().size());
    assertTrue(client.resource(replicaSetList.getItems().get(0)).delete().size() == 1);
  }
}
