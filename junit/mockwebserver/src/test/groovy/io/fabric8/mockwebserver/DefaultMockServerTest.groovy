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

import io.fabric8.mockwebserver.internal.WebSocketMessage
import io.fabric8.mockwebserver.utils.ResponseProvider
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.WebSocketClient
import io.vertx.ext.web.client.WebClient
import okhttp3.Headers
import okhttp3.mockwebserver.RecordedRequest
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class DefaultMockServerTest extends Specification {

  Vertx vertx

  DefaultMockServer server

  WebClient client

  WebSocketClient wsClient

  def setup() {
    vertx = Vertx.vertx()
    server = new DefaultMockServer()
    server.start()
    client = WebClient.create(vertx)
    wsClient = vertx.createWebSocketClient()
  }

  def cleanup() {
    server.shutdown()
    client.close()
    wsClient.close()
    vertx.close()
  }

  def "getPort, should return a valid port"() {
    when:
      def result = server.getPort()

    then:
      assert result > 0
      assert result <= 65535
  }

  def "getHostName, should return a valid host name"() {
    when:
      def result = server.getHostName()

    then:
      assert !result.isBlank()
  }

  def "toProxy, should return Proxy with the current HostName and Port"() {
    when:
      def result = server.toProxyAddress()

    then:
      assert result.address() instanceof InetSocketAddress
      assert ((InetSocketAddress) result.address()).getPort() == server.getPort()
      assert ((InetSocketAddress) result.address()).getHostName() == server.getHostName()
  }

  def "getRequestCount, with no requests, should return 0"() {
    when:
      def result = server.getRequestCount()

    then:
      assert result == 0
  }

  def "getRequestCount, with multiple, should return valid request count"() {
    given:
      def all = Future.all(
        client.get(server.port, server.getHostName(), "/").send(),
        client.get(server.port, server.getHostName(), "/one").send(),
        client.get(server.port, server.getHostName(), "/two").send()
      )
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      all.onComplete {isr ->
        async.evaluate { assert server.getRequestCount() == 3 }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "getLastRequest, with no requests, should return null"() {
    when:
      def result = server.getLastRequest()

    then:
      assert result == null
  }

  def "getLastRequest, with one request, should return the request"() {
    given:
      def request = client.get(server.port, server.getHostName(), "/").send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      request.onComplete { isr ->
        async.evaluate { assert server.getLastRequest().getPath() == "/" }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "getLastRequest, with one request, can be invoked multiple times"() {
    given:
      def request = client.get(server.port, server.getHostName(), "/").send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      request.onComplete { isr ->
        server.getLastRequest()
        async.evaluate { assert server.getLastRequest().getPath() == "/" }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "getLastRequest, with multiple requests, should return the latest request"() {
    given:
      def all = client.get(server.port, server.getHostName(), "/").send()
        .compose { _ -> client.get(server.port, server.getHostName(), "/one").send() }
        .compose { _ -> client.get(server.port, server.getHostName(), "/two").send() }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)


    when: "The request is sent and completed"
      all.onComplete {isr ->
        async.evaluate { assert server.getLastRequest().getPath() == "/two" }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "getLastRequest, with multiple requests, can be invoked multiple times"() {
    given:
      def all = client.get(server.port, server.getHostName(), "/").send()
        .compose { _ -> client.get(server.port, server.getHostName(), "/one").send()}
        .compose { _ -> client.get(server.port, server.getHostName(), "/two").send()}
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      all.onComplete {isr ->
        server.getLastRequest()
        async.evaluate { assert server.getLastRequest().getPath() == "/two" }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "takeRequest, with timeout and no requests, should return null and don't block (after timeout)"() {
    when:
      def result = server.takeRequest(1, TimeUnit.MICROSECONDS)

    then:
      assert result == null
  }

  def "when setting an expectation with once it should be met only the first time"() {
    given: "An expectation with once"
      server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").once()
    and: "A first request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "A second request"
      def req2 = req1.compose { _ ->
        client.get(server.port, server.getHostName(), "/api/v1/users").send()
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The requests are sent and completed"
      Future.all(req1, req2).onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "admin"
          assert req2.result().statusCode() == 404
          assert req2.result().body() == null
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting an expectation with n-th times it should be met only the for the first n-th times"() {
    given: "An expectation with times (3)"
      server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").times(3)
    and: "A first request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "A second request"
      def req2 = req1.compose { _ ->
        client.get(server.port, server.getHostName(), "/api/v1/users").send()
      }
    and: "A third request"
      def req3 = req2.compose { _ ->
        client.get(server.port, server.getHostName(), "/api/v1/users").send()
      }
    and: "A fourth request"
      def req4 = req3.compose { _ ->
        client.get(server.port, server.getHostName(), "/api/v1/users").send()
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The requests are sent and completed"
      Future.all(req1, req2, req3, req4).onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "admin"
          assert req2.result().statusCode() == 200
          assert req2.result().body().toString() == "admin"
          assert req3.result().statusCode() == 200
          assert req3.result().body().toString() == "admin"
          assert req4.result().statusCode() == 404
          assert req4.result().body() == null
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting an expectation with always it should always be met"() {
    given: "An expectation with always"
      server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").always()
    and: "A first request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "A second request"
      def req2 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "A third request"
      def req3 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "A fourth request"
      def req4 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The requests are sent and completed"
      Future.all(req1, req2, req3, req4).onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "admin"
          assert req2.result().statusCode() == 200
          assert req2.result().body().toString() == "admin"
          assert req3.result().statusCode() == 200
          assert req3.result().body().toString() == "admin"
          assert req4.result().statusCode() == 200
          assert req4.result().body().toString() == "admin"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting an expectation as an object it should be serialized to json"() {
    given: "An expectation with always"
      def root = new User(0, "root", true)
      server.expect().get().withPath("/api/v1/users").andReturn(200, root).always()
    and: "A request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      req1.onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "{\"id\":0,\"username\":\"root\",\"enabled\":true}"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting a timed websocket String message it should be fired at the specified time"() {
    given: "A WebSocket expectation"
      server.expect().get().withPath("/api/v1/users/watch")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(1000).andEmit("DELETED")
        .done()
        .once()
    and:
      Queue<String> messages = new ArrayBlockingQueue<>(1)
    and: "A WebSocket request"
      def wsReq =wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
    and: "A WebSocket listener"
      wsReq.onComplete { ws ->
        ws.result().textMessageHandler { text ->
          messages.add(text)
        }
        ws.result().closeHandler { _ ->
          ws.result().close()
        }
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      async.evaluate {
        assert messages.poll(10, TimeUnit.SECONDS) == "DELETED"
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting a timed websocket binary message it should be fire at the specified time"() {
    given: "A WebSocket expectation"
      server.expect().get().withPath("/api/v1/users/watch")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(1000).andEmit(new WebSocketMessage(new byte[]{1, 2, 3}))
        .done()
        .once()
    and:
      Queue<byte[]> messages = new ArrayBlockingQueue<>(1)
    and: "A WebSocket request"
      def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
    and: "A WebSocket listener"
      wsReq.onComplete { ws ->
        ws.result().binaryMessageHandler { buffer ->
          messages.add(buffer.getBytes(0, buffer.length()))
        }
        ws.result().closeHandler { _ ->
          ws.result().close()
        }
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      async.evaluate {
        assert messages.poll(10, TimeUnit.SECONDS) == new byte[]{1, 2, 3}
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting a request/response websocket message it should be fired when the event is triggered"() {
    given: "A WebSocket expectation"
      server.expect().get().withPath("/api/v1/users/watch")
        .andUpgradeToWebSocket()
        .open()
        .expect("create root").andEmit("CREATED").once()
        .expect("delete root").andEmit("DELETED").once()
        .done()
        .once()
    and:
      Queue<String> messages = new ArrayBlockingQueue<>(2)
    and: "A WebSocket request"
      def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
    and: "A WebSocket listener"
      wsReq.onComplete { ws ->
        ws.result().textMessageHandler { text ->
          messages.add(text)
        }
        ws.result().writeTextMessage("create root")
        ws.result().writeTextMessage("delete root")
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      async.evaluate {
        assert messages.poll(10, TimeUnit.SECONDS) == "CREATED"
        assert messages.poll(10, TimeUnit.SECONDS) == "DELETED"
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when receiving an unexpected websocket message it should close the connection with status code 1002"() {
    given: "A WebSocket expectation"
      server.expect().get().withPath("/api/v1/users/watch")
        .andUpgradeToWebSocket()
        .open()
        .expect("expected message").andEmit("MESSAGE OK").once()
        .done()
        .once()
    and:
      def closeCode = new CompletableFuture<Integer>()
      def closeReason = new CompletableFuture<String>()
    and: "A WebSocket request"
      def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
    and: "A WebSocket listener"
      wsReq.onComplete { ws ->
        ws.result().closeHandler { v ->
          closeCode.complete(ws.result().closeStatusCode())
          closeReason.complete(ws.result().closeReason())
        }
        ws.result().writeTextMessage("unexpected message")
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      async.evaluate {
        assert closeCode.get(10, TimeUnit.SECONDS) == 1002
        assert closeReason.get(10, TimeUnit.SECONDS) == "Unexpected message:unexpected message"
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting a delayed response it should be delayed for the specified duration"() {
    given: "An expectation with delay"
      server.expect().get().withPath("/api/v1/users")
        .delay(100, TimeUnit.MILLISECONDS)
        .andReturn(200, "admin")
        .once()
    and: "A start time"
      def startTime = System.currentTimeMillis()
    and: "A request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      req1.onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "admin"
          assert System.currentTimeMillis() - startTime >= 100
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when using a body provider it should work as for static responses"() {
    given: "A counter"
      def counter = new AtomicInteger(0);
    and: "An expectation with body provider"
      server.expect().get().withPath("/api/v1/users")
        .andReply(200, {req -> "admin-" + counter.getAndIncrement()})
        .always()
    and: "A request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "A second request"
      def req2 = req1.compose { _ ->
        client.get(server.port, server.getHostName(), "/api/v1/users").send()
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      Future.all(req1, req2).onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "admin-0"
          assert req2.result().statusCode() == 200
          assert req2.result().body().toString() == "admin-1"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when using a response provider it should work as for static responses"() {
    given: "An expectation with response provider"
      server.expect().get().withPath("/api/v1/users")
        .andReply(new ResponseProvider<Object>() {
            def counter = new AtomicInteger(0);
            def headers = new Headers.Builder().build()

            int getStatusCode(RecordedRequest request) {
                return 200
            }

            Object getBody(RecordedRequest request) {
                return "admin-" + counter.get()
            }

            @Override
            Headers getHeaders() {
                return headers.newBuilder().add("Count", "" + counter.incrementAndGet()).build()
            }

            @Override
            void setHeaders(Headers headers) {
                this.headers = headers
            }
        })
        .always()
    and: "A request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "A second request"
      def req2 = req1.compose { _ ->
        client.get(server.port, server.getHostName(), "/api/v1/users").send()
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      Future.all(req1, req2).onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "admin-1"
          assert req1.result().headers().get("Count") == "1"
          assert req2.result().statusCode() == 200
          assert req2.result().body().toString() == "admin-2"
          assert req2.result().headers().get("Count") == "2"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "should be able to set headers on responses"() {
    given: "An expectation with header"
      server.expect().get().withPath("/api/v1/users")
        .andReturn(200, "admin")
        .withHeader("test: header")
        .withHeader("test2", "header2")
        .once()
    and: "A request"
      def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      req1.onComplete {isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "admin"
          assert req1.result().headers().get("test") == "header"
          assert req1.result().headers().get("test2") == "header2"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting an httprequest/response websocket message it should be fired when the event is triggered"() {
    given: "A WebSocket + HTTP expectation"
      server.expect().get().withPath("/api/v1/users/watch")
        .andUpgradeToWebSocket()
        .open()
        .expectHttpRequest("/api/v1/create").andEmit("CREATED").once()
        .expectHttpRequest("/api/v1/delete").andEmit("DELETED").once()
        .done()
        .once()
    and:
      Queue<String> messages = new ArrayBlockingQueue<>(2)
    and: "A WebSocket request"
      def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
    and: "A WebSocket listener"
      wsReq.andThen { ws ->
        ws.result().textMessageHandler { text ->
          messages.add(text)
        }
      }
    and: "HTTP requests after WS connection initiated"
      wsReq.onComplete {
        client.get(server.port, server.getHostName(), "/api/v1/create").send()
          .compose { _ -> client.get(server.port, server.getHostName(), "/api/v1/delete").send() }

      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      async.evaluate {
        assert messages.poll(10, TimeUnit.SECONDS) == "CREATED"
        assert messages.poll(10, TimeUnit.SECONDS) == "DELETED"
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting an sentWebSocketMessage/response websocket message it should be fired when the event is triggered"() {
    given: "A WebSocket + HTTP expectation"
      server.expect().get().withPath("/api/v1/users/watch")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(50L).andEmit("READY")
        .expectHttpRequest("/api/v1/create").andEmit("CREATED").once()
        .expectSentWebSocketMessage("CREATED").andEmit("WS-CREATED").once()
        .done()
        .once()
    and:
      Queue<String> messages = new ArrayBlockingQueue<>(2)
    and: "A WebSocket request"
      def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
    and: "A WebSocket listener that sends an HTTP request after WS connection initiated and WS request after HTTP request"
      wsReq.andThen { ws ->
        ws.result().textMessageHandler { text ->
          if (text == "READY") {
            client.get(server.port, server.getHostName(), "/api/v1/create").send()
                .andThen {_ ->{
                  ws.result().writeTextMessage("CREATED")
                }}
          } else {
            messages.add(text)
          }
        }
      }
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      async.evaluate {
        assert messages.poll(10, TimeUnit.SECONDS) == "CREATED"
        assert messages.poll(10, TimeUnit.SECONDS) == "WS-CREATED"
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }
}
