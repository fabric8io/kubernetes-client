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
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(https = false)
class InformTest {

  private static final Long EVENT_WAIT_PERIOD_MS = 10L;

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testInformPodWithLabel() throws InterruptedException {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
        .withResourceVersion("1").endMetadata().build();

    server.expect()
        .withPath("/api/v1/namespaces/test/pods?watch=false&labelSelector=my-label")
        .andReturn(HttpURLConnection.HTTP_OK,
            new PodListBuilder().withNewMetadata().withResourceVersion("1").endMetadata().withItems(pod1).build())
        .once();

    server.expect()
        .withPath("/api/v1/namespaces/test/pods?labelSelector=my-label&resourceVersion=1&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "DELETED"))
        .done()
        .once();
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(1);
    final ResourceEventHandler<Pod> handler = new ResourceEventHandler<Pod>() {

      @Override
      public void onAdd(Pod obj) {
        addLatch.countDown();
      }

      @Override
      public void onDelete(Pod obj, boolean deletedFinalStateUnknown) {
        deleteLatch.countDown();
      }

      @Override
      public void onUpdate(Pod oldObj, Pod newObj) {

      }

    };
    // When
    SharedIndexInformer<Pod> informer = client.pods().withLabel("my-label").inform(handler);

    assertTrue(deleteLatch.await(10, TimeUnit.SECONDS));
    assertTrue(addLatch.await(10, TimeUnit.SECONDS));

    informer.stop();
  }

  @Test
  void testInformGeneric() throws InterruptedException {
    // Given
    GenericKubernetesResource dummy = new GenericKubernetesResource();
    dummy.setMetadata(new ObjectMetaBuilder().withName("one").withNamespace("test").build());
    dummy.setKind("dummy");
    dummy.setApiVersion("demos.fabric8.io/v1");
    GenericKubernetesResourceList list = new GenericKubernetesResourceList();
    list.setMetadata(new ListMetaBuilder().withResourceVersion("1").build());
    list.setItems(Arrays.asList(dummy));

    server.expect()
        .withPath("/apis/demos.fabric8.io/v1/namespaces/test/dummies?watch=false&labelSelector=my-label")
        .andReturn(HttpURLConnection.HTTP_OK, list)
        .once();

    server.expect()
        .withPath("/apis/demos.fabric8.io/v1/namespaces/test/dummies?labelSelector=my-label&resourceVersion=1&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(dummy, "DELETED"))
        .done()
        .once();
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(1);
    final ResourceEventHandler<GenericKubernetesResource> handler = new ResourceEventHandler<GenericKubernetesResource>() {

      @Override
      public void onAdd(GenericKubernetesResource obj) {
        addLatch.countDown();
      }

      @Override
      public void onDelete(GenericKubernetesResource obj, boolean deletedFinalStateUnknown) {
        deleteLatch.countDown();
      }

      @Override
      public void onUpdate(GenericKubernetesResource oldObj, GenericKubernetesResource newObj) {

      }

    };

    // When
    CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
        .withKind("Dummy")
        .withScope("Namespaced")
        .withVersion("v1")
        .withGroup("demos.fabric8.io")
        .withPlural("dummies")
        .build();

    SharedIndexInformer<GenericKubernetesResource> informer =
        client.genericKubernetesResources(context).withLabel("my-label").inform(handler);

    assertTrue(deleteLatch.await(10, TimeUnit.SECONDS));
    assertTrue(addLatch.await(10, TimeUnit.SECONDS));

    informer.stop();
  }

  /**
   * Checks that even if there is a registered deserializer for the type, that it will still be treated as a generic
   */
  @Test
  void testGenericWithKnownType() throws InterruptedException {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withNamespace("test").withName("pod1")
        .withResourceVersion("1").endMetadata().build();

    server.expect()
        .withPath("/api/v1/namespaces/test/pods?watch=false&fieldSelector=metadata.name%3Dpod1")
        .andReturn(HttpURLConnection.HTTP_OK,
            new PodListBuilder().withNewMetadata().withResourceVersion("1").endMetadata().withItems(pod1).build())
        .once();

    server.expect()
        .withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1%2Cmetadata.name%3Dpod1&resourceVersion=1&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(EVENT_WAIT_PERIOD_MS)
        .andEmit(new WatchEvent(pod1, "DELETED"))
        .done()
        .once();

    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final CountDownLatch addLatch = new CountDownLatch(1);
    final ResourceEventHandler<GenericKubernetesResource> handler = new ResourceEventHandler<GenericKubernetesResource>() {

      @Override
      public void onAdd(GenericKubernetesResource obj) {
        addLatch.countDown();
      }

      @Override
      public void onDelete(GenericKubernetesResource obj, boolean deletedFinalStateUnknown) {
        deleteLatch.countDown();
      }

      @Override
      public void onUpdate(GenericKubernetesResource oldObj, GenericKubernetesResource newObj) {

      }

    };

    // When
    CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
        .withKind("Pod")
        .withScope("Namespaced")
        .withVersion("v1")
        .withPlural("pods")
        .build();

    SharedIndexInformer<GenericKubernetesResource> informer =
        client.genericKubernetesResources(context).withName("pod1").inform(handler);

    assertTrue(deleteLatch.await(1000, TimeUnit.SECONDS));
    assertTrue(addLatch.await(1000, TimeUnit.SECONDS));

    informer.stop();
  }

}
