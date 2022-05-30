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

package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.http.HttpRequest;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

class OkHttpRequestImpl implements HttpRequest {

  static class BuilderImpl implements Builder {

    private final Request.Builder builder;

    public BuilderImpl() {
      this(new Request.Builder());
    }

    public BuilderImpl(Request.Builder builder) {
      this.builder = builder;
    }

    @Override
    public HttpRequest build() {
      return new OkHttpRequestImpl(builder.build());
    }

    @Override
    public Builder uri(String uri) {
      builder.url(uri);
      return this;
    }

    @Override
    public Builder url(URL resourceUrl) {
      builder.url(resourceUrl);
      return this;
    }

    @Override
    public Builder method(String method, String contentType, String body) {
      builder.method(method, RequestBody.create(OkHttpClientImpl.parseMediaType(contentType), body));
      return this;
    }

    @Override
    public Builder post(String contentType, byte[] writeValueAsBytes) {
      builder.post(RequestBody.create(OkHttpClientImpl.parseMediaType(contentType), writeValueAsBytes));
      return this;
    }

    @Override
    public Builder post(String contentType, InputStream inputStream, long length) {
      builder.post(new RequestBody() {

        @Override
        public void writeTo(BufferedSink sink) throws IOException {
          try (final BufferedInputStream bis = new BufferedInputStream(inputStream);
              final Source source = Okio.source(bis)) {
            sink.writeAll(source);
          }
        }

        @Override
        public MediaType contentType() {
          return OkHttpClientImpl.parseMediaType(contentType);
        }

        @Override
        public long contentLength() throws IOException {
          return length;
        }
      });
      return this;
    }

    @Override
    public Builder header(String k, String v) {
      builder.addHeader(k, v);
      return this;
    }

    @Override
    public Builder setHeader(String k, String v) {
      builder.header(k, v);
      return this;
    }

    @Override
    public Builder uri(URI uri) {
      try {
        builder.url(uri.toURL());
      } catch (MalformedURLException e) {
        throw new IllegalArgumentException(uri.toString(), e);
      }
      return this;
    }

    @Override
    public Builder expectContinue() {
      builder.header("Expect", "100-continue");
      return this;
    }

  }

  private Request request;

  public OkHttpRequestImpl(Request request) {
    this.request = request;
  }

  @Override
  public URI uri() {
    return request.url().uri();
  }

  @Override
  public String method() {
    return request.method();
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public List<String> headers(String key) {
    return request.headers(key);
  }

  @Override
  public Map<String, List<String>> headers() {
    return request.headers().toMultimap();
  }

  @Override
  public String bodyString() {
    if (request.body() == null) {
      return null;
    }
    Buffer buffer = new Buffer();
    try {
      request.body().writeTo(buffer);
    } catch (IOException e) {
      return null;
    }
    return buffer.readUtf8();
  }

}
