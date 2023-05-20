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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ServiceToURLProvider;
import io.fabric8.kubernetes.client.utils.internal.URLFromServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Locale;

public class URLFromNodePortImpl implements ServiceToURLProvider {
  public static final Logger logger = LoggerFactory.getLogger(URLFromNodePortImpl.class);

  public String getURL(Service service, String portName, String namespace, KubernetesClient client) {
    ServicePort port = URLFromServiceUtil.getServicePortByName(service, portName);
    String serviceProto = port.getProtocol();
    NodePortUrlComponents urlComponents = null;
    Integer nodePort = port.getNodePort();
    if (nodePort != null) {
      try {
        NodeList nodeList = client.nodes().list();
        if (nodeList != null && nodeList.getItems() != null) {
          for (Node item : nodeList.getItems()) {
            urlComponents = getUrlComponentsFromNodeList(item.getStatus(), nodePort);
            if (urlComponents != null) {
              break;
            }
          }
        }
      } catch (KubernetesClientException exception) {
        logger.warn("Could not find a node!", exception);
      }
    }

    return urlComponents != null
        ? (serviceProto + "://" + urlComponents.getClusterIP() + ":" + urlComponents.getPortNumber()).toLowerCase(Locale.ROOT)
        : null;
  }

  private NodePortUrlComponents getUrlComponentsFromNodeList(NodeStatus nodeStatus, Integer nodePort) {
    if (nodeStatus != null) {
      List<NodeAddress> addresses = nodeStatus.getAddresses();
      for (NodeAddress address : addresses) {
        String ip = address.getAddress();
        if (!ip.isEmpty()) {
          return new NodePortUrlComponents(ip, nodePort);
        }
      }
    }
    return null;
  }

  private class NodePortUrlComponents {
    public String getClusterIP() {
      return clusterIP;
    }

    private String clusterIP;

    public Integer getPortNumber() {
      return portNumber;
    }

    private Integer portNumber;

    public NodePortUrlComponents(String clusterIP, Integer portNumber) {
      this.clusterIP = clusterIP;
      this.portNumber = portNumber;
    }
  }

  @Override
  public int getPriority() {
    return ServiceToUrlImplPriority.SECOND.getValue();
  }

}
