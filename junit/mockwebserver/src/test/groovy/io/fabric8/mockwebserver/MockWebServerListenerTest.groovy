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
import io.fabric8.mockwebserver.http.RecordedHttpConnection
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class MockWebServerListenerTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()
	WebClient client
	MockWebServer server

	def setup() {
		// Set keep alive to false to disable connection pooling and make connections evicted as requests are completed
		client = WebClient.create(vertx, new WebClientOptions().setKeepAlive(false))
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

	def "onConnection, propagates connection events to the listener"() {
		given: "A connection listener"
		RecordedHttpConnection recordedHttpConnection
		def connectionListener = new MockWebServerListener() {
					@Override
					void onConnection(RecordedHttpConnection connection) {
						recordedHttpConnection = connection
					}
				}
		and: "The connection listener is registered with the server"
		server.addListener(connectionListener)
		and: "A client request is sent"
		client.get(server.getPort(), server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The connection listener is invoked"
		conditions.eventually {
			assert recordedHttpConnection != null
		}

		then: "The recorded connection matchers the client request"
		recordedHttpConnection.getLocalAddress().port() == server.getPort()
	}

	def "onConnectionClosed, propagates connection events to the listener"() {
		given: "A connection listener"
		RecordedHttpConnection recordedHttpConnection
		def connectionListener = new MockWebServerListener() {
					@Override
					void onConnectionClosed(RecordedHttpConnection connection) {
						recordedHttpConnection = connection
					}
				}
		and: "The connection listener is registered with the server"
		server.addListener(connectionListener)
		and: "A response is enqueued so that the connection can get closed"
		server.enqueue(new MockResponse().setResponseCode(200))
		and: "A client request is sent"
		client.get(server.getPort(), server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The connection listener is invoked"
		conditions.eventually {
			assert recordedHttpConnection != null
		}

		then: "The recorded connection matchers the client request"
		recordedHttpConnection.getLocalAddress().port() == server.getPort()
	}
}
