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
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.ProjectLayout;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

public abstract class JavaGeneratorCrd2JavaTask extends DefaultTask {

  public static final String NAME = "crd2java";

  @InputFiles
  @PathSensitive(PathSensitivity.RELATIVE)
  public abstract ConfigurableFileCollection getSource();

  @Input
  public abstract ListProperty<String> getUrls();

  @Internal
  public abstract DirectoryProperty getDownloadTarget();

  @Internal
  public abstract DirectoryProperty getTarget();

  @Input
  public abstract Property<Boolean> getUppercaseEnums();

  @Input
  public abstract Property<Boolean> getObjectExtraAnnotations();

  @Input
  public abstract Property<Boolean> getGeneratedAnnotations();

  @Input
  public abstract Property<Boolean> getAlwaysPreserveUnknown();

  @Input
  public abstract MapProperty<String, String> getPackageOverrides();

  @Input
  public abstract ListProperty<String> getFilesSuffixes();

  @Input
  public abstract Property<String> getSerDatetimeFormat();

  @Input
  public abstract Property<String> getDeserDatetimeFormat();

  @Input
  public abstract MapProperty<String, String> getExistingJavaTypes();

  @Inject
  public JavaGeneratorCrd2JavaTask(ProjectLayout layout) {
    setDescription("Generate Java model from CRDs.");
    getDownloadTarget().convention(layout.getBuildDirectory().dir("crds"));
    getTarget().convention(layout.getBuildDirectory().dir("generated/sources"));
    getUppercaseEnums().convention(Config.DEFAULT_UPPERCASE_ENUM);
    getObjectExtraAnnotations().convention(Config.DEFAULT_ADD_EXTRA_ANNOTATIONS);
    getGeneratedAnnotations().convention(Config.DEFAULT_ADD_GENERATED_ANNOTATIONS);
    getAlwaysPreserveUnknown().convention(Config.DEFAULT_ALWAYS_PRESERVE_UNKNOWN);
    getPackageOverrides().convention(Config.DEFAULT_PACKAGE_OVERRIDES);
    getFilesSuffixes().convention(Config.DEFAULT_FILES_SUFFIXES);
    getSerDatetimeFormat().convention(Config.DEFAULT_SER_DATETIME_FORMAT);
    getDeserDatetimeFormat().convention(Config.DEFAULT_DESER_DATETIME_FORMAT);
    getExistingJavaTypes().convention(Config.DEFAULT_EXISTING_JAVA_TYPES_OVERRIDES);
  }

  @TaskAction
  public final void runTask() {
    final Config config = Config.builder()
        .uppercaseEnums(getUppercaseEnums().get())
        .objectExtraAnnotations(getObjectExtraAnnotations().get())
        .generatedAnnotations(getGeneratedAnnotations().get())
        .alwaysPreserveUnknown(getAlwaysPreserveUnknown().get())
        .packageOverrides(getPackageOverrides().get())
        .filesSuffixes(getFilesSuffixes().get())
        .serDatetimeFormat(getSerDatetimeFormat().get())
        .deserDatetimeFormat(getDeserDatetimeFormat().get())
        .existingJavaTypes(getExistingJavaTypes().get())
        .build();

    final Set<File> sources = getSource().getFiles();
    final List<String> urls = getUrls().getOrElse(new ArrayList<>());
    if (sources.isEmpty() && urls.isEmpty()) {
      throw new GradleException("No source or urls specified");
    }

    List<JavaGenerator> runners = new ArrayList<>();

    if (!urls.isEmpty()) {
      final List<URL> urlList = new ArrayList<>();
      for (String url : urls) {
        try {
          urlList.add(new URL(url));
        } catch (MalformedURLException e) {
          throw new GradleException("URL '" + url + "' is not valid", e);
        }
      }
      final File downloadTarget = getDownloadTarget().getAsFile().get();
      if (!downloadTarget.isDirectory()) {
        downloadTarget.mkdirs();
      }
      runners.add(new URLJavaGenerator(config, urlList, downloadTarget));
    }

    // One generator per configured root (file or directory); FileJavaGenerator walks a directory.
    for (File source : sources) {
      runners.add(new FileJavaGenerator(config, source));
    }

    final File target = getTarget().getAsFile().get();
    runners.forEach(r -> r.run(target));
  }
}
