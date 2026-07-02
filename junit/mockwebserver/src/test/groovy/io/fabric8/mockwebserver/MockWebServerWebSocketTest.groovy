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
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.WebSocketClient
import io.vertx.core.http.WebSocketConnectOptions
import java.util.concurrent.TimeUnit
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

	def "Upgrades to WebSocket even when the request carries content headers"() {
		given: "A WebSocketUpgrade expectation"
		String receivedMessage = null
		server.enqueue(new MockResponse().withWebSocketUpgrade(new WebSocketListener() {
					@Override
					void onMessage(WebSocket webSocket, String text) {
						receivedMessage = text
					}
				}))
		and: "A WebSocket request carrying a Content-Type header (previously routed through the async body reader)"
		def options = new WebSocketConnectOptions()
				.setHost(server.getHostName())
				.setPort(server.port)
				.setURI("/websocket")
				.addHeader("Content-Type", "application/octet-stream")
		def wsReq = wsClient.connect(options)
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "The request is sent and a text message is written"
		wsReq.onSuccess { ws ->
			ws.writeTextMessage("A text message from the client")
		}

		then: "The upgrade succeeds and the message is received"
		condition.eventually {
			assert wsReq.isComplete()
			assert wsReq.succeeded()
			assert receivedMessage == "A text message from the client"
		}
	}

	def "Replies with the enqueued HTTP response when a WebSocket-upgrade request receives a non-WebSocket response"() {
		given: "A standard (non-WebSocket) response is enqueued"
		server.enqueue(new MockResponse().setResponseCode(200).setBody("Not a websocket"))
		and: "A plain HTTP client"
		def httpClient = vertx.createHttpClient()
		and: "An instance of PollingConditions"
		def condition = new PollingConditions(timeout: 10)

		when: "A request carrying Upgrade and content headers is sent, but the mock returns a standard response"
		// Only the status line is asserted: reading the response body over a connection that
		// requested (and was denied) an upgrade is not reliable across HTTP client stacks and
		// flakes on some platforms. Body delivery is already covered by the regular HTTP tests;
		// this test only needs to prove the upgrade request falls back to a standard HTTP
		// response instead of hanging or being upgraded.
		def result = httpClient.request(HttpMethod.GET, server.port, server.getHostName(), "/websocket")
				.compose { req ->
					req.putHeader("Upgrade", "websocket")
					req.putHeader("Content-Type", "application/octet-stream")
					req.send()
				}
				.map { resp -> resp.statusCode() }

		then: "The server replies with the enqueued HTTP status instead of hanging or upgrading"
		condition.eventually {
			assert result.succeeded()
			assert result.result() == 200
		}
		and: "The server actually saw the upgrade header, so the synchronous fallback branch was exercised"
		def recorded = server.takeRequest(10, TimeUnit.SECONDS)
		recorded != null
		recorded.getHeader("Upgrade")?.toLowerCase()?.contains("websocket")

		cleanup:
		httpClient.close()
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
