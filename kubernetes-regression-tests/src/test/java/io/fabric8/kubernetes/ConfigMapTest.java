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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConfigMapTest {
  public static KubernetesClient client;

  public static String currentNamespace;

  @BeforeClass
  public static void init() {
    client = new DefaultKubernetesClient();
    currentNamespace = "rt-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    Namespace aNamespace = new NamespaceBuilder().withNewMetadata().withName(currentNamespace).and().build();
    client.namespaces().create(aNamespace);
  }

  @AfterClass
  public static void cleanup() {
    client.namespaces().withName(currentNamespace).delete();
    client.close();
  }

  @Test
  public void testLoad() {
    ConfigMap aConfigMap = client.configMaps().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-configmap.yml")).get();
    assertThat(aConfigMap).isNotNull();
    assertEquals("game-config", aConfigMap.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    ConfigMap configMap1 = new ConfigMapBuilder()
      .withNewMetadata().withName("configmap1").endMetadata()
      .addToData("1", "one")
      .addToData("2", "two")
      .addToData("3", "three")
      .build();
    ConfigMap configMap2 = new ConfigMapBuilder()
      .withNewMetadata().withName("configmap2").endMetadata()
      .addToData("PostgreSQL", "Free Open Source Enterprise Database")
      .addToData("DB2", "Enterprise Database , It's expensive")
      .addToData("Oracle", "Enterprise Database , It's expensive")
      .addToData("MySQL", "Free Open SourceDatabase")
      .build();

    client.configMaps().inNamespace(currentNamespace).create(configMap1);
    client.configMaps().inNamespace(currentNamespace).create(configMap2);

    ConfigMapList aConfigMapList = client.configMaps().inNamespace(currentNamespace).list();
    assertNotNull(aConfigMapList);
    assertEquals(2, aConfigMapList.getItems().size());

    configMap1 = client.configMaps().inNamespace(currentNamespace).withName("configmap1").edit()
      .addToData("4", "four").done();
    configMap2 = client.configMaps().inNamespace(currentNamespace).withName("configmap2").edit()
      .addToData("MSSQL", "Microsoft Database").done();
    assertNotNull(configMap1);
    assertNotNull(configMap2);
    assertEquals("four", configMap1.getData().get("4"));
    assertEquals("Microsoft Database", configMap2.getData().get("MSSQL"));

    boolean bDeleted = client.configMaps().inNamespace(currentNamespace).withName("configmap1").delete();
    assertTrue(bDeleted);
  }

}
