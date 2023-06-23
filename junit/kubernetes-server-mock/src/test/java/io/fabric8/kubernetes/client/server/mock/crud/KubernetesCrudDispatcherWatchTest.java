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
package io.fabric8.kubernetes.client.server.mock.crud;

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.server.mock.crud.crd.Owl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesCrudDispatcherWatchTest extends KubernetesCrudDispatcherTestBase {

  @Test
  @DisplayName("patch, custom resource watched, watch receives event")
  void patchCrIgnoreStatusChanges() throws InterruptedException {
    // Given
    client.apiextensions().v1().customResourceDefinitions().resource(Owl.toCrd()).create();
    final Owl owl = new Owl();
    owl.setMetadata(new ObjectMetaBuilder().withName("lincoln-march").build());
    owl.getSpec().setSpecies("Barn owl");
    client.resources(Owl.class).resource(owl).create();

    AtomicBoolean owlAdded = new AtomicBoolean(false);
    AtomicReference<Owl> modifiedOwl = new AtomicReference<>();
    AtomicReference<WatcherException> watchException = new AtomicReference<>();
    CountDownLatch modificationLatch = new CountDownLatch(1);

    client.resources(Owl.class).resource(owl).watch(new Watcher<Owl>() {
      @Override
      public void eventReceived(Action action, Owl resource) {
        switch (action) {
          case ADDED:
            owlAdded.set(true);
            break;
          case MODIFIED:
            modifiedOwl.set(resource);
            modificationLatch.countDown();
            break;
          default:
            break;
        }
      }

      @Override
      public void onClose(WatcherException cause) {
        watchException.set(cause);
      }
    });

    owl.getSpec().setSpecies("Snowy owl");
    owl.getStatus().setNotes("updated");

    // When
    client.resources(Owl.class).withName("lincoln-march")
        .patch(PatchContext.of(PatchType.JSON), owl);

    // Then
    modificationLatch.await(10, TimeUnit.SECONDS);

    assertThat(watchException.get())
        .isNull();
    assertThat(owlAdded.get())
        .isTrue();
    assertThat(modifiedOwl.get())
        .isNotNull()
        .hasFieldOrPropertyWithValue("spec.species", "Snowy owl")
        .hasFieldOrPropertyWithValue("status.notes", null);
    /**
     * Reads: 2 for watch (get + async stream for ADDED event), fetch for patch
     * Writes: create CRD, create CR, patch
     */
    assertLocked(3, 3);
  }
}
