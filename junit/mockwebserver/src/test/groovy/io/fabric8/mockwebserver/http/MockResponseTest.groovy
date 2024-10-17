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
import java.time.Duration
import java.util.concurrent.TimeUnit
import spock.lang.Specification

class MockResponseTest extends Specification {

	def "getStatus returns HTTP status line"(int code, String expected) {
		expect:
		new MockResponse().setResponseCode(code).getStatus() == expected
		where:
		code | expected
		100  | "HTTP/1.1 100 Informational"
		101  | "HTTP/1.1 101 Switching protocols"
		200  | "HTTP/1.1 200 OK"
		300  | "HTTP/1.1 300 Redirection"
		400  | "HTTP/1.1 400 Client Error"
		500  | "HTTP/1.1 500 Server Error"
		999  | "HTTP/1.1 999 Mock Response"
	}

	def "setBody(String) sets body"() {
		when:
		def response = new MockResponse().setBody("Hello, world!")
		then:
		response.getBody().readUtf8() == "Hello, world!"
	}

	def "setBody(byte[]) sets body"() {
		when:
		def response = new MockResponse().setBody("Hello, world!".getBytes(StandardCharsets.UTF_8))
		then:
		response.getBody().readUtf8() == "Hello, world!"
	}

	def "setChunkedBody sets the response body chunked every maxChunkSize bytes"() {
		when:
		def response = new MockResponse()
				.addHeader("Content-Length", "1337")
				.setChunkedBody("This is a long chunked body", 16)
		then:
		response.header("Transfer-Encoding") == "chunked"
		response.getBody().readUtf8() == "10\r\nThis is a long c\r\nb\r\nhunked body\r\n0\r\n"
	}

	def "setChunkedBody sets the response body chunked and removes Content-Length header"() {
		when:
		def response = new MockResponse()
				.addHeader("Content-Length", "1337")
				.setChunkedBody("This is a long chunked body", 5)
		then:
		response.header("Content-Length") == null
	}

	def "setHttpVersion sets the HTTP version"() {
		when:
		def response = new MockResponse().setHttpVersion("HTTP/2")
		then:
		assert response.getStatus().startsWith("HTTP/2")
	}

	def "setBodyDelay sets body delay"() {
		when:
		def response = new MockResponse().setBodyDelay(1000, TimeUnit.MILLISECONDS)
		then:
		response.getBodyDelay() == Duration.ofSeconds(1)
	}

	def "clearHeaders removes all headers"() {
		given:
		def response = new MockResponse()
				.addHeader("Content-Type", "text/plain")
				.addHeader("Content-Length", "1337")
		when:
		response.clearHeaders()
		then:
		assert response.getHeaders().toMultimap().isEmpty()
	}

	def "addHeader(String, Object) adds a header"() {
		when:
		def response = new MockResponse().addHeader("Content-Type", "text/plain")
		then:
		response.header("Content-Type") == "text/plain"
	}

	def "addHeader(String) adds a header"() {
		when:
		def response = new MockResponse().addHeader("Content-Type:text/plain")
		then:
		response.header("Content-Type") == "text/plain"
	}

	def "setHeader replaces a header"() {
		given:
		def response = new MockResponse().addHeader("Content-Type", "text/plain")
		when:
		response.setHeader("Content-Type", "text/html")
		then:
		response.header("Content-Type") == "text/html"
	}

	def "setHeaders replaces all headers"() {
		given:
		def response = new MockResponse().addHeader("Content-Type", "text/plain")
		when:
		response.setHeaders(Headers.builder().add("Content-Type", "text/html").add("Accept:text/plain").build())
		then:
		response.header("Content-Type") == "text/html"
		response.header("Accept") == "text/plain"
	}

	def "withWebsocketUpgrade sets a WebSocketListener"() {
		when:
		def response = new MockResponse()
				.setBody("Will be cleared")
				.withWebSocketUpgrade(new WebSocketListener() {})
		then:
		response.getWebSocketListener() != null
	}

	def "withWebsocketUpgrade clears the body"() {
		when:
		def response = new MockResponse()
				.setBody("Will be cleared")
				.withWebSocketUpgrade(new WebSocketListener() {})
		then:
		response.getBody() == null
	}
}
