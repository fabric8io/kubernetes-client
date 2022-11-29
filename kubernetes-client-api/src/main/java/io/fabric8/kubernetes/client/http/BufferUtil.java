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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    final List<byte[]> arrays = buffers.stream().map(BufferUtil::toArray).collect(Collectors.toList());
    final byte[] ret = new byte[arrays.stream().mapToInt(a -> a.length).sum()];
    int offset = 0;
    for (byte[] array : arrays) {
      System.arraycopy(array, 0, ret, offset, array.length);
      offset += array.length;
    }
    return ret;
  }

  /**
   * Deep copy/clone of a ByteBuffer.
   *
   * @param buffer The buffer to copy.
   * @return A copy of the provided buffer.
   */
  public static ByteBuffer copy(ByteBuffer buffer) {
    if (buffer == null) {
      return null;
    }
    final int position = buffer.position();
    ByteBuffer clone = buffer.isDirect() ? ByteBuffer.allocateDirect(buffer.remaining())
        : ByteBuffer.allocate(buffer.remaining());
    clone.put(buffer);
    clone.flip();
    buffer.position(position);
    return clone;
  }
}
