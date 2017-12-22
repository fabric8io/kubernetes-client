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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.*;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class WatchIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private static final Logger logger = LoggerFactory.getLogger(WatchIT.class);

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
          bKilled = client.pods().inNamespace(currentNamespace).withName("sample-watch-pod").delete();
          logger.info("isPodKilled : {}", bKilled);
        }
      }, 15000);
    }
  }

  @Test
  public void testWatch() throws InterruptedException {
    String currentNamespace = session.getNamespace();
    Pod pod1 = new PodBuilder()
      .withNewMetadata().withName("sample-watch-pod").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx").endContainer()
      .endSpec()
      .build();

    client.pods().inNamespace(currentNamespace).create(pod1);

    // Start the killer process
    PodKillerRunnable podKiller = new PodKillerRunnable(client, currentNamespace);
    Thread aThread = new Thread(podKiller);
    aThread.start();

    final CountDownLatch eventLatch = new CountDownLatch(1);
    final CountDownLatch modifyLatch = new CountDownLatch(1);
    final CountDownLatch closeLatch = new CountDownLatch(1);
    final CountDownLatch deleteLatch = new CountDownLatch(1);
    Watch watch = client.pods().inNamespace(currentNamespace).withName("sample-watch-pod").watch(new Watcher<Pod>() {
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

    client.pods().inNamespace(currentNamespace).withName("sample-watch-pod").edit()
      .editMetadata().addToLabels("foo", "bar")
      .endMetadata()
      .done();

    assertTrue(eventLatch.await(10, TimeUnit.SECONDS));
    assertTrue(deleteLatch.await(60, TimeUnit.SECONDS));
    watch.close();
    assertTrue(closeLatch.await(30, TimeUnit.SECONDS));
  }
}
