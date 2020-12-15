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
import io.fabric8.kubernetes.model.annotation.Singular;
import io.sundr.builder.annotations.Buildable;

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
public abstract class CustomResource<S extends KubernetesResource, T extends KubernetesResource> implements HasMetadata {
  public static final String NAMESPACE_SCOPE = "Namespaced";
  public static final String CLUSTER_SCOPE = "Cluster";
  private ObjectMeta metadata = new ObjectMeta();

  @JsonProperty("spec")
  private S spec;
  
  @JsonProperty("status")
  private T status;
  
  @JsonIgnore
  private String plural;
  
  @JsonIgnore
  private String singular;
  
  @JsonIgnore
  private String crdName;
  
  private final String kind;
  private final String apiVersion;
  private final String scope;
  
  public CustomResource() {
    final String version = HasMetadata.super.getApiVersion();
    if (isNullOrEmpty(version)) {
      throw new IllegalArgumentException(getClass().getName() + " CustomResource must provide an API version using @ApiGroup and @ApiVersion annotations");
    }
    this.apiVersion = version;
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
  
  
  public static String getPlural(Class<? extends CustomResource> clazz) {
    final Plural fromAnnotation = clazz.getAnnotation(Plural.class);
    return (fromAnnotation != null ? fromAnnotation.value().toLowerCase(Locale.ROOT) : Pluralize.toPlural(getSingular(clazz)));
  }
  
  @JsonIgnore
  public String getPlural() {
    if(plural == null) {
      final Plural fromAnnotation = getClass().getAnnotation(Plural.class);
      this.plural = (fromAnnotation != null ? fromAnnotation.value().toLowerCase(Locale.ROOT) : Pluralize.toPlural(getSingular()));
    }
    return plural;
  }
  
  public static String getSingular(Class<? extends CustomResource> clazz) {
    final Singular fromAnnotation = clazz.getAnnotation(Singular.class);
    return (fromAnnotation != null ? fromAnnotation.value().toLowerCase(Locale.ROOT) : HasMetadata.getKind(clazz)).toLowerCase(Locale.ROOT);
  }
  
  @JsonIgnore
  public String getSingular() {
    if(singular == null) {
      final Singular fromAnnotation = getClass().getAnnotation(Singular.class);
      this.singular = (fromAnnotation != null ? fromAnnotation.value().toLowerCase(Locale.ROOT) : getKind()).toLowerCase(Locale.ROOT);
    }
    return singular;
  }
  
  
  public static String getCRDName(Class<? extends CustomResource> clazz) {
    return getPlural(clazz) + "." + getGroup(clazz);
  }
  
  @JsonIgnore
  public String getCRDName() {
    if(crdName == null) {
      this.crdName = getCRDName(getClass());
    }
    return crdName;
  }
  
  @JsonIgnore
  public String getScope() {
    return scope;
  }
  
  public static String getGroup(Class<? extends CustomResource> clazz) {
    return ApiVersionUtil.trimGroup(HasMetadata.getApiVersion(clazz));
  }
  
  @JsonIgnore
  public String getGroup() {
    return getGroup(getClass());
  }
  
  public static String getVersion(Class<? extends CustomResource> clazz) {
    return ApiVersionUtil.trimVersion(HasMetadata.getApiVersion(clazz));
  }
  
  @JsonIgnore
  public String getVersion() {
    return getVersion(getClass());
  }
  
  public S getSpec() {
    return spec;
  }
  
  public void setSpec(S spec) {
    this.spec = spec;
  }
  
  public T getStatus() {
    return status;
  }
  
  public void setStatus(T status) {
    this.status = status;
  }
}
