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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "items",
})
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class GenericKubernetesResource implements HasMetadata {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @JsonProperty("apiVersion")
  private String apiVersion;
  @JsonProperty("kind")
  private String kind;
  @JsonProperty("metadata")
  private ObjectMeta metadata;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  /**
   * @deprecated use KubernetesSerialization to convert the additionalProperties
   */
  @Deprecated
  @JsonIgnore
  public JsonNode getAdditionalPropertiesNode() {
    return MAPPER.convertValue(getAdditionalProperties(), JsonNode.class);
  }

  /**
   * Allows the retrieval of field values from this Resource for the provided path segments.
   *
   * <p>
   * If the path segment is of type {@link Integer}, then we assume that it is an array index to retrieve
   * the value of an entry in the array.
   *
   * <p>
   * If the path segment is of type {@link String}, then we assume that it is a field name to retrieve the value
   * from the resource.
   *
   * <p>
   * In any other case, the path segment is ignored and considered invalid. The method returns null.
   *
   * <p>
   * Considering the following JSON object:
   *
   * <pre>{@code
   * {
   *   "field": {
   *     "value": 42
   *     "list": [
   *       {entry: 1}, {entry: 2}, {entry: 3}
   *     ],
   *     "1": "one"
   *   }
   * }
   * }</pre>
   *
   * <p>
   * The following invocations will produce the documented results:
   * <ul>
   * <li>{@code get("field", "value")} will result in {@code 42}</li>
   * <li>{@code get("field", "1")} will result in {@code "one"}</li>
   * <li>{@code get("field", 1)} will result in {@code null}</li>
   * <li>{@code get("field", "list", 1, "entry")} will result in {@code 2}</li>
   * <li>{@code get("field", "list", 99, "entry")} will result in {@code null}</li>
   * <li>{@code get("field", "list", "1", "entry")} will result in {@code null}</li>
   * <li>{@code get("field", "list", 1, false)} will result in {@code null}</li>
   * </ul>
   *
   * @param path of the field to retrieve.
   * @param <T> type of the returned object.
   * @return the value of the traversed path or null if the field does not exist.
   */
  public <T> T get(Object... path) {
    return get(getAdditionalProperties(), path);
  }

  /**
   * The same as {@link #get(Object...)}, but starting at any root raw object
   *
   * @param <T> type of the returned object (Map, Collection, or value).
   * @param root starting object
   * @param path of the field to retrieve.
   * @return the value of the traversed path or null if the field does not exist.
   */
  @SuppressWarnings("unchecked")
  public static <T> T get(Map<String, Object> root, Object... path) {
    Object current = root;
    for (Object segment : path) {
      if (segment instanceof Integer && current instanceof Collection && ((Collection<?>) current).size() > (int) segment) {
        current = ((Collection<Object>) current).toArray()[(int) segment];
      } else if (segment instanceof String && current instanceof Map) {
        current = ((Map<String, Object>) current).get(segment.toString());
      } else {
        return null;
      }
    }
    return (T) current;
  }
}
