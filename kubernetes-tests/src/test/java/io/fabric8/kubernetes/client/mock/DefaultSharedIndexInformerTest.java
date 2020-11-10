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
import io.fabric8.kubernetes.client.mock.crd.PodSet;
import io.fabric8.kubernetes.client.mock.crd.PodSetList;
import io.fabric8.kubernetes.client.mock.crd.PodSetSpec;
import io.fabric8.kubernetes.client.mock.crd.Star;
import io.fabric8.kubernetes.client.mock.crd.StarList;
import io.fabric8.kubernetes.client.mock.crd.StarSpec;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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

  static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
    .withMessage(
      "401: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
    .build();
  static final WatchEvent outdatedEvent = new WatchEventBuilder().withStatusObject(outdatedStatus).build();
  static final Long WATCH_EVENT_EMIT_TIME = 1L;
  static final Long OUTDATED_WATCH_EVENT_EMIT_TIME = 1L;
  static final long RESYNC_PERIOD = 5L;
  static final int LATCH_AWAIT_PERIOD_IN_SECONDS = 10;

  @Test
  @DisplayName("Pod Informer should watch in test(as specified in OperationContext)")
  void testNamespacedPodInformer() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Collections.emptyList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
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
    assertEquals(0L, foundExistingPod.getCount());
    await().atMost(1, TimeUnit.SECONDS)
      .until(() -> podInformer.lastSyncResourceVersion().equals(endResourceVersion));
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("Pod Informer should watch in all namespaces")
  void testAllNamespacedInformer() throws InterruptedException {
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

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
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
    assertEquals(0, foundExistingPod.getCount());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("Pod Informer should reconnect on 410")
  void shouldReconnectInCaseOf410() throws InterruptedException {
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

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
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
    assertEquals(0, relistSuccessful.getCount());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("PodInformer's hasSynced() method should return false when it's not able to resync")
  void testHasSynced() {
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

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
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
    assertFalse(podInformer.hasSynced());

    factory.stopAllRegisteredInformers();
  }

  @Test
  void testEventListeners() throws InterruptedException {
    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
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

    factory.addSharedInformerEventListener(exception -> failureCallbackReceived.countDown());
    factory.startAllRegisteredInformers();

    failureCallbackReceived.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    assertEquals(0, failureCallbackReceived.getCount());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("Should create Informer for Namespace resource")
  void testWithNamespaceInformer() throws InterruptedException {
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

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Namespace> namespaceSharedIndexInformer = factory.sharedIndexInformerFor(
      Namespace.class, NamespaceList.class,
      RESYNC_PERIOD);

    CountDownLatch foundExistingNamespace = new CountDownLatch(1);
    namespaceSharedIndexInformer.addEventHandler(
      new ResourceEventHandler<Namespace>() {
        @Override
        public void onAdd(Namespace obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("ns1")) {
            foundExistingNamespace.countDown();
          }
        }

        @Override
        public void onUpdate(Namespace oldObj, Namespace newObj) { }

        @Override
        public void onDelete(Namespace oldObj, boolean deletedFinalStateUnknown) { }
      });
    factory.startAllRegisteredInformers();

    foundExistingNamespace.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    assertEquals(0, foundExistingNamespace.getCount());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("Should create informer for ClusterRoleBinding resource")
  void testWithClusterBindingInformer() throws InterruptedException {
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

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<ClusterRoleBinding> clusterRoleBindingSharedIndexInformer = factory.sharedIndexInformerFor(
      ClusterRoleBinding.class, ClusterRoleBindingList.class,
      RESYNC_PERIOD);

    CountDownLatch foundExistingClusterRoleBinding = new CountDownLatch(1);
    clusterRoleBindingSharedIndexInformer.addEventHandler(
      new ResourceEventHandler<ClusterRoleBinding>() {
        @Override
        public void onAdd(ClusterRoleBinding obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("crb1")) {
            foundExistingClusterRoleBinding.countDown();
          }
        }

        @Override
        public void onUpdate(ClusterRoleBinding oldObj, ClusterRoleBinding newObj) { }

        @Override
        public void onDelete(ClusterRoleBinding oldObj, boolean deletedFinalStateUnknown) { }
      });
    factory.startAllRegisteredInformers();

    foundExistingClusterRoleBinding.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    assertEquals(0, foundExistingClusterRoleBinding.getCount());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("Should create informer for Deployment resource")
  void testWithDeploymentInformer() throws InterruptedException {
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

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Deployment> deploymentSharedIndexInformer = factory.sharedIndexInformerFor(
      Deployment.class, DeploymentList.class,
      new OperationContext().withNamespace("ns1"),
      RESYNC_PERIOD);

    CountDownLatch foundExistingDeployment = new CountDownLatch(1);
    deploymentSharedIndexInformer.addEventHandler(
      new ResourceEventHandler<Deployment>() {
        @Override
        public void onAdd(Deployment obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("deployment1")) {
            foundExistingDeployment.countDown();
          }
        }

        @Override
        public void onUpdate(Deployment oldObj, Deployment newObj) { }

        @Override
        public void onDelete(Deployment oldObj, boolean deletedFinalStateUnknown) { }
      });
    factory.startAllRegisteredInformers();

    foundExistingDeployment.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    assertEquals(0, foundExistingDeployment.getCount());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("Pod Informer should watch in ns1")
  void testWithOperationContextArgument() throws InterruptedException {
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

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(
      Pod.class, PodList.class,
      new OperationContext().withNamespace("ns1"),
      100L);

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
    assertEquals(0, foundExistingPod.getCount());

    factory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("PodSet Informer should watch in all namespaces")
  void testPodSetCustomResourceInformerShouldWatchInAllNamespaces() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/apis/demo.k8s.io/v1alpha1/podsets")
      .andReturn(HttpURLConnection.HTTP_OK, getPodSetList(startResourceVersion)).once();

    server.expect().withPath("/apis/demo.k8s.io/v1alpha1/podsets?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(getPodSet("podset1", endResourceVersion), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();
    KubernetesClient client = server.getClient();


    SharedInformerFactory sharedInformerFactory = client.informers();
    SharedIndexInformer<PodSet> podSetSharedIndexInformer = sharedInformerFactory.sharedIndexInformerForCustomResource(podSetCustomResourceContext, PodSet.class, PodSetList.class, 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingPodSet = new CountDownLatch(1);
    podSetSharedIndexInformer.addEventHandler(
      new ResourceEventHandler<PodSet>() {
        @Override
        public void onAdd(PodSet podSet) {
          if (podSet.getMetadata().getName().equalsIgnoreCase("podset1")) {
            foundExistingPodSet.countDown();
          }
        }

        @Override
        public void onUpdate(PodSet oldPodSet, PodSet newPodSet) { }

        @Override
        public void onDelete(PodSet podSet, boolean deletedFinalStateUnknown) { }
      });
    sharedInformerFactory.startAllRegisteredInformers();

    // Namespace set in Client's Configuration from MockWebServer
    assertEquals("test", client.getConfiguration().getNamespace());
    foundExistingPodSet.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    assertEquals(0, foundExistingPodSet.getCount());

    sharedInformerFactory.stopAllRegisteredInformers();
  }

  @Test
  @DisplayName("PodSet Informer should watch in ns1(as specified in OperationContext)")
  void testWithPodSetCustomResourceInformerShouldWatchInSpecifiedNamespace() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/ns1/podsets")
      .andReturn(HttpURLConnection.HTTP_OK, getPodSetList(startResourceVersion)).once();

    server.expect().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/ns1/podsets?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(getPodSet("podset1", endResourceVersion), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();
    KubernetesClient client = server.getClient();

    SharedInformerFactory sharedInformerFactory = client.informers();
    SharedIndexInformer<PodSet> podSetSharedIndexInformer = sharedInformerFactory.sharedIndexInformerForCustomResource(podSetCustomResourceContext, PodSet.class, PodSetList.class, new OperationContext().withNamespace("ns1"), 60 * WATCH_EVENT_EMIT_TIME);
    CountDownLatch foundExistingPodSet = new CountDownLatch(1);
    podSetSharedIndexInformer.addEventHandler(
      new ResourceEventHandler<PodSet>() {
        @Override
        public void onAdd(PodSet podSet) {
          if (podSet.getMetadata().getName().equalsIgnoreCase("podset1")) {
            foundExistingPodSet.countDown();
          }
        }

        @Override
        public void onUpdate(PodSet oldPodSet, PodSet newPodSet) { }

        @Override
        public void onDelete(PodSet podSet, boolean deletedFinalStateUnknown) { }
      });
    sharedInformerFactory.startAllRegisteredInformers();

    foundExistingPodSet.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    assertEquals(0, foundExistingPodSet.getCount());

    sharedInformerFactory.stopAllRegisteredInformers();
  }

  @Test
  void testWithOperationContextArgumentForClusterScopedCustomResource() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";
    StarList starList = new StarList();
    starList.setMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build());

    server.expect().withPath("/apis/example.crd.com/v1alpha1/stars")
      .andReturn(200, starList).once();

    server.expect().withPath("/apis/example.crd.com/v1alpha1/stars?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_EMIT_TIME)
      .andEmit(new WatchEvent(getStar("star1", endResourceVersion), "ADDED"))
      .waitFor(OUTDATED_WATCH_EVENT_EMIT_TIME)
      .andEmit(outdatedEvent).done().always();
    KubernetesClient client = server.getClient();

    CustomResourceDefinitionContext crdContext = new CustomResourceDefinitionContext.Builder()
      .withVersion("v1alpha1")
      .withScope("Cluster")
      .withGroup("example.crd.com")
      .withPlural("stars")
      .build();

    SharedInformerFactory sharedInformerFactory = client.informers();
    SharedIndexInformer<Star> starSharedIndexInformer = sharedInformerFactory.sharedIndexInformerForCustomResource(crdContext, Star.class, StarList.class,  RESYNC_PERIOD);
    CountDownLatch foundExistingStar = new CountDownLatch(1);
    starSharedIndexInformer.addEventHandler(
      new ResourceEventHandler<Star>() {
        @Override
        public void onAdd(Star star) {
          if (star.getMetadata().getName().equalsIgnoreCase("star1")) {
            foundExistingStar.countDown();
          }
        }

        @Override
        public void onUpdate(Star oldStar, Star newStar) { }

        @Override
        public void onDelete(Star star, boolean deletedFinalStateUnknown) { }
      });
    sharedInformerFactory.startAllRegisteredInformers();

    foundExistingStar.await(LATCH_AWAIT_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    assertEquals(0, foundExistingStar.getCount());

    sharedInformerFactory.stopAllRegisteredInformers();
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

}
