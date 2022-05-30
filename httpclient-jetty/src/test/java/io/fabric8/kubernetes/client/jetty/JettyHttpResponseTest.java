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
package io.fabric8.kubernetes.client.jetty;

import org.eclipse.jetty.client.HttpResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JettyHttpResponseTest {

  @Test
  void headersHandlesJettyHttpFields() {
    // Given
    final HttpResponse response = new HttpResponse(null, Collections.emptyList())
        .headers(m -> m
            .add("Content-Type", "text/plain")
            .add("Content-Length", "1337")
            .add("Via", "proxy-1")
            .add("Via", "proxy-2"));
    // When
    final Map<String, List<String>> result = new JettyHttpResponse<>(null, response, null)
        .headers();
    // Then
    assertThat(result)
        .hasSize(3)
        .containsEntry("Content-Type", Collections.singletonList("text/plain"))
        .containsEntry("Content-Length", Collections.singletonList("1337"))
        .containsEntry("Via", Arrays.asList("proxy-1", "proxy-2"));
  }

  @ParameterizedTest(name = "{index}: SupportedResponse: from type ''{0}'' is ''{1}''")
  @MethodSource("supportedResponsesInput")
  void supportedResponses(Class<?> type, JettyHttpResponse.SupportedResponse supportedResponse) {
    // When
    final var result = JettyHttpResponse.SupportedResponse.from(type);
    // Then
    assertThat(result).isEqualTo(supportedResponse);
  }

  static Stream<Arguments> supportedResponsesInput() {
    return Stream.of(
        arguments(String.class, JettyHttpResponse.SupportedResponse.TEXT),
        arguments(InputStream.class, JettyHttpResponse.SupportedResponse.INPUT_STREAM),
        arguments(ByteArrayInputStream.class, JettyHttpResponse.SupportedResponse.INPUT_STREAM),
        arguments(Reader.class, JettyHttpResponse.SupportedResponse.READER),
        arguments(InputStreamReader.class, JettyHttpResponse.SupportedResponse.READER),
        arguments(byte[].class, JettyHttpResponse.SupportedResponse.BYTE_ARRAY));
  }
}
