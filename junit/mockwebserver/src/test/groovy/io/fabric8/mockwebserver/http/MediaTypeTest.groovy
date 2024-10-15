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

class MediaTypeTest extends Specification {

	def "parse gets type"() {
		when:
		def mediaType = MediaType.parse("text/plain;boundary=foo;charset=utf-8")
		then:
		assert mediaType.type() == "text"
	}

	def "parse gets subtype"() {
		when:
		def mediaType = MediaType.parse("text/plain;boundary=foo;charset=utf-8")
		then:
		assert mediaType.subtype() == "plain"
	}

	def "parse gets charset"() {
		when:
		def mediaType = MediaType.parse("text/plain;boundary=foo;charset=utf-8")
		then:
		assert mediaType.charset() == "utf-8"
	}

	def "parse gets charset quoted"() {
		when:
		def mediaType = MediaType.parse("text/plain;boundary=foo;charset=\"utf-8\"")
		then:
		assert mediaType.charset() == "utf-8"
	}

	def "parse gets charset single-quoted"() {
		when:
		def mediaType = MediaType.parse("text/plain;boundary=foo;charset='utf-8'")
		then:
		assert mediaType.charset() == "utf-8"
	}

	def "parse preserves mediaType"() {
		when:
		def mediaType = MediaType.parse("text/plain;boundary=foo;charset=utf-8")
		then:
		assert mediaType.toString() == "text/plain;boundary=foo;charset=utf-8"
	}

	def "parse with invalid returns null"() {
		when:
		def mediaType = MediaType.parse("text/plain;boundary=foo;charset")
		then:
		assert mediaType == null
	}

	def "get with invalid subtype throws IllegalArgumentException"() {
		when:
		MediaType.get("plain;boundary=foo;charset=utf-8")
		then:
		def exception = thrown(IllegalArgumentException)
		exception.message == "No subtype found for: \"plain;boundary=foo;charset=utf-8\""
	}

	def "get with invalid charset throws IllegalArgumentException"() {
		when:
		MediaType.get("text/plain;boundary=foo;charset")
		then:
		def exception = thrown(IllegalArgumentException)
		exception.message == "Parameter is not formatted correctly: \"charset\" for: \"text/plain;boundary=foo;charset\""
	}

	def "get with multiple charsets throws IllegalArgumentException"() {
		when:
		MediaType.get("text/plain;boundary=foo;charset=utf-8;charset=utf-16")
		then:
		def exception = thrown(IllegalArgumentException)
		exception.message == "Multiple charsets defined: \"utf-8\" and: \"utf-16\" for: \"text/plain;boundary=foo;charset=utf-8;charset=utf-16\""
	}
}
