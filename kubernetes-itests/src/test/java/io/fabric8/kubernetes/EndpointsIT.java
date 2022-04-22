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

import io.fabric8.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@LoadKubernetesManifests("/endpoints-it.yml")
class EndpointsIT {

  KubernetesClient client;

  @Test
  void get() {
    Endpoints endpoints = client.endpoints().withName("endpoints-get").get();
    assertThat(endpoints).isNotNull();
  }

  @Test
  void list() {
    EndpointsList aEndpointList = client.endpoints().list();
    assertNotNull(aEndpointList);
    assertTrue(aEndpointList.getItems().size() >= 1);
  }

  @Test
  void update() {
    Endpoints endpoints = client.endpoints().withName("endpoints-update").edit(c -> new EndpointsBuilder(c)
      .editOrNewMetadata().addToAnnotations("foo", "bar").endMetadata().build());

    assertNotNull(endpoints);
    assertEquals("bar", endpoints.getMetadata().getAnnotations().get("foo"));
  }

  @Test
  void delete() {
    assertTrue(client.endpoints().withName("endpoints-delete").delete().size() == 1);
  }

}
