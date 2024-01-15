package io.fabric8.kubeapitest.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.KubeAPIServerConfig;
import io.fabric8.kubeapitest.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.fabric8.kubeapitest.binary.BinaryManager;
import io.fabric8.kubeapitest.cert.CertManager;

public class KubeAPIServerProcess {

  private static final Logger log = LoggerFactory.getLogger(KubeAPIServerProcess.class);
  private static final Logger apiLog = LoggerFactory.getLogger(KubeAPIServerProcess.class
      .getName() + ".APIServerProcessLogs");
  public static final String KUBE_API_SERVER = "Kube API Server";

  private final CertManager certManager;
  private final BinaryManager binaryManager;
  private final KubeAPIServerConfig config;
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
          log.error("API Server process stopped unexpectedly");
          this.processStopHandler.processStopped(p);
        }
        return null;
      });
      log.debug("Kube API Server started on port: {} using binaries: {}", apiServerPort,
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
    command.addAll(Arrays.asList("--cert-dir", config.getJenvtestDir(),
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
    readinessChecker.waitUntilReady(apiServerPort, "readyz", KUBE_API_SERVER, true, timeout);
    var newTimout = (int) (timeout - (System.currentTimeMillis() - startTime));
    readinessChecker.waitUntilDefaultNamespaceAvailable(apiServerPort, binaryManager, certManager,
        config, newTimout);
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
        throw new KubeAPITestException(e);
      }
    }
    log.debug("API Server stopped");
  }

  public int getApiServerPort() {
    return apiServerPort;
  }
}
