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
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.Policy;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyBuilder;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PolicyTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/policy.open-cluster-management.io/v1/namespaces/ns1/policies/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPolicy("test-get"))
        .once();

    // When
    Policy policy = client.policy().policies().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(policy)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/policy.open-cluster-management.io/v1/namespaces/ns1/policies")
        .andReturn(HttpURLConnection.HTTP_OK, new PolicyListBuilder()
            .addToItems(createNewPolicy("test-list"))
            .build())
        .once();

    // When
    PolicyList policyList = client.policy().policies().inNamespace("ns1").list();

    // Then
    assertThat(policyList).isNotNull();
    assertThat(policyList.getItems()).hasSize(1);
    assertThat(policyList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/policy.open-cluster-management.io/v1/namespaces/ns1/policies/sample-policy")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPolicy("sample-policy"))
        .once();

    // When
    boolean isDeleted = client.policy().policies().inNamespace("ns1").withName("sample-policy").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Policy createNewPolicy(String name) {
    return new PolicyBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withDisabled(false)
        .withRemediationAction("enforce")
        .addNewPolicyTemplate()
        .withObjectDefinition(Collections.singletonMap("kind", "ConfigurationPolicy"))
        .endPolicyTemplate()
        .endSpec()
        .build();
  }
}
