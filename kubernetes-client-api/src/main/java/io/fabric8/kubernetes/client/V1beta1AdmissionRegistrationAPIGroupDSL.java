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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfigurationList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingAdmissionPolicy;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingAdmissionPolicyBinding;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingAdmissionPolicyBindingList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingAdmissionPolicyList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfiguration;
import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfigurationList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1beta1AdmissionRegistrationAPIGroupDSL extends Client {
  MixedOperation<ValidatingWebhookConfiguration, ValidatingWebhookConfigurationList, Resource<ValidatingWebhookConfiguration>> validatingWebhookConfigurations();

  NonNamespaceOperation<MutatingWebhookConfiguration, MutatingWebhookConfigurationList, Resource<MutatingWebhookConfiguration>> mutatingWebhookConfigurations();

  /**
   * API entrypoint for admissionregistration.k8s.io/v1beta1 ValidatingAdmissionPolicy
   * <p>
   * ValidatingAdmissionPolicy describes the definition of an admission validation policy that accepts or
   * rejects an object without changing it.
   * </p>
   * 
   * @return NonNamespaceOperation for ValidatingAdmissionPolicy
   */
  NonNamespaceOperation<ValidatingAdmissionPolicy, ValidatingAdmissionPolicyList, Resource<ValidatingAdmissionPolicy>> validatingAdmissionPolicies();

  /**
   * API entrypoint for admissionregistration.k8s.io/v1beta1 ValidatingAdmissionPolicyBinding
   * <p>
   * ValidatingAdmissionPolicyBinding and parameter CRDs together define how cluster administrators configure policies for
   * clusters.
   * </p>
   * 
   * @return NonNamespaceOperation for ValidatingAdmissionPolicyBinding
   */
  NonNamespaceOperation<ValidatingAdmissionPolicyBinding, ValidatingAdmissionPolicyBindingList, Resource<ValidatingAdmissionPolicyBinding>> validatingAdmissionPolicyBindings();
}
