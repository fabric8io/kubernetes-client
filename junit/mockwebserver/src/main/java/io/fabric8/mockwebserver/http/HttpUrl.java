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

  /**
   * Returns this URL as a {@link URI java.net.URI}.
   */
  public final URI uri() {
    return uri;
  }

  /**
   * Returns the entire path of this URL encoded for use in HTTP resource resolution.
   * The returned path will start with {@code "/"}.
   *
   * <p>
   * <table>
   * <caption>Examples</caption>
   * <tr>
   * <th>URL</th>
   * <th>{@code encodedPath()}</th>
   * </tr>
   * <tr>
   * <td>{@code http://host/}</td>
   * <td>{@code "/"}</td>
   * </tr>
   * <tr>
   * <td>{@code http://host/a/b/c}</td>
   * <td>{@code "/a/b/c"}</td>
   * </tr>
   * <tr>
   * <td>{@code http://host/a/b%20c/d}</td>
   * <td>{@code "/a/b%20c/d"}</td>
   * </tr>
   * </table>
   */
  public final String encodedPath() {
    final String path = uri().getRawPath();
    if (path == null || path.isEmpty()) {
      return "/";
    }
    return uri().getRawPath();
  }

  /**
   * Returns the first query parameter named {@code name} decoded using UTF-8, or null if there is
   * no such query parameter.
   *
   * <p>
   * <table>
   * <caption>Examples</caption>
   * <tr>
   * <th>URL</th>
   * <th>{@code queryParameter("a")}</th>
   * </tr>
   * <tr>
   * <td>{@code http://host/}</td>
   * <td>null</td>
   * </tr>
   * <tr>
   * <td>{@code http://host/?}</td>
   * <td>null</td>
   * </tr>
   * <tr>
   * <td>{@code http://host/?a=apple&k=key+lime}</td>
   * <td>{@code "apple"}</td>
   * </tr>
   * <tr>
   * <td>{@code http://host/?a=apple&a=apricot}</td>
   * <td>{@code "apple"}</td>
   * </tr>
   * <tr>
   * <td>{@code http://host/?a=apple&b}</td>
   * <td>{@code "apple"}</td>
   * </tr>
   * </table>
   */
  public final String queryParameter(String name) {
    final List<String> values = new QueryStringDecoder(uri()).parameters().get(name);
    if (values == null || values.isEmpty()) {
      return null;
    }
    return values.iterator().next();
  }

  /**
   * Returns the content of this HttpUrl as a String.
   *
   * @return the content of this HttpUrl as a String.
   */
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
