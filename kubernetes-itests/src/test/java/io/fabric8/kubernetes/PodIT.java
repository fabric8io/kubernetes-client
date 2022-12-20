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

package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/pod-it.yml")
class PodIT {

  private static final int POD_READY_WAIT_IN_MILLIS = 60000;

  private static final Logger logger = LoggerFactory.getLogger(PodIT.class);

  KubernetesClient client;

  Namespace namespace;

  @Test
  void load() {
    Pod aPod = client.pods().load(getClass().getResourceAsStream("/test-pod.yml")).item();
    assertThat(aPod).isNotNull();
    assertEquals("nginx", aPod.getMetadata().getName());
  }

  @Test
  void get() {
    Pod pod1 = client.pods().withName("pod-standard").get();
    assertNotNull(pod1);
  }

  @Test
  void list() {
    PodList podList = client.pods().list();
    assertThat(podList).isNotNull();
    assertTrue(podList.getItems().size() >= 1);
  }

  @Test
  void update() {
    Pod pod1 = client.pods().withName("pod-standard").edit(p -> new PodBuilder(p)
        .editMetadata().addToLabels("foo", "bar").endMetadata().build());
    assertEquals("bar", pod1.getMetadata().getLabels().get("foo"));
  }

  @Test
  void delete() {
    assertTrue(client.pods().withName("pod-delete").delete().size() == 1);
  }

