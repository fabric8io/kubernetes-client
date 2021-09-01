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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ServiceToURLProvider;
import io.fabric8.kubernetes.client.utils.URLFromServiceUtil;
import io.fabric8.openshift.api.model.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class URLFromOpenshiftRouteImpl implements ServiceToURLProvider {
  public static final Logger logger = LoggerFactory.getLogger(URLFromOpenshiftRouteImpl.class);
  private final ConcurrentMap<URL, Boolean> IS_OPENSHIFT = new ConcurrentHashMap<>();

  @Override
  public String getURL(Service service, String portName, String namespace, KubernetesClient client) {
    String serviceName = service.getMetadata().getName();
    ServicePort port = URLFromServiceUtil.getServicePortByName(service, portName);
    if(port != null && port.getName() != null && isOpenShift(client)) {
      try {
        String serviceProtocol = port.getProtocol();
        OpenShiftClient openShiftClient = client.adapt(OpenShiftClient.class);
        Route route = openShiftClient.routes().inNamespace(namespace).withName(service.getMetadata().getName()).get();
        if (route != null) {
          return (serviceProtocol + "://" + route.getSpec().getHost()).toLowerCase(Locale.ROOT);
        }
      } catch (KubernetesClientException e) {
        if(e.getCode() == HttpURLConnection.HTTP_FORBIDDEN) {
          logger.warn("Could not lookup route:{} in namespace:{}, due to:{} ",serviceName,namespace,e.getMessage());
        }
      }
    }
    return null;
  }

  @Override
  public int getPriority() {
    return ServiceToUrlImplPriority.FOURTH.getValue();
  }

  public boolean isOpenShift(KubernetesClient client) {
    URL masterUrl = client.getMasterUrl();
    if (IS_OPENSHIFT.containsKey(masterUrl)) {
      return IS_OPENSHIFT.get(masterUrl);
    } else {
      RootPaths rootPaths = client.rootPaths();
      if (rootPaths != null) {
        List<String> paths = rootPaths.getPaths();
        if (paths != null) {
          for (String path : paths) {
            if (java.util.Objects.equals("/oapi", path) || java.util.Objects.equals("oapi", path)) {
              IS_OPENSHIFT.putIfAbsent(masterUrl, true);
              return true;
            }
          }
        }
      }
    }
    IS_OPENSHIFT.putIfAbsent(masterUrl, false);
    return false;
  }
}
