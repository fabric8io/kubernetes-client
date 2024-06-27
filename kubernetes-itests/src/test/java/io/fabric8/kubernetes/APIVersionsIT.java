/*
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

import io.fabric8.kubernetes.api.model.APIVersions;
import io.fabric8.kubernetes.api.model.ServerAddressByClientCIDR;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class APIVersionsIT {
  KubernetesClient client;

  @Test
  void testApiVersions() {
    // Given + When
    APIVersions apiVersions = client.getAPIVersions();
    // Then
    assertThat(apiVersions)
        .isNotNull()
        .hasFieldOrPropertyWithValue("versions", Collections.singletonList("v1"))
        .extracting(APIVersions::getServerAddressByClientCIDRs)
        .asInstanceOf(InstanceOfAssertFactories.list(ServerAddressByClientCIDR.class))
        .singleElement()
        .hasFieldOrPropertyWithValue("clientCIDR", "0.0.0.0/0")
        .hasFieldOrPropertyWithValue("serverAddress",
            String.format("%s:%d", client.getMasterUrl().getHost(), client.getMasterUrl().getPort()));
  }
}
