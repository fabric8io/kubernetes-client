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
package io.fabric8.kubernetes.model.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

class GoIntegerDeserializerTest {
  private ObjectMapper context;

  @BeforeEach
  void setUp() {
    context = new ObjectMapper();
    context.registerModule(new GoCompatibilityModule());
  }

  @Nested
  @TestInstance(PER_CLASS)
  class Applicable {
    @ParameterizedTest(name = "{index}: with \'{\'\"{0}\": {1}\'}\' parses as {2}")
    @MethodSource
    void parsesOctals(String fieldName, String content, Integer expected) throws Exception {
      final IntegerFieldsContainer result = context.readValue(String.format("{\"%s\": %s}", fieldName, content),
          IntegerFieldsContainer.class);
      assertThat(result).hasFieldOrPropertyWithValue(fieldName, expected);
    }

    private Stream<Arguments> parsesOctals() {
      return Stream.of("mode", "defaultMode")
          .flatMap(field -> Stream.of(Arguments.of(field, "null", null), Arguments.of(field, "\"400\"", 400),
              Arguments.of(field, "\"0555\"", 365), Arguments.of(field, "\"0o555\"", 365),
              Arguments.of(field, "\"0O555\"", 365), Arguments.of(field, "\"555\"", 555), Arguments.of(field, "\"0888\"", 888),
              Arguments.of(field, "\"0o12\"", 10), Arguments.of(field, "\"0O12\"", 10)));
    }
  }

  //
  @Nested
  class NotApplicable {
    @Test
    void parsesOctalsAsDecimal() throws Exception {
      final IntegerFieldsContainer result = context.readValue("{\"notApplicable\": \"0555\"}", IntegerFieldsContainer.class);
      assertThat(result).hasFieldOrPropertyWithValue("notApplicable", 555);
    }

    @Test
    void throwsExceptionForInvalidOctal() {
      assertThatThrownBy(() -> context.readValue("{\"mode\": \"0o955\"}", IntegerFieldsContainer.class))
          .isInstanceOf(InvalidFormatException.class);
    }

    @Test
    void throwsExceptionForOctalWithSeparator() {
      assertThatThrownBy(() -> context.readValue("{\"notApplicable\": \"0o555\"}", IntegerFieldsContainer.class))
          .isInstanceOf(InvalidFormatException.class);
    }
  }

  private static final class IntegerFieldsContainer {
    private Integer mode;
    private Integer defaultMode;
    private Integer notApplicable;

    public IntegerFieldsContainer() {
    }

    public Integer getMode() {
      return this.mode;
    }

    public Integer getDefaultMode() {
      return this.defaultMode;
    }

    public Integer getNotApplicable() {
      return this.notApplicable;
    }

    public void setMode(final Integer mode) {
      this.mode = mode;
    }

    public void setDefaultMode(final Integer defaultMode) {
      this.defaultMode = defaultMode;
    }

    public void setNotApplicable(final Integer notApplicable) {
      this.notApplicable = notApplicable;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof GoIntegerDeserializerTest.IntegerFieldsContainer))
        return false;
      final GoIntegerDeserializerTest.IntegerFieldsContainer other = (GoIntegerDeserializerTest.IntegerFieldsContainer) o;
      final java.lang.Object this$mode = this.getMode();
      final java.lang.Object other$mode = other.getMode();
      if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode))
        return false;
      final java.lang.Object this$defaultMode = this.getDefaultMode();
      final java.lang.Object other$defaultMode = other.getDefaultMode();
      if (this$defaultMode == null ? other$defaultMode != null : !this$defaultMode.equals(other$defaultMode))
        return false;
      final java.lang.Object this$notApplicable = this.getNotApplicable();
      final java.lang.Object other$notApplicable = other.getNotApplicable();
      if (this$notApplicable == null ? other$notApplicable != null : !this$notApplicable.equals(other$notApplicable))
        return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $mode = this.getMode();
      result = result * PRIME + ($mode == null ? 43 : $mode.hashCode());
      final java.lang.Object $defaultMode = this.getDefaultMode();
      result = result * PRIME + ($defaultMode == null ? 43 : $defaultMode.hashCode());
      final java.lang.Object $notApplicable = this.getNotApplicable();
      result = result * PRIME + ($notApplicable == null ? 43 : $notApplicable.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "GoIntegerDeserializerTest.IntegerFieldsContainer(mode=" + this.getMode() + ", defaultMode="
          + this.getDefaultMode() + ", notApplicable=" + this.getNotApplicable() + ")";
    }
  }
}
