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

package io.fabric8.kubernetes.api.model.apiextensions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.builder.annotations.Inline;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * JSONSchemaPropsOrStringArray represents a JSONSchemaProps or a string array.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
  "apiVersion",
  "kind",
  "metadata",
  "Property",
  "Schema"
})
@JsonDeserialize(using = JSONSchemaPropsOrStringArray.Deserializer.class)
@JsonSerialize(using = JSONSchemaPropsOrStringArray.Serializer.class)
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", inline = {
  @Inline(type = Doneable.class, prefix = "Doneable", value = "done")
}, refs = {
  @BuildableReference(ObjectMeta.class),
  @BuildableReference(LabelSelector.class),
  @BuildableReference(Container.class),
  @BuildableReference(PodTemplateSpec.class),
  @BuildableReference(ResourceRequirements.class),
  @BuildableReference(IntOrString.class),
  @BuildableReference(ObjectReference.class),
  @BuildableReference(LocalObjectReference.class),
  @BuildableReference(PersistentVolumeClaim.class)
})
public class JSONSchemaPropsOrStringArray implements KubernetesResource {

  @JsonProperty("Property")
  private List<String> property = new ArrayList<String>();

  @JsonProperty("Schema")
  private JSONSchemaProps schema;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * No args constructor for use in serialization
   */
  public JSONSchemaPropsOrStringArray() {
  }

  public JSONSchemaPropsOrStringArray(List<String> property, JSONSchemaProps schema) {
    this.property = property;
    this.schema = schema;
  }

  public JSONSchemaPropsOrStringArray(List<String> property) {
    this(property, null);
  }

  public JSONSchemaPropsOrStringArray(JSONSchemaProps schema) {
    this(null, schema);
  }

  /**
   * Get Property
   *
   * @return The property
   */
  @JsonProperty("Property")
  public List<String> getProperty() {
    return property;
  }

  /**
   * Set Property
   *
   * @param property The Property
   */
  @JsonProperty("Property")
  public void setProperty(List<String> property) {
    this.property = property;
  }

  /**
   * Get Schema
   *
   * @return The schema
   */
  @JsonProperty("Schema")
  public JSONSchemaProps getSchema() {
    return schema;
  }

  /**
   * Set Schema
   *
   * @param schema The Schema
   */
  @JsonProperty("Schema")
  public void setSchema(JSONSchemaProps schema) {
    this.schema = schema;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public static class Serializer extends JsonSerializer<JSONSchemaPropsOrStringArray> {

    @Override
    public void serialize(JSONSchemaPropsOrStringArray value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      if (value.getSchema() != null && value.getProperty() != null) {
        throw new IllegalArgumentException("schema and property both can't be present ");
      } else if (value.getProperty() != null) {
        writeArray(value, jgen);
      } else if (value.getSchema() != null ) {
        jgen.writeObject(value.getSchema());
      } else {
        jgen.writeNull();
      }
    }

    private void writeArray(JSONSchemaPropsOrStringArray value, JsonGenerator jgen) throws IOException {
      jgen.writeStartArray(value.getProperty().size());
      for (String property : value.getProperty()) {
        jgen.writeObject(property);
      }
      jgen.writeEndArray();
    }
  }

  public static class Deserializer extends JsonDeserializer<JSONSchemaPropsOrStringArray> {

    @Override
    public JSONSchemaPropsOrStringArray deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
      if (jsonParser.isExpectedStartArrayToken()) {
        return new JSONSchemaPropsOrStringArray((List<String>)ctxt.readValue(jsonParser, ctxt.getTypeFactory().constructCollectionType(List.class, String.class)));
      } else {
        return new JSONSchemaPropsOrStringArray(ctxt.readValue(jsonParser, JSONSchemaProps.class));
      }
    }
  }
}
