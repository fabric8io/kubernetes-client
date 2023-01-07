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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.openshift.api.model.config.v1.Ingress;
import io.fabric8.openshift.api.model.config.v1.IngressBuilder;
import io.fabric8.openshift.api.model.config.v1.IngressList;
import io.fabric8.openshift.api.model.config.v1.IngressListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class IngressTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-openshift-config-ingress.yml"))
        .items();
    assertThat(items).isNotNull().hasSize(1);
    assertThat(items.get(0)).isInstanceOf(Ingress.class);
  }

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/ingresses/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIngress("test-get", "test.fabric8.io"))
        .once();

    // When
    Ingress ing = client.config().ingresses().withName("test-get").get();

    // Then
    assertThat(ing)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get")
        .hasFieldOrPropertyWithValue("spec.domain", "test.fabric8.io");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/ingresses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressListBuilder()
            .addToItems(createNewIngress("test-list", "test.fabric8.io"))
            .build())
        .once();

    // When
    IngressList ingressList = client.config().ingresses().list();

    // Then
    assertThat(ingressList).isNotNull();
    assertThat(ingressList.getItems()).hasSize(1);
    assertThat(ingressList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list")
        .hasFieldOrPropertyWithValue("spec.domain", "test.fabric8.io");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/config.openshift.io/v1/ingresses/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIngress("cluster", "test-delete.fabric8.io"))
        .once();

    // When
    boolean isDeleted = client.config().ingresses().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Ingress createNewIngress(String name, String domain) {
    return new IngressBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withDomain(domain)
        .endSpec()
        .build();
  }
}
