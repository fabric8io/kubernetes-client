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

import io.fabric8.mockwebserver.MockWebServer
import io.fabric8.mockwebserver.http.MockResponse
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.WebClient
import java.time.Duration
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class HttpServerRequestHandlerTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()
	WebClient client
	MockWebServer server

	def setup() {
		client = WebClient.create(vertx)
		server = new MockWebServer()
		server.start()
	}

	def cleanup() {
		server.shutdown()
		client.close()
	}

	def cleanupSpec() {
		vertx.close()
	}

	def "reads headers from the client request"() {
		given: "A request"
		def req = client.get(server.getPort(), server.getHostName(), "/")
		and: "headers added to the request"
		req.headers().set("a-header", "a-value")
		and: "An enqueued response"
		server.enqueue(new MockResponse().setResponseCode(200))
		and: "the request is sent"
		def requestFuture = req.send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when:
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then:
		server.takeRequest().getHeader("a-header") == "a-value"
	}

	def "reads body from the client request"() {
		given: "A request"
		def req = client.get(server.getPort(), server.getHostName(), "/")
		and: "An enqueued response"
		server.enqueue(new MockResponse().setResponseCode(200))
		and: "the request is sent"
		def requestFuture = req.sendBuffer(Buffer.buffer([1, 2, 3] as byte[]))
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when:
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then:
		server.takeRequest().getBody().readByteArray() == [1, 2, 3] as byte[]
	}

	def "sends body to the client"() {
		given: "An enqueued response with body"
		server.enqueue(new MockResponse().setResponseCode(200).setBody("the-body"))
		and: "A request is sent"
		def requestFuture = client.get(server.getPort(), server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when:
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then:
		requestFuture.result().getHeader("content-length") == "8"
		requestFuture.result().bodyAsString() == "the-body"
	}

	def "sends body to the client with delay"() {
		given: "An enqueued response with body and delay of 300ms"
		server.enqueue(new MockResponse().setBodyDelay(Duration.ofMillis(300L)).setResponseCode(200).setBody("the-body"))
		and: "The current time"
		def startTime = System.currentTimeMillis()
		and: "A request is sent"
		def requestFuture = client.get(server.getPort(), server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when:
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then:
		requestFuture.result().getHeader("content-length") == "8"
		requestFuture.result().bodyAsString() == "the-body"
		and: "Expect the current time to be at least 300ms greater than the start time"
		System.currentTimeMillis() - startTime >= 300L
	}
}
