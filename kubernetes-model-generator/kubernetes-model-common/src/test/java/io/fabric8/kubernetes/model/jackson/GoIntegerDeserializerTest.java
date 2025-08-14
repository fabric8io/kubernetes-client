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
import lombok.Data;
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

    @ParameterizedTest(name = "{index}: with '{'\"{0}\": {1}'}' parses as {2}")
    @MethodSource
    void parsesOctals(String fieldName, String content, Integer expected) throws Exception {
      final IntegerFieldsContainer result = context
          .readValue(String.format("{\"%s\": %s}", fieldName, content), IntegerFieldsContainer.class);
      assertThat(result).hasFieldOrPropertyWithValue(fieldName, expected);
    }

    private Stream<Arguments> parsesOctals() {
      return Stream.of("mode", "defaultMode")
          .flatMap(field -> Stream.of(
              Arguments.of(field, "null", null),
              Arguments.of(field, "\"400\"", 400),
              Arguments.of(field, "\"0555\"", 365),
              Arguments.of(field, "\"0o555\"", 365),
              Arguments.of(field, "\"0O555\"", 365),
              Arguments.of(field, "\"555\"", 555),
              Arguments.of(field, "\"0888\"", 888),
              Arguments.of(field, "\"0o12\"", 10),
              Arguments.of(field, "\"0O12\"", 10)));
    }
  }

  //
  @Nested
  class NotApplicable {

    @Test
    void parsesOctalsAsDecimal() throws Exception {
      final IntegerFieldsContainer result = context
          .readValue("{\"notApplicable\": \"0555\"}", IntegerFieldsContainer.class);
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

  @Data
  private static final class IntegerFieldsContainer {
    private Integer mode;
    private Integer defaultMode;
    private Integer notApplicable;
  }
}
