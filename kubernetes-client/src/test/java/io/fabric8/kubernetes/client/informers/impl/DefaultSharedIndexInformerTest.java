/*
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
package io.fabric8.kubernetes.client.informers.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.informers.impl.cache.Reflector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
class DefaultSharedIndexInformerTest {

  private static class TestReflector extends Reflector {
    boolean watching;

    public TestReflector(ListerWatcher listerWatcher, boolean initialWatchingState) {
      super(listerWatcher, null);
      watching = initialWatchingState;
    }

    @Override
    public boolean isWatching() {
      return watching;
    }
  }

  private static TestReflector reflector(boolean initialWatchingState) {
    final var listerWatcher = mock(ListerWatcher.class);
    when(listerWatcher.getConfig()).thenReturn(Config.empty());
    return new TestReflector(listerWatcher, initialWatchingState);
  }

  private final TestReflector reflector = reflector(new Random(System.currentTimeMillis()).nextBoolean());

  public static Stream<Arguments> noCooldown() {
    return Stream.of(
        Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE),
        Arguments.of(Integer.MIN_VALUE, -1),
        Arguments.of(Integer.MIN_VALUE, 0),
        Arguments.of(-1, Integer.MIN_VALUE),
        Arguments.of(-1, -1),
        Arguments.of(-1, 0),
        Arguments.of(0, Integer.MIN_VALUE),
        Arguments.of(0, -1),
        Arguments.of(0, 0));
  }

  @ParameterizedTest
  @MethodSource("noCooldown")
  void isWatchingWithNoCooldownShouldJustReturnReflectorState(int cooldownIntervalMillis, int maxNumberOfAttempts) {
    final var informer = new DefaultSharedIndexInformer(HasMetadata.class, reflector, 0L, cooldownIntervalMillis,
        maxNumberOfAttempts);
    assertThat(informer.isWatching()).isEqualTo(reflector.isWatching());
    reflector.watching = !reflector.watching;
    assertThat(informer.isWatching()).isEqualTo(reflector.isWatching());
  }

  public static Stream<Arguments> randomConfiguration() {
    Random random = new Random(System.currentTimeMillis());
    return random.ints(5).mapToObj(i -> Arguments.of(random.nextInt(), random.nextInt()));
  }

  @ParameterizedTest
  @MethodSource("randomConfiguration")
  void whenReflectorIsWatchingSoIsInformerRegardlessOfCooldown(int cooldownIntervalMillis, int maxNumberOfAttempts) {
    reflector.watching = true;
    final var informer = new DefaultSharedIndexInformer(HasMetadata.class, reflector, 0L, cooldownIntervalMillis,
        maxNumberOfAttempts);
    assertThat(informer.isWatching()).isTrue();
  }

  @Test
  void whenNotWatchingShouldAtLeastTryMaxNumberOfAttemptsBeforeReportingFailure() {
    reflector.watching = false;
    final var informer = new DefaultSharedIndexInformer(HasMetadata.class, reflector, 0L, Integer.MAX_VALUE, 2);
    assertThat(informer.isWatching()).isTrue();
    assertThat(informer.isWatching()).isTrue();
    assertThat(informer.isWatching()).isFalse(); // reached max number of failures during the cooldown window
    reflector.watching = true;
    assertThat(informer.isWatching()).isTrue();
  }

  @Test
  void failureOutsideOfCooldownResetsAttemptNumber() throws InterruptedException {
    reflector.watching = false;
    final var informer = new DefaultSharedIndexInformer(HasMetadata.class, reflector, 0L, 300, 2);
    assertThat(informer.isWatching()).isTrue();
    Thread.sleep(400);
    assertThat(informer.isWatching()).isTrue();
    assertThat(informer.isWatching()).isTrue();
    assertThat(informer.isWatching()).isFalse(); // reached max number of failures during the cooldown window
  }

  @Test
  void whenNotWatchingWithoutMaxNumberOfAttemptsShouldReportFailureImmediately() {
    reflector.watching = false;
    final var informer = new DefaultSharedIndexInformer(HasMetadata.class, reflector, 0L, Integer.MAX_VALUE, 0);
    assertThat(informer.isWatching()).isFalse();
  }
}
