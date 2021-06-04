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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "object",
    "type"
})
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, builderPackage = "io.fabric8.kubernetes.api.builder")
public class WatchEvent implements KubernetesResource
{

  /**
   *
   *
   */
  @JsonProperty("object")
  private KubernetesResource object;
  /**
   * the type of watch event; may be ADDED
   *
   */
  @JsonProperty("type")
  private String type;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  /**
   * No args constructor for use in serialization
   *
   */
  public WatchEvent() {
  }

  /**
   *
   * @param type
   * @param object
   */
  public WatchEvent(KubernetesResource object, String type) {
    this.object = object;
    this.type = type;
  }

  /**
   *
   *
   * @return
   *     The object
   */
  @JsonProperty("object")
  public KubernetesResource getObject() {
    return object;
  }

  /**
   *
   *
   * @param object
   *     The object
   */
  @JsonProperty("object")
  public void setObject(KubernetesResource object) {
    this.object = object;
  }

  /**
   * the type of watch event; may be ADDED
   *
   * @return
   *     The type
   */
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  /**
   * the type of watch event; may be ADDED
   *
   * @param type
   *     The type
   */
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

}
