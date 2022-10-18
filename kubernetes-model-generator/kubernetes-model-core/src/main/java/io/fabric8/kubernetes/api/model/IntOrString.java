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
import io.sundr.builder.annotations.Buildable;

public class IntOrString extends AnyType {

  public IntOrString() {
  }

  @JsonCreator
  //Builders are generated for the first non-empty constructor found.
  @Buildable(editableEnabled = false, generateBuilderPackage = true, builderPackage = "io.fabric8.kubernetes.api.builder")
  public IntOrString(Object value) {
    setValue(value);
  }

  @Override
  public void setValue(Object value) {
    if (value != null && !(value instanceof Integer) && !(value instanceof String)) {
      throw new IllegalArgumentException("Either integer or string value needs to be provided");
    }
    super.setValue(value);
  }

  /**
   * Get Integer value
   *
   * @return Integer value if set
   */
  public Integer getIntVal() {
    if (value instanceof Integer) {
      return (Integer) value;
    }
    return null;
  }

  /**
   * Get String value
   *
   * @return string value if set
   */
  public String getStrVal() {
    if (value instanceof String) {
      return (String) value;
    }
    return null;
  }

}
