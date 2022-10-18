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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;

/**
 * A holder for a value of any type - a wrapped primitive, an array, or object value.
 * <p>
 * It does not matter what the object type is, default serialization logic will be used.
 */
@JsonSerialize(using = AnyType.Serializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Setter
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class AnyType implements Serializable {

  protected Object value;

  public AnyType() {
  }

  @JsonCreator
  //Builders are generated for the first non-empty constructor found.
  @Buildable(editableEnabled = false, generateBuilderPackage = true, builderPackage = "io.fabric8.kubernetes.api.builder")
  public AnyType(Object value) {
    this.value = value;
  }

  /**
   * Get Raw enclosed object.
   * <p>
   * If this instance has been deserialized, the Object will be
   * composed of the default object mapping - a wrapped primitive value,
   * a Map&lt;String, Object&gt;, or a List of those values
   *
   * @return Object value
   */
  public Object getValue() {
    return value;
  }

  public static class Serializer extends JsonSerializer<AnyType> {

    @Override
    public void serialize(AnyType value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
      jgen.writeObject(value.value);
    }
  }

}
