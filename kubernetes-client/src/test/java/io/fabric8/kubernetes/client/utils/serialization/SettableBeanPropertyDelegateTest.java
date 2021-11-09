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
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SettableBeanPropertyDelegateTest {

  private SettableBeanProperty delegateMock;
  private SettableAnyProperty anySetterMock;
  private SettableBeanPropertyDelegate settableBeanPropertyDelegate;

  @BeforeEach
  void setUp() {
    delegateMock = mock(SettableBeanProperty.class, RETURNS_DEEP_STUBS);
    anySetterMock = mock(SettableAnyProperty.class);
    settableBeanPropertyDelegate = new SettableBeanPropertyDelegate(delegateMock, anySetterMock, () -> false);
  }

  @Test
  @DisplayName("withValueDeserializer, should return a new instance")
  void withValueDeserializer() {
    // Given
    doReturn(delegateMock).when(delegateMock).withValueDeserializer(any());
    // When
    final SettableBeanProperty result = settableBeanPropertyDelegate.withValueDeserializer(null);
    // Then
    assertThat(result)
      .isInstanceOf(SettableBeanPropertyDelegate.class)
      .isNotSameAs(settableBeanPropertyDelegate)
      .hasFieldOrPropertyWithValue("anySetter", anySetterMock)
      .hasFieldOrPropertyWithValue("delegate", delegateMock);
  }

  @Test
  @DisplayName("withName, should return a new instance")
  void withName() {
    // Given
    doReturn(delegateMock).when(delegateMock).withName(any());
    // When
    final SettableBeanProperty result = settableBeanPropertyDelegate.withName(null);
    // Then
    assertThat(result)
      .isInstanceOf(SettableBeanPropertyDelegate.class)
      .isNotSameAs(settableBeanPropertyDelegate)
      .hasFieldOrPropertyWithValue("anySetter", anySetterMock)
      .hasFieldOrPropertyWithValue("delegate", delegateMock);
  }

  @Test
  @DisplayName("withNullProvider, should return a new instance")
  void withNullProvider() {
    // Given
    doReturn(delegateMock).when(delegateMock).withNullProvider(any());
    // When
    final SettableBeanProperty result = settableBeanPropertyDelegate.withNullProvider(null);
    // Then
    assertThat(result)
      .isInstanceOf(SettableBeanPropertyDelegate.class)
      .isNotSameAs(settableBeanPropertyDelegate)
      .hasFieldOrPropertyWithValue("anySetter", anySetterMock)
      .hasFieldOrPropertyWithValue("delegate", delegateMock);
  }

  @Test
  @DisplayName("getMember, should return delegate's Member")
  void getMember() {
    // Given
    when(delegateMock.getMember().getName()).thenReturn("the-member");
    // When
    final String result = settableBeanPropertyDelegate.getMember().getName();
    // Then
    assertThat(result).isEqualTo("the-member");
  }

  @Test
  @DisplayName("getAnnotation, should return delegate's Annotation")
  void getAnnotation() {
    // When
    settableBeanPropertyDelegate.getAnnotation(null);
    // Then
    verify(delegateMock, times(1)).getAnnotation(null);
  }

  @Test
  @DisplayName("fixAccess, should invoke fixAccess in delegate")
  void fixAccess() {
    // When
    settableBeanPropertyDelegate.fixAccess(null);
    // Then
    verify(delegateMock, times(1)).fixAccess(null);
  }

  @Test
  @DisplayName("markAsIgnorable, should invoke markAsIgnorable in delegate")
  void markAsIgnorable() {
    // When
    settableBeanPropertyDelegate.markAsIgnorable();
    // Then
    verify(delegateMock, times(1)).markAsIgnorable();
  }

  @Test
  @DisplayName("isIgnorable, should return isIgnorable result in delegate")
  void isIgnorable() {
    // Given
    when(delegateMock.isIgnorable()).thenReturn(true);
    // When
    final boolean result = settableBeanPropertyDelegate.isIgnorable();
    // Then
    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("set, should set in delegate")
  void set() throws IOException {
    // Given
    final Object o1 = new Object();
    final Object o2 = new Object();
    // When
    settableBeanPropertyDelegate.set(o1, o2);
    // Then
    verify(delegateMock, times(1)).set(o1, o2);
  }

  @Test
  @DisplayName("setAndReturn, should setAndReturn in delegate")
  void setAndReturn() throws IOException {
    // Given
    final Object o1 = new Object();
    final Object o2 = new Object();
    // When
    settableBeanPropertyDelegate.setAndReturn(o1, o2);
    // Then
    verify(delegateMock, times(1)).setAndReturn(o1, o2);
  }

  @Test
  @DisplayName("deserializeSetAndReturn, should deserializeSetAndReturn in delegate")
  void deserializeSetAndReturn() throws IOException {
    // Given
    final Object instance = new Object();
    when(delegateMock.deserializeSetAndReturn(any(), any(), eq(instance))).thenReturn("the-set-value");
    // When
    final Object result = settableBeanPropertyDelegate.deserializeSetAndReturn(null, null, instance);
    // Then
    assertThat(result).isEqualTo("the-set-value");
  }

  @Test
  @DisplayName("deserializeSetAndReturn, throws Exception, should try anySetter or rethrow")
  void deserializeSetAndReturnWithException() throws IOException {
    // Given
    final Object instance = new Object();
    when(delegateMock.getName()).thenReturn("the-property");
    when(delegateMock.deserializeSetAndReturn(any(), any(), eq(instance)))
      .thenThrow(MismatchedInputException.from(null, Integer.class, "The Mocked Exception"));
    doThrow(MismatchedInputException.from(null, Integer.class, "The Mocked Exception"))
      .when(delegateMock).deserializeAndSet(any(), any(), eq(instance));
    // When
    final Object result = settableBeanPropertyDelegate.deserializeSetAndReturn(mock(JsonParser.class), null, instance);
    // Then
    assertThat(result).isNull();
    verify(anySetterMock, times(1)).set(eq(instance), eq("the-property"), any());
  }
}
