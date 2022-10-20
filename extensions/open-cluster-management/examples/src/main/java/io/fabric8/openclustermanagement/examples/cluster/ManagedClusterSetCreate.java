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
package io.fabric8.openclustermanagement.examples.cluster;

import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSet;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBuilder;
import io.fabric8.openclustermanagement.client.DefaultOpenClusterManagementClient;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagedClusterSetCreate {
  private static final Logger logger = LoggerFactory.getLogger(ManagedClusterSetCreate.class.getSimpleName());

  public static void main(String[] args) {
    try (OpenClusterManagementClient ocmClient = new DefaultOpenClusterManagementClient()) {
      ManagedClusterSet managedClusterSet = new ManagedClusterSetBuilder()
          .withNewMetadata().withName("managedclusterset1").endMetadata()
          .withNewSpec()
          .endSpec()
          .build();
      logger.info("Creating ManagedClusterSet {}", managedClusterSet.getMetadata().getName());

      ocmClient.clusters().managedClusterSets().create(managedClusterSet);
    }
  }
}
