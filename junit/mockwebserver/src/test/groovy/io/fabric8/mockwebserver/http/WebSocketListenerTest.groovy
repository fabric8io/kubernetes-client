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

import java.nio.charset.StandardCharsets
import spock.lang.Specification

class WebSocketListenerTest extends Specification {

	def "onMessage(WebSocket,byte[]) calls deprecated onMessage(WebSocket,ByteString) method"() {
		given:
		String message
		def listener = new WebSocketListener(){
					@Override
					void onMessage(WebSocket webSocket, ByteString bytes) {
						message = bytes.utf8()
					}
				}
		when:
		listener.onMessage(null, "Hello, world!".getBytes(StandardCharsets.UTF_8))
		then:
		message == "Hello, world!"
	}
}
