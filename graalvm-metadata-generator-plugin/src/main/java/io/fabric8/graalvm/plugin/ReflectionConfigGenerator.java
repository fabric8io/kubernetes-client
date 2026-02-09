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
package io.fabric8.graalvm.plugin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generates GraalVM reflect-config.json files.
 */
public class ReflectionConfigGenerator {

  private final ObjectMapper objectMapper;
  private final boolean allDeclaredConstructors;
  private final boolean allDeclaredMethods;
  private final boolean allDeclaredFields;

  public ReflectionConfigGenerator(boolean allDeclaredConstructors, boolean allDeclaredMethods,
      boolean allDeclaredFields) {
    this.allDeclaredConstructors = allDeclaredConstructors;
    this.allDeclaredMethods = allDeclaredMethods;
    this.allDeclaredFields = allDeclaredFields;

    this.objectMapper = new ObjectMapper();
    this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  /**
   * Generate reflection configuration and write to file.
   *
   * @param classes Classes to include in reflection configuration
   * @param outputFile Output file path
   * @param mergeWithExisting Whether to merge with existing configuration
   * @throws IOException if file operations fail
   */
  public void generate(Set<String> classes, File outputFile, boolean mergeWithExisting) throws IOException {
    Map<String, ReflectionEntry> entries = new LinkedHashMap<>();

    // Load existing configuration if merging
    if (mergeWithExisting && outputFile.exists()) {
      List<ReflectionEntry> existing = loadExisting(outputFile);
      for (ReflectionEntry entry : existing) {
        entries.put(entry.getName(), entry);
      }
    }

    // Add new classes
    for (String className : classes) {
      entries.computeIfAbsent(className, key -> {
        ReflectionEntry entry = new ReflectionEntry(key);
        entry.setCondition(new ReflectionEntry.Condition(key));
        entry.setAllDeclaredConstructors(allDeclaredConstructors);
        entry.setAllDeclaredMethods(allDeclaredMethods);
        entry.setAllDeclaredFields(allDeclaredFields);
        return entry;
      });
    }

    // Sort by class name for stable output
    List<ReflectionEntry> sortedEntries = new ArrayList<>(entries.values());
    sortedEntries.sort(Comparator.comparing(ReflectionEntry::getName));

    // Ensure output directory exists
    File outputDir = outputFile.getParentFile();
    if (outputDir != null && !outputDir.exists()) {
      outputDir.mkdirs();
    }

    // Write to file
    objectMapper.writeValue(outputFile, sortedEntries);
  }

  /**
   * Load existing reflection configuration from file.
   */
  private List<ReflectionEntry> loadExisting(File file) throws IOException {
    ReflectionEntry[] entries = objectMapper.readValue(file, ReflectionEntry[].class);
    return java.util.Arrays.asList(entries);
  }
}
