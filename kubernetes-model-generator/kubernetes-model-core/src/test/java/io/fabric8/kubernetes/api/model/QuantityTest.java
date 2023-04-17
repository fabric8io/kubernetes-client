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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuantityTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  @DisplayName("Test Serialization and Deserialization")
  public void testAmountUnitSeparately() throws JsonProcessingException {
    Quantity quantity = new Quantity("256", "Mi");
    String serializedObj = mapper.writeValueAsString(quantity);
    assertEquals("\"256Mi\"", serializedObj);

    Quantity deserializedObj = mapper.readValue("{\"amount\":256,\"format\":\"Mi\"}", Quantity.class);
    assertEquals("256", deserializedObj.getAmount());
    assertEquals("Mi", deserializedObj.getFormat());
  }

  @Test
  @DisplayName("Test Serialized value with single argument constructor")
  public void testAmount() throws JsonProcessingException {
    Quantity quantity = new Quantity("256Mi");
    String serializedObj = mapper.writeValueAsString(quantity);
    assertEquals("\"256Mi\"", serializedObj);
  }

  @Test
  @DisplayName("Test getters and setters")
  public void testQuantityObj() {
    Quantity quantity = new Quantity("32Mi");
    assertEquals("32", quantity.getAmount());
    assertEquals("Mi", quantity.getFormat());
    quantity.setAmount("16");
    quantity.setFormat("Ei");
    assertEquals("16", quantity.getAmount());
    assertEquals("Ei", quantity.getFormat());
  }

  @Test

  public void testNormalization() {
    Quantity quantity = new Quantity(".5Mi");
    assertEquals(new BigDecimal("524288.0"), Quantity.getAmountInBytes(quantity));

    Quantity quantity1 = new Quantity("512Ki");
    assertEquals(Quantity.getAmountInBytes(quantity1).toBigInteger(), Quantity.getAmountInBytes(quantity).toBigInteger());
  }

  @Test
  @DisplayName("Should be able to process negative exponents")
  public void testNegativeExponents() {
    Quantity quantity1 = new Quantity("100001m");
    Quantity quantity2 = new Quantity("1n");

    assertEquals("100.001", Quantity.getAmountInBytes(quantity1).toString());
    assertEquals("1E-9", Quantity.getAmountInBytes(quantity2).toString());
  }

  @Test
  @DisplayName("Should be able to get correct amount in bytes")
  public void testExponents() {
    assertEquals("129000000", Quantity.getAmountInBytes(new Quantity("129e6")).toString());
    assertEquals("129000000", Quantity.getAmountInBytes(new Quantity("129e+6")).toString());
    assertEquals("1234567890", Quantity.getAmountInBytes(new Quantity("1234567890")).toString());
    assertEquals("8192", Quantity.getAmountInBytes(new Quantity("8Ki")).toString());
    assertEquals("7340032", Quantity.getAmountInBytes(new Quantity("7Mi")).toString());
    assertEquals("6442450944", Quantity.getAmountInBytes(new Quantity("6Gi")).toString());
    assertEquals("5497558138880", Quantity.getAmountInBytes(new Quantity("5Ti")).toString());
    assertEquals("4503599627370496", Quantity.getAmountInBytes(new Quantity("4Pi")).toString());
    assertEquals("3.458764513820541E+18", Quantity.getAmountInBytes(new Quantity("3Ei")).toString());
    assertEquals("5E-9", Quantity.getAmountInBytes(new Quantity("5n")).toString());
    assertEquals("0.000004", Quantity.getAmountInBytes(new Quantity("4u")).toString());
    assertEquals("0.003", Quantity.getAmountInBytes(new Quantity("3m")).toString());
    assertEquals("9", Quantity.getAmountInBytes(new Quantity("9")).toString());
    assertEquals("8000", Quantity.getAmountInBytes(new Quantity("8k")).toString());
    assertEquals("50000", Quantity.getAmountInBytes(new Quantity("50k")).toString());
    assertEquals("7000000", Quantity.getAmountInBytes(new Quantity("7M")).toString());
    assertEquals("6000000000", Quantity.getAmountInBytes(new Quantity("6G")).toString());
    assertEquals("5000000000000", Quantity.getAmountInBytes(new Quantity("5T")).toString());
    assertEquals("40000000000000", Quantity.getAmountInBytes(new Quantity("40T")).toString());
    assertEquals("300000000000000", Quantity.getAmountInBytes(new Quantity("300T")).toString());
    assertEquals("2000000000000000", Quantity.getAmountInBytes(new Quantity("2P")).toString());
    assertEquals("1.000000000000000E+18", Quantity.getAmountInBytes(new Quantity("1E")).toString());
    assertEquals("524288.0", Quantity.getAmountInBytes(new Quantity(".5Mi")).toString());
    assertEquals("524288.0", Quantity.getAmountInBytes(new Quantity(".5", "Mi")).toString());
    assertEquals("524288.0", Quantity.getAmountInBytes(new Quantity(".5Mi", null)).toString());
    assertEquals("0.05", Quantity.getAmountInBytes(new Quantity("0.5e-1")).toString());
    assertEquals("0.000011", Quantity.getAmountInBytes(new Quantity("1.1E-5")).toString());
  }

  @Test
  @DisplayName("Test equals operation")
  public void testEquality() {
    assertEquals(new Quantity(".5Mi"), new Quantity("512Ki"));
    assertEquals(new Quantity("1Gi"), new Quantity("1024Mi"));
    assertNotEquals(new Quantity("2P"), "2P");

    Quantity quantity = new Quantity("100.035k");
    assertEquals(quantity, quantity);
    assertEquals(100035, quantity.hashCode());
  }

  @Test
  @DisplayName("Test exponential formats")
  public void testExponent() {
    assertEquals("10000", Quantity.getAmountInBytes(new Quantity("1e4")).toString());
    assertEquals("2000000000", Quantity.getAmountInBytes(new Quantity("2E9")).toString());
    assertEquals("2000000000000", Quantity.getAmountInBytes(new Quantity("2E12")).toString());
  }

  @Test
  @DisplayName("Fractional values should be handled properly, checks removed cast of BigDecimal to BigInteger")
  public void testFractions() {
    assertNotEquals(new Quantity("100m"), new Quantity("200m"));
    assertEquals(new Quantity("100m"), new Quantity("100m"));
  }

  @Test
  @DisplayName("Test toString() method")
  public void testStringConversion() {
    assertEquals(".5Mi", new Quantity(".5Mi").toString());
    assertEquals("1", new Quantity("1").toString());
    assertEquals("129e6", new Quantity("129e6").toString());
    assertEquals("0.001m", new Quantity("0.001m").toString());
    assertEquals("1Ki", new Quantity("1Ki").toString());
    assertEquals("32Mi", new Quantity("32Mi").toString());
    assertEquals("1e3", new Quantity("1e3").toString());
    assertEquals("1e10", new Quantity("1e10").toString());
    assertEquals("1e-3", new Quantity("1e-3").toString());
    assertEquals("100k", new Quantity("100k").toString());
    assertEquals("100001m", new Quantity("100001m").toString());
    assertEquals("1Mi", new Quantity("1Mi").toString());
  }

  @Test
  @DisplayName("Invalid formats should fail during parsing")
  public void testParseFailure() {
    assertThrows(IllegalArgumentException.class, () -> new Quantity("4e9e"));
    assertThrows(IllegalArgumentException.class, () -> new Quantity(""));
    assertThrows(IllegalArgumentException.class, () -> new Quantity(null));
    assertThrows(IllegalArgumentException.class, () -> Quantity.getAmountInBytes(new Quantity()));
    assertThrows(IllegalArgumentException.class, () -> Quantity.getAmountInBytes(new Quantity("4MiB")));
    assertThrows(IllegalArgumentException.class, () -> Quantity.getAmountInBytes(new Quantity("4megabyte")));
    assertThrows(IllegalArgumentException.class, () -> Quantity.getAmountInBytes(new Quantity("4c")));
  }

  @Test
  @DisplayName("Test containsAtLeastOneDigit method")
  public void testContainsAtLeastOneDigit() {
    assertTrue(Quantity.containsAtLeastOneDigit("0"));
    assertTrue(Quantity.containsAtLeastOneDigit(".1"));
    assertTrue(Quantity.containsAtLeastOneDigit(".1e2"));
    assertTrue(Quantity.containsAtLeastOneDigit("1.2e3"));
    assertTrue(Quantity.containsAtLeastOneDigit("-1K"));

    assertFalse(Quantity.containsAtLeastOneDigit(""));
    assertFalse(Quantity.containsAtLeastOneDigit("e"));
    assertFalse(Quantity.containsAtLeastOneDigit("Mi"));
  }

  @Test
  @DisplayName("Test indexOfUnit method")
  public void testIndexOfUnit() {
    assertEquals(0, Quantity.indexOfUnit(""));
    assertEquals(1, Quantity.indexOfUnit("0"));
    assertEquals(1, Quantity.indexOfUnit("1"));
    assertEquals(3, Quantity.indexOfUnit("123"));
    assertEquals(2, Quantity.indexOfUnit("12Mi"));
    assertEquals(3, Quantity.indexOfUnit("123K"));
    assertEquals(1, Quantity.indexOfUnit("1e3"));
    assertEquals(4, Quantity.indexOfUnit("123 K"));
    assertEquals(4, Quantity.indexOfUnit("123c"));
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "129e6", "129e+6", "1234567890", "8Ki", "7Mi", "6Gi", "5Ti", "4Pi", "3Ei", "5n", "4u", "3m",
      "9", "8k", "50k", "7M", "6G", "5T", "40T", "300T", "2P", "1E", ".5Mi", "0.5e-1", "1.1E-5" })
  @DisplayName("Test fromAmountInBytes method")
  public void testFromAmountInBytes(String amount) {
    Quantity quantity = new Quantity(amount);
    assertEquals(quantity, Quantity.fromNumericalAmount(quantity.getNumericalAmount(), quantity.getFormat()));
  }
}
