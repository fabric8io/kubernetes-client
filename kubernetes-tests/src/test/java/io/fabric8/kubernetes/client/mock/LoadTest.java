/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
public class LoadTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testResourceGetFromLoadWhenMultipleDocumentsWithDelimiter() throws Exception {
    // given
    KubernetesClient client = server.getClient();

    // when
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/multiple-document-template.yml")).get();

    // then
    assertNotNull(result);
    assertEquals(6, result.size());
    HasMetadata deploymentResource = result.get(1);
    assertEquals("apps/v1", deploymentResource.getApiVersion());
    assertEquals("Deployment", deploymentResource.getKind());
    assertEquals("redis-master", deploymentResource.getMetadata().getName());
  }

  @Test
  public void testResourceGetFromLoadWhenSingleDocumentsWithoutDelimiter() throws Exception {
    // given
    KubernetesClient client = server.getClient();

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

  @Test
  public void testResourceGetFromLoadWhenSingleDocumentsWithStartingDelimiter() throws Exception {
    // given
    KubernetesClient client = server.getClient();

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
}
