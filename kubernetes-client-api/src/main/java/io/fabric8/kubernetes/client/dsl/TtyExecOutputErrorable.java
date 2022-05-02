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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;

public interface TtyExecOutputErrorable extends
    TtyExecErrorable {

  /**
   * Should only be called with a minimally blocking or non-blocking stream
   * <p>
   * In particular do no use a {@link PipedOutputStream} - use {@link #redirectingOutput()} instead
   */
  TtyExecErrorable writingOutput(OutputStream in);

  /**
   * Will provide an {@link InputStream} via {@link ExecWatch#getOutput()}
   * <p>
   * WARNING: the resulting stream must be fully read or closed for other events to be processed properly
   */
  TtyExecErrorable redirectingOutput();
}
