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
import io.vertx.ext.web.client.WebClient
import spock.lang.Shared
import spock.lang.Specification
import spock.util.concurrent.AsyncConditions

class DefaultMockServerAnyMethodTest extends Specification {

  @Shared
  static def vertx = Vertx.vertx()

  DefaultMockServer server

  WebClient client

  def setup() {
    server = new DefaultMockServer()
    server.start()
    client = WebClient.create(vertx)
  }

  def cleanup() {
    server.shutdown()
    client.close()
  }

  def cleanupSpec() {
    vertx.close()
  }

  def "when setting an expectation for ANY should respond to POST"() {
    given: "An expectation with any"
      server.expect().any().withPath("/api/v1/resource").andReturn(200, "OK").always()
    and: "A POST request"
      def req1 = client.post(server.port, server.getHostName(), "/api/v1/resource")
        .send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      req1.onComplete { isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "OK"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }

  def "when setting an expectation for ANY should respond to PUT"() {
    given: "An expectation with any"
      server.expect().any().withPath("/api/v1/resource").andReturn(200, "OK").always()
    and: "A PUT request"
      def req1 = client.put(server.port, server.getHostName(), "/api/v1/resource")
        .send()
    and: "An instance of AsyncConditions"
      def async = new AsyncConditions(1)

    when: "The request is sent and completed"
      req1.onComplete { isr ->
        async.evaluate {
          assert req1.result().statusCode() == 200
          assert req1.result().body().toString() == "OK"
        }
      }

    then: "Expect the result to be completed in the specified time"
      async.await(10)
  }
}
