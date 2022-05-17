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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HasMetadataOperationsImplTest {

  @Test
  void shouldBeAbleToReturnOperationsWithoutSpecificList() {
    final MixedOperation<Bar, BarList, Resource<Bar>> operation = new DefaultKubernetesClient().resources(Bar.class,
        BarList.class);
    assertNotNull(operation);
  }

  @Test
  void shouldReturnGenericKubernetesResourceWhenNotRegistered() {
    // When
    final KubernetesResource resource = Serialization.unmarshal("{\n" +
        "    \"apiVersion\": \"sample.fabric8.io/v1\",\n" +
        "    \"kind\": \"Bar\"\n" +
        "}");
    // Then
    assertThat(resource)
        .isInstanceOf(GenericKubernetesResource.class)
        .hasFieldOrPropertyWithValue("apiVersion", "sample.fabric8.io/v1");
  }

  @DisplayName("HasMetadataOperationsImpl registers custom kind")
  @ParameterizedTest(name = "{index}: {1}")
  @MethodSource("registerCustomKindInput")
  void hasMetadataOperationsImplRegistersCustomKind(
      String description,
      ResourceDefinitionContext resourceDefinitionContext,
      Class<? extends CustomResource<?, ?>> resourceClazz,
      Class<? extends CustomResourceList<?>> resourceListClazz) {
    // Given
    new HasMetadataOperationsImpl(
        new OperationContext(),
        resourceDefinitionContext,
        resourceClazz,
        resourceListClazz);
    // When
    final KubernetesResource resource = Serialization.unmarshal("{\n" +
        "    \"apiVersion\": \"custom.group/v1alpha1\",\n" +
        "    \"kind\": \"MyCustomResource\"\n" +
        "}");
    // Then
    assertThat(resource)
        .isInstanceOf(MyCustomResource.class)
        .hasFieldOrPropertyWithValue("apiVersion", "custom.group/v1alpha1");
  }

  static Stream<Arguments> registerCustomKindInput() {
    final CustomResourceDefinition myCustomResourceCrd = CustomResourceDefinitionContext
        .v1beta1CRDFromCustomResourceType(MyCustomResource.class).build();
    return Stream.of(
        Arguments.arguments(
            "with typed custom resource and list",
            CustomResourceDefinitionContext.fromCrd(myCustomResourceCrd),
            MyCustomResource.class,
            MyCustomResourceList.class),
        Arguments.arguments(
            "with typed custom resource and generic list",
            CustomResourceDefinitionContext.fromCrd(myCustomResourceCrd),
            MyCustomResource.class,
            CustomResourceList.class),
        Arguments.arguments(
            "with manual ResourceDefinitionContext",
            new ResourceDefinitionContext.Builder()
                .withGroup("custom.group")
                .withVersion("v1alpha1")
                .withPlural("mycustomresources")
                .build(),
            MyCustomResource.class,
            MyCustomResourceList.class));
  }

  @Group(MyCustomResource.GROUP)
  @Version(MyCustomResource.VERSION)
  public static class MyCustomResource extends CustomResource<Object, Object> {
    public static final String GROUP = "custom.group";
    public static final String VERSION = "v1alpha1";
  }

  public static class MyCustomResourceList extends CustomResourceList<MyCustomResource> {
  }

  @Group("sample.fabric8.io")
  @Version("v1")
  public static class Bar extends CustomResource<Object, Object> {
  }

  public static class BarList extends CustomResourceList<Bar> {
  }
}
