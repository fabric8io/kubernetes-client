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

package io.fabric8.openshift.examples;

import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.OpenShiftAPIGroups;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListDeploymentConfigs {

  private static final Logger logger = LoggerFactory.getLogger(ListDeploymentConfigs.class);

  public static void main(String[] args) {
    try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
      if (!client.supportsOpenShiftAPIGroup(OpenShiftAPIGroups.APPS)) {
        logger.warn("This cluster does not support the API Group {}", OpenShiftAPIGroups.APPS);
        return;
      }
      DeploymentConfigList list = client.deploymentConfigs().list();
      if (list == null) {
        logger.error("No list returned!");
        return;
      }
      List<DeploymentConfig> items = list.getItems();
      for (DeploymentConfig item : items) {
        logger.info("DeploymentConfig {} has version: {}", item.getMetadata().getName(), item.getApiVersion());
      }

      if (!items.isEmpty()) {
        DeploymentConfig deploymentConfig = items.get(0);
        String name = deploymentConfig.getMetadata().getName();
        deploymentConfig = client.deploymentConfigs().withName(name).get();
        if (deploymentConfig == null) {
          logger.error("No DeploymentConfig found for name {}", name);
          return;
        }
        logger.info("get() DeploymentConfig {} has version: {}", name, deploymentConfig.getApiVersion());
      }
    } catch (KubernetesClientException e) {
      logger.error("Failed: {}", e.getMessage(), e);
    }
  }

}
