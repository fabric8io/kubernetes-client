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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.IOException;
import java.util.function.BooleanSupplier;

/**
 * This concrete sub-class encapsulates a {@link SettableBeanProperty} delegate that is always tried first.
 *
 * <p>
 * A fall-back mechanism is implemented in the deserializeAndSet methods to allow field values that don't match the
 * target type to be preserved in the anySetter method if exists.
 */
public class SettableBeanPropertyDelegate extends SettableBeanProperty.Delegating {

  private final SettableAnyProperty anySetter;
  private final transient BooleanSupplier useAnySetter;

  SettableBeanPropertyDelegate(SettableBeanProperty delegate, SettableAnyProperty anySetter, BooleanSupplier useAnySetter) {
    super(delegate);
    this.anySetter = anySetter;
    this.useAnySetter = useAnySetter;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected SettableBeanProperty withDelegate(SettableBeanProperty d) {
    return new SettableBeanPropertyDelegate(d, anySetter, useAnySetter);
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

  private boolean shouldUseAnySetter() {
    if (anySetter == null) {
      return false;
    }
    return useAnySetter.getAsBoolean();
  }
}
