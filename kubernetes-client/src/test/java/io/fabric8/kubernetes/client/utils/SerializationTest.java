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
package io.fabric8.kubernetes.client.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.CustomResource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;
import java.util.stream.Collectors;

import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SerializationTest {


  @Test
  void unmarshalCRDWithSchema() throws Exception {
    final String input = readYamlToString("/test-crd-schema.yml");
    final CustomResourceDefinition crd = Serialization.unmarshal(input, CustomResourceDefinition.class);
    JSONSchemaProps spec = crd.getSpec()
      .getValidation()
      .getOpenAPIV3Schema()
      .getProperties()
      .get("spec");

    assertEquals(3, spec.getRequired().size());
    assertEquals("builderName", spec.getRequired().get(0));
    assertEquals("edges", spec.getRequired().get(1));
    assertEquals("dimensions", spec.getRequired().get(2));

    Map<String, JSONSchemaProps> properties = spec.getProperties();
    assertNotNull(properties.get("builderName"));
    assertEquals(properties.get("builderName").getExample(), new TextNode("builder-example"));
    assertEquals(BooleanNode.FALSE, properties.get("hollow").getDefault());

    assertNotNull(properties.get("dimensions"));
    assertNotNull(properties.get("dimensions").getProperties().get("x"));
    assertEquals(properties.get("dimensions").getProperties().get("x").getDefault(), new IntNode(10));

    String output = Serialization.asYaml(crd);
    assertEquals(input.trim(), output.trim());
  }

  @Test
  @DisplayName("unmarshal, String containing List with windows like line-ends (CRLF), all list items should be available")
  void unmarshalListWithWindowsLineSeparatorsString() throws Exception {
    // Given
    final String crlfFile = readYamlToString("/test-list.yml");
    // When
    final KubernetesResource result = Serialization.unmarshal(crlfFile, KubernetesResource.class);
    // Then
    assertTrue(result instanceof KubernetesList);
    final KubernetesList kubernetesList = (KubernetesList)result;
    assertEquals(2, kubernetesList.getItems().size());
    assertTrue(kubernetesList.getItems().get(0) instanceof Service);
    assertTrue(kubernetesList.getItems().get(1) instanceof Deployment);
  }

  private String readYamlToString(String path) throws IOException {
    return Files.readAllLines(
      new File(SerializationTest.class.getResource(path).getFile()).toPath(), StandardCharsets.UTF_8)
      .stream()
      .filter(line -> !line.startsWith("#"))
      .collect(Collectors.joining("\n"));
  }

  @Test
  @DisplayName("containsMultipleDocuments, multiple documents with windows line ends, should return true")
  void containsMultipleDocumentsWithMultipleDocumentsAndWindowsLineEnds() {
    // Given
    final String multiDocument = "---\r\napiVersion: v1\r\nKind: Something\r\n\r\n---\r\napiVersion: v2\r\nKind: Other";
    // When
    final boolean result = Serialization.containsMultipleDocuments(multiDocument);
    // Then
    assertTrue(result);
  }

  @Test
  @DisplayName("containsMultipleDocuments, single document with windows line ends, should return false")
  void containsMultipleDocumentsWithSingleDocumentAndWindowsLineEnds() {
    // Given
    final String multiDocument = "---\r\napiVersion: v1\r\nKind: Something\r\n\r\n";
    // When
    final boolean result = Serialization.containsMultipleDocuments(multiDocument);
    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("containsMultipleDocuments, multiple documents with linux line ends, should return true")
  void containsMultipleDocumentsWithMultipleDocumentsAndLinuxLineEnds() {
    // Given
    final String multiDocument = "---\napiVersion: v1\nKind: Something\n\n---\napiVersion: v2\nKind: Other";
    // When
    final boolean result = Serialization.containsMultipleDocuments(multiDocument);
    // Then
    assertTrue(result);
  }

  @Test
  @DisplayName("containsMultipleDocuments, single document with linux line ends, should return false")
  void containsMultipleDocumentsWithSingleDocumentAndLinuxLineEnds() {
    // Given
    final String multiDocument = "---\napiVersion: v1\nKind: Something\n\n";
    // When
    final boolean result = Serialization.containsMultipleDocuments(multiDocument);
    // Then
    assertFalse(result);
  }

  @Test
  void testSerializeYamlWithAlias() {
    // Given
    InputStream fileInputStream = getClass().getResourceAsStream("/test-pod-manifest-with-aliases.yml");

    // When
    Pod pod = Serialization.unmarshal(fileInputStream);

    // Then
    assertNotNull(pod);
    assertEquals("test-pod-with-alias", pod.getMetadata().getName());
    assertEquals("build", pod.getSpec().getNodeSelector().get("workload"));
    assertEquals(1, pod.getSpec().getTolerations().size());
    assertEquals(1000, pod.getSpec().getSecurityContext().getRunAsGroup().intValue());
    assertEquals(1000, pod.getSpec().getSecurityContext().getRunAsUser().intValue());
    assertEquals(2, pod.getSpec().getContainers().size());
    assertEquals("ubuntu", pod.getSpec().getContainers().get(0).getName());
    assertEquals("ubuntu:bionic", pod.getSpec().getContainers().get(0).getImage());
    assertEquals(new Quantity("100m"), pod.getSpec().getContainers().get(0).getResources().getRequests().get("cpu"));
    assertEquals("python3", pod.getSpec().getContainers().get(1).getName());
    assertEquals("python:3.7", pod.getSpec().getContainers().get(1).getImage());
    assertEquals(new Quantity("100m"), pod.getSpec().getContainers().get(1).getResources().getRequests().get("cpu"));
  }
  
  @Test
  void testClone() {
    // Given
    Pod pod = new PodBuilder().withNewMetadata().withName("pod").endMetadata().build();

    // When
    Pod clonePod = Serialization.clone(pod);

    // Then
    assertNotNull(clonePod);
    assertNotSame(pod, clonePod);
    assertEquals(pod.getMetadata().getName(), clonePod.getMetadata().getName());
  }

  @JsonTypeInfo(
          use = JsonTypeInfo.Id.NAME,
          include = JsonTypeInfo.As.EXISTING_PROPERTY,
          property = "type"
  )
  @JsonSubTypes(
      @JsonSubTypes.Type(value = Typed.class, name = "x")
  )
  public interface Typeable {

      String getType();

  }

  public static class Typed implements Typeable {

      @Override
      public String getType() {
          return "x";
      }

  }

  public static class Root {

      private Typeable typeable;

      public Typeable getTypeable() {
          return typeable;
      }

      public void setTypeable(Typeable typeable) {
          this.typeable = typeable;
      }
  }

  @Test
  void testSerializeYamlWithJsonSubTypes() {
      Root root = new Root();
      root.setTypeable(new Typed());
      assertEquals("---\n"
              + "typeable:\n"
              + "  type: \"x\"\n", Serialization.asYaml(root));
  }

  @Group("serialization.fabric8.io")
  @Version("v1")
  private static class MyCR extends CustomResource<String, Void> {

    public MyCR() {
      setSpec("foo");
    }
  }

  @Test
  void nullValueShouldNotBeOutput() {
    MyCR cr = new MyCR();
    final String s = Serialization.asYaml(cr);
    assertTrue(!s.contains("status"));
    assertTrue(s.contains("spec: \"foo\""));
  }

}
