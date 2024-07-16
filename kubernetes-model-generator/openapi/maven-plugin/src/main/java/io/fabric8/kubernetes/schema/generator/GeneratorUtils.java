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
// Ported from https://github.com/manusa/yakc/blob/9272d649bfe05cd536d417fec64dcf679877bd14/buildSrc/src/main/java/com/marcnuri/yakc/schema/GeneratorUtils.java
package io.fabric8.kubernetes.schema.generator;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class GeneratorUtils {

  private final GeneratorSettings settings;

  public GeneratorUtils(GeneratorSettings settings) {
    this.settings = settings;
  }

  public static Predicate<? super Map.Entry<String, ?>> filter(GeneratorSettings gs) {
    return e -> {
      for (String regex : gs.getSkipGenerationRegexes()) {
        if (e.getKey().matches(regex)) {
          return false;
        }
      }
      if (gs.getIncludeGenerationRegexes().isEmpty()) {
        return true;
      }
      for (String regex : gs.getIncludeGenerationRegexes()) {
        if (e.getKey().matches(regex)) {
          return true;
        }
      }
      return false;
    };
  }

  public String readTemplate(String name) {
    try (var stream = SchemaUtils.class.getResourceAsStream("/templates/" + name + ".mustache")) {
      return new String(Objects.requireNonNull(stream).readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException ex) {
      settings.getLogger().severe(ex.getMessage());
      throw new GeneratorException("Can't load template " + name);
    }
  }

  public final void writeFile(Path file, String fileContents) {
    try {
      Files.writeString(file, fileContents,
          StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException ex) {
      settings.getLogger().severe(ex.getMessage());
      throw new GeneratorException("Can't write java generated class " + file.toString());
    }
  }

  public static void cleanSourceDirectory(File sourceDirectory) {
    try {
      FileUtils.deleteDirectory(sourceDirectory);
    } catch (IOException ex) {
      throw new GeneratorException("Can't clean existent generated sources");
    }
  }
}
