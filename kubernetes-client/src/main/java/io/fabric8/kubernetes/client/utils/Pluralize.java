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
package io.fabric8.kubernetes.client.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pluralize implements UnaryOperator<String>
{

  private static Pluralize INSTANCE = null;
  private static final Object LOCK = new Object();
  private static final List<String> UNCOUNTABLE = Arrays.asList("equipment", "fish", "information", "money", "rice", "series", "sheep", "species");
  private static final List<UnaryOperator<String>> PLURALS = Arrays.<UnaryOperator<String>>asList(
            //Irregulars
            new StringReplace("(p)eople$", "$1erson"),
            new StringReplace("(m)en$", "$1an"),
            new StringReplace("(c)hildren$", "$1hild"),
            new StringReplace("(s)exes$", "$1ex"),
            new StringReplace("(m)oves$", "$1ove"),
            new StringReplace("(s)tadiums$", "$1tadium"),

            //Rules
            new StringReplace("(quiz)$", "$1zes"),
            new StringReplace("(matr)ix$", "$1ices"),
            new StringReplace("(vert|ind)ex$", "$1ices"),
            new StringReplace("^(ox)$", "$1en"),
            new StringReplace("(alias|status)$", "$1"),
            new StringReplace("(alias|status)$", "$1es"),
            new StringReplace("(octop|vir)us$", "$1us"),
            new StringReplace("(cris|ax|test)is$", "$1es"),
            new StringReplace("(shoe)$", "$1s"),
            new StringReplace("(o)$", "$1es"),
            new StringReplace("(bus)$", "$1es"),
            new StringReplace("([m|l])ouse$", "$1ice"),
            new StringReplace("(x|ch|ss|sh)$", "$1es"),
            new StringReplace("(m)ovie$", "$1ovies"),
            new StringReplace("(s)eries$", "$1eries"),
            new StringReplace("([^aeiouy]|qu)y$", "$1ies"),
            new StringReplace("([lr])f$", "$1ves"),
            new StringReplace("(tive)$", "$1s"),
            new StringReplace("(hive)$", "$1s"),
            new StringReplace("([^f])fe$", "$1ves"),
            new StringReplace("(^analy)sis$", "$1sis"),
            new StringReplace("((a)naly|(b)a|(d)iagno|(p)arenthe|(p)rogno|(s)ynop|(t)he)ses$", "$1$2sis"),
            new StringReplace("([ti])um$", "$1a"),
            new StringReplace("(n)ews$", "$1ews"),
            new StringReplace("(s|si|u)s$", "$1s")
    );

    public static String toPlural(String word) {
      if (INSTANCE != null) {
        return INSTANCE.apply(word);
      }

      synchronized (LOCK) {
        if (INSTANCE == null) {
          INSTANCE = new Pluralize();
        }
      }
      return INSTANCE.apply(word);
    }

    public String apply(String word) {
        if (word == null) {
            return null;
        } else if (word.isEmpty()) {
            return word;
        } else if (UNCOUNTABLE.contains(word)) {
            return word;
        } else if (isAlreadyPlural(word)) {
            return word;
        }

        for (UnaryOperator<String> function : PLURALS) {
            String result = function.apply(word);
            if (result != null) {
                return result;
            }
        }
        return word + "s";
    }

    /**
     * Rudimentary implementation of checking whether word is plural or not.
     * It can be further improved to handle complex cases.
     *
     * @param word
     * @return Boolean value indicating whether it's already plural or not
     */
    private boolean isAlreadyPlural(String word) {
        if(!word.endsWith("ss")) {
            if(word.endsWith("s")) {
                return true;
            }
        }
        return false;
    }

  private static class StringReplace implements UnaryOperator<String> {

    private final String target;
    private final String replacement;
    private final Pattern pattern;


    public StringReplace(String target, String replacement) {
        this.target = target;
        this.replacement = replacement;
        this.pattern = Pattern.compile(target, Pattern.CASE_INSENSITIVE);
    }

    public String apply(String word) {
        Matcher matcher = this.pattern.matcher(word);
        if (!matcher.find()) {
            return null;
        }
        return matcher.replaceAll(replacement);
    }
  }
}
