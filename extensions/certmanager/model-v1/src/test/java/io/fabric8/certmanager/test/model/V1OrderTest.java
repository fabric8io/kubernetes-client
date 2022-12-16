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
package io.fabric8.certmanager.test.model;

import io.fabric8.certmanager.api.model.acme.v1.Order;
import io.fabric8.certmanager.api.model.acme.v1.OrderBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class V1OrderTest {

  @Test
  void testOrderModelApiVersion() {

    Order order = new OrderBuilder()
        .withNewMetadata().withName("my-order").endMetadata()
        .build();

    assertNotNull(order);
    assertEquals("my-order", order.getMetadata().getName());
    assertEquals("acme.cert-manager.io/v1", order.getApiVersion());
  }

}
