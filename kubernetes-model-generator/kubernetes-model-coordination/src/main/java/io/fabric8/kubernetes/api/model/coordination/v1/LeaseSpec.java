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

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "apiVersion", "kind", "metadata", "acquireTime", "holderIdentity", "leaseDurationSeconds",
    "leaseTransitions", "preferredHolder", "renewTime", "strategy" })
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class), @BuildableReference(LabelSelector.class), @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class), @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class), @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class), @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class), @BuildableReference(ContainerPort.class), @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class) })
public class LeaseSpec implements Editable<LeaseSpecBuilder>, KubernetesResource {
  @JsonProperty("acquireTime")
  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS\'Z\'")
  private ZonedDateTime acquireTime;
  @JsonProperty("holderIdentity")
  private String holderIdentity;
  @JsonProperty("leaseDurationSeconds")
  private Integer leaseDurationSeconds;
  @JsonProperty("leaseTransitions")
  private Integer leaseTransitions;
  @JsonProperty("preferredHolder")
  private String preferredHolder;
  @JsonProperty("renewTime")
  @JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS\'Z\'")
  private ZonedDateTime renewTime;
  @JsonProperty("strategy")
  private String strategy;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  public LeaseSpec() {
  }

  public LeaseSpec(ZonedDateTime acquireTime, String holderIdentity, Integer leaseDurationSeconds, Integer leaseTransitions,
      String preferredHolder, ZonedDateTime renewTime, String strategy) {
    this.acquireTime = acquireTime;
    this.holderIdentity = holderIdentity;
    this.leaseDurationSeconds = leaseDurationSeconds;
    this.leaseTransitions = leaseTransitions;
    this.preferredHolder = preferredHolder;
    this.renewTime = renewTime;
    this.strategy = strategy;
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

  @JsonProperty("preferredHolder")
  public String getPreferredHolder() {
    return preferredHolder;
  }

  @JsonProperty("preferredHolder")
  public void setPreferredHolder(String preferredHolder) {
    this.preferredHolder = preferredHolder;
  }

  @JsonProperty("renewTime")
  public ZonedDateTime getRenewTime() {
    return renewTime;
  }

  @JsonProperty("renewTime")
  public void setRenewTime(ZonedDateTime renewTime) {
    this.renewTime = renewTime;
  }

  @JsonProperty("strategy")
  public String getStrategy() {
    return strategy;
  }

  @JsonProperty("strategy")
  public void setStrategy(String strategy) {
    this.strategy = strategy;
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
  @JsonIgnore
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

  @java.lang.Override
  public java.lang.String toString() {
    return "LeaseSpec(acquireTime=" + this.getAcquireTime() + ", holderIdentity=" + this.getHolderIdentity()
        + ", leaseDurationSeconds=" + this.getLeaseDurationSeconds() + ", leaseTransitions=" + this.getLeaseTransitions()
        + ", preferredHolder=" + this.getPreferredHolder() + ", renewTime=" + this.getRenewTime() + ", strategy="
        + this.getStrategy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object o) {
    if (o == this)
      return true;
    if (!(o instanceof LeaseSpec))
      return false;
    final LeaseSpec other = (LeaseSpec) o;
    if (!other.canEqual((java.lang.Object) this))
      return false;
    final java.lang.Object this$leaseDurationSeconds = this.getLeaseDurationSeconds();
    final java.lang.Object other$leaseDurationSeconds = other.getLeaseDurationSeconds();
    if (this$leaseDurationSeconds == null ? other$leaseDurationSeconds != null
        : !this$leaseDurationSeconds.equals(other$leaseDurationSeconds))
      return false;
    final java.lang.Object this$leaseTransitions = this.getLeaseTransitions();
    final java.lang.Object other$leaseTransitions = other.getLeaseTransitions();
    if (this$leaseTransitions == null ? other$leaseTransitions != null : !this$leaseTransitions.equals(other$leaseTransitions))
      return false;
    final java.lang.Object this$acquireTime = this.getAcquireTime();
    final java.lang.Object other$acquireTime = other.getAcquireTime();
    if (this$acquireTime == null ? other$acquireTime != null : !this$acquireTime.equals(other$acquireTime))
      return false;
    final java.lang.Object this$holderIdentity = this.getHolderIdentity();
    final java.lang.Object other$holderIdentity = other.getHolderIdentity();
    if (this$holderIdentity == null ? other$holderIdentity != null : !this$holderIdentity.equals(other$holderIdentity))
      return false;
    final java.lang.Object this$preferredHolder = this.getPreferredHolder();
    final java.lang.Object other$preferredHolder = other.getPreferredHolder();
    if (this$preferredHolder == null ? other$preferredHolder != null : !this$preferredHolder.equals(other$preferredHolder))
      return false;
    final java.lang.Object this$renewTime = this.getRenewTime();
    final java.lang.Object other$renewTime = other.getRenewTime();
    if (this$renewTime == null ? other$renewTime != null : !this$renewTime.equals(other$renewTime))
      return false;
    final java.lang.Object this$strategy = this.getStrategy();
    final java.lang.Object other$strategy = other.getStrategy();
    if (this$strategy == null ? other$strategy != null : !this$strategy.equals(other$strategy))
      return false;
    final java.lang.Object this$additionalProperties = this.getAdditionalProperties();
    final java.lang.Object other$additionalProperties = other.getAdditionalProperties();
    if (this$additionalProperties == null ? other$additionalProperties != null
        : !this$additionalProperties.equals(other$additionalProperties))
      return false;
    return true;
  }

  protected boolean canEqual(final java.lang.Object other) {
    return other instanceof LeaseSpec;
  }

  @java.lang.Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final java.lang.Object $leaseDurationSeconds = this.getLeaseDurationSeconds();
    result = result * PRIME + ($leaseDurationSeconds == null ? 43 : $leaseDurationSeconds.hashCode());
    final java.lang.Object $leaseTransitions = this.getLeaseTransitions();
    result = result * PRIME + ($leaseTransitions == null ? 43 : $leaseTransitions.hashCode());
    final java.lang.Object $acquireTime = this.getAcquireTime();
    result = result * PRIME + ($acquireTime == null ? 43 : $acquireTime.hashCode());
    final java.lang.Object $holderIdentity = this.getHolderIdentity();
    result = result * PRIME + ($holderIdentity == null ? 43 : $holderIdentity.hashCode());
    final java.lang.Object $preferredHolder = this.getPreferredHolder();
    result = result * PRIME + ($preferredHolder == null ? 43 : $preferredHolder.hashCode());
    final java.lang.Object $renewTime = this.getRenewTime();
    result = result * PRIME + ($renewTime == null ? 43 : $renewTime.hashCode());
    final java.lang.Object $strategy = this.getStrategy();
    result = result * PRIME + ($strategy == null ? 43 : $strategy.hashCode());
    final java.lang.Object $additionalProperties = this.getAdditionalProperties();
    result = result * PRIME + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
    return result;
  }
}
