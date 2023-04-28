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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

/**
 * This sample code is Java equivalent to `kubectl create -f test-pod.yml`. It loads
 * YAML manifest for specified pod and creates it in specified namespace
 */
public class PodCreateYamlEquivalent {
  public static void main(String[] args) {
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      // Load YAML manifest into Java object
      Pod pod = k8s.pods().load(PodCreateYamlEquivalent.class.getResourceAsStream("/test-pod.yaml")).item();
      // Apply manifest onto Kubernetes cluster
      k8s.pods().inNamespace("default").resource(pod).create();
    }
  }
}
