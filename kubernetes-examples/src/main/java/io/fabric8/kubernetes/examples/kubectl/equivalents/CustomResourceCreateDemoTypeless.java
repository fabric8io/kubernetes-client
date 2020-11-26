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

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;

import java.io.IOException;
import java.util.Map;

/**
 * This example is Java equivalent to `kubectl create -f test-customresource.yaml`. It applies
 * the specified Custom Resource. It assumes that CustomResourceDefinition for the particular
 * CustomResource is already created. Note that with this approach, you don't need to provide
 * POJOs for your custom types but you're also losing type safety since it would be upto the
 * user to manipulate raw CustomResource as HashMaps.
 */
public class CustomResourceCreateDemoTypeless {
  public static void main(String[] args) {
    try (final KubernetesClient k8s = new DefaultKubernetesClient()) {
      // Create Custom Resource Context
      CustomResourceDefinitionContext context = new CustomResourceDefinitionContext
        .Builder()
        .withGroup("demo.fabric8.io")
        .withKind("Dummy")
        .withName("dummies.demo.fabric8.io")
        .withPlural("dummies")
        .withScope("Namespaced")
        .withVersion("v1")
        .build();

      // Load from Yaml
      Map<String, Object> dummyObject = k8s.customResource(context)
        .load(CustomResourceCreateDemoTypeless.class.getResourceAsStream("/test-customresource.yaml"));
      // Create Custom Resource
      k8s.customResource(context).create("default", dummyObject);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
