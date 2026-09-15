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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.DEDUCTION;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NONE;
import static org.assertj.core.api.Assertions.assertThat;

class JsonUnwrappedDeserializerTest {
  private ObjectMapper mapper;

  @BeforeEach
  void initMapper() {
    mapper = new ObjectMapper();
  }

  @Nested
  class Deserialize {
    @Test
    @DisplayName("Single @JsonUnwrapped polymorphic type")
    void singleJsonWrappedPolymorphicField() throws JsonProcessingException {
      final RootClass result = mapper.readValue("{" + "\"stringField\": \"string-field-value\", "
          + "\"extendedField\": \"extended-field-value\", " + "\"nestedField\": \"nested-field-value\"" + "}", RootClass.class);

      // Verify normal fields works along to the json-wrapped fields
      // Verify interfaces are supported at root level
      // Verify nested interfaces are also supported
      assertThat(result).hasFieldOrPropertyWithValue("stringField", "string-field-value")
          .extracting(RootClass::getRootInterface).isNotNull()
          .asInstanceOf(InstanceOfAssertFactories.type(RootImplementation.class))
          .hasFieldOrPropertyWithValue("extendedField", "extended-field-value")
          .extracting(RootImplementation::getNestedInterface).isNotNull()
          .asInstanceOf(InstanceOfAssertFactories.type(NestedImplementation.class))
          .hasFieldOrPropertyWithValue("nestedField", "nested-field-value");
    }

    @Test
    @DisplayName("Single @JsonUnwrapped polymorphic field with missing data")
    void singleJsonWrappedPolymorphicFieldWithMissingDataForUnwrapped() throws JsonProcessingException {
      final RootClass result = mapper.readValue("{" + "\"stringField\": \"string-field-value\"" + "}", RootClass.class);

      // Verify normal fields works along to the json-wrapped fields
      // Verify interfaces are supported at root level
      assertThat(result).hasFieldOrPropertyWithValue("stringField", "string-field-value")
          .extracting(RootClass::getRootInterface).isNull();
    }

    @Test
    @DisplayName("Multiple @JsonUnwrapped fields")
    void multipleJsonUnwrappedFields() throws JsonProcessingException {
      final MultipleJsonUnwrapped result = mapper.readValue(
          "{" + "\"foo\": \"foo-value\"," + "\"bar\": \"bar-value\"," + "\"control\": \"pass\"" + "}",
          MultipleJsonUnwrapped.class);
      assertThat(result).hasFieldOrPropertyWithValue("foo.foo", "foo-value").hasFieldOrPropertyWithValue("bar.bar", "bar-value")
          .hasFieldOrPropertyWithValue("control", "pass");
    }

    @Test
    @DisplayName("Multiple polymorphic fields")
    void multiplePolymorphicFields() throws JsonProcessingException {
      final MultiplePolymorphicFields result = mapper.readValue(
          "{" + "\"foo\": {\"foo\": \"foo-value\"}," + "\"bar\": {\"bar\": \"bar-value\"}," + "\"control\": \"pass\"" + "}",
          MultiplePolymorphicFields.class);
      assertThat(result).hasFieldOrPropertyWithValue("foo.foo", "foo-value").hasFieldOrPropertyWithValue("bar.bar", "bar-value")
          .hasFieldOrPropertyWithValue("control", "pass");
    }

    @Test
    @DisplayName("Multiple @JsonUnwrapped polymorphic fields")
    void multipleJsonUnwrappedPolymorphicFields() throws JsonProcessingException {
      final MultipleJsonUnwrappedPolymorphicFields result = mapper.readValue(
          "{" + "\"foo\": \"foo-value\"," + "\"bar\": \"bar-value\"," + "\"control\": \"pass\"" + "}",
          MultipleJsonUnwrappedPolymorphicFields.class);
      assertThat(result).hasFieldOrPropertyWithValue("foo.foo", "foo-value").hasFieldOrPropertyWithValue("bar.bar", "bar-value")
          .hasFieldOrPropertyWithValue("control", "pass");
    }
  }

  public static class MultipleJsonUnwrapped {
    @JsonUnwrapped
    private FooImpl foo;
    @JsonUnwrapped
    private BarImpl bar;
    private String control;

