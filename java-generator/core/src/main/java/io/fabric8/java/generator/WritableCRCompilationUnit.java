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

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class WritableCRCompilationUnit {

    private final CompilationUnit cu;
    private final List<String> classNames;

    WritableCRCompilationUnit(CompilationUnit cu, List<String> classNames) {
        this.cu = cu;
        this.classNames = classNames;
    }

    public void writeAllJavaClasses(File basePath) {
        try {
            File finalPath =
                    createFolders(
                            cu.getPackageDeclaration().map(p -> p.getName().asString()), basePath);
            for (String cn : this.classNames) {
                writeJavaClass(finalPath, cn);
            }
        } catch (Exception e) {
            throw new JavaGeneratorException(e);
        }
    }

    protected String getJavaClass(String name) {
        Optional<ClassOrInterfaceDeclaration> clazz = cu.getClassByName(name);
        assert (clazz.isPresent());

        StringBuilder content = new StringBuilder();
        cu.getPackageDeclaration().ifPresent(content::append);
        content.append(clazz.get());

        return content.toString();
    }

    private void writeJavaClass(File basePath, String name) throws IOException {
        String content = getJavaClass(name);

        writeToFile(basePath.toPath().resolve(name + ".java").toFile(), content);
    }

    private void writeToFile(File file, String str) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(str);
        }
    }

    private static File createFolders(Optional<String> pkg, File folder) {
        Path destFolder = folder.toPath();
        if (pkg.isPresent()) {
            for (String p : pkg.get().split("\\.")) {
                destFolder = destFolder.resolve(p);
            }
        }
        destFolder.toFile().mkdirs();
        return destFolder.toFile();
    }
}
