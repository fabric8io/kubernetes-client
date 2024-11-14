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
package io.fabric8.kubernetes.api.model.coordination.v1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "acquireTime",
    "holderIdentity",
    "leaseDurationSeconds",
    "leaseTransitions",
    "renewTime"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class LeaseSpec implements Editable<LeaseSpecBuilder>, KubernetesResource {

  @JsonProperty("acquireTime")
  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
  private ZonedDateTime acquireTime;
  @JsonProperty("holderIdentity")
  private String holderIdentity;
  @JsonProperty("leaseDurationSeconds")
  private Integer leaseDurationSeconds;
  @JsonProperty("leaseTransitions")
  private Integer leaseTransitions;
  @JsonProperty("renewTime")
  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
  private ZonedDateTime renewTime;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  public LeaseSpec() {
  }

  public LeaseSpec(ZonedDateTime acquireTime, String holderIdentity, Integer leaseDurationSeconds, Integer leaseTransitions,
      ZonedDateTime renewTime) {
    this.acquireTime = acquireTime;
    this.holderIdentity = holderIdentity;
    this.leaseDurationSeconds = leaseDurationSeconds;
    this.leaseTransitions = leaseTransitions;
    this.renewTime = renewTime;
  }

  @JsonProperty("acquireTime")
  public ZonedDateTime getAcquireTime() {
    return acquireTime;
  }

  @JsonProperty("acquireTime")
  public void setAcquireTime(ZonedDateTime acquireTime) {
    this.acquireTime = acquireTime;
  }

  @JsonProperty("holderIdentity")
  public String getHolderIdentity() {
    return holderIdentity;
  }

  @JsonProperty("holderIdentity")
  public void setHolderIdentity(String holderIdentity) {
    this.holderIdentity = holderIdentity;
  }

  @JsonProperty("leaseDurationSeconds")
  public Integer getLeaseDurationSeconds() {
    return leaseDurationSeconds;
  }

  @JsonProperty("leaseDurationSeconds")
  public void setLeaseDurationSeconds(Integer leaseDurationSeconds) {
    this.leaseDurationSeconds = leaseDurationSeconds;
  }

  @JsonProperty("leaseTransitions")
  public Integer getLeaseTransitions() {
    return leaseTransitions;
  }

  @JsonProperty("leaseTransitions")
  public void setLeaseTransitions(Integer leaseTransitions) {
    this.leaseTransitions = leaseTransitions;
  }

  @JsonProperty("renewTime")
  public ZonedDateTime getRenewTime() {
    return renewTime;
  }

  @JsonProperty("renewTime")
  public void setRenewTime(ZonedDateTime renewTime) {
    this.renewTime = renewTime;
  }

  @JsonIgnore
  public LeaseSpecBuilder edit() {
    return new LeaseSpecBuilder(this);
  }

  @JsonIgnore
  public LeaseSpecBuilder toBuilder() {
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

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}
