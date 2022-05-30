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
import io.fabric8.kubernetes.client.utils.Utils;
import org.eclipse.jetty.client.api.Response;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

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

  @Override
  public Optional<HttpResponse<?>> previousResponse() {
    return Optional.empty();
  }

  enum SupportedResponse {

    TEXT(String.class, (r, bytes) -> new String(bytes, responseCharset(r))),
    INPUT_STREAM(ByteArrayInputStream.class, (r, bytes) -> new ByteArrayInputStream(bytes)),
    READER(InputStreamReader.class, (r, bytes) -> new InputStreamReader(new ByteArrayInputStream(bytes), responseCharset(r))),
    BYTE_ARRAY(byte[].class, (r, bytes) -> bytes);

    private final Class<?> type;
    private final BiFunction<Response, byte[], Object> processor;

    SupportedResponse(Class<?> type, BiFunction<Response, byte[], Object> processor) {
      this.type = type;
      this.processor = processor;
    }

    public <T> T process(Response response, byte[] bytes, Class<T> type) {
      return type.cast(processor.apply(response, bytes));
    }

    static SupportedResponse from(Class<?> type) {
      for (SupportedResponse sr : SupportedResponse.values()) {
        if (type.isAssignableFrom(sr.type)) {
          return sr;
        }
      }
      throw new IllegalArgumentException("Unsupported response type: " + type.getName());
    }

    private static Charset responseCharset(Response response) {
      var responseCharset = StandardCharsets.UTF_8;
      final var responseEncoding = response.getHeaders().get("Content-Encoding");
      if (Utils.isNotNullOrEmpty(responseEncoding)) {
        try {
          responseCharset = Charset.forName(responseEncoding);
        } catch (Exception e) {
          // ignored
        }
      }
      return responseCharset;
    }
  }
}
