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
package io.fabric8.crd.example.complex.k8s;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.model.KubernetesResource;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Simplified version of the K8s StatefulSetSpec.
 *
 * The purpose of this class is to create a complex, but stable CRD, that doesn't change when the generated StatefulSetSpec
 * class is changed.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "minReadySeconds",
    "podManagementPolicy",
    "replicas",
    "revisionHistoryLimit",
    "serviceName"
})
public class StatefulSetSpec implements KubernetesResource {
  @JsonProperty("minReadySeconds")
  private Integer minReadySeconds;
  @JsonProperty("podManagementPolicy")
  private String podManagementPolicy;
  @JsonProperty("replicas")
  private Integer replicas;
  @JsonProperty("revisionHistoryLimit")
  private Integer revisionHistoryLimit;
  @JsonProperty("serviceName")
  private String serviceName;
  @JsonIgnore
  private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

  /**
   * No args constructor for use in serialization
   *
   */
  public StatefulSetSpec() {
  }

  @JsonProperty("minReadySeconds")
  public Integer getMinReadySeconds() {
    return minReadySeconds;
  }

  @JsonProperty("minReadySeconds")
  public void setMinReadySeconds(Integer minReadySeconds) {
    this.minReadySeconds = minReadySeconds;
  }

  @JsonProperty("podManagementPolicy")
  public String getPodManagementPolicy() {
    return podManagementPolicy;
  }

  @JsonProperty("podManagementPolicy")
  public void setPodManagementPolicy(String podManagementPolicy) {
    this.podManagementPolicy = podManagementPolicy;
  }

  @JsonProperty("replicas")
  public Integer getReplicas() {
    return replicas;
  }

  @JsonProperty("replicas")
  public void setReplicas(Integer replicas) {
    this.replicas = replicas;
  }

  @JsonProperty("revisionHistoryLimit")
  public Integer getRevisionHistoryLimit() {
    return revisionHistoryLimit;
  }

  @JsonProperty("revisionHistoryLimit")
  public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
    this.revisionHistoryLimit = revisionHistoryLimit;
  }

  @JsonProperty("serviceName")
  public String getServiceName() {
    return serviceName;
  }

  @JsonProperty("serviceName")
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
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
