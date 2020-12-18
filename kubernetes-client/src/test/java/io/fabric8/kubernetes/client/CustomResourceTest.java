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
package io.fabric8.kubernetes.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomResourceTest {
  private static class MissingApiVersion extends CustomResource {
  }
  
  @Test
  void missingGroupAndVersionShouldFail() {
    assertThrows(IllegalArgumentException.class, MissingApiVersion::new);
  }
  
  @Test
  void valuesShouldProperlyBeComputedFromDefaultsAndAnnotations() {
    final Good good = new Good();
    assertEquals("Good", good.getKind());
    assertEquals("goods", good.getPlural());
    assertEquals("good", good.getSingular());
    assertEquals(Good.GROUP + "/" + Good.VERSION, good.getApiVersion());
    assertEquals(good.getPlural() + "." + Good.GROUP, good.getCRDName());
    assertEquals(Good.VERSION, good.getVersion());
    assertEquals(Good.GROUP, good.getGroup());
  }
  
  @Test
  @DisplayName("fully annotated custom resource should use annotation values instead of defaults")
  void customCRShouldWork() {
    final Custom custom = new Custom();
    assertEquals(Custom.KIND, custom.getKind());
    assertEquals(Custom.SINGULAR, custom.getSingular());
    assertEquals(Custom.PLURAL, custom.getPlural());
    assertEquals(Custom.GROUP + "/" + Custom.VERSION, custom.getApiVersion());
    assertEquals(custom.getPlural() + "." + Custom.GROUP, custom.getCRDName());
    assertEquals(Custom.VERSION, custom.getVersion());
    assertEquals(Custom.GROUP, custom.getGroup());
  }
}
