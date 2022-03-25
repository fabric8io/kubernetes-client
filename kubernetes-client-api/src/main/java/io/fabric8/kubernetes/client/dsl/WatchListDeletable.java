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

import io.fabric8.kubernetes.client.GracePeriodConfigurable;
import io.fabric8.kubernetes.client.PropagationPolicyConfigurable;
import io.fabric8.kubernetes.client.Watcher;

import java.util.stream.Stream;

public interface WatchListDeletable<T, L, R>
    extends Watchable<Watcher<T>>, Versionable<WatchAndWaitable<T>>, Listable<L>, Deletable,
    GracePeriodConfigurable<Deletable>,
    PropagationPolicyConfigurable<EditReplacePatchDeletable<T>>,
    StatusUpdatable<T>,
    Informable<T> {

  /**
   * Perform a list operation and return the items as a stream of {@link Resource}s
   *
   * @return the {@link Resource} steam
   */
  Stream<R> resources();

}
