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

import io.fabric8.kubernetes.client.KubernetesClientException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StandardHttpRequest extends StandardHttpHeaders implements HttpRequest {

  public static final String METHOD_POST = "POST";

  private final URI uri;
  private final String method;
  private final String bodyString;
  private final InputStream bodyStream;

  public StandardHttpRequest(Map<String, List<String>> headers, URI uri, String method, String bodyString,
      InputStream bodyStream) {
    super(headers);
    this.uri = uri;
    this.method = method;
    this.bodyString = bodyString;
    this.bodyStream = bodyStream;
  }

  @Override
  public URI uri() {
    return uri;
  }

  @Override
  public String method() {
    return method;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String bodyString() {
    return bodyString;
  }

  /**
   * Return the body as a string, but only if one of the byte[] or InputStream valued {@link HttpRequest.Builder}
   * methods were used otherwise null.
   *
   * @return the body as InputStream.
   */
  public InputStream bodyStream() {
    return bodyStream;
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static final class Builder extends AbstractBasicBuilder<Builder> implements HttpRequest.Builder {

    private String method = "GET";
    private InputStream bodyAsStream;
    private String bodyAsString;

    public Builder() {
    }

    public Builder(StandardHttpRequest original) {
      super.uri(original.uri());
      super.setHeaders(original.headers());
      method = original.method;
      bodyAsString = original.bodyString;
      bodyAsStream = original.bodyStream;
    }

    @Override
    public StandardHttpRequest build() {
      return new StandardHttpRequest(
          getHeaders(), Objects.requireNonNull(getUri()), method, bodyAsString, bodyAsStream);
    }

    @Override
    public HttpRequest.Builder uri(String uri) {
      return super.uri(URI.create(uri));
    }

    @Override
    public HttpRequest.Builder url(URL url) {
      try {
        return super.uri(url.toURI());
      } catch (URISyntaxException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    @Override
    public HttpRequest.Builder post(String contentType, byte[] writeValueAsBytes) {
      return post(contentType, new ByteArrayInputStream(writeValueAsBytes), writeValueAsBytes.length);
    }

    @Override
    public HttpRequest.Builder post(String contentType, InputStream stream, long length) {
      if (length >= 0) {
        header(CONTENT_LENGTH, Long.toString(length));
      }
      method = METHOD_POST;
      contentType(contentType);
      bodyAsStream = stream;
      return this;
    }

    @Override
    public HttpRequest.Builder method(String method, String contentType, String body) {
      this.method = method;
      contentType(contentType);
      this.bodyAsString = body;
      return this;
    }

    private void contentType(String contentType) {
      if (contentType != null) {
        setHeader(CONTENT_TYPE, contentType);
      }
    }

    @Override
    public HttpRequest.Builder expectContinue() {
      setHeader(EXPECT, EXPECT_CONTINUE);
      return this;
    }
  }
}
