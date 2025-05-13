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

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.lang.reflect.Member;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that registers the capability of deserializing and serializing objects with properties that don't match the
 * target's bean field types.
 *
 * <pre>{@code
 * ObjectMapper mapper = new ObjectMapper();
 * mapper.registerModule(new UnmatchedFieldTypeModule());
 * }</pre>
 */
public class UnmatchedFieldTypeModule extends SimpleModule {

  private boolean logWarnings;
  private boolean restrictToTemplates;

  private static final ThreadLocal<Boolean> IN_TEMPLATE = ThreadLocal.withInitial(() -> false);

  public UnmatchedFieldTypeModule() {
    this(true, true);
  }

  public UnmatchedFieldTypeModule(boolean logWarnings, boolean restrictToTemplates) {
    this.logWarnings = logWarnings;
    this.restrictToTemplates = restrictToTemplates;
    setDeserializerModifier(new BeanDeserializerModifier() {

      @Override
      public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc,
          BeanDeserializerBuilder builder) {
        builder.getProperties().forEachRemaining(p -> builder.addOrReplaceProperty(
            new SettableBeanPropertyDelegating(p, builder.getAnySetter(), UnmatchedFieldTypeModule.this::useAnySetter) {
            }, true));
        return builder;
      }
    });
    setSerializerModifier(new BeanSerializerModifier() {
      /**
       * Customizes property writers used during serialization.
       *
       * This method wraps standard property writers in a delegate that can suppress serialization
       * of fields that may be overridden by values in the map returned by {@code @JsonAnyGetter}.
       *
       * The property corresponding to the {@code @JsonAnyGetter} method itself is left unmodified
       * to avoid interfering with Jackson’s internal handling via {@link com.fasterxml.jackson.databind.ser.AnyGetterWriter}.
       *
       * This mechanism ensures that if a field is both explicitly declared and also present in the
       * any-getter map, only the value from the any-getter is serialized, avoiding duplication or conflicts.
       */
      @Override
      public BeanSerializerBuilder updateBuilder(SerializationConfig config, BeanDescription beanDesc,
          BeanSerializerBuilder builder) {
        AnnotatedMember anyGetter = beanDesc.findAnyGetter();
        Member anyGetterMember = (anyGetter != null) ? anyGetter.getMember() : null;

        // Wrap each property writer unless it's the any-getter (handled by Jackson separately)
        List<BeanPropertyWriter> customWriters = builder.getProperties().stream()
            .map(writer -> {
              if (isAnyGetterWriter(writer, anyGetterMember)) {
                // Skipping wrapping for any-getter to avoid interfering with Jackson's internal handling
                return writer;
              }
              // Wrap normal field writers with delegate to handle overrides and logging
              return new BeanPropertyWriterDelegate(
                  writer,
                  anyGetter,
                  UnmatchedFieldTypeModule.this::isLogWarnings);
            })
            .collect(Collectors.toList());

        builder.setProperties(customWriters);
        return builder;
      }
    });
  }

  boolean isLogWarnings() {
    return logWarnings;
  }

  /**
   * Set if warnings should be logged for ambiguous serializer and deserializer situations.
   *
   * @param logWarnings if true, warnings will be logged.
   */
  public void setLogWarnings(boolean logWarnings) {
    this.logWarnings = logWarnings;
  }

  boolean isRestrictToTemplates() {
    return restrictToTemplates;
  }

  boolean useAnySetter() {
    return !restrictToTemplates || isInTemplate();
  }

  /**
   * Sets if the DeserializerModifier should only be applied to Templates or object trees contained in Templates.
   *
   * @param restrictToTemplates if true, the DeserializerModifier will only be applicable for Templates.
   */
  public void setRestrictToTemplates(boolean restrictToTemplates) {
    this.restrictToTemplates = restrictToTemplates;
  }

  public static boolean isInTemplate() {
    return Boolean.TRUE.equals(IN_TEMPLATE.get());
  }

  public static void setInTemplate() {
    IN_TEMPLATE.set(true);
  }

  public static void removeInTemplate() {
    IN_TEMPLATE.remove();
  }

  /**
   * Checks whether the given {@link BeanPropertyWriter} corresponds to the method annotated with {@code @JsonAnyGetter}.
   *
   * This is used to identify and exclude the any-getter property from custom wrapping,
   * since Jackson handles it separately via {@link com.fasterxml.jackson.databind.ser.AnyGetterWriter}.
   *
   * @param writer the property writer to examine
   * @param anyGetterMember the reflective member (method or field) marked with {@code @JsonAnyGetter}, if available
   * @return {@code true} if the writer represents the any-getter property; {@code false} otherwise
   */
  private static boolean isAnyGetterWriter(BeanPropertyWriter writer, Member anyGetterMember) {
    if (writer == null || anyGetterMember == null) {
      return false;
    }
    AnnotatedMember annotated = writer.getMember();
    Member member = (annotated != null) ? annotated.getMember() : null;
    return member != null && member.equals(anyGetterMember);
  }
}
