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
import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/pod-it.yml")
class PodIT {

  private static final int POD_READY_WAIT_IN_MILLIS = 60000;
  private static final Logger logger = LoggerFactory.getLogger(PodIT.class);

  private ExecutorService executorService;

  @TempDir
  Path tempDir;

  KubernetesClient client;

  Namespace namespace;

  @BeforeEach
  void prepare() {
    executorService = Executors.newSingleThreadExecutor(Utils.daemonThreadFactory(this));
  }

  @AfterEach
  void tearDown() {
    executorService.shutdownNow();
  }

  @Test
  void load() {
    Pod aPod = client.pods().load(getClass().getResourceAsStream("/test-pod.yml")).item();
    assertThat(aPod)
        .isNotNull()
        .extracting("metadata.name")
        .isEqualTo("nginx");
  }

  @Test
  void get() {
    Pod pod1 = client.pods().withName("pod-standard").get();
    assertNotNull(pod1);
  }

  @Test
  void list() {
    PodList podList = client.pods().list();
    assertThat(podList)
        .isNotNull()
        .extracting(PodList::getItems)
        .asList().hasSizeGreaterThanOrEqualTo(1);
  }

  @Test
  void update() {
    Pod pod1 = client.pods().withName("pod-standard").edit(p -> new PodBuilder(p)
        .editMetadata().withResourceVersion(null).addToLabels("foo", "bar").endMetadata().build());
    assertEquals("bar", pod1.getMetadata().getLabels().get("foo"));
  }

  @Test
  void delete() {
    assertEquals(1, client.pods().withName("pod-delete").delete().size());
  }

