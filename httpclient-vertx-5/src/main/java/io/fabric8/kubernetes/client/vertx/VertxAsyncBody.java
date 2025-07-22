package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.vertx.core.http.HttpClientResponse;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Vert.x 5 implementation of {@link AsyncBody} that bridges Vert.x streaming to Fabric8's async body interface.
 * 
 * <p>
 * Handles backpressure by starting in a paused state - consumption must be explicitly triggered
 * via {@link #consume()}. Converts Vert.x buffers to ByteBuffers for the Fabric8 consumer.
 * 
 * <p>
 * Must be consumed or cancelled to prevent resource leaks.
 */
final class VertxAsyncBody implements AsyncBody {
  /** The underlying Vert.x response for streaming control. */
  private final HttpClientResponse resp;

  /** Completion future tracking when streaming is finished or cancelled. */
  private final CompletableFuture<Void> done = new CompletableFuture<>();

  /**
   * Creates a new VertxAsyncBody bridging Vert.x streaming to Fabric8's AsyncBody interface.
   * Sets up handlers for data, end, and exception events. Response starts paused.
   * 
   * @param resp the Vert.x response to stream from
   * @param consumer the consumer to receive ByteBuffer data
   */
  VertxAsyncBody(final HttpClientResponse resp, final AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    this.resp = resp;

    resp.handler(buf -> {
      try {
        consumer.consume(List.of(ByteBuffer.wrap(buf.getBytes())), this);
      } catch (Exception e) {
        resp.request().reset();
        done.completeExceptionally(e);
      }
    }).endHandler(v -> done.complete(null))
        .exceptionHandler(done::completeExceptionally);
  }

  /**
   * Requests the next chunk of data from the Vert.x response.
   * Implements backpressure by requesting one buffer at a time.
   */
  @Override
  public void consume() {
    resp.fetch(1);
  }

  /**
   * Returns a future that completes when streaming is finished or fails.
   * 
   * @return completion future
   */
  @Override
  public CompletableFuture<Void> done() {
    return done;
  }

  /**
   * Cancels the async body by clearing handlers, resetting the connection,
   * and cancelling the completion future.
   */
  @Override
  public void cancel() {
    resp.handler(null);
    resp.endHandler(null);
    resp.request().reset();
    done.cancel(false);
  }
}
