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

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;

import java.util.List;

@SuppressWarnings("java:S106")
public class ListCustomResourceDefinitions {
  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      if (!client.supports(CustomResourceDefinition.class)
          && !client.supports(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition.class)) {
        System.out.println("WARNING this cluster does not support the API Group apiextensions.k8s.io");
        return;
      }
      CustomResourceDefinitionList list = client.apiextensions().v1beta1().customResourceDefinitions().list();
      if (list == null) {
        System.out.println("ERROR no list returned!");
        return;
      }
      List<CustomResourceDefinition> items = list.getItems();
      for (CustomResourceDefinition item : items) {
        System.out
            .println("CustomResourceDefinition " + item.getMetadata().getName() + " has version: " + item.getApiVersion());
      }
    } catch (KubernetesClientException e) {
      System.out.println("Failed: " + e);
      e.printStackTrace();
    }
  }
}
