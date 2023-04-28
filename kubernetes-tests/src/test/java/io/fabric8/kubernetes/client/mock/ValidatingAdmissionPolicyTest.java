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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicy;
import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicyBuilder;
import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicyList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicyListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class ValidatingAdmissionPolicyTest {

  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/test-v1alpha1-validatingadmissionpolicy.yml"))
        .items();
    assertThat(items).isNotNull().hasSize(1);
    AssertionsForClassTypes.assertThat(items.get(0))
        .isInstanceOf(ValidatingAdmissionPolicy.class)
        .hasFieldOrPropertyWithValue("metadata.name", "demo-policy.example.com");
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/admissionregistration.k8s.io/v1alpha1/validatingadmissionpolicies/demo-policy.example.com")
        .andReturn(HttpURLConnection.HTTP_OK, createValidatingAdmissionPolicy())
        .once();

    // When
    ValidatingAdmissionPolicy validatingAdmissionPolicy = client.admissionRegistration().v1alpha1()
        .validatingAdmissionPolicies().withName("demo-policy.example.com").get();

    // Then
    AssertionsForClassTypes.assertThat(validatingAdmissionPolicy)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "demo-policy.example.com");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/admissionregistration.k8s.io/v1alpha1/validatingadmissionpolicies")
        .andReturn(HttpURLConnection.HTTP_OK, new ValidatingAdmissionPolicyListBuilder()
            .addToItems(createValidatingAdmissionPolicy())
            .build())
        .once();

    // When
    ValidatingAdmissionPolicyList flowSchemas = client.admissionRegistration().v1alpha1().validatingAdmissionPolicies().list();

    // Then
    AssertionsForClassTypes.assertThat(flowSchemas).isNotNull();
    assertThat(flowSchemas.getItems()).hasSize(1);
    AssertionsForClassTypes.assertThat(flowSchemas.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "demo-policy.example.com");
  }

  @Test
  void create() {
    // Given
    ValidatingAdmissionPolicy validatingAdmissionPolicy = createValidatingAdmissionPolicy();
    server.expect().post().withPath("/apis/admissionregistration.k8s.io/v1alpha1/validatingadmissionpolicies")
        .andReturn(HttpURLConnection.HTTP_OK, validatingAdmissionPolicy)
        .once();

    // When
    ValidatingAdmissionPolicy createdValidatingAdmissionPolicy = client.admissionRegistration().v1alpha1()
        .validatingAdmissionPolicies().resource(validatingAdmissionPolicy).create();

    // Then
    AssertionsForClassTypes.assertThat(createdValidatingAdmissionPolicy).isNotNull();
    AssertionsForClassTypes.assertThat(createdValidatingAdmissionPolicy)
        .hasFieldOrPropertyWithValue("metadata.name", "demo-policy.example.com");
  }

  @Test
  void delete() {
    // Given
    ValidatingAdmissionPolicy flowSchema = createValidatingAdmissionPolicy();
    server.expect().delete()
        .withPath("/apis/admissionregistration.k8s.io/v1alpha1/validatingadmissionpolicies/demo-policy.example.com")
        .andReturn(HttpURLConnection.HTTP_OK, flowSchema)
        .once();

    // When
    boolean isDeleted = client.admissionRegistration().v1alpha1().validatingAdmissionPolicies()
        .withName("demo-policy.example.com").delete().size() == 1;

    // Then
    AssertionsForClassTypes.assertThat(isDeleted).isTrue();
  }

  private ValidatingAdmissionPolicy createValidatingAdmissionPolicy() {
    return new ValidatingAdmissionPolicyBuilder()
        .withNewMetadata().withName("demo-policy.example.com").endMetadata()
        .withNewSpec()
        .addNewValidation().withExpression("object.spec.replicas <= 5").endValidation()
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
