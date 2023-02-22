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
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.informers.cache.Lister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class SharedInformerExample {
  private static final Logger logger = LoggerFactory.getLogger(SharedInformerExample.class);

  private static final String POD_NAME = "myapp-pod";

  public static void main(String[] args) throws InterruptedException {
    try (final KubernetesClient client = new KubernetesClientBuilder().build()) {
      SharedInformerFactory sharedInformerFactory = client.informers();
      SharedIndexInformer<Pod> podInformer = sharedInformerFactory.sharedIndexInformerFor(Pod.class, 30 * 1000L);
      logger.info("Informer factory initialized.");

      podInformer.addEventHandler(
          new ResourceEventHandler<Pod>() {
            @Override
            public void onAdd(Pod pod) {
              logger.info("{} pod added", pod.getMetadata().getName());
            }

            @Override
            public void onUpdate(Pod oldPod, Pod newPod) {
              logger.info("{} pod updated", oldPod.getMetadata().getName());
            }

            @Override
            public void onDelete(Pod pod, boolean deletedFinalStateUnknown) {
              logger.info("{} pod deleted", pod.getMetadata().getName());
            }
          });

      logger.info("Starting all registered informers");
      sharedInformerFactory.startAllRegisteredInformers();
      Pod testPod = new PodBuilder()
          .withNewMetadata().withName(POD_NAME).withLabels(Collections.singletonMap("app", POD_NAME)).endMetadata()
          .withNewSpec()
          .addNewContainer()
          .withName("myapp-container")
          .withImage("busybox:1.28")
          .withCommand("sh", "-c", "echo The app is running!; sleep 10")
          .endContainer()
          .addNewInitContainer()
          .withName("init-myservice")
          .withImage("busybox:1.28")
          .withCommand("sh", "-c", "echo inititalizing...; sleep 5")
          .endInitContainer()
          .endSpec()
          .build();

      client.pods().inNamespace("default").resource(testPod).create();
      logger.info("Pod created");
      Thread.sleep(3000L);

      Lister<Pod> podLister = new Lister<>(podInformer.getIndexer(), "default");
      Pod myPod = podLister.get(POD_NAME);
      logger.info("PodLister has {}", podLister.list().size());

      if (myPod != null) {
        logger.info("***** myapp-pod created {}", myPod.getMetadata().getCreationTimestamp());
      }

      // Wait for some time now
      TimeUnit.MINUTES.sleep(3);

      podInformer.close();
      sharedInformerFactory.stopAllRegisteredInformers();
    }
  }
}
