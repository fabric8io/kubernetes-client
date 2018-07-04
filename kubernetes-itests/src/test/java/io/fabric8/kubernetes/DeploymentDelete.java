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

package io.fabric8.kubernetes;

import io.fabric8.kubernetes.client.KubernetesClient;

import java.util.concurrent.Callable;

public class DeploymentDelete implements Callable<Boolean> {

  private KubernetesClient client;
  private String name;
  private String namespace;

  public DeploymentDelete(KubernetesClient client, String name, String namespace) {
    this.client = client;
    this.name = name;
    this.namespace = namespace;
  }

  @Override
  public Boolean call() throws Exception {
    return this.client.extensions().deployments().inNamespace(this.namespace).list().getItems().size() == 0;
  }
}
