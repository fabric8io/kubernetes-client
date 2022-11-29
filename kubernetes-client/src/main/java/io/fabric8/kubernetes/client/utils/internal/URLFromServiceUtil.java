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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.extensions.*;
import io.fabric8.kubernetes.client.utils.URLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class URLFromServiceUtil {
  public static final Logger logger = LoggerFactory.getLogger(URLFromServiceUtil.class);
  public static final String DEFAULT_PROTO = "tcp";
  private static final String HOST_SUFFIX = "_SERVICE_HOST";
  private static final String PORT_SUFFIX = "_SERVICE_PORT";
  private static final String PROTO_SUFFIX = "_TCP_PROTO";

  private URLFromServiceUtil() {
    throw new IllegalStateException("Utility class");
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

  public static Map<String, String> getOrCreateAnnotations(HasMetadata entity) {
    ObjectMeta metadata = getOrCreateMetadata(entity);
    Map<String, String> answer = metadata.getAnnotations();
    if (answer == null) {
      // use linked so the annotations can be in the FIFO order
      answer = new LinkedHashMap<>();
      metadata.setAnnotations(answer);
    }
    return answer;
  }

  public static ObjectMeta getOrCreateMetadata(HasMetadata entity) {
    ObjectMeta metadata = entity.getMetadata();
    if (metadata == null) {
      metadata = new ObjectMeta();
      entity.setMetadata(metadata);
    }
    return metadata;
  }

  public static String resolvePortFromEnvVarOrSystemProperty(String serviceName, String portName) {
    String envVarName = toServicePortEnvironmentVariable(serviceName, portName);
    return getEnvVarOrSystemProperty(envVarName, "");
  }

  public static String toServicePortEnvironmentVariable(String serviceName, String portName) {
    String name = serviceName + PORT_SUFFIX + (portName.isEmpty() ? "_" + portName : "");
    return toEnvVariable(name);
  }

  private static String toServiceHostEnvironmentVariable(String serviceName) {
    return toEnvVariable(serviceName + HOST_SUFFIX);
  }

  public static String toEnvVariable(String serviceName) {
    return serviceName.toUpperCase(Locale.ROOT).replaceAll("-", "_");
  }

  public static String getURLFromIngressList(List<Ingress> ingressList, String namespace, String serviceName,
      ServicePort port) {
    for (Ingress item : ingressList) {
      String ns = getNamespace(item);
      if (Objects.equals(ns, namespace) && item.getSpec() != null) {
        return getURLFromIngressSpec(item.getSpec(), serviceName, port);
      }
    }
    return null;
  }

  public static String getURLFromIngressSpec(IngressSpec spec, String serviceName, ServicePort port) {
    List<IngressRule> ingressRules = spec.getRules();
    if (ingressRules != null && !ingressRules.isEmpty()) {
      for (IngressRule rule : ingressRules) {
        HTTPIngressRuleValue http = rule.getHttp();
        if (http != null && http.getPaths() != null) {
          return getURLFromIngressRules(http.getPaths(), spec, serviceName, port, rule);
        }
      }
    }
    return null;
  }

  public static String getURLFromIngressRules(List<HTTPIngressPath> paths, IngressSpec spec, String serviceName,
      ServicePort port, IngressRule rule) {
    for (HTTPIngressPath path : paths) {
      IngressBackend backend = path.getBackend();
      if (backend != null) {
        String backendServiceName = backend.getServiceName();
        if (serviceName.equals(backendServiceName) && portsMatch(port, backend.getServicePort())) {
          String pathPostFix = path.getPath();
          if (spec.getTls() != null) {
            return getURLFromTLSHost(rule, pathPostFix);
          }
          String answer = rule.getHost();
          if (answer != null && !answer.isEmpty()) {
            pathPostFix = fixPathPostFixIfEmpty(pathPostFix);
            return "http://" + URLUtils.pathJoin(answer, pathPostFix);
          }
        }
      }
    }
    return null;
  }

  public static String getURLFromTLSHost(IngressRule rule, String pathPostFix) {
    String host = rule.getHost();
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

  public static String getNamespace(HasMetadata entity) {
    if (entity != null) {
      return entity.getMetadata() != null ? entity.getMetadata().getNamespace() : null;
    } else {
      return null;
    }
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
