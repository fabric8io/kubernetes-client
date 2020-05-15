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
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.WatchEventBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.mock.crd.PodSet;
import io.fabric8.kubernetes.client.mock.crd.PodSetList;
import io.fabric8.kubernetes.client.mock.crd.PodSetSpec;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@EnableRuleMigrationSupport
public class DefaultSharedIndexInformerTest {
  @Rule
  public KubernetesServer server = new KubernetesServer(false);

  static final Status outdatedStatus = new StatusBuilder().withCode(HttpURLConnection.HTTP_GONE)
    .withMessage(
      "401: The event in requested index is outdated and cleared (the requested history has been cleared [3/1]) [2]")
    .build();
  static final WatchEvent outdatedEvent = new WatchEventBuilder().withStatusObject(outdatedStatus).build();

  @Test
  public void testNamespacedPodInformer() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().always();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class,4000L);

    AtomicBoolean foundExistingPod = new AtomicBoolean(false);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("pod1")) {
            foundExistingPod.set(true);
          }
        }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000L);
    factory.startAllRegisteredInformers();

    Thread.sleep(5000L);
    assertEquals(true, foundExistingPod.get());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }

  @Test
  public void testAllNamespacedInformer() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().always();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 4000L);

    AtomicBoolean foundExistingPod = new AtomicBoolean(false);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("pod1") && obj.getMetadata().getNamespace().equalsIgnoreCase("test")) {
            foundExistingPod.set(true);
          }
        }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000L);
    factory.startAllRegisteredInformers();

    Thread.sleep(5000L);
    assertEquals(true, foundExistingPod.get());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }

  @Test
  public void shouldReconnectInCaseOf410() throws InterruptedException {
    String startResourceVersion = "1000", midResourceVersion = "1001", mid2ResourceVersion = "1002", endResourceVersion = "1003";

    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(midResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent)
      .done().always();
    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(mid2ResourceVersion).endMetadata().withItems(Arrays.asList()).build()).times(2);
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + mid2ResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "MODIFIED"))
      .done()
      .always();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 10000L);

    AtomicBoolean relistSuccessful = new AtomicBoolean(false);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) { }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) {
          if (newObj.getMetadata().getName().equalsIgnoreCase("pod1") &&
            newObj.getMetadata().getResourceVersion().equalsIgnoreCase(endResourceVersion)) {
            relistSuccessful.set(true);
          }
        }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000L);
    factory.startAllRegisteredInformers();

    Thread.sleep(10000L);
    assertEquals(true, relistSuccessful.get());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }

  @Test
  public void testHasSynced() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().once();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 4000L);

    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) { }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000L);
    factory.startAllRegisteredInformers();

    // Wait for resync period of pass
    Thread.sleep(8000L);
    assertEquals(false, podInformer.hasSynced());

    factory.stopAllRegisteredInformers();
  }

  @Test
  public void testEventListeners() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";
    server.expect().withPath("/api/v1/namespaces/test/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/test/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().once();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(Pod.class, PodList.class, 4000L);
    AtomicBoolean failureCallbackReceived = new AtomicBoolean(false);

    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) { }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });

    factory.addSharedInformerEventListener(exception -> failureCallbackReceived.set(true));
    Thread.sleep(1000L);
    factory.startAllRegisteredInformers();

    // Wait for resync period of pass
    Thread.sleep(8000L);
    assertEquals(false, failureCallbackReceived.get());

    factory.stopAllRegisteredInformers();
  }

  @Test
  public void testWithOperationContextArgument() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";

    server.expect().withPath("/api/v1/namespaces/ns1/pods")
      .andReturn(200, new PodListBuilder().withNewMetadata().withResourceVersion(startResourceVersion).endMetadata().withItems(Arrays.asList()).build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(new PodBuilder().withNewMetadata().withName("pod1").withResourceVersion(endResourceVersion).endMetadata().build(), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().always();

    KubernetesClient client = server.getClient();
    SharedInformerFactory factory = client.informers();
    SharedIndexInformer<Pod> podInformer = factory.sharedIndexInformerFor(
      Pod.class, PodList.class,
      new OperationContext().withNamespace("ns1"),
      4000L);

    AtomicBoolean foundExistingPod = new AtomicBoolean(false);
    podInformer.addEventHandler(
      new ResourceEventHandler<Pod>() {
        @Override
        public void onAdd(Pod obj) {
          if (obj.getMetadata().getName().equalsIgnoreCase("pod1")) {
            foundExistingPod.set(true);
          }
        }

        @Override
        public void onUpdate(Pod oldObj, Pod newObj) { }

        @Override
        public void onDelete(Pod oldObj, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000L);
    factory.startAllRegisteredInformers();

    Thread.sleep(5000L);
    assertTrue(foundExistingPod.get());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    factory.stopAllRegisteredInformers();
  }

  @Test
  public void testWithOperationContextArgumentForCustomResource() throws InterruptedException {
    String startResourceVersion = "1000", endResourceVersion = "1001";
    PodSetList podSetList = new PodSetList();
    podSetList.setMetadata(new ListMetaBuilder().withResourceVersion(startResourceVersion).build());

    server.expect().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/ns1/podsets")
      .andReturn(200, podSetList).once();

    server.expect().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/ns1/podsets?resourceVersion=" + startResourceVersion + "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(1000)
      .andEmit(new WatchEvent(getPodSet("podset1", endResourceVersion), "ADDED"))
      .waitFor(2000)
      .andEmit(outdatedEvent).done().always();
    KubernetesClient client = server.getClient();

    CustomResourceDefinitionContext crdContext = new CustomResourceDefinitionContext.Builder()
      .withVersion("v1alpha1")
      .withScope("Namespaced")
      .withGroup("demo.k8s.io")
      .withPlural("podsets")
      .build();

    SharedInformerFactory sharedInformerFactory = client.informers();
    SharedIndexInformer<PodSet> podInformer = sharedInformerFactory.sharedIndexInformerForCustomResource(crdContext, PodSet.class, PodSetList.class, new OperationContext().withNamespace("ns1"), 1 * 60 * 1000);
    AtomicBoolean foundExistingPodSet = new AtomicBoolean(false);
    podInformer.addEventHandler(
      new ResourceEventHandler<PodSet>() {
        @Override
        public void onAdd(PodSet podSet) {
          if (podSet.getMetadata().getName().equalsIgnoreCase("podset1")) {
            foundExistingPodSet.set(true);
          }
        }

        @Override
        public void onUpdate(PodSet oldPodSet, PodSet newPodSet) { }

        @Override
        public void onDelete(PodSet podSet, boolean deletedFinalStateUnknown) { }
      });
    Thread.sleep(1000L);
    sharedInformerFactory.startAllRegisteredInformers();

    Thread.sleep(5000L);
    assertTrue(foundExistingPodSet.get());
    assertEquals(endResourceVersion, podInformer.lastSyncResourceVersion());

    sharedInformerFactory.stopAllRegisteredInformers();
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
}
