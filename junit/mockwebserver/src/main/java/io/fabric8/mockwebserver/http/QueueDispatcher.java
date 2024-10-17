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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Compatibility layer for OkHttp.
 */
public class QueueDispatcher extends Dispatcher {

  private static final MockResponse DEAD_LETTER = new MockResponse().setResponseCode(503);
  private final BlockingQueue<MockResponse> responseQueue;

  private MockResponse failFastResponse;

  public QueueDispatcher() {
    this.responseQueue = new LinkedBlockingQueue<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MockResponse dispatch(RecordedRequest request) {
    if (failFastResponse != null && responseQueue.isEmpty()) {
      return failFastResponse;
    }
    final MockResponse ret;
    try {
      ret = responseQueue.take();
      if (ret == DEAD_LETTER) {
        // Re-add the dead letter to the queue (server is shutting down)
        responseQueue.add(DEAD_LETTER);
      }
      return ret;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IllegalStateException("Interrupted while waiting for response", e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void shutdown() {
    responseQueue.add(DEAD_LETTER);
  }

  public final void enqueueResponse(MockResponse response) {
    responseQueue.add(response);
  }

  public final QueueDispatcher setFailFastResponse(MockResponse response) {
    this.failFastResponse = response;
    return this;
  }
}
