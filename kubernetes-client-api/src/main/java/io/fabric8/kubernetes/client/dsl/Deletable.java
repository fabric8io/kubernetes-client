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

import io.fabric8.kubernetes.api.model.StatusDetails;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface Deletable extends Timeoutable {

  /**
   * Deletes the resources at this context and returns the {@link StatusDetails} of resources marked for deletion
   * as determined by the api server response(s).
   * <p>
   * It is not guaranteed that the returned list will contain all values marked for deletion
   * - see <a href="https://github.com/fabric8io/kubernetes-client/pull/3058">Issue #3058</a>
   *
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if an error occurs.
   */
  List<StatusDetails> delete();

  /**
   * Perform the delete operation as blocking, waiting for finalizers, for up to the given timeout
   */
  @Override
  Deletable withTimeout(long timeout, TimeUnit unit);

  /**
   * Perform the delete operation as blocking, waiting for finalizers, for up to the given timeout
   */
  @Override
  Deletable withTimeoutInMillis(long timeoutInMillis);

}
