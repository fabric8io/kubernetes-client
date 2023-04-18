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

import org.gradle.api.Project;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;

import java.io.File;
import java.util.Collections;
import java.util.Map;

public abstract class JavaGeneratorPluginExtension {

  public static final String NAME = "javaGen";
  private Project gradleProject;

  public JavaGeneratorPluginExtension(Project gradleProject) {
    this.gradleProject = gradleProject;
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
  public abstract Property<String[]> getUrls();

  public String[] getUrlsOrDefault() {
    return this.getUrls().getOrElse(new String[] {});
  }

  /**
   * The Download target folder for CRDs downloaded from remote URLs
   *
   */
  public abstract DirectoryProperty getDownloadTarget();

  public File getDownloadTargetOrDefault() {
    return this.getDownloadTarget().getAsFile()
        .getOrElse(this.gradleProject.getLayout().getProjectDirectory().dir("tmp").dir("input").getAsFile());
  }

  /**
   * The target folder to generate the Java sources
   *
   */
  public abstract DirectoryProperty getTarget();

  public File getTargetOrDefault() {
    return this.getTarget().getAsFile()
        .getOrElse(this.gradleProject.getLayout().getProjectDirectory().dir("tmp").dir("output").getAsFile());
  }

  /**
   * Generate uppercase Enums
   *
   */
  public abstract Property<Boolean> getEnumUppercase();

  public Boolean getEnumUppercaseOrDefault() {
    return this.getEnumUppercase().getOrElse(Boolean.FALSE);
  }

  /**
   * *DEPRECATED* Always inject additional properties in the generated classes
   *
   */
  @Deprecated
  public abstract Property<Boolean> getAlwaysPreserveUnknown();

  public Boolean getAlwaysPreserveUnknownOrDefault() {
    return this.getAlwaysPreserveUnknown().getOrElse(Boolean.FALSE);
  }

  /**
   * Generate Extra annotation for lombok and sundrio integration
   *
   */
  public abstract Property<Boolean> getExtraAnnotations();

  public Boolean getExtraAnnotationsOrDefault() {
    return this.getExtraAnnotations().getOrElse(Boolean.FALSE);
  }

  /**
   * *advanced* Emit the @javax.annotation.processing.Generated annotation on the generated sources
   *
   */
  public abstract Property<Boolean> getGeneratedAnnotations();

  public Boolean getGeneratedAnnotationsOrDefault() {
    return this.getGeneratedAnnotations().getOrElse(Boolean.TRUE);
  }

  /**
   * Package names to be substituted
   *
   */
  public abstract MapProperty<String, String> getPackageOverrides();

  public Map<String, String> getPackageOverridesOrDefault() {
    return this.getPackageOverrides().getOrElse(Collections.emptyMap());
  }
}
