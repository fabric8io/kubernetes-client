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
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeCondition;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerSpec;
import io.fabric8.kubernetes.api.model.ReplicationControllerStatus;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentSpec;
import io.fabric8.kubernetes.api.model.extensions.DeploymentStatus;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetSpec;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetStatus;
import io.fabric8.kubernetes.api.model.extensions.StatefulSet;
import io.fabric8.kubernetes.api.model.extensions.StatefulSetSpec;
import io.fabric8.kubernetes.api.model.extensions.StatefulSetStatus;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigSpec;
import io.fabric8.openshift.api.model.DeploymentConfigStatus;

public class Readiness {

  private static final String POD_READY = "Ready";
  private static final String NODE_READY = "Ready";
  private static final String TRUE = "True";


  public static boolean isReadinessApplicable(HasMetadata item) {
    return (item instanceof Deployment) ||
      (item instanceof ReplicaSet) ||
      (item instanceof Pod) ||
      (item instanceof DeploymentConfig) ||
      (item instanceof ReplicationController) ||
      (item instanceof Endpoints) ||
      (item instanceof Node);
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
      return isEndpointsReady((Endpoints) item);
    } else if (item instanceof Node) {
      return isNodeReady((Node) item);
    } else if (item instanceof StatefulSet) {
      return isStatefulSetReady((StatefulSet) item);
    } else {
      throw new IllegalArgumentException("Item needs to be one of [Node, Deployment, ReplicaSet, StatefulSet, Pod, DeploymentConfig, ReplicationController], but was: [" + item.getKind() + "]");
    }
  }

  public static boolean isStatefulSetReady(StatefulSet ss) {
    Utils.checkNotNull(ss, "StatefulSet can't be null.");
    StatefulSetSpec spec = ss.getSpec();
    StatefulSetStatus status =ss.getStatus();

    if (status == null || status.getReplicas() == null) {
      return false;
    }

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReplicas();
  }


  public static boolean isDeploymentReady(Deployment d) {
    Utils.checkNotNull(d, "Deployment can't be null.");
    DeploymentSpec spec = d.getSpec();
    DeploymentStatus status = d.getStatus();

    if (status == null || status.getReplicas() == null || status.getAvailableReplicas() == null) {
      return false;
    }

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReplicas() &&
      spec.getReplicas().intValue() <= status.getAvailableReplicas();
  }


  public static boolean isReplicaSetReady(ReplicaSet r) {
    Utils.checkNotNull(r, "ReplicationController can't be null.");
    ReplicaSetSpec spec = r.getSpec();
    ReplicaSetStatus status = r.getStatus();

    if (status == null || status.getReadyReplicas() == null) {
      return false;
    }

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }
    return spec.getReplicas().intValue() == status.getReadyReplicas();
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
      spec.getReplicas().intValue() <= status.getAvailableReplicas();
  }

  public static boolean isReplicationControllerReady(ReplicationController r) {
    Utils.checkNotNull(r, "ReplicationController can't be null.");
    ReplicationControllerSpec spec = r.getSpec();
    ReplicationControllerStatus status = r.getStatus();

    if (status == null || status.getReadyReplicas() == null) {
      return false;
    }

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReadyReplicas();
  }

  public static boolean isEndpointsReady(Endpoints e) {
    Utils.checkNotNull(e, "Endpoints can't be null.");
    String name = e.getMetadata().getName();
    Utils.checkNotNull(name, "Endpoints name can't be null.");

    if (e.getSubsets() == null) {
      return false;
    }

    for (EndpointSubset subset : e.getSubsets()) {
      if(!subset.getAddresses().isEmpty() && !subset.getPorts().isEmpty()) {
        return true;
      }
    }
    return false;
  }

  public static boolean isPodReady(Pod pod) {
    Utils.checkNotNull(pod, "Pod can't be null.");
    PodCondition condition = getPodReadyCondition(pod);

    //Can be true in testing, so handle it to make test writing easier.
    if (condition == null  || condition.getStatus() == null) {
      return false;
    }
    return condition.getStatus().equalsIgnoreCase(TRUE);
  }


  /**
   * Returns the ready condition of the pod.
   * @param pod   The target pod.
   * @return      The {@link PodCondition} or null if not found.
   */
  private static PodCondition getPodReadyCondition(Pod pod) {
    Utils.checkNotNull(pod, "Pod can't be null.");

    if (pod.getStatus() == null || pod.getStatus().getConditions() == null) {
      return null;
    }

    for (PodCondition condition : pod.getStatus().getConditions()) {
      if (POD_READY.equals(condition.getType())) {
        return condition;
      }
    }
    return null;
  }

  public static boolean isNodeReady(Node node) {
    Utils.checkNotNull(node, "Node can't be null.");
    NodeCondition condition = getNodeReadyCondition(node);
    if (condition == null || condition.getStatus() == null) {
      return false;
    }
    return condition.getStatus().equalsIgnoreCase(TRUE);
  }

  /**
   * Returns the ready condition of the node.
   * 
   * @param node The target node.
   * @return The {@link NodeCondition} or null if not found.
   */
  private static NodeCondition getNodeReadyCondition(Node node) {
    Utils.checkNotNull(node, "Node can't be null.");

    if (node.getStatus() == null || node.getStatus().getConditions() == null) {
      return null;
    }

    for (NodeCondition condition : node.getStatus().getConditions()) {
      if (NODE_READY.equals(condition.getType())) {
        return condition;
      }
    }
    return null;
  }
}


