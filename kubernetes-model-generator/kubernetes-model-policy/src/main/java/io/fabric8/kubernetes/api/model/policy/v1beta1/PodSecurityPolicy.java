/*
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
package io.fabric8.kubernetes.api.model.policy.v1beta1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @deprecated PodSecurityPolicy was deprecated in Kubernetes 1.21 and removed in Kubernetes 1.25.
 *             Users are advised to not rely on this resource.
 *             For more information read this <a href=
 *             "https://kubernetes.io/blog/2021/04/06/podsecuritypolicy-deprecation-past-present-and-future/">blogpost</a>
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("policy")
@Deprecated
public class PodSecurityPolicy implements Editable<PodSecurityPolicyBuilder>, HasMetadata {

  /**
   * 
   * (Required)
   * 
   */
  @JsonProperty("apiVersion")
  private String apiVersion = "policy/v1beta1";
  /**
   * 
   * (Required)
   * 
   */
  @JsonProperty("kind")
  private String kind = "PodSecurityPolicy";
  @JsonProperty("metadata")
  private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
  @JsonProperty("spec")
  private PodSecurityPolicySpec spec;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  /**
   * No args constructor for use in serialization
   * 
   */
  public PodSecurityPolicy() {
  }

  public PodSecurityPolicy(String apiVersion, String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata,
      PodSecurityPolicySpec spec) {
    super();
    this.apiVersion = apiVersion;
    this.kind = kind;
    this.metadata = metadata;
    this.spec = spec;
  }

  /**
   * 
   * (Required)
   * 
   */
  @JsonProperty("apiVersion")
  public String getApiVersion() {
    return apiVersion;
  }

  /**
   * 
   * (Required)
   * 
   */
  @JsonProperty("apiVersion")
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  /**
   * 
   * (Required)
   * 
   */
  @JsonProperty("kind")
  public String getKind() {
    return kind;
  }

  /**
   * 
   * (Required)
   * 
   */
  @JsonProperty("kind")
  public void setKind(String kind) {
    this.kind = kind;
  }

  @JsonProperty("metadata")
  public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
    return metadata;
  }

  @JsonProperty("metadata")
  public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
    this.metadata = metadata;
  }

  @JsonProperty("spec")
  public PodSecurityPolicySpec getSpec() {
    return spec;
  }

  @JsonProperty("spec")
  public void setSpec(PodSecurityPolicySpec spec) {
    this.spec = spec;
  }

  @JsonIgnore
  public PodSecurityPolicyBuilder edit() {
    return new PodSecurityPolicyBuilder(this);
  }

  @JsonIgnore
  public PodSecurityPolicyBuilder toBuilder() {
    return edit();
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
