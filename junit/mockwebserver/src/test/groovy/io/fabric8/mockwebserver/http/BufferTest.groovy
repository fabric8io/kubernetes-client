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

class BufferTest extends Specification {

	def "size should return the number of bytes in the buffer"() {
		when:
		def buffer = new Buffer().writeUtf8("an UTF-8 string")
		then:
		buffer.size() == 15
	}

	def "getBytes should return all bytes"() {
		given:
		def buffer = new Buffer().writeUtf8("an UTF-8 string")
		when:
		def bytes = buffer.getBytes()
		then:
		new String(bytes, StandardCharsets.UTF_8) == "an UTF-8 string"
	}

	def "readByteArray should return all bytes and leave the buffer empty"() {
		given:
		def buffer = new Buffer().writeUtf8("an UTF-8 string")
		when:
		def bytes = buffer.readByteArray()
		then:
		new String(bytes, StandardCharsets.UTF_8) == "an UTF-8 string"
		buffer.size() == 0
	}

	def "readUtf8 should read all bytes and leave the buffer empty"() {
		given:
		def buffer = new Buffer().writeUtf8("an UTF-8 string")
		when:
		def string = buffer.readUtf8()
		then:
		string == "an UTF-8 string"
		buffer.size() == 0
	}

	def "readString should read all bytes as a String and leave the buffer empty"() {
		given:
		def buffer = new Buffer().writeUtf8("an UTF-8 string")
		when:
		def string = buffer.readString(StandardCharsets.UTF_8)
		then:
		string == "an UTF-8 string"
		buffer.size() == 0
	}

	def "write should append the bytes to the buffer"() {
		given:
		def buffer = new Buffer()
		when:
		buffer.write([1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as byte[]).write([11, 12, 13, 14, 15] as byte[])
		then:
		buffer.size() == 15
		buffer.readUtf8() == "\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000B\f\r\u000E\u000F"
	}

	def "writeString should append the UTF-8 bytes to the buffer"() {
		given:
		def buffer = new Buffer()
		when:
		buffer.writeString("an UTF-8 string", StandardCharsets.UTF_8)
		then:
		buffer.size() == 15
		buffer.readUtf8() == "an UTF-8 string"
	}

	def "writeUtf8 should append the UTF-8 bytes to the buffer"() {
		given:
		def buffer = new Buffer()
		when:
		buffer.writeUtf8("an UTF-8 string")
		then:
		buffer.size() == 15
		buffer.readUtf8() == "an UTF-8 string"
	}

	def "inputStream should return an InputStream that reads from bytes cloned from this buffer"() {
		given:
		def buffer = new Buffer().writeUtf8("an UTF-8 string")
		when:
		def inputStream = buffer.inputStream()
		then:
		new String(inputStream.bytes, StandardCharsets.UTF_8) == "an UTF-8 string"
		buffer.size() == 15
	}

	def "flush performs no operation"() {
		given:
		def buffer = new Buffer().writeUtf8("an UTF-8 string")
		when:
		buffer.flush()
		then:
		buffer.size() == 15
	}
}
