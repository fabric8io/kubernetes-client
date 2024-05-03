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
package io.fabric8.crd.generator.cli;

import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

class SourceParameterTypeConverter
    implements CommandLine.ITypeConverter<SourceParameter> {

  private static final Pattern VALID_JAVA_IDENTIFIER = Pattern.compile(
      "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");

  private static final Pattern FQCN_PATTERN = Pattern.compile(
      "(" + VALID_JAVA_IDENTIFIER + "\\.)*" + VALID_JAVA_IDENTIFIER);

  static boolean isFQCN(String value) {
    return FQCN_PATTERN.matcher(value).matches();
  }

  @Override
  public SourceParameter convert(String value) {
    File f = new File(value);
    if (f.exists()) {
      try {
        return new SourceParameter.FileToScan(f.getCanonicalFile());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    if (isFQCN(value)) {
      return new SourceParameter.CustomResourceClass(value);
    }

    // fail fast if invalid input can be already detected here
    throw new IllegalArgumentException(
        "Not an existing file or a full qualified class name.");
  }
}
