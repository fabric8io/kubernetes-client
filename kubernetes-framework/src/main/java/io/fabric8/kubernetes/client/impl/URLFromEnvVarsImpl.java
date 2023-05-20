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

package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.ServiceToURLProvider;
import io.fabric8.kubernetes.client.utils.internal.URLFromServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getOrCreateAnnotations;

public class URLFromEnvVarsImpl implements ServiceToURLProvider {
  public static final Logger logger = LoggerFactory.getLogger(URLFromEnvVarsImpl.class);

  public static final String ANNOTATION_EXPOSE_URL = "fabric8.io/exposeUrl";

  @Override
  public String getURL(Service service, String portName, String namespace, KubernetesClient client) {
    String serviceHost = URLFromServiceUtil.resolveHostFromEnvVarOrSystemProperty(service.getMetadata().getName());
    String servicePort = URLFromServiceUtil.resolvePortFromEnvVarOrSystemProperty(service.getMetadata().getName(), "");
    String serviceProtocol = URLFromServiceUtil
        .resolveProtocolFromEnvVarOrSystemProperty(service.getSpec().getPorts().iterator().next().getProtocol(), "");

    if (!serviceHost.isEmpty() && !servicePort.isEmpty() && !serviceProtocol.isEmpty()) {
      return serviceProtocol + "://" + serviceHost + ":" + servicePort;
    } else {
      String answer = getOrCreateAnnotations(service).get(ANNOTATION_EXPOSE_URL);
      if (answer != null && !answer.isEmpty()) {
        return answer;
      }
    }
    return null;
  }

  @Override
  public int getPriority() {
    return ServiceToUrlImplPriority.THIRD.getValue();
  }
}
