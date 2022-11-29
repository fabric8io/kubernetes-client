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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MicroTimeSerDes {
  private MicroTimeSerDes() {
  }

  public static class Serializer extends JsonSerializer<MicroTime> {
    @Override
    public void serialize(MicroTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      if (value != null) {
        if (value.getTime() != null) {
          jgen.writeString(value.getTime());
        }
      } else {
        jgen.writeNull();
      }
    }
  }

  public static class Deserializer extends JsonDeserializer<MicroTime> {
    @Override
    public MicroTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      MicroTime microTime = null;
      if (node != null) {
        microTime = new MicroTime(node.asText());
      }
      return microTime;
    }
  }
}
