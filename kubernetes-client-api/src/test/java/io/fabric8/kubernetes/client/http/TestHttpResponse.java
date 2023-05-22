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

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Basic {@link HttpResponse} implementation to be used in tests instead of mocks or real responses.
 *
 * @param <T> type of the response body.
 */
public class TestHttpResponse<T> extends StandardHttpHeaders implements HttpResponse<T> {

  private int code;
  private T body;
  private HttpRequest request;
  private HttpResponse<T> previousResponse;

  public TestHttpResponse() {
    super();
  }

  public TestHttpResponse(Map<String, List<String>> headers) {
    super(headers);
  }

  @Override
  public int code() {
    return code;
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
    return Optional.ofNullable(previousResponse);
  }

  public int getCode() {
    return code;
  }

  public TestHttpResponse<T> withCode(int code) {
    this.code = code;
    return this;
  }

  public T getBody() {
    return body;
  }

  public TestHttpResponse<T> withBody(T body) {
    this.body = body;
    return this;
  }

  public HttpResponse<T> withRequest(HttpRequest request) {
    this.request = request;
    return this;
  }

  public HttpResponse<T> getPreviousResponse() {
    return previousResponse;
  }

  public HttpResponse<T> withPreviousResponse(HttpResponse<T> previousResponse) {
    this.previousResponse = previousResponse;
    return this;
  }

  public static TestHttpResponse<byte[]> from(int code, String body) {
    return new TestHttpResponse<byte[]>().withCode(code)
        .withBody(body.getBytes(StandardCharsets.UTF_8));
  }
}
