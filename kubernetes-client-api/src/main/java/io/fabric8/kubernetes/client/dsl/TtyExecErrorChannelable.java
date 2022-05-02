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

public interface TtyExecErrorChannelable extends
    TtyExecable {

  /**
   * @deprecated use {@link ExecListener#onExit(int, io.fabric8.kubernetes.api.model.Status)}
   *             or {@link ExecWatch#exitCode()}
   */
  @Deprecated
  TtyExecable writingErrorChannel(OutputStream in);

  /**
   * Will provide an {@link InputStream} via {@link ExecWatch#getErrorChannel()}
   * <p>
   * WARNING: the resulting stream must be fully read or closed for other events to be processed properly
   * 
   * @deprecated use {@link ExecListener#onExit(int, io.fabric8.kubernetes.api.model.Status)}
   *             or {@link ExecWatch#exitCode()}
   */
  @Deprecated
  TtyExecable redirectingErrorChannel();
}
