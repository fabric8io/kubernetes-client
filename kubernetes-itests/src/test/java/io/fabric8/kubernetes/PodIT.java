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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetBuilder;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetSpecBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import okhttp3.Response;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class PodIT {

  @ArquillianResource
  public KubernetesClient client;

  @ArquillianResource
  public Session session;

  private static final int POD_READY_WAIT_IN_SECONDS = 60;

  private static final Logger logger = LoggerFactory.getLogger(PodIT.class);

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(PodIT.class.getResourceAsStream("/pod-it.yml"));
  }

  @Test
  public void load() {
    Pod aPod = client.pods().inNamespace(session.getNamespace()).load(getClass().getResourceAsStream("/test-pod.yml")).get();
    assertThat(aPod).isNotNull();
    assertEquals("nginx", aPod.getMetadata().getName());
  }

  @Test
  public void get() {
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    assertNotNull(pod1);
  }

  @Test
  public void list() {
    PodList podList = client.pods().inNamespace(session.getNamespace()).list();
    assertThat(podList).isNotNull();
    assertTrue(podList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").edit(p -> new PodBuilder(p)
                 .editMetadata().addToLabels("foo", "bar").endMetadata().build());
    assertEquals("bar", pod1.getMetadata().getLabels().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.pods().inNamespace(session.getNamespace()).withName("pod-delete").delete());
  }

  @Test
  public void evict() {
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
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
          .build()
      )
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

    client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName())
      .waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    client.pods().inNamespace(session.getNamespace()).createOrReplace(pod2);
    client.pods().inNamespace(session.getNamespace()).withName(pod2.getMetadata().getName())
      .waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    client.policy().v1beta1().podDisruptionBudget().inNamespace(session.getNamespace()).createOrReplace(pdb);

    assertTrue(client.pods().inNamespace(session.getNamespace()).withName(pod2.getMetadata().getName()).evict());
    // cant evict because only one left
    assertFalse(client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).evict());
    // ensure it really is still up
    assertTrue(Readiness.getInstance().isReady(client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).fromServer().get()));

    // create another pod to satisfy PDB
    client.pods().inNamespace(session.getNamespace()).createOrReplace(pod3);
    client.pods().inNamespace(session.getNamespace()).withName(pod3.getMetadata().getName())
      .waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    // can now evict
    assertTrue(client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).evict());
  }

  @Test
  public void log() throws InterruptedException {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);
    String log = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).getLog();
    assertNotNull(log);
  }

  @Test
  public void exec() throws InterruptedException {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);
    final CountDownLatch execLatch = new CountDownLatch(1);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ExecWatch execWatch = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName())
      .writingOutput(out).withTTY().usingListener(new ExecListener() {
        @Override
        public void onOpen(Response response) {
          logger.info("Shell was opened");
        }

        @Override
        public void onFailure(Throwable throwable, Response response) {
          logger.info("Shell barfed");
          execLatch.countDown();
        }

        @Override
        public void onClose(int i, String s) {
          logger.info("Shell closed");
          execLatch.countDown();
        }
      }).exec("date");

    execLatch.await(5, TimeUnit.SECONDS);
    assertNotNull(execWatch);
    assertNotNull(out.toString());
  }

  @Test
  public void readFile() throws IOException {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(60, TimeUnit.SECONDS).until(podReady);
    ExecWatch watch = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).writingOutput(System.out).exec("sh", "-c", "echo 'hello' > /msg");
    try (InputStream is = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).file("/msg").read())  {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
      assertEquals("hello", result);
    }
  }

  @Test
  public void readFileEscapedParams() throws IOException {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);
    ExecWatch watch = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).writingOutput(System.out).exec("sh", "-c", "echo 'H$ll* (W&RLD}' > /msg");
    try (InputStream is = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).file("/msg").read())  {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
      assertEquals("H$ll* (W&RLD}", result);
    }
  }

  @Test
  public void uploadFile() throws IOException {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(),
        session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);

    final Path tmpFile = Files.createTempFile("PodIT", "toBeUploaded");
    Files.write(tmpFile, Arrays.asList("I'm uploaded"));

    assertUploaded(pod1, tmpFile, "/tmp/toBeUploaded");
    assertUploaded(pod1, tmpFile, "/tmp/001_special_!@#\\$^&(.mp4");
  }

  private void assertUploaded(Pod pod1, final Path tmpFile, String filename) throws IOException {
    PodResource<Pod> podResource = client.pods().inNamespace(session.getNamespace())
        .withName(pod1.getMetadata().getName());

    podResource.file(filename).upload(tmpFile);

    try (InputStream checkIs = podResource.file(filename).read();
        BufferedReader br = new BufferedReader(new InputStreamReader(checkIs, StandardCharsets.UTF_8))) {
      String result = br.lines().collect(Collectors.joining(System.lineSeparator()));
      assertEquals("I'm uploaded", result);
    }
  }

  @Test
  public void uploadDir() throws IOException {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(),
        session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);

    final String[] files = new String[] { "1", "2", "a", "b", "c" };
    final Path tmpDir = Files.createTempDirectory("uploadDir");
    for (String fileName : files) {
      Path file = tmpDir.resolve(fileName);
      Files.write(Files.createFile(file), Arrays.asList("I'm uploaded", fileName));
    }

    PodResource<Pod> podResource = client.pods().inNamespace(session.getNamespace())
        .withName(pod1.getMetadata().getName());

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
  public void copyFile() throws IOException {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(),
        session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);

    final Path tmpDir = Files.createTempDirectory("copyFile");

    PodResource<Pod> podResource = client.pods().inNamespace(session.getNamespace())
        .withName(pod1.getMetadata().getName());
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
  public void listFromServer() {
    // Wait for resources to get ready
    Pod pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);

    List<HasMetadata> resources = client.resourceList(pod1).inNamespace(session.getNamespace()).fromServer().get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));

    HasMetadata fromServerPod = resources.get(0);

    assertEquals(pod1.getKind(), fromServerPod.getKind());
    assertEquals(session.getNamespace(), fromServerPod.getMetadata().getNamespace());
    assertEquals(pod1.getMetadata().getName(), fromServerPod.getMetadata().getName());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(NetworkPolicyIT.class.getResourceAsStream("/pod-it.yml"));
  }

}
