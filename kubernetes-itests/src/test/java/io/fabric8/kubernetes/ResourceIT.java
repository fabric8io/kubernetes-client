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
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentSpecBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/resource-it.yml")
class ResourceIT {

  KubernetesClient client;

  @Test
  void get() {
    assertNotNull(client.pods().withName("resource-pod-get").get());
  }

  @Test
  void list() {
    Pod listPod1 = new PodBuilder()
        .withNewMetadata().withName("resource-pod-list-pod3").endMetadata()
        .withNewSpec()
        .addNewContainer().withName("nginx").withImage("nginx").endContainer()
        .endSpec()
        .build();
    client.resourceList(new PodListBuilder().withItems(listPod1).build())
        .create();

    assertNotNull(client.pods().withName("resource-pod-list-pod3"));

    boolean bDeleted = client
        .resourceList(new PodListBuilder().withItems(listPod1).build())
        .withGracePeriod(0L)
        .delete().size() == 1;
    assertTrue(bDeleted);
  }

  @Test
  void createOrReplace() {
    Service service = new ServiceBuilder()
        .withNewMetadata().withName("my-service").endMetadata()
        .withNewSpec()
        .addToSelector("app", "Myapp")
        .addNewPort().withProtocol("TCP").withPort(80).withTargetPort(new IntOrString(9376)).endPort()
        .endSpec()
        .build();

    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withName("my-configmap").endMetadata()
        .addToData(Collections.singletonMap("app", "Myapp"))
        .build();

    KubernetesList list = new KubernetesListBuilder().withItems(service, configMap).build();

    // Create them for the first time
    client.resourceList(list).createOrReplace();

    // Modify
    service.getSpec().getPorts().get(0).setTargetPort(new IntOrString(9998));
    configMap.getData().put("test", "createOrReplace");
    configMap.getData().put("io", "fabric8");

    // Issue createOrReplace()
    list = new KubernetesListBuilder().withItems(service, configMap).build();
    List<HasMetadata> createdObjects = client.resourceList(list).createOrReplace();

    // Assert whether objects have been modified
    createdObjects.forEach((HasMetadata object) -> {
      if (object instanceof Service) {
        assertEquals(9998, ((Service) object).getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
      } else if (object instanceof ConfigMap) {
        assertTrue(((ConfigMap) object).getData().containsKey("io"));
        assertTrue(((ConfigMap) object).getData().containsKey("test"));
      }
    });
  }

  @Test
  void delete() {
    Pod pod1 = client.pods().withName("resource-pod-delete")
        .waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    assertTrue(client.resource(pod1).withGracePeriod(0L).delete().size() == 1);
  }

  @Test
  void testDeleteExistingWithOrphanDeletion() throws Exception {
    final String deploymentName = "delete-existing-with-orphan-deletion";
    final Deployment deployment = initDeployment(deploymentName);
    Resource<Deployment> resource = client.resource(deployment);
    resource.createOrReplace();

    // get uid of underlying replicaset. we expect this NOT to match later, meaning the orphan WAS deleted.
    List<ReplicaSet> replicaSetList = client.apps().replicaSets().withLabel("run", deploymentName)
        .informOnCondition(replicaSets -> replicaSets.size() == 1).get(30, TimeUnit.SECONDS);
    String replicaSetUid = replicaSetList.iterator().next().getMetadata().getUid();

    // Recreate deployment
    resource.withGracePeriod(0L).delete();
    resource.waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
    client.apps().replicaSets().withLabel("run", deploymentName).informOnCondition(Collection::isEmpty)
        .get(60, TimeUnit.SECONDS);
    resource.create();

    List<ReplicaSet> replicaSets = client.apps().replicaSets().withLabel("run", deploymentName)
        .informOnCondition(l -> l.size() == 1).get(30, TimeUnit.SECONDS);
    // check that uid DOES NOT MATCH original, meaning the orphan WAS deleted
    assertNotEquals(replicaSetUid, replicaSets.iterator().next().getMetadata().getUid());

    // cleanup
    assertTrue(resource.withGracePeriod(0L).delete().size() == 1);
    // Check whether child resources are also deleted
    client.apps().replicaSets().withLabel("run", deploymentName).informOnCondition(List::isEmpty)
        .get(60, TimeUnit.SECONDS);
  }

  @Test
  void testDeleteExistingWithoutOrphanDeletion() throws Exception {
    final String deploymentName = "delete-existing-without-orphan-deletion";
    final Deployment deployment = initDeployment(deploymentName);
    Resource<Deployment> resource = client.resource(deployment);
    resource.createOrReplace();

    // get uid of underlying replicaset. we expect this to match later, meaning the orphan was not deleted.
    List<ReplicaSet> replicaSetList = client.apps().replicaSets().withLabel("run", deploymentName)
        .informOnCondition(replicaSets -> replicaSets.size() == 1).get(30, TimeUnit.SECONDS);
    String replicaSetUid = replicaSetList.iterator().next().getMetadata().getUid();

    // Recreate deployment
    resource
        .withPropagationPolicy(DeletionPropagation.ORPHAN)
        .withGracePeriod(0L)
        .delete();
    resource.waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
    resource.create();

    // check that uid matches original, meaning the orphan was not deleted
    replicaSetList = client.apps().replicaSets().withLabel("run", deploymentName)
        .informOnCondition(replicaSets -> replicaSets.size() == 1).get(30, TimeUnit.SECONDS);
    assertEquals(1, replicaSetList.size());
    assertEquals(replicaSetUid, replicaSetList.iterator().next().getMetadata().getUid());

    // cleanup
    assertTrue(resource.withPropagationPolicy(DeletionPropagation.FOREGROUND).withGracePeriod(0L).delete().size() == 1);
    // Check whether child resources are also deleted
    client.apps().replicaSets().withLabel("run", deploymentName).informOnCondition(List::isEmpty)
        .get(60, TimeUnit.SECONDS);
  }

  @Test
  void testDeletionWithOrphanDeletion() throws Exception {
    final String deploymentName = "delete-with-orphan-deletion";
    final Deployment deployment = initDeployment(deploymentName);
    client.resource(deployment).createOrReplace();
    // Check whether child resources are also created
    client.apps().replicaSets().withLabel("run", deploymentName)
        .informOnCondition(replicaSets -> replicaSets.size() == 1).get(30, TimeUnit.SECONDS);

    // Delete deployment
    boolean deleted = client.resource(deployment).withPropagationPolicy(DeletionPropagation.BACKGROUND).delete().size() == 1;
    assertTrue(deleted);

    // Check whether child resources are also deleted
    client.apps().replicaSets().withLabel("run", deploymentName).informOnCondition(List::isEmpty)
        .get(60, TimeUnit.SECONDS);
  }

  @Test
  void testDeletionWithoutOrphanDeletion() throws Exception {
    final String deploymentName = "delete-without-orphan-deletion";
    final Deployment deployment = initDeployment(deploymentName);
    client.resource(deployment).createOrReplace();
    // Check whether child resources are also created
    client.apps().replicaSets().withLabel("run", deploymentName)
        .informOnCondition(replicaSets -> replicaSets.size() == 1).get(30, TimeUnit.SECONDS);

    // Delete deployment
    boolean deleted = client.resource(deployment).withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(deleted);

    // wait till deployment is deleted
    client.apps().deployments().withLabel("run", deploymentName)
        .informOnCondition(List::isEmpty).get(60, TimeUnit.SECONDS);

    // Check whether child resources are not deleted, they should be alive
    client.apps().replicaSets().withLabel("run", deploymentName).informOnCondition(l -> l.size() == 1)
        .get(30, TimeUnit.SECONDS);

    // cleanup resources which are not cleaned up during cascade deletion
    client.apps().replicaSets().withLabel("run", deploymentName).withGracePeriod(0L).delete();
  }

  private static Deployment initDeployment(String name) {
    return new DeploymentBuilder()
        .withMetadata(new ObjectMetaBuilder()
            .withName(name)
            .build())
        .withSpec(new DeploymentSpecBuilder()
            .withReplicas(1)
            .withNewSelector().withMatchLabels(Collections.singletonMap("run", name)).endSelector()
            .withTemplate(new PodTemplateSpecBuilder()
                .withNewMetadata().withLabels(Collections.singletonMap("run", name)).endMetadata()
                .withNewSpec()
                .withTerminationGracePeriodSeconds(1L)
                .addToContainers(new ContainerBuilder()
                    .withImage("busybox")
                    .withCommand("sh", "-c", "sleep 60")
                    .withName(name)
                    .addNewPort().withContainerPort(80).endPort()
                    .build())
                .endSpec()
                .build())
            .build())
        .build();
  }
}
