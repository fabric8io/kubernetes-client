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
package io.fabric8.kubernetes.model.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.cfg.EnumFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import tools.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import tools.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import tools.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Expected values are what Jackson 2.21 (with jackson-datatype-jsr310) writes for the same input.
 */
class Jackson2JdkTypesModuleTest {

  // local midnight in the default timezone, so it has to be created after the timezone is set
  private static java.sql.Date sqlDate() {
    return java.sql.Date.valueOf("2024-01-15");
  }

  private TimeZone defaultTimeZone;
  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    defaultTimeZone = TimeZone.getDefault();
    // west of UTC, where Jackson 2 read yyyy-MM-dd as the previous day
    TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
    mapper = JsonMapper.builderWithJackson2Defaults()
        .addModule(new Jackson2JdkTypesModule())
        .disable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
        // @JsonFormat patterns format with the default locale, e.g. th_TH writes Buddhist years
        .defaultLocale(Locale.ROOT)
        .build();
  }

  @AfterEach
  void tearDown() {
    TimeZone.setDefault(defaultTimeZone);
  }

  @Nested
  @DisplayName("Serialization")
  class Serialization {

    @Test
    @DisplayName("writes Year, Month, java.sql.Date and Locale in the Jackson 2 form")
    void writesJackson2Form() {
      assertThat(mapper.writeValueAsString(new Plain()))
          .isEqualTo("{\"year\":\"2024\",\"month\":\"JANUARY\",\"sqlDate\":\"2024-01-15\",\"locale\":\"zh_TW_#Hant\"}");
    }

    @Test
    @DisplayName("with WRITE_DATES_AS_TIMESTAMPS, writes Year and java.sql.Date as numbers, like Jackson 2")
    void writesTimestampsWhenEnabled() {
      final ObjectMapper timestamps = mapper.rebuild().enable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS).build();

      assertThat(timestamps.writeValueAsString(new Plain()))
          .isEqualTo("{\"year\":2024,\"month\":\"JANUARY\",\"sqlDate\":" + sqlDate().getTime()
              + ",\"locale\":\"zh_TW_#Hant\"}");
    }

    @Test
    @DisplayName("honors @JsonFormat patterns and shapes, like Jackson 2")
    void honorsJsonFormat() {
      assertThat(mapper.writeValueAsString(new Annotated()))
          .isEqualTo("{\"year\":\"24\",\"month\":0,\"sqlDate\":\"15/01/2024\",\"stringYear\":\"2024\",\"numberSqlDate\":"
              + sqlDate().getTime() + "}");
    }

    @Test
    @DisplayName("with WRITE_ENUMS_USING_INDEX, writes Month as its index, like any other enum")
    void writesMonthIndexWhenEnabled() {
      final ObjectMapper index = mapper.rebuild().enable(EnumFeature.WRITE_ENUMS_USING_INDEX).build();

      assertThat(index.writeValueAsString(Map.of("month", Month.JANUARY))).isEqualTo("{\"month\":0}");
    }

    @Test
    @DisplayName("writes Locale map keys in the Jackson 2 form")
    void writesLocaleKeysInJackson2Form() {
      assertThat(mapper.writeValueAsString(Map.of(Locale.forLanguageTag("zh-Hant-TW"), "zh")))
          .isEqualTo("{\"zh_TW_#Hant\":\"zh\"}");
    }
  }

  /**
   * The CRD generator describes the types with what their serializers report.
   */
  @Nested
  @DisplayName("Schema")
  class Schema {

    @Test
    @DisplayName("reports what it writes: Year as a string without format, java.sql.Date as a date, Month by name")
    void reportsWhatItWrites() {
      assertThat(reportedSchema(mapper, Year.class)).containsExactly("string");
      assertThat(reportedSchema(mapper, java.sql.Date.class)).containsExactly("string", "format date");
      assertThat(reportedSchema(mapper, Month.class))
          .containsExactly("string", "enum " + Stream.of(Month.values()).map(Month::name).sorted().toList());
    }

    @Test
    @DisplayName("with WRITE_DATES_AS_TIMESTAMPS, reports Year and java.sql.Date as integers, like Jackson 2")
    void reportsTimestampsWhenEnabled() {
      final ObjectMapper timestamps = mapper.rebuild().enable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS).build();

      assertThat(reportedSchema(timestamps, Year.class)).containsExactly("integer");
      assertThat(reportedSchema(timestamps, java.sql.Date.class)).containsExactly("integer", "format utc-millisec");
    }

    /**
     * The JSON type the serializer of the type reports, and its format or enum values.
     */
    private List<String> reportedSchema(ObjectMapper objectMapper, Class<?> type) {
      final List<String> reported = new ArrayList<>();
      objectMapper.acceptJsonFormatVisitor(type, new JsonFormatVisitorWrapper.Base() {
        @Override
        public JsonStringFormatVisitor expectStringFormat(JavaType typeHint) {
          reported.add("string");
          return new JsonStringFormatVisitor.Base() {
            @Override
            public void format(JsonValueFormat format) {
              reported.add("format " + format);
            }

            @Override
            public void enumTypes(Set<String> enums) {
              reported.add("enum " + enums.stream().sorted().toList());
            }
          };
        }

        @Override
        public JsonIntegerFormatVisitor expectIntegerFormat(JavaType typeHint) {
          reported.add("integer");
          return new JsonIntegerFormatVisitor.Base() {
            @Override
            public void format(JsonValueFormat format) {
              reported.add("format " + format);
            }
          };
        }
      });
      return reported;
    }
  }

  @Nested
  @DisplayName("java.sql.Date deserialization")
  class SqlDateDeserialization {

    @ParameterizedTest(name = "in {0}")
    @ValueSource(strings = { "America/New_York", "UTC", "Asia/Tokyo" })
    @DisplayName("reads yyyy-MM-dd as a local date, so the day doesn't depend on the timezone")
    void readsLocalDate(String timeZone) {
      TimeZone.setDefault(TimeZone.getTimeZone(timeZone));

      assertThat(mapper.readValue("\"2024-01-15\"", java.sql.Date.class).toLocalDate())
          .isEqualTo(LocalDate.of(2024, 1, 15));
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = { "1705276800000", "\"2024-01-15T00:00:00.000+00:00\"", "\"2024-02-30\"", "\"\"" })
    @DisplayName("reads anything else like Jackson does")
    void readsAnythingElseLikeJackson(String json) {
      final ObjectMapper plain = JsonMapper.builderWithJackson2Defaults().build();

      assertThat(readSqlDate(mapper, json)).isEqualTo(readSqlDate(plain, json));
    }

    /**
     * The value read, or the type of the exception thrown.
     */
    private Object readSqlDate(ObjectMapper objectMapper, String json) {
      try {
        return objectMapper.readValue(json, java.sql.Date.class);
      } catch (RuntimeException e) {
        return e.getClass();
      }
    }

    @Test
    @DisplayName("with a @JsonFormat pattern, reads with that pattern and its timezone like Jackson does")
    void readsWithPattern() {
      final ObjectMapper plain = JsonMapper.builderWithJackson2Defaults().build();
      final String json = "{\"sqlDate\":\"2024-01-15\"}";

      assertThat(mapper.readValue(json, UtcPattern.class).sqlDate)
          .isEqualTo(plain.readValue(json, UtcPattern.class).sqlDate);
    }
  }

  @Nested
  @DisplayName("Locale deserialization")
  class LocaleDeserialization {

    @ParameterizedTest(name = "{0}")
    @MethodSource("io.fabric8.kubernetes.model.jackson.Jackson2JdkTypesModuleTest#locales")
    @DisplayName("reads the Jackson 2 form (Locale#toString) back into the same locale")
    void readsJackson2Form(Locale locale) {
      assertThat(mapper.readValue("\"" + locale + "\"", Locale.class)).isEqualTo(locale);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("io.fabric8.kubernetes.model.jackson.Jackson2JdkTypesModuleTest#locales")
    @DisplayName("reads the BCP 47 form (Locale#toLanguageTag) back into the same locale")
    void readsBcp47Form(Locale locale) {
      assertThat(mapper.readValue("\"" + locale.toLanguageTag() + "\"", Locale.class)).isEqualTo(locale);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("io.fabric8.kubernetes.model.jackson.Jackson2JdkTypesModuleTest#locales")
    @DisplayName("reads map keys in the Jackson 2 and BCP 47 forms back into the same locale")
    void readsKeysInBothForms(Locale locale) {
      final TypeReference<Map<Locale, String>> type = new TypeReference<>() {
      };

      assertThat(mapper.readValue("{\"" + locale + "\":\"a\"}", type)).containsOnlyKeys(locale);
      assertThat(mapper.readValue("{\"" + locale.toLanguageTag() + "\":\"a\"}", type)).containsOnlyKeys(locale);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("io.fabric8.kubernetes.model.jackson.Jackson2JdkTypesModuleTest#legacyLocales")
    @DisplayName("reads the Jackson 2 form of legacy locales, which BCP 47 can't express, back into the same locale")
    void readsLegacyLocales(Locale locale) {
      final TypeReference<Map<Locale, String>> type = new TypeReference<>() {
      };

      assertThat(mapper.readValue("\"" + locale + "\"", Locale.class)).isEqualTo(locale);
      assertThat(mapper.readValue("{\"" + locale + "\":\"a\"}", type)).containsOnlyKeys(locale);
    }

    @Test
    @DisplayName("reads an empty string as the root locale, like Jackson does")
    void readsEmptyStringAsRoot() {
      assertThat(mapper.readValue("\"\"", Locale.class)).isEqualTo(Locale.ROOT);
    }

    @Test
    @DisplayName("reads und, how Jackson 3 writes the root locale, as the root locale (values and map keys)")
    void readsUndAsRoot() {
      assertThat(mapper.readValue("\"und\"", Locale.class)).isEqualTo(Locale.ROOT);
      assertThat(mapper.readValue("{\"und\":\"a\"}", new TypeReference<Map<Locale, String>>() {
      })).containsOnlyKeys(Locale.ROOT);
    }

    @Test
    @DisplayName("reads an empty map key as the root locale, like Jackson 2 did")
    void readsEmptyKeyAsRoot() {
      assertThat(mapper.readValue("{\"\":\"a\"}", new TypeReference<Map<Locale, String>>() {
      })).containsOnlyKeys(Locale.ROOT);
    }
  }

  /**
   * Created with the Locale constructor, which keeps what BCP 47 can't express (long or legacy variants and regions).
   */
  @SuppressWarnings("deprecation")
  static Stream<Arguments> legacyLocales() {
    return Stream.of(
        new Locale("es", "ES", "Traditional_WIN"),
        new Locale("en", "USA"),
        new Locale("", "US"),
        new Locale("x", "US"),
        new Locale("en", "", "a-b"),
        // the POSIX locale, and other languages without separators that aren't valid BCP 47
        new Locale("C"),
        new Locale("x"))
        .map(Arguments::of);
  }

  static Stream<Arguments> locales() {
    return Stream.of(
        "es",
        "es-ES",
        "zh-Hant-TW",
        "en-Latn",
        "th-TH-u-nu-thai",
        "de-DE-u-co-phonebk-ka-shifted",
        "en-US-u-ca-gregory-x-priv",
        "sr-Latn-RS-x-lvariant-POSIX",
        "de-x-lvariant-POSIX",
        "ja-JP-u-ca-japanese-x-lvariant-JP",
        "sl-rozaj-biske",
        "en-US-x-priv-lvariant-POSIX")
        .map(Locale::forLanguageTag)
        .map(Arguments::of);
  }

  public static class Plain {
    public Year year = Year.of(2024);
    public Month month = Month.JANUARY;
    public java.sql.Date sqlDate = sqlDate();
    public Locale locale = Locale.forLanguageTag("zh-Hant-TW");
  }

  /**
   * A pattern that also matches yyyy-MM-dd, read as midnight in UTC like Jackson does, not as a local date.
   */
  public static class UtcPattern {
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    public java.sql.Date sqlDate;
  }

  public static class Annotated {
    @JsonFormat(pattern = "yy")
    public Year year = Year.of(2024);
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    public Month month = Month.JANUARY;
    @JsonFormat(pattern = "dd/MM/yyyy")
    public java.sql.Date sqlDate = sqlDate();
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Year stringYear = Year.of(2024);
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    public java.sql.Date numberSqlDate = sqlDate();
  }
}
