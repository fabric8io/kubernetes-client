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

class HttpUrlTest extends Specification {

	def "encodedPath should returns the entire path of this URL encoded for use in HTTP resource resolution"(String url, String expectedPath) {
		expect:
		HttpUrl.parse(url).encodedPath() == expectedPath
		where:
		url | expectedPath
		"https://example.com" | "/"
		"https://example.com/a" | "/a"
		"https://example.com/a%20b" | "/a%20b"
		"https://example.com/a%20b?c=d" | "/a%20b"
		"https://example.com/a%20b#c" | "/a%20b"
		"https://example.com/a/b" | "/a/b"
		"https://example.com/a/b%20c/d" | "/a/b%20c/d"
	}

	def "queryParameter should return the first value for the query parameter"(String url, String name, String expectedValue) {
		expect:
		HttpUrl.parse(url).queryParameter(name) == expectedValue
		where:
		url | name | expectedValue
		"https://example.com" | "a" | null
		"https://example.com?a=b" | "a" | "b"
		"https://example.com?a=b&a=c" | "a" | "b"
		"https://example.com?a=b&c=d" | "c" | "d"
		"https://example.com?a=b&c=d&a=e" | "a" | "b"
		"https://example.com?a=b&c=d&a=e" | "c" | "d"
		"https://example.com?a=b&c=d&a=e" | "d" | null
	}

	def "toString should return the URL as a string"(String url) {
		expect:
		HttpUrl.parse(url).toString() == url
		where:
		url | _
		"https://example.com" | _
		"https://example.com/" | _
		"https://example.com/a" | _
		"https://example.com/a%20b" | _
		"https://example.com/a%20b?c=d" | _
		"https://example.com/a%20b#c" | _
		"https://example.com/a/b" | _
		"https://example.com/a/b%20c/d" | _
	}

	def "fromUrl with invalid URL should throw IllegalArgumentException"() {
		when:
		HttpUrl.fromUrl(new URL("https://user%@example.com/invalid"))
		then:
		def exception = thrown(IllegalArgumentException)
		exception.message == "Invalid URL: https://user%@example.com/invalid"
	}

	def "parse with invalid URL should throw IllegalArgumentException"() {
		when:
		HttpUrl.parse("example.com/invalid")
		then:
		def exception = thrown(IllegalArgumentException)
		exception.message == "Invalid URL: example.com/invalid"
	}
}
