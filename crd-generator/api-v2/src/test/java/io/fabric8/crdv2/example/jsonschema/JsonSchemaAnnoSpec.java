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
package io.fabric8.crdv2.example.jsonschema;

import io.fabric8.generator.annotation.JSONSchema;
import io.fabric8.generator.annotation.JSONSchema.ExternalDocumentation;
import io.fabric8.generator.annotation.ValidationRule;
import lombok.Data;

import java.util.List;

@Data
public class JsonSchemaAnnoSpec {

  @JSONSchema(type = "string")
  private Object customizedType;

  /* *********************************************************************** */

  @JSONSchema(externalDocs = @ExternalDocumentation(url = "https://example.com/docs.txt"))
  private String documentedExternally;

  /* *********************************************************************** */

  @JSONSchema(implementation = StrictItemsSchema.class, additionalProperties = JSONSchema.False.class)
  @Data
  static class StrictItemsSchema {
    String field1;
    int field2;
  }

  @JSONSchema(type = "array", additionalItems = JSONSchema.False.class, items = StrictItemsSchema.class)
  private List<Object> strictItems;

  /* *********************************************************************** */

  @JSONSchema(implementation = LaxItemsSchema1.class, additionalProperties = JSONSchema.True.class)
  @Data
  static class LaxItemsSchema1 {
    String field1;
    double field2;
  }

  // besides field1 and field2, allows additional properties if they are objects of type LaxItemsSchema1
  @JSONSchema(implementation = LaxItemsSchema2.class, additionalProperties = LaxItemsSchema1.class)
  @Data
  static class LaxItemsSchema2 {
    String field1;
    int field2;
  }

  @JSONSchema(type = "array", additionalItems = JSONSchema.True.class, items = { LaxItemsSchema1.class,
      LaxItemsSchema2.class })
  private List<Object> laxItems;

  /* *********************************************************************** */

  @JSONSchema(implementation = OverriddenPropertiesSchema.class, description = "Has properties that are replaced by referencing type")
  @Data
  static class OverriddenPropertiesSchema {
    String field1;
    int field2;
  }

  @JSONSchema(type = "object", properties = {
      @JSONSchema.Map(name = "field3", value = Long.class),
      @JSONSchema.Map(name = "field4", value = Double.class),
  }, implementation = OverriddenPropertiesSchema.class)
  private OverriddenPropertiesSchema overriddenProperties;

  /* *********************************************************************** */

  @Data
  static class ObjectEnumerationSchema {
    String field1;
    int field2;
  }

  @JSONSchema(type = "object", implementation = ObjectEnumerationSchema.class, defaultValue = "{ \"field1\": \"allowedValue1\", \"field2\": 1 }", enumeration = {
      "{ \"field1\": \"allowedValue1\", \"field2\": 1 }",
      "{ \"field1\": \"allowedValue2\", \"field2\": 2 }",
  }, example = "{ \"field1\": \"allowedValue2\", \"field2\": 2 }")
  private OverriddenPropertiesSchema objectEnumeration;

  /* *********************************************************************** */

  @JSONSchema(type = "integer", nullable = JSONSchema.True.class, minimum = 0d, maximum = 100d, exclusiveMaximum = JSONSchema.True.class)
  static class NullableIntegerWithRange {
  }

  @Data
  @JSONSchema(type = "object", implementation = ObjectEnumerationSchema.class, dependencies = {
      // field1 requires the presence of field2
      @JSONSchema.DependencyMap(name = "field1", value = @JSONSchema.Dependency(properties = "field2")),
      // field2 requires that field1 is null or an integer between 0 and 100 (exclusive)
      @JSONSchema.DependencyMap(name = "field2", value = @JSONSchema.Dependency(schema = NullableIntegerWithRange.class))
  })
  static class DependentPropertiesSchema {
    String field1;
    Integer field2;
  }

  private DependentPropertiesSchema dependentProperties;

  /* *********************************************************************** */

  @Data
  @JSONSchema(implementation = SuppressionSchema.class, additionalProperties = String.class, minProperties = 1, maxProperties = 10, example = "{ \"field2\": 42 }", xKubernetesValidations = @ValidationRule("some rule"))
  static class SuppressionSchema {
    String field1;
    Integer field2;
    @JSONSchema(minItems = 3)
    List<String> field3;
  }

  @JSONSchema(implementation = SuppressionSchema.class, additionalProperties = JSONSchema.Suppressed.class, minProperties = JSONSchema.Suppressed.LONG, example = JSONSchema.Suppressed.STRING, xKubernetesValidations = {})
  private SuppressionSchema suppression;

  /* *********************************************************************** */

  @Data
  static class StructuralSchema1 {
    String string1;
  }

  @Data
  static class StructuralSchema2 {
    String string2;
  }

  @Data
  static class StructuralSchema3 {
    String string3;
    StructuralSchema1 structural3;
  }

  @Data
  static class StructuralSchema4 {
    List<String> string4;
  }

  @Data
  static class StructuralSchema5 {
    String string5;
  }

  @Data
  static class StructuralSchema6 {
    String string6;
  }

  @Data
  static class StructuralSchema7 {
    String string7;
    StructuralSchema8 intOrString7;
  }

  @Data
  @JSONSchema(xKubernetesIntOrString = JSONSchema.True.class, anyOf = { Integer.class, String.class })
  static class StructuralSchema8 {
    String string8;
    Integer integer8;
  }

  @Data
  @JSONSchema(structural = true, allOf = { StructuralSchema4.class, StructuralSchema5.class }, anyOf = {
      StructuralSchema1.class,
      StructuralSchema3.class }, not = StructuralSchema2.class, oneOf = { StructuralSchema6.class, StructuralSchema7.class })
  static class StructuralSchema {
    String string;
    Integer integer;
  }

  private StructuralSchema structural;

}
