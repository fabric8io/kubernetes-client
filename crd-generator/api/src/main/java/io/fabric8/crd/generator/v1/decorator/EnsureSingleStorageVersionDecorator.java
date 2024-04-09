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
package io.fabric8.crd.generator.v1.decorator;

import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EnsureSingleStorageVersionDecorator
    extends CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {

  public EnsureSingleStorageVersionDecorator(String name) {
    super(name);
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
    List<CustomResourceDefinitionVersion> versions = spec.buildVersions();

    List<String> storageVersions = versions.stream()
        .filter(v -> Optional.ofNullable(v.getStorage()).orElse(true))
        .map(CustomResourceDefinitionVersion::getName)
        .collect(Collectors.toList());

    if (storageVersions.size() > 1) {
      throw new IllegalStateException(String.format(
          "'%s' custom resource has versions %s marked as storage. Only one version can be marked as storage per custom resource.",
          resourceMeta.getName(), storageVersions));
    }
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[] {
        CustomResourceDefinitionVersionDecorator.class
    };
  }

  @Override
  public String toString() {
    return getClass().getName() + " [name:" + getName() + "]";
  }
}