    public MultipleJsonUnwrapped() {
    }

    public FooImpl getFoo() {
      return this.foo;
    }

    public BarImpl getBar() {
      return this.bar;
    }

    public String getControl() {
      return this.control;
    }

    public void setFoo(final FooImpl foo) {
      this.foo = foo;
    }

    public void setBar(final BarImpl bar) {
      this.bar = bar;
    }

    public void setControl(final String control) {
      this.control = control;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.MultipleJsonUnwrapped))
        return false;
      final JsonUnwrappedDeserializerTest.MultipleJsonUnwrapped other = (JsonUnwrappedDeserializerTest.MultipleJsonUnwrapped) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$foo = this.getFoo();
      final java.lang.Object other$foo = other.getFoo();
      if (this$foo == null ? other$foo != null : !this$foo.equals(other$foo))
        return false;
      final java.lang.Object this$bar = this.getBar();
      final java.lang.Object other$bar = other.getBar();
      if (this$bar == null ? other$bar != null : !this$bar.equals(other$bar))
        return false;
      final java.lang.Object this$control = this.getControl();
      final java.lang.Object other$control = other.getControl();
      if (this$control == null ? other$control != null : !this$control.equals(other$control))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.MultipleJsonUnwrapped;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $foo = this.getFoo();
      result = result * PRIME + ($foo == null ? 43 : $foo.hashCode());
      final java.lang.Object $bar = this.getBar();
      result = result * PRIME + ($bar == null ? 43 : $bar.hashCode());
      final java.lang.Object $control = this.getControl();
      result = result * PRIME + ($control == null ? 43 : $control.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.MultipleJsonUnwrapped(foo=" + this.getFoo() + ", bar=" + this.getBar()
          + ", control=" + this.getControl() + ")";
    }
  }

  public static class MultiplePolymorphicFields {
    private Foo foo;
    private Bar bar;
    private String control;

    public MultiplePolymorphicFields() {
    }

    public Foo getFoo() {
      return this.foo;
    }

    public Bar getBar() {
      return this.bar;
    }

    public String getControl() {
      return this.control;
    }

    public void setFoo(final Foo foo) {
      this.foo = foo;
    }

    public void setBar(final Bar bar) {
      this.bar = bar;
    }

    public void setControl(final String control) {
      this.control = control;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.MultiplePolymorphicFields))
        return false;
      final JsonUnwrappedDeserializerTest.MultiplePolymorphicFields other = (JsonUnwrappedDeserializerTest.MultiplePolymorphicFields) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$foo = this.getFoo();
      final java.lang.Object other$foo = other.getFoo();
      if (this$foo == null ? other$foo != null : !this$foo.equals(other$foo))
        return false;
      final java.lang.Object this$bar = this.getBar();
      final java.lang.Object other$bar = other.getBar();
      if (this$bar == null ? other$bar != null : !this$bar.equals(other$bar))
        return false;
      final java.lang.Object this$control = this.getControl();
      final java.lang.Object other$control = other.getControl();
      if (this$control == null ? other$control != null : !this$control.equals(other$control))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.MultiplePolymorphicFields;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $foo = this.getFoo();
      result = result * PRIME + ($foo == null ? 43 : $foo.hashCode());
      final java.lang.Object $bar = this.getBar();
      result = result * PRIME + ($bar == null ? 43 : $bar.hashCode());
      final java.lang.Object $control = this.getControl();
      result = result * PRIME + ($control == null ? 43 : $control.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.MultiplePolymorphicFields(foo=" + this.getFoo() + ", bar=" + this.getBar()
          + ", control=" + this.getControl() + ")";
    }
  }

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class MultipleJsonUnwrappedPolymorphicFields {
    @JsonUnwrapped
    private Foo foo;
    @JsonUnwrapped
    private Bar bar;
    private String control;

    public MultipleJsonUnwrappedPolymorphicFields() {
    }

    public Foo getFoo() {
      return this.foo;
    }

    public Bar getBar() {
      return this.bar;
    }

    public String getControl() {
      return this.control;
    }

    public void setFoo(final Foo foo) {
      this.foo = foo;
    }

    public void setBar(final Bar bar) {
      this.bar = bar;
    }

    public void setControl(final String control) {
      this.control = control;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.MultipleJsonUnwrappedPolymorphicFields))
        return false;
      final JsonUnwrappedDeserializerTest.MultipleJsonUnwrappedPolymorphicFields other = (JsonUnwrappedDeserializerTest.MultipleJsonUnwrappedPolymorphicFields) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$foo = this.getFoo();
      final java.lang.Object other$foo = other.getFoo();
      if (this$foo == null ? other$foo != null : !this$foo.equals(other$foo))
        return false;
      final java.lang.Object this$bar = this.getBar();
      final java.lang.Object other$bar = other.getBar();
      if (this$bar == null ? other$bar != null : !this$bar.equals(other$bar))
        return false;
      final java.lang.Object this$control = this.getControl();
      final java.lang.Object other$control = other.getControl();
      if (this$control == null ? other$control != null : !this$control.equals(other$control))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.MultipleJsonUnwrappedPolymorphicFields;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $foo = this.getFoo();
      result = result * PRIME + ($foo == null ? 43 : $foo.hashCode());
      final java.lang.Object $bar = this.getBar();
      result = result * PRIME + ($bar == null ? 43 : $bar.hashCode());
      final java.lang.Object $control = this.getControl();
      result = result * PRIME + ($control == null ? 43 : $control.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.MultipleJsonUnwrappedPolymorphicFields(foo=" + this.getFoo() + ", bar="
          + this.getBar() + ", control=" + this.getControl() + ")";
    }
  }

