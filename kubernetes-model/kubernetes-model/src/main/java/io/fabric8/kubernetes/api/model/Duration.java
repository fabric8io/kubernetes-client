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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
import io.fabric8.kubernetes.api.model.Doneable;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.Inline;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Duration is wrapper around duration variable which just stores the
 * amount of time in seconds. It supports correct marshaling to YAML
 * and JSON. In particular, it marshals into strings, which can be used
 * as map keys in json.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = Duration.Deserializer.class)
@JsonSerialize(using = Duration.Serializer.class)
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", inline = @Inline(type = Doneable.class, prefix = "Doneable", value = "done"))
public class Duration implements Serializable
{

    /**
     * 
     * 
     */
    @JsonProperty("Duration")
    private Long duration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Duration() {
    }

    /**
     * 
     * @param duration
     */
    public Duration(Long duration) {
        this.duration = duration;
    }

    public Duration(String duration) {
      Pattern p = Pattern.compile("\\d+");
      Matcher m = p.matcher(duration);
      long totalSeconds = 0;

      while (m.find()) {
        String digit = m.group();
        int digitIndex = duration.indexOf(digit);
        if (digitIndex + 1 < duration.length()) {
          char unit = duration.charAt(digitIndex + 1);
          if (unit == 'h') {
            totalSeconds += (3600 * Integer.parseInt(digit));
          } else if (unit == 'm') {
            totalSeconds += (60 * Integer.parseInt(digit));
          } else if (unit == 's') {
            totalSeconds += (Integer.parseInt(digit));
          }
        }
      }
      this.duration = totalSeconds;
    }

    /**
     * 
     * 
     * @return
     *     The duration
     */
    @JsonProperty("Duration")
    public Long getDuration() {
        return duration;
    }

    /**
     * 
     * 
     * @param duration
     *     The Duration
     */
    @JsonProperty("Duration")
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

  public static class Serializer extends JsonSerializer<Duration> {

    @Override
    public void serialize(Duration value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      if (value != null && value.getDuration() != null) {
        jgen.writeString(value.getDuration().toString());
      } else {
        jgen.writeNull();
      }
    }
  }

  public static class Deserializer extends JsonDeserializer<Duration> {

    @Override
    public Duration deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      Duration duration = new Duration(node.asText());
      return duration;
    }

  }

}
