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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class ConfigMapTest {

  KubernetesMockServer server;
  KubernetesClient client;
  
  @Test
  void testLiteralConfigMap() throws InterruptedException {
    HashMap<String, String> data = new HashMap<>();
    data.put("foo", "bar");
    data.put("cheese", "gouda");

    server.expect().withPath("/api/v1/namespaces/test/configmaps").andReturn(200,
      new ConfigMapBuilder()
        .withNewMetadata()
          .withName("cfg1")
        .endMetadata()
        .addToData(data)
        .build())
      .once();

    ConfigMapList cfgList = client.configMaps().list();
    assertNotNull(cfgList);
    assertEquals(1, cfgList.getAdditionalProperties().size());
    Map<String, String> keys = (Map<String, String>) cfgList.getAdditionalProperties().get("data");
    assertEquals("gouda",keys.get("cheese"));
    assertEquals("bar",keys.get("foo"));
  }

  @Test
  void testFromResourceWithFileConfigMap() throws InterruptedException {
    ConfigMap configMap = client.configMaps().load(getClass().getResourceAsStream("/test-application-properties-config-map.yml")).get();
    assertEquals("cfg1", configMap.getMetadata().getName());

    Map<String, String> data = (Map<String, String>) configMap.getData();
    String result = data.get("application.properties");
    String[] p1 = result.split("\n");
    Map<String,String> keys = new HashMap<>();
    for (int i = 0; i < p1.length; i += 1) {
      String[] p2 = p1[i].split(": ");
      keys.put(p2[0],p2[1]);
    }
    assertEquals("gouda",keys.get("cheese"));
    assertEquals("bar",keys.get("foo"));
  }

  @Test
  void testFromResourceConfigMap() throws InterruptedException {
    ConfigMap configMap = client.configMaps().load(getClass().getResourceAsStream("/test-config-map.yml")).get();
    assertEquals("cfg1", configMap.getMetadata().getName());

    Map<String, String> keys = (Map<String, String>) configMap.getData();
    assertEquals("gouda",keys.get("cheese"));
    assertEquals("bar",keys.get("foo"));
  }

}
