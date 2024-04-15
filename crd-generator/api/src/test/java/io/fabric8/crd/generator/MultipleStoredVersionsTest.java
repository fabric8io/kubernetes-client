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
package io.fabric8.crd.generator;

import io.fabric8.crd.example.multiple.v2.MultipleSpec;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultipleStoredVersionsTest {

  @Group("sample.fabric8.io")
  @Version(value = "v3")
  public static class Multiple extends CustomResource<MultipleSpec, Void> {
  }

  @Test
  public void generateV1_expectException(@TempDir File tmpDir) {
    test("v1", false, tmpDir);
  }

  @Test
  public void generateV1beta1_expectException(@TempDir File tmpDir) {
    test("v1beta1", false, tmpDir);
  }

  @Test
  public void generateV1Parallel_expectException(@TempDir File tmpDir) {
    test("v1", true, tmpDir);
  }

  @Test
  public void generateV1beta1Parallel_expectException(@TempDir File tmpDir) {
    test("v1beta1", true, tmpDir);
  }

  public void test(String crdVersion, boolean parallel, File tmpDir) {
    final CRDGenerator crdGenerator = new CRDGenerator()
        .inOutputDir(tmpDir)
        .withParallelGenerationEnabled(parallel)
        .forCRDVersions(crdVersion)
        .customResourceClasses(io.fabric8.crd.example.multiple.v2.Multiple.class, Multiple.class);

    assertThrows(IllegalStateException.class, crdGenerator::generate);
  }
}
