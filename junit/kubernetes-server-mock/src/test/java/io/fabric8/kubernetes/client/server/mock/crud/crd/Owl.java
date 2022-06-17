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
package io.fabric8.kubernetes.client.server.mock.crud.crd;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("owls.example.com")
@Version("v1")
@Singular("owl")
public class Owl extends CustomResource<Owl.Spec, Owl.Status> {

  @Override
  protected Spec initSpec() {
    return new Spec();
  }

  @Override
  protected Status initStatus() {
    return new Status();
  }

  public static final class Spec {
    private String species;

    public String getSpecies() {
      return species;
    }

    public void setSpecies(String species) {
      this.species = species;
    }
  }

  public static final class Status {
    private boolean flying;
    private String notes;

    public boolean isFlying() {
      return flying;
    }

    public void setFlying(boolean flying) {
      this.flying = flying;
    }

    public String getNotes() {
      return notes;
    }

    public void setNotes(String notes) {
      this.notes = notes;
    }
  }

  public static CustomResourceDefinition toCrd() {
    return CustomResourceDefinitionContext.v1CRDFromCustomResourceType(Owl.class)
        .editSpec()
        .editVersion(0)
        .withNewSchema()
        .withNewOpenAPIV3Schema()
        .withTitle("Owl")
        .withType("object")
        .addToRequired("spec")
        .addToProperties("spec", new JSONSchemaPropsBuilder()
            .withType("object")
            .addToProperties("species", new JSONSchemaPropsBuilder().withType("string").build())
            .build())
        .addToProperties("status", new JSONSchemaPropsBuilder()
            .withType("object")
            .addToProperties("flying", new JSONSchemaPropsBuilder().withType("boolean").build())
            .addToProperties("notes", new JSONSchemaPropsBuilder().withType("string").build())
            .build())
        .endOpenAPIV3Schema()
        .endSchema()
        .withNewSubresources()
        .withNewStatus().endStatus()
        .endSubresources()
        .endVersion()
        .endSpec()
        .build();
  }
}
