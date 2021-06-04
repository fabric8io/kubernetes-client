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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ConfigMapIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ConfigMapIT.class.getResourceAsStream("/configmap-it.yml"));
  }

  @Test
  public void load() {
    ConfigMap aConfigMap = client.configMaps().inNamespace(session.getNamespace()).load(getClass().getResourceAsStream("/test-configmap.yml")).get();
    assertThat(aConfigMap).isNotNull();
    assertEquals("game-config", aConfigMap.getMetadata().getName());
  }

  @Test
  public void get() {
    ConfigMap configMap = client.configMaps().inNamespace(session.getNamespace()).withName("configmap-get").get();
    assertThat(configMap).isNotNull();
  }

  @Test
  public void list() {
    ConfigMapList aConfigMapList = client.configMaps().inNamespace(session.getNamespace()).list();
    assertNotNull(aConfigMapList);
    assertTrue(aConfigMapList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ConfigMap configMap = client.configMaps().inNamespace(session.getNamespace()).withName("configmap-update").edit(c -> new ConfigMapBuilder(c)
                      .addToData("MSSQL", "Microsoft Database").build());

    assertNotNull(configMap);
    assertEquals("Microsoft Database", configMap.getData().get("MSSQL"));
  }

  @Test
  public void delete() {
    assertTrue(client.configMaps().inNamespace(session.getNamespace()).withName("configmap-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ConfigMapIT.class.getResourceAsStream("/configmap-it.yml"));
  }
}
