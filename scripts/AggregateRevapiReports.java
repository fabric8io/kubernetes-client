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
/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
//SOURCES GenerateRevapiIndex.java
//DEPS com.fasterxml.jackson.core:jackson-databind:2.20.0
//DEPS org.freemarker:freemarker:2.3.34

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Step 1: Find revapi-report.json from each module's target/ directory and copy
 * into target/staging/ preserving the module path structure.
 * Step 2: Delegate to GenerateRevapiIndex to parse the staged JSON files and
 * produce per-module HTML pages and the overall index.
 */
class AggregateRevapiReports {

  static class ModuleReport {
    final Path jsonPath;
    final String modulePath;

    ModuleReport(Path jsonPath, String modulePath) {
      this.jsonPath = jsonPath;
      this.modulePath = modulePath;
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("Copying revapi-report.json files into target/staging...");

    Path rootDir = Paths.get(".");
    Path stagingDir = rootDir.resolve("target/staging");
    Files.createDirectories(stagingDir);

    List<ModuleReport> reports = findModuleReports(rootDir);
    System.out.println("Found " + reports.size() + " modules with revapi-report.json");

    for (ModuleReport report : reports) {
      Path dest = stagingDir.resolve(report.modulePath);
      Files.createDirectories(dest);
      Files.copy(report.jsonPath, dest.resolve("revapi-report.json"), StandardCopyOption.REPLACE_EXISTING);
      System.out.println("  Copied: " + report.modulePath);
    }

    System.out.println();
    System.out.println("✓ Copied " + reports.size() + " JSON reports into target/staging/");
    System.out.println("Generating HTML reports from staged JSON files...");

    GenerateRevapiIndex.main(args);

    System.out.println("✓ Open: target/staging/revapi-index.html");
  }

  static List<ModuleReport> findModuleReports(Path rootDir) throws IOException {
    List<ModuleReport> reports = new ArrayList<>();

    Files.walkFileTree(rootDir, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        String name = dir.getFileName() != null ? dir.getFileName().toString() : "";
        // Skip hidden directories (.git, .mvn, etc.) but not "." (root) or ".."
        if (name.length() > 1 && name.startsWith(".")) {
          return FileVisitResult.SKIP_SUBTREE;
        }
        // Avoid re-processing already-staged output
        if (dir.endsWith("target/staging")) {
          return FileVisitResult.SKIP_SUBTREE;
        }
        // revapi-report.json sits directly under target/, skip deeper subdirs
        Path parent = dir.getParent();
        if (parent != null && "target".equals(
          parent.getFileName() != null ? parent.getFileName().toString() : "")) {
          return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (!file.getFileName().toString().equals("revapi-report.json")) {
          return FileVisitResult.CONTINUE;
        }
        Path targetDir = file.getParent();
        if (targetDir == null || !"target".equals(
          targetDir.getFileName() != null ? targetDir.getFileName().toString() : "")) {
          return FileVisitResult.CONTINUE;
        }
        Path moduleDir = targetDir.getParent();
        if (moduleDir == null) {
          return FileVisitResult.CONTINUE;
        }
        Path relative = rootDir.toAbsolutePath().normalize()
          .relativize(moduleDir.toAbsolutePath().normalize());
        String relStr = relative.toString();
        if (!relStr.isEmpty()) {
          reports.add(new ModuleReport(file, relStr));
        }
        return FileVisitResult.CONTINUE;
      }
    });

    return reports;
  }
}
