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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A typed representation of the {@code shardSelector} list option, so that the CEL expression sent to the
 * API server does not have to be assembled by hand. It is one or more {@link ShardRange}s combined with
 * {@code ||} (logical OR):
 *
 * <pre>{@code
 * shardRange(object.metadata.uid, '0x0000000000000000', '0x4000000000000000') ||
 *     shardRange(object.metadata.uid, '0x8000000000000000', '0xc000000000000000')
 * }</pre>
 *
 * which is shards 0 and 2 of an even four way split, and can be expressed as:
 *
 * <pre>{@code
 * ShardSelector selector = new ShardSelectorBuilder()
 *     .addShard(0, 4)
 *     .addShard(2, 4)
 *     .build();
 *
 * client.configMaps().withShardSelector(selector).list();
 * }</pre>
 *
 * Instances are immutable. This feature is in alpha version, introduced in Kubernetes version 1.36, and must
 * be enabled with the {@code ShardedListAndWatch} feature gate on your API server.
 *
 * @see ShardRange
 * @see Filterable#withShardSelector(ShardSelector)
 */
public class ShardSelector {

  private static final String OR = " || ";

  private final List<ShardRange> ranges;

  /**
   * @param ranges the ranges to OR together, at least one
   */
  public ShardSelector(List<ShardRange> ranges) {
    if (ranges == null || ranges.isEmpty()) {
      throw new IllegalArgumentException("A shard selector requires at least one shard range");
    }
    if (ranges.contains(null)) {
      throw new IllegalArgumentException("A shard selector must not contain a null shard range");
    }
    this.ranges = Collections.unmodifiableList(new ArrayList<>(ranges));
  }

  public static ShardSelectorBuilder builder() {
    return new ShardSelectorBuilder();
  }

  public static ShardSelector of(ShardRange... ranges) {
    return new ShardSelector(ranges == null ? null : Arrays.asList(ranges));
  }

  /**
   * A selector matching the {@code shard}-th slice of an even {@code totalShards}-way split of the
   * {@link ShardField#UID} hash space.
   *
   * @param shard the zero based index of the shard, lower than {@code totalShards}
   * @param totalShards the number of shards the hash space is split into
   */
  public static ShardSelector ofShard(int shard, int totalShards) {
    return of(ShardRange.ofShard(shard, totalShards));
  }

  /**
   * A selector matching the {@code shard}-th slice of an even {@code totalShards}-way split of the
   * {@code field} hash space.
   *
   * @param shard the zero based index of the shard, lower than {@code totalShards}
   * @param totalShards the number of shards the hash space is split into
   */
  public static ShardSelector ofShard(ShardField field, int shard, int totalShards) {
    return of(ShardRange.ofShard(field, shard, totalShards));
  }

  /**
   * @return the ranges of this selector, as an unmodifiable list
   */
  public List<ShardRange> getRanges() {
    return ranges;
  }

  /**
   * @return this selector as the CEL expression to send as the {@code shardSelector} query parameter
   */
  public String toExpression() {
    return ranges.stream().map(ShardRange::toExpression).collect(Collectors.joining(OR));
  }

  @Override
  public String toString() {
    return toExpression();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return ranges.equals(((ShardSelector) o).ranges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ranges);
  }
}
