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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Kubernetes Mock Server Expectations")
class ExpectationsTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    server = new KubernetesMockServer();
    server.start();
    client = server.createClient();
  }

  @Nested
  @DisplayName("POST")
  class Post {

    @Test
    void postOk() {
      // Given
      server.expect()
          .post()
          .withPath("/api/post/ok")
          .andReturn(200, "ok")
          .once();
      // When
      final String result = client.raw("/api/post/ok", "POST", null);
      // Then
      assertThat(result).isEqualTo("ok");
    }
  }
}
