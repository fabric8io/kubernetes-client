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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListMeta;
import io.fabric8.kubernetes.api.model.ListMetaBuilder;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.NamespaceListBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.WatchEventBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.apps.DeploymentListBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.mock.crd.Animal;
import io.fabric8.kubernetes.client.mock.crd.AnimalSpec;
import io.fabric8.kubernetes.client.mock.crd.CronTab;
import io.fabric8.kubernetes.client.mock.crd.CronTabList;
import io.fabric8.kubernetes.client.mock.crd.CronTabSpec;
import io.fabric8.kubernetes.client.mock.crd.PodSet;
import io.fabric8.kubernetes.client.mock.crd.PodSetList;
import io.fabric8.kubernetes.client.mock.crd.PodSetSpec;
import io.fabric8.kubernetes.client.mock.crd.Star;
import io.fabric8.kubernetes.client.mock.crd.StarList;
import io.fabric8.kubernetes.client.mock.crd.StarSpec;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.awaitility.Awaitility.await;

@EnableRuleMigrationSupport
class DefaultSharedIndexInformerTest {
  @Rule
  public KubernetesServer server = new KubernetesServer(false);

  private final CustomResourceDefinitionContext podSetCustomResourceContext = new CustomResourceDefinitionContext.Builder()
    .withVersion("v1alpha1")
    .withScope("Namespaced")
    .withGroup("demo.k8s.io")
    .withPlural("podsets")
    .build();

  private final CustomResourceDefinitionContext cronTabCRDContext = new CustomResourceDefinitionContext.Builder()
    .withVersion("v1")
    .withScope("Namespaced")
    .withGroup("stable.example.com")
    .withPlural("crontabs")
    .build();

