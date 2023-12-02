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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Compatibility layer for OkHttp.
 */
public class Buffer {

  private final ByteArrayOutputStream byteStream;

  public Buffer() {
    this(new byte[0]);
  }

  public Buffer(byte[] bytes) {
    byteStream = new ByteArrayOutputStream();
    if (bytes != null) {
      byteStream.write(bytes, 0, bytes.length);
    }
  }

  public final byte[] readByteArray() {
    return getBytes();
  }

  public final byte[] getBytes() {
    return byteStream.toByteArray();
  }

  public final long size() {
    return byteStream.size();
  }

  public final String readUtf8() {
    return readString(StandardCharsets.UTF_8);
  }

  public final String readString(Charset charset) {
    return new String(getBytes(), charset);
  }

  public final Buffer write(byte[] bytes) {
    return write(bytes, 0, bytes.length);
  }

  public Buffer write(byte[] bytes, int off, int len) {
    byteStream.write(bytes, off, len);
    return this;
  }

  public final Buffer writeString(String string, Charset charset) {
    return write(string.getBytes(charset));
  }

  public final Buffer writeUtf8(String string) {
    return writeString(string, StandardCharsets.UTF_8);
  }

  public final void flush() {
    // NO-OP
  }

  public final InputStream inputStream() {
    return new ByteArrayInputStream(getBytes());
  }

}
