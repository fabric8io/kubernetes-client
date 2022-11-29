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
package io.fabric8.kubernetes.api.model.coordination.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.model.annotation.Generated;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
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
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class LeaseSpec implements KubernetesResource {

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

  public ZonedDateTime getAcquireTime() {
    return acquireTime;
  }

  public void setAcquireTime(ZonedDateTime acquireTime) {
    this.acquireTime = acquireTime;
  }

  public String getHolderIdentity() {
    return holderIdentity;
  }

  public void setHolderIdentity(String holderIdentity) {
    this.holderIdentity = holderIdentity;
  }

  public Integer getLeaseDurationSeconds() {
    return leaseDurationSeconds;
  }

  public void setLeaseDurationSeconds(Integer leaseDurationSeconds) {
    this.leaseDurationSeconds = leaseDurationSeconds;
  }

  public Integer getLeaseTransitions() {
    return leaseTransitions;
  }

  public void setLeaseTransitions(Integer leaseTransitions) {
    this.leaseTransitions = leaseTransitions;
  }

  public ZonedDateTime getRenewTime() {
    return renewTime;
  }

  public void setRenewTime(ZonedDateTime renewTime) {
    this.renewTime = renewTime;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}
