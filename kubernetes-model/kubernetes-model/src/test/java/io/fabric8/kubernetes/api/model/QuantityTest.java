/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuantityTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void testAmountUnitSeparately() throws JsonProcessingException {
    Quantity quantity = new Quantity("256", "Mi");
    String serializedObj = mapper.writeValueAsString(quantity);
    assertEquals("\"256Mi\"", serializedObj);
  }

  @Test
  public void testAmount() throws JsonProcessingException {
    Quantity quantity = new Quantity("256Mi");
    String serializedObj = mapper.writeValueAsString(quantity);
    assertEquals("\"256Mi\"", serializedObj);
  }

  @Test
  public void testQuantityObj() {
    Quantity quantity = new Quantity("32Mi");
    assertEquals("32", quantity.getAmount());
    assertEquals("Mi", quantity.getFormat());
  }

  @Test
  public void testNormalization() {
    Quantity quantity = new Quantity(".5Mi");
    assertEquals(new BigDecimal("524288.0"), Quantity.getAmountInBytes(quantity));

    Quantity quantity1 =  new Quantity("512Ki");
    assertEquals(Quantity.getAmountInBytes(quantity1).toBigInteger(), Quantity.getAmountInBytes(quantity).toBigInteger());
  }

  @Test
  public void testNegativeExponents() {
    Quantity quantity1 = new Quantity("100001m");
    Quantity quantity2 = new Quantity("1n");

    assertEquals("100.001", Quantity.getAmountInBytes(quantity1).toString());
    assertEquals("1E-9", Quantity.getAmountInBytes(quantity2).toString());
  }

  @Test
  public void testEquality() {
    assertTrue(new Quantity(".5Mi").equals( new Quantity("512Ki")));
  }

  @Test
  public void testExponent() {
    assertEquals("10000", Quantity.getAmountInBytes(new Quantity("1e4")).toString());
  }
}
