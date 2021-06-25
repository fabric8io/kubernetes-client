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
package io.fabric8.kubernetes.client.dsl.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.HttpURLConnection;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

import io.fabric8.kubernetes.client.WatcherException;
import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher.Action;

class WaitForConditionWatcherTest {

  private final ConfigMap configMap = new ConfigMapBuilder()
      .withNewMetadata()
      .withName("test")
      .withNamespace("test")
      .endMetadata()
      .addToData("foo", "bar")
      .build();

  @Test
  void itCompletesOnMatchAdded() throws Exception {
    TrackingPredicate condition = condition(ss -> true);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.eventReceived(Action.ADDED, configMap);
    assertTrue(watcher.getFuture().isDone());
    assertEquals(watcher.getFuture().get(), configMap);
    assertTrue(condition.isCalledWith(configMap));
  }

  @Test
  void itCompletesOnMatchModified() throws Exception {
    TrackingPredicate condition = condition(ss -> true);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.eventReceived(Action.MODIFIED, configMap);
    assertTrue(watcher.getFuture().isDone());
    assertEquals(watcher.getFuture().get(), configMap);
    assertTrue(condition.isCalledWith(configMap));
  }

  @Test
  void itCompletesOnMatchDeleted() throws Exception {
    TrackingPredicate condition = condition(Objects::isNull);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.eventReceived(Action.DELETED, configMap);
    assertTrue(watcher.getFuture().isDone());
    assertNull(watcher.getFuture().get());
    assertTrue(condition.isCalledWith(null));
  }

  @Test
  void itDoesNotCompleteOnNoMatchAdded() {
    TrackingPredicate condition = condition(ss -> false);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.eventReceived(Action.ADDED, configMap);
    assertFalse(watcher.getFuture().isDone());
    assertTrue(condition.isCalledWith(configMap));
  }

  @Test
  void itDoesNotCompleteOnNoMatchModified() {
    TrackingPredicate condition = condition(ss -> false);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.eventReceived(Action.MODIFIED, configMap);
    assertFalse(watcher.getFuture().isDone());
    assertTrue(condition.isCalledWith(configMap));
  }

  @Test
  void itNotDeleted() throws Exception {
    TrackingPredicate condition = condition(Objects::nonNull);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.eventReceived(Action.DELETED, configMap);
    assertFalse(watcher.getFuture().isDone());
  }

  @Test
  void itCompletesExceptionallyOnError() throws Exception {
    TrackingPredicate condition = condition(ss -> true);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.eventReceived(Action.ERROR, configMap);
    assertTrue(watcher.getFuture().isDone());
    try {
      watcher.getFuture().get();
      fail("should have thrown exception");
    } catch (ExecutionException e) {
      assertEquals(WatcherException.class, e.getCause().getClass());
      assertEquals("Action.ERROR received", e.getCause().getMessage());
    }
    assertFalse(condition.isCalled());
  }

  @Test
  void itCompletesExceptionallyWithRetryOnCloseNonGone() throws Exception {
    TrackingPredicate condition = condition(ss -> true);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.onClose(new WatcherException("Watcher closed", new KubernetesClientException("test", 500, null)));
    assertTrue(watcher.getFuture().isDone());
    try {
      watcher.getFuture().get();
      fail("should have thrown exception");
    } catch (ExecutionException e) {
      assertEquals(WatcherException.class, e.getCause().getClass());
      assertEquals("Watcher closed", e.getCause().getMessage());
    }
    assertFalse(condition.isCalled());
  }

  @Test
  void itCompletesExceptionallyWithNoRetryOnCloseGone() throws Exception {
    TrackingPredicate condition = condition(ss -> true);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.onClose(new WatcherException("Watcher closed", new KubernetesClientException("test", HttpURLConnection.HTTP_GONE, null)));
    assertTrue(watcher.getFuture().isDone());
    try {
      watcher.getFuture().get();
      fail("should have thrown exception");
    } catch (ExecutionException e) {
      assertEquals(WatcherException.class, e.getCause().getClass());
      assertEquals("Watcher closed", e.getCause().getMessage());
    }
    assertFalse(condition.isCalled());
  }

  @Test
  void itCompletesExceptionallyWithRetryOnGracefulClose() throws Exception {
    TrackingPredicate condition = condition(ss -> true);
    WaitForConditionWatcher<ConfigMap> watcher = new WaitForConditionWatcher<>(condition);
    watcher.onClose();
    assertTrue(watcher.getFuture().isDone());
    try {
      watcher.getFuture().get();
      fail("should have thrown exception");
    } catch (ExecutionException e) {
      assertEquals(WatcherException.class, e.getCause().getClass());
      assertEquals("Watcher closed", e.getCause().getMessage());
    }
    assertFalse(condition.isCalled());
  }
  private TrackingPredicate condition(Predicate<ConfigMap> condition) {
    return new TrackingPredicate(condition);
  }

  private static class TrackingPredicate implements Predicate<ConfigMap> {

    private final Predicate<ConfigMap> delegate;

    private boolean called;
    private ConfigMap calledWith;

    public TrackingPredicate(Predicate<ConfigMap> delegate) {
      this.delegate = delegate;
      this.called = false;
      this.calledWith = null;
    }

    @Override
    public boolean test(ConfigMap configMap) {
      called = true;
      calledWith = configMap;
      return delegate.test(configMap);
    }

    public boolean isCalled() {
      return called;
    }

    public boolean isCalledWith(ConfigMap configMap) {
      return called && Objects.equals(configMap, calledWith);
    }
  }

  private ConfigMap configMap() {
    return new ConfigMapBuilder()
      .withNewMetadata()
      .withName("test")
      .withNamespace("test")
      .endMetadata()
      .addToData("foo", "bar")
      .build();
  }
}
