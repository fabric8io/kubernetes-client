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
package io.fabric8.openclustermanagement.examples.apps;

import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRule;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleBuilder;
import io.fabric8.openclustermanagement.client.DefaultOpenClusterManagementClient;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlacementRuleCreate {
  private static final Logger logger = LoggerFactory.getLogger(PlacementRuleCreate.class.getSimpleName());

  public static void main(String[] args) {
    try (OpenClusterManagementClient ocmClient = new DefaultOpenClusterManagementClient()) {

      PlacementRule placementRule = new PlacementRuleBuilder()
          .withNewMetadata().withName("towhichcluster").endMetadata()
          .withNewSpec()
          .addNewClusterCondition()
          .withType("ManagedClusterConditionAvailable")
          .withStatus("True")
          .endClusterCondition()
          .endSpec()
          .build();
      logger.info("Creating PlacementRule {}", placementRule.getMetadata().getName());
      ocmClient.apps().placementRules().inNamespace("default").create(placementRule);
      logger.info("Success.");
    }
  }
}
