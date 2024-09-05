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
package io.fabric8.kubernetes.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class KubernetesDeserializerForListTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
  }

  @Test
  void invalid() {
    assertThatExceptionOfType(JsonProcessingException.class)
        .isThrownBy(() -> mapper.readValue("{\"aList\":{}, \"aListWithRaw\": {}}", ListWrapperForList.class))
        .withMessageContaining("Expected array but found OBJECT");
  }

  @Nested
  class AsKubernetesResource {

    private ListWrapperForKubernetesResource listWrapper;

    @BeforeEach
    void setUp() throws IOException {
      listWrapper = mapper.readValue(Helper.loadJson("/kubernetes-deserializer-for-list.json"),
          ListWrapperForKubernetesResource.class);
    }

    @Test
    void deserializesKubernetesList() {
      assertThat(listWrapper.aList).isInstanceOf(KubernetesList.class);
    }

    @Test
    void deserializesPod() {
      assertThat(listWrapper.aList)
          .asInstanceOf(InstanceOfAssertFactories.type(KubernetesList.class))
          .extracting(KubernetesList::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(KubernetesResource.class))
          .element(0)
          .isInstanceOf(Pod.class)
          .hasFieldOrPropertyWithValue("metadata.name", "pod");
    }

    @Test
    void deserializesGeneric() {
      assertThat(listWrapper.aList)
          .asInstanceOf(InstanceOfAssertFactories.type(KubernetesList.class))
          .extracting(KubernetesList::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(KubernetesResource.class))
          .element(1)
          .isInstanceOf(GenericKubernetesResource.class)
          .hasFieldOrPropertyWithValue("kind", "Generic")
          .hasFieldOrPropertyWithValue("apiVersion", "generic.example.com")
          .hasFieldOrPropertyWithValue("metadata.name", "generic");
    }
  }

  @Nested
  class AsList {

    private ListWrapperForList listWrapper;

    @BeforeEach
    void setUp() throws IOException {
      listWrapper = mapper.readValue(Helper.loadJson("/kubernetes-deserializer-for-list.json"), ListWrapperForList.class);
    }

    @Test
    void deserializesPod() {
      assertThat(listWrapper.aList)
          .element(0)
          .isInstanceOf(Pod.class)
          .hasFieldOrPropertyWithValue("metadata.name", "pod");
    }

    @Test
    void deserializesGeneric() {
      assertThat(listWrapper.aList)
          .element(1)
          .isInstanceOf(GenericKubernetesResource.class)
          .hasFieldOrPropertyWithValue("kind", "Generic")
          .hasFieldOrPropertyWithValue("apiVersion", "generic.example.com")
          .hasFieldOrPropertyWithValue("metadata.name", "generic");
    }

    @Test
    void deserializesRaw() {
      assertThat(listWrapper.aListWithRaw)
          .element(0)
          .isInstanceOf(RawExtension.class)
          .hasFieldOrPropertyWithValue("value.name", "raw-extension");
    }

    @Test
    void deserializesNestedPod() {
      assertThat(listWrapper.aListWithRaw)
          .element(1)
          .asInstanceOf(InstanceOfAssertFactories.type(KubernetesList.class))
          .extracting(KubernetesList::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(KubernetesResource.class))
          .element(0)
          .isInstanceOf(Pod.class)
          .hasFieldOrPropertyWithValue("metadata.name", "nested-pod");
    }

  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  private static final class ListWrapperForKubernetesResource {
    @JsonDeserialize(using = KubernetesDeserializer.class)
    public KubernetesResource aList;
  }

  private static final class ListWrapperForList {
    @JsonDeserialize(using = KubernetesDeserializerForList.class)
    public List<KubernetesResource> aList;
    @JsonDeserialize(using = KubernetesDeserializerForList.class)
    public List<KubernetesResource> aListWithRaw;
  }
}
