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
package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class WatchExample {

  private static final Logger logger = LoggerFactory.getLogger(WatchExample.class);

  public static void main(String[] args) throws InterruptedException {
    final CountDownLatch closeLatch = new CountDownLatch(1);
    Config config = new ConfigBuilder().build();
    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
      try (Watch watch = client.replicationControllers().inNamespace("default").withName("test").watch(new Watcher<ReplicationController>() {
        @Override
        public void eventReceived(Action action, ReplicationController resource) {
          logger.info("{}: {}", action, resource.getMetadata().getResourceVersion());
        }

        @Override
        public void onClose(KubernetesClientException e) {
          logger.debug("Watcher onClose");
          if (e != null) {
            logger.error(e.getMessage(), e);
            closeLatch.countDown();
          }
        }
      })) {
        closeLatch.await(10, TimeUnit.SECONDS);
      } catch (KubernetesClientException | InterruptedException e) {
        logger.error("Could not watch resources", e);
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);

      Throwable[] suppressed = e.getSuppressed();
      if (suppressed != null) {
        for (Throwable t : suppressed) {
          logger.error(t.getMessage(), t);
        }
      }
    }
    Thread.sleep(60000l);
  }

}