  static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
    .withMessage(
      "401: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
    .build();
  static final WatchEvent outdatedEvent = new WatchEventBuilder().withStatusObject(outdatedStatus).build();
  static final Long WATCH_EVENT_EMIT_TIME = 1L;
  static final Long OUTDATED_WATCH_EVENT_EMIT_TIME = 1L;
  static final long RESYNC_PERIOD = 5L;
  static final int LATCH_AWAIT_PERIOD_IN_SECONDS = 10;
  private KubernetesClient client;
  private SharedInformerFactory factory;

  @BeforeEach
  void setup() {
    client = server.getClient();
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
      .andReturn(200, getEmptyPodList(startResourceVersion)).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, new OperationContext().withNamespace("test"), RESYNC_PERIOD);
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
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
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
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, RESYNC_PERIOD);
    CountDownLatch foundExistingPod = new CountDownLatch(1);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("pod1") && obj.getMetadata().getNamespace().equalsIgnoreCase("test")) {
            foundExistingPod.countDown();
          }
        }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    factory.startAllRegisteredInformers();
    foundExistingPod.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingPod.getCount());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());
  }

  @Test
  @DisplayName("Pod Informer should reconnect on 410")
  void shouldReconnectInCaseOf410() throws InterruptedException {
    // Given
    String startResourceVersion = "1000", midResourceVersion = "1001", mid2ResourceVersion = "1002", endResourceVersion = "1003";

    server.expect().withPath("/api/v1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(midResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent)
      .done().always();
    server.expect().withPath("/api/v1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(mid2ResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).times(2);
    server.expect().withPath("/api/v1/pods?resourceVersion=" + mid2ResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "MODIFIED"))
      .done()
      .always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 10000L);
    CountDownLatch relistSuccessful = new CountDownLatch(1);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) { }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) {
          if (newObj.getMetadata().getName().equalsIgnoreCase("pod1") &&
            newObj.getMetadata().getResourceVersion().equalsIgnoreCase(endResourceVersion)) {
            relistSuccessful.countDown();
          }
        }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    factory.startAllRegisteredInformers();
    relistSuccessful.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, relistSuccessful.getCount());
  }

  @Test
  @DisplayName("PodInformer's hasSynced() method should return false when it's not able to resync")
  void testHasSynced() {
    // Given
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().once();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 2000L);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) { }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    factory.startAllRegisteredInformers();
    await().atMost(1, TimeUnit.SECONDS).until(() -> !podInformer.hasSynced());

    // Then
    assertFalse(podInformer.hasSynced());
  }

  @Test
  void testEventListeners() throws InterruptedException {
    // Given
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 1000L);
    CountDownLatch failureCallbackReceived = new CountDownLatch(1);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) { }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
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
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/api/v1/namespaces")
      .andReturn(200, new NamespaceListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/namespaces?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new NamespaceBuilder().withNewMetadata().withName("ns1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Namespace> namespaceSharedIndexInformer = factory.sharedIndexInformerFor(
      Namespace.class, NamespaceList.class,
      RESYNC_PERIOD);
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
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/apis/rbac.authorization.k8s.io/v1beta1/clusterrolebindings")
      .andReturn(200, new ClusterRoleBindingListBuilder().withMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build()).withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/apis/rbac.authorization.k8s.io/v1beta1/clusterrolebindings?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new ClusterRoleBindingBuilder().withNewMetadata().withName("crb1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

    // Given
    SharedIndexInformer<ClusterRoleBinding> clusterRoleBindingSharedIndexInformer = factory.sharedIndexInformerFor(
      ClusterRoleBinding.class, ClusterRoleBindingList.class, RESYNC_PERIOD);
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
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments")
      .andReturn(200, new DeploymentListBuilder().withMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build()).withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/apis/apps/v1/namespaces/ns1/deployments?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new DeploymentBuilder().withNewMetadata().withName("deployment1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Deployment> deploymentSharedIndexInformer = factory.sharedIndexInformerFor(
      Deployment.class, DeploymentList.class, new OperationContext().withNamespace("ns1"), RESYNC_PERIOD);
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
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/namespaces/ns1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(
      Pod.class, PodList.class,
      new OperationContext().withNamespace("ns1"),
      100L);
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
    setupMockServerExpectationsForCronTab("demo.k8s.io", "v1alpha1", null, "podsets",
      this::getPodSetList, r -> new WatchEvent(getPodSet("podset1", r), "ADDED"));

    // When
    SharedIndexInformer<PodSet> podSetSharedIndexInformer = factory.sharedIndexInformerForCustomResource(podSetCustomResourceContext, PodSet.class, PodSetList.class, 60 * WATCH_EVENT_EMIT_TIME);
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
    setupMockServerExpectationsForCronTab("demo.k8s.io", "v1alpha1", "ns1", "podsets",
      this::getPodSetList, r -> new WatchEvent(getPodSet("podset1", r), "ADDED"));

    // When
    SharedIndexInformer<PodSet> podSetSharedIndexInformer = factory.sharedIndexInformerForCustomResource(podSetCustomResourceContext, PodSet.class, PodSetList.class, new OperationContext().withNamespace("ns1"), 60 * WATCH_EVENT_EMIT_TIME);
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
    setupMockServerExpectationsForCronTab("example.crd.com", "v1alpha1", null, "stars",
      this::getStarList, r -> new WatchEvent(getStar("star1", r), "ADDED"));
    CustomResourceDefinitionContext crdContext = new CustomResourceDefinitionContext.Builder()
      .withVersion("v1alpha1")
      .withScope("Cluster")
      .withGroup("example.crd.com")
      .withPlural("stars")
      .build();

    // When
    SharedIndexInformer<Star> starSharedIndexInformer = factory.sharedIndexInformerForCustomResource(crdContext, Star.class, StarList.class,  RESYNC_PERIOD);
    CountDownLatch foundExistingStar = new CountDownLatch(1);
    starSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingStar, "star1"));
    factory.startAllRegisteredInformers();
    foundExistingStar.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingStar.getCount());
  }

  @Test
  @DisplayName("Pod Informer should without list type should watch in all namespaces")
  void testPodInformerWithNoOperationContextAndNoListType() throws InterruptedException {
    // Given
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/api/v1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

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
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/api/v1/namespaces/ns1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("ns1").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();
    OperationContext operationContext = new OperationContext().withNamespace("ns1");

    // When
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, operationContext, RESYNC_PERIOD);
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
    setupMockServerExpectationsForCronTab("stable.example.com", "v1", null, "crontabs",
      this::getCronTabList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"));

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerForCustomResource(CronTab.class, CronTabList.class, 60 * WATCH_EVENT_EMIT_TIME);
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
    setupMockServerExpectationsForCronTab("stable.example.com", "v1", "ns1", "crontabs",
      this::getCronTabList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"));

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerForCustomResource(CronTab.class, CronTabList.class, new OperationContext().withNamespace("ns1"), 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer with no CRDContext, OperationContext and List type should watch in all namespaces")
  void testCronTabCustomResourceInformerWithNoCRDContextAndListShouldWatchInAllNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectationsForCronTab("stable.example.com", "v1", null, "crontabs",
      this::getCronTabList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"));

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerForCustomResource(CronTab.class, 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer without any CRDContext & List type should watch in namespace provided in OperationContext")
  void testCronTabCustomResourceInformerWithNoCRDContextAndListShouldWatchInNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectationsForCronTab("stable.example.com", "v1", "ns1", "crontabs",
      this::getCronTabList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"));

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerForCustomResource(CronTab.class, new OperationContext().withNamespace("ns1"), 60 * WATCH_EVENT_EMIT_TIME);
    final CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer with CRDContext no List type should watch in all namespaces")
  void testCronTabCustomResourceInformerWithCRDContextShouldWatchAllNamespaces() throws InterruptedException {
    // Given
    setupMockServerExpectationsForCronTab("stable.example.com", "v1", null, "crontabs",
      this::getCronTabList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"));

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerForCustomResource(cronTabCRDContext, CronTab.class, 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  @DisplayName("CronTab Informer with CRDContext no List type should watch in namespaces in OperationContext")
  void testCronTabCustomResourceInformerWithCRDContextShouldWatchNamespaceProvidedInOperationContext() throws InterruptedException {
    // Given
    setupMockServerExpectationsForCronTab("stable.example.com", "v1", "ns1", "crontabs",
      this::getCronTabList, r -> new WatchEvent(getCronTab("crontab1", r), "ADDED"));

    // When
    SharedIndexInformer<CronTab> cronTabSharedIndexInformer = factory.sharedIndexInformerForCustomResource(cronTabCRDContext, CronTab.class, new OperationContext().withNamespace("ns1"), 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    cronTabSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "crontab1"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  @Test
  void testCustomResourceInformerWithNoCRDContextAndNoListTypeInClassPath() throws InterruptedException {
    // Given
    setupMockServerExpectationsForCronTab("jungle.example.com", "v1", null, "animals",
      this::getAnimalList, r -> new WatchEvent(getAnimal("red-panda", "Carnivora", r), "ADDED"));

    // When
    SharedIndexInformer<Animal> animalSharedIndexInformer = factory.sharedIndexInformerForCustomResource(Animal.class, 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingCronTab = new CountDownLatch(1);
    animalSharedIndexInformer.addEventHandler(new TestResourceHandler<>(foundExistingCronTab, "red-panda"));
    factory.startAllRegisteredInformers();
    foundExistingCronTab.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);

    // Then
    assertEquals("test", client.getConfiguration().getNamespace());
    assertEquals(0, foundExistingCronTab.getCount());
  }

  private KubernetesResource getAnimal(String name, String order, String resourceVersion) {
    AnimalSpec animalSpec = new AnimalSpec();
    animalSpec.setOrder(order);

    Animal animal = new Animal();
    animal.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    animal.setSpec(animalSpec);
    return animal;
  }

  private StarList getStarList(String startResourceVersion) {
    StarList starList = new StarList();
    starList.setMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build());
    return starList;
  }

  private CronTabList getCronTabList(String startResourceVersion) {
    CronTabList cronTabList = new CronTabList();
    cronTabList.setMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build());
    return cronTabList;
  }

  private KubernetesResource getCronTab(String name, String resourceVersion) {
    CronTabSpec cronTabSpec= new CronTabSpec();
    cronTabSpec.setCronSpec("* * * * */5");
    cronTabSpec.setImage("my-awesome-cron-image");

    CronTab cronTab = new CronTab();
    cronTab.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    cronTab.setSpec(cronTabSpec);
    return cronTab;
  }

  private <T extends HasMetadata, L extends KubernetesResourceList<T>> void setupMockServerExpectationsForCronTab(String group, String version, String namespace, String plural, Function<String, L> listSupplier, Function<String, WatchEvent> watchEventSupplier) {
    String startResourceVersion = "1000", endResourceVersion = "1001";
    String url = "/apis/" + group +"/" + version;
    if (namespace != null) {
      url += ("/namespaces/" + namespace);
    }
    url += ("/" + plural);
    server.expect().withPath(url)
      .andReturn(HttpURLConnection.HTTP_OK, listSupplier.apply(startResourceVersion)).once();

    server.expect().withPath(url + "?resourceVersion=" + startResourceVersion + "&watch=true")
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
    public void onUpdate(T oldObj, T newObj) { }

    @Override
    public void onDelete(T obj, boolean deletedFinalStateUnknown) { }
  }

  private Star getStar(String name, String resourceVersion) {
    StarSpec starSpec = new StarSpec();
    starSpec.setType("G");
    starSpec.setLocation("Galaxy");

    Star star = new Star();
    star.setApiVersion("example.crd.com/v1alpha1");
    star.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    star.setSpec(starSpec);
    return star;
  }

  private PodSet getPodSet(String name, String resourceVersion) {
    PodSetSpec podSetSpec = new PodSetSpec();
    podSetSpec.setReplicas(5);

    PodSet podSet = new PodSet();
    podSet.setApiVersion("demo.k8s.io/v1alpha1");
    podSet.setMetadata(new ObjectMetaBuilder().withName(name).withResourceVersion(resourceVersion).build());
    podSet.setSpec(podSetSpec);

    return podSet;
  }

  private PodSetList getPodSetList(String startResourceVersion) {
    PodSetList podSetList = new PodSetList();
    podSetList.setMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build());
    return podSetList;
  }

  private KubernetesResourceList<Animal> getAnimalList(String resourceVersion) {
    return new KubernetesResourceList<Animal>() {
      @Override
      public ListMeta getMetadata() {
        return new ListMetaBuilder()
          .withResourceVersion(resourceVersion)
          .build();
      }

      @Override
      public List<Animal> getItems() {
        return Collections.emptyList();
      }
    };
  }

  private KubernetesResourceList<Pod> getEmptyPodList(String resourceVersion) {
    return new PodListBuilder().withNewMetadata().withResourceVersion(resourceVersion).endMetadata().withItems(Collections.emptyList()).build();
  }

}
