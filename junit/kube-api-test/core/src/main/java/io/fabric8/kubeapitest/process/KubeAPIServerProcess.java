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

import io.fabric8.kubeapitest.KubeAPIServerConfig;
import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.Utils;
import io.fabric8.kubeapitest.binary.BinaryManager;
import io.fabric8.kubeapitest.cert.CertManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;

public class KubeAPIServerProcess {

  private static final Logger logger = LoggerFactory.getLogger(KubeAPIServerProcess.class);
  private static final Logger apiLog = LoggerFactory.getLogger(KubeAPIServerProcess.class
      .getName() + ".APIServerProcessLogs");
  public static final String KUBE_API_SERVER = "Kube API Server";

  private final CertManager certManager;
  private final BinaryManager binaryManager;
  private final KubeAPIServerConfig config;
  @SuppressWarnings("java:S3077") // volatile ensures cross-thread visibility; Process methods are thread-safe
  private volatile Process apiServerProcess;
  private volatile boolean stopped = false;
  private final UnexpectedProcessStopHandler processStopHandler;
  private int apiServerPort;

  public KubeAPIServerProcess(CertManager certManager, BinaryManager binaryManager,
      UnexpectedProcessStopHandler processStopHandler,
      KubeAPIServerConfig config) {
    this.certManager = certManager;
    this.binaryManager = binaryManager;
    this.config = config;
    this.processStopHandler = processStopHandler;
  }

  public int startApiServer(int etcdPort) {
    File apiServerBinary = binaryManager.binaries().getApiServer();
    try {
      if (!apiServerBinary.exists()) {
        throw new KubeAPITestException(
            "Missing binary for API Server on path: " + apiServerBinary.getAbsolutePath());
      }
      apiServerPort = Utils.findFreePort();
      var command = createCommand(apiServerBinary, apiServerPort, etcdPort);
      apiServerProcess = new ProcessBuilder(command)
          .start();
      Utils.redirectProcessOutputToLogger(apiServerProcess.getInputStream(), apiLog);
      Utils.redirectProcessOutputToLogger(apiServerProcess.getErrorStream(), apiLog);
      apiServerProcess.onExit().thenApply(p -> {
        if (!stopped) {
          stopped = true;
          logger.error("API Server process stopped unexpectedly with exit code {}", p.exitValue());
          this.processStopHandler.processStopped(p);
        }
        return null;
      });
      logger.debug("Kube API Server started on port: {} using binaries: {}", apiServerPort,
          apiServerBinary);
      return apiServerPort;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    }
  }

  private List<String> createCommand(File apiServerBinary, int apiServerPort, int etcdPort) {
    ArrayList<String> command = new ArrayList<String>();
    command.add(apiServerBinary.getAbsolutePath());
    command.addAll(config.getApiServerFlags());
    command.addAll(Arrays.asList("--cert-dir", config.getKubeAPITestDir(),
        "--secure-port", "" + apiServerPort,
        "--etcd-servers", "http://0.0.0.0:" + etcdPort,
        "--authorization-mode", "RBAC",
        "--service-account-issuer", "https://localhost",
        "--service-account-signing-key-file", certManager.getAPIServerKeyPath(),
        "--service-account-signing-key-file", certManager.getAPIServerKeyPath(),
        "--service-account-key-file", certManager.getAPIServerKeyPath(),
        "--service-account-issuer", certManager.getAPIServerCertPath(),
        "--disable-admission-plugins", "ServiceAccount",
        "--client-ca-file", certManager.getClientCertPath(),
        "--service-cluster-ip-range", "10.0.0.0/24",
        "--allow-privileged"));
    return command;
  }

  public void waitUntilReady() {
    var readinessChecker = new ProcessReadinessChecker();
    var timeout = config.getStartupTimeout();
    var startTime = System.currentTimeMillis();
    // Abort the readiness wait promptly if the apiserver process exits unexpectedly during
    // startup, instead of running out the full startupTimeout on a dead process (see #7807).
    BooleanSupplier abortCheck = () -> apiServerProcess != null && !apiServerProcess.isAlive();
    readinessChecker.waitUntilReady(apiServerPort, "readyz", KUBE_API_SERVER, true, timeout,
        certManager, abortCheck);
    var newTimout = (int) (timeout - (System.currentTimeMillis() - startTime));
    readinessChecker.waitUntilDefaultNamespaceAvailable(apiServerPort, binaryManager, certManager,
        config, newTimout, abortCheck);
  }

  public void stopApiServer() {
    if (stopped) {
      return;
    }
    stopped = true;
    if (apiServerProcess != null) {
      try {
        apiServerProcess.destroyForcibly();
        apiServerProcess.waitFor();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new KubeAPITestException(e);
      }
    }
    logger.debug("API Server stopped");
  }

  public int getApiServerPort() {
    return apiServerPort;
  }
}
