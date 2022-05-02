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

import io.fabric8.openshift.api.model.monitoring.v1.Probe;
import io.fabric8.openshift.api.model.monitoring.v1.ProbeBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.ProbeList;
import io.fabric8.openshift.api.model.monitoring.v1.ProbeListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ProbeTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/probes/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewProbe("test-get"))
        .once();

    // When
    Probe probe = client.monitoring().probes().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(probe)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/probes")
        .andReturn(HttpURLConnection.HTTP_OK, new ProbeListBuilder()
            .addToItems(createNewProbe("test-list"))
            .build())
        .once();

    // When
    ProbeList probeList = client.monitoring().probes().inNamespace("ns1").list();

    // Then
    assertThat(probeList).isNotNull();
    assertThat(probeList.getItems()).hasSize(1);
    assertThat(probeList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/monitoring.coreos.com/v1/namespaces/ns1/probes/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewProbe("test-delete"))
        .once();

    // When
    boolean isDeleted = client.monitoring().probes().inNamespace("ns1").withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Probe createNewProbe(String name) {
    return new ProbeBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withJobName("probe-cr")
        .withNewProber()
        .withUrl("example-prometheus-blackbox-exporter:9115")
        .endProber()
        .withNewTargets()
        .withNewStaticConfig()
        .withStatic("https://example.com")
        .endStaticConfig()
        .endTargets()
        .endSpec()
        .build();
  }
}
