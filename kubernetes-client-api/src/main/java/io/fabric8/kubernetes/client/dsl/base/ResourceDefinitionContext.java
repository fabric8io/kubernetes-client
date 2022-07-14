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

import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.Optional;

public class ResourceDefinitionContext {
  protected String group;
  protected boolean namespaced;
  protected String plural;
  protected String version;
  protected String kind;

  public String getGroup() {
    return group;
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

  public boolean isNamespaceScoped() {
    return namespaced;
  }

  protected void validate() {
    if (plural == null) {
      if (kind == null) {
        throw new IllegalArgumentException("Neither kind nor plural was set, at least one is required");
      }
      plural = Utils.getPluralFromKind(kind);
    }
  }

  public static ResourceDefinitionContext fromResourceType(Class<? extends KubernetesResource> resource) {
    try {
      return new Builder()
          .withGroup(HasMetadata.getGroup(resource))
          .withVersion(HasMetadata.getVersion(resource))
          .withNamespaced(Utils.isResourceNamespaced(resource))
          .withPlural(HasMetadata.getPlural(resource))
          .withKind(HasMetadata.getKind(resource))
          .build();
    } catch (IllegalArgumentException e) {
      throw new KubernetesClientException(
          String.format("%s is not annotated appropriately: %s", resource.getName(), e.getMessage()), e);
    }
  }

  public static ResourceDefinitionContext fromApiResource(String apiVersion, APIResource resource) {
    return new Builder()
        .withGroup(Optional.ofNullable(ApiVersionUtil.trimGroupOrNull(apiVersion)).orElse(""))
        .withVersion(ApiVersionUtil.trimVersion(apiVersion))
        .withNamespaced(Boolean.TRUE.equals(resource.getNamespaced()))
        .withPlural(resource.getName())
        .withKind(resource.getKind())
        .build();
  }

  public static class Builder {
    private final ResourceDefinitionContext resourceDefinitionContext;

    public Builder() {
      this.resourceDefinitionContext = new ResourceDefinitionContext();
    }

    public Builder withGroup(String group) {
      this.resourceDefinitionContext.group = group;
      return this;
    }

    public Builder withNamespaced(boolean namespaced) {
      this.resourceDefinitionContext.namespaced = namespaced;
      return this;
    }

    public Builder withPlural(String plural) {
      this.resourceDefinitionContext.plural = plural;
      return this;
    }

    public Builder withVersion(String version) {
      this.resourceDefinitionContext.version = version;
      return this;
    }

    public Builder withKind(String kind) {
      this.resourceDefinitionContext.kind = kind;
      return this;
    }

    public ResourceDefinitionContext build() {
      this.resourceDefinitionContext.validate();
      return this.resourceDefinitionContext;
    }
  }

}
