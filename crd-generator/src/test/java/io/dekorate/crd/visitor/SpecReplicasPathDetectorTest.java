/**
 * Copyright 2018 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.dekorate.crd.visitor;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.dekorate.crd.examples.webserver.WebServerWithSpec;
import io.dekorate.crd.examples.webserver.WebServerWithStatusProperty;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;

class SpecReplicasPathDetectorTest {

  @Test
  public void shoudDetectSpecReplicasPath() throws Exception {
    TypeDef def = ClassTo.TYPEDEF.apply(WebServerWithStatusProperty.class);
    SpecReplicasPathDetector detector = new SpecReplicasPathDetector();
    def = new TypeDefBuilder(def).accept(detector).build();
    assertTrue(detector.getPath().isPresent());
    assertEquals(".replicas", detector.getPath().get());
  }


  @Test
  public void shoudDetectNestedSpecReplicasPath() throws Exception {
    TypeDef def = ClassTo.TYPEDEF.apply(WebServerWithSpec.class);
    SpecReplicasPathDetector detector = new SpecReplicasPathDetector();
    def = new TypeDefBuilder(def).accept(detector).build();
    assertTrue(detector.getPath().isPresent());
    assertEquals(".spec.replicas", detector.getPath().get());
  }
}

