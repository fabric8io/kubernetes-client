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
package io.fabric8.kubernetes.client.extended.leaderelection;

import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.ConfigMapLock;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class LeaderElectorBuilderTest {

  private NamespacedKubernetesClient mockKubernetesClient;
  private LeaderElectionConfigBuilder defaultConfigBuilder;

  @BeforeEach
  void setUp() {
    mockKubernetesClient = mock(NamespacedKubernetesClient.class, Answers.RETURNS_DEEP_STUBS);
    defaultConfigBuilder = new LeaderElectionConfigBuilder()
        .withName("Valid Leader Election configuration")
        .withLeaseDuration(Duration.ofSeconds(15L))
        .withLock(new ConfigMapLock("fakeNamespace", "fakeName", "fakeIdentity"))
        .withRenewDeadline(Duration.ofSeconds(10L))
        .withRetryPeriod(Duration.ofSeconds(2L))
        .withLeaderCallbacks(new LeaderCallbacks(() -> {
        }, () -> {
        }, newLeader -> {
        }));
  }

  @Test
  void withConfigAndValidConfigurationShouldReturnConfig() {
    // Given
    final LeaderElectionConfig validConfig = defaultConfigBuilder.build();
    // When
    final LeaderElector leadElector = new LeaderElectorBuilder(mockKubernetesClient, CommonThreadPool.get())
        .withConfig(validConfig).build();
    // Expect
    assertNotNull(leadElector);
  }

  @Test
  void withConfigAndMissingNameShouldThrowException() {
    assertRequiredField(defaultConfigBuilder.withName(null).build());
  }

  @Test
  void withConfigAndMissingLeaseDurationShouldThrowException() {
    assertRequiredField(defaultConfigBuilder.withLeaseDuration(null).build());
  }

  @Test
  void withConfigAndMissingRenewDeadlineShouldThrowException() {
    assertRequiredField(defaultConfigBuilder.withRenewDeadline(null).build());
  }

  @Test
  void withConfigAndMissingRetryPeriodShouldThrowException() {
    assertRequiredField(defaultConfigBuilder.withRetryPeriod(null).build());
  }

  @Test
  void withConfigAndMissingLeaderCallbacksPeriodShouldThrowException() {
    assertRequiredField(defaultConfigBuilder.withLeaderCallbacks(null).build());
  }

  @Test
  void withConfigAndMissingLockPeriodShouldThrowException() {
    assertRequiredField(defaultConfigBuilder.withLock(null).build());
  }

  @Test
  void withConfigAndInvalidLeaseDurationComparedToRenewDeadlineShouldThrowException() {
    assertInvalidField(defaultConfigBuilder
        .withLeaseDuration(Duration.ofSeconds(1)).withRenewDeadline(Duration.ofSeconds(2)).build());
  }

  @Test
  void withConfigAndInvalidRenewDeadlineComparedToRetryPeriodShouldThrowException() {
    assertInvalidField(defaultConfigBuilder
        .withRenewDeadline(Duration.ofSeconds(1)).withRetryPeriod(Duration.ofMillis(8000L)).build());
  }

  @Test
  void withConfigAndInvalidLeaseDurationShouldThrowException() {
    assertInvalidField(defaultConfigBuilder
        .withLeaseDuration(Duration.ofNanos(15))
        .withRenewDeadline(Duration.ofNanos(10))
        .withRetryPeriod(Duration.ofNanos(2))
        .build());
  }

  @Test
  void withConfigAndInvalidRenewDeadlineShouldThrowException() {
    assertInvalidField(defaultConfigBuilder
        .withRenewDeadline(Duration.ofNanos(10))
        .withRetryPeriod(Duration.ofNanos(2))
        .build());
  }

  @Test
  void withConfigAndInvalidRetryPeriodShouldThrowException() {
    assertInvalidField(defaultConfigBuilder.withRetryPeriod(Duration.ofNanos(2)).build());
  }

  private void assertRequiredField(LeaderElectionConfig invalidConfig) {
    assertThrows(NullPointerException.class,
        () -> new LeaderElectorBuilder(mockKubernetesClient, CommonThreadPool.get()).withConfig(invalidConfig).build());
  }

  private void assertInvalidField(LeaderElectionConfig invalidConfig) {
    assertThrows(IllegalArgumentException.class,
        () -> new LeaderElectorBuilder(mockKubernetesClient, CommonThreadPool.get()).withConfig(invalidConfig).build());
  }
}
