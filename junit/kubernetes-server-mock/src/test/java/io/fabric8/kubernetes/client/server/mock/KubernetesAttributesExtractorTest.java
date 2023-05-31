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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.extensions.IngressBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
public class KubernetesAttributesExtractorTest {

  KubernetesClient client;

  @Test
  void shouldHandleNamespacedPathWithResource() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/namespaces/myns/pods/mypod");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "mypod"));
    expected = expected.add(new Attribute("version", "v1"));
    assertTrue(attributes.matches(expected));
    assertFalse(attributes.containsKey(KubernetesAttributesExtractor.API));
  }

  @Test
  void shouldHandleNamespacedPath() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/namespaces/myns/pods");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("namespace", "myns"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleNonNamespacedPath() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/nodes/mynode");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "nodes"));
    expected = expected.add(new Attribute("name", "mynode"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandlePathWithLabelSelectorParam() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/pods?labelSelector=testKey%3DtestValue");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("labels:testKey", "testValue"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandlePathWithFieldSelectorParam() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/pods?fieldSelector=testKey%3DtestValue");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("testKey", "testValue"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleResource() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    Pod pod = new PodBuilder().withNewMetadata().withName("mypod").withNamespace("myns").endMetadata().build();

    AttributeSet attributes = extractor.extract(pod);

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("metadata.namespace", "myns"));
    expected = expected.add(new Attribute("name", "mypod"));
    expected = expected.add(new Attribute("metadata.name", "mypod"));
    expected = expected.add(new Attribute("version", "v1"));
    assertTrue(attributes.matches(expected));
    assertFalse(attributes.containsKey(KubernetesAttributesExtractor.API));
  }

  @Test
  void shouldHandleRawResource() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    String resource = "{\"metadata\":{\"name\":\"myresource\",\"namespace\":\"myns\"}, \"kind\":\"raw\", \"apiVersion\":\"v1\"}";

    AttributeSet attributes = extractor.fromResource(resource);

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("metadata.namespace", "myns"));
    expected = expected.add(new Attribute("name", "myresource"));
    expected = expected.add(new Attribute("metadata.name", "myresource"));
    expected = expected.add(new Attribute("version", "v1"));
    assertTrue(attributes.matches(expected));
    assertFalse(attributes.containsKey(KubernetesAttributesExtractor.API));
  }

  @Test
  void shouldHandleResourceWithLabel() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    Map<String, String> labels = new HashMap<>();
    labels.put("name", "myname");
    Pod pod = new PodBuilder().withNewMetadata().withLabels(labels).endMetadata().build();

    AttributeSet attributes = extractor.extract(pod);

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  /**
   * Default versions are not yet understood
   */
  @Test
  void shouldHandleKindWithoutVersion() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/pods");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleExtensions() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/apis/apps/v1/deployments");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "deployments"));
    expected = expected.add(new Attribute("api", "apps"));
    expected = expected.add(new Attribute("version", "v1"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleIngress() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    extractor.extract(new IngressBuilder().withNewMetadata().endMetadata().build());
    AttributeSet attributes = extractor.fromPath("/apis/extensions/v1beta1/namespaces/myns/ingresses/myingress");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "ingresses"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "myingress"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleEndpoints() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/namespaces/myns/endpoints");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "endpoints"));
    expected = expected.add(new Attribute("namespace", "myns"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleIngresses() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/apis/extensions/v1beta1/namespaces/myns/ingresses");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "ingresses"));
    expected = expected.add(new Attribute("namespace", "myns"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleApiGroups() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor
        .fromPath("/apis/autoscaling/v1/namespaces/myns/horizontalpodautoscalers/myhpa");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "horizontalpodautoscalers"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "myhpa"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleCrdsTypeUnknown() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/apis/test.com/v1/namespaces/myns/crds/mycrd");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "crds"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "mycrd"));
    expected = expected.add(new Attribute("version", "v1"));
    expected = expected.add(new Attribute("api", "test.com"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleCrds() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/apis/test.com/v1/namespaces/myns/crds/mycrd");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "crds"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "mycrd"));
    expected = expected.add(new Attribute("api", "test.com"));
    expected = expected.add(new Attribute("version", "v1"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleCustomResources() {
    CustomResourceDefinitionContext crdContext = new CustomResourceDefinitionContext.Builder()
        .withScope("Namespaced")
        .withPlural("crds")
        .withVersion("v1")
        .withGroup("test.com")
        .withKind("crd")
        .build();

    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    CustomResourceDefinitionProcessor processor = new CustomResourceDefinitionProcessor();
    processor.addCrdContext(crdContext);
    extractor.setCustomResourceDefinitionProcessor(processor);
    String resource = "{\"metadata\":{\"name\":\"myresource\",\"namespace\":\"myns\"}, \"kind\":\"crd\", \"apiVersion\":\"test.com/v1\"}";
    AttributeSet attributes = extractor.fromResource(resource);

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "crds"));
    expected = expected.add(new Attribute("namespace", "myns"));
    expected = expected.add(new Attribute("name", "myresource"));
    expected = expected.add(new Attribute("metadata.name", "myresource"));
    expected = expected.add(new Attribute("metadata.namespace", "myns"));
    expected = expected.add(new Attribute("api", "test.com"));
    expected = expected.add(new Attribute("version", "v1"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleCrdSubresources() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    String[] subresources = new String[] { "status", "scale" };

    String basePath = "/apis/test.com/v1/namespaces/myns/crds/mycrd/";
    for (String subresource : subresources) {
      AttributeSet attributes = extractor.fromPath(basePath + subresource);

      AttributeSet expected = new AttributeSet();
      expected = expected.add(new Attribute("plural", "crds"));
      expected = expected.add(new Attribute("namespace", "myns"));
      expected = expected.add(new Attribute("name", "mycrd"));
      assertTrue(attributes.matches(expected),
          "extracted attributes match for " + subresource + " expectation: " + expected);
    }

    AttributeSet attributes = extractor.fromPath(basePath + "somethingRandom");
    assertTrue(attributes.matches(new AttributeSet()),
        "should extract nothing from an unsupported crd subresource");
  }

  @Test
  void shouldHandleNamespacedResourceLabelSelectorsWithOneLabel() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3Dmyname");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleLabelSelectorsWithDoubleEquals() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor
        .fromPath("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3D%3Dmyname");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleLabelSelectorsWithTwoLabels() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor
        .fromPath("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3Dmyname,age%3D37");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:name", "myname"));
    expected = expected.add(new Attribute("labels:age", "37"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleNamespacedResourceFieldSelectorsWithOneField() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor.fromPath("/api/v1/namespaces/myns/pods/mypod?fieldSelector=testKey%3DtestValue");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("testKey", "testValue"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleFieldSelectorsWithDoubleEquals() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor
        .fromPath("/api/v1/namespaces/myns/pods/mypod?fieldSelector=testKey%3D%3DtestValue");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("testKey", "testValue"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleFieldSelectorsWithTwoLabels() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor
        .fromPath("/api/v1/namespaces/myns/pods/mypod?fieldSelector=keyOne%3DvalueOne,keyTwo%3DvalueTwo");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("plural", "pods"));
    expected = expected.add(new Attribute("keyOne", "valueOne"));
    expected = expected.add(new Attribute("keyTwo", "valueTwo"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void shouldHandleLabelSelectorsWithADomain() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    AttributeSet attributes = extractor
        .fromPath("/api/v1/namespaces/myns/pods/mypod?labelSelector=example.com/name%3Dmyname");

    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("labels:example.com/name", "myname"));
    assertTrue(attributes.matches(expected));
  }

  // https://github.com/fabric8io/kubernetes-client/issues/1688

  @Test
  void getDeploymentsWithLabels() {
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
        .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
        .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment2);

    List<Deployment> deployments = client.apps().deployments().withLabel("app", "core").list().getItems();
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withKeepUntil")).findFirst()
        .isPresent());
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withoutKeepUntil")).findFirst()
        .isPresent());
  }

  @Test
  void getDeploymentsWithoutLabels() {
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
        .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
        .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment2);

    List<Deployment> deployments = client.apps().deployments().withoutLabel("keepUntil", "12000").list()
        .getItems();
    assertFalse(deployments.stream().filter(d -> d.getMetadata().getName().equals("withKeepUntil")).findFirst()
        .isPresent());
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withoutKeepUntil")).findFirst()
        .isPresent());
  }

  @Test
  void getDeploymentsWithAndWithoutLabels() {
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
        .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
        .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment2);

    List<Deployment> deployments = client.apps().deployments().withLabel("app", "core")
        .withoutLabel("keepUntil", "12000").list().getItems();
    assertFalse(deployments.stream().filter(d -> d.getMetadata().getName().equals("withKeepUntil")).findFirst()
        .isPresent());
    assertTrue(deployments.stream().filter(d -> d.getMetadata().getName().equals("withoutKeepUntil")).findFirst()
        .isPresent());
  }

  @Test
  void shouldFilterBasedOnLabelExists() {
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
        .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
        .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment2);

    List<Deployment> deployments = client.apps().deployments().withLabel("keepUntil").list().getItems();
    assertTrue(deployments.stream().anyMatch(d -> d.getMetadata().getName().equals("withKeepUntil")));
    assertTrue(deployments.stream().noneMatch(d -> d.getMetadata().getName().equals("withoutKeepUntil")));
  }

  @Test
  void shouldFilterBasedOnLabelNotExists() {
    Map<String, String> labels = new HashMap<>();
    labels.put("app", "core");
    labels.put("apiVersion", "1.7.1");
    labels.put("keepUntil", "12000");
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata().withName("withKeepUntil").addToLabels(labels)
        .endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment1);

    labels.remove("keepUntil");
    Deployment deployment2 = new DeploymentBuilder().withNewMetadata().withName("withoutKeepUntil")
        .addToLabels(labels).endMetadata().withNewStatus().withReadyReplicas(2).endStatus().build();
    client.apps().deployments().create(deployment2);

    List<Deployment> deployments = client.apps().deployments().withoutLabel("keepUntil").list().getItems();
    assertEquals(1, deployments.size());
    assertEquals("withoutKeepUntil", deployments.get(0).getMetadata().getName());
  }

  @Test
  void testCustomResourceAttributesExtraction() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();

    // When
    AttributeSet attributes = extractor
        .fromPath("/apis/demo.fabric8.io/v1alpha1/namespaces/ns1/customdatabases");

    // Then
    AttributeSet expected = new AttributeSet();
    expected = expected.add(new Attribute("namespace", "ns1"));
    expected = expected.add(new Attribute("plural", "customdatabases"));
    expected = expected.add(new Attribute("api", "demo.fabric8.io"));
    expected = expected.add(new Attribute("version", "v1alpha1"));
    assertTrue(attributes.matches(expected));
  }

  @Test
  void kubernetesPathIngresses() {
    KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
    Map<String, String> attributes = extractor
        .fromKubernetesPath("/apis/extensions/v1beta1/namespaces/myns/ingresses/myingress");

    assertEquals("ingresses", attributes.get(KubernetesAttributesExtractor.PLURAL));
  }

  @Test
  void testMultipleCrdVersions() throws IOException {
    helpTestMultipleCrdVersions(true);
  }

  @Test
  void testMultipleCrdVersionsUnregistered() throws IOException {
    helpTestMultipleCrdVersions(false);
  }

  private void helpTestMultipleCrdVersions(boolean registered) throws IOException {
    CustomResourceDefinitionContext crdContextV1 = new CustomResourceDefinitionContext.Builder()
        .withScope("Namespaced")
        .withPlural("customdatabases")
        .withVersion("v1")
        .withGroup("demo.fabric8.io")
        .withKind("CustomDatabase")
        .build();

    CustomResourceDefinitionContext crdContextV1Alpha1 = new CustomResourceDefinitionContext.Builder()
        .withScope("Namespaced")
        .withPlural("customdatabases")
        .withVersion("v1alpha1")
        .withGroup("demo.fabric8.io")
        .withKind("CustomDatabase")
        .build();

    GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setMetadata(new ObjectMetaBuilder().withName("v1").build());
    gkr.setKind("CustomDatabase");
    gkr.setApiVersion("demo.fabric8.io/v1");

    client.genericKubernetesResources(crdContextV1).create(gkr);

    gkr.setApiVersion("demo.fabric8.io/v1alpha1");
    client.genericKubernetesResources(crdContextV1Alpha1).create(gkr);

    assertEquals(1, client.genericKubernetesResources(crdContextV1).list().getItems().size());
    assertEquals(1, client.genericKubernetesResources(crdContextV1Alpha1).list().getItems().size());
  }
}
