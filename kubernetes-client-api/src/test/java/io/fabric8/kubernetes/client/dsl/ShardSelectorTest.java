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

import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class ShardSelectorTest {

  @Nested
  class Expression {

    @Test
    @DisplayName("ranges are ORed together in insertion order, matching the shardSelector CEL grammar")
    void combinesRangesWithOr() {
      ShardSelector selector = new ShardSelectorBuilder()
          .addShard(0, 4)
          .addShard(2, 4)
          .build();

      assertThat(selector.toExpression()).isEqualTo(
          "shardRange(object.metadata.uid, '0x0000000000000000', '0x4000000000000000') || " +
              "shardRange(object.metadata.uid, '0x8000000000000000', '0xc000000000000000')");
    }

    @Test
    @DisplayName("a single range is rendered without an OR")
    void rendersSingleRange() {
      assertThat(ShardSelector.ofShard(0, 2).toExpression())
          .isEqualTo("shardRange(object.metadata.uid, '0x0000000000000000', '0x8000000000000000')");
    }

    @Test
    @DisplayName("bounds are lower case hexadecimal, zero padded to the 16 digits of the 64 bit hash space")
    void padsBoundsTo16HexDigits() {
      assertThat(ShardRange.of(ShardField.UID, "0x0", "0xC000000000000000").toExpression())
          .isEqualTo("shardRange(object.metadata.uid, '0x0000000000000000', '0xc000000000000000')");
    }

    @Test
    @DisplayName("the exclusive end of the hash space is rendered as 2^64, which does not fit in a long")
    void rendersMaxHashAsTwoToThe64() {
      assertThat(ShardRange.ofShard(1, 2).getEndHex()).isEqualTo("0x10000000000000000");
      assertThat(ShardRange.MAX_HASH).isEqualTo(BigInteger.ONE.shiftLeft(64));
    }

    @Test
    @DisplayName("the namespace field path is emitted in CEL object-rooted syntax, not fieldSelector syntax")
    void supportsNamespaceField() {
      assertThat(ShardSelector.ofShard(ShardField.NAMESPACE, 0, 2).toExpression())
          .isEqualTo("shardRange(object.metadata.namespace, '0x0000000000000000', '0x8000000000000000')");
    }

    @Test
    @DisplayName("an arbitrary field path is accepted, so a newly supported server-side path needs no client release")
    void supportsRawFieldPath() {
      assertThat(new ShardSelectorBuilder()
          .addRange("object.metadata.name", "0x0", "0x10000000000000000")
          .build()
          .toExpression())
          .isEqualTo("shardRange(object.metadata.name, '0x0000000000000000', '0x10000000000000000')");
    }

    @Test
    @DisplayName("toString is the expression, so a selector can be interpolated where a string is expected")
    void toStringIsTheExpression() {
      ShardSelector selector = ShardSelector.ofShard(0, 2);
      assertThat(selector).hasToString(selector.toExpression());
      assertThat(selector.getRanges().get(0)).hasToString(selector.getRanges().get(0).toExpression());
    }
  }

  @Nested
  class EvenSplit {

    @ParameterizedTest(name = "{0} shards")
    @ValueSource(ints = { 1, 2, 3, 4, 8, 16, 1000 })
    @DisplayName("an n-way split covers the whole hash space without gaps or overlaps")
    void coversTheWholeHashSpace(int totalShards) {
      BigInteger previousEnd = ShardRange.MIN_HASH;
      for (int shard = 0; shard < totalShards; shard++) {
        ShardRange range = ShardRange.ofShard(shard, totalShards);
        assertThat(range.getStart()).isEqualTo(previousEnd);
        assertThat(range.getEnd()).isGreaterThan(range.getStart());
        previousEnd = range.getEnd();
      }
      assertThat(previousEnd).isEqualTo(ShardRange.MAX_HASH);
    }

    @Test
    @DisplayName("the documented 4-shard split is reproduced bound for bound")
    void matchesTheDocumentedFourShardSplit() {
      assertThat(Arrays.asList(
          ShardRange.ofShard(0, 4).toExpression(),
          ShardRange.ofShard(1, 4).toExpression(),
          ShardRange.ofShard(2, 4).toExpression(),
          ShardRange.ofShard(3, 4).toExpression()))
          .containsExactly(
              "shardRange(object.metadata.uid, '0x0000000000000000', '0x4000000000000000')",
              "shardRange(object.metadata.uid, '0x4000000000000000', '0x8000000000000000')",
              "shardRange(object.metadata.uid, '0x8000000000000000', '0xc000000000000000')",
              "shardRange(object.metadata.uid, '0xc000000000000000', '0x10000000000000000')");
    }

    @Test
    @DisplayName("a shard index outside [0, totalShards) is rejected instead of producing an empty shard")
    void rejectsOutOfRangeShardIndex() {
      assertThatIllegalArgumentException().isThrownBy(() -> ShardRange.ofShard(2, 2));
      assertThatIllegalArgumentException().isThrownBy(() -> ShardRange.ofShard(-1, 2));
      assertThatIllegalArgumentException().isThrownBy(() -> ShardRange.ofShard(0, 0));
    }
  }

  @Nested
  class Bounds {

    @ParameterizedTest
    @ValueSource(strings = { "0x8000000000000000", "0X8000000000000000", "8000000000000000", " 0x8000000000000000 " })
    @DisplayName("hexadecimal bounds are accepted with or without the 0x prefix, in any case, and trimmed")
    void parsesHexBounds(String hexStart) {
      assertThat(ShardRange.of(ShardField.UID, hexStart, "0x10000000000000000").getStart())
          .isEqualTo(BigInteger.ONE.shiftLeft(63));
    }

    @Test
    @DisplayName("BigInteger bounds bypass hexadecimal formatting entirely")
    void acceptsBigIntegerBounds() {
      assertThat(ShardRange.of(ShardField.UID, BigInteger.ZERO, BigInteger.valueOf(255)).toExpression())
          .isEqualTo("shardRange(object.metadata.uid, '0x0000000000000000', '0x00000000000000ff')");
    }

    @Test
    @DisplayName("an empty or inverted range is rejected, since it would silently select nothing")
    void rejectsEmptyRange() {
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, "0x1", "0x1"))
          .withMessageContaining("lower than the end bound");
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, "0x2", "0x1"));
    }

    @Test
    @DisplayName("bounds outside [0, 2^64] are rejected")
    void rejectsBoundsOutsideTheHashSpace() {
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, ShardRange.MAX_HASH, ShardRange.MAX_HASH));
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, BigInteger.ZERO, ShardRange.MAX_HASH.add(BigInteger.ONE)));
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, BigInteger.valueOf(-1), BigInteger.ONE));
    }

    @Test
    @DisplayName("a bound that is not hexadecimal is reported as such rather than as a NumberFormatException")
    void rejectsNonHexBounds() {
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, "0xnope", "0x1"))
          .withMessageContaining("hexadecimal");
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, "", "0x1"));
    }

    @Test
    @DisplayName("a missing field or bound is rejected at construction, not when the request is sent")
    void rejectsMissingFieldOrBound() {
      assertThatIllegalArgumentException()
          .isThrownBy(() -> ShardRange.of("", BigInteger.ZERO, BigInteger.ONE));
      assertThatNullPointerException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, null, BigInteger.ONE));
      assertThatNullPointerException()
          .isThrownBy(() -> ShardRange.of(ShardField.UID, BigInteger.ZERO, (BigInteger) null));
    }
  }

  @Nested
  class SelectorValue {

    @Test
    @DisplayName("a selector without ranges is rejected, since an empty expression is not valid CEL")
    void rejectsEmptySelector() {
      assertThatIllegalArgumentException()
          .isThrownBy(() -> new ShardSelectorBuilder().build())
          .withMessageContaining("at least one shard range");
      assertThatIllegalArgumentException().isThrownBy(() -> new ShardSelector(Collections.emptyList()));
      assertThatIllegalArgumentException().isThrownBy(() -> new ShardSelector(null));
      assertThatIllegalArgumentException()
          .isThrownBy(() -> new ShardSelector(Collections.singletonList(null)));
      assertThatIllegalArgumentException().isThrownBy(() -> new ShardSelectorBuilder().addRange(null));
    }

    @Test
    @DisplayName("the ranges of a built selector cannot be mutated through the builder or the returned list")
    void isImmutable() {
      ShardSelectorBuilder builder = new ShardSelectorBuilder().addShard(0, 2);
      ShardSelector selector = builder.build();
      builder.addShard(1, 2);

      assertThat(selector.getRanges()).hasSize(1).isUnmodifiable();
    }

    @Test
    @DisplayName("selectors and ranges compare by value, so they can be used as map keys or asserted on")
    void comparesByValue() {
      assertThat(ShardSelector.ofShard(0, 2))
          .isEqualTo(new ShardSelectorBuilder().addRange(ShardField.UID, "0x0", "0x8000000000000000").build())
          .hasSameHashCodeAs(new ShardSelectorBuilder().addShard(0, 2).build())
          .isNotEqualTo(ShardSelector.ofShard(1, 2))
          .isNotEqualTo(ShardSelector.ofShard(ShardField.NAMESPACE, 0, 2));
    }

    @Test
    @DisplayName("a selector can be copied and extended through the builder")
    void copiesExistingSelector() {
      ShardSelector selector = new ShardSelectorBuilder(ShardSelector.ofShard(0, 4))
          .addShard(2, 4)
          .build();

      assertThat(selector.getRanges())
          .containsExactly(ShardRange.ofShard(0, 4), ShardRange.ofShard(2, 4));
    }
  }

  @Nested
  class FilterableIntegration {

    @Test
    @DisplayName("the typed overload of withShardSelector forwards the rendered expression to the String overload")
    void forwardsExpressionToStringOverload() {
      RecordingFilterable filterable = new RecordingFilterable();
      ShardSelector selector = ShardSelector.ofShard(0, 2);

      filterable.withShardSelector(selector);

      assertThat(filterable.shardSelector).isEqualTo(selector.toExpression());
    }

    @Test
    @DisplayName("a null typed selector clears the shard selector rather than throwing")
    void clearsOnNull() {
      RecordingFilterable filterable = new RecordingFilterable();
      filterable.withShardSelector(ShardSelector.ofShard(0, 2));

      filterable.withShardSelector((ShardSelector) null);

      assertThat(filterable.shardSelector).isNull();
    }
  }

  /**
   * Minimal {@link Filterable} recording only what the shard selector overloads forward to it.
   */
  private static class RecordingFilterable implements Filterable<RecordingFilterable> {

    private String shardSelector;

    @Override
    public RecordingFilterable withShardSelector(String shardSelector) {
      this.shardSelector = shardSelector;
      return this;
    }

    @Override
    public RecordingFilterable withLabels(Map<String, String> labels) {
      return this;
    }

    @Override
    public RecordingFilterable withoutLabels(Map<String, String> labels) {
      return this;
    }

    @Override
    public RecordingFilterable withLabelIn(String key, String... values) {
      return this;
    }

    @Override
    public RecordingFilterable withLabelNotIn(String key, String... values) {
      return this;
    }

    @Override
    public RecordingFilterable withLabel(String key, String value) {
      return this;
    }

    @Override
    public RecordingFilterable withoutLabel(String key, String value) {
      return this;
    }

    @Override
    public RecordingFilterable withFields(Map<String, String> fields) {
      return this;
    }

    @Override
    public RecordingFilterable withField(String key, String value) {
      return this;
    }

    @Override
    public RecordingFilterable withoutFields(Map<String, String> fields) {
      return this;
    }

    @Override
    public RecordingFilterable withoutField(String key, String value) {
      return this;
    }

    @Override
    public RecordingFilterable withLabelSelector(LabelSelector selector) {
      return this;
    }

    @Override
    public RecordingFilterable withLabelSelector(String selectorAsString) {
      return this;
    }

    @Override
    public RecordingFilterable withInvolvedObject(ObjectReference objectReference) {
      return this;
    }
  }
}
