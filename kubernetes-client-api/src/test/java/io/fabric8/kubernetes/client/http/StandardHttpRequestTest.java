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
package io.fabric8.kubernetes.client.http;

import io.fabric8.kubernetes.client.utils.IOHelpers;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class StandardHttpRequestTest {

  @Test
  void builderMethod() {
    // Given
    final HttpRequest.Builder b = new StandardHttpRequest.Builder()
        .header("h1", "v1")
        .header("h1", "v2")
        .uri("https://example.com/aitana")
        .expectContinue()
        .method("PUT", "application/json", "{\"v\":true}");
    // When
    final HttpRequest result = b.build();
    // Then
    assertThat(result)
        .isInstanceOf(StandardHttpRequest.class)
        .returns(URI.create("https://example.com/aitana"), HttpRequest::uri)
        .returns("PUT", HttpRequest::method)
        .returns("{\"v\":true}", HttpRequest::bodyString)
        .extracting(HttpHeaders::headers, InstanceOfAssertFactories.map(String.class, List.class))
        .containsOnly(
            entry("h1", Arrays.asList("v1", "v2")),
            entry("Content-Type", Collections.singletonList("application/json")),
            entry("Expect", Collections.singletonList("100-Continue")));
  }

  @Test
  void builderPostBytes() {
    // Given
    final HttpRequest.Builder b = new StandardHttpRequest.Builder()
        .uri("https://example.com/alex")
        .post("text/plain", "The bytes".getBytes(StandardCharsets.UTF_8));
    // When
    final HttpRequest result = b.build();
    // Then
    assertThat(result)
        .isInstanceOf(StandardHttpRequest.class)
        .asInstanceOf(InstanceOfAssertFactories.type(StandardHttpRequest.class))
        .returns(URI.create("https://example.com/alex"), HttpRequest::uri)
        .returns("POST", HttpRequest::method)
        .returns("The bytes", r -> toString(r.bodyStream()))
        .extracting(HttpHeaders::headers, InstanceOfAssertFactories.map(String.class, List.class))
        .containsOnly(
            entry("Content-Type", Collections.singletonList("text/plain")),
            entry("Content-Length", Collections.singletonList("9")));
  }

  @Test
  void toBuilderReturnsNewBuilderWithPreservedSettings() {
    // Given
    final HttpRequest.Builder b = new StandardHttpRequest.Builder()
        .header("h1", "v1")
        .uri("https://example.com/julia");
    // When
    final HttpRequest.Builder result = ((StandardHttpRequest) b.build()).toBuilder();
    // Then
    assertThat(result)
        .isNotSameAs(b)
        .extracting(HttpRequest.Builder::build)
        .isInstanceOf(StandardHttpRequest.class)
        .returns(URI.create("https://example.com/julia"), HttpRequest::uri)
        .returns("GET", HttpRequest::method)
        .extracting(HttpHeaders::headers, InstanceOfAssertFactories.map(String.class, List.class))
        .containsOnly(
            entry("h1", Collections.singletonList("v1")));
  }

  static String toString(InputStream is) {
    try {
      return IOHelpers.readFully(is);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
