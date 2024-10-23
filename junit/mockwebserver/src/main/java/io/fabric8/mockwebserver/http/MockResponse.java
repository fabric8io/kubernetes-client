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

import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MockResponse implements Response {

  private Headers.Builder headers;
  private String httpVersion;
  private int code;
  private Buffer body;
  private Duration bodyDelay;
  private WebSocketListener webSocketListener;

  public MockResponse() {
    this.headers = Headers.builder();
    httpVersion = "HTTP/1.1";
  }

  @Override
  public String getStatus() {
    final HttpResponseStatus status;
    if (code == 200 || code % 100 != 0) {
      status = HttpResponseStatus.valueOf(code);
    } else {
      // Get the status for an invalid code which contains a default reason matching the family/class name
      status = HttpResponseStatus.valueOf(code + 99);
    }
    var reason = status.codeClass() == HttpStatusClass.UNKNOWN ? "Mock Response" : status.reasonPhrase();
    if (reason.indexOf('(') > -1) {
      reason = reason.substring(0, reason.indexOf('('));
    }
    return httpVersion + " " + code + " " + reason.trim();
  }

  @Override
  public int code() {
    return code;
  }

  @Override
  public Headers getHeaders() {
    return headers.build();
  }

  @Override
  public Buffer getBody() {
    return body;
  }

  @Override
  public WebSocketListener getWebSocketListener() {
    return webSocketListener;
  }

  public List<String> headers(String key) {
    return headers.build().headers(key);
  }

  public String header(String key) {
    return headers.build().header(key);
  }

  public MockResponse setHttpVersion(String httpVersion) {
    this.httpVersion = httpVersion;
    return this;
  }

  public MockResponse setResponseCode(int code) {
    this.code = code;
    return this;
  }

  public MockResponse setBody(Buffer body) {
    this.body = body;
    return this;
  }

  public MockResponse setBody(byte[] body) {
    return setBody(new Buffer(body));
  }

  public MockResponse setBody(String body) {
    return setBody(new Buffer().writeUtf8(body));
  }

  /**
   * Sets the response body to {@code body}, chunked every {@code maxChunkSize} bytes.
   */
  public MockResponse setChunkedBody(Buffer body, int maxChunkSize) {
    removeHeader("Content-Length");
    setHeader("Transfer-encoding", "chunked");

    final Buffer chunkedBody = new Buffer();
    final byte[] bodyBytes = body.getBytes();
    int offset = 0;
    while (offset < bodyBytes.length) {
      final int chunkSize = Math.min(bodyBytes.length - offset, maxChunkSize);
      chunkedBody.writeUtf8(Integer.toHexString(chunkSize));
      chunkedBody.writeUtf8("\r\n");
      chunkedBody.write(bodyBytes, offset, chunkSize);
      chunkedBody.writeUtf8("\r\n");
      offset += chunkSize;
    }
    chunkedBody.writeUtf8("0\r\n"); // Last chunk. Trailers follow!

    this.body = chunkedBody;
    return this;
  }

  /**
   * Sets the response body to the UTF-8 encoded bytes of {@code body}, chunked every {@code
   * maxChunkSize} bytes.
   */
  public MockResponse setChunkedBody(String body, int maxChunkSize) {
    return setChunkedBody(new Buffer().writeUtf8(body), maxChunkSize);
  }

  public Duration getBodyDelay() {
    return bodyDelay;
  }

  public MockResponse setBodyDelay(long delay, TimeUnit delayUnit) {
    return setBodyDelay(Duration.ofMillis(delayUnit.toMillis(delay)));
  }

  public MockResponse setBodyDelay(Duration bodyDelay) {
    this.bodyDelay = bodyDelay;
    return this;
  }

  public MockResponse clearHeaders() {
    headers = Headers.builder();
    return this;
  }

  public MockResponse addHeader(String header) {
    headers.add(header);
    return this;
  }

  public MockResponse addHeader(String name, Object value) {
    headers.add(name, String.valueOf(value));
    return this;
  }

  public MockResponse setHeaders(Headers headers) {
    this.headers = headers.newBuilder();
    return this;
  }

  public MockResponse setHeader(String name, Object value) {
    headers.setHeader(name, String.valueOf(value));
    return this;
  }

  public MockResponse removeHeader(String name) {
    headers.removeAll(name);
    return this;
  }

  public MockResponse withWebSocketUpgrade(WebSocketListener listener) {
    body = null;
    webSocketListener = listener;
    return this;
  }

  @Override
  public String toString() {
    return getStatus();
  }

}
