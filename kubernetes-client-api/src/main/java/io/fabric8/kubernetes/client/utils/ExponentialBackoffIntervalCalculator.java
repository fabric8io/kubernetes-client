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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.RequestConfig;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ExponentialBackoffIntervalCalculator {

  //we were using the same default in multiple places, so it has been moved here for now
  private static final int MAX_RETRY_INTERVAL_EXPONENT = 5;

  public static final int UNLIMITED_RETRIES = -1;

  private final int initialInterval;
  // other calculators express this as max wait
  private final int maxRetryIntervalExponent;
  private final int maxRetries;
  final AtomicInteger currentReconnectAttempt = new AtomicInteger();

  public ExponentialBackoffIntervalCalculator(int initialInterval, int maxRetries) {
    this.initialInterval = initialInterval;
    this.maxRetries = maxRetries;
    this.maxRetryIntervalExponent = MAX_RETRY_INTERVAL_EXPONENT;
  }

  public long getInterval(int retryIndex) {
    int exponentOfTwo = retryIndex;
    if (exponentOfTwo > maxRetryIntervalExponent) {
      exponentOfTwo = maxRetryIntervalExponent;
    }
    return (long) initialInterval * (1 << exponentOfTwo);
  }

  public void resetReconnectAttempts() {
    currentReconnectAttempt.set(0);
  }

  public final long nextReconnectInterval() {
    int exponentOfTwo = currentReconnectAttempt.getAndIncrement();
    return getInterval(exponentOfTwo);
  }

  public int getCurrentReconnectAttempt() {
    return currentReconnectAttempt.get();
  }

  public boolean shouldRetry() {
    return maxRetries < 0 || currentReconnectAttempt.get() < maxRetries;
  }

  public static ExponentialBackoffIntervalCalculator from(RequestConfig requestConfig) {
    final int requestRetryBackoffInterval = Optional.ofNullable(requestConfig)
        .map(RequestConfig::getRequestRetryBackoffInterval)
        .orElse(Config.DEFAULT_REQUEST_RETRY_BACKOFFINTERVAL);
    final int requestRetryBackoffLimit = Optional.ofNullable(requestConfig)
        .map(RequestConfig::getRequestRetryBackoffLimit)
        .orElse(Config.DEFAULT_REQUEST_RETRY_BACKOFFLIMIT);
    return new ExponentialBackoffIntervalCalculator(requestRetryBackoffInterval, requestRetryBackoffLimit);
  }
}
