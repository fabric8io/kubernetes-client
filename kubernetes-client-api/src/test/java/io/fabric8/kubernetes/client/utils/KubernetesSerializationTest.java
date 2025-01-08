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
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesSerializationTest {

  private KubernetesSerialization kubernetesSerialization;

  @Nested
  @DisplayName("with searchClassloaders=false")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  class NoSearchClassLoaders {

    @BeforeEach
    void setUp() {
      kubernetesSerialization = new KubernetesSerialization(new ObjectMapper(), false);
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

    @Test
    void asYaml() throws Exception {
      final String input = readYamlToString("/serialization/test-crd-schema.yml");
      final CustomResourceDefinition crd = Serialization.unmarshal(input, CustomResourceDefinition.class);

      String result = kubernetesSerialization.asYaml(crd);
      assertThat(result).asString().contains("\"widgets.test.fabric8.io\"");

      result = kubernetesSerialization.asYaml(crd, false);
      assertThat(result).asString().contains("\"widgets.test.fabric8.io\"");

      result = kubernetesSerialization.asYaml(crd, true);
      assertThat(result).asString().doesNotContain("\"widgets.test.fabric8.io\"");
      assertThat(result).asString().contains("widgets.test.fabric8.io");
    }

    private String readYamlToString(String path) throws IOException {
      return Files.readAllLines(
          new File(KubernetesSerializationTest.class.getResource(path).getFile()).toPath(), StandardCharsets.UTF_8)
          .stream()
          .filter(line -> !line.startsWith("#"))
          .collect(Collectors.joining("\n"));
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

  @Version("v1")
  @Group("custom.core.kubernetes.io")
  @JsonDeserialize(using = JsonDeserializer.None.class)
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
