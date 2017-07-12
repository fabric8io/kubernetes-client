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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftAPIGroups;
import io.fabric8.openshift.client.OpenShiftClient;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ListDeploymentConfigs {
  public static void main(String[] args) {
    try {
      OpenShiftClient client = new DefaultOpenShiftClient();
      if (!client.supportsOpenShiftAPIGroup(OpenShiftAPIGroups.APPS)) {
        System.out.println("WARNING this cluster does not support the API Group " + OpenShiftAPIGroups.APPS);
        return;
      }
      DeploymentConfigList list = client.deploymentConfigs().list();
      if (list == null) {
        System.out.println("ERROR no list returned!");
        return;
      }
      List<DeploymentConfig> items = list.getItems();
      for (DeploymentConfig item : items) {
        System.out.println("DeploymentConfig " + item.getMetadata().getName() + " has version: " + item.getApiVersion());
      }

      if (items.size() > 0) {
        // lets check .get() too
        DeploymentConfig deploymentConfig = items.get(0);
        String name = deploymentConfig.getMetadata().getName();
        deploymentConfig = client.deploymentConfigs().withName(name).get();
        assertNotNull("No DeploymentConfig found for name " + name, deploymentConfig);
        System.out.println("get() DeploymentConfig " + name + " has version: " + deploymentConfig.getApiVersion());
      }
    } catch (KubernetesClientException e) {
      System.out.println("Failed: " + e);
      e.printStackTrace();
    }
  }

}
