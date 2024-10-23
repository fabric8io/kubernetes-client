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
package io.fabric8.mockwebserver.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Headers are case-insensitive for HTTP/1.1 and must be lower-cased for HTTP/2.
 */
public class Headers {

  private final Map<String, List<String>> headerMap;

  Headers(Map<String, List<String>> headerMap) {
    this.headerMap = headerMap;
  }

  public final List<String> headers(String key) {
    return Collections.unmodifiableList(headerMap.getOrDefault(keySanitize(key), Collections.emptyList()));
  }

  public final String header(String key) {
    final List<String> values = headers(key);
    if (values.size() == 1) {
      return values.get(0);
    }
    if (values.isEmpty()) {
      return null;
    }
    return String.join(",", values);
  }

  public final String get(String name) {
    return header(name);
  }

  /**
   * Compatibility layer for OkHttp
   *
   * @return a Map of the headers with lower-cased keys
   */
  public final Map<String, List<String>> toMultimap() {
    return headerMap.entrySet().stream()
        .collect(Collectors.toMap(e -> keySanitize(e.getKey()), Map.Entry::getValue, (old, neu) -> neu));
  }

  private static String keySanitize(String header) {
    return header.trim().toLowerCase(Locale.ROOT);
  }

  public final Builder newBuilder() {
    return new Builder(new LinkedHashMap<>(headerMap.entrySet()
        .stream().collect(Collectors.toMap(Map.Entry::getKey, e -> new ArrayList<>(e.getValue())))));
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private final Map<String, List<String>> headerMap;

    public Builder() {
      this(new LinkedHashMap<>());
    }

    private Builder(Map<String, List<String>> headers) {
      this.headerMap = headers;
    }

    public Headers build() {
      return new Headers(headerMap);
    }

    public Builder add(String key, String value) {
      headerMap.compute(keySanitize(key), (k, values) -> {
        if (values == null) {
          values = new ArrayList<>();
        }
        values.add(value);
        return values;
      });
      return this;
    }

    /**
     * Add a header line containing a field name, a literal colon, and a value.
     */
    public Builder add(String header) {
      final int index = header.indexOf(":");
      if (index == -1) {
        throw new IllegalArgumentException("Unexpected header: " + header);
      }
      return add(header.substring(0, index).trim(), header.substring(index + 1).trim());
    }

    /**
     * Adds all headers from an existing collection.
     */
    public Builder addAll(Iterable<Map.Entry<String, String>> headers) {
      for (Map.Entry<String, String> header : headers) {
        add(header.getKey(), header.getValue());
      }
      return this;
    }

    public Builder removeAll(String key) {
      headerMap.remove(keySanitize(key));
      return this;
    }

    /**
     * Set a field with the specified value.
     * If the field is not found, it is added. If the field is found, the existing values are replaced.
     */
    public Builder set(String name, String value) {
      return setHeader(name, value);
    }

    public Builder setHeader(String key, String value) {
      final List<String> values = new ArrayList<>();
      values.add(value);
      headerMap.put(keySanitize(key), values);
      return this;
    }

    public Builder setHeaders(Headers headers) {
      headerMap.clear();
      headerMap.putAll(headers.newBuilder().headerMap);
      return this;
    }

  }
}
