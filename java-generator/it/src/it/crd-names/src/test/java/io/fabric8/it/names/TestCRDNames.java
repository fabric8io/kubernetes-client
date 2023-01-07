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
package io.fabric8.it.names;

import com.fabric8.test.ActiveMQArtemis;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCRDNames {

  @Test
  void testSingularAndPlural() {
    // Arrange
    ActiveMQArtemis x = new ActiveMQArtemis();

    // Act
    String singular = x.getSingular();
    String plural = x.getPlural();
    String name = x.getCRDName();

    // Assert
    assertEquals("activemqartemis", singular);
    assertEquals("activemqartemises", plural);
    assertEquals("activemqartemises.broker.amq.io", name);
  }

}
