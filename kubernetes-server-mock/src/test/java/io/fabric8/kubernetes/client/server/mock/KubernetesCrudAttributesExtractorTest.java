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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodStatusBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KubernetesCrudAttributesExtractorTest {

  @Test
  public void shouldHandleNamespacedPathWithResource() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/pods/mypod");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "pod"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "mypod"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleNamespacedPath() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/pods");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "pod"));
    expected = expected.add(new Attribute("namespace", "myns"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleNonNamespacedPath() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/nodes/mynode");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "node"));
    expected = expected.add(new Attribute("name", "mynode"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandlePathWithParameters() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/pods?labelSelector=testKey%3DtestValue");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "pod"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleResource() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    Pod pod = new PodBuilder().withNewMetadata().withName("mypod").withNamespace("myns").endMetadata().build();

    AttributeSet attributes = extractor.extract(pod);

    AttributeSet expected1 = new AttributeSet();
    expected1 = expected1.add(new Attribute("kind", "pod"));
    expected1 = expected1.add(new Attribute("namespace", "myns"));
    expected1 = expected1.add(new Attribute("name", "mypod"));
    assertFalse(attributes.matches(expected1));

    AttributeSet expected2 = new AttributeSet();
    expected2 = expected2.add(new Attribute("namespace", "myns"));
    expected2 = expected2.add(new Attribute("name", "mypod"));
    assertTrue(attributes.matches(expected2));
  }

  @Test
  public void shouldHandleResourceWithLabel() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    Map<String, String> labels = new HashMap<>();
    labels.put("name", "myname");
    Pod pod = new PodBuilder().withNewMetadata().withLabels(labels).endMetadata().build();

    AttributeSet attributes = extractor.extract(pod);

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleKindWithoutVersion() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/pods");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "pod"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleExtensions() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/apis/apps/v1/deployments");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "deployment"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleIngress() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/apis/extensions/v1beta1/namespaces/myns/ingresses/myingress");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "ingress"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "myingress"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleEndpoints() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/endpoints");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "endpoints"));
    expected = expected.add(new Attribute("namespace", "myns"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleIngresses() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/apis/extensions/v1beta1/namespaces/myns/ingresses");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "ingress"));
    expected = expected.add(new Attribute("namespace", "myns"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleApiGroups() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor
      .extract("/apis/autoscaling/v1/namespaces/myns/horizontalpodautoscalers/myhpa");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "horizontalpodautoscaler"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "myhpa"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleCrds() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/apis/test.com/v1/namespaces/myns/crds/mycrd");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("kind", "crd"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "mycrd"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleLabelSelectorsWithOneLabel() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3Dmyname");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleLabelSelectorsWithDoubleEquals() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor
      .extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3D%3Dmyname");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleLabelSelectorsWithTwoLabels() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor
      .extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3Dmyname,age%3D37");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    expected = expected.add(new Attribute("labels:age", "37"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldHandleLabelSelectorsWithADomain() {
    KubernetesCrudAttributesExtractor extractor = new KubernetesCrudAttributesExtractor();
    AttributeSet attributes = extractor
      .extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=example.com/name%3Dmyname");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:example.com/name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  public void shouldGenerateMetadata() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withGenerateName("prefix")
      .endMetadata().build();
    kubernetesClient.apps().deployments().create(deployment1);

    Deployment result = kubernetesClient.apps().deployments().list()
      .getItems().get(0);

    assertTrue(result.getMetadata().getName().startsWith("prefix"));
    assertNotNull(result.getMetadata().getUid());
    assertNotNull(result.getMetadata().getResourceVersion());
    assertNotNull(result.getMetadata().getCreationTimestamp());
    assertNotNull(result.getMetadata().getGeneration());
  }

  @Test
  public void replaceNonExistent() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Pod pod = new PodBuilder().withNewMetadata()
            .withName("name")
            .withNamespace("test") // required until https://github.com/fabric8io/mockwebserver/pull/59
            .endMetadata()
            .withStatus(new PodStatusBuilder().withHostIP("x").build())
            .build();
    assertNull(kubernetesClient.pods().inNamespace("test").withName("name").replace(pod));
  }

  @Test
  public void statusHandling() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Pod pod = new PodBuilder().withNewMetadata()
            .withName("name")
            .withNamespace("test") // required until https://github.com/fabric8io/mockwebserver/pull/59
            .endMetadata()
            .withStatus(new PodStatusBuilder().withHostIP("x").build())
            .build();
    Pod result = kubernetesClient.pods().create(pod);

    // should be null after create
    assertNull(result.getStatus());

    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");

    pod.getMetadata().setLabels(labels);

    result = kubernetesClient.pods()
        .inNamespace(pod.getMetadata().getNamespace())
        .withName(pod.getMetadata().getName())
        .replace(pod);

    String originalUid = result.getMetadata().getUid();

    // should be null after replace
    assertNull(result.getStatus());

    assertNotNull(kubernetesClient.pods().updateStatus(pod).getStatus());

    labels.put("other", "label");
    result = kubernetesClient.pods()
        .inNamespace(pod.getMetadata().getNamespace())
        .withName(pod.getMetadata().getName())
        .replace(pod);

    // should retain the existing
    assertNotNull(result.getStatus());

    labels.put("another", "label");
    result = kubernetesClient.pods()
        .inNamespace(pod.getMetadata().getNamespace())
        .withName(pod.getMetadata().getName())
        .patch(pod);

    // should retain the existing
    assertNotNull(result.getStatus());

    assertEquals(originalUid, result.getMetadata().getUid());
  }

  @Test
  public void createConflict() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Pod pod = new PodBuilder().withNewMetadata()
            .withName("name")
            .withNamespace("test") // required until https://github.com/fabric8io/mockwebserver/pull/59
            .endMetadata()
            .withStatus(new PodStatusBuilder().withHostIP("x").build())
            .build();
    kubernetesClient.pods().create(pod);
    assertThrows(KubernetesClientException.class, ()-> kubernetesClient.pods().create(pod));
  }

  // https://github.com/fabric8io/kubernetes-client/issues/1688

  @Test
  public void getDeploymentsWithLabels() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
      .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
      .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment2);

    List<Deployment> deployments = kubernetesClient.apps().deployments().withLabel("app", "core").list().getItems();
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withKeepUntil")).findFirst()
      .isPresent());
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withoutKeepUntil")).findFirst()
      .isPresent());
  }

  @Test
  public void getDeploymentsWithoutLabels() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
      .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
      .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment2);

    List<Deployment> deployments = kubernetesClient.apps().deployments().withoutLabel("keepUntil", "12000").list()
      .getItems();
    assertFalse(deployments.stream().filter(d -> d.getMetadata().getName().equals("withKeepUntil")).findFirst()
      .isPresent());
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withoutKeepUntil")).findFirst()
      .isPresent());
  }

  @Test
  public void getDeploymentsWithAndWithoutLabels() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
      .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
      .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment2);

    List<Deployment> deployments = kubernetesClient.apps().deployments().withLabel("app", "core")
      .withoutLabel("keepUntil", "12000").list().getItems();
    assertFalse(deployments.stream().filter(d -> d.getMetadata().getName().equals("withKeepUntil")).findFirst()
      .isPresent());
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withoutKeepUntil")).findFirst()
      .isPresent());
  }

  @Test
  public void shouldFilterBasedOnLabelExists() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
      .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
      .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment2);

    List<Deployment> deployments = kubernetesClient.apps().deployments().withLabel("keepUntil").list().getItems();
    assertTrue(deployments.stream().anyMatch(d -> d.getMetadata().getName().equals("withKeepUntil")));
    assertTrue(deployments.stream().noneMatch(d -> d.getMetadata().getName().equals("withoutKeepUntil")));
  }

  @Test
  public void shouldFilterBasedOnLabelNotExists() {
    KubernetesServer kubernetesServer = new KubernetesServer(false, true);
    kubernetesServer.before();
    KubernetesClient kubernetesClient = kubernetesServer.getClient();
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
      .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
      .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    kubernetesClient.apps().deployments().create(deployment2);

    List<Deployment> deployments = kubernetesClient.apps().deployments().withoutLabel("keepUntil").list().getItems();
    assertEquals(1, deployments.size());
    assertEquals("withoutKeepUntil", deployments.get(0).getMetadata().getName());
  }

}
