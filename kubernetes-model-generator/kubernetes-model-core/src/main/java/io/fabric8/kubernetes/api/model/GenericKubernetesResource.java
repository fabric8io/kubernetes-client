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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

  private static final Pattern ARRAY_PROPERTY_PATTERN = Pattern.compile("^(.+)\\[(\\d+)]$");

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
   * Allows the retrieval of field values from this Resource for the provided path segments.
   *
   * <p> The following notation is supported
   * <ul>
   *   <li>
   *     Dot Notation
   *     <pre>{@code resource.get("path.of.the.nested.prop");}</pre>
   *   </li>
   *   <li>
   *     Varargs Notation
   *     <pre>{@code resource.get("path", "of", "the", "nested", "prop");}</pre>
   *   </li>
   *   <li>
   *     Mixed Notation
   *     <pre>{@code resource.get("path.of", "the.nested", "prop");}</pre>
   *   </li>
   * </ul>
   *
   * <p> In addition, fields that contain collections/arrays can also be traversed
   * <pre>{@code resource.get("path.collectionField[1].nested.array[0].field");}</pre>
   *
   * <p> {@code .} may be escaped with {@code \\.}
   * Any other appearance of {@code \\} will be treated as itself.
   *
   * @param path of the field to retrieve.
   * @param <T> type of the returned object.
   * @return the value of the traversed path or null if the field does not exist.
   */
  @SuppressWarnings("unchecked")
  public <T> T get(String... path) {
    Object current = null;
    int it = 0;
    final List<String> properties = Stream.of(path).map(p -> p.split("(?<!\\\\)\\.")).flatMap(Stream::of)
      .collect(Collectors.toList());
    for (String p : properties) {
      p = p.replace("\\.", ".");
      if (it++ == 0) {
        current = getAdditionalProperties().get(p);
      } else {
        final Matcher arrayMatcher = ARRAY_PROPERTY_PATTERN.matcher(p);
        if (current instanceof Map && arrayMatcher.find()) {
          final String key = arrayMatcher.group(1);
          final int index = Integer.parseInt(arrayMatcher.group(2));
          final Map<String, Object> field = (Map<String, Object>) current;
          current = ((Collection<Object>)field.get(key)).toArray()[index];
        } else if (current instanceof Map) {
          current = ((Map<String, Object>) current).get(p);
        } else {
          throw new IllegalArgumentException("Cannot get property '" + String.join(".", properties) +
            "' from " + getApiVersion() + " " + getKind() +
            " (missing segment '" + String.join(".", properties.subList(it - 1, properties.size())) + "')");
        }
      }
    }
    return (T) current;
  }
}
