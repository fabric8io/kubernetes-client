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

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ConfigMapIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private ConfigMap configMap1, configMap2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    configMap1 = new ConfigMapBuilder()
      .withNewMetadata().withName("configmap1").endMetadata()
      .addToData("1", "one")
      .addToData("2", "two")
      .addToData("3", "three")
      .build();
    configMap2 = new ConfigMapBuilder()
      .withNewMetadata().withName("configmap2").endMetadata()
      .addToData("PostgreSQL", "Free Open Source Enterprise Database")
      .addToData("DB2", "Enterprise Database , It's expensive")
      .addToData("Oracle", "Enterprise Database , It's expensive")
      .addToData("MySQL", "Free Open SourceDatabase")
      .build();
    client.configMaps().inNamespace(currentNamespace).create(configMap1);
    client.configMaps().inNamespace(currentNamespace).create(configMap2);
  }

  @Test
  public void load() {
    ConfigMap aConfigMap = client.configMaps().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-configmap.yml")).get();
    assertThat(aConfigMap).isNotNull();
    assertEquals("game-config", aConfigMap.getMetadata().getName());
  }

  @Test
  public void get() {
    configMap1 = client.configMaps().inNamespace(currentNamespace).withName("configmap1").get();
    assertThat(configMap1).isNotNull();
    configMap2 = client.configMaps().inNamespace(currentNamespace).withName("configmap2").get();
    assertThat(configMap2).isNotNull();
  }

  @Test
  public void list() {
    ConfigMapList aConfigMapList = client.configMaps().inNamespace(currentNamespace).list();
    assertNotNull(aConfigMapList);
    assertEquals(2, aConfigMapList.getItems().size());
  }

  @Test
  public void update() {
    ReadyEntity<ConfigMap> configMap1Ready = new ReadyEntity<>(ConfigMap.class, client, "configmap1", currentNamespace);
    ReadyEntity<ConfigMap> configMap2Ready = new ReadyEntity<>(ConfigMap.class, client, "configmap2", currentNamespace);

    configMap1 = client.configMaps().inNamespace(currentNamespace).withName("configmap1").edit()
      .addToData("4", "four").done();

    configMap2 = client.configMaps().inNamespace(currentNamespace).withName("configmap2").edit()
      .addToData("MSSQL", "Microsoft Database").done();

    await().atMost(30, TimeUnit.SECONDS).until(configMap1Ready);
    await().atMost(30, TimeUnit.SECONDS).until(configMap2Ready);
    assertNotNull(configMap1);
    assertNotNull(configMap2);
    assertEquals("four", configMap1.getData().get("4"));
    assertEquals("Microsoft Database", configMap2.getData().get("MSSQL"));
  }

  @Test
  public void delete() {
    ReadyEntity<ConfigMap> configMap1Ready = new ReadyEntity<>(ConfigMap.class, client, "configmap1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(configMap1Ready);
    assertTrue(client.configMaps().inNamespace(currentNamespace).withName("configmap1").delete());

    ReadyEntity<ConfigMap> configMap2Ready = new ReadyEntity<>(ConfigMap.class, client, "configmap2", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(configMap2Ready);
    assertTrue(client.configMaps().inNamespace(currentNamespace).withName("configmap2").delete());
  }

  @After
  public void cleanup() throws InterruptedException {
    if (client.configMaps().inNamespace(currentNamespace).list().getItems().size()!= 0) {
      client.configMaps().inNamespace(currentNamespace).delete();
    }
    DeleteEntity<ConfigMap> configMapDelete = new DeleteEntity<>(ConfigMap.class, client, "configmap1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(configMapDelete);
  }
}
