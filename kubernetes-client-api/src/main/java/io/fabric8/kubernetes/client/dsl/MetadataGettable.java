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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.PartialObjectMetadata;

/**
 * Provides an operation to get a single resource with server-side content negotiation returning
 * only resource metadata (omitting spec and status).
 */
public interface MetadataGettable {

  /**
   * Get a resource returning only its metadata (no spec or status).
   * Uses {@code Accept: application/json;as=PartialObjectMetadata;g=meta.k8s.io;v=v1}.
   *
   * @return a {@link PartialObjectMetadata} containing only the resource metadata, or null if not found
   */
  PartialObjectMetadata getAsPartialObjectMetadata();

}