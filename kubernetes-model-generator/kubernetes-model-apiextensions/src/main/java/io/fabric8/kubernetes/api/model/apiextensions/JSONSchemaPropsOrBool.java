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
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
 * JSONSchemaPropsOrBool represents JSONSchemaProps or a boolean value.
 * Defaults to true for the boolean property.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
  "apiVersion",
  "kind",
  "metadata",
  "Allows",
  "Schema"
})
@JsonDeserialize(using = JSONSchemaPropsOrBool.Deserializer.class)
@JsonSerialize(using = JSONSchemaPropsOrBool.Serializer.class)
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
public class JSONSchemaPropsOrBool implements KubernetesResource {

  /**
   *
   */
  @JsonProperty("Allows")
  private Boolean allows;
  /**
   *
   */
  @JsonProperty("Schema")
  private JSONSchemaProps schema;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * No args constructor for use in serialization
   */
  public JSONSchemaPropsOrBool() {
  }

  public JSONSchemaPropsOrBool(Boolean allows, JSONSchemaProps schema) {
    this.allows = allows;
    this.schema = schema;
  }

  public JSONSchemaPropsOrBool(Boolean allows) {
    this(allows, null);
  }

  public JSONSchemaPropsOrBool(JSONSchemaProps schema) {
    this(null, schema);
  }

  /**
   * Get Allows
   *
   * @return The allows
   */
  @JsonProperty("Allows")
  public Boolean getAllows() {
    return allows;
  }

  /**
   * Set Allows
   *
   * @param allows The Allows
   */
  @JsonProperty("Allows")
  public void setAllows(Boolean allows) {
    this.allows = allows;
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
   * Set schema
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

  public static class Serializer extends JsonSerializer<JSONSchemaPropsOrBool> {

    @Override
    public void serialize(JSONSchemaPropsOrBool value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      if (value.getSchema() != null && value.getAllows() != null) {
        throw new IllegalArgumentException("schema and allows both can't be set");
      } else if (value.getAllows() != null) {
        jgen.writeBoolean(value.getAllows());
      } else if (value.getSchema() != null ) {
        jgen.writeObject(value.getSchema());
      } else {
        jgen.writeNull();
      }
    }

  }

  public static class Deserializer extends JsonDeserializer<JSONSchemaPropsOrBool> {

    @Override
    public JSONSchemaPropsOrBool deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      if (jsonParser.isExpectedStartObjectToken()) {
        return new JSONSchemaPropsOrBool(ctxt.readValue(jsonParser, JSONSchemaProps.class));
      } else {
        return new JSONSchemaPropsOrBool(ctxt.readValue(jsonParser, Boolean.class));
      }
    }

  }
}
