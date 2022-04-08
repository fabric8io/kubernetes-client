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

package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListLoadIT {

  KubernetesClient client;

  @Test
  void test() {
    DeploymentList deploymentListOld = client.apps().deployments().list();
    client.load(getClass().getResourceAsStream("/test-list.json")).createOrReplace();

    DeploymentList deploymentListNew = client.apps().deployments().list();
    assertThat(deploymentListNew).isNotNull();
    assertEquals(deploymentListOld.getItems().size() + 1, deploymentListNew.getItems().size());
  }

}
