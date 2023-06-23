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
package io.fabric8.kubernetes.client.server.mock.crud;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesCrudDispatcher;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.Context;
import okhttp3.mockwebserver.MockWebServer;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.assertj.core.api.Assertions.assertThat;

abstract class KubernetesCrudDispatcherTestBase {

  protected KubernetesClient client;
  protected KubernetesMockServer server;

  private Map<Class<? extends Lock>, AtomicInteger> lockCount;

  @BeforeEach
  void setUp() {
    lockCount = new HashMap<>(2);
    lockCount.put(ReentrantReadWriteLock.WriteLock.class, new AtomicInteger(0));
    lockCount.put(ReentrantReadWriteLock.ReadLock.class, new AtomicInteger(0));

    KubernetesCrudDispatcher dispatcher = new KubernetesCrudDispatcher() {
      @Override
      protected void locked(Lock lock) {
        lockCount.get(lock.getClass()).incrementAndGet();
      }
    };

    server = new KubernetesMockServer(new Context(), new MockWebServer(), new HashMap<>(), dispatcher, false);
    server.start();
    client = server.createClient();
  }

  @AfterEach
  void tearDown() {
    client.close();
    server.shutdown();
  }

  protected void assertLocked(int writeLockCount, int readLockCount) {
    assertThat(lockCount)
        .hasEntrySatisfying(
            ReentrantReadWriteLock.WriteLock.class,
            new Condition<>(value -> value.get() == writeLockCount, "writeLock acquired %d times", writeLockCount))
        .hasEntrySatisfying(
            ReentrantReadWriteLock.ReadLock.class,
            new Condition<>(value -> value.get() == readLockCount, "readLock acquired %d times", readLockCount));
  }
}
