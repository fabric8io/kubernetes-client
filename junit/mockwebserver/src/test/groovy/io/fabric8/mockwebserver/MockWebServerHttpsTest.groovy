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
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.ext.web.client.impl.ClientPhase
import io.vertx.ext.web.client.impl.WebClientInternal
import java.security.cert.Certificate
import java.security.cert.X509Certificate
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class MockWebServerHttpsTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()
	WebClient client
	MockWebServer server

	def setup() {
		client = WebClient.create(vertx, new WebClientOptions().setSsl(true).setTrustAll(true))
		server = new MockWebServer()
		server.useHttps()
		server.start()
	}

	def cleanup() {
		server.shutdown()
		client.close()
	}

	def cleanupSpec() {
		vertx.close()
	}

	def "uses a self-signed certificate"() {
		given: "An enqueued response"
		server.enqueue(new MockResponse().setResponseCode(200))
		and: "An empty list of peer certificates"
		def peerCertificates = new ArrayList<Certificate>()
		and: "A connection handler"
		((WebClientInternal) client).addInterceptor { ctx ->
			if (ctx.phase() == ClientPhase.RECEIVE_RESPONSE) {
				peerCertificates.addAll(ctx.clientResponse().request().connection().peerCertificates())
			}
			ctx.next()
		}
		and: "An HTTPS request"
		def request = client.get(server.port, server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert request.isComplete()
		}

		then: "The peer certificates match the server certificate"
		request.result().statusCode() == 200
		def cert = peerCertificates.iterator().next()
		assert cert instanceof X509Certificate
		((X509Certificate) cert).getSubjectDN().getName() == "CN=${server.getHostName()}"
	}
}
