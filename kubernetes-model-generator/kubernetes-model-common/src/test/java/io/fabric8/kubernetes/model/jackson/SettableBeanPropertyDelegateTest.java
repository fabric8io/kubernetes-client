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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SettableBeanPropertyDelegateTest {

  private AtomicBoolean useAnySetter;
  private ObjectMapper objectMapper;
  private DefaultDeserializationContext deserializationContext;
  private SettableAnyProperty anySetter;
  private SettableBeanProperty intFieldProperty;
  private SettableBeanPropertyDelegate intFieldPropertyDelegating;

  @BeforeEach
  void setUp() throws Exception {
    useAnySetter = new AtomicBoolean(false);
    // Required Jackson deserialization objects to set up the test components
    objectMapper = new ObjectMapper();
    final DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig();
    deserializationContext = new DefaultDeserializationContext.Impl(objectMapper.getDeserializationContext().getFactory())
        .createDummyInstance(deserializationConfig);
    final JavaType testBeanJavaType = objectMapper.constructType(TestBean.class);
    final BeanDescription testBeanDescription = deserializationConfig.introspect(testBeanJavaType);
    final BeanDeserializer testBeanDeserializer = (BeanDeserializer) ((BeanDeserializerFactory) deserializationContext
        .getFactory())
        .buildBeanDeserializer(deserializationContext, testBeanJavaType, testBeanDescription);
    // AnySetter used by delegator, real instance that will invoke the additionalProperties any setter in TestBean
    final BeanPropertyDefinition anySetterDefinition = SimpleBeanPropertyDefinition.construct(deserializationConfig,
        testBeanDescription.findAnySetterAccessor());
    final BeanProperty anySetterProperty = new BeanProperty.Std(
        anySetterDefinition.getFullName(), anySetterDefinition.getPrimaryType(), anySetterDefinition.getWrapperName(),
        anySetterDefinition.getPrimaryMember(), anySetterDefinition.getMetadata());
    final JavaType anySetterValueType = objectMapper.constructType(Object.class);
    anySetter = SettableAnyProperty.constructForMethod(
        deserializationContext, anySetterProperty, anySetterProperty.getMember(), anySetterValueType,
        deserializationContext.findKeyDeserializer(objectMapper.constructType(String.class), anySetterProperty),
        deserializationContext.findRootValueDeserializer(anySetterValueType), null);
    // Delegated SettableBeanProperty
    intFieldProperty = testBeanDeserializer.findProperty("intField")
        .withValueDeserializer(NumberDeserializers.find(int.class, null));
    // Delegating SettableBeanProperty in test
    intFieldPropertyDelegating = new SettableBeanPropertyDelegate(intFieldProperty, anySetter, useAnySetter::get);

  }

  @Test
  @DisplayName("withValueDeserializer, should return a new instance")
  void withValueDeserializer() {
    // When
    final SettableBeanProperty result = intFieldPropertyDelegating.withValueDeserializer(null);
    // Then
    assertThat(result)
        .isInstanceOf(SettableBeanPropertyDelegate.class)
        .isNotSameAs(intFieldPropertyDelegating)
        .hasFieldOrPropertyWithValue("anySetter", anySetter)
        .asInstanceOf(InstanceOfAssertFactories.type(SettableBeanPropertyDelegate.class))
        .extracting(SettableBeanPropertyDelegate::getDelegate)
        .isInstanceOf(CreatorProperty.class)
        .isNotSameAs(intFieldProperty)
        .hasFieldOrPropertyWithValue("name", "intField");
  }

  @Test
  @DisplayName("withName, should return a new instance")
  void withName() {
    // When
    final SettableBeanProperty result = intFieldPropertyDelegating.withName(new PropertyName("overriddenName"));
    // Then
    assertThat(result)
        .isInstanceOf(SettableBeanPropertyDelegate.class)
        .isNotSameAs(intFieldPropertyDelegating)
        .hasFieldOrPropertyWithValue("anySetter", anySetter)
        .asInstanceOf(InstanceOfAssertFactories.type(SettableBeanPropertyDelegate.class))
        .extracting(SettableBeanPropertyDelegate::getDelegate)
        .isInstanceOf(CreatorProperty.class)
        .isNotSameAs(intFieldProperty)
        .hasFieldOrPropertyWithValue("name", "overriddenName");
  }

  @Test
  @DisplayName("withNullProvider, should return a new instance")
  void withNullProvider() {
    // When
    final SettableBeanProperty result = intFieldPropertyDelegating.withNullProvider(null);
    // Then
    assertThat(result)
        .isInstanceOf(SettableBeanPropertyDelegate.class)
        .isNotSameAs(intFieldPropertyDelegating)
        .hasFieldOrPropertyWithValue("anySetter", anySetter)
        .asInstanceOf(InstanceOfAssertFactories.type(SettableBeanPropertyDelegate.class))
        .extracting(SettableBeanPropertyDelegate::getDelegate)
        .isInstanceOf(CreatorProperty.class)
        .isNotSameAs(intFieldProperty)
        .hasFieldOrPropertyWithValue("name", "intField");
  }

  @Test
  @DisplayName("getMember, should return delegate's Member")
  void getMember() {
    // When
    final AnnotatedMember result = intFieldPropertyDelegating.getMember();
    // Then
    assertThat(result)
        .isSameAs(intFieldProperty.getMember())
        .extracting(am -> am.getAnnotation(JsonProperty.class).value())
        .isEqualTo("intField");
  }

  @Test
  @DisplayName("getCreatorIndex, should return delegate's creator index")
  void getCreatorIndex() {
    // When
    final int result = intFieldPropertyDelegating.getCreatorIndex();
    // Then
    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("getAnnotation, should return delegate's Annotation")
  void getAnnotation() {
    // When
    final JsonProperty result = intFieldPropertyDelegating.getAnnotation(JsonProperty.class);
    // Then
    assertThat(result)
        .isSameAs(intFieldProperty.getAnnotation(JsonProperty.class));
  }

  @Test
  @DisplayName("fixAccess, should invoke fixAccess in delegate")
  void fixAccess() {
    // Given
    final JavaType testBeanJavaType = objectMapper.constructType(TestBean.class);
    final BasicBeanDescription testBeanDescription = (BasicBeanDescription) deserializationContext.getConfig()
        .introspect(testBeanJavaType);
    final BeanPropertyDefinition testPropertyFieldDefinition = (testBeanDescription)
        .findProperty(PropertyName.construct("intField"));
    final SettableBeanProperty fieldProperty = new FieldProperty(testPropertyFieldDefinition, testBeanJavaType, null,
        testBeanDescription.getClassAnnotations(), testPropertyFieldDefinition.getField());
    final SettableBeanProperty fieldPropertyDelegating = new SettableBeanPropertyDelegate(fieldProperty, anySetter,
        useAnySetter::get);
    assertThat(((AccessibleObject) fieldProperty.getMember().getMember()).isAccessible()).isFalse();
    // When
    fieldPropertyDelegating.fixAccess(deserializationContext.getConfig());
    // Then
    assertThat(((AccessibleObject) fieldProperty.getMember().getMember()).isAccessible()).isTrue();
  }

  @Test
  @DisplayName("markAsIgnorable, should invoke markAsIgnorable in delegate")
  void markAsIgnorable() {
    // Given
    assertThat(intFieldProperty.isIgnorable()).isFalse();
    // When
    intFieldPropertyDelegating.markAsIgnorable();
    // Then
    assertThat(intFieldProperty.isIgnorable()).isTrue();
  }

  @Test
  @DisplayName("isIgnorable, should return isIgnorable result in delegate")
  void isIgnorable() {
    // When
    final boolean result = intFieldPropertyDelegating.isIgnorable();
    // Then
    assertThat(result)
        .isFalse()
        .isEqualTo(intFieldProperty.isIgnorable());
  }

  @Test
  @DisplayName("set, should set in delegate")
  void set() throws IOException {
    // Given
    final TestBean instance = new TestBean(1337);
    intFieldProperty.fixAccess(objectMapper.getDeserializationConfig());
    // When
    intFieldPropertyDelegating.set(instance, 313373);
    // Then
    assertThat(instance)
        .hasFieldOrPropertyWithValue("intField", 313373);
  }

  @Test
  @DisplayName("setAndReturn, should setAndReturn in delegate")
  void setAndReturn() throws IOException {
    // Given
    final TestBean instance = new TestBean(1337);
    intFieldProperty.fixAccess(objectMapper.getDeserializationConfig());
    // When
    final Object result = intFieldPropertyDelegating.setAndReturn(instance, 313373);
    // Then
    assertThat(instance)
        .hasFieldOrPropertyWithValue("intField", 313373)
        .isSameAs(result);
  }

  @Nested
  @DisplayName("deserializeSetAndReturn")
  class DeserializeSetAndReturn {

    private TestBean instance;

    @BeforeEach
    void setUp() {
      intFieldProperty.fixAccess(objectMapper.getDeserializationConfig());
      instance = new TestBean(1337);
    }

    @Test
    @DisplayName("validValue, should deserializeSetAndReturn in delegate")
    void validValue() throws IOException {
      try (JsonParser parser = objectMapper.createParser("313373")) {
        final DefaultDeserializationContext ctx = deserializationContext
            .createInstance(deserializationContext.getConfig(), parser, null);
        parser.nextToken();
        final Object result = intFieldPropertyDelegating.deserializeSetAndReturn(parser, ctx, instance);
        assertThat(instance)
            .hasFieldOrPropertyWithValue("intField", 313373)
            .isEqualTo(result);
      }
    }

    @Test
    @DisplayName("deserializeSetAndReturn, with anySetter enabled and throws Exception, should use anySetter")
    void invalidValueWithExceptionUsingAnySetter() throws IOException {
      useAnySetter.set(true);
      try (JsonParser parser = objectMapper.createParser("\"${a-placeholder}\"")) {
        final DefaultDeserializationContext ctx = deserializationContext
            .createInstance(deserializationContext.getConfig(), parser, null);
        parser.nextToken();
        final Object result = intFieldPropertyDelegating.deserializeSetAndReturn(parser, ctx, instance);
        assertThat(instance)
            .hasFieldOrPropertyWithValue("intField", 1337)
            .hasFieldOrPropertyWithValue("additionalProperties", Collections.singletonMap("intField", "${a-placeholder}"))
            .isEqualTo(result);
      }
    }

    @Test
    @DisplayName("deserializeSetAndReturn, with anySetter disabled and throws Exception, should throw Exception")
    void deserializeSetAndReturnWithExceptionNotUsingAnySetter() throws IOException {
      try (JsonParser parser = objectMapper.createParser("\"${a-placeholder}\"")) {
        final DefaultDeserializationContext ctx = deserializationContext
            .createInstance(deserializationContext.getConfig(), parser, null);
        parser.nextToken();
        assertThatThrownBy(() -> intFieldPropertyDelegating.deserializeSetAndReturn(parser, ctx, instance))
            .isInstanceOf(InvalidFormatException.class)
            .hasMessageContainingAll(
                "Cannot deserialize value of type `int`", "\"${a-placeholder}\"");
      }
    }

    @Test
    @DisplayName("deserializeSetAndReturn, with anySetter=null and throws Exception, should throw Exception")
    void deserializeSetAndReturnWithExceptionAndNullAnySetter() throws IOException {
      intFieldPropertyDelegating = new SettableBeanPropertyDelegate(intFieldProperty, null, () -> true);
      try (JsonParser parser = objectMapper.createParser("\"${a-placeholder}\"")) {
        final DefaultDeserializationContext ctx = deserializationContext
            .createInstance(deserializationContext.getConfig(), parser, null);
        parser.nextToken();
        assertThatThrownBy(() -> intFieldPropertyDelegating.deserializeSetAndReturn(parser, ctx, instance))
            .isInstanceOf(InvalidFormatException.class)
            .hasMessageContainingAll(
                "Cannot deserialize value of type `int`", "\"${a-placeholder}\"");
      }
    }
  }

  private static final class TestBean {

    @JsonProperty("intField")
    int intField;
    private final Map<String, Object> additionalProperties;

    @JsonCreator
    private TestBean(@JsonProperty("intField") int intField) {
      this.intField = intField;
      additionalProperties = new LinkedHashMap<>();
    }

    @JsonAnyGetter
    private Map<String, Object> getAdditionalProperties() {
      return this.additionalProperties;
    }

    @JsonAnySetter
    private void setAdditionalProperty(String name, Object value) {
      this.additionalProperties.put(name, value);
    }
  }

  @AllArgsConstructor
  @EqualsAndHashCode
  private static final class MethodSignature {
    private final Class<?> returnType;
    private final String name;
    private final Class<?>[] parameterTypes;

    private static MethodSignature from(Method m) {
      return new MethodSignature(m.getReturnType(), m.getName(), m.getParameterTypes());
    }

  }
}
