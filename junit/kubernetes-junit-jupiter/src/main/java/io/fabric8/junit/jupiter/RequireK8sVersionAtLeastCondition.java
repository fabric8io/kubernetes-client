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

import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.VersionInfo;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.platform.commons.support.AnnotationSupport.findAnnotation;

public class RequireK8sVersionAtLeastCondition implements ExecutionCondition {

  public static final String NON_NUMERIC_CHARACTERS = "[^\\d.]";

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    final RequireK8sVersionAtLeast requireK8s = findAnnotation(context.getElement(), RequireK8sVersionAtLeast.class)
        .orElse(null);
    if (requireK8s != null) {
      final int majorVersion = requireK8s.majorVersion();
      final int minorVersion = requireK8s.minorVersion();
      if (kubernetesVersionAtLeast(majorVersion, minorVersion)) {
        return ConditionEvaluationResult
            .enabled(String.format("Kubernetes version is at least %s.%s", majorVersion, minorVersion));
      } else {
        return ConditionEvaluationResult
            .disabled(String.format("Kubernetes version is below %s.%s", majorVersion, minorVersion));
      }
    }
    return ConditionEvaluationResult.enabled("RequireK8sVersionAtLeastCondition is not applicable");
  }

  boolean kubernetesVersionAtLeast(int majorVersion, int minorVersion) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      VersionInfo versionInfo = client.getKubernetesVersion();
      String clusterMajorVersion = versionInfo.getMajor().replaceAll(NON_NUMERIC_CHARACTERS, "");
      String clusterMinorVersion = versionInfo.getMinor().replaceAll(NON_NUMERIC_CHARACTERS, "");

      if (majorVersion < Integer.parseInt(clusterMajorVersion)) {
        return true;
      }

      return Integer.parseInt(clusterMajorVersion) >= majorVersion &&
          Integer.parseInt(clusterMinorVersion) >= minorVersion;
    }
  }
}
