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
package io.fabric8.junit.jupiter;

import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.platform.commons.support.AnnotationSupport.findAnnotation;

public class RequireK8sSupportCondition implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    final RequireK8sSupport requireK8s = findAnnotation(context.getElement(), RequireK8sSupport.class)
        .orElse(null);
    if (requireK8s != null) {
      try (KubernetesClient client = new KubernetesClientBuilder().build()) {
        if (client.supports(requireK8s.value())) {
          return ConditionEvaluationResult
              .enabled(String.format("Kubernetes resource %s IS supported in this cluster", requireK8s.value().getName()));
        } else {
          return ConditionEvaluationResult
              .disabled(String.format("Kubernetes resource %s IS NOT supported in this cluster", requireK8s.value().getName()));
        }
      }
    }
    return ConditionEvaluationResult.enabled("RequireK8sSupportCondition is not applicable");
  }
}
