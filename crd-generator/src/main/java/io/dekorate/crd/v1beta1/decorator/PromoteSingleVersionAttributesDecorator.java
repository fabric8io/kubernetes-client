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

package io.dekorate.crd.v1beta1.decorator;

import io.dekorate.kubernetes.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceSubresources;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    } else {
      Set<CustomResourceSubresources> subresources = versions.stream().map(CustomResourceDefinitionVersion::getSubresources).collect(Collectors.toSet());
      Set<List<CustomResourceColumnDefinition>> additionalPrinterColumns = versions.stream().map(CustomResourceDefinitionVersion::getAdditionalPrinterColumns).collect(Collectors.toSet());
      Set<CustomResourceValidation> schemas = versions.stream().map(CustomResourceDefinitionVersion::getSchema).collect(Collectors.toSet());
      
      boolean hasIdenticalSubresources = subresources.size() == 1;
      boolean hasIdenticalAdditionalPrinterColumns = additionalPrinterColumns.size() == 1;
      boolean hasIdenticalSchemas = schemas.size() == 1;

      System.out
        .printf("Found %s subresources, %s column list sets, %s schemas ", subresources.size(),
          additionalPrinterColumns.size(), schemas.size());
      
      spec
        .withValidation(hasIdenticalSchemas ? schemas.iterator().next() : null)
        .withSubresources(hasIdenticalSubresources ? subresources.iterator().next() : null)
        .withAdditionalPrinterColumns(hasIdenticalAdditionalPrinterColumns ? additionalPrinterColumns.iterator().next() : null);

      spec.removeAllFromVersions(versions);
      List<CustomResourceDefinitionVersion> newVersions = new ArrayList<>();
      for (CustomResourceDefinitionVersion version : versions) {
        CustomResourceDefinitionVersion newVersion = new CustomResourceDefinitionVersionBuilder(version).build();
        if (hasIdenticalSchemas) {
          newVersion.setSchema(null);
        }
        if (hasIdenticalSubresources) {
          newVersion.setSubresources(null);
        }
        if (hasIdenticalAdditionalPrinterColumns) {
          newVersion.setAdditionalPrinterColumns(null);
        }
        newVersions.add(newVersion);
      }

      spec.withVersions(newVersions);
    }
	}

	@Override
	public Class<? extends Decorator>[] after() {
    return new Class[]{
      AddCustomResourceDefinitionResourceDecorator.class,
      AddCustomResourceDefinitionVersionDecorator.class,
      CustomResourceDefinitionVersionDecorator.class,
      AddSchemaToCustomResourceDefinitionVersionDecorator.class,
      AddSubresourcesDecorator.class, AddStatusSubresourceDecorator.class,
      AddStatusReplicasPathDecorator.class, AddSpecReplicasPathDecorator.class,
      AddLabelSelectorPathDecorator.class};
	}
}
