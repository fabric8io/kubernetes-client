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
package io.fabric8.crd.generator.apt;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.approvaltests.Approvals;
import org.approvaltests.approvers.ApprovalApprover;
import org.approvaltests.approvers.FileApprover;
import org.approvaltests.core.Options;
import org.approvaltests.namer.ApprovalNamer;
import org.approvaltests.writers.ApprovalTextWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.processing.Processor;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;

import static com.google.testing.compile.Compiler.javac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractCRDGeneratorCompilerTest {

  protected abstract String[] getJavaSources();

  protected abstract String[] getExpectedCRDs();

  protected String getJavaSourcePath() {
    return getClass().getPackage().getName().replace('.', File.separatorChar) + "/api/";
  }

  protected String getOutputPath() {
    return "META-INF/fabric8/";
  }

  protected Processor[] additionalProcessors() {
    return new Processor[0];
  }

  protected String[] additionalCompilerOptions() {
    return new String[] {};
  }

  protected boolean lombokEnabled() {
    return false;
  }

  /**
   * Get lombok annotation processors.
   * Lombok needs special handling because lombok's processors are hidden.
   *
   * @return the lombok annotation processors
   */
  protected List<Processor> lombokAnnotationProcessors() {
    List<Processor> processors = new LinkedList<>();
    try {
      Class<?> lombokAnnotationProcessorClass = getClass().getClassLoader()
          .loadClass("lombok.launch.AnnotationProcessorHider$AnnotationProcessor");
      Class<?> lombokClaimingProcessorClass = getClass().getClassLoader()
          .loadClass("lombok.launch.AnnotationProcessorHider$ClaimingProcessor");
      Processor lombokAnnotationProcessor = (Processor) lombokAnnotationProcessorClass
          .getDeclaredConstructor().newInstance();
      Processor lombokClaimingProcessor = (Processor) lombokClaimingProcessorClass
          .getDeclaredConstructor().newInstance();
      processors.add(lombokAnnotationProcessor);
      processors.add(lombokClaimingProcessor);
    } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException | NoSuchMethodException
        | InstantiationException e) {
      fail("Could not load lombok annotation processors", e);
      throw new RuntimeException(e);
    }
    return processors;
  }

  @BeforeAll
  public void init() {
    // Allow using the same approval files for this class multiple times (required for parallel testing)
    String className = getClass().getName().replace('.', File.separatorChar);
    FileApprover.tracker.addAllowedDuplicates(f -> f.contains(className));
  }

  @Test
  public void test() {
    test(false);
  }

  @Test
  public void testParallel() {
    test(true);
  }

  private void test(boolean parallel) {
    assertTrue(getJavaSources().length > 0, "No JavaSources configured");
    assertTrue(getExpectedCRDs().length > 0, "No expected CRDs configured");

    final List<JavaFileObject> javaFileObjects = Arrays.stream(getJavaSources())
        .map(s -> JavaFileObjects.forResource(getJavaSourcePath() + s))
        .collect(Collectors.toList());

    final List<Processor> processors = new LinkedList<>(Arrays.asList(additionalProcessors()));
    if (lombokEnabled()) {
      processors.addAll(lombokAnnotationProcessors());
    }
    processors.add(new CustomResourceAnnotationProcessor());

    final List<String> compilerOptions = new LinkedList<>(Arrays.asList(additionalCompilerOptions()));
    compilerOptions.add("-Aio.fabric8.crd.generator.parallel=" + parallel);

    final Compilation compilation = javac()
        .withProcessors(processors)
        .withOptions(compilerOptions)
        .compile(javaFileObjects);

    if (!compilation.notes().isEmpty()) {
      System.out.println("Compiler notes:");
      compilation.notes().forEach(diagnostic -> System.out.println(diagnostic.toString()));
    }
    if (!compilation.warnings().isEmpty()) {
      System.out.println("Compiler warnings:");
      compilation.warnings().forEach(diagnostic -> System.out.println(diagnostic.toString()));
    }
    if (!compilation.errors().isEmpty()) {
      System.out.println("Compiler errors:");
      compilation.errors().forEach(diagnostic -> System.out.println(diagnostic.toString()));
    }

    assertEquals(compilation.status(), Compilation.Status.SUCCESS);

    for (String expectedCRDFile : getExpectedCRDs()) {
      String crd = getGeneratedCRD(compilation, getOutputPath() + expectedCRDFile);
      verify(expectedCRDFile, crd);
    }
  }

  protected void verify(String expectedCRDFile, String generatedCRD) {
    ApprovalTextWriter writer = new ApprovalTextWriter(generatedCRD, new Options()
        .forFile().withExtension(".yml"));
    ApprovalNamer approvalNamer = new CRDGeneratorApprovalNamer(AbstractCRDGeneratorCompilerTest.class, getClass())
        .addAdditionalInformation(expectedCRDFile.replace(".yml", ""));
    ApprovalApprover approver = new FileApprover(writer, approvalNamer);
    Approvals.verify(approver);
  }

  private String getGeneratedCRD(Compilation compilation, String expectedCRD) {
    Optional<JavaFileObject> maybeFileObject = compilation.generatedFile(StandardLocation.CLASS_OUTPUT, expectedCRD);
    assertTrue(maybeFileObject.isPresent());
    JavaFileObject fileObject = maybeFileObject.get();
    assertEquals(fileObject.getKind(), JavaFileObject.Kind.OTHER);
    try {
      return readFile(fileObject);
    } catch (IOException e) {
      fail(e);
      throw new RuntimeException(e);
    }
  }

  private String readFile(JavaFileObject javaFileObject) throws IOException {
    return new BufferedReader(new InputStreamReader(javaFileObject.openInputStream()))
        .lines().collect(Collectors.joining("\n"));
  }

}
