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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Basic {@link HttpHeaders} implementation to be used in tests instead of mocks or real headers.
 *
 * @param <T> type for the return type of chained methods.
 */
public class TestHttpHeaders<T extends HttpHeaders> implements HttpHeaders {

  private final Map<String, List<String>> headers = new HashMap<>();

  @Override
  public List<String> headers(String key) {
    return headers.getOrDefault(key, Collections.emptyList());
  }

  @Override
  public Map<String, List<String>> headers() {
    return headers;
  }

  public T clearHeaders() {
    headers.clear();
    return (T) this;
  }

  public T addHeader(String name, String value) {
    headers.compute(name, (k, v) -> {
      if (v == null) {
        v = new ArrayList<>();
      }
      v.add(value);
      return v;
    });
    return (T) this;
  }
}
