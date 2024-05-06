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
package io.fabric8.crd.generator.approvaltests.k8svalidation;

import io.fabric8.generator.annotation.ValidationRule;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("samples.fabric8.io")
@Version("v1alpha1")
@ValidationRule(value = "self.metadata.name.startsWith(self.spec.namePrefix)", messageExpression = "'name must start with ' + self.spec.namePrefix", reason = "FieldValueForbidden")
@ValidationRule(value = "self.status.availableReplicas >= self.spec.minReplicas", message = "updates not allowed in degraded state")
public class K8sValidation extends CustomResource<K8sValidationSpec, K8sValidationStatus> {

  @Override
  @ValidationRule(value = "self.minReplicas <= self.replicas", message = "replicas must be greater than or equal to minReplicas")
  @ValidationRule(value = "self.replicas <= self.maxReplicas", message = "replicas must be smaller than or equal to maxReplicas")
  public K8sValidationSpec getSpec() {
    return super.getSpec();
  }
}
