/*
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
package io.fabric8.crdv2.generator.v1;

import io.fabric8.crdv2.example.customized.Customized;
import io.fabric8.crdv2.example.customized.RawCustomized;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SchemaCustomizerTest {

  @Test
  void applyCustomizer() {
    JSONSchemaProps schema = JsonSchema.from(Customized.class);
    assertEquals("my description", schema.getDescription());
  }

  @Test
  void applyRawCustomizer() {
    JSONSchemaProps schema = JsonSchema.from(RawCustomized.class);
    assertEquals(1, schema.getProperties().size());
    assertEquals("integer", schema.getProperties().get("prop").getType());
  }

}
