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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractConfiguredClientTest {

  private static DefaultMockServer server;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  private HttpClient clientWithDefaultConfiguration() {
    return getHttpClientFactory().newBuilder(Config.empty()).build();
  }

  @Test
  public void userAgentTest() throws Exception {
    try (final HttpClient client = clientWithDefaultConfiguration()) {
      server.expect().withPath("/consume-bytes")
          .andReturn(200, "This is the response body as bytes")
          .always();
      client.sendAsync(client.newHttpRequestBuilder().uri(server.url("/consume-bytes")).build(), String.class).get(10L,
          TimeUnit.SECONDS);
      // ensure that the header interceptor is applied
      assertThat(server.getLastRequest().getHeader("User-Agent")).startsWith("fabric8-kubernetes-client");
    }
  }

}
