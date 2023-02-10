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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ExponentialBackoffIntervalCalculatorTest {

  @Test
  @DisplayName("nextReconnectInterval, from null config, should use default values")
  void nextReconnectIntervalFromNullConfig() {
    // Given
    final ExponentialBackoffIntervalCalculator calculator = ExponentialBackoffIntervalCalculator.from(null);
    // When-Then
    assertThat(calculator.nextReconnectInterval()).isEqualTo(1000);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(2000);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(4000);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(8000);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(16000);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(32000);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(32000);
  }

  @Test
  @DisplayName("nextReconnectInterval, from config, should use Config-provided values")
  void nextReconnectIntervalFromConfig() {
    // Given
    final Config requestConfig = new ConfigBuilder(Config.empty())
        .withRequestRetryBackoffInterval(1)
        .build();
    final ExponentialBackoffIntervalCalculator calculator = ExponentialBackoffIntervalCalculator.from(requestConfig);
    // When-Then
    assertThat(calculator.nextReconnectInterval()).isEqualTo(1);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(2);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(4);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(8);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(16);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(32);
    assertThat(calculator.nextReconnectInterval()).isEqualTo(32);
  }

  @Test
  @DisplayName("shouldRetry, from null config, should use default values returns false (always)")
  void shouldRetryFromNullConfig() {
    // Given
    final ExponentialBackoffIntervalCalculator calculator = ExponentialBackoffIntervalCalculator.from(null);
    // When-Then
    assertThat(calculator.shouldRetry()).isFalse();
  }

  @Test
  @DisplayName("shouldRetry, from config within limit, returns true")
  void shouldRetryFromConfigReturnsTrue() {
    // Given
    final Config requestConfig = new ConfigBuilder(Config.empty())
        .withRequestRetryBackoffLimit(5)
        .build();
    final ExponentialBackoffIntervalCalculator calculator = ExponentialBackoffIntervalCalculator.from(requestConfig);
    // When
    IntStream.range(0, 4).forEach(i -> calculator.nextReconnectInterval());
    // Then
    assertThat(calculator.shouldRetry()).isTrue();
  }

  @Test
  @DisplayName("shouldRetry, from config outside limit, returns false")
  void shouldRetryFromConfigReturnsFalse() {
    // Given
    final Config requestConfig = new ConfigBuilder(Config.empty())
        .withRequestRetryBackoffLimit(5)
        .build();
    final ExponentialBackoffIntervalCalculator calculator = ExponentialBackoffIntervalCalculator.from(requestConfig);
    // When
    IntStream.range(0, 5).forEach(i -> calculator.nextReconnectInterval());
    // Then
    assertThat(calculator.shouldRetry()).isFalse();
  }

  @Test
  @DisplayName("resetReconnectAttempts, from config outside limit, allows for more retries")
  void resetReconnectAttemptsFromConfigAllowsForMoreRetries() {
    // Given
    final Config requestConfig = new ConfigBuilder(Config.empty())
        .withRequestRetryBackoffLimit(5)
        .build();
    final ExponentialBackoffIntervalCalculator calculator = ExponentialBackoffIntervalCalculator.from(requestConfig);
    IntStream.range(0, 5).forEach(i -> calculator.nextReconnectInterval());
    // When
    calculator.resetReconnectAttempts();
    // Then
    assertThat(calculator)
        .returns(0, ExponentialBackoffIntervalCalculator::getCurrentReconnectAttempt)
        .returns(true, ExponentialBackoffIntervalCalculator::shouldRetry);
  }
}
