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

import io.fabric8.kubernetes.api.model.ContainerStatus;
import io.fabric8.kubernetes.api.model.Pod;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.fabric8.kubernetes.client.utils.PodMockUtils.condition;
import static io.fabric8.kubernetes.client.utils.PodMockUtils.containerState;
import static io.fabric8.kubernetes.client.utils.PodMockUtils.containerStateRunning;
import static io.fabric8.kubernetes.client.utils.PodMockUtils.containerStateTerminated;
import static io.fabric8.kubernetes.client.utils.PodMockUtils.containerStateWaiting;
import static io.fabric8.kubernetes.client.utils.PodMockUtils.containerStatus;
import static io.fabric8.kubernetes.client.utils.PodMockUtils.pod;
import static org.assertj.core.api.Assertions.assertThat;

class PodStatusUtilTest {

  private ContainerStatus runningReady = containerStatus(
      true,
      containerState(
          null,
          null,
          containerStateRunning()));

  @Test
  void isRunning_should_return_true_if_pod_is_in_phase_running() {
    // given
    Pod pod = pod("starwars")
        .status("Running", "<Darth Vader has lost its sabre>")
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isTrue();
  }

  @Test
  void isRunning_should_return_true_if_pod_has_reason_running() {
    // given
    Pod pod = pod("anakin")
        .status("<transition to the dark side>", "Running")
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isTrue();
  }

  @Test
  void isRunning_should_return_false_if_pod_has_deletion_Timestamp() {
    // given
    Pod pod = pod("some pod")
        .status("", "")
        .deletion("2020-06-10")
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isFalse();
  }

  @Test
  void isRunning_should_return_false_if_pod_is_initializing() {
    // given
    Pod pod = pod("some pod")
        .setInitializing()
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isFalse();
  }

  @Test
  void isInitializing_should_return_false_if_pod_has_no_initContainerStatus() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .build()
        .build();
    // when
    boolean initializing = PodStatusUtil.isInitializing(pod);
    // then
    assertThat(initializing).isFalse();
  }

  @Test
  void isInitializing_should_return_true_if_pod_has_initContainerStatus_without_state() {
    // given
    Pod pod = pod("some pod")
        .initContainerStatus()
        .build();
    // when
    boolean initializing = PodStatusUtil.isInitializing(pod);
    // then
    assertThat(initializing).isTrue();
  }

  @Test
  void isInitializing_should_return_true_if_pod_has_initContainerStatus_without_terminated_value_nor_waiting_value() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .initContainerStatuses(
            containerStatus(false, containerState(null, null, null)))
        .build()
        .build();
    // when
    boolean initializing = PodStatusUtil.isInitializing(pod);
    // then
    assertThat(initializing).isTrue();
  }

  @Test
  void isInitializing_should_return_true_if_pod_has_initContainerStatus_without_terminated_value_but_waiting_value() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .initContainerStatuses(
            containerStatus(
                false,
                containerState(
                    null,
                    containerStateWaiting("WaitingForTheBus"),
                    null)))
        .build()
        .build();
    // when
    boolean initializing = PodStatusUtil.isInitializing(pod);
    // then
    assertThat(initializing).isTrue();
  }

  @Test
  void isInitializing_should_return_false_if_pod_has_initContainerStatus_without_terminated_value_but_waiting_value_PodInitializing() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .initContainerStatuses(
            containerStatus(
                false,
                containerState(
                    null,
                    containerStateWaiting("PodInitializing"),
                    null)))
        .build()
        .build();
    // when
    boolean initializing = PodStatusUtil.isInitializing(pod);
    // then
    assertThat(initializing).isFalse();
  }

  @Test
  void isInitializing_should_return_false_if_pod_has_initContainerStatus_with_state_with_exit_code_0() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .initContainerStatuses(
            containerStatus(
                false,
                containerState(
                    containerStateTerminated(0, null),
                    null,
                    null)))
        .build()
        .build();
    // when
    boolean initializing = PodStatusUtil.isInitializing(pod);
    // then
    assertThat(initializing).isFalse();
  }

  @Test
  void isRunning_should_return_true_if_pod_has_containerStatus_ready_and_running() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .containerStatuses(runningReady)
        .build()
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isTrue();
  }

  @Test
  void isRunning_should_return_false_if_pod_has_containerStatus_ready_but_not_running() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .containerStatuses(
            containerStatus(
                true,
                containerState(null, null, null)))
        .build()
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isFalse();
  }

  @Test
  void isRunning_should_return_true_if_pod_has_running_container_and_another_that_is_completed_and_ready_condition_is_true() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .containerStatuses(
            runningReady,
            containerStatus(
                false,
                containerState(
                    containerStateTerminated(
                        null,
                        "Completed"),
                    null,
                    null)))
        .podConditions(
            condition("Ready", "true"))
        .build()
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isTrue();
  }

  @Test
  void isRunning_should_return_false_if_pod_has_running_container_and_another_that_is_completed_and_ready_condition_is_false() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .containerStatuses(
            runningReady,
            containerStatus(
                false,
                containerState(
                    containerStateTerminated(null, "Completed"),
                    null,
                    null)))
        .podConditions(
            condition("Ready", "false"))
        .build()
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isFalse();
  }

  @Test
  void isRunning_should_return_true_if_pod_has_running_container_and_another_that_is_terminated_for_other_reason_than_completed() {
    // given
    Pod pod = pod("some pod")
        .statusBuilder()
        .containerStatuses(
            runningReady,
            containerStatus(
                false,
                containerState(
                    containerStateTerminated(
                        null,
                        "I was bored"),
                    null,
                    null)))
        .build()
        .build();
    // when
    boolean running = PodStatusUtil.isRunning(pod);
    // then
    assertThat(running).isTrue();
  }

  @Test
  void getContainersStatuses_should_return_all_containers() {
    // given
    ContainerStatus waitingReady = containerStatus(
        true,
        containerState(
            null,
            containerStateWaiting(null),
            null));
    ContainerStatus terminatedNonReady = containerStatus(
        false,
        containerState(
            containerStateTerminated(null, null),
            null,
            null));
    Pod pod = pod("some pod")
        .statusBuilder()
        .containerStatuses(
            runningReady,
            waitingReady,
            terminatedNonReady)
        .build()
        .build();
    // when
    List<ContainerStatus> containers = PodStatusUtil.getContainerStatus(pod);
    // then
    assertThat(containers).containsExactlyInAnyOrder(
        runningReady,
        waitingReady,
        terminatedNonReady);
  }

  @Test
  void getContainersStatuses_should_return_emptyList_if_pod_has_no_status() {
    // given
    Pod pod = pod("some pod")
        .build();
    assertThat(pod.getStatus()).isNull();
    // when
    List<ContainerStatus> containers = PodStatusUtil.getContainerStatus(pod);
    // then
    assertThat(containers).isEmpty();
  }
}
