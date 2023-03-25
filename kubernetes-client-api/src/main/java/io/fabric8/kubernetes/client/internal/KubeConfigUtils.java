/**
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
import io.fabric8.kubernetes.api.model.NamedAuthInfo;
import io.fabric8.kubernetes.api.model.NamedCluster;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Helper class for working with the YAML config file thats located in
 * <code>~/.kube/config</code> which is updated when you use commands
 * like <code>osc login</code> and <code>osc project myproject</code>
 */
public class KubeConfigUtils {
  private KubeConfigUtils() {
  }

  public static Config parseConfig(File file) throws IOException {
    return Serialization.unmarshal(new FileInputStream(file), Config.class);
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
    String contextName = config.getCurrentContext();
    if (contextName != null) {
      List<NamedContext> contexts = config.getContexts();
      if (contexts != null) {
        for (NamedContext context : contexts) {
          if (contextName.equals(context.getName())) {
            return context;
          }
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
    AuthInfo authInfo = null;
    if (config != null && context != null) {
      String user = context.getUser();
      if (user != null) {
        List<NamedAuthInfo> users = config.getUsers();
        if (users != null) {
          authInfo = users.stream()
              .filter(u -> u.getName().equals(user))
              .findAny()
              .map(NamedAuthInfo::getUser)
              .orElse(null);
        }
      }
    }
    return authInfo;
  }

  /**
   * Returns the current {@link Cluster} for the current context
   *
   * @param config {@link Config} config object
   * @param context {@link Context} context object
   * @return current {@link Cluster} for current context
   */
  public static Cluster getCluster(Config config, Context context) {
    Cluster cluster = null;
    if (config != null && context != null) {
      String clusterName = context.getCluster();
      if (clusterName != null) {
        List<NamedCluster> clusters = config.getClusters();
        if (clusters != null) {
          cluster = clusters.stream()
              .filter(c -> c.getName().equals(clusterName))
              .findAny()
              .map(NamedCluster::getCluster)
              .orElse(null);
        }
      }
    }
    return cluster;
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
  public static void persistKubeConfigIntoFile(Config kubeConfig, String kubeConfigPath) throws IOException {
    try (FileWriter writer = new FileWriter(kubeConfigPath)) {
      writer.write(Serialization.asYaml(kubeConfig));
    }
  }
}
