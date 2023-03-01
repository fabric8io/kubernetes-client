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

package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/serviceaccount-it.yml")
class ServiceAccountIT {

  KubernetesClient client;

  @Test
  void load() {
    ServiceAccount svcAccount = client.serviceAccounts()
        .load(getClass().getResourceAsStream("/test-serviceaccount.yml")).item();
    assertThat(svcAccount).isNotNull();
    assertThat(svcAccount.getMetadata().getName()).isNotNull();
  }

  @Test
  void get() {
    ServiceAccount serviceAccount1 = client.serviceAccounts().withName("sa-get").get();
    assertNotNull(serviceAccount1);
  }

  @Test
  void list() {
    ServiceAccountList svcAccountList = client.serviceAccounts().list();
    assertThat(svcAccountList).isNotNull();
    // Every namespace has a default service account resource.
    assertTrue(svcAccountList.getItems().size() >= 1);
  }

  @Test
  void update() {
    ServiceAccount serviceAccount1 = client.serviceAccounts().withName("sa-update").edit(s -> new ServiceAccountBuilder(s)
        .editMetadata().withResourceVersion(null).endMetadata()
        .addNewSecret().withName("default-token-uudp").endSecret()
        .addNewImagePullSecret().withName("myregistrykey").endImagePullSecret()
        .build());
    client.serviceAccounts().withName("sa-update").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    assertThat(serviceAccount1).isNotNull();
  }

  @Test
  void delete() {
    client.serviceAccounts().withName("sa-delete").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean bDeleted = client.serviceAccounts().withName("sa-delete").delete().size() == 1;
    assertTrue(bDeleted);
  }

}
