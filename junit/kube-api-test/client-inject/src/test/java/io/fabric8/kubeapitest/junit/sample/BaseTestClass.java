package io.fabric8.kubeapitest.junit.sample;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;
import io.fabric8.kubernetes.client.KubernetesClient;

@EnableKubeAPIServer
public class BaseTestClass {

  static KubernetesClient client;

  // config yaml injection also works
  @KubeConfig
  static String configYaml;

}
