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

/**
 * Basic {@link HttpRequest} implementation to be used in tests instead of mocks or real requests.
 */
public class TestHttpRequest extends TestHttpHeaders<TestHttpRequest> implements HttpRequest {

  private URI uri;
  private String method;
  private String bodyString;

  @Override
  public URI uri() {
    return uri;
  }

  @Override
  public String method() {
    return method;
  }

  @Override
  public String bodyString() {
    return bodyString;
  }

  public TestHttpRequest withUri(URI uri) {
    this.uri = uri;
    return this;
  }

  public TestHttpRequest withMethod(String method) {
    this.method = method;
    return this;
  }

  public TestHttpRequest withBodyString(String bodyString) {
    this.bodyString = bodyString;
    return this;
  }
}
