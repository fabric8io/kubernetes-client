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
package io.fabric8.crdv2.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CRDUtilsTest {

  @Nested
  class ToMap {

    @Test
    @DisplayName("Only the first '=' separates the key, so values may contain '='")
    void splitsOnFirstSeparatorOnly() {
      assertThat(CRDUtils.toMap(new String[] { "three=3", "four=4=4", "five=====>" }))
          .containsEntry("three", "3")
          .containsEntry("four", "4=4")
          .containsEntry("five", "====>");
    }

    @Test
    @DisplayName("An entry without a separator is rejected")
    void rejectsEntryWithoutSeparator() {
      assertThatIllegalArgumentException()
          .isThrownBy(() -> CRDUtils.toMap(new String[] { "novalue" }))
          .withMessageContaining("cannot be parsed as a key-value pair");
    }

    @Test
    @DisplayName("An entry with an empty value is rejected, although Kubernetes allows empty label values")
    void rejectsEntryWithEmptyValue() {
      assertThatIllegalArgumentException()
          .isThrownBy(() -> CRDUtils.toMap(new String[] { "key=" }))
          .withMessageContaining("cannot be parsed as a key-value pair");
    }

    @Test
    @DisplayName("A null array yields an empty map")
    void nullArrayYieldsEmptyMap() {
      assertThat(CRDUtils.toMap(null)).isEmpty();
    }
  }
}
