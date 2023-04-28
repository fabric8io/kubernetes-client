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

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

public class WatchExample {

  private static final Logger logger = LoggerFactory.getLogger(WatchExample.class);

  @SuppressWarnings("java:S1604")
  public static void main(String[] args) {
    try (
        KubernetesClient client = new KubernetesClientBuilder().build();
        Watch ignored = newConfigMapWatch(client)) {
      final String namespace = Optional.ofNullable(client.getNamespace()).orElse("default");
      final String name = "watch-config-map-test-" + UUID.randomUUID();
      final ConfigMap cm = client.configMaps().inNamespace(namespace).resource(new ConfigMapBuilder()
          .withNewMetadata().withName(name).endMetadata()
          .build())
          .createOrReplace();
      client.configMaps().inNamespace(namespace).withName(name)
          .patch(new ConfigMapBuilder().withNewMetadata().withName(name).endMetadata().addToData("key", "value").build());
      //noinspection Convert2Lambda
      client.configMaps().inNamespace(namespace).withName(name).edit(new Visitor<ObjectMetaBuilder>() {
        @Override
        public void visit(ObjectMetaBuilder omb) {
          omb.addToAnnotations("annotation", "value");
        }
      });
      client.configMaps().resource(cm).delete();
    } catch (Exception e) {
      logger.error("Global Error: {}", e.getMessage(), e);
    }
  }

  private static Watch newConfigMapWatch(KubernetesClient client) {
    return client.configMaps().watch(new Watcher<ConfigMap>() {
      @Override
      public void eventReceived(Action action, ConfigMap resource) {
        logger.info("Watch event received {}: {}", action.name(), resource.getMetadata().getName());
      }

      @Override
      public void onClose(WatcherException e) {
        logger.error("Watch error received: {}", e.getMessage(), e);
      }

      @Override
      public void onClose() {
        logger.info("Watch gracefully closed");
      }
    });
  }

}
