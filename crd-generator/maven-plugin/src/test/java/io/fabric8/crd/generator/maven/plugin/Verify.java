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
package io.fabric8.crd.generator.maven.plugin;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

class Verify {
  static void verifyExist(Path file) {
    Objects.requireNonNull(file);
    if (!Files.exists(file))
      throw new AssertionError("File " + file.normalize() + " does not exist");
  }

  static void verifyAbsent(Path file) {
    Objects.requireNonNull(file);
    if (Files.exists(file))
      throw new AssertionError("File " + file.normalize() + " exists");
  }

  static void verifyContentEquals(Path file1, Path file2) throws IOException {
    verifyExist(file1);
    verifyExist(file2);

    if (!Objects.equals(readFile(file1), readFile(file2))) {
      throw new AssertionError("File contents not equal: " + file1.normalize() + " " + file2.normalize());
    }
  }

  private static String readFile(Path path) throws IOException {
    return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
  }
}
