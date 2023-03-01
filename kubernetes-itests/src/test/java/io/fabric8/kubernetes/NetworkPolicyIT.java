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
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/networkpolicy-it.yml")
class NetworkPolicyIT {

  KubernetesClient client;

  @Test
  void load() {
    NetworkPolicy loadedNetworkPolicy = client.network().v1().networkPolicies()
        .load(getClass().getResourceAsStream("/test-networkpolicy.yml")).item();

    assertNotNull(loadedNetworkPolicy);
    assertEquals("networkpolicy", loadedNetworkPolicy.getMetadata().getName());
    assertEquals("db", loadedNetworkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", loadedNetworkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
        .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", loadedNetworkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
        .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", loadedNetworkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379, loadedNetworkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());
  }

  @Test
  void get() {
    NetworkPolicy getNetworkPolicy = client.network().v1().networkPolicies()
        .withName("networkpolicy-get").get();
    assertNotNull(getNetworkPolicy);
    assertEquals("networkpolicy-get", getNetworkPolicy.getMetadata().getName());
    assertEquals(1, getNetworkPolicy.getMetadata().getLabels().size());
    assertEquals("db", getNetworkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", getNetworkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
        .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", getNetworkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
        .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", getNetworkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379, getNetworkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());
  }

  @Test
  void list() {

    NetworkPolicyList networkPolicyList = client.network().v1().networkPolicies()
        .withLabels(Collections.singletonMap("test", "list")).list();
    assertNotNull(networkPolicyList);
    assertTrue(networkPolicyList.getItems().size() >= 1);
    for (NetworkPolicy networkPolicy : networkPolicyList.getItems()) {
      if (networkPolicy.getMetadata().getName().equals("networkpolicy-list")) {
        assertEquals("db", networkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
        assertEquals("myproject", networkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
            .getNamespaceSelector().getMatchLabels().get("project"));
        assertEquals("frontend", networkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
            .getPodSelector().getMatchLabels().get("role"));
        assertEquals("TCP", networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
        assertEquals(6379, networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());
      }
    }

  }

  @Test
  void update() {
    NetworkPolicy networkPolicy = client.network().v1().networkPolicies()
        .withName("networkpolicy-update").edit(n -> new NetworkPolicyBuilder(n)
            .editMetadata().withResourceVersion(null).addToLabels("bar", "foo").endMetadata()
            .build());

    assertNotNull(networkPolicy);
    assertEquals("networkpolicy-update", networkPolicy.getMetadata().getName());
    assertEquals(1, networkPolicy.getMetadata().getLabels().size());
    assertEquals("db", networkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", networkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
        .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", networkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
        .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379, networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());

  }

  @Test
  void delete() {
    client.network().v1().networkPolicies().withName("networkpolicy-delete")
        .waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean deleted = client.network().v1().networkPolicies().withName("networkpolicy-delete").delete().size() == 1;

    assertTrue(deleted);

    client.network().v1().networkPolicies().withName("networkpolicy-delete")
        .waitUntilCondition(np -> np == null || np.getMetadata().getDeletionTimestamp() != null, 30, TimeUnit.SECONDS);
  }

}
