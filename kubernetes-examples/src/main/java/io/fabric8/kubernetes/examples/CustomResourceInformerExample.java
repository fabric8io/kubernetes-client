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

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerEventListener;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.examples.crds.Dummy;
import io.fabric8.kubernetes.examples.crds.DummyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CustomResourceInformerExample {
  private static final Logger logger = LoggerFactory.getLogger(CustomResourceInformerExample.class);

  public static void main(String args[]) {
    try (KubernetesClient client = new DefaultKubernetesClient()) {
      CustomResourceDefinitionContext crdContext = new CustomResourceDefinitionContext.Builder()
        .withVersion("v1")
        .withScope("Namespaced")
        .withGroup("demo.fabric8.io")
        .withPlural("dummies")
        .build();

      SharedInformerFactory sharedInformerFactory = client.informers();
      SharedIndexInformer<Dummy> podInformer = sharedInformerFactory.sharedIndexInformerForCustomResource(crdContext, Dummy.class, DummyList.class, 1 * 60 * 1000);
      logger.info("Informer factory initialized.");

      podInformer.addEventHandler(
        new ResourceEventHandler<Dummy>() {
          @Override
          public void onAdd(Dummy pod) {
            System.out.printf("%s dummy added\n", pod.getMetadata().getName());
          }

          @Override
          public void onUpdate(Dummy oldPod, Dummy newPod) {
            System.out.printf("%s dummy updated\n", oldPod.getMetadata().getName());
          }

          @Override
          public void onDelete(Dummy pod, boolean deletedFinalStateUnknown) {
            System.out.printf("%s dummy deleted \n", pod.getMetadata().getName());
          }
        }
      );

      sharedInformerFactory.addSharedInformerEventListener(new SharedInformerEventListener() {
        @Override
        public void onException(Exception exception) {
          System.out.println("Exception occurred, but caught");
        }
      });

      logger.info("Starting all registered informers");
      sharedInformerFactory.startAllRegisteredInformers();

      Executors.newSingleThreadExecutor().submit(() -> {
        Thread.currentThread().setName("HAS_SYNCED_THREAD");
        try {
          for (;;) {
            logger.info("podInformer.hasSynced() : {}", podInformer.hasSynced());
            Thread.sleep(200);
          }
        } catch (InterruptedException inEx) {
          logger.info("HAS_SYNCED_THREAD INTERRUPTED!");
        }
      });

      // Wait for some time now
      TimeUnit.MINUTES.sleep(60);
    } catch (InterruptedException interruptedException) {
      logger.info("interrupted: {}", interruptedException.getMessage());
    }
  }
}
