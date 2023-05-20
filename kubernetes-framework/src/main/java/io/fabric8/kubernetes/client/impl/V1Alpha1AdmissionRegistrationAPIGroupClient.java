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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicy;
import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicyBinding;
import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicyBindingList;
import io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1.ValidatingAdmissionPolicyList;
import io.fabric8.kubernetes.client.V1Alpha1AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1Alpha1AdmissionRegistrationAPIGroupClient extends ClientAdapter<V1Alpha1AdmissionRegistrationAPIGroupClient>
    implements V1Alpha1AdmissionRegistrationAPIGroupDSL {
  @Override
  public V1Alpha1AdmissionRegistrationAPIGroupClient newInstance() {
    return new V1Alpha1AdmissionRegistrationAPIGroupClient();
  }

  @Override
  public NonNamespaceOperation<ValidatingAdmissionPolicy, ValidatingAdmissionPolicyList, Resource<ValidatingAdmissionPolicy>> validatingAdmissionPolicies() {
    return resources(ValidatingAdmissionPolicy.class, ValidatingAdmissionPolicyList.class);
  }

  @Override
  public NonNamespaceOperation<ValidatingAdmissionPolicyBinding, ValidatingAdmissionPolicyBindingList, Resource<ValidatingAdmissionPolicyBinding>> validatingAdmissionPolicyBindings() {
    return resources(ValidatingAdmissionPolicyBinding.class, ValidatingAdmissionPolicyBindingList.class);
  }
}
