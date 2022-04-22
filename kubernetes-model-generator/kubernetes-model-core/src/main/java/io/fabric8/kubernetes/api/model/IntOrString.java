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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = IntOrString.Deserializer.class)
@JsonSerialize(using = IntOrString.Serializer.class)
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
public class IntOrString implements Serializable {

  private Object value;

  public IntOrString() {
  }

  //Builders are generated for the first non-empty constructor found.
  @Buildable(editableEnabled = false, generateBuilderPackage = true, builderPackage = "io.fabric8.kubernetes.api.builder")
  public IntOrString(Object value) {
    if (value == null || value instanceof Integer || value instanceof String) {
      this.value = value;
    } else {
      throw new IllegalArgumentException("Either integer or string value needs to be provided");
    }
  }

  /**
   * Get Raw enclosed object.
   *
   * @return Object value
   */
  public Object getValue() {
    return value;
  }

  /**
   * Get Integer value
   *
   * @return Integer value if set
   */
  public Integer getIntVal() {
    if (value instanceof Integer) {
      return (Integer) value;
    }
    return null;
  }

  /**
   * Get String value
   *
   * @return string value if set
   */
  public String getStrVal() {
    if (value instanceof String) {
      return (String) value;
    }
    return null;
  }

  public static class Serializer extends JsonSerializer<IntOrString> {

    @Override
    public void serialize(IntOrString value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      if (value != null) {
        Integer intValue = value.getIntVal();
        if (intValue != null) {
          jgen.writeNumber(intValue);
        } else {
          String stringValue = value.getStrVal();
          if (stringValue != null) {
            jgen.writeString(stringValue);
          } else {
            jgen.writeNull();
          }
        }
      } else {
        jgen.writeNull();
      }
    }
  }

  public static class Deserializer extends JsonDeserializer<IntOrString> {

    @Override
    public IntOrString deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException {
      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      IntOrString intOrString;
      if (node.isInt()) {
        intOrString = new IntOrString(node.asInt());
      } else {
        intOrString = new IntOrString(node.asText());
      }
      return intOrString;
    }

  }
}
