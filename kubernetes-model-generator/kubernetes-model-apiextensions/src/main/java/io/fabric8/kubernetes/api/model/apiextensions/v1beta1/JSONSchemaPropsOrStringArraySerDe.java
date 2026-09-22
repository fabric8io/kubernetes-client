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
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import tools.jackson.core.JsonGenerator;
import tools.jackson.core.JsonParser;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.ValueSerializer;

import java.util.List;

public class JSONSchemaPropsOrStringArraySerDe {
  private JSONSchemaPropsOrStringArraySerDe() {
  }

  public static class Serializer extends ValueSerializer<JSONSchemaPropsOrStringArray> {
    @Override
    public void serialize(JSONSchemaPropsOrStringArray jsonSchemaPropsOrStringArray,
        JsonGenerator jsonGenerator,
        SerializationContext serializationContext) {
      if (jsonSchemaPropsOrStringArray.getProperty() != null && !jsonSchemaPropsOrStringArray.getProperty().isEmpty()) {
        jsonGenerator.writeStartArray();
        for (String property : jsonSchemaPropsOrStringArray.getProperty()) {
          jsonGenerator.writePOJO(property);
        }
        jsonGenerator.writeEndArray();
      } else {
        jsonGenerator.writePOJO(jsonSchemaPropsOrStringArray.getSchema());
      }
    }
  }

  public static class Deserializer extends ValueDeserializer<JSONSchemaPropsOrStringArray> {

    @Override
    public JSONSchemaPropsOrStringArray deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
      JSONSchemaPropsOrStringArrayBuilder builder = new JSONSchemaPropsOrStringArrayBuilder();
      if (jsonParser.isExpectedStartObjectToken()) {
        builder.withSchema(
            jsonParser.readValueAs(JSONSchemaProps.class));
      } else if (jsonParser.isExpectedStartArrayToken()) {
        builder.withProperty(jsonParser.<List<String>> readValueAs(new TypeReference<List<String>>() {
        }));
      }
      return builder.build();
    }
  }
}
