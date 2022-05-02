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
package io.fabric8.kubernetes.client.readiness;

import io.fabric8.kubernetes.api.model.EndpointSubset;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeCondition;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodCondition;
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

import java.util.Objects;

public class Readiness {

  private static final String POD_READY = "Ready";
  private static final String NODE_READY = "Ready";
  private static final String TRUE = "True";
  private static final Logger logger = LoggerFactory.getLogger(Readiness.class);
  protected static final String READINESS_APPLICABLE_RESOURCES = "Node, Deployment, ReplicaSet, StatefulSet, Pod, ReplicationController";

  private static class ReadinessHolder {
    public static final Readiness INSTANCE = new Readiness();
  }

  public static Readiness getInstance() {
    return ReadinessHolder.INSTANCE;
  }

  /**
   * Checks if the provided {@link HasMetadata} is marked as ready by the cluster.
   *
   * <p>
   * A "Readiable" resources is a subjective trait for Kubernetes Resources. Many Resources, such as ConfigMaps,
   * Secrets, etc. become ready as soon as they've been created in the cluster.
   *
   * <p>
   * However, other resources such as Pods, Endpoints, Deployments, and controllers in general, only become
   * ready when their desired state matches their actual state.
   *
   * <p>
   * This method returns true for those "Readiable" resources once they are considered ready (even if the resource
   * exists in the cluster). For "non-Readiable" resources, this method returns true once the resources are created in
   * the cluster (in addition it logs a warning stating that the given resource is not considered "Readiable").
   *
   * @param item resource to be checked for Readiness.
   * @return true if it's a Readiable Resource and is ready, or it's a non-readiable resource and has been created. false
   *         otherwise.
   */
  public boolean isReady(HasMetadata item) {
    if (isReadinessApplicable(item)) {
      return isResourceReady(item);
    } else {
      return handleNonReadinessApplicableResource(item);
    }
  }

  protected boolean isReadinessApplicable(HasMetadata item) {
    return (item instanceof Deployment ||
        item instanceof io.fabric8.kubernetes.api.model.extensions.Deployment ||
        item instanceof ReplicaSet ||
        item instanceof Pod ||
        item instanceof ReplicationController ||
        item instanceof Endpoints ||
        item instanceof Node ||
        item instanceof StatefulSet);
  }

  protected boolean isResourceReady(HasMetadata item) {
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

  protected String getReadinessResourcesList() {
    return READINESS_APPLICABLE_RESOURCES;
  }

  final boolean handleNonReadinessApplicableResource(HasMetadata item) {
    boolean doesItemExist = Objects.nonNull(item);
    logger.warn("{} is not a Readiable resource. It needs to be one of [{}]",
        doesItemExist ? item.getKind() : "Unknown", getReadinessResourcesList());
    return doesItemExist;
  }

  public static boolean isStatefulSetReady(StatefulSet ss) {
    Utils.checkNotNull(ss, "StatefulSet can't be null.");
    StatefulSetSpec spec = ss.getSpec();
    StatefulSetStatus status = ss.getStatus();

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    if (spec.getReplicas() == 0) {
      return true;
    }

    if (status == null || status.getReplicas() == null || status.getReadyReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReplicas()
        && spec.getReplicas().intValue() == status.getReadyReplicas();
  }

  public static boolean isDeploymentReady(Deployment d) {
    Utils.checkNotNull(d, "Deployment can't be null.");
    DeploymentSpec spec = d.getSpec();
    DeploymentStatus status = d.getStatus();

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    if (spec.getReplicas() == 0) {
      return true;
    }

    if (status == null || status.getReplicas() == null || status.getAvailableReplicas() == null) {
      return false;
    }

    int replicas = Utils.getNonNullOrElse(spec.getReplicas(), 0);

    return replicas == status.getReplicas() &&
        replicas <= status.getAvailableReplicas();
  }

  public static boolean isExtensionsDeploymentReady(io.fabric8.kubernetes.api.model.extensions.Deployment d) {
    Utils.checkNotNull(d, "Deployment can't be null.");
    io.fabric8.kubernetes.api.model.extensions.DeploymentSpec spec = d.getSpec();
    io.fabric8.kubernetes.api.model.extensions.DeploymentStatus status = d.getStatus();

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    if (spec.getReplicas() == 0) {
      return true;
    }

    if (status == null || status.getReplicas() == null || status.getAvailableReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReplicas() &&
        spec.getReplicas() <= status.getAvailableReplicas();
  }

  public static boolean isReplicaSetReady(ReplicaSet r) {
    Utils.checkNotNull(r, "ReplicationController can't be null.");
    ReplicaSetSpec spec = r.getSpec();
    ReplicaSetStatus status = r.getStatus();

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    if (spec.getReplicas() == 0) {
      return true;
    }

    if (status == null || status.getReadyReplicas() == null) {
      return false;
    }

    return spec.getReplicas().intValue() == status.getReadyReplicas();
  }

  public static boolean isReplicationControllerReady(ReplicationController r) {
    Utils.checkNotNull(r, "ReplicationController can't be null.");
    ReplicationControllerSpec spec = r.getSpec();
    ReplicationControllerStatus status = r.getStatus();

    //Can be true in testing, so handle it to make test writing easier.
    if (spec == null || spec.getReplicas() == null) {
      return false;
    }

    if (spec.getReplicas() == 0) {
      return true;
    }

    if (status == null || status.getReadyReplicas() == null) {
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
      if (!subset.getAddresses().isEmpty() && !subset.getPorts().isEmpty()) {
        return true;
      }
    }
    return false;
  }

  public static boolean isPodReady(Pod pod) {
    Utils.checkNotNull(pod, "Pod can't be null.");
    PodCondition condition = getPodReadyCondition(pod);

    //Can be true in testing, so handle it to make test writing easier.
    if (condition == null || condition.getStatus() == null) {
      return false;
    }
    return condition.getStatus().equalsIgnoreCase(TRUE);
  }

  /**
   * Returns true if the Pod.status.phase is 'Succeeded'.
   *
   * @param pod the Pod to check the status phase of
   * @return true if the Pod is succeeded, false otherwise
   */
  public static boolean isPodSucceeded(Pod pod) {
    Utils.checkNotNull(pod, "Pod can't be null.");
    return pod.getStatus() != null && "Succeeded".equals(pod.getStatus().getPhase());
  }

  /**
   * Returns the ready condition of the pod.
   *
   * @param pod The target pod.
   * @return The {@link PodCondition} or null if not found.
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
