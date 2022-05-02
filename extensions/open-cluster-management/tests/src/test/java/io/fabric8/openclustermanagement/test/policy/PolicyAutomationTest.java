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
package io.fabric8.openclustermanagement.test.policy;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomation;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationBuilder;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PolicyAutomationTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/policy.open-cluster-management.io/v1beta1/namespaces/ns1/policyautomations/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPolicyAutomation("test-get"))
        .once();

    // When
    PolicyAutomation policy = client.policy().policyAutomations().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(policy)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/policy.open-cluster-management.io/v1beta1/namespaces/ns1/policyautomations")
        .andReturn(HttpURLConnection.HTTP_OK, new PolicyAutomationListBuilder()
            .addToItems(createNewPolicyAutomation("test-list"))
            .build())
        .once();

    // When
    PolicyAutomationList policyAutomationList = client.policy().policyAutomations().inNamespace("ns1").list();

    // Then
    assertThat(policyAutomationList).isNotNull();
    assertThat(policyAutomationList.getItems()).hasSize(1);
    assertThat(policyAutomationList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/policy.open-cluster-management.io/v1beta1/namespaces/ns1/policyautomations/sample-policy")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPolicyAutomation("sample-policy"))
        .once();

    // When
    boolean isDeleted = client.policy().policyAutomations().inNamespace("ns1").withName("sample-policy").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PolicyAutomation createNewPolicyAutomation(String name) {
    return new PolicyAutomationBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withEventHook("noncompliant")
        .withPolicyRef("case5-test-policy")
        .withMode("disabled")
        .withNewAutomationDef()
        .withName("Demo Job Template")
        .withSecret("toweraccess")
        .addToExtraVars("sn_severity", 1)
        .addToExtraVars("sn_priority", 1)
        .addToExtraVars("target_clusters", Collections.singletonList("cluster1"))
        .endAutomationDef()
        .endSpec()
        .build();
  }
}
