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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomResourceCollectorE2ETest {

  @Test
  void scanClassDirWithCRs_thenFindAll(@TempDir File tempDir) throws IOException {
    List<String> expectedClasses = TestUtils.prepareDirectoryWithClasses(tempDir);
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToScan(tempDir);
    Class<? extends HasMetadata>[] classes = collector.findCustomResourceClasses();
    assertEquals(expectedClasses.size(), classes.length);
    Arrays.stream(classes).forEach(aClass -> assertTrue(expectedClasses.contains(aClass.getName())));
  }

  @Test
  void scanJarWithCRs_thenFindAll(@TempDir File tempDir) throws IOException {
    File jarFile = new File(tempDir, "test.jar");
    List<String> expectedClasses = TestUtils.prepareJarFileWithClasses(jarFile);
    CustomResourceCollector collector = new CustomResourceCollector();
    collector.withFileToScan(jarFile);
    Class<? extends HasMetadata>[] classes = collector.findCustomResourceClasses();
    assertEquals(expectedClasses.size(), classes.length);
    Arrays.stream(classes).forEach(aClass -> assertTrue(expectedClasses.contains(aClass.getName())));
  }

}
