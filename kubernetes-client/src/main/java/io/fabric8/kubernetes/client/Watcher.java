/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.Status;

public interface Watcher<T> {

  void eventReceived(Action action, T resource);

  /**
   * Run when the watcher finally closes.
   *
   * @param cause What caused the watcher to be closed. Null means normal close.
   */
  void onClose(KubernetesClientException cause);

  enum Action {
    ADDED, MODIFIED, DELETED, ERROR
  }

}
