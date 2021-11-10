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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = IntOrString.Deserializer.class)
@JsonSerialize(using = IntOrString.Serializer.class)
@JsonPropertyOrder({
    "IntVal",
    "Kind",
    "StrVal"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage=true, builderPackage = "io.fabric8.kubernetes.api.builder")
public class IntOrString implements Serializable {

    @JsonProperty("IntVal")
    private Integer IntVal;
    @JsonProperty("Kind")
    private Integer Kind;
    @JsonProperty("StrVal")
    private String StrVal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public IntOrString() {
    }

    //Builders are generated for the first non-empty constructor found.
    public IntOrString(Integer intVal, Integer kind, String strVal, Map<String, Object> additionalProperties) {
        IntVal = intVal;
        Kind = kind;
        StrVal = strVal;
        this.additionalProperties = additionalProperties;
    }

    public IntOrString(Integer intVal) {
        this(intVal, 0, null, new HashMap<>());
    }

    public IntOrString(String strVal) {
        this(null, 1, strVal, new HashMap<>());
    }


    /**
     *
     * @return
     *     The IntVal
     */
    @JsonProperty("IntVal")
    public Integer getIntVal() {
        return IntVal;
    }

    /**
     *
     * @param IntVal
     *     The IntVal
     */
    @JsonProperty("IntVal")
    public void setIntVal(Integer IntVal) {
        this.IntVal = IntVal;
    }

    /**
     *
     * @return
     *     The Kind
     */
    @JsonProperty("Kind")
    public Integer getKind() {
        return Kind;
    }

    /**
     *
     * @param Kind
     *     The Kind
     */
    @JsonProperty("Kind")
    public void setKind(Integer Kind) {
        this.Kind = Kind;
    }

    /**
     *
     * @return
     *     The StrVal
     */
    @JsonProperty("StrVal")
    public String getStrVal() {
        return StrVal;
    }

    /**
     *
     * @param StrVal
     *     The StrVal
     */
    @JsonProperty("StrVal")
    public void setStrVal(String StrVal) {
        this.StrVal = StrVal;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public static class Serializer extends JsonSerializer<IntOrString> {

        @Override
        public void serialize(IntOrString value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value != null) {
                if (value.getKind() == null) {
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
                } else if (value.getKind() == 0) {
                    jgen.writeNumber(value.getIntVal());
                } else if (value.getKind() == 1) {
                    jgen.writeString(value.getStrVal());
                } else {
                    jgen.writeNull();
                }
            } else {
                jgen.writeNull();
            }
        }

    }

    public static class Deserializer extends JsonDeserializer<IntOrString> {

        @Override
        public IntOrString deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
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
