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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SerializationTest {

  @Test
  void unmarshalCRDWithSchema() throws Exception {
    // Given
    final String input = readYamlToString("/serialization/test-crd-schema.yml");
    final CustomResourceDefinition crd = Serialization.unmarshal(input, CustomResourceDefinition.class);
    // When
    JSONSchemaProps spec = crd.getSpec()
        .getValidation()
        .getOpenAPIV3Schema()
        .getProperties()
        .get("spec");
    // Then
    assertThat(spec)
        .hasFieldOrPropertyWithValue("properties.builderName.example", new TextNode("builder-example"))
        .hasFieldOrPropertyWithValue("properties.hollow.default", BooleanNode.FALSE)
        .hasFieldOrPropertyWithValue("properties.dimensions.properties.x.default", new IntNode(10))
        .extracting(JSONSchemaProps::getRequired).asList()
        .containsExactly("builderName", "edges", "dimensions");
  }

  @Test
  void asYamlWithDeserializedCRD() throws Exception {
    // Given
    final String input = readYamlToString("/serialization/test-crd-schema.yml");
    final CustomResourceDefinition crd = Serialization.unmarshal(input, CustomResourceDefinition.class);
    // When
    final String result = Serialization.asYaml(crd);
    // Then
    assertThat(result.trim()).isEqualTo(input.trim());
  }

  @Test
  @DisplayName("unmarshal, String containing List with windows like line-ends (CRLF), all list items should be available")
  void unmarshalListWithWindowsLineSeparatorsString() throws Exception {
    // Given
    final String crlfFile = readYamlToString("/serialization/test-list.yml");
    // When
    final KubernetesResource result = Serialization.unmarshal(crlfFile, KubernetesResource.class);
    // Then
    assertThat(result)
        .asInstanceOf(InstanceOfAssertFactories.type(KubernetesList.class))
        .extracting(KubernetesList::getItems).asList()
        .hasSize(2)
        .hasAtLeastOneElementOfType(Service.class)
        .hasAtLeastOneElementOfType(Deployment.class);
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
    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("containsMultipleDocuments, single document with windows line ends, should return false")
  void containsMultipleDocumentsWithSingleDocumentAndWindowsLineEnds() {
    // Given
    final String multiDocument = "---\r\napiVersion: v1\r\nKind: Something\r\n\r\n";
    // When
    final boolean result = Serialization.containsMultipleDocuments(multiDocument);
    // Then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("containsMultipleDocuments, multiple documents with linux line ends, should return true")
  void containsMultipleDocumentsWithMultipleDocumentsAndLinuxLineEnds() {
    // Given
    final String multiDocument = "---\napiVersion: v1\nKind: Something\n\n---\napiVersion: v2\nKind: Other";
    // When
    final boolean result = Serialization.containsMultipleDocuments(multiDocument);
    // Then
    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("containsMultipleDocuments, single document with linux line ends, should return false")
  void containsMultipleDocumentsWithSingleDocumentAndLinuxLineEnds() {
    // Given
    final String multiDocument = "---\napiVersion: v1\nKind: Something\n\n";
    // When
    final boolean result = Serialization.containsMultipleDocuments(multiDocument);
    // Then
    assertThat(result).isFalse();
  }

  @Test
  void testSerializeYamlWithAlias() {
    // Given
    InputStream fileInputStream = getClass().getResourceAsStream("/serialization/test-pod-manifest-with-aliases.yml");
    // When
    Pod pod = Serialization.unmarshal(fileInputStream);
    // Then
    assertThat(pod)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-pod-with-alias")
        .hasFieldOrPropertyWithValue("spec.nodeSelector.workload", "build")
        .hasFieldOrPropertyWithValue("spec.tolerations.size", 1)
        .hasFieldOrPropertyWithValue("spec.securityContext.runAsGroup", 1000L)
        .hasFieldOrPropertyWithValue("spec.securityContext.runAsUser", 1000L)
        .extracting(Pod::getSpec).extracting(PodSpec::getContainers).asList()
        .hasSize(2)
        .extracting("name", "image", "resources.requests.cpu")
        .containsExactly(
            new Tuple("ubuntu", "ubuntu:bionic", new Quantity("100m")),
            new Tuple("python3", "python:3.7", new Quantity("100m")));
  }

  @Test
  void testClone() {
    // Given
    Pod pod = new PodBuilder().withNewMetadata().withName("pod").endMetadata().build();
    // When
    Pod clonePod = Serialization.clone(pod);
    // Then
    assertThat(clonePod)
        .isEqualTo(pod)
        .isNotSameAs(pod)
        .hasFieldOrPropertyWithValue("metadata.name", "pod");
  }

  @Test
  void testCloneNonResource() {
    // Given
    Map<String, String> value = Collections.singletonMap("key", "value");
    // When
    Map<String, String> cloneValue = Serialization.clone(value);
    // Then
    assertThat(cloneValue)
        .isEqualTo(value)
        .isNotSameAs(value);
  }

  @Test
  @DisplayName("unmarshal, with valid YAML custom resource, should return GenericKubernetesResource instance")
  void unmarshalWithValidCustomResourceShouldReturnGenericCustomResource() {
    // When
    final KubernetesResource result = Serialization.unmarshal(
        SerializationTest.class.getResourceAsStream("/serialization/custom-resource.yml"));
    // Then
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GenericKubernetesResource.class)
        .hasFieldOrPropertyWithValue("apiVersion", "the-cr.example.com/v1")
        .hasFieldOrPropertyWithValue("Kind", "SomeCustomResource")
        .hasFieldOrPropertyWithValue("metadata.name", "custom-resource-example")
        .hasFieldOrPropertyWithValue("additionalProperties.spec.field", "value")
        .hasFieldOrPropertyWithValue("additionalProperties.status.reconciled", true);
  }

  @Test
  @DisplayName("unmarshal, with invalid YAML content, should throw Exception")
  void unmarshalWithInvalidYamlShouldThrowException() {
    // Given
    final InputStream is = SerializationTest.class.getResourceAsStream("/serialization/invalid-yaml.yml");
    // When
    final ClassCastException result = assertThrows(ClassCastException.class, () -> Serialization.unmarshal(is));
    // Then
    assertThat(result)
        .hasMessageContainingAll("java.lang.String", "cannot be cast to", "java.util.Map");
  }

  @Test
  @DisplayName("unmarshal, with invalid YAML resource, should return null")
  void unmarshalWithInvalidResourceShouldReturnNull() {
    // When
    final KubernetesResource result = Serialization.unmarshal(
        SerializationTest.class.getResourceAsStream("/serialization/invalid-resource.yml"));
    // Then
    assertThat(result).isNull();
  }

  @Test
  @DisplayName("unmarshal, with valid YAML list, should return KubernetesList")
  void unmarshalWithValidListShouldReturnKubernetesList() {
    // When
    final KubernetesResource result = Serialization.unmarshal(
        SerializationTest.class.getResourceAsStream("/serialization/kubernetes-list.yml"));
    // Then
    assertThat(result)
        .asInstanceOf(InstanceOfAssertFactories.type(KubernetesList.class))
        .extracting(KubernetesList::getItems).asList()
        .hasSize(3)
        .extracting("class", "apiVersion", "kind", "metadata.name")
        .containsExactlyInAnyOrder(
            new Tuple(GenericKubernetesResource.class, "custom.resource.example.com/v1", "Example", "a-custom-resource"),
            new Tuple(Namespace.class, "v1", "Namespace", "a-namespace"),
            new Tuple(Pod.class, "v1", "Pod", "a-pod"));
  }

  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
  @JsonSubTypes(@JsonSubTypes.Type(value = Typed.class, name = "x"))
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
    final String result = Serialization.asYaml(root);
    assertThat(result)
        .isEqualTo("---\n"
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
    assertThat(s)
        .doesNotContain("status")
        .contains("spec: \"foo\"");
  }

  @Test
  void quantityQuoting() {
    Quantity quantity = Serialization.unmarshal("amount: \"2\"\nformat: \"Gi\"", Quantity.class);
    assertThat(Serialization.asYaml(quantity)).isEqualTo("--- \"2Gi\"\n");
  }

}
