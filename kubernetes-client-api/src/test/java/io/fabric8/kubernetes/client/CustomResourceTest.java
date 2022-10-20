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

import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    assertTrue(good.isServed());
    assertTrue(good.isStorage());
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
    assertFalse(custom.isServed());
    assertFalse(custom.isStorage());
  }

  @Test
  void untypedCustomResourceInitShouldWork() {
    final CustomResource cr = new Untyped();
    assertNull(cr.getSpec());
    assertNull(cr.getStatus());
  }

  @Test
  void voidVoidCustomResourceInitShouldWork() {
    final CustomResource cr = new VoidVoid();
    assertNull(cr.getSpec());
    assertNull(cr.getStatus());
  }

  @Test
  void subclassWithOverriddenInitShouldWork() {
    final CRI cri = new CRI();
    assertNull(cri.getSpec());
    assertEquals(7, cri.getStatus());
  }

  @Group("example.com")
  @Version("v1")
  private static class Untyped extends CustomResource {
  }

  @Group("example.com")
  @Version("v1")
  private static class CRI extends CustomResource<String, Integer> {

    @Override
    protected Integer initStatus() {
      return 7;
    }
  }

  @Group("example.com")
  @Version("v1")
  private static class VoidVoid extends CustomResource<Void, Void> {
  }
}
