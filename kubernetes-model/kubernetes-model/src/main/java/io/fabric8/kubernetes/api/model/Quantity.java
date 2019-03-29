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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.Inline;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.Generated;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;


/**
 *
 *
 */
@JsonDeserialize(using = Quantity.Deserializer.class)
@JsonSerialize(using = Quantity.Serializer.class)
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = true, generateBuilderPackage=true, builderPackage = "io.fabric8.kubernetes.api.builder", inline = @Inline(type = Doneable.class, prefix = "Doneable", value = "done"))
public class Quantity  implements Serializable {

    private String amount;
    private String format;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Quantity() {
    }

    /**
     * Single argument constructor for setting amount.
     *
     * @param amount amount of quantity specified.
     */
    public Quantity(String amount) {
        this.amount = amount;
    }

    /**
     * Double argument constructor for setting amount along with format.
     *
     * @param amount amount of quantity specified
     * @param format format for the amount.
     */
    public Quantity(String amount, String format) {
        this.amount = amount;
        this.format = format;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public static class Serializer extends JsonSerializer<Quantity> {

        @Override
        public void serialize(Quantity value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value != null && value.getAmount() != null) {
                jgen.writeString(value.getAmount());
            } else {
                jgen.writeNull();
            }
        }
    }

    public static class Deserializer extends JsonDeserializer<Quantity> {

        @Override
        public Quantity deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            Quantity quantity = new Quantity(node.asText());
            return quantity;
        }

    }

}
