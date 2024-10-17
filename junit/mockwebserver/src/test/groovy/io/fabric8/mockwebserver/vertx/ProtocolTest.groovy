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
package io.fabric8.mockwebserver.vertx

import io.vertx.core.http.HttpVersion
import spock.lang.Specification

class ProtocolTest extends Specification {

	def "get should parse the right protocol HttpVersion"(String protocol, HttpVersion expectedVersion) {
		expect:
		Protocol.get(protocol).getHttpVersion() == expectedVersion
		where:
		protocol | expectedVersion
		"HTTP/1.0" | HttpVersion.HTTP_1_0
		"HTTP/1.1" | HttpVersion.HTTP_1_1
		"h2" | HttpVersion.HTTP_2
		"h2_prior_knowledge" | HttpVersion.HTTP_2
		"h2c" | HttpVersion.HTTP_2
		"HTTP/2.0" | HttpVersion.HTTP_2
	}

	def "get with invalid ALPN identifier or handled alternative should throw an exception"() {
		when:
		Protocol.get("HTTP/1.33.7")
		then:
		def exception = thrown(IllegalArgumentException)
		exception.message == "Unknown protocol: HTTP/1.33.7"
	}
}
