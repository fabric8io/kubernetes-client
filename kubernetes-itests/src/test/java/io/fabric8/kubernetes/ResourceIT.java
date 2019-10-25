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

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.apache.commons.lang.RandomStringUtils;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Time;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.waitAtMost;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ResourceIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Pod pod1;

  private String currentNamespace;

  private Deployment deployment = new DeploymentBuilder()
    .withNewMetadata().withName("deploy1").endMetadata()
    .withNewSpec()
    .withReplicas(1)
    .withNewSelector().withMatchLabels(Collections.singletonMap("run", "deploy1")).endSelector()
    .withNewTemplate()
    .withNewMetadata().withLabels(Collections.singletonMap("run", "deploy1")).endMetadata()
    .withNewSpec()
    .addNewContainer()
    .withImage("httpd")
    .withName("deploy1")
    .addNewPort().withContainerPort(80).endPort()
    .endContainer()
    .endSpec()
    .endTemplate()
    .endSpec()
    .build();

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    pod1 = new PodBuilder()
      .withNewMetadata().withName("resource-pod-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase(Locale.ROOT)).endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();

    client.resource(pod1).inNamespace(currentNamespace).createOrReplace();
  }

  @Test
  public void get() {
    assertNotNull(client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName()).get());
  }

  @Test
  public void list() {
    Pod listPod1 = new PodBuilder()
      .withNewMetadata().withName("pod3").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();
    client.resourceList(new PodListBuilder().withItems(listPod1).build())
      .inNamespace(currentNamespace)
      .apply();

    assertTrue(client.pods().inNamespace(currentNamespace).withName("pod3") != null);

    boolean bDeleted = client.resourceList(new PodListBuilder().withItems(listPod1).build())
      .inNamespace(currentNamespace)
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
    client.resourceList(list).inNamespace(currentNamespace).createOrReplace();

    // Modify
    service = client.services().inNamespace(currentNamespace).withName("my-service").get();
    service.getSpec().getPorts().get(0).setTargetPort(new IntOrString(9998));
    configMap.getData().put("test", "createOrReplace");
    configMap.getData().put("io", "fabric8");

    // Issue createOrReplace()
    list = new KubernetesListBuilder().withItems(deployment, service, configMap).build();
    List<HasMetadata> createdObjects = client.resourceList(list).inNamespace(currentNamespace).createOrReplace();

    // Assert whether objects have been modified
    createdObjects.forEach((HasMetadata object) -> {
      if (object instanceof Service) {
        assertEquals(9998, ((Service)object).getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
      } else if (object instanceof ConfigMap) {
        assertTrue(((ConfigMap)object).getData().containsKey("io"));
        assertTrue(((ConfigMap)object).getData().containsKey("test"));
      }
    });

    // Cleanup
    client.resourceList(list).inNamespace(currentNamespace).deletingExisting();
  }

  @Test
  public void delete() {
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(pod1));
    assertTrue(client.resource(pod1).inNamespace(currentNamespace).delete());
  }

  @Test
  public void testCascadeDeletion() throws InterruptedException {
    // Create Deployment
    client.resource(deployment).inNamespace(currentNamespace).createOrReplace();
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(deployment));
    // Check whether child resources are also created
    assertEquals(1, client.apps().replicaSets().inNamespace(currentNamespace).withLabel("run", "deploy1").list().getItems().size());

    // Delete deployment
    Boolean deleted = client.resource(deployment).inNamespace(currentNamespace).withGracePeriod(0).cascading(true).delete();
    assertTrue(deleted);

    // Check whether child resources are also deleted
    await().atMost(30, TimeUnit.SECONDS)
      .until(() -> client.apps().replicaSets().inNamespace(currentNamespace).withLabel("run", "deploy1").list().getItems().size() == 0);
  }

  @Test
  public void testDisabledCascadeDeletion() throws InterruptedException {
    // Create Deployment
    client.resource(deployment).inNamespace(currentNamespace).createOrReplace();
    await().atMost(30, TimeUnit.SECONDS).until(resourceIsReady(deployment));
    // Check whether child resources are also created
    assertEquals(1, client.apps().replicaSets().inNamespace(currentNamespace).withLabel("run", "deploy1").list().getItems().size());

    // Delete deployment
    Boolean deleted = client.resource(deployment).inNamespace(currentNamespace).withGracePeriod(0).cascading(false).delete();
    assertTrue(deleted);

    // wait till deployment is deleted
    await().atMost(30, TimeUnit.SECONDS)
      .until(() -> client.apps().deployments().inNamespace(currentNamespace).withLabel("run", "deploy1").list().getItems().size() == 0);

    // Check whether child resources are not deleted, they should be alive
    assertEquals(1, client.apps().replicaSets().inNamespace(currentNamespace).withLabel("run", "deploy1").list().getItems().size());

    // cleanup resources which are not cleaned up during cascade deletion
    client.apps().replicaSets().inNamespace(currentNamespace).withLabel("run", "deploy1").delete();
  }


  @After
  public void cleanup() throws InterruptedException {
    client.pods().inNamespace(currentNamespace).delete();
    // Wait for resources to get destroyed
    Thread.sleep(30000);
  }

  private Callable<Boolean> resourceIsReady(HasMetadata resource) {
    return () -> client.resource(resource).inNamespace(currentNamespace).get()!= null;
  }

  private Callable<Boolean> resourceCleanedUp(HasMetadata resource) {
    return () -> client.resource(resource).inNamespace(currentNamespace).get() == null;
  }

}