  @JsonSubTypes(@JsonSubTypes.Type(FooImpl.class))
  @JsonTypeInfo(use = DEDUCTION)
  public interface Foo {
    String getFoo();
  }

  @JsonSubTypes(@JsonSubTypes.Type(BarImpl.class))
  @JsonTypeInfo(use = DEDUCTION)
  public interface Bar {
    String getBar();
  }

  @JsonTypeInfo(use = NONE)
  public static class FooImpl implements Foo {
    private String foo;

    public String getFoo() {
      return this.foo;
    }

    public void setFoo(final String foo) {
      this.foo = foo;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.FooImpl))
        return false;
      final JsonUnwrappedDeserializerTest.FooImpl other = (JsonUnwrappedDeserializerTest.FooImpl) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$foo = this.getFoo();
      final java.lang.Object other$foo = other.getFoo();
      if (this$foo == null ? other$foo != null : !this$foo.equals(other$foo))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.FooImpl;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $foo = this.getFoo();
      result = result * PRIME + ($foo == null ? 43 : $foo.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.FooImpl(foo=" + this.getFoo() + ")";
    }

    public FooImpl() {
    }
  }

  @JsonTypeInfo(use = NONE)
  public static class BarImpl implements Bar {
    private String bar;

    public String getBar() {
      return this.bar;
    }

    public void setBar(final String bar) {
      this.bar = bar;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.BarImpl))
        return false;
      final JsonUnwrappedDeserializerTest.BarImpl other = (JsonUnwrappedDeserializerTest.BarImpl) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$bar = this.getBar();
      final java.lang.Object other$bar = other.getBar();
      if (this$bar == null ? other$bar != null : !this$bar.equals(other$bar))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.BarImpl;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $bar = this.getBar();
      result = result * PRIME + ($bar == null ? 43 : $bar.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.BarImpl(bar=" + this.getBar() + ")";
    }

    public BarImpl() {
    }
  }

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootClass {
    private String stringField;
    @JsonUnwrapped
    private RootInterface rootInterface;

    public String getStringField() {
      return this.stringField;
    }

    public RootInterface getRootInterface() {
      return this.rootInterface;
    }

    public void setStringField(final String stringField) {
      this.stringField = stringField;
    }

    public void setRootInterface(final RootInterface rootInterface) {
      this.rootInterface = rootInterface;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.RootClass))
        return false;
      final JsonUnwrappedDeserializerTest.RootClass other = (JsonUnwrappedDeserializerTest.RootClass) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$stringField = this.getStringField();
      final java.lang.Object other$stringField = other.getStringField();
      if (this$stringField == null ? other$stringField != null : !this$stringField.equals(other$stringField))
        return false;
      final java.lang.Object this$rootInterface = this.getRootInterface();
      final java.lang.Object other$rootInterface = other.getRootInterface();
      if (this$rootInterface == null ? other$rootInterface != null : !this$rootInterface.equals(other$rootInterface))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.RootClass;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $stringField = this.getStringField();
      result = result * PRIME + ($stringField == null ? 43 : $stringField.hashCode());
      final java.lang.Object $rootInterface = this.getRootInterface();
      result = result * PRIME + ($rootInterface == null ? 43 : $rootInterface.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.RootClass(stringField=" + this.getStringField() + ", rootInterface="
          + this.getRootInterface() + ")";
    }

    public RootClass() {
    }
  }

  @JsonSubTypes(@JsonSubTypes.Type(RootImplementation.class))
  @JsonTypeInfo(use = DEDUCTION)
  interface RootInterface {
  }

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootImplementation implements RootInterface {
    private String extendedField;
    @JsonUnwrapped
    private NestedInterface nestedInterface;

    public String getExtendedField() {
      return this.extendedField;
    }

    public NestedInterface getNestedInterface() {
      return this.nestedInterface;
    }

    public void setExtendedField(final String extendedField) {
      this.extendedField = extendedField;
    }

    public void setNestedInterface(final NestedInterface nestedInterface) {
      this.nestedInterface = nestedInterface;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.RootImplementation))
        return false;
      final JsonUnwrappedDeserializerTest.RootImplementation other = (JsonUnwrappedDeserializerTest.RootImplementation) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$extendedField = this.getExtendedField();
      final java.lang.Object other$extendedField = other.getExtendedField();
      if (this$extendedField == null ? other$extendedField != null : !this$extendedField.equals(other$extendedField))
        return false;
      final java.lang.Object this$nestedInterface = this.getNestedInterface();
      final java.lang.Object other$nestedInterface = other.getNestedInterface();
      if (this$nestedInterface == null ? other$nestedInterface != null : !this$nestedInterface.equals(other$nestedInterface))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.RootImplementation;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $extendedField = this.getExtendedField();
      result = result * PRIME + ($extendedField == null ? 43 : $extendedField.hashCode());
      final java.lang.Object $nestedInterface = this.getNestedInterface();
      result = result * PRIME + ($nestedInterface == null ? 43 : $nestedInterface.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.RootImplementation(extendedField=" + this.getExtendedField() + ", nestedInterface="
          + this.getNestedInterface() + ")";
    }

    public RootImplementation() {
    }
  }

  @JsonSubTypes(@JsonSubTypes.Type(NestedImplementation.class))
  @JsonTypeInfo(use = DEDUCTION)
  interface NestedInterface {
  }

  public static class NestedImplementation implements NestedInterface {
    private String nestedField;

    public String getNestedField() {
      return this.nestedField;
    }

    public void setNestedField(final String nestedField) {
      this.nestedField = nestedField;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
      if (o == this)
        return true;
      if (!(o instanceof JsonUnwrappedDeserializerTest.NestedImplementation))
        return false;
      final JsonUnwrappedDeserializerTest.NestedImplementation other = (JsonUnwrappedDeserializerTest.NestedImplementation) o;
      if (!other.canEqual((java.lang.Object) this))
        return false;
      final java.lang.Object this$nestedField = this.getNestedField();
      final java.lang.Object other$nestedField = other.getNestedField();
      if (this$nestedField == null ? other$nestedField != null : !this$nestedField.equals(other$nestedField))
        return false;
      return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
      return other instanceof JsonUnwrappedDeserializerTest.NestedImplementation;
    }

    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final java.lang.Object $nestedField = this.getNestedField();
      result = result * PRIME + ($nestedField == null ? 43 : $nestedField.hashCode());
      return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "JsonUnwrappedDeserializerTest.NestedImplementation(nestedField=" + this.getNestedField() + ")";
    }

    public NestedImplementation() {
    }
  }
}
