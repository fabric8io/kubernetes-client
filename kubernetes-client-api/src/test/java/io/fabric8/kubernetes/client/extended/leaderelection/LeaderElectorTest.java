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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LeaderElectionRecord;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.Lock;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import io.fabric8.kubernetes.client.utils.Utils;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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
    final LeaderElectionConfig lec = mockLeaderElectionConfiguration();
    when(lec.getRenewDeadline()).thenReturn(Duration.ofMillis(renewDeadlineMillis));
    final Lock mockedLock = lec.getLock();
    doNothing().doAnswer(invocation -> {
      // Sleep so that RENEW DEADLINE is reached
      Thread.sleep(renewDeadlineMillis * 2);
      throw new KubernetesClientException("");
    }).when(mockedLock).update(any(), any());
    // When
    CompletableFuture<?> future = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, CommonThreadPool.get())
        .start();

    // Then
    future.get(10, TimeUnit.SECONDS);
    verify(mockedLock, atLeast(2)).get(any());
    verify(mockedLock, times(1)).create(any(), any());
    verify(mockedLock, atLeast(2)).update(any(), any());
    verify(lec.getLeaderCallbacks(), atLeast(1)).onNewLeader(eq("1337"));
    verify(lec.getLeaderCallbacks(), times(1)).onStartLeading();
    verify(lec.getLeaderCallbacks(), times(1)).onStopLeading();
  }

  @Test
  void runShouldEndlesslyRun() throws Exception {
    // Given
    final ExecutorService executor = Executors.newSingleThreadExecutor();
    final CountDownLatch signal = new CountDownLatch(1);
    final LeaderElectionConfig lec = mockLeaderElectionConfiguration();
    final Lock mockedLock = lec.getLock();
    doNothing().doThrow(new KubernetesClientException("Exception won't affect execution")).doNothing().doAnswer(invocation -> {
      // Force dedicated thread to gracefully end after a couple of updates
      signal.countDown();
      return null;
    }).when(mockedLock).update(any(), any());
    // When
    executor.submit(() -> new LeaderElector(mock(NamespacedKubernetesClient.class), lec, CommonThreadPool.get()).run());
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
  void shouldReleaseWhenCanceled() throws Exception {
    // Given
    AtomicReference<LeaderElectionRecord> activeLer = new AtomicReference<>();
    final LeaderElectionConfig lec = mockLeaderElectionConfiguration(activeLer);
    final CountDownLatch signal = new CountDownLatch(1);
    final Lock mockedLock = lec.getLock();
    when(lec.isReleaseOnCancel()).thenReturn(true);
    doAnswer(invocation -> {
      LeaderElectionRecord leaderRecord = invocation.getArgument(1, LeaderElectionRecord.class);
      activeLer.set(leaderRecord);
      signal.countDown();
      return null;
    }).when(mockedLock).update(any(), any());

    // When
    LeaderElector leaderElector = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, CommonThreadPool.get());
    CompletableFuture<?> started = leaderElector.start();
    assertTrue(signal.await(10, TimeUnit.SECONDS));
    started.cancel(true);

    // Then
    Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> Utils.isNullOrEmpty(activeLer.get().getHolderIdentity()));
    assertEquals(0, activeLer.get().getLeaderTransitions());

    // create a new elector, they are no good after a single use
    leaderElector = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, CommonThreadPool.get());
    // the leader is now empty/null, we should be able to re-acquire
    assertTrue(leaderElector.tryAcquireOrRenew());

    // there should be a transition
    assertEquals(1, activeLer.get().getLeaderTransitions());
  }

  @Test
  void shouldRelease() throws Exception {
    // Given
    AtomicReference<LeaderElectionRecord> activeLer = new AtomicReference<>();
    final LeaderElectionConfig lec = mockLeaderElectionConfiguration(activeLer);
    final CountDownLatch signal = new CountDownLatch(1);
    final Lock mockedLock = lec.getLock();
    doAnswer(invocation -> {
      LeaderElectionRecord leaderRecord = invocation.getArgument(1, LeaderElectionRecord.class);
      activeLer.set(leaderRecord);
      signal.countDown();
      return null;
    }).when(mockedLock).update(any(), any());

    // When
    LeaderElector leaderElector = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, CommonThreadPool.get());
    CompletableFuture<?> started = leaderElector.start();
    assertTrue(signal.await(10, TimeUnit.SECONDS));

    Mockito.verify(lec.getLeaderCallbacks(), times(1)).onStartLeading();

    leaderElector.release();

    // ensure that release cause us to stop leading
    Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> {
      Mockito.verify(lec.getLeaderCallbacks()).onStopLeading();
      return true;
    });

    // we haven't stopped, so we'll re-acquire
    Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> {
      Mockito.verify(lec.getLeaderCallbacks(), times(2)).onStartLeading();
      return true;
    });

    started.cancel(true);
  }

  @Test
  void isLeaderAndIsLeaderShouldReturnTrue() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class, Answers.RETURNS_DEEP_STUBS);
    when(lec.getLock().identity()).thenReturn("1337");
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getHolderIdentity()).thenReturn("1337");
    // When
    final boolean result = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, Runnable::run).isLeader(ler);
    // Then
    assertTrue(result);
  }

  @Test
  void isLeaderTrueEmptyIdentity() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class, Answers.RETURNS_DEEP_STUBS);
    when(lec.getLock().identity()).thenReturn("1337");
    when(lec.getLeaseDuration()).thenReturn(Duration.ofMinutes(59L));
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getRenewTime()).thenReturn(ZonedDateTime.now(ZoneOffset.UTC));
    // When
    final boolean result = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, Runnable::run).canBecomeLeader(ler);
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
    final boolean result = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, Runnable::run).isLeader(ler);
    // Then
    assertFalse(result);
  }

  @Test
  void canBecomeLeaderAndDifferentLeaderWithExpiredLockShouldReturnTrue() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class);
    when(lec.getLeaseDuration()).thenReturn(Duration.ofMinutes(59L));
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getHolderIdentity()).thenReturn("someone");
    when(ler.getRenewTime()).thenReturn(ZonedDateTime.now(ZoneOffset.UTC).minusHours(1));
    // When
    final boolean result = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, Runnable::run).canBecomeLeader(ler);
    // Then
    assertTrue(result);
  }

  @Test
  void canBecomeLeaderAndDifferentLeaderWithActiveLockShouldReturnFalse() {
    // Given
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class);
    when(lec.getLeaseDuration()).thenReturn(Duration.ofHours(1L));
    final LeaderElectionRecord ler = mock(LeaderElectionRecord.class);
    when(ler.getHolderIdentity()).thenReturn("someone");
    when(ler.getRenewTime()).thenReturn(ZonedDateTime.now(ZoneOffset.UTC));
    // When
    final boolean result = new LeaderElector(mock(NamespacedKubernetesClient.class), lec, Runnable::run).canBecomeLeader(ler);
    // Then
    assertFalse(result);
  }

  @Test
  void loopCompletesOk() throws Exception {
    // Given
    CompletableFuture<?> cf = loop(completion -> {
      completion.complete(null);
    }, () -> 1L, CommonThreadPool.get());
    // When
    cf.get(500, TimeUnit.MILLISECONDS);
  }

  @Test
  void loopCancel() throws Exception {
    // Given
    AtomicInteger count = new AtomicInteger();
    CompletableFuture<?> cf = loop(completion -> count.getAndIncrement(), () -> 10L, CommonThreadPool.get());
    // When
    Awaitility.await().atMost(1, TimeUnit.SECONDS).until(() -> count.get() >= 1);

    cf.cancel(true);

    // make sure that the task is no longer running
    Thread.sleep(100);
    int sample = count.get();
    Thread.sleep(100);
    assertEquals(sample, count.get());
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

  private LeaderElectionConfig mockLeaderElectionConfiguration() throws Exception {
    return mockLeaderElectionConfiguration(new AtomicReference<>());
  }

  private LeaderElectionConfig mockLeaderElectionConfiguration(AtomicReference<LeaderElectionRecord> activeLer)
      throws Exception {
    final LeaderElectionConfig lec = mock(LeaderElectionConfig.class, Answers.RETURNS_DEEP_STUBS);
    when(lec.getLeaseDuration()).thenReturn(Duration.ofSeconds(2L));
    when(lec.getRenewDeadline()).thenReturn(Duration.ofSeconds(1L));
    when(lec.getRetryPeriod()).thenReturn(Duration.ofMillis(10L));
    final Lock mockedLock = lec.getLock();
    when(mockedLock.identity()).thenReturn("1337");
    when(mockedLock.get(any())).thenReturn(null).thenAnswer(invocation -> activeLer.get());
    doAnswer(invocation -> {
      LeaderElectionRecord leaderRecord = invocation.getArgument(1, LeaderElectionRecord.class);
      activeLer.set(leaderRecord);
      return null;
    }).when(mockedLock).create(any(), any());
    return lec;
  }
}
