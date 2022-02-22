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

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class DryRunIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion =
    new AssumingK8sVersionAtLeast("1", "13");

  private String currentNamespace;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(CronJobIT.class.getResourceAsStream("/dryrun-it.yml"));
  }

  @Before
  public void before() {
    currentNamespace = ClusterEntity.getArquillianNamespace();
  }

  @Test
  public void create() {
    // Given
    String name = "dryrunit-create";
    ConfigMap configMap = createConfigMap(name);

    // When
    ConfigMap createdConfigMap = client.configMaps().inNamespace(currentNamespace).dryRun().create(configMap);

    // Then
    assertNotNull(createdConfigMap);
    assertNotNull(createdConfigMap.getMetadata());
    assertNotNull(createdConfigMap.getMetadata().getCreationTimestamp());
    assertNotNull(createdConfigMap.getMetadata().getUid());
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    assertNull(configMapQueriedFromServer);
  }

  @Test
  public void createOrReplace() {
    // Given
    String name = "dryrunit-replace";

    // When
    ConfigMap configMap = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    configMap.getMetadata().setLabels(Collections.singletonMap("foo", "bar"));
    ConfigMap replacedConfigMap = client.configMaps().inNamespace(currentNamespace).dryRun().createOrReplace(configMap);

    // Then
    assertNotNull(replacedConfigMap);
    assertNotNull(replacedConfigMap.getMetadata());
    assertNotNull(replacedConfigMap.getMetadata().getCreationTimestamp());
    assertNotNull(replacedConfigMap.getMetadata().getUid());
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    assertNull(configMapQueriedFromServer.getMetadata().getLabels());
  }

  @Test
  public void delete() {
    // Given
    String name = "dryrunit-delete";

    // When
    boolean deletionResult = client.configMaps().inNamespace(currentNamespace).withName(name).dryRun().delete();

    // Then
    assertTrue(deletionResult);
    ConfigMap configMapFromServer = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    assertNotNull(configMapFromServer);
  }

  @Test
  public void resourceCreateOrReplace() {
    // Given
    String name = "dryrunit-resource-create";
    ConfigMap configMap = createConfigMap(name);

    // When
    ConfigMap createdConfigMap = client.resource(configMap).inNamespace(currentNamespace).dryRun().createOrReplace();

    // Then
    assertNotNull(createdConfigMap);
    assertNotNull(createdConfigMap.getMetadata());
    assertNotNull(createdConfigMap.getMetadata().getCreationTimestamp());
    assertNotNull(createdConfigMap.getMetadata().getUid());
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    assertNull(configMapQueriedFromServer);
  }

  @Test
  public void resourceDelete() {
    // Given
    String name = "dryrunit-resource-delete";
    ConfigMap configMap = client.configMaps().inNamespace(currentNamespace).withName(name).get();

    // When
    Boolean isDeleted = client.resource(configMap).inNamespace(currentNamespace).dryRun().delete();

    // Then
    assertTrue(isDeleted);
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    assertNotNull(configMapQueriedFromServer);
  }

  @Test
  public void resourceListDelete() {
    // Given
    String name = "dryrunit-resourcelist-delete";
    ConfigMap configMap = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    Service svc = client.services().inNamespace(currentNamespace).withName(name).get();

    // When
    boolean isDeleted = client.resourceList(configMap, svc).inNamespace(currentNamespace).dryRun().delete();

    // Then
    assertTrue(isDeleted);
    ConfigMap configMapQueriedFromServer = client.configMaps().inNamespace(currentNamespace).withName(name).get();
    Service serviceQueriedFromServer = client.services().inNamespace(currentNamespace).withName(name).get();
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

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(CronJobIT.class.getResourceAsStream("/dryrun-it.yml"));
  }
}
