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
package io.fabric8.crd.generator.schemaswaps;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchemaSwapCRDTest {

  @Test
  void testCrd() {
    CustomResourceDefinition d = Serialization.unmarshal(getClass().getClassLoader()
        .getResourceAsStream("META-INF/fabric8/multipleschemaswaps.acme.com-v1.yml"),
        CustomResourceDefinition.class);
    assertNotNull(d);

    CustomResourceDefinitionVersion v1 = d.getSpec().getVersions().get(0);
    assertNotNull(v1);
    assertEquals("v1", v1.getName());
    Map<String, JSONSchemaProps> spec = v1.getSchema().getOpenAPIV3Schema().getProperties().get("spec").getProperties();
    assertNotNull(spec);

    // 'first' is replaced by SchemaSwap from int to string
    JSONSchemaProps first = spec.get("first");
    Map<String, JSONSchemaProps> firstProps = first.getProperties();
    assertNotNull(firstProps);
    JSONSchemaProps firstProperty = firstProps.get("shouldBeString");
    assertEquals("string", firstProperty.getType());

    // 'second' is replaced by the same SchemaSwap that is applied multiple times
    JSONSchemaProps second = spec.get("second");
    Map<String, JSONSchemaProps> secondProps = second.getProperties();
    assertNotNull(secondProps);
    JSONSchemaProps secondProperty = secondProps.get("shouldBeString");
    assertEquals("string", secondProperty.getType());

    // 'third' is replaced by another SchemaSwap
    JSONSchemaProps third = spec.get("third");
    Map<String, JSONSchemaProps> thirdProps = third.getProperties();
    assertNotNull(thirdProps);
    JSONSchemaProps thirdProperty = thirdProps.get("shouldBeInt");
    assertEquals("integer", thirdProperty.getType());

    // 'fourth' is replaced by another SchemaSwap and its property deleted
    JSONSchemaProps fourth = spec.get("fourth");
    Map<String, JSONSchemaProps> fourthProps = fourth.getProperties();
    assertNotNull(fourthProps);
    assertTrue(fourthProps.isEmpty());
  }

}
