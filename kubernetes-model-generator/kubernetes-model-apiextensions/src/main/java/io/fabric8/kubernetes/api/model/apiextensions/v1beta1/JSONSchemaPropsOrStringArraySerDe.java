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
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public class JSONSchemaPropsOrStringArraySerDe {
  private JSONSchemaPropsOrStringArraySerDe() {
  }

  public static class Serializer extends JsonSerializer<JSONSchemaPropsOrStringArray> {
    @Override
    public void serialize(JSONSchemaPropsOrStringArray jsonSchemaPropsOrStringArray,
        JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException {
      if (jsonSchemaPropsOrStringArray.getProperty() != null && !jsonSchemaPropsOrStringArray.getProperty().isEmpty()) {
        jsonGenerator.writeStartArray();
        for (String property : jsonSchemaPropsOrStringArray.getProperty()) {
          jsonGenerator.writeObject(property);
        }
        jsonGenerator.writeEndArray();
      } else {
        jsonGenerator.writeObject(jsonSchemaPropsOrStringArray.getSchema());
      }
    }
  }

  public static class Deserializer extends JsonDeserializer<JSONSchemaPropsOrStringArray> {

    @Override
    public JSONSchemaPropsOrStringArray deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {
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
