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

package io.dekorate.crd.util;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.example.webserver.WebServerStatus;
import io.dekorate.crd.example.webserver.WebServerWithStatusProperty;
import io.dekorate.crd.example.webserver.WebServerWithoutStatusProperty;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.Property;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeRef;

public class TypesTest {

  @Test
  public void shouldFindStatusPropety() {
    TypeDef def = ClassTo.TYPEDEF.apply(WebServerWithStatusProperty.class);
    CustomResourceConfig config = new CustomResourceConfig();
    Optional<Property> p = Types.findStatusProperty(config, def);
    assertTrue(p.isPresent());
  }
  

  @Test
  public void shouldFindStatusFromConfig() {
    TypeDef def = ClassTo.TYPEDEF.apply(WebServerWithoutStatusProperty.class);
    CustomResourceConfig config = new CustomResourceConfigBuilder()
      .withStatusClassName(WebServerStatus.class.getName())
      .build();

    Optional<TypeRef> type = Types.findStatusType(config, def);
    assertTrue(type.isPresent());
  }

}
