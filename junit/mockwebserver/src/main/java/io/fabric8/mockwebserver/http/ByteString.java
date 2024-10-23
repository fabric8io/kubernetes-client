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

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Compatibility layer for OkHttp.
 *
 * @deprecated used as parameter in {@link WebSocketListener} and {@link WebSocket}.
 *             Alternative methods provided in those classes should be used instead.
 */
public class ByteString {

  private final byte[] data;

  private ByteString(byte[] data) {
    this.data = data;
  }

  /**
   * Returns a new {@code ByteString} containing a clone of the bytes of {@code data}.
   */
  public static ByteString of(byte... data) {
    Objects.requireNonNull(data, "data === null");
    return new ByteString(data.clone());
  }

  /**
   * Returns a new {@code ByteString} containing the {@code UTF-8} bytes of {@code s}.
   */
  public static ByteString encodeUtf8(String s) {
    Objects.requireNonNull(s, "s === null");
    return new ByteString(s.getBytes(StandardCharsets.UTF_8));
  }

  /**
   * Constructs a new {@code String} by decoding the bytes as {@code UTF-8}.
   */
  public final String utf8() {
    return new String(data, StandardCharsets.UTF_8);
  }

  /**
   * Returns a byte array containing a copy of the bytes in this {@code ByteString}.
   */
  public final byte[] toByteArray() {
    return data.clone();
  }
}
