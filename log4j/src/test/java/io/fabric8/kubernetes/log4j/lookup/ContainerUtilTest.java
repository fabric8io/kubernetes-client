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
package io.fabric8.kubernetes.log4j.lookup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URL;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerUtilTest {

  private static final String CONTAINER_ID = "3dd988081e7149463c043b5d9c57d7309e079c5e9290f91feba1cc45a04d6a5b";

  static Stream<Arguments> should_recognize_container_id() {
    return Stream.of(
        // Some possible example /proc/self/cgroup
        Arguments.of("cgroups/positive/case_0.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_1.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_2.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_3.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_4.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_5.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_6.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_7.dat", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_8.dat", CONTAINER_ID),
        // Smoke test in case the file changes format
        Arguments.of("cgroups/negative/case_0.dat", null),
        Arguments.of("cgroups/negative/case_1.dat", null));
  }

  @ParameterizedTest
  @MethodSource
  void should_recognize_container_id(String resourceFile, String expectedContainerId) throws Exception {
    final URL url = ContainerUtilTest.class.getClassLoader().getResource(resourceFile);
    assertThat(url).hasProtocol("file");
    assertThat(ContainerUtil.getContainerId(Paths.get(url.toURI()))).isEqualTo(expectedContainerId);
  }
}
