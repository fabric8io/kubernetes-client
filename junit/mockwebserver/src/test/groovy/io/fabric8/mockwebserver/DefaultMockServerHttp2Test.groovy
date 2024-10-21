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

import io.vertx.core.Vertx
import io.vertx.core.http.HttpVersion
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class DefaultMockServerHttp2Test extends Specification {

	@Shared
	static def vertx = Vertx.vertx()
	DefaultMockServer server
	WebClient client

	def setup() {
		server = new DefaultMockServer(false)
		server.start()
		client = WebClient.create(vertx, new WebClientOptions()
				.setUseAlpn(true)
				.setProtocolVersion(HttpVersion.HTTP_2))
	}

	def "GET /, with no expectations, should return 404"() {
		given: "An HTTP request to /"
		def request = client.get(server.port, server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert request.isComplete()
		}

		then: "The response has status code 404"
		request.result().statusCode() == 404
		request.result().body() == null
	}

	def "getLastRequest, after request, should return h2 protocol"() {
		given: "An HTTP request to /"
		def request = client.get(server.port, server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert request.isComplete()
		}

		then: "The http version is H2"
		server.getLastRequest().getHttpVersion() == "H2"
	}
}
