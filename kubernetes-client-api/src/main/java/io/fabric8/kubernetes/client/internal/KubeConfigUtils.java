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
package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.api.model.AuthInfo;
import io.fabric8.kubernetes.api.model.Cluster;
import io.fabric8.kubernetes.api.model.Config;
import io.fabric8.kubernetes.api.model.Context;
import io.fabric8.kubernetes.api.model.ExecConfig;
import io.fabric8.kubernetes.api.model.ExecEnvVar;
import io.fabric8.kubernetes.api.model.NamedAuthInfo;
import io.fabric8.kubernetes.api.model.NamedCluster;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.client.Config.HTTPS_PROTOCOL_PREFIX;
import static io.fabric8.kubernetes.client.Config.HTTP_PROTOCOL_PREFIX;
import static io.fabric8.kubernetes.client.Config.SOCKS5_PROTOCOL_PREFIX;
import static io.fabric8.kubernetes.client.Config.getKeyAlgorithm;

/**
 * Helper class for working with the YAML config file thats located in
 * <code>~/.kube/config</code> which is updated when you use commands
 * like <code>osc login</code> and <code>osc project myproject</code>
 */
public class KubeConfigUtils {

  private static final Logger logger = LoggerFactory.getLogger(io.fabric8.kubernetes.client.Config.class);

  private static final String KUBERNETES_CONFIG_FILE_KEY = "KUBERNETES_CONFIG_FILE_KEY";
  private static final String ACCESS_TOKEN = "access-token";
  private static final String ID_TOKEN = "id-token";

  private KubeConfigUtils() {
  }

  public static Config parseConfig(File kubeconfigFile) {
    try (var fis = Files.newInputStream(kubeconfigFile.toPath())) {
      final var ret = Serialization.unmarshal(fis, Config.class);
      ret.setAdditionalProperty(KUBERNETES_CONFIG_FILE_KEY, kubeconfigFile);
      return ret;
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(kubeconfigFile + " is not a parseable Kubernetes Config", e);
    }
  }

  public static Config parseConfigFromString(String contents) {
    return Serialization.unmarshal(contents, Config.class);
  }

  /**
   * Returns the current context in the given config
   *
   * @param config Config object
   * @return returns context in config if found, otherwise null
   */
  public static NamedContext getCurrentContext(Config config) {
    final String currentContext = config.getCurrentContext();
    if (currentContext != null && config.getContexts() != null) {
      for (NamedContext context : config.getContexts()) {
        if (Objects.equals(currentContext, context.getName())) {
          return context;
        }
      }
    }
    return null;
  }

  public static NamedContext findContext(List<NamedContext> contexts, String context) {
    if (contexts != null && Utils.isNotNullOrEmpty(context)) {
      for (var ctx : contexts) {
        if (Objects.equals(ctx.getName(), context)) {
          return ctx;
        }
      }
    }
    return null;
  }

  /**
   * Returns the current user token for the config and current context
   *
   * @param config Config object
   * @param context Context object
   * @return returns current user based upon provided parameters.
   */
  public static String getUserToken(Config config, Context context) {
    AuthInfo authInfo = getUserAuthInfo(config, context);
    if (authInfo != null) {
      return authInfo.getToken();
    }
    return null;
  }

  /**
   * Returns the current {@link AuthInfo} for the current context and user
   *
   * @param config Config object
   * @param context Context object
   * @return {@link AuthInfo} for current context
   */
  public static AuthInfo getUserAuthInfo(Config config, Context context) {
    if (config != null && config.getUsers() != null && context != null && context.getUser() != null) {
      return config.getUsers().stream()
          .filter(u -> Objects.equals(u.getName(), context.getUser()))
          .findAny()
          .map(NamedAuthInfo::getUser)
          .orElse(null);
    }
    return null;
  }

  /**
   * Returns the current {@link Cluster} for the current context
   *
   * @param config {@link Config} config object
   * @param context {@link Context} context object
   * @return current {@link Cluster} for current context
   */
  public static Cluster getCluster(Config config, Context context) {
    if (config != null && config.getClusters() != null && context != null && context.getCluster() != null) {
      return config.getClusters().stream()
          .filter(c -> Objects.equals(c.getName(), context.getCluster()))
          .findAny()
          .map(NamedCluster::getCluster)
          .orElse(null);
    }
    return null;
  }

