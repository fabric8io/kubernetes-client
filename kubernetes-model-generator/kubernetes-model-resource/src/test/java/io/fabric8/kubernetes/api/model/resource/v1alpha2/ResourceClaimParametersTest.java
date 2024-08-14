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
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ResourceClaimParametersTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isNamespaceScoped() {
    assertThat(Namespaced.class.isAssignableFrom(ResourceClaimParameters.class)).isTrue();
  }

  @Test
  void apiGroup() {
    assertThat(new ResourceClaimParameters().getApiVersion()).isEqualTo("resource.k8s.io/v1alpha2");
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(
        ResourceClaimParametersTest.class.getResourceAsStream("/valid-resourceclaimparameters.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ResourceClaimParameters resourceClaimParameters = mapper.readValue(originalJson, ResourceClaimParameters.class);
    final String serializedJson = mapper.writeValueAsString(resourceClaimParameters);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(resourceClaimParameters)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("generatedFrom.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("generatedFrom.kind", "kindValue")
        .hasFieldOrPropertyWithValue("generatedFrom.name", "nameValue")
        .hasFieldOrPropertyWithValue("shareable", true)
        .extracting("driverRequests")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(DriverRequests.class))
        .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
        .hasFieldOrPropertyWithValue("vendorParameters.apiVersion", "example.com/v1")
        .hasFieldOrPropertyWithValue("vendorParameters.kind", "CustomType")
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.spec.replicas", 1)
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.status.available", 1)
        .extracting("requests")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(ResourceRequest.class))
        .hasFieldOrPropertyWithValue("vendorParameters.apiVersion", "example.com/v1")
        .hasFieldOrPropertyWithValue("vendorParameters.kind", "CustomType")
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.spec.replicas", 1)
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.status.available", 1)
        .hasFieldOrPropertyWithValue("namedResources.selector", "selectorValue");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ResourceClaimParametersBuilder ResourceClaimParametersBuilder = new ResourceClaimParametersBuilder()
        .withNewMetadata().withName("nameValue").endMetadata()
        .withNewGeneratedFrom()
        .withApiGroup("apiGroupValue")
        .withKind("kindValue")
        .withName("nameValue")
        .endGeneratedFrom()
        .withShareable()
        .addNewDriverRequest()
        .withDriverName("driverNameValue")
        .withVendorParameters(new GenericKubernetesResourceBuilder()
            .withApiVersion("example.com/v1")
            .withKind("CustomType")
            .addToAdditionalProperties("spec", Collections.singletonMap("replicas", 1))
            .addToAdditionalProperties("status", Collections.singletonMap("available", 1))
            .build())
        .addNewRequest()
        .withNewNamedResources("selectorValue")
        .withVendorParameters(new GenericKubernetesResourceBuilder()
            .withApiVersion("example.com/v1")
            .withKind("CustomType")
            .addToAdditionalProperties("spec", Collections.singletonMap("replicas", 1))
            .addToAdditionalProperties("status", Collections.singletonMap("available", 1))
            .build())
        .endRequest()
        .endDriverRequest();

    // When
    ResourceClaimParameters resourceClaimParameters = ResourceClaimParametersBuilder.build();

    // Then
    assertThat(resourceClaimParameters)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "nameValue")
        .hasFieldOrPropertyWithValue("generatedFrom.apiGroup", "apiGroupValue")
        .hasFieldOrPropertyWithValue("generatedFrom.kind", "kindValue")
        .hasFieldOrPropertyWithValue("generatedFrom.name", "nameValue")
        .hasFieldOrPropertyWithValue("shareable", true)
        .extracting("driverRequests")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(DriverRequests.class))
        .hasFieldOrPropertyWithValue("driverName", "driverNameValue")
        .hasFieldOrPropertyWithValue("vendorParameters.apiVersion", "example.com/v1")
        .hasFieldOrPropertyWithValue("vendorParameters.kind", "CustomType")
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.spec.replicas", 1)
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.status.available", 1)
        .extracting("requests")
        .asInstanceOf(InstanceOfAssertFactories.LIST)
        .singleElement(InstanceOfAssertFactories.type(ResourceRequest.class))
        .hasFieldOrPropertyWithValue("vendorParameters.apiVersion", "example.com/v1")
        .hasFieldOrPropertyWithValue("vendorParameters.kind", "CustomType")
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.spec.replicas", 1)
        .hasFieldOrPropertyWithValue("vendorParameters.additionalProperties.status.available", 1)
        .hasFieldOrPropertyWithValue("namedResources.selector", "selectorValue");
  }
}
