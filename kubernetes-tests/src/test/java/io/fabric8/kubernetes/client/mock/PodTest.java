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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
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
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.server.mock.OutputStreamMessage;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Response;
import okio.ByteString;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@EnableKubernetesMockClient
class PodTest {

  KubernetesMockServer server;

  @TempDir
  Path tempDir;

  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    client = server.createClient().inNamespace("test");
  }

  @Test
  void testList() {
   server.expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

   server.expect().withPath("/api/v1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

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
  void testListWithLabels() {
   server.expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new PodListBuilder().build()).always();
   server.expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

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
  void testListWithFields() {
   server.expect().withPath("/api/v1/namespaces/test/pods?fieldSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3!=value3,key3!=value4")).andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    PodList podList = client.pods()
      .withField("key1", "value1")
      .withField("key2","value2")
      .withoutField("key3","value3")
      .withoutField("key3", "value4")
      .list();

    assertNotNull(podList);
    assertEquals(2, podList.getItems().size());
  }


  @Test
  void testEditMissing() {
    // Given
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(404, "error message from kubernetes").always();

    // When
    PodResource<Pod> podOp = client.pods().withName("pod1");

    // Then
    Assertions.assertThrows(KubernetesClientException.class, () -> podOp.edit(p -> p));
  }

  @Test
  void testDelete() {
   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, new PodBuilder().build()).once();


    Boolean deleted = client.pods().withName("pod1").delete();
    assertTrue(deleted);

    deleted = client.pods().withName("pod2").delete();
    assertFalse(deleted);

    deleted = client.pods().inNamespace("ns1").withName("pod2").cascading(false).delete();
    assertTrue(deleted);
  }

  @Test
  void testDeleteMulti() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();

   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();
   server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).once();

    Boolean deleted = client.pods().inAnyNamespace().delete(pod1, pod2);
    assertTrue(deleted);

    deleted = client.pods().inAnyNamespace().delete(pod3);
    assertFalse(deleted);
  }

  @Test
  void testDeleteWithNamespaceMismatch() {
    // Given
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    // When + Then
    NonNamespaceOperation<Pod, PodList, PodResource<Pod>> podOp = client.pods().inNamespace("test1");
    Assertions.assertThrows(KubernetesClientException.class, () -> podOp.delete(pod1));
  }

  @Test
  void testDeleteWithPropagationPolicy() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();

    Boolean deleted = client.pods().inNamespace("test").withName("pod1").withPropagationPolicy(DeletionPropagation.FOREGROUND).delete();
    assertTrue(deleted);
  }

  @Test
  void testEvict() {
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1/eviction").andReturn(200, new PodBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod2/eviction").andReturn(200, new PodBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod3/eviction").andReturn(PodOperationsImpl.HTTP_TOO_MANY_REQUESTS, new PodBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod3/eviction").andReturn(200, new PodBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/pods/pod4/eviction").andReturn(500, new PodBuilder().build()).once();

    Boolean deleted = client.pods().withName("pod1").evict();
    assertTrue(deleted);

    // not found
    deleted = client.pods().withName("pod2").evict();
    assertFalse(deleted);

    deleted = client.pods().inNamespace("ns1").withName("pod2").evict();
    assertTrue(deleted);

    // too many requests
    deleted = client.pods().inNamespace("ns1").withName("pod3").evict();
    assertFalse(deleted);

    deleted = client.pods().inNamespace("ns1").withName("pod3").evict();
    assertTrue(deleted);

    // unhandled error
    PodResource<Pod> resource = client.pods().inNamespace("ns1").withName("pod4");
    assertThrows(KubernetesClientException.class, resource::evict);
  }

  @Test
  void testCreateWithNameMismatch() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();

    PodResource<Pod> podOp = client.pods().inNamespace("test1").withName("mypod1");
    Assertions.assertThrows(KubernetesClientException.class, () -> podOp.create(pod1));
  }

  @Test
  void testGetLog() {
    String pod1Log = "pod1Log";
    String pod2Log = "pod2Log";
    String pod3Log = "pod3Log";
    String pod4Log = "pod4Log";

   server.expect().withPath("/api/v1/namespaces/test/pods/pod1/log?pretty=true").andReturn(200, pod1Log).once();
   server.expect().withPath("/api/v1/namespaces/test/pods/pod2/log?pretty=false").andReturn(200, pod2Log).once();
   server.expect().withPath("/api/v1/namespaces/test/pods/pod3/log?pretty=false&container=cnt3").andReturn(200, pod3Log).once();
   server.expect().withPath("/api/v1/namespaces/test4/pods/pod4/log?pretty=true&container=cnt4").andReturn(200, pod4Log).once();
   server.expect().withPath("/api/v1/namespaces/test4/pods/pod1/log?pretty=false&limitBytes=100").andReturn(200, pod1Log).once();
   server.expect().withPath("/api/v1/namespaces/test5/pods/pod1/log?pretty=false&tailLines=1&timestamps=true").andReturn(200, pod1Log).once();

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

    log = client.pods().inNamespace("test5").withName("pod1").usingTimestamps().tailingLines(1).getLog();
    assertEquals(pod1Log, log);
  }

  @Test
  void testExec() throws InterruptedException {
    String expectedOutput = "file1 file2";
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1/exec?command=ls&stdout=true")
            .andUpgradeToWebSocket()
                .open(new OutputStreamMessage(expectedOutput))
                .done()
            .always();

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
    watch.close();
  }


  @Test
  void testWatch() throws InterruptedException {
    // Given
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
      .waitFor(50).andEmit(new WatchEvent(pod1, "DELETED"))
      .done()
      .always();
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    final Watcher<Pod> watcher = new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod resource) {
        if (action != Action.DELETED) {
          fail();
        }
        deleteLatch.countDown();
      }

      @Override
      public void onClose(WatcherException cause) {
      }
    };
    // When
    final Watch watch = client.pods().withName("pod1").watch(watcher);
    // Then
    assertTrue(deleteLatch.await(30, TimeUnit.SECONDS));
    watch.close();
  }


  @Test
  void testGetLogNotFound() {
    // Given
    PodResource<Pod> podOp = client.pods().withName("pod5");

    // When + Then
    Assertions.assertThrows(KubernetesClientException.class, () -> podOp.getLog(true));
  }

  @Test
  void testLoad() {
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod.yml")).get();
    assertEquals("nginx", pod.getMetadata().getName());
  }

  @Test
  void testWait() throws InterruptedException {
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


    Pod ready = new PodBuilder(notReady)
      .editMetadata()
      .withResourceVersion("2")
      .endMetadata()
      .withNewStatus()
      .addNewCondition()
      .withType("Ready")
      .withStatus("True")
      .endCondition()
      .endStatus()
      .build();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&watch=false").andReturn(200, notReady).once();

    server.expect().get().withPath("/api/v1/namespaces/test/pods?fieldSelector=metadata.name%3Dpod1&resourceVersion=1&watch=true").andUpgradeToWebSocket()
      .open()
      .waitFor(50).andEmit(new WatchEvent(ready, "MODIFIED"))
      .done()
      .always();

    Pod result = client.pods().withName("pod1").waitUntilReady(5, TimeUnit.SECONDS);
    Assert.assertEquals("2", result.getMetadata().getResourceVersion());
  }

  @Test
  void testPortForward() throws IOException {
    server.expect().withPath("/api/v1/namespaces/test/pods/pod1/portforward?ports=123")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(10).andEmit(portForwardEncode(true, "12")) // data channel info
      .waitFor(10).andEmit(portForwardEncode(false, "12")) // error channel info
      .waitFor(10).andEmit(portForwardEncode(true, "Hell"))
      .waitFor(10).andEmit(portForwardEncode(true, "o World"))
      .done()
      .once();

    try(
      LocalPortForward portForward = client.pods().withName("pod1").portForward(123);
      SocketChannel channel = SocketChannel.open()
    ) {
      int localPort = portForward.getLocalPort();
      assertTrue(channel.connect(new InetSocketAddress("localhost", localPort)));

      ByteBuffer buffer = ByteBuffer.allocate(1024);
      int read;
      do {
        try {
          read = channel.read(buffer);
        } catch (IOException io) {
          // On windows an exception is thrown when connection is reset during read
          // It can only be distinguished via message, and that message is localized
          // So let's at least handle English
          if (!io.getMessage().startsWith("An existing connection was forcibly closed")) {
            throw io;
          }
          read = -1;
        }
      } while(read >= 0);
      buffer.flip();
      channel.socket().close();
      assertEquals("Hello World", ByteString.of(buffer).utf8());
      assertFalse(portForward.errorOccurred());
      assertEquals(0, portForward.getClientThrowables().size());
      assertEquals(0, portForward.getServerThrowables().size());
    }
  }

  @Test
  void testPortForwardWithChannel() throws InterruptedException, IOException {

    server.expect().withPath("/api/v1/namespaces/test/pods/pod1/portforward?ports=123")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(10).andEmit(portForwardEncode(true, "12")) // data channel info
      .waitFor(10).andEmit(portForwardEncode(false, "12")) // error channel info
      .waitFor(10).andEmit(portForwardEncode(true, "Hell"))
      .waitFor(10).andEmit(portForwardEncode(true, "o World!"))
      .done()
      .once();

    ByteArrayInputStream in = new ByteArrayInputStream(new byte[0]);
    ReadableByteChannel inChannel = Channels.newChannel(in);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    WritableByteChannel outChannel = Channels.newChannel(out);

    try(PortForward portForward = client.pods().withName("pod1").portForward(123, inChannel, outChannel)) {
      while(portForward.isAlive()) {
        Thread.sleep(100);
      }
    }

    String got = new String(out.toByteArray(), StandardCharsets.UTF_8);
    assertEquals("Hello World!", got);
  }

  @Test
  void testOptionalUpload() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      client.pods().inNamespace("ns1").withName("pod2").dir("/etc/hosts/dir").upload(tempDir.toAbsolutePath());
    });
  }

  @Test
  void testOptionalCopy() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      client.pods().inNamespace("ns1").withName("pod2").file("/etc/hosts").copy(tempDir.toAbsolutePath());
    });
  }

  @Test
  void testOptionalCopyDir() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      client.pods().inNamespace("ns1").withName("pod2").dir("/etc/hosts").copy(tempDir.toAbsolutePath());
    });
  }

  @Test
  void testListFromServer() {
    PodBuilder podBuilder = new PodBuilder()
      .withNewMetadata()
        .withNamespace("test")
        .withName("pod1")
      .endMetadata();

    Pod clientPod = podBuilder.build();
    Pod serverPod = podBuilder
      .editMetadata()
        .withResourceVersion("1")
      .endMetadata()
      .withNewStatus()
        .addNewCondition()
          .withType("Ready")
          .withStatus("True")
        .endCondition()
      .endStatus()
      .build();

    server.expect().get()
      .withPath("/api/v1/namespaces/test/pods/pod1")
      .andReturn(200, serverPod).once();

    List<HasMetadata> resources = client.resourceList(clientPod).fromServer().get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));
    assertTrue(resources.get(0) instanceof Pod);

    Pod fromServerPod = (Pod) resources.get(0);
    assertNotNull(fromServerPod.getMetadata());
    assertEquals("1", fromServerPod.getMetadata().getResourceVersion());
    assertNotNull(fromServerPod.getStatus());
    assertNotNull(fromServerPod.getStatus().getConditions());
    assertEquals(1, fromServerPod.getStatus().getConditions().size());
    assertEquals("Ready", fromServerPod.getStatus().getConditions().get(0).getType());
    assertEquals("True", fromServerPod.getStatus().getConditions().get(0).getStatus());
  }

  private static String portForwardEncode(boolean dataChannel, String str) {
    try {
      byte[] data = str.getBytes(StandardCharsets.UTF_8);
      byte[] msg = new byte[data.length + 1];
      System.arraycopy(data, 0, msg, 1, data.length);
      msg[0] = dataChannel ? (byte) 0 : (byte) 1;
      return new String(msg, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
