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
package io.fabric8.kubernetes.model.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsonUnwrappedDeserializerTest {

  private static final String EXPECTED_VALUE_A = "Value A";
  private static final String EXPECTED_VALUE_B = "Value B";
  private static final String EXPECTED_VALUE_C = "Value C";

  @Test
  void shouldDeserializeInterfacesWithJsonWrapped() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    RootClass instance = mapper.readValue("{ \"stringField\": \"" + EXPECTED_VALUE_A + "\", "
        + "\"extendedField\": \"" + EXPECTED_VALUE_B + "\", "
        + "\"nestedField\": \"" + EXPECTED_VALUE_C + "\" }", RootClass.class);
    // Verify normal fields works along to the json-wrapped fields
    assertEquals(EXPECTED_VALUE_A, instance.stringField);

    // Verify interfaces are supported at root level
    assertNotNull(instance.rootInterface, "Interface was not deserialized!");
    assertTrue(instance.rootInterface instanceof RootImplementation);
    RootImplementation rootImplementation = ((RootImplementation) instance.rootInterface);
    assertEquals(EXPECTED_VALUE_B, rootImplementation.extendedField);

    // Verify nested interfaces are also supported
    assertTrue(rootImplementation.nestedInterface instanceof NestedImplementation);
    assertEquals(EXPECTED_VALUE_C, ((NestedImplementation) rootImplementation.nestedInterface).nestedField);
  }

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootClass {

    private String stringField;

    @JsonUnwrapped
    private RootInterface rootInterface;

    public RootClass() {

    }

    public String getStringField() {
      return stringField;
    }

    public void setStringField(String stringField) {
      this.stringField = stringField;
    }

    public RootInterface getRootInterface() {
      return rootInterface;
    }

    public void setRootInterface(RootInterface rootInterface) {
      this.rootInterface = rootInterface;
    }
  }

  @JsonSubTypes(@JsonSubTypes.Type(RootImplementation.class))
  @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
  interface RootInterface {

  }

  @JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
  public static class RootImplementation implements RootInterface {

    private String extendedField;
    @JsonUnwrapped
    private NestedInterface nestedInterface;

    public RootImplementation() {

    }

    public String getExtendedField() {
      return extendedField;
    }

    public void setExtendedField(String extendedField) {
      this.extendedField = extendedField;
    }
  }

  @JsonSubTypes(@JsonSubTypes.Type(NestedImplementation.class))
  @JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
  interface NestedInterface {

  }

  public static class NestedImplementation implements NestedInterface {
    private String nestedField;

    public NestedImplementation() {

    }

    public String getNestedField() {
      return nestedField;
    }

    public void setNestedField(String nestedField) {
      this.nestedField = nestedField;
    }
  }
}
