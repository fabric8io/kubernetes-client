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
package io.fabric8.kubernetes.log4j.lookup;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerStatus;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.PodStatus;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.AbstractLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.LoaderUtil;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Retrieves various attributes from the Kubernetes server.
 * <p>
 * The supported keys are listed in the following table:
 * </p>
 * <table>
 * <caption>Supported keys</caption>
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

  /**
   * Supported keys
   */
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

  private static KubernetesInfo kubernetesInfo;
  // Used in tests
  static Path cgroupPath = ContainerUtil.CGROUP_PATH;
  private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();
  private static final Lock READ_LOCK = LOCK.readLock();
  private static final Lock WRITE_LOCK = LOCK.writeLock();
  private static final boolean IS_SPRING_INCLUDED = LoaderUtil
      .isClassAvailable("org.apache.logging.log4j.spring.cloud.config.client.SpringEnvironmentHolder")
      || LoaderUtil.isClassAvailable("org.apache.logging.log4j.spring.boot.SpringEnvironmentHolder");

  private Pod pod;
  private Namespace namespace;
  private URL masterUrl;

  /**
   * Default constructor, called by reflection.
   */
  public KubernetesLookup() {
    this.pod = null;
    this.namespace = null;
    this.masterUrl = null;
    initialize(this);
  }

  KubernetesLookup(Pod pod, Namespace namespace, URL masterUrl) {
    this.pod = pod;
    this.namespace = namespace;
    this.masterUrl = masterUrl;
    initialize(this);
  }

  private static void initialize(KubernetesLookup lookup) {
    KubernetesInfo kubernetesInfo = KubernetesLookup.kubernetesInfo;
    if (kubernetesInfo == null || isSpringStatusChanged(kubernetesInfo)) {
      WRITE_LOCK.lock();
      try {
        kubernetesInfo = KubernetesLookup.kubernetesInfo;
        if (kubernetesInfo == null || isSpringStatusChanged(kubernetesInfo)) {
          if (lookup.pod == null || lookup.namespace == null || lookup.masterUrl == null) {
            tryInitializeFields(lookup);
          }
          // Retrieve the data from the fields
          kubernetesInfo = new KubernetesInfo();
          kubernetesInfo.isSpringActive = isSpringActive();
          kubernetesInfo.masterUrl = lookup.masterUrl;
          if (lookup.namespace != null) {
            fillNamespaceData(lookup.namespace, kubernetesInfo);
          }
          if (lookup.pod != null) {
            fillPodData(lookup.pod, kubernetesInfo);
          }
          KubernetesLookup.kubernetesInfo = kubernetesInfo;
        }
      } finally {
        WRITE_LOCK.unlock();
      }
    }
  }

  private static boolean isSpringStatusChanged(KubernetesInfo kubernetesInfo) {
    return IS_SPRING_INCLUDED
        && isSpringActive() != (kubernetesInfo != null && kubernetesInfo.isSpringActive);
  }

  private static boolean isSpringActive() {
    return IS_SPRING_INCLUDED
        && LogManager.getFactory() != null
        && LogManager.getFactory().hasContext(KubernetesLookup.class.getName(), null, false)
        && LogManager.getContext(false).getObject(SPRING_ENVIRONMENT_KEY) != null;
  }

  /**
   * Tries to initialize the fields of the lookup.
   */
  private static void tryInitializeFields(KubernetesLookup lookup) {
    KubernetesClient client = lookup.createClient();
    if (client != null) {
      if (lookup.pod == null) {
        lookup.pod = getCurrentPod(client);
      }
      if (lookup.pod != null && lookup.namespace == null) {
        lookup.namespace = getNamespace(client, lookup.pod);
      }
      if (lookup.masterUrl == null) {
        lookup.masterUrl = client.getMasterUrl();
      }
    } else {
      LOGGER.warn("Kubernetes is not available for access");
    }
  }

  /**
   * Creates a Kubernetes client used to retrieve K8S configuration.
   * <p>
   * Used in tests to provide a mock client.
   * </p>
   * 
   * @return A Kubernetes client.
   */
  protected KubernetesClient createClient() {
    return ClientBuilder.createClient();
  }

  private static Pod getCurrentPod(final KubernetesClient kubernetesClient) {
    final String hostName = getHostName();
    try {
      if (hostName != null && !hostName.isEmpty()) {
        return kubernetesClient.pods().withName(hostName).get();
      }
    } catch (Exception e) {
      LOGGER.debug("Unable to locate pod with name {}.", hostName, e);
    }
    return null;
  }

  static String getHostName() {
    String hostName = null;
    try {
      hostName = InetAddress.getLocalHost().getHostName();
    } catch (final UnknownHostException ignored) {
      // NOP
    }
    return hostName != null && !"localhost".equals(hostName) ? hostName : System.getenv(HOSTNAME);
  }

  private static Namespace getNamespace(KubernetesClient client, Pod pod) {
    return client.namespaces()
        .withName(pod.getMetadata().getNamespace())
        .get();
  }

  private static void fillNamespaceData(Namespace namespace, KubernetesInfo kubernetesInfo) {
    final ObjectMeta namespaceMetadata = namespace.getMetadata();
    if (namespaceMetadata != null) {
      kubernetesInfo.namespaceAnnotations = namespaceMetadata.getAnnotations();
      kubernetesInfo.namespaceId = namespaceMetadata.getUid();
      kubernetesInfo.namespaceLabels = namespaceMetadata.getLabels();
    }
  }

  private static void fillPodData(Pod pod, KubernetesInfo kubernetesInfo) {
    final ObjectMeta podMetadata = pod.getMetadata();
    if (podMetadata != null) {
      kubernetesInfo.annotations = podMetadata.getAnnotations();
      kubernetesInfo.labels = podMetadata.getLabels();
      kubernetesInfo.namespace = podMetadata.getNamespace();
      kubernetesInfo.podId = podMetadata.getUid();
      kubernetesInfo.podName = podMetadata.getName();
    }
    fillStatuses(pod, kubernetesInfo);
    // The container name is filled as a result
    String containerName = kubernetesInfo.containerName;

    final PodSpec podSpec = pod.getSpec();
    if (podSpec != null) {
      kubernetesInfo.hostName = podSpec.getNodeName();
      kubernetesInfo.accountName = podSpec.getServiceAccountName();

      Container container = getContainer(podSpec, containerName);
      if (container != null) {
        kubernetesInfo.containerName = container.getName();
        kubernetesInfo.imageName = container.getImage();
      }
    }
  }

  private static void fillStatuses(Pod pod, KubernetesInfo kubernetesInfo) {
    final PodStatus podStatus = pod.getStatus();
    if (podStatus != null) {
      kubernetesInfo.hostIp = podStatus.getHostIP();
      kubernetesInfo.podIp = podStatus.getPodIP();

      ContainerStatus containerStatus = getContainerStatus(podStatus);
      if (containerStatus != null) {
        kubernetesInfo.containerId = containerStatus.getContainerID();
        kubernetesInfo.imageId = containerStatus.getImageID();
        kubernetesInfo.containerName = containerStatus.getName();
      }
    }
  }

  private static ContainerStatus getContainerStatus(PodStatus podStatus) {
    List<ContainerStatus> statuses = podStatus.getContainerStatuses();
    switch (statuses.size()) {
      case 0:
        return null;
      case 1:
        return statuses.get(0);
      default:
        final String containerId = ContainerUtil.getContainerId(cgroupPath);
        return containerId != null ? statuses.stream()
            .filter(cs -> cs.getContainerID().contains(containerId))
            .findFirst()
            .orElse(null) : null;
    }
  }

  private static Container getContainer(PodSpec podSpec, String containerName) {
    final List<Container> containers = podSpec.getContainers();
    switch (containers.size()) {
      case 0:
        return null;
      case 1:
        return containers.get(0);
      default:
        return containerName != null ? containers.stream()
            .filter(c -> c.getName().equals(containerName))
            .findFirst()
            .orElse(null) : null;
    }
  }

  @Override
  public String lookup(final LogEvent event, final String key) {
    KubernetesInfo info;
    READ_LOCK.lock();
    try {
      info = kubernetesInfo;
    } finally {
      READ_LOCK.unlock();
    }
    if (key.startsWith(LABELS_PREFIX)) {
      return info.labels != null ? info.labels.get(key.substring(LABELS_PREFIX.length())) : null;
    }
    switch (key) {
      case ACCOUNT_NAME: {
        return info.accountName;
      }
      case ANNOTATIONS: {
        return info.annotations != null ? info.annotations.toString() : null;
      }
      case CONTAINER_ID: {
        return info.containerId;
      }
      case CONTAINER_NAME: {
        return info.containerName;
      }
      case HOST: {
        return info.hostName;
      }
      case HOST_IP: {
        return info.hostIp;
      }
      case LABELS: {
        return info.labels != null ? info.labels.toString() : null;
      }
      case MASTER_URL: {
        return info.masterUrl != null ? info.masterUrl.toString() : null;
      }
      case NAMESPACE_ANNOTATIONS: {
        return info.namespaceAnnotations != null ? info.namespaceAnnotations.toString() : null;
      }
      case NAMESPACE_ID: {
        return info.namespaceId;
      }
      case NAMESPACE_LABELS: {
        return info.namespaceLabels != null ? info.namespaceLabels.toString() : null;
      }
      case NAMESPACE_NAME: {
        return info.namespace;
      }
      case POD_ID: {
        return info.podId;
      }
      case POD_IP: {
        return info.podIp;
      }
      case POD_NAME: {
        return info.podName;
      }
      case IMAGE_ID: {
        return info.imageId;
      }
      case IMAGE_NAME: {
        return info.imageName;
      }
      default:
        return null;
    }
  }

  /**
   * For unit testing only.
   */
  static void clear() {
    kubernetesInfo = null;
    cgroupPath = ContainerUtil.CGROUP_PATH;
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
