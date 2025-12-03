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
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class V1beta1MutatingAdmissionPolicyBindingTest {

  KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-v1beta1-mutatingadmissionpolicybinding.yml"))
        .items();
    assertThat(items).isNotNull().hasSize(1);
    AssertionsForClassTypes.assertThat(items.get(0))
        .isInstanceOf(MutatingAdmissionPolicyBinding.class)
        .hasFieldOrPropertyWithValue("metadata.name", "simple-mutating-policy-binding");
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/admissionregistration.k8s.io/v1beta1/mutatingadmissionpolicybindings/demo-binding-test.example.com")
        .andReturn(HttpURLConnection.HTTP_OK, createMutatingAdmissionPolicyBinding())
        .once();

    // When
    MutatingAdmissionPolicyBinding mutatingAdmissionPolicyBinding = client.admissionRegistration().v1beta1()
        .mutatingAdmissionPolicyBindings().withName("demo-binding-test.example.com").get();

    // Then
    AssertionsForClassTypes.assertThat(mutatingAdmissionPolicyBinding)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "demo-binding-test.example.com");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/admissionregistration.k8s.io/v1beta1/mutatingadmissionpolicybindings")
        .andReturn(HttpURLConnection.HTTP_OK, new MutatingAdmissionPolicyBindingListBuilder()
            .addToItems(createMutatingAdmissionPolicyBinding())
            .build())
        .once();

    // When
    MutatingAdmissionPolicyBindingList flowSchemas = client.admissionRegistration().v1beta1()
        .mutatingAdmissionPolicyBindings().list();

    // Then
    AssertionsForClassTypes.assertThat(flowSchemas).isNotNull();
    assertThat(flowSchemas.getItems()).hasSize(1);
    AssertionsForClassTypes.assertThat(flowSchemas.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "demo-binding-test.example.com");
  }

  @Test
  void create() {
    // Given
    MutatingAdmissionPolicyBinding validatingAdmissionPolicyBinding = createMutatingAdmissionPolicyBinding();
    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1beta1/mutatingadmissionpolicybindings")
        .andReturn(HttpURLConnection.HTTP_OK, validatingAdmissionPolicyBinding)
        .once();

    // When
    MutatingAdmissionPolicyBinding mutatingAdmissionPolicyBinding = client.admissionRegistration().v1beta1()
        .mutatingAdmissionPolicyBindings().resource(validatingAdmissionPolicyBinding).create();

    // Then
    AssertionsForClassTypes.assertThat(mutatingAdmissionPolicyBinding).isNotNull();
    AssertionsForClassTypes.assertThat(mutatingAdmissionPolicyBinding)
        .hasFieldOrPropertyWithValue("metadata.name", "demo-binding-test.example.com");
  }

  @Test
  void delete() {
    // Given
    MutatingAdmissionPolicyBinding flowSchema = createMutatingAdmissionPolicyBinding();
    server.expect().delete()
        .withPath("/apis/admissionregistration.k8s.io/v1beta1/mutatingadmissionpolicybindings/demo-binding-test.example.com")
        .andReturn(HttpURLConnection.HTTP_OK, flowSchema)
        .once();

    // When
    boolean isDeleted = client.admissionRegistration().v1beta1().mutatingAdmissionPolicyBindings()
        .withName("demo-binding-test.example.com").delete().size() == 1;

    // Then
    AssertionsForClassTypes.assertThat(isDeleted).isTrue();
  }

  private MutatingAdmissionPolicyBinding createMutatingAdmissionPolicyBinding() {
    return new MutatingAdmissionPolicyBindingBuilder()
        .withNewMetadata().withName("demo-binding-test.example.com").endMetadata()
        .withNewSpec()
        .withPolicyName("demo-policy.example.com")
        .withNewMatchResources()
        .withNewNamespaceSelector()
        .addNewMatchExpression()
        .withKey("environment")
        .withOperator("In")
        .withValues("test")
        .endMatchExpression()
        .endNamespaceSelector()
        .endMatchResources()
        .endSpec()
        .build();
  }
}
