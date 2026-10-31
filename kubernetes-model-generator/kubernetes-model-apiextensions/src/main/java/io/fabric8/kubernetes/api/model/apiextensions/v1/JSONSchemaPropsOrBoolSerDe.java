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
package io.fabric8.kubernetes.api.model.apiextensions.v1;

import tools.jackson.core.JsonGenerator;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.ValueSerializer;

public class JSONSchemaPropsOrBoolSerDe {

  private JSONSchemaPropsOrBoolSerDe() {
  }

  public static class Serializer extends ValueSerializer<JSONSchemaPropsOrBool> {
    @Override
    public void serialize(JSONSchemaPropsOrBool jsonSchemaPropsOrBool,
        JsonGenerator jsonGenerator,
        SerializationContext serializationContext) {
      if (jsonSchemaPropsOrBool.getSchema() != null) {
        jsonGenerator.writePOJO(jsonSchemaPropsOrBool.getSchema());
      } else {
        jsonGenerator.writeBoolean(jsonSchemaPropsOrBool.getAllows());
      }
    }
  }

  public static class Deserializer extends ValueDeserializer<JSONSchemaPropsOrBool> {

    @Override
    public JSONSchemaPropsOrBool deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
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
