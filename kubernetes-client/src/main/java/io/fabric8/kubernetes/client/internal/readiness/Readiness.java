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
package io.fabric8.kubernetes.client.internal.readiness;

import io.fabric8.kubernetes.api.model.EndpointSubset;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodCondition;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerSpec;
import io.fabric8.kubernetes.api.model.ReplicationControllerStatus;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentSpec;
import io.fabric8.kubernetes.api.model.extensions.DeploymentStatus;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetSpec;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetStatus;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigSpec;
import io.fabric8.openshift.api.model.DeploymentConfigStatus;

public class Readiness {

  private static final String POD_READY = "Ready";
  private static final String TRUE = "True";


  public static boolean isReadinessApplicable(HasMetadata item) {
    return (item instanceof Deployment) ||
      (item instanceof ReplicaSet) ||
      (item instanceof Pod) ||
      (item instanceof DeploymentConfig) ||
      (item instanceof ReplicationController) ||
      (item instanceof Endpoints);
  }

  public static boolean isReady(HasMetadata item) {
    if (item instanceof Deployment) {
      return isDeploymentReady((Deployment) item);
    } else if (item instanceof ReplicaSet) {
      return isReplicaSetReady((ReplicaSet) item);
    } else if (item instanceof Pod) {
      return isPodReady((Pod) item);
    } else if (item instanceof DeploymentConfig) {
      return isDeploymentConfigReady((DeploymentConfig) item);
    } else if (item instanceof ReplicationController) {
      return isReplicationControllerReady((ReplicationController) item);
    } else if (item instanceof Endpoints) {
      return isEndpointsReady((Endpoints)item);
    } else {
      throw new IllegalArgumentException("Item needs to be one of [Deployment, ReplicaSet, Pod, DeploymentConfig, ReplicationController], but was: [" + item.getKind() + "]");
    }
  }

  public static boolean isDeploymentReady(Deployment d) {
    Utils.checkNotNull(d, "Deployment can't be null.");
    DeploymentSpec spec = d.getSpec();
    DeploymentStatus status = d.getStatus();

    return spec.getReplicas().intValue() == status.getReplicas() &&
      spec.getReplicas().intValue() <= status.getAvailableReplicas();
  }


  public static boolean isReplicaSetReady(ReplicaSet r) {
    Utils.checkNotNull(r, "ReplicationController can't be null.");
    ReplicaSetSpec spec = r.getSpec();
    ReplicaSetStatus status = r.getStatus();

    return spec.getReplicas().intValue() == status.getReadyReplicas();
  }


  public static boolean isDeploymentConfigReady(DeploymentConfig d) {
    Utils.checkNotNull(d, "Deployment can't be null.");
    DeploymentConfigSpec spec = d.getSpec();
    DeploymentConfigStatus status = d.getStatus();

    return spec.getReplicas().intValue() == status.getReplicas() &&
      spec.getReplicas().intValue() <= status.getAvailableReplicas();
  }

  public static boolean isReplicationControllerReady(ReplicationController r) {
    Utils.checkNotNull(r, "ReplicationController can't be null.");
    ReplicationControllerSpec spec = r.getSpec();
    ReplicationControllerStatus status = r.getStatus();

    return spec.getReplicas().intValue() == status.getReadyReplicas();
  }

  public static boolean isEndpointsReady(Endpoints e) {
    Utils.checkNotNull(e, "Endpoints can't be null.");
    String name = e.getMetadata().getName();
    Utils.checkNotNull(name, "Endpoints name can't be null.");

    for (EndpointSubset subset : e.getSubsets()) {
      if(!subset.getAddresses().isEmpty() && !subset.getPorts().isEmpty()) {
        return true;
      }
    }
    return true;
  }

  public static boolean isPodReady(Pod pod) {
    Utils.checkNotNull(pod, "Pod can't be null.");
    PodCondition condition = getPodReadyCondition(pod);
    return condition.getStatus().equalsIgnoreCase(TRUE);
  }


  private static PodCondition getPodReadyCondition(Pod pod) {
    Utils.checkNotNull(pod, "Pod can't be null.");
    Utils.checkNotNull(pod.getStatus(), "Pod status can't be null.");
    Utils.checkNotNull(pod.getStatus().getConditions(), "Pod conditions can't be null.");

    for (PodCondition condition : pod.getStatus().getConditions()) {
      if (POD_READY.equals(condition.getType())) {
        return condition;
      }
    }
    throw new IllegalStateException("Can't find ready condition for pod: [" + pod.getMetadata().getName() + "].");
  }
}


