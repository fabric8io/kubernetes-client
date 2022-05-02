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

  /**
   * Gets the {@link OutputStream} for stdIn if {@link ContainerResource#redirectingInput()} has been called.
   * <p>
   * Closing this stream does not immediately force sending. You will typically call {@link #close()} after
   * you are finished writing - the close message will not be sent until all pending messages have been sent.
   * 
   * @return the stdIn stream
   */
  OutputStream getInput();

  /**
   * Gets the {@link InputStream} for stdOut if {@link TtyExecOutputErrorable#redirectingOutput()} has been called.
   * 
   * @return the stdOut stream
   */
  InputStream getOutput();

  /**
   * Gets the {@link InputStream} for stdErr if {@link TtyExecErrorable#redirectingError()} has been called.
   * 
   * @return the stdErr stream
   */
  InputStream getError();

  /**
   * Gets the {@link InputStream} associated with channel 3, which
   * returns the final Status containing the exit code, which
   * could indicate abnormal termination.
   * <p>
   * See also {@link #exitCode()}
   * 
   * @return the channel 3 stream
   */
  InputStream getErrorChannel();

  /**
   * Gracefully close the Watch - the close message will not be sent until all pending messages have been sent.
   */
  @Override
  void close();

  void resize(int cols, int rows);

  /**
   * Get a future that will be completed with the exit code.
   * <p>
   * Will be -1 if the exit code can't be determined from the status, or null if close is received before the exit code.
   * <br>
   * See https://github.com/kubernetes/kubernetes/issues/89899 - which explains there's currently no way to indicate
   * end of input over a websocket, so you may not get an exit code when using stdIn.
   * <p>
   * Can be used as an alternative to
   * {@link ExecListener#onFailure(Throwable, io.fabric8.kubernetes.client.dsl.ExecListener.Response)}
   * and {@link ExecListener#onExit(int, io.fabric8.kubernetes.api.model.Status)} methods.
   *
   * @return the exit code future
   */
  CompletableFuture<Integer> exitCode();

}
