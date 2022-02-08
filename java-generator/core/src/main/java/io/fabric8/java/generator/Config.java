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

public class Config {
    public enum CodeStructure {
        FLAT,
        PACKAGE_NESTED,
    }

    public enum Prefix {
        TOP_LEVEL,
        ALWAYS,
        NEVER,
    }

    public enum Suffix {
        TOP_LEVEL,
        ALWAYS,
        NEVER,
    }

    private static final boolean DEFAULT_UPPERCASE_ENUM = true;
    private static final Prefix DEFAULT_PREFIX_STRATEGY = Prefix.TOP_LEVEL;
    private static final Suffix DEFAULT_SUFFIX_STRATEGY = Suffix.TOP_LEVEL;
    private static final boolean DEFAULT_ALWAYS_PRESERVE_FIELDS = false;
    private static final boolean DEFAULT_ADD_EXTRA_ANNOTATIONS = false;
    private static final CodeStructure DEFAULT_CODE_STRUCTURE = CodeStructure.PACKAGE_NESTED;

    private Boolean uppercaseEnums = DEFAULT_UPPERCASE_ENUM;
    private Prefix prefixStrategy = DEFAULT_PREFIX_STRATEGY;
    private Suffix suffixStrategy = DEFAULT_SUFFIX_STRATEGY;
    private Boolean alwaysPreserveUnknownFields = DEFAULT_ALWAYS_PRESERVE_FIELDS;
    private Boolean objectExtraAnnotations = DEFAULT_ADD_EXTRA_ANNOTATIONS;
    private CodeStructure structure = DEFAULT_CODE_STRUCTURE;

    public Config() {}

    public Config(
            Boolean uppercaseEnums,
            Prefix prefixStrategy,
            Suffix suffixStrategy,
            Boolean alwaysPreserveUnknownFields,
            Boolean objectExtraAnnotations,
            CodeStructure structure) {
        if (uppercaseEnums != null) {
            this.uppercaseEnums = uppercaseEnums;
        }
        if (prefixStrategy != null) {
            this.prefixStrategy = prefixStrategy;
        }
        if (suffixStrategy != null) {
            this.suffixStrategy = suffixStrategy;
        }
        if (alwaysPreserveUnknownFields != null) {
            this.alwaysPreserveUnknownFields = alwaysPreserveUnknownFields;
        }
        if (objectExtraAnnotations != null) {
            this.objectExtraAnnotations = objectExtraAnnotations;
        }
        if (structure != null) {
            this.structure = structure;
        }
    }

    public boolean isUppercaseEnums() {
        return (uppercaseEnums == null) ? DEFAULT_UPPERCASE_ENUM : uppercaseEnums;
    }

    public Prefix getPrefixStrategy() {
        return (prefixStrategy == null) ? DEFAULT_PREFIX_STRATEGY : prefixStrategy;
    }

    public Suffix getSuffixStrategy() {
        return (suffixStrategy == null) ? DEFAULT_SUFFIX_STRATEGY : suffixStrategy;
    }

    public boolean isAlwaysPreserveUnknownFields() {
        return (alwaysPreserveUnknownFields == null)
                ? DEFAULT_ALWAYS_PRESERVE_FIELDS
                : alwaysPreserveUnknownFields;
    }

    public boolean isObjectExtraAnnotations() {
        return (objectExtraAnnotations == null)
                ? DEFAULT_ADD_EXTRA_ANNOTATIONS
                : objectExtraAnnotations;
    }

    public CodeStructure getCodeStructure() {
        return (structure == null) ? DEFAULT_CODE_STRUCTURE : structure;
    }
}
