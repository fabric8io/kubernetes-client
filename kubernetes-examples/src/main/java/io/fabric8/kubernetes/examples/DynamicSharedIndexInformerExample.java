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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.informers.SharedIndexInformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * You would need to have Dummy CRD installed. See <code>test-crd.yaml</code> in resources/ folder.
 *
 * Run this sample using this command:
 * <code>
 *   mvn exec:java -Dexec.mainClass="io.fabric8.kubernetes.examples.DynamicSharedIndexInformerExample"
 * </code>
 *
 */
public class DynamicSharedIndexInformerExample {
  private static final Logger logger = LoggerFactory.getLogger(DynamicSharedIndexInformerExample.class.getSimpleName());

  public static void main(String[] args) {
    ResourceDefinitionContext context = new ResourceDefinitionContext.Builder()
        .withGroup("demo.fabric8.io")
        .withVersion("v1")
        .withPlural("dummies")
        .withKind("Dummy")
        .withNamespaced(true)
        .build();

    try (KubernetesClient client = new KubernetesClientBuilder().build();
        SharedIndexInformer<GenericKubernetesResource> informer = client.genericKubernetesResources(context).inAnyNamespace()
            .runnableInformer(60 * 1000L);) {
      informer.addEventHandler(new ResourceEventHandler<GenericKubernetesResource>() {
        @Override
        public void onAdd(GenericKubernetesResource genericKubernetesResource) {
          logger.info("ADD {}/{}", genericKubernetesResource.getMetadata().getNamespace(),
              genericKubernetesResource.getMetadata().getName());
        }

        @Override
        public void onUpdate(GenericKubernetesResource genericKubernetesResource, GenericKubernetesResource t1) {
          logger.info("UPDATE {}/{}", genericKubernetesResource.getMetadata().getNamespace(),
              genericKubernetesResource.getMetadata().getName());
        }

        @Override
        public void onDelete(GenericKubernetesResource genericKubernetesResource, boolean b) {
          logger.info("DELETE {}/{}", genericKubernetesResource.getMetadata().getNamespace(),
              genericKubernetesResource.getMetadata().getName());
        }
      });

      TimeUnit.MINUTES.sleep(10);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      logger.error("interrupted: {}", interruptedException.getMessage());
    }
  }
}
