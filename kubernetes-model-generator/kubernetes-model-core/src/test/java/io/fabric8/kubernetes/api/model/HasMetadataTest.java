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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HasMetadataTest {
  @Test
  void validFinalizersShouldBeAddedAndCanBeRemoved() {
    HasMetadata hasMetadata = new Default();
    final String finalizer = "example.fabric8.io/finalizer";
    assertTrue(hasMetadata.addFinalizer(finalizer));
    assertEquals(hasMetadata.getMetadata().getFinalizers().contains(finalizer), hasMetadata.hasFinalizer(finalizer));
    
    assertTrue(hasMetadata.removeFinalizer(finalizer));
    assertFalse(hasMetadata.hasFinalizer(finalizer));
  }
  
  @Test
  void shouldNotAddFinalizerToMarkedForDeletion() {
    HasMetadata hasMetadata = new Default() {
      @Override
      public boolean isMarkedForDeletion() {
        return true;
      }
    };
    
    assertFalse(hasMetadata.addFinalizer("example.fabric8.io/finalizer"));
  }
  
  @Test
  void invalidFinalizersShouldFail() {
    HasMetadata hasMetadata = new Default();
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(null));
    assertFalse(hasMetadata.isFinalizerValid(null));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(""));
    assertFalse(hasMetadata.isFinalizerValid(""));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("/"));
    assertFalse(hasMetadata.isFinalizerValid("/"));
    assertTrue(hasMetadata.isFinalizerValid("fabric8.io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("-fabric8.io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8.i/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8./finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("this-label-is-too-long-12345678901234567890123456789012345678901234567890qwertyuiopasdfghjkl.io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("this.dns.name.is.way.way.too.long.more.than.255.characters.12345678901234567890.qwertyuiop.asdfghjkl.zxcvbnm.qwertyuiop.adfghjkl.zxcvbnm.mnbvcxz.lkjhgfdsa.poiuytrewq12345678901234567890.qwertyuiop.asdfghjkl.zxcvbnm.qwertyuiop.adfghjkl.zxcvbnm.mnbvcxz.lkjhgfdsa.poiuytrewq.io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(".io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8.io/-finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8.io/finalizer-"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8.io/finalizerreallyreallywaywaywaytooooooooooooooooooooolooooooooonnnnnnnnnnng"));
  }
  
  private static class Default implements HasMetadata {
    private final ObjectMeta meta = new ObjectMeta();
    
    @Override
    public ObjectMeta getMetadata() {
      return meta;
    }
    
    @Override
    public void setMetadata(ObjectMeta metadata) {
      throw new RuntimeException("shouldn't be called");
    }
    
    @Override
    public String getKind() {
      throw new RuntimeException("shouldn't be called");
    }
    
    @Override
    public String getApiVersion() {
      throw new RuntimeException("shouldn't be called");
    }
    
    @Override
    public void setApiVersion(String version) {
      throw new RuntimeException("shouldn't be called");
    }
  }
}
