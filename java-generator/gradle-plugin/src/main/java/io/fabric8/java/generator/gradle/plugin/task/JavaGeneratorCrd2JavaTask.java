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
import org.gradle.api.file.FileCollection;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.LocalState;
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

import javax.inject.Inject;

public class JavaGeneratorCrd2JavaTask extends DefaultTask {

  private final JavaGeneratorPluginExtension extensionClass;

  public static final String NAME = "crd2java";

  @Inject
  public JavaGeneratorCrd2JavaTask(Class<? extends JavaGeneratorPluginExtension> extensionClass) {
    this.extensionClass = getProject().getExtensions().getByType(extensionClass);
    setDescription("Generate Java model from CRDs.");
  }

  @Optional
  @InputFiles
  @PathSensitive(PathSensitivity.RELATIVE)
  public FileCollection getSourceFiles() {
    final File source = extensionClass.getSourceOrDefault();
    if (source == null) {
      return getProject().files();
    }
    return source.isDirectory() ? getProject().fileTree(source) : getProject().files(source);
  }

  @Input
  public List<String> getUrls() {
    return extensionClass.getUrlsOrDefault();
  }

  @LocalState
  public File getDownloadTarget() {
    return extensionClass.getDownloadTargetOrDefault();
  }

  @OutputDirectory
  public File getTarget() {
    return extensionClass.getTargetOrDefault();
  }

  @Input
  public Boolean getEnumUppercase() {
    return extensionClass.getEnumUppercase();
  }

  @Input
  public Boolean getExtraAnnotations() {
    return extensionClass.getExtraAnnotations();
  }

  @Input
  public Boolean getGeneratedAnnotations() {
    return extensionClass.getGeneratedAnnotations();
  }

  @Input
  public Boolean getAlwaysPreserveUnknown() {
    return extensionClass.getAlwaysPreserveUnknown();
  }

  @Input
  public List<String> getFilesSuffixes() {
    return extensionClass.getFilesSuffixes();
  }

  @Input
  public String getSerializationDatetimeFormat() {
    return extensionClass.getSerializationDatetimeFormat();
  }

  @Input
  public String getDeserializationDatetimeFormat() {
    return extensionClass.getDeserializationDatetimeFormat();
  }

  @Input
  public java.util.Map<String, String> getPackageOverrides() {
    return extensionClass.getPackageOverrides();
  }

  @Input
  public java.util.Map<String, String> getExistingJavaTypes() {
    return extensionClass.getExistingJavaTypes();
  }

  @TaskAction
  public final void runTask() {

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
  }
}
