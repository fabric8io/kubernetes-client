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
package io.fabric8.crd.generator.types;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

public class TypeMappingsSpec {

  // Date/Time related types
  public Date date;
  public LocalDate localDate;
  public LocalDateTime localDateTime;
  public ZonedDateTime zonedDateTime;
  public OffsetDateTime offsetDateTime;
  public OffsetTime offsetTime;
  public YearMonth yearMonth;
  public MonthDay monthDay;
  public Instant instant;
  public Duration duration;
  public Period period;
  public Timestamp timestamp;

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

  public byte aByte;
  public Byte aByteObj;
  public byte[] aByteArray;

  public UUID uuid;
}
