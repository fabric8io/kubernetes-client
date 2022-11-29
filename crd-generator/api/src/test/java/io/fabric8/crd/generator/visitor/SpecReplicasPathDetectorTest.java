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
package io.fabric8.crd.generator.visitor;

import io.fabric8.crd.example.webserver.WebServerWithSpec;
import io.fabric8.crd.example.webserver.WebServerWithStatusProperty;
import io.sundr.adapter.api.AdapterContext;
import io.sundr.adapter.api.Adapters;
import io.sundr.model.TypeDef;
import io.sundr.model.TypeDefBuilder;
import io.sundr.model.repo.DefinitionRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpecReplicasPathDetectorTest {

  public static final AdapterContext CONTEXT = AdapterContext.create(DefinitionRepository.getRepository());

  @Test
  public void shoudDetectSpecReplicasPath() throws Exception {
    TypeDef def = Adapters.adaptType(WebServerWithStatusProperty.class, CONTEXT);
    SpecReplicasPathDetector detector = new SpecReplicasPathDetector();
    def = new TypeDefBuilder(def).accept(detector).build();
    assertTrue(detector.getPath().isPresent());
    assertEquals(".replicas", detector.getPath().get());
  }

  @Test
  public void shoudDetectNestedSpecReplicasPath() throws Exception {
    TypeDef def = Adapters.adaptType(WebServerWithSpec.class, CONTEXT);
    SpecReplicasPathDetector detector = new SpecReplicasPathDetector();
    def = new TypeDefBuilder(def).accept(detector).build();
    assertTrue(detector.getPath().isPresent());
    assertEquals(".spec.replicas", detector.getPath().get());
  }
}
