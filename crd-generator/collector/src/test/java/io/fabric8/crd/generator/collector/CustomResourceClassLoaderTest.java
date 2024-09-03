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
package io.fabric8.crd.generator.collector;

import io.fabric8.crd.generator.collector.examples.MyCustomResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomResourceClassLoaderTest {

  @Test
  void checkNullsafe() {
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    loader.withClasspathElement((String[]) null);
    loader.withClasspathElement((String) null);
    loader.withClasspathElements(null);
    loader.withParentClassLoader(null);
    assertNotNull(loader.loadCustomResourceClass(MyCustomResource.class.getName()));
  }

  @Test
  void loadNotExisting_thenError() {
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    CustomResourceClassLoaderException e = assertThrows(CustomResourceClassLoaderException.class,
        () -> loader.loadCustomResourceClass("io.fabric8.crd.generator.collector.examples.MyNotExistingCustomResource"));
    assertEquals(e.getCause().getClass(), ClassNotFoundException.class);
  }

  @Test
  void loadNotCustomResource_thenError() {
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    String notACustomResourceClassName = String.class.getName();
    assertThrows(CustomResourceClassLoaderException.class,
        () -> loader.loadCustomResourceClass(notACustomResourceClassName));
  }

  @Test
  void loadExistingWithDefaultClassLoader() {
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    assertNotNull(loader.loadCustomResourceClass(MyCustomResource.class.getName()));
  }

  @Test
  void loadExistingWithParentClassLoader() {
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    loader.withParentClassLoader(Thread.currentThread().getContextClassLoader());
    assertNotNull(loader.loadCustomResourceClass(MyCustomResource.class.getName()));
  }

  @Test
  void loadWithAdditionalClasspath(@TempDir File tempDir) throws IOException {
    TestUtils.prepareDirectoryWithClasses(tempDir);
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    loader.withClasspathElement(tempDir.toString());
    assertNotNull(loader.loadCustomResourceClass(MyCustomResource.class.getName()));
  }

  @Test
  void loadWithAdditionalClasspathAndParentClassLoader(@TempDir File tempDir) throws IOException {
    TestUtils.prepareDirectoryWithClasses(tempDir);
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    loader.withParentClassLoader(Thread.currentThread().getContextClassLoader());
    loader.withClasspathElement(tempDir.toString());
    assertNotNull(loader.loadCustomResourceClass(MyCustomResource.class.getName()));
  }

  @Test
  void checkClassLoaderCaching(@TempDir File tempDir) throws IOException {
    TestUtils.prepareDirectoryWithClasses(tempDir);
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    loader.withClasspathElement(tempDir.toString());
    assertSame(loader.getClassLoader(), loader.getClassLoader());
  }

  @Test
  void checkReset(@TempDir File tempDir) throws IOException {
    TestUtils.prepareDirectoryWithClasses(tempDir);
    CustomResourceClassLoader loader = new CustomResourceClassLoader();
    loader.withClasspathElement(tempDir.toString());
    ClassLoader classLoaderBeforeReset = loader.getClassLoader();
    loader.reset();
    ClassLoader classLoaderAfterReset = loader.getClassLoader();
    assertNotSame(classLoaderBeforeReset, classLoaderAfterReset);
  }

}
