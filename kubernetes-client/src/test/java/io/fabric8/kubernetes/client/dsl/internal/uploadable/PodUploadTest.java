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
package io.fabric8.kubernetes.client.dsl.internal.uploadable;

import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

class PodUploadTest {

  @Test
  void transferTo() throws Exception {
    final ByteArrayInputStream input = new ByteArrayInputStream("I'LL BE COPIED".getBytes(Charset.defaultCharset()));
    final AtomicReference<String> copiedStream = new AtomicReference<>();
    final InputStreamPumper.Writable consumer = (bytes, offset, length) -> {
      assertThat(length).isEqualTo(14);
      copiedStream.set(new String(Arrays.copyOf(bytes, 14), Charset.defaultCharset()));
    };
    InputStreamPumper.transferTo(input, consumer);
    assertThat(copiedStream).hasValue("I'LL BE COPIED");
  }

  @Nested
  @DisplayName("createExecCommandForUpload")
  class CreateExecCommand {
    @Test
    void withFileInRootPath_shouldCreateValidExecCommandForUpload() {
      // When
      String result = PodUpload.createExecCommandForUpload("/cp.log");
      // Then
      assertThat(result).isEqualTo("mkdir -p '/' && cat - > '/cp.log'");
    }

    @Test
    void withNormalFile_shouldCreateValidExecCommandForUpload() {
      // When
      String result = PodUpload.createExecCommandForUpload("/tmp/foo/cp.log");
      // Then
      assertThat(result).isEqualTo("mkdir -p '/tmp/foo' && cat - > '/tmp/foo/cp.log'");
    }

    //
    @Test
    void withSingleQuoteInPath() {
      // When
      String result = PodUpload.createExecCommandForUpload("/tmp/fo'o/cp.log");
      // Then
      assertThat(result).isEqualTo("mkdir -p '/tmp/fo\'\\'\'o' && cat - > '/tmp/fo\'\\'\'o/cp.log'");
    }

    @Test
    void withMultipleSingleQuotesInPath() {
      // When
      String result = PodUpload.createExecCommandForUpload("/tmp/f'o'o/c'p.log");
      // Then
      assertThat(result).isEqualTo("mkdir -p '/tmp/f\'\\'\'o\'\\'\'o' && cat - > '/tmp/f\'\\'\'o\'\\'\'o/c\'\\'\'p.log'");
    }
  }

}
