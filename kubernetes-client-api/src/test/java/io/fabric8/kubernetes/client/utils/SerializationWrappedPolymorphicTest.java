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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SerializationWrappedPolymorphicTest {

  @Group("example.com")
  @Version("v1alpha1")
  static class TestCR extends CustomResource<TestCR.TestCRSpec, Void> implements Namespaced {

    @JsonDeserialize(using = JsonDeserializer.None.class)
    static class TestCRSpec implements KubernetesResource {

      @JsonIgnore
      private final Map<String, Object> additionalProperties = new HashMap<>();

      private List<Child> children = new ArrayList<>();

      public List<Child> getChildren() {
        return children;
      }

      public void setChildren(List<Child> children) {
        this.children = children;
      }

      @JsonAnyGetter
      public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
      }

      @JsonAnySetter
      public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
      }
    }

    @Override
    protected TestCRSpec initSpec() {
      return new TestCRSpec();
    }
  }

  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
  @JsonSubTypes({ //
      @JsonSubTypes.Type(FooChild.class), //
      @JsonSubTypes.Type(BarChild.class), //
  })
  @JsonDeserialize(using = JsonDeserializer.None.class)
  interface Child extends KubernetesResource {
  }

  @JsonTypeName("foo")
  @Data
  static class FooChild implements Child {
    private String name;
  }

  @JsonTypeName("bar")
  @Data
  static class BarChild implements Child {
    private String file;
  }

  @Test
  void testPolyRoundTrip() {
    TestCR original = new TestCR();
    FooChild foo = new FooChild();
    foo.setName("alice");
    BarChild bar = new BarChild();
    bar.setFile("bob");
    original.getSpec().setChildren(Arrays.asList(foo, bar));
    String json = Serialization.asJson(original);
    assertThat(json).isEqualTo(
        "{\"apiVersion\":\"example.com/v1alpha1\",\"kind\":\"TestCR\",\"metadata\":{},\"spec\":{\"children\":[{\"foo\":{\"name\":\"alice\"}},{\"bar\":{\"file\":\"bob\"}}]}}");
    TestCR deserialized = Serialization.unmarshal(json, TestCR.class);
    assertEquals(deserialized.getSpec().getChildren(), original.getSpec().getChildren());
  }

}
