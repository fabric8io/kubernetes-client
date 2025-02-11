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
package io.fabric8.kubernetes.client.dsl;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CompletionStage;

public interface LogWatch extends Closeable {

  /**
   * Returns the {@link InputStream} for the log watch.
   * If an {@link OutputStream} was passed in, will be null
   * 
   * @return the {@link InputStream} which must be read completely or closed
   */
  InputStream getOutput();

  /**
   * Returns a {@link CompletionStage} released when the log stream is closed.
   * If the stream is closed due to an exception (cf onFailure),
   * this exception will be passed as parameter, null otherwise
   *
   * @return a {@link CompletionStage} released when the log stream is closed
   */
  CompletionStage<Throwable> onClose();

  /**
   * Close the Watch.
   */
  @Override
  void close();
}