  @Test
  void log() {
    String log = client.pods().withName("pod-standard").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).getLog();
    assertNotNull(log);
  }

  @Test
  void logWatch() throws IOException {
    try (
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        LogWatch ignore = client.pods().withName("pod-standard").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
            .watchLog(baos)) {
      await()
          .atMost(15, TimeUnit.SECONDS)
          .until(() -> baos.toString(Charset.defaultCharset().name()).startsWith("1\n"));
    }
  }

  @Test
  void logWatchLongerThanDefaultTimeout() throws IOException {
    final long startTime = System.currentTimeMillis();
    try (
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        LogWatch ignore = client.pods().withName("pod-standard").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
            .watchLog(baos)) {
      await()
          .atMost(60, TimeUnit.SECONDS)
          .until(() -> baos.toString(Charset.defaultCharset().name()).startsWith("1\n2\n3\n"));
      assertThat(System.currentTimeMillis() - startTime).isGreaterThanOrEqualTo(10000);
    }
  }

  @Test
  void logWatchWithoutNewLogsLongerThanDefaultTimeout() throws IOException {
    final long startTime = System.currentTimeMillis();
    final ContainerResource container = client.pods().withName("nginx").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS);
    try (
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        LogWatch ignore = container.watchLog(baos)) {
      final String initialLog = container.getLog();
      await()
          .pollDelay(Duration.ofSeconds(15))
          .atMost(Duration.ofSeconds(30))
          .until(() -> initialLog.equals(baos.toString(StandardCharsets.UTF_8.name())));
      assertThat(System.currentTimeMillis() - startTime).isGreaterThanOrEqualTo(10000);
    }
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
  void execExitCode() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ExecWatch watch = client.pods().withName("pod-standard")
        .writingOutput(out)
        .withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS)
        .exec("sh", "-c", "echo 'hello world!'");
    assertEquals(0, watch.exitCode().join());
    assertThat(out.toString()).startsWith("hello world!");
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

    InputStreamPumper.pump(watch.getOutput(), baos::write, executorService);

    watch.getInput().write("whoami\n".getBytes(StandardCharsets.UTF_8));
    watch.getInput().flush();

    await().atMost(30, TimeUnit.SECONDS)
        .until(() -> new String(baos.toByteArray(), StandardCharsets.UTF_8).contains("root"));

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

    InputStreamPumper.pump(watch.getOutput(), stdout::write, executorService);

    await().atMost(30, TimeUnit.SECONDS)
        .until(() -> stdout.toString().contains("root"));

    watch.close();

    assertTrue(latch.await(5, TimeUnit.SECONDS));
    assertTrue(closed.get());
    assertFalse(failed.get());

    // make sure we can get log output before the pod terminates
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    LogWatch log = client.pods().withName("pod-interactive").tailingLines(10).watchLog(result);
    await().atMost(30, TimeUnit.SECONDS).until(() -> result.size() > 0);
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

  @ParameterizedTest(name = "upload, with valid file to ''{0}'', should create file with contents")
  @ValueSource(strings = {
      "/tmp/toBeUploaded",
      "/tmp/001_special_!@#\\$^&(.mp4",
      "/tmp/002'special"
  })
  void uploadFile(String uploadPath) throws IOException {
    // Given
    final Path tempFile = Files.write(tempDir.resolve("file.toBeUploaded"),
        Collections.singletonList("I'm uploaded"));
    final PodResource podResource = client.pods().withName("pod-standard");
    podResource.waitUntilReady(POD_READY_WAIT_IN_MILLIS, TimeUnit.SECONDS);
    // When
    retryUpload(() -> podResource.file(uploadPath).upload(tempFile));

    try (InputStream checkIs = podResource.file(uploadPath).read();
        BufferedReader br = new BufferedReader(new InputStreamReader(checkIs, StandardCharsets.UTF_8))) {
      String result = br.lines().collect(Collectors.joining(System.lineSeparator()));
      assertEquals("I'm uploaded", result, () -> checkFile(podResource, null, uploadPath));
    }
  }

  void retryUpload(BooleanSupplier operation) {
    await().atMost(60, TimeUnit.SECONDS).until(operation::getAsBoolean);
  }

  @Test
  void uploadBinaryStream() throws Exception {
    byte[] bytes = new byte[16385];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) i;
    }
    final PodResource podResource = client.pods().withName("pod-standard");
    // When
    retryUpload(() -> podResource.file("/tmp/binstream").upload(new ByteArrayInputStream(bytes)));
    // Then
    try (InputStream checkIs = podResource.file("/tmp/binstream").read();) {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      InputStreamPumper.transferTo(checkIs, baos::write);
      assertArrayEquals(bytes, baos.toByteArray(), () -> checkFile(podResource, null, "/tmp/binstream"));
    }
  }

  @Test
  void uploadBinaryFile() throws IOException {
    // Given
    byte[] bytes = new byte[16385];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) i;
    }
    final Path tempFile = Files.write(tempDir.resolve("file.toBeUploaded"), bytes);
    final PodResource podResource = client.pods().withName("pod-standard");
    // When
    retryUpload(() -> podResource.file("/tmp/binfile").upload(tempFile));
    // Then
    try (InputStream checkIs = podResource.file("/tmp/binfile").read();) {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      InputStreamPumper.transferTo(checkIs, baos::write);
      assertArrayEquals(bytes, baos.toByteArray(), () -> checkFile(podResource, null, "/tmp/binfile"));
    }
  }

  @Test
  void uploadDir(@TempDir Path toUpload) throws Exception {
    // Given
    final String[] files = new String[] { "1", "2", "a", "b", "c" };
    final Path nestedDir = Files.createDirectory(toUpload.resolve("nested"));
    for (Path path : new Path[] { toUpload, nestedDir }) {
      for (String fileName : files) {
        Path file = path.resolve(fileName);
        Files.write(Files.createFile(file), Arrays.asList("I'm uploaded", fileName));
      }
    }
    // When
    PodResource podResource = client.pods().withName("pod-standard");
    retryUpload(() -> podResource.dir("/tmp/upload-dir")
        .withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).upload(toUpload));
    // Then
    final List<Path> pathsToCheck = Stream.of(files)
        .map(f -> new Path[] { Paths.get(f), Paths.get("nested").resolve(f) })
        .flatMap(Stream::of)
        .map(p -> Paths.get("tmp").resolve("upload-dir").resolve(p))
        .collect(Collectors.toList());
    for (Path pathToCheck : pathsToCheck) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      podResource.writingOutput(baos)
          .exec("sh", "-c", String.format("cat /%s", pathToCheck.toString())).exitCode().get();
      assertThat(baos)
          .extracting(ByteArrayOutputStream::toString)
          .asString()
          .startsWith("I'm uploaded" + System.lineSeparator() + pathToCheck.getFileName());
    }
  }

  @Test
  void copyDir() throws IOException {
    final Path tmpDir = Files.createTempDirectory("copyFile");

    PodResource podResource = client.pods().withName("pod-standard");
    podResource.dir("/etc").withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).copy(tmpDir);

    Path msg = tmpDir.resolve("etc/hosts");
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
      assertEquals("hello", result, () -> checkFile(podResource, msg, "/msg.txt"));
    }
  }

  private String checkFile(PodResource podResource, Path msg, String remoteFile) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      podResource.writingOutput(baos).withReadyWaitTimeout(POD_READY_WAIT_IN_MILLIS).exec("sh", "-c",
          String.format("ls -al %s", remoteFile)).exitCode().get();
      String ls = new String(baos.toByteArray());
      if (msg != null) {
        byte[] bytes = Files.readAllBytes(msg);
        return String.format("%s local bytes %s", ls, bytes.length);
      }
      return ls;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void readFileMissingException() throws IOException {
    PodResource podResource = client.pods().withName("pod-standard");
    try (InputStream is = podResource.file("does not exist").read()) {
      assertThrows(IOException.class, () -> is.read());
    }
  }

  @Test
  void readDirMissingException() throws IOException {
    PodResource podResource = client.pods().withName("pod-standard");
    try (InputStream is = podResource.dir("/nodir").read()) {
      // this is a little odd, but tar sends some data to stdOut
      // before deciding to error out, so we have to do more than a
      // single read - this seems like a usability issue...
      assertThrows(IOException.class, () -> IOHelpers.readFully(is));
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

  @Test
  void portForward() throws IOException {
    client.pods().withName("nginx").waitUntilReady(POD_READY_WAIT_IN_MILLIS, TimeUnit.SECONDS);
    LocalPortForward portForward = client.pods().withName("nginx").portForward(80);
    boolean failed = false;
    try (SocketChannel channel = SocketChannel.open()) {

      int localPort = portForward.getLocalPort();

      URL url = new URL("http://localhost:" + localPort);

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      InputStream content = (InputStream) conn.getContent();

      // make sure we got data, should be the welcome page
      assertTrue(content.read() != -1);

      content.close();
    } catch (SocketException e) {
      failed = true;
    } finally {
      portForward.close();
    }

    if (failed) {
      // not all kube versions nor runtimes can to port forwarding - the nodes need socat installed
      portForward.getServerThrowables().stream()
          .filter(t -> !t.getMessage().contains("unable to do port forwarding: socat not found")).findFirst()
          .ifPresent(Assertions::fail);
    } else {
      assertThat(portForward.getServerThrowables()).isEmpty();
    }
    assertThat(portForward.getClientThrowables()).isEmpty();
  }

}
