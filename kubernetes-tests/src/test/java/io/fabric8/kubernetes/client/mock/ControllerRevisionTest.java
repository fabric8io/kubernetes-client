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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.apps.ControllerRevision;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionBuilder;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionList;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class ControllerRevisionTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-controllerrevision.yml")).items();
    assertThat(items).isNotNull().hasSize(1);
    assertThat(items.get(0)).isInstanceOf(ControllerRevision.class);
  }

  @Test
  void create() {
    // Given
    ControllerRevision controllerRevision = getMockControllerRevision("my-cr1");
    server.expect().post().withPath("/apis/apps/v1/namespaces/default/controllerrevisions")
        .andReturn(HttpURLConnection.HTTP_CREATED, controllerRevision)
        .once();

    // When
    ControllerRevision myCr = client.apps().controllerRevisions().inNamespace("default").create(controllerRevision);

    // Then
    assertThat(myCr).isNotNull().hasFieldOrPropertyWithValue("metadata.name", "my-cr1");
  }

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/apps/v1/namespaces/default/controllerrevisions/cr1")
        .andReturn(HttpURLConnection.HTTP_OK, getMockControllerRevision("cr1"))
        .once();

    // When
    ControllerRevision cr1 = client.apps().controllerRevisions().inNamespace("default").withName("cr1").get();

    // Then
    assertThat(cr1)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "cr1");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/apps/v1/namespaces/default/controllerrevisions")
        .andReturn(HttpURLConnection.HTTP_OK,
            new ControllerRevisionListBuilder().addToItems(getMockControllerRevision("cr1")).build())
        .once();

    // When
    ControllerRevisionList controllerRevisionList = client.apps().controllerRevisions().inNamespace("default").list();

    // Then
    assertThat(controllerRevisionList).isNotNull();
    assertThat(controllerRevisionList.getItems()).isNotNull().hasSize(1);
    assertThat(controllerRevisionList.getItems().get(0)).hasFieldOrPropertyWithValue("metadata.name", "cr1");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/apps/v1/namespaces/default/controllerrevisions/cr1")
        .andReturn(HttpURLConnection.HTTP_OK, getMockControllerRevision("cr1"))
        .once();

    // When
    boolean isDeleted = client.apps().controllerRevisions().inNamespace("default").withName("cr1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ControllerRevision getMockControllerRevision(String name) {
    return new ControllerRevisionBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewDaemonSetData()
        .withApiVersion("apps/v1")
        .withKind("DaemonSet")
        .endDaemonSetData()
        .build();
  }

}
