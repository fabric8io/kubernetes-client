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
package io.fabric8.kubeapitest.binary.repo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryRepoTest {

  @Test
  void downloadsIndex() {
    new BinaryRepo(null).listObjectNames();
  }

  @Test
  void parsesSelfLinkToArchiveDescriptor() {
    var archiveDescriptor = BinaryRepo
        .mapSelfLinkToArchiveDescriptor(
            "https://github.com/kubernetes-sigs/controller-tools/releases/download/envtest-v1.28.0/envtest-v1.28.0-linux-arm64.tar.gz");

    assertThat(archiveDescriptor.getOs()).isEqualTo("linux");
    assertThat(archiveDescriptor.getArch()).isEqualTo("arm64");
    assertThat(archiveDescriptor.getVersion()).isEqualTo("1.28.0");
  }

}
