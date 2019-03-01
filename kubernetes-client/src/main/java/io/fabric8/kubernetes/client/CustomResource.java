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
package io.fabric8.kubernetes.client;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.sundr.builder.annotations.Buildable;

/**
 * A base class for implementing a custom resource kind
 */
@JsonDeserialize(
    using = JsonDeserializer.None.class
)
@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
public abstract class CustomResource implements HasMetadata {
  private String kind;
  private String apiVersion;
  private ObjectMeta metadata = new ObjectMeta();

  public CustomResource() {
    this.kind = getClass().getSimpleName();
  }

  public CustomResource(String kind) {
    this.kind = kind;
  }

  @Override
  public String toString() {
    return "CustomResourceSupport{" +
        "kind='" + kind + '\'' +
        ", apiVersion='" + apiVersion + '\'' +
        ", metadata=" + metadata +
        '}';
  }

  @Override
  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  @Override
  public ObjectMeta getMetadata() {
    return metadata;
  }

  @Override
  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }
}
