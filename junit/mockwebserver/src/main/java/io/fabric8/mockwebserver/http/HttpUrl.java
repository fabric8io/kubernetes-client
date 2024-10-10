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

import io.netty.handler.codec.http.QueryStringDecoder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * Compatibility layer for OkHttp.
 */
public class HttpUrl {

  private final URI uri;

  public HttpUrl(URI uri) {
    this.uri = uri;
  }

  public final URI uri() {
    return uri;
  }

  public final String encodedPath() {
    return uri().getRawPath();
  }

  public final String queryParameter(String name) {
    final List<String> values = new QueryStringDecoder(uri()).parameters().get(name);
    if (values == null || values.isEmpty()) {
      return null;
    }
    return values.iterator().next();
  }

  @Override
  public final String toString() {
    return uri().toString();
  }

  public static HttpUrl fromUrl(URL url) {
    try {
      return new HttpUrl(url.toURI());
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException("Invalid URL: " + url, e);
    }
  }

  public static HttpUrl parse(String url) {
    try {
      return fromUrl(new URL(url));
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Invalid URL: " + url, e);
    }
  }

}
