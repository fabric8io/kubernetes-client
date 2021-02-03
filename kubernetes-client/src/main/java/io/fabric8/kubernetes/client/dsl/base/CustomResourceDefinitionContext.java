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
package io.fabric8.kubernetes.client.dsl.base;

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.KubernetesVersionPriority;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomResourceDefinitionContext {
  private String name;
  private String group;
  private String scope;
  private String plural;
  private String version;
  private String kind;

  public String getName() { return name; }

  public String getGroup() {
    return group;
  }

  public String getScope() {
    return scope;
  }

  public String getPlural() {
    return plural;
  }

  public String getVersion() {
    return version;
  }

  public String getKind() {
    return kind;
  }

  @SuppressWarnings("rawtypes")
  public static CustomResourceDefinitionBuilder v1beta1CRDFromCustomResourceType(Class<? extends CustomResource> customResource) {
    try {
      final CustomResource instance = customResource.getDeclaredConstructor().newInstance();

      final String version = instance.getVersion();

      return new CustomResourceDefinitionBuilder()
        .withNewMetadata()
        .withName(instance.getCRDName())
        .endMetadata()
        .withNewSpec()
        .withGroup(instance.getGroup())
        .withVersion(version) // also set version to the first (and only) versions item
        .addNewVersion().withName(version).withServed(instance.isServed()).withStorage(instance.isStorage()).endVersion()
        .withScope(instance.getScope())
        .withNewNames()
        .withKind(instance.getKind())
        .withPlural(instance.getPlural())
        .withSingular(instance.getSingular())
        .endNames()
        .endSpec();
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @SuppressWarnings("rawtypes")
  public static io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder v1CRDFromCustomResourceType(
    Class<? extends CustomResource> customResource
  ) {
    try {
      final CustomResource instance = customResource.getDeclaredConstructor().newInstance();
      return new io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder()
        .withNewMetadata()
        .withName(instance.getCRDName())
        .endMetadata()
        .withNewSpec()
        .withGroup(instance.getGroup())
        .addNewVersion().withName(instance.getVersion()).withServed(true).withStorage(true).endVersion()
        .withScope(instance.getScope())
        .withNewNames()
        .withKind(instance.getKind())
        .withPlural(instance.getPlural())
        .withSingular(instance.getSingular())
        .endNames()
        .endSpec();
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @SuppressWarnings("rawtypes")
  public static CustomResourceDefinitionContext fromCustomResourceType(Class<? extends CustomResource> customResource) {
    try {
      final CustomResource instance = customResource.getDeclaredConstructor().newInstance();
      return new Builder()
        .withGroup(instance.getGroup())
        .withVersion(instance.getVersion())
        .withScope(instance.getScope())
        .withName(instance.getCRDName())
        .withPlural(instance.getPlural())
        .withKind(instance.getKind())
        .build();
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public static CustomResourceDefinitionContext fromCrd(CustomResourceDefinition crd) {
    final CustomResourceDefinitionSpec spec = crd.getSpec();
    return new CustomResourceDefinitionContext.Builder()
      .withGroup(spec.getGroup())
      .withVersion(getVersion(spec))
      .withScope(spec.getScope())
      .withName(crd.getMetadata().getName())
      .withPlural(spec.getNames().getPlural())
      .withKind(spec.getNames().getKind())
      .build();
  }

  public static CustomResourceDefinitionContext fromCrd(
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition crd
  ) {
    return new CustomResourceDefinitionContext.Builder()
      .withGroup(crd.getSpec().getGroup())
      .withVersion(getVersion(crd.getSpec()))
      .withScope(crd.getSpec().getScope())
      .withName(crd.getMetadata().getName())
      .withPlural(crd.getSpec().getNames().getPlural())
      .withKind(crd.getSpec().getNames().getKind())
      .build();
  }

  private static String getVersion(List<String> versions, String defaultVersion) {
    return Optional.ofNullable(versions)
      .map(KubernetesVersionPriority::highestPriority)
      .orElse(defaultVersion);
  }

  private static String getVersion(CustomResourceDefinitionSpec spec) {
    return getVersion(
      spec.getVersions().stream()
        .map(CustomResourceDefinitionVersion::getName)
        .collect(Collectors.toList()),
      spec.getVersion()
    );
  }

  private static String getVersion(
    io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec spec
  ) {
    return getVersion(
      spec.getVersions().stream()
        .map(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion::getName)
        .collect(Collectors.toList()),
      null
    );
  }

  public static class Builder {
    private final CustomResourceDefinitionContext customResourceDefinitionContext;

    public Builder() {
      this.customResourceDefinitionContext = new CustomResourceDefinitionContext();
    }

    public Builder withName(String name) {
      this.customResourceDefinitionContext.name = name;
      return this;
    }

    public Builder withGroup(String group) {
      this.customResourceDefinitionContext.group = group;
      return this;
    }

    public Builder withScope(String scope) {
      this.customResourceDefinitionContext.scope = scope;
      return this;
    }

    public Builder withPlural(String plural) {
      this.customResourceDefinitionContext.plural = plural;
      return this;
    }

    public Builder withVersion(String version) {
      this.customResourceDefinitionContext.version = version;
      return this;
    }

    public Builder withKind(String kind) {
      this.customResourceDefinitionContext.kind = kind;
      return this;
    }

    public CustomResourceDefinitionContext build() {
      return this.customResourceDefinitionContext;
    }
  }


}
