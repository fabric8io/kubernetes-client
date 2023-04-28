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

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;

public class BufferUtil {

  private BufferUtil() {
    // utils class
  }

  /**
   * Convert a ByteBuffer to a byte array.
   *
   * @param buffer The buffer to convert in flush mode. The buffer is not altered.
   * @return An array of bytes duplicated from the buffer.
   */
  public static byte[] toArray(ByteBuffer buffer) {
    if (buffer.hasArray()) {
      byte[] array = buffer.array();
      int from = buffer.arrayOffset() + buffer.position();
      return Arrays.copyOfRange(array, from, from + buffer.remaining());
    } else {
      byte[] to = new byte[buffer.remaining()];
      buffer.slice().get(to);
      return to;
    }
  }

  public static byte[] toArray(Collection<ByteBuffer> buffers) {
    final byte[] ret = new byte[buffers.stream().mapToInt(ByteBuffer::remaining).sum()];
    int offset = 0;
    for (ByteBuffer buffer : buffers) {
      buffer.slice().get(ret, offset, buffer.remaining());
      offset += buffer.remaining();
    }
    return ret;
  }

  /**
   * Copy of a ByteBuffer into a heap buffer
   *
   * @param buffer The buffer to copy.
   * @return A copy of the provided buffer.
   */
  public static ByteBuffer copy(ByteBuffer buffer) {
    if (buffer == null) {
      return null;
    }
    final int position = buffer.position();
    ByteBuffer clone = ByteBuffer.allocate(buffer.remaining());
    clone.put(buffer);
    clone.flip();
    buffer.position(position);
    return clone;
  }

  /**
   * Very rudimentary method to check if the provided ByteBuffer contains text.
   * 
   * @return true if the buffer contains text, false otherwise.
   */
  public static boolean isPlainText(ByteBuffer originalBuffer) {
    if (originalBuffer == null) {
      return false;
    }
    final ByteBuffer buffer = copy(originalBuffer);
    final CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
    try {
      decoder.decode(buffer);
      return true;
    } catch (CharacterCodingException ex) {
      return false;
    }
  }

}
