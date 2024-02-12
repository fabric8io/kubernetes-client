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
package io.fabric8.mockwebserver.crud

import spock.lang.Specification

import java.util.stream.Collectors

class AttributeSetTest extends Specification {

    def "when two feature set are empty the should be equals"() {
        given:
        when:
        AttributeSet f1 = new AttributeSet()
        AttributeSet f2 = new AttributeSet()
        then:
        assert f1.equals(f2)
    }

    def "when two feature sets contain the same feature"() {
        given:
        Attribute f = new Attribute("key1", "value1")
        when:
        AttributeSet f1 = new AttributeSet(f)
        AttributeSet f2 = new AttributeSet(f)
        then:
        assert f1.equals(f2)
    }

    def "when two feature sets contain the same features order should not matter"() {
        given:
        Attribute f1 = new Attribute("key1", "value1")
        Attribute f2 = new Attribute("key2", "value2")
        Attribute f3 = new Attribute("key3", "value3")
        when:
        AttributeSet fs12 = new AttributeSet(f1, f2)
        AttributeSet fs21 = new AttributeSet(f2, f1)
        AttributeSet fs23 = new AttributeSet(f2, f3)

        then:
        assert fs12.equals(fs21)
        assert !fs12.equals(fs23)
        assert !fs21.equals(fs23)
    }

    def "when an EXISTS attribute exists in both sets they should match"() {
        given:
        Attribute a1 = new Attribute("key1", "", AttributeType.EXISTS)
        Attribute a2 = new Attribute("key2", "value2")
        when:
        AttributeSet selector = new AttributeSet(a1, a2)
        AttributeSet attributeSet = new AttributeSet(a1, a2)
        then:
        assert attributeSet.matches(selector)
    }

    def "when an EXISTS attribute exists in one set but not the other sets they should not match"() {
        given:
        Attribute a1 = new Attribute("key1", "", AttributeType.EXISTS)
        Attribute a2 = new Attribute("key2", "value2")
        when:
        AttributeSet selector = new AttributeSet(a1, a2)
        AttributeSet attributeSet = new AttributeSet(a2)
        then:
        assert !attributeSet.matches(selector)
    }

    def "when a NOT_EXISTS attribute exists in both sets they should not match"() {
        given:
        Attribute a1 = new Attribute("key1", "", AttributeType.NOT_EXISTS)
        Attribute a2 = new Attribute("key2", "value2")
        when:
        AttributeSet selector = new AttributeSet(a1, a2)
        AttributeSet attributeSet = new AttributeSet(a1, a2)
        then:
        assert !attributeSet.matches(selector)
    }

    def "when a NOT_EXISTS attribute exists in one set but not the other sets they should match"() {
        given:
        Attribute a1 = new Attribute("key1", "", AttributeType.NOT_EXISTS)
        Attribute a2 = new Attribute("key2", "value2")
        when:
        AttributeSet selector = new AttributeSet(a1, a2)
        AttributeSet attributeSet = new AttributeSet(a2)
        then:
        assert attributeSet.matches(selector)
    }

  def "when multiple attributes are specified it should not match an attribute set with a single attribute"() {
    given: "multiple attributes"
      def a2 = new Attribute("key2", "value2")
      def a3 = new Attribute("key3", "", AttributeType.EXISTS)
    and: "an AttributeSet with only one attribute"
      def attributeSet = new AttributeSet(a2)
    and: "an AttributeSet with two attributes as selector"
      def selectorWithTwo = new AttributeSet(a2, a3)
    when: "matching"
      def matches = attributeSet.matches(selectorWithTwo)
    then: "it should not match"
      assert !matches
  }

  def "when multiple attributes are specified it should examine all"() {
    given: "multiple attributes"
      def a2 = new Attribute("key2", "value2")
      def a3 = new Attribute("key3", "", AttributeType.EXISTS)
    and: "an AttributeSet with all attributes"
      def attributeSet = new AttributeSet(a2, a3)
    when: "listing its values"
      def attributes = attributeSet.attributes.values().stream().sorted().collect(Collectors.toList())
    then: "it should contain all attributes"
      assert attributes.indexOf(a3) == 1
      assert attributes.size() == 2
  }

  def "when IN attribute in selector"() {
    given:
    Attribute a1 = new Attribute("key1", "value")
    Attribute a2 = new Attribute("key2", "value1")
    Attribute a3 = new Attribute("key2", "value2")
    Attribute a4 = new Attribute("key2", "value3")
    Attribute a5 = new Attribute("key2", Arrays.asList("value1", "value2"), AttributeType.IN)

    when:
    AttributeSet attributeSetWithoutAttr = new AttributeSet(a1)
    AttributeSet attributeSetWithVal1 = new AttributeSet(a2)
    AttributeSet attributeSetWithVal2 = new AttributeSet(a3)
    AttributeSet attributeSetWithWrongVal = new AttributeSet(a4)
    AttributeSet selector = new AttributeSet(a5);

    then:
    assert !attributeSetWithoutAttr.matches(selector)
    assert attributeSetWithVal1.matches(selector)
    assert attributeSetWithVal2.matches(selector)
    assert !attributeSetWithWrongVal.matches(selector)
  }

    def "when NOT_IN attribute in selector"() {
    given:
    Attribute a1 = new Attribute("key1", "value")
    Attribute a2 = new Attribute("key2", "value1")
    Attribute a3 = new Attribute("key2", "value2")
    Attribute a4 = new Attribute("key2", "value3")
    Attribute a5 = new Attribute("key2", Arrays.asList("value1", "value2"), AttributeType.NOT_IN)

    when:
    AttributeSet attributeSetWithoutAttr = new AttributeSet(a1)
    AttributeSet attributeSetWithVal1 = new AttributeSet(a2)
    AttributeSet attributeSetWithVal2 = new AttributeSet(a3)
    AttributeSet attributeSetWithWrongVal = new AttributeSet(a4)
    AttributeSet selector = new AttributeSet(a5);

    then:
    assert attributeSetWithoutAttr.matches(selector)
    assert !attributeSetWithVal1.matches(selector)
    assert !attributeSetWithVal2.matches(selector)
    assert attributeSetWithWrongVal.matches(selector)
  }

}
