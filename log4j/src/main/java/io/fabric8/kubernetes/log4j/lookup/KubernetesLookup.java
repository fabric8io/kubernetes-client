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
package io.fabric8.kubernetes.log4j.lookup;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerStatus;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.AbstractLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.LoaderUtil;
import org.apache.logging.log4j.util.Strings;

import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Retrieves various attributes from the Kubernetes server.
 * <p>
 * Supported keys are:
 * </p>
 * <table>
 * <tr>
 * <th>Key</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td>{@value ACCOUNT_NAME}</td>
 * <td>the name of the account</td>
 * </tr>
 * <tr>
 * <td>{@value ANNOTATIONS}</td>
 * <td>the annotations of the Kubernetes pod</td>
 * </tr>
 * <tr>
 * <td>{@value CONTAINER_ID}</td>
 * <td>the id of the Kubernetes container</td>
 * </tr>
 * <tr>
 * <td>{@value CONTAINER_NAME}</td>
 * <td>the name of the Kubernetes container</td>
 * </tr>
 * <tr>
 * <td>{@value HOST}</td>
 * <td>the host name of the Kubernetes pod</td>
 * </tr>
 * <tr>
 * <td>{@value HOST_IP}</td>
 * <td>the IP of the Kubernetes pod</td>
 * </tr>
 * <tr>
 * <td>{@value IMAGE_ID}</td>
 * <td>the id of the Kubernetes container image</td>
 * </tr>
 * <tr>
 * <td>{@value IMAGE_NAME}</td>
 * <td>the name of the Kubernetes container image</td>
 * </tr>
 * <tr>
 * <td>{@value LABELS}</td>
 * <td>the labels of the Kubernetes pod</td>
 * </tr>
 * <tr>
 * <td>"labels.&lt;name&gt;"</td>
 * <td>the value of the "&lt;name&gt;" label of the Kubernetes pod</td>
 * </tr>
 * <tr>
 * <td>{@value MASTER_URL}</td>
 * <td>the master URL of the Kubernetes cluster</td>
 * </tr>
 * <tr>
 * <td>{@value NAMESPACE_ANNOTATIONS}</td>
 * <td>the annotations of the namespace</td>
 * </tr>
 * <tr>
 * <td>{@value NAMESPACE_ID}</td>
 * <td>the id of the namespace</td>
 * </tr>
 * <tr>
 * <td>{@value NAMESPACE_LABELS}</td>
 * <td>the labels of the namespace</td>
 * </tr>
 * <tr>
 * <td>{@value NAMESPACE_NAME}</td>
 * <td>the name of the namespace</td>
 * </tr>
 * <tr>
 * <td>{@value POD_ID}</td>
 * <td>the id of the pod</td>
 * </tr>
 * <tr>
 * <td>{@value POD_IP}</td>
 * <td>the IP of the pod</td>
 * </tr>
 * <tr>
 * <td>{@value POD_NAME}</td>
 * <td>the name of the pod</td>
 * </tr>
 * </table>
 */
@Plugin(name = "k8s", category = StrLookup.CATEGORY)
public class KubernetesLookup extends AbstractLookup {

  private static final Logger LOGGER = StatusLogger.getLogger();
  private static final String HOSTNAME = "HOSTNAME";
  private static final String SPRING_ENVIRONMENT_KEY = "SpringEnvironment";

  /** Supported keys */
  private static final String ACCOUNT_NAME = "accountName";
  private static final String ANNOTATIONS = "annotations";
  private static final String CONTAINER_ID = "containerId";
  private static final String CONTAINER_NAME = "containerName";
  private static final String HOST = "host";
  private static final String HOST_IP = "hostIp";
  private static final String IMAGE_ID = "imageId";
  private static final String IMAGE_NAME = "imageName";
  private static final String LABELS = "labels";
  private static final String LABELS_PREFIX = "labels.";
  private static final String MASTER_URL = "masterUrl";
  private static final String NAMESPACE_ANNOTATIONS = "namespaceAnnotations";
  private static final String NAMESPACE_ID = "namespaceId";
  private static final String NAMESPACE_LABELS = "namespaceLabels";
  private static final String NAMESPACE_NAME = "namespaceName";
  private static final String POD_ID = "podId";
  private static final String POD_IP = "podIp";
  private static final String POD_NAME = "podName";

  private static volatile KubernetesInfo kubernetesInfo;
  private static final Lock initLock = new ReentrantLock();
  private static final boolean isSpringIncluded = LoaderUtil
      .isClassAvailable("org.apache.logging.log4j.spring.cloud.config.client.SpringEnvironmentHolder")
      || LoaderUtil.isClassAvailable("org.apache.logging.log4j.spring.boot.SpringEnvironmentHolder");
  private Pod pod;
  private Namespace namespace;
  private URL masterUrl;

  public KubernetesLookup() {
    this.pod = null;
    this.namespace = null;
    this.masterUrl = null;
    initialize();
  }

  KubernetesLookup(Pod pod, Namespace namespace, URL masterUrl) {
    this.pod = pod;
    this.namespace = namespace;
    this.masterUrl = masterUrl;
    initialize();
  }

