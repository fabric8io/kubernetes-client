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
package io.fabric8.kubernetes.client.dsl.base;

import okhttp3.MediaType;

import static io.fabric8.kubernetes.client.dsl.base.OperationSupport.JSON_PATCH;
import static io.fabric8.kubernetes.client.dsl.base.OperationSupport.JSON_MERGE_PATCH;
import static io.fabric8.kubernetes.client.dsl.base.OperationSupport.STRATEGIC_MERGE_JSON_PATCH;

/**
 * Enum for different Patch types supported by Patch
 */
public enum PatchType {
  JSON(JSON_PATCH),
  JSON_MERGE(JSON_MERGE_PATCH),
  STRATEGIC_MERGE(STRATEGIC_MERGE_JSON_PATCH);

  private final MediaType mediaType;

  PatchType(MediaType mediaType) {
    this.mediaType = mediaType;
  }

  public MediaType getMediaType() {
    return this.mediaType;
  }
}
