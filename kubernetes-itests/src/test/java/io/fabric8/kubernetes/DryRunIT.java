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

import io.fabric8.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 13)
class DryRunIT {

  static KubernetesClient client;

  Namespace namespace;

  @BeforeAll
  public static void init() {
    client.load(CronJobIT.class.getResourceAsStream("/dryrun-it.yml")).create();
  }

  @AfterAll
  public static void cleanup() {
    client.load(CronJobIT.class.getResourceAsStream("/dryrun-it.yml")).withGracePeriod(0L).delete();
  }

  @Test
  void create() {
    // Given
    String name = "dryrunit-create";
    ConfigMap configMap = createConfigMap(name);

    // When
    ConfigMap createdConfigMap = client.configMaps().inNamespace(namespace.getMetadata().getName()).dryRun().create(configMap);

    // Then
    assertNotNull(createdConfigMap);
    assertNotNull(createdConfigMap.getMetadata());
    assertNotNull(createdConfigMap.getMetadata().getCreationTimestamp());
    assertNotNull(createdConfigMap.getMetadata().getUid());
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    assertNull(configMapQueriedFromServer);
  }

  @Test
  void createOrReplace() {
    // Given
    String name = "dryrunit-replace";

    // When
    ConfigMap configMap = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    configMap.getMetadata().setLabels(Collections.singletonMap("foo", "bar"));
    ConfigMap replacedConfigMap = client.configMaps().inNamespace(namespace.getMetadata().getName()).dryRun().createOrReplace(configMap);

    // Then
    assertNotNull(replacedConfigMap);
    assertNotNull(replacedConfigMap.getMetadata());
    assertNotNull(replacedConfigMap.getMetadata().getCreationTimestamp());
    assertNotNull(replacedConfigMap.getMetadata().getUid());
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    assertNull(configMapQueriedFromServer.getMetadata().getLabels());
  }

  @Test
  void delete() {
    // Given
    String name = "dryrunit-delete";

    // When
    boolean deletionResult = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).dryRun().delete();

    // Then
    assertTrue(deletionResult);
    ConfigMap configMapFromServer = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    assertNotNull(configMapFromServer);
  }

  @Test
  void resourceCreateOrReplace() {
    // Given
    String name = "dryrunit-resource-create";
    ConfigMap configMap = createConfigMap(name);

    // When
    ConfigMap createdConfigMap = client.resource(configMap).inNamespace(namespace.getMetadata().getName()).dryRun().createOrReplace();

    // Then
    assertNotNull(createdConfigMap);
    assertNotNull(createdConfigMap.getMetadata());
    assertNotNull(createdConfigMap.getMetadata().getCreationTimestamp());
    assertNotNull(createdConfigMap.getMetadata().getUid());
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    assertNull(configMapQueriedFromServer);
  }

  @Test
  void resourceDelete() {
    // Given
    String name = "dryrunit-resource-delete";
    ConfigMap configMap = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();

    // When
    Boolean isDeleted = client.resource(configMap).inNamespace(namespace.getMetadata().getName()).dryRun().delete();

    // Then
    assertTrue(isDeleted);
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    assertNotNull(configMapQueriedFromServer);
  }

  @Test
  void resourceListDelete() {
    // Given
    String name = "dryrunit-resourcelist-delete";
    ConfigMap configMap = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    Service svc = client.services().inNamespace(namespace.getMetadata().getName()).withName(name).get();

    // When
    boolean isDeleted = client.resourceList(configMap, svc).inNamespace(namespace.getMetadata().getName()).dryRun().delete();

    // Then
    assertTrue(isDeleted);
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    Service serviceQueriedFromServer = client.services().inNamespace(namespace.getMetadata().getName()).withName(name).get();
    assertNotNull(configMapQueriedFromServer);
    assertNotNull(serviceQueriedFromServer);
  }

  private ConfigMap createConfigMap(String name) {
    return new ConfigMapBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .addToData("key1", "value1")
      .addToData("key2", "value2")
      .build();
  }

}
