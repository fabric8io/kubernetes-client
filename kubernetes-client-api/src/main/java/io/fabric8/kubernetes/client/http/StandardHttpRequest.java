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

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Standard representation of a request. HttpClient implementations need to handle the special fields,
 * such as expectContinue, or content-type
 */
public class StandardHttpRequest extends StandardHttpHeaders implements HttpRequest {

  public static final String METHOD_POST = "POST";

  public interface BodyContent {

  }

  public static class StringBodyContent implements BodyContent {

    private String content;

    public StringBodyContent(String content) {
      this.content = content;
    }

    public String getContent() {
      return content;
    }

  }

  public static class ByteArrayBodyContent implements BodyContent {

    private byte[] content;

    public ByteArrayBodyContent(byte[] bytes) {
      this.content = bytes;
    }

    public byte[] getContent() {
      return content;
    }

  }

  public static class InputStreamBodyContent implements BodyContent {
    private long length;
    private InputStream content;

    public InputStreamBodyContent(InputStream stream, long length) {
      this.length = length;
      this.content = stream;
    }

    public InputStream getContent() {
      return content;
    }

    public long getLength() {
      return length;
    }

  }

  private final UUID id;
  private final URI uri;
  private final String method;
  private final String contentType;
  private final String bodyString;
  private final BodyContent body;
  private final boolean expectContinue;

  /**
   * Constructor that provides the public information
   *
   * @param headers
   * @param uri
   * @param method
   * @param bodyString
   */
  public StandardHttpRequest(Map<String, List<String>> headers, URI uri, String method, String bodyString) {
    this(headers, uri, method, bodyString, null, false, null);
  }

  StandardHttpRequest(Map<String, List<String>> headers, URI uri, String method, String bodyString,
      BodyContent body, boolean expectContinue, String contentType) {
    super(headers);
    this.id = UUID.randomUUID();
    this.uri = uri;
    this.method = method;
    this.bodyString = bodyString;
    this.body = body;
    this.expectContinue = expectContinue;
    this.contentType = contentType;
  }

  @Override
  public UUID id() {
    return id;
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

  public BodyContent body() {
    return body;
  }

  public boolean isExpectContinue() {
    return expectContinue;
  }

  public String getContentType() {
    return contentType;
  }

  public Builder newBuilder() {
    return new Builder(this);
  }

  public static final class Builder extends AbstractBasicBuilder<Builder> implements HttpRequest.Builder {

    private String method = "GET";
    private BodyContent body;
    private String bodyAsString;
    private boolean expectContinue;
    private String contentType;

    public Builder() {
    }

    public Builder(StandardHttpRequest original) {
      super.uri(original.uri());
      super.setHeaders(original.headers());
      method = original.method;
      bodyAsString = original.bodyString;
      body = original.body;
      expectContinue = original.expectContinue;
      contentType = original.contentType;
    }

    @Override
    public StandardHttpRequest build() {
      return new StandardHttpRequest(
          getHeaders(), Objects.requireNonNull(getUri()), method, bodyAsString, body, expectContinue, contentType);
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
      method = METHOD_POST;
      this.contentType = contentType;
      body = new ByteArrayBodyContent(writeValueAsBytes);
      return this;
    }

    @Override
    public HttpRequest.Builder post(String contentType, InputStream stream, long length) {
      method = METHOD_POST;
      this.contentType = contentType;
      body = new InputStreamBodyContent(stream, length);
      return this;
    }

    @Override
    public HttpRequest.Builder method(String method, String contentType, String body) {
      this.method = method;
      this.contentType = contentType;
      this.bodyAsString = body;
      this.body = new StringBodyContent(body);
      return this;
    }

    @Override
    public HttpRequest.Builder expectContinue() {
      expectContinue = true;
      return this;
    }
  }
}
