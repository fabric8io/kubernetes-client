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
package io.fabric8.java.generator.gradle.plugin.task;

import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.FileJavaGenerator;
import io.fabric8.java.generator.JavaGenerator;
import io.fabric8.java.generator.URLJavaGenerator;
import io.fabric8.java.generator.gradle.plugin.JavaGeneratorPluginExtension;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.logging.Logger;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;


/**
 * Gradle task that generates Java classes from Kubernetes CustomResourceDefinition (CRD) files.
 * <p>
 * This task supports incremental builds and build caching. It will only re-run when:
 * <ul>
 *   <li>The source CRD files or directories change</li>
 *   <li>The list of URLs to download CRDs from changes</li>
 *   <li>Any configuration parameter affecting code generation changes</li>
 *   <li>The generated output is missing or modified</li>
 * </ul>
 * <p>
 * When the task is up-to-date, Gradle will skip execution and log "UP-TO-DATE" next to the task name.
 * This significantly improves build performance when CRDs and configuration haven't changed.
 * <p>
 * <b>Note on URL-based sources:</b> The task tracks the URL strings as inputs, not the content
 * at those URLs. If the content at a URL changes but the URL string remains the same, you may
 * need to force the task to re-run using {@code --rerun-tasks} flag or by cleaning the outputs.
 * <p>
 * Example usage:
 * <pre>
 * javaGen {
 *   source = file('src/main/resources/crds')
 *   target = file('build/generated/sources/crds')
 *   enumUppercase = true
 *   extraAnnotations = true
 * }
 * </pre>
 *
 * @see JavaGeneratorPluginExtension
 */
public class JavaGeneratorCrd2JavaTask extends DefaultTask {

  private final JavaGeneratorPluginExtension extensionClass;

  public static final String NAME = "crd2java";

  @Inject
  public JavaGeneratorCrd2JavaTask(Class<? extends JavaGeneratorPluginExtension> extensionClass) {
    this.extensionClass = getProject().getExtensions().getByType(extensionClass);
    setDescription("Generate Java model from CRDs.");
  }

  /**
   * Returns the source file or directory containing CRD definitions.
   * This is used as an input for Gradle's up-to-date checking.
   * The task will re-run if the source files change.
   *
   * @return the source file or directory, or null if not specified
   */
  @Optional
  @PathSensitive(PathSensitivity.RELATIVE)
  @InputFiles
  public File getSource() {
    return extensionClass.getSourceOrDefault();
  }

  /**
   * Returns the list of URLs to download CRDs from.
   * This is used as an input for Gradle's up-to-date checking.
   * The task will re-run if the URL list changes.
   *
   * @return the list of URLs, or empty list if not specified
   */
  @Optional
  @Input
  public List<String> getUrls() {
    return extensionClass.getUrlsOrDefault();
  }

  /**
   * Returns the target directory where generated Java sources will be written.
   * This is used as an output for Gradle's up-to-date checking.
   *
   * @return the target directory for generated sources
   */
  @OutputDirectory
  public File getTarget() {
    return extensionClass.getTargetOrDefault();
  }

  /**
   * Returns the download target directory where CRDs from URLs will be downloaded.
   * This is used as an output for Gradle's up-to-date checking.
   *
   * @return the download target directory
   */
  @OutputDirectory
  public File getDownloadTarget() {
    return extensionClass.getDownloadTargetOrDefault();
  }

  /**
   * Returns whether to generate uppercase enums.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return true if enums should be uppercase
   */
  @Input
  public Boolean getEnumUppercase() {
    return extensionClass.getEnumUppercase();
  }

  /**
   * Returns whether to add extra annotations (Lombok, Sundrio).
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return true if extra annotations should be added
   */
  @Input
  public Boolean getExtraAnnotations() {
    return extensionClass.getExtraAnnotations();
  }

  /**
   * Returns whether to add generated annotations.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return true if generated annotations should be added
   */
  @Input
  public Boolean getGeneratedAnnotations() {
    return extensionClass.getGeneratedAnnotations();
  }

  /**
   * Returns whether to always preserve unknown fields.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return true if unknown fields should be preserved
   */
  @Input
  public Boolean getAlwaysPreserveUnknown() {
    return extensionClass.getAlwaysPreserveUnknown();
  }

  /**
   * Returns the package name overrides.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return the package overrides map
   */
  @Input
  public Map<String, String> getPackageOverrides() {
    return extensionClass.getPackageOverrides();
  }

  /**
   * Returns the file suffixes to be processed.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return the list of file suffixes
   */
  @Input
  public List<String> getFilesSuffixes() {
    return extensionClass.getFilesSuffixes();
  }

  /**
   * Returns the datetime format for serialization.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return the serialization datetime format
   */
  @Input
  public String getSerializationDatetimeFormat() {
    return extensionClass.getSerializationDatetimeFormat();
  }

  /**
   * Returns the datetime format for deserialization.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return the deserialization datetime format
   */
  @Input
  public String getDeserializationDatetimeFormat() {
    return extensionClass.getDeserializationDatetimeFormat();
  }

  /**
   * Returns the mapping of existing Java types.
   * This is used as an input for Gradle's up-to-date checking.
   *
   * @return the existing Java types map
   */
  @Input
  public Map<String, String> getExistingJavaTypes() {
    return extensionClass.getExistingJavaTypes();
  }

  @TaskAction
  public final void runTask() {
    final Logger logger = getLogger();

    logger.info("Starting Java generation from CRDs");
    logger.debug("Source: {}", extensionClass.getSourceOrDefault());
    logger.debug("URLs: {}", extensionClass.getUrlsOrDefault());
    logger.debug("Target: {}", extensionClass.getTargetOrDefault());
    logger.debug("Download target: {}", extensionClass.getDownloadTargetOrDefault());

    final Config config = extensionClass.getConfig();

    List<JavaGenerator> runners = new ArrayList<>();

    final List<String> urls = extensionClass.getUrlsOrDefault();
    if (urls != null && !urls.isEmpty()) {
      final List<URL> urlList = new ArrayList<>();
      for (String url : urls) {
        try {
          urlList.add(new URL(url));
        } catch (MalformedURLException e) {
          throw new GradleException("URL '" + url + "' is not valid", e);
        }
      }
      final File downloadTarget = extensionClass.getDownloadTargetOrDefault();
      if (!downloadTarget.isDirectory()) {
        downloadTarget.mkdirs();
      }
      runners.add(new URLJavaGenerator(config, urlList, downloadTarget));
    }
    final File source = extensionClass.getSourceOrDefault();
    if (source != null) {
      runners.add(new FileJavaGenerator(config, source));
    }

    if (runners.isEmpty()) {
      throw new GradleException("No source or urls specified");
    }

    runners.forEach(r -> r.run(extensionClass.getTargetOrDefault()));

    logger.info("Java generation completed successfully. Generated sources written to: {}", extensionClass.getTargetOrDefault());
  }
}
