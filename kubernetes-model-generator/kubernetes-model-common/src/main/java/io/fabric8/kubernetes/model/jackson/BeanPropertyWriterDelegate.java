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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.introspect.AnnotatedMember;
import tools.jackson.databind.jsontype.TypeSerializer;
import tools.jackson.databind.ser.BeanPropertyWriter;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Variant of {@link BeanPropertyWriter} which prevents property values present in the {@link AnnotatedMember} anyGetter
 * to be serialized twice.
 *
 * <p>
 * Any property that's present in the anyGetter is ignored upon serialization. The values present in the anyGetter
 * take precedence over those stored in the Bean's fields.
 *
 * <p>
 * This BeanPropertyWriter implementation is intended to be used in combination with
 * the {@link SettableBeanPropertyDelegating} to allow the propagation of deserialized properties that don't match the
 * target field types.
 */
public class BeanPropertyWriterDelegate extends BeanPropertyWriter {

  private static final Logger logger = LoggerFactory.getLogger(BeanPropertyWriterDelegate.class);

  private final BeanPropertyWriter delegate;
  private final AnnotatedMember anyGetter;
  private final transient Supplier<Boolean> logDuplicateWarning;

  BeanPropertyWriterDelegate(BeanPropertyWriter delegate, AnnotatedMember anyGetter, Supplier<Boolean> logDuplicateWarning) {
    super(delegate);
    this.delegate = delegate;
    this.anyGetter = anyGetter;
    this.logDuplicateWarning = logDuplicateWarning;
  }

  @Override
  public void serializeAsProperty(Object bean, JsonGenerator gen, SerializationContext prov) throws Exception {
    Object valueInAnyGetter = null;
    if (anyGetter != null) {
      Object anyGetterValue = anyGetter.getValue(bean);
      if (anyGetterValue != null) {
        valueInAnyGetter = ((Map<?, ?>) anyGetterValue).get(delegate.getName());
      }
    }
    if (valueInAnyGetter == null) {
      delegate.serializeAsProperty(bean, gen, prov);
    } else if (Boolean.TRUE.equals(logDuplicateWarning.get())) {
      logger.warn("Value in field '{}' ignored in favor of value in additionalProperties ({}) for {}",
          delegate.getName(), valueInAnyGetter, bean.getClass().getName());
    }
  }

  @Override
  public void assignNullSerializer(ValueSerializer<Object> nullSer) {
    delegate.assignNullSerializer(nullSer);
  }

  @Override
  public void assignSerializer(ValueSerializer<Object> ser) {
    delegate.assignSerializer(ser);
  }

  @Override
  public void assignTypeSerializer(TypeSerializer typeSer) {
    delegate.assignTypeSerializer(typeSer);
  }
}
