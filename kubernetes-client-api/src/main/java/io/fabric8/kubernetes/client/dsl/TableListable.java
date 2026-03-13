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
import io.fabric8.kubernetes.api.model.Table;

/**
 * Provides operations to list resources as a server-rendered Table, returning column
 * definitions and pre-formatted cell values. This is the format used by {@code kubectl get}.
 */
public interface TableListable {

  /**
   * List resources as a Table containing server-defined column definitions and row data.
   * Uses {@code Accept: application/json;as=Table;v=v1;g=meta.k8s.io}.
   *
   * @return a {@link Table} with a row per resource
   */
  Table listAsTable();

  /**
   * List resources as a Table with the given options.
   * Uses {@code Accept: application/json;as=Table;v=v1;g=meta.k8s.io}.
   *
   * @param options list options (label selectors, field selectors, pagination, etc.)
   * @return a {@link Table} with a row per resource
   */
  Table listAsTable(ListOptions options);

}