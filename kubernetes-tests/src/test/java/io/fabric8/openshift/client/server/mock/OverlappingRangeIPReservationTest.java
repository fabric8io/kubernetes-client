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

import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservation;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservationBuilder;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservationList;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservationListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class OverlappingRangeIPReservationTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/whereabouts.cni.cncf.io/v1alpha1/namespaces/ns1/overlappingrangeipreservations/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOverlappingRangeIPReservation("test-get"))
        .once();

    // When
    OverlappingRangeIPReservation overlappingRangeIPReservation = client.whereabouts().overlappingRangeIpReservations()
        .inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(overlappingRangeIPReservation)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/whereabouts.cni.cncf.io/v1alpha1/namespaces/ns1/overlappingrangeipreservations")
        .andReturn(HttpURLConnection.HTTP_OK, new OverlappingRangeIPReservationListBuilder()
            .addToItems(createNewOverlappingRangeIPReservation("test-list"))
            .build())
        .once();

    // When
    OverlappingRangeIPReservationList overlappingRangeIPReservationList = client.whereabouts().overlappingRangeIpReservations()
        .inNamespace("ns1").list();

    // Then
    assertThat(overlappingRangeIPReservationList).isNotNull();
    assertThat(overlappingRangeIPReservationList.getItems()).hasSize(1);
    assertThat(overlappingRangeIPReservationList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/whereabouts.cni.cncf.io/v1alpha1/namespaces/ns1/overlappingrangeipreservations/orir")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOverlappingRangeIPReservation("orir"))
        .once();

    // When
    boolean isDeleted = client.whereabouts().overlappingRangeIpReservations().inNamespace("ns1").withName("orir").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private OverlappingRangeIPReservation createNewOverlappingRangeIPReservation(String name) {
    return new OverlappingRangeIPReservationBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withContainerid("container1")
        .endSpec()
        .build();
  }
}
