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
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.ServiceToURLProvider;
import io.fabric8.kubernetes.client.utils.internal.URLFromServiceUtil;

public class URLFromClusterIPImpl implements ServiceToURLProvider {
  @Override
  public int getPriority() {
    return ServiceToUrlImplPriority.FIFTH.getValue();
  }

  @Override
  public String getURL(Service service, String portName, String namespace, KubernetesClient client) {
    ServicePort port = URLFromServiceUtil.getServicePortByName(service, portName);
    if (port != null && service.getSpec().getType().equals("ClusterIP")) {
      return port.getProtocol().toLowerCase() + "://" + service.getSpec().getClusterIP() + ":" + port.getPort();
    }
    return null;
  }
}
