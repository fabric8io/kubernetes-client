/*
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
package io.fabric8.crdv2.generator;

import io.fabric8.kubernetes.api.model.HasMetadata;

public interface CRDPostProcessor {

  /**
   * Processes the specified CRD (passed as {@link HasMetadata} to be able to handle multiple versions of the CRD spec) after
   * they are generated but before they are written out
   *
   * @param crd the CRD to process as a {@link HasMetadata}
   * @param crdSpecVersion the CRD specification version of the CRD to process (to be able to cast to the appropriate CRD class)
   * @return the modified CRD (though, typically, this would just be the CRD specified as input, modified in place)
   */
  default HasMetadata process(HasMetadata crd, String crdSpecVersion) {
    return crd;
  }
}
