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
package io.fabric8.mockwebserver

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import java.util.stream.IntStream

class DefaultMockServerWebSocketTest extends Specification {

  DefaultMockServer server

  @Shared
  OkHttpClient client = new OkHttpClient()

  def setup() {
    server = new DefaultMockServer()
    server.start()
  }

  def cleanup() {
    server.shutdown()
  }

  def "andUpgradeToWebSocket, with configured events, should emit events"() {
    given:
    server.expect()
        .withPath("/websocket")
        .andUpgradeToWebSocket().open().waitFor(10L).andEmit("A text message").done().always()
    def future = new CompletableFuture()
    when:
    def ws = client.newWebSocket(new Request.Builder().url(server.url("/websocket")).build(), new WebSocketListener() {
      @Override
      void onMessage(WebSocket webSocket, String text) {
        future.complete(text)
      }
    })
    then:
    assert future.get(100L, TimeUnit.MILLISECONDS) == "A text message"
    cleanup:
    ws.close(1000, "Test finished")
  }

  def "andUpgradeToWebSocket, with configured events, should emit onClose when done"() {
    given:
    server.expect()
        .withPath("/websocket")
        .andUpgradeToWebSocket().open().immediately().andEmit("event").done().always()
    def future = new CompletableFuture()
    when:
    def ws = client.newWebSocket(new Request.Builder().url(server.url("/websocket")).build(), new WebSocketListener() {
      @Override
      void onClosing(WebSocket webSocket, int code, String reason) {
        future.complete(reason)
      }
    })
    then:
    assert future.get(100L, TimeUnit.MILLISECONDS) == "Closing..."
  }

  def "andUpgradeToWebSocket, with no events, should emit onClose"() {
    given:
    server.expect()
        .withPath("/websocket")
        .andUpgradeToWebSocket().open().done().always()
    def future = new CompletableFuture()
    when:
    def ws = client.newWebSocket(new Request.Builder().url(server.url("/websocket")).build(), new WebSocketListener() {
      @Override
      void onClosing(WebSocket webSocket, int code, String reason) {
        future.complete(reason)
      }
    })
    then:
    assert future.get(100L, TimeUnit.MILLISECONDS) == "Closing..."
  }

  // https://github.com/fabric8io/mockwebserver/pull/66#issuecomment-944289335
  def "andUpgradeToWebSocket, with multiple upgrades, should emit events for all websocket listeners"() {
    given:
    server.expect()
        .withPath("/websocket")
        .andUpgradeToWebSocket().open().waitFor(10L).andEmit("A text message").done().always()
    def latch = new CountDownLatch(15)
    def wsListener = new WebSocketListener() {
      @Override
      void onMessage(WebSocket webSocket, String text) {
        latch.countDown()
      }
    }
    when:
    def wss = IntStream.range(0, 15).mapToObj(i ->
        client.newWebSocket(new Request.Builder().url(server.url("/websocket")).build(), wsListener)
    ).collect(Collectors.toList())
    then:
    assert latch.await(10000L, TimeUnit.MILLISECONDS)
    cleanup:
    wss.forEach(ws -> ws.close(1000, "Test finished"))
  }

  // https://github.com/fabric8io/mockwebserver/issues/77
  def "andUpgradeToWebSocket, with request header 'sec-websocket-protocol', should create response with matching header"() {
    given:
    server.expect()
            .withPath("/websocket")
            .andUpgradeToWebSocket().open().done().always()
    def future = new CompletableFuture()
    when:
    def ws = client.newWebSocket(new Request.Builder().url(server.url("/websocket")).header("sec-websocket-protocol", "v4.channel.k8s.io").build(), new WebSocketListener() {
      @Override
      void onOpen(WebSocket webSocket, Response response) {
        future.complete(response.header("sec-websocket-protocol"))
      }
    })
    then:
    assert future.get(100L, TimeUnit.MILLISECONDS) == "v4.channel.k8s.io"
    cleanup:
    ws.close(1000, "Test finished")
  }

  // https://github.com/fabric8io/mockwebserver/issues/77
  def "andUpgradeToWebSocket, with request header 'sec-websocket-protocol', should not change existing response header"() {
    given:
    server.expect()
            .withPath("/websocket")
            .andUpgradeToWebSocket()
            .open()
            .done()
            .withHeader("sec-websocket-protocol", "v3.channel.k8s.io,v4.channel.k8s.io")
            .always()
    def future = new CompletableFuture()
    when:
    def ws = client.newWebSocket(new Request.Builder().url(server.url("/websocket")).header("sec-websocket-protocol", "v4.channel.k8s.io").build(), new WebSocketListener() {
      @Override
      void onOpen(WebSocket webSocket, Response response) {
        future.complete(response.header("sec-websocket-protocol"))
      }
    })
    then:
    assert future.get(100L, TimeUnit.MILLISECONDS) == "v3.channel.k8s.io,v4.channel.k8s.io"
    cleanup:
    ws.close(1000, "Test finished")
  }
}
