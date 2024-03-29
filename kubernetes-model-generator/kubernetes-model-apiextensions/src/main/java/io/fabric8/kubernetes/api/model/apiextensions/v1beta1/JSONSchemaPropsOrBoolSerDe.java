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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class JSONSchemaPropsOrBoolSerDe {

  private JSONSchemaPropsOrBoolSerDe() {
  }

  public static class Serializer extends JsonSerializer<JSONSchemaPropsOrBool> {
    @Override
    public void serialize(JSONSchemaPropsOrBool jsonSchemaPropsOrBool,
        JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException {
      if (jsonSchemaPropsOrBool.getSchema() != null) {
        jsonGenerator.writeObject(jsonSchemaPropsOrBool.getSchema());
      } else {
        jsonGenerator.writeBoolean(jsonSchemaPropsOrBool.getAllows());
      }
    }
  }

  public static class Deserializer extends JsonDeserializer<JSONSchemaPropsOrBool> {

    @Override
    public JSONSchemaPropsOrBool deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {
      JSONSchemaPropsOrBoolBuilder builder = new JSONSchemaPropsOrBoolBuilder();
      if (jsonParser.isExpectedStartObjectToken()) {
        builder.withSchema(
            jsonParser.readValueAs(JSONSchemaProps.class));
        builder.withAllows(true);
      } else {
        builder.withAllows(jsonParser.getBooleanValue());
      }
      return builder.build();
    }
  }
}
