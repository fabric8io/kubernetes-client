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

import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceQuotaSpecBuilder;
import io.fabric8.openshift.api.model.ClusterResourceQuota;
import io.fabric8.openshift.api.model.ClusterResourceQuotaBuilder;
import io.fabric8.openshift.api.model.ClusterResourceQuotaList;
import io.fabric8.openshift.api.model.ClusterResourceQuotaListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class ClusterResourceQuotaTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    ClusterResourceQuota featureGate = getClusterResourceQuota();
    server.expect().post()
        .withPath("/apis/quota.openshift.io/v1/clusterresourcequotas")
        .andReturn(HttpURLConnection.HTTP_OK, featureGate)
        .once();

    // When
    featureGate = client.quotas().clusterResourceQuotas().create(featureGate);

    // Then
    assertNotNull(featureGate);
    assertEquals("foo", featureGate.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/quota.openshift.io/v1/clusterresourcequotas/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getClusterResourceQuota())
        .once();

    // When
    ClusterResourceQuota f = client.quotas().clusterResourceQuotas().withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/quota.openshift.io/v1/clusterresourcequotas")
        .andReturn(HttpURLConnection.HTTP_OK,
            new ClusterResourceQuotaListBuilder().withItems(getClusterResourceQuota()).build())
        .once();

    // When
    ClusterResourceQuotaList fgList = client.quotas().clusterResourceQuotas().list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/quota.openshift.io/v1/clusterresourcequotas/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getClusterResourceQuota())
        .once();

    // When
    boolean deleted = client.quotas().clusterResourceQuotas().withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ClusterResourceQuota getClusterResourceQuota() {
    Map<String, Quantity> hard = new HashMap<>();
    hard.put("pods", new Quantity("10"));
    hard.put("secrets", new Quantity("20"));
    return new ClusterResourceQuotaBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withNewSpec()
        .withNewSelector()
        .addToAnnotations("openshift.io/requester", "foo-user")
        .endSelector()
        .withQuota(new ResourceQuotaSpecBuilder()
            .withHard(hard)
            .build())
        .endSpec()
        .build();
  }
}
