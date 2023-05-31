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
package io.fabric8.kubernetes.client.utils.internal;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateOrReplaceHelperTest {

  @Test
  void testCreateOrReplaceShouldCreate() {
    // Given
    AtomicBoolean wasPodCreated = new AtomicBoolean(false);
    UnaryOperator<Pod> createPodTask = p -> {
      wasPodCreated.set(true);
      return getPod();
    };
    CreateOrReplaceHelper<Pod> podCreateOrReplaceHelper = new CreateOrReplaceHelper<>(
        createPodTask,
        p -> getPod(),
        p -> getPod(),
        p -> getPod(), new KubernetesSerialization());

    Pod p = getPod();
    p.getMetadata().setResourceVersion("1");

    // When
    Pod podCreated = podCreateOrReplaceHelper.createOrReplace(p);

    // Then
    assertNotNull(podCreated);
    assertTrue(wasPodCreated.get());
    assertEquals("1", p.getMetadata().getResourceVersion());
  }

  @Test
  void testCreateOrReplaceShouldReplace() {
    // Given
    AtomicBoolean wasPodReplaced = new AtomicBoolean(false);
    UnaryOperator<Pod> createPodTask = p -> {
      throw new KubernetesClientException("Already exist",
          HttpURLConnection.HTTP_CONFLICT, new StatusBuilder().withCode(HttpURLConnection.HTTP_CONFLICT).build());
    };
    UnaryOperator<Pod> replacePodTask = p -> {
      wasPodReplaced.set(true);
      return getPod();
    };
    CreateOrReplaceHelper<Pod> podCreateOrReplaceHelper = new CreateOrReplaceHelper<>(
        createPodTask,
        replacePodTask,
        p -> getPod(),
        p -> getPod(), new KubernetesSerialization());

    // When
    Pod podCreated = podCreateOrReplaceHelper.createOrReplace(getPod());

    // Then
    assertNotNull(podCreated);
    assertTrue(wasPodReplaced.get());
  }

  @Test
  void testCreateOrReplaceShouldRetryOnInternalServerError() {
    // Given
    AtomicBoolean waitedForPod = new AtomicBoolean(false);
    UnaryOperator<Pod> createPodTask = Mockito.mock(UnaryOperator.class, Mockito.RETURNS_DEEP_STUBS);
    UnaryOperator<Pod> reloadTask = Mockito.mock(UnaryOperator.class, Mockito.RETURNS_DEEP_STUBS);
    when(reloadTask.apply(any())).thenReturn(null);
    when(createPodTask.apply(any())).thenThrow(new KubernetesClientException("The POST operation could not be completed at " +
        "this time, please try again",
        HttpURLConnection.HTTP_INTERNAL_ERROR, new StatusBuilder().withCode(HttpURLConnection.HTTP_INTERNAL_ERROR).build()))
        .thenReturn(getPod());
    UnaryOperator<Pod> waitTask = p -> {
      waitedForPod.set(true);
      return getPod();
    };
    CreateOrReplaceHelper<Pod> podCreateOrReplaceHelper = new CreateOrReplaceHelper<>(
        createPodTask,
        p -> getPod(),
        waitTask,
        reloadTask, new KubernetesSerialization());

    // When
    Pod podCreated = podCreateOrReplaceHelper.createOrReplace(getPod());

    // Then
    assertNotNull(podCreated);
    assertTrue(waitedForPod.get());
  }

  @Test
  void testCreateOrReplaceThrowExceptionOnErrorCodeLessThan500() {
    // Given
    UnaryOperator<Pod> createPodTask = p -> {
      throw new KubernetesClientException("The POST operation could not be completed at " +
          "this time, please try again",
          HttpURLConnection.HTTP_BAD_REQUEST, new StatusBuilder().withCode(HttpURLConnection.HTTP_BAD_REQUEST).build());
    };
    CreateOrReplaceHelper<Pod> podCreateOrReplaceHelper = new CreateOrReplaceHelper<>(createPodTask,
        p -> getPod(), p -> getPod(), p -> getPod(), new KubernetesSerialization());
    Pod podToCreate = getPod();

    // When
    assertThrows(KubernetesClientException.class, () -> podCreateOrReplaceHelper.createOrReplace(podToCreate));
  }

  private Pod getPod() {
    return new PodBuilder()
        .withNewMetadata().withName("p1").endMetadata()
        .build();
  }
}
