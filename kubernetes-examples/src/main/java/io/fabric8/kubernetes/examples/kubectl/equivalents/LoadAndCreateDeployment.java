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

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

/**
 * This example is Java equivalent to `kubectl create -f test-deploy.yaml`. It loads
 * Deployment YAML manifest and then applies to to Kubernetes Cluster.
 */
public class LoadAndCreateDeployment {
  public static void main(String[] args) {
    try (KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      // Load Deployment YAML Manifest into Java object
      Deployment deploy1 = k8s.apps().deployments()
          .load(LoadAndCreateDeployment.class.getResourceAsStream("/test-deploy.yaml"))
          .item();
      // Apply it to Kubernetes Cluster
      k8s.apps().deployments().inNamespace("default").resource(deploy1).create();
    }
  }
}
