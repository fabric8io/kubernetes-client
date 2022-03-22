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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pluralize implements UnaryOperator<String> {

  private static final Pluralize INSTANCE = new Pluralize();
  private static final Set<String> UNCOUNTABLE = new HashSet<>(Arrays.asList("equipment", "fish",
      "information", "money", "rice", "series", "sheep", "species", "news"));
  private static final Map<String, String> EXCEPTIONS = new HashMap<>();

  static {
    EXCEPTIONS.put("person", "people");
    EXCEPTIONS.put("woman", "women");
    EXCEPTIONS.put("man", "men");
    EXCEPTIONS.put("child", "children");
    EXCEPTIONS.put("ox", "oxen");
    EXCEPTIONS.put("die", "dice");
    EXCEPTIONS.put("podmetrics", "pods");
    EXCEPTIONS.put("nodemetrics", "nodes");
    EXCEPTIONS.put("networkattachmentdefinition", "network-attachment-definitions");
  }

  private static final List<UnaryOperator<String>> PLURALS = Arrays.asList(
      //Rules
      new StringReplace("([^aeiouy]|qu)y$", "$1ies"),
      new StringReplace("(x|ch|ss|sh)$", "$1es"),
      new StringReplace("(s)?ex$", "$1exes"),
      new StringReplace("(bus)$", "$1es"),
      new StringReplace("(quiz)$", "$1zes"),
      new StringReplace("(matr)ix$", "$1ices"),
      new StringReplace("(vert|ind)ex$", "$1ices"),
      new StringReplace("(alias|status|dns)$", "$1es"),
      new StringReplace("(octop|vir)us$", "$1us"),
      new StringReplace("(cris|ax|test)is$", "$1es"),
      new StringReplace("(o)$", "$1es"),
      new StringReplace("([m|l])ouse$", "$1ice"),
      new StringReplace("([lr])f$", "$1ves"),
      new StringReplace("([^f])fe$", "$1ves"),
      new StringReplace("(^analy)sis$", "$1sis"),
      new StringReplace("((a)naly|(b)a|(d)iagno|(p)arenthe|(p)rogno|(s)ynop|(t)he)ses$", "$1$2sis"),
      new StringReplace("([ti])um$", "$1a"),
      new StringReplace("(prometheus)$", "$1es"),
      new StringReplace("(s|si|u)s$", "$1s"));

  public static String toPlural(String word) {
    return INSTANCE.apply(word);
  }

  @Override
  public String apply(String word) {
    if (word == null || word.isEmpty() || UNCOUNTABLE.contains(word)) {
      return word;
    }

    // deal with exceptions
    String plural = EXCEPTIONS.get(word);
    if (plural != null) {
      return plural;
    }

    // apply rules
    for (UnaryOperator<String> function : PLURALS) {
      String result = function.apply(word);
      if (result != null) {
        return result;
      }
    }

    // we haven't found a match, if the word is already plural, return it or add a final 's'
    return isAlreadyPlural(word) ? word : word + "s";
  }

  /**
   * Rudimentary implementation of checking whether word is plural or not. It can be further
   * improved to handle complex cases.
   *
   * @param word the word to test
   * @return {@code true} if the specified word is already plural, {@code false} otherwise
   */
  private boolean isAlreadyPlural(String word) {
    if (!word.endsWith("ss")) {
      return word.endsWith("s");
    }
    return false;
  }

  private static class StringReplace implements UnaryOperator<String> {

    private final String replacement;
    private final Pattern pattern;

    public StringReplace(String target, String replacement) {
      this.replacement = replacement;
      this.pattern = Pattern.compile(target, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public String apply(String word) {
      Matcher matcher = this.pattern.matcher(word);
      if (!matcher.find()) {
        return null;
      }
      return matcher.replaceAll(replacement);
    }
  }
}
