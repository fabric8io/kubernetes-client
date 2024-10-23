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
package io.fabric8.mockwebserver.http

import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class QueueDispatcherTest extends Specification {

	def "dispatch with queued response returns the response"() {
		given:
		def dispatcher = new QueueDispatcher()
		def response = new MockResponse().setResponseCode(200).setBody("the response body")
		dispatcher.enqueueResponse(response)
		when:
		def actual = dispatcher.dispatch(null)
		then:
		actual == response
	}

	def "dispatch with failFastResponse and empty queue returns 404"() {
		given:
		def dispatcher = new QueueDispatcher()
				.setFailFastResponse(new MockResponse().setResponseCode(404))
		when:
		def result = dispatcher.dispatch(null)
		then:
		result.code() == 404
	}

	def "dispatch with empty queue and interrupted throws InterruptedException"() {
		given:
		def conditions = new PollingConditions(timeout: 10)
		def dispatcher = new QueueDispatcher()
		Exception exception
		when:
		def thread = new Thread({
			try {
				dispatcher.dispatch(null)
			} catch (Exception e) {
				exception = e
			}
		})
		thread.start()
		thread.interrupt()
		then:
		conditions.eventually {
			assert exception != null
		}
		exception instanceof IllegalStateException
		exception.message == "Interrupted while waiting for response"
	}

	def "shutdown enqueues a dead letter response"() {
		given:
		def dispatcher = new QueueDispatcher()
		when:
		dispatcher.shutdown()
		then:
		dispatcher.dispatch(null).code() == 503
	}

	def "dispatch re-enqueues the dead letter after shutdown"() {
		given:
		def dispatcher = new QueueDispatcher()
		when:
		dispatcher.shutdown()
		then:
		[503, 503] == [
			dispatcher.dispatch(null).code(),
			dispatcher.dispatch(null).code()
		]
	}
}
