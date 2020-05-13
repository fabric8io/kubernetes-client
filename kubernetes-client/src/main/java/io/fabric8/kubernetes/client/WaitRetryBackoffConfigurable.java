package io.fabric8.kubernetes.client;

import java.util.concurrent.TimeUnit;

public interface WaitRetryBackoffConfigurable<T> {

  /**
   * Configure the backoff strategy to use when waiting for conditions, in case the watcher encounters a retryable error.
   * @param initialBackoff the value for the initial backoff on first error
   * @param backoffUnit the TimeUnit for the initial backoff value
   * @param backoffMultiplier what to multiply the backoff by on each subsequent error
   * @return
   */
  T withWaitRetryBackoff(long initialBackoff, TimeUnit backoffUnit, double backoffMultiplier);
}
