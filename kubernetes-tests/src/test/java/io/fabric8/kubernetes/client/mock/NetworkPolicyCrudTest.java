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

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyIngressRuleBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyPeerBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyPortBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class NetworkPolicyCrudTest {

  private static final Logger logger = LoggerFactory.getLogger(NetworkPolicyCrudTest.class);

  KubernetesClient client;

  @Test
  void crudTest() {

    NetworkPolicy networkPolicy = new NetworkPolicyBuilder()
        .withNewMetadata()
        .withName("networkpolicy")
        .addToLabels("foo", "bar")
        .endMetadata()
        .withNewSpec()
        .withNewPodSelector()
        .addToMatchLabels("role", "db")
        .endPodSelector()
        .addToIngress(0,
            new NetworkPolicyIngressRuleBuilder()
                .addToFrom(0, new NetworkPolicyPeerBuilder().withNewPodSelector()
                    .addToMatchLabels("role", "frontend").endPodSelector()
                    .build())
                .addToFrom(1, new NetworkPolicyPeerBuilder().withNewNamespaceSelector()
                    .addToMatchLabels("project", "myproject").endNamespaceSelector()
                    .build())
                .addToPorts(0, new NetworkPolicyPortBuilder().withPort(new IntOrString(6379))
                    .withProtocol("TCP").build())
                .build())
        .endSpec()
        .build();

    //test of Creation
    networkPolicy = client.network().v1().networkPolicies().create(networkPolicy);

    assertNotNull(networkPolicy);
    assertEquals("networkpolicy", networkPolicy.getMetadata().getName());
    assertEquals("db", networkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", networkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
        .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", networkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
        .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379, networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());

    //test of list
    NetworkPolicyList networkPolicyList = client.network().networkPolicies()
        .withLabels(Collections.singletonMap("foo", "bar")).list();

    assertNotNull(networkPolicyList);
    assertEquals(1, networkPolicyList.getItems().size());
    assertEquals("networkpolicy", networkPolicyList.getItems().get(0).getMetadata().getName());
    assertEquals("db", networkPolicyList.getItems().get(0).getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getFrom().get(1)
        .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getFrom().get(0)
        .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379,
        networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());
    logger.info(networkPolicyList.toString());

    //test of updation
    networkPolicy = client.network().networkPolicies()
        .withName("networkpolicy").edit(n -> new NetworkPolicyBuilder(n)
            .editSpec().editIngress(0).editFirstPort().withPort(new IntOrString(6679)).endPort().endIngress().endSpec()
            .build());

    logger.info("Updated PodSecurityPolicy : " + networkPolicy.toString());
    assertNotNull(networkPolicy);
    assertEquals("networkpolicy", networkPolicy.getMetadata().getName());
    assertEquals("db", networkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", networkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
        .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", networkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
        .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6679, networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());

    //test of deletion
    boolean deleted = client.network().networkPolicies().delete().size() == 1;
    assertTrue(deleted);
    networkPolicyList = client.network().networkPolicies().list();
    assertEquals(0, networkPolicyList.getItems().size());

  }

}
