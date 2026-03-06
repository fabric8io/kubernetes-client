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

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.PartialObjectMetadataList;

/**
 * Provides operations to list resources with server-side content negotiation returning
 * only resource metadata (omitting spec and status), which significantly reduces
 * response sizes when only metadata is needed.
 */
public interface MetadataListable {

  /**
   * List resources returning only their metadata (no spec or status).
   * Uses {@code Accept: application/json;as=PartialObjectMetadataList;g=meta.k8s.io;v=v1}.
   *
   * @return a {@link PartialObjectMetadataList} containing only resource metadata
   */
  PartialObjectMetadataList listAsPartialObjectMetadata();

  /**
   * List resources returning only their metadata (no spec or status), with the given options.
   * Uses {@code Accept: application/json;as=PartialObjectMetadataList;g=meta.k8s.io;v=v1}.
   *
   * @param options list options (label selectors, field selectors, pagination, etc.)
   * @return a {@link PartialObjectMetadataList} containing only resource metadata
   */
  PartialObjectMetadataList listAsPartialObjectMetadata(ListOptions options);

}