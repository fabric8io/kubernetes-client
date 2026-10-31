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
package io.fabric8.crd.generator.approvaltests.jdktypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.fabric8.generator.annotation.Size;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.xml.namespace.QName;

/**
 * The JDK types Jackson writes differently from what it reports (binary types, char[] and QName are strings), that
 * Jackson2JdkTypesModule writes in their Jackson 2 form, and the integers controller-gen gives a range-checked format.
 * GeneratedCRDsOnApiServerTest round-trips a populated instance through a real API server.
 */
@Getter
@Setter
public class JdkTypesSpec {

  private byte[] bytes;
  private ByteBuffer byteBuffer;
  private Optional<byte[]> optionalBytes;
  private List<byte[]> byteArrays;
  private Map<String, byte[]> byteArrayMap;
  /** Bounds the base64 length, the round-trip writes exactly the maximum. */
  @Size(max = 100)
  private byte[] maxSizedBytes;
  /** Bounds the base64 length, the round-trip writes exactly the minimum. */
  @Size(min = 2)
  private byte[] minSizedBytes;
  /** The API server rejects an empty string for format: byte. */
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private byte[] emptyBytes;
  /** Written as arrays of numbers. */
  private Byte[] boxedBytes;
  private List<Byte> byteList;
  private char[] chars;
  private QName qname;
  /** Jackson describes the QNames after the first one with a reference to it. */
  private List<QName> qnames;
  private Year year;
  private List<Year> years;
  private Month month;
  private Map<String, Month> months;
  private java.sql.Date sqlDate;
  private List<java.sql.Date> sqlDates;
  private Locale locale;
  private Map<String, Locale> locales;
  private Map<Locale, String> localeKeys;
  private Integer maxInt;
  private Long maxLong;
  private List<Integer> ints;
  private Map<String, Long> longs;
}
