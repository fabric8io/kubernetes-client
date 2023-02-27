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

package io.fabric8.kubernetes.client.utils.internal;

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.client.utils.URLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getNamespace;

public class URLFromServiceUtil {
  public static final Logger logger = LoggerFactory.getLogger(URLFromServiceUtil.class);
  public static final String DEFAULT_PROTO = "tcp";
  private static final String HOST_SUFFIX = "_SERVICE_HOST";
  private static final String PORT_SUFFIX = "_SERVICE_PORT";
  private static final String PROTO_SUFFIX = "_TCP_PROTO";

  private URLFromServiceUtil() {
  }

  public static String resolveHostFromEnvVarOrSystemProperty(String serviceName) {
    return getEnvVarOrSystemProperty(toServiceHostEnvironmentVariable(serviceName), "");
  }

  private static String getEnvVarOrSystemProperty(String envVarName, String defaultValue) {
    String answer = null;
    try {
      answer = System.getenv(envVarName);
    } catch (Exception e) {
      logger.warn("Failed to look up environment variable $" + envVarName + ". " + e, e);
    }
    if (answer == null || answer.isEmpty()) {
      answer = System.getProperty(envVarName, defaultValue);
    }
    if (!answer.isEmpty()) {
      return answer;
    } else {
      return defaultValue;
    }
  }

  public static String resolveProtocolFromEnvVarOrSystemProperty(String serviceName, String servicePort) {
    return getEnvVarOrSystemProperty(toEnvVariable(serviceName + PORT_SUFFIX + "_" + servicePort + PROTO_SUFFIX),
        DEFAULT_PROTO);
  }

  public static String resolvePortFromEnvVarOrSystemProperty(String serviceName, String portName) {
    String envVarName = toServicePortEnvironmentVariable(serviceName, portName);
    return getEnvVarOrSystemProperty(envVarName, "");
  }

  public static String toServicePortEnvironmentVariable(String serviceName, String portName) {
    String name = serviceName + PORT_SUFFIX + (!portName.isEmpty() ? "_" + portName : "");
    return toEnvVariable(name);
  }

  private static String toServiceHostEnvironmentVariable(String serviceName) {
    return toEnvVariable(serviceName + HOST_SUFFIX);
  }

  public static String toEnvVariable(String serviceName) {
    return serviceName.toUpperCase(Locale.ROOT).replaceAll("-", "_");
  }

  public static String getURLFromExtensionsV1beta1IngressList(
      List<io.fabric8.kubernetes.api.model.extensions.Ingress> ingressList, String namespace, String serviceName,
      ServicePort port) {
    for (io.fabric8.kubernetes.api.model.extensions.Ingress item : ingressList) {
      String ns = getNamespace(item);
      if (Objects.equals(ns, namespace) && item.getSpec() != null) {
        String url = getURLFromIngressSpec(item.getSpec(), serviceName, port);
        if (url != null) {
          return url;
        }
      }
    }
    return null;
  }

  public static String getURLFromNetworkingV1IngressList(
      List<io.fabric8.kubernetes.api.model.networking.v1.Ingress> ingressList, String namespace, String serviceName,
      ServicePort port) {
    for (io.fabric8.kubernetes.api.model.networking.v1.Ingress item : ingressList) {
      String ns = getNamespace(item);
      if (Objects.equals(ns, namespace) && item.getSpec() != null) {
        String url = getURLFromNetworkV1IngressSpec(item.getSpec(), serviceName, port);
        if (url != null) {
          return url;
        }
      }
    }
    return null;
  }

  public static String getURLFromNetworkV1IngressSpec(io.fabric8.kubernetes.api.model.networking.v1.IngressSpec spec,
      String serviceName, ServicePort port) {
    List<io.fabric8.kubernetes.api.model.networking.v1.IngressRule> ingressRules = spec.getRules();
    if (ingressRules != null && !ingressRules.isEmpty()) {
      for (io.fabric8.kubernetes.api.model.networking.v1.IngressRule rule : ingressRules) {
        io.fabric8.kubernetes.api.model.networking.v1.HTTPIngressRuleValue http = rule.getHttp();
        if (http != null && http.getPaths() != null) {
          return getURLFromNetworkV1IngressRules(http.getPaths(), spec, serviceName, port, rule);
        }
      }
    }
    return null;
  }

