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
package io.fabric8.mockwebserver

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.Vertx
import io.vertx.core.http.WebSocket
import io.vertx.core.http.WebSocketClient
import io.vertx.core.http.WebSocketConnectOptions
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.stream.IntStream
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class DefaultMockServerWebSocketTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()

	DefaultMockServer server

	WebSocketClient wsClient

	def setup() {
		server = new DefaultMockServer()
		server.start()
		wsClient = vertx.createWebSocketClient()
	}

	def cleanup() {
		server.shutdown()
		wsClient.close()
	}

	def "andUpgradeToWebSocket, with configured events, should emit events"() {
		given: "A WebSocket expectation"
		server.expect().withPath("/websocket")
				.andUpgradeToWebSocket()
				.open()
				.waitFor(10L).andEmit("A text message")
				.done()
				.always()
		and:
		Queue<String> messages = new ArrayBlockingQueue<>(1)
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
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
			assert messages.poll(10, TimeUnit.SECONDS) == "A text message"
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}

	def "andUpgradeToWebSocket, with configured events, should emit onClose when done"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().immediately().andEmit("event").done().always()
		and:
		def future = new CompletableFuture()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "A WebSocket listener"
		wsReq.onComplete { ws ->
			ws.result().closeHandler { _ ->
				ws.result().close()
				future.complete(ws.result().closeReason())
			}
		}
		and: "An instance of AsyncConditions"
		def async = new AsyncConditions(1)

		when: "The request is sent and completed"
		async.evaluate {
			assert future.get(10, TimeUnit.SECONDS) == "Closing..."
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}

	def "andUpgradeToWebSocket, with no events, should emit onClose"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().done().always()
		and:
		def future = new CompletableFuture()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "A WebSocket listener"
		wsReq.onComplete { ws ->
			if (ws.result().isClosed()) {
				future.complete(ws.result().closeReason())
			} else {
				ws.result().closeHandler { _ ->
					ws.result().close()
					future.complete(ws.result().closeReason())
				}
			}
		}
		and: "An instance of AsyncConditions"
		def async = new AsyncConditions(1)

		when: "The request is sent and completed"
		async.evaluate {
			assert future.get(10, TimeUnit.SECONDS) == "Closing..."
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}

	// https://github.com/fabric8io/mockwebserver/pull/66#issuecomment-944289335
	def "andUpgradeToWebSocket, with multiple upgrades, should emit events for all websocket listeners"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().waitFor(10L).andEmit("A text message").done().always()
		and: "A CountDown latch to verify the event count"
		def latch = new CountDownLatch(15)
		and: "A Vert.x WebSocket completion handler"
		Handler<AsyncResult<WebSocket>> completionHandler =  { ws ->
			ws.result().textMessageHandler { text ->
				latch.countDown()
			}
			ws.result().closeHandler { _ ->
				ws.result().close()
			}
		}
		and: "WebSocket requests"
		IntStream.range(0, 15).forEach {i ->
			def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
			wsReq.onComplete(completionHandler)
		}
		and: "An instance of AsyncConditions"
		def async = new AsyncConditions(1)

		when: "The requests are sent and completed"
		async.evaluate {
			assert latch.await(10, TimeUnit.SECONDS)
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}

	// https://github.com/fabric8io/mockwebserver/issues/77
	def "andUpgradeToWebSocket, with request header 'sec-websocket-protocol', should create response with matching header"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().done().always()
		and:
		def future = new CompletableFuture()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(new WebSocketConnectOptions()
				.setPort(server.port)
				.setHost(server.getHostName())
				.setURI("/websocket")
				.addSubProtocol("v4.channel.k8s.io"))
		and: "A WebSocket listener"
		wsReq.onComplete { ws ->
			if (ws.result() != null && ws.result().headers() != null) {
				future.complete(ws.result().headers().get("sec-websocket-protocol"))
			}
		}
		if (wsReq.result() != null && wsReq.result().headers() != null) {
			future.complete(wsReq.result().headers().get("sec-websocket-protocol"))
		}
		and: "An instance of AsyncConditions"
		def async = new AsyncConditions(1)

		when: "The request is sent and completed"
		async.evaluate {
			assert future.get(10, TimeUnit.SECONDS) == "v4.channel.k8s.io"
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}
}
