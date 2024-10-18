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
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.stream.IntStream
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class DefaultMockServerWebSocketTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()
	WebSocketClient wsClient
	DefaultMockServer server

	def setup() {
		wsClient = vertx.createWebSocketClient()
		server = new DefaultMockServer()
		server.start()
	}

	def cleanup() {
		wsClient.close()
		server.shutdown()
	}

	def cleanupSpec() {
		vertx.close()
	}

	def "andUpgradeToWebSocket, with configured events, should emit events"() {
		given: "A WebSocket expectation"
		server.expect().withPath("/websocket")
				.andUpgradeToWebSocket()
				.open()
				.waitFor(10L).andEmit("A text message from the server")
				.done()
				.always()
		and:
		def messages = new ArrayList<>()
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent and completed"
		conditions.eventually {
			assert !messages.isEmpty()
		}

		then: "Expect the event from the server"
		messages.iterator().next() == "A text message from the server"
	}

	def "andUpgradeToWebSocket, with configured events, should emit onClose when done"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().immediately().andEmit("event").done().always()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent and completed"
		conditions.eventually {
			assert wsReq.isComplete()
		}

		then: "Expect the onClose reason"
		wsReq.result().closeReason() == "Closing..."
	}

	def "andUpgradeToWebSocket, with no events, should emit onClose"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().done().always()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "A WebSocket listener"
		String closeReason
		wsReq.onComplete { ws ->
			if (ws.result().isClosed()) {
				closeReason = ws.result().closeReason()
			} else {
				ws.result().closeHandler { _ ->
					ws.result().close()
					closeReason = ws.result().closeReason()
				}
			}
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent and completed"
		conditions.eventually {
			assert closeReason != null
		}

		then: "Expect the onClose reason"
		closeReason == "Closing..."
	}

	// https://github.com/fabric8io/mockwebserver/pull/66#issuecomment-944289335
	def "andUpgradeToWebSocket, with multiple upgrades, should emit events for all websocket listeners"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().waitFor(10L)
				.andEmit("A text message from the server")
				.done().always()
		and: "A list to store the received messages"
		def receivedMessages = new ConcurrentLinkedQueue<String>()
		and: "A Vert.x WebSocket completion handler"
		Handler<AsyncResult<WebSocket>> completionHandler =  { ws ->
			ws.result().textMessageHandler { text ->
				receivedMessages.add(text)
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are sent and completed"
		conditions.eventually {
			assert receivedMessages.size() == 15
		}

		then: "Expect the messages to be received"
		receivedMessages.each { message ->
			assert message == "A text message from the server"
		}
	}

	// https://github.com/fabric8io/mockwebserver/issues/77
	def "andUpgradeToWebSocket, with request header 'sec-websocket-protocol', should create response with matching header"() {
		given: "A WebSocket expectation"
		server.expect()
				.withPath("/websocket")
				.andUpgradeToWebSocket().open().waitFor(10L).andEmit("done").done().always()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(new WebSocketConnectOptions()
				.setPort(server.port)
				.setHost(server.getHostName())
				.setURI("/websocket")
				.addSubProtocol("v4.channel.k8s.io"))
		and: "A WebSocket listener"
		String secWebSocketProtocol
		wsReq.onComplete { ws ->
			if (ws.result() != null && ws.result().headers() != null) {
				secWebSocketProtocol = ws.result().headers().get("sec-websocket-protocol")
			}
		}
		def currentResult = wsReq.result()
		if (currentResult != null && currentResult.headers() != null) {
			secWebSocketProtocol = currentResult.headers().get("sec-websocket-protocol")
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent and completed"
		conditions.eventually {
			assert secWebSocketProtocol != null
		}

		then: "Expect the response to contain a matching header"
		secWebSocketProtocol == "v4.channel.k8s.io"
	}
}
