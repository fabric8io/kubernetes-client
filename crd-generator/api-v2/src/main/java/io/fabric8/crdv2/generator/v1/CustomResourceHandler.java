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
package io.fabric8.crdv2.generator.v1;

import io.fabric8.crdv2.generator.AbstractCustomResourceHandler;
import io.fabric8.crdv2.generator.CRDUtils;
import io.fabric8.crdv2.generator.CustomResourceInfo;
import io.fabric8.crdv2.generator.ResolvingContext;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.KubernetesVersionPriority;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.annotation.LabelSelector;
import io.fabric8.kubernetes.model.annotation.SpecReplicas;
import io.fabric8.kubernetes.model.annotation.StatusReplicas;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomResourceHandler extends AbstractCustomResourceHandler {

  private Queue<Map.Entry<CustomResourceDefinition, Set<String>>> crds = new ConcurrentLinkedQueue<>();

  public static final String VERSION = "v1";

  @Override
  public void handle(CustomResourceInfo config, ResolvingContext resolvingContext) {
    final String name = config.crdName();
    final String version = config.version();

    JsonSchema resolver = new JsonSchema(resolvingContext, config.definition());
    JSONSchemaProps schema = resolver.getSchema();

    CustomResourceDefinitionVersionBuilder builder = new CustomResourceDefinitionVersionBuilder()
        .withName(version)
        .withStorage(config.storage())
        .withServed(config.served())
        .withDeprecated(config.deprecated() ? true : null)
        .withDeprecationWarning(config.deprecationWarning())
        .withNewSchema()
        .withOpenAPIV3Schema(schema)
        .endSchema();

    handlePrinterColumns(resolver, new PrinterColumnHandler() {
      @Override
      public void addPrinterColumn(String path, String column, String format, int priority, String type, String description) {
        if (Utils.isNullOrEmpty(column)) {
          column = path.substring(path.lastIndexOf(".") + 1).toUpperCase();
        }
        description = Utils.isNotNullOrEmpty(description) ? description : null;

        builder.addNewAdditionalPrinterColumn()
            .withType(type)
            .withName(column)
            .withJsonPath(path)
            .withFormat(Utils.isNotNullOrEmpty(format) ? format : null)
            .withDescription(Utils.isNotNullOrEmpty(description) ? description : null)
            .withPriority(priority)
            .endAdditionalPrinterColumn();
      }
    });

    handleSelectableField(resolver, jsonPath -> builder.addNewSelectableField()
        .withJsonPath(jsonPath)
        .endSelectableField());

    resolver.getSinglePath(SpecReplicas.class).ifPresent(path -> {
      builder.editOrNewSubresources().editOrNewScale().withSpecReplicasPath(path).endScale().endSubresources();
    });

    resolver.getSinglePath(StatusReplicas.class).ifPresent(path -> {
      builder.editOrNewSubresources().editOrNewScale().withStatusReplicasPath(path).endScale().endSubresources();
    });

    resolver.getSinglePath(LabelSelector.class).ifPresent(path -> {
      builder.editOrNewSubresources().editOrNewScale().withLabelSelectorPath(path).endScale().endSubresources();
    });

    if (config.statusClassName().isPresent()) {
      builder.editOrNewSubresources().withNewStatus().endStatus().endSubresources();
    }

    CustomResourceDefinition crd = new CustomResourceDefinitionBuilder()
        .withNewMetadata()
        .withName(name)
        .withAnnotations(CRDUtils.toMap(config.annotations()))
        .withLabels(CRDUtils.toMap(config.labels()))
        .endMetadata()
        .withNewSpec()
        .withScope(config.scope().value())
        .withGroup(config.group())
        .withNewNames()
        .withKind(config.kind())
        .withShortNames(config.shortNames())
        .withPlural(config.plural())
        .withSingular(config.singular())
        .endNames()
        .addToVersions(builder.build())
        .endSpec()
        .build();

    crds.add(new AbstractMap.SimpleEntry<>(crd, resolver.getDependentClasses()));
  }

  @Override
  public Stream<Entry<? extends HasMetadata, Set<String>>> finish() {
    return crds.stream().collect(Collectors.groupingBy(crd -> crd.getKey().getMetadata().getName())).values().stream()
        .map(this::combine);
  }

  private Map.Entry<CustomResourceDefinition, Set<String>> combine(
      List<Map.Entry<CustomResourceDefinition, Set<String>>> definitions) {
    Map.Entry<CustomResourceDefinition, Set<String>> primary = definitions.get(0);
    if (definitions.size() == 1) {
      return primary;
    }

    List<CustomResourceDefinitionVersion> versions = definitions.stream()
        .flatMap(crd -> crd.getKey().getSpec().getVersions().stream())
        .collect(Collectors.toList());

    Set<String> allDependentClasses = definitions.stream().flatMap(crd -> crd.getValue().stream()).collect(Collectors.toSet());

    List<String> storageVersions = versions.stream()
        .filter(v -> Optional.ofNullable(v.getStorage()).orElse(true))
        .map(CustomResourceDefinitionVersion::getName)
        .collect(Collectors.toList());

    if (storageVersions.size() > 1) {
      throw new IllegalStateException(String.format(
          "'%s' custom resource has versions %s marked as storage. Only one version can be marked as storage per custom resource.",
          primary.getKey().getMetadata().getName(), storageVersions));
    }

    versions = KubernetesVersionPriority.sortByPriority(versions, CustomResourceDefinitionVersion::getName);

    //TODO: we could double check that the top-level metadata is consistent across all versions
    return new AbstractMap.SimpleEntry<>(
        new CustomResourceDefinitionBuilder(primary.getKey()).editSpec().withVersions(versions).endSpec().build(),
        allDependentClasses);
  }

}
