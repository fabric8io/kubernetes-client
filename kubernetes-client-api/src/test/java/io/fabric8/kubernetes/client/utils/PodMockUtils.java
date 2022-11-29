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
import io.fabric8.kubernetes.api.model.ContainerStateRunning;
import io.fabric8.kubernetes.api.model.ContainerStateTerminated;
import io.fabric8.kubernetes.api.model.ContainerStateWaiting;
import io.fabric8.kubernetes.api.model.ContainerStatus;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodCondition;
import io.fabric8.kubernetes.api.model.PodStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A class that allows mocking of the pod (resource). Various methods allow mocking of the different objects contained in a pod.
 */
public class PodMockUtils {

  /**
   * Returns a builder that allows to create a pod with the given name.
   *
   * @param name the name of the pod
   * @return the build that one can use to create a mock for a pod
   */
  public static PodMockBuilder pod(String name) {
    return new PodMockBuilder(name);
  }

  /**
   * Returns a {@link PodCondition} for the given type and status.
   *
   * @param type the type of the pod condition
   * @param status the status of the pod condition
   *
   * @return a pod condition
   *
   * @see PodStatus#getConditions()
   */
  public static PodCondition condition(String type, String status) {
    PodCondition mock = mock(PodCondition.class);
    when(mock.getType())
        .thenReturn(type);
    when(mock.getStatus())
        .thenReturn(status);
    return mock;
  }

  /**
   * Returns a {@link ContainerStatus} for the given {@link ContainerState}.
   * The ready property for the container status that's used is {@code false}
   *
   * @param state the container state for the container status
   * @return the container status
   *
   * @see PodStatus#getContainerStatuses()
   * @see ContainerStatus#getReady()
   */
  public static ContainerStatus containerStatus(ContainerState state) {
    return containerStatus(false, state);
  }

  /**
   * Returns a {@link ContainerStatus} for the given {@link ContainerState} and ready property.
   * The ready property for the container status that's used is {@code false}
   *
   * @param state the container state for the container status
   * @return the container status
   *
   * @see PodStatus#getContainerStatuses()
   * @see ContainerStatus#getReady()
   */
  public static ContainerStatus containerStatus(Boolean ready, ContainerState state) {
    ContainerStatus mock = mock(ContainerStatus.class);
    when(mock.getReady())
        .thenReturn(ready);
    when(mock.getState())
        .thenReturn(state);
    return mock;
  }

  /**
   * Returns a {@link ContainerState} for the given terminated, waiting and running state.
   *
   * @param terminated the terminated state
   * @param waiting the waiting state
   * @param running the running state
   *
   * @return a container state
   *
   * @see ContainerStatus#getState()
   */
  public static ContainerState containerState(ContainerStateTerminated terminated, ContainerStateWaiting waiting,
      ContainerStateRunning running) {
    ContainerState mock = mock(ContainerState.class);
    when(mock.getTerminated())
        .thenReturn(terminated);
    when(mock.getWaiting())
        .thenReturn(waiting);
    when(mock.getRunning())
        .thenReturn(running);
    return mock;
  }

  /**
   * Returns a {@link ContainerStateTerminated} for the given exit code and reason.
   *
   * @param exitCode the exist code
   * @param reason the reason
   *
   * @return the container state terminated
   *
   * @see ContainerState#getTerminated()
   */
  public static ContainerStateTerminated containerStateTerminated(Integer exitCode, String reason) {
    ContainerStateTerminated mock = mock(ContainerStateTerminated.class);
    when(mock.getExitCode())
        .thenReturn(exitCode);
    when(mock.getReason())
        .thenReturn(reason);
    return mock;
  }

  /**
   * Returns a {@link ContainerStateWaiting} for the given reason.
   *
   * @param reason the reason
   *
   * @return the container state waiting
   *
   * @see ContainerState#getWaiting()
   */
  public static ContainerStateWaiting containerStateWaiting(String reason) {
    ContainerStateWaiting mock = mock(ContainerStateWaiting.class);
    when(mock.getReason())
        .thenReturn(reason);
    return mock;
  }

