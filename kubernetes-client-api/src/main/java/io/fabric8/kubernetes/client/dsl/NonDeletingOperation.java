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

import java.util.function.Function;

public interface NonDeletingOperation<T> extends
    CreateOrReplaceable<T>,
    EditReplacePatchable<T>,
    Replaceable<T>, ItemReplacable<T>,
    ItemWritableOperation<T>,
    ServerSideApplicable<T> {

  /**
   * Alternative to {@link CreateOrReplaceable#createOrReplace()}.
   * <p>
   * Will attempt a create, and if that fails will perform the conflictAction.
   * <p>
   * Most commonly the conflictAction will be NonDeletingOperation::update or NonDeletingOperation::patch,
   * but you are free to provide whatever Function suits your needs.
   *
   * @param conflictAction to be performed it the create fails with a conflict
   * @return
   */
  T createOr(Function<NonDeletingOperation<T>, T> conflictAction);

  /**
   * Removes the resource version from the current item. If the operation context was
   * created by name, and without an item, this will fetch the item from the api server first.
   *
   * @return NonDeletingOperation that may act on the unlocked item
   */
  NonDeletingOperation<T> unlock();
}
