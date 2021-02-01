/**
 * Copyright 2018 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.dekorate.crd.decorator;

import io.dekorate.kubernetes.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionFluentImpl;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class EnsureSingleStorageVersionDecorator extends CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {

  private final AtomicReference<String> storageVersion = new AtomicReference<>();

	public EnsureSingleStorageVersionDecorator(String name) {
		super(name);
	}

	@Override
	public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
    Predicate<CustomResourceDefinitionVersionBuilder> hasStorageVersion = CustomResourceDefinitionVersionFluentImpl::isStorage;

    if (spec.hasVersions() && !spec.hasMatchingVersion(hasStorageVersion)) {
      spec.editFirstVersion().withStorage(true).endVersion();
    }
                                                                             
    for (CustomResourceDefinitionVersion version : spec.buildVersions()) {
      if (version.getStorage()) {
        String existing = storageVersion.get();
        if (existing != null && !existing.equals(version.getName())) {
          throw new IllegalStateException(String.format("Version %s is marked as storage and so is %s. Only one version should be marked as storage per custom resource.", version.getName(), existing));
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
}
