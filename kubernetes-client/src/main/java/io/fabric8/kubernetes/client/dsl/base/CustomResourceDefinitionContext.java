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

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;

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

  public static CustomResourceDefinitionContext fromCrd(CustomResourceDefinition crd) {
    return new CustomResourceDefinitionContext.Builder()
      .withGroup(crd.getSpec().getGroup())
      .withVersion(crd.getSpec().getVersion())
      .withScope(crd.getSpec().getScope())
      .withName(crd.getMetadata().getName())
      .withPlural(crd.getSpec().getNames().getPlural())
      .withKind(crd.getSpec().getNames().getKind())
      .build();
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
