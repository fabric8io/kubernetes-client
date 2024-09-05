
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.tuple;

public class KubernetesDeserializerForMapTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
  }

  @Test
  void invalid() {
    assertThatExceptionOfType(JsonProcessingException.class)
        .isThrownBy(() -> mapper.readValue("{\"aMap\":[]}", MapWrapper.class))
        .withMessageContaining("Expected map but found ARRAY");
  }

  @Nested
  class AsMap {

    private MapWrapper mapWrapper;

    @BeforeEach
    void setUp() throws IOException {
      mapWrapper = mapper.readValue(Helper.loadJson("/kubernetes-deserializer-for-map.json"), MapWrapper.class);
    }

    @Test
    void deserializesList() {
      assertThat(mapWrapper.aMap)
          .extracting("aList")
          .asInstanceOf(InstanceOfAssertFactories.type(KubernetesList.class))
          .extracting(KubernetesList::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(HasMetadata.class))
          .extracting("class", "metadata.name")
          .contains(
              tuple(Pod.class, "pod-in-list"),
              tuple(GenericKubernetesResource.class, "generic-in-list"));
    }

    @Test
    void deserializesPod() {
      assertThat(mapWrapper.aMap)
          .extracting("aPod")
          .isInstanceOf(Pod.class)
          .hasFieldOrPropertyWithValue("metadata.name", "pod");
    }

    @Test
    void deserializesGeneric() {
      assertThat(mapWrapper.aMap)
          .extracting("aGeneric")
          .isInstanceOf(GenericKubernetesResource.class)
          .hasFieldOrPropertyWithValue("kind", "Generic")
          .hasFieldOrPropertyWithValue("apiVersion", "generic.example.com")
          .hasFieldOrPropertyWithValue("metadata.name", "generic");
    }

    @Test
    void deserializesRaw() {
      assertThat(mapWrapper.aMap)
          .extracting("aRaw")
          .isInstanceOf(RawExtension.class)
          .hasFieldOrPropertyWithValue("value.name", "raw-extension");
    }

  }

  private static final class MapWrapper {
    @JsonDeserialize(using = KubernetesDeserializerForMap.class)
    public Map<String, Object> aMap;
  }
}
