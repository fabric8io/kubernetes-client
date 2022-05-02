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
package io.fabric8.camelk.test;

import io.fabric8.camelk.client.CamelKClient;
import io.fabric8.camelk.v1alpha1.KameletBinding;
import io.fabric8.camelk.v1alpha1.KameletBindingBuilder;
import io.fabric8.camelk.v1alpha1.KameletBindingList;
import io.fabric8.camelk.v1alpha1.KameletBindingListBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@EnableKubernetesMockClient
class KameletBindingTest {
  CamelKClient client;
  KubernetesMockServer server;

  @Test
  void load() {
    // Given + When
    KameletBinding kameletBinding = client.v1alpha1().kameletBindings()
        .load(getClass().getResourceAsStream("/test-kameletbinding.yml"))
        .get();

    // Then
    assertThat(kameletBinding)
        .hasFieldOrPropertyWithValue("kind", "KameletBinding")
        .hasFieldOrPropertyWithValue("metadata.name", "example");
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/camel.apache.org/v1alpha1/namespaces/ns1/kameletbindings/kb-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKameletBinding("kb-get"))
        .once();

    // When
    KameletBinding kameletBinding = client.v1alpha1().kameletBindings().inNamespace("ns1").withName("kb-get").get();

    // Then
    assertThat(kameletBinding)
        .hasFieldOrPropertyWithValue("kind", "KameletBinding")
        .hasFieldOrPropertyWithValue("metadata.name", "kb-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/camel.apache.org/v1alpha1/namespaces/ns1/kameletbindings")
        .andReturn(HttpURLConnection.HTTP_OK, new KameletBindingListBuilder()
            .addToItems(createNewKameletBinding("kb-list"))
            .build())
        .once();

    // When
    KameletBindingList kameletBindings = client.v1alpha1().kameletBindings().inNamespace("ns1").list();

    // Then
    assertThat(kameletBindings)
        .extracting(KameletBindingList::getItems)
        .asList()
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("kind", "KameletBinding")
        .hasFieldOrPropertyWithValue("metadata.name", "kb-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/camel.apache.org/v1alpha1/namespaces/ns1/kameletbindings/kb-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKameletBinding("kb-delete"))
        .once();

    // When
    boolean isDeleted = client.v1alpha1().kameletBindings().inNamespace("ns1").withName("kb-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private KameletBinding createNewKameletBinding(String name) {
    return new KameletBindingBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewSource()
        .withNewRef()
        .withApiVersion("camel.apache.org/v1alpha1")
        .withKind("Kamelet")
        .withName("example")
        .endRef()
        .withProperties(Collections.singletonMap("message", "Hello World"))
        .endSource()
        .endSpec()
        .build();
  }
}