  /**
   * Returns a {@link ContainerStateRunning}.
   *
   * @return the container state running
   *
   * @see ContainerState#getRunning()
   */
  public static ContainerStateRunning containerStateRunning() {
    return mock(ContainerStateRunning.class);
  }

  /**
   * A builder that allows to create a mock for a {@link Pod}.
   */
  static class PodMockBuilder {

    private final String name;
    private final String namespace;
    private final String uid;
    private PodStatus status;
    private String timestamp;

    PodMockBuilder(String name) {
      this(name, null, String.valueOf(System.currentTimeMillis()));
    }

    PodMockBuilder(String name, String namespace, String uid) {
      this.name = name;
      this.namespace = namespace;
      this.uid = uid;
    }

    /**
     * Sets the given pod to initializing. This is achieved by mocking an initContainerStatus that
     * is terminated with an exit code that's not 0.
     */
    public PodMockBuilder setInitializing() {
      ContainerStatus containerStatus = containerStatus(
          containerState(
              containerStateTerminated(42, null),
              null,
              null));
      initContainerStatus(Collections.singletonList(containerStatus));
      return this;
    }

    /**
     * Sets the given {@link PodStatus} to the pod that this builder is creating.
     *
     * @param status the status to use for the pod under construction
     *
     * @return the builder
     */
    public PodMockBuilder status(PodStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Returns a builder for the {@link PodStatus} in the pod under construction.
     *
     * @return the builder for the pod status for the pod under construction
     */
    public PodStatusMockBuilder statusBuilder() {
      return new PodStatusMockBuilder(this);
    }

    /**
     * Creates a {@link PodStatus} for given phase and reason for the pod under construction.
     *
     * @return the pod status
     */
    public PodMockBuilder status(String phase, String reason) {
      return status(phase, reason, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    /**
     * Sets an empty ContainerStatus to the pod under construction.
     *
     * @return the builder
     */
    public PodMockBuilder initContainerStatus() {
      return initContainerStatus(Collections.singletonList(containerStatus(null, null)));
    }

    public PodMockBuilder initContainerStatus(List<ContainerStatus> initContainerStatus) {
      return status(
          null,
          null,
          initContainerStatus,
          Collections.emptyList(),
          Collections.emptyList());
    }

    /**
     * Creates a {@link PodStatus} for the pod that this builder is creating.
     *
     * @param phase the phase for the pod status
     * @param reason the reason for the pod status
     * @param initContainerStatuses the init container statuses for the pod status
     * @param containerStatuses the container statuses for the pod status
     * @param conditions the conditions for the pod status
     *
     * @return the builder
     */
    public PodMockBuilder status(
        String phase,
        String reason,
        List<ContainerStatus> initContainerStatuses,
        List<ContainerStatus> containerStatuses,
        List<PodCondition> conditions) {
      PodStatus mock = mock(PodStatus.class);
      when(mock.getPhase())
          .thenReturn(phase);
      when(mock.getReason())
          .thenReturn(reason);
      when(mock.getInitContainerStatuses())
          .thenReturn(initContainerStatuses);
      when(mock.getContainerStatuses())
          .thenReturn(containerStatuses);
      when(mock.getConditions())
          .thenReturn(conditions);
      return status(mock);
    }

    /**
     * Creates a deletion timestamp for given timestamp for the pod under construction.
     *
     * @param timestamp the timestamp for the deletion timestamp
     * @return the builder
     *
     * @see ObjectMeta#getDeletionTimestamp()
     */
    public PodMockBuilder deletion(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Creates the pod for this builder
     * 
     * @return
     */
    public Pod build() {
      Pod pod = pod(name, namespace, uid);
      when(pod.getStatus())
          .thenReturn(status);
      when(pod.getMetadata().getDeletionTimestamp())
          .thenReturn(timestamp);
      return pod;
    }

    private Pod pod(String name, String namespace, String uid) {
      ObjectMeta metadata = metadata(name, namespace, uid);
      Pod mock = mock(Pod.class);
      when(mock.getMetadata())
          .thenReturn(metadata);
      when(mock.getApiVersion())
          .thenReturn("PodMock");
      when(mock.getKind())
          .thenReturn(Pod.class.getSimpleName());
      return mock;
    }

    private ObjectMeta metadata() {
      return metadata(null, null, null);
    }

    private ObjectMeta metadata(String name, String namespace, String uid) {
      ObjectMeta metaData = mock(ObjectMeta.class);
      when(metaData.getName())
          .thenReturn(name);
      when(metaData.getNamespace())
          .thenReturn(namespace);
      when(metaData.getUid())
          .thenReturn(uid);
      return metaData;
    }
  }

  /**
   * A builder that allows to create a mock for a {@link PodStatus}.
   */
  static public class PodStatusMockBuilder {

    private final PodMockBuilder parent;
    private String phase;
    private String reason;
    private List<ContainerStatus> initContainerStatuses = Collections.emptyList();
    private List<ContainerStatus> containerStatuses = Collections.emptyList();
    private List<PodCondition> podConditions = Collections.emptyList();

    private PodStatusMockBuilder(PodMockBuilder parent) {
      this.parent = parent;
    }

    /**
     * Sets the phase for the pod status under construction.
     *
     * @param phase the phase for this pod status
     * @return the builder
     */
    public PodStatusMockBuilder phase(String phase) {
      this.phase = phase;
      return this;
    }

    /**
     * Sets the reason for the pod status under construction.
     *
     * @param reason the phase for this pod status
     * @return the builder
     */
    public PodStatusMockBuilder reason(String reason) {
      this.reason = reason;
      return this;
    }

    /**
     * Sets the given init container Statuses for the pod status under construction.
     *
     * @param initContainerStatuses the init container statuses
     * @return the builder
     */
    public PodStatusMockBuilder initContainerStatuses(List<ContainerStatus> initContainerStatuses) {
      this.initContainerStatuses = initContainerStatuses;
      return this;
    }

    /**
     * Sets the given init container Statuses for the pod status under construction.
     *
     * @param initContainerStatuses the init container statuses
     * @return the builder
     *
     * @see PodStatus#getInitContainerStatuses()
     */
    public PodStatusMockBuilder initContainerStatuses(ContainerStatus... initContainerStatuses) {
      return initContainerStatuses(Arrays.asList(initContainerStatuses));
    }

    /**
     * Sets the given container Statuses for the pod status under construction.
     *
     * @param containerStatuses the init container statuses
     * @return the builder
     *
     * @see PodStatus#getContainerStatuses()
     */
    public PodStatusMockBuilder containerStatuses(List<ContainerStatus> containerStatuses) {
      this.containerStatuses = containerStatuses;
      return this;
    }

    /**
     * Sets the given container Statuses for the pod status under construction.
     *
     * @param containerStatuses the init container statuses
     * @return the builder
     *
     * @see PodStatus#getContainerStatuses()
     */
    public PodStatusMockBuilder containerStatuses(ContainerStatus... containerStatuses) {
      return containerStatuses(Arrays.asList(containerStatuses));
    }

    /**
     * Sets the given pod conditions for the pod status under construction.
     *
     * @param podConditions the pod conditions for this pod status
     * @return
     *
     * @see PodStatus#getConditions()
     */
    public PodStatusMockBuilder podConditions(List<PodCondition> podConditions) {
      this.podConditions = podConditions;
      return this;
    }

    /**
     * Sets the given pod conditions for the pod status under construction.
     *
     * @param podConditions the pod conditions for this pod status
     * @return
     *
     * @see PodStatus#getConditions()
     */
    public PodStatusMockBuilder podConditions(PodCondition... podConditions) {
      return podConditions(Arrays.asList(podConditions));
    }

    /**
     * Creates the {@link PodStatus} for this builder.
     *
     * @return the pod builder for this pod status builderP
     */
    public PodMockBuilder build() {
      parent.status(phase, reason, initContainerStatuses, containerStatuses, podConditions);
      return parent;
    }

  }
}
