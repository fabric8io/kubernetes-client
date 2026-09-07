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

/**
 * The object field paths currently supported by the {@code shardSelector} list option.
 * <p>
 * Field paths use the CEL-style object-rooted syntax (e.g. {@code object.metadata.uid}), <em>not</em> the
 * {@code fieldSelector} format ({@code metadata.uid}). Should the API server support a path that is not
 * listed here, use the {@link String} based factories of {@link ShardRange} instead.
 *
 * @see ShardSelector
 */
public enum ShardField {

  UID("object.metadata.uid"),
  NAMESPACE("object.metadata.namespace");

  private final String path;

  ShardField(String path) {
    this.path = path;
  }

  /**
   * @return the CEL field path as it appears in the shard selector expression
   */
  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return path;
  }
}
