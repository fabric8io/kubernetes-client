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
package io.fabric8.kubeapitest;

import io.fabric8.kubeapitest.binary.BinaryManager;
import io.fabric8.kubeapitest.cert.CertManager;
import io.fabric8.kubeapitest.kubeconfig.KubeConfig;
import io.fabric8.kubeapitest.process.EtcdProcess;
import io.fabric8.kubeapitest.process.KubeAPIServerProcess;
import io.fabric8.kubeapitest.process.UnexpectedProcessStopHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KubeAPIServer implements UnexpectedProcessStopHandler {

  private static final Logger logger = LoggerFactory.getLogger(KubeAPIServer.class);

  private final KubeAPIServerConfig config;
  private final BinaryManager binaryManager;
  private final CertManager certManager;
  private final KubeConfig kubeConfig;
  private final EtcdProcess etcdProcess;
  private final KubeAPIServerProcess kubeApiServerProcess;
  private volatile boolean stopped = false;

  public KubeAPIServer() {
    this(KubeAPIServerConfigBuilder.anAPIServerConfig().build());
  }

  public KubeAPIServer(KubeAPIServerConfig config) {
    this.config = config;
    this.binaryManager = new BinaryManager(config);
    this.certManager = new CertManager(config.getKubeAPITestDir());
    this.kubeConfig = new KubeConfig(certManager, binaryManager);
    this.etcdProcess = new EtcdProcess(binaryManager, this,
        config.isWaitForEtcdHealthCheckOnStartup(), config.getStartupTimeout());
    this.kubeApiServerProcess = new KubeAPIServerProcess(certManager, binaryManager, this, config);
  }

  public void start() {
    logger.debug("Stating API Server. Using Kube API Test dir: {}", config.getKubeAPITestDir());
    binaryManager.initAndDownloadIfRequired();
    certManager.createCertificatesIfNeeded();
    var etcdPort = etcdProcess.startEtcd();
    var apiServerPort = kubeApiServerProcess.startApiServer(etcdPort);
    if (config.isUpdateKubeConfig()) {
      kubeConfig.updateKubeConfig(apiServerPort);
    }
    kubeApiServerProcess.waitUntilReady();
    logger.debug("API Server ready to use");
  }

  // Guarded so the JUnit afterAll path and the processStopped() callback
  // (fired on unexpected child-process exit during startup) can both call
  // stop() without the second invocation crashing in cleanEtcdData() once
  // the temp dirs have already been removed. See #7834.
  public synchronized void stop() {
    if (stopped) {
      return;
    }
    stopped = true;
    logger.debug("Stopping");
    kubeApiServerProcess.stopApiServer();
    etcdProcess.stopEtcd();
    if (config.isUpdateKubeConfig()) {
      kubeConfig.restoreKubeConfig();
    }
    etcdProcess.cleanEtcdData();
    logger.debug("Stopped");
  }

  public String getKubeConfigYaml() {
    return kubeConfig.generateKubeConfigYaml(kubeApiServerProcess.getApiServerPort());
  }

  @Override
  public void processStopped(Process process) {
    stop();
  }
}
