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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.HttpRequest;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow.Subscriber;

import static io.fabric8.kubernetes.client.http.StandardHttpHeaders.CONTENT_TYPE;

class JdkHttpRequestImpl implements HttpRequest {

  public static class BuilderImpl implements Builder {

    private String bodyString;
    private java.net.http.HttpRequest.Builder builder;

    public BuilderImpl() {
      builder = java.net.http.HttpRequest.newBuilder();
    }

    public BuilderImpl(BuilderImpl builderImpl) {
      this.bodyString = builderImpl.bodyString;
      this.builder = builderImpl.builder.copy();
    }

    @Override
    public JdkHttpRequestImpl build() {
      return new JdkHttpRequestImpl(this, builder.build());
    }

    @Override
    public Builder uri(String uri) {
      return uri(URI.create(uri));
    }

    @Override
    public Builder url(URL url) {
      return uri(url.toString());
    }

    @Override
    public Builder uri(URI uri) {
      builder.uri(uri);
      return this;
    }

    @Override
    public Builder method(String method, String contentType, String body) {
      this.bodyString = body;
      this.builder.setHeader(CONTENT_TYPE, contentType).method(method, BodyPublishers.ofString(body));
      return this;
    }

    @Override
    public Builder post(String contentType, byte[] writeValueAsBytes) {
      this.bodyString = null;
      this.builder.setHeader(CONTENT_TYPE, contentType).POST(BodyPublishers.ofByteArray(writeValueAsBytes));
      return this;
    }

    @Override
    public Builder post(String contentType, InputStream stream, long length) {
      this.bodyString = null;
      BodyPublisher publisher = BodyPublishers.ofInputStream(() -> stream);
      this.builder.setHeader(CONTENT_TYPE, contentType)
          .POST(new BodyPublisher() {

            @Override
            public void subscribe(Subscriber<? super ByteBuffer> subscriber) {
              publisher.subscribe(subscriber);
            }

            @Override
            public long contentLength() {
              return length;
            }
          });
      return this;
    }

    @Override
    public Builder header(String k, String v) {
      builder.header(k, v);
      return this;
    }

    @Override
    public Builder setHeader(String k, String v) {
      builder.setHeader(k, v);
      return this;
    }

    public Builder timeout(Duration duration) {
      if (duration != null) {
        builder.timeout(duration);
      }
      return this;
    }

    @Override
    public Builder expectContinue() {
      builder.expectContinue(true);
      return this;
    }

  }

  private BuilderImpl builder;
  java.net.http.HttpRequest request;

  public JdkHttpRequestImpl(BuilderImpl builder, java.net.http.HttpRequest request) {
    this.builder = builder;
    this.request = request;
  }

  @Override
  public List<String> headers(String key) {
    return request.headers().allValues(key);
  }

  @Override
  public Map<String, List<String>> headers() {
    return request.headers().map();
  }

  @Override
  public URI uri() {
    return request.uri();
  }

  @Override
  public String method() {
    return request.method();
  }

  @Override
  public String bodyString() {
    if (this.builder == null) {
      return null; // TODO: could try to subscribe to the request body
    }
    return builder.bodyString;
  }

  BuilderImpl newBuilder() {
    return new BuilderImpl(builder);
  }

}
