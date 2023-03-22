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
package io.fabric8.tekton.pipeline.v1beta1;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "arrayVal",
    "stringVal",
    "type"
})
@JsonDeserialize(using = ParamValue.Deserializer.class)
@JsonSerialize(using = ParamValue.Serializer.class)
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ParamValue implements KubernetesResource {

  private static final String TYPE_STRING = "string";
  private static final String TYPE_ARRAY = "array";

  @JsonProperty("arrayVal")
  private List<String> arrayVal = new ArrayList<>();

  @JsonProperty("stringVal")
  private String stringVal;

  @JsonProperty("type")
  private String type;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  /**
   * No args constructor for use in serialization
   */
  public ParamValue() {
  }

  //Builders are generated for the first non-empty constructor found.
  public ParamValue(List<String> arrayVal, String stringVal, String type, Map<String, Object> additionalProperties) {
    this.arrayVal = arrayVal;
    this.stringVal = stringVal;
    this.type = type;
    this.additionalProperties = additionalProperties;
  }

  public ParamValue(String stringVal) {
    this(null, stringVal, TYPE_STRING, new HashMap<>());
  }

  public ParamValue(List<String> arrayVal) {
    this(arrayVal, null, TYPE_ARRAY, new HashMap<>());
  }

  @JsonProperty("arrayVal")
  public List<String> getArrayVal() {
    return arrayVal;
  }

  @JsonProperty("arrayVal")
  public void setArrayVal(List<String> arrayVal) {
    this.arrayVal = arrayVal;
  }

  @JsonProperty("stringVal")
  public String getStringVal() {
    return stringVal;
  }

  @JsonProperty("stringVal")
  public void setStringVal(String stringVal) {
    this.stringVal = stringVal;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public static class Serializer extends JsonSerializer<ParamValue> {

    @Override
    public void serialize(ParamValue value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
      if (value != null) {
        if (value.getType() == null) {
          String stringVal = value.getStringVal();
          if (stringVal != null) {
            jgen.writeString(stringVal);
          } else {
            List<String> arrayVal = value.getArrayVal();
            if (arrayVal != null) {
              writeArray(value, jgen);
            } else {
              jgen.writeNull();
            }
          }
        } else if (Objects.equals(value.getType(), TYPE_STRING)) {
          jgen.writeString(value.stringVal);
        } else if (Objects.equals(value.getType(), TYPE_ARRAY)) {
          writeArray(value, jgen);
        } else {
          jgen.writeNull();
        }
      } else {
        jgen.writeNull();
      }
    }

    private void writeArray(ParamValue value, JsonGenerator jgen) throws IOException {
      jgen.writeStartArray(value.getArrayVal().size());
      for (String n : value.getArrayVal()) {
        jgen.writeString(n);
      }
      jgen.writeEndArray();
    }

  }

  public static class Deserializer extends JsonDeserializer<ParamValue> {

    @Override
    public ParamValue deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      ParamValue arrayOrString;
      if (node.isArray()) {
        List<String> elements = new ArrayList<>();
        node.elements().forEachRemaining(n -> elements.add(n.asText()));
        arrayOrString = new ParamValue(elements);
      } else {
        arrayOrString = new ParamValue(node.asText());
      }
      return arrayOrString;
    }

  }

}
