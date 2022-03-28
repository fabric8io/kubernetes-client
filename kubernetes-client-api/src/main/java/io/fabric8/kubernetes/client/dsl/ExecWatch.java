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
package io.fabric8.kubernetes.client.dsl;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CompletableFuture;

public interface ExecWatch extends Closeable {

  OutputStream getInput();

  InputStream getOutput();

  InputStream getError();

  InputStream getErrorChannel();

  /**
   * Close the Watch.
   */
  @Override
  void close();

  void resize(int cols, int rows);

  /**
   * Get a future that will be completed with the exit code.
   * <p>
   * Will be -1 if the exit code can't be determined.
   * <p>
   * Can be used as an alternative to {@link ExecListener#onFailure(Throwable, io.fabric8.kubernetes.client.dsl.ExecListener.Response)}
   * and {@link ExecListener#onExit(int, io.fabric8.kubernetes.api.model.Status)} methods.
   *
   * @return the exit code future
   */
  CompletableFuture<Integer> exitCode();

}
