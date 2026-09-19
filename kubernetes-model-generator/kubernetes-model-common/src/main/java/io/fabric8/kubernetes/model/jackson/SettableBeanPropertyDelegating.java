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

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.PropertyName;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.cfg.MapperConfig;
import tools.jackson.databind.deser.NullValueProvider;
import tools.jackson.databind.deser.SettableAnyProperty;
import tools.jackson.databind.deser.SettableBeanProperty;
import tools.jackson.databind.exc.MismatchedInputException;
import tools.jackson.databind.introspect.ObjectIdInfo;
import tools.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import tools.jackson.databind.util.NameTransformer;

import java.lang.annotation.Annotation;
import java.util.function.BooleanSupplier;

/**
 * This concrete subclass encapsulates a {@link SettableBeanProperty} delegate that is always tried first.
 *
 * <p>
 * A fall-back mechanism is implemented in the deserializeAndSet methods to allow field values that don't match the
 * target type to be preserved in the anySetter method if exists.
 */
public class SettableBeanPropertyDelegating extends SettableBeanProperty.Delegating {

  private final SettableAnyProperty anySetter;
  private final transient BooleanSupplier useAnySetter;

  SettableBeanPropertyDelegating(SettableBeanProperty delegate, SettableAnyProperty anySetter, BooleanSupplier useAnySetter) {
    super(delegate);
    this.anySetter = anySetter;
    this.useAnySetter = useAnySetter;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected SettableBeanProperty withDelegate(SettableBeanProperty d) {
    return new SettableBeanPropertyDelegating(d, anySetter, useAnySetter);
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
  public boolean isMerging() {
    return delegate.isMerging();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public JacksonInject.Value getInjectionDefinition() {
    return delegate.getInjectionDefinition();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isIgnorable() {
    return delegate.isIgnorable();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setViews(Class<?>[] views) {
    delegate.setViews(views);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <A extends Annotation> A getContextAnnotation(Class<A> acls) {
    return delegate.getContextAnnotation(acls);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PropertyName getWrapperName() {
    return delegate.getWrapperName();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public JsonInclude.Value findPropertyInclusion(MapperConfig<?> config, Class<?> baseType) {
    return delegate.findPropertyInclusion(config, baseType);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NullValueProvider getNullValueProvider() {
    return delegate.getNullValueProvider();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void depositSchemaProperty(JsonObjectFormatVisitor objectVisitor, SerializationContext provider)
      throws DatabindException {
    delegate.depositSchemaProperty(objectVisitor, provider);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public JavaType getType() {
    return delegate.getType();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PropertyName getFullName() {
    return delegate.getFullName();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setManagedReferenceName(String n) {
    delegate.setManagedReferenceName(n);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SettableBeanProperty withSimpleName(String simpleName) {
    return _with(delegate.withSimpleName(simpleName));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SettableBeanProperty unwrapped(DeserializationContext ctxt, NameTransformer unwrapper) {
    return _with(delegate.unwrapped(ctxt, unwrapper));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setObjectIdInfo(ObjectIdInfo objectIdInfo) {
    delegate.setObjectIdInfo(objectIdInfo);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return delegate.toString();
  }

  /**
   * Method called to deserialize appropriate value, given parser (and context), and set it using appropriate mechanism.
   *
   * <p>
   * Deserialization is first tried through the delegate. In case a {@link MismatchedInputException} is caught,
   * the field is stored in the bean's {@link SettableAnyProperty} anySetter field if it exists.
   *
   * <p>
   * This allows deserialization processes propagate values that initially don't match the target bean type for the
   * applicable field.
   *
   * <p>
   * An example use-case is the use of placeholders (e.g. {@code ${aValue}}) in a field.
   */
  @Override
  public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) {
    try {
      delegate.deserializeAndSet(p, ctxt, instance);
    } catch (MismatchedInputException ex) {
      if (shouldUseAnySetter()) {
        anySetter.set(ctxt, instance, delegate.getName(), p.getText());
      } else {
        throw ex;
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) {
    try {
      return delegate.deserializeSetAndReturn(p, ctxt, instance);
    } catch (MismatchedInputException ex) {
      deserializeAndSet(p, ctxt, instance);
    }
    return instance;
  }

  private boolean shouldUseAnySetter() {
    if (anySetter == null) {
      return false;
    }
    return useAnySetter.getAsBoolean();
  }
}
