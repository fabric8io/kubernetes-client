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

public interface TimeTailPrettyLoggable extends TailPrettyLoggable {

  /**
   * Only return logs after a specific date (RFC3339)
   *
   * @param timestamp timestamp as string
   * @return log operation with PodLogOptions configured
   */
  TailPrettyLoggable sinceTime(String timestamp);

  /**
   * Get logs after a duration of seconds:
   *
   * @param seconds number of seconds
   * @return log operation with PodLogOptions configured
   */
  TailPrettyLoggable sinceSeconds(int seconds);
}
