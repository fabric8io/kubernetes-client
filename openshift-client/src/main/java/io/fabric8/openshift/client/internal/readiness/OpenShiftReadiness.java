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
package io.fabric8.openshift.client.internal.readiness;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigSpec;
import io.fabric8.openshift.api.model.DeploymentConfigStatus;

public class OpenShiftReadiness extends Readiness {
  public static boolean isReadinessApplicable(Class<? extends HasMetadata> itemClass) {
    return Readiness.isReadinessApplicable(itemClass)
      || DeploymentConfig.class.isAssignableFrom(itemClass)
      ;
  }

  public static boolean isReady(HasMetadata item) {
    if (Readiness.isReadiableKubernetesResource(item)) {
      return Readiness.isReady(item);
    } else if (item instanceof DeploymentConfig) {
      return isDeploymentConfigReady((DeploymentConfig) item);
    } else {
      throw new IllegalArgumentException("Item needs to be one of [Node, Deployment, ReplicaSet, StatefulSet, Pod, DeploymentConfig, ReplicationController], but was: [" + (item != null ? item.getKind() : "Unknown (null)") + "]");
    }
  }

  public static boolean isDeploymentConfigReady(DeploymentConfig d) {
    Utils.checkNotNull(d, "Deployment can't be null.");
    DeploymentConfigSpec spec = d.getSpec();
    DeploymentConfigStatus status = d.getStatus();

    if (status == null || status.getReplicas() == null || status.getAvailableReplicas() == null) {
      return false;
    }

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReplicas() &&
      spec.getReplicas() <= status.getAvailableReplicas();
  }
}
