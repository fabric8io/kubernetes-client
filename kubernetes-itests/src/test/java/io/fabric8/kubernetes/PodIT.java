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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetBuilder;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetSpecBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.IOHelpers;
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
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/pod-it.yml")
class PodIT {

  private static final int POD_READY_WAIT_IN_SECONDS = 60;

  private static final Logger logger = LoggerFactory.getLogger(PodIT.class);

  KubernetesClient client;

  Namespace namespace;

  @Test
  void load() {
    Pod aPod = client.pods().load(getClass().getResourceAsStream("/test-pod.yml")).get();
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
  void evict() {
    Pod pod1 = client.pods().withName("pod-standard").get();
    String pdbScope = pod1.getMetadata().getLabels().get("pdb-scope");
    assertNotNull("pdb-scope label is null. is pod1 misconfigured?", pdbScope);

    PodDisruptionBudget pdb = new PodDisruptionBudgetBuilder()
        .withNewMetadata()
        .withName("test-pdb")
        .endMetadata()
        .withSpec(
            new PodDisruptionBudgetSpecBuilder()
                .withMinAvailable(new IntOrString(1))
                .withNewSelector()
                .addToMatchLabels("pdb-scope", pdbScope)
                .endSelector()
                .build())
        .build();

    Pod pod2 = new PodBuilder()
        .withNewMetadata()
        .withName("pod2")
        .addToLabels("pdb-scope", pdbScope)
        .endMetadata()
        .withSpec(pod1.getSpec())
        .build();

    Pod pod3 = new PodBuilder()
        .withNewMetadata()
        .withName("pod3")
        .addToLabels("pdb-scope", pdbScope)
        .endMetadata()
        .withSpec(pod1.getSpec())
        .build();

    client.pods().withName(pod1.getMetadata().getName())
        .waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    client.pods().createOrReplace(pod2);
    client.pods().withName(pod2.getMetadata().getName())
        .waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    client.policy().v1beta1().podDisruptionBudget().createOrReplace(pdb);

    // the server needs to process the pdb before the eviction can proceed, so we'll need to wait here
    await().atMost(5, TimeUnit.MINUTES)
        .until(() -> client.pods().withName(pod2.getMetadata().getName()).evict());

    // cant evict because only one left
    assertFalse(client.pods().withName(pod1.getMetadata().getName()).evict());
    // ensure it really is still up
    assertTrue(Readiness.getInstance().isReady(client.pods().withName(pod1.getMetadata().getName()).fromServer().get()));

    // create another pod to satisfy PDB
    client.pods().createOrReplace(pod3);
    client.pods().withName(pod3.getMetadata().getName())
        .waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    // can now evict
    assertTrue(client.pods().withName(pod1.getMetadata().getName()).evict());
  }

  @Test
  void log() {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    String log = client.pods().withName("pod-standard").getLog();
    assertNotNull(log);
  }

  @Test
  void exec() throws InterruptedException, IOException {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    final CountDownLatch execLatch = new CountDownLatch(1);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int[] exitCode = new int[] { Integer.MAX_VALUE };
    ExecWatch execWatch = client.pods().withName("pod-standard")
        .writingOutput(out)
        .redirectingErrorChannel()
        .withTTY().usingListener(new ExecListener() {
          @Override
          public void onOpen() {
            logger.info("Shell was opened");
          }

          @Override
          public void onFailure(Throwable t, Response failureResponse) {
            logger.info("Shell barfed");
            execLatch.countDown();
          }

          @Override
          public void onClose(int i, String s) {
            logger.info("Shell closed");
            execLatch.countDown();
          }

          @Override
          public void onExit(int code, Status status) {
            exitCode[0] = code;
          }
        }).exec("date");

    execLatch.await(5, TimeUnit.SECONDS);
    assertNotNull(execWatch);
    assertNotNull(out.toString());
    assertEquals(0, exitCode[0]);
    assertEquals("{\"metadata\":{},\"status\":\"Success\"}", IOHelpers.readFully(execWatch.getErrorChannel()));
  }

  @Test
  void readFile() throws IOException {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    try (
        ExecWatch ignore = client.pods().withName("pod-standard").writingOutput(System.out).exec("sh", "-c",
            "echo 'hello' > /msg");
        InputStream is = client.pods().withName("pod-standard").file("/msg").read()) {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
      assertEquals("hello", result);
    }
  }

  @Test
  void readFileEscapedParams() throws IOException {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    try (
        ExecWatch watch = client.pods().withName("pod-standard").writingOutput(System.out).exec("sh", "-c",
            "echo 'H$ll* (W&RLD}' > /msg");
        InputStream is = client.pods().withName("pod-standard").file("/msg").read()) {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
      assertEquals("H$ll* (W&RLD}", result);
    }
  }

  @Test
  void uploadFile() throws IOException {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    // Wait for resources to get ready
    final Path tmpFile = Files.createTempFile("PodIT", "toBeUploaded");
    Files.write(tmpFile, Arrays.asList("I'm uploaded"));

    assertUploaded("pod-standard", tmpFile, "/tmp/toBeUploaded");
    assertUploaded("pod-standard", tmpFile, "/tmp/001_special_!@#\\$^&(.mp4");
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
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    final String[] files = new String[] { "1", "2", "a", "b", "c" };
    final Path tmpDir = Files.createTempDirectory("uploadDir");
    for (String fileName : files) {
      Path file = tmpDir.resolve(fileName);
      Files.write(Files.createFile(file), Arrays.asList("I'm uploaded", fileName));
    }

    PodResource podResource = client.pods().withName("pod-standard");

    podResource.dir("/tmp/uploadDir").upload(tmpDir);

    for (String fileName : files) {
      try (InputStream checkIs = podResource.file("/tmp/uploadDir/" + fileName).read();
          BufferedReader br = new BufferedReader(new InputStreamReader(checkIs, StandardCharsets.UTF_8))) {
        String result = br.lines().collect(Collectors.joining(System.lineSeparator()));
        assertEquals("I'm uploaded" + System.lineSeparator() + fileName, result);
      }
    }
  }

  @Test
  void copyFile() throws IOException {
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    final Path tmpDir = Files.createTempDirectory("copyFile");

    PodResource podResource = client.pods().withName("pod-standard");
    podResource.writingOutput(System.out).exec("sh", "-c", "echo 'hello' > /msg.txt");
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
    client.pods().withName("pod-standard").waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);
    final Pod pod1 = client.pods().withName("pod-standard").get();
    List<HasMetadata> resources = client.resourceList(pod1).fromServer().get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));

    HasMetadata fromServerPod = resources.get(0);

    assertEquals(pod1.getKind(), fromServerPod.getKind());
    assertEquals(namespace.getMetadata().getName(), fromServerPod.getMetadata().getNamespace());
    assertEquals(pod1.getMetadata().getName(), fromServerPod.getMetadata().getName());
  }

}
