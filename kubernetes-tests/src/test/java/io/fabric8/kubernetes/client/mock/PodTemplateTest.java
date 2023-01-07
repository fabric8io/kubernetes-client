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

import io.fabric8.kubernetes.api.model.PodTemplate;
import io.fabric8.kubernetes.api.model.PodTemplateBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateList;
import io.fabric8.kubernetes.api.model.PodTemplateListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class PodTemplateTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("Should load a PodTemplate from yaml")
  public void testLoad() {
    PodTemplate podTemplate = client.v1().podTemplates().load(getClass().getResourceAsStream("/test-podtemplate.yml")).item();
    assertNotNull(podTemplate);
    assertEquals("hello", podTemplate.getMetadata().getName());
    assertEquals(1, podTemplate.getTemplate().getSpec().getContainers().size());
  }

  @Test
  @DisplayName("Should create a PodTemplate")
  public void testCreate() {
    // Given
    PodTemplate pt1 = getPodTemplate();
    server.expect().post().withPath("/api/v1/namespaces/test/podtemplates")
        .andReturn(200, pt1)
        .once();

    // When
    PodTemplate result = client.v1().podTemplates().inNamespace("test").create(pt1);

    // Then
    assertEquals("pt1", result.getMetadata().getName());
    assertEquals(1, result.getTemplate().getSpec().getContainers().size());
  }

  @Test
  @DisplayName("Should fetch PodTemplate from apiServer")
  public void testGet() {
    // Given
    server.expect().get().withPath("/api/v1/namespaces/test/podtemplates/pt1")
        .andReturn(200, getPodTemplate())
        .once();

    // When
    PodTemplate result = client.v1().podTemplates().inNamespace("test").withName("pt1").get();

    // Then
    assertEquals("pt1", result.getMetadata().getName());
    assertEquals(1, result.getTemplate().getSpec().getContainers().size());
  }

  @Test
  @DisplayName("Should list all PodTemplate resources in some namespace")
  public void testList() {
    // Given
    server.expect().get().withPath("/api/v1/namespaces/test/podtemplates")
        .andReturn(200, new PodTemplateListBuilder().withItems(getPodTemplate()).build())
        .once();

    // When
    PodTemplateList podTemplateList = client.v1().podTemplates().inNamespace("test").list();

    // Then
    assertNotNull(podTemplateList);
    assertEquals(1, podTemplateList.getItems().size());
    assertEquals("pt1", podTemplateList.getItems().get(0).getMetadata().getName());
    assertEquals(1, podTemplateList.getItems().get(0).getTemplate().getSpec().getContainers().size());
  }

  @Test
  @DisplayName("Should be able to edit a PodTemplate")
  public void testEdit() {
    // Given
    PodTemplate updatedPodTemplate = new PodTemplateBuilder()
        .withNewMetadata()
        .withName("pt1")
        .addToLabels("foo", "bar")
        .endMetadata()
        .withNewTemplate()
        .withNewSpec()
        .addNewContainer()
        .withName("foo")
        .withImage("docker.io/matzew/eventing-display@sha256:f1c948343622a75b5f7a9058aacdffd2dc1732e07a339477f7d1d6ef09da872a")
        .endContainer()
        .endSpec()
        .endTemplate()
        .build();
    server.expect().get().withPath("/api/v1/namespaces/test/podtemplates/pt1")
        .andReturn(200, getPodTemplate())
        .times(3);
    server.expect().patch().withPath("/api/v1/namespaces/test/podtemplates/pt1")
        .andReturn(200, updatedPodTemplate)
        .once();

    // When
    PodTemplate podTemplate = client.v1().podTemplates().inNamespace("test").withName("pt1")
        .edit(p -> new PodTemplateBuilder(p).editMetadata().addToLabels("foo", "bar").endMetadata().build());

    // Then
    assertEquals("pt1", podTemplate.getMetadata().getName());
    assertEquals("bar", podTemplate.getMetadata().getLabels().get("foo"));
    assertEquals(1, podTemplate.getTemplate().getSpec().getContainers().size());
  }

  @Test
  @DisplayName("Should be able to delete a PodTemplate")
  public void testDelete() {
    // Given
    server.expect().delete().withPath("/api/v1/namespaces/test/podtemplates/pt1")
        .andReturn(200, getPodTemplate())
        .once();

    // When
    boolean isDeleted = client.v1().podTemplates().inNamespace("test").withName("pt1").delete().size() == 1;

    // Then
    assertTrue(isDeleted);
  }

  private PodTemplate getPodTemplate() {
    return new PodTemplateBuilder()
        .withNewMetadata().withName("pt1").endMetadata()
        .withNewTemplate()
        .withNewSpec()
        .addNewContainer()
        .withName("foo")
        .withImage("docker.io/matzew/eventing-display@sha256:f1c948343622a75b5f7a9058aacdffd2dc1732e07a339477f7d1d6ef09da872a")
        .endContainer()
        .endSpec()
        .endTemplate()
        .build();
  }
}
