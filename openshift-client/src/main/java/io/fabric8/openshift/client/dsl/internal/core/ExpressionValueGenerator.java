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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// from: https://github.com/openshift/library-go/blob/aed018c215a122871be1768155cf9f3e658278fc/pkg/template/generator/expressionvalue.go
public class ExpressionValueGenerator {
  private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String NUMERALS = "0123456789";
  private static final String SYMBOLS = "~!@#$%^&*()-_+={}[]\\|<,>.?/\"';:`";
  private static final String ASCII = ALPHABET + NUMERALS + SYMBOLS;

  private static final Pattern RANGE_EXP = Pattern.compile("([\\\\]?[a-zA-Z0-9]\\-?[a-zA-Z0-9]?)");
  private static final Pattern GENERATORS_EXP = Pattern.compile("\\[([a-zA-Z0-9\\-\\\\]+)\\](\\{([0-9]+)\\})");
  private static final Pattern EXPRESSION_EXP = Pattern.compile("\\[(\\\\w|\\\\d|\\\\a|\\\\A)|([a-zA-Z0-9]\\-[a-zA-Z0-9])+\\]");

  private final Random random;

  public ExpressionValueGenerator(Random random) {
    this.random = random;
  }

  public String generateValue(final String expression) {
    String result = expression;
    Matcher matcher = GENERATORS_EXP.matcher(result);
    while (matcher.find()) {
      String matched = result.substring(matcher.start(), matcher.end());
      String ranges = getRange(matched);
      int length = Integer.parseInt(getLength(matched));

      result = replaceWithGenerated(
          result,
          matched,
          findExpressionPos(ranges),
          length,
          random);
      matcher = GENERATORS_EXP.matcher(result);
    }
    return result;
  }

  private static String alphabetSlice(char from, char to) {
    int leftPos = ASCII.indexOf(from);
    int rightPos = ASCII.lastIndexOf(to) + 1;
    if (leftPos > rightPos) {
      throw new IllegalArgumentException("invalid range specified: " + from + "-" + to);
    }
    return ASCII.substring(leftPos, rightPos);
  }

  private static String replaceWithGenerated(String s, String expression, List<CharRange> ranges, int length, Random random) {
    StringBuilder alphabet = new StringBuilder();
    for (CharRange r : ranges) {
      switch (r.rangeStr()) {
        case "\\w":
          alphabet.append(ALPHABET).append(NUMERALS).append("_");
          break;
        case "\\d":
          alphabet.append(NUMERALS);
          break;
        case "\\a":
          alphabet.append(ALPHABET).append(NUMERALS);
          break;
        case "\\A":
          alphabet.append(SYMBOLS);
          break;
        default:
          alphabet.append(alphabetSlice(r.start(), r.end()));
          break;
      }
    }
    String alphabetStr = removeDuplicateChars(alphabet.toString());
    StringBuilder result = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      result.append(alphabetStr.charAt(random.nextInt(alphabetStr.length())));
    }
    return s.replace(expression, result.toString());
  }

  protected static String removeDuplicateChars(String input) {
    return input.chars()
        .distinct()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
  }

  private static List<CharRange> findExpressionPos(String s) {
    Matcher matcher = RANGE_EXP.matcher(s);
    List<CharRange> result = new ArrayList<>();
    while (matcher.find()) {
      result.add(new CharRange(s.charAt(matcher.start()), s.charAt(matcher.end() - 1)));
    }
    return result;
  }

  private static String getRange(String s) {
    int lastOpenCurly = s.lastIndexOf("{");
    String expr = s.substring(0, lastOpenCurly);
    if (!EXPRESSION_EXP.matcher(expr).find()) {
      throw new IllegalArgumentException("malformed expression syntax: " + expr);
    }
    return expr;
  }

  private static String getLength(String s) {
    int lastOpenCurly = s.lastIndexOf("{");
    String lengthStr = s.substring(lastOpenCurly + 1, s.length() - 1);
    int length = Integer.parseInt(lengthStr);
    if (length > 0 && length <= 255) {
      return lengthStr;
    }
    throw new IllegalArgumentException("invalid range: must be within [1-255] characters (" + length + ")");
  }

}
