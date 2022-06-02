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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.examples.crds.Dummy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CustomResourceInformerExample {
  private static final Logger logger = LoggerFactory.getLogger(CustomResourceInformerExample.class);

  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      SharedInformerFactory sharedInformerFactory = client.informers();
      SharedIndexInformer<Dummy> podInformer = sharedInformerFactory.sharedIndexInformerFor(Dummy.class, 60 * 1000L);
      logger.info("Informer factory initialized.");

      podInformer.addEventHandler(
          new ResourceEventHandler<Dummy>() {
            @Override
            public void onAdd(Dummy pod) {
              logger.info("{} dummy added", pod.getMetadata().getName());
            }

            @Override
            public void onUpdate(Dummy oldPod, Dummy newPod) {
              logger.info("{} dummy updated", oldPod.getMetadata().getName());
            }

            @Override
            public void onDelete(Dummy pod, boolean deletedFinalStateUnknown) {
              logger.info("{} dummy deleted", pod.getMetadata().getName());
            }
          });

      sharedInformerFactory
          .addSharedInformerEventListener(ex -> logger.error("Exception occurred, but caught: {}", ex.getMessage()));

      logger.info("Starting all registered informers");
      sharedInformerFactory.startAllRegisteredInformers();

      Executors.newSingleThreadExecutor().submit(() -> {
        Thread.currentThread().setName("HAS_SYNCED_THREAD");
        try {
          for (;;) {
            logger.info("podInformer.hasSynced() : {}", podInformer.hasSynced());
            Thread.sleep(10 * 1000L);
          }
        } catch (InterruptedException inEx) {
          Thread.currentThread().interrupt();
          logger.warn("HAS_SYNCED_THREAD interrupted: {}", inEx.getMessage());
        }
      });

      final Dummy toCreate = new Dummy();
      toCreate.getMetadata().setName("dummy");
      if (client.getConfiguration().getNamespace() != null) {
        toCreate.getMetadata().setNamespace(client.getConfiguration().getNamespace());
      } else if (client.getNamespace() != null) {
        toCreate.getMetadata().setNamespace(client.getNamespace());
      } else {
        toCreate.getMetadata().setNamespace(client.namespaces().list().getItems().stream().findFirst()
            .map(HasMetadata::getMetadata).map(ObjectMeta::getNamespace).orElse("default"));
      }

      client.resources(Dummy.class).createOrReplace(toCreate);
      // Wait for some time now
      TimeUnit.MINUTES.sleep(5);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      logger.warn("interrupted: {}", interruptedException.getMessage());
    }
  }
}
