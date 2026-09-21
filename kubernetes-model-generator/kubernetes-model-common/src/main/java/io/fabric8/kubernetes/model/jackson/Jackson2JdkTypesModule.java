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
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.KeyDeserializer;
import tools.jackson.databind.SerializationConfig;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.deser.jdk.JDKFromStringDeserializer;
import tools.jackson.databind.deser.jdk.JDKKeyDeserializer;
import tools.jackson.databind.ext.javatime.ser.YearSerializer;
import tools.jackson.databind.ext.sql.JavaSqlDateDeserializer;
import tools.jackson.databind.ext.sql.JavaSqlDateSerializer;
import tools.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import tools.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.Serializers;
import tools.jackson.databind.ser.jdk.EnumSerializer;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.StringJoiner;

/**
 * Writes the JDK types whose format changed with Jackson 3 as Jackson 2 did: {@link Year} as {@code "2024"} (not
 * {@code 2024}), {@link Month} as {@code "JANUARY"} (not {@code 0}), {@link java.sql.Date} as {@code "2024-01-15"} (not a
 * UTC date-time) and {@link Locale} as {@link Locale#toString()} ({@code "zh_TW_#Hant"}, not {@code "zh-Hant-TW"}).
 * {@code @JsonFormat} and {@link DateTimeFeature#WRITE_DATES_AS_TIMESTAMPS} apply as they did in Jackson 2.
 * <p>
 * Both forms are read. A {@code yyyy-MM-dd} {@link java.sql.Date} is read as a local date, so it keeps its day in any
 * timezone (Jackson 2 read it as UTC midnight).
 * <p>
 * {@code new KubernetesSerialization()} registers it. Mappers you build yourself need it to keep the Jackson 2 format.
 */
public class Jackson2JdkTypesModule extends SimpleModule {

  /**
   * Optional, like for Jackson: runtimes without the java.sql module (e.g. jlink images) have no java.sql.Date.
   */
  private static final boolean JAVA_SQL = isPresent("java.sql.Date");

  @SuppressWarnings({ "unchecked", "rawtypes" }) // Jackson's JDK deserializers are typed as Object
  public Jackson2JdkTypesModule() {
    addSerializer(Year.class, new Jackson2YearSerializer());
    if (JAVA_SQL) {
      addSerializer(java.sql.Date.class, new Jackson2SqlDateSerializer());
      addDeserializer(java.sql.Date.class, new Jackson2SqlDateDeserializer());
    }
    addSerializer(Locale.class, ToStringSerializer.instance);
    addDeserializer(Locale.class, (ValueDeserializer) new Jackson2LocaleDeserializer());
    addKeyDeserializer(Locale.class, new Jackson2LocaleKeyDeserializer());
  }

  @Override
  public void setupModule(SetupContext context) {
    super.setupModule(context);
    context.addSerializers(new Jackson2MonthSerializers());
  }

  private static boolean isPresent(String className) {
    try {
      Class.forName(className, false, Jackson2JdkTypesModule.class.getClassLoader());
      return true;
    } catch (ClassNotFoundException | LinkageError e) {
      return false;
    }
  }

  /**
   * Parses the {@link Locale#toString()} of a locale with a script or extensions, the form Jackson 2 wrote:
   * {@code language_REGION_variant_#script_extensions}. Jackson 3 doesn't know the {@code _#} marker and reads the
   * script and extensions as part of the variant, it reads the rest of the Jackson 2 forms like Jackson 2 did.
   */
  private static Locale fromLocaleString(String value) {
    final int marker = value.indexOf("_#");
    final String[] base = value.substring(0, marker).split("_", 3);
    final String suffix = value.substring(marker + 2);
    final int separator = suffix.indexOf('_');
    String script = "";
    String extensions = "";
    if (separator >= 0) {
      script = suffix.substring(0, separator);
      extensions = suffix.substring(separator + 1);
    } else if (suffix.indexOf('-') >= 0) {
      extensions = suffix;
    } else {
      script = suffix;
    }
    final StringJoiner tag = new StringJoiner("-");
    tag.add(base[0].isEmpty() ? "und" : base[0]);
    addIfPresent(tag, script);
    addIfPresent(tag, base.length > 1 ? base[1] : "");
    addIfPresent(tag, extensions);
    if (base.length > 2 && !base[2].isEmpty()) {
      // the private use form of the variant, which also takes the legacy variants BCP 47 doesn't (e.g. ja_JP_JP)
      final boolean hasPrivateUse = extensions.startsWith("x-") || extensions.contains("-x-");
      tag.add((hasPrivateUse ? "lvariant-" : "x-lvariant-") + base[2].replace('_', '-'));
    }
    return Locale.forLanguageTag(tag.toString());
  }

  private static void addIfPresent(StringJoiner tag, String subtags) {
    if (!subtags.isEmpty()) {
      tag.add(subtags);
    }
  }

