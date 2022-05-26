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
package io.fabric8.crd.generator.inherited;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChildCRDTest {

  @Test
  void testCrd() {
    CustomResourceDefinition d = Serialization.unmarshal(getClass().getClassLoader()
        .getResourceAsStream("META-INF/fabric8/children.acme.com-v1.yml"),
        CustomResourceDefinition.class);
    assertNotNull(d);
    assertEquals("Child", d.getSpec().getNames().getKind());
    assertEquals("children", d.getSpec().getNames().getPlural());
    assertEquals("Namespaced", d.getSpec().getScope());
    assertTrue(d.getSpec().getVersions().stream().anyMatch(v -> v.getSubresources() != null));
  }

}
