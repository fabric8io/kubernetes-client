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

import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionBuilder;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class EnsureSingleStorageVersionDecorator extends
  CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {

  private final AtomicReference<String> storageVersion = new AtomicReference<>();

  public EnsureSingleStorageVersionDecorator(String name) {
    super(name);
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
    Predicate<CustomResourceDefinitionVersionBuilder> hasStorageVersion = v -> v.getStorage() != null && v.getStorage();

    if (spec.hasVersions() && !spec.hasMatchingVersion(hasStorageVersion)) {
      spec.editFirstVersion().withStorage(true).endVersion();
    }

    for (CustomResourceDefinitionVersion version : spec.buildVersions()) {
      if (version.getStorage() != null && version.getStorage()) {
        String existing = storageVersion.get();
        if (existing != null && !existing.equals(version.getName())) {
          throw new IllegalStateException(String.format(
            "'%s' custom resource has versions %s and %s marked as storage. Only one version can be marked as storage per custom resource.",
            resourceMeta.getName(), version.getName(), existing));
        } else {
          storageVersion.set(version.getName());
        }
      }
    }
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[]{AddCustomResourceDefinitionResourceDecorator.class,
      AddCustomResourceDefinitionVersionDecorator.class, SetStorageVersionDecorator.class};
  }

	@Override
	public String toString() {
		return getClass().getName() + " [name:"+ getName() +"]";
	}
}
