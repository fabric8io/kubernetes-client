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
package io.fabric8.crdv2.generator.v1;

import io.fabric8.crdv2.example.webserver.WebServerWithSpec;
import io.fabric8.crdv2.example.webserver.WebServerWithStatusProperty;
import io.fabric8.crdv2.generator.ResolvingContext;
import io.fabric8.kubernetes.model.annotation.SpecReplicas;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpecReplicasPathTest {

  @Test
  public void shoudDetectSpecReplicasPath() throws Exception {
    JsonSchema resolver = new JsonSchema(ResolvingContext.defaultResolvingContext(false), WebServerWithStatusProperty.class);
    Optional<String> path = resolver.getSinglePath(SpecReplicas.class);
    assertTrue(path.isPresent());
    assertEquals(".replicas", path.get());
  }

  @Test
  public void shoudDetectNestedSpecReplicasPath() throws Exception {
    JsonSchema resolver = new JsonSchema(ResolvingContext.defaultResolvingContext(false), WebServerWithSpec.class);
    Optional<String> path = resolver.getSinglePath(SpecReplicas.class);
    assertTrue(path.isPresent());
    assertEquals(".spec.replicas", path.get());
  }
}
