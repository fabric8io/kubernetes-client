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

public interface Execable {

  /**
   * Execute a command in a container
   *
   * @param input the command to run
   * @return container with stdin, stdout, stderr streams
   *         (if redirectingInput(), redirectingOutput(), redirectingError() were called respectively)
   */
  ExecWatch exec(String... input);

  /**
   * Attach to the main process of a container
   *
   * @return container with stdin, stdout, stderr streams
   *         (if redirectingInput(), redirectingOutput(), redirectingError() were called respectively)
   */
  ExecWatch attach();

  /**
   * How long shall we wait until a Pod is ready before attaching or execing
   *
   * @param timeout in milliseconds
   * @return {@link Loggable} for fetching logs
   */
  Execable withReadyWaitTimeout(Integer timeout);

}
