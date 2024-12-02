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
package io.fabric8.java.generator;

import io.fabric8.java.generator.nodes.AbstractJSONSchema2Pojo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSanitizationTest {

  @Test
  void shouldRemoveDashes() {
    // Arrange
    final var str = "property-name";

    // Act
    final var res = AbstractJSONSchema2Pojo.sanitizeString(str);

    // Assert
    assertThat(res).isEqualTo("propertyName");
  }

  @Test
  void shouldRemoveTrailingDashes() {
    // Arrange
    final var str = "property-name-";

    // Act
    final var res = AbstractJSONSchema2Pojo.sanitizeString(str);

    // Assert
    assertThat(res).isEqualTo("propertyName");
  }

  @Test
  void shouldAddTrailingUnderscoreOnInvalidClassAndPackageNames() {
    // Arrange
    final var str = "3property-name-";

    // Act
    final var res = AbstractJSONSchema2Pojo.sanitizeString(str);

    // Assert
    assertThat(res).isEqualTo("_3propertyName");
  }
}
