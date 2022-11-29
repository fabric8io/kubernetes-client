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
package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java equivalent of `kubectl config use-context my-cluster-name`. You can specify a different
 * context before creating the client(which may be different from current context in your KubeConfig).
 * Changing context after creation of client is not supported right now:
 * https://github.com/fabric8io/kubernetes-client/issues/1512
 */
public class ConfigUseContext {
  private static final Logger logger = LoggerFactory.getLogger(ConfigUseContext.class);

  public static void main(String[] args) {
    // Pass the context you want to use in Config.autoConfigure(..)
    Config config = Config.autoConfigure("minikube");
    // Use modified Config for your operations with KubernetesClient
    try (final KubernetesClient k8s = new KubernetesClientBuilder().withConfig(config).build()) {
      k8s.pods().inNamespace("default").list().getItems().stream()
          .map(Pod::getMetadata)
          .map(ObjectMeta::getName)
          .forEach(logger::info);
    }
  }
}
