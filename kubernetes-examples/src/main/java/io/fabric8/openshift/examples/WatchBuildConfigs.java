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

package io.fabric8.openshift.examples;

import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class WatchBuildConfigs {

  private static final Logger logger = LoggerFactory.getLogger(WatchBuildConfigs.class);

  public static void main(String[] args) {
    try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
      final String namespace = Optional.ofNullable(client.getNamespace()).orElse("myproject");
      logger.info("Watching BuildConfigs in namespace {}", namespace);
      try (Watch watchable = client.buildConfigs().inNamespace(namespace).watch(new Watcher<BuildConfig>() {
        @Override
        public void eventReceived(Action action, BuildConfig resource) {
          logger.info(">> Action: {} on BuildConfig {} with version: {}",
              action.name(), resource.getMetadata().getName(), resource.getApiVersion());
        }

        @Override
        public void onClose(WatcherException cause) {
          logger.error("Error on Watcher (Closed): {}", cause.getMessage(), cause);
        }
      })) {
        logger.info("Created watchable {}", watchable);
      }
    } catch (KubernetesClientException e) {
      logger.error("Failed: {}", e.getMessage(), e);
    }
  }

}
