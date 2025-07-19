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

import io.fabric8.mockwebserver.http.MockResponse
import io.fabric8.mockwebserver.http.Response
import io.fabric8.mockwebserver.http.WebSocket
import io.fabric8.mockwebserver.http.WebSocketListener
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.WebSocketClient
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class MockWebServerWebSocketTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()
	WebSocketClient wsClient
	MockWebServer server

	def setup() {
		wsClient = vertx.createWebSocketClient()
		server = new MockWebServer()
		server.start()
	}

	def cleanup() {
		wsClient.close()
		server.shutdown()
	}

	def cleanupSpec() {
		vertx.close()
	}

	def "Receives WebSocket text messages from client"() {
		given: "A WebSocketUpgrade expectation"
		String receivedMessage = null
		server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
					@Override
					void onMessage(WebSocket webSocket, String text) {
						receivedMessage = text
					}
				}))
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "The request is sent and a text message is written"
		wsReq.onSuccess { ws ->
			ws.writeTextMessage("A text message from the client")
		}

		then: "Expect the message to be received"
		condition.eventually {
			assert receivedMessage != null
		}

		then: "The received message should be the expected one"
		receivedMessage == "A text message from the client"
	}

	def "Sends WebSocket text messages to client"() {
		given: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "A WebSocketUpgrade expectation"
		server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
					@Override
					void onMessage(WebSocket webSocket, String text) {
						// Send the message after we make sure that the client wsRequest is established and ready
						webSocket.send("A text message from the server")
					}
				}))
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "The request is sent and a text message is expected from server"
		String receivedMessage = null
		wsReq.onSuccess { ws ->
			ws.textMessageHandler { text ->
				receivedMessage = text
			}
			ws.fetch(Long.MAX_VALUE)
			ws.writeTextMessage("Send me something")
		}

		then: "Expect the message to be received by the client"
		condition.eventually {
			assert receivedMessage != null
		}

		then: "The received message should be the expected one"
		receivedMessage == "A text message from the server"
	}

	def "Receives WebSocket binary messages from client"() {
		given: "A WebSocketUpgrade expectation"
		byte[] receivedMessage = null
		server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
					@Override
					void onMessage(WebSocket webSocket, byte[] bytes) {
						receivedMessage = bytes
					}
				}))
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "The request is sent and a binary message is written"
		wsReq.onSuccess { ws ->
			ws.writeBinaryMessage(Buffer.buffer([1, 2, 3] as byte[]))
		}

		then: "Expect the message to be received"
		condition.eventually {
			assert receivedMessage != null
		}

		then: "The received message should be the expected one"
		receivedMessage == [1, 2, 3] as byte[]
	}

	def "Sends WebSocket binary messages to client"() {
		given: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "A WebSocketUpgrade expectation"
		server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
					@Override
					void onMessage(WebSocket webSocket, String text) {
						// Send the message after we make sure that the client wsRequest is established
						wsReq.onSuccess {
							webSocket.send([1, 2, 3] as byte[])
						}
					}
				}))
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "The request is sent and a binary message is expected from server"
		byte[] receivedMessage
		wsReq.onSuccess { ws ->
			ws.binaryMessageHandler { buffer ->
				receivedMessage = buffer.getBytes()
			}
			ws.fetch(Long.MAX_VALUE)
			ws.writeTextMessage("Send me something")
		}

		then: "Expect the message to be received by the client"
		condition.eventually {
			assert receivedMessage != null
		}

		then: "The received message should be the expected one"
		receivedMessage == [1, 2, 3] as byte[]
	}

	def "Receives WebSocket onClose messages from client"() {
		given: "A WebSocketUpgrade expectation"
		int receivedCode = -1
		String receivedReason
		server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
					@Override
					void onClosing(WebSocket webSocket, int code, String reason) {
						receivedCode = code
						receivedReason = reason
					}
				}))
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "The request is sent and a close message is written"
		wsReq.onSuccess { ws ->
			ws.close(1000 as short, "Normal closure")
		}

		then: "Expect the message to be received"
		condition.eventually {
			assert receivedCode != -1
			assert receivedReason != null
		}

		then: "The close message should be the expected one"
		receivedCode == 1000
		receivedReason == "Normal closure"
	}

	def "Sends WebSocket onClose messages to client"() {
		given: "A WebSocketUpgrade expectation"
		server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
					@Override
					void onOpen(WebSocket webSocket, Response response) {
						Thread.sleep(100L)
						webSocket.close(1000, "Normal closure")
					}
				}))
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/websocket")
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "The connection completes"
		condition.eventually {
			assert wsReq.isComplete()
			assert wsReq.result() != null
			assert wsReq.result().closeReason() != null
		}

		then: "The received message should be the expected one"
		wsReq.result().closeStatusCode() == 1000 as short
		wsReq.result().closeReason() == "Normal closure"
	}
}