  @Test
  void log() {
    String log = client.pods().withName("pod-standard").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).getLog();
    assertNotNull(log);
  }

  @Test
  void exec() throws Exception {
    final CountDownLatch execLatch = new CountDownLatch(1);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    final AtomicBoolean closed = new AtomicBoolean();
    final AtomicBoolean failed = new AtomicBoolean();
    final CompletableFuture<Status> exitStatus = new CompletableFuture<>();
    int[] exitCode = new int[] { Integer.MAX_VALUE };
    client.pods().withName("pod-standard")
        .writingOutput(out)
        .usingListener(new ExecListener() {
          @Override
          public void onOpen() {
            logger.info("Shell was opened");
          }

          @Override
          public void onFailure(Throwable t, Response failureResponse) {
            logger.info("Shell barfed");
            failed.set(true);
            execLatch.countDown();
          }

          @Override
          public void onClose(int i, String s) {
            logger.info("Shell closed");
            closed.set(true);
            execLatch.countDown();
          }

          @Override
          public void onExit(int code, Status status) {
            exitCode[0] = code;
            exitStatus.complete(status);
          }
        }).withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).exec("sh", "-c", "echo 'hello world!'");
    assertThat(exitStatus.get(5, TimeUnit.SECONDS))
        .hasFieldOrPropertyWithValue("status", "Success");
    assertTrue(execLatch.await(5, TimeUnit.SECONDS));
    assertEquals(0, exitCode[0]);
    assertTrue(closed.get());
    assertFalse(failed.get());
    assertNotNull(out.toString());
  }

  @Test
  void execExitCode() throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ExecWatch watch = client.pods().withName("pod-standard")
        .writingOutput(out)
        .withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
        .exec("sh", "-c", "echo 'hello world!'");
    assertEquals(0, watch.exitCode().join());
    assertNotNull("hello world!", out.toString());
  }

  @Test
  void execInteractiveShell() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ExecWatch watch = client.pods().withName("pod-standard")
        .redirectingInput()
        .redirectingOutput()
        .redirectingError()
        .withTTY()
        .withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
        .exec("sh", "-i");

    InputStreamPumper.pump(watch.getOutput(), baos::write, Executors.newSingleThreadExecutor());

    watch.getInput().write("whoami\n".getBytes(StandardCharsets.UTF_8));
    watch.getInput().flush();

    Awaitility.await().atMost(30, TimeUnit.SECONDS).until(() -> {
      return new String(baos.toByteArray(), StandardCharsets.UTF_8).contains("root");
    });

    watch.close();

    // no error is expected
    assertEquals(-1, watch.getError().read());
  }

  @Test
  void attach() throws Exception {
    CountDownLatch latch = new CountDownLatch(1);
    ByteArrayOutputStream stdout = new ByteArrayOutputStream();
    AtomicBoolean closed = new AtomicBoolean();
    AtomicBoolean failed = new AtomicBoolean();

    ExecWatch watch = client.pods().withName("pod-interactive")
        .redirectingInput()
        .redirectingOutput()
        .redirectingError()
        .withTTY()
        .usingListener(new ExecListener() {
          @Override
          public void onFailure(Throwable t, Response failureResponse) {
            failed.set(true);
            latch.countDown();
          }

          @Override
          public void onClose(int i, String s) {
            closed.set(true);
            latch.countDown();
          }
        })
        .withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
        .attach();

    watch.getInput().write("whoami\n".getBytes(StandardCharsets.UTF_8));
    watch.getInput().flush();

    InputStreamPumper.pump(watch.getOutput(), stdout::write, Executors.newSingleThreadExecutor());

    Awaitility.await().atMost(30, TimeUnit.SECONDS)
        .until(() -> stdout.toString().contains("root"));

    watch.close();

    assertTrue(latch.await(5, TimeUnit.SECONDS));
    assertTrue(closed.get());
    assertFalse(failed.get());

    // make sure we can get log output before the pod terminates
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    LogWatch log = client.pods().withName("pod-interactive").tailingLines(10).watchLog(result);
    Awaitility.await().atMost(30, TimeUnit.SECONDS).until(() -> result.size() > 0);
    log.close();
  }

  @Test
  void readFile() throws IOException {
    try (
        ExecWatch ignore = client.pods().withName("pod-standard").writingOutput(System.out)
            .withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
            .exec("sh", "-c",
                "echo 'hello' > /msg");
        InputStream is = client.pods().withName("pod-standard").file("/msg").read()) {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
      assertEquals("hello", result);
    }
  }

  @Test
  void readFileEscapedParams() throws IOException {
    try (
        ExecWatch watch = client.pods().withName("pod-standard").writingOutput(System.out)
            .withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
            .exec("sh", "-c",
                "echo 'H$ll* (W&RLD}' > /msg");
        InputStream is = client.pods().withName("pod-standard").file("/msg").read()) {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
      assertEquals("H$ll* (W&RLD}", result);
    }
  }

  @Test
  void uploadFile() throws IOException {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_MILLIS, TimeUnit.SECONDS);
    // Wait for resources to get ready
    final Path tmpFile = Files.createTempFile("PodIT", "toBeUploaded");
    Files.write(tmpFile, Collections.singletonList("I'm uploaded"));

    assertUploaded("pod-standard", tmpFile, "/tmp/toBeUploaded");
    assertUploaded("pod-standard", tmpFile, "/tmp/001_special_!@#\\$^&(.mp4");
    assertUploaded("pod-standard", tmpFile, "/tmp/002'special");
  }

  private void assertUploaded(String podName, final Path tmpFile, String filename) throws IOException {
    PodResource podResource = client.pods().withName(podName);

    podResource.file(filename).upload(tmpFile);

    try (InputStream checkIs = podResource.file(filename).read();
        BufferedReader br = new BufferedReader(new InputStreamReader(checkIs, StandardCharsets.UTF_8))) {
      String result = br.lines().collect(Collectors.joining(System.lineSeparator()));
      assertEquals("I'm uploaded", result);
    }
  }

  @Test
  void uploadDir() throws IOException {
    final String[] files = new String[] { "1", "2", "a", "b", "c" };
    final Path tmpDir = Files.createTempDirectory("uploadDir");
    for (String fileName : files) {
      Path file = tmpDir.resolve(fileName);
      Files.write(Files.createFile(file), Arrays.asList("I'm uploaded", fileName));
    }

    PodResource podResource = client.pods().withName("pod-standard");

    podResource.dir("/tmp/uploadDir").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).upload(tmpDir);

    for (String fileName : files) {
      try (InputStream checkIs = podResource.file("/tmp/uploadDir/" + fileName).read();
          BufferedReader br = new BufferedReader(new InputStreamReader(checkIs, StandardCharsets.UTF_8))) {
        String result = br.lines().collect(Collectors.joining(System.lineSeparator()));
        assertEquals("I'm uploaded" + System.lineSeparator() + fileName, result);
      }
    }
  }

  @Test
  void copyDir() throws IOException {
    final Path tmpDir = Files.createTempDirectory("copyFile");

    PodResource podResource = client.pods().withName("pod-standard");
    podResource.dir("/etc").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).copy(tmpDir);

    Path msg = tmpDir.resolve("/etc/hosts");
    assertTrue(Files.exists(msg));
  }

  @Test
  void copyFile() throws IOException {
    final Path tmpDir = Files.createTempDirectory("copyFile");

    PodResource podResource = client.pods().withName("pod-standard");
    podResource.writingOutput(System.out).withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).exec("sh", "-c",
        "echo 'hello' > /msg.txt");
    podResource.file("/msg.txt").copy(tmpDir);

    Path msg = tmpDir.resolve("msg.txt");
    assertTrue(Files.exists(msg));

    try (InputStream is = Files.newInputStream(msg);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
      String result = br.lines().collect(Collectors.joining(System.lineSeparator()));
      assertEquals("hello", result);
    }
  }

  @Test
  void listFromServer() {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_MILLIS, TimeUnit.SECONDS);
    final Pod pod1 = client.pods().withName("pod-standard").get();
    List<HasMetadata> resources = client.resourceList(pod1).get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));

    HasMetadata fromServerPod = resources.get(0);

    assertEquals(pod1.getKind(), fromServerPod.getKind());
    assertEquals(namespace.getMetadata().getName(), fromServerPod.getMetadata().getNamespace());
    assertEquals(pod1.getMetadata().getName(), fromServerPod.getMetadata().getName());
  }

}
