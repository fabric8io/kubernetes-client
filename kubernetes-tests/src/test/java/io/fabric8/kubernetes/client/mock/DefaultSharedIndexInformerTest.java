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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListMetaBuilder;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.WatchEventBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingBuilder;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.mock.crd.Animal;
import io.fabric8.kubernetes.client.mock.crd.AnimalSpec;
import io.fabric8.kubernetes.client.mock.crd.CronTab;
import io.fabric8.kubernetes.client.mock.crd.CronTabSpec;
import io.fabric8.kubernetes.client.mock.crd.PodSet;
import io.fabric8.kubernetes.client.mock.crd.PodSetSpec;
import io.fabric8.kubernetes.client.mock.crd.Star;
import io.fabric8.kubernetes.client.mock.crd.StarSpec;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class DefaultSharedIndexInformerTest {

  KubernetesMockServer server;

  static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
      .withMessage(
          "410: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
      .build();
  static final WatchEvent outdatedEvent = new WatchEventBuilder().withStatusObject(outdatedStatus).build();
  static final Long WATCH_EVENT_EMIT_TIME = 1L;
  static final Long OUTDATED_WATCH_EVENT_EMIT_TIME = 1L;
  static final long RESYNC_PERIOD = 5L;
  static final int LATCH_AWAIT_PERIOD_IN_SECONDS = 10;
  private static final CustomResourceDefinitionContext animalContext = new CustomResourceDefinitionContext.Builder()
      .withGroup("jungle.example.com")
      .withVersion("v1")
      .withPlural("animals")
      .withKind("Animal")
      .withScope("Namespaced")
      .build();
  private KubernetesClient client;
  private SharedInformerFactory factory;

  @BeforeEach
  void setup() {
    factory = client.informers();
  }

  @AfterEach
  void tearDown() {
    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("Pod Informer should watch in test(as specified in OperationContext)")
  void testNamespacedPodInformer() throws InterruptedException {
    // Given
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/namespaces/test/pods")
        .andReturn(200, getList(startResourceVersion, Pod.class)).once();
    server.expect()
        .withPath(
            "/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(
            new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(),
            "ADDED"))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.inNamespace("test").sharedIndexInformerFor(Pod.class, RESYNC_PERIOD);
    CountDownLatch foundExistingPod = new CountDownLatch(1);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
            if (obj.getMetadata().getName().equalsIgnoreCase("pod1")) {
              foundExistingPod.countDown();
            }
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });
    factory.startAllRegisteredInformers();
    foundExistingPod.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0L, foundExistingPod.getCount());
    await().atMost(1, TimeUnit.SECONDS)
        .until(() -> podInformer.lastSyncResourceVersion().equals(endResourceVersion));
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());
  }

  @Test
  void testInformerWithNamespaceAndNameConfigured() throws InterruptedException {
    // Given
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/namespaces/test/pods?fieldSelector=" + Utils.toUrlEncoded("metadata.name=pod1"))
        .andReturn(200, getList(startResourceVersion, Pod.class)).once();
    server.expect()
        .withPath("/api/v1/namespaces/test/pods?fieldSelector=" + Utils.toUrlEncoded("metadata.name=pod1") + "&resourceVersion="
            + startResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(
            new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(),
            "ADDED"))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.inNamespace("test").withName("pod1").sharedIndexInformerFor(Pod.class,
        RESYNC_PERIOD);
    CountDownLatch foundExistingPod = new CountDownLatch(1);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
            if (obj.getMetadata().getName().equalsIgnoreCase("pod1")) {
              foundExistingPod.countDown();
            }
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });
    factory.startAllRegisteredInformers();
    foundExistingPod.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0L, foundExistingPod.getCount());
    await().atMost(1, TimeUnit.SECONDS)
        .until(() -> podInformer.lastSyncResourceVersion().equals(endResourceVersion));
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());
  }

  @Test
  @DisplayName("Pod Informer should watch in all namespaces")
  void testAllNamespacedInformer() throws InterruptedException {
    // When
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/pods")
        .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata()
            .withItems(Collections.emptyList()).build())
        .once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
            .withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, RESYNC_PERIOD);
    CountDownLatch foundExistingPod = new CountDownLatch(1);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
            if (obj.getMetadata().getName().equalsIgnoreCase("pod1")
                && obj.getMetadata().getNamespace().equalsIgnoreCase("test")) {
              foundExistingPod.countDown();
            }
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });
    factory.startAllRegisteredInformers();
    foundExistingPod.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingPod.getCount());
    await().atMost(1, TimeUnit.SECONDS)
        .until(() -> podInformer.lastSyncResourceVersion().equals(endResourceVersion));
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());
  }

  @Test
  @DisplayName("Pod Informer should reconnect on 410")
  void shouldReconnectInCaseOf410() throws InterruptedException {
    // Given
    String startResourceVersion = "1000", midResourceVersion = "1001", mid2ResourceVersion = "1002",
        endResourceVersion = "1003";

    server.expect().withPath("/api/v1/pods")
        .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata()
            .withItems(Collections.emptyList()).build())
        .once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
            .withResourceVersion(midResourceVersion).endMetadata().build(), "ADDED"))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent)
        .done().always();
    server.expect().withPath("/api/v1/pods")
        .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(mid2ResourceVersion).endMetadata().withItems(
            new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion)
                .endMetadata().build())
            .build())
        .times(2);
    server.expect().withPath("/api/v1/pods?resourceVersion=" + mid2ResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
            .withResourceVersion(endResourceVersion).endMetadata().build(), "MODIFIED"))
        .done()
        .always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 10000L);
    CountDownLatch relistSuccessful = new CountDownLatch(1);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
            if (newObj.getMetadata().getName().equalsIgnoreCase("pod1") &&
                newObj.getMetadata().getResourceVersion().equalsIgnoreCase(endResourceVersion)) {
              relistSuccessful.countDown();
            }
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });
    factory.startAllRegisteredInformers();
    relistSuccessful.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, relistSuccessful.getCount());
  }

  @Test
  @DisplayName("Pod Informer should delete the entry from the index")
  void shouldDeleteIfMissingOnResync() throws InterruptedException {
    // Given
    String startResourceVersion = "1000", midResourceVersion = "1001", mid2ResourceVersion = "1002";

    server.expect().withPath("/api/v1/pods")
        .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata()
            .withItems(Collections.emptyList()).build())
        .once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
            .withResourceVersion(midResourceVersion).endMetadata().build(), "ADDED"))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent)
        .done().always();
    server.expect().withPath("/api/v1/pods")
        .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(mid2ResourceVersion).endMetadata()
            .withItems(Collections.emptyList()).build())
        .times(2);

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 10000L);
    CountDownLatch delete = new CountDownLatch(1);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
            if (deletedFinalStateUnknown) {
              delete.countDown();
            }
          }
        });
    factory.startAllRegisteredInformers();
    delete.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, delete.getCount());
    assertEquals(0, podInformer.getIndexer().list().size());
  }

  @Test
  @DisplayName("PodInformer's hasSynced() method should return false when it's not able to resync")
  void testHasSynced() {
    // Given
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/api/v1/namespaces/test/pods")
        .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata()
            .withItems(Collections.emptyList()).build())
        .once();
    server.expect()
        .withPath(
            "/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
            .withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent).done().once();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 2000L);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });
    factory.startAllRegisteredInformers();
    await().atMost(1, TimeUnit.SECONDS).until(() -> !podInformer.hasSynced());

    // Then
    assertFalse(podInformer.hasSynced());
  }

  @Test
  void testExceptionThrownOnInformerStartupFailure() {
    // Given
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 1000L);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });

    // When
    Future<Void> informerStartFutures = factory.startAllRegisteredInformers();
    assertThrows(ExecutionException.class, () -> informerStartFutures.get(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS));
  }

  @Test
  void testEventListeners() throws InterruptedException {
    // Given
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 1000L);
    CountDownLatch failureCallbackReceived = new CountDownLatch(1);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });

    // When
    factory.addSharedInformerEventListener(exception -> failureCallbackReceived.countDown());
    factory.startAllRegisteredInformers();
    failureCallbackReceived.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, failureCallbackReceived.getCount());
  }

  @Test
  @DisplayName("Should create Informer for Namespace resource")
  void testWithNamespaceInformer() throws InterruptedException {
    // Given
    setupMockServerExpectations(Namespace.class, null, this::getList, r -> new WatchEvent(new NamespaceBuilder()
        .withNewMetadata().withName("ns1")
        .withResourceVersion(r).endMetadata().build(), "ADDED"), null, null);

    // When
    SharedIndexInformer<Namespace> namespaceSharedIndexInformer = factory.sharedIndexInformerFor(
        Namespace.class, RESYNC_PERIOD);
    CountDownLatch foundExistingNamespace = new CountDownLatch(1);
    namespaceSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingNamespace, "ns1"));
    factory.startAllRegisteredInformers();
    foundExistingNamespace.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingNamespace.getCount());
  }

  @Test
  @DisplayName("Should create informer for ClusterRoleBinding resource")
  void testWithClusterBindingInformer() throws InterruptedException {
    // Given
    setupMockServerExpectations(ClusterRoleBinding.class, null, this::getList,
        r -> new WatchEvent(new ClusterRoleBindingBuilder()
            .withNewMetadata().withName("crb1")
            .withResourceVersion(r).endMetadata().build(), "ADDED"),
        null, null);

    // Given
    SharedIndexInformer<ClusterRoleBinding> clusterRoleBindingSharedIndexInformer = factory.sharedIndexInformerFor(
        ClusterRoleBinding.class, RESYNC_PERIOD);
    CountDownLatch foundExistingClusterRoleBinding = new CountDownLatch(1);
    clusterRoleBindingSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingClusterRoleBinding, "crb1"));
    factory.startAllRegisteredInformers();
    foundExistingClusterRoleBinding.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingClusterRoleBinding.getCount());
  }

  @Test
  @DisplayName("Should create informer for Deployment resource")
  void testWithDeploymentInformer() throws InterruptedException {
    // Given
    setupMockServerExpectations(Deployment.class, "ns1", this::getList, r -> new WatchEvent(new DeploymentBuilder()
        .withNewMetadata().withName("deployment1")
        .withResourceVersion(r).endMetadata().build(), "ADDED"), null, null);
    // When
    SharedIndexInformer<Deployment> deploymentSharedIndexInformer = factory.inNamespace("ns1").sharedIndexInformerFor(
        Deployment.class, RESYNC_PERIOD);
    CountDownLatch foundExistingDeployment = new CountDownLatch(1);
    deploymentSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingDeployment, "deployment1"));
    factory.startAllRegisteredInformers();
    foundExistingDeployment.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingDeployment.getCount());
  }

  @Test
  @DisplayName("Pod Informer should watch in ns1")
  void testWithOperationContextArgument() throws InterruptedException {
    // Given
    setupMockServerExpectations(Pod.class, "ns1", this::getList, r -> new WatchEvent(new PodBuilder()
        .withNewMetadata().withName("pod1")
        .withResourceVersion(r).endMetadata().build(), "ADDED"), null, null);

    // When
    SharedIndexInformer<Pod> podInformer = factory.inNamespace("ns1").sharedIndexInformerFor(Pod.class, 100L);
    CountDownLatch foundExistingPod = new CountDownLatch(1);
    podInformer.addEventHandler(new TestResourceHandler<>(foundExistingPod, "pod1"));
    factory.startAllRegisteredInformers();
    foundExistingPod.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingPod.getCount());
  }

  @Test
  @DisplayName("PodSet Informer should watch in all namespaces")
  void testPodSetCustomResourceInformerShouldWatchInAllNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectations(PodSet.class, null, this::getList, r -> new WatchEvent(getPodSet("podset1", r), "ADDED"), null,
        null);

    // When
    SharedIndexInformer<PodSet> podSetSharedIndexInformer = factory.sharedIndexInformerFor(PodSet.class,
        60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingPodSet = new CountDownLatch(1);
    podSetSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingPodSet, "podset1"));
    factory.startAllRegisteredInformers();
    foundExistingPodSet.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Namespace set in Client's Configuration from MockWebServer
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingPodSet.getCount());
  }

  @Test
  @DisplayName("PodSet Informer should watch in ns1(as specified in OperationContext)")
  void testWithPodSetCustomResourceInformerShouldWatchInSpecifiedNamespace() throws InterruptedException {
    // Given
    setupMockServerExpectations(PodSet.class, "ns1", this::getList, r -> new WatchEvent(getPodSet("podset1", r), "ADDED"), null,
        null);

    // When
    SharedIndexInformer<PodSet> podSetSharedIndexInformer = factory.inNamespace("ns1")
        .sharedIndexInformerFor(PodSet.class, 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingPodSet = new CountDownLatch(1);
    podSetSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingPodSet, "podset1"));
    factory.startAllRegisteredInformers();
    foundExistingPodSet.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingPodSet.getCount());
  }

  @Test
  void testWithOperationContextArgumentForClusterScopedCustomResource() throws InterruptedException {
    // Given
    setupMockServerExpectations(Star.class, null, this::getList, r -> new WatchEvent(getStar("star1", r), "ADDED"), null, null);

    // When
    SharedIndexInformer<Star> starSharedIndexInformer = factory.sharedIndexInformerFor(Star.class, RESYNC_PERIOD);
    CountDownLatch foundExistingStar = new CountDownLatch(1);
    starSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingStar, "star1"));
    factory.startAllRegisteredInformers();
    foundExistingStar.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingStar.getCount());
  }

  @Test
  @DisplayName("Pod Informer should should watch in all namespaces")
  void testPodInformerWithNoOperationContextAndNoListType() throws InterruptedException {
    // Given
    setupMockServerExpectations(Pod.class, null, this::getList, r -> new WatchEvent(new PodBuilder()
        .withNewMetadata().withName("pod1")
        .withResourceVersion(r).endMetadata().build(), "ADDED"), null, null);

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, RESYNC_PERIOD);
    CountDownLatch foundExistingPod = new CountDownLatch(1);
    podInformer.addEventHandler(new TestResourceHandler<>(foundExistingPod, "pod1"));
    factory.startAllRegisteredInformers();
    foundExistingPod.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingPod.getCount());
  }

  @Test
  @DisplayName("Pod Informer should without list type should watch in namespaces provided in OperationContext")
  void testPodInformerOperationContextAndNoListType() throws InterruptedException {
    // Given
    setupMockServerExpectations(Pod.class, "ns1", this::getList, r -> new WatchEvent(new PodBuilder()
        .withNewMetadata().withName("pod1")
        .withResourceVersion(r).endMetadata().build(), "ADDED"), null, null);

    // When
    SharedIndexInformer<Pod> podInformer = factory.inNamespace("ns1").sharedIndexInformerFor(Pod.class, RESYNC_PERIOD);
    CountDownLatch foundExistingPod = new CountDownLatch(1);
    podInformer.addEventHandler(new TestResourceHandler<>(foundExistingPod, "pod1"));
    factory.startAllRegisteredInformers();
    foundExistingPod.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingPod.getCount());
  }

  @Test
  @DisplayName("CronTab Informer without any CRDContext, OperationContext should watch in all namespaces")
  void testCronTabCustomResourceInformerWithNoCRDContextShouldWatchInAllNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectations(CronTab.class, null, this::getList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"),
        null, null);

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerFor(CronTab.class,
        60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer without any CRDContext should watch in namespace provided in OperationContext")
  void testCronTabCustomResourceInformerWithNoCRDContextShouldWatchInNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectations(CronTab.class, "ns1", this::getList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"),
        null, null);

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.inNamespace("ns1")
        .sharedIndexInformerFor(CronTab.class, 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer with no OperationContext should watch in all namespaces")
  void testCronTabCustomResourceInformerWithNoCRDContextAndListShouldWatchInAllNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectations(CronTab.class, null, this::getList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"),
        null, null);

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerFor(CronTab.class,
        60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer should watch in all namespaces")
  void testCronTabCustomResourceInformerShouldWatchAllNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectations(CronTab.class, null, this::getList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"),
        null, null);

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerFor(CronTab.class,
        60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer with should watch in namespaces in OperationContext")
  void testCronTabCustomResourceInformerWithShouldWatchNamespaceProvidedInOperationContext() throws InterruptedException {
    // Given
    setupMockServerExpectations(CronTab.class, "ns1", this::getList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"),
        null, null);

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.inNamespace("ns1")
        .sharedIndexInformerFor(CronTab.class, 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  void testCustomResourceInformerWithNoListTypeInClassPath() throws InterruptedException {
    // Given
    setupMockServerExpectations(Animal.class, null, this::getList,
        r -> new WatchEvent(getAnimal("red-panda", "Carnivora", r), "ADDED"), null, null);

    // When
    SharedIndexInformer<Animal> animalSharedIndexInformer = factory.sharedIndexInformerFor(Animal.class,
        60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    animalSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "red-panda"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("Test Informers of Same Resource but watching different namespaces")
  void testDifferentDeploymentInformersWatchingInDifferentNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectations(Deployment.class, "ns1", this::getList, r -> new WatchEvent(new DeploymentBuilder()
        .withNewMetadata().withName("d1")
        .withResourceVersion(r).endMetadata().build(), "ADDED"), null, null);
    setupMockServerExpectations(Deployment.class, "ns2", this::getList, r -> new WatchEvent(new DeploymentBuilder()
        .withNewMetadata().withName("d2")
        .withResourceVersion(r).endMetadata().build(), "ADDED"), null, null);
    CountDownLatch ns1FoundLatch = new CountDownLatch(1);
    CountDownLatch ns2FoundLatch = new CountDownLatch(1);

    // When
    SharedIndexInformer<Deployment> deploymentSharedIndexInformerInNamespace1 = factory.inNamespace("ns1")
        .sharedIndexInformerFor(Deployment.class, 60 * WATCH_EVENT_EMIT_TIME);
    SharedIndexInformer<Deployment> deploymentSharedIndexInformerInNamespace2 = factory.inNamespace("ns2")
        .sharedIndexInformerFor(Deployment.class, 60 * WATCH_EVENT_EMIT_TIME);
    deploymentSharedIndexInformerInNamespace1.addEventHandler(new TestResourceHandler<>(ns1FoundLatch, "d1"));
    deploymentSharedIndexInformerInNamespace2.addEventHandler(new TestResourceHandler<>(ns2FoundLatch, "d2"));
    factory.startAllRegisteredInformers();
    ns1FoundLatch.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    ns2FoundLatch.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, ns1FoundLatch.getCount());
    assertEquals(0, ns2FoundLatch.getCount());
  }

  @Test
  @DisplayName("Test CustomResource Informers with different versions")
  void testCustomResourceInformerWithDifferentVersions() throws InterruptedException {
    // Given
    setupMockServerExpectationsWithVersion(CronTab.class, "v1", "default", this::getList,
        r -> new WatchEvent(getCronTab("v1-crontab", r), "ADDED"), null, null);
    setupMockServerExpectationsWithVersion(CronTab.class, "v1beta1", "default", this::getList,
        r -> new WatchEvent(getCronTab("v1beta1-crontab", r), "ADDED"), null, null);
    CountDownLatch v1CronTabFound = new CountDownLatch(1);
    CountDownLatch v1beta1CronTabFound = new CountDownLatch(1);

    // When
    SharedIndexInformer<CronTab> v1CronTabSharedIndexInformer = factory.inNamespace("default")
        .sharedIndexInformerFor(CronTab.class, 60 * WATCH_EVENT_EMIT_TIME);
    ResourceDefinitionContext context = new ResourceDefinitionContext.Builder().withPlural(HasMetadata.getPlural(CronTab.class))
        .withGroup(HasMetadata.getGroup(CronTab.class))
        .withVersion("v1beta1")
        .withNamespaced(true)
        .build();
    SharedIndexInformer<GenericKubernetesResource> v1beta1CronTabSharedIndexInformer = client
        .genericKubernetesResources(context).inNamespace("default").inform();
    v1CronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(v1CronTabFound, "v1-crontab"));
    v1beta1CronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(v1beta1CronTabFound, "v1beta1-crontab"));
    factory.startAllRegisteredInformers();
    v1CronTabFound.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    v1beta1CronTabFound.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, v1CronTabFound.getCount());
    assertEquals(0, v1beta1CronTabFound.getCount());
  }

  @Test
  void testReconnectAfterOnCloseException() throws InterruptedException {
    // Given
    String startResourceVersion = "1000", midResourceVersion = "1001", mid2ResourceVersion = "1002";

    // initial list
    server.expect().withPath("/api/v1/pods")
        .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata()
            .withItems(Collections.emptyList()).build())
        .once();

    // initial watch - terminates with an exception
    Pod mid = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(midResourceVersion)
        .endMetadata().build();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(mid, "ADDED"))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent)
        .done().always();

    // re-list
    server.expect().withPath("/api/v1/pods")
        .andReturn(200,
            new PodListBuilder().withNewMetadata().withResourceVersion(midResourceVersion).endMetadata().withItems(mid).build())
        .once();

    // should pick this up after the termination
    server.expect().withPath("/api/v1/pods?resourceVersion=" + midResourceVersion + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
            .withResourceVersion(mid2ResourceVersion).endMetadata().build(), "MODIFIED"))
        .done().always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 0);
    CountDownLatch updates = new CountDownLatch(1);
    podInformer.addEventHandler(
        new ResourceEventHandler<Pod>() {
          @Override
          public void onAdd(Pod obj) {
          }

          @Override
          public void onUpdate(Pod oldObj, Pod newObj) {
            updates.countDown();
          }

          @Override
          public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) {
          }
        });
    factory.startAllRegisteredInformers();
    updates.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // should still be running after all that
    assertTrue(podInformer.isRunning());
    // Then
    assertEquals(0, updates.getCount());

    podInformer.stop();

    assertFalse(podInformer.isRunning());
  }

  @Test
  void testRunAfterStop() {
    // Given
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, 0);
    podInformer.stop();
    // When
    final IllegalStateException result = assertThrows(IllegalStateException.class, podInformer::run);
    // Then
    assertThat(result)
        .hasMessage("Cannot restart a stopped informer");
  }

  @Test
  void testGenericKubernetesResourceSharedIndexInformerAllNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectations(Animal.class, null, this::getList,
        r -> new WatchEvent(getAnimal("red-panda", "Carnivora", r), "ADDED"), null, null);

    // When
    SharedIndexInformer<GenericKubernetesResource> animalSharedIndexInformer = client
        .genericKubernetesResources(animalContext).inAnyNamespace().runnableInformer(60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingAnimal = new CountDownLatch(1);
    animalSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingAnimal, "red-panda"));
    animalSharedIndexInformer.start();
    foundExistingAnimal.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    animalSharedIndexInformer.stop();

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingAnimal.getCount());
  }

  @Test
  void testGenericKubernetesResourceSharedIndexInformerWithNamespaceConfigured() throws InterruptedException {
    // Given
    setupMockServerExpectations(Animal.class, "ns1", this::getList,
        r -> new WatchEvent(getAnimal("red-panda", "Carnivora", r), "ADDED"), null, null);

    // When
    SharedIndexInformer<GenericKubernetesResource> animalSharedIndexInformer = client
        .genericKubernetesResources(animalContext).inNamespace("ns1").runnableInformer(60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingAnimal = new CountDownLatch(1);
    animalSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingAnimal, "red-panda"));
    animalSharedIndexInformer.start();
    foundExistingAnimal.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    animalSharedIndexInformer.stop();

    // Then
    assertEquals(0, foundExistingAnimal.getCount());
  }

  @Test
  void testGenericKubernetesResourceSharedIndexInformerWithAdditionalDeserializers() throws InterruptedException {
    // Given
    setupMockServerExpectations(Animal.class, "ns1", this::getList,
        r -> new WatchEvent(getAnimal("red-panda", "Carnivora", r), "ADDED"), null, null);

    // When
    KubernetesDeserializer.registerCustomKind("jungle.example.com/v1", "Animal", CronTab.class);
    SharedIndexInformer<GenericKubernetesResource> animalSharedIndexInformer = client
        .genericKubernetesResources(animalContext).inNamespace("ns1").runnableInformer(60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingAnimal = new CountDownLatch(1);
    animalSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingAnimal, "red-panda"));
    animalSharedIndexInformer.start();
    foundExistingAnimal.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    animalSharedIndexInformer.stop();

    // Then
    assertEquals(0, foundExistingAnimal.getCount());
  }

  private KubernetesResource getAnimal(String name, String order, String resourceVersion) {
    AnimalSpec animalSpec = new AnimalSpec();
    animalSpec.setOrder(order);

    Animal animal = new Animal();
    animal.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    animal.setSpec(animalSpec);
    return animal;
  }

  private <T extends HasMetadata> KubernetesResourceList<T> getList(String startResourceVersion, Class<T> crClass) {
    final CustomResourceList<T> list = new CustomResourceList<>();
    list.setMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build());
    return list;
  }

  private KubernetesResource getCronTab(String name, String resourceVersion) {
    CronTabSpec cronTabSpec = new CronTabSpec();
    cronTabSpec.setCronSpec("* * * * */5");
    cronTabSpec.setImage("my-awesome-cron-image");

    CronTab cronTab = new CronTab();
    cronTab.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    cronTab.setSpec(cronTabSpec);
    return cronTab;
  }

  private <T extends HasMetadata> void setupMockServerExpectations(Class<T> resourceClass, String namespace,
      BiFunction<String, Class<T>, KubernetesResourceList<T>> listSupplier, Function<String, WatchEvent> watchEventSupplier,
      String labelSelector, String fieldSelector) {
    setupMockServerExpectationsWithVersion(resourceClass, HasMetadata.getVersion(resourceClass), namespace, listSupplier,
        watchEventSupplier, labelSelector, fieldSelector);
  }

  private <T extends HasMetadata> void setupMockServerExpectationsWithVersion(Class<T> resourceClass, String version,
      String namespace, BiFunction<String, Class<T>, KubernetesResourceList<T>> listSupplier,
      Function<String, WatchEvent> watchEventSupplier, String labelSelector, String fieldSelector) {
    String startResourceVersion = "1000", endResourceVersion = "1001";
    String group = HasMetadata.getGroup(resourceClass);
    String url = Utils.isNotNullOrEmpty(group) ? "/apis" : "/api";
    if (Utils.isNotNullOrEmpty(group)) {
      url += "/" + group;
    }
    url += "/" + version;
    if (namespace != null) {
      url += ("/namespaces/" + namespace);
    }
    url += ("/" + HasMetadata.getPlural(resourceClass));
    String queryParams = "";
    if (labelSelector != null) {
      queryParams += "labelSelector=" + labelSelector;
    }
    if (fieldSelector != null) {
      queryParams += "fieldSelector=" + fieldSelector;
    }
    String listUrl = url;
    if (Utils.isNotNullOrEmpty(queryParams)) {
      listUrl += "?" + queryParams;
    }
    server.expect().withPath(listUrl)
        .andReturn(HttpURLConnection.HTTP_OK, listSupplier.apply(startResourceVersion, resourceClass)).once();

    String watchUrl = listUrl;
    if (Utils.isNotNullOrEmpty(queryParams)) {
      watchUrl += "&";
    } else {
      watchUrl += "?";
    }

    watchUrl += "resourceVersion=" + startResourceVersion + "&allowWatchBookmarks=true&watch=true";
    server.expect().withPath(watchUrl)
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_EMIT_TIME)
        .andEmit(watchEventSupplier.apply(endResourceVersion))
        .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
        .andEmit(outdatedEvent).done().always();
  }

  private static class TestResourceHandler<T extends HasMetadata> implements ResourceEventHandler<T> {
    private final CountDownLatch foundExistingCronTab;
    private final String targetResourceName;

    public TestResourceHandler(CountDownLatch foundExistingCronTab, String targetResourceName) {
      this.targetResourceName = targetResourceName;
      this.foundExistingCronTab = foundExistingCronTab;
    }

    @Override
    public void onAdd(T cronTab) {
      if (cronTab.getMetadata().getName().equalsIgnoreCase(targetResourceName)) {
        foundExistingCronTab.countDown();
      }
    }

    @Override
    public void onUpdate(T oldObj, T newObj) {
    }

    @Override
    public void onDelete(T obj, boolean deletedFinalStateUnknown) {
    }
  }

  private Star getStar(String name, String resourceVersion) {
    StarSpec starSpec = new StarSpec();
    starSpec.setType("G");
    starSpec.setLocation("Galaxy");

    Star star = new Star();
    star.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    star.setSpec(starSpec);
    return star;
  }

  private PodSet getPodSet(String name, String resourceVersion) {
    PodSetSpec podSetSpec = new PodSetSpec();
    podSetSpec.setReplicas(5);

    PodSet podSet = new PodSet();
    podSet.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    podSet.setSpec(podSetSpec);

    return podSet;
  }

}
