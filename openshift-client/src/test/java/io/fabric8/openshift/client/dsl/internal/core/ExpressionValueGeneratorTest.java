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
package io.fabric8.openshift.client.dsl.internal.core;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpressionValueGeneratorTest {

  static class ExpressionValuesArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
      return Stream.of(
          Arguments.of("test[0-9]{1}x", "test6x"),
          Arguments.of("[0-1]{8}", "11100011"),
          Arguments.of("0x[A-F0-9]{4}", "0x545A"),
          Arguments.of("[a-zA-Z0-9]{8}", "KaP00gmR"),
          Arguments.of("test[A-Z0-9]{4}template", "testQU7Etemplate"),
          Arguments.of("[\\d]{3}", "645"),
          Arguments.of("[\\w]{20}", "0V86t3tosHvHdzUwQKTB"),
          Arguments.of("[\\a]{10}", "KaP00gmRS2"),
          Arguments.of("[\\A]{10}", ">|>~-{'>,]"),
          Arguments.of("strongPassword[\\w]{3}[\\A]{3}", "strongPassword0V8~-{"),
          Arguments.of("admin[0-9]{2}[A-Z]{2}", "admin64DK"),
          Arguments.of("admin[0-9]{2}test[A-Z]{2}", "admin64testDK"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(ExpressionValuesArgumentsProvider.class)
  public void generateStringFromRegEx(String input, String expected) {
    // Arrange
    Random random = new Random();
    random.setSeed(7);
    ExpressionValueGenerator generator = new ExpressionValueGenerator(random);

    // Act
    String result = generator.generateValue(input);

    // Assert
    assertEquals(expected, result);
  }

  static class DuplicatesArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
      return Stream.of(
          Arguments.of("abcdefgh", "abcdefgh"),
          Arguments.of("abcabc", "abc"),
          Arguments.of("1111111", "1"),
          Arguments.of("1234567890", "1234567890"),
          Arguments.of("test@@", "tes@"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DuplicatesArgumentsProvider.class)
  public void removeDuplicatedCharacters(String input, String expected) {
    // Arrange
    ExpressionValueGenerator generator = new ExpressionValueGenerator(new Random());

    // Act
    String result = ExpressionValueGenerator.removeDuplicateChars(input);

    // Assert
    assertEquals(expected, result);
  }

  @Test
  public void maformedSyntax() {
    // Arrange
    ExpressionValueGenerator generator = new ExpressionValueGenerator(new Random());

    // Act
    IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
        () -> generator.generateValue("[ABC]{3}"));

    // Assert
    assertTrue(result.getMessage().contains("malformed"));
    assertTrue(result.getMessage().contains("syntax"));
  }

  @Test
  public void invalidRange() {
    // Arrange
    ExpressionValueGenerator generator = new ExpressionValueGenerator(new Random());

    // Act
    IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
        () -> generator.generateValue("[Z-A]{3}"));

    // Assert
    assertTrue(result.getMessage().contains("invalid"));
    assertTrue(result.getMessage().contains("range"));
  }

  @Test
  public void rangeOutOfBound() {
    // Arrange
    ExpressionValueGenerator generator = new ExpressionValueGenerator(new Random());

    // Act
    IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
        () -> generator.generateValue("[A-Z]{300}"));

    // Assert
    assertTrue(result.getMessage().contains("invalid"));
    assertTrue(result.getMessage().contains("range"));
  }

  @Test
  public void zeroRange() {
    // Arrange
    ExpressionValueGenerator generator = new ExpressionValueGenerator(new Random());

    // Act
    IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
        () -> generator.generateValue("[A-Z]{0}"));

    // Assert
    assertTrue(result.getMessage().contains("invalid"));
    assertTrue(result.getMessage().contains("range"));
  }
}
