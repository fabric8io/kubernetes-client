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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.function.Supplier;

/**
 * This concrete sub-class encapsulates a {@link SettableBeanProperty} delegate that is always tried first.
 *
 * <p> A fall-back mechanism is implemented in the deserializeAndSet methods to allow field values that don't match the
 * target type to be preserved in the anySetter method if exists.
 */
public class SettableBeanPropertyDelegate extends SettableBeanProperty {

  private final SettableBeanProperty delegate;
  private final SettableAnyProperty anySetter;
  private final transient Supplier<Boolean> restrictToTemplates;

  SettableBeanPropertyDelegate(SettableBeanProperty delegate, SettableAnyProperty anySetter, Supplier<Boolean> restrictToTemplates) {
    super(delegate);
    this.delegate = delegate;
    this.anySetter = anySetter;
    this.restrictToTemplates = restrictToTemplates;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> deser) {
    return new SettableBeanPropertyDelegate(delegate.withValueDeserializer(deser), anySetter, restrictToTemplates);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SettableBeanProperty withName(PropertyName newName) {
    return new SettableBeanPropertyDelegate(delegate.withName(newName), anySetter, restrictToTemplates);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SettableBeanProperty withNullProvider(NullValueProvider nva) {
    return new SettableBeanPropertyDelegate(delegate.withNullProvider(nva), anySetter, restrictToTemplates);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AnnotatedMember getMember() {
    return delegate.getMember();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <A extends Annotation> A getAnnotation(Class<A> acls) {
    return delegate.getAnnotation(acls);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void fixAccess(DeserializationConfig config) {
    delegate.fixAccess(config);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void markAsIgnorable() {
    delegate.markAsIgnorable();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isIgnorable() {
    return delegate.isIgnorable();
  }

  /**
   * Method called to deserialize appropriate value, given parser (and context), and set it using appropriate mechanism.
   *
   * <p> Deserialization is first tried through the delegate. In case a {@link MismatchedInputException} is caught,
   * the field is stored in the bean's {@link SettableAnyProperty} anySetter field if it exists.
   *
   * <p> This allows deserialization processes propagate values that initially don't match the target bean type for the
   * applicable field.
   *
   * <p> An example use-case is the use of placeholders (e.g. {@code ${aValue}}) in a field.
   */
  @Override
  public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
    try {
      delegate.deserializeAndSet(p, ctxt, instance);
    } catch (MismatchedInputException ex) {
      if (shouldUseAnySetter()) {
        anySetter.set(instance, delegate.getName(), p.getText());
      } else {
        throw ex;
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
    try {
      return delegate.deserializeSetAndReturn(p, ctxt, instance);
    } catch (MismatchedInputException ex) {
      deserializeAndSet(p, ctxt, instance);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void set(Object instance, Object value) throws IOException {
    delegate.set(instance, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object setAndReturn(Object instance, Object value) throws IOException {
    return delegate.setAndReturn(instance, value);
  }

  private boolean shouldUseAnySetter() {
    if (anySetter == null) {
      return false;
    }
    if (Boolean.TRUE.equals(restrictToTemplates.get()) ) {
      return KubernetesDeserializer.isInTemplate();
    }
    return true;
  }
}
