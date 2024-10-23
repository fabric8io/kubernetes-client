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

class HeadersTest extends Specification {

	def "toMultimap should return a map of the headers with lower-cased keys"() {
		given:
		def headers = Headers.builder()
				.add("Content-Type", "application/json")
				.add("Content-Length", "1024")
				.add("content-type", "application/xml")
				.add("Accept:application/json")
				.build()
		when:
		def result = headers.toMultimap()
		then:
		result.size() == 3
		result["content-type"] == [
			"application/json",
			"application/xml"
		]
		result["content-length"] == ["1024"]
		result["accept"] == ["application/json"]
	}

	def "Builder.add with colon separator should add a header"() {
		given:
		def headers = Headers.builder()
				.add("Accept:application/json")
				.add(" Accept :  text/plain  ")
				.build()
		when:
		def result = headers.get("Accept")
		then:
		result == "application/json,text/plain"
	}

	def "Builder.add(String) with no colon separator throws IllegalArgumentException"() {
		when:
		Headers.builder().add("AcceptForgotColon")
		then:
		def exception = thrown(IllegalArgumentException)
		exception.message == "Unexpected header: AcceptForgotColon"
	}

	def "Builder.addAll adds all headers from iterable"() {
		given:
		def headers = Headers.builder()
		when:
		headers.addAll([Accept: "application/json", "Content-Type": "application/xml"].entrySet())
		then:
		headers.build().get("Accept") == "application/json"
		headers.build().get("Content-Type") == "application/xml"
	}

	def "Builder.removeAll removes all headers with the given name"() {
		given:
		def headers = Headers.builder()
				.add("Accept", "application/json")
				.add("Accept", "application/xml")
				.add("Content-Type", "application/xml")
		and:
		headers.build().get("Accept") == "application/json,application/xml"
		when:
		def result = headers.removeAll("Accept").build()
		then:
		result.get("Accept") == null
		result.get("Content-Type") == "application/xml"
	}

	def "Builder.set replaces all headers with the given name"() {
		given:
		def headers = Headers.builder()
				.add("Accept", "application/json")
				.add("Accept", "application/xml")
				.add("Content-Type", "application/xml")
		and:
		headers.build().get("Accept") == "application/json,application/xml"
		when:
		def result = headers.set("Accept", "text/plain").build()
		then:
		result.get("Accept") == "text/plain"
		result.get("Content-Type") == "application/xml"
	}

	def "Builder.setHeaders replaces all headers with the given headers"() {
		given:
		def headers = Headers.builder()
				.add("Accept", "application/json")
				.add("Content-Type", "application/xml")
		def newHeaders = Headers.builder()
				.add("Accept", "text/plain")
				.add("Accept", "text/html")
				.add("Content-Type", "application/json")
		when:
		def result = headers.setHeaders(newHeaders.build()).build()
		then:
		result.get("Accept") == "text/plain,text/html"
		result.get("Content-Type") == "application/json"
	}

	def "get with no values should return null"() {
		given:
		def headers = Headers.builder().build()
		when:
		def result = headers.get("Accept")
		then:
		result == null
	}

	def "get with single value should return the value"() {
		given:
		def headers = Headers.builder().add("Accept", "application/json").build()
		when:
		def result = headers.get("Accept")
		then:
		result == "application/json"
	}

	def "get with multiple values should return a comma-separated string"() {
		given:
		def headers = Headers.builder()
				.add("Accept", "application/json")
				.add("Accept", "application/xml")
				.build()
		when:
		def result = headers.get("Accept")
		then:
		result == "application/json,application/xml"
	}

	def "newBuilder should return a new instance of Headers.Builder"() {
		given:
		def headers = Headers.builder().add("Accept", "application/json").build()
		when:
		def builder = headers.newBuilder()
		and:
		builder.add("Accept", "application/xml")
		then:
		builder.build() != headers
		headers.get("Accept") == "application/json"
		builder.build().get("Accept") == "application/json,application/xml"
	}
}
