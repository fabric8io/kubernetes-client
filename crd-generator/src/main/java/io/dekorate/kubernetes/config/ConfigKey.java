/**
 * Copyright 2018 The original authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.dekorate.kubernetes.config;

import java.util.Objects;

public class ConfigKey<T> {

  private final String name;
  private final Class<T> type;
  private final T defaultValue;

  public ConfigKey(String name, Class<T> type) {
    this(name, type, null);
  }

  public ConfigKey(String name, Class<T> type, T defaultValue) {
    this.name = name;
    this.type = type;
    this.defaultValue = defaultValue;
  }

  public String getName() {
    return name;
  }

  public Class<T> getType() {
    return type;
  }

  public T getDefaultValue() {
    return defaultValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigKey<?> configKey = (ConfigKey<?>) o;
    return Objects.equals(name, configKey.name) &&
      Objects.equals(type, configKey.type);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, type);
  }
}
