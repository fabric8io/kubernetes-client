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

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * HttpResponse implementation wrapping an existing HttpResponse with a processed body.
 * <p>
 * Allows for changing the body type - there is further redesign that could be done here
 *
 * @param <T> the type of the body.
 */
class HttpResponseAdapter<T> implements HttpResponse<T> {

  private final HttpResponse<?> response;
  private final T body;

  public HttpResponseAdapter(HttpResponse<?> response, T body) {
    this.response = response;
    this.body = body;
  }

  @Override
  public List<String> headers(String key) {
    return response.headers(key);
  }

  @Override
  public boolean isSuccessful() {
    return response.isSuccessful();
  }

  @Override
  public Map<String, List<String>> headers() {
    return response.headers();
  }

  @Override
  public int code() {
    return response.code();
  }

  @Override
  public String message() {
    return response.message();
  }

  @Override
  public HttpRequest request() {
    return response.request();
  }

  @Override
  public Optional<HttpResponse<?>> previousResponse() {
    return response.previousResponse();
  }

  @Override
  public T body() {
    return body;
  }

}
