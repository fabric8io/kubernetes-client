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

  private static final Logger log = LoggerFactory.getLogger(KubeAPIServer.class);

  private final KubeAPIServerConfig config;
  private final BinaryManager binaryManager;
  private final CertManager certManager;
  private final KubeConfig kubeConfig;
  private final EtcdProcess etcdProcess;
  private final KubeAPIServerProcess kubeApiServerProcess;

  public KubeAPIServer() {
    this(KubeAPIServerConfigBuilder.anAPIServerConfig().build());
  }

  public KubeAPIServer(KubeAPIServerConfig config) {
    this.config = config;
    this.binaryManager = new BinaryManager(config);
    this.certManager = new CertManager(config.getJenvtestDir());
    this.kubeConfig = new KubeConfig(certManager, binaryManager);
    this.etcdProcess = new EtcdProcess(binaryManager, this,
        config.isWaitForEtcdHealthCheckOnStartup(), config.getStartupTimeout());
    this.kubeApiServerProcess =
        new KubeAPIServerProcess(certManager, binaryManager, this, config);
  }

  public void start() {
    log.debug("Stating API Server. Using jenvtest dir: {}", config.getJenvtestDir());
    binaryManager.initAndDownloadIfRequired();
    certManager.createCertificatesIfNeeded();
    var etcdPort = etcdProcess.startEtcd();
    var apiServerPort = kubeApiServerProcess.startApiServer(etcdPort);
    if (config.isUpdateKubeConfig()) {
      kubeConfig.updateKubeConfig(apiServerPort);
    }
    kubeApiServerProcess.waitUntilReady();
    log.debug("API Server ready to use");
  }

  public void stop() {
    log.debug("Stopping");
    kubeApiServerProcess.stopApiServer();
    etcdProcess.stopEtcd();
    if (config.isUpdateKubeConfig()) {
      kubeConfig.restoreKubeConfig();
    }
    etcdProcess.cleanEtcdData();
    log.debug("Stopped");
  }

  public String getKubeConfigYaml() {
    return kubeConfig.generateKubeConfigYaml(kubeApiServerProcess.getApiServerPort());
  }

  @Override
  public void processStopped(Process process) {
    stop();
  }
}