  public static String getURLFromNetworkV1IngressRules(
      List<io.fabric8.kubernetes.api.model.networking.v1.HTTPIngressPath> paths,
      io.fabric8.kubernetes.api.model.networking.v1.IngressSpec spec, String serviceName,
      ServicePort port, io.fabric8.kubernetes.api.model.networking.v1.IngressRule rule) {
    for (io.fabric8.kubernetes.api.model.networking.v1.HTTPIngressPath path : paths) {
      io.fabric8.kubernetes.api.model.networking.v1.IngressBackend backend = path.getBackend();
      if (backend != null) {
        String backendServiceName = backend.getService().getName();
        if (serviceName.equals(backendServiceName)
            && portsMatch(port, new IntOrString(backend.getService().getPort().getNumber()))) {
          return getURLFromIngressBackend(spec.getTls() != null && !spec.getTls().isEmpty(), path.getPath(), rule.getHost());
        }
      }
    }
    return null;
  }

  public static String getURLFromIngressSpec(io.fabric8.kubernetes.api.model.extensions.IngressSpec spec, String serviceName,
      ServicePort port) {
    List<io.fabric8.kubernetes.api.model.extensions.IngressRule> ingressRules = spec.getRules();
    if (ingressRules != null && !ingressRules.isEmpty()) {
      for (io.fabric8.kubernetes.api.model.extensions.IngressRule rule : ingressRules) {
        io.fabric8.kubernetes.api.model.extensions.HTTPIngressRuleValue http = rule.getHttp();
        if (http != null && http.getPaths() != null) {
          return getURLFromIngressRules(http.getPaths(), spec, serviceName, port, rule);
        }
      }
    }
    return null;
  }

  public static String getURLFromIngressRules(List<io.fabric8.kubernetes.api.model.extensions.HTTPIngressPath> paths,
      io.fabric8.kubernetes.api.model.extensions.IngressSpec spec, String serviceName,
      ServicePort port, io.fabric8.kubernetes.api.model.extensions.IngressRule rule) {
    for (io.fabric8.kubernetes.api.model.extensions.HTTPIngressPath path : paths) {
      io.fabric8.kubernetes.api.model.extensions.IngressBackend backend = path.getBackend();
      if (backend != null) {
        String backendServiceName = backend.getServiceName();
        if (serviceName.equals(backendServiceName) && portsMatch(port, backend.getServicePort())) {
          return getURLFromIngressBackend(spec.getTls() != null && !spec.getTls().isEmpty(), path.getPath(), rule.getHost());
        }
      }
    }
    return null;
  }

  private static String getURLFromIngressBackend(boolean tlsProvided, String pathPostFix, String host) {
    if (tlsProvided) {
      return getURLFromTLSHost(host, pathPostFix);
    }
    if (host != null && !host.isEmpty()) {
      pathPostFix = fixPathPostFixIfEmpty(pathPostFix);
      return "http://" + URLUtils.pathJoin(host, pathPostFix);
    }
    return null;
  }

  public static String getURLFromTLSHost(String host, String pathPostFix) {
    if (!host.isEmpty()) {
      pathPostFix = fixPathPostFixIfEmpty(pathPostFix);
      return "https://" + URLUtils.pathJoin(host, pathPostFix);
    }
    return null;
  }

  private static String fixPathPostFixIfEmpty(String pathPostFix) {
    return pathPostFix.isEmpty() ? "/" : pathPostFix;
  }

  private static boolean portsMatch(ServicePort servicePort, IntOrString intOrString) {
    if (intOrString != null) {
      Integer port = servicePort.getPort();
      Integer intVal = intOrString.getIntVal();
      String strVal = intOrString.getStrVal();
      if (intVal != null) {
        if (port != null) {
          return port.intValue() == intVal.intValue();
        } else {
          /// should we find the port by name now?
        }
      } else if (strVal != null) {
        return strVal.equals(servicePort.getName());
      }
    }
    return false;
  }

  public static ServicePort getServicePortByName(Service service, String portName) {
    if (portName.isEmpty()) {
      return service.getSpec().getPorts().iterator().next();
    }

    for (ServicePort servicePort : service.getSpec().getPorts()) {
      if (Objects.equals(servicePort.getName(), portName)) {
        return servicePort;
      }
    }
    return null;
  }
}
