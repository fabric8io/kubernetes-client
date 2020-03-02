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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ported from
 * @see <a href="https://github.com/go-openapi/strfmt/blob/1940fb2f8aba2045ae5493bd64b76ad4af8b5856/duration_test.go">github.com/go-openapi/strfmt/duration_test.go</a>
 */
public class DurationTest {

  private static ObjectMapper MAPPER = new ObjectMapper();

  private static void assertDurationParser(String durationToParse, java.time.Duration expectedDuration) throws Exception {
    assertEquals(expectedDuration, MAPPER.readValue(durationToParse, Duration.class).getDuration());
  }

  @Test
  public void invalidDurationTest() {
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"yoda\"", Duration.class));
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"three week\"", Duration.class));
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"9999999999999999999999999999999999999999999999999999999 weeks\"", Duration.class));
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"1nss\"", Duration.class));
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"1337µss\"", Duration.class));
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"100\"", Duration.class));
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"1n\"", Duration.class));
    assertThrows(ValueInstantiationException.class, () -> MAPPER.readValue("\"\"", Duration.class));
  }

  @Test
  public void nanosTest() throws Exception {
    assertDurationParser("\"1337ns\"", java.time.Duration.ofNanos(1337L));
    assertDurationParser("\"1000000000nano\"", java.time.Duration.ofSeconds(1L));
    assertDurationParser("\"1000000000nanos\"", java.time.Duration.ofSeconds(1L));
    assertDurationParser("\"1000000000 nanos\"", java.time.Duration.ofSeconds(1L));
    assertDurationParser("\"still 1 ns is valid\"", java.time.Duration.ofNanos(1L));
  }

  @Test
  public void microsTest() throws Exception {
    assertDurationParser("\"1us\"", java.time.Duration.of(1L, ChronoUnit.MICROS));
    assertDurationParser("\"1337µs\"", java.time.Duration.ofNanos(1337000L));
    assertDurationParser("\"1000000micro\"", java.time.Duration.ofSeconds(1L));
    assertDurationParser("\"1000000micros\"", java.time.Duration.ofSeconds(1L));
    assertDurationParser("\"1000000 micros\"", java.time.Duration.ofSeconds(1L));
    assertDurationParser("\"still 1 us is valid\"", java.time.Duration.ofNanos(1000L));
  }

  @Test
  public void secondsTest() throws Exception {
    assertDurationParser("\"1s\"", java.time.Duration.ofSeconds(1L));
    assertDurationParser("\"9sec\"", java.time.Duration.ofMillis(9000L));
    assertDurationParser("\"9secs\"", java.time.Duration.ofMillis(9000L));
    assertDurationParser("\"9 secs\"", java.time.Duration.ofMillis(9000L));
    assertDurationParser("\"still 1 sec is valid\"", java.time.Duration.ofSeconds(1L));
  }

  @Test
  public void minutesTest() throws Exception {
    assertDurationParser("\"1m\"", java.time.Duration.ofSeconds(60L));
    assertDurationParser("\"9min\"", java.time.Duration.ofMinutes(9L));
    assertDurationParser("\"1337mins\"", java.time.Duration.ofMinutes(1337L));
    assertDurationParser("\"1337 mins\"", java.time.Duration.ofMinutes(1337L));
    assertDurationParser("\"still 1 min is valid\"", java.time.Duration.ofMinutes(1L));
  }

  @Test
  public void hoursTest() throws Exception {
    assertDurationParser("\"1h\"", java.time.Duration.ofSeconds(3600L));
    assertDurationParser("\"2hr\"", java.time.Duration.ofMinutes(120L));
    assertDurationParser("\"24hour\"", java.time.Duration.ofDays(1L));
    assertDurationParser("\"1337hours\"", java.time.Duration.ofHours(1337L));
    assertDurationParser("\"still 1 hour is valid\"", java.time.Duration.ofHours(1L));
  }

  @Test
  public void daysTest() throws Exception {
    assertDurationParser("\"1d\"", java.time.Duration.ofMinutes(1440L));
    assertDurationParser("\"2day\"", java.time.Duration.ofHours(48L));
    assertDurationParser("\"3days\"", java.time.Duration.ofDays(3L));
    assertDurationParser("\"1337 days\"", java.time.Duration.ofDays(1337L));
    assertDurationParser("\"still 1 day is valid\"", java.time.Duration.ofDays(1L));
  }

  @Test
  public void weeksTest() throws Exception {
    assertDurationParser("\"1w\"", java.time.Duration.ofHours(168L));
    assertDurationParser("\"2wk\"", java.time.Duration.ofDays(14L));
    assertDurationParser("\"1337week\"", java.time.Duration.ofDays(9359L));
    assertDurationParser("\"1337 weeks\"", java.time.Duration.ofDays(9359L));
    assertDurationParser("\"still 1 week valid\"", java.time.Duration.ofDays(7L));
  }

  @Test
  @DisplayName("Deserialize, valid string containing a composite duration, should return expected Duration")
  public void validCompositeDuration() throws Exception {
    assertDurationParser("\"1ns1us1ms1s1m1h1d1w\"", java.time.Duration.ofNanos(694861001001001L));
    assertDurationParser("\"1w and 1h\"", java.time.Duration.ofHours(169L));
    assertDurationParser("\"1ns1S 1ms 1us 1s 1m and 1 MIN more\"", java.time.Duration.ofNanos(122001001001L));
  }

  @Test
  @DisplayName("Serialize, with valid java duration, should write value in nanoseconds")
  public void serializationWithValidJavaDurationTest() throws Exception {
    // Given
    final Duration toSerialize = new Duration(java.time.Duration.ofMillis(1337L));
    // When
    final String result = MAPPER.writeValueAsString(toSerialize);
    // Then
    assertEquals("\"1337000000ns\"", result);
  }

  @Test
  @DisplayName("isDuration, with invalid String duration, should return false")
  public void isDurationInvalidTest() {
    // Given
    final String invalidDuration = "not a valid duration 1nss";
    // When
    final boolean result = Duration.isDuration(invalidDuration);
    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("isDuration, with valid String duration, should return true")
  public void isDurationValidTest() {
    // Given
    final String validDuration = "1ns";
    // When
    final boolean result = Duration.isDuration(validDuration);
    // Then
    assertTrue(result);
  }

  @Test
  @DisplayName("isDuration, with valid String duration in one token and rest invalid, should return true")
  public void isDurationValidCornerCaseTokenTest() {
    // Given
    final String validDuration = "nope, not valid 1ns invalid";
    // When
    final boolean result = Duration.isDuration(validDuration);
    // Then
    assertTrue(result);
  }

  @Test
  @DisplayName("isDuration, with null String duration, should return false")
  public void isDurationValidCornerCaseNullTest() {
    // Given
    final String nullDuration = null;
    // When
    final boolean result = Duration.isDuration(nullDuration);
    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("Serialize, with null java duration, should write 0 in nanoseconds")
  public void serializationWithNullJavaDurationTest() throws Exception {
    // Given
    final Duration toSerialize = new Duration();
    // When
    final String result = MAPPER.writeValueAsString(toSerialize);
    // Then
    assertEquals("\"0ns\"", result);
  }
}
