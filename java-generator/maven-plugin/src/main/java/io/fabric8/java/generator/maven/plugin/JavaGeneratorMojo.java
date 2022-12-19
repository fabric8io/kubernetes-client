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

import io.fabric8.java.generator.Config;
import io.fabric8.java.generator.FileJavaGenerator;
import io.fabric8.java.generator.JavaGenerator;
import io.fabric8.java.generator.URLJavaGenerator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JavaGeneratorMojo extends AbstractMojo {

  @Parameter(defaultValue = "${project}")
  private MavenProject project;

  /**
   * The input file or directory to be used for generating sources
   *
   */
  @Parameter(property = "fabric8.java-generator.source")
  File source;

  /**
   * The URLs to be used to download CRDs from remote locations
   */
  @Parameter(property = "fabric8.java-generator.urls", required = false)
  String[] urls;

  /**
   * The Download target folder for CRDs downloaded from remote URLs
   *
   */
  @Parameter(property = "fabric8.java-generator.download-target", defaultValue = "${basedir}/target/manifests")
  File downloadTarget;

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

  /**
   * Package names to be substituted
   *
   */
  @Parameter(property = "fabric8.java-generator.package-overrides", required = false)
  Map<String, String> packageOverrides = null;

  @Override
  public void execute() throws MojoExecutionException {
    final Config config = Config.builder()
        .uppercaseEnums(enumUppercase)
        .prefixStrategy(prefixStrategy)
        .suffixStrategy(suffixStrategy)
        .alwaysPreserveUnknownFields(alwaysPreserveUnknown)
        .objectExtraAnnotations(extraAnnotations)
        .structure(codeStructure)
        .generatedAnnotations(generatedAnnotations)
        .packageOverrides(packageOverrides)
        .build();

    boolean executed = false;
    if (urls != null && urls.length > 0) {
      executed = true;
      final List<URL> urlList = new ArrayList<>();
      for (String url : urls) {
        try {
          urlList.add(new URL(url));
        } catch (MalformedURLException e) {
          throw new MojoExecutionException("URL '" + url + "' is not valid", e);
        }
      }
      new URLJavaGenerator(config, urlList, downloadTarget).run(target);
    }
    if (source != null) {
      executed = true;
      final JavaGenerator runner = new FileJavaGenerator(config, source);
      runner.run(target);
    }
    if (!executed) {
      throw new MojoExecutionException("No source or urls specified");
    }
    project.addCompileSourceRoot(target.getAbsolutePath());
  }
}
