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
package io.fabric8.kubernetes.client.utils;

/**
 * Builder for YamlDumpSettings.
 */
public class YamlDumpSettingsBuilder {

  private boolean minQuotes = false;

  /**
   * Set whether use of quotes should be minimized.
   * 
   * @param minQuotes if {@code true}, quotes will only be included where necessary.
   */
  public YamlDumpSettingsBuilder setMinimizeQuotes(boolean minQuotes) {
    this.minQuotes = minQuotes;
    return this;
  }

  /**
   * Create immutable YamlDumpSettings
   *
   * @return YamlDumpSettings with the provided values
   */
  public YamlDumpSettings build() {
    return new YamlDumpSettings(minQuotes);
  }
}
