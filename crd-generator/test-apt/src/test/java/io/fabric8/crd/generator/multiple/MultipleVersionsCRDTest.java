/*
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
package io.fabric8.crd.generator.multiple;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleVersionsCRDTest {

  @Test
  void testCrd() {
    CustomResourceDefinition d = Serialization.unmarshal(getClass().getClassLoader()
        .getResourceAsStream("META-INF/fabric8/multiples.sample.fabric8.io-v1.yml"),
        CustomResourceDefinition.class);
    assertNotNull(d);
    assertEquals(2, d.getSpec().getVersions().size());

    Optional<CustomResourceDefinitionVersion> maybeV1Version = d.getSpec().getVersions().stream()
        .filter(version -> "v1".equals(version.getName())).findFirst();

    assertTrue(maybeV1Version.isPresent());
    CustomResourceDefinitionVersion v1Version = maybeV1Version.get();
    assertFalse(v1Version.getStorage());

    Optional<CustomResourceDefinitionVersion> maybeV2Version = d.getSpec().getVersions().stream()
        .filter(version -> "v2".equals(version.getName())).findFirst();

    assertTrue(maybeV2Version.isPresent());
    CustomResourceDefinitionVersion v2Version = maybeV2Version.get();
    assertTrue(v2Version.getStorage());
  }
}
