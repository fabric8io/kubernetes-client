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

import com.squareup.okhttp.Response;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.server.mock.OutputStreamMessage;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PodTest extends KubernetesMockServerTestBase {

  @Test
  public void testList() {
    expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
    expect().withPath("/api/v1/namespaces/ns1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    expect().withPath("/api/v1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    KubernetesClient client = getClient();
    PodList podList = client.pods().list();
    assertNotNull(podList);
    assertEquals(0, podList.getItems().size());

    podList = client.pods().inNamespace("ns1").list();
    assertNotNull(podList);
    assertEquals(2, podList.getItems().size());

    podList = client.pods().inAnyNamespace().list();
    assertNotNull(podList);
    assertEquals(3, podList.getItems().size());
  }

  @Test
  public void testListWithLables() {
    expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new PodListBuilder().build()).always();
    expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = getClient();
    PodList podList = client.pods()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();


    assertNotNull(podList);
    assertEquals(0, podList.getItems().size());

    podList = client.pods()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .list();

    assertNotNull(podList);
    assertEquals(3, podList.getItems().size());
  }



  @Test
  public void testDelete() {
    expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();
    expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, new PodBuilder().build()).once();

    KubernetesClient client = getClient();

    Boolean deleted = client.pods().withName("pod1").delete();
    assertNotNull(deleted);

    deleted = client.pods().withName("pod2").delete();
    assertFalse(deleted);

    deleted = client.pods().inNamespace("ns1").withName("pod2").cascading(false).delete();
    assertTrue(deleted);
  }


  @Test
  public void testDeleteMulti() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();

    expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();
    expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).once();

    KubernetesClient client = getClient();

    Boolean deleted = client.pods().inAnyNamespace().delete(pod1, pod2);
    assertNotNull(deleted);

    deleted = client.pods().inAnyNamespace().delete(pod3);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    KubernetesClient client = getClient();

    Boolean deleted = client.pods().inNamespace("test1").delete(pod1);
    assertNotNull(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    KubernetesClient client = getClient();

    client.pods().inNamespace("test1").withName("mypod1").create(pod1);
  }

  @Test
  public void testGetLog() {
    String pod1Log = "pod1Log";
    String pod2Log = "pod2Log";
    String pod3Log = "pod3Log";
    String pod4Log = "pod4Log";

    expect().withPath("/api/v1/namespaces/test/pods/pod1/log?pretty=true").andReturn(200, pod1Log).once();
    expect().withPath("/api/v1/namespaces/test/pods/pod2/log?pretty=false").andReturn(200, pod2Log).once();
    expect().withPath("/api/v1/namespaces/test/pods/pod3/log?pretty=false&container=cnt3").andReturn(200, pod3Log).once();
    expect().withPath("/api/v1/namespaces/test4/pods/pod4/log?pretty=true&container=cnt4").andReturn(200, pod4Log).once();

    KubernetesClient client = getClient();

    String log = client.pods().withName("pod1").getLog(true);
    assertEquals(pod1Log, log);

    log = client.pods().withName("pod2").getLog(false);
    assertEquals(pod2Log, log);

    log = client.pods().withName("pod3").getLog("cnt3", false);
    assertEquals(pod3Log, log);

    log = client.pods().inNamespace("test4").withName("pod4").getLog("cnt4", true);
    assertEquals(pod4Log, log);
  }

  @Test
  public void testExec() throws InterruptedException {
    String expectedOutput = "file1 file2";
    expect().withPath("/api/v1/namespaces/test/pods/pod1/exec?command=ls&tty=true&stdout=true")
            .andUpgradeToWebSocket()
                .open(new OutputStreamMessage(expectedOutput))
                .done()
            .always();

    KubernetesClient client = getClient();

    final CountDownLatch execLatch = new CountDownLatch(1);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ExecWatch watch = client.pods().withName("pod1").writingOutput(baos).usingListener(new ExecListener() {
      @Override
      public void onOpen(Response response) {
      }

      @Override
      public void onFailure(IOException e, Response response) {
        execLatch.countDown();
      }

      @Override
      public void onClose(int code, String reason) {
        execLatch.countDown();
      }
    }).exec("ls");

    execLatch.await(10, TimeUnit.MINUTES);
    assertNotNull(watch);
    assertEquals(expectedOutput, baos.toString());
  }



  @Test
  public void testWatch() throws InterruptedException {
    //We start with a list
    Pod pod1 = new PodBuilder()
            .withNewMetadata()
            .withName("pod1")
            .withResourceVersion("1")
            .endMetadata()
            .build();

    expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder()
            .withNewMetadata()
                .withResourceVersion("1")
            .endMetadata()
            .addToItems(pod1)
            .build()
    ).once();

    expect().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true")
            .andUpgradeToWebSocket()
            .open()
            .waitFor(15000).andEmit(new WatchEvent(pod1, "DELETED"))
            .done()
            .always();

    KubernetesClient client = getClient();

    final CountDownLatch deleteLatch = new CountDownLatch(1);
    Watch watch = client.pods().withName("pod1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        switch (action) {
          case DELETED:
            deleteLatch.countDown();
        }
      }

      @Override
      public void onClose(KubernetesClientException cause) {

      }
    });

    assertTrue(deleteLatch.await(10, TimeUnit.MINUTES));
  }


  @Test(expected = KubernetesClientException.class)
  public void testGetLogNotFound() {
    KubernetesClient client = getClient();
    client.pods().withName("pod5").getLog(true);
  }

  @Test
  public void testLoad() {
    KubernetesClient client = getClient();
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod.yml")).get();
    assertEquals("nginx", pod.getMetadata().getName());
  }

  /**
   * Converts string to URL encoded string.
   * It's not a fullblown converter, it serves just the purpose of this test.
   * @param str
   * @return
   */
  private static final String toUrlEncoded(String str) {
    return str.replaceAll("=", "%3D");
  }
}
