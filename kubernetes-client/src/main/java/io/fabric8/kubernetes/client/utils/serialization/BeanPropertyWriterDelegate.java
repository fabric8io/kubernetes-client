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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Variant of {@link BeanPropertyWriter} which prevents property values present in the {@link AnnotatedMember} anyGetter
 * to be serialized twice.
 *
 * <p> Any property that's present in the anyGetter is ignored upon serialization. The values present in the anyGetter
 * take precedence over those stored in the Bean's fields.
 *
 * <p> This BeanPropertyWriter implementation is intended to be used in combination with
 * the {@link SettableBeanPropertyDelegate} to allow the propagation of deserialized properties that don't match the
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
  public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
    final Object valueInAnyGetter = Optional.ofNullable(anyGetter)
      .map(ag -> ag.getValue(bean))
      .map(Map.class::cast)
      .map(m -> m.get(delegate.getName()))
      .orElse(null);
    if (valueInAnyGetter == null) {
      delegate.serializeAsField(bean, gen, prov);
    } else if (Boolean.TRUE.equals(logDuplicateWarning.get())) {
      logger.warn("Value in field '{}' ignored in favor of value in additionalProperties ({}) for {}",
        delegate.getName(), valueInAnyGetter, bean.getClass().getName());
    }
  }
}
