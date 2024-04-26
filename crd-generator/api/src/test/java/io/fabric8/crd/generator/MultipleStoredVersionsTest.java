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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class MultipleStoredVersionsTest {

  @Group("sample.fabric8.io")
  @Version(value = "v3")
  public static class Multiple extends CustomResource<MultipleSpec, Void> {
  }

  @ParameterizedTest(name = "{index}: version: {0}, parallel: {1}")
  @DisplayName("Generate CRD for multiple stored versions throws exception")
  @MethodSource("multipleCrdVersions")
  void generateMultipleThrowsException(String crdVersion, boolean parallel, @TempDir File tmpDir) {
    final CRDGenerator crdGenerator = new CRDGenerator()
        .inOutputDir(tmpDir)
        .withParallelGenerationEnabled(parallel)
        .forCRDVersions(crdVersion)
        .customResourceClasses(io.fabric8.crd.example.multiple.v2.Multiple.class, Multiple.class);
    assertThatIllegalStateException()
        .isThrownBy(crdGenerator::generate)
        .withMessageContaining("Only one version can be marked as storage per custom resource.");
  }

  static Stream<Arguments> multipleCrdVersions() {
    return Stream.of("v1", "v1beta1")
        .flatMap(crdVersion -> Stream.of(
            Arguments.of(crdVersion, false),
            Arguments.of(crdVersion, true)));
  }
}
