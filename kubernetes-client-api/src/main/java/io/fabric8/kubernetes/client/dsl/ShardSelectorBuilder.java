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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Builds a {@link ShardSelector} out of {@link ShardRange}s, each of which is added as a further
 * {@code ||} (logical OR) alternative:
 *
 * <pre>{@code
 * ShardSelector selector = new ShardSelectorBuilder()
 *     .addShard(0, 4)
 *     .addShard(2, 4)
 *     .build();
 * }</pre>
 *
 * @see ShardSelector
 */
public class ShardSelectorBuilder {

  private final List<ShardRange> ranges = new ArrayList<>();

  public ShardSelectorBuilder() {
  }

  /**
   * Starts from the ranges of an existing selector.
   */
  public ShardSelectorBuilder(ShardSelector selector) {
    if (selector != null) {
      this.ranges.addAll(selector.getRanges());
    }
  }

  public ShardSelectorBuilder addRange(ShardRange range) {
    if (range == null) {
      throw new IllegalArgumentException("A shard selector must not contain a null shard range");
    }
    this.ranges.add(range);
    return this;
  }

  /**
   * @param start the inclusive lower bound, within
   *        <code>[{@link ShardRange#MIN_HASH}, {@link ShardRange#MAX_HASH})</code>
   * @param end the exclusive upper bound, greater than {@code start} and at most {@link ShardRange#MAX_HASH}
   */
  public ShardSelectorBuilder addRange(ShardField field, BigInteger start, BigInteger end) {
    return addRange(ShardRange.of(field, start, end));
  }

  /**
   * @param hexStart the inclusive lower bound as a hexadecimal value, with or without the {@code 0x} prefix
   * @param hexEnd the exclusive upper bound as a hexadecimal value, with or without the {@code 0x} prefix
   */
  public ShardSelectorBuilder addRange(ShardField field, String hexStart, String hexEnd) {
    return addRange(ShardRange.of(field, hexStart, hexEnd));
  }

  /**
   * @param fieldPath the CEL field path to hash, e.g. {@code object.metadata.uid}
   * @param hexStart the inclusive lower bound as a hexadecimal value, with or without the {@code 0x} prefix
   * @param hexEnd the exclusive upper bound as a hexadecimal value, with or without the {@code 0x} prefix
   */
  public ShardSelectorBuilder addRange(String fieldPath, String hexStart, String hexEnd) {
    return addRange(ShardRange.of(fieldPath, hexStart, hexEnd));
  }

  /**
   * Adds the {@code shard}-th slice of an even {@code totalShards}-way split of the {@link ShardField#UID}
   * hash space.
   *
   * @param shard the zero based index of the shard, lower than {@code totalShards}
   * @param totalShards the number of shards the hash space is split into
   */
  public ShardSelectorBuilder addShard(int shard, int totalShards) {
    return addRange(ShardRange.ofShard(shard, totalShards));
  }

  /**
   * Adds the {@code shard}-th slice of an even {@code totalShards}-way split of the {@code field} hash space.
   *
   * @param shard the zero based index of the shard, lower than {@code totalShards}
   * @param totalShards the number of shards the hash space is split into
   */
  public ShardSelectorBuilder addShard(ShardField field, int shard, int totalShards) {
    return addRange(ShardRange.ofShard(field, shard, totalShards));
  }

  /**
   * @return the selector, which requires at least one range to have been added
   */
  public ShardSelector build() {
    return new ShardSelector(ranges);
  }
}
