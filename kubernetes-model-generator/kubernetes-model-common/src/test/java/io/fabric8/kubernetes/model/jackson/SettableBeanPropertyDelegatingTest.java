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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.PropertyName;
import tools.jackson.databind.deser.CreatorProperty;
import tools.jackson.databind.deser.NullValueProvider;
import tools.jackson.databind.deser.SettableAnyProperty;
import tools.jackson.databind.deser.SettableBeanProperty;
import tools.jackson.databind.deser.bean.BeanDeserializerBase;
import tools.jackson.databind.deser.impl.MethodProperty;
import tools.jackson.databind.deser.jdk.NumberDeserializers;
import tools.jackson.databind.exc.InvalidFormatException;
import tools.jackson.databind.introspect.AnnotatedMember;
import tools.jackson.databind.introspect.BasicBeanDescription;
import tools.jackson.databind.introspect.BeanPropertyDefinition;
import tools.jackson.databind.introspect.ObjectIdInfo;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import tools.jackson.databind.util.SimpleBeanPropertyDefinition;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SettableBeanPropertyDelegatingTest {

  private AtomicBoolean useAnySetter;
  private ObjectMapper objectMapper;
  private DeserializationContext deserializationContext;
  private SettableAnyProperty anySetter;
  private SettableBeanProperty intFieldProperty;
  private SettableBeanPropertyDelegating intFieldPropertyDelegating;

  @BeforeEach
  void setUp() throws Exception {
    useAnySetter = new AtomicBoolean(false);
    objectMapper = new JsonMapper();
    deserializationContext = objectMapper._deserializationContext();
    final JavaType testBeanJavaType = objectMapper.constructType(TestBean.class);
    final BeanDescription testBeanDescription = deserializationContext.introspectBeanDescriptionForCreation(testBeanJavaType);
    final BeanDeserializerBase testBeanDeserializer = (BeanDeserializerBase) deserializationContext
        .findRootValueDeserializer(testBeanJavaType);
    // AnySetter used by delegator, real instance that will invoke the additionalProperties any setter in TestBean
    final BeanPropertyDefinition anySetterDefinition = SimpleBeanPropertyDefinition.construct(
        objectMapper.deserializationConfig(), testBeanDescription.findAnySetterAccessor());
    final BeanProperty anySetterProperty = new BeanProperty.Std(
        anySetterDefinition.getFullName(), anySetterDefinition.getPrimaryType(), anySetterDefinition.getWrapperName(),
        anySetterDefinition.getPrimaryMember(), anySetterDefinition.getMetadata());
    final JavaType anySetterValueType = objectMapper.constructType(Object.class);
    anySetter = SettableAnyProperty.constructForMethod(
        deserializationContext, anySetterProperty, anySetterProperty.getMember(), anySetterValueType,
        deserializationContext.findKeyDeserializer(objectMapper.constructType(String.class), anySetterProperty),
        deserializationContext.findRootValueDeserializer(anySetterValueType), null);
    // Delegated SettableBeanProperty
    intFieldProperty = testBeanDeserializer.findProperty(PropertyName.construct("intField"))
        .withValueDeserializer(NumberDeserializers.find(int.class));
    // Delegating SettableBeanProperty in test
    intFieldPropertyDelegating = new SettableBeanPropertyDelegating(intFieldProperty, anySetter, useAnySetter::get);

  }

  @Test
  @DisplayName("withValueDeserializer, should return a new instance")
  void withValueDeserializer() {
    // When
    final SettableBeanProperty result = intFieldPropertyDelegating.withValueDeserializer(null);
    // Then
    assertThat(result)
        .isInstanceOf(SettableBeanPropertyDelegating.class)
        .isNotSameAs(intFieldPropertyDelegating)
        .hasFieldOrPropertyWithValue("anySetter", anySetter)
        .asInstanceOf(InstanceOfAssertFactories.type(SettableBeanPropertyDelegating.class))
        .extracting(SettableBeanPropertyDelegating::getDelegate)
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
        .isInstanceOf(SettableBeanPropertyDelegating.class)
        .isNotSameAs(intFieldPropertyDelegating)
        .hasFieldOrPropertyWithValue("anySetter", anySetter)
        .asInstanceOf(InstanceOfAssertFactories.type(SettableBeanPropertyDelegating.class))
        .extracting(SettableBeanPropertyDelegating::getDelegate)
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
        .isInstanceOf(SettableBeanPropertyDelegating.class)
        .isNotSameAs(intFieldPropertyDelegating)
        .hasFieldOrPropertyWithValue("anySetter", anySetter)
        .asInstanceOf(InstanceOfAssertFactories.type(SettableBeanPropertyDelegating.class))
        .extracting(SettableBeanPropertyDelegating::getDelegate)
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
    assertThat(result).isZero();
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
    final BasicBeanDescription testBeanDescription = (BasicBeanDescription) deserializationContext
        .introspectBeanDescriptionForCreation(testBeanJavaType);
    final BeanPropertyDefinition testPropertyFieldDefinition = (testBeanDescription)
        .findProperty(PropertyName.construct("intField"));
    final AnnotatedMember setter = testBeanDescription.findAnySetterAccessor();
    final SettableBeanProperty methodProp = new MethodProperty(testPropertyFieldDefinition, testBeanJavaType, null,
        testBeanDescription.getClassAnnotations(), setter);
    final SettableBeanProperty methodPropDelegating = new SettableBeanPropertyDelegating(methodProp, anySetter,
        useAnySetter::get);
    // When
    methodPropDelegating.fixAccess(deserializationContext.getConfig());
    // Then (fixAccess was invoked on the delegate without error)
    assertThat(methodProp.getMember()).isNotNull();
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
  @DisplayName("setViews, should invoke setViews in delegate")
  void setViews() {
    // When
    intFieldPropertyDelegating.setViews(new Class<?>[] { Integer.class });
    // Then — delegate reflects the view restriction set through the delegating property
    assertThat(intFieldProperty.visibleInView(Integer.class)).isTrue();
    assertThat(intFieldProperty.visibleInView(String.class)).isFalse();
  }

  @Test
  @DisplayName("getContextAnnotation, should return getContextAnnotation result in delegate")
  void getContextAnnotation() {
    // When
    final JsonIgnoreProperties result = intFieldPropertyDelegating
        .getContextAnnotation(JsonIgnoreProperties.class);
    // Then
    assertThat(result)
        .isSameAs(intFieldProperty.getContextAnnotation(JsonIgnoreProperties.class))
        .extracting(JsonIgnoreProperties::ignoreUnknown)
        .isEqualTo(true);
  }

  @Test
  @DisplayName("getWrapperName, should return getWrapperName result in delegate")
  void getWrapperName() {
    // Given — verify delegation: delegating property returns same wrapperName as delegate
    final JavaType testBeanJavaType = objectMapper.constructType(TestBean.class);
    final BasicBeanDescription testBeanDescription = (BasicBeanDescription) deserializationContext
        .introspectBeanDescriptionForCreation(testBeanJavaType);
    final BeanPropertyDefinition testPropertyFieldDefinition = (testBeanDescription)
        .findProperty(PropertyName.construct("intField"));
    final AnnotatedMember setter = testBeanDescription.findAnySetterAccessor();
    final SettableBeanProperty methodProp = new MethodProperty(testPropertyFieldDefinition, testBeanJavaType, null,
        testBeanDescription.getClassAnnotations(), setter);
    final SettableBeanProperty methodPropDelegating = new SettableBeanPropertyDelegating(methodProp, anySetter,
        useAnySetter::get);
    // When
    final PropertyName result = methodPropDelegating.getWrapperName();
    // Then
    assertThat(result)
        .isSameAs(methodProp.getWrapperName());
  }

  @Test
  @DisplayName("getNullValueProvider, should return getNullValueProvider result in delegate")
  void getNullValueProvider() {
    // When
    final NullValueProvider result = intFieldPropertyDelegating.getNullValueProvider();
    // Then
    assertThat(result)
        .isSameAs(intFieldProperty.getNullValueProvider());
  }

  @Test
  @DisplayName("depositSchemaProperty, should invoke depositSchemaProperty in delegate")
  void depositSchemaProperty() throws Exception {
    // Given
    final JsonObjectFormatVisitor visitor = new JsonObjectFormatVisitor.Base(objectMapper._serializationContext()) {
      @Override
      public void optionalProperty(BeanProperty prop) {
        ((CreatorProperty) prop).setManagedReferenceName("visited");
      }
    };
    // When
    intFieldPropertyDelegating.depositSchemaProperty(visitor, objectMapper._serializationContext());
    // Then
    assertThat(intFieldProperty.getManagedReferenceName())
        .isEqualTo("visited");
  }

  @Test
  @DisplayName("getFullName, should return getFullName result in delegate")
  void getFullName() {
    // When
    final PropertyName result = intFieldPropertyDelegating.getFullName();
    // Then
    assertThat(result)
        .isSameAs(intFieldProperty.getFullName())
        .hasFieldOrPropertyWithValue("simpleName", "intField");
  }

  @Test
  @DisplayName("setManagedReferenceName, should invoke setManagedReferenceName in delegate")
  void setManagedReferenceName() {
    // When
    intFieldPropertyDelegating.setManagedReferenceName("the-managed-reference-name");
    // Then
    assertThat(intFieldPropertyDelegating.getManagedReferenceName())
        .isEqualTo(intFieldProperty.getManagedReferenceName())
        .isEqualTo("the-managed-reference-name");
  }

  @Test
  @DisplayName("setObjectIdInfo, should invoke setObjectIdInfo in delegate")
  void setObjectIdInfo() {
    // When
    intFieldPropertyDelegating.setObjectIdInfo(
        new ObjectIdInfo(PropertyName.construct("objectId"), null, null, null));
    // Then
    assertThat(intFieldProperty.getObjectIdInfo())
        .extracting(ObjectIdInfo::getPropertyName)
        .hasFieldOrPropertyWithValue("simpleName", "objectId");
  }

  @Test
  @DisplayName("withSimpleName, should invoke withSimpleName in delegate")
  void withSimpleName() {
    // When
    final SettableBeanProperty result = intFieldPropertyDelegating
        .withSimpleName("overridden-simple-name");
    // Then
    assertThat(result)
        .isNotSameAs(intFieldPropertyDelegating)
        .returns("overridden-simple-name", SettableBeanProperty::getName)
        .extracting("delegate")
        .asInstanceOf(InstanceOfAssertFactories.type(CreatorProperty.class))
        .isNotSameAs(intFieldProperty)
        .returns("overridden-simple-name", SettableBeanProperty::getName);
  }

  @Test
  @DisplayName("toString, should return toString result in delegate")
  void toStringTest() {
    // When
    final String result = intFieldPropertyDelegating.toString();
    // Then
    assertThat(result)
        .isEqualTo(intFieldProperty.toString())
        .isNotBlank();
  }

  @Test
  @DisplayName("set, should set in delegate")
  void set() {
    // Given
    final TestBean instance = new TestBean(1337);
    intFieldProperty.fixAccess(objectMapper.deserializationConfig());
    // When
    intFieldPropertyDelegating.set(deserializationContext, instance, 313373);
    // Then
    assertThat(instance)
        .hasFieldOrPropertyWithValue("intField", 313373);
  }

  @Test
  @DisplayName("setAndReturn, should setAndReturn in delegate")
  void setAndReturn() {
    // Given
    final TestBean instance = new TestBean(1337);
    intFieldProperty.fixAccess(objectMapper.deserializationConfig());
    // When
    final Object result = intFieldPropertyDelegating.setAndReturn(deserializationContext, instance, 313373);
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
      intFieldProperty.fixAccess(objectMapper.deserializationConfig());
      instance = new TestBean(1337);
    }

    @Test
    @DisplayName("validValue, should deserializeSetAndReturn in delegate")
    void validValue() {
      try (JsonParser parser = objectMapper.createParser("313373")) {
        final DeserializationContext ctx = objectMapper._deserializationContext()
            .assignParser(parser);
        parser.nextToken();
        final Object result = intFieldPropertyDelegating.deserializeSetAndReturn(parser, ctx, instance);
        assertThat(instance)
            .hasFieldOrPropertyWithValue("intField", 313373)
            .isEqualTo(result);
      }
    }

    @Test
    @DisplayName("deserializeSetAndReturn, with anySetter enabled and throws Exception, should use anySetter")
    void invalidValueWithExceptionUsingAnySetter() {
      useAnySetter.set(true);
      try (JsonParser parser = objectMapper.createParser("\"${a-placeholder}\"")) {
        final DeserializationContext ctx = objectMapper._deserializationContext()
            .assignParser(parser);
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
    void deserializeSetAndReturnWithExceptionNotUsingAnySetter() {
      try (JsonParser parser = objectMapper.createParser("\"${a-placeholder}\"")) {
        final DeserializationContext ctx = objectMapper._deserializationContext()
            .assignParser(parser);
        parser.nextToken();
        assertThatThrownBy(() -> intFieldPropertyDelegating.deserializeSetAndReturn(parser, ctx, instance))
            .isInstanceOf(InvalidFormatException.class)
            .hasMessageContainingAll(
                "Cannot deserialize value of type `int`", "\"${a-placeholder}\"");
      }
    }

    @Test
    @DisplayName("deserializeSetAndReturn, with anySetter=null and throws Exception, should throw Exception")
    void deserializeSetAndReturnWithExceptionAndNullAnySetter() {
      intFieldPropertyDelegating = new SettableBeanPropertyDelegating(intFieldProperty, null, () -> true);
      try (JsonParser parser = objectMapper.createParser("\"${a-placeholder}\"")) {
        final DeserializationContext ctx = objectMapper._deserializationContext()
            .assignParser(parser);
        parser.nextToken();
        assertThatThrownBy(() -> intFieldPropertyDelegating.deserializeSetAndReturn(parser, ctx, instance))
            .isInstanceOf(InvalidFormatException.class)
            .hasMessageContainingAll(
                "Cannot deserialize value of type `int`", "\"${a-placeholder}\"");
      }
    }
  }

  @Nested
  class ReflectionTest {

    @Test
    @DisplayName("All concrete superclass methods are implemented by SettableBeanPropertyDelegating")
    void allMethodsFromSuperclassAreImplementedByDelegatingClass() {
      final Map<MethodSignature, Boolean> superclassMethods = Stream.of(SettableBeanProperty.class.getDeclaredMethods())
          .filter(m -> !Modifier.isFinal(m.getModifiers()))
          .filter(m -> !Modifier.isPrivate(m.getModifiers()))
          .filter(m -> !Modifier.isAbstract(m.getModifiers()))
          .filter(m -> !m.getName().startsWith("_"))
          .map(MethodSignature::from)
          .collect(Collectors.toMap(ms -> ms, ms -> false));

      Stream.concat(
          Stream.of(SettableBeanProperty.Delegating.class.getDeclaredMethods()),
          Stream.of(SettableBeanPropertyDelegating.class.getDeclaredMethods()))
          .map(MethodSignature::from)
          .forEach(ms -> superclassMethods.computeIfPresent(ms, (k, v) -> true));

      List<MethodSignature> missing = superclassMethods.entrySet().stream()
          .filter(e -> !e.getValue())
          .map(Map.Entry::getKey)
          .collect(Collectors.toList());

      assertThat(missing)
          .withFailMessage("Missing method overrides: %s", missing)
          .isEmpty();
    }

  }

  @JsonIgnoreProperties(ignoreUnknown = true)
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

    @Override
    public String toString() {
      String params = Arrays.stream(parameterTypes)
          .map(Class::getSimpleName)
          .collect(Collectors.joining(", "));
      return returnType.getSimpleName() + " " + name + "(" + params + ")";
    }
  }
}