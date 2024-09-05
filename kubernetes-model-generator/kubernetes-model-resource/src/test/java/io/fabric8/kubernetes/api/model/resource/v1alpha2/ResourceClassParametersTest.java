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
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceBuilder;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.model.util.Helper;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ResourceClassParametersTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isNamespaceScoped() {
    assertThat(Namespaced.class.isAssignableFrom(ResourceClassParameters.class)).isTrue();
  }

  @Test
  void apiGroup() {
    assertThat(new ResourceClassParameters().getApiVersion()).isEqualTo("resource.k8s.io/v1alpha2");
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    final String originalJson = Helper.loadJson("/valid-resourceclassparameters.json");

    // When
    final ResourceClassParameters resourceClassParameters = mapper.readValue(originalJson, ResourceClassParameters.class);
    final String serializedJson = mapper.writeValueAsString(resourceClassParameters);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(resourceClassParameters)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("generatedFrom.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("generatedFrom.kind", "kindValue")
        .hasFieldOrPropertyWithValue("generatedFrom.name", "nameValue")
        .satisfies(r -> assertThat(r.getVendorParameters())
            .asInstanceOf(InstanceOfAssertFactories.LIST)
            .singleElement(InstanceOfAssertFactories.type(VendorParameters.class))
            .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
            .hasFieldOrPropertyWithValue("parameters.apiVersion", "example.com/v1")
            .hasFieldOrPropertyWithValue("parameters.kind", "CustomType")
            .hasFieldOrPropertyWithValue("parameters.additionalProperties.spec.replicas", 1)
            .hasFieldOrPropertyWithValue("parameters.additionalProperties.status.available", 1))
        .satisfies(r -> assertThat(r.getFilters())
            .asInstanceOf(InstanceOfAssertFactories.LIST)
            .singleElement(InstanceOfAssertFactories.type(ResourceFilter.class))
            .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
            .hasFieldOrPropertyWithValue("namedResources.selector", "selectorValue"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ResourceClassParametersBuilder ResourceClassParametersBuilder = new ResourceClassParametersBuilder()
        .withNewMetadata().withName("nameValue").endMetadata()
        .withNewGeneratedFrom()
        .withApiGroup("apiGroupValue")
        .withKind("kindValue")
        .withName("nameValue")
        .endGeneratedFrom()
        .addNewVendorParameter()
        .withDriverName("driverNameValue")
        .withParameters(new GenericKubernetesResourceBuilder()
            .withApiVersion("example.com/v1")
            .withKind("CustomType")
            .addToAdditionalProperties("spec", Collections.singletonMap("replicas", 1))
            .addToAdditionalProperties("status", Collections.singletonMap("available", 1))
            .build())
        .endVendorParameter()
        .addNewFilter()
        .withDriverName("driverNameValue")
        .withNewNamedResources("selectorValue")
        .endFilter();

    // When
    ResourceClassParameters resourceClassParameters = ResourceClassParametersBuilder.build();

    // Then
    assertThat(resourceClassParameters)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("generatedFrom.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("generatedFrom.kind", "kindValue")
        .hasFieldOrPropertyWithValue("generatedFrom.name", "nameValue")
        .satisfies(r -> assertThat(r.getVendorParameters())
            .asInstanceOf(InstanceOfAssertFactories.LIST)
            .singleElement(InstanceOfAssertFactories.type(VendorParameters.class))
            .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
            .hasFieldOrPropertyWithValue("parameters.apiVersion", "example.com/v1")
            .hasFieldOrPropertyWithValue("parameters.kind", "CustomType")
            .hasFieldOrPropertyWithValue("parameters.additionalProperties.spec.replicas", 1)
            .hasFieldOrPropertyWithValue("parameters.additionalProperties.status.available", 1))
        .satisfies(r -> assertThat(r.getFilters())
            .asInstanceOf(InstanceOfAssertFactories.LIST)
            .singleElement(InstanceOfAssertFactories.type(ResourceFilter.class))
            .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
            .hasFieldOrPropertyWithValue("namedResources.selector", "selectorValue"));
  }
}
