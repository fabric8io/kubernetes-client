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
package io.fabric8.kubeapitest.kubeconfig;

import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.binary.BinaryManager;
import io.fabric8.kubeapitest.cert.CertManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KubeConfig {

  private static final Logger log = LoggerFactory.getLogger(KubeConfig.class);
  public static final String KUBE_API_TEST = "kubeapitest";

  private final CertManager certManager;
  private final BinaryManager binaryManager;
  private String previousCurrentContext;

  public KubeConfig(CertManager certManager, BinaryManager binaryManager) {
    this.certManager = certManager;
    this.binaryManager = binaryManager;
  }

  public void updateKubeConfig(int apiServerPort) {
    log.debug("Updating kubeconfig");
    previousCurrentContext = execWithKubectlConfigAndWait("current-context").trim();
    execWithKubectlConfigAndWait("set-cluster", KUBE_API_TEST,
        "--server=https://127.0.0.1:" + apiServerPort,
        "--certificate-authority=" + certManager.getAPIServerCertPath());
    execWithKubectlConfigAndWait("set-credentials", KUBE_API_TEST,
        "--client-certificate=" + certManager.getClientCertPath(),
        "--client-key=" + certManager.getClientKeyPath());
    execWithKubectlConfigAndWait("set-context", KUBE_API_TEST, "--cluster=kubeapitest",
        "--namespace=default", "--user=kubeapitest");
    execWithKubectlConfigAndWait("use-context", KUBE_API_TEST);
  }

  public void restoreKubeConfig() {
    log.debug("Cleanig up kubeconfig");
    unset("contexts." + KUBE_API_TEST);
    unset("clusters." + KUBE_API_TEST);
    unset("users." + KUBE_API_TEST);
    unset("current-context");
    if (previousCurrentContext != null && !previousCurrentContext.isEmpty()) {
      execWithKubectlConfigAndWait("use-context", previousCurrentContext);
    }
  }

  private void unset(String target) {
    execWithKubectlConfigAndWait("unset", target);
  }

  public String generateKubeConfigYaml(int apiServerPort) {
    try (InputStream is = KubeConfig.class.getResourceAsStream("/kubeconfig-template.yaml")) {
      String template = new String(is.readAllBytes(), StandardCharsets.UTF_8);
      Object[] args = new Object[] { certManager.getAPIServerCertPath(),
          apiServerPort, certManager.getClientCertPath(), certManager.getClientKeyPath() };
      MessageFormat format = new MessageFormat(template);
      return format.format(args);
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    }
  }

  private String execWithKubectlConfigAndWait(String... arguments) {
    try {
      List<String> args = new ArrayList<>(arguments.length + 2);
      args.add(binaryManager.binaries().getKubectl().getPath());
      args.add("config");
      args.addAll(Arrays.asList(arguments));
      Process process = new ProcessBuilder(args).start();
      String stdout;
      try (InputStream is = process.getInputStream()) {
        stdout = new String(is.readAllBytes(), Charset.defaultCharset());
      }
      process.waitFor();
      return stdout;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new KubeAPITestException(e);
    }
  }
}
