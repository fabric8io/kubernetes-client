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
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceSubresourcesFluent;

public class AddSpecReplicasPathDecorator extends CustomResourceDefinitionVersionDecorator<CustomResourceSubresourcesFluent<?>> {

  private final String path;
 
	public AddSpecReplicasPathDecorator(String name, String version, String path) {
		super(name, version);
		this.path = path;
	}
 
	@Override
	public void andThenVisit(CustomResourceSubresourcesFluent<?> subresources) {
    if (subresources.hasScale())  {
      subresources.editScale().withSpecReplicasPath(path).endScale();
    } else {
      subresources.withNewScale().withSpecReplicasPath(path).endScale();
    }
	}
	@Override
	public Class<? extends Decorator>[] after() {
    return new Class[]{AddCustomResourceDefinitionVersionDecorator.class,
      AddSubresourcesDecorator.class};
  }
}
