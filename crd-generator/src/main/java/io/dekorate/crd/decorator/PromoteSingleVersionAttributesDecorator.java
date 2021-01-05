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

import java.util.List;

import io.dekorate.kubernetes.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionVersionBuilder;

public class PromoteSingleVersionAttributesDecorator extends CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {

	public PromoteSingleVersionAttributesDecorator(String name) {
		super(name);
	}

	@Override
	public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
    List<CustomResourceDefinitionVersion> versions = spec.buildVersions();

    if (versions.size() == 1) {
      CustomResourceDefinitionVersion version = versions.get(0);
      spec.withSubresources(version.getSubresources())
          .withValidation(version.getSchema())
          .withAdditionalPrinterColumns(version.getAdditionalPrinterColumns());
        

      CustomResourceDefinitionVersion newVersion = new CustomResourceDefinitionVersionBuilder(version).build();
      newVersion.setSubresources(null);
      newVersion.setSchema(null);
      newVersion.setAdditionalPrinterColumns(null);

      spec.removeAllFromVersions(versions);
      spec.withVersions(newVersion);
    }
	}

	@Override
	public Class<? extends Decorator>[] after() {
    return new Class[] {
      AddCustomResourceDefinitionResourceDecorator.class,
      AddCustomResourceDefintionVersionDecorator.class,
      CustomResourceDefinitionVersionDecorator.class,
      AddSchemaToCustomResourceDefinitionVersionDecorator.class,
      AddSubresourcesDecorator.class, AddStatusSubresourceDecorator.class, AddStatusReplicasPathDecorator.class, AddSpecReplicasPathDecorator.class, AddLabelSelectorPathDecorator.class };
	}
}
