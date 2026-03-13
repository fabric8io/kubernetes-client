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

import io.fabric8.kubernetes.api.model.Table;

/**
 * Provides an operation to get a single resource as a server-rendered Table,
 * returning column definitions and cell values instead of the full resource structure.
 */
public interface TableGettable {

  /**
   * Get a resource as a Table containing server-defined column definitions and row data.
   * Uses {@code Accept: application/json;as=Table;v=v1;g=meta.k8s.io}.
   *
   * @return a {@link Table} with one row for the resource, or null if not found
   */
  Table getAsTable();

}