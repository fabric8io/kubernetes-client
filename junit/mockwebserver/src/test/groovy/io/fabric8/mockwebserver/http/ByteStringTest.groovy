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

class ByteStringTest extends Specification {

	def "of variable arguments should concatenate all byte strings"() {
		when:
		def result = ByteString.of((byte) 1, (byte) 2, (byte) 3)
		then:
		result.utf8() == "\u0001\u0002\u0003"
	}

	def "encodeUtf8 should return the byte string representation of the string"() {
		when:
		def result = ByteString.encodeUtf8("abc")
		then:
		result.utf8() == "abc"
	}

	def "utf8 should return the string representation of the byte string"() {
		given:
		def byteString = new ByteString("abc".getBytes())
		when:
		def result = byteString.utf8()
		then:
		result == "abc"
	}

	def "toByteArray should return the byte array representation of the byte string"() {
		given:
		def byteString = new ByteString("abc".getBytes())
		when:
		def result = byteString.toByteArray()
		then:
		result == "abc".getBytes()
	}

	def "toByteArray should return a copy of the byte array representation of the byte string"() {
		given:
		def byteString = new ByteString("abc".getBytes())
		def byteArray = byteString.toByteArray()
		when:
		byteArray[0] = 0
		then:
		byteString.toByteArray()[0] == 'a'.getBytes()[0]
	}
}
