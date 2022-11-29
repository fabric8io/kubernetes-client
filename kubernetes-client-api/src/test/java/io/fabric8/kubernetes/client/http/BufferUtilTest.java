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
package io.fabric8.kubernetes.client.http;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BufferUtilTest {

  @Test
  void toArrayFromBBWithArray() {
    final ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
    final byte[] result = BufferUtil.toArray(buffer);
    assertThat(result).asString(StandardCharsets.UTF_8).isEqualTo("hello");
  }

  @Test
  void toArrayFromBB() {
    final ByteBuffer buffer = ByteBuffer.allocateDirect(5);
    buffer.put((byte) 104);
    buffer.put((byte) 101);
    buffer.put((byte) 108);
    buffer.put((byte) 108);
    buffer.put((byte) 111);
    buffer.rewind();
    final byte[] result = BufferUtil.toArray(buffer);
    assertThat(result).asString(StandardCharsets.UTF_8).isEqualTo("hello");
  }

  @Test
  void toArrayFromBBInPosition() {
    final ByteBuffer buffer = ByteBuffer.allocateDirect(12);
    buffer.position(7);
    buffer.put((byte) 104);
    buffer.put((byte) 101);
    buffer.put((byte) 108);
    buffer.put((byte) 108);
    buffer.put((byte) 111);
    buffer.position(7);
    final byte[] result = BufferUtil.toArray(buffer);
    assertThat(result).asString(StandardCharsets.UTF_8).isEqualTo("hello");
  }

  @Test
  void toArrayFromMultipleBB() {
    final ByteBuffer hello = ByteBuffer.allocateDirect(12);
    hello.position(7);
    hello.put((byte) 104);
    hello.put((byte) 101);
    hello.put((byte) 108);
    hello.put((byte) 108);
    hello.put((byte) 111);
    hello.position(7);
    final ByteBuffer space = ByteBuffer.allocateDirect(1);
    space.put((byte) 32);
    space.rewind();
    final ByteBuffer world = ByteBuffer.wrap("world".getBytes(StandardCharsets.UTF_8));
    final byte[] result = BufferUtil.toArray(Arrays.asList(hello, space, world));
    assertThat(result).asString(StandardCharsets.UTF_8).isEqualTo("hello world");
  }

  @Test
  void copyReturnsADifferentInstance() {
    final ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
    final ByteBuffer result = BufferUtil.copy(buffer);
    assertThat(result)
        .isNotSameAs(buffer)
        .extracting(BufferUtil::toArray).asInstanceOf(InstanceOfAssertFactories.BYTE_ARRAY)
        .asString(StandardCharsets.UTF_8)
        .isEqualTo("hello");
  }

  @Test
  void copyReturnsInstanceWithSameContent() {
    final ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
    final ByteBuffer result = BufferUtil.copy(buffer);
    assertThat(result)
        .extracting(BufferUtil::toArray)
        .asInstanceOf(InstanceOfAssertFactories.BYTE_ARRAY)
        .asString(StandardCharsets.UTF_8)
        .isEqualTo("hello");
  }

  @Test
  void copyReturnsInstanceWithSameContentRange() {
    final ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
    buffer.position(2);
    final ByteBuffer result = BufferUtil.copy(buffer);
    assertThat(result)
        .extracting(BufferUtil::toArray)
        .asInstanceOf(InstanceOfAssertFactories.BYTE_ARRAY)
        .asString(StandardCharsets.UTF_8)
        .isEqualTo("llo");
  }

  @Test
  void copyReturnsInstancePreservingPositionOfOriginal() {
    final ByteBuffer buffer = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
    buffer.position(2);
    BufferUtil.copy(buffer);
    assertThat(buffer)
        .extracting(ByteBuffer::position)
        .isEqualTo(2);
  }

  @Test
  void copyWithNullReturnsNull() {
    assertThat(BufferUtil.copy(null)).isNull();
  }
}
