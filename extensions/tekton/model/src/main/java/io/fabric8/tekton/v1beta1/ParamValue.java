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

package io.fabric8.tekton.v1beta1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonDeserialize(using = ParamValue.Deserializer.class)
@JsonSerialize(using = ParamValue.Serializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ArrayVal",
    "ObjectVal",
    "StringVal",
    "Type"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ParamValue implements Editable<io.fabric8.tekton.v1beta1.ParamValueBuilder>, KubernetesResource {

  private static final String TYPE_STRING = "string";
  private static final String TYPE_ARRAY = "array";
  private static final String TYPE_OBJECT = "object";

  @JsonProperty("ArrayVal")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> arrayVal = new ArrayList<>();
  @JsonProperty("ObjectVal")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Map<String, String> objectVal = new LinkedHashMap<>();
  @JsonProperty("StringVal")
  private String stringVal;
  @JsonProperty("Type")
  private String type;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  /**
   * No args constructor for use in serialization
   *
   */
  public ParamValue() {
  }

  public ParamValue(List<String> arrayVal, Map<String, String> objectVal, String stringVal, String type) {
    super();
    this.arrayVal = arrayVal;
    this.objectVal = objectVal;
    this.stringVal = stringVal;
    this.type = type;
  }

  public ParamValue(String stringVal) {
    this(null, null, stringVal, TYPE_STRING);
  }

  public ParamValue(List<String> arrayVal) {
    this(arrayVal, null, null, TYPE_ARRAY);
  }

  public ParamValue(Map<String, String> objectVal) {
    this(null, objectVal, null, TYPE_OBJECT);
  }

  @JsonProperty("ArrayVal")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  public List<String> getArrayVal() {
    return arrayVal;
  }

  @JsonProperty("ArrayVal")
  public void setArrayVal(List<String> arrayVal) {
    this.arrayVal = arrayVal;
  }

  @JsonProperty("ObjectVal")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  public Map<String, String> getObjectVal() {
    return objectVal;
  }

  @JsonProperty("ObjectVal")
  public void setObjectVal(Map<String, String> objectVal) {
    this.objectVal = objectVal;
  }

  @JsonProperty("StringVal")
  public String getStringVal() {
    return stringVal;
  }

  @JsonProperty("StringVal")
  public void setStringVal(String stringVal) {
    this.stringVal = stringVal;
  }

  @JsonProperty("Type")
  public String getType() {
    return type;
  }

  @JsonProperty("Type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonIgnore
  public io.fabric8.tekton.v1beta1.ParamValueBuilder edit() {
    return new io.fabric8.tekton.v1beta1.ParamValueBuilder(this);
  }

  @JsonIgnore
  public ParamValueBuilder toBuilder() {
    return edit();
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
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
