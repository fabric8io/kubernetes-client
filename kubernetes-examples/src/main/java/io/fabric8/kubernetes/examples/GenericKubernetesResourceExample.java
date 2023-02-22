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
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GenericKubernetesResourceExample {

  private static final Logger logger = LoggerFactory.getLogger(GenericKubernetesResourceExample.class);

  public static void main(String[] args) throws Exception {

    final ConfigBuilder configBuilder = new ConfigBuilder();
    configBuilder.withWatchReconnectInterval(500);
    configBuilder.withWatchReconnectLimit(5);
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {

      String namespace = "default";
      CustomResourceDefinition prometheousRuleCrd = client.apiextensions().v1beta1().customResourceDefinitions()
          .load(GenericKubernetesResourceExample.class.getResourceAsStream("/prometheous-rule-crd.yml")).item();
      client.apiextensions().v1beta1().customResourceDefinitions().resource(prometheousRuleCrd).createOrReplace();
      logger.info("Successfully created Prometheous custom resource definition");

      // Creating Custom Resources Now:
      ResourceDefinitionContext crdContext = CustomResourceDefinitionContext.fromCrd(prometheousRuleCrd);

      client.load(GenericKubernetesResourceExample.class.getResourceAsStream("/prometheous-rule-cr.yml"))
          .inNamespace(namespace)
          .createOrReplace();
      logger.info("Created Custom Resource successfully too");

      // Listing all custom resources in given namespace:
      NonNamespaceOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> resourcesInNamespace = client
          .genericKubernetesResources(crdContext).inNamespace(namespace);
      GenericKubernetesResourceList list = resourcesInNamespace.list();
      List<GenericKubernetesResource> items = list.getItems();
      logger.info("Custom Resources :- ");
      for (GenericKubernetesResource customResource : items) {
        ObjectMeta metadata = customResource.getMetadata();
        final String name = metadata.getName();
        logger.info(name);
      }

      // Watching custom resources now
      logger.info("Watching custom resources now");
      final CountDownLatch closeLatch = new CountDownLatch(1);
      Watch watch = resourcesInNamespace.watch(new Watcher<GenericKubernetesResource>() {
        @Override
        public void eventReceived(Action action, GenericKubernetesResource resource) {
          logger.info("{}: {}", action, resource);
        }

        @Override
        public void onClose(WatcherException e) {
          logger.debug("Watcher onClose");
          closeLatch.countDown();
          if (e != null) {
            logger.error(e.getMessage(), e);
          }
        }
      });
      closeLatch.await(10, TimeUnit.MINUTES);
      watch.close();

      // Cleanup
      logger.info("Deleting custom resources...");
      resourcesInNamespace.withName("prometheus-example-rules").delete();
      client.apiextensions().v1beta1().customResourceDefinitions()
          .withName(prometheousRuleCrd.getMetadata().getName()).delete();
    } catch (KubernetesClientException e) {
      logger.error("Could not create resource: {}", e.getMessage(), e);
    }
  }
}
