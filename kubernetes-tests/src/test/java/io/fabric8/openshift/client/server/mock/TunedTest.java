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

import io.fabric8.openshift.api.model.tuned.v1.Tuned;
import io.fabric8.openshift.api.model.tuned.v1.TunedBuilder;
import io.fabric8.openshift.api.model.tuned.v1.TunedList;
import io.fabric8.openshift.api.model.tuned.v1.TunedListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class TunedTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/tuned.openshift.io/v1/namespaces/ns1/tuneds/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewTuned("test-get"))
        .once();

    // When
    Tuned profile = client.tuned().tuneds().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(profile)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/tuned.openshift.io/v1/namespaces/ns1/tuneds")
        .andReturn(HttpURLConnection.HTTP_OK, new TunedListBuilder()
            .addToItems(createNewTuned("test-list"))
            .build())
        .once();

    // When
    TunedList profileList = client.tuned().tuneds().inNamespace("ns1").list();

    // Then
    assertThat(profileList).isNotNull();
    assertThat(profileList.getItems()).hasSize(1);
    assertThat(profileList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/tuned.openshift.io/v1/namespaces/ns1/tuneds/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewTuned("cluster"))
        .once();

    // When
    boolean isDeleted = client.tuned().tuneds().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Tuned createNewTuned(String name) {
    return new TunedBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewProfile()
        .withName("openshift-module-load")
        .withData("foo")
        .endProfile()
        .addNewRecommend()
        .addNewMatch()
        .withLabel("tuned.openshift.io/module-load")
        .endMatch()
        .withPriority(20L)
        .withProfile("openshift-module-load")
        .endRecommend()
        .endSpec()
        .build();
  }
}
