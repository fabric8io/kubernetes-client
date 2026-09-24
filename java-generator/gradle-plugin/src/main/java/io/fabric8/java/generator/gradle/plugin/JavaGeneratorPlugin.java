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
package io.fabric8.java.generator.gradle.plugin;

import io.fabric8.java.generator.gradle.plugin.task.JavaGeneratorCrd2JavaTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JavaGeneratorPlugin implements Plugin<Project> {
  @Override
  public void apply(Project project) {
    project.getExtensions().create(JavaGeneratorPluginExtension.NAME, JavaGeneratorPluginExtension.class);
    final JavaGeneratorPluginExtension extension = project.getExtensions()
        .getByType(JavaGeneratorPluginExtension.class);
    // Wire the task's lazy inputs from the extension's providers so the task captures neither the
    // Project nor the extension (configuration-cache compatible).
    project.getTasks().register(JavaGeneratorCrd2JavaTask.NAME, JavaGeneratorCrd2JavaTask.class, task -> {
      task.getSource().from(extension.getSource());
      task.getUrls().set(extension.getUrls());
      task.getDownloadTarget().set(extension.getDownloadTarget()
          .orElse(project.getLayout().getBuildDirectory().dir("crds")));
      task.getTarget().set(extension.getTarget()
          .orElse(project.getLayout().getBuildDirectory().dir("generated/sources")));
      task.getUppercaseEnums().set(project.provider(extension::getEnumUppercase));
      task.getObjectExtraAnnotations().set(project.provider(extension::getExtraAnnotations));
      task.getGeneratedAnnotations().set(project.provider(extension::getGeneratedAnnotations));
      task.getAlwaysPreserveUnknown().set(project.provider(extension::getAlwaysPreserveUnknown));
      task.getPackageOverrides().set(project.provider(extension::getPackageOverrides));
      task.getFilesSuffixes().set(project.provider(extension::getFilesSuffixes));
      task.getSerDatetimeFormat().set(project.provider(extension::getSerializationDatetimeFormat));
      task.getDeserDatetimeFormat().set(project.provider(extension::getDeserializationDatetimeFormat));
      task.getExistingJavaTypes().set(project.provider(extension::getExistingJavaTypes));
    });
  }
}
