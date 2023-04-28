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
package io.fabric8.java.generator;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Builder(toBuilder = true)
@NoArgsConstructor
public class Config {
  private static final boolean DEFAULT_UPPERCASE_ENUM = true;
  private static final boolean DEFAULT_ADD_EXTRA_ANNOTATIONS = false;
  private static final boolean DEFAULT_ADD_GENERATED_ANNOTATIONS = true;
  private static final Map<String, String> DEFAULT_PACKAGE_OVERRIDES = new HashMap<>();

  private Boolean uppercaseEnums = DEFAULT_UPPERCASE_ENUM;
  private Boolean objectExtraAnnotations = DEFAULT_ADD_EXTRA_ANNOTATIONS;
  private Boolean generatedAnnotations = DEFAULT_ADD_GENERATED_ANNOTATIONS;
  private Map<String, String> packageOverrides = DEFAULT_PACKAGE_OVERRIDES;

  public Config(
      Boolean uppercaseEnums,
      Boolean objectExtraAnnotations,
      Boolean generatedAnnotations,
      Map<String, String> packageOverrides) {
    if (uppercaseEnums != null) {
      this.uppercaseEnums = uppercaseEnums;
    }
    if (objectExtraAnnotations != null) {
      this.objectExtraAnnotations = objectExtraAnnotations;
    }
    if (generatedAnnotations != null) {
      this.generatedAnnotations = generatedAnnotations;
    }
    if (packageOverrides != null) {
      this.packageOverrides = packageOverrides;
    }
  }

  public boolean isUppercaseEnums() {
    return (uppercaseEnums == null) ? DEFAULT_UPPERCASE_ENUM : uppercaseEnums;
  }

  public boolean isObjectExtraAnnotations() {
    return (objectExtraAnnotations == null)
        ? DEFAULT_ADD_EXTRA_ANNOTATIONS
        : objectExtraAnnotations;
  }

  public boolean isGeneratedAnnotations() {
    return (generatedAnnotations == null)
        ? DEFAULT_ADD_GENERATED_ANNOTATIONS
        : generatedAnnotations;
  }

  public Map<String, String> getPackageOverrides() {
    return (packageOverrides == null)
        ? DEFAULT_PACKAGE_OVERRIDES
        : packageOverrides;
  }
}
