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
package io.fabric8.java.generator;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder(toBuilder = true)
@NoArgsConstructor
public class Config {
  public static final boolean DEFAULT_UPPERCASE_ENUM = true;
  public static final boolean DEFAULT_ADD_EXTRA_ANNOTATIONS = false;
  public static final boolean DEFAULT_ADD_GENERATED_ANNOTATIONS = true;
  public static final boolean DEFAULT_ALWAYS_PRESERVE_UNKNOWN = false;
  public static final Map<String, String> DEFAULT_PACKAGE_OVERRIDES = new HashMap<>();
  public static final List<String> DEFAULT_FILES_SUFFIXES = Arrays.asList(".yaml", ".yml", ".json");
  // RFC 3339 - from: https://swagger.io/docs/specification/data-models/data-types/
  public static final String DEFAULT_SER_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
  public static final String DEFAULT_DESER_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
  public static final Map<String, String> DEFAULT_EXISTING_JAVA_TYPES_OVERRIDES = new HashMap<>();

  private Boolean uppercaseEnums = DEFAULT_UPPERCASE_ENUM;
  private Boolean objectExtraAnnotations = DEFAULT_ADD_EXTRA_ANNOTATIONS;
  private Boolean generatedAnnotations = DEFAULT_ADD_GENERATED_ANNOTATIONS;
  private Boolean alwaysPreserveUnknown = DEFAULT_ALWAYS_PRESERVE_UNKNOWN;
  private Map<String, String> packageOverrides = DEFAULT_PACKAGE_OVERRIDES;
  private List<String> filesSuffixes = DEFAULT_FILES_SUFFIXES;
  private String serDatetimeFormat = DEFAULT_SER_DATETIME_FORMAT;
  private String deserDatetimeFormat = DEFAULT_DESER_DATETIME_FORMAT;
  private Map<String, String> existingJavaTypes = DEFAULT_EXISTING_JAVA_TYPES_OVERRIDES;

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

  @Deprecated
  public Config(
      Boolean uppercaseEnums,
      Boolean objectExtraAnnotations,
      Boolean generatedAnnotations,
      Map<String, String> packageOverrides,
      List<String> filesSuffixes) {
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
    if (filesSuffixes != null) {
      this.filesSuffixes = filesSuffixes;
    }
  }

  @Deprecated
  public Config(
      Boolean uppercaseEnums,
      Boolean objectExtraAnnotations,
      Boolean generatedAnnotations,
      Map<String, String> packageOverrides,
      List<String> filesSuffixes,
      String serDatetimeFormat,
      String deserDatetimeFormat) {
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
    if (filesSuffixes != null) {
      this.filesSuffixes = filesSuffixes;
    }
    if (serDatetimeFormat != null) {
      this.serDatetimeFormat = serDatetimeFormat;
    }
    if (deserDatetimeFormat != null) {
      this.deserDatetimeFormat = deserDatetimeFormat;
    }
  }

  public Config(
      Boolean uppercaseEnums,
      Boolean objectExtraAnnotations,
      Boolean generatedAnnotations,
      Boolean alwaysPreserveUnknown,
      Map<String, String> packageOverrides,
      List<String> filesSuffixes,
      String serDatetimeFormat,
      String deserDatetimeFormat,
      Map<String, String> existingJavaTypes) {
    if (uppercaseEnums != null) {
      this.uppercaseEnums = uppercaseEnums;
    }
    if (objectExtraAnnotations != null) {
      this.objectExtraAnnotations = objectExtraAnnotations;
    }
    if (generatedAnnotations != null) {
      this.generatedAnnotations = generatedAnnotations;
    }
    if (alwaysPreserveUnknown != null) {
      this.alwaysPreserveUnknown = alwaysPreserveUnknown;
    }
    if (packageOverrides != null) {
      this.packageOverrides = packageOverrides;
    }
    if (filesSuffixes != null) {
      this.filesSuffixes = filesSuffixes;
    }
    if (serDatetimeFormat != null) {
      this.serDatetimeFormat = serDatetimeFormat;
    }
    if (deserDatetimeFormat != null) {
      this.deserDatetimeFormat = deserDatetimeFormat;
    }
    if (existingJavaTypes != null) {
      this.existingJavaTypes = existingJavaTypes;
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

  public boolean isAlwaysPreserveUnknown() {
    return (alwaysPreserveUnknown == null)
        ? DEFAULT_ALWAYS_PRESERVE_UNKNOWN
        : alwaysPreserveUnknown;
  }

  public Map<String, String> getPackageOverrides() {
    return (packageOverrides == null || packageOverrides.isEmpty())
        ? DEFAULT_PACKAGE_OVERRIDES
        : packageOverrides;
  }

  public List<String> getFilesSuffixes() {
    return (filesSuffixes == null || filesSuffixes.isEmpty())
        ? DEFAULT_FILES_SUFFIXES
        : filesSuffixes;
  }

  public String getSerDatetimeFormat() {
    return (serDatetimeFormat == null || serDatetimeFormat.isEmpty())
        ? DEFAULT_SER_DATETIME_FORMAT
        : serDatetimeFormat;
  }

  public String getDeserDatetimeFormat() {
    return (deserDatetimeFormat == null || deserDatetimeFormat.isEmpty())
        ? DEFAULT_DESER_DATETIME_FORMAT
        : deserDatetimeFormat;
  }

  public Map<String, String> getExistingJavaTypes() {
    return (existingJavaTypes == null || existingJavaTypes.isEmpty())
        ? DEFAULT_EXISTING_JAVA_TYPES_OVERRIDES
        : existingJavaTypes;
  }
}
