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
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.client.utils.Utils;
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
@ToString
@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false)
public abstract class CustomResource implements HasMetadata {
  public static final String NAMESPACE_SCOPE = "Namespaced";
  public static final String CLUSTER_SCOPE = "Cluster";
  private ObjectMeta metadata = new ObjectMeta();
  
  @JsonIgnore
  private String plural;
  
  @JsonIgnore
  private String crdName;
  
  private String kind;
  private String apiVersion;
  private final String scope;
  
  public CustomResource() {
    this.apiVersion = HasMetadata.super.getApiVersion();
    this.kind = HasMetadata.super.getKind();
    scope = this instanceof Namespaced ? NAMESPACE_SCOPE : CLUSTER_SCOPE;
  }
  
  @Override
  public String toString() {
    return "CustomResource{" +
      "kind='" + getKind() + '\'' +
      ", apiVersion='" + getApiVersion() + '\'' +
      ", metadata=" + metadata +
      '}';
  }
  
  @Override
  public String getApiVersion() {
    return apiVersion;
  }
  
  @Override
  public void setApiVersion(String version) {
    if(Utils.isNotNullOrEmpty(this.apiVersion)) {
      throw new IllegalStateException("API version has already been set");
    }
    this.apiVersion = version;
  }
  
  @Override
  public String getKind() {
    return this.kind;
  }
  
  public void setKind(String kind) {
    if (Utils.isNotNullOrEmpty(this.kind)) {
      throw new IllegalStateException("Kind has already been set");
    }
    this.kind = kind;
  }
  
  @Override
  public ObjectMeta getMetadata() {
    return metadata;
  }
  
  @Override
  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }
  
  public String getPlural() {
    if(plural == null) {
      final Plural plural = getClass().getAnnotation(Plural.class);
      this.plural = (plural != null ? plural.value().toLowerCase(Locale.ROOT) : Pluralize.toPlural(getKind())).toLowerCase(Locale.ROOT);
    }
    return plural;
  }
  
  public String getCRDName() {
    if(crdName == null) {
      this.crdName = getPlural() + "." + ApiVersionUtil.apiGroup(this, null);
    }
    return crdName;
  }
  
  public String getScope() {
    return scope;
  }
  
  public String getGroup() {
    return ApiVersionUtil.trimGroup(getApiVersion());
  }
  
  public String getVersion() {
    return ApiVersionUtil.trimVersion(getApiVersion());
  }
}
