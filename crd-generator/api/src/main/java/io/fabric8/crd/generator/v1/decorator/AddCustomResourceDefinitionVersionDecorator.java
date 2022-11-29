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
package io.fabric8.crd.generator.v1.decorator;

import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;

import java.util.function.Predicate;

public class AddCustomResourceDefinitionVersionDecorator extends
    CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {

  private final String version;

  public AddCustomResourceDefinitionVersionDecorator(String name, String version) {
    super(name);
    this.version = version;
  }

  public String getName() {
    return this.name;
  }

  public String getVersion() {
    return this.version;
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
    Predicate<CustomResourceDefinitionVersionBuilder> predicate = candidate -> candidate.getName()
        .equals(version);

    spec.removeMatchingFromVersions(predicate);
    spec.addNewVersion()
        .withName(version)
        .endVersion();
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[] { AddCustomResourceDefinitionResourceDecorator.class };
  }

  @Override
  public String toString() {
    return getClass().getName() + " [name:" + getName() + ", version:" + version + "]";
  }
}
