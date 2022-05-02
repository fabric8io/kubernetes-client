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
package io.fabric8.openclustermanagement.test.apps;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.Application;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationBuilder;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationList;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ApplicationTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/app.k8s.io/v1beta1/namespaces/ns1/applications/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewApplication("test-get"))
        .once();

    // When
    Application application = client.apps().applications().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(application)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/app.k8s.io/v1beta1/namespaces/ns1/applications")
        .andReturn(HttpURLConnection.HTTP_OK, new ApplicationListBuilder()
            .addToItems(createNewApplication("test-list"))
            .build())
        .once();

    // When
    ApplicationList applicationList = client.apps().applications().inNamespace("ns1").list();

    // Then
    assertThat(applicationList).isNotNull();
    assertThat(applicationList.getItems()).hasSize(1);
    assertThat(applicationList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/app.k8s.io/v1beta1/namespaces/ns1/applications/sample-application")
        .andReturn(HttpURLConnection.HTTP_OK, createNewApplication("sample-application"))
        .once();

    // When
    boolean isDeleted = client.apps().applications().inNamespace("ns1").withName("sample-application").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Application createNewApplication(String name) {
    return new ApplicationBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewComponentKind("apps.open-cluster-management.io", "Subscription")
        .withNewSelector()
        .addToMatchLabels("app", "nginx-app-details")
        .endSelector()
        .endSpec()
        .build();
  }
}
