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
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class QuantityTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  @DisplayName("Test Serialization and Deserialization")
  void testAmountUnitSeparately() throws JsonProcessingException {
    Quantity quantity = new Quantity("256", "Mi");
    String serializedObj = mapper.writeValueAsString(quantity);
    assertThat(serializedObj).isEqualTo("\"256Mi\"");

    Quantity deserializedObj = mapper.readValue("{\"amount\":256,\"format\":\"Mi\"}", Quantity.class);
    assertThat(deserializedObj)
        .hasFieldOrPropertyWithValue("amount", "256")
        .hasFieldOrPropertyWithValue("format", "Mi");
  }

  @Test
  @DisplayName("Test Serialized value with single argument constructor")
  void testAmount() throws JsonProcessingException {
    Quantity quantity = new Quantity("256Mi");
    String serializedObj = mapper.writeValueAsString(quantity);
    assertThat(serializedObj).isEqualTo("\"256Mi\"");
  }

  @Test
  void quantity_whenSerialized_thenAdditionalPropertiesNotPresentInSerializedForm() throws JsonProcessingException {
    // Given
    Quantity quantity = new Quantity("8Mi");
    quantity.setAdditionalProperties(Collections.singletonMap("unwantedKey", "unwantedValue"));
    // When
    String result = mapper.writeValueAsString(quantity);
    // Then
    assertThat(result).isEqualTo("\"8Mi\"").doesNotContain("additionalProperties");
  }

  @Test
  void quantity_whenDeserialized_thenAdditionalPropertiesNotPresentInObject() throws JsonProcessingException {
    // Given
    String serializedForm = "{\"amount\":256,\"format\":\"Mi\",\"additionalProperties\":{\"unwantedKey\":\"unwantedValue\"}}";
    // When
    Quantity result = mapper.readValue(serializedForm, Quantity.class);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("amount", "256")
        .hasFieldOrPropertyWithValue("format", "Mi")
        .hasFieldOrPropertyWithValue("additionalProperties", Collections.emptyMap());
  }

  @Test
  @DisplayName("Test getters and setters")
  void testQuantityObj() {
    Quantity quantity = new Quantity("32Mi");
    assertThat(quantity)
        .hasFieldOrPropertyWithValue("amount", "32")
        .hasFieldOrPropertyWithValue("format", "Mi");
    quantity.setAmount("16");
    quantity.setFormat("Ei");
    assertThat(quantity)
        .hasFieldOrPropertyWithValue("amount", "16")
        .hasFieldOrPropertyWithValue("format", "Ei");
  }

  @Test
  void testNormalization() {
    Quantity quantity = new Quantity(".5Mi");
    assertThat(Quantity.getAmountInBytes(quantity)).isEqualTo(new BigDecimal("524288.0"));

    Quantity quantity1 = new Quantity("512Ki");
    assertThat(Quantity.getAmountInBytes(quantity).toBigInteger())
        .isEqualTo(Quantity.getAmountInBytes(quantity1).toBigInteger());
  }

  @Test
  @DisplayName("Should be able to process negative exponents")
  void testNegativeExponents() {
    Quantity quantity1 = new Quantity("100001m");
    Quantity quantity2 = new Quantity("1n");

    assertThat(Quantity.getAmountInBytes(quantity1)).hasToString("100.001");
    assertThat(Quantity.getAmountInBytes(quantity2)).hasToString("1E-9");
  }

  @ParameterizedTest
  @DisplayName("Should be able to get correct amount in bytes using Quantity string constructor")
  @CsvSource({
      "129e6,129000000", "129e+6,129000000", "1234567890,1234567890", "8Ki,8192", "7Mi,7340032", "6Gi,6442450944",
      "5Ti,5497558138880", "4Pi,4503599627370496", "3Ei,3.458764513820541E+18", "5n,5E-9", "4u,0.000004", "3m,0.003", "9,9",
      "8k,8000", "50k,50000", "7M,7000000", "6G,6000000000", "5T,5000000000000", "40T,40000000000000", "300T,300000000000000",
      "2P,2000000000000000", "1E,1.000000000000000E+18", ".5Mi,524288.0", "0.5e-1,0.05", "1.1E-5,0.000011", "1e4,10000",
      "2E9,2000000000",
      "2E12,2000000000000"
  })
  void getAmountInBytes_whenQuantityConstructedViaStringProvided_thenConvertsAmountIntoBytes(String input,
      String expectedOutput) {
    assertThat(Quantity.getAmountInBytes(new Quantity(input))).hasToString(expectedOutput);
  }

  @ParameterizedTest
  @DisplayName("Should be able to get correct amount in bytes using Quantity amount and format constructor")
  @CsvSource({ ".5Mi,,524288.0", ".5,Mi,524288.0" })
  void getAmountInBytes_whenQuantityConstructedViaAmountAndFormatProvided_thenConvertsAmountIntoBytes(String amount,
      String format, String expectedBytes) {
    assertThat(Quantity.getAmountInBytes(new Quantity(amount, format))).hasToString(expectedBytes);
  }

  @Test
  @DisplayName("Test equals operation")
  void testEquality() {
    assertThat(new Quantity(".5Mi")).isEqualTo(new Quantity("512Ki"));
    assertThat(new Quantity("1Gi")).isEqualTo(new Quantity("1024Mi"));
    assertThat(new Quantity("2P")).isNotEqualTo("2P");

    Quantity quantity = new Quantity("100.035k");
    assertThat(quantity).isEqualTo(quantity);
    assertThat(quantity.hashCode()).isEqualTo(100035);
  }

  @Test
  @DisplayName("Fractional values should be handled properly, checks removed cast of BigDecimal to BigInteger")
  void testFractions() {
    assertThat(new Quantity("100m")).isNotEqualTo(new Quantity("200m"));
    assertThat(new Quantity("100m")).isEqualTo(new Quantity("100m"));
  }

  @ParameterizedTest
  @DisplayName("Test toString() method")
  @CsvSource({
      ".5Mi,.5Mi", "1,1", "129e6,129e6", "0.001m,0.001m", "1Ki,1Ki", "32Mi,32Mi", "1e3,1e3", "1e10,1e10", "1e-3,1e-3",
      "100k,100k", "100001m,100001m", "1Mi,1Mi"
  })
  void testStringConversion(String input, String expectedToString) {
    assertThat(new Quantity(input)).hasToString(expectedToString);
  }

  @Test
  @DisplayName("Invalid formats should fail during parsing")
  void testParseFailure() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Quantity("4e9e"));
    assertThatIllegalArgumentException().isThrownBy(() -> new Quantity(""));
    assertThatIllegalArgumentException().isThrownBy(() -> new Quantity(null));
    assertThatIllegalArgumentException().isThrownBy(() -> Quantity.getAmountInBytes(new Quantity()));
    assertThatIllegalArgumentException().isThrownBy(() -> Quantity.getAmountInBytes(new Quantity("4MiB")));
    assertThatIllegalArgumentException().isThrownBy(() -> Quantity.getAmountInBytes(new Quantity("4megabyte")));
    assertThatIllegalArgumentException().isThrownBy(() -> Quantity.getAmountInBytes(new Quantity("4c")));
  }

  @ParameterizedTest
  @DisplayName("Test containsAtLeastOneDigit method")
  @CsvSource({
      "0,true", ".1,true", ".1e2,true", "1.2e3,true", "-1K,true", "e,false", "Mi,false"
  })
  void containsAtLeastOneDigit_whenStandardValuesProvided_thenReturnExpectedOutput(String input, boolean result) {
    assertThat(Quantity.containsAtLeastOneDigit(input)).isEqualTo(result);
  }

  @Test
  void containsAtLeastOneDigit_whenBlankValueProvided_thenReturnFalse() {
    assertThat(Quantity.containsAtLeastOneDigit("")).isFalse();
  }

  @ParameterizedTest
  @DisplayName("Test indexOfUnit method")
  @CsvSource({ "0,1", "1,1", "123,3", "12Mi,2", "123K,3", "1e3,1", "123 K,4", "123c,4" })
  void testIndexOfUnit(String input, int result) {
    assertThat(Quantity.indexOfUnit(input)).isEqualTo(result);
  }

  @Test
  void indexOfUnit_whenBlankValueProvided_thenReturnsZero() {
    assertThat(Quantity.indexOfUnit("")).isZero();
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "129e6", "129e+6", "1234567890", "8Ki", "7Mi", "6Gi", "5Ti", "4Pi", "3Ei", "5n", "4u", "3m",
      "9", "8k", "50k", "7M", "6G", "5T", "40T", "300T", "2P", "1E", ".5Mi", "0.5e-1", "1.1E-5" })
  @DisplayName("Test fromAmountInBytes method")
  void testFromAmountInBytes(String amount) {
    Quantity quantity = new Quantity(amount);
    assertThat(quantity).isEqualTo(Quantity.fromNumericalAmount(quantity.getNumericalAmount(), quantity.getFormat()));
  }
}
