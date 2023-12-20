/**
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
import io.vertx.ext.web.client.WebClient
import okhttp3.mockwebserver.MockWebServer
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class DefaultMockServerCrudTest extends Specification {

  @Shared
  static def vertx = Vertx.vertx()
  @Shared
  static def client = WebClient.create(vertx)

  DefaultMockServer server

  def setup() {
    server = new DefaultMockServer(new Context(), new MockWebServer(), new HashMap<>(),
        new CrudDispatcher(new Context(), new UserAttributeExtractor(), new JsonResponseComposer()), false)
    server.start()
  }

  def cleanup() {
    server.shutdown()
  }

  def cleanupSpec() {
    client.close()
    vertx.close()
  }

  def "GET /, with empty store, should return 404"() {
    given: "An HTTP request to /"
     def request = client.get(server.port, server.getHostName(), "/")
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      request.send().onComplete { res ->
        async.evaluate {
          assert res.result().statusCode() == 404
          assert res.result().body() == null
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "POST /, with one item, should return item"() {
    given: "An HTTP request to /"
      def request = client.post(server.port, server.getHostName(), "/")
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent with one JSON item and completed"
      request.sendJson(new User(1L, "user", true)).onComplete { res ->
        async.evaluate {
          assert res.result().statusCode() == 202
          assert res.result().body().toString() == "{\"id\":1,\"username\":\"user\",\"enabled\":true}"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "GET /, with multiple items, should return array"() {
    given: "An HTTP request to /"
      def request = client.get(server.port, server.getHostName(), "/")
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)
    and: "Items in the server"
      def itemsInServer = Future.all(
        client.post(server.port, server.getHostName(), "/")
          .sendJson(new User(1L, "user", true)),
        client.post(server.port, server.getHostName(), "/")
          .sendJson(new User(2L, "user-2", true))
      )

    when: "The request is sent and completed"
      itemsInServer.onComplete {isr ->
        request.send().onComplete { res ->
          async.evaluate { assert res.result().statusCode() == 200
            assert res.result().body().toString() == "[{\"id\":1,\"username\":\"user\",\"enabled\":true},{\"id\":2,\"username\":\"user-2\",\"enabled\":true}]"
          }
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "GET /1, with existent item, should return item"() {
    given: "An HTTP request to /1"
      def request = client.get(server.port, server.getHostName(), "/1")
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)
    and: "Items in the server"
      def itemsInServer = Future.all(
        client.post(server.port, server.getHostName(), "/")
          .sendJson(new User(1L, "user", true)),
        client.post(server.port, server.getHostName(), "/")
          .sendJson(new User(2L, "user-2", true))
      )

    when: "The request is sent and completed"
      itemsInServer.onComplete {isr ->
        request.send().onComplete { res ->
          async.evaluate {
            assert res.result().statusCode() == 200
            assert res.result().body().toString() == "{\"id\":1,\"username\":\"user\",\"enabled\":true}"
          }
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "PUT /1, with missing item, should create item"() {
    given: "An HTTP request to /1"
      def request = client.put(server.port, server.getHostName(), "/1")
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)


    when: "The request is sent with one JSON item and completed"
      request.sendJson(new User(1L, "user-replaced", true)).onComplete { res ->
        async.evaluate {
          assert res.result().statusCode() == 201
          assert res.result().body().toString() == "{\"id\":1,\"username\":\"user-replaced\",\"enabled\":true}"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "PUT /1, with existent item, should replace item"() {
    given: "An HTTP request to /1"
      def request = client.put(server.port, server.getHostName(), "/1")
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)
    and: "Items in the server"
      def itemsInServer = Future.all(
        client.post(server.port, server.getHostName(), "/")
          .sendJson(new User(1L, "user", true)),
        client.post(server.port, server.getHostName(), "/")
          .sendJson(new User(2L, "user-2", true))
      )

    when: "The request is sent with one JSON item and completed"
      itemsInServer.onComplete { isr ->
        request.sendJson(new User(1L, "user-replaced", true)).onComplete { res ->
          async.evaluate {
            assert res.result().statusCode() == 202
            assert res.result().body().toString() == "{\"id\":1,\"username\":\"user-replaced\",\"enabled\":true}"
          }
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }
}
