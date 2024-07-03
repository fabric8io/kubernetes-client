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

import java.io.BufferedReader;
import java.io.IOException;
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

    long mismatchLinenumber = compareFilesByLine(file1, file2);
    if (mismatchLinenumber > 0) {
      throw new AssertionError("File contents not equal (line " + mismatchLinenumber + "): "
          + file1.normalize() + " " + file2.normalize());
    }
  }

  /**
   * Compares two files line-by-line, where the line is determined OS independent.
   *
   * @param path1 the first file
   * @param path2 the second file
   * @return Returns <code>-1</code>, if all lines are equal.
   *         Otherwise, the linenumber of the first mismatch.
   * @throws IOException if an I/ O error occurs opening one of the files
   */
  private static long compareFilesByLine(Path path1, Path path2) throws IOException {
    try (BufferedReader bf1 = Files.newBufferedReader(path1);
        BufferedReader bf2 = Files.newBufferedReader(path2)) {

      long lineNumber = 1;
      String line1 = "", line2 = "";
      while ((line1 = bf1.readLine()) != null) {
        line2 = bf2.readLine();
        if (!line1.equals(line2)) {
          return lineNumber;
        }
        lineNumber++;
      }
      if (bf2.readLine() == null) {
        return -1;
      } else {
        return lineNumber;
      }
    }
  }
}
