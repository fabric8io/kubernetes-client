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
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentSpec;
import io.fabric8.kubernetes.api.model.apps.DeploymentStatus;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetSpec;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetStatus;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetSpec;
import io.fabric8.kubernetes.api.model.apps.StatefulSetStatus;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Readiness {

  private static final String POD_READY = "Ready";
  private static final String NODE_READY = "Ready";
  private static final String TRUE = "True";
  private static final Logger logger = LoggerFactory.getLogger(Readiness.class);

  public static boolean isReadinessApplicable(Class<? extends HasMetadata> itemClass) {
    return Deployment.class.isAssignableFrom(itemClass)
      || io.fabric8.kubernetes.api.model.extensions.Deployment.class.isAssignableFrom(itemClass)
      || ReplicaSet.class.isAssignableFrom(itemClass)
      || Pod.class.isAssignableFrom(itemClass)
      || ReplicationController.class.isAssignableFrom(itemClass)
      || Endpoints.class.isAssignableFrom(itemClass)
      || Node.class.isAssignableFrom(itemClass)
      || StatefulSet.class.isAssignableFrom(itemClass)
      ;
  }

  public static boolean isReady(HasMetadata item) {
    if (isReadiableKubernetesResource(item)) {
      return isKubernetesResourceReady(item);
    } else {
      return handleNonReadinessApplicableResource(item, getReadinessApplicableResourcesList());
    }
  }

  public static boolean handleNonReadinessApplicableResource(HasMetadata item, List<String> readinessApplicableResources) {
    boolean doesItemExist = Objects.nonNull(item);
    String readinessApplicableResourcesStr = String.join(",", readinessApplicableResources);
    logger.warn("{} is not a Readiableresource. It needs to be one of [{}]",
      doesItemExist ? item.getKind() : "Unknown", readinessApplicableResourcesStr);
    return doesItemExist;
  }

  public static List<String> getReadinessApplicableResourcesList() {
    List<String> readinessApplicableResources = new ArrayList<>();
    readinessApplicableResources.add("Node");
    readinessApplicableResources.add("Deployment");
    readinessApplicableResources.add("ReplicaSet");
    readinessApplicableResources.add("StatefulSet");
    readinessApplicableResources.add("Pod");
    readinessApplicableResources.add("ReplicationController");

    return readinessApplicableResources;
  }

  private static boolean isKubernetesResourceReady(HasMetadata item) {
    if (item instanceof Deployment) {
      return isDeploymentReady((Deployment) item);
    } else if (item instanceof io.fabric8.kubernetes.api.model.extensions.Deployment) {
      return isExtensionsDeploymentReady((io.fabric8.kubernetes.api.model.extensions.Deployment) item);
    } else if (item instanceof ReplicaSet) {
      return isReplicaSetReady((ReplicaSet) item);
    } else if (item instanceof Pod) {
      return isPodReady((Pod) item);
    } else if (item instanceof ReplicationController) {
      return isReplicationControllerReady((ReplicationController) item);
    } else if (item instanceof Endpoints) {
      return isEndpointsReady((Endpoints) item);
    } else if (item instanceof Node) {
      return isNodeReady((Node) item);
    } else if (item instanceof StatefulSet) {
      return isStatefulSetReady((StatefulSet) item);
    }
    return false;
  }

  public static boolean isStatefulSetReady(StatefulSet ss) {
    Utils.checkNotNull(ss, "StatefulSet can't be null.");
    StatefulSetSpec spec = ss.getSpec();
    StatefulSetStatus status = ss.getStatus();

    if (status == null || status.getReplicas() == null || status.getReadyReplicas() == null) {
      return false;
    }

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReplicas()
      && spec.getReplicas().intValue() == status.getReadyReplicas();
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
      spec.getReplicas() <= status.getAvailableReplicas();
  }


  public static boolean isExtensionsDeploymentReady(io.fabric8.kubernetes.api.model.extensions.Deployment d) {
    Utils.checkNotNull(d, "Deployment can't be null.");
    io.fabric8.kubernetes.api.model.extensions.DeploymentSpec spec = d.getSpec();
    io.fabric8.kubernetes.api.model.extensions.DeploymentStatus status = d.getStatus();

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

  protected static boolean isReadiableKubernetesResource(HasMetadata item) {
    return (item instanceof Deployment ||
      item instanceof io.fabric8.kubernetes.api.model.extensions.Deployment ||
    item instanceof ReplicaSet ||
    item instanceof Pod ||
    item instanceof ReplicationController ||
    item instanceof Endpoints ||
    item instanceof Node ||
    item instanceof StatefulSet);
  }
}


