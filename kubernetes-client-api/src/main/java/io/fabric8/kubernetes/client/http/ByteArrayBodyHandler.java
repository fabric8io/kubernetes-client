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

import io.fabric8.kubernetes.client.http.HttpClient.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient.BodyConsumer;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ByteArrayBodyHandler implements BodyConsumer<List<ByteBuffer>> {

  private final LinkedList<ByteBuffer> buffers = new LinkedList<>();
  private final CompletableFuture<byte[]> result = new CompletableFuture<byte[]>();

  @Override
  public synchronized void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {
    this.buffers.addAll(value);
    asyncBody.consume();
  }

  protected void onResponse(HttpResponse<AsyncBody> response) {
    AsyncBody asyncBody = response.body();
    asyncBody.done().whenComplete(this::onBodyDone);
    asyncBody.consume();
  }

  private synchronized void onBodyDone(Void v, Throwable t) {
    if (t != null) {
      result.completeExceptionally(t);
    } else {
      int size = buffers.stream().map(ByteBuffer::remaining).collect(Collectors.summingInt(Integer::intValue)).intValue();
      byte[] res = new byte[size];
      int from = 0;
      for (ByteBuffer b : buffers) {
        int l = b.remaining();
        b.get(res, from, l);
        from += l;
      }
      result.complete(res);
    }
    buffers.clear();
  }

  public CompletableFuture<byte[]> getResult() {
    return result;
  }

}
