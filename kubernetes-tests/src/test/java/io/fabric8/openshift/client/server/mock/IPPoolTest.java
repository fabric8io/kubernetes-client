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

import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPAllocationBuilder;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPool;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPoolBuilder;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPoolList;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPoolListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class IPPoolTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/whereabouts.cni.cncf.io/v1alpha1/namespaces/ns1/ippools/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIPPool("test-get"))
        .once();

    // When
    IPPool ipPool = client.whereabouts().ippools().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(ipPool)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/whereabouts.cni.cncf.io/v1alpha1/namespaces/ns1/ippools")
        .andReturn(HttpURLConnection.HTTP_OK, new IPPoolListBuilder()
            .addToItems(createNewIPPool("test-list"))
            .build())
        .once();

    // When
    IPPoolList ipPoolList = client.whereabouts().ippools().inNamespace("ns1").list();

    // Then
    assertThat(ipPoolList).isNotNull();
    assertThat(ipPoolList.getItems()).hasSize(1);
    assertThat(ipPoolList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/whereabouts.cni.cncf.io/v1alpha1/namespaces/ns1/ippools/ippool1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIPPool("ippool1"))
        .once();

    // When
    boolean isDeleted = client.whereabouts().ippools().inNamespace("ns1").withName("ippool1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private IPPool createNewIPPool(String name) {
    return new IPPoolBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addToAllocations("key1", new IPAllocationBuilder().withId("id1").build())
        .withRange("192.168.12.0/24")
        .endSpec()
        .build();
  }
}