  /**
   * Get User index from Config object
   *
   * @param config {@link io.fabric8.kubernetes.api.model.Config} Kube Config
   * @param userName username inside Config
   * @return index of user in users array
   */
  public static int getNamedUserIndexFromConfig(Config config, String userName) {
    for (int i = 0; i < config.getUsers().size(); i++) {
      if (config.getUsers().get(i).getName().equals(userName)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Modify KUBECONFIG file
   *
   * @param kubeConfig modified {@link io.fabric8.kubernetes.api.model.Config} object
   * @param kubeConfigPath path to KUBECONFIG
   * @throws IOException in case of failure while writing to file
   */
  public static void persistKubeConfigIntoFile(Config kubeConfig, File kubeConfigPath) throws IOException {
    Files.writeString(kubeConfigPath.toPath(), Serialization.asYaml(kubeConfig));
  }

  public static void merge(io.fabric8.kubernetes.client.Config clientConfig, Config kubeConfig, String context) {
    if (clientConfig.getContexts() == null) {
      clientConfig.setContexts(new ArrayList<>());
    }
    if (kubeConfig.getContexts() != null) {
      clientConfig.getContexts().addAll(kubeConfig.getContexts());
    }
    // Try to load the context requested by the user, otherwise fallback to the one selected in the .kube/config
    final NamedContext currentContext;
    if (findContext(clientConfig.getContexts(), context) != null) {
      currentContext = findContext(clientConfig.getContexts(), context);
    } else {
      currentContext = findContext(kubeConfig.getContexts(), kubeConfig.getCurrentContext());
    }
    if (currentContext == null || currentContext.getContext() == null) {
      return;
    }
    clientConfig.setCurrentContext(currentContext);
    clientConfig.setNamespace(currentContext.getContext().getNamespace());
    // If config was loaded using KubeConfigUtils#parseConfig, then the file is available in the additional properties
    final File configFile;
    if (kubeConfig.getAdditionalProperties().get(KUBERNETES_CONFIG_FILE_KEY) instanceof File) {
      configFile = (File) kubeConfig.getAdditionalProperties().get(KUBERNETES_CONFIG_FILE_KEY);
    } else {
      configFile = null;
    }
    final var currentCluster = KubeConfigUtils.getCluster(kubeConfig, currentContext.getContext());
    if (currentCluster != null) {
      clientConfig.setMasterUrl(currentCluster.getServer());
      clientConfig.setTrustCerts(Objects.equals(currentCluster.getInsecureSkipTlsVerify(), true));
      clientConfig.setDisableHostnameVerification(Objects.equals(currentCluster.getInsecureSkipTlsVerify(), true));
      final String caCertFile = configFile != null ? absolutify(configFile, currentCluster.getCertificateAuthority())
          : currentCluster.getCertificateAuthority();
      clientConfig.setCaCertFile(caCertFile);
      clientConfig.setCaCertData(currentCluster.getCertificateAuthorityData());
      String proxyUrl = currentCluster.getProxyUrl();
      if (Utils.isNotNullOrEmpty(proxyUrl)) {
        if (proxyUrl.startsWith(SOCKS5_PROTOCOL_PREFIX) && clientConfig.getMasterUrl().startsWith(HTTPS_PROTOCOL_PREFIX)) {
          clientConfig.setHttpsProxy(proxyUrl);
        } else if (proxyUrl.startsWith(SOCKS5_PROTOCOL_PREFIX)) {
          clientConfig.setHttpProxy(proxyUrl);
        } else if (proxyUrl.startsWith(HTTP_PROTOCOL_PREFIX)) {
          clientConfig.setHttpProxy(proxyUrl);
        } else if (proxyUrl.startsWith(HTTPS_PROTOCOL_PREFIX)) {
          clientConfig.setHttpsProxy(proxyUrl);
        }
      }
    }
    final var currentAuthInfo = KubeConfigUtils.getUserAuthInfo(kubeConfig, currentContext.getContext());
    if (currentAuthInfo != null) {
      String clientCertFile = currentAuthInfo.getClientCertificate();
      String clientKeyFile = currentAuthInfo.getClientKey();
      if (configFile != null) {
        clientCertFile = absolutify(configFile, currentAuthInfo.getClientCertificate());
        clientKeyFile = absolutify(configFile, currentAuthInfo.getClientKey());
      }
      clientConfig.setClientCertFile(clientCertFile);
      clientConfig.setClientCertData(currentAuthInfo.getClientCertificateData());
      clientConfig.setClientKeyFile(clientKeyFile);
      clientConfig.setClientKeyData(currentAuthInfo.getClientKeyData());
      clientConfig.setClientKeyAlgo(getKeyAlgorithm(clientConfig.getClientKeyFile(), clientConfig.getClientKeyData()));
      clientConfig.setAutoOAuthToken(currentAuthInfo.getToken());
      clientConfig.setUsername(currentAuthInfo.getUsername());
      clientConfig.setPassword(currentAuthInfo.getPassword());
      if (Utils.isNullOrEmpty(clientConfig.getAutoOAuthToken()) && currentAuthInfo.getAuthProvider() != null) {
        mergeKubeConfigAuthProviderConfig(clientConfig, currentAuthInfo);
      } else if (clientConfig.getOauthTokenProvider() == null) { // https://kubernetes.io/docs/reference/access-authn-authz/authentication/#client-go-credential-plugins
        mergeKubeConfigExecCredential(clientConfig, currentAuthInfo.getExec(), configFile);
      }
    }
  }

  private static void mergeKubeConfigAuthProviderConfig(io.fabric8.kubernetes.client.Config config, AuthInfo currentAuthInfo) {
    if (currentAuthInfo.getAuthProvider().getConfig() != null) {
      config.setAuthProvider(currentAuthInfo.getAuthProvider());
      if (!Utils.isNullOrEmpty(currentAuthInfo.getAuthProvider().getConfig().get(ACCESS_TOKEN))) {
        // GKE token
        config.setAutoOAuthToken(currentAuthInfo.getAuthProvider().getConfig().get(ACCESS_TOKEN));
      } else if (!Utils.isNullOrEmpty(currentAuthInfo.getAuthProvider().getConfig().get(ID_TOKEN))) {
        // OpenID Connect token
        config.setAutoOAuthToken(currentAuthInfo.getAuthProvider().getConfig().get(ID_TOKEN));
      }
    }
  }

  private static void mergeKubeConfigExecCredential(io.fabric8.kubernetes.client.Config config, ExecConfig exec,
      File configFile) {
    if (exec != null) {
      io.fabric8.kubernetes.client.Config.ExecCredential ec = getExecCredentialFromExecConfig(exec, configFile);
      if (ec != null && ec.status != null) {
        if (ec.status.token != null) {
          config.setAutoOAuthToken(ec.status.token);
        } else if (Utils.isNotNullOrEmpty(ec.status.clientCertificateData)
            && Utils.isNotNullOrEmpty(ec.status.clientKeyData)) {
          config.setClientCertData(ec.status.clientCertificateData);
          config.setClientKeyData(ec.status.clientKeyData);
        } else {
          logger.warn("No token or certificate returned");
        }
      }
    }
  }

  protected static io.fabric8.kubernetes.client.Config.ExecCredential getExecCredentialFromExecConfig(ExecConfig exec,
      File configFile) {
    String apiVersion = exec.getApiVersion();
    List<ExecEnvVar> env = exec.getEnv();
    // TODO check behavior of tty & stdin
    ProcessBuilder pb = new ProcessBuilder(
        getAuthenticatorCommandFromExecConfig(exec, configFile, Utils.getSystemPathVariable()));
    pb.redirectErrorStream(true);
    if (env != null) {
      Map<String, String> environment = pb.environment();
      env.forEach(var -> environment.put(var.getName(), var.getValue()));
    }
    String output;
    try {
      Process p = pb.start();
      try (InputStream is = p.getInputStream()) {
        output = IOHelpers.readFully(is);
      }
      if (p.waitFor() != 0) {
        logger.warn(output);
      }
    } catch (IOException ex) {
      throw KubernetesClientException.launderThrowable(ex);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(ex);
    }
    try {
      io.fabric8.kubernetes.client.Config.ExecCredential ec = Serialization.unmarshal(output,
          io.fabric8.kubernetes.client.Config.ExecCredential.class);
      if (ec == null || !Objects.equals(apiVersion, ec.apiVersion)) {
        logger.warn("Wrong apiVersion {} vs. {}", ec == null ? null : ec.apiVersion, apiVersion);
      } else {
        return ec;
      }
    } catch (Exception ex) {
      logger.warn("Error unmarshalling ExecCredential", ex);
    }
    return null;
  }

  protected static List<String> getAuthenticatorCommandFromExecConfig(ExecConfig exec, File configFile,
      String systemPathValue) {
    String command = exec.getCommand();
    if (command.contains(File.separator) && !command.startsWith(File.separator) && configFile != null) {
      // Appears to be a relative path; normalize. Spec is vague about how to detect this situation.
      command = Paths.get(configFile.getAbsolutePath()).resolveSibling(command).normalize().toString();
    }
    List<String> argv = new ArrayList<>(Utils.getCommandPlatformPrefix());
    command = findExecutable(command, systemPathValue);

    command = shellQuote(command);

    List<String> args = exec.getArgs();
    if (args != null && !args.isEmpty()) {
      command += " " + args
          .stream()
          .map(KubeConfigUtils::shellQuote)
          .collect(Collectors.joining(" "));
    }
    argv.add(command);
    return argv;
  }

  private static String shellQuote(String value) {
    if (value.contains(" ") || value.contains("\"") || value.contains("'")) {
      return "\"" + value.replace("\"", "\\\"") + "\"";
    }
    return value;
  }

  protected static String findExecutable(String command, String pathValue) {
    // Iterate through path in order to find executable file
    for (String pathPart : pathValue.split(File.pathSeparator)) {
      File commandFile = new File(pathPart + File.separator + command);
      if (commandFile.exists()) {
        return commandFile.getAbsolutePath();
      }
    }

    return command;
  }

  private static String absolutify(File relativeTo, String filename) {
    if (filename == null) {
      return null;
    }
    File file = new File(filename);
    if (file.isAbsolute()) {
      return file.getAbsolutePath();
    }
    return new File(relativeTo.getParentFile(), filename).getAbsolutePath();
  }
}
