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

public interface DryRunable<T> {
  /**
   * Indicates that modifications should not be persisted. All dry run stages will be processed. the request is still
   * processed as typical request: the fields are defaulted, the object is validated, it goes through the validation
   * admission chain, and through the mutating admission chain, and then the final object is returned to the user as
   * it normally would, without being persisted.
   *
   * @return write operations which are applicable for dry run
   */
  T dryRun();

  /**
   * Indicates whether modifications should not be persisted or not. If enabled, All dry run stages will be processed.
   * the request is still processed as typical request: the fields are defaulted, the object is validated, it goes through
   * the validation admission chain, and through the mutating admission chain, and then the final object is returned
   * to the user as it normally would, without being persisted.
   *
   * @param isDryRun whether dry run is enabled or disabled
   * @return write operations which are applicable for dry run
   */
  T dryRun(boolean isDryRun);
}
