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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.KubernetesVersionPriority;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.Scope;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomResourceDefinitionContext extends ResourceDefinitionContext {
  private String name;
  private String scope;
  private boolean statusSubresource;

  public String getName() {
    return name;
  }

  public String getScope() {
    return scope;
  }

  public boolean isStatusSubresource() {
    return statusSubresource;
  }

  @Override
  public boolean isNamespaceScoped() {
    if (scope != null) {
      return Scope.NAMESPACED.value().equals(scope);
    }
    return false;
  }

  @SuppressWarnings("rawtypes")
  public static CustomResourceDefinitionBuilder v1beta1CRDFromCustomResourceType(
      Class<? extends CustomResource> customResource) {
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
      Class<? extends CustomResource> customResource) {
    try {
      final CustomResource instance = customResource.getDeclaredConstructor().newInstance();
      return new io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder()
          .withNewMetadata()
          .withName(instance.getCRDName())
          .endMetadata()
          .withNewSpec()
          .withGroup(instance.getGroup())
          .addNewVersion().withName(instance.getVersion()).withServed(instance.isServed()).withStorage(
              instance.isStorage())
          .endVersion()
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

  public static CustomResourceDefinitionContext fromResourceType(Class<? extends HasMetadata> customResource, String crdName) {
    return new Builder()
        .withGroup(HasMetadata.getGroup(customResource))
        .withVersion(HasMetadata.getVersion(customResource))
        .withScope(Utils.isResourceNamespaced(customResource) ? Scope.NAMESPACED.value() : Scope.CLUSTER.value())
        .withName(crdName)
        .withPlural(HasMetadata.getPlural(customResource))
        .withKind(HasMetadata.getKind(customResource))
        .build();
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
        .withStatusSubresource(spec.getSubresources() != null && spec.getSubresources().getStatus() != null)
        .build();
  }

  public static CustomResourceDefinitionContext fromCrd(
      io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition crd) {
    String version = getVersion(crd.getSpec());
    return new CustomResourceDefinitionContext.Builder()
        .withGroup(crd.getSpec().getGroup())
        .withVersion(version)
        .withScope(crd.getSpec().getScope())
        .withName(crd.getMetadata().getName())
        .withPlural(crd.getSpec().getNames().getPlural())
        .withKind(crd.getSpec().getNames().getKind())
        .withStatusSubresource(crd.getSpec()
            .getVersions()
            .stream()
            .filter(v -> version.equals(v.getName()))
            .anyMatch(v -> v.getSubresources() != null && v.getSubresources().getStatus() != null))
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
        spec.getVersion());
  }

  private static String getVersion(
      io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec spec) {
    return getVersion(
        spec.getVersions().stream()
            .map(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion::getName)
            .collect(Collectors.toList()),
        null);
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

    public Builder withStatusSubresource(boolean statusSubresource) {
      this.customResourceDefinitionContext.statusSubresource = statusSubresource;
      return this;
    }

    public CustomResourceDefinitionContext build() {
      this.customResourceDefinitionContext.validate();
      return this.customResourceDefinitionContext;
    }
  }

}
