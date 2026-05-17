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
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KubeConfig {

  private static final Logger logger = LoggerFactory.getLogger(KubeConfig.class);
  public static final String KUBE_API_TEST = "kubeapitest";

  private final CertManager certManager;
  private final BinaryManager binaryManager;
  private String previousCurrentContext;

  public KubeConfig(CertManager certManager, BinaryManager binaryManager) {
    this.certManager = certManager;
    this.binaryManager = binaryManager;
  }

  public void updateKubeConfig(int apiServerPort) {
    logger.debug(
        "Updating kubeconfig (env HOME={}, USERPROFILE={}, HOMEDRIVE={}, HOMEPATH={}, KUBECONFIG={}, user.home={})",
        System.getenv("HOME"),
        System.getenv("USERPROFILE"),
        System.getenv("HOMEDRIVE"),
        System.getenv("HOMEPATH"),
        System.getenv("KUBECONFIG"),
        System.getProperty("user.home"));
    ensureKubeConfigFileExists();
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
    logCandidateKubeConfigPaths();
  }

  // Post-write diagnostics so we can tell, from CI output alone, whether kubectl
  // wrote to the HOME-based path that ensureKubeConfigFileExists prepared or
  // landed somewhere else (e.g. %USERPROFILE% on Windows). Remove once #7804 is
  // fully understood on Windows.
  private void logCandidateKubeConfigPaths() {
    logCandidatePath("HOME", System.getenv("HOME"));
    logCandidatePath("USERPROFILE", System.getenv("USERPROFILE"));
    String homeDrive = System.getenv("HOMEDRIVE");
    String homePath = System.getenv("HOMEPATH");
    if (homeDrive != null && homePath != null) {
      logCandidatePath("HOMEDRIVE+HOMEPATH", homeDrive + homePath);
    }
    logCandidatePath("user.home", System.getProperty("user.home"));
  }

  private void logCandidatePath(String label, String base) {
    if (base == null || base.isEmpty()) {
      logger.debug("Kubeconfig probe [{}]: env unset", label);
      return;
    }
    Path candidate = Paths.get(base, ".kube", "config");
    if (Files.isRegularFile(candidate)) {
      long size = -1;
      try {
        size = Files.size(candidate);
      } catch (IOException e) {
        // best-effort diagnostic; size unavailable
      }
      logger.debug("Kubeconfig probe [{}]: {} exists, {} bytes", label, candidate, size);
    } else {
      logger.debug("Kubeconfig probe [{}]: {} absent", label, candidate);
    }
  }

  public void restoreKubeConfig() {
    logger.debug("Cleanig up kubeconfig");
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

  // Pin kubectl's kubeconfig path to $HOME/.kube/config so writer (kubectl) and
  // reader (fabric8 Config) resolve to the same file on Windows: Go's
  // client-go/util/homedir.HomeDir picks %USERPROFILE% over $HOME on Windows
  // unless $HOME/.kube/config already exists. See #7804.
  private void ensureKubeConfigFileExists() {
    String home = System.getenv("HOME");
    if (home == null || home.isEmpty()) {
      home = System.getProperty("user.home");
    }
    if (home == null || home.isEmpty()) {
      return;
    }
    Path kubeConfigPath = Paths.get(home, ".kube", "config");
    try {
      Files.createDirectories(kubeConfigPath.getParent());
      Files.createFile(kubeConfigPath);
      logger.debug("Pre-created {} for kubectl/fabric8 homedir parity", kubeConfigPath);
    } catch (FileAlreadyExistsException ignored) {
      // Already exists (prior run or sibling fork); nothing to do.
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    }
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
      int exitCode = process.waitFor();
      String stderr;
      try (InputStream is = process.getErrorStream()) {
        stderr = new String(is.readAllBytes(), Charset.defaultCharset());
      }
      if (exitCode != 0) {
        logger.warn("kubectl config {} exit={} stderr={}",
            String.join(" ", arguments), exitCode, stderr.trim());
      }
      return stdout;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new KubeAPITestException(e);
    }
  }
}
