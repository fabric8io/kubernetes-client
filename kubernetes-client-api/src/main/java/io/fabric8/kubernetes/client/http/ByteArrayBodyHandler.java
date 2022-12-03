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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static io.fabric8.kubernetes.client.http.BufferUtil.toArray;

public class ByteArrayBodyHandler implements AsyncBody.Consumer<List<ByteBuffer>> {

  private final List<ByteBuffer> buffers = Collections.synchronizedList(new LinkedList<>());
  private final CompletableFuture<byte[]> result = new CompletableFuture<>();

  @Override
  public void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {
    this.buffers.addAll(value);
    asyncBody.consume();
  }

  protected void onResponse(HttpResponse<AsyncBody> response) {
    AsyncBody asyncBody = response.body();
    asyncBody.done().whenComplete(this::onBodyDone);
    asyncBody.consume();
  }

  private void onBodyDone(Void v, Throwable t) {
    if (t != null) {
      result.completeExceptionally(t);
    } else {
      byte[] bytes = null;
      synchronized (buffers) {
        bytes = toArray(buffers);
      }
      result.complete(bytes);
    }
    buffers.clear();
  }

  public CompletableFuture<byte[]> getResult() {
    return result;
  }

}
