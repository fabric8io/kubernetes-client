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
package io.fabric8.mockwebserver.crud

import io.fabric8.mockwebserver.Context
import io.fabric8.mockwebserver.DefaultMockServer
import io.fabric8.mockwebserver.MockWebServer
import io.fabric8.mockwebserver.ServerRequest
import io.fabric8.mockwebserver.ServerResponse
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.WebClient
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class CrudDispatcherTest extends Specification {

	@Shared
	static def vertx = Vertx.vertx()

	DefaultMockServer server

	WebClient client

	def setup() {
		var context = new Context();
		server = new DefaultMockServer(context, new MockWebServer(), new HashMap<ServerRequest, Queue<ServerResponse>>(),
				new CrudDispatcher(context, new CrudDispatcherTestAttributeExtractor(), new CrudDispatcherTestComposer()), false)
		server.start()
		client = WebClient.create(vertx)
	}

	def cleanup() {
		server.shutdown()
		client.close()
	}

	def "should be able to get after a patch"() {
		given: "A POST request with a starting object"
		var postNew = client.post(server.port, server.hostName, "/namespace/test/name/one")
				.putHeader("Content-Type", "application/json")
				.sendBuffer(Buffer.buffer("""{"foo":{"bar":"startingValue","baz":"keepThis"} }"""))
		and: "A PATCH request to update the object"
		var patch = postNew.compose { _ ->
			client
					.patch(server.port, server.hostName, "/namespace/test/name/one")
					.putHeader("Content-Type", "application/strategic-merge-patch+json")
					.sendBuffer(Buffer.buffer("""[{"op":"replace","path":"/foo/bar","value":"canary"}]"""))
		}
		and: "A GET request to retrieve and verify the object"
		var get = patch.compose { _ ->
			client.get(server.port, server.hostName, "/namespace/test/name/one").send()
		}
		and: "An instance of AsyncConditions"
		def async = new AsyncConditions(1)

		when: "The requests are sent and completed"
		get.onComplete { res ->
			async.evaluate {
				assert res.result().statusCode() == 200
				assert res.result().body().toString() == """{"foo":{"bar":"canary","baz":"keepThis"}}"""
			}
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}

	def "should be able to get after a post"() {
		given: "A POST request with a starting object"
		var postNew = client.post(server.port, server.hostName, "/namespace/test/name/one")
				.putHeader("Content-Type", "text/html")
				.sendBuffer(Buffer.buffer("one"))
		and: "A GET request to retrieve and verify the object"
		var get = postNew.compose { _ ->
			client.get(server.port, server.hostName, "/namespace/test/name/one").send()
		}
		and: "An instance of AsyncConditions"
		def async = new AsyncConditions(1)

		when: "The requests are sent and completed"
		get.onComplete { res ->
			async.evaluate {
				assert res.result().statusCode() == 200
				assert res.result().body().toString() == "one"
			}
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}

	def "should be able to delete after a post"() {
		given: "A POST request with a starting object"
		var postNew = client.post(server.port, server.hostName, "/namespace/test/name/one")
				.putHeader("Content-Type", "text/html")
				.sendBuffer(Buffer.buffer("one"))
		and: "A DELETE request to delete the object"
		var delete = postNew.compose { _ ->
			client.delete(server.port, server.hostName, "/namespace/test/name/one").send()
		}
		and: "A GET request to retrieve and verify the object"
		var get = delete.compose { _ ->
			client.get(server.port, server.hostName, "/namespace/test/name/one").send()
		}
		and: "An instance of AsyncConditions"
		def async = new AsyncConditions(1)

		when: "The requests are sent and completed"
		get.onComplete { res ->
			async.evaluate {
				assert res.result().statusCode() == 404
			}
		}

		then: "Expect the result to be completed in the specified time"
		async.await(10)
	}

	private static final class CrudDispatcherTestAttributeExtractor implements AttributeExtractor {

		@Override
		AttributeSet fromPath(String path) {
			var set = new AttributeSet()
			var parts = path.split("/")
			if (parts.length > 2) {
				set.add(new Attribute("namespace", parts[2]))
			} else if (parts.length > 4) {
				set.add(new Attribute("name", parts[4]))
			}
			return set
		}

		@Override
		AttributeSet fromResource(String resource) {
			return null
		}
	}

	private static final class CrudDispatcherTestComposer implements ResponseComposer {
		@Override
		String compose(Collection<String> items) {
			StringBuilder sb = new StringBuilder();
			for (String item : items) {
				sb.append(item).append(" ")
			}
			return sb.toString().trim()
		}
	}
}
