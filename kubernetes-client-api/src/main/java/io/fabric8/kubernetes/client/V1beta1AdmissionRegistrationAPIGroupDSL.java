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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfigurationList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfigurationList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingAdmissionPolicy;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingAdmissionPolicyList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingAdmissionPolicyBinding;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingAdmissionPolicyBindingList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

/**
 * DSL interface for interacting with the Kubernetes Admission Registration API Group v1beta1.
 * Provides access to admission webhook configurations and admission policies.
 */
public interface V1beta1AdmissionRegistrationAPIGroupDSL extends Client {
  /**
   * Gets a mixed operation for ValidatingWebhookConfiguration resources.
   * ValidatingWebhookConfigurations describe the configuration of admission webhooks that validate requests.
   *
   * @return the mixed operation for ValidatingWebhookConfiguration
   */
  MixedOperation<ValidatingWebhookConfiguration, ValidatingWebhookConfigurationList, Resource<ValidatingWebhookConfiguration>> validatingWebhookConfigurations();

  /**
   * Gets a non-namespace operation for MutatingWebhookConfiguration resources.
   * MutatingWebhookConfigurations describe the configuration of admission webhooks that mutate requests.
   *
   * @return the non-namespace operation for MutatingWebhookConfiguration
   */
  NonNamespaceOperation<MutatingWebhookConfiguration, MutatingWebhookConfigurationList, Resource<MutatingWebhookConfiguration>> mutatingWebhookConfigurations();

  /**
   * Gets a non-namespace operation for MutatingAdmissionPolicy resources.
   * MutatingAdmissionPolicies describe the definition of admission mutation policies that mutate objects coming into the admission chain.
   *
   * @return the non-namespace operation for MutatingAdmissionPolicy
   */
  NonNamespaceOperation<MutatingAdmissionPolicy, MutatingAdmissionPolicyList, Resource<MutatingAdmissionPolicy>> mutatingAdmissionPolicies();

  /**
   * Gets a non-namespace operation for MutatingAdmissionPolicyBinding resources.
   * MutatingAdmissionPolicyBindings bind MutatingAdmissionPolicies with parameterized resources.
   *
   * @return the non-namespace operation for MutatingAdmissionPolicyBinding
   */
  NonNamespaceOperation<MutatingAdmissionPolicyBinding, MutatingAdmissionPolicyBindingList, Resource<MutatingAdmissionPolicyBinding>> validatingMutatingAdmissionPoliciesBindings();
}
