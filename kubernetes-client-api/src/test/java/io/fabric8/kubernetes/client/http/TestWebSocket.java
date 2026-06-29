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
package io.fabric8.kubernetes.client.http;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Hand-written {@link WebSocket} fake intended to replace {@code Mockito.mock(WebSocket.class)} in
 * listener tests. It captures sent payloads (defensive copies), publishes the first
 * {@link #send(ByteBuffer)} and the first {@link #sendClose(int, String)} through
 * {@link CompletableFuture}s for race-free happens-before assertions, and supports scripted
 * per-{@link #request()} actions.
 * <p>
 * Each call to {@link #getSent()} and {@link #firstSent()} returns a fresh read-only view over
 * the captured bytes, so reads through one view never advance the position observed by another
 * caller.
 */
public final class TestWebSocket implements WebSocket {

  private final List<ByteBuffer> sent = new CopyOnWriteArrayList<>();
  private final CompletableFuture<ByteBuffer> firstSent = new CompletableFuture<>();
  private final CompletableFuture<CloseFrame> firstClose = new CompletableFuture<>();
  private final Deque<Runnable> onRequestActions = new ConcurrentLinkedDeque<>();
  private final AtomicInteger requestCount = new AtomicInteger();

  /**
   * Registers an action to run on the next un-handled {@link #request()} call. Actions run in FIFO
   * order, one per {@code request()}; once the queue is exhausted, subsequent {@code request()}
   * calls only increment the counter.
   */
  public TestWebSocket onRequest(Runnable action) {
    onRequestActions.addLast(Objects.requireNonNull(action, "action"));
    return this;
  }

  /**
   * Snapshot of all payloads sent so far, in send order. Each entry is a fresh read-only view
   * over the defensive copy taken at {@link #send(ByteBuffer)} time; reads through one view do
   * not affect the position observed by other callers.
   */
  public List<ByteBuffer> getSent() {
    return Collections.unmodifiableList(
        sent.stream().map(ByteBuffer::asReadOnlyBuffer).collect(Collectors.toList()));
  }

  /**
   * Completes with a fresh read-only view over the defensive copy of the first
   * {@link #send(ByteBuffer)} payload. A new view is produced for each call so reads do not leak
   * position state between callers.
   */
  public CompletableFuture<ByteBuffer> firstSent() {
    return firstSent.thenApply(ByteBuffer::asReadOnlyBuffer);
  }

  /**
   * Completes with the {@link CloseFrame} captured from the first {@link #sendClose(int, String)}
   * call.
   */
  public CompletableFuture<CloseFrame> firstClose() {
    return firstClose;
  }

  /**
   * Number of {@link #request()} invocations observed so far.
   */
  public int requestCount() {
    return requestCount.get();
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    final ByteBuffer copy = ByteBuffer.allocate(buffer.remaining());
    copy.put(buffer.duplicate());
    copy.flip();
    sent.add(copy);
    firstSent.complete(copy);
    return true;
  }

  @Override
  public boolean sendClose(int code, String reason) {
    firstClose.complete(new CloseFrame(code, reason));
    return true;
  }

  @Override
  public long queueSize() {
    return 0L;
  }

  @Override
  public void request() {
    requestCount.incrementAndGet();
    final Runnable action = onRequestActions.pollFirst();
    if (action != null) {
      action.run();
    }
  }

  /**
   * Immutable capture of a {@link #sendClose(int, String)} call.
   */
  public static final class CloseFrame {

    private final int code;
    private final String reason;

    public CloseFrame(int code, String reason) {
      this.code = code;
      this.reason = reason;
    }

    public int getCode() {
      return code;
    }

    public String getReason() {
      return reason;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof CloseFrame)) {
        return false;
      }
      final CloseFrame other = (CloseFrame) o;
      return code == other.code && Objects.equals(reason, other.reason);
    }

    @Override
    public int hashCode() {
      return Objects.hash(code, reason);
    }

    @Override
    public String toString() {
      return "CloseFrame{code=" + code + ", reason=" + reason + "}";
    }
  }
}
