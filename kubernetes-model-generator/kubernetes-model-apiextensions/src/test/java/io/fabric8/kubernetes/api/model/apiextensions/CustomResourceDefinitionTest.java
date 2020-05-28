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
package io.fabric8.kubernetes.api.model.apiextensions;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomResourceDefinitionTest {
  @Test
  public void testBuilder() {
    CustomResourceDefinition crd = new io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder()
      .withApiVersion("apiextensions.k8s.io/v1beta1")
      .withNewMetadata()
      .withName("itests.examples.fabric8.io")
      .endMetadata()
      .withNewSpec()
      .withGroup("examples.fabric8.io")
      .withVersion("v1")
      .addAllToVersions(Collections.singletonList(new io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionVersionBuilder()
        .withName("v1")
        .withServed(true)
        .withStorage(true)
        .build()))
      .withScope("Namespaced")
      .withNewNames()
      .withPlural("itests")
      .withSingular("itest")
      .withKind("Itest")
      .withShortNames("it")
      .endNames()
      .endSpec()
      .build();

    assertEquals("itests.examples.fabric8.io", crd.getMetadata().getName());
    assertEquals("examples.fabric8.io", crd.getSpec().getGroup());
    assertEquals("v1", crd.getSpec().getVersion());
    assertEquals("Namespaced", crd.getSpec().getScope());
  }
}
