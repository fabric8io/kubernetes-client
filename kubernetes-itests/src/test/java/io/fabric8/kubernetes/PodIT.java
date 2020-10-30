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

import com.google.common.io.Files;
import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.policy.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.PodDisruptionBudgetBuilder;
import io.fabric8.kubernetes.api.model.policy.PodDisruptionBudgetSpecBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import okhttp3.Response;
import org.apache.commons.io.IOUtils;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class PodIT {

  @ArquillianResource
  public KubernetesClient client;

  @ArquillianResource
  public Session session;

  private Pod pod1;

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
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
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
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").edit(p -> new PodBuilder(p)
                 .editMetadata().addToLabels("foo", "bar").endMetadata().build());
    assertEquals("bar", pod1.getMetadata().getLabels().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.pods().inNamespace(session.getNamespace()).withName("pod-delete").delete());
  }

  @Test
  public void evict() throws InterruptedException {
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
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

    client.policy().podDisruptionBudget().inNamespace(session.getNamespace()).createOrReplace(pdb);

    assertTrue(client.pods().inNamespace(session.getNamespace()).withName(pod2.getMetadata().getName()).evict());
    // cant evict because only one left
    assertFalse(client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).evict());
    // ensure it really is still up
    assertTrue(Readiness.isReady(client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).fromServer().get()));

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
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);
    String log = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).getLog();
    assertNotNull(log);
  }

  @Test
  public void exec() throws InterruptedException {
    // Wait for resources to get ready
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
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
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
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
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
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
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);

    final File tmpDir = Files.createTempDir();
    final File tmpFile = new File(tmpDir, "toBeUploaded");
    tmpFile.createNewFile();
    Files.write("I'm uploaded", tmpFile, StandardCharsets.UTF_8);

    client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName())
      .file("/tmp/toBeUploaded").upload(tmpFile.toPath());

    try (
      final InputStream checkIs = client.pods().inNamespace(session.getNamespace())
        .withName(pod1.getMetadata().getName()).file("/tmp/toBeUploaded").read();
      final ByteArrayOutputStream resultOs = new ByteArrayOutputStream()
    ) {
      IOUtils.copy(checkIs, resultOs);
      assertEquals(resultOs.toString(StandardCharsets.UTF_8.name()),"I'm uploaded");
    }
  }

  @Test
  public void uploadDir() {
    // Wait for resources to get ready
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);

    final String[] files = new String[]{"1", "2"};
    final File tmpDir = Files.createTempDir();
    final File uploadDir = new File(tmpDir, "uploadDir");
    assertTrue(uploadDir.mkdir());
    Stream.of(files).map(fileName -> new File(uploadDir, fileName)).forEach(f -> {
      try {
        assertTrue(f.createNewFile());
        Files.write("I'm uploaded", f, StandardCharsets.UTF_8);
      } catch (IOException ex) {
        fail(ex.getMessage());
      }
    });

    client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName())
      .dir("/tmp/uploadDir").upload(uploadDir.toPath());

    Stream.of(files).forEach(fileName -> {
      try (
        final InputStream checkIs = client.pods().inNamespace(session.getNamespace())
          .withName(pod1.getMetadata().getName()).file("/tmp/uploadDir/"+fileName).read();
        final ByteArrayOutputStream resultOs = new ByteArrayOutputStream()
      ) {
        IOUtils.copy(checkIs, resultOs);
        assertEquals(resultOs.toString(StandardCharsets.UTF_8.name()),"I'm uploaded");
      } catch(IOException ex) {
        fail(ex.getMessage());
      }
    });
  }

  @Test
  public void copyFile() throws IOException {
    // Wait for resources to get ready
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
    ReadyEntity<Pod> podReady = new ReadyEntity<>(Pod.class, client, pod1.getMetadata().getName(), session.getNamespace());
    await().atMost(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS).until(podReady);

    File tmpDir = Files.createTempDir();
    ExecWatch watch = client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).writingOutput(System.out).exec("sh", "-c", "echo 'hello' > /msg");
    client.pods().inNamespace(session.getNamespace()).withName(pod1.getMetadata().getName()).file("/msg").copy(tmpDir.toPath());
    File msg = tmpDir.toPath().resolve("msg").toFile();
    assertTrue(msg.exists());
    try (InputStream is = new FileInputStream(msg))  {
      String result = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
      assertEquals("hello", result);
    }
  }

  @Test
  public void listFromServer() {
    // Wait for resources to get ready
    pod1 = client.pods().inNamespace(session.getNamespace()).withName("pod-standard").get();
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
