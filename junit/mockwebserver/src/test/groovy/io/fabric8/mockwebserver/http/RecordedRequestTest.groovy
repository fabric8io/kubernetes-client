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

import io.fabric8.mockwebserver.dsl.HttpMethod
import spock.lang.Specification

class RecordedRequestTest extends Specification {

	def "getRequestLine returns HTTP request line"(String httpVersion, HttpMethod method, String path, String expected) {
		expect:
		new RecordedRequest(httpVersion, method, path, Headers.builder().build(), new Buffer()).getRequestLine() == expected
		where:
		httpVersion | method | path | expected
		"HTTP/1.1"  | HttpMethod.GET | "/foo" | "GET /foo HTTP/1.1"
		"HTTP/1.1"  | HttpMethod.POST | "/bar" | "POST /bar HTTP/1.1"
		"HTTP/1.0"  | HttpMethod.PUT | "/baz" | "PUT /baz HTTP/1.0"
		"HTTP/2"    | HttpMethod.DELETE | "/qux" | "DELETE /qux HTTP/2"
		"HTTP/1.1"  | HttpMethod.PATCH | "/quux" | "PATCH /quux HTTP/1.1"
		"HTTP/1.1"  | HttpMethod.CONNECT | "/" | "CONNECT / HTTP/1.1"
		"HTTP/1.1"  | HttpMethod.OPTIONS | "/foo/bar" | "OPTIONS /foo/bar HTTP/1.1"
	}

	def "getPath returns path"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().build(), new Buffer())
				.getPath() == "/foo"
	}

	def "method returns method as String"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().build(), new Buffer())
				.method() == HttpMethod.GET
	}

	def "getMethod returns method as String"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().build(), new Buffer())
				.getMethod() == "GET"
	}

	def "getHttpVersion returns HTTP version"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().build(), new Buffer())
				.getHttpVersion() == "HTTP/1.1"
	}

	def "getUtf8Body returns body as UTF-8 string"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().build(), new Buffer().writeUtf8("Hello, world!"))
				.getUtf8Body() == "Hello, world!"
	}

	def "getUtf8Body with null returns null"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().build(), null)
				.getUtf8Body() == null
	}

	def "getHeaders returns headers"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().add("foo", "bar").build(), new Buffer())
				.getHeaders().get("foo") == "bar"
	}

	def "getHeader returns header"() {
		expect:
		new RecordedRequest("HTTP/1.1", HttpMethod.GET, "/foo", Headers.builder().add("foo", "bar").build(), new Buffer())
				.getHeader("foo") == "bar"
	}

	def "getMethod from requestLine returns method"() {
		expect:
		new RecordedRequest("GET /foo HTTP/1.1", Headers.builder().build(), [], 0L, new Buffer(), 0, null)
		.getMethod() == "GET"
	}

	def "getPath from requestLine returns path"() {
		expect:
		new RecordedRequest("GET /foo HTTP/1.1", Headers.builder().build(), [], 0L, new Buffer(), 0, null)
		.getPath() == "/foo"
	}
}
