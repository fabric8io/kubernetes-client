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

package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.ContainerState;
import io.fabric8.kubernetes.api.model.ContainerStatus;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodStatus;
import io.fabric8.kubernetes.client.readiness.Readiness;

import java.util.Collections;
import java.util.List;

public class PodStatusUtil {

  private static final String POD_RUNNING = "Running";
  private static final String POD_INITIALIZING = "PodInitializing";
  private static final String CONTAINER_COMPLETED = "Completed";

  private PodStatusUtil() {
  }

  /**
   * Returns {@code true} if the given pod is running. Returns {@code false} otherwise.
   *
   * The definition when a pod is considered running can be found at
   * <a href=
   * "https://github.com/openshift/origin/blob/master/vendor/k8s.io/api/core/v1/types.go#L3564">k8s.io/api/core/v1/types.go#L3564</a>
   * It states:
   * "PodRunning means the pod has been bound to a node and all of the containers have been started.
   * At least one container is still running or is in the process of being restarted."
   *
   * The logic is taken from <a href=
   * "https://github.com/openshift/origin/blob/master/vendor/k8s.io/kubernetes/pkg/printers/internalversion/printers.go#L695-L781">(kubernetes/printers.go)
   * printPod()</a>
   * and <a href=
   * "https://github.com/openshift/origin-web-console/blob/master/app/scripts/filters/resources.js#L1012-L1088">(openshift-web-console/resources.js)
   * podStatus()</a>
   *
   * @param pod the pod to return the running status for
   * @return returns true if the pod is running
   */
  public static boolean isRunning(Pod pod) {
    if (isInStatus(POD_RUNNING, pod)) {
      return true;
    }
    if (hasDeletionTimestamp(pod)
        || isInitializing(pod)) {
      return false;
    }
    if (hasRunningContainer(pod)) {
      return !hasCompletedContainer(pod)
          || Readiness.isPodReady(pod);
    }
    return false;
  }

  private static boolean isInStatus(String expected, Pod pod) {
    if (pod == null
        || pod.getStatus() == null
        || expected == null) {
      return false;
    }

    return expected.equals(pod.getStatus().getPhase())
        || expected.equals(pod.getStatus().getReason());
  }

  private static boolean hasDeletionTimestamp(Pod pod) {
    if (pod == null) {
      return false;
    }
    return pod.getMetadata() != null
        && pod.getMetadata().getDeletionTimestamp() != null;
  }

  /**
   * Returns {@code true} if the given pod has at least 1 container that's initializing.
   *
   * @param pod the pod to return the initializing status for
   * @return returns true if the pod is initializing
   */
  public static boolean isInitializing(Pod pod) {
    if (pod == null) {
      return false;
    }
    return pod.getStatus().getInitContainerStatuses().stream()
        .anyMatch(PodStatusUtil::isInitializing);
  }

  /**
   * Returns {@code true} if the given container status is terminated with an non-0 exit code or is waiting.
   * Returns {@code false} otherwise.
   */
  private static boolean isInitializing(ContainerStatus status) {
    if (status == null) {
      return true;
    }

    ContainerState state = status.getState();
    if (state == null) {
      return true;
    }
    if (isTerminated(state)) {
      return hasNonNullExitCode(state);
    } else if (isWaiting(state)) {
      return !isWaitingInitializing(state);
    } else {
      return true;
    }
  }

  private static boolean isTerminated(ContainerState state) {
    return state == null
        || state.getTerminated() != null;
  }

  private static boolean hasNonNullExitCode(ContainerState state) {
    return state.getTerminated() != null
        && state.getTerminated().getExitCode() != 0;
  }

  private static boolean isWaiting(ContainerState state) {
    return state == null
        || state.getWaiting() != null;
  }

  private static boolean isWaitingInitializing(ContainerState state) {
    return state != null
        && state.getWaiting() != null
        && POD_INITIALIZING.equals(state.getWaiting().getReason());
  }

  private static boolean hasRunningContainer(Pod pod) {
    return getContainerStatus(pod).stream()
        .anyMatch(PodStatusUtil::isRunning);
  }

  private static boolean isRunning(ContainerStatus status) {
    return status.getReady() != null
        && status.getState() != null
        && status.getState().getRunning() != null;
  }

  private static boolean hasCompletedContainer(Pod pod) {
    return getContainerStatus(pod).stream()
        .anyMatch(PodStatusUtil::isCompleted);
  }

  private static boolean isCompleted(ContainerStatus status) {
    return status.getState() != null
        && status.getState().getTerminated() != null
        && CONTAINER_COMPLETED.equals(status.getState().getTerminated().getReason());
  }

  /**
   * Returns the container status for all containers of the given pod. Returns an empty list
   * if the pod has no status
   *
   * @param pod the pod to return the container status for
   * @return list of container status
   *
   * @see Pod#getStatus()
   * @see PodStatus#getContainerStatuses()
   */
  public static List<ContainerStatus> getContainerStatus(Pod pod) {
    if (pod == null
        || pod.getStatus() == null) {
      return Collections.emptyList();
    }
    return pod.getStatus().getContainerStatuses();
  }

}