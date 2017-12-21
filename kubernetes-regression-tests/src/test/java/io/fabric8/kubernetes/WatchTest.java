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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.*;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class WatchTest {
  public static KubernetesClient client;

  public static String currentNamespace;

  private static final Logger logger = LoggerFactory.getLogger(WatchTest.class);

  private boolean bKilled;

  public class PodKillerRunnable implements Runnable {
    private KubernetesClient client;
    private String currentNamespace;
    private Timer timer = new Timer();

    public PodKillerRunnable(KubernetesClient aClient, String namespace) {
      this.client = aClient;
      this.currentNamespace = namespace;
    }

    public void run() {
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          logger.info("killing pod  now ....");
          bKilled = client.pods().inNamespace(currentNamespace).withName("pod1").delete();
          logger.info("isPodKilled : {}", bKilled);
        }
      }, 15000);
    }
  }

  @BeforeClass
  public static void init() {
    client = new DefaultKubernetesClient();
    currentNamespace = "rt-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    Namespace aNamespace = new NamespaceBuilder().withNewMetadata().withName(currentNamespace).and().build();
    client.namespaces().create(aNamespace);
  }

  @AfterClass
  public static void cleanup() {
    client.namespaces().withName(currentNamespace).delete();
    client.close();
  }

  @Test
  public void testWatch() throws InterruptedException {
    Pod pod1 = new PodBuilder()
      .withNewMetadata().withName("pod1").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();

    // Wait for service account token to be generated.
    Thread.sleep(3000);
    client.pods().inNamespace(currentNamespace).create(pod1);

    // Start the killer process
    PodKillerRunnable podKiller = new PodKillerRunnable(client, currentNamespace);
    Thread aThread = new Thread(podKiller);
    aThread.start();

    final CountDownLatch eventLatch = new CountDownLatch(1);
    final CountDownLatch modifyLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    Watch watch = client.pods().inNamespace(currentNamespace).withName("pod1").watch(new Watcher<Pod>() {
      @Override
      public void eventReceived(Action action, Pod pod) {
        eventLatch.countDown();

        if (action.equals(Action.MODIFIED))
          modifyLatch.countDown();
        if (action.equals(Action.DELETED))
          deleteLatch.countDown();
        logger.info("Action : {} Pod name : {}", action.name(), pod.getMetadata().getName());
      }

      @Override
      public void onClose(KubernetesClientException e) {
        closeLatch.countDown();
        logger.info("watch closed...");
      }
    });

    client.pods().inNamespace(currentNamespace).withName("pod1").edit()
      .editMetadata().addToLabels("foo", "bar")
      .endMetadata()
      .done();

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    assertTrue(deleteLatch.await(60, TimeUnit.SECONDS));
    watch.close();
    assertTrue(closeLatch.await(30, TimeUnit.SECONDS));
  }
}
