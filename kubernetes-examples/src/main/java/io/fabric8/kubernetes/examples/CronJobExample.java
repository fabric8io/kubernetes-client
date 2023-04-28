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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.batch.v1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1.CronJobBuilder;
import io.fabric8.kubernetes.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * Creates a simple cronjob that runs every minute spinning a pod that echoes hello world.
 */
public class CronJobExample {
  private static final Logger logger = LoggerFactory.getLogger(CronJobExample.class);

  public static void main(String[] args) {
    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    log("Using master with url ", master);
    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (final KubernetesClient client = new KubernetesClientBuilder().withConfig(config).build()) {
      final String namespace = client.getNamespace();

      CronJob cronJob1 = new CronJobBuilder()
          .withApiVersion("batch/v1beta1")
          .withNewMetadata()
          .withName("hello")
          .withLabels(Collections.singletonMap("foo", "bar"))
          .endMetadata()
          .withNewSpec()
          .withSchedule("*/1 * * * *")
          .withNewJobTemplate()
          .withNewSpec()
          .withNewTemplate()
          .withNewSpec()
          .addNewContainer()
          .withName("hello")
          .withImage("busybox")
          .withArgs("/bin/sh", "-c", "date; echo Hello from Kubernetes")
          .endContainer()
          .withRestartPolicy("OnFailure")
          .endSpec()
          .endTemplate()
          .endSpec()
          .endJobTemplate()
          .endSpec()
          .build();

      log("Creating cron job from object");
      cronJob1 = client.batch().v1().cronjobs().inNamespace(namespace).resource(cronJob1).create();
      log("Successfully created cronjob with name ", cronJob1.getMetadata().getName());

      log("Watching over pod which would be created during cronjob execution...");
      final CountDownLatch watchLatch = new CountDownLatch(1);
      try (Watch ignored = client.pods().inNamespace(namespace).withLabel("job-name").watch(new Watcher<Pod>() {
        @Override
        public void eventReceived(Action action, Pod aPod) {
          log(aPod.getMetadata().getName(), aPod.getStatus().getPhase());
          if (aPod.getStatus().getPhase().equals("Succeeded")) {
            log("Logs -> ", client.pods().inNamespace(namespace).withName(aPod.getMetadata().getName()).getLog());
            watchLatch.countDown();
          }
        }

        @Override
        public void onClose(WatcherException e) {
          // Ignore
        }
      })) {
        watchLatch.await(2, TimeUnit.MINUTES);
      } catch (InterruptedException interruptedException) {
        Thread.currentThread().interrupt();
        log("Could not watch pod", interruptedException);
      } catch (KubernetesClientException kubernetesClientException) {
        log("Could not watch pod", kubernetesClientException);
      }
    } catch (KubernetesClientException exception) {
      log("An error occured while processing cronjobs:", exception.getMessage());
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
