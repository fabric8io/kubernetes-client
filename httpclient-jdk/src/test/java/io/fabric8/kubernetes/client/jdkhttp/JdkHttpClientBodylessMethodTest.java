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
package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class JdkHttpClientBodylessMethodTest {

  @Test
  void bodylessDeleteKeepsDeleteMethod() throws Exception {
    DefaultMockServer server = new DefaultMockServer(false);
    String path = "/api/v1/namespaces/default/secrets/db-password";
    server.expect().delete().withPath(path).andReturn(200, "{\"kind\":\"Status\",\"status\":\"Success\"}").once();
    server.expect().get().withPath(path).andReturn(200, "{\"kind\":\"Secret\",\"data\":{\"password\":\"c2VjcmV0\"}}")
        .once();

    server.start();
    try (HttpClient client = new JdkHttpClientFactory().newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(server.url(path))
          .method("DELETE", "application/json", null)
          .build();

      HttpResponse<String> response = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
      RecordedRequest recordedRequest = server.getLastRequest();

      assertThat(recordedRequest.getMethod()).isEqualTo("DELETE");
      assertThat(response.body()).contains("\"Status\"");
    } finally {
      server.shutdown();
    }
  }
}
