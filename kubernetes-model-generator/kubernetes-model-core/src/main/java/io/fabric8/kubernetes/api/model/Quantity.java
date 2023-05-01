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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.sundr.builder.annotations.Buildable;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Quantity is fixed point representation of a number.
 * It provides convenient marshalling/unmarshalling in JSON or YAML,
 * in addition to String or getAmountInBytes accessors.
 *
 */
@JsonDeserialize(using = Quantity.Deserializer.class)
@JsonSerialize(using = Quantity.Serializer.class)
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, builderPackage = "io.fabric8.kubernetes.api.builder")
public class Quantity implements Serializable {
  private String amount;
  private String format = "";
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  /**
   * No args constructor for use in serialization
   *
   */
  public Quantity() {
  }

  /**
   * Single argument constructor for setting amount.
   *
   * @param amount amount of quantity specified.
   */
  public Quantity(String amount) {
    Quantity parsedQuantity = parse(amount);
    this.amount = parsedQuantity.getAmount();
    this.format = parsedQuantity.getFormat();
  }

  /**
   * Double argument constructor for setting amount along with format.
   *
   * @param amount amount of quantity specified
   * @param format format for the amount.
   */
  public Quantity(String amount, String format) {
    this.amount = amount;
    if (format != null) {
      this.format = format;
    }
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  /**
   * If this is a memory Quantity, the result will represent bytes.<br>
   * If this is a cpu Quantity, the result will represent cores.
   *
   * @return the formatted amount as a number
   * @throws ArithmeticException
   */
  @JsonIgnore
  public BigDecimal getNumericalAmount() throws ArithmeticException {
    return getAmountInBytes(this);
  }

  /**
   * If the quantity is a memory Quantity, the result will represent bytes.<br>
   * If the quantity is a cpu Quantity, the result will represent cores.
   *
   * @see #getNumericalAmount()
   * @param quantity
   * @return a BigDecimal of the bytes
   * @throws ArithmeticException
   */
  public static BigDecimal getAmountInBytes(Quantity quantity) throws ArithmeticException {
    String value = "";
    if (quantity.getAmount() != null && quantity.getFormat() != null) {
      value = quantity.getAmount() + quantity.getFormat();
    } else if (quantity.getAmount() != null) {
      value = quantity.getAmount();
    }

    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException("Invalid quantity value passed to parse");
    }
    // Append Extra zeroes if starting with decimal
    if (!Character.isDigit(value.indexOf(0)) && value.startsWith(".")) {
      value = "0" + value;
    }

    Quantity amountFormatPair = parse(value);
    String formatStr = amountFormatPair.getFormat();

    BigDecimal digit = new BigDecimal(amountFormatPair.getAmount());
    BigDecimal multiple = getMultiple(formatStr);

    return digit.multiply(multiple);
  }

  /**
   * Constructs a new Quantity from the provided amountInBytes. This amount is converted
   * to a value with the unit provided in desiredFormat.
   * 
   * @param amountInBytes
   * @param desiredFormat
   * @see #getNumericalAmount()
   * @return a new Quantity with the value of amountInBytes with units desiredFormat
   */
  public static Quantity fromNumericalAmount(BigDecimal amountInBytes, String desiredFormat) {
    if (desiredFormat == null || desiredFormat.isEmpty()) {
      return new Quantity(amountInBytes.stripTrailingZeros().toPlainString());
    }

    BigDecimal scaledToDesiredFormat = amountInBytes.divide(getMultiple(desiredFormat), MathContext.DECIMAL64);

    return new Quantity(scaledToDesiredFormat.stripTrailingZeros().toPlainString(), desiredFormat);
  }

