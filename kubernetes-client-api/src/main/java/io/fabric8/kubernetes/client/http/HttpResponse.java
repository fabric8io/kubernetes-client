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

import io.fabric8.kubernetes.client.utils.IOHelpers;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;

public interface HttpResponse<T> extends HttpHeaders {

  default boolean isSuccessful() {
    return isSuccessful(code());
  }

  public static boolean isSuccessful(int code) {
    return code >= 200 && code < 300;
  }

  int code();

  default String message() {
    return HttpStatusMessage.getMessageForStatus(code());
  }

  /**
   * Get the body. If the body is {@link Closeable}, it should be closed by the caller.
   *
   * @return the body
   */
  T body();

  /**
   * Return the body as a String. Or an empty String if there was no body (possibly discarded).
   * <br>
   * If the body is an {@link InputStream}, it will be read as UTF-8.
   *
   * @return the body
   * @throws IOException
   */
  default String bodyString() throws IOException {
    Object body = body();
    if (body == null) {
      return "";
    }
    if (body instanceof String) {
      return (String) body;
    }
    if (body instanceof Reader) {
      return IOHelpers.readFully((Reader) body);
    }
    if (body instanceof byte[]) {
      return new String((byte[]) body, UTF_8);
    }
    return IOHelpers.readFully((InputStream) body, UTF_8);
  }

  HttpRequest request();

  public Optional<HttpResponse<?>> previousResponse();

}
