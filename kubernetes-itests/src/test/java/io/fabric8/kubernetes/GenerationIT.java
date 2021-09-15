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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class GenerationIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testCreatedObjectHasGeneration() {
    ConfigMap configMap = new ConfigMapBuilder()
      .withNewMetadata().withName(getTestResourcePrefix() + "-configmap").endMetadata()
      .build();

    assertNull(configMap.getMetadata().getGeneration());
    configMap = client.configMaps().inNamespace(session.getNamespace()).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);
  }

  @Test
  public void testUpdatedSpecIncrementsGeneration() {
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withName(getTestResourcePrefix() + "-configmap").endMetadata()
        .build();

    configMap = client.configMaps().inNamespace(session.getNamespace()).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);

    Map<String, String> configMapData = new HashMap<>();
    configMapData.put("key", "value");
    configMap.setData(configMapData);

    configMap = client.configMaps().inNamespace(session.getNamespace()).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 2L);
  }

  @Test
  public void testUpdatingMetadataDoesNotIncrementGeneration() {
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withName(getTestResourcePrefix() + "-configmap").endMetadata()
        .build();

    configMap = client.configMaps().inNamespace(session.getNamespace()).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);

    configMap.getMetadata().getAnnotations().put("new-annotation", "new-value");

    configMap = client.configMaps().inNamespace(session.getNamespace()).createOrReplace(configMap);
    assertEquals(configMap.getMetadata().getGeneration().longValue(), 1L);
  }

  private String getTestResourcePrefix() {
    return getClass().getSimpleName().toLowerCase();
  }

  @After
  public void cleanup() {
    client.configMaps().inNamespace(session.getNamespace()).withName(getTestResourcePrefix() + "-configmap").delete();
  }

}
