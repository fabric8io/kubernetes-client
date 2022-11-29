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

import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HasMetadataTest {
  @Test
  void fullResourceNameShouldNotEndWithPeriodForHistoricResources() {
    assertEquals("pods", HasMetadata.getFullResourceName(Pod.class));
    assertEquals("services", HasMetadata.getFullResourceName(Service.class));
  }

  @Test
  void fullResourceNameShouldConcatenatePluralAndGroup() {
    assertEquals("women.fabric8.io", HasMetadata.getFullResourceName(Woman.class));
    assertEquals("overridden.fabric8.io", HasMetadata.getFullResourceName(Over.class));
  }

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
  void finalizerValidationShouldWork() {
    assertFalse(HasMetadata.validateFinalizer(null));
    assertFalse(HasMetadata.validateFinalizer(""));
    assertFalse(HasMetadata.validateFinalizer("/"));
    assertTrue(HasMetadata.validateFinalizer("fabric8.io/finalizer"));
    // other cases are indirectly validated in invalidFinalizersShouldFail
  }

  @Test
  void invalidFinalizersShouldFail() {
    HasMetadata hasMetadata = new Default();
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(null));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(""));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("/"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("-fabric8.io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8.i/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8./finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(
        "this-label-is-too-long-12345678901234567890123456789012345678901234567890qwertyuiopasdfghjkl.io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(
        "this.dns.name.is.way.way.too.long.more.than.255.characters.12345678901234567890.qwertyuiop.asdfghjkl.zxcvbnm.qwertyuiop.adfghjkl.zxcvbnm.mnbvcxz.lkjhgfdsa.poiuytrewq12345678901234567890.qwertyuiop.asdfghjkl.zxcvbnm.qwertyuiop.adfghjkl.zxcvbnm.mnbvcxz.lkjhgfdsa.poiuytrewq.io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer(".io/finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8.io/-finalizer"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata.addFinalizer("fabric8.io/finalizer-"));
    assertThrows(IllegalArgumentException.class, () -> hasMetadata
        .addFinalizer("fabric8.io/finalizerreallyreallywaywaywaytooooooooooooooooooooolooooooooonnnnnnnnnnng"));
  }

  @Test
  void addingNullOwnerReferenceShouldFail() {
    final String name = "defaultName";
    final String kind = "Default";
    final Default target = new Default(name) {
      @Override
      public String getKind() {
        return kind;
      }
    };

    IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
        () -> target.addOwnerReference((OwnerReference) null));
    String msg = iae.getMessage();
    assertTrue(msg.contains("null reference to '" + name + "' " + kind));
    iae = assertThrows(IllegalArgumentException.class, () -> target.addOwnerReference((HasMetadata) null));
    msg = iae.getMessage();
    assertTrue(msg.contains("null owner to '" + name + "' " + kind));
  }

  @Test
  void addingNullOwnerReferenceShouldNotCrashEvenIfTargetDoesNotHaveMetadata() {
    final HasMetadata target = new Empty();

    IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
        () -> target.addOwnerReference((OwnerReference) null));
    String msg = iae.getMessage();
    assertTrue(msg.contains("null reference to unnamed " + target.getKind()));
  }

  @Test
  void addingOwnerReferenceToOwnerWithoutMetadataShouldFail() {
    final String name = "defaultName";
    final String kind = "Default";
    final Default target = new Default(name) {
      @Override
      public String getKind() {
        return kind;
      }
    };

    IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> target.addOwnerReference(new Empty()));
    String msg = iae.getMessage();
    assertTrue(msg.contains("to '" + name + "' " + kind) && msg.contains("owner without metadata"));
  }

  @Test
  void addingOwnerReferenceOnObjectWithoutMetadataShouldCreateTheMetadata() {
    HasMetadata target = new Empty();
    assertNull(target.getMetadata());
    final Owner owner = new Owner();
    target.addOwnerReference(owner);
    assertNotNull(target.getMetadata());
    assertTrue(target.hasOwnerReferenceFor(owner));
  }

  @Test
  void addingReferenceToOwnerWithMissingFieldsShouldFail() {
    HasMetadata hasMetadata = new Default();
    HasMetadata owner = new InvalidOwner();

    IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
        () -> hasMetadata.addOwnerReference(owner));
    final String msg = iae.getMessage();
    assertTrue(
        msg.contains("uid") && msg.contains("apiVersion") && msg.contains("name") && msg.contains(
            "kind"));
  }

  @Test
  void addingAndRemovingOwnerReferenceShouldWork() {
    HasMetadata hasMetadata = new Default();
    HasMetadata owner = new Owner();

    assertEquals(0, hasMetadata.getMetadata().getOwnerReferences().size());
    assertFalse(hasMetadata.hasOwnerReferenceFor(owner));

    OwnerReference ownerReference = hasMetadata.addOwnerReference(owner);
    assertEquals(1, hasMetadata.getMetadata().getOwnerReferences().size());
    assertTrue(hasMetadata.hasOwnerReferenceFor(owner));
    assertTrue(hasMetadata.hasOwnerReferenceFor(Owner.uid));

    final Optional<OwnerReference> retrieved = hasMetadata.getOwnerReferenceFor(owner);
    assertTrue(retrieved.isPresent());
    assertEquals(ownerReference, retrieved.get());
    assertEquals(retrieved, hasMetadata.getOwnerReferenceFor(Owner.uid));

    assertEquals(Owner.uid, ownerReference.getUid());
    assertEquals(Owner.apiVersion, ownerReference.getApiVersion());
    assertEquals(Owner.name, ownerReference.getName());
    assertEquals(Owner.kind, ownerReference.getKind());

    final String uid2 = "uid2";
    final Owner owner2 = new Owner(uid2);
    ownerReference = hasMetadata.addOwnerReference(owner2);
    assertEquals(uid2, ownerReference.getUid());
    assertEquals(2, hasMetadata.getMetadata().getOwnerReferences().size());
    assertTrue(hasMetadata.hasOwnerReferenceFor(owner2));
    assertTrue(hasMetadata.hasOwnerReferenceFor(owner2.getMetadata().getUid()));

    hasMetadata.removeOwnerReference((String) null);
    assertEquals(2, hasMetadata.getMetadata().getOwnerReferences().size());
    hasMetadata.removeOwnerReference((HasMetadata) null);
    assertEquals(2, hasMetadata.getMetadata().getOwnerReferences().size());
    hasMetadata.removeOwnerReference(Owner.uid);
    assertEquals(1, hasMetadata.getMetadata().getOwnerReferences().size());
    assertFalse(hasMetadata.hasOwnerReferenceFor(Owner.uid));
    hasMetadata.removeOwnerReference(owner2);
    assertTrue(hasMetadata.getMetadata().getOwnerReferences().isEmpty());
    assertFalse(hasMetadata.hasOwnerReferenceFor(owner2));
  }

  @Test
  void addingSameOwnerReferenceMultipleTimesShouldAddItOnlyOnce() {
    HasMetadata hasMetadata = new Default();
    HasMetadata owner = new Owner();

    hasMetadata.addOwnerReference(owner);
    hasMetadata.addOwnerReference(owner);
    hasMetadata.addOwnerReference(owner);
    assertEquals(1, hasMetadata.getMetadata().getOwnerReferences().size());
  }

  @Group("fabric8.io")
  @Version("v1")
  private static class Woman implements HasMetadata {

    @Override
    public ObjectMeta getMetadata() {
      return null;
    }

    @Override
    public void setMetadata(ObjectMeta metadata) {
    }

    @Override
    public void setApiVersion(String version) {
    }
  }

  @Group("fabric8.io")
  @Version("v1")
  @Plural("overridden")
  private static class Over implements HasMetadata {

    @Override
    public ObjectMeta getMetadata() {
      return null;
    }

    @Override
    public void setMetadata(ObjectMeta metadata) {
    }

    @Override
    public void setApiVersion(String version) {
    }
  }

  private static class Empty implements HasMetadata {
    private ObjectMeta meta;

    @Override
    public ObjectMeta getMetadata() {
      return meta;
    }

    @Override
    public void setMetadata(ObjectMeta metadata) {
      this.meta = metadata;
    }

    @Override
    public void setApiVersion(String version) {
    }
  }

  private static class Owner extends Default {
    static final String kind = "Owner";
    static final String apiVersion = "group/version";
    static final String uid = "ownerUid";
    static final String name = "ownerName";

    Owner() {
      this(uid);
    }

    Owner(String uid) {
      super(name);
      meta.setUid(uid);
    }

    @Override
    public String getKind() {
      return kind;
    }

    @Override
    public String getApiVersion() {
      return apiVersion;
    }
  }

  private static class InvalidOwner extends Default {

    @Override
    public String getKind() {
      return null;
    }

    @Override
    public String getApiVersion() {
      return "   ";
    }
  }

  private static class Default implements HasMetadata {
    protected final ObjectMeta meta = new ObjectMeta();

    Default() {
    }

    Default(String name) {
      meta.setName(name);
    }

    @Override
    public ObjectMeta getMetadata() {
      return meta;
    }

    @Override
    public void setMetadata(ObjectMeta metadata) {
      throw new RuntimeException("setMetadata shouldn't be called");
    }

    @Override
    public String getKind() {
      throw new RuntimeException("getKind shouldn't be called");
    }

    @Override
    public String getApiVersion() {
      throw new RuntimeException("getApiVersion shouldn't be called");
    }

    @Override
    public void setApiVersion(String version) {
      throw new RuntimeException("setApiVersion shouldn't be called");
    }
  }
}
