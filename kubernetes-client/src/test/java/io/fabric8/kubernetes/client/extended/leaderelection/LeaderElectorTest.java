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

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LeaderElectionRecord;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.Lock;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LockException;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.extended.leaderelection.LeaderElector.jitter;
import static io.fabric8.kubernetes.client.extended.leaderelection.LeaderElector.loop;
import static io.fabric8.kubernetes.client.extended.leaderelection.LeaderElector.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LeaderElectorTest {

  @Test
  void runShouldAbortAfterRenewDeadlineExpired() throws Exception {
    // Given
    final Long renewDeadlineMillis = 1000L;
    final ExecutorService executor = Executors.newSingleThreadExecutor();
    final CountDownLatch signal = new CountDownLatch(1);
    final LeaderElectionConfig lec = mockLeaderElectionConfiguration();
    when(lec.getRenewDeadline()).thenReturn(Duration.ofMillis(renewDeadlineMillis));
    final Lock mockedLock = lec.getLock();
    doNothing().doAnswer(invocation -> {
      // Sleep so that RENEW DEADLINE is reached
      Thread.sleep(renewDeadlineMillis*2);
      return null;
    }).when(mockedLock).update(any(), any());
    // When
    executor.submit(() -> {
      new LeaderElector<>(mock(DefaultKubernetesClient.class), lec).run();
      signal.countDown();
    });
    signal.await(10, TimeUnit.SECONDS);
    // Then
    assertEquals(0, signal.getCount());
    verify(mockedLock, atLeast(2)).get(any());
    verify(mockedLock, times(1)).create(any(), any());
    verify(mockedLock, atLeast(2)).update(any(), any());
    verify(lec.getLeaderCallbacks(), atLeast(1)).onNewLeader(eq("1337"));
    verify(lec.getLeaderCallbacks(), times(1)).onStartLeading();
    verify(lec.getLeaderCallbacks(), times(1)).onStopLeading();
    executor.shutdownNow();
  }

  @Test
  void runShouldEndlesslyRun() throws Exception {
    // Given
    final ExecutorService executor = Executors.newSingleThreadExecutor();
    final CountDownLatch signal = new CountDownLatch(1);
    final LeaderElectionConfig lec = mockLeaderElectionConfiguration();
    final Lock mockedLock = lec.getLock();
    doNothing().doThrow(new LockException("Exception won't affect execution")).doNothing().doAnswer(invocation -> {
      // Force dedicated thread to gracefully end after a couple of updates
      signal.countDown();
      return null;
    }).when(mockedLock).update(any(), any());
    // When
    executor.submit(() -> new LeaderElector<>(mock(DefaultKubernetesClient.class), lec).run());
    signal.await(10, TimeUnit.SECONDS);
    // Then
    assertEquals(0, signal.getCount());
    verify(mockedLock, atLeast(2)).get(any());
    verify(mockedLock, times(1)).create(any(), any());
    verify(mockedLock, atLeast(2)).update(any(), any());
    verify(lec.getLeaderCallbacks(), atLeast(1)).onNewLeader(eq("1337"));
    verify(lec.getLeaderCallbacks(), times(1)).onStartLeading();
    executor.shutdownNow();
    executor.awaitTermination(5, TimeUnit.SECONDS);
    verify(lec.getLeaderCallbacks(), times(1)).onStopLeading();
  }

  @Test
  void isLeaderAndIsLeaderShouldReturnTrue() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class, Answers.RETURNS_DEEP_STUBS);
    when(lec.getLock().identity()).thenReturn("1337");
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getHolderIdentity()).thenReturn("1337");
    // When
    final boolean result = new LeaderElector<>(mock(DefaultKubernetesClient.class), lec).isLeader(ler);
    // Then
    assertTrue(result);
  }

  @Test
  void isLeaderAndIsNotLeaderShouldReturnFalse() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class, Answers.RETURNS_DEEP_STUBS);
    when(lec.getLock().identity()).thenReturn("313373");
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getHolderIdentity()).thenReturn("1337");
    // When
    final boolean result = new LeaderElector<>(mock(DefaultKubernetesClient.class), lec).isLeader(ler);
    // Then
    assertFalse(result);
  }

  @Test
  void canBecomeLeaderAndDifferentLeaderWithExpiredLockShouldReturnTrue() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class);
    when(lec.getLeaseDuration()).thenReturn(Duration.ofMinutes(59L));
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getRenewTime()).thenReturn(ZonedDateTime.now(ZoneOffset.UTC).minusHours(1));
    // When
    final boolean result = new LeaderElector<>(mock(DefaultKubernetesClient.class), lec).canBecomeLeader(ler);
    // Then
    assertTrue(result);
  }

  @Test
  void canBecomeLeaderAndDifferentLeaderWithActiveLockShouldReturnFalse() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class);
    when(lec.getLeaseDuration()).thenReturn(Duration.ofHours(1L));
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getRenewTime()).thenReturn(ZonedDateTime.now(ZoneOffset.UTC));
    // When
    final boolean result = new LeaderElector<>(mock(DefaultKubernetesClient.class), lec).canBecomeLeader(ler);
    // Then
    assertFalse(result);
  }

  @Test
  void loopCompletesOkShouldShutdownExecutorService() throws Exception {
    // Given
    final CountDownLatch signal = new CountDownLatch(1);
    final ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(() -> loop(countDownLatch -> {
      countDownLatch.countDown();
      signal.countDown();
    }, 1));
    // When
    signal.await(50, TimeUnit.MILLISECONDS);
    // Then
    assertEquals(0, signal.getCount());
    executor.shutdownNow();
  }

  @Test
  void loopInterruptedShouldShutdownExecutorService() throws Exception {
    // Given
    final CountDownLatch signal = new CountDownLatch(1);
    final ExecutorService executor = Executors.newSingleThreadExecutor();
    final AtomicReference<CountDownLatch> loopCountDownLatch = new AtomicReference<>(null);
    final Future<Boolean> futureLoop = executor.submit(() -> loop(countDownLatch -> {
      loopCountDownLatch.set(countDownLatch);
      signal.countDown();
    }, 1));
    // When
    signal.await(50, TimeUnit.MILLISECONDS);
    futureLoop.cancel(true);
    // Then
    assertEquals(0, signal.getCount());
    assertEquals(1, loopCountDownLatch.get().getCount());
    executor.shutdownNow();
    executor.awaitTermination(10, TimeUnit.SECONDS);
  }

  @Test
  void nowShouldReturnZonedTimeInUTC() {
    // Given
    final Instant now = Instant.now();
    // When
    final ZonedDateTime result = now();
    // Then
    assertEquals(ZoneOffset.UTC, result.getZone());
    final long delta = result.toEpochSecond() - now.getEpochSecond();
    assertTrue(delta <= 1);
    assertTrue(delta >= 0);
  }

  @Test
  void jitterWithPositiveShouldReturnPositiveDouble() {
    // Given
    final Duration test = Duration.of(1, ChronoUnit.SECONDS);
    // When
    final Duration result = jitter(test, 1);
    // Then
    assertTrue(result.toMillis() < 2000L);
    assertTrue(result.toMillis() > 1000L);
  }

  @Test
  void jitterWithNegativeShouldReturnDuration() {
    // Given
    final Duration test = Duration.of(1, ChronoUnit.SECONDS);
    // When
    final Duration result = jitter(test, -1);
    // Then
    assertTrue(result.toMillis() < 2000L);
    assertTrue(result.toMillis() > 1000L);
  }

  private static LeaderElectionConfig mockLeaderElectionConfiguration() throws Exception {
    final AtomicReference<LeaderElectionRecord> activeLer = new AtomicReference<>(null);
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class, Answers.RETURNS_DEEP_STUBS);
    when(lec.getLeaseDuration()).thenReturn(Duration.ofSeconds(2L));
    when(lec.getRenewDeadline()).thenReturn(Duration.ofSeconds(1L));
    when(lec.getRetryPeriod()).thenReturn(Duration.ofMillis(10L));
    final Lock mockedLock = lec.getLock();
    when(mockedLock.identity()).thenReturn("1337");
    when(mockedLock.get(any())).thenReturn(null).thenAnswer(invocation -> activeLer.get());
    doAnswer(invocation -> {
      activeLer.set(invocation.getArgument(1, LeaderElectionRecord.class));
      return null;
    }).when(mockedLock).create(any(), any());
    return lec;
  }
}
