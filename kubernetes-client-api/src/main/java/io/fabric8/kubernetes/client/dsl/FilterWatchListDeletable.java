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

public interface FilterWatchListDeletable<T, L, R>
    extends Filterable<FilterWatchListDeletable<T, L, R>>, WatchListDeletable<T, L, R> {

  /**
   * Accumulate a filter on the context, when done {@link FilterNested#endFilter()} or and must be called
   * 
   * @return a {@link FilterNested}
   */
  FilterNested<FilterWatchListDeletable<T, L, R>> withNewFilter();

}
