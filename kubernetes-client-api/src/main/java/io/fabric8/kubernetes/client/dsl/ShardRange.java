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

import io.fabric8.kubernetes.client.utils.Utils;

import java.math.BigInteger;
import java.util.Locale;
import java.util.Objects;

/**
 * A single {@code shardRange(<field>, '<hexStart>', '<hexEnd>')} term of a {@link ShardSelector}.
 * <p>
 * The bounds are positions in the 64-bit FNV-1a hash space of the selected field: the lower bound is
 * inclusive, the upper bound is exclusive, and the whole space is
 * <code>[{@link #MIN_HASH}, {@link #MAX_HASH})</code> - that is {@code [0x0, 0x10000000000000000)},
 * where the exclusive upper bound is 2<sup>64</sup> and therefore does not fit in a {@code long}.
 * <p>
 * Instances are immutable and validated on construction.
 *
 * @see ShardSelector
 */
public class ShardRange {

  /**
   * The inclusive start of the hash space, {@code 0x0}.
   */
  public static final BigInteger MIN_HASH = BigInteger.ZERO;

  /**
   * The exclusive end of the hash space, {@code 0x10000000000000000} (2<sup>64</sup>).
   */
  public static final BigInteger MAX_HASH = BigInteger.ONE.shiftLeft(64);

  private final String fieldPath;
  private final BigInteger start;
  private final BigInteger end;

  /**
   * @param fieldPath the CEL field path to hash, e.g. {@code object.metadata.uid}
   * @param start the inclusive lower bound, within <code>[{@link #MIN_HASH}, {@link #MAX_HASH})</code>
   * @param end the exclusive upper bound, greater than {@code start} and at most {@link #MAX_HASH}
   */
  public ShardRange(String fieldPath, BigInteger start, BigInteger end) {
    if (Utils.isNullOrEmpty(fieldPath)) {
      throw new IllegalArgumentException("A shard range requires a field path");
    }
    Objects.requireNonNull(start, "A shard range requires a start bound");
    Objects.requireNonNull(end, "A shard range requires an end bound");
    if (start.compareTo(MIN_HASH) < 0 || start.compareTo(MAX_HASH) >= 0) {
      throw new IllegalArgumentException(
          "The start bound must be within [" + toHex(MIN_HASH) + ", " + toHex(MAX_HASH) + "), but was " + toHex(start));
    }
    if (end.compareTo(MAX_HASH) > 0) {
      throw new IllegalArgumentException(
          "The end bound must not exceed " + toHex(MAX_HASH) + ", but was " + toHex(end));
    }
    if (start.compareTo(end) >= 0) {
      throw new IllegalArgumentException(
          "The start bound must be lower than the end bound, but was " + toHex(start) + " >= " + toHex(end));
    }
    this.fieldPath = fieldPath;
    this.start = start;
    this.end = end;
  }

  public static ShardRange of(ShardField field, BigInteger start, BigInteger end) {
    return new ShardRange(pathOf(field), start, end);
  }

  /**
   * @param hexStart the inclusive lower bound as a hexadecimal value, with or without the {@code 0x} prefix
   * @param hexEnd the exclusive upper bound as a hexadecimal value, with or without the {@code 0x} prefix
   */
  public static ShardRange of(ShardField field, String hexStart, String hexEnd) {
    return new ShardRange(pathOf(field), parseHash(hexStart), parseHash(hexEnd));
  }

  public static ShardRange of(String fieldPath, BigInteger start, BigInteger end) {
    return new ShardRange(fieldPath, start, end);
  }

  public static ShardRange of(String fieldPath, String hexStart, String hexEnd) {
    return new ShardRange(fieldPath, parseHash(hexStart), parseHash(hexEnd));
  }

  /**
   * The {@code shard}-th slice of an even {@code totalShards}-way split of the {@link ShardField#UID} hash space.
   *
   * @param shard the zero based index of the shard, lower than {@code totalShards}
   * @param totalShards the number of shards the hash space is split into
   */
  public static ShardRange ofShard(int shard, int totalShards) {
    return ofShard(ShardField.UID, shard, totalShards);
  }

  /**
   * The {@code shard}-th slice of an even {@code totalShards}-way split of the {@code field} hash space.
   *
   * @param shard the zero based index of the shard, lower than {@code totalShards}
   * @param totalShards the number of shards the hash space is split into
   */
  public static ShardRange ofShard(ShardField field, int shard, int totalShards) {
    return ofShard(pathOf(field), shard, totalShards);
  }

  /**
   * The {@code shard}-th slice of an even {@code totalShards}-way split of the {@code fieldPath} hash space.
   *
   * @param shard the zero based index of the shard, lower than {@code totalShards}
   * @param totalShards the number of shards the hash space is split into
   */
  public static ShardRange ofShard(String fieldPath, int shard, int totalShards) {
    if (totalShards < 1) {
      throw new IllegalArgumentException("The total number of shards must be at least 1, but was " + totalShards);
    }
    if (shard < 0 || shard >= totalShards) {
      throw new IllegalArgumentException(
          "The shard index must be within [0, " + totalShards + "), but was " + shard);
    }
    final BigInteger total = BigInteger.valueOf(totalShards);
    return new ShardRange(fieldPath,
        MAX_HASH.multiply(BigInteger.valueOf(shard)).divide(total),
        MAX_HASH.multiply(BigInteger.valueOf(shard + 1L)).divide(total));
  }

  public String getFieldPath() {
    return fieldPath;
  }

  /**
   * @return the inclusive lower bound
   */
  public BigInteger getStart() {
    return start;
  }

  /**
   * @return the exclusive upper bound
   */
  public BigInteger getEnd() {
    return end;
  }

  /**
   * @return the inclusive lower bound as it appears in the expression, e.g. {@code 0x8000000000000000}
   */
  public String getStartHex() {
    return toHex(start);
  }

  /**
   * @return the exclusive upper bound as it appears in the expression, e.g. {@code 0x10000000000000000}
   */
  public String getEndHex() {
    return toHex(end);
  }

  /**
   * @return this range as a single {@code shardRange(...)} CEL term
   */
  public String toExpression() {
    return "shardRange(" + fieldPath + ", '" + getStartHex() + "', '" + getEndHex() + "')";
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
    ShardRange other = (ShardRange) o;
    return fieldPath.equals(other.fieldPath) && start.equals(other.start) && end.equals(other.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldPath, start, end);
  }

  private static String pathOf(ShardField field) {
    Objects.requireNonNull(field, "A shard range requires a field");
    return field.getPath();
  }

  private static BigInteger parseHash(String hex) {
    if (Utils.isNullOrEmpty(hex)) {
      throw new IllegalArgumentException("A shard range bound must not be empty");
    }
    String value = hex.trim();
    if (value.regionMatches(true, 0, "0x", 0, 2)) {
      value = value.substring(2);
    }
    try {
      return new BigInteger(value, 16);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Not a valid hexadecimal shard range bound: " + hex, e);
    }
  }

  private static String toHex(BigInteger value) {
    return String.format(Locale.ROOT, "0x%016x", value);
  }
}
