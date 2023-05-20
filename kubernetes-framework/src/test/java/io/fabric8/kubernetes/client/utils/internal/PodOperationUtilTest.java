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
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PodOperationUtilTest {
  private PodOperationsImpl podOperations;
  private OperationContext operationContext;

  @BeforeEach
  void setUp() {
    this.podOperations = mock(PodOperationsImpl.class, Mockito.RETURNS_DEEP_STUBS);
    this.operationContext = mock(OperationContext.class, Mockito.RETURNS_DEEP_STUBS);
  }

  @Test
  void testGetFilteredPodsForLogs() {
    // Given
    String controllerUid = "controller-uid-ejofjeofer";
    PodList podList = getMockPodList(controllerUid);

    // When
    List<PodResource> podResourceList = PodOperationUtil.getFilteredPodsForLogs(podOperations, podList, controllerUid);

    // Then
    assertNotNull(podResourceList);
    assertEquals(1, podResourceList.size());
    verify(podOperations, times(1)).withName(any());
  }

  @Test
  void testGetGenericPodOperations() {
    // When
    PodOperationsImpl podOperations = PodOperationUtil.getGenericPodOperations(operationContext,
        new PodOperationContext().withPrettyOutput(false).withReadyWaitTimeout(5).withContainerId("container1"));

    // Then
    assertThat(podOperations).isNotNull();
    assertThat(podOperations.getName()).isNull();
    assertThat(podOperations.getContext().getContainerId()).isEqualTo("container1");
  }

  @Test
  void testWaitUntilReadyBeforeFetchingLogs() {
    // When
    PodOperationUtil.waitUntilReadyOrSucceded(podOperations, 5);
    // Then
    verify(podOperations, times(1)).waitUntilCondition(any(), eq(5L), eq(TimeUnit.SECONDS));
  }

  @Test
  void testGetPodOperationsForController() {
    // Given
    String controllerUid = "some-uid";
    Map<String, String> selectorLabels = Collections.singletonMap("foo", "bar");
    FilterWatchListDeletable<Pod, PodList, PodResource> filterWatchListDeletable = getMockPodFilterOperation(controllerUid);
    when(podOperations.withLabels(any())).thenReturn(filterWatchListDeletable);

    // When
    List<PodResource> podResources = PodOperationUtil.getPodOperationsForController(podOperations, controllerUid,
        selectorLabels);

    // Then
    assertNotNull(podResources);
    assertEquals(1, podResources.size());
  }

  @Test
  void testWatchLogSinglePod() {
    // Given
    PodResource podResource = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);
    ByteArrayOutputStream byteArrayOutputStream = mock(ByteArrayOutputStream.class, Mockito.RETURNS_DEEP_STUBS);

    // When
    LogWatch logWatch = PodOperationUtil.watchLog(createMockPodResourceList(podResource), byteArrayOutputStream);

    // Then
    assertThat(logWatch).isNotNull();
    verify(podResource, times(1)).watchLog(byteArrayOutputStream);
  }

  @Test
  void testWatchLogMultiplePodReplicasPicksFirstPod() {
    // Given
    PodResource p1 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);
    PodResource p2 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);
    ByteArrayOutputStream byteArrayOutputStream = mock(ByteArrayOutputStream.class, Mockito.RETURNS_DEEP_STUBS);

    // When
    LogWatch logWatch = PodOperationUtil.watchLog(createMockPodResourceList(p1, p2), byteArrayOutputStream);

    // Then
    assertThat(logWatch).isNotNull();
    verify(p1, times(1)).watchLog(byteArrayOutputStream);
    verify(p2, times(0)).watchLog(byteArrayOutputStream);
  }

  @Test
  void testWatchLogEmptyPodResourceList() {
    assertThat(PodOperationUtil.watchLog(Collections.emptyList(), null)).isNull();
  }

  @Test
  void testGetLogReaderEmptyPodResourceList() {
    assertThat(PodOperationUtil.getLogReader(Collections.emptyList())).isNull();
  }

  @Test
  void testGetLogReaderMultiplePodReplicasPicksFirstPod() {
    // Given
    PodResource p1 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);
    PodResource p2 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);

    // When
    Reader reader = PodOperationUtil.getLogReader(createMockPodResourceList(p1, p2));

    // Then
    assertThat(reader).isNotNull();
    verify(p1, times(1)).getLogReader();
    verify(p2, times(0)).getLogReader();
  }

  @Test
  void testGetLogInputStreamEmptyPodResourceList() {
    assertThat(PodOperationUtil.getLogInputStream(Collections.emptyList())).isNull();
  }

  @Test
  void testGetLogInputStreamMultiplePodReplicasPicksFirstPod() {
    // Given
    PodResource p1 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);
    PodResource p2 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);

    // When
    InputStream inputStream = PodOperationUtil.getLogInputStream(createMockPodResourceList(p1, p2));

    // Then
    assertThat(inputStream).isNotNull();
    verify(p1, times(1)).getLogInputStream();
    verify(p2, times(0)).getLogInputStream();
  }

  @Test
  void testGetLog() {
    // Given
    PodResource p1 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);
    PodResource p2 = mock(PodResource.class, Mockito.RETURNS_DEEP_STUBS);
    when(p1.getLog(anyBoolean())).thenReturn("p1-log");
    when(p2.getLog(anyBoolean())).thenReturn("p2-log");

    // When
    String result = PodOperationUtil.getLog(createMockPodResourceList(p1, p2), false);

    // Then
    assertThat(result).isNotNull().isEqualTo("p1-logp2-log");
    verify(p1, times(1)).getLog(false);
    verify(p2, times(1)).getLog(false);
  }

  private PodList getMockPodList(String controllerUid) {
    return new PodListBuilder()
        .addToItems(
            new PodBuilder()
                .withNewMetadata()
                .withName("pod1")
                .addNewOwnerReference()
                .withController(true)
                .withUid(controllerUid)
                .endOwnerReference()
                .endMetadata()
                .build())
        .addToItems(new PodBuilder().withNewMetadata().withName("pod2").endMetadata().build())
        .build();
  }

  private FilterWatchListDeletable<Pod, PodList, PodResource> getMockPodFilterOperation(String controllerUid) {
    FilterWatchListDeletable<Pod, PodList, PodResource> result = mock(FilterWatchListDeletable.class);
    Mockito.when(result.list()).then(new Answer<PodList>() {
      @Override
      public PodList answer(InvocationOnMock invocation) throws Throwable {
        return getMockPodList(controllerUid);
      }
    });
    return result;
  }

  @SafeVarargs
  private final List<PodResource> createMockPodResourceList(PodResource... podResources) {
    List<PodResource> podResourceList = new ArrayList<>();
    Collections.addAll(podResourceList, podResources);
    return podResourceList;
  }
}
