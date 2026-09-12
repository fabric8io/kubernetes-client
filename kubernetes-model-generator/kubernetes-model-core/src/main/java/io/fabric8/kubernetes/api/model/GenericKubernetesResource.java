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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "apiVersion", "kind", "metadata", "items" })
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class GenericKubernetesResource implements Editable<GenericKubernetesResourceBuilder>, HasMetadata {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  @JsonProperty("apiVersion")
  private String apiVersion;
  @JsonProperty("kind")
  private String kind;
  @JsonProperty("metadata")
  private ObjectMeta metadata;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<>();

  @JsonIgnore
  public GenericKubernetesResourceBuilder edit() {
    return new GenericKubernetesResourceBuilder(this);
  }

  @JsonIgnore
  public GenericKubernetesResourceBuilder toBuilder() {
    return edit();
  }

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

  // spotless:off
  // spotless:on
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
   * "field": {
   * "value": 42
   * "list": [
   * {entry: 1}, {entry: 2}, {entry: 3}
   * ],
   * "1": "one"
   * }
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

  public String getApiVersion() {
    return this.apiVersion;
  }

  public String getKind() {
    return this.kind;
  }

  public ObjectMeta getMetadata() {
    return this.metadata;
  }

  public void setApiVersion(final String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public void setKind(final String kind) {
    this.kind = kind;
  }

  public void setMetadata(final ObjectMeta metadata) {
    this.metadata = metadata;
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "GenericKubernetesResource(apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", metadata="
        + this.getMetadata() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object o) {
    if (o == this)
      return true;
    if (!(o instanceof GenericKubernetesResource))
      return false;
    final GenericKubernetesResource other = (GenericKubernetesResource) o;
    if (!other.canEqual((java.lang.Object) this))
      return false;
    final java.lang.Object this$apiVersion = this.getApiVersion();
    final java.lang.Object other$apiVersion = other.getApiVersion();
    if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion))
      return false;
    final java.lang.Object this$kind = this.getKind();
    final java.lang.Object other$kind = other.getKind();
    if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind))
      return false;
    final java.lang.Object this$metadata = this.getMetadata();
    final java.lang.Object other$metadata = other.getMetadata();
    if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata))
      return false;
    final java.lang.Object this$additionalProperties = this.getAdditionalProperties();
    final java.lang.Object other$additionalProperties = other.getAdditionalProperties();
    if (this$additionalProperties == null ? other$additionalProperties != null
        : !this$additionalProperties.equals(other$additionalProperties))
      return false;
    return true;
  }

  protected boolean canEqual(final java.lang.Object other) {
    return other instanceof GenericKubernetesResource;
  }

  @java.lang.Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final java.lang.Object $apiVersion = this.getApiVersion();
    result = result * PRIME + ($apiVersion == null ? 43 : $apiVersion.hashCode());
    final java.lang.Object $kind = this.getKind();
    result = result * PRIME + ($kind == null ? 43 : $kind.hashCode());
    final java.lang.Object $metadata = this.getMetadata();
    result = result * PRIME + ($metadata == null ? 43 : $metadata.hashCode());
    final java.lang.Object $additionalProperties = this.getAdditionalProperties();
    result = result * PRIME + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
    return result;
  }
}
