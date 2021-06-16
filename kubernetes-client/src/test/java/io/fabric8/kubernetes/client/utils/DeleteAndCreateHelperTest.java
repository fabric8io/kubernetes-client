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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeleteAndCreateHelperTest {
  @Test
  void testDeleteAndCreate() {
    // Given
    AtomicBoolean wasPodDeleted = new AtomicBoolean(false);
    Function<Pod, Boolean> deletePodTask = p -> {
      wasPodDeleted.set(true);
      return true;
    };
    UnaryOperator<Pod> createPodTask = Mockito.mock(UnaryOperator.class, Mockito.RETURNS_DEEP_STUBS);
    when(createPodTask.apply(any()))
      .thenReturn(getPod());
    DeleteAndCreateHelper<Pod> podDeleteAndCreateHelper = new DeleteAndCreateHelper<>(
      createPodTask,
      deletePodTask,
      p -> true
    );

    // When
    Pod podCreated = podDeleteAndCreateHelper.deleteAndCreate(getPod());

    // Then
    assertNotNull(podCreated);
    assertTrue(wasPodDeleted.get());
  }

  @Test
  void testDeleteAndCreateWhenDeletionFailed() {
    // Given
    AtomicBoolean wasPodDeleted = new AtomicBoolean(false);
    Function<Pod, Boolean> deletePodTask = p -> {
      wasPodDeleted.set(true);
      return false;
    };
    UnaryOperator<Pod> createPodTask = Mockito.mock(UnaryOperator.class, Mockito.RETURNS_DEEP_STUBS);
    when(createPodTask.apply(any())).thenAnswer(invocation -> invocation.getArgument(0));

    DeleteAndCreateHelper<Pod> podDeleteAndCreateHelper = new DeleteAndCreateHelper<>(
      createPodTask,
      deletePodTask,
      p -> {
        throw new RuntimeException("should not be called because creation will succeed first");
      }
    );

    // When
    Pod podToDeleteAndCreate = getPod();
    Pod result = podDeleteAndCreateHelper.deleteAndCreate(podToDeleteAndCreate);

    // Then
    assertEquals(podToDeleteAndCreate, result);
    verify(createPodTask).apply(podToDeleteAndCreate);
  }

  @Test
  void testThrowExceptionOnConflictAfterNoDelete() {
    // Given
    AtomicBoolean wasPodDeleted = new AtomicBoolean(false);
    Function<Pod, Boolean> deletePodTask = p -> {
      wasPodDeleted.set(true);
      return false;
    };

    UnaryOperator<Pod> createPodTask = Mockito.mock(UnaryOperator.class, Mockito.RETURNS_DEEP_STUBS);
    when(createPodTask.apply(any())).thenThrow(new KubernetesClientException("The POST operation could not be completed at " +
      "this time, please try again",
      HttpURLConnection.HTTP_CONFLICT, new StatusBuilder().withCode(HttpURLConnection.HTTP_CONFLICT).build()));
    DeleteAndCreateHelper<Pod> podDeleteAndCreateHelper = new DeleteAndCreateHelper<>(
      createPodTask,
      deletePodTask,
      p -> {
        throw new RuntimeException("should not be called because creation will succeed first");
      }
    );

    // When
    Pod podToDeleteAndCreate = getPod();
    assertThrows(KubernetesClientException.class,() -> podDeleteAndCreateHelper.deleteAndCreate(podToDeleteAndCreate));
  }

  @Test
  void testDeleteAndCreateWhenDeletionSucceedsButNotFinishedInTime() {
    // Given
    UnaryOperator<Pod> createPodTask = Mockito.mock(UnaryOperator.class, Mockito.RETURNS_DEEP_STUBS);
    when(createPodTask.apply(any())).thenThrow(new KubernetesClientException("The POST operation could not be completed at " +
      "this time, please try again",
      HttpURLConnection.HTTP_CONFLICT, new StatusBuilder().withCode(HttpURLConnection.HTTP_CONFLICT).build()));
    DeleteAndCreateHelper<Pod> podDeleteAndCreateHelper = new DeleteAndCreateHelper<>(
      createPodTask,
      p -> true, // deletion succeeds
      p -> false // but doesn't finish in time
    );

    // When
    Pod podToDeleteAndCreate = getPod();
    assertThrows(KubernetesClientException.class,() -> podDeleteAndCreateHelper.deleteAndCreate(podToDeleteAndCreate));
  }

  @Test
  void testDeleteAndCreateAfterWaitingForItemToBeDeleted() {
    // Given
    AtomicBoolean wasPodDeleted = new AtomicBoolean(false);
    Function<Pod, Boolean> deletePodTask = p -> {
      wasPodDeleted.set(true);
      return true;
    };

    AtomicBoolean awaitedDeletion = new AtomicBoolean(false);
    Function<Pod, Boolean> awaitDeletionTask = p -> {
      awaitedDeletion.set(true);
      return true;
    };

    UnaryOperator<Pod> createPodTask = Mockito.mock(UnaryOperator.class, Mockito.RETURNS_DEEP_STUBS);
    when(createPodTask.apply(any()))
      .thenThrow(new KubernetesClientException("The POST operation could not be completed at " +
        "this time, please try again",
        HttpURLConnection.HTTP_CONFLICT, new StatusBuilder().withCode(HttpURLConnection.HTTP_CONFLICT).build()))
      .thenReturn(getPod());

    DeleteAndCreateHelper<Pod> podDeleteAndCreateHelper = new DeleteAndCreateHelper<>(
      createPodTask,
      deletePodTask,
      awaitDeletionTask
    );

    // When
    Pod podCreated = podDeleteAndCreateHelper.deleteAndCreate(getPod());

    // Then
    assertNotNull(podCreated);
    assertTrue(wasPodDeleted.get());
    assertTrue(awaitedDeletion.get());
  }

  private Pod getPod() {
    return new PodBuilder()
      .withNewMetadata().withName("p1").endMetadata()
      .build();
  }
}
