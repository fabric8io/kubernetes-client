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

/**
 * Handler for mock server requests.
 */
public abstract class Dispatcher {

  /**
   * Returns a response to satisfy {@code request}.
   * This method may block (for instance, to wait on a CountdownLatch).
   */
  public abstract MockResponse dispatch(RecordedRequest request);

  /**
   * Release any resources held by this dispatcher.
   * Any requests that are currently being dispatched should return immediately.
   * Responses returned after shutdown will not be transmitted: their socket connections have already been closed.
   */
  public void shutdown() {
  }
}
