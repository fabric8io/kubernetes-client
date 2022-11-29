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

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This example is Java equivalent to `kubectl get events`. It gets
 * events related to specified namespace in a Kubernetes Cluster.
 */
public class EventsGetEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(EventsGetEquivalent.class);

  public static void main(String[] args) {
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      k8s.v1().events().inNamespace("default").list().getItems().stream()
          .map(Event::getMessage)
          .forEach(logger::info);
    }
  }
}
