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

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;

import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.server.mock.OutputStreamMessage;

import okhttp3.Response;
import okio.ByteString;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PodTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
   server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

   server.expect().withPath("/api/v1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    KubernetesClient client = server.getClient();
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
   server.expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new PodListBuilder().build()).always();
   server.expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
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


  @Test(expected = KubernetesClientException.class)
  public void testEditMissing() {
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(404, "error message from kubernetes").always();
    KubernetesClient client = server.getClient();

    client.pods().withName("pod1").edit();
  }

  @Test
  public void testDelete() {
   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, new PodBuilder().build()).once();

    KubernetesClient client = server.getClient();

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

   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).once();

    KubernetesClient client = server.getClient();

    Boolean deleted = client.pods().inAnyNamespace().delete(pod1, pod2);
    assertNotNull(deleted);

    deleted = client.pods().inAnyNamespace().delete(pod3);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    KubernetesClient client = server.getClient();

    Boolean deleted = client.pods().inNamespace("test1").delete(pod1);
    assertNotNull(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    KubernetesClient client = server.getClient();

    client.pods().inNamespace("test1").withName("mypod1").create(pod1);
  }

  @Test
  public void testGetLog() {
    String pod1Log = "pod1Log";
    String pod2Log = "pod2Log";
    String pod3Log = "pod3Log";
    String pod4Log = "pod4Log";

   server.expect().withPath("/api/v1/namespaces/test/pods/pod1/log?pretty=true").andReturn(200, pod1Log).once();
   server.expect().withPath("/api/v1/namespaces/test/pods/pod2/log?pretty=false").andReturn(200, pod2Log).once();
   server.expect().withPath("/api/v1/namespaces/test/pods/pod3/log?pretty=false&container=cnt3").andReturn(200, pod3Log).once();
   server.expect().withPath("/api/v1/namespaces/test4/pods/pod4/log?pretty=true&container=cnt4").andReturn(200, pod4Log).once();
   server.expect().withPath("/api/v1/namespaces/test4/pods/pod1/log?pretty=false&limitBytes=100").andReturn(200, pod1Log).once();

    KubernetesClient client = server.getClient();

    String log = client.pods().withName("pod1").getLog(true);
    assertEquals(pod1Log, log);

    log = client.pods().withName("pod2").getLog(false);
    assertEquals(pod2Log, log);

    log = client.pods().withName("pod3").inContainer("cnt3").getLog();
    assertEquals(pod3Log, log);

    log = client.pods().inNamespace("test4").withName("pod4").inContainer("cnt4").withPrettyOutput().getLog();
    assertEquals(pod4Log, log);

    log = client.pods().inNamespace("test4").withName("pod1").limitBytes(100).getLog();
    assertEquals(pod1Log, log);
  }

  @Test
  public void testExec() throws InterruptedException {
    String expectedOutput = "file1 file2";
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1/exec?command=ls&stdout=true")
            .andUpgradeToWebSocket()
                .open(new OutputStreamMessage(expectedOutput))
                .done()
            .always();

    KubernetesClient client = server.getClient();

    final CountDownLatch execLatch = new CountDownLatch(1);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ExecWatch watch = client.pods().withName("pod1").writingOutput(baos).usingListener(new ExecListener() {
      @Override
      public void onOpen(Response response) {
      }

      @Override
      public void onFailure(Throwable t , Response response) {
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

   server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder()
            .withNewMetadata()
                .withResourceVersion("1")
            .endMetadata()
            .addToItems(pod1)
            .build()
    ).once();

   server.expect().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true")
            .andUpgradeToWebSocket()
            .open()
            .waitFor(15000).andEmit(new WatchEvent(pod1, "DELETED"))
            .done()
            .always();

    KubernetesClient client = server.getClient();

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
    KubernetesClient client = server.getClient();
    client.pods().withName("pod5").getLog(true);
  }

  @Test
  public void testLoad() {
    KubernetesClient client = server.getClient();
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod.yml")).get();
    assertEquals("nginx", pod.getMetadata().getName());
  }

  @Test
  public void testWait() throws InterruptedException {
    Pod notReady = new PodBuilder()
      .withNewMetadata()
      .withName("pod1")
      .withResourceVersion("1")
      .withNamespace("test")
      .endMetadata()
      .withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus("False")
      .endCondition()
      .endStatus()
      .build();


    Pod ready = new PodBuilder()
      .withNewMetadata()
      .withName("pod1")
      .withResourceVersion("2")
      .withNamespace("test")
      .endMetadata()
      .withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus("True")
      .endCondition()
      .endStatus()
      .build();

    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, notReady).once();
    server.expect().get().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, ready).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder()
      .withNewMetadata()
      .withResourceVersion("1")
      .endMetadata()
      .withItems(notReady).build()).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(1000).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .always();

    KubernetesClient client = server.getClient();
    Pod result = client.pods().withName("pod1").waitUntilReady(5, TimeUnit.SECONDS);
    Assert.assertEquals("2", result.getMetadata().getResourceVersion());
  }

  @Test
  public void testPortForward() throws IOException {

    server.expect().withPath("/api/v1/namespaces/test/pods/pod1/portforward?ports=123")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(10).andEmit(portForwardEncode(true, "12")) // data channel info
      .waitFor(10).andEmit(portForwardEncode(false, "12")) // error channel info
      .waitFor(10).andEmit(portForwardEncode(true, "Hell"))
      .waitFor(10).andEmit(portForwardEncode(true, "o World"))
      .done()
      .once();

    KubernetesClient client = server.getClient();

    try(LocalPortForward portForward = client.pods().withName("pod1").portForward(123)) {
      int localPort = portForward.getLocalPort();
      SocketChannel channel = SocketChannel.open();
      assertTrue(channel.connect(new InetSocketAddress("localhost", localPort)));

      ByteBuffer buffer = ByteBuffer.allocate(1024);
      int read;
      do {
        read = channel.read(buffer);
      } while(read >= 0);
      buffer.flip();
      String data = ByteString.of(buffer).utf8();
      assertEquals("Hello World", data);
    }

  }

  @Test
  public void testPortForwardWithChannel() throws InterruptedException, IOException {

    server.expect().withPath("/api/v1/namespaces/test/pods/pod1/portforward?ports=123")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(10).andEmit(portForwardEncode(true, "12")) // data channel info
      .waitFor(10).andEmit(portForwardEncode(false, "12")) // error channel info
      .waitFor(10).andEmit(portForwardEncode(true, "Hell"))
      .waitFor(10).andEmit(portForwardEncode(true, "o World!"))
      .done()
      .once();

    KubernetesClient client = server.getClient();

    ByteArrayInputStream in = new ByteArrayInputStream(new byte[0]);
    ReadableByteChannel inChannel = Channels.newChannel(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    WritableByteChannel outChannel = Channels.newChannel(out);

    try(PortForward portForward = client.pods().withName("pod1").portForward(123, inChannel, outChannel)) {
      while(portForward.isAlive()) {
        Thread.sleep(100);
      }
    }

    String got = new String(out.toByteArray(), "UTF-8");
    assertEquals("Hello World!", got);
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

  private static String portForwardEncode(boolean dataChannel, String str) {
    try {
      byte[] data = str.getBytes("UTF-8");
      byte[] msg = new byte[data.length + 1];
      System.arraycopy(data, 0, msg, 1, data.length);
      msg[0] = dataChannel ? (byte) 0 : (byte) 1;
      return new String(msg, "UTF-8");
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

}
