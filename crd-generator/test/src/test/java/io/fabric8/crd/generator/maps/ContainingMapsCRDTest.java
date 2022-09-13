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
package io.fabric8.crd.generator.maps;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContainingMapsCRDTest {

  @Test
  void testCrd() {
    CustomResourceDefinition d = Serialization.unmarshal(getClass().getClassLoader()
        .getResourceAsStream("META-INF/fabric8/containingmaps.map.fabric8.io-v1.yml"),
        CustomResourceDefinition.class);
    assertNotNull(d);

    CustomResourceDefinitionVersion v1 = d.getSpec().getVersions().get(0);
    assertNotNull(v1);
    assertEquals("v1", v1.getName());
    Map<String, JSONSchemaProps> spec = v1.getSchema().getOpenAPIV3Schema().getProperties().get("spec").getProperties();
    assertNotNull(spec);

    final Map<String, JSONSchemaProps> specProps = v1.getSchema().getOpenAPIV3Schema()
        .getProperties().get("spec").getProperties();

    assertEquals(7, specProps.size());

    for (int i = 1; i <= 7; i++) {
      String name = "stringToIntMultiMap" + i;
      JSONSchemaProps schema = checkMapProp(specProps, name, "array");
      assertEquals("integer", schema.getItems().getSchema().getType(), name + "'s array item type should be integer");
    }
  }

  private JSONSchemaProps checkMapProp(Map<String, JSONSchemaProps> specProps, String name, String valueType) {
    final JSONSchemaProps props = specProps.get(name);
    assertNotNull(props, name + " should be contained in spec");
    assertEquals("object", props.getType(), name + "'s type should be object");
    assertEquals(valueType, props.getAdditionalProperties().getSchema().getType(),
        name + "'s value type should be " + valueType);
    return props.getAdditionalProperties().getSchema();
  }
}
