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

import io.fabric8.kubernetes.client.utils.InputStreamPumper;

import java.io.InputStream;
import java.io.OutputStream;

public interface ContainerResource
    extends TtyExecOutputErrorable,
    TimestampBytesLimitTerminateTimeTailPrettyLoggable {

  /**
   * Will send the given input stream via a polling mechanism.
   *
   * @deprecated use redirectingInput and the resulting {@link ExecWatch#getOutput()} with
   *             InputStream#transferTo(java.io.OutputStream) on JDK 9+
   *             or
   *             {@link InputStreamPumper#transferTo(InputStream, io.fabric8.kubernetes.client.utils.InputStreamPumper.Writable)}
   * @param in the {@link InputStream}
   */
  @Deprecated
  TtyExecOutputErrorable readingInput(InputStream in);

  /**
   * Will provide an {@link OutputStream} via {@link ExecWatch#getInput()} with the
   * default buffer size.
   */
  TtyExecOutputErrorable redirectingInput();

  /**
   * Will provide an {@link OutputStream} via {@link ExecWatch#getInput()} with the
   * given buffer size.
   *
   * @param bufferSize if null will use the default
   */
  TtyExecOutputErrorable redirectingInput(Integer bufferSize);

  CopyOrReadable file(String path);

  CopyOrReadable dir(String path);

  /**
   * How long to wait for the pod to be ready before performing an operation, such as
   * getting the logs, exec, attach, copy, etc.
   *
   * @param timeout in milliseconds
   */
  @Override
  ContainerResource withReadyWaitTimeout(Integer timeout);
}
