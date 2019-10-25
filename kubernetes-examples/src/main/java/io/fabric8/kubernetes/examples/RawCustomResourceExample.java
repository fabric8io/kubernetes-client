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

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RawCustomResourceExample {
  private static final Logger logger = LoggerFactory.getLogger(RawCustomResourceExample.class);

  public static void main(String args[]) throws Exception {

    final CountDownLatch closeLatch = new CountDownLatch(1);
    try (final KubernetesClient client = new DefaultKubernetesClient()) {

      String namespace = "default";
      CustomResourceDefinition prometheousRuleCrd = client.customResourceDefinitions().load(RawCustomResourceExample.class.getResourceAsStream("/prometheous-rule-crd.yml")).get();
      client.customResourceDefinitions().create(prometheousRuleCrd);
      log("Successfully created prometheous custom resource definition");

      // Creating Custom Resources Now:
      CustomResourceDefinitionContext crdContext = new CustomResourceDefinitionContext.Builder()
        .withGroup("monitoring.coreos.com")
        .withPlural("prometheusrules")
        .withScope("Namespaced")
        .withVersion("v1")
        .build();

      client.customResource(crdContext).create(namespace, RawCustomResourceExample.class.getResourceAsStream("/prometheous-rule-cr.yml"));
      log("Created Custom Resource successfully too");

      // Listing all custom resources in given namespace:
      Map<String, Object> list = client.customResource(crdContext).list(namespace);
      List<Map<String, Object>> items = (List<Map<String, Object>>) list.get("items");
      log("Custom Resources :- ");
      for(Map<String, Object> customResource : items) {
        Map<String, Object> metadata = (Map<String, Object>) customResource.get("metadata");
        log(metadata.get("name").toString());
      }


      // Watching custom resources now
      log("Watching custom resources now");
      client.customResource(crdContext).watch(namespace, new Watcher<String>() {
        @Override
        public void eventReceived(Action action, String resource) {
          logger.info("{}: {}", action, resource);
        }

        @Override
        public void onClose(KubernetesClientException e) {
          logger.debug("Watcher onClose");
          closeLatch.countDown();
          if (e != null) {
            logger.error(e.getMessage(), e);
          }
        }
      });
      closeLatch.await(10, TimeUnit.MINUTES);

      // Cleanup
      log("Deleting custom resources...");
      Map<String, Object> deleted  = client.customResource(crdContext).delete(namespace, "prometheus-example-rules");
      client.customResourceDefinitions().withName("prometheusrules.monitoring.coreos.com").delete();
    } catch (KubernetesClientException e) {
      e.printStackTrace();
      log("Could not create resource", e.getMessage());
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
