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

import io.fabric8.mockwebserver.crud.CrudDispatcher
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import okhttp3.mockwebserver.MockWebServer
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class DefaultMockServerCrudTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()
	WebClient client
	DefaultMockServer server

	def setup() {
		client = WebClient.create(vertx)
		server = new DefaultMockServer(new Context(), new MockWebServer(), new HashMap<>(),
				new CrudDispatcher(new Context(), new UserAttributeExtractor(), new JsonResponseComposer()), false)
		server.start()
	}

	def cleanup() {
		client.close()
		server.shutdown()
	}

	def cleanupSpec() {
		vertx.close()
	}

	def "GET /, with empty store, should return 404"() {
		given: "An HTTP request to /"
		def request = client.get(server.port, server.getHostName(), "/").send()
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is completed"
		conditions.eventually {
			assert request.isComplete()
		}

		then: "Expect the response to have status code 404"
		request.result().statusCode() == 404
		request.result().body() == null
	}

	def "POST /, with one item, should return item"() {
		given: "An HTTP request to /"
		def request = client.post(server.port, server.getHostName(), "/")
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent"
		def requestFuture = request.sendJson(new User(1L, "user", true))
		and: "completed"
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then: "The response contains the item"
		requestFuture.result().statusCode() == 202
		requestFuture.result().body().toString() == "{\"id\":1,\"username\":\"user\",\"enabled\":true}"
	}

	def "GET /, with multiple items, should return array"() {
		given: "An HTTP request to /"
		def request = client.get(server.port, server.getHostName(), "/")
		and: "Items in the server"
		def itemsInServer = client.post(server.port, server.getHostName(), "/")
				.sendJson(new User(1L, "user", true))
				.compose { _ ->
					client.post(server.port, server.getHostName(), "/")
							.sendJson(new User(2L, "user-2", true))
				}
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent after the initial items have been created"
		Future<HttpResponse<Buffer>> requestFuture
		itemsInServer.onComplete {isr ->
			requestFuture = request.send()
		}
		and: "completed"
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then: "Expect the response to contain the requested items"
		requestFuture.result().statusCode() == 200
		requestFuture.result().body().toString() == "[{\"id\":1,\"username\":\"user\",\"enabled\":true},{\"id\":2,\"username\":\"user-2\",\"enabled\":true}]"
	}

	def "GET /1, with existent item, should return item"() {
		given: "An HTTP request to /1"
		def request = client.get(server.port, server.getHostName(), "/1")
		and: "Items in the server"
		def itemsInServer = Future.all(
				client.post(server.port, server.getHostName(), "/")
				.sendJson(new User(1L, "user", true)),
				client.post(server.port, server.getHostName(), "/")
				.sendJson(new User(2L, "user-2", true))
				)
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent after the initial items have been created"
		Future<HttpResponse<Buffer>> requestFuture
		itemsInServer.onComplete {isr ->
			requestFuture = request.send()
		}
		and: "completed"
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then: "Expect the response to contain the requested item"
		requestFuture.result().statusCode() == 200
		requestFuture.result().body().toString() == "{\"id\":1,\"username\":\"user\",\"enabled\":true}"
	}

	def "PUT /1, with missing item, should create item"() {
		given: "An HTTP request to /1"
		def request = client.put(server.port, server.getHostName(), "/1")
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent with one JSON item"
		def requestFuture = request.sendJson(new User(1L, "user-replaced", true))
		and: "completed"
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then: "Expect the response to contain the created item"
		requestFuture.result().statusCode() == 201
		requestFuture.result().body().toString() == "{\"id\":1,\"username\":\"user-replaced\",\"enabled\":true}"
	}

	def "PUT /1, with existent item, should replace item"() {
		given: "An HTTP request to /1"
		def request = client.put(server.port, server.getHostName(), "/1")
		and: "Items in the server"
		def itemsInServer = Future.all(
				client.post(server.port, server.getHostName(), "/")
				.sendJson(new User(1L, "user", true)),
				client.post(server.port, server.getHostName(), "/")
				.sendJson(new User(2L, "user-2", true))
				)
		and: "An instance of PollingConditions"
		def conditions = new PollingConditions(timeout: 10)

		when: "The request is sent with one JSON item after the initial items have been created"
		Future<HttpResponse<Buffer>> requestFuture
		itemsInServer.onComplete { isr ->
			requestFuture = request.sendJson(new User(1L, "user-replaced", true))
		}
		and: "completed"
		conditions.eventually {
			assert requestFuture.isComplete()
		}

		then: "Expect the response to contain the replaced item"
		requestFuture.result().statusCode() == 202
		requestFuture.result().body().toString() == "{\"id\":1,\"username\":\"user-replaced\",\"enabled\":true}"
	}
}
