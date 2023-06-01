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
package io.fabric8.kubernetes.client.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesVersionPriorityTest {

  @Test
  void should_version_with_highest_priority() {
    // given
    String highest = "v10";
    List<String> versions = Arrays.asList(
        "foo10",
        "v11alpha2",
        "foo1",
        "v3beta1",
        "v2",
        "v10beta3",
        highest,
        "v11beta2",
        "v1",
        "v12alpha1");
    // when
    String computed = KubernetesVersionPriority.highestPriority(versions);
    // then
    assertThat(computed).isEqualTo(highest);
  }
}
