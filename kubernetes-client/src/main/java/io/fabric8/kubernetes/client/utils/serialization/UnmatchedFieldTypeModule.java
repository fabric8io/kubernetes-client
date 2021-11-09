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
package io.fabric8.kubernetes.client.utils.serialization;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

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

  public UnmatchedFieldTypeModule() {
    this(true, true);
  }

  public UnmatchedFieldTypeModule(boolean logWarnings, boolean restrictToTemplates) {
    this.logWarnings = logWarnings;
    this.restrictToTemplates = restrictToTemplates;
    setDeserializerModifier(new BeanDeserializerModifier() {

      @Override
      public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc, BeanDeserializerBuilder builder) {
        builder.getProperties().forEachRemaining(p ->
          builder.addOrReplaceProperty(new SettableBeanPropertyDelegate(p, builder.getAnySetter(), UnmatchedFieldTypeModule.this::isRestrictToTemplates) {
          }, true));
        return builder;
      }
    });
    setSerializerModifier(new BeanSerializerModifier() {
      @Override
      public BeanSerializerBuilder updateBuilder(SerializationConfig config, BeanDescription beanDesc, BeanSerializerBuilder builder) {
        builder.setProperties(builder.getProperties().stream().map(p ->
          new BeanPropertyWriterDelegate(p, builder.getBeanDescription().findAnyGetter(), UnmatchedFieldTypeModule.this::isLogWarnings))
          .collect(Collectors.toList()));
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

  /**
   * Sets if the DeserializerModifier should only be applied to Templates or object trees contained in Templates.
   *
   * @param restrictToTemplates if true, the DeserializerModifier will only be applicable for Templates.
   */
  public void setRestrictToTemplates(boolean restrictToTemplates) {
    this.restrictToTemplates = restrictToTemplates;
  }
}
