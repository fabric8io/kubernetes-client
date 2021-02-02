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
package io.fabric8.crd.generator.v1beta1.decorator;

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionFluent;

public class SetStorageVersionDecorator extends
  CustomResourceDefinitionVersionDecorator<CustomResourceDefinitionVersionFluent<?>> {

  private final boolean storage;

  public SetStorageVersionDecorator(String name, String version, boolean storage) {
    super(name, version);
    this.storage = storage;
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionVersionFluent<?> version) {
    version.withStorage(storage);
  }
}
