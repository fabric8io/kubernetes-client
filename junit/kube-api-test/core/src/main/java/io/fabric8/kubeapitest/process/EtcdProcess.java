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

package io.fabric8.kubeapitest.process;

import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.Utils;
import io.fabric8.kubeapitest.binary.BinaryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static io.fabric8.kubeapitest.Utils.deleteDirectory;

import static io.fabric8.kubeapitest.Utils.deleteDirectory;

public class EtcdProcess {

  private static final Logger log = LoggerFactory.getLogger(EtcdProcess.class);
  private static final Logger etcdLog = LoggerFactory.getLogger(EtcdProcess.class.getName() + ".EtcdProcessLogs");

  private final BinaryManager binaryManager;

  private volatile Process etcdProcess;
  private volatile boolean stopped = false;
  private final UnexpectedProcessStopHandler processStopHandler;
  private final boolean waitForHealthCheck;
  private final int startupTimeout;
  private File tempWalDir;
  private File tempDataDir;

  public EtcdProcess(BinaryManager binaryManager,
      UnexpectedProcessStopHandler processStopHandler, boolean waitForHealthCheck,
      int startupTimeout) {
    this.binaryManager = binaryManager;
    this.processStopHandler = processStopHandler;
    this.waitForHealthCheck = waitForHealthCheck;
    this.startupTimeout = startupTimeout;
  }

  public int startEtcd() {
    try {
      File etcdBinary = binaryManager.binaries().getEtcd();
      tempWalDir = Files.createTempDirectory("etcdwal").toFile();
      tempDataDir = Files.createTempDirectory("etcddata").toFile();
      log.trace("Using temp wal dir: {} and temp data dir: {}", tempWalDir.getPath(),
          tempDataDir.getPath());
      var port = Utils.findFreePort();
      var peerPort = Utils.findFreePort();

      if (!etcdBinary.exists()) {
        throw new KubeAPITestException(
            "Missing binary for etcd on path: " + etcdBinary.getAbsolutePath());
      }
      etcdProcess = new ProcessBuilder(etcdBinary.getAbsolutePath(),
          "-data-dir", tempDataDir.getPath(),
          "-wal-dir", tempWalDir.getPath(),
          "--listen-client-urls", "http://0.0.0.0:" + port,
          "--advertise-client-urls", "http://0.0.0.0:" + port,
          // the below added because of stability
          "--initial-cluster", "default=http://localhost:" + peerPort,
          "--initial-advertise-peer-urls", "http://localhost:" + peerPort,
          "--listen-peer-urls", "http://localhost:" + peerPort)
          .start();
      Utils.redirectProcessOutputToLogger(etcdProcess.getInputStream(), etcdLog);
      Utils.redirectProcessOutputToLogger(etcdProcess.getErrorStream(), etcdLog);
      etcdProcess.onExit().thenApply(p -> {
        if (!stopped) {
          stopped = true;
          log.error("etcd process stopped unexpectedly");
          processStopHandler.processStopped(p);
        }
        return null;
      });
      log.debug("etcd started on port: {}", port);
      if (waitForHealthCheck) {
        waitUntilEtcdHealthy(port);
      }
      return port;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    }
  }

  private void waitUntilEtcdHealthy(int port) {
    new ProcessReadinessChecker().waitUntilReady(port, "health", "etcd", false, startupTimeout);
  }

  public void cleanEtcdData() {
    try {
      deleteDirectory(tempDataDir);
      deleteDirectory(tempWalDir);
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    }
  }

  public void stopEtcd() {
    if (stopped) {
      return;
    }
    stopped = true;
    if (etcdProcess != null) {
      try {
        etcdProcess.destroyForcibly();
        etcdProcess.waitFor();
      } catch (InterruptedException e) {
        throw new KubeAPITestException(e);
      }
    }
    log.debug("etcd stopped");
  }
}
