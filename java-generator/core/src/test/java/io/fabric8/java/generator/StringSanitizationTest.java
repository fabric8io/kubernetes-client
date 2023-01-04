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
package io.fabric8.java.generator;

import io.fabric8.java.generator.nodes.AbstractJSONSchema2Pojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSanitizationTest {

  @Test
  void shouldRemoveDashes() {
    // Arrange
    String str = "property-name";

    // Act
    String res = AbstractJSONSchema2Pojo.sanitizeString(str);

    // Assert
    assertEquals("propertyName", res);
  }

  @Test
  void shouldRemoveTrailingDashes() {
    // Arrange
    String str = "property-name-";

    // Act
    String res = AbstractJSONSchema2Pojo.sanitizeString(str);

    // Assert
    assertEquals("propertyName", res);
  }

  @Test
  void shouldAddTrailingUnderscoreOnInvalidClassAndPackageNames() {
    // Arrange
    String str = "3property-name-";

    // Act
    String res = AbstractJSONSchema2Pojo.sanitizeString(str);

    // Assert
    assertEquals("_3propertyName", res);
  }
}
