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
package io.fabric8.kubernetes.model.util;

import io.sundr.builder.annotations.Buildable;

/**
 * Only exists to trigger builder package generation.
 *
 * <p>
 * {@code generateBuilderPackage = true} is what makes sundrio emit the {@code io.fabric8.kubernetes.api.builder}
 * runtime (BaseFluent, Visitable, VisitableBuilder, ...) that every generated Builder imports. sundrio keeps a single
 * BuilderContext per javac run and throws {@code IllegalStateException: Cannot use different values for generate
 * builder package in a single project} if two {@code @Buildable} types in the same module disagree, so this trigger
 * cannot live alongside the model classes: every other {@code @Buildable} in the repository sets it to {@code false}.
 * Hence a module of its own, and hence a type that models nothing.
 *
 * <p>
 * This file lives in {@code src/generate/java}, a source root the {@code generate} profile adds and the default build
 * does not, so the class is compiled only while regenerating (see this module's pom). The runtime it produces is
 * committed under {@code src/generated-builders/java} and compiled as plain source the rest of the time (#5622).
 */
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, builderPackage = "io.fabric8.kubernetes.api.builder")
class Dummy {

}
