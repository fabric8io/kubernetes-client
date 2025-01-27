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
package io.fabric8.kubernetes.client.behavior;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesClientBuilderTest {

  @Nested
  class WithConfig {

    @Test
    void fromStringDoesntAutoconfigure() {
      final var config = "{\"masterUrl\":\"https://example.com\"}";
      try (var client = new KubernetesClientBuilder().withConfig(config).build()) {
        assertThat(client.getConfiguration())
            .returns(false, c -> Boolean.TRUE.equals(c.getAutoConfigure()))
            .returns("https://example.com/", Config::getMasterUrl);
      }
    }

    @Test
    void fromInputStreamDoesntAutoconfigure() {
      final var config = new ByteArrayInputStream("{\"masterUrl\":\"https://example.com\"}".getBytes(StandardCharsets.UTF_8));
      try (var client = new KubernetesClientBuilder().withConfig(config).build()) {
        assertThat(client.getConfiguration())
            .returns(false, c -> Boolean.TRUE.equals(c.getAutoConfigure()))
            .returns("https://example.com/", Config::getMasterUrl);
      }
    }
  }
}
