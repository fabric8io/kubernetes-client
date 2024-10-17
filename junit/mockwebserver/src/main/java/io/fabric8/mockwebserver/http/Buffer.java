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

  /**
   * Returns the bytes in this source as a byte array.
   *
   * @return the bytes in this source as a byte array.
   */
  public final byte[] getBytes() {
    return byteStream.toByteArray();
  }

  /**
   * Returns the number of bytes in this buffer.
   *
   * @return the number of bytes in this buffer.
   */
  public final long size() {
    return byteStream.size();
  }

  /**
   * Removes all bytes from this and returns them as a byte array.
   *
   * @return the byte array containing the bytes in this buffer.
   */
  public final byte[] readByteArray() {
    final byte[] bytes = getBytes();
    byteStream.reset();
    return bytes;
  }

  /**
   * Removes all bytes from this, decodes them as {@code charset}, and returns the string.
   *
   * @param charset the charset to use to decode the bytes.
   * @return the string containing the bytes in this buffer.
   */
  public final String readString(Charset charset) {
    return new String(readByteArray(), charset);
  }

  /**
   * Removes all bytes from this, decodes them as UTF-8, and returns the string. Returns the empty
   * string if this source is empty. <pre>{@code
   *
   *   Buffer buffer = new Buffer()
   *       .writeUtf8("Uh uh uh!")
   *       .writeByte(' ')
   *       .writeUtf8("You didn't say the magic word!");
   *
   *   assertEquals("Uh uh uh! You didn't say the magic word!", buffer.readUtf8());
   *   assertEquals(0, buffer.size());
   *
   *   assertEquals("", buffer.readUtf8());
   *   assertEquals(0, buffer.size());
   * }</pre>
   */
  public final String readUtf8() {
    return readString(StandardCharsets.UTF_8);
  }

  /**
   * Like {@link java.io.OutputStream#write(byte[])}, this writes a complete byte array to
   * this sink.
   *
   * @param bytes the bytes to write.
   */
  public final Buffer write(byte[] bytes) {
    return write(bytes, 0, bytes.length);
  }

  /**
   * Like {@link java.io.OutputStream#write(byte[], int, int)}, this writes {@code byteCount}
   * bytes of {@code source}, starting at {@code offset}.
   *
   * @param bytes the bytes to write.
   * @param off the index of the first byte to write.
   * @param len the number of bytes to write.
   */
  public Buffer write(byte[] bytes, int off, int len) {
    byteStream.write(bytes, off, len);
    return this;
  }

  /**
   * Encodes {@code string} in {@code charset} and writes it to this buffer.
   *
   * @param string the string to write.
   * @param charset the charset to use to encode the string.
   */
  public final Buffer writeString(String string, Charset charset) {
    return write(string.getBytes(charset));
  }

  /**
   * Encodes {@code string} in UTF-8 and writes it to this buffer. <pre>{@code
   *
   *   Buffer buffer = new Buffer();
   *   buffer.writeUtf8("Uh uh uh!");
   *   buffer.writeByte(' ');
   *   buffer.writeUtf8("You didn't say the magic word!");
   *
   *   assertEquals("Uh uh uh! You didn't say the magic word!", buffer.readUtf8());
   * }</pre>
   *
   * @param string the string to write.
   */
  public final Buffer writeUtf8(String string) {
    return writeString(string, StandardCharsets.UTF_8);
  }

  /**
   * Returns an input stream that reads from bytes cloned from this buffer.
   *
   * @return an input stream that reads from bytes cloned from this buffer.
   */
  public final InputStream inputStream() {
    return new ByteArrayInputStream(getBytes());
  }

  /**
   * No operation is performed, added for compatibility.
   */
  public final void flush() {
    // NO-OP
  }

}
