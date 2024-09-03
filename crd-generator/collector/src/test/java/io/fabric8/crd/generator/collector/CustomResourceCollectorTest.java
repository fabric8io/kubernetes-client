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

import io.fabric8.kubernetes.api.model.HasMetadata;
import org.jboss.jandex.IndexView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustomResourceCollectorTest {

  CustomResourceClassLoader customResourceClassLoader;
  JandexCustomResourceClassScanner jandexCustomResourceClassScanner;

  CustomResourceCollector customResourceCollector;

  @BeforeEach
  void setUp() {
    customResourceClassLoader = Mockito.mock(CustomResourceClassLoader.class);
    jandexCustomResourceClassScanner = Mockito.mock(JandexCustomResourceClassScanner.class);
    customResourceCollector = new CustomResourceCollector(customResourceClassLoader, jandexCustomResourceClassScanner);
  }

  @Test
  void givenClassName_thenLoadClassAndSkipScan() {
    customResourceCollector.withCustomResourceClass("com.example.Test");

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    verify(customResourceClassLoader, times(1)).loadCustomResourceClass("com.example.Test");
    verify(jandexCustomResourceClassScanner, times(0)).findCustomResourceClasses();
    assertEquals(1, classes.size());
  }

  @Test
  void givenClassNameAndFileToScan_thenLoadClassAndSkipScan() {
    customResourceCollector.withCustomResourceClass("com.example.Test");
    customResourceCollector.withFileToScan(Mockito.mock(File.class));

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    verify(customResourceClassLoader, times(1)).loadCustomResourceClass("com.example.Test");
    verify(jandexCustomResourceClassScanner, times(0)).findCustomResourceClasses();
    assertEquals(1, classes.size());
  }

  @Test
  void givenClassNameAndFileToScanAndForceScan_thenScan() {
    customResourceCollector.withCustomResourceClass("com.example.Test");
    customResourceCollector.withFileToScan(Mockito.mock(File.class));
    customResourceCollector.withForceScan(true);

    when(jandexCustomResourceClassScanner.findCustomResourceClasses())
        .thenReturn(Arrays.asList("com.example.Test1", "com.example.Test2"));

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    verify(customResourceClassLoader, times(1)).loadCustomResourceClass("com.example.Test");
    verify(jandexCustomResourceClassScanner, times(1)).findCustomResourceClasses();
    assertEquals(3, classes.size());
  }

  @Test
  void givenFileToScan_thenScan() {
    customResourceCollector.withFileToScan(Mockito.mock(File.class));

    when(jandexCustomResourceClassScanner.findCustomResourceClasses())
        .thenReturn(Arrays.asList("com.example.Test1", "com.example.Test2"));

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    verify(jandexCustomResourceClassScanner, times(1)).findCustomResourceClasses();
    assertEquals(2, classes.size());
  }

  @Test
  void givenClassNameAndExcludePackage_thenNoLoading() {
    customResourceCollector.withCustomResourceClass("com.example.Test");
    customResourceCollector.withExcludePackages(Collections.singletonList("com.example"));

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    verify(customResourceClassLoader, times(0)).loadCustomResourceClass(anyString());
    assertEquals(0, classes.size());
  }

  @Test
  void givenClassNamesAndIncludePackage_thenLoad() {
    customResourceCollector.withCustomResourceClass("com.example.Test", "com.other.Test");
    customResourceCollector.withIncludePackages(Collections.singletonList("com.example"));

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    verify(customResourceClassLoader, times(1)).loadCustomResourceClass(anyString());
    assertEquals(1, classes.size());
  }

  @Test
  void checkNullsafe() {
    CustomResourceCollector collector = new CustomResourceCollector();

    collector.withCustomResourceClass((String[]) null);
    collector.withCustomResourceClass((String) null);
    collector.withCustomResourceClasses(null);

    collector.withParentClassLoader(null);
    collector.withClasspathElement((String) null);
    collector.withClasspathElements(null);

    collector.withIndex((IndexView[]) null);
    collector.withIndex((IndexView) null);
    collector.withIndices(null);

    collector.withFileToScan((File[]) null);
    collector.withFileToScan((File) null);
    collector.withFilesToScan(null);

    collector.withIncludePackages(null);
    collector.withExcludePackages(null);

    collector.withForceIndex(true);

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    assertEquals(0, classes.size());
  }

  @Test
  void checkReset() {
    customResourceCollector.withCustomResourceClass("com.example.Test");
    customResourceCollector.reset();
    verify(customResourceClassLoader, times(1)).reset();
    verify(jandexCustomResourceClassScanner, times(1)).reset();

    List<Class<? extends HasMetadata>> classes = customResourceCollector.findCustomResourceClasses();
    verify(customResourceClassLoader, times(0)).loadCustomResourceClass(anyString());
    assertEquals(0, classes.size());
  }

  @Test
  void withParentClassLoader() {
    ClassLoader classLoader = mock(ClassLoader.class);
    assertEquals(customResourceCollector, customResourceCollector.withParentClassLoader(classLoader));
  }

  @Test
  void withParentClassLoader_thenDelegate() {
    customResourceCollector.withParentClassLoader(mock(ClassLoader.class));
    verify(customResourceClassLoader, times(1)).withParentClassLoader(any());
  }

  @Test
  void withClasspathElement_thenDelegate() {
    customResourceCollector.withClasspathElement("path");
    verify(customResourceClassLoader, times(1)).withClasspathElement("path");
  }

  @Test
  void withClasspathElements_thenDelegate() {
    customResourceCollector.withClasspathElements(Arrays.asList("path1", "path2"));
    customResourceCollector.findCustomResourceClasses();
    verify(customResourceClassLoader, times(1)).withClasspathElements(anyCollection());
  }

  @Test
  void withIndex_thenDelegate() {
    customResourceCollector.withIndex(mock(IndexView.class));
    verify(jandexCustomResourceClassScanner, times(1)).withIndex(any());
  }

  @Test
  void withIndices_thenDelegate() {
    customResourceCollector.withIndices(Arrays.asList(mock(IndexView.class), mock(IndexView.class)));
    verify(jandexCustomResourceClassScanner, times(1)).withIndices(anyCollection());
  }

  @Test
  void withFileToScan_thenDelegate() {
    customResourceCollector.withFileToScan(mock(File.class));
    verify(jandexCustomResourceClassScanner, times(1)).withFileToScan(any());
  }

  @Test
  void withFilesToScan_thenDelegate() {
    customResourceCollector.withFilesToScan(Arrays.asList(mock(File.class), mock(File.class)));
    verify(jandexCustomResourceClassScanner, times(1)).withFilesToScan(anyCollection());
  }

}
