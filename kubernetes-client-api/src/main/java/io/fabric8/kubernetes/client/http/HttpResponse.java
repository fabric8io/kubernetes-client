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
import java.util.concurrent.CompletableFuture;

import static java.nio.charset.StandardCharsets.UTF_8;

public interface HttpResponse<T> extends HttpHeaders {

  default boolean isSuccessful() {
    return isSuccessful(code());
  }

  static boolean isSuccessful(int code) {
    return code >= 200 && code < 300;
  }

  /**
   * Returns the HTTP status code.
   *
   * @return the HTTP status code.
   */
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
   * @throws IOException in case there's an I/O problem
   */
  default String bodyString() throws IOException {
    final Object body = body();
    final SupportedResponses supportedResponse = SupportedResponses.from(body);
    if (supportedResponse == null) {
      return "";
    }
    return supportedResponse.asString(body);
  }

  /**
   * The original {@link HttpRequest} that initiated this response.
   *
   * @return the HTTP request.
   */
  HttpRequest request();

  Optional<HttpResponse<?>> previousResponse();

  enum SupportedResponses {
    TEXT(String.class, Object::toString, SendAsyncUtils::string),
    INPUT_STREAM(InputStream.class, body -> IOHelpers.readFully((InputStream) body, UTF_8), SendAsyncUtils::inputStream),
    READER(Reader.class, body -> IOHelpers.readFully((Reader) body), SendAsyncUtils::reader),
    BYTE_ARRAY(byte[].class, body -> new String((byte[]) body, UTF_8), SendAsyncUtils::bytes);

    private final Class<?> type;
    private final ToString toString;
    private final Async<?> async;

    <T> SupportedResponses(Class<T> type, ToString toString, Async<T> async) {
      this.type = type;
      this.toString = toString;
      this.async = async;
    }

    private String asString(Object body) throws IOException {
      return toString.toString(body);
    }

    <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, HttpClient client) {
      return ((Async<T>) async).sendAsync(request, client);
    }

    public static SupportedResponses from(Object object) {
      if (object == null) {
        return null;
      }
      return from(object.getClass());
    }

    public static SupportedResponses from(Class<?> type) {
      for (SupportedResponses sr : SupportedResponses.values()) {
        if (sr.type.isAssignableFrom(type)) {
          return sr;
        }
      }
      throw new IllegalArgumentException("Unsupported response type: " + type.getName());
    }

    @FunctionalInterface
    interface ToString {
      String toString(Object body) throws IOException;
    }

    @FunctionalInterface
    interface Async<T> {
      CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, HttpClient client);
    }
  }
}
