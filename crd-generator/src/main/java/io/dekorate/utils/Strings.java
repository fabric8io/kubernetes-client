/**
 * Copyright 2018 The original authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.dekorate.utils;

import io.dekorate.DekorateException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Strings {

  private static final char COMMA = ',';

  public static boolean isNotNullOrEmpty(String str) {
    return !isNullOrEmpty(str);
  }

  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

  public static String join(final Object[] array) {
    return join(array, ',');
  }

  public static String join(final Object[] array, final char separator) {
    if (array == null) {
      return null;
    }
    if (array.length == 0) {
      return "";
    }
    final StringBuilder buf = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      if (i > 0) {
        buf.append(separator);
      }
      if (array[i] != null) {
        buf.append(array[i]);
      }
    }
    return buf.toString();
  }

  /**
   * Uppercase the first character of the word and ignore the rest.
   * Examples:
   * null -> null
   * "" -> ""
   * "a" -> "A"
   * "string" -> "String"
   * "myString" -> "MyString"
   *
   * @param str The input string.
   * @return The input string with the first character upper cased.
   */
  public static String uppercaseFirst(String str) {
    if (str == null) {
      return null;
    }

    if (str.isEmpty()) {
      return str;
    }

    if (str.length() == 1) {
      return str.toUpperCase();
    }
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  /**
   * Lowercase the first character of the word and ignore the rest.
   * Examples:
   * null -> null
   * "" -> ""
   * "A" -> "a"
   * "String" -> "string"
   * "MyString" -> "myString"
   *
   * @param str The input string.
   * @return The input string with the first character lower cased.
   */

  public static String lowerFirst(String str) {
    if (str == null) {
      return null;
    }

    if (str.isEmpty()) {
      return str;
    }

    if (str.length() == 1) {
      return str.toLowerCase();
    }
    return str.substring(0, 1).toLowerCase() + str.substring(1);
  }

  /**
   * Convert kebab case to camel case.
   *
   * @param The input string.
   * @return The camel cased string.
   */
  public static String kebabToCamelCase(String str) {
    final AtomicBoolean first = new AtomicBoolean(true);
    return str != null && str.contains("-") ? Arrays.stream(str.split("-"))
      .map(s -> first.getAndSet(false) ? s : Strings.uppercaseFirst(s))
      .collect(Collectors.joining()) : str;
  }

  public static String read(Path path) {
    try {
      return new String(Files.readAllBytes(path));
    } catch (IOException e) {
      throw DekorateException.launderThrowable(e);
    }
  }

  public static String read(InputStream is) {
    try (BufferedReader buffer = new BufferedReader(new InputStreamReader(is))) {
      return buffer.lines().collect(Collectors.joining("\n"));
    } catch (IOException e) {
      throw DekorateException.launderThrowable(e);
    }
  }
}
