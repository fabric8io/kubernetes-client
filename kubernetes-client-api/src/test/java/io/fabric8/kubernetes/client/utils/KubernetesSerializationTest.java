/*
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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.fabric8.kubernetes.model.jackson.UnmatchedFieldTypeModule;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KubernetesSerializationTest {

  private KubernetesSerialization kubernetesSerialization;

  @Nested
  @DisplayName("with searchClassloaders=false")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  class NoSearchClassLoaders {

    @BeforeEach
    void setUp() {
      kubernetesSerialization = new KubernetesSerialization(JsonMapper.builder().build(), false);
    }

    @Test
    void shouldDeserializeToGeneric() {
      assertThat(kubernetesSerialization.<Object> unmarshal("{\"kind\":\"Pod\", \"apiVersion\":\"v1\"}"))
          .isNotInstanceOf(io.fabric8.kubernetes.api.model.Pod.class)
          .isInstanceOf(GenericKubernetesResource.class);
    }

    @Test
    void withRegisteredKubernetesResourceShouldDeserializeToPod() {
      kubernetesSerialization.registerKubernetesResource(io.fabric8.kubernetes.api.model.Pod.class);
      assertThat(kubernetesSerialization.<Object> unmarshal("{\"kind\":\"Pod\", \"apiVersion\":\"v1\"}"))
          .isInstanceOf(io.fabric8.kubernetes.api.model.Pod.class);
    }

    @ParameterizedTest(name = "{index}: {0} {1} deserializes to {2}")
    @MethodSource("sameGVK")
    void withCollidingRegisteredKubernetesResourceShouldDeserializeAppropriate(
        String apiVersion, String kind, Class<?> expectedClass) {
      kubernetesSerialization.registerKubernetesResource(KubernetesSerializationTest.Pod.class);
      kubernetesSerialization.registerKubernetesResource(io.fabric8.kubernetes.api.model.Pod.class);
      assertThat(kubernetesSerialization.<Object> unmarshal(
          "{\"kind\":\"" + kind + "\", \"apiVersion\":\"" + apiVersion + "\"}"))
          .isInstanceOf(expectedClass);
    }

    private Stream<Arguments> sameGVK() {
      return Stream.of(
          Arguments.of("v1", "Pod", io.fabric8.kubernetes.api.model.Pod.class),
          Arguments.of("v2", "Pod", GenericKubernetesResource.class),
          Arguments.of("custom.core.kubernetes.io/v1", "Pod", KubernetesSerializationTest.Pod.class),
          Arguments.of("custom.core.kubernetes.io/v2", "Pod", GenericKubernetesResource.class),
          Arguments.of("customs.core.kubernetes.io/v1", "Pod", GenericKubernetesResource.class),
          Arguments.of("custom.core.kubernetes.io/v1", "Pods", GenericKubernetesResource.class));
    }
  }

  @Nested
  class AsYaml {

    private CustomResourceDefinition inputResource;

    @BeforeEach
    void loadYamlAsString() throws IOException {
      try (var is = KubernetesSerializationTest.class.getResourceAsStream("/serialization/test-crd-schema.yml")) {
        inputResource = Serialization.unmarshal(new String(is.readAllBytes()), CustomResourceDefinition.class);
      }
    }

    @Test
    void asYamlWithDefaults() {
      assertThat(new KubernetesSerialization().asYaml(inputResource))
          .contains("\"widgets.test.fabric8.io\"");
    }

    @Test
    void asYamlWithDefaultYamlDumpSettings() {
      kubernetesSerialization = new KubernetesSerialization(JsonMapper.builder().build(), true,
          new YamlDumpSettingsBuilder().build());
      assertThat(kubernetesSerialization.asYaml(inputResource))
          .contains("\"widgets.test.fabric8.io\"");
    }

    @Test
    void asYamlWithDefaultYamlDumpSettingsMinimizeQuotes() {
      kubernetesSerialization = new KubernetesSerialization(JsonMapper.builder().build(), true,
          new YamlDumpSettingsBuilder().setMinimizeQuotes(true).build());
      assertThat(kubernetesSerialization.asYaml(inputResource))
          .contains("widgets.test.fabric8.io");
    }

  }

  @Nested
  @DisplayName("default instance, with user types, keeps the Jackson 2 behavior")
  class DefaultInstanceUserTypes {

    @BeforeEach
    void setUp() {
      kubernetesSerialization = new KubernetesSerialization();
    }

    @Test
    @DisplayName("asJson, serializes properties in declaration order")
    void asJsonKeepsDeclarationOrder() {
      final UserSpec spec = new UserSpec();
      spec.setZeta("z");
      spec.setAlpha("a");
      assertThat(kubernetesSerialization.asJson(spec))
          .isEqualTo("{\"zeta\":\"z\",\"replicas\":0,\"items\":[],\"alpha\":\"a\"}");
    }

    @Test
    @DisplayName("asJson, serializes enums by name, ignoring toString")
    void asJsonSerializesEnumName() {
      final UserSpec spec = new UserSpec();
      spec.setPhase(Phase.RUNNING);
      assertThat(kubernetesSerialization.asJson(spec)).contains("\"phase\":\"RUNNING\"");
    }

    @Test
    @DisplayName("unmarshal, deserializes enums by name, ignoring toString")
    void unmarshalDeserializesEnumName() {
      assertThat(kubernetesSerialization.unmarshal("{\"phase\":\"RUNNING\"}", UserSpec.class))
          .extracting(UserSpec::getPhase)
          .isEqualTo(Phase.RUNNING);
    }

    @Test
    @DisplayName("unmarshal, with null for a primitive, uses the primitive default")
    void unmarshalNullPrimitive() {
      assertThat(kubernetesSerialization.unmarshal("{\"replicas\":null}", UserSpec.class))
          .extracting(UserSpec::getReplicas)
          .isEqualTo(0);
    }

    @Test
    @DisplayName("unmarshal, with getter-only collection, populates it")
    void unmarshalGetterOnlyCollection() {
      assertThat(kubernetesSerialization.unmarshal("{\"items\":[\"a\",\"b\"]}", UserSpec.class))
          .extracting(UserSpec::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(String.class))
          .containsExactly("a", "b");
    }
  }

  @Nested
  @DisplayName("Jackson failures")
  class JacksonFailures {

    @BeforeEach
    void setUp() {
      kubernetesSerialization = new KubernetesSerialization();
    }

    @Test
    @DisplayName("asJson, with unserializable object, throws KubernetesClientException")
    void asJsonThrowsKubernetesClientException() {
      final SelfReferencing selfReferencing = new SelfReferencing();
      assertThatThrownBy(() -> kubernetesSerialization.asJson(selfReferencing))
          .isInstanceOf(KubernetesClientException.class)
          .hasCauseInstanceOf(JacksonException.class);
    }

    @Test
    @DisplayName("mergePatch, with invalid patch, throws KubernetesClientException")
    void mergePatchThrowsKubernetesClientException() {
      final UserSpec spec = new UserSpec();
      assertThatThrownBy(() -> kubernetesSerialization.mergePatch(spec, "{"))
          .isInstanceOf(KubernetesClientException.class)
          .hasCauseInstanceOf(JacksonException.class);
    }

    @Test
    @DisplayName("convertValue, with incompatible type, throws IllegalArgumentException")
    void convertValueThrowsIllegalArgumentException() {
      assertThatThrownBy(() -> kubernetesSerialization.convertValue("not-a-number", Integer.class))
          .isInstanceOf(IllegalArgumentException.class)
          .hasCauseInstanceOf(JacksonException.class);
    }
  }

  @Test
  @DisplayName("constructor, with provided mapper, configures a copy and leaves the provided mapper untouched")
  void constructorDoesNotModifyProvidedMapper() {
    final ObjectMapper mapper = JsonMapper.builder().build();
    new KubernetesSerialization(mapper, false);
    assertThat(mapper.registeredModules())
        .noneMatch(UnmatchedFieldTypeModule.class::isInstance);
  }

  public enum Phase {
    RUNNING;

    @Override
    public String toString() {
      return "running";
    }
  }

  public static class UserSpec {
    private String zeta;
    private int replicas;
    private Phase phase;
    private final List<String> items = new ArrayList<>();
    private String alpha;

    public String getZeta() {
      return zeta;
    }

    public void setZeta(String zeta) {
      this.zeta = zeta;
    }

    public int getReplicas() {
      return replicas;
    }

    public void setReplicas(int replicas) {
      this.replicas = replicas;
    }

    public Phase getPhase() {
      return phase;
    }

    public void setPhase(Phase phase) {
      this.phase = phase;
    }

    public List<String> getItems() {
      return items;
    }

    public String getAlpha() {
      return alpha;
    }

    public void setAlpha(String alpha) {
      this.alpha = alpha;
    }
  }

  public static class SelfReferencing {
    public SelfReferencing getSelf() {
      return this;
    }
  }

  @Version("v1")
  @Group("custom.core.kubernetes.io")
  @JsonDeserialize(using = ValueDeserializer.None.class)
  public static class Pod implements HasMetadata {

    @JsonProperty("apiVersion")
    private String apiVersion = "custom.core.kubernetes.io/v1";
    @JsonProperty("kind")
    private String kind = "Pod";

    @Override
    public ObjectMeta getMetadata() {
      return null;
    }

    @Override
    public void setMetadata(ObjectMeta metadata) {

    }

    @Override
    public void setApiVersion(String version) {

    }
  }
}
