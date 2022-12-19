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
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceSubresourceScale;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceSubresourceStatus;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceSubresources;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceSubresourcesBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PromoteSingleVersionAttributesDecorator
    extends CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {

  public PromoteSingleVersionAttributesDecorator(String name) {
    super(name);
  }

  private CustomResourceSubresources mergeSubresources(CustomResourceSubresources versionSub,
      CustomResourceSubresources topLevelSub) {
    if (versionSub == null) {
      return topLevelSub;
    } else if (topLevelSub == null) {
      return versionSub;
    } else {
      // merge additional properties
      Map<String, Object> additionalProperties = new HashMap<>();
      if (versionSub.getAdditionalProperties() != null) {
        additionalProperties.putAll(versionSub.getAdditionalProperties());
      }
      if (topLevelSub.getAdditionalProperties() != null) {
        additionalProperties.putAll(topLevelSub.getAdditionalProperties());
      }

      // merge scale
      CustomResourceSubresourceScale scale = null;
      if (topLevelSub.getScale() != null) {
        scale = topLevelSub.getScale();
      } else if (versionSub.getScale() != null) {
        scale = versionSub.getScale();
      }

      // merge status
      CustomResourceSubresourceStatus status = null;
      if (topLevelSub.getStatus() != null) {
        status = topLevelSub.getStatus();
      } else if (versionSub.getStatus() != null) {
        status = versionSub.getStatus();
      }

      return new CustomResourceSubresourcesBuilder()
          .withAdditionalProperties(additionalProperties)
          .withScale(scale)
          .withStatus(status)
          .build();
    }
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
    List<CustomResourceDefinitionVersion> versions = spec.buildVersions();

    if (versions.size() == 1) {
      CustomResourceDefinitionVersion version = versions.get(0);
      spec.withSubresources(mergeSubresources(version.getSubresources(), spec.buildSubresources()))
          .withValidation(version.getSchema())
          .withAdditionalPrinterColumns(version.getAdditionalPrinterColumns());

      CustomResourceDefinitionVersion newVersion = new CustomResourceDefinitionVersionBuilder(version).build();
      newVersion.setSubresources(null);
      newVersion.setSchema(null);
      newVersion.setAdditionalPrinterColumns(null);

      spec.removeAllFromVersions(versions);
      spec.withVersions(newVersion);
    } else {
      Set<CustomResourceSubresources> subresources = versions.stream().map(CustomResourceDefinitionVersion::getSubresources)
          .filter(o -> o != null).collect(Collectors.toSet());
      Set<List<CustomResourceColumnDefinition>> additionalPrinterColumns = versions.stream()
          .map(CustomResourceDefinitionVersion::getAdditionalPrinterColumns).filter(o -> o != null).collect(Collectors.toSet());
      Set<CustomResourceValidation> schemas = versions.stream().map(CustomResourceDefinitionVersion::getSchema)
          .filter(o -> o != null).collect(Collectors.toSet());

      boolean hasIdenticalSubresources = subresources.size() == 1;
      boolean hasIdenticalAdditionalPrinterColumns = additionalPrinterColumns.size() == 1;
      boolean hasIdenticalSchemas = schemas.size() == 1;

      if (hasIdenticalSchemas) {
        spec.withValidation(schemas.iterator().next());
      }

      if (hasIdenticalSubresources) {
        spec.withSubresources(mergeSubresources(subresources.iterator().next(), spec.buildSubresources()));
      }

      if (hasIdenticalAdditionalPrinterColumns) {
        spec.withAdditionalPrinterColumns(additionalPrinterColumns.iterator().next());
      }

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
    return new Class[] {
        AddCustomResourceDefinitionResourceDecorator.class,
        AddCustomResourceDefinitionVersionDecorator.class,
        CustomResourceDefinitionVersionDecorator.class,
        AddSchemaToCustomResourceDefinitionVersionDecorator.class,
        AddSubresourcesDecorator.class, AddStatusSubresourceDecorator.class,
        AddStatusReplicasPathDecorator.class, AddSpecReplicasPathDecorator.class,
        AddLabelSelectorPathDecorator.class };
  }
}
