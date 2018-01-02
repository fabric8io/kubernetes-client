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

import io.fabric8.kubernetes.api.KubernetesHelper;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import okhttp3.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class PodIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Pod pod1, pod2;

  private String currentNamespace;

  private static final Logger logger = LoggerFactory.getLogger(PodIT.class);

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    pod1 = new PodBuilder()
      .withNewMetadata().withName("pod1-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase()).endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();
    pod2 = new PodBuilder()
      .withNewMetadata().withName("pod2" + RandomStringUtils.randomAlphanumeric(6).toLowerCase()).endMetadata()
      .withNewSpec()
      .addNewContainer().withName("httpd").withImage("httpd").endContainer()
      .endSpec()
      .build();

    client.pods().inNamespace(currentNamespace).createOrReplace(pod1);
    client.pods().inNamespace(currentNamespace).createOrReplace(pod2);
  }

  @Test
  public void create() {
    Pod aPod = client.pods().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-pod.yml")).get();
    assertThat(aPod).isNotNull();
    assertEquals("nginx", aPod.getMetadata().getName());
  }

  @Test
  public void get() {
    pod1 = client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName()).get();
    assertNotNull(pod1);
    pod2 = client.pods().inNamespace(currentNamespace).withName(pod2.getMetadata().getName()).get();
    assertNotNull(pod2);
  }

  @Test
  public void list() {
    PodList podList = client.pods().inNamespace(currentNamespace).list();
    assertThat(podList).isNotNull();
    assertTrue(podList.getItems().size() >= 2);
  }

  @Test
  public void update() {
    pod1 = client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName()).edit()
      .editMetadata().addToLabels("foo", "bar").and().done();
    assertEquals("bar", pod1.getMetadata().getLabels().get("foo"));
  }

  @Test
  public void delete() {
    assertTrue(client.pods().inNamespace(currentNamespace).delete(pod1));
    assertTrue(client.pods().inNamespace(currentNamespace).delete(pod2));
  }

  @After
  public void cleanup() {
    client.pods().inNamespace(currentNamespace).delete();
  }

  @Test
  public void log() throws InterruptedException {
    waitUntilPodIsReady(pod2.getMetadata().getName(), 60);
    String log = client.pods().inNamespace(currentNamespace).withName(pod2.getMetadata().getName()).getLog();
    assertNotNull(log);
  }

  @Test
  public void exec() throws InterruptedException {
    waitUntilPodIsReady(pod1.getMetadata().getName(), 60);
    final CountDownLatch execLatch = new CountDownLatch(1);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ExecWatch execWatch = client.pods().inNamespace(currentNamespace).withName(pod1.getMetadata().getName())
      .writingOutput(out).usingListener(new ExecListener() {
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

    execLatch.await(10, TimeUnit.MINUTES);
    assertNotNull(execWatch);
    assertNotNull(out.toString());
  }

  /**
   * A Simple utility function to watch over pod until it gets ready
   *
   * @param podName Name of the pod
   * @param nAwaitTimeout Time in seconds upto which pod must be watched
   * @throws InterruptedException
   */
  private void waitUntilPodIsReady(String podName, int nAwaitTimeout) throws InterruptedException {
    final CountDownLatch readyLatch = new CountDownLatch(1);
    try (Watch watch = client.pods().withName(podName).watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod aPod) {
        if (KubernetesHelper.isPodReady(aPod)) {
          readyLatch.countDown();
        }
      }

      @Override
      public void onClose(KubernetesClientException e) {
        // Ignore
      }
    })) {
      readyLatch.await(nAwaitTimeout, TimeUnit.SECONDS);
    } catch (KubernetesClientException | InterruptedException e) {
      logger.error(e.getMessage(), e);
    }
  }
}
