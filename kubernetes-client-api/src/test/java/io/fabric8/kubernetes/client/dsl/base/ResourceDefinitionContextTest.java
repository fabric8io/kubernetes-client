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

package io.fabric8.kubernetes.client.dsl.base;

import io.fabric8.kubernetes.api.model.APIResourceBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceDefinitionContextTest {

  @Test
  void missingRequiredKindShouldFail() {
    ResourceDefinitionContext.Builder builder = new ResourceDefinitionContext.Builder();
    assertThrows(IllegalArgumentException.class, () -> builder.build());
    builder.withKind("Kind");
    ResourceDefinitionContext context = builder.build();
    assertEquals("kinds", context.getPlural());
  }

  @Test
  void fromCoreApiResource() {
    ResourceDefinitionContext context = ResourceDefinitionContext.fromApiResource("v1",
        new APIResourceBuilder().withKind("builtin").withName("builtins").withNamespaced(true).build());

    assertEquals("builtins", context.getPlural());
    assertEquals("builtin", context.getKind());
    assertTrue(context.isNamespaceScoped());
    assertEquals("", context.getGroup());
    assertEquals("v1", context.getVersion());
  }

}
