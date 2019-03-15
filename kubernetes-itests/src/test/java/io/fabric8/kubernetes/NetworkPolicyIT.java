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

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.networking.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.NetworkPolicyBuilder;
import io.fabric8.kubernetes.api.model.networking.NetworkPolicyIngressRuleBuilder;
import io.fabric8.kubernetes.api.model.networking.NetworkPolicyPeerBuilder;
import io.fabric8.kubernetes.api.model.networking.NetworkPolicyPortBuilder;
import io.fabric8.kubernetes.api.model.networking.NetworkPolicyList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class NetworkPolicyIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private NetworkPolicy networkPolicy;

  private String currentNamespace;

  @Before
  public void init(){
    currentNamespace = session.getNamespace();
    networkPolicy = new NetworkPolicyBuilder()
      .withNewMetadata()
      .withName("networkpolicy")
      .addToLabels("foo","bar")
      .endMetadata()
      .withNewSpec()
      .withNewPodSelector()
      .addToMatchLabels("role","db")
      .endPodSelector()
      .addToIngress(0,
        new NetworkPolicyIngressRuleBuilder()
        .addToFrom(0, new NetworkPolicyPeerBuilder().withNewPodSelector()
          .addToMatchLabels("role","frontend").endPodSelector()
          .build()
        ).addToFrom(1, new NetworkPolicyPeerBuilder().withNewNamespaceSelector()
          .addToMatchLabels("project","myproject").endNamespaceSelector()
            .build()
        )
        .addToPorts(0,new NetworkPolicyPortBuilder().withPort(new IntOrString(6379))
          .withProtocol("TCP").build())
        .build()
      )
      .endSpec()
      .build();

    client.network().networkPolicies().create(networkPolicy);
  }

  @Test
  public void load() {

    NetworkPolicy loadedNetworkPolicy = client.network().networkPolicies()
      .load(getClass().getResourceAsStream("/test-networkpolicy.yml")).get();

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
  public void get() {

    NetworkPolicy getNetworkPolicy = client.network().networkPolicies()
      .withName("networkpolicy").get();
    assertNotNull(getNetworkPolicy);
    assertEquals("networkpolicy", getNetworkPolicy.getMetadata().getName());
    assertEquals(1,getNetworkPolicy.getMetadata().getLabels().size());
    assertEquals("db", getNetworkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", getNetworkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
      .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", getNetworkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
      .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", getNetworkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379, getNetworkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());
  }

  @Test
  public void list() {

    NetworkPolicyList networkPolicyList = client.network().networkPolicies()
      .withLabels(Collections.singletonMap("foo","bar")).list();
    assertNotNull(networkPolicyList);
    assertEquals(1,networkPolicyList.getItems().size());
    assertEquals("networkpolicy",networkPolicyList.getItems().get(0).getMetadata().getName());
    assertEquals("db", networkPolicyList.getItems().get(0).getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getFrom().get(1)
      .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getFrom().get(0)
      .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379, networkPolicyList.getItems().get(0).getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());

  }

  @Test
  public void update(){
    ReadyEntity<NetworkPolicy> networkPolicyReady = new ReadyEntity<>(NetworkPolicy.class, client, "networkpolicy", currentNamespace);
    networkPolicy = client.network().networkPolicies()
      .withName("networkpolicy").edit()
      .editMetadata().addToLabels("bar","foo").endMetadata()
      .done();

    await().atMost(30, TimeUnit.SECONDS).until(networkPolicyReady);
    assertNotNull(networkPolicy);
    assertEquals("networkpolicy",networkPolicy.getMetadata().getName());
    assertEquals(2,networkPolicy.getMetadata().getLabels().size());
    assertEquals("db", networkPolicy.getSpec().getPodSelector().getMatchLabels().get("role"));
    assertEquals("myproject", networkPolicy.getSpec().getIngress().get(0).getFrom().get(1)
      .getNamespaceSelector().getMatchLabels().get("project"));
    assertEquals("frontend", networkPolicy.getSpec().getIngress().get(0).getFrom().get(0)
      .getPodSelector().getMatchLabels().get("role"));
    assertEquals("TCP", networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getProtocol());
    assertEquals(6379, networkPolicy.getSpec().getIngress().get(0).getPorts().get(0).getPort().getIntVal().intValue());

  }

  @Test
  public void delete(){
    ReadyEntity<NetworkPolicy> networkPolicyReady = new ReadyEntity<>(NetworkPolicy.class, client, "networkpolicy", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(networkPolicyReady);
    boolean deleted = client.network().networkPolicies().delete(networkPolicy);

    assertTrue(deleted);

    DeleteEntity<NetworkPolicy> deleteEntity = new DeleteEntity<>(NetworkPolicy.class, client, "networkpolicy", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);

    NetworkPolicyList networkPolicyList = client.network().networkPolicies().list();
    assertEquals(0,networkPolicyList.getItems().size());
  }

  @After
  public void cleanup() {
    if (client.network().networkPolicies().list().getItems().size()!= 0) {
      client.network().networkPolicies().delete();
    }
    DeleteEntity<NetworkPolicy> networkPolicyDelete = new DeleteEntity<>(NetworkPolicy.class, client, "networkpolicy", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(networkPolicyDelete);
  }
}
