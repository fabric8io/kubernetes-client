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
package io.fabric8.crdv2.example.types;

import io.fabric8.generator.annotation.Size;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import tools.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import tools.jackson.databind.ser.std.StdSerializer;
import tools.jackson.databind.ser.std.ToStringSerializer;
import tools.jackson.databind.util.StdConverter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.sql.Time;
import java.sql.Timestamp;
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
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.namespace.QName;

public class TypeMappingsSpec {

  // Date/Time related types
  public Date date;
  public LocalDate localDate;
  public LocalDateTime localDateTime;
  public LocalTime localTime;
  public ZonedDateTime zonedDateTime;
  public OffsetDateTime offsetDateTime;
  public OffsetTime offsetTime;
  public YearMonth yearMonth;
  public MonthDay monthDay;
  public Instant instant;
  public Duration duration;
  public Period period;
  public Timestamp timestamp;
  public java.sql.Date sqlDate;
  public Time sqlTime;
  public Calendar calendar;
  public Optional<Instant> optionalInstant;
  public Optional<Duration> optionalDuration;
  public Year year;
  public Month month;

  // Number related types
  public short aShort;
  public Short aShortObj;
  public int aInt;
  public Integer aIntegerObj;
  public long aLong;
  public Long aLongObj;
  public double aDouble;
  public Double aDoubleObj;
  public float aFloat;
  public Float aFloatObj;
  public Number aNumber;
  public BigInteger aBigInteger;
  public BigDecimal aBigDecimal;
  public Optional<Integer> optionalInteger;
  public OptionalInt optionalInt;
  public OptionalLong optionalLong;
  public AtomicInteger atomicInteger;
  public AtomicLong atomicLong;
  public int[] intArray;
  public long[] longArray;
  public List<Integer> integerList;
  public Map<String, Long> longMap;
  /** Written as decimals by the property's serializer or converter, which report a number. */
  @JsonSerialize(using = RatioSerializer.class)
  public Integer ratio;
  @JsonSerialize(converter = RatioConverter.class)
  public Long convertedRatio;

  // Boolean related types
  public boolean aBoolean;
  public Boolean aBooleanObj;

  // String related types
  public char aChar;
  public Character aCharacterObj;
  public char[] aCharArray;
  public CharSequence aCharSequence;
  public String aString;
  public String[] aStringArray;
  public Locale locale;
  public QName qname;
  /** Jackson describes the types it has already seen with a reference to the first one. */
  public QName otherQname;
  public List<QName> qnameList;
  public Map<String, QName> qnameMap;

  // Binary related types
  public byte aByte;
  public Byte aByteObj;
  public byte[] aByteArray;
  public ByteBuffer byteBuffer;
  public Optional<byte[]> optionalByteArray;
  public List<byte[]> byteArrayList;
  public Map<String, byte[]> byteArrayMap;
  public Byte[] boxedByteArray;
  public List<Byte> byteList;
  @Size(min = 1, max = 1024)
  public byte[] sizedByteArray;
  @Size(min = 3, max = 6)
  public ByteBuffer sizedByteBuffer;
  public List<@Size(max = 3) ByteBuffer> sizedByteBufferList;
  /** Written by a serializer that reports a plain string, @Size limits that string. */
  @JsonSerialize(using = ToStringSerializer.class)
  @Size(max = 3)
  public byte[] stringSerializedBytes;
  @JsonSerialize(using = NumbersSerializer.class)
  public byte[] numberSerializedBytes;
  @JsonSerialize(contentUsing = NumbersSerializer.class)
  public List<byte[]> numberSerializedByteArrays;
  @JsonSerialize(contentUsing = NumbersSerializer.class)
  public Optional<byte[]> numberSerializedOptionalBytes;

  public UUID uuid;

  /**
   * Writes a percentage as a ratio.
   */
  public static class RatioSerializer extends StdSerializer<Integer> {

    public RatioSerializer() {
      super(Integer.class);
    }

    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializationContext provider) {
      gen.writeNumber(value / 100d);
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) {
      visitor.expectNumberFormat(typeHint);
    }
  }

  public static class RatioConverter extends StdConverter<Long, Double> {

    @Override
    public Double convert(Long value) {
      return value / 100d;
    }
  }

  /**
   * Writes a byte[] as an array of numbers, like Jackson does for a Byte[].
   */
  public static class NumbersSerializer extends StdSerializer<byte[]> {

    public NumbersSerializer() {
      super(byte[].class);
    }

    @Override
    public void serialize(byte[] value, JsonGenerator gen, SerializationContext provider) {
      gen.writeStartArray();
      for (byte b : value) {
        gen.writeNumber(b);
      }
      gen.writeEndArray();
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) {
      visitArrayFormat(visitor, typeHint, JsonFormatTypes.INTEGER);
    }
  }
}
