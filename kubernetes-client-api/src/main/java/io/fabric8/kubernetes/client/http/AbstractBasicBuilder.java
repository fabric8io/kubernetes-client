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

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class AbstractBasicBuilder<T extends BasicBuilder> implements BasicBuilder {

  private URI uri;
  private final Map<String, List<String>> headers = new HashMap<>();

  @Override
  public T uri(URI uri) {
    this.uri = uri;
    return (T) this;
  }

  @Override
  public T header(String name, String value) {
    headers.compute(name, (k, v) -> {
      if (v == null) {
        v = new ArrayList<>();
      }
      v.add(value);
      return v;
    });
    return (T) this;
  }

  @Override
  public T setHeader(String name, String value) {
    headers.put(name, new ArrayList<>(Collections.singletonList(value)));
    return (T) this;
  }

  protected final URI getUri() {
    return uri;
  }

  protected final Map<String, List<String>> getHeaders() {
    return headers;
  }

  protected final void setHeaders(Map<String, List<String>> headers) {
    this.headers.clear();
    headers.forEach((header, values) -> values.forEach(value -> header(header, value)));
  }
}
