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
package io.fabric8.java.generator.maven.plugin;

import io.fabric8.java.generator.CRGeneratorRunner;
import io.fabric8.java.generator.Config;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JavaGeneratorMojo extends AbstractMojo {

  @Parameter(defaultValue = "${project}")
  private MavenProject project;

  /**
   * The input file or directory to be used for generating sources
   *
   */
  @Parameter(property = "fabric8.java-generator.source", required = true)
  File source;

  /**
   * The target folder to generate the Java sources
   *
   */
  @Parameter(property = "fabric8.java-generator.target", defaultValue = "${basedir}/target/generated-sources/java")
  File target;

  /**
   * Generate uppercase Enums
   *
   */
  @Parameter(property = "fabric8.java-generator.enum-uppercase", required = false)
  Boolean enumUppercase = null;

  /**
   * *advanced* The prefix strategy for name mangling
   *
   */
  @Parameter(property = "fabric8.java-generator.prefix-strategy", required = false)
  Config.Prefix prefixStrategy = null;

  /**
   * *advanced* The suffix strategy for name mangling
   *
   */
  @Parameter(property = "fabric8.java-generator.suffix-strategy", required = false)
  Config.Suffix suffixStrategy = null;

  /**
   * *advanced* Always inject additional properties in the generated classes
   *
   */
  @Parameter(property = "fabric8.java-generator.always-preserve-unknown", required = false)
  Boolean alwaysPreserveUnknown = null;

  /**
   * Generate Extra annotation for lombok and sundrio integration
   *
   */
  @Parameter(property = "fabric8.java-generator.extra-annotations", required = false)
  Boolean extraAnnotations = null;

  /**
   * *advanced* The code structure to be used when generating java sources
   *
   */
  @Parameter(property = "fabric8.java-generator.code-structure", required = false)
  protected Config.CodeStructure codeStructure = null;

  /**
   * *advanced* Emit the @javax.annotation.processing.Generated annotation on the generated sources
   *
   */
  @Parameter(property = "fabric8.java-generator.generated-annotations", required = false)
  Boolean generatedAnnotations = null;

  @Override
  public void execute() {
    final Config config = new Config(
        enumUppercase,
        prefixStrategy,
        suffixStrategy,
        alwaysPreserveUnknown,
        extraAnnotations,
        codeStructure,
        generatedAnnotations);
    final CRGeneratorRunner runner = new CRGeneratorRunner(config);
    runner.run(source, target);
    project.addCompileSourceRoot(target.getAbsolutePath());
  }
}
