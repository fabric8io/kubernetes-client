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
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LeaderElectionRecord;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.Lock;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class LeaderElector<C extends NamespacedKubernetesClient> {

  private static final Logger LOGGER = LoggerFactory.getLogger(LeaderElector.class);

  protected static final Double JITTER_FACTOR = 1.2;

  private C kubernetesClient;
  private LeaderElectionConfig leaderElectionConfig;
  private final AtomicReference<LeaderElectionRecord> observedRecord;
  private final AtomicReference<LocalDateTime> observedTime;
  private final AtomicReference<String> reportedLeader;

  public LeaderElector(C kubernetesClient, LeaderElectionConfig leaderElectionConfig) {
    this.kubernetesClient = kubernetesClient;
    this.leaderElectionConfig = leaderElectionConfig;
    observedRecord = new AtomicReference<>();
    observedTime = new AtomicReference<>();
    reportedLeader = new AtomicReference<>();
  }

  /**
   * Starts the leader election loop
   */
  public void run() {
    LOGGER.debug("Leader election started");
    if (!acquire()) {
      return;
    }
    leaderElectionConfig.getLeaderCallbacks().onStartLeading();
    renewWithTimeout();
    leaderElectionConfig.getLeaderCallbacks().onStopLeading();
  }

  private boolean acquire() {
    final String lockDescription = leaderElectionConfig.getLock().describe();
    LOGGER.debug("Attempting to acquire leader lease '{}'...", lockDescription);
    final AtomicBoolean succeeded = new AtomicBoolean(false);
    return loop(countDownLatch -> {
      try {
        if (!succeeded.get()) {
          succeeded.set(tryAcquireOrRenew());
          reportTransitionIfLeaderChanged();
        }
        if (succeeded.get()) {
          LOGGER.debug("Successfully Acquired leader lease '{}'", lockDescription);
          countDownLatch.countDown();
        } else {
          LOGGER.debug("Failed to acquire lease '{}' retrying...", lockDescription);
        }
      } catch (Exception exception) {
        LOGGER.error("Exception occurred while acquiring lock '{}'", lockDescription, exception);
      }
    }, jitter(leaderElectionConfig.getRetryPeriod(), JITTER_FACTOR).toMillis());
  }

  private void renewWithTimeout() {
    final String lockDescription = leaderElectionConfig.getLock().describe();
    LOGGER.debug("Attempting to renew leader lease '{}'...", lockDescription);
    loop(abortLatch -> {
      final ExecutorService timeoutExecutorService = Executors.newSingleThreadScheduledExecutor();
      final CountDownLatch renewSignal = new CountDownLatch(1);
      try {
        timeoutExecutorService.submit(() -> renew(abortLatch, renewSignal));
        if (!renewSignal.await(leaderElectionConfig.getRenewDeadline().toMillis(), TimeUnit.MILLISECONDS)) {
          LOGGER.debug("Renew deadline reached after {} seconds while renewing lock {}",
            leaderElectionConfig.getRenewDeadline().get(ChronoUnit.SECONDS), lockDescription);
          abortLatch.countDown();
        }
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      } finally {
        timeoutExecutorService.shutdown();
      }
    }, leaderElectionConfig.getRetryPeriod().toMillis());
  }

  private void renew(CountDownLatch abortLatch, CountDownLatch renewSignal) {
    try {
      final boolean success = tryAcquireOrRenew();
      reportTransitionIfLeaderChanged();
      if (!success) {
        abortLatch.countDown();
      }
    } catch(LockException exception) {
      LOGGER.debug("Exception occurred while renewing lock: {}", exception.getMessage(), exception);
    }
    renewSignal.countDown();
  }

  private boolean tryAcquireOrRenew() throws LockException {
    final Lock lock = leaderElectionConfig.getLock();
    final ZonedDateTime now = now();
    final LeaderElectionRecord oldLeaderElectionRecord = lock.get(kubernetesClient);
    if (oldLeaderElectionRecord == null) {
      final LeaderElectionRecord newLeaderElectionRecord = new LeaderElectionRecord(
        lock.identity(), leaderElectionConfig.getLeaseDuration(), now, now, 0);
      lock.create(kubernetesClient, newLeaderElectionRecord);
      updateObserved(newLeaderElectionRecord);
      return true;
    }
    updateObserved(oldLeaderElectionRecord);
    final boolean isLeader = isLeader(oldLeaderElectionRecord);
    if (!isLeader && !canBecomeLeader(oldLeaderElectionRecord)) {
      LOGGER.debug("Lock is held by {} and has not yet expired", oldLeaderElectionRecord.getHolderIdentity());
      return false;
    }
    final LeaderElectionRecord newLeaderElectionRecord = new LeaderElectionRecord(
      lock.identity(),
      leaderElectionConfig.getLeaseDuration(),
      isLeader ? oldLeaderElectionRecord.getAcquireTime() : now,
      now,
      isLeader ? (oldLeaderElectionRecord.getLeaderTransitions() + 1) : 0
    );
    newLeaderElectionRecord.setVersion(oldLeaderElectionRecord.getVersion());
    leaderElectionConfig.getLock().update(kubernetesClient, newLeaderElectionRecord);
    updateObserved(newLeaderElectionRecord);
    return true;
  }

  private void updateObserved(LeaderElectionRecord leaderElectionRecord) {
    if (!Objects.equals(leaderElectionRecord, observedRecord.get())) {
      observedRecord.set(leaderElectionRecord);
      observedTime.set(LocalDateTime.now());
    }
  }

  private void reportTransitionIfLeaderChanged() {
    final String currentLeader = reportedLeader.get();
    final String newLeader = observedRecord.get().getHolderIdentity();
    if (!Objects.equals(newLeader, currentLeader)) {
      LOGGER.debug("Leader changed from {} to {}", currentLeader, newLeader);
      reportedLeader.set(newLeader);
      leaderElectionConfig.getLeaderCallbacks().onNewLeader(newLeader);
    }
  }

  protected final boolean isLeader(LeaderElectionRecord leaderElectionRecord) {
    return Objects.equals(leaderElectionConfig.getLock().identity(), leaderElectionRecord.getHolderIdentity());
  }

  protected final boolean canBecomeLeader(LeaderElectionRecord leaderElectionRecord) {
    return !leaderElectionRecord.getRenewTime().plus(leaderElectionConfig.getLeaseDuration()).isAfter(now());
  }

  /**
   * Periodically (every provided period) runs the provided {@link Consumer} in a separate thread causing the current
   * thread to wait until the supplied {@link CountDownLatch} is decremented by 1 unit.
   *
   * @param consumer function to run in a separate thread
   * @param periodInMillis to schedule the run of the provided consumer
   * @return true if the current thread was not interrupted, false otherwise
   */
  protected static boolean loop(Consumer<CountDownLatch> consumer, long periodInMillis) {
    final ScheduledExecutorService singleThreadExecutorService = Executors.newSingleThreadScheduledExecutor();
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    final Future<?> future = singleThreadExecutorService.scheduleAtFixedRate(
      () -> consumer.accept(countDownLatch), 0L, periodInMillis, TimeUnit.MILLISECONDS);
    try {
      countDownLatch.await();
      return true;
    } catch (InterruptedException e) {
      LOGGER.debug("Loop thread interrupted: {}", e.getMessage());
      Thread.currentThread().interrupt();
      return false;
    } finally {
      future.cancel(true);
      singleThreadExecutorService.shutdownNow();
    }
  }

  protected static ZonedDateTime now() {
    return ZonedDateTime.now(ZoneOffset.UTC);
  }

  /**
   * Returns a {@link Duration} between the provided duration and (duration + maxFactor*duration)
   *
   * @param duration  to apply jitter to
   * @param maxFactor for jitter
   * @return the jittered duration
   */
  protected static Duration jitter(Duration duration, double maxFactor) {
    maxFactor = maxFactor > 0 ? maxFactor : 1.0;
    return duration.plusMillis(Double.valueOf(duration.toMillis() * Math.random() * maxFactor).longValue());
  }
}
