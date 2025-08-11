package io.fabric8.kubeapitest.sample;

import io.fabric8.kubeapitest.junit.EnableKubeAPIServer;
import io.fabric8.kubeapitest.junit.KubeConfig;

@EnableKubeAPIServer
public class BaseTestClass {

  @KubeConfig
  static String kubeConfigYaml;

}
