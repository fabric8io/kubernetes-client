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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WatchEventTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
  }

  @Nested
  class Deserialization {

    private List<WatchEvent> watchEvents;

    @BeforeEach
    void setUp() throws IOException {
      watchEvents = mapper.readValue(Helper.loadJson("/watch-events.json"), new TypeReference<List<WatchEvent>>() {
      });
    }

    @Test
    void deserializesRegularFields() {
      assertThat(watchEvents)
          .extracting("type")
          .containsOnly("ADDED", "MODIFIED", "DELETED", "ERROR", "BOOKMARK");
    }

    @Test
    void deserializesNull() {
      assertThat(watchEvents)
          .element(0)
          .extracting(WatchEvent::getObject)
          .isNull();
    }

    @Test
    void deserializesPod() {
      assertThat(watchEvents)
          .element(1)
          .extracting(WatchEvent::getObject)
          .isInstanceOf(Pod.class)
          .hasFieldOrPropertyWithValue("metadata.name", "pod-modified");
    }

    @Test
    void deserializesGenericKubernetesResource() {
      assertThat(watchEvents)
          .element(2)
          .extracting(WatchEvent::getObject)
          .isInstanceOf(GenericKubernetesResource.class)
          .hasFieldOrPropertyWithValue("kind", "UnknownKind")
          .hasFieldOrPropertyWithValue("apiVersion", "unknown.example.com/v1")
          .hasFieldOrPropertyWithValue("metadata.name", "generic-deleted");
    }

    @Test
    void deserializesRaw() {
      assertThat(watchEvents)
          .element(3)
          .extracting(WatchEvent::getObject)
          .isInstanceOf(RawExtension.class)
          .hasFieldOrPropertyWithValue("value.name", "raw-error");
    }

    @Test
    void deserializesPrimitiveString() {
      assertThat(watchEvents)
          .element(4)
          .extracting(WatchEvent::getObject)
          .asInstanceOf(InstanceOfAssertFactories.type(RawExtension.class))
          .extracting(AnyType::getValue)
          .isEqualTo("primitive-string-bookmark");
    }

    @Test
    void deserializesPrimitiveInt() {
      assertThat(watchEvents)
          .element(5)
          .extracting(WatchEvent::getObject)
          .asInstanceOf(InstanceOfAssertFactories.type(RawExtension.class))
          .extracting(AnyType::getValue)
          .isEqualTo(1337);
    }
  }

  @Nested
  class Builder {

    @Test
    void shouldBuildWatchEvent() {
      final WatchEvent result = new WatchEventBuilder()
          .withType("ADDED")
          .withObject(new PodBuilder().withNewMetadata().withName("pod").endMetadata().build())
          .build();
      assertThat(result)
          .hasFieldOrPropertyWithValue("type", "ADDED")
          .extracting(WatchEvent::getObject)
          .isInstanceOf(Pod.class)
          .hasFieldOrPropertyWithValue("metadata.name", "pod");

    }

    @Test
    // We need to ensure that Sundrio won't generate withNewXxx methods for the raw typed object field
    void doesNotContainWithNew() {
      assertThat(WatchEventBuilder.class.getMethods())
          .filteredOn(method -> method.getName().startsWith("with"))
          .extracting(Method::getName)
          .containsExactlyInAnyOrder("withObject", "withType", "withAdditionalProperties");
    }
  }
}
