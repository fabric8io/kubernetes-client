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
package io.fabric8.java.generator.cli;

import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.FileJavaGenerator;
import io.fabric8.java.generator.JavaGenerator;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.Map;

@Command(name = "java-gen", mixinStandardHelpOptions = true, helpCommand = true, versionProvider = KubernetesClientVersionProvider.class)
public class GenerateJavaSources implements Runnable {

  @Option(names = { "-s",
      "--source" }, description = "The source(file or folder) with the CustomResourceDefinition(s) to use", required = true)
  File source;

  @Option(names = { "-t", "--target" }, description = "The folder to write the generated sources", required = true)
  File target;

  @Option(names = { "-enum-uppercase", "--enum-uppercase" }, description = "Uppercase the enum values", required = false)
  Boolean uppercaseEnum = null;

  @Option(names = { "-prefix-strategy",
      "--prefix-strategy" }, description = "The prefix strategy to be used", required = false, hidden = true)
  String prefixStrategy = null;

  @Option(names = { "-suffix-strategy", "--suffix-strategy" }, description = "The suffix strategy to be used", required = false)
  String suffixStrategy = null;

  @Option(names = { "-always-preserve-unknown",
      "--always-preserve-unknown" }, description = "Always preserve unknown fields in the generated classes", required = false, hidden = true)
  Boolean alwaysPreserveUnkownFields = null;

  @Option(names = { "-add-extra-annotations",
      "--add-extra-annotations" }, description = "Add extra lombok and sundrio annotation to the generated classes", required = false)
  Boolean addExtraAnnotations = null;

  @Option(names = { "-code-structure",
      "--code-structure" }, description = "Generate classes using a specific layout", required = false, hidden = true)
  String codeStructure = null;

  @Option(names = { "-skip-generated-annotations",
      "--skip-generated-annotations" }, description = "Add extra lombok and sundrio annotation to the generated classes", required = false, hidden = true)
  Boolean skipGeneratedAnnotations = null;

  @Option(names = { "-package-overrides",
      "--package-overrides" }, description = "Apply the overrides to the package names", required = false)
  Map<String, String> packageOverrides = null;

  @Override
  public void run() {
    final Config.Prefix pSt = (prefixStrategy != null) ? Config.Prefix.valueOf(prefixStrategy) : null;
    final Config.Suffix sSt = (suffixStrategy != null) ? Config.Suffix.valueOf(suffixStrategy) : null;
    final Config.CodeStructure structure = (codeStructure != null) ? Config.CodeStructure.valueOf(codeStructure) : null;
    final Boolean generatedAnnotations = (skipGeneratedAnnotations != null) ? skipGeneratedAnnotations : null;
    final Config config = new Config(
        uppercaseEnum,
        pSt,
        sSt,
        alwaysPreserveUnkownFields,
        addExtraAnnotations,
        structure,
        generatedAnnotations,
        packageOverrides);
    final JavaGenerator runner = new FileJavaGenerator(config, source);
    runner.run(target);
  }

  public static void main(String[] args) {
    int exitCode = new CommandLine(new GenerateJavaSources()).execute(args);
    System.exit(exitCode);
  }
}
