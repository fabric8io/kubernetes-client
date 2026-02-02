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
package io.fabric8.bom.plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for a single BOM (Bill of Materials) to be generated.
 * This mirrors the configuration structure of the sundrio-maven-plugin.
 */
public class BomConfig {

  /**
   * The artifactId for the generated BOM.
   */
  private String artifactId;

  /**
   * The name for the generated BOM.
   */
  private String name;

  /**
   * Module filtering configuration.
   */
  private ModuleFilter modules = new ModuleFilter();

  /**
   * Dependency filtering configuration for including transitive dependencies.
   */
  private DependencyFilter dependencies = new DependencyFilter();

  public String getArtifactId() {
    return artifactId;
  }

  public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ModuleFilter getModules() {
    return modules;
  }

  public void setModules(ModuleFilter modules) {
    this.modules = modules;
  }

  public DependencyFilter getDependencies() {
    return dependencies;
  }

  public void setDependencies(DependencyFilter dependencies) {
    this.dependencies = dependencies;
  }

  /**
   * Filter configuration for modules (reactor projects).
   */
  public static class ModuleFilter {
    private List<String> includes = new ArrayList<>();
    private List<String> excludes = new ArrayList<>();

    public List<String> getIncludes() {
      return includes;
    }

    public void setIncludes(List<String> includes) {
      this.includes = includes;
    }

    public List<String> getExcludes() {
      return excludes;
    }

    public void setExcludes(List<String> excludes) {
      this.excludes = excludes;
    }
  }

  /**
   * Filter configuration for transitive dependencies.
   */
  public static class DependencyFilter {
    private List<String> includes = new ArrayList<>();
    private List<String> excludes = new ArrayList<>();

    public List<String> getIncludes() {
      return includes;
    }

    public void setIncludes(List<String> includes) {
      this.includes = includes;
    }

    public List<String> getExcludes() {
      return excludes;
    }

    public void setExcludes(List<String> excludes) {
      this.excludes = excludes;
    }
  }
}
