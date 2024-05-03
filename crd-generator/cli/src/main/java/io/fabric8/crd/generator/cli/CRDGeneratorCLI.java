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

import io.fabric8.crd.generator.collector.CustomResourceCollector;
import io.fabric8.crdv2.generator.CRDGenerationInfo;
import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.kubernetes.api.model.HasMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * CRD-Generator Command Line Interface.
 */
// spotless:off
@CommandLine.Command(
  name = "crd-gen",
  description = "@|bold Fabric8 CRD-Generator|@%n" +
  "Generate Custom Resource Definitions (CRD) for Kubernetes from Java classes.",
  exitCodeList = {
    " 0:Successful execution",
    " 1:Unexpected error",
    " 2:Invalid input",
    "70:Custom Resource class loading failed",
    "80:No Custom Resource classes retained after filtering"
  },
  helpCommand = true,
  mixinStandardHelpOptions = true,
  usageHelpAutoWidth = true,
  sortOptions = false,
  versionProvider = KubernetesClientVersionProvider.class,
  synopsisHeading = "%nUsage:%n%n",
  descriptionHeading = "%nDescription:%n%n",
  parameterListHeading = "%nParameters:%n",
  optionListHeading = "%nOptions:%n",
  exitCodeListHeading = "%nExit Codes:%n",
  footerHeading = "%nExamples:%n",
  footer = "  Generate CRDs for Custom Resource classes in a directory:%n" +
           "    @|faint ${COMMAND-NAME} target/classes/|@%n" +
           "  Generate CRDs for Custom Resource classes in a JAR file:%n" +
           "    @|faint ${COMMAND-NAME} my-jar-with-custom-resources.jar|@%n" +
           "  Generate CRD by using a single class only:%n" +
           "    @|faint ${COMMAND-NAME} -cp target/classes/ com.example.MyCustomResource|@"
)
// spotless:on
public class CRDGeneratorCLI implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(CRDGeneratorCLI.class);

  private static final CRDGenerationInfo EMPTY_INFO = new CRDGenerationInfo();

  private CRDGenerationInfo crdGenerationInfo = EMPTY_INFO;

  private final Set<String> customResourceClassNames = new HashSet<>();
  private final Set<File> filesToScan = new HashSet<>();

  @CommandLine.Spec
  CommandLine.Model.CommandSpec spec;

  // spotless:off
  @CommandLine.Option(
    names = {"-o", "--output-dir"},
    description = "The output directory where the CRDs are emitted.",
    showDefaultValue = CommandLine.Help.Visibility.ALWAYS
  )
  // spotless:on
  File outputDirectory = new File(".");

  // spotless:off
  @CommandLine.Option(
    names = {"-cp", "--classpath"},
    paramLabel = "<classpathElement>",
    description = "Additional classpath element, e.g. a dependency packaged as JAR file or a directory of class files."
  )
  // spotless:on
  List<String> classpathElements = new ArrayList<>();

  // spotless:off
  @CommandLine.Option(
    names = {"--force-index"},
    description = "Create Jandex index even if the directory or JAR file contains an existing index.",
    defaultValue = "false"
  )
  // spotless:on
  Boolean forceIndex;

  // spotless:off
  @CommandLine.Option(
    names = {"--force-scan"},
    description = "Scan directories and JAR files even if Custom Resource classes are given.",
    defaultValue = "false"
  )
  // spotless:on
  Boolean forceScan;

  // spotless:off
  @CommandLine.Option(
    names = {"--no-parallel"},
    description = "Disable parallel generation of CRDs.",
    defaultValue = "false"
  )
  // spotless:on
  Boolean parallelDisabled;

  // spotless:off
  @CommandLine.Option(
    names = {"--implicit-preserve-unknown-fields"},
    description = "`x-kubernetes-preserve-unknown-fields: true` will be added on objects which contain an any-setter or any-getter.",
    defaultValue = "false"
  )
  // spotless:on
  Boolean implicitPreserveUnknownFields;

  // spotless:off
  @CommandLine.Option(
    names = {"--include-package"},
    paramLabel = "<package>",
    description = "Filter Custom Resource classes after scanning by package inclusions."
  )
  // spotless:on
  List<String> includedPackages = new LinkedList<>();

  // spotless:off
  @CommandLine.Option(
    names = {"--exclude-package"},
    paramLabel = "<package>",
    description = "Filter Custom Resource classes after scanning by package exclusions."
  )
  // spotless:on
  List<String> excludedPackages = new LinkedList<>();

  // spotless:off
  @CommandLine.Option(
    names = {"-v"},
    description = "Verbose mode. Helpful for troubleshooting.\nMultiple -v options increase the verbosity."
  )
  // spotless:on
  List<Boolean> verbose = new LinkedList<>();

  // spotless:off
  @CommandLine.Parameters(
    paramLabel = "<source>",
    arity = "1..*",
    converter = SourceParameterTypeConverter.class,
    description = "A directory or JAR file to scan for Custom Resource classes, or a full qualified Custom Resource class name."
  )
  // spotless:on
  void setParameters(List<SourceParameter> parameters) {
    setCustomResourceClassNames(parameters);
    setFilesToScan(parameters);
  }

  @Override
  public void run() {
    LoggingConfiguration.configureLogger(verbose);
    List<String> allClasspathElements = getClasspathElements();

    log.trace("Custom Resource Class Names: {}", customResourceClassNames);
    log.trace("Files to scan: {}", filesToScan);
    log.trace("Classpath: {}", allClasspathElements);

    CustomResourceCollector customResourceCollector = new CustomResourceCollector()
        .withClasspathElements(allClasspathElements)
        .withFilesToScan(filesToScan)
        .withForceIndex(forceIndex)
        .withForceScan(forceScan)
        .withCustomResourceClasses(customResourceClassNames)
        .withIncludePackages(includedPackages)
        .withExcludePackages(excludedPackages);

    List<Class<? extends HasMetadata>> customResourceClasses = customResourceCollector.findCustomResourceClasses();

    if (customResourceClasses.isEmpty()) {
      throw new CustomResourceClassNotFoundException();
    }

    log.debug("Generating CRDs for {} Custom Resource classes", customResourceClasses.size());

    File sanitizedOutputDirectory;
    try {
      sanitizedOutputDirectory = outputDirectory.getCanonicalFile();
    } catch (IOException e) {
      throw new RuntimeException("Could not get canonical file for " + outputDirectory, e);
    }

    try {
      Files.createDirectories(sanitizedOutputDirectory.toPath());
    } catch (IOException e) {
      throw new RuntimeException(
          "Could not create output directory at " + sanitizedOutputDirectory, e);
    }

    CRDGenerator crdGenerator = new CRDGenerator()
        .customResourceClasses(customResourceClasses)
        .withParallelGenerationEnabled(!parallelDisabled)
        .withImplicitPreserveUnknownFields(implicitPreserveUnknownFields)
        .inOutputDir(sanitizedOutputDirectory);

    crdGenerationInfo = crdGenerator.detailedGenerate();
    crdGenerationInfo.getCRDDetailsPerNameAndVersion().forEach((crdName, versionToInfo) -> {
      getOut().printf("Generated CRD %s:%n", crdName);
      versionToInfo.forEach(
          (version, info) -> getOut().printf(" %s -> %s%n", version, info.getFilePath()));
    });
  }

  CRDGenerationInfo getCrdGenerationInfo() {
    return crdGenerationInfo;
  }

  String getDiagText() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");

    if (!customResourceClassNames.isEmpty()) {
      sb.append("Custom Resource class names:\n");
      customResourceClassNames.forEach(fqcn -> sb.append(" ").append(fqcn).append("\n"));
    }
    if (filesToScan.isEmpty()) {
      sb.append("Scan Paths: []\n");
    } else {
      sb.append("Scan Paths:\n");
      filesToScan.forEach(f -> sb.append(" ").append(f.getPath()).append("\n"));
    }

    List<String> classpathElements = getClasspathElements();
    if (classpathElements.isEmpty()) {
      sb.append("Classpath: []\n");
    } else {
      sb.append("\nClasspath:\n");
      classpathElements.forEach(cpe -> sb.append(" ").append(cpe).append("\n"));
    }
    sb.append("\n");
    return sb.toString();
  }

  private void setCustomResourceClassNames(List<SourceParameter> source) {
    source.stream()
        .filter(s -> s instanceof SourceParameter.CustomResourceClass)
        .map(SourceParameter.CustomResourceClass.class::cast)
        .map(SourceParameter.CustomResourceClass::getCustomResourceClass)
        .forEach(customResourceClassNames::add);
  }

  private void setFilesToScan(List<SourceParameter> source) {
    source.stream()
        .filter(s -> s instanceof SourceParameter.FileToScan)
        .map(SourceParameter.FileToScan.class::cast)
        .map(SourceParameter.FileToScan::getFileToScan)
        .forEach(filesToScan::add);
  }

  private List<String> getClasspathElements() {
    List<String> allClasspathElements = new LinkedList<>(classpathElements);
    // Add files to classpath elements to improve UX of the CLI:
    // A scan target must be always in the classpath.
    filesToScan.stream()
        .map(File::getPath)
        .forEach(allClasspathElements::add);

    return allClasspathElements;
  }

  private PrintWriter getOut() {
    return spec.commandLine().getOut();
  }

  public static void main(String[] args) {
    System.exit(exec(args));
  }

  /**
   * Entry point for the CLI, intended to be used if embedded in other applications. In comparison
   * to {@link #main(String[])}, <code>System.exit()</code> won't be called.
   *
   * @param args arguments
   * @return the exit code
   */
  public static int exec(String[] args) {
    return createCommandLine()
        .execute(args);
  }

  static CommandLine createCommandLine() {
    return createCommandLine(new CRDGeneratorCLI());
  }

  static CommandLine createCommandLine(CRDGeneratorCLI crdGeneratorCLI) {
    return new CommandLine(crdGeneratorCLI)
        .setExecutionExceptionHandler(new CRDGeneratorExecutionExceptionHandler(crdGeneratorCLI));
  }

  /**
   * Exception to indicate that no custom resource classes
   * have been retained after scanning and filtering.
   */
  static class CustomResourceClassNotFoundException extends RuntimeException {
    CustomResourceClassNotFoundException() {
      super("No Custom Resource class retained after filtering");
    }
  }

}
