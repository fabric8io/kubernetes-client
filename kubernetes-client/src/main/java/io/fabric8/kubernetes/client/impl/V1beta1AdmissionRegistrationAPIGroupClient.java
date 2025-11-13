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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.*;
import io.fabric8.kubernetes.client.V1beta1AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

/**
 * Client implementation for the Kubernetes Admission Registration API Group v1beta1.
 * This client provides access to admission webhook configurations and admission policies
 * through a fluent DSL interface.
 */
public class V1beta1AdmissionRegistrationAPIGroupClient extends ClientAdapter<V1beta1AdmissionRegistrationAPIGroupClient>
    implements V1beta1AdmissionRegistrationAPIGroupDSL {

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ValidatingWebhookConfiguration, ValidatingWebhookConfigurationList, Resource<ValidatingWebhookConfiguration>> validatingWebhookConfigurations() {
    return resources(ValidatingWebhookConfiguration.class, ValidatingWebhookConfigurationList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<MutatingWebhookConfiguration, MutatingWebhookConfigurationList, Resource<MutatingWebhookConfiguration>> mutatingWebhookConfigurations() {
    return resources(MutatingWebhookConfiguration.class, MutatingWebhookConfigurationList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<MutatingAdmissionPolicy, MutatingAdmissionPolicyList, Resource<MutatingAdmissionPolicy>> mutatingAdmissionPolicies() {
    return resources(MutatingAdmissionPolicy.class, MutatingAdmissionPolicyList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<MutatingAdmissionPolicyBinding, MutatingAdmissionPolicyBindingList, Resource<MutatingAdmissionPolicyBinding>> validatingMutatingAdmissionPoliciesBindings() {
    return resources(MutatingAdmissionPolicyBinding.class, MutatingAdmissionPolicyBindingList.class);
  }

  /**
   * Creates a new instance of this client.
   *
   * @return a new V1beta1AdmissionRegistrationAPIGroupClient instance
   */
  @Override
  public V1beta1AdmissionRegistrationAPIGroupClient newInstance() {
    return new V1beta1AdmissionRegistrationAPIGroupClient();
  }
}
