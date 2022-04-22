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

import io.fabric8.openshift.api.model.monitoring.v1.ThanosRuler;
import io.fabric8.openshift.api.model.monitoring.v1.ThanosRulerBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.ThanosRulerList;
import io.fabric8.openshift.api.model.monitoring.v1.ThanosRulerListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ThanosRulerTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/thanosrulers/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewThanosRuler("test-get"))
        .once();

    // When
    ThanosRuler probe = client.monitoring().thanosRulers().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(probe)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/thanosrulers")
        .andReturn(HttpURLConnection.HTTP_OK, new ThanosRulerListBuilder()
            .addToItems(createNewThanosRuler("test-list"))
            .build())
        .once();

    // When
    ThanosRulerList probeList = client.monitoring().thanosRulers().inNamespace("ns1").list();

    // Then
    assertThat(probeList).isNotNull();
    assertThat(probeList.getItems()).hasSize(1);
    assertThat(probeList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/thanosrulers/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewThanosRuler("test-delete"))
        .once();

    // When
    boolean isDeleted = client.monitoring().thanosRulers().inNamespace("ns1").withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ThanosRuler createNewThanosRuler(String name) {
    return new ThanosRulerBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withImage("quay.io/thanos/thanos")
        .withNewRuleSelector()
        .withMatchLabels(Collections.singletonMap("role", "my-thanos-rules"))
        .endRuleSelector()
        .withQueryEndpoints("dnssrv+_http._tcp.my-thanos-querier.monitoring.svc.cluster.local")
        .endSpec()
        .build();
  }
}
