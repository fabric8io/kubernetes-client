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

package io.fabric8.kubernetes.server.mock;

class ServerRequest {

  private final String method;
  private final String path;

  public ServerRequest(String path) {
    this("", path);
  }

  public ServerRequest(String method, String path) {
    this.method = method.toUpperCase();
    this.path = path;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof ServerRequest) {
      ServerRequest other = (ServerRequest) obj;
      return method.equals(other.method) && path.equals(other.path);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return (method + path).hashCode();
  }
}
