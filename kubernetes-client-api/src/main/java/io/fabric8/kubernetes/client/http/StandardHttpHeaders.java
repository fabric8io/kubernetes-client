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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StandardHttpHeaders implements HttpHeaders {

  public static final String CONTENT_TYPE = "Content-Type";
  public static final String CONTENT_LENGTH = "Content-Length";
  public static final String EXPECT = "Expect";
  public static final String EXPECT_CONTINUE = "100-continue";

  private final Map<String, List<String>> headers;

  public StandardHttpHeaders() {
    this(new LinkedHashMap<>());
  }

  public StandardHttpHeaders(Map<String, List<String>> headers) {
    this.headers = headers;
  }

  @Override
  public List<String> headers(String key) {
    return Collections.unmodifiableList(headers.getOrDefault(key, Collections.emptyList()));
  }

  @Override
  public Map<String, List<String>> headers() {
    return Collections.unmodifiableMap(headers);
  }
}
