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
package io.fabric8.java.generator.nodes;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GeneratorResult {

  public static class ClassResult {
    private final String name;
    private final CompilationUnit cu;
    private final String javaSource;

    public ClassResult(String name, CompilationUnit cu) {
      this.name = name;
      this.cu = cu;
      this.javaSource = cu.toString();
    }

    public String getName() {
      return name;
    }

    public String getJavaSource() {
      return javaSource;
    }

    public Optional<PackageDeclaration> getPackageDeclaration() {
      return cu.getPackageDeclaration();
    }

    public Optional<EnumDeclaration> getEnumByName(String enumName) {
      return cu.getEnumByName(enumName);
    }

    public Optional<ClassOrInterfaceDeclaration> getClassByName(String className) {
      return cu.getClassByName(className);
    }
  }

  private final List<ClassResult> topLevelClasses;

  public List<ClassResult> getInnerClasses() {
    return innerClasses;
  }

  private final List<ClassResult> innerClasses;

  public List<ClassResult> getTopLevelClasses() {
    return topLevelClasses;
  }

  public GeneratorResult() {
    this.topLevelClasses = new ArrayList<>();
    this.innerClasses = new ArrayList<>();
  }

  public GeneratorResult(List<ClassResult> topLevelClasses) {
    this.topLevelClasses = topLevelClasses;
    this.innerClasses = new ArrayList<>();
  }

  public GeneratorResult(List<ClassResult> topLevelClasses, List<ClassResult> innerClasses) {
    this.topLevelClasses = topLevelClasses;
    this.innerClasses = innerClasses;
  }
}
