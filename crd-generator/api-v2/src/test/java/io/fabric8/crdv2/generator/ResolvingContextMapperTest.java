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
package io.fabric8.crdv2.generator;

import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The generated schema describes what the client writes, so the mapper the schema is derived from has
 * to serialize like the client's. Jackson 3 makes that easy to get wrong: {@link KubernetesSerialization}
 * configures a <em>copy</em> of the mapper it is given, so settings applied there do not reach this one.
 */
class ResolvingContextMapperTest {

  private static final Map<String, Object> SAMPLE = Map.ofEntries(
      Map.entry("instant", Instant.ofEpochSecond(1_700_000_000L)),
      Map.entry("duration", Duration.ofMinutes(90)),
      Map.entry("localDateTime", LocalDateTime.of(2026, 1, 1, 10, 15, 30)),
      Map.entry("offsetTime", java.time.OffsetTime.parse("10:15:30+01:00")),
      Map.entry("yearMonth", java.time.YearMonth.of(2026, 1)),
      Map.entry("monthDay", java.time.MonthDay.of(12, 25)),
      Map.entry("timestamp", new java.sql.Timestamp(1_700_000_000_000L)),
      Map.entry("year", Year.of(2024)),
      Map.entry("month", Month.JANUARY),
      Map.entry("sqlDate", java.sql.Date.valueOf("2024-01-15")),
      Map.entry("locale", Locale.forLanguageTag("zh-Hant-TW")));

  @Test
  @DisplayName("Default schema mapper serializes dates, durations and JDK types like KubernetesSerialization does")
  void defaultMapperMatchesClientSerialization() {
    final String fromSchemaMapper = ResolvingContext.defaultResolvingContext(false).objectMapper.writeValueAsString(SAMPLE);

    assertThat(fromSchemaMapper).isEqualTo(new KubernetesSerialization().asJson(SAMPLE));
  }

  @Test
  @DisplayName("Default schema mapper writes Year, Month, java.sql.Date and Locale in their Jackson 2 form")
  void defaultMapperWritesJackson2JdkTypes() {
    final Map<String, Object> jdkTypes = new LinkedHashMap<>();
    jdkTypes.put("year", Year.of(2024));
    jdkTypes.put("month", Month.JANUARY);
    jdkTypes.put("sqlDate", java.sql.Date.valueOf("2024-01-15"));
    jdkTypes.put("locale", Locale.forLanguageTag("zh-Hant-TW"));

    assertThat(ResolvingContext.defaultResolvingContext(false).objectMapper.writeValueAsString(jdkTypes))
        .isEqualTo("{\"year\":\"2024\",\"month\":\"JANUARY\",\"sqlDate\":\"2024-01-15\",\"locale\":\"zh_TW_#Hant\"}");
  }

  @Test
  @DisplayName("A caller-supplied mapper serializes dates, durations and JDK types like KubernetesSerialization does")
  void callerSuppliedMapperMatchesClientSerialization() {
    final ObjectMapper mapper = JsonMapper.builderWithJackson2Defaults().build();
    final KubernetesSerialization kubernetesSerialization = new KubernetesSerialization(mapper, false);

    final String fromSchemaMapper = new ResolvingContext(mapper, kubernetesSerialization, false).objectMapper
        .writeValueAsString(SAMPLE);

    assertThat(fromSchemaMapper).isEqualTo(kubernetesSerialization.asJson(SAMPLE));
  }
}
