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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@LoadKubernetesManifests("/endpoints-it.yml")
class EndpointsIT {

  KubernetesClient client;

  @Test
  void withNoSubsets() {
    final Endpoints result = client.endpoints().withName("endpoints-with-no-subsets").get();
    assertThat(result)
        .hasFieldOrPropertyWithValue("metadata.name", "endpoints-with-no-subsets")
        .extracting(Endpoints::getSubsets).asList()
        .isEmpty();
  }

  @Test
  void withSubsets() {
    client.apps().deployments().withName("endpoints-with-subsets").waitUntilReady(30, TimeUnit.SECONDS);
    final Endpoints result = client.endpoints().withName("endpoints-with-subsets").get();
    assertThat(result)
        .hasFieldOrPropertyWithValue("metadata.name", "endpoints-with-subsets")
        .extracting(Endpoints::getSubsets).asList()
        .singleElement()
        .extracting("ports").asList()
        .singleElement()
        .hasFieldOrPropertyWithValue("name", "http")
        .hasFieldOrPropertyWithValue("protocol", "TCP")
        .hasFieldOrPropertyWithValue("port", 1337);
  }

  @Test
  void list() {
    final EndpointsList result = client.endpoints().list();
    assertThat(result)
        .extracting(EndpointsList::getItems).asList()
        .extracting("metadata.name")
        .containsExactlyInAnyOrder("endpoints-with-subsets", "endpoints-with-no-subsets");
  }

}
