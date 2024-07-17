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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IntegerOctalHandlerUtilTest {
  private final ObjectMapper objectMapper = new ObjectMapper();

  private static Stream<Arguments> shouldParseOctalNumbersCorrectly() {
    return Stream.of(
        Arguments.of("\"012\"", Integer.valueOf("012", 8)),
        Arguments.of("\"0o12\"", Integer.valueOf("012", 8)),
        Arguments.of("\"0O12\"", Integer.valueOf("012", 8)));
  }

  @ParameterizedTest
  @MethodSource
  void shouldParseOctalNumbersCorrectly(String input, Integer expectedValue) throws JsonProcessingException {
    assertThat(IntegerOctalHandlerUtil.createIntegerValue(objectMapper.readTree(input)))
        .isEqualTo(expectedValue);
  }
}
