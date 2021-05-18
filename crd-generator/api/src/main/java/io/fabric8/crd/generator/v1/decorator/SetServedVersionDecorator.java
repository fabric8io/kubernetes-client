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

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionFluent;

public class SetServedVersionDecorator extends CustomResourceDefinitionVersionDecorator<CustomResourceDefinitionVersionFluent<?>> {

  private final boolean served;

	public SetServedVersionDecorator(String name, String version, boolean served) {
		super(name, version);
		this.served = served;
	}

	@Override
	public void andThenVisit(CustomResourceDefinitionVersionFluent<?> version) {
    version.withServed(served);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [name:"+ getName() + ", version:"+ getVersion() + ", served:" + served + "]";
	}
}