  /**
   * Jackson 3 always writes a {@link Year} as a number unless the shape says otherwise, Jackson 2 followed
   * {@link DateTimeFeature#WRITE_DATES_AS_TIMESTAMPS}.
   */
  static final class Jackson2YearSerializer extends YearSerializer {

    Jackson2YearSerializer() {
      super(null);
    }

    private Jackson2YearSerializer(Jackson2YearSerializer base, DateTimeFormatter dtf, Boolean useTimestamp) {
      super(base, dtf, useTimestamp);
    }

    @Override
    protected Jackson2YearSerializer withFormat(DateTimeFormatter dtf, Boolean useTimestamp, JsonFormat.Shape shape) {
      return new Jackson2YearSerializer(this, dtf, useTimestamp);
    }

    @Override
    protected boolean useTimestampFromGlobalDefaults(SerializationContext ctxt) {
      return ctxt != null && ctxt.isEnabled(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) {
      if (useTimestamp(visitor.getContext())) {
        super.acceptJsonFormatVisitor(visitor, typeHint);
      } else {
        // Jackson reports date-time, which "2024" doesn't match
        visitor.expectStringFormat(typeHint);
      }
    }
  }

  /**
   * Jackson 3 writes a {@link java.sql.Date} like a {@link java.util.Date}: a UTC date-time of its local midnight.
   */
  static final class Jackson2SqlDateSerializer extends JavaSqlDateSerializer {

    Jackson2SqlDateSerializer() {
      this(null, null);
    }

    private Jackson2SqlDateSerializer(Boolean useTimestamp, DateFormat customFormat) {
      super(useTimestamp, customFormat);
    }

    @Override
    public Jackson2SqlDateSerializer withFormat(Boolean timestamp, DateFormat customFormat) {
      return new Jackson2SqlDateSerializer(timestamp, customFormat);
    }

    @Override
    public void serialize(java.sql.Date value, JsonGenerator g, SerializationContext ctxt) {
      if (!_asTimestamp(ctxt) && _customFormat == null) {
        g.writeString(value.toString());
        return;
      }
      super.serialize(value, g, ctxt);
    }

    @Override
    protected void _acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint, boolean asNumber) {
      if (asNumber) {
        super._acceptJsonFormatVisitor(visitor, typeHint, true);
      } else if (_customFormat == null) {
        visitStringFormat(visitor, typeHint, JsonValueFormat.DATE);
      } else {
        visitStringFormat(visitor, typeHint);
      }
    }
  }

  static final class Jackson2SqlDateDeserializer extends JavaSqlDateDeserializer {

    Jackson2SqlDateDeserializer() {
      super();
    }

    private Jackson2SqlDateDeserializer(Jackson2SqlDateDeserializer src, DateFormat df, String formatString) {
      super(src, df, formatString);
    }

    @Override
    protected Jackson2SqlDateDeserializer withDateFormat(DateFormat df, String formatString) {
      return new Jackson2SqlDateDeserializer(this, df, formatString);
    }

    @Override
    public java.sql.Date deserialize(JsonParser p, DeserializationContext ctxt) {
      if (_customFormat == null && p.hasToken(JsonToken.VALUE_STRING)) {
        try {
          return java.sql.Date.valueOf(LocalDate.parse(p.getString().trim()));
        } catch (DateTimeParseException e) {
          // not yyyy-MM-dd, read it like Jackson does
        }
      }
      return super.deserialize(p, ctxt);
    }
  }

  static final class Jackson2LocaleDeserializer extends JDKFromStringDeserializer {

    Jackson2LocaleDeserializer() {
      super(Locale.class, STD_LOCALE);
    }

    @Override
    public Object _deserialize(String value, DeserializationContext ctxt)
        throws MalformedURLException, UnknownHostException {
      return value.contains("_#") ? fromLocaleString(value) : super._deserialize(value, ctxt);
    }
  }

  static final class Jackson2LocaleKeyDeserializer extends KeyDeserializer {

    private final KeyDeserializer jackson = JDKKeyDeserializer.forType(Locale.class);

    @Override
    public Object deserializeKey(String key, DeserializationContext ctxt) {
      if (key.isEmpty()) {
        // Locale.ROOT, which Jackson 2 read back and Jackson 3 rejects
        return Locale.ROOT;
      }
      return key.contains("_#") ? fromLocaleString(key) : jackson.deserializeKey(key, ctxt);
    }
  }

  /**
   * Jackson 2 had no {@link Month} serializer and wrote it like any other enum (by name, enum schema), Jackson 3 writes
   * its zero-based index.
   */
  static final class Jackson2MonthSerializers extends Serializers.Base {

    @Override
    public ValueSerializer<?> findEnumSerializer(SerializationConfig config, JavaType type,
        BeanDescription.Supplier beanDescRef, JsonFormat.Value formatOverrides) {
      if (type.hasRawClass(Month.class)) {
        return EnumSerializer.construct(Month.class, config, beanDescRef.get(),
            calculateEffectiveFormat(beanDescRef, Month.class, formatOverrides));
      }
      return null;
    }
  }
}
