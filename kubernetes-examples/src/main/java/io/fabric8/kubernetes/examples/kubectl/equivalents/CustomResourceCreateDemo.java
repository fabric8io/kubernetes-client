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
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.examples.crds.Dummy;
import io.fabric8.kubernetes.examples.crds.DummyList;

/**
 * This example is Java equivalent to `kubectl create -f test-customresource.yaml`. It applies
 * the specified Custom Resource. It assumes that CustomResourceDefinition for the particular
 * CustomResource is already created.
 */
public class CustomResourceCreateDemo {
    public static void main(String[] args) {

        try (final KubernetesClient k8s = new DefaultKubernetesClient()) {
            // Dummy Client
            MixedOperation<Dummy, DummyList, Resource<Dummy>> dummyClient = null;
            CustomResourceDefinitionContext context = new CustomResourceDefinitionContext
                    .Builder()
                    .withGroup("demo.fabric8.io")
                    .withKind("Dummy")
                    .withName("dummies.demo.fabric8.io")
                    .withPlural("dummies")
                    .withScope("Namespaced")
                    .withVersion("v1")
                    .build();

            // Initializing Dummy Client
            dummyClient = k8s.customResources(context, Dummy.class, DummyList.class);

            // Get Dummy CustomResource
            Dummy dummy = dummyClient.load(CustomResourceCreateDemo.class.getResourceAsStream("/test-customresource.yaml")).get();

            // Using Dummy Client to create Dummy resource
            dummyClient.inNamespace("default").create(dummy);
        }

    }
}
