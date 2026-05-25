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
package io.fabric8.kubeapitest.process;

import com.sun.net.httpserver.HttpServer;
import io.fabric8.kubeapitest.KubeAPITestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

class ProcessReadinessCheckerTest {

  private HttpServer httpServer;
  private int port;
  private ProcessReadinessChecker checker;

  @BeforeEach
  void setUp() throws IOException {
    httpServer = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    httpServer.createContext("/readyz-ok", exchange -> {
      exchange.sendResponseHeaders(200, -1);
      exchange.close();
    });
    httpServer.createContext("/readyz-not-ready", exchange -> {
      exchange.sendResponseHeaders(503, -1);
      exchange.close();
    });
    httpServer.start();
    port = httpServer.getAddress().getPort();
    checker = new ProcessReadinessChecker();
  }

  @AfterEach
  void tearDown() {
    httpServer.stop(0);
  }

  @Test
  void waitUntilReadyAbortsPromptlyWhenAbortCheckFlips() throws InterruptedException {
    AtomicBoolean aborted = new AtomicBoolean(false);
    Thread flipper = new Thread(() -> {
      try {
        Thread.sleep(ProcessReadinessChecker.POLLING_INTERVAL * 2L);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      aborted.set(true);
    });
    flipper.start();

    long start = System.currentTimeMillis();
    KubeAPITestException ex = catchThrowableOfType(() -> checker.waitUntilReady(
        port, "readyz-not-ready", "test-process", false, 60_000, null, aborted::get),
        KubeAPITestException.class);
    long elapsed = System.currentTimeMillis() - start;
    flipper.join();

    assertThat(ex).isNotNull()
        .hasMessageContaining("test-process")
        .hasMessageContaining("exited");
    // Generous upper bound. The assertion is that the wait aborts well before the 60s
    // startupTimeout, not that it returns in microseconds. HttpClient/JSSE cold start on a
    // contended 2-vCPU CI runner can chew several seconds.
    assertThat(elapsed).isLessThan(15_000L);
  }

  @Test
  void waitUntilReadyReturnsNormallyOnHealthyResponse() {
    AtomicBoolean aborted = new AtomicBoolean(false);
    checker.waitUntilReady(port, "readyz-ok", "test-process", false, 10_000, null, aborted::get);
  }

  @Test
  void waitUntilReadyTimesOutWhenAbortCheckNullAndNotReady() {
    long start = System.currentTimeMillis();
    KubeAPITestException ex = catchThrowableOfType(() -> checker.waitUntilReady(
        port, "readyz-not-ready", "test-process", false, 500, null, null),
        KubeAPITestException.class);
    long elapsed = System.currentTimeMillis() - start;

    assertThat(ex).isNotNull()
        .hasMessageContaining("test-process")
        .hasMessageContaining("did not start properly");
    // Lower bound proves the timeout actually fired; upper bound guards against a hypothetical
    // regression that drops out of the polling loop into an unbounded wait.
    assertThat(elapsed).isGreaterThanOrEqualTo(500L).isLessThan(30_000L);
  }
}
