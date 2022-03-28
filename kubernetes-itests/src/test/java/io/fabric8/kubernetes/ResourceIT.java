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
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.Utils;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertNotNull;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ResourceIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private String deploymentName;
  private Deployment deployment;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ResourceIT.class.getResourceAsStream("/resource-it.yml"));
  }

  @Before
  public void setUp() {
    deploymentName = UUID.randomUUID().toString();
    deployment = initDeployment(deploymentName);
  }

  @After
  public void tearDown() {
    client.apps().deployments().withName(deploymentName).withGracePeriod(0L).delete();
  }

  @Test
  public void get() {
    assertNotNull(client.pods().inNamespace(session.getNamespace()).withName("resource-pod-get").get());
  }

  @Test
  public void list() {
    Pod listPod1 = new PodBuilder()
      .withNewMetadata().withName("resource-pod-list-pod3").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();
    client.resourceList(new PodListBuilder().withItems(listPod1).build())
      .inNamespace(session.getNamespace())
      .createOrReplace();

    Assert.assertNotNull(client.pods().inNamespace(session.getNamespace()).withName("resource-pod-list-pod3"));

    boolean bDeleted = client.resourceList(new PodListBuilder().withItems(listPod1).build())
      .inNamespace(session.getNamespace())
      .delete();
    assertTrue(bDeleted);
  }

  @Test
  public void createOrReplace() {
    Service service =  new ServiceBuilder()
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

    KubernetesList list = new KubernetesListBuilder().withItems(deployment, service, configMap).build();

    // Create them for the first time
    client.resourceList(list).inNamespace(session.getNamespace()).createOrReplace();

    // Modify
    service.getSpec().getPorts().get(0).setTargetPort(new IntOrString(9998));
    configMap.getData().put("test", "createOrReplace");
    configMap.getData().put("io", "fabric8");

    // Issue createOrReplace()
    list = new KubernetesListBuilder().withItems(deployment, service, configMap).build();
    List<HasMetadata> createdObjects = client.resourceList(list).inNamespace(session.getNamespace()).createOrReplace();

    // Assert whether objects have been modified
    createdObjects.forEach((HasMetadata object) -> {
      if (object instanceof Service) {
        assertEquals(9998, ((Service)object).getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
      } else if (object instanceof ConfigMap) {
        assertTrue(((ConfigMap)object).getData().containsKey("io"));
        assertTrue(((ConfigMap)object).getData().containsKey("test"));
      }
    });
  }

  @Test
  public void delete() {
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("resource-pod-delete").get();
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(pod1));
    assertTrue(client.resource(pod1).inNamespace(session.getNamespace()).delete());
  }

  @Test
  public void testDeleteExistingWithOrphanDeletion() throws Exception {
    // Create Deployment
    Resource<Deployment> resource = client.resource(deployment).inNamespace(session.getNamespace());
    resource.createOrReplace();
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(deployment));

    // get uid of underlying replicaset. we expect this NOT to match later, meaning the orphan WAS deleted.
    ReplicaSetList replicaSetList = client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list();
    assertEquals(1, replicaSetList.getItems().size());
    String replicaSetUid = replicaSetList.getItems().get(0).getMetadata().getUid();

    // Recreate deployment
    resource.delete();
    resource.waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
    resource.create();
    final Callable<List<ReplicaSet>> replicaSets = () -> client.apps().replicaSets()
      .inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().stream()
      .filter(rs -> Utils.isNullOrEmpty(rs.getMetadata().getDeletionTimestamp()))
      .collect(Collectors.toList());
    await().atMost(30, TimeUnit.SECONDS)
      .until(() -> resourceIsReady(deployment).call() && replicaSets.call().size() == 1);
    // check that uid DOES NOT MATCH original, meaning the orphan WAS deleted
    assertNotEquals(replicaSetUid, replicaSets.call().iterator().next().getMetadata().getUid());

    // cleanup
    assertEquals(true, resource.withGracePeriod(0L).delete());
    // Check whether child resources are also deleted
    await().atMost(30, TimeUnit.SECONDS)
      .until(() -> client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().isEmpty());
  }

  @Test
  public void testDeleteExistingWithoutOrphanDeletion() {
    // Create Deployment
    Resource<Deployment> resource = client.resource(deployment)
      .inNamespace(session.getNamespace());
    resource.createOrReplace();
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(deployment));

    // get uid of underlying replicaset. we expect this to match later, meaning the orphan was not deleted.
    ReplicaSetList replicaSetList = client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list();
    assertEquals(1, replicaSetList.getItems().size());
    String replicaSetUid= replicaSetList.getItems().get(0).getMetadata().getUid();

    // Recreate deployment
    resource
      .withPropagationPolicy(DeletionPropagation.ORPHAN)
      .delete();
    resource.waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
    resource.create();

    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(deployment));

    // check that uid matches original, meaning the orphan was not deleted
    replicaSetList = client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list();
    assertEquals(1, replicaSetList.getItems().size());
    assertEquals(replicaSetUid, replicaSetList.getItems().get(0).getMetadata().getUid());

    // cleanup
    assertEquals(true, resource.delete());
    // Check whether child resources are also deleted
    await().atMost(30, TimeUnit.SECONDS)
      .until(() -> client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().size() == 0);
  }

  @Test
  public void testDeletionWithOrphanDeletion() {
    // Create Deployment
    client.resource(deployment).inNamespace(session.getNamespace()).createOrReplace();
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(deployment));
    // Check whether child resources are also created
    assertEquals(1, client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().size());

    // Delete deployment
    Boolean deleted = client.resource(deployment).inNamespace(session.getNamespace()).withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();
    assertTrue(deleted);

    // Check whether child resources are also deleted
    await().atMost(30, TimeUnit.SECONDS)
      .until(() -> client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().size() == 0);
  }

  @Test
  public void testDeletionWithoutOrphanDeletion() {
    // Create Deployment
    client.resource(deployment).inNamespace(session.getNamespace()).createOrReplace();
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(deployment));
    // Check whether child resources are also created
    assertEquals(1, client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().size());

    // Delete deployment
    Boolean deleted = client.resource(deployment).inNamespace(session.getNamespace()).withPropagationPolicy(DeletionPropagation.ORPHAN).delete();
    assertTrue(deleted);

    // wait till deployment is deleted
    await().atMost(30, TimeUnit.SECONDS)
      .until(() -> client.apps().deployments().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().size() == 0);

    // Check whether child resources are not deleted, they should be alive
    assertEquals(1, client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).list().getItems().size());

    // cleanup resources which are not cleaned up during cascade deletion
    client.apps().replicaSets().inNamespace(session.getNamespace()).withLabel("run", deploymentName).delete();
  }

  private Callable<Boolean> resourceIsReady(HasMetadata resource) {
    return () -> client.resource(resource).inNamespace(session.getNamespace()).get()!= null;
  }

  private Callable<Boolean> resourceCleanedUp(HasMetadata resource) {
    return () -> client.resource(resource).inNamespace(session.getNamespace()).get() == null;
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ResourceIT.class.getResourceAsStream("/resource-it.yml"));
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
