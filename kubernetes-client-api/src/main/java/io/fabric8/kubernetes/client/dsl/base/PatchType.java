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

/**
 * Enum for different Patch types supported by Patch
 */
public enum PatchType {
  JSON("application/json-patch+json"),
  JSON_MERGE("application/merge-patch+json"),
  STRATEGIC_MERGE("application/strategic-merge-patch+json"),
  SERVER_SIDE_APPLY("application/apply-patch+yaml");

  private final String contentType;

  PatchType(String mediaType) {
    this.contentType = mediaType;
  }

  public String getContentType() {
    return this.contentType;
  }
}
