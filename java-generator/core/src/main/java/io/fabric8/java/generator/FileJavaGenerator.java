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
package io.fabric8.java.generator;

import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static io.fabric8.java.generator.CRGeneratorRunner.groupToPackage;

/**
 * {@link JavaGenerator} implementation that reads CRD files or directories containing CRD files and generates
 * Java classes for them.
 */
public class FileJavaGenerator implements JavaGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(FileJavaGenerator.class);

  private final File source;
  private final CRGeneratorRunner crGeneratorRunner;

  public FileJavaGenerator(Config config, File source) {
    crGeneratorRunner = new CRGeneratorRunner(config);
    this.source = source;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run(File outputDirectory) {
    if (source.isDirectory()) {
      try (Stream<Path> walk = Files.walk(source.toPath(), FileVisitOption.FOLLOW_LINKS)) {
        walk
            .map(Path::toFile)
            .filter(f -> !f.getAbsolutePath().equals(source.getAbsolutePath()))
            .forEach(f -> runOnSingleSource(f, outputDirectory));
      } catch (IOException e) {
        throw new JavaGeneratorException(
            "Error visiting the folder " + source.getAbsolutePath(), e);
      }
    } else {
      runOnSingleSource(source, outputDirectory);
    }
  }

  private void runOnSingleSource(File source, File basePath) {
    try (FileInputStream fis = new FileInputStream(source)) {
      List<Object> resources = new ArrayList<>();

      Object deserialized = Serialization.unmarshal(fis);
      if (deserialized instanceof List) {
        resources.addAll((List<Object>) deserialized);
      } else {
        resources.add(deserialized);
      }

      resources.parallelStream()
          .forEach(
              rawResource -> {
                if (rawResource != null && rawResource instanceof HasMetadata) {
                  final HasMetadata resource = (HasMetadata) rawResource;

                  if (resource != null && resource.getKind()
                      .toLowerCase(Locale.ROOT)
                      .equals("customresourcedefinition")) {
                    CustomResourceDefinition crd = (CustomResourceDefinition) resource;

                    final String basePackage = groupToPackage(crd.getSpec().getGroup());
                    List<WritableCRCompilationUnit> writables = crGeneratorRunner.generate(crd, basePackage);

                    writables.parallelStream()
                        .forEach(w -> w.writeAllJavaClasses(basePath, basePackage));
                  } else {
                    LOGGER.warn("Not generating nothing for resource of kind: {}", resource.getKind());
                  }
                } else {
                  LOGGER.warn("Not generating nothing for unrecognized resource: {}", Serialization.asYaml(rawResource));
                }
              });
    } catch (FileNotFoundException e) {
      throw new JavaGeneratorException("File " + source.getAbsolutePath() + " not found", e);
    } catch (IOException e) {
      throw new JavaGeneratorException("Exception reading " + source.getAbsolutePath(), e);
    }
  }
}
