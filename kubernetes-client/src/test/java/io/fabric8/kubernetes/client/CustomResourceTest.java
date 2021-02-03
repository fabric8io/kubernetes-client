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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
  void subclassInitShouldWork() {
    final CRC cr = new CRC();
    assertEquals("", cr.getSpec());
    assertEquals(new Foo(), cr.getStatus());
  }
  
  @Test
  void subclassWithOverriddenInitShouldWork() {
    final CRI cri = new CRI();
    assertEquals("", cri.getSpec());
    assertEquals(7, cri.getStatus());
  }
  
  @Test
  void subclassWithVoidStatusShouldWork() {
    final CRV crv = new CRV();
    assertEquals("", crv.getSpec());
    assertNull(crv.getStatus());
  }
  
  @Test
  void deeperSubclassShouldWork() {
    final CRGG cr = new CRGG();
    assertEquals("", cr.getSpec());
    assertEquals(new Foo(), cr.getStatus());
  }
  
  @Test
  void implicitConstructorShouldWork() {
    final CRImplicit cr = new CRImplicit();
    assertEquals(new Bar(), cr.getSpec());
    assertEquals("", cr.getStatus());
  }
  
  @Test
  void interfaceTypeShouldFail() {
    final IllegalArgumentException exception = assertThrows(
      IllegalArgumentException.class, CRInterface::new);
    assertTrue(exception.getMessage().contains(KubernetesResource.class.getName()));
  }
  
  private static class Foo {
    public Foo() {
    }
    
    @Override
    public boolean equals(Object obj) {
      return obj instanceof Foo;
    }
  }
  
  private static class Bar {
    @Override
    public boolean equals(Object obj) {
      return obj instanceof Bar;
    }
  }
  
  @Group("example.com")
  @Version("v1")
  private static class Untyped extends CustomResource{}
  
  @Group("example.com")
  @Version("v1")
  private static class CRV extends CustomResource<String, Void> {
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
  private static class CRC extends CustomResource<String, Foo> {
  }
  
  @Group("example.com")
  @Version("v1")
  private static class CRG extends CRC {}
  
  @Group("example.com")
  @Version("v1")
  private static class CRGG extends CRG {}
  
  @Group("example.com")
  @Version("v1")
  private static class CRImplicit extends CustomResource<Bar, String> {}
  
  @Group("example.com")
  @Version("v1")
  private static class CRInterface extends CustomResource<String, KubernetesResource> {}
}
