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
package io.fabric8.java.generator.gradle.plugin;

import io.fabric8.java.generator.Config;
import org.gradle.api.Project;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.ListProperty;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class JavaGeneratorPluginExtension {

  public static final String NAME = "javaGen";
  protected Project gradleProject;

  private Config javaGeneratorConfig = Config.builder().build();

  public JavaGeneratorPluginExtension(Project gradleProject) {
    this.gradleProject = gradleProject;
  }

  public Config getConfig() {
    return javaGeneratorConfig;
  }

  /**
   * The input file or directory to be used for generating sources
   *
   */
  public abstract RegularFileProperty getSource();

  public File getSourceOrDefault() {
    return this.getSource().getAsFile().getOrElse(null);
  }

  /**
   * The URLs to be used to download CRDs from remote locations
   */
  public abstract ListProperty<String> getUrls();

  public List<String> getUrlsOrDefault() {
    return this.getUrls().getOrElse(new ArrayList<>());
  }

  /**
   * The Download target folder for CRDs downloaded from remote URLs
   *
   */
  public abstract DirectoryProperty getDownloadTarget();

  public File getDownloadTargetOrDefault() {
    return this.getDownloadTarget().getAsFile()
        .getOrElse(this.gradleProject.getLayout().getProjectDirectory()
            .dir("build")
            .dir("crds")
            .getAsFile());
  }

  /**
   * The target folder to generate the Java sources
   *
   */
  public abstract DirectoryProperty getTarget();

  public File getTargetOrDefault() {
    return this.getTarget().getAsFile()
        .getOrElse(this.gradleProject.getLayout().getProjectDirectory()
            .dir("build")
            .dir("generated")
            .dir("sources").getAsFile());
  }

  /**
   * Generate uppercase Enums
   *
   */
  public Boolean getEnumUppercase() {
    return javaGeneratorConfig.isUppercaseEnums();
  }

  public void setEnumUppercase(final Boolean isEnumUppercase) {
    javaGeneratorConfig = new Config(isEnumUppercase,
        javaGeneratorConfig.isObjectExtraAnnotations(),
        javaGeneratorConfig.isGeneratedAnnotations(),
        javaGeneratorConfig.getPackageOverrides(),
        javaGeneratorConfig.getFilesSuffixes());
  }

  /**
   * Generate Extra annotation for lombok and sundrio integration
   *
   */
  public Boolean getExtraAnnotations() {
    return javaGeneratorConfig.isObjectExtraAnnotations();
  }

  public void setExtraAnnotations(final Boolean isExtraAnnotations) {
    javaGeneratorConfig = new Config(javaGeneratorConfig.isUppercaseEnums(),
        isExtraAnnotations,
        javaGeneratorConfig.isGeneratedAnnotations(),
        javaGeneratorConfig.getPackageOverrides(),
        javaGeneratorConfig.getFilesSuffixes());
  }

  /**
   * *advanced* Emit the @javax.annotation.processing.Generated annotation on the generated sources
   *
   */
  public Boolean getGeneratedAnnotations() {
    return javaGeneratorConfig.isUppercaseEnums();
  }

  public void setGeneratedAnnotations(final Boolean isGeneratedAnnotations) {
    javaGeneratorConfig = new Config(javaGeneratorConfig.isUppercaseEnums(),
        javaGeneratorConfig.isObjectExtraAnnotations(),
        isGeneratedAnnotations,
        javaGeneratorConfig.getPackageOverrides(),
        javaGeneratorConfig.getFilesSuffixes());
  }

  /**
   * Package names to be substituted
   *
   */
  public Map<String, String> getPackageOverrides() {
    return javaGeneratorConfig.getPackageOverrides();
  }

  public void setPackageOverrides(final Map<String, String> packageOverrides) {
    javaGeneratorConfig = new Config(javaGeneratorConfig.isUppercaseEnums(),
        javaGeneratorConfig.isObjectExtraAnnotations(),
        javaGeneratorConfig.isGeneratedAnnotations(),
        packageOverrides,
        javaGeneratorConfig.getFilesSuffixes());
  }

  /**
   * Files suffixes to be processed
   *
   */
  public List<String> getFilesSuffixes() {
    return javaGeneratorConfig.getFilesSuffixes();
  }

  public void setPackageOverrides(final List<String> filesSuffixes) {
    javaGeneratorConfig = new Config(javaGeneratorConfig.isUppercaseEnums(),
        javaGeneratorConfig.isObjectExtraAnnotations(),
        javaGeneratorConfig.isGeneratedAnnotations(),
        javaGeneratorConfig.getPackageOverrides(),
        filesSuffixes);
  }
}
