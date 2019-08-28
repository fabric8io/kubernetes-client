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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.mockwebserver.crud.Attribute;
import io.fabric8.mockwebserver.crud.AttributeSet;

public class KubernetesAttributesExtractorTest {

	@Test
	public void shouldHandleNamespacedPathWithResource() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/pods/mypod");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "pod"));
		expected = expected.add(new Attribute("namespace", "myns"));
		expected = expected.add(new Attribute("name", "mypod"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleNamespacedPath() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/pods");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "pod"));
		expected = expected.add(new Attribute("namespace", "myns"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleNonNamespacedPath() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/api/v1/nodes/mynode");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "node"));
		expected = expected.add(new Attribute("name", "mynode"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandlePathWithParameters() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/api/v1/pods?labelSelector=testKey%3DtestValue");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "pod"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleResource() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		Pod pod = new PodBuilder().withNewMetadata().withName("mypod").withNamespace("myns").endMetadata().build();

		AttributeSet attributes = extractor.extract(pod);

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "pod"));
		expected = expected.add(new Attribute("namespace", "myns"));
		expected = expected.add(new Attribute("name", "mypod"));
		assertTrue(attributes.matches(expected));

	}

	@Test
	public void shouldHandleResourceWithLabel() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
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
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/api/pods");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "pod"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleExtensions() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/apis/apps/v1/deployments");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "deployment"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleIngress() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/apis/extensions/v1beta1/namespaces/myns/ingresses/myingress");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "ingress"));
		expected = expected.add(new Attribute("namespace", "myns"));
		expected = expected.add(new Attribute("name", "myingress"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleEndpoints() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/endpoints");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "endpoints"));
		expected = expected.add(new Attribute("namespace", "myns"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleIngresses() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/apis/extensions/v1beta1/namespaces/myns/ingresses");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "ingress"));
		expected = expected.add(new Attribute("namespace", "myns"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleApiGroups() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
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
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/apis/test.com/v1/namespaces/myns/crds/mycrd");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("kind", "crd"));
		expected = expected.add(new Attribute("namespace", "myns"));
		expected = expected.add(new Attribute("name", "mycrd"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleLabelSelectorsWithOneLabel() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor.extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3Dmyname");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("labels:name", "myname"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleLabelSelectorsWithDoubleEquals() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor
				.extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3D%3Dmyname");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("labels:name", "myname"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleLabelSelectorsWithTwoLabels() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor
				.extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=name%3Dmyname,age%3D37");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("labels:name", "myname"));
		expected = expected.add(new Attribute("labels:age", "37"));
		assertTrue(attributes.matches(expected));
	}

	@Test
	public void shouldHandleLabelSelectorsWithADomain() {
		KubernetesAttributesExtractor extractor = new KubernetesAttributesExtractor();
		AttributeSet attributes = extractor
				.extract("/api/v1/namespaces/myns/pods/mypod?labelSelector=example.com/name%3Dmyname");

		AttributeSet expected = new AttributeSet();
		expected = expected.add(new Attribute("labels:example.com/name", "myname"));
		assertTrue(attributes.matches(expected));
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
}
