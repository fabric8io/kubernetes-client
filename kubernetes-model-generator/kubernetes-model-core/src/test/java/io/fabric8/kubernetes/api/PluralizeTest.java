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
package io.fabric8.kubernetes.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class PluralizeTest {
  @Test
  void pluralizeShouldWork() {
    assertNull(Pluralize.toPlural(null));
    assertEquals("", Pluralize.toPlural(""));
    
    assertEquals("equipment", Pluralize.toPlural("equipment"));
    assertEquals("news", Pluralize.toPlural("news"));

    assertEquals("people", Pluralize.toPlural("person"));
    assertEquals("children", Pluralize.toPlural("child"));
    assertEquals("shoes", Pluralize.toPlural("shoe"));
    assertEquals("loves", Pluralize.toPlural("love"));
    assertEquals("movies", Pluralize.toPlural("movie"));
    assertEquals("lives", Pluralize.toPlural("life"));
    assertEquals("chives", Pluralize.toPlural("chive"));
    assertEquals("diminutives", Pluralize.toPlural("diminutive"));
    assertEquals("dice", Pluralize.toPlural("die"));
    assertEquals("scarves", Pluralize.toPlural("scarf"));
    assertEquals("humans", Pluralize.toPlural("human"));

    assertEquals("definitions", Pluralize.toPlural("definition"));
    assertEquals("statuses", Pluralize.toPlural("status"));
    assertEquals("endpoints", Pluralize.toPlural("endpoints"));
  }

}
