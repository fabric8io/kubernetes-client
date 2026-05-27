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
package io.fabric8.kubeapitest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {

  @Test
  void getsLatestVersion() {
    assertThat(
        Utils.getLatestVersion(new ArrayList<>(List.of("1.22.4", "1.26.3", "1.26.1", "1.11.2"))))
        .isEqualTo("1.26.3");
    assertThat(Utils.getLatestVersion(new ArrayList<>(List.of("1.22", "1.23.1", "1.24"))))
        .isEqualTo("1.24");
  }

  @Test
  void checksIfVersionIsWildcard() {
    assertThat(Utils.isWildcardVersion("1.25.*")).isTrue();
    assertThat(Utils.isWildcardVersion("1.26.2")).isFalse();
  }

  @Test
  void wildcardToPrefix() {
    assertThat(Utils.wildcardToPrefix("1.25.*")).isEqualTo("1.25");
  }

  @Test
  @DisplayName("findFreePort never returns the same port twice within a JVM so that concurrently-launched child processes (e.g. etcd and kube-apiserver) cannot collide on bind")
  void findFreePortDoesNotReturnDuplicates() {
    // Issue #7873: successive findFreePort() calls within the same JVM could
    // return the same port because the probe ServerSocket was closed before the
    // caller bound it. etcd and kube-apiserver allocate ports in quick
    // succession, hitting "bind: address already in use" when both got the
    // same value. Assert global uniqueness across many calls.
    final int iterations = 500;
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < iterations; i++) {
      int port = Utils.findFreePort();
      assertThat(seen)
          .as("findFreePort returned duplicate port %d on iteration %d", port, i)
          .doesNotContain(port);
      seen.add(port);
    }
    assertThat(seen).hasSize(iterations);
  }

}
