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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PluralizeTest {

  @DisplayName("toPlural, should return argument's plural")
  @ParameterizedTest(name = "{index}: ''{1}'' plural is ''{0}''")
  @MethodSource("toPluralInput")
  void toPlural(String plural, String singular) {
    assertEquals(plural, Pluralize.toPlural(singular));
  }

  static Stream<Arguments> toPluralInput() {
    return Stream.of(
        arguments("", ""),
        arguments(null, null),
        arguments("equipment", "equipment"),
        arguments("news", "news"),
        arguments("people", "person"),
        arguments("children", "child"),
        arguments("shoes", "shoe"),
        arguments("loves", "love"),
        arguments("movies", "movie"),
        arguments("lives", "life"),
        arguments("chives", "chive"),
        arguments("diminutives", "diminutive"),
        arguments("dice", "die"),
        arguments("scarves", "scarf"),
        arguments("humans", "human"),
        arguments("definitions", "definition"),
        arguments("statuses", "status"),
        arguments("endpoints", "endpoints"),
        arguments("pods", "podmetrics"),
        arguments("nodes", "nodemetrics"),
        arguments("women", "woman"),
        arguments("men", "man"),
        arguments("dnses", "dns"));
  }

}
