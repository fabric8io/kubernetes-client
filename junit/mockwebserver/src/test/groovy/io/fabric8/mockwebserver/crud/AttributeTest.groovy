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
package io.fabric8.mockwebserver.crud

import spock.lang.Specification

class AttributeTest extends Specification {

    def "when key and value equals features should equal"() {
        given:
        when:
        Attribute f11 = new Attribute("key1", "value1")
        Attribute f11a = new Attribute("key1", "value1")
        Attribute f12 = new Attribute("key1", "value2")
        Attribute f22 = new Attribute("key2", "value2")

        then:
        assert !f11.equals(f22)
        assert !f11.equals(f12)
        assert f11.equals(f11a)
    }

    def "equals, with same attributes but different type, should be true"() {
        given:
        Attribute a1 = new Attribute("key1", "value1", AttributeType.EXISTS)
        Attribute a2 = new Attribute("key1", "value1", AttributeType.NOT_EXISTS)
        when:
        var result = a1 == a2
        then:
        assert result
    }

    def "hashCode, with same attributes but different type, should be equal"() {
        given:
        Attribute a1 = new Attribute("key1", "value1", AttributeType.EXISTS)
        Attribute a2 = new Attribute("key1", "value1", AttributeType.NOT_EXISTS)
        when:
        var result = a1.hashCode() == a2.hashCode()
        then:
        assert result
    }
}
