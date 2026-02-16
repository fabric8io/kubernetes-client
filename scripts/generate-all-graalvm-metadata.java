/// usr/bin/env jbang "$0" "$@" ; exit $?
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

//JAVA 11+

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * JBang wrapper script to generate GraalVM metadata for all Maven modules.
 *
 * Usage:
 *   jbang generate-all-graalvm-metadata.java [OPTIONS]
 *
 * Options:
 *   -r, --root <dir>                 Root directory of the Maven project (default: current directory)
 *   -s, --strategy <strategy>        Inclusion strategy (default: JACKSON_ANNOTATIONS)
 *   -d, --dry-run                    Show what would be processed without actually generating
 *   -h, --help                       Show this help message
 *
 * Examples:
 *   jbang generate-all-graalvm-metadata.java
 *   jbang generate-all-graalvm-metadata.java -r /path/to/project
 *   jbang generate-all-graalvm-metadata.java -s COMPREHENSIVE
 *   jbang generate-all-graalvm-metadata.java -d
 */
class generate_all_graalvm_metadata {

  private static final String DEFAULT_STRATEGY = "JACKSON_ANNOTATIONS";

  public static void main(String[] args) {
    try {
      var config = parseArgs(args);
      if (config == null) {
        return;
      }

      var rootDir = config.rootDir;
      var pomFile = new File(rootDir, "pom.xml");

      if (!pomFile.exists()) {
        System.err.println("ERROR: pom.xml not found in: " + rootDir);
        System.exit(1);
      }

      System.out.println("=".repeat(80));
      System.out.println("GraalVM Metadata Generator - Batch Mode");
      System.out.println("=".repeat(80));
      System.out.println("Root directory: " + rootDir);
      System.out.println("Strategy: " + config.strategy);
      System.out.println("Dry run: " + config.dryRun);
      System.out.println();

      // Discover all Maven modules
      var modules = discoverModules(rootDir);
      System.out.println("Found " + modules.size() + " Maven modules");
      System.out.println();

      var processedCount = 0;
      var skippedCount = 0;
      var failedCount = 0;

      for (var module : modules) {
        var jandexIndex = new File(module, "target/classes/META-INF/jandex.idx");

        if (!jandexIndex.exists()) {
          System.out.println("⊘ SKIP: " + getModuleName(rootDir, module) + " (no jandex index)");
          skippedCount++;
          continue;
        }

        var moduleName = getModuleName(rootDir, module);
        System.out.println("▶ PROCESS: " + moduleName);

        if (config.dryRun) {
          System.out.println("  Would generate metadata from: " + jandexIndex);
          processedCount++;
        } else {
          var success = generateMetadata(jandexIndex, config.strategy);
          if (success) {
            System.out.println("  ✓ Successfully generated metadata");
            processedCount++;
          } else {
            System.err.println("  ✗ Failed to generate metadata");
            failedCount++;
          }
        }
        System.out.println();
      }

      // Print summary
      System.out.println("=".repeat(80));
      System.out.println("Summary:");
      System.out.println("  Total modules: " + modules.size());
      System.out.println("  Processed: " + processedCount);
      System.out.println("  Skipped: " + skippedCount);
      System.out.println("  Failed: " + failedCount);
      System.out.println("=".repeat(80));

      if (failedCount > 0) {
        System.exit(1);
      }

    } catch (Exception e) {
      System.err.println("ERROR: " + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
  }

  static List<File> discoverModules(File rootDir) throws Exception {
    var modules = new ArrayList<File>();
    discoverModulesRecursive(rootDir, modules);
    return modules;
  }

  static void discoverModulesRecursive(File dir, List<File> modules) throws Exception {
    var pomFile = new File(dir, "pom.xml");
    if (!pomFile.exists()) {
      return;
    }

    // Add current module
    modules.add(dir);

    // Parse pom.xml to find child modules using simple XML parsing
    var childModules = extractModulesFromPom(pomFile);

    if (childModules != null && !childModules.isEmpty()) {
      for (var moduleName : childModules) {
        var moduleDir = new File(dir, moduleName);
        if (moduleDir.exists() && moduleDir.isDirectory()) {
          discoverModulesRecursive(moduleDir, modules);
        }
      }
    }
  }

  static List<String> extractModulesFromPom(File pomFile) throws Exception {
    var modules = new ArrayList<String>();

    try {
      var dbFactory = DocumentBuilderFactory.newInstance();
      var dBuilder = dbFactory.newDocumentBuilder();
      var doc = dBuilder.parse(pomFile);
      doc.getDocumentElement().normalize();

      // Get all <module> elements
      var moduleNodes = doc.getElementsByTagName("module");
      for (int i = 0; i < moduleNodes.getLength(); i++) {
        var node = moduleNodes.item(i);
        // Only get direct children of <modules>, not nested ones
        if (node.getParentNode().getNodeName().equals("modules")) {
          var moduleText = node.getTextContent().trim();
          if (!moduleText.isEmpty()) {
            modules.add(moduleText);
          }
        }
      }
    } catch (Exception e) {
      // If parsing fails, just return empty list
      System.err.println("Warning: Could not parse " + pomFile + ": " + e.getMessage());
    }

    return modules;
  }

  static String getModuleName(File rootDir, File moduleDir) {
    var relativePath = rootDir.toPath().relativize(moduleDir.toPath());
    return relativePath.toString().isEmpty() ? "." : relativePath.toString();
  }

  static boolean generateMetadata(File jandexIndex, String strategy) {
    try {
      // Get the path to the generate-graalvm-metadata.java script
      var scriptPath = Paths.get("scripts/generate-graalvm-metadata.java").toAbsolutePath();

      // If we're running from scripts directory, adjust path
      if (!Files.exists(scriptPath)) {
        scriptPath = Paths.get("generate-graalvm-metadata.java").toAbsolutePath();
      }

      if (!Files.exists(scriptPath)) {
        System.err.println("  ERROR: Could not find generate-graalvm-metadata.java script");
        return false;
      }

      var processBuilder = new ProcessBuilder(
        "jbang",
        scriptPath.toString(),
        jandexIndex.getAbsolutePath(),
        "-s",
        strategy
      );

      processBuilder.inheritIO();
      var process = processBuilder.start();
      var exitCode = process.waitFor();

      return exitCode == 0;

    } catch (Exception e) {
      System.err.println("  ERROR: " + e.getMessage());
      return false;
    }
  }

  static Config parseArgs(String[] args) {
    if (args.length > 0 && (args[0].equals("-h") || args[0].equals("--help"))) {
      showHelp();
      return null;
    }

    var config = new Config();
    config.rootDir = new File(".").getAbsoluteFile();
    config.strategy = DEFAULT_STRATEGY;
    config.dryRun = false;

    for (int i = 0; i < args.length; i++) {
      var arg = args[i];
      switch (arg) {
        case "-r":
        case "--root":
          config.rootDir = new File(args[++i]).getAbsoluteFile();
          break;
        case "-s":
        case "--strategy":
          config.strategy = args[++i];
          break;
        case "-d":
        case "--dry-run":
          config.dryRun = true;
          break;
        case "-h":
        case "--help":
          showHelp();
          return null;
        default:
          System.err.println("Unknown option: " + arg);
          showHelp();
          System.exit(1);
      }
    }

    return config;
  }

  static void showHelp() {
    System.out.println("GraalVM Metadata Generator - Batch Mode");
    System.out.println();
    System.out.println("Usage: jbang generate-all-graalvm-metadata.java [OPTIONS]");
    System.out.println();
    System.out.println("Options:");
    System.out.println("  -r, --root <dir>                 Root directory of Maven project (default: current)");
    System.out.println("  -s, --strategy <strategy>        Inclusion strategy (default: JACKSON_ANNOTATIONS)");
    System.out.println("                                   Options: JACKSON_ANNOTATIONS, SUNDRIO_BUILDERS,");
    System.out.println("                                           KUBERNETES_RESOURCES, COMPREHENSIVE,");
    System.out.println("                                           PATTERN_BASED, ALL_PUBLIC_CLASSES,");
    System.out.println("                                           DIRECT_OBJECT_SUBCLASSES");
    System.out.println("  -d, --dry-run                    Show what would be processed without generating");
    System.out.println("  -h, --help                       Show this help message");
    System.out.println();
    System.out.println("Examples:");
    System.out.println("  jbang generate-all-graalvm-metadata.java");
    System.out.println("  jbang generate-all-graalvm-metadata.java -r /path/to/project");
    System.out.println("  jbang generate-all-graalvm-metadata.java -s COMPREHENSIVE");
    System.out.println("  jbang generate-all-graalvm-metadata.java -d");
    System.out.println();
    System.out.println("Note: This script requires modules to have Jandex indexes generated.");
    System.out.println("      Run 'mvn clean install' first to generate the indexes.");
  }

  static class Config {
    File rootDir;
    String strategy;
    boolean dryRun;
  }
}
