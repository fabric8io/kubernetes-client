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
package io.fabric8.commons;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.NamedCluster;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.VersionInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ClusterEntity {

  public static final String FRAMEWORK = "framework";
  public static final String ARQUILLIAN = "arquillian";

  public static final String NON_NUMERIC_CHARACTERS = "[^\\d.]";
  public static final String EMPTY = "";

  public static void apply(InputStream inputStream) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      String namespace = getArquillianNamespace();
      if (namespace != null) {
        client.load(inputStream).inNamespace(namespace).createOrReplace();
      }
    }
  }

  public static void apply(HasMetadata kubernetesResource) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      String namespace = getArquillianNamespace();
      if (namespace != null) {
        client.resource(kubernetesResource).inNamespace(namespace).createOrReplace();
      }
    }
  }

  public static void remove(InputStream inputStream) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      List<HasMetadata> items = client.load(inputStream).get();
      client.resourceList(items).inNamespace(getArquillianNamespace()).withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();
    }
  }

  public static void remove(HasMetadata kubernetesResource) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      client.resource(kubernetesResource).inNamespace(getArquillianNamespace()).withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();
    }
  }

  public static boolean kubernetesVersionAtLeast(String majorVersion, String minorVersion) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      VersionInfo versionInfo = client.getVersion();
      String clusterMajorVersion = versionInfo.getMajor().replaceAll(NON_NUMERIC_CHARACTERS, EMPTY);
      String clusterMinorVersion = versionInfo.getMinor().replaceAll(NON_NUMERIC_CHARACTERS, EMPTY);

      if (Integer.parseInt(majorVersion) < Integer.parseInt(clusterMajorVersion)) {
        return true;
      }

      return Integer.parseInt(clusterMajorVersion) >= Integer.parseInt(majorVersion) &&
        Integer.parseInt(clusterMinorVersion) >= Integer.parseInt(minorVersion);
    }
  }

  public static String getArquillianNamespace() {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      NamespaceList namespaceList = client.namespaces().list();
      for (Namespace namespace : namespaceList.getItems()) {

        // Namespace should not be in terminating state and it should have
        // labels.
        if (namespace.getMetadata().getDeletionTimestamp() == null) {
          if (namespace.getMetadata().getLabels() != null) {
            Map<String, String> labels = namespace.getMetadata().getLabels();
            if (labels.containsKey(FRAMEWORK) &&
              labels.get(FRAMEWORK).equals(ARQUILLIAN)) {
              return namespace.getMetadata().getName();
            }
          }

          if (namespace.getMetadata().getName().startsWith("itest-")) {
            return namespace.getMetadata().getName();
          }
        }
      }
    }
    return null;
  }

  public static String getClusterUrl() throws IOException {
    io.fabric8.kubernetes.api.model.Config kubeConfig = Serialization.yamlMapper().readValue(new File(Config.getKubeconfigFilename()), io.fabric8.kubernetes.api.model.Config.class);

    String currentContext = kubeConfig.getCurrentContext();
    NamedContext currentNamedContext = kubeConfig.getContexts().stream()
      .filter(c -> c.getName().equals(currentContext)).findFirst()
      .orElse(null);
    if (currentNamedContext != null) {
      String clusterInContext = currentNamedContext.getContext().getCluster();
      NamedCluster namedCluster = kubeConfig.getClusters().stream()
        .filter(c -> c.getName().equals(clusterInContext))
        .findFirst()
        .orElse(null);
      if (namedCluster != null) {
        return namedCluster.getCluster().getServer();
      }
    }
    return null;
  }
}