  private static BigDecimal getMultiple(String formatStr) {
    // Handle Decimal exponent case
    if (containsAtLeastOneDigit(formatStr) && formatStr.length() > 1) {
      int exponent = Integer.parseInt(formatStr.substring(1));
      return new BigDecimal("10").pow(exponent, MathContext.DECIMAL64);
    }

    BigDecimal multiple = new BigDecimal("1");
    BigDecimal binaryFactor = new BigDecimal("2");
    BigDecimal decimalFactor = new BigDecimal("10");

    switch (formatStr) {
      case "Ki":
        multiple = binaryFactor.pow(10, MathContext.DECIMAL64);
        break;
      case "Mi":
        multiple = binaryFactor.pow(20, MathContext.DECIMAL64);
        break;
      case "Gi":
        multiple = binaryFactor.pow(30, MathContext.DECIMAL64);
        break;
      case "Ti":
        multiple = binaryFactor.pow(40, MathContext.DECIMAL64);
        break;
      case "Pi":
        multiple = binaryFactor.pow(50, MathContext.DECIMAL64);
        break;
      case "Ei":
        multiple = binaryFactor.pow(60, MathContext.DECIMAL64);
        break;
      case "n":
        multiple = decimalFactor.pow(-9, MathContext.DECIMAL64);
        break;
      case "u":
        multiple = decimalFactor.pow(-6, MathContext.DECIMAL64);
        break;
      case "m":
        multiple = decimalFactor.pow(-3, MathContext.DECIMAL64);
        break;
      case "k":
        multiple = decimalFactor.pow(3, MathContext.DECIMAL64);
        break;
      case "M":
        multiple = decimalFactor.pow(6, MathContext.DECIMAL64);
        break;
      case "G":
        multiple = decimalFactor.pow(9, MathContext.DECIMAL64);
        break;
      case "T":
        multiple = decimalFactor.pow(12, MathContext.DECIMAL64);
        break;
      case "P":
        multiple = decimalFactor.pow(15, MathContext.DECIMAL64);
        break;
      case "E":
        multiple = decimalFactor.pow(18, MathContext.DECIMAL64);
        break;
      case "":
        break;
      default:
        throw new IllegalArgumentException("Invalid quantity format passed to parse");
    }
    return multiple;
  }

  /**
   * @param value
   * @return true if the specified value contains at least one digit, otherwise false
   */
  static boolean containsAtLeastOneDigit(String value) {
    for (int i = 0; i < value.length(); i++) {
      if (Character.isDigit(value.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Quantity quantity = (Quantity) o;
    return getAmountInBytes(this)
        .compareTo(getAmountInBytes(quantity)) == 0;
  }

  @Override
  public int hashCode() {
    return getAmountInBytes(this).toBigInteger().hashCode();
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    if (getAmount() != null) {
      b.append(getAmount());
    }
    if (getFormat() != null) {
      b.append(getFormat());
    }
    return b.toString();
  }

  public static Quantity parse(String quantityAsString) {
    if (quantityAsString == null || quantityAsString.isEmpty()) {
      throw new IllegalArgumentException("Invalid quantity string format passed.");
    }

    int unitIndex = indexOfUnit(quantityAsString);
    String amountStr = quantityAsString.substring(0, unitIndex);
    String formatStr = quantityAsString.substring(unitIndex);
    // For cases like 4e9 or 129e-6, formatStr would be e9 and e-6 respectively
    // we need to check whether this is valid too. It must not end with character.
    if (containsAtLeastOneDigit(formatStr) && Character.isAlphabetic(formatStr.charAt(formatStr.length() - 1))) {
      throw new IllegalArgumentException("Invalid quantity string format passed");
    }
    return new Quantity(amountStr, formatStr);
  }

  /**
   * @param quantityAsString quantity as a string
   * @return the first index containing a unit character, or the length of the string if no element provided
   */
  static int indexOfUnit(String quantityAsString) {
    for (int i = 0; i < quantityAsString.length(); i++) {
      char ch = quantityAsString.charAt(i);
      switch (ch) {
        case 'e':
        case 'E':
        case 'i':
        case 'n':
        case 'u':
        case 'm':
        case 'k':
        case 'K':
        case 'M':
        case 'G':
        case 'T':
        case 'P':
          return i;
        default:
          //noinspection UnnecessaryContinue - satisfy Sonar
          continue;
      }
    }
    return quantityAsString.length();
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public static class Serializer extends JsonSerializer<Quantity> {

    @Override
    public void serialize(Quantity value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      if (value != null) {
        StringBuilder objAsStringBuilder = new StringBuilder();
        if (value.getAmount() != null) {
          objAsStringBuilder.append(value.getAmount());
        }
        if (value.getFormat() != null) {
          objAsStringBuilder.append(value.getFormat());
        }
        jgen.writeString(objAsStringBuilder.toString());
      } else {
        jgen.writeNull();
      }
    }
  }

  public static class Deserializer extends JsonDeserializer<Quantity> {

    @Override
    public Quantity deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      Quantity quantity = null;
      if (node.get("amount") != null && node.get("format") != null) {
        quantity = new Quantity(node.get("amount").asText(), node.get("format").asText());
      } else if (node.get("amount") != null) {
        quantity = new Quantity(node.get("amount").asText());
      } else {
        quantity = new Quantity(node.asText());
      }
      return quantity;
    }

  }

}
