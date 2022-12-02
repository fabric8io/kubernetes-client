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

import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import org.eclipse.jetty.client.api.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JettyHttpResponse<T> implements HttpResponse<T> {

  private final HttpRequest request;
  private final Response response;
  private final T body;

  public JettyHttpResponse(HttpRequest request, Response response, T body) {
    this.request = request;
    this.response = response;
    this.body = body;
  }

  @Override
  public List<String> headers(String key) {
    return response.getHeaders().getValuesList(key);
  }

  @Override
  public Map<String, List<String>> headers() {
    return response.getHeaders().stream().reduce(new HashMap<>(), (m, e) -> {
      m.compute(e.getName(), (k, v) -> {
        if (v == null) {
          v = new ArrayList<>();
        }
        v.add(e.getValue());
        return v;
      });
      return m;
    }, (m1, m2) -> m1);
  }

  @Override
  public int code() {
    return response.getStatus();
  }

  @Override
  public T body() {
    return body;
  }

  @Override
  public HttpRequest request() {
    return request;
  }

  public Response getResponse() {
    return response;
  }

  @Override
  public Optional<HttpResponse<?>> previousResponse() {
    return Optional.empty();
  }

}
