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
import io.fabric8.mockwebserver.http.RecordedRequest
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import java.util.concurrent.TimeUnit
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class MockWebServerTest extends Specification {

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

	def "url, should return a valid URL"() {
		when:
		def result = server.url("/")

		then:
		//noinspection HttpUrlsUsage
		assert result.toString() == "http://${server.getHostName()}:${server.getPort()}/"
	}

	def "getRequestCount, with no requests, should return 0"() {
		when:
		def result = server.getRequestCount()

		then:
		assert result == 0
	}

	def "getRequestCount, with multiple, should return valid request count"() {
		given:
		server.enqueue(new MockResponse().setResponseCode(200))
		server.enqueue(new MockResponse().setResponseCode(200))
		def all = Future.all(
				client.get(server.port, server.getHostName(), "/").send(),
				client.get(server.port, server.getHostName(), "/one").send()
				)
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent and completed"
		conditions.eventually {
			assert all.isComplete()
		}

		then: "Expect the result to be completed in the specified time"
		server.getRequestCount() == 2
	}

	def "takeRequest, with timeout and no requests, should return null and don't block -after timeout-"() {
		when:
		def result = server.takeRequest(1, TimeUnit.MICROSECONDS)

		then:
		assert result == null
	}

	def "takeRequest, should wait until request is received"() {
		given:
		def conditions = new PollingConditions(timeout: 10)
		RecordedRequest recordedRequest = null

		when:
		new Thread({
			recordedRequest = server.takeRequest()
		}).start()
		and:
		recordedRequest == null
		and:
		client.get(server.port, server.getHostName(), "/the-request").send()

		then:
		conditions.eventually {
			assert recordedRequest != null
		}
		recordedRequest.getPath() == "/the-request"
	}
}
