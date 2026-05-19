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
package io.fabric8.kubernetes.client.http;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class TestWebSocketTest {

  @Test
  void send_capturesDefensiveCopyOfPayload() {
    final TestWebSocket ws = new TestWebSocket();
    final byte[] backing = "hello".getBytes(StandardCharsets.UTF_8);
    final ByteBuffer source = ByteBuffer.wrap(backing);

    ws.send(source);
    // Mutate the original backing array after send returns: the capture must not be affected.
    backing[0] = 'X';

    assertThat(ws.getSent()).singleElement().satisfies(captured -> {
      final byte[] out = new byte[captured.remaining()];
      captured.duplicate().get(out);
      assertThat(new String(out, StandardCharsets.UTF_8)).isEqualTo("hello");
      assertThat(captured.isReadOnly()).isTrue();
    });
  }

  @Test
  void send_completesFirstSent() {
    final TestWebSocket ws = new TestWebSocket();

    ws.send(ByteBuffer.wrap("payload".getBytes(StandardCharsets.UTF_8)));

    assertThat(ws.firstSent())
        .succeedsWithin(1, TimeUnit.SECONDS)
        .satisfies(captured -> {
          final byte[] out = new byte[captured.remaining()];
          captured.duplicate().get(out);
          assertThat(new String(out, StandardCharsets.UTF_8)).isEqualTo("payload");
        });
  }

  @Test
  void send_capturesIndependentlyWhenSourceBufferIsReusedAcrossSends() {
    // Mirrors PortForwarderWebsocketListener.pipe(): a single buffer is cleared, filled, and
    // sent on each iteration. Captures must remain independent across iterations.
    final TestWebSocket ws = new TestWebSocket();
    final ByteBuffer reused = ByteBuffer.allocate(4);

    reused.put("AAAA".getBytes(StandardCharsets.UTF_8)).flip();
    ws.send(reused);
    reused.clear();
    reused.put("BBBB".getBytes(StandardCharsets.UTF_8)).flip();
    ws.send(reused);

    assertThat(ws.getSent()).hasSize(2).satisfies(snapshots -> {
      final byte[] first = new byte[snapshots.get(0).remaining()];
      final byte[] second = new byte[snapshots.get(1).remaining()];
      snapshots.get(0).duplicate().get(first);
      snapshots.get(1).duplicate().get(second);
      assertThat(new String(first, StandardCharsets.UTF_8)).isEqualTo("AAAA");
      assertThat(new String(second, StandardCharsets.UTF_8)).isEqualTo("BBBB");
    });
  }

  @Test
  void getSent_andFirstSent_returnIndependentViews() {
    // Reading bytes through one accessor must not advance the position seen by another caller.
    final TestWebSocket ws = new TestWebSocket();
    ws.send(ByteBuffer.wrap("payload".getBytes(StandardCharsets.UTF_8)));

    // Drain the read-only view returned by getSent() — its position advances to limit.
    final ByteBuffer first = ws.getSent().get(0);
    final byte[] drained = new byte[first.remaining()];
    first.get(drained);
    assertThat(first.hasRemaining()).isFalse();

    // A subsequent caller through either accessor must see a fresh, undrained view.
    assertThat(ws.getSent().get(0).remaining()).isEqualTo("payload".length());
    assertThat(ws.firstSent().getNow(null)).isNotNull()
        .satisfies(buf -> assertThat(buf.remaining()).isEqualTo("payload".length()));
  }

  @Test
  void firstSent_capturesFirstPayloadOnly() {
    final TestWebSocket ws = new TestWebSocket();

    ws.send(ByteBuffer.wrap("first".getBytes(StandardCharsets.UTF_8)));
    ws.send(ByteBuffer.wrap("second".getBytes(StandardCharsets.UTF_8)));

    assertThat(ws.firstSent())
        .succeedsWithin(1, TimeUnit.SECONDS)
        .satisfies(captured -> {
          final byte[] out = new byte[captured.remaining()];
          captured.duplicate().get(out);
          assertThat(new String(out, StandardCharsets.UTF_8)).isEqualTo("first");
        });
    assertThat(ws.getSent()).hasSize(2);
  }

  @Test
  void sendClose_completesFirstCloseWithCodeAndReason() {
    final TestWebSocket ws = new TestWebSocket();

    ws.sendClose(1002, "Protocol error");

    assertThat(ws.firstClose())
        .succeedsWithin(1, TimeUnit.SECONDS)
        .isEqualTo(new TestWebSocket.CloseFrame(1002, "Protocol error"));
  }

  @Test
  void sendClose_capturesFirstCallOnly() {
    final TestWebSocket ws = new TestWebSocket();

    ws.sendClose(1000, "normal");
    ws.sendClose(1002, "second");

    assertThat(ws.firstClose())
        .succeedsWithin(1, TimeUnit.SECONDS)
        .isEqualTo(new TestWebSocket.CloseFrame(1000, "normal"));
  }

  @Test
  void request_runsScriptedActionsInOrderThenIsNoOp() {
    final TestWebSocket ws = new TestWebSocket();
    final StringBuilder trace = new StringBuilder();
    ws.onRequest(() -> trace.append("a")).onRequest(() -> trace.append("b"));

    ws.request();
    ws.request();
    ws.request();

    assertThat(trace.toString()).isEqualTo("ab");
    assertThat(ws.requestCount()).isEqualTo(3);
  }

  @Test
  void request_incrementsCounterEvenWithoutScriptedActions() {
    final TestWebSocket ws = new TestWebSocket();

    ws.request();
    ws.request();

    assertThat(ws.requestCount()).isEqualTo(2);
  }

  @Test
  void onRequest_rejectsNullAction() {
    final TestWebSocket ws = new TestWebSocket();

    assertThatNullPointerException().isThrownBy(() -> ws.onRequest(null));
  }

  @Test
  void queueSize_returnsZero() {
    final TestWebSocket ws = new TestWebSocket();

    ws.send(ByteBuffer.wrap(new byte[] { 1, 2, 3 }));

    assertThat(ws.queueSize()).isZero();
  }

  @Test
  void closeFrame_equalsAndHashCode() {
    final TestWebSocket.CloseFrame a = new TestWebSocket.CloseFrame(1000, "normal");
    final TestWebSocket.CloseFrame b = new TestWebSocket.CloseFrame(1000, "normal");
    final TestWebSocket.CloseFrame c = new TestWebSocket.CloseFrame(1002, "normal");

    assertThat(a).isEqualTo(b).hasSameHashCodeAs(b);
    assertThat(a).isNotEqualTo(c);
  }
}
