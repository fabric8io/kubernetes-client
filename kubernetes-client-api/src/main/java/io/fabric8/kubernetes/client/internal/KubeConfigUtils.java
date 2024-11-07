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
import io.fabric8.kubernetes.api.model.Config;
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
import java.util.HashMap;
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

  public static Config parseConfig(File kubeconfig) {
    if (kubeconfig == null) {
      throw new KubernetesClientException("kubeconfig (File) cannot be null");
    }
    try (var fis = Files.newInputStream(kubeconfig.toPath())) {
      final var ret = Serialization.unmarshal(fis, Config.class);
      ret.setAdditionalProperty(KUBERNETES_CONFIG_FILE_KEY, kubeconfig);
      return ret;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(kubeconfig + " (File) is not a parseable Kubernetes Config", e);
    }
  }

  public static Config parseConfigFromString(String contents) {
    return Serialization.unmarshal(contents, Config.class);
  }

  /**
   * Persist KUBECONFIG file from the provided {@link io.fabric8.kubernetes.api.model.Config} object.
   *
   * @param kubeconfig modified {@link io.fabric8.kubernetes.api.model.Config} object.
   * @param kubeConfigPath path to KUBECONFIG.
   * @throws IOException in case of failure while writing to file.
   */
  public static void persistKubeConfigIntoFile(Config kubeconfig, File kubeConfigPath) throws IOException {
    if (kubeconfig.getAdditionalProperties() != null) {
      kubeconfig.getAdditionalProperties().remove(KUBERNETES_CONFIG_FILE_KEY);
    }
    if (kubeconfig.getContexts() != null) {
      kubeconfig.getContexts().stream()
          .filter(ctx -> ctx.getAdditionalProperties() != null)
          .forEach(ctx -> ctx.getAdditionalProperties().remove(KUBERNETES_CONFIG_FILE_KEY));
    }
    Files.writeString(kubeConfigPath.toPath(), Serialization.asYaml(kubeconfig));
  }

  public static File getFileFromContext(NamedContext namedContext) {
    return namedContext != null && namedContext.getAdditionalProperties() != null
        && namedContext.getAdditionalProperties().get(KUBERNETES_CONFIG_FILE_KEY) instanceof File
            ? (File) namedContext.getAdditionalProperties().get(KUBERNETES_CONFIG_FILE_KEY)
            : null;
  }

  /**
   * Merges the provided {@link Config} objects into the provided {@link io.fabric8.kubernetes.client.Config} object.
   * <p>
   * The following precedence is followed:
   * <ol>
   * <li>Incomplete Contexts, Clusters, and Users are ignored</li>
   * <li>Context argument provided by the user is used if provided and exists</li>
   * <li>The first Config object to set a value wins</li>
   * </ol>
   */
  public static void merge(io.fabric8.kubernetes.client.Config clientConfig, String context, Config... kubeconfigs) {
    final var mergedContexts = mergeContexts(clientConfig, kubeconfigs);
    clientConfig.setContexts(new ArrayList<>(mergedContexts.values()));
    // Try to load the context requested by the user, otherwise fallback to the one selected in the first .kube/config
    NamedContext currentContext = null;
    for (String contextName : contextPreference(context, kubeconfigs)) {
      if (mergedContexts.containsKey(contextName)) {
        currentContext = mergedContexts.get(contextName);
        break;
      }
    }
    if (currentContext == null || currentContext.getContext() == null) {
      return;
    }
    clientConfig.setCurrentContext(currentContext);
    clientConfig.setNamespace(currentContext.getContext().getNamespace());
    // If config was loaded using KubeConfigUtils#parseConfig, then the file is available in the additional properties
    final File configFile;
    if (currentContext.getAdditionalProperties().get(KUBERNETES_CONFIG_FILE_KEY) instanceof File) {
      configFile = (File) currentContext.getAdditionalProperties().get(KUBERNETES_CONFIG_FILE_KEY);
    } else {
      configFile = null;
    }
    final var mergedClusters = mergeClusters(kubeconfigs);
    if (mergedClusters.containsKey(currentContext.getContext().getCluster())) {
      final var currentCluster = mergedClusters.get(currentContext.getContext().getCluster()).getCluster();
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
    final var mergedUsers = mergeUsers(kubeconfigs);
    if (mergedUsers.containsKey(currentContext.getContext().getUser())) {
      final var currentAuthInfo = mergedUsers.get(currentContext.getContext().getUser()).getUser();
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

  private static Map<String, NamedContext> mergeContexts(io.fabric8.kubernetes.client.Config config, Config... kubeconfigs) {
    final Map<String, NamedContext> mergedContexts = new HashMap<>();
    // process kubeconfigs in inverse order, so that the first kubeconfig has precedence
    for (int i = kubeconfigs.length - 1; i >= 0; i--) {
      if (kubeconfigs[i].getContexts() != null) {
        for (NamedContext ctx : kubeconfigs[i].getContexts()) {
          if (ctx.getContext() != null) {
            // Contains KUBERNETES_CONFIG_FILE_KEY if config was parsed using KubeConfigUtils#parseConfig
            ctx.getAdditionalProperties().putAll(kubeconfigs[i].getAdditionalProperties());
            mergedContexts.put(ctx.getName(), ctx);
          }
        }
      }
    }
    if (config.getContexts() != null) {
      for (NamedContext ctx : config.getContexts()) {
        mergedContexts.put(ctx.getName(), ctx);
      }
    }
    return mergedContexts;
  }

  private static Map<String, NamedCluster> mergeClusters(Config... kubeconfigs) {
    final Map<String, NamedCluster> mergedClusters = new HashMap<>();
    // process kubeconfigs in inverse order, so that the first kubeconfig has precedence
    for (int i = kubeconfigs.length - 1; i >= 0; i--) {
      if (kubeconfigs[i].getClusters() != null) {
        for (NamedCluster cluster : kubeconfigs[i].getClusters()) {
          if (cluster.getCluster() != null) {
            mergedClusters.put(cluster.getName(), cluster);
          }
        }
      }
    }
    return mergedClusters;
  }

  private static Map<String, NamedAuthInfo> mergeUsers(Config... kubeconfigs) {
    final Map<String, NamedAuthInfo> mergedUsers = new HashMap<>();
    // process kubeconfigs in inverse order, so that the first kubeconfig has precedence
    for (int i = kubeconfigs.length - 1; i >= 0; i--) {
      if (kubeconfigs[i].getUsers() != null) {
        for (NamedAuthInfo user : kubeconfigs[i].getUsers()) {
          if (user.getUser() != null) {
            mergedUsers.put(user.getName(), user);
          }
        }
      }
    }
    return mergedUsers;
  }

  private static List<String> contextPreference(String context, Config... kubeconfigs) {
    final List<String> contextPreference = new ArrayList<>();
    if (Utils.isNotNullOrEmpty(context)) {
      contextPreference.add(context);
    }
    for (Config kubeconfig : kubeconfigs) {
      if (Utils.isNotNullOrEmpty(kubeconfig.getCurrentContext())) {
        contextPreference.add(kubeconfig.getCurrentContext());
      }
    }
    return contextPreference;
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
