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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersion;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterServiceVersionTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void testLoad() {
    ClusterServiceVersion clusterServiceVersion = client.operatorHub().clusterServiceVersions()
        .load(getClass().getResourceAsStream("/test-clusterserviceversion.yml"))
        .item();

    assertThat(clusterServiceVersion)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "memcached-operator.v0.0.1")
        .hasFieldOrPropertyWithValue("spec.version", "0.0.1");
  }
}
