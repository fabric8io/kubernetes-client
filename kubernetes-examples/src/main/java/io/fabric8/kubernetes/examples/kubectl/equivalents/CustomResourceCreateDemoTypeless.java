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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;

/**
 * This example is Java equivalent to `kubectl create -f test-customresource.yaml`. It applies
 * the specified Resource. It assumes that CustomResourceDefinition for the particular
 * CustomResource is already created. Note that with this approach, you don't need to provide
 * POJOs for your custom types but you're also losing type safety since it would be upto the
 * user to manipulate raw Resources as GenericKubernetesResource.
 */
public class CustomResourceCreateDemoTypeless {
  public static void main(String[] args) {
    try (final KubernetesClient k8s = new KubernetesClientBuilder().build()) {
      // Create Custom Resource Context
      ResourceDefinitionContext context = new ResourceDefinitionContext.Builder()
          .withGroup("demo.fabric8.io")
          .withKind("Dummy")
          .withPlural("dummies")
          .withNamespaced(true)
          .withVersion("v1")
          .build();

      // Load from Yaml
      Resource<GenericKubernetesResource> dummyObject = k8s.genericKubernetesResources(context)
          .load(CustomResourceCreateDemoTypeless.class.getResourceAsStream("/test-customresource.yaml"));
      // Create Custom Resource
      dummyObject.create();
    }
  }
}
