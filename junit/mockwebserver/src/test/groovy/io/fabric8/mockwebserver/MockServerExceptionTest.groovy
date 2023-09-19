/**
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
package io.fabric8.mockwebserver

import spock.lang.Specification

class MockServerExceptionTest extends Specification {

  def "launderThrowable, with null, should throw MockServerException"() {
    when:
    MockServerException.launderThrowable(null)
    then:
    def result = thrown(MockServerException)
    assert result.getMessage() == "An error has occurred."
    assert result.getCause() == null
  }

  def "launderThrowable, with checked exception, should throw MockServerException"() {
    when:
    MockServerException.launderThrowable(new Exception("I'm checked"))
    then:
    def result = thrown(MockServerException)
    assert result.getMessage() == "An error has occurred."
    assert result.getCause().getClass() == Exception
    assert result.getCause().getMessage() == "I'm checked"
  }

  def "launderThrowable, with unchecked exception, should throw MockServerException"() {
    when:
    def result = MockServerException.launderThrowable(new RuntimeException("I'm unchecked"))
    then:
    assert result.getMessage() == "I'm unchecked"
    assert result.getClass() != MockServerException
  }

  def "launderThrowable, with Error, should not be handled"() {
    when:
    MockServerException.launderThrowable(new Error("I'm an Error"))
    then:
    def result = thrown(Error)
    assert result.getMessage() == "I'm an Error"
  }

  def "launderThrowable, with Interrupted Exception, should re-interrupt"() {
    when:
    MockServerException.launderThrowable(new InterruptedException("I'm interrupted"))
    then:
    assert Thread.currentThread().isInterrupted()
    def result = thrown(MockServerException)
    assert result.getMessage() == "An error has occurred."
  }
}
