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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import io.fabric8.kubernetes.api.model.AnyType;
import io.fabric8.kubernetes.api.model.Config;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseSpec;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SerializationTest {

  static class WithNull {
    @JsonInclude(value = Include.ALWAYS)
    public Integer field;
  }

  static class WithoutNull {
    public Integer field;
  }

  @Test
  void testNullSerialization() throws Exception {
    assertEquals("---\nfield: null\n", Serialization.asYaml(new WithNull()));
    assertEquals("{\"field\":null}", Serialization.asJson(new WithNull()));
    assertEquals("--- {}\n", Serialization.asYaml(new WithoutNull()));
    assertEquals("{}", Serialization.asJson(new WithoutNull()));
    // map null values should be preserved
    Map<String, String> map = new HashMap<>();
    map.put("key", null);
    assertEquals("{\"key\":null}", Serialization.asJson(map));
  }

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
        .hasFieldOrPropertyWithValue("spec.securityContext.runAsGroup", 1000L)
        .hasFieldOrPropertyWithValue("spec.securityContext.runAsUser", 1000L)
        .extracting(Pod::getSpec)
        .returns(Arrays.asList(new Toleration("NoSchedule", "nodeType", "Equal", null, "build")), PodSpec::getTolerations)
        .extracting(PodSpec::getContainers).asList()
        .hasSize(2)
        .extracting("name", "image", "resources.requests.cpu")
        .containsExactly(
            new Tuple("ubuntu", "ubuntu:bionic", new Quantity("100m")),
            new Tuple("python3", "python:3.7", new Quantity("100m")));
  }

  @Test
  void cloneKubernetesResourceReturnsDifferentInstance() {
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
  void cloneNonResourceReturnsDifferentInstance() {
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
  void unmarshalWithInvalidYamlShouldReturnRawExtension() {
    // Given
    final InputStream is = SerializationTest.class.getResourceAsStream("/serialization/invalid-yaml.yml");
    // When
    RawExtension result = Serialization.unmarshal(is);
    // Then
    assertEquals("This\nis not\nYAML", result.getValue());
  }

  @Test
  void unmarshalYamlArrayShouldThrowException() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Serialization.unmarshal("- 1\n- 2"))
        .withMessageStartingWith("Cannot parse a nested array containing non-object resource");
  }

  @Test
  void unmarshalJsonArrayShouldThrowException() {
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(() -> Serialization.unmarshal("[1, 2]"))
        .withMessage("An error has occurred.")
        .havingCause()
        .withMessageStartingWith("Cannot parse a nested array containing non-object resource");
  }

  @Test
  void unmarshalYamlArrayWithProvidedTypeShouldDeserialize() {
    // not valid as KubernetesResource - we'd have to look ahead to know if the array values
    // were not hasmetadata
    assertEquals(Arrays.asList(1, 2), Serialization.unmarshal("- 1\n- 2", List.class));
  }

  @Test
  void unmarshalJsonArrayWithProvidedTypeShouldDeserialize() {
    // not valid as KubernetesResource - we'd have to look ahead to know if the array values
    // were not hasmetadata
    assertEquals(Arrays.asList(1, 2), Serialization.unmarshal("[1, 2]", List.class));
  }

  @ParameterizedTest(name = "''{0}'' should be deserialized as ''{1}''")
  @MethodSource("unmarshalPrimitivesInput")
  void unmarshalPrimitives(String input, Object expected) {
    assertThat(Serialization.<RawExtension> unmarshal(input))
        .extracting(RawExtension::getValue)
        .isEqualTo(expected);
    assertEquals("a", Serialization.unmarshal("\"a\"", String.class));
    assertEquals("a", Serialization.unmarshal("a", String.class));
  }

  @ParameterizedTest(name = "''{0}'' and ''{2}'' target type should be deserialized as ''{1}''")
  @MethodSource("unmarshalPrimitivesInput")
  void unmarshalPrimitivesWithType(String input, Object expected, Class<?> targetType) {
    assertThat(Serialization.unmarshal(input, targetType))
        .isEqualTo(expected);
  }

  static Stream<Arguments> unmarshalPrimitivesInput() {
    return Stream.of(
        Arguments.arguments("\"a\"", "a", String.class), // JSON
        Arguments.arguments("a", "a", String.class), // YAML
        Arguments.arguments("1", 1, Integer.class),
        Arguments.arguments("true", true, Boolean.class),
        Arguments.arguments("1.2", 1.2, Double.class));
  }

  @Test
  void unmarshalRawResource() {
    InputStream is = SerializationTest.class.getResourceAsStream("/serialization/invalid-resource.yml");
    RawExtension raw = Serialization.unmarshal(is);
    ((Map) raw.getValue()).get("not-a").equals("resource");
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

  @Test
  void parseConfigWithRaw() {
    Config config = Serialization.unmarshal("extensions: \n"
        + "- name: foo\n"
        + "  extension:\n"
        + "    not: kubernetesresource", Config.class);

    // ensure that the extenion is preserved
    assertThat(Serialization.asYaml(config)).isEqualTo("---\n"
        + "extensions:\n"
        + "- extension:\n"
        + "    not: \"kubernetesresource\"\n"
        + "  name: \"foo\"\n");
  }

  @JsonTypeResolver(io.fabric8.kubernetes.model.jackson.UnwrappedTypeResolverBuilder.class)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonSubTypes({
      @JsonSubTypes.Type(Named.class),
      @JsonSubTypes.Type(Counted.class)
  })
  @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
  interface Poly {

  }

  @JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  static class Named implements Poly {
    public String name;
  }

  @JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
  static class Counted implements Poly {
    public int count;
  }

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  static class PolyParent {
    @JsonUnwrapped
    public Poly poly;
    public int other;
  }

  @Test
  void polymorphicUnwrap() {
    PolyParent parent = Serialization.unmarshal("other: 1\nname: x", PolyParent.class);
    assertEquals("x", ((Named) parent.poly).name);

    // should be null if it can't be deduced
    parent = Serialization.unmarshal("other: 1", PolyParent.class);
    assertThat(parent.poly).isNull();
  }

  @Test
  void unmarshal_podWithYYYYMMDDAnnotation_shouldNotConvertToDate() {
    // Given
    InputStream inputStream = getClass().getResourceAsStream("/serialization/test-pod-manifest-dateformat-annotation.yml");

    // When
    Pod pod = Serialization.unmarshal(inputStream);

    // Then
    assertThat(pod)
        .isNotNull()
        .hasFieldOrPropertyWithValue("spec.shareProcessNamespace", false)
        .hasFieldOrPropertyWithValue("spec.terminationGracePeriodSeconds", 2L)
        .extracting(Pod::getMetadata)
        .extracting(ObjectMeta::getAnnotations)
        .isEqualTo(Collections.singletonMap("report_date", "2020-01-01"));
  }

  @Test
  void unmarshal_leaseWithTypedValues_ShouldConvertToTypedFields() {
    // Given
    InputStream inputStream = getClass().getResourceAsStream("/serialization/test-lease-manifest-typed-fields.yml");

    // When
    Lease lease = Serialization.unmarshal(inputStream);

    // Then
    assertThat(lease)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.annotations",
            Collections.singletonMap("creationTimestamp", "2022-07-22T10:42:02Z"))
        .hasFieldOrPropertyWithValue("spec.leaseDurationSeconds", 2)
        .hasFieldOrPropertyWithValue("spec.leaseTransitions", 3)
        .extracting(Lease::getSpec)
        .extracting(LeaseSpec::getAcquireTime)
        .isInstanceOf(ZonedDateTime.class);
  }

  @Test
  void unmarshal_configMapWithBoolAndDateData_shouldBeDeserializedAsString() {
    // Given
    InputStream inputStream = getClass().getResourceAsStream("/serialization/test-configmap-manifest-bool-dateformat.yml");

    // When
    ConfigMap configMap = Serialization.unmarshal(inputStream);

    // Then
    assertThat(configMap)
        .isNotNull()
        .extracting(ConfigMap::getData)
        .asInstanceOf(InstanceOfAssertFactories.MAP)
        .containsEntry("bool", "NO")
        .containsEntry("date", "2022-07-22");
  }

  @Test
  void testArrayAsYaml() {
    // Given
    String[] value = new String[] { "x", "y" };

    // When
    String yaml = Serialization.asYaml(value);

    // Then
    assertThat(yaml).isEqualTo("---\n"
        + "- \"x\"\n"
        + "- \"y\"\n");
  }

  @Test
  void testAnyTypeSerialization() {
    // Given
    AnyType value = new AnyType("x");

    // When
    String yaml = Serialization.asYaml(value);

    // Then
    assertThat(yaml).isEqualTo("--- \"x\"\n");
  }

  @Test
  void testAnyTypeDeserialization() {
    // Given
    String yaml = "x: 1";
    HashMap<String, Object> map = new HashMap<>();
    map.put("x", 1);

    // When
    AnyType type = Serialization.unmarshal(yaml, AnyType.class);

    // Then
    assertThat(type.getValue()).isEqualTo(map);
  }

}
