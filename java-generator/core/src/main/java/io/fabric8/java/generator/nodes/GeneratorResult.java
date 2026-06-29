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

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.LiteralExpr;
import io.fabric8.java.generator.exceptions.JavaGeneratorException;

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
      assertStructuralIntegrity(cu, this.javaSource);
    }

    private static void assertStructuralIntegrity(CompilationUnit original, String javaSource) {
      CompilationUnit reparsed;
      try {
        reparsed = StaticJavaParser.parse(javaSource);
      } catch (Exception e) {
        throw new JavaGeneratorException(
            "Generated source failed to re-parse, possible code injection in CRD schema values", e);
      }
      List<TypeDeclaration<?>> originalTypes = original.getTypes();
      List<TypeDeclaration<?>> reparsedTypes = reparsed.getTypes();
      if (originalTypes.size() != reparsedTypes.size()) {
        throw new JavaGeneratorException(
            "Generated source structural mismatch: expected " + originalTypes.size()
                + " type(s) but re-parsed " + reparsedTypes.size()
                + ". CRD schema values may contain injected code.");
      }
      for (int i = 0; i < originalTypes.size(); i++) {
        assertTypeIntegrity(originalTypes.get(i), reparsedTypes.get(i));
      }
    }

    private static void assertTypeIntegrity(TypeDeclaration<?> original, TypeDeclaration<?> reparsed) {
      List<BodyDeclaration<?>> origMembers = original.getMembers();
      List<BodyDeclaration<?>> reparsedMembers = reparsed.getMembers();
      if (origMembers.size() != reparsedMembers.size()) {
        throw new JavaGeneratorException(
            "Generated source structural mismatch in type '" + original.getNameAsString()
                + "': expected " + origMembers.size() + " member(s) but re-parsed "
                + reparsedMembers.size()
                + ". CRD schema values may contain injected code.");
      }
      for (int i = 0; i < origMembers.size(); i++) {
        if (!origMembers.get(i).getClass().equals(reparsedMembers.get(i).getClass())) {
          throw new JavaGeneratorException(
              "Generated source structural mismatch in type '" + original.getNameAsString()
                  + "': member " + i + " expected " + origMembers.get(i).getClass().getSimpleName()
                  + " but re-parsed " + reparsedMembers.get(i).getClass().getSimpleName()
                  + ". CRD schema values may contain injected code.");
        }
        if (origMembers.get(i) instanceof TypeDeclaration && reparsedMembers.get(i) instanceof TypeDeclaration) {
          assertTypeIntegrity((TypeDeclaration<?>) origMembers.get(i), (TypeDeclaration<?>) reparsedMembers.get(i));
        }
      }
      if (original instanceof EnumDeclaration && reparsed instanceof EnumDeclaration) {
        assertEnumEntriesIntegrity(
            (EnumDeclaration) original, (EnumDeclaration) reparsed);
      }
    }

    private static void assertEnumEntriesIntegrity(EnumDeclaration original, EnumDeclaration reparsed) {
      List<EnumConstantDeclaration> origEntries = original.getEntries();
      List<EnumConstantDeclaration> reparsedEntries = reparsed.getEntries();
      if (origEntries.size() != reparsedEntries.size()) {
        throw new JavaGeneratorException(
            "Generated source structural mismatch in enum '" + original.getNameAsString()
                + "': expected " + origEntries.size() + " constant(s) but re-parsed "
                + reparsedEntries.size()
                + ". CRD schema values may contain injected code.");
      }
      for (int i = 0; i < origEntries.size(); i++) {
        assertEnumConstantIntegrity(origEntries.get(i), reparsedEntries.get(i), original.getNameAsString());
      }
    }

    private static void assertEnumConstantIntegrity(
        EnumConstantDeclaration original, EnumConstantDeclaration reparsed, String typeName) {
      List<Expression> origArgs = original.getArguments();
      List<Expression> reparsedArgs = reparsed.getArguments();
      if (origArgs.size() != reparsedArgs.size()) {
        throw new JavaGeneratorException(
            "Generated source structural mismatch in enum constant '"
                + original.getNameAsString() + "' of type '" + typeName
                + "': expected " + origArgs.size() + " argument(s) but re-parsed "
                + reparsedArgs.size()
                + ". CRD schema values may contain injected code.");
      }
      for (int i = 0; i < origArgs.size(); i++) {
        assertExpressionIntegrity(origArgs.get(i), reparsedArgs.get(i), typeName);
      }
    }

    private static void assertExpressionIntegrity(Expression original, Expression reparsed, String typeName) {
      if (original instanceof LiteralExpr && !(reparsed instanceof LiteralExpr)) {
        throw new JavaGeneratorException(
            "Generated source structural mismatch in type '" + typeName
                + "': expected a literal expression but re-parsed "
                + reparsed.getClass().getSimpleName()
                + ". CRD schema values may contain injected code.");
      }
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
