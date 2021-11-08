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

import java.util.Map;
import java.util.Optional;

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

  private final BeanPropertyWriter delegate;
  private final AnnotatedMember anyGetter;

  BeanPropertyWriterDelegate(BeanPropertyWriter delegate, AnnotatedMember anyGetter) {
    super(delegate);
    this.delegate = delegate;
    this.anyGetter = anyGetter;
  }

  @Override
  public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
    if (shouldSerializeProperty(bean)) {
      delegate.serializeAsField(bean, gen, prov);
    }
  }

  private boolean shouldSerializeProperty(Object bean) {
    return !Optional.ofNullable(anyGetter)
      .map(ag -> ag.getValue(bean))
      .map(Map.class::cast)
      .map(m -> m.get(delegate.getName()))
      .isPresent();
  }
}
