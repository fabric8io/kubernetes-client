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
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.Subscription;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionBuilder;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class SubscriptionTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/subscriptions/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSubscription("test-get"))
        .once();

    // When
    Subscription subscription = client.apps().subscriptions().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(subscription)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/subscriptions")
        .andReturn(HttpURLConnection.HTTP_OK, new SubscriptionListBuilder()
            .addToItems(createNewSubscription("test-list"))
            .build())
        .once();

    // When
    SubscriptionList subscriptionList = client.apps().subscriptions().inNamespace("ns1").list();

    // Then
    assertThat(subscriptionList).isNotNull();
    assertThat(subscriptionList.getItems()).hasSize(1);
    assertThat(subscriptionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/subscriptions/sample_subscription")
        .andReturn(HttpURLConnection.HTTP_OK, createNewSubscription("sample_subscription"))
        .once();

    // When
    boolean isDeleted = client.apps().subscriptions().inNamespace("ns1").withName("sample_subscription").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Subscription createNewSubscription(String name) {
    return new SubscriptionBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withChannel("channel_namespace/sample_channel")
        .addNewPackageOverride()
        .withPackageName("my-sample-application")
        .withPackageAlias("the-sample-app")
        .endPackageOverride()
        .endSpec()
        .build();
  }
}
