/*
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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.JSONPatch;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingAdmissionPolicy;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingAdmissionPolicyBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingAdmissionPolicyList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingAdmissionPolicyListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class V1MutatingAdmissionPolicyTest {

  KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-v1-mutatingadmissionpolicy.yml"))
        .items();
    assertThat(items).isNotNull().hasSize(1);
    AssertionsForClassTypes.assertThat(items.get(0))
        .isInstanceOf(MutatingAdmissionPolicy.class)
        .hasFieldOrPropertyWithValue("metadata.name", "sidecar-policy.example.com");
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/admissionregistration.k8s.io/v1/mutatingadmissionpolicies/sidecar-policy.example.com")
        .andReturn(HttpURLConnection.HTTP_OK, createMutatingAdmissionPolicy())
        .once();

    // When
    MutatingAdmissionPolicy mutatingAdmissionPolicy = client.admissionRegistration().v1()
        .mutatingAdmissionPolicies().withName("sidecar-policy.example.com").get();

    // Then
    AssertionsForClassTypes.assertThat(mutatingAdmissionPolicy)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "sidecar-policy.example.com");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/admissionregistration.k8s.io/v1/mutatingadmissionpolicies")
        .andReturn(HttpURLConnection.HTTP_OK, new MutatingAdmissionPolicyListBuilder()
            .addToItems(createMutatingAdmissionPolicy())
            .build())
        .once();

    // When
    MutatingAdmissionPolicyList list = client.admissionRegistration().v1().mutatingAdmissionPolicies().list();

    // Then
    AssertionsForClassTypes.assertThat(list).isNotNull();
    assertThat(list.getItems()).hasSize(1);
    AssertionsForClassTypes.assertThat(list.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "sidecar-policy.example.com");
  }

  @Test
  void create() {
    // Given
    MutatingAdmissionPolicy admissionPolicy = createMutatingAdmissionPolicy();
    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1/mutatingadmissionpolicies")
        .andReturn(HttpURLConnection.HTTP_OK, admissionPolicy)
        .once();

    // When
    MutatingAdmissionPolicy mutatingAdmissionPolicy = client.admissionRegistration().v1()
        .mutatingAdmissionPolicies().resource(admissionPolicy).create();

    // Then
    AssertionsForClassTypes.assertThat(mutatingAdmissionPolicy).isNotNull();
    AssertionsForClassTypes.assertThat(mutatingAdmissionPolicy)
        .hasFieldOrPropertyWithValue("metadata.name", "sidecar-policy.example.com");
  }

  @Test
  void delete() {
    // Given
    MutatingAdmissionPolicy admissionPolicy = createMutatingAdmissionPolicy();
    server.expect().delete()
        .withPath("/apis/admissionregistration.k8s.io/v1/mutatingadmissionpolicies/sidecar-policy.example.com")
        .andReturn(HttpURLConnection.HTTP_OK, admissionPolicy)
        .once();

    // When
    boolean isDeleted = client.admissionRegistration().v1().mutatingAdmissionPolicies()
        .withName("sidecar-policy.example.com").delete().size() == 1;

    // Then
    AssertionsForClassTypes.assertThat(isDeleted).isTrue();
  }

  private MutatingAdmissionPolicy createMutatingAdmissionPolicy() {
    return new MutatingAdmissionPolicyBuilder()
        .withNewMetadata().withName("sidecar-policy.example.com").endMetadata()
        .withNewSpec()
        .addNewMutation().withNewApplyConfiguration("newExpression").withJsonPatch(new JSONPatch("someValue"))
        .withPatchType("someType").endMutation()
        .withNewMatchConstraints()
        .addNewResourceRule()
        .addToApiGroups("apps")
        .addToApiVersions("v1")
        .addToOperations("CREATE", "UPDATE")
        .addToResources("deployments")
        .endResourceRule()
        .endMatchConstraints()
        .endSpec()
        .build();
  }
}