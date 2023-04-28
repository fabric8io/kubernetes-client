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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NamespaceIT {

  KubernetesClient client;

  @Test
  void testCrud() {
    // Load
    Namespace namespace = client.namespaces().load(getClass().getResourceAsStream("/test-namespace.yml")).item();
    assertThat(namespace).isNotNull();
    assertEquals("fabric8-test", namespace.getMetadata().getName());

    // Create
    namespace = client.namespaces().create(namespace);
    assertNotNull(namespace);

    // Read
    namespace = client.namespaces().withName("fabric8-test").get();
    assertNotNull(namespace);
    assertEquals("fabric8-test", namespace.getMetadata().getName());

    // Update
    namespace = client.namespaces().withName("fabric8-test").edit(c -> new NamespaceBuilder(c)
        .editOrNewMetadata().withResourceVersion(null).addToAnnotations("foo", "bar").endMetadata()
        .build());
    assertNotNull(namespace);
    assertEquals("bar", namespace.getMetadata().getAnnotations().get("foo"));

    // Delete
    assertTrue(client.namespaces().withName("fabric8-test").delete().size() == 1);
  }
}
