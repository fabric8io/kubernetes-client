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
package io.fabric8.java.generator.nodes;

import java.util.Set;
import java.util.TreeSet;

public class Keywords {

  private Keywords() {
  }

  protected static final Set<String> JAVA_KEYWORDS = new TreeSet<>();

  static {
    // From: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html
    JAVA_KEYWORDS.add("abstract");
    JAVA_KEYWORDS.add("continue");
    JAVA_KEYWORDS.add("for");
    JAVA_KEYWORDS.add("new");
    JAVA_KEYWORDS.add("switch");
    JAVA_KEYWORDS.add("assert");
    JAVA_KEYWORDS.add("default");
    JAVA_KEYWORDS.add("goto");
    JAVA_KEYWORDS.add("package");
    JAVA_KEYWORDS.add("synchronized");
    JAVA_KEYWORDS.add("boolean");
    JAVA_KEYWORDS.add("do");
    JAVA_KEYWORDS.add("if");
    JAVA_KEYWORDS.add("private");
    JAVA_KEYWORDS.add("this");
    JAVA_KEYWORDS.add("break");
    JAVA_KEYWORDS.add("double");
    JAVA_KEYWORDS.add("implements");
    JAVA_KEYWORDS.add("protected");
    JAVA_KEYWORDS.add("throw");
    JAVA_KEYWORDS.add("byte");
    JAVA_KEYWORDS.add("else");
    JAVA_KEYWORDS.add("import");
    JAVA_KEYWORDS.add("public");
    JAVA_KEYWORDS.add("throws");
    JAVA_KEYWORDS.add("case");
    JAVA_KEYWORDS.add("enum");
    JAVA_KEYWORDS.add("instanceof");
    JAVA_KEYWORDS.add("return");
    JAVA_KEYWORDS.add("transient");
    JAVA_KEYWORDS.add("catch");
    JAVA_KEYWORDS.add("extends");
    JAVA_KEYWORDS.add("int");
    JAVA_KEYWORDS.add("short");
    JAVA_KEYWORDS.add("try");
    JAVA_KEYWORDS.add("char");
    JAVA_KEYWORDS.add("final");
    JAVA_KEYWORDS.add("interface");
    JAVA_KEYWORDS.add("static");
    JAVA_KEYWORDS.add("void");
    JAVA_KEYWORDS.add("class");
    JAVA_KEYWORDS.add("finally");
    JAVA_KEYWORDS.add("long");
    JAVA_KEYWORDS.add("strictfp**");
    JAVA_KEYWORDS.add("volatile");
    JAVA_KEYWORDS.add("const");
    JAVA_KEYWORDS.add("float");
    JAVA_KEYWORDS.add("native");
    JAVA_KEYWORDS.add("super");
    JAVA_KEYWORDS.add("while");
  }

  static final String JAVA_UTIL_MAP = "java.util.Map";
  static final String JAVA_UTIL_LIST = "java.util.List";
  static final String JAVA_LANG_STRING = "java.lang.String";
  static final String ADDITIONAL_PROPERTIES = "additionalProperties";
}
