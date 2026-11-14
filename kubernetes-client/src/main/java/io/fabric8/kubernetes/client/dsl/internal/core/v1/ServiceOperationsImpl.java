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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;
import io.fabric8.kubernetes.client.ServiceToURLProvider;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.ServiceResource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.utils.URLUtils;

import java.net.InetAddress;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ServiceOperationsImpl extends HasMetadataOperation<Service, ServiceList, ServiceResource<Service>>
    implements ServiceResource<Service> {

  public static final String EXTERNAL_NAME = "ExternalName";

  public ServiceOperationsImpl(Client client) {
    this(HasMetadataOperationsImpl.defaultContext(client));
  }

  private ServiceOperationsImpl(OperationContext context) {
    super(context.withPlural("services"), Service.class, ServiceList.class);
  }

  @Override
  public ServiceOperationsImpl newInstance(OperationContext context) {
    return new ServiceOperationsImpl(context);
  }

  @Override
  public Service waitUntilReady(long amount, TimeUnit timeUnit) {
    long started = System.nanoTime();
    super.waitUntilReady(amount, timeUnit);
    long alreadySpent = System.nanoTime() - started;

    // if awaiting existence took very long, let's give at least 10 seconds to awaiting readiness
    long remaining = Math.max(10_000, timeUnit.toNanos(amount) - alreadySpent);

    Resource<Endpoints> endpointsOperation = this.context.getClient().resources(Endpoints.class, EndpointsList.class)
        .inNamespace(this.context.getNamespace()).withName(this.context.getName());
    endpointsOperation.waitUntilReady(remaining, TimeUnit.MILLISECONDS);

    return get();
  }

  @Override
  public String getURL(String portName) {
    String clusterIP = getItemOrRequireFromServer().getSpec().getClusterIP();
    if ("None".equals(clusterIP)) {
      throw new IllegalStateException("Service: " + getItemOrRequireFromServer().getMetadata().getName() + " in namespace "
          + namespace + " is head-less. Search for endpoints instead");
    }
    return getUrlHelper(portName);
  }

  private String getUrlHelper(String portName) {
    List<ServiceToURLProvider> servicesList = getServiceToURLProviders(Thread.currentThread().getContextClassLoader());
    if (servicesList.isEmpty()) {
      servicesList = getServiceToURLProviders(getClass().getClassLoader());
    }

    // Sort all loaded implementations according to priority
    Collections.sort(servicesList, new ServiceToUrlSortComparator());
    for (ServiceToURLProvider serviceToURLProvider : servicesList) {
      String url = serviceToURLProvider.getURL(getItemOrRequireFromServer(), portName, namespace,
          context.getClient().adapt(KubernetesClient.class));
      if (url != null && URLUtils.isValidURL(url)) {
        return url;
      }
    }

    return null;
  }

  private static List<ServiceToURLProvider> getServiceToURLProviders(ClassLoader loader) {
    Iterator<ServiceToURLProvider> iterator = ServiceLoader.load(ServiceToURLProvider.class, loader).iterator();
    List<ServiceToURLProvider> servicesList = new ArrayList<>();

    while (iterator.hasNext()) {
      servicesList.add(iterator.next());
    }
    return servicesList;
  }

  private Pod matchingPod(Service item) {
    Map<String, String> labels = item.getSpec().getSelector();
    PodList list = new PodOperationsImpl(context.getClient()).inNamespace(item.getMetadata().getNamespace()).withLabels(labels)
        .list();
    return list.getItems().stream().findFirst()
        .orElseThrow(() -> new IllegalStateException("Could not find matching pod for service:" + item + "."));
  }

  @Override
  public PortForward portForward(int port, ReadableByteChannel in, WritableByteChannel out) {
    Service s = requireFromServer();
    Pod m = matchingPod(s);
    return new PodOperationsImpl(context.getClient())
        .inNamespace(m.getMetadata().getNamespace())
        .withName(m.getMetadata().getName())
        .portForward(getTargetPortAsInt(s, m, port), in, out);
  }

  @Override
  public LocalPortForward portForward(int port) {
    return portForward(port, 0);
  }

  @Override
  public LocalPortForward portForward(int port, int localPort) {
    return portForward(port, null, localPort);
  }

  @Override
  public LocalPortForward portForward(int port, InetAddress localInetAddress, int localPort) {
    Service s = requireFromServer();
    Pod m = matchingPod(s);
    return new PodOperationsImpl(context.getClient())
        .inNamespace(m.getMetadata().getNamespace())
        .withName(m.getMetadata().getName())
        .portForward(getTargetPortAsInt(s, m, port), localInetAddress, localPort);
  }

  private int getTargetPortAsInt(Service service, Pod pod, int port) {
    return service.getSpec().getPorts().stream()
        .filter(p -> p.getPort().equals(port))
        .map(p -> resolveTargetPort(service, p, pod))
        .findFirst()
        .orElse(port);
  }

  private int resolveTargetPort(Service service, ServicePort servicePort, Pod pod) {
    if ("None".equals(service.getSpec().getClusterIP())) {
      return servicePort.getPort();
    }
    IntOrString targetPort = servicePort.getTargetPort();
    if (targetPort == null) {
      return servicePort.getPort();
    }
    Integer intVal = targetPort.getIntVal();
    if (intVal != null) {
      return intVal == 0 ? servicePort.getPort() : intVal;
    }
    String strVal = targetPort.getStrVal();
    if (strVal == null) {
      return servicePort.getPort();
    }
    return findPodContainerPort(pod, strVal, servicePort.getProtocol())
        .orElseThrow(() -> new IllegalStateException(String.format(
            "Could not resolve targetPort '%s' for service port %d on pod %s.",
            strVal, servicePort.getPort(), pod.getMetadata().getName())));
  }

  private Optional<Integer> findPodContainerPort(Pod pod, String name, String serviceProtocol) {
    if (pod.getSpec() == null) {
      return Optional.empty();
    }
    Stream<Container> containers = stream(pod.getSpec().getContainers());
    Stream<Container> sidecars = stream(pod.getSpec().getInitContainers())
        .filter(container -> "Always".equals(container.getRestartPolicy()));
    return Stream.concat(containers, sidecars)
        .flatMap(container -> stream(container.getPorts()))
        .filter(containerPort -> Objects.equals(containerPort.getName(), name))
        .filter(containerPort -> protocolsMatch(serviceProtocol, containerPort.getProtocol()))
        .map(ContainerPort::getContainerPort)
        .filter(Objects::nonNull)
        .findFirst();
  }

  private static <T> Stream<T> stream(List<T> items) {
    return items == null ? Stream.empty() : items.stream();
  }

  private static boolean protocolsMatch(String serviceProtocol, String containerProtocol) {
    return protocolOrDefault(serviceProtocol).equals(protocolOrDefault(containerProtocol));
  }

  private static String protocolOrDefault(String protocol) {
    return protocol == null ? "TCP" : protocol;
  }

  public static final class ServiceToUrlSortComparator implements Comparator<ServiceToURLProvider> {
    @Override
    public int compare(ServiceToURLProvider first, ServiceToURLProvider second) {
      return first.getPriority() - second.getPriority();
    }
  }

  @Override
  protected Service modifyItemForReplaceOrPatch(Supplier<Service> currentSupplier, Service item) {
    if (!isExternalNameService(item)) {
      Service old = currentSupplier.get();
      return new ServiceBuilder(item)
          .editSpec()
          .withClusterIP(old.getSpec().getClusterIP())
          .endSpec()
          .build();
    }
    return item;
  }

  private boolean isExternalNameService(Service item) {
    if (item.getSpec() != null && item.getSpec().getType() != null) {
      return item.getSpec().getType().equals(EXTERNAL_NAME);
    }
    return false;
  }
}
