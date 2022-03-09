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

import com.github.javaparser.ast.nodeTypes.NodeWithName;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import io.fabric8.java.generator.nodes.GeneratorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class WritableCRCompilationUnit {

  private static final Logger LOGGER = LoggerFactory.getLogger(WritableCRCompilationUnit.class);

  private final List<GeneratorResult.ClassResult> classResults;

  WritableCRCompilationUnit(List<GeneratorResult.ClassResult> classResults) {
    this.classResults = classResults;
  }

  public List<GeneratorResult.ClassResult> getClassResults() {
    return classResults;
  }

  public void writeAllJavaClasses(File basePath, String basePackage) {
    try {
      createFolders(basePackage, basePath);
      for (GeneratorResult.ClassResult cr : this.classResults) {
        String pkg = cr.getCompilationUnit()
            .getPackageDeclaration()
            .map(NodeWithName::getNameAsString)
            .orElse(null);
        File path = createFolders(pkg, basePath);

        writeToFile(
            path.toPath().resolve(cr.getName() + ".java").toFile(),
            cr.getCompilationUnit().toString());
      }
    } catch (Exception e) {
      throw new JavaGeneratorException(e);
    }
  }

  private void writeToFile(File file, String str) throws IOException {
    if (file.exists()) {
      LOGGER.warn("File {} already exists, overwriting", file.getAbsolutePath());
    }
    try (FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter)) {
      printWriter.println(str);
    }
  }

  private static File createFolders(String pkg, File folder) {
    Path destFolder = folder.toPath();
    if (Optional.ofNullable(pkg).isPresent()) {
      for (String p : pkg.split("\\.")) {
        destFolder = destFolder.resolve(p);
      }
    }
    destFolder.toFile().mkdirs();
    return destFolder.toFile();
  }
}
