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

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.sundr.builder.annotations.Buildable;
import lombok.ToString;

import static io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty;

/**
 * A base class for implementing a custom resource kind
 */
@JsonDeserialize(
  using = JsonDeserializer.None.class
)
@JsonPropertyOrder({
  "apiVersion",
  "kind",
  "metadata",
  "spec",
  "status"
})
@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
public abstract class CustomResource<Spec extends KubernetesResource, Status extends KubernetesResource> implements HasMetadata {
  public static final String NAMESPACE_SCOPE = "Namespaced";
  public static final String CLUSTER_SCOPE = "Cluster";
  private ObjectMeta metadata = new ObjectMeta();

  @JsonProperty("spec")
  private Spec spec;
  
  @JsonProperty("status")
  private Status status;
  
  @JsonIgnore
  private String plural;
  
  @JsonIgnore
  private String crdName;
  
  private final String kind;
  private final String apiVersion;
  private final String scope;
  
  public CustomResource() {
    final String apiVersion = HasMetadata.super.getApiVersion();
    if (isNullOrEmpty(apiVersion)) {
      throw new IllegalArgumentException(getClass().getName() + " CustomResource must provide an API version using @ApiGroup and @ApiVersion annotations");
    }
    this.apiVersion = apiVersion;
    this.kind = HasMetadata.super.getKind();
    scope = this instanceof Namespaced ? NAMESPACE_SCOPE : CLUSTER_SCOPE;
  }
  
  @Override
  public String toString() {
    return "CustomResource{" +
      "kind='" + getKind() + '\'' +
      ", apiVersion='" + getApiVersion() + '\'' +
      ", metadata=" + metadata +
      ", spec=" + spec +
      ", status=" + status +
      '}';
  }
  
  @Override
  public String getApiVersion() {
    return apiVersion;
  }
  
  @Override
  public void setApiVersion(String version) {
    // already set in constructor
  }
  
  @Override
  public String getKind() {
    return this.kind;
  }
  
  public void setKind(String kind) {
    // already set in constructor
  }
  
  @Override
  public ObjectMeta getMetadata() {
    return metadata;
  }
  
  @Override
  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }
  
  @JsonIgnore
  public String getPlural() {
    if(plural == null) {
      final Plural plural = getClass().getAnnotation(Plural.class);
      this.plural = (plural != null ? plural.value().toLowerCase(Locale.ROOT) : Pluralize.toPlural(getKind())).toLowerCase(Locale.ROOT);
    }
    return plural;
  }
  
  @JsonIgnore
  public String getCRDName() {
    if(crdName == null) {
      this.crdName = getPlural() + "." + ApiVersionUtil.apiGroup(this, null);
    }
    return crdName;
  }
  
  @JsonIgnore
  public String getScope() {
    return scope;
  }
  
  @JsonIgnore
  public String getGroup() {
    return ApiVersionUtil.trimGroup(getApiVersion());
  }
  
  @JsonIgnore
  public String getVersion() {
    return ApiVersionUtil.trimVersion(getApiVersion());
  }
  
  public Spec getSpec() {
    return spec;
  }
  
  public void setSpec(Spec spec) {
    this.spec = spec;
  }
  
  public Status getStatus() {
    return status;
  }
  
  public void setStatus(Status status) {
    this.status = status;
  }
}
