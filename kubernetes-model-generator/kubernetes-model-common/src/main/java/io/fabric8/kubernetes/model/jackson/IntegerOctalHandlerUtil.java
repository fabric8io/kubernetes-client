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
package io.fabric8.kubernetes.model.jackson;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerOctalHandlerUtil {
  private static final Pattern OCTAL_NUMBER = Pattern.compile("(0[oO]?)[0-7]+");

  private IntegerOctalHandlerUtil() {
  }

  public static Integer createIntegerValue(JsonNode node) {
    String textValue = node.textValue();
    if (textValue != null) {
      Matcher octalNumberMatcher = OCTAL_NUMBER.matcher(textValue);
      if (octalNumberMatcher.matches()) {
        return Integer.valueOf(textValue.substring(octalNumberMatcher.group(1).length()), 8);
      }
    }
    return node.intValue();
  }
}
