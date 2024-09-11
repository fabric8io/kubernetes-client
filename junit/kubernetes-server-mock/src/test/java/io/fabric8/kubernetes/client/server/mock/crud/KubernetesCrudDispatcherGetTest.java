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
package io.fabric8.kubernetes.client.server.mock.crud;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.client.dsl.NonDeletingOperation;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class KubernetesCrudDispatcherGetTest extends KubernetesCrudDispatcherTestBase {

  @Nested
  class WithNoItems {

    @BeforeEach
    void clearItems() {
      client.resources(ConfigMap.class).delete();
    }

    @Test
    void singleItem() {
      assertThat(client.configMaps().withName("config-map-1").get()).isNull();
    }

    @Test
    @Disabled("#6220: Need to figure out a way to extract the singular from the plural form in URL")
    void multipleItems_shouldReturnListObjectWithCorrectKind() {
      // When
      final ConfigMapList result = client.configMaps().list();
      // Then
      assertThat(result)
          .hasFieldOrPropertyWithValue("kind", "ConfigMapList")
          .extracting(ConfigMapList::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(ConfigMap.class))
          .isEmpty();
    }

  }

  @Nested
  class WithValidItems {

    @BeforeEach
    void addConsistentItems() {
      for (int it = 0; it < 5; it++) {
        client.resource(new ConfigMapBuilder().withNewMetadata().withName("config-map-" + it).endMetadata().build())
            .createOr(NonDeletingOperation::update);
      }
    }

    @Test
    void singleItem() {
      assertThat(client.configMaps().withName("config-map-1").get())
          .isInstanceOf(ConfigMap.class);
    }

    @Test
    @Disabled("#6220: Need to figure out a way to extract the singular from the plural form in URL")
    void multipleItems_shouldReturnListObjectWithCorrectKind() {
      // When
      final ConfigMapList result = client.configMaps().list();
      // Then
      assertThat(result)
          .hasFieldOrPropertyWithValue("kind", "ConfigMapList")
          .extracting(ConfigMapList::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(ConfigMap.class))
          .extracting("kind")
          .containsOnly("ConfigMap");
    }
  }

  @Nested
  class WithInvalidItems {
    @BeforeEach
    void addInvalidItems() throws Exception {
      client.configMaps().resource(new ConfigMapBuilder()
          .withKind("NotConfigMap")
          .withNewMetadata().withName("NotConfigMap").endMetadata()
          .build())
          .create();
      for (int it = 0; it < 5; it++) {
        client.resource(new ConfigMapBuilder().withNewMetadata().withName("config-map-" + it).endMetadata().build())
            .createOr(NonDeletingOperation::update);
      }
      client.getHttpClient().sendAsync(client.getHttpClient().newHttpRequestBuilder()
          .uri(server.url("/api/v1/namespaces/test/configmaps"))
          .post("application/json", "{\"kind\":\"NotConfigMap\"}")
          .build(), String.class)
          .get(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    void addConsistentItems() {
      for (int it = 0; it < 10; it++) {
        client.resource(new ConfigMapBuilder().withNewMetadata().withName("config-map-" + it).endMetadata().build())
            .createOr(NonDeletingOperation::update);
      }
    }

    @Test
    void singleItem() {
      assertThat(client.configMaps().withName("config-map-1").get())
          .isInstanceOf(ConfigMap.class);
    }

    @Test
    @Disabled("#6220: Need to figure out a way to extract the singular from the plural form in URL")
    void multipleItems_shouldReturnListObjectWithCorrectKind() {
      // When
      final ConfigMapList result = client.configMaps().list();
      // Then
      assertThat(result)
          .hasFieldOrPropertyWithValue("kind", "ConfigMapList")
          .extracting(ConfigMapList::getItems)
          .asInstanceOf(InstanceOfAssertFactories.list(ConfigMap.class))
          .extracting("kind")
          .containsOnly("ConfigMap");
    }
  }
}
