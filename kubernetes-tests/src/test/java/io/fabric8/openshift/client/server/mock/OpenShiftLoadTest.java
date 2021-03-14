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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableOpenShiftMockClient
class OpenShiftLoadTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testResourceGetFromLoadWhenSingleDocumentsWithStartingDelimiter() {

    // when
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/test-template.yml")).get();

    // then
    assertNotNull(result);
    assertEquals(5, result.size());
    HasMetadata deploymentResource = result.get(1);
    assertEquals("v1", deploymentResource.getApiVersion());
    assertEquals("ImageStream", deploymentResource.getKind());
    assertEquals("eap-app", deploymentResource.getMetadata().getName());
  }

  @Test
  void testResourceGetFromLoadWhenSingleDocumentsWithoutDelimiter() {

    // when
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/template-with-params.yml")).get();

    // then
    assertNotNull(result);
    assertEquals(1, result.size());
    HasMetadata deploymentResource = result.get(0);
    assertEquals("v1", deploymentResource.getApiVersion());
    assertEquals("Pod", deploymentResource.getKind());
    assertEquals("example-pod", deploymentResource.getMetadata().getName());
  }
}
