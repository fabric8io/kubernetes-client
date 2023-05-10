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

package io.fabric8.kubernetes.client;

import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.CompletionStage;

public interface StreamConsumer {

  public static StreamConsumer newStreamConsumer(OutputStream os) {
    if (os == null) {
      return null;
    }
    checkForPiped(os);
    return newBlockingStreamConsumer(Channels.newChannel(os));
  }

  public static StreamConsumer newBlockingStreamConsumer(WritableByteChannel channel) {
    if (channel == null) {
      return null;
    }
    return buffer -> {
      int remaining = buffer.remaining();
      if (channel.write(buffer) != remaining) {
        throw new KubernetesClientException("Unsucessful blocking write");
      }
      return null;
    };
  }

  public static void checkForPiped(Object object) {
    if (object instanceof PipedOutputStream || object instanceof PipedInputStream) {
      throw new KubernetesClientException("Piped streams should not be used");
    }
  }

  /**
   * A callback for consuming a stream as a series of {@link ByteBuffer}s
   *
   * @param buffer
   * @return a {@link CompletionStage} that is completed when the buffer has been fully consumed,
   *         or null if it was already consumed
   * @throws Exception
   */
  CompletionStage<?> consume(ByteBuffer buffer) throws Exception;

}
