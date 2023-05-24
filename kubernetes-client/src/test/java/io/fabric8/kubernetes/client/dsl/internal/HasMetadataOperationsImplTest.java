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

import io.fabric8.kubernetes.api.model.DefaultKubernetesResourceList;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HasMetadataOperationsImplTest {

  @Test
  void shouldBeAbleToReturnOperationsWithoutSpecificList() {
    final MixedOperation<Bar, BarList, Resource<Bar>> operation = new KubernetesClientBuilder().build().resources(Bar.class,
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

  @Group("sample.fabric8.io")
  @Version("v1")
  public static class Bar extends CustomResource<Object, Object> {
  }

  public static class BarList extends DefaultKubernetesResourceList<Bar> {
  }
}
