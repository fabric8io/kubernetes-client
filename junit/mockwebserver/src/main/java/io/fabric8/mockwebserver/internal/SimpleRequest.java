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

package io.fabric8.mockwebserver.internal;

import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.dsl.HttpMethod;

public class SimpleRequest implements ServerRequest {

  private static final String ROOT = "/";

  private final HttpMethod method;
  private final String path;

  public SimpleRequest() {
    this(HttpMethod.ANY, ROOT);
  }

  public SimpleRequest(String path) {
    this(HttpMethod.ANY, path);
  }

  public SimpleRequest(HttpMethod method, String path) {
    this.method = method;
    this.path = path;
  }

  public HttpMethod getMethod() {
    return method;
  }

  public String getPath() {
    return path;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    SimpleRequest that = (SimpleRequest) o;

    if (method != that.method)
      return false;
    return path != null ? path.equals(that.path) : that.path == null;

  }

  @Override
  public int hashCode() {
    int result = method != null ? method.hashCode() : 0;
    result = 31 * result + (path != null ? path.hashCode() : 0);
    return result;
  }
}
