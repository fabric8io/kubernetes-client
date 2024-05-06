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
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.Quantity;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ResourceSliceTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(ResourceSlice.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void apiGroup() {
    assertThat(new ResourceSlice().getApiVersion()).isEqualTo("resource.k8s.io/v1alpha2");
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-resourceslice.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ResourceSlice resourceSlice = mapper.readValue(originalJson, ResourceSlice.class);
    final String serializedJson = mapper.writeValueAsString(resourceSlice);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(resourceSlice)
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("nodeName", "nodeNameValue")
        .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
        .extracting("namedResources.instances")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(NamedResourcesInstance.class))
        .hasFieldOrPropertyWithValue("name", "nameValue")
        .extracting("attributes")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(NamedResourcesAttribute.class))
        .hasFieldOrPropertyWithValue("quantity", new Quantity("0"))
        .hasFieldOrPropertyWithValue("name", "nameValue")
        .hasFieldOrPropertyWithValue("bool", true)
        .hasFieldOrPropertyWithValue("int", 7L)
        .hasFieldOrPropertyWithValue("intSlice", new NamedResourcesIntSliceBuilder().withInts(1L).build())
        .hasFieldOrPropertyWithValue("stringSlice", new NamedResourcesStringSliceBuilder().withStrings("stringsValue").build())
        .hasFieldOrPropertyWithValue("string", "stringValue")
        .hasFieldOrPropertyWithValue("version", "versionValue");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ResourceSliceBuilder resourceSliceBuilder = new ResourceSliceBuilder()
        .withNewMetadata().withName("nameValue").endMetadata()
        .withNodeName("nodeNameValue")
        .withDriverName("driverNameValue")
        .withNewNamedResources()
        .addNewInstance()
        .withName("nameValue")
        .addNewAttribute()
        .withName("nameValue")
        .withQuantity(new Quantity("0"))
        .withBool()
        .withInt(7L)
        .withNewIntSlice()
        .withInts(1L)
        .endIntSlice()
        .withString("stringValue")
        .withNewStringSlice()
        .withStrings("stringsValue")
        .endStringSlice()
        .withVersion("versionValue")
        .endAttribute()
        .endInstance()
        .endNamedResources();

    // When
    ResourceSlice resourceSlice = resourceSliceBuilder.build();

    // Then
    assertThat(resourceSlice)
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("nodeName", "nodeNameValue")
        .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
        .extracting("namedResources.instances")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(NamedResourcesInstance.class))
        .hasFieldOrPropertyWithValue("name", "nameValue")
        .extracting("attributes")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(NamedResourcesAttribute.class))
        .hasFieldOrPropertyWithValue("quantity", new Quantity("0"))
        .hasFieldOrPropertyWithValue("name", "nameValue")
        .hasFieldOrPropertyWithValue("bool", true)
        .hasFieldOrPropertyWithValue("int", 7L)
        .hasFieldOrPropertyWithValue("intSlice", new NamedResourcesIntSliceBuilder().withInts(1L).build())
        .hasFieldOrPropertyWithValue("stringSlice", new NamedResourcesStringSliceBuilder().withStrings("stringsValue").build())
        .hasFieldOrPropertyWithValue("string", "stringValue")
        .hasFieldOrPropertyWithValue("version", "versionValue");

  }
}
