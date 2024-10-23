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

import io.fabric8.mockwebserver.dsl.HttpMethod;

import java.net.Socket;
import java.util.List;

public class RecordedRequest {

  private final String httpVersion;
  private final HttpMethod method;
  private final String path;
  private final Headers headers;
  private final Buffer body;

  public RecordedRequest(String httpVersion, HttpMethod method, String path, Headers headers, Buffer body) {
    this.httpVersion = httpVersion;
    this.method = method;
    this.path = path;
    this.headers = headers;
    this.body = body;
  }

  public String getRequestLine() {
    return method + " " + path + " " + httpVersion;
  }

  public String getPath() {
    return path;
  }

  /**
   * Compatibility layer for OkHttp
   *
   * @return a String with the HTTP method.
   */
  public String getMethod() {
    return method.toString();
  }

  public HttpMethod method() {
    return method;
  }

  public String getHttpVersion() {
    return httpVersion;
  }

  /**
   * Returns the body of this POST request.
   */
  public Buffer getBody() {
    return body;
  }

  public String getUtf8Body() {
    return getBody() != null ? getBody().readUtf8() : null;
  }

  public Headers getHeaders() {
    return headers;
  }

  public String getHeader(String key) {
    return headers.header(key);
  }

  @Override
  public String toString() {
    return getRequestLine();
  }

  /**
   * Compatibility layer for OkHttp.
   *
   * @deprecated use the non-deprecated constructor instead.
   */
  @Deprecated
  public RecordedRequest(String requestLine, Headers headers, List<Integer> chunkSizes, long bodySize, Buffer body,
      int sequenceNumber, Socket socket) {
    this(extractHttpVersion(requestLine), extractMethod(requestLine), extractPath(requestLine), headers, body);
  }

  private static HttpMethod extractMethod(String requestLine) {
    return HttpMethod.valueOf(requestLine.split(" ")[0]);
  }

  private static String extractPath(String requestLine) {
    final int methodEnd = requestLine.indexOf(' ');
    final int pathEnd = requestLine.indexOf(' ', methodEnd + 1);
    return requestLine.substring(methodEnd + 1, pathEnd);
  }

  private static String extractHttpVersion(String requestLine) {
    final int pathEnd = requestLine.lastIndexOf(' ');
    return requestLine.substring(pathEnd + 1);
  }

}
