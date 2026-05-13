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
package io.fabric8.mockwebserver.vertx

import io.fabric8.mockwebserver.dsl.HttpMethod
import io.fabric8.mockwebserver.http.Headers
import io.fabric8.mockwebserver.http.RecordedRequest
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.ServerWebSocket
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class VertxMockWebSocketTest extends Specification {

	def "request returns the RecordedRequest"() {
		given:
		def recordedRequest = new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/", Headers.builder().build(), null)
		def serverSocket = new VertxMockWebSocket(recordedRequest, null)
		when:
		def result = serverSocket.request()
		then:
		result == recordedRequest
	}

	def "send(String) blocks until the underlying writeTextMessage Future completes (#7775)"() {
		given: "A ServerWebSocket whose writeTextMessage Future is pending"
		Promise<Void> promise = Promise.promise()
		ServerWebSocket vertxWs = Mock(ServerWebSocket) {
			writeTextMessage(_ as String) >> promise.future()
		}
		def mockWebSocket = new VertxMockWebSocket(null, vertxWs)

		and: "send is invoked from a background thread"
		def returned = new CompletableFuture<Boolean>()
		def thread = Thread.start { returned.complete(mockWebSocket.send("hello")) }

		when: "the background thread parks waiting for the write Future"
		new PollingConditions(timeout: 5).eventually {
			// TIMED_WAITING means send blocked inside Future.get(timeout); TERMINATED
			// would mean send returned and the thread exited (the pre-fix bug).
			assert thread.state == Thread.State.TIMED_WAITING
		}

		then: "send has not returned"
		!returned.isDone()

		when: "the Future is completed successfully"
		promise.complete()

		then: "send returns true"
		returned.get(5, TimeUnit.SECONDS)
	}

	def "send(byte[]) blocks until the underlying writeBinaryMessage Future completes (#7775)"() {
		given: "A ServerWebSocket whose writeBinaryMessage Future is pending"
		Promise<Void> promise = Promise.promise()
		ServerWebSocket vertxWs = Mock(ServerWebSocket) {
			writeBinaryMessage(_ as Buffer) >> promise.future()
		}
		def mockWebSocket = new VertxMockWebSocket(null, vertxWs)

		and: "send is invoked from a background thread"
		def returned = new CompletableFuture<Boolean>()
		def thread = Thread.start { returned.complete(mockWebSocket.send([1, 2, 3] as byte[])) }

		when: "the background thread parks waiting for the write Future"
		new PollingConditions(timeout: 5).eventually {
			assert thread.state == Thread.State.TIMED_WAITING
		}

		then: "send has not returned"
		!returned.isDone()

		when: "the Future is completed successfully"
		promise.complete()

		then: "send returns true"
		returned.get(5, TimeUnit.SECONDS)
	}

	def "send(String) returns immediately when the writeTextMessage Future is already complete"() {
		given:
		ServerWebSocket vertxWs = Mock(ServerWebSocket) {
			writeTextMessage(_ as String) >> Future.succeededFuture()
		}
		def mockWebSocket = new VertxMockWebSocket(null, vertxWs)

		expect:
		mockWebSocket.send("hello")
	}
}
