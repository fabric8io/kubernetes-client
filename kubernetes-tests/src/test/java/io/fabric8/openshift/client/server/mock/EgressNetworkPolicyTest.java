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

import io.fabric8.openshift.api.model.EgressNetworkPolicy;
import io.fabric8.openshift.api.model.EgressNetworkPolicyBuilder;
import io.fabric8.openshift.api.model.EgressNetworkPolicyList;
import io.fabric8.openshift.api.model.EgressNetworkPolicyListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class EgressNetworkPolicyTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    EgressNetworkPolicy egressNetworkPolicy = getEgressNetworkPolicy();
    server.expect().post()
        .withPath("/apis/network.openshift.io/v1/namespaces/ns1/egressnetworkpolicies")
        .andReturn(HttpURLConnection.HTTP_OK, egressNetworkPolicy)
        .once();

    // When
    egressNetworkPolicy = client.egressNetworkPolicies().inNamespace("ns1").create(egressNetworkPolicy);

    // Then
    assertNotNull(egressNetworkPolicy);
    assertEquals("foo", egressNetworkPolicy.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/network.openshift.io/v1/namespaces/ns1/egressnetworkpolicies/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getEgressNetworkPolicy())
        .once();

    // When
    EgressNetworkPolicy f = client.egressNetworkPolicies().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/network.openshift.io/v1/namespaces/ns1/egressnetworkpolicies")
        .andReturn(HttpURLConnection.HTTP_OK, new EgressNetworkPolicyListBuilder().withItems(getEgressNetworkPolicy()).build())
        .once();

    // When
    EgressNetworkPolicyList fgList = client.egressNetworkPolicies().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/network.openshift.io/v1/namespaces/ns1/egressnetworkpolicies/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getEgressNetworkPolicy())
        .once();

    // When
    boolean deleted = client.egressNetworkPolicies().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private EgressNetworkPolicy getEgressNetworkPolicy() {
    return new EgressNetworkPolicyBuilder()
        .withNewMetadata()
        .withName("foo")
        .withNamespace("ns1")
        .endMetadata()
        .withNewSpec()
        .addNewEgress()
        .withType("Allow")
        .withNewTo()
        .withCidrSelector("1.2.3.0/24")
        .endTo()
        .endEgress()
        .addNewEgress()
        .withType("Allow")
        .withNewTo()
        .withDnsName("www.foo.com")
        .endTo()
        .endEgress()
        .endSpec()
        .build();
  }
}
