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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.extended.leaderelection.resourcelock.ConfigMapLock;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.fabric8.kubernetes.client.mock.LeaderElectionTest.testAndAssertSingleLeader;

@EnableKubernetesMockClient(crud = true)
@DisplayName("LeaderElection runs on Kubernetes Mock Server in CRUD mode")
class LeaderElectionCrudTest {

  KubernetesClient client;

  @Test
  void singleLeaderConfigMapLockTest() throws Exception {
    testAndAssertSingleLeader(client, "lead-config-map-crud",
        new ConfigMapLock("namespace", "name", "lead-config-map-crud"));

  }
}