  private boolean initialize() {
    if (kubernetesInfo == null || (isSpringIncluded && !kubernetesInfo.isSpringActive)) {
      initLock.lock();
      try {
        final boolean isSpringActive = isSpringActive();
        if (kubernetesInfo == null || (!kubernetesInfo.isSpringActive && isSpringActive)) {
          final KubernetesInfo info = new KubernetesInfo();
          KubernetesClient client = null;
          info.isSpringActive = isSpringActive;
          if (pod == null) {
            client = new ClientBuilder().createClient();
            if (client != null) {
              pod = getCurrentPod(client);
              info.masterUrl = client.getMasterUrl();
              if (pod != null) {
                info.namespace = pod.getMetadata().getNamespace();
                namespace = client.namespaces()
                    .withName(info.namespace)
                    .get();
              }
            } else {
              LOGGER.warn("Kubernetes is not available for access");
            }
          } else {
            info.masterUrl = masterUrl;
          }
          if (pod != null) {
            if (namespace != null) {
              info.namespaceId = namespace.getMetadata().getUid();
              info.namespaceAnnotations = namespace.getMetadata().getAnnotations();
              info.namespaceLabels = namespace.getMetadata().getLabels();
            }
            info.hostName = pod.getSpec().getNodeName();
            info.annotations = pod.getMetadata().getAnnotations();
            info.accountName = pod.getSpec().getServiceAccountName();
            info.hostIp = pod.getStatus().getHostIP();
            info.labels = pod.getMetadata().getLabels();
            info.podId = pod.getMetadata().getUid();
            info.podIp = pod.getStatus().getPodIP();
            info.podName = pod.getMetadata().getName();
            ContainerStatus containerStatus = null;
            final List<ContainerStatus> statuses = pod.getStatus().getContainerStatuses();
            if (statuses.size() == 1) {
              containerStatus = statuses.get(0);
            } else if (statuses.size() > 1) {
              final String containerId = ContainerUtil.getContainerId();
              if (containerId != null) {
                containerStatus = statuses.stream()
                    .filter(cs -> cs.getContainerID().contains(containerId))
                    .findFirst()
                    .orElse(null);
              }
            }
            final String containerName;
            if (containerStatus != null) {
              info.containerId = containerStatus.getContainerID();
              info.imageId = containerStatus.getImageID();
              containerName = containerStatus.getName();
            } else {
              containerName = null;
            }
            Container container = null;
            final List<Container> containers = pod.getSpec().getContainers();
            if (containers.size() == 1) {
              container = containers.get(0);
            } else if (containers.size() > 1 && containerName != null) {
              container = containers.stream()
                  .filter(c -> c.getName().equals(containerName))
                  .findFirst()
                  .orElse(null);
            }
            if (container != null) {
              info.containerName = container.getName();
              info.imageName = container.getImage();
            }

            kubernetesInfo = info;
          }
        }
      } finally {
        initLock.unlock();
      }
    }
    return kubernetesInfo != null;
  }

  @Override
  public String lookup(final LogEvent event, final String key) {
    if (kubernetesInfo == null) {
      return null;
    }
    if (key.startsWith(LABELS_PREFIX)) {
      return kubernetesInfo.labels.get(key.substring(LABELS_PREFIX.length()));
    }
    switch (key) {
      case ACCOUNT_NAME: {
        return kubernetesInfo.accountName;
      }
      case ANNOTATIONS: {
        return kubernetesInfo.annotations.toString();
      }
      case CONTAINER_ID: {
        return kubernetesInfo.containerId;
      }
      case CONTAINER_NAME: {
        return kubernetesInfo.containerName;
      }
      case HOST: {
        return kubernetesInfo.hostName;
      }
      case HOST_IP: {
        return kubernetesInfo.hostIp;
      }
      case LABELS: {
        return kubernetesInfo.labels.toString();
      }
      case MASTER_URL: {
        return kubernetesInfo.masterUrl.toString();
      }
      case NAMESPACE_ANNOTATIONS: {
        return kubernetesInfo.namespaceAnnotations.toString();
      }
      case NAMESPACE_ID: {
        return kubernetesInfo.namespaceId;
      }
      case NAMESPACE_LABELS: {
        return kubernetesInfo.namespaceLabels.toString();
      }
      case NAMESPACE_NAME: {
        return kubernetesInfo.namespace;
      }
      case POD_ID: {
        return kubernetesInfo.podId;
      }
      case POD_IP: {
        return kubernetesInfo.podIp;
      }
      case POD_NAME: {
        return kubernetesInfo.podName;
      }
      case IMAGE_ID: {
        return kubernetesInfo.imageId;
      }
      case IMAGE_NAME: {
        return kubernetesInfo.imageName;
      }
      default:
        return null;
    }
  }

  /**
   * For unit testing only.
   */
  void clearInfo() {
    kubernetesInfo = null;
  }

  private Pod getCurrentPod(final KubernetesClient kubernetesClient) {
    final String hostName = System.getenv(HOSTNAME);
    try {
      if (isServiceAccount() && Strings.isNotBlank(hostName)) {
        return kubernetesClient.pods().withName(hostName).get();
      }
    } catch (Throwable t) {
      LOGGER.debug("Unable to locate pod with name {}.", hostName);
    }
    return null;
  }

  private boolean isServiceAccount() {
    return Paths.get(Config.KUBERNETES_SERVICE_ACCOUNT_TOKEN_PATH).toFile().exists()
        && Paths.get(Config.KUBERNETES_SERVICE_ACCOUNT_CA_CRT_PATH)
            .toFile()
            .exists();
  }

  private boolean isSpringActive() {
    return isSpringIncluded
        && LogManager.getFactory() != null
        && LogManager.getFactory().hasContext(KubernetesLookup.class.getName(), null, false)
        && LogManager.getContext(false).getObject(SPRING_ENVIRONMENT_KEY) != null;
  }

  private static class KubernetesInfo {
    boolean isSpringActive;
    String accountName;
    Map<String, String> annotations;
    String containerId;
    String containerName;
    String hostName;
    String hostIp;
    String imageId;
    String imageName;
    Map<String, String> labels;
    URL masterUrl;
    String namespace;
    Map<String, String> namespaceAnnotations;
    String namespaceId;
    Map<String, String> namespaceLabels;
    String podId;
    String podIp;
    String podName;
  }
}
