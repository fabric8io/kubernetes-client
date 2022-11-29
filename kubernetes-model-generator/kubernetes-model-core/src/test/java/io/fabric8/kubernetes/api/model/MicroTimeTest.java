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
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MicroTimeTest {
  private static final ObjectMapper mapper = new ObjectMapper();

  private static final class MicroTimeHolder {
    private MicroTime microTime;

    public MicroTime getMicroTime() {
      return microTime;
    }
  }

  @Test
  void testSerialization() throws JsonProcessingException {
    // Given
    String timeFormat = OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    MicroTime microTime = new MicroTimeBuilder()
        .withTime(timeFormat)
        .build();

    // When
    String result = mapper.writeValueAsString(microTime);

    // Then
    assertEquals("\"" + timeFormat + "\"", result);
  }

  @Test
  void testDeserialization() throws JsonProcessingException {
    String microTimeAsStr = "1998-05-05T05:05:05.000000Z";
    String input = "{\"microTime\": \"" + microTimeAsStr + "\"}";

    MicroTimeHolder microTimeHolder = mapper.readValue(input, MicroTimeHolder.class);

    assertNotNull(microTimeHolder);
    assertEquals(microTimeAsStr, microTimeHolder.getMicroTime().getTime());
  }
}
