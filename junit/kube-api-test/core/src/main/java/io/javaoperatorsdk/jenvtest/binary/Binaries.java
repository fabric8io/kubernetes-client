package io.javaoperatorsdk.jenvtest.binary;

import java.io.File;

public class Binaries {

  public static final String ETCD_BINARY_NAME = "etcd";
  public static final String API_SERVER_BINARY_NAME = "kube-apiserver";
  public static final String KUBECTL_BINARY_NAME = "kubectl";

  private final File etcd;
  private final File apiServer;
  private final File kubectl;

  public Binaries(File etcd, File apiServer, File kubectl) {
    this.etcd = etcd;
    this.apiServer = apiServer;
    this.kubectl = kubectl;
  }

  public File getEtcd() {
    return etcd;
  }

  public File getApiServer() {
    return apiServer;
  }

  public File getKubectl() {
    return kubectl;
  }
}
