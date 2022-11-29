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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigMapTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void configMapTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-configMap.json");

    // when
    final ConfigMap configMap = mapper.readValue(originalJson, ConfigMap.class);
    final String serializedJson = mapper.writeValueAsString(configMap);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  public void configMapBuilderTest() {

    ConfigMap configMap = new io.fabric8.kubernetes.api.model.ConfigMapBuilder()
        .withNewMetadata()
        .withName("game-config")
        .endMetadata()
        .withData(
            new HashMap<String, String>() {
              {
                put("game.properties", "enemies=aliens\nlives=3\nsecret.code.lives=30");
                put("ui.properties", "color.good=purple\ncolor.bad=yellow\n");
                put("special.how", "test1");
                put("special.type", "test2");
                put("example.property.file", "property.1=value-1\nproperty.2=value-2\nproperty.3=value-3");
              }
            })
        .build();

    assertNotNull(configMap);
    assertEquals("game-config", configMap.getMetadata().getName());
    assertEquals(5, configMap.getData().size());
    assertEquals("enemies=aliens\nlives=3\nsecret.code.lives=30", configMap.getData().get("game.properties"));
    assertEquals("color.good=purple\ncolor.bad=yellow\n", configMap.getData().get("ui.properties"));
    assertEquals("test1", configMap.getData().get("special.how"));
    assertEquals("test2", configMap.getData().get("special.type"));
    assertEquals("property.1=value-1\nproperty.2=value-2\nproperty.3=value-3",
        configMap.getData().get("example.property.file"));

  }
}
