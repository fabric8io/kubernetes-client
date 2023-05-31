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

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.LeaderElectionRecord;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.Lock;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.LongSupplier;

public class LeaderElector {

  private static final Logger LOGGER = LoggerFactory.getLogger(LeaderElector.class);

  protected static final Double JITTER_FACTOR = 1.2;

  private KubernetesClient kubernetesClient;
  private LeaderElectionConfig leaderElectionConfig;
  private final AtomicReference<LeaderElectionRecord> observedRecord = new AtomicReference<>();
  private final AtomicReference<LocalDateTime> observedTime = new AtomicReference<>();
  private final Executor executor;
  private boolean stopped;

  public LeaderElector(KubernetesClient kubernetesClient, LeaderElectionConfig leaderElectionConfig, Executor executor) {
    this.kubernetesClient = kubernetesClient;
    this.leaderElectionConfig = leaderElectionConfig;
    this.executor = executor;
  }

  /**
   * Starts the leader election loop
   * <p>
   * {@link #start()} is preferred as it does not hold a thread.
   */
  public void run() {
    CompletableFuture<?> acquire = start();
    try {
      acquire.get();
    } catch (InterruptedException e) {
      acquire.cancel(true);
      Thread.currentThread().interrupt();
    } catch (ExecutionException e) {
      LOGGER.error("Exception during leader election", e);
    }
  }

  /**
   * Start a leader elector. The future may be cancelled to stop
   * the leader elector.
   *
   * @return the future
   */
  public CompletableFuture<?> start() {
    LOGGER.debug("Leader election started");
    CompletableFuture<Void> result = new CompletableFuture<>();

    CompletableFuture<?> acquireFuture = acquire();

    acquireFuture.whenComplete((v, t) -> {
      if (t == null) {
        CompletableFuture<?> renewFuture = renewWithTimeout();
        result.whenComplete((v1, t1) -> renewFuture.cancel(true));
        renewFuture.whenComplete((v1, t1) -> {
          stopLeading();
          if (t1 != null) {
            result.completeExceptionally(t1);
          } else {
            result.complete(null);
          }
        });
      } else {
        if (!(t instanceof CancellationException)) {
          LOGGER.error("Exception during leader election", t);
        }
        // there's a possibility that we'll obtain the lock, but get cancelled
        // before completing the future
        stopLeading();
      }
    });
    result.whenComplete((v, t) -> {
      acquireFuture.cancel(true);
    });
    return result;
  }

  private synchronized void stopLeading() {
    stopped = true;
    LeaderElectionRecord current = observedRecord.get();
    if (current == null || !isLeader(current)) {
      return; // not leading
    }
    if (leaderElectionConfig.isReleaseOnCancel()) {
      release();
    } else {
      leaderElectionConfig.getLeaderCallbacks().onStopLeading();
    }
  }

  /**
   * Release the leadership if currently held. If not cancelled, the elector will
   * continue to try and re-acquire the lock.
   */
  public synchronized void release() {
    LeaderElectionRecord current = leaderElectionConfig.getLock().get(kubernetesClient);
    if (current == null || !isLeader(current)) {
      return; // lost leadership already
    }
    try {
      ZonedDateTime now = now();
      final LeaderElectionRecord newLeaderElectionRecord = new LeaderElectionRecord(
          "",
          Duration.ofSeconds(1),
          now,
          now,
          current.getLeaderTransitions());

      leaderElectionConfig.getLock().update(kubernetesClient, newLeaderElectionRecord);
      updateObserved(newLeaderElectionRecord);
    } catch (KubernetesClientException e) {
      final String lockDescription = leaderElectionConfig.getLock().describe();
      LOGGER.error("Exception occurred while releasing lock '{}'", lockDescription, e);
    }
  }

