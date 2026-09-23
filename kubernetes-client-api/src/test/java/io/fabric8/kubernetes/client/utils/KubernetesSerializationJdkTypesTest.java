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
package io.fabric8.kubernetes.client.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The default serialization keeps the 7.x wire format of the JDK types. The golden file is what 7.9.0 wrote for
 * {@link JdkTypes#sample()}, in any timezone. {@code Optional} values are left out, 7.x failed to write them.
 */
class KubernetesSerializationJdkTypesTest {

  private static final String[] RESTORED_FIELDS = { "year", "month", "sqlDate", "locale", "localeWithScript",
      "localeWithExtension", "yearKeys", "monthKeys", "localeKeys" };

  private TimeZone defaultTimeZone;
  private KubernetesSerialization kubernetesSerialization;

  @BeforeEach
  void setUp() {
    defaultTimeZone = TimeZone.getDefault();
    kubernetesSerialization = new KubernetesSerialization();
  }

  @AfterEach
  void tearDown() {
    TimeZone.setDefault(defaultTimeZone);
  }

  @ParameterizedTest(name = "in {0}")
  @ValueSource(strings = { "America/New_York", "UTC", "Asia/Tokyo" })
  @DisplayName("asJson, writes every JDK type exactly like 7.9.0")
  void asJsonWritesLike790(String timeZone) throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone(timeZone));

    assertThat(kubernetesSerialization.asJson(JdkTypes.sample())).isEqualTo(golden());
  }

  @ParameterizedTest(name = "in {0}")
  @ValueSource(strings = { "America/New_York", "UTC", "Asia/Tokyo" })
  @DisplayName("unmarshal, reads Year, Month, java.sql.Date and Locale (values and map keys) as 7.9.0 wrote them")
  void unmarshalReads790(String timeZone) throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    final JdkTypes expected = JdkTypes.sample();

    assertThat(kubernetesSerialization.unmarshal(golden(), JdkTypes.class))
        .extracting(RESTORED_FIELDS)
        .containsExactly(expected.year, expected.month, expected.sqlDate, expected.locale, expected.localeWithScript,
            expected.localeWithExtension, expected.yearKeys, expected.monthKeys, expected.localeKeys);
  }

  @Test
  @DisplayName("unmarshal, reads Year, Month, java.sql.Date and Locale (values and map keys) as plain Jackson 3 writes them")
  void unmarshalReadsJackson3Form() throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
    final JdkTypes expected = JdkTypes.sample();

    assertThat(kubernetesSerialization.unmarshal("{\"year\":2024,\"month\":0," +
        "\"sqlDate\":\"2024-01-15T05:00:00.000+00:00\",\"locale\":\"es-ES\",\"localeWithScript\":\"zh-Hant-TW\"," +
        "\"localeWithExtension\":\"th-TH-u-nu-thai\",\"yearKeys\":{\"2024\":\"year\"},\"monthKeys\":{\"JANUARY\":\"month\"}," +
        "\"localeKeys\":{\"es-ES\":\"es\",\"zh-Hant-TW\":\"zh\",\"th-TH-u-nu-thai\":\"th\"}}", JdkTypes.class))
        .extracting(RESTORED_FIELDS)
        .containsExactly(expected.year, expected.month, expected.sqlDate, expected.locale, expected.localeWithScript,
            expected.localeWithExtension, expected.yearKeys, expected.monthKeys, expected.localeKeys);
  }

  @Test
  @SuppressWarnings("deprecation")
  @DisplayName("Serialization.yamlMapper, writes Month, java.sql.Date and Locale like 7.9.0's yamlMapper")
  void yamlMapperWritesLike790() {
    TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
    final Map<String, Object> values = new LinkedHashMap<>();
    values.put("month", Month.JANUARY);
    values.put("sqlDate", java.sql.Date.valueOf("2024-01-15"));
    values.put("locale", Locale.forLanguageTag("zh-Hant-TW"));
    values.put("localeKeys", Map.of(Locale.forLanguageTag("zh-Hant-TW"), "zh"));

    // 7.9.0's yamlMapper kept Jackson's default of writing dates as timestamps
    assertThat(YAMLMapper.builder().build().readValue(Serialization.yamlMapper().writeValueAsString(values),
        new TypeReference<Map<String, Object>>() {
        }))
        .containsExactly(
            Map.entry("month", "JANUARY"),
            Map.entry("sqlDate", 1705294800000L),
            Map.entry("locale", "zh_TW_#Hant"),
            Map.entry("localeKeys", Map.of("zh_TW_#Hant", "zh")));
  }

  private static String golden() throws IOException {
    try (
        InputStream is = KubernetesSerializationJdkTypesTest.class.getResourceAsStream("/serialization/jdk-types-7.9.0.json")) {
      return new String(is.readAllBytes(), StandardCharsets.UTF_8).trim();
    }
  }

  public static class JdkTypes {
    public String string;
    public boolean aBoolean;
    public char aChar;
    public byte aByte;
    public short aShort;
    public int anInt;
    public long aLong;
    public float aFloat;
    public double aDouble;
    public BigInteger bigInteger;
    public BigDecimal bigDecimal;
    public StringBuilder stringBuilder;
    public byte[] byteArray;
    public ByteBuffer byteBuffer;
    public Byte[] boxedByteArray;
    public char[] charArray;
    public short[] shortArray;
    public int[] intArray;
    public long[] longArray;
    public float[] floatArray;
    public double[] doubleArray;
    public boolean[] booleanArray;
    public String[] stringArray;
    public List<Integer> integerList;
    public AtomicBoolean atomicBoolean;
    public AtomicInteger atomicInteger;
    public AtomicLong atomicLong;
    public AtomicReference<String> atomicReference;
    public Instant instant;
    public Date date;
    public Calendar calendar;
    public java.sql.Date sqlDate;
    public java.sql.Time sqlTime;
    public java.sql.Timestamp sqlTimestamp;
    public LocalDate localDate;
    public LocalDateTime localDateTime;
    public LocalTime localTime;
    public OffsetDateTime offsetDateTime;
    public OffsetTime offsetTime;
    public ZonedDateTime zonedDateTime;
    public Year year;
    public YearMonth yearMonth;
    public MonthDay monthDay;
    public Month month;
    public DayOfWeek dayOfWeek;
    public Duration duration;
    public Period period;
    public ZoneId zoneId;
    public ZoneOffset zoneOffset;
    public TimeZone timeZone;
    public XMLGregorianCalendar xmlGregorianCalendar;
    public javax.xml.datatype.Duration xmlDuration;
    public Locale locale;
    public Locale localeWithScript;
    public Locale localeWithExtension;
    public UUID uuid;
    public URI uri;
    public URL url;
    public InetAddress inetAddress;
    public InetSocketAddress inetSocketAddress;
    public Currency currency;
    public Charset charset;
    public Pattern pattern;
    public Class<?> clazz;
    public QName qname;
    public Map<Year, String> yearKeys;
    public Map<Month, String> monthKeys;
    public Map<Locale, String> localeKeys;
    public Map<DayOfWeek, String> enumMap;
    public Set<DayOfWeek> enumSet;

    /**
     * Created in the default timezone, java.sql.Date and java.sql.Time are local.
     */
    static JdkTypes sample() throws Exception {
      final Instant instant = Instant.parse("2026-01-02T10:15:30Z");
      final LocalDateTime localDateTime = LocalDateTime.of(2026, 1, 2, 10, 15, 30);
      final GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
      calendar.setTimeInMillis(instant.toEpochMilli());
      final JdkTypes sample = new JdkTypes();
      sample.string = "text";
      sample.aBoolean = true;
      sample.aChar = 'c';
      sample.aByte = 1;
      sample.aShort = 2;
      sample.anInt = Integer.MAX_VALUE;
      sample.aLong = Long.MAX_VALUE;
      sample.aFloat = 1.5f;
      sample.aDouble = 2.5d;
      sample.bigInteger = new BigInteger("123456789012345678901234567890");
      sample.bigDecimal = new BigDecimal("1.10");
      sample.stringBuilder = new StringBuilder("builder");
      sample.byteArray = new byte[] { 1, 2, 3 };
      sample.byteBuffer = ByteBuffer.wrap(new byte[] { 1, 2, 3 });
      sample.boxedByteArray = new Byte[] { 1, 2, 3 };
      sample.charArray = new char[] { 'a', 'b' };
      sample.shortArray = new short[] { 1, 2 };
      sample.intArray = new int[] { 1, 2 };
      sample.longArray = new long[] { 1L, 2L };
      sample.floatArray = new float[] { 1.5f };
      sample.doubleArray = new double[] { 2.5d };
      sample.booleanArray = new boolean[] { true, false };
      sample.stringArray = new String[] { "a", "b" };
      sample.integerList = List.of(1, 2);
      sample.atomicBoolean = new AtomicBoolean(true);
      sample.atomicInteger = new AtomicInteger(3);
      sample.atomicLong = new AtomicLong(4);
      sample.atomicReference = new AtomicReference<>("ref");
      sample.instant = instant;
      sample.date = Date.from(instant);
      sample.calendar = calendar;
      sample.sqlDate = java.sql.Date.valueOf("2024-01-15");
      sample.sqlTime = java.sql.Time.valueOf("10:15:30");
      sample.sqlTimestamp = java.sql.Timestamp.from(instant);
      sample.localDate = LocalDate.of(2026, 1, 2);
      sample.localDateTime = localDateTime;
      sample.localTime = localDateTime.toLocalTime();
      sample.offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(1));
      sample.offsetTime = OffsetTime.of(localDateTime.toLocalTime(), ZoneOffset.ofHours(1));
      sample.zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Madrid"));
      sample.year = Year.of(2024);
      sample.yearMonth = YearMonth.of(2026, 1);
      sample.monthDay = MonthDay.of(12, 25);
      sample.month = Month.JANUARY;
      sample.dayOfWeek = DayOfWeek.MONDAY;
      sample.duration = Duration.ofMinutes(90);
      sample.period = Period.ofDays(3);
      sample.zoneId = ZoneId.of("Europe/Madrid");
      sample.zoneOffset = ZoneOffset.ofHours(1);
      sample.timeZone = TimeZone.getTimeZone("Europe/Madrid");
      sample.xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
      sample.xmlDuration = DatatypeFactory.newInstance().newDuration("P1DT2H");
      sample.locale = Locale.forLanguageTag("es-ES");
      sample.localeWithScript = Locale.forLanguageTag("zh-Hant-TW");
      sample.localeWithExtension = Locale.forLanguageTag("th-TH-u-nu-thai");
      sample.uuid = UUID.fromString("9f1c7a5e-3b2d-4c1e-8f6a-0d9e8b7c6a5f");
      sample.uri = URI.create("https://example.com/a?b=c");
      sample.url = URI.create("https://example.com/a?b=c").toURL();
      sample.inetAddress = InetAddress.getByName("127.0.0.1");
      sample.inetSocketAddress = InetSocketAddress.createUnresolved("example.com", 8080);
      sample.currency = Currency.getInstance("EUR");
      sample.charset = StandardCharsets.UTF_8;
      sample.pattern = Pattern.compile("a+b");
      sample.clazz = String.class;
      sample.qname = new QName("urn:example", "local", "ex");
      sample.yearKeys = new LinkedHashMap<>(Map.of(Year.of(2024), "year"));
      sample.monthKeys = new LinkedHashMap<>(Map.of(Month.JANUARY, "month"));
      sample.localeKeys = new LinkedHashMap<>();
      sample.localeKeys.put(Locale.forLanguageTag("es-ES"), "es");
      sample.localeKeys.put(Locale.forLanguageTag("zh-Hant-TW"), "zh");
      sample.localeKeys.put(Locale.forLanguageTag("th-TH-u-nu-thai"), "th");
      sample.enumMap = new EnumMap<>(Map.of(DayOfWeek.MONDAY, "monday"));
      sample.enumSet = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.FRIDAY);
      return sample;
    }
  }
}
