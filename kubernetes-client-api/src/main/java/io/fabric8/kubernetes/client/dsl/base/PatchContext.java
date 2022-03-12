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

import java.util.List;

public class PatchContext {
  // TODO this state overlaps with PatchOptions
  private List<String> dryRun;
  private String fieldManager;
  private Boolean force;
  private PatchType patchType;
  private String fieldValidation;

  public static PatchContext of(PatchType type) {
    return new PatchContext.Builder().withPatchType(type).build();
  }

  public List<String> getDryRun() {
    return dryRun;
  }

  public void setDryRun(List<String> dryRun) {
    this.dryRun = dryRun;
  }

  public String getFieldManager() {
    return fieldManager;
  }

  public void setFieldManager(String fieldManager) {
    this.fieldManager = fieldManager;
  }

  public Boolean getForce() {
    return force;
  }

  public void setForce(Boolean force) {
    this.force = force;
  }

  public PatchType getPatchType() {
    return patchType;
  }

  public void setPatchType(PatchType patchType) {
    this.patchType = patchType;
  }

  public String getFieldValidation() {
    return fieldValidation;
  }

  public void setFieldValidation(String fieldValidation) {
    this.fieldValidation = fieldValidation;
  }

  public static class Builder {
    private final PatchContext patchContext;

    public Builder() {
      this.patchContext = new PatchContext();
    }

    public Builder withDryRun(List<String> dryRun) {
      this.patchContext.setDryRun(dryRun);
      return this;
    }

    public Builder withFieldManager(String fieldManager) {
      this.patchContext.setFieldManager(fieldManager);
      return this;
    }

    public Builder withForce(Boolean force) {
      this.patchContext.setForce(force);
      return this;
    }

    public Builder withPatchType(PatchType patchType) {
      this.patchContext.setPatchType(patchType);
      return this;
    }

    public Builder withFieldValidation(String fieldValidation) {
      this.patchContext.setFieldValidation(fieldValidation);
      return this;
    }

    public PatchContext build() {
      return this.patchContext;
    }
  }
}
