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
package io.fabric8.mockwebserver.internal

import io.fabric8.mockwebserver.http.Response
import io.fabric8.mockwebserver.http.WebSocket
import spock.lang.Specification

class WebSocketSessionTest extends Specification {

	def "onOpen after shutdown does not propagate RejectedExecutionException"() {
		given: "A WebSocketSession with open messages whose executor has already been shut down"
		def open = [
			new WebSocketMessage(0L, "hello", true)
		]
		def session = new WebSocketSession(open, null, null)
		session.shutdown()
		def ws = Mock(WebSocket)
		def response = Mock(Response)

		when: "onOpen is invoked after the executor was shut down (race window between in-flight WebSocket upgrade and MockWebServer.shutdown())"
		session.onOpen(ws, response)

		then: "No exception is propagated to the caller (Vert.x event loop)"
		noExceptionThrown()
	}
}
