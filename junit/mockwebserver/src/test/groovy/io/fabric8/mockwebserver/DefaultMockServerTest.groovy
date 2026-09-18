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

import io.fabric8.mockwebserver.http.Headers
import io.fabric8.mockwebserver.http.RecordedRequest
import io.fabric8.mockwebserver.internal.WebSocketMessage
import io.fabric8.mockwebserver.utils.ResponseProvider
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.WebSocketClient
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class DefaultMockServerTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()

	WebClient client
	WebSocketClient wsClient
	DefaultMockServer server

	def setup() {
		client = WebClient.create(vertx)
		wsClient = vertx.createWebSocketClient()
		server = new DefaultMockServer()
		server.start()
	}

	def cleanup() {
		client.close()
		wsClient.close()
		server.shutdown()
	}

	def cleanupSpec() {
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			all.each { req ->
				assert req.isComplete()
			}
		}

		then: "Expect the server to have 3 requests"
		server.getRequestCount() == 3
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert request.isComplete()
		}

		then: "Expect the request to match the last request"
		server.getLastRequest().getPath() == "/"
	}

	def "getLastRequest, with one request, can be invoked multiple times"() {
		given:
		def request = client.get(server.port, server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert request.isComplete()
		}

		then: "Expect getLastRequest to return always the last request"
		[1, 2, 3].each {
			assert server.getLastRequest().getPath() == "/"
		}
	}

	def "getLastRequest, with multiple requests, should return the latest request"() {
		given:
		def all = client.get(server.port, server.getHostName(), "/").send()
				.compose { _ -> client.get(server.port, server.getHostName(), "/one").send() }
				.compose { _ -> client.get(server.port, server.getHostName(), "/two").send() }
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			all.each { request ->
				assert request.isComplete()
			}
		}

		then: "Expect getLastRequest to return the last request"
		server.getLastRequest().getPath() == "/two"
	}

	def "getLastRequest, with multiple requests, can be invoked multiple times"() {
		given:
		def all = client.get(server.port, server.getHostName(), "/").send()
				.compose { _ -> client.get(server.port, server.getHostName(), "/one").send()}
				.compose { _ -> client.get(server.port, server.getHostName(), "/two").send()}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			all.each { request ->
				assert request.isComplete()
			}
		}

		then: "Expect getLastRequest to return the last request"
		[1, 2, 3].each {
			assert server.getLastRequest().getPath() == "/two"
		}
	}

	def "getLastRequest, with multiple requests and reset, should return null"() {
		given:
		def all = client.get(server.port, server.getHostName(), "/").send()
				.compose { _ -> client.get(server.port, server.getHostName(), "/one").send()}
				.compose { _ -> client.get(server.port, server.getHostName(), "/two").send()}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			all.each { request ->
				assert request.isComplete()
			}
		}
		and:
		server.reset()

		then: "Expect getLastRequest to return null"
		assert  server.getLastRequest() == null
	}

	def "takeRequest, with timeout and no requests, should return null and don't block after timeout"() {
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			[req1, req2].each { request ->
				assert request.isComplete()
			}
		}

		then: "Expect the responses to match the expectations once"
		req1.result().statusCode() == 200
		req1.result().body().toString() == "admin"
		req2.result().statusCode() == 404
		req2.result().body() == null
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			[req1, req2, req3, req4].each { request ->
				assert request.isComplete()
			}
		}

		then: "Expect the responses to match the expectations n times"
		req1.result().statusCode() == 200
		req1.result().body().toString() == "admin"
		req2.result().statusCode() == 200
		req2.result().body().toString() == "admin"
		req3.result().statusCode() == 200
		req3.result().body().toString() == "admin"
		req4.result().statusCode() == 404
		req4.result().body() == null
	}

	def "when setting an expectation with always it should always be met"() {
		given: "An expectation with always"
		server.expect().get().withPath("/api/v1/users").andReturn(200, "admin").always()
		and: "Multiple equal requests"
		def requests = new ArrayList<Future<HttpResponse<Buffer>>>()
		[1, 2, 3, 4].each {
			requests.add(client.get(server.port, server.getHostName(), "/api/v1/users").send())
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			requests.each { request ->
				assert request.isComplete()
			}
		}

		then: "Expect the responses to match the expectations always"
		requests.each { request ->
			assert request.result().statusCode() == 200
			assert request.result().body().toString() == "admin"
		}
	}

	def "when setting an expectation as an object it should be serialized to json"() {
		given: "An expectation with always"
		def root = new User(0, "root", true)
		server.expect().get().withPath("/api/v1/users").andReturn(200, root).always()
		and: "A request"
		def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert req1.isComplete()
		}

		then: "Expect the response to contain the serialized json"
		req1.result().statusCode() == 200
		req1.result().body().toString() == "{\"id\":0,\"username\":\"root\",\"enabled\":true}"
	}

	def "when setting a timed websocket String message it should be fired at the specified time"() {
		given: "A WebSocket expectation"
		server.expect().get().withPath("/api/v1/users/watch")
				.andUpgradeToWebSocket()
				.open()
				.waitFor(300).andEmit("DELETED")
				.done()
				.once()
		and: "The current time"
		def startTime = System.currentTimeMillis()
		and: "A list to store the received messages"
		def receivedMessages = new ConcurrentLinkedQueue<String>()
		and: "A WebSocket request"
		def wsReq =wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
		and: "A WebSocket listener"
		wsReq.onSuccess { ws ->
			ws.textMessageHandler { text ->
				receivedMessages.add(text)
			}
			ws.closeHandler { _ ->
				ws.close()
			}
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert !receivedMessages.isEmpty()
		}

		then: "Expect the messages to be received"
		receivedMessages.iterator().next() == "DELETED"
		and: "Expect the current time to be at least 300ms greater than the start time"
		System.currentTimeMillis() - startTime >= 300L
	}

	def "when setting a timed websocket binary message it should be fire at the specified time"() {
		given: "A WebSocket expectation"
		server.expect().get().withPath("/api/v1/users/watch")
				.andUpgradeToWebSocket()
				.open()
				// Using WebSocketMessage to be able to send byte[] directly
				// delay must be set in the WebSocketMessage instance too, else the server ignores it
				.waitFor(300).andEmit(new WebSocketMessage(300, [1, 2, 3] as byte[], true))
				.done()
				.once()
		and: "The current time"
		def startTime = System.currentTimeMillis()
		and: "A list to store the received messages"
		def receivedMessages = new ConcurrentLinkedQueue<byte[]>()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
		and: "A WebSocket listener"
		wsReq.onSuccess { ws ->
			ws.binaryMessageHandler { buffer ->
				receivedMessages.add(buffer.getBytes(0, buffer.length()))
			}
			ws.closeHandler { _ ->
				ws.close()
			}
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert !receivedMessages.isEmpty()
		}

		then: "Expect the messages to be received"
		receivedMessages.iterator().next() == [1, 2, 3] as byte[]
		and: "Expect the current time to be at least 300ms greater than the start time"
		System.currentTimeMillis() - startTime >= 300
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
		and: "A list to store the received messages"
		def receivedMessages = new ConcurrentLinkedQueue<String>()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
		and: "A WebSocket listener"
		wsReq.onSuccess { ws ->
			ws.textMessageHandler { text ->
				receivedMessages.add(text)
			}
			ws.writeTextMessage("create root")
			ws.writeTextMessage("delete root")
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert receivedMessages.size() == 2
		}

		then: "Expect the messages to be received"
		receivedMessages.poll() == "CREATED"
		receivedMessages.poll() == "DELETED"
	}

	def "when receiving an unexpected websocket message it should close the connection with status code 1002"() {
		given: "A WebSocket expectation"
		server.expect().get().withPath("/api/v1/users/watch")
				.andUpgradeToWebSocket()
				.open()
				.expect("expected message").andEmit("MESSAGE OK").once()
				.done()
				.once()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
		and: "A WebSocket listener"
		wsReq.onSuccess { ws ->
			ws.writeTextMessage("unexpected message")
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert wsReq.isComplete()
			assert wsReq.result() != null
			assert wsReq.result().closeStatusCode() != null
		}

		then: "Expect the close code to be 1002"
		wsReq.result().closeStatusCode() == 1002
		and: "Expect the close reason to be 'Unexpected message:unexpected message'"
		wsReq.result().closeReason() == "Unexpected message:unexpected message"
	}

	def "when setting a delayed response it should be delayed for the specified duration"() {
		given: "An expectation with delay"
		server.expect().get().withPath("/api/v1/users")
				.delay(100, TimeUnit.MILLISECONDS)
				.andReturn(200, "admin")
				.once()
		and: "The current time"
		def startTime = System.currentTimeMillis()
		and: "A request"
		def req1 = client.get(server.port, server.getHostName(), "/api/v1/users").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert req1.isComplete()
		}

		then: "Expect the response to match the expectation"
		req1.result().statusCode() == 200
		req1.result().body().toString() == "admin"
		and: "Expect the current time to be at least 100ms greater than the start time"
		System.currentTimeMillis() - startTime >= 100
	}

	def "when using a body provider it should work as for static responses"() {
		given: "A counter"
		def counter = new AtomicInteger(0)
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request are completed"
		conditions.eventually {
			assert req1.isComplete()
			assert req2.isComplete()
		}

		then: "Expect the responses to match the expectations"
		req1.result().statusCode() == 200
		req1.result().body().toString() == "admin-0"
		req2.result().statusCode() == 200
		req2.result().body().toString() == "admin-1"
	}

	def "when using a response provider it should work as for static responses"() {
		given: "An expectation with response provider"
		server.expect().get().withPath("/api/v1/users")
				.andReply(new ResponseProvider<Object>() {
					def counter = new AtomicInteger(0)
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The requests are completed"
		conditions.eventually {
			assert req1.isComplete()
			assert req2.isComplete()
		}

		then: "Expect the responses to match the expectations"
		req1.result().statusCode() == 200
		req1.result().body().toString() == "admin-1"
		req1.result().headers().get("Count") == "1"
		req2.result().statusCode() == 200
		req2.result().body().toString() == "admin-2"
		req2.result().headers().get("Count") == "2"
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
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert req1.isComplete()
		}

		then: "Expect the response to match the expectation"
		req1.result().statusCode() == 200
		req1.result().body().toString() == "admin"
		req1.result().headers().get("test") == "header"
		req1.result().headers().get("test2") == "header2"
	}

	def "when setting an HttpRequest/Response websocket message it should be fired when the event is triggered"() {
		given: "A WebSocket + HTTP expectation"
		server.expect().get().withPath("/api/v1/users/watch")
				.andUpgradeToWebSocket()
				.open()
				.expectHttpRequest("/api/v1/create").andEmit("CREATED").once()
				.expectHttpRequest("/api/v1/delete").andEmit("DELETED").once()
				.done()
				.once()
		and: "A list to store the received messages"
		def receivedMessages = new ConcurrentLinkedQueue<String>()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
		and: "A WebSocket listener"
		wsReq.onSuccess { ws ->
			ws.textMessageHandler { text ->
				receivedMessages.add(text)
			}
		}
		and: "HTTP requests after WS connection initiated"
		wsReq.onSuccess { ws ->
			client.get(server.port, server.getHostName(), "/api/v1/create").send()
					.compose { _ -> client.get(server.port, server.getHostName(), "/api/v1/delete").send() }
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert receivedMessages.size() == 2
		}

		then: "Expect the messages to be received"
		receivedMessages.poll() == "CREATED"
		receivedMessages.poll() == "DELETED"
	}

	def "when setting an sentWebSocketMessage it should be fired when the server sends the expected message"() {
		given: "A WebSocket + HTTP expectation"
		server.expect().get().withPath("/api/v1/users/watch")
				.andUpgradeToWebSocket()
				.open()
				.waitFor(60L).andEmit("READY")
				.expectHttpRequest("/api/v1/create").andEmit("CREATED").once()
				.expectSentWebSocketMessage("CREATED").andEmit("WS-CREATED").once()
				.done()
				.once()
		and: "A list to store the received messages"
		def receivedMessages = new ConcurrentLinkedQueue<String>()
		and: "A WebSocket request"
		def wsReq = wsClient.webSocket().connect(server.port, server.getHostName(), "/api/v1/users/watch")
		and: "A WebSocket listener that sends an HTTP request after WS connection initiated"
		wsReq.onSuccess { ws ->
			ws.textMessageHandler { text ->
				if (text == "READY") {
					client.get(server.port, server.getHostName(), "/api/v1/create").send()
				} else {
					receivedMessages.add(text)
				}
			}
		}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert receivedMessages.size() == 2
		}

		then: "Expect the messages to be received"
		receivedMessages.poll() == "CREATED"
		receivedMessages.poll() == "WS-CREATED"
	}

	def "when setting a chunked response it should be sent in chunks"() {
		given: "An expectation with chunked response"
		server.expect().get().withPath("/api/v1/chunked-response")
				.andReturnChunked(200, "A response that should be sent in chunks")
				.always()
		and: "A request"
		def request = client.get(server.port, server.getHostName(), "/api/v1/chunked-response").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert request.isComplete()
		}

		then: "Expect the response to match the expectation"
		request.result().statusCode() == 200
		request.result().body().toString() == "28\r\nA response that should be sent in chunks\r\n0\r\n"
		request.result().headers().get("Transfer-Encoding") == "chunked"
	}
}