  private CompletableFuture<Void> acquire() {
    final String lockDescription = leaderElectionConfig.getLock().describe();
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Attempting to acquire leader lease '{}'...", lockDescription);
    }
    return loop(completion -> {
      try {
        if (tryAcquireOrRenew()) {
          completion.complete(null);
          if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Acquired lease '{}'", lockDescription);
          }
        } else if (LOGGER.isDebugEnabled()) {
          LOGGER.debug("Failed to acquire lease '{}' retrying...", lockDescription);
        }
      } catch (KubernetesClientException exception) {
        LOGGER.error("Exception occurred while acquiring lock '{} retrying...'", lockDescription, exception);
      }
    }, () -> jitter(leaderElectionConfig.getRetryPeriod(), JITTER_FACTOR).toMillis(), executor);
  }

  private CompletableFuture<Void> renewWithTimeout() {
    final String lockDescription = leaderElectionConfig.getLock().describe();
    LOGGER.debug("Attempting to renew leader lease '{}'...", lockDescription);
    AtomicLong renewBy = new AtomicLong(System.currentTimeMillis() + leaderElectionConfig.getRenewDeadline().toMillis());
    return loop(completion -> {
      if (System.currentTimeMillis() > renewBy.get()) {
        LOGGER.debug("Renew deadline reached after {} seconds while renewing lock {}",
            leaderElectionConfig.getRenewDeadline().get(ChronoUnit.SECONDS), lockDescription);
        completion.complete(null);
        return;
      }
      try {
        if (tryAcquireOrRenew()) {
          renewBy.set(System.currentTimeMillis() + leaderElectionConfig.getRenewDeadline().toMillis());
        } else {
          // renewal failed, exit
          completion.complete(null);
        }
      } catch (KubernetesClientException exception) {
        LOGGER.debug("Exception occurred while renewing lock: {}", exception.getMessage(), exception);
      }
    }, () -> leaderElectionConfig.getRetryPeriod().toMillis(), executor);
  }

  synchronized boolean tryAcquireOrRenew() {
    if (stopped) {
      return false;
    }
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
        oldLeaderElectionRecord.getLeaderTransitions() + (isLeader ? 0 : 1));
    lock.update(kubernetesClient, newLeaderElectionRecord);
    updateObserved(newLeaderElectionRecord);
    return true;
  }

  private void updateObserved(LeaderElectionRecord leaderElectionRecord) {
    final LeaderElectionRecord current = observedRecord.getAndSet(leaderElectionRecord);
    if (!Objects.equals(leaderElectionRecord, current)) {
      observedTime.set(LocalDateTime.now());
      final String currentLeader = current == null ? null : current.getHolderIdentity();
      final String newLeader = leaderElectionRecord.getHolderIdentity();
      if (!Objects.equals(newLeader, currentLeader)) {
        LOGGER.debug("Leader changed from {} to {}", currentLeader, newLeader);
        // this will notify even if the newLeader is null or empty, which is the same behavior as the go client
        // but does not seem entirely correct
        leaderElectionConfig.getLeaderCallbacks().onNewLeader(newLeader);
        if (Objects.equals(currentLeader, leaderElectionConfig.getLock().identity())) {
          leaderElectionConfig.getLeaderCallbacks().onStopLeading();
        } else if (Objects.equals(newLeader, leaderElectionConfig.getLock().identity())) {
          LOGGER.debug("Successfully Acquired leader lease '{}'", leaderElectionConfig.getLock().describe());
          leaderElectionConfig.getLeaderCallbacks().onStartLeading();
        }
      }
    }
  }

  protected final boolean isLeader(LeaderElectionRecord leaderElectionRecord) {
    return Objects.equals(leaderElectionConfig.getLock().identity(), leaderElectionRecord.getHolderIdentity());
  }

  protected final boolean canBecomeLeader(LeaderElectionRecord leaderElectionRecord) {
    return Utils.isNullOrEmpty(leaderElectionRecord.getHolderIdentity())
        || !leaderElectionRecord.getRenewTime().plus(leaderElectionConfig.getLeaseDuration()).isAfter(now());
  }

  /**
   * Periodically (every provided period) runs the provided {@link Consumer} in a separate thread
   * until the supplied {@link CompletableFuture} is completed.
   *
   * @param consumer function to run in a separate thread
   * @param delaySupplier to schedule the run of the provided consumer
   * @return the future to be completed
   */
  protected static CompletableFuture<Void> loop(Consumer<CompletableFuture<?>> consumer, LongSupplier delaySupplier,
      Executor executor) {
    CompletableFuture<Void> completion = new CompletableFuture<>();
    Utils.scheduleWithVariableRate(completion, executor, () -> consumer.accept(completion), 0,
        delaySupplier,
        TimeUnit.MILLISECONDS);
    return completion;
  }

  protected static ZonedDateTime now() {
    return ZonedDateTime.now(ZoneOffset.UTC);
  }

  /**
   * Returns a {@link Duration} between the provided duration and (duration + maxFactor*duration)
   *
   * @param duration to apply jitter to
   * @param maxFactor for jitter
   * @return the jittered duration
   */
  protected static Duration jitter(Duration duration, double maxFactor) {
    maxFactor = maxFactor > 0 ? maxFactor : 1.0;
    return duration.plusMillis(Double.valueOf(duration.toMillis() * Math.random() * maxFactor).longValue());
  }
}
