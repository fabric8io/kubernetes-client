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
package io.fabric8.openshift.client.dsl.base;

import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.openshift.api.model.Template;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUnmarshal {

  @Test
  void testUnmarshalJSONTemplate() {
    Template t = Serialization.unmarshal(getClass().getResourceAsStream("/test-template.json"), Template.class);
    assertEquals("eap6-basic-sti", t.getMetadata().getName());
  }

  @Test
  void testUnmarshalYAMLTemplate() {
    Template t = Serialization.unmarshal(getClass().getResourceAsStream("/test-template.yml"), Template.class);
    assertEquals("eap6-basic-sti", t.getMetadata().getName());
  }

}
