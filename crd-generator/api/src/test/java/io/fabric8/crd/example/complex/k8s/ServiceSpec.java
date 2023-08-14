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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Simplified version of the K8s ServiceSpec.
 *
 * The purpose of this class is to create a complex, but stable CRD, that doesn't change when the generated ServiceSpec class is
 * changed.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "allocateLoadBalancerNodePorts",
    "clusterIP",
    "clusterIPs",
    "externalIPs",
    "externalName",
    "externalTrafficPolicy",
    "healthCheckNodePort",
    "internalTrafficPolicy",
    "ipFamilies",
    "ipFamilyPolicy",
    "loadBalancerClass",
    "loadBalancerIP",
    "loadBalancerSourceRanges",
    "publishNotReadyAddresses",
    "selector",
    "sessionAffinityConfig",
    "type"
})
public class ServiceSpec implements KubernetesResource {

  @JsonProperty("allocateLoadBalancerNodePorts")
  private Boolean allocateLoadBalancerNodePorts;
  @JsonProperty("clusterIP")
  private String clusterIP;
  @JsonProperty("clusterIPs")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> clusterIPs = new ArrayList<>();
  @JsonProperty("externalIPs")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> externalIPs = new ArrayList<>();
  @JsonProperty("externalName")
  private String externalName;
  @JsonProperty("externalTrafficPolicy")
  private String externalTrafficPolicy;
  @JsonProperty("healthCheckNodePort")
  private Integer healthCheckNodePort;
  @JsonProperty("internalTrafficPolicy")
  private String internalTrafficPolicy;
  @JsonProperty("ipFamilies")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> ipFamilies = new ArrayList<>();
  @JsonProperty("ipFamilyPolicy")
  private String ipFamilyPolicy;
  @JsonProperty("loadBalancerClass")
  private String loadBalancerClass;
  @JsonProperty("loadBalancerIP")
  private String loadBalancerIP;
  @JsonProperty("loadBalancerSourceRanges")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> loadBalancerSourceRanges = new ArrayList<>();
  @JsonProperty("publishNotReadyAddresses")
  private Boolean publishNotReadyAddresses;
  @JsonProperty("selector")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Map<String, String> selector = new LinkedHashMap<>();
  @JsonProperty("sessionAffinity")
  private String sessionAffinity;
  @JsonProperty("type")
  private String type;
  @JsonIgnore
  private final Map<String, Object> additionalProperties = new LinkedHashMap<>();

  public ServiceSpec() {
  }

  @JsonProperty("allocateLoadBalancerNodePorts")
  public Boolean getAllocateLoadBalancerNodePorts() {
    return allocateLoadBalancerNodePorts;
  }

  @JsonProperty("allocateLoadBalancerNodePorts")
  public void setAllocateLoadBalancerNodePorts(Boolean allocateLoadBalancerNodePorts) {
    this.allocateLoadBalancerNodePorts = allocateLoadBalancerNodePorts;
  }

  @JsonProperty("clusterIP")
  public String getClusterIP() {
    return clusterIP;
  }

  @JsonProperty("clusterIP")
  public void setClusterIP(String clusterIP) {
    this.clusterIP = clusterIP;
  }

  @JsonProperty("clusterIPs")
  public List<String> getClusterIPs() {
    return clusterIPs;
  }

  @JsonProperty("clusterIPs")
  public void setClusterIPs(List<String> clusterIPs) {
    this.clusterIPs = clusterIPs;
  }

  @JsonProperty("externalIPs")
  public List<String> getExternalIPs() {
    return externalIPs;
  }

  @JsonProperty("externalIPs")
  public void setExternalIPs(List<String> externalIPs) {
    this.externalIPs = externalIPs;
  }

  @JsonProperty("externalName")
  public String getExternalName() {
    return externalName;
  }

  @JsonProperty("externalName")
  public void setExternalName(String externalName) {
    this.externalName = externalName;
  }

  @JsonProperty("externalTrafficPolicy")
  public String getExternalTrafficPolicy() {
    return externalTrafficPolicy;
  }

  @JsonProperty("externalTrafficPolicy")
  public void setExternalTrafficPolicy(String externalTrafficPolicy) {
    this.externalTrafficPolicy = externalTrafficPolicy;
  }

  @JsonProperty("healthCheckNodePort")
  public Integer getHealthCheckNodePort() {
    return healthCheckNodePort;
  }

  @JsonProperty("healthCheckNodePort")
  public void setHealthCheckNodePort(Integer healthCheckNodePort) {
    this.healthCheckNodePort = healthCheckNodePort;
  }

  @JsonProperty("internalTrafficPolicy")
  public String getInternalTrafficPolicy() {
    return internalTrafficPolicy;
  }

  @JsonProperty("internalTrafficPolicy")
  public void setInternalTrafficPolicy(String internalTrafficPolicy) {
    this.internalTrafficPolicy = internalTrafficPolicy;
  }

  @JsonProperty("ipFamilies")
  public List<String> getIpFamilies() {
    return ipFamilies;
  }

  @JsonProperty("ipFamilies")
  public void setIpFamilies(List<String> ipFamilies) {
    this.ipFamilies = ipFamilies;
  }

  @JsonProperty("ipFamilyPolicy")
  public String getIpFamilyPolicy() {
    return ipFamilyPolicy;
  }

  @JsonProperty("ipFamilyPolicy")
  public void setIpFamilyPolicy(String ipFamilyPolicy) {
    this.ipFamilyPolicy = ipFamilyPolicy;
  }

  @JsonProperty("loadBalancerClass")
  public String getLoadBalancerClass() {
    return loadBalancerClass;
  }

  @JsonProperty("loadBalancerClass")
  public void setLoadBalancerClass(String loadBalancerClass) {
    this.loadBalancerClass = loadBalancerClass;
  }

  @JsonProperty("loadBalancerIP")
  public String getLoadBalancerIP() {
    return loadBalancerIP;
  }

  @JsonProperty("loadBalancerIP")
  public void setLoadBalancerIP(String loadBalancerIP) {
    this.loadBalancerIP = loadBalancerIP;
  }

  @JsonProperty("loadBalancerSourceRanges")
  public List<String> getLoadBalancerSourceRanges() {
    return loadBalancerSourceRanges;
  }

  @JsonProperty("loadBalancerSourceRanges")
  public void setLoadBalancerSourceRanges(List<String> loadBalancerSourceRanges) {
    this.loadBalancerSourceRanges = loadBalancerSourceRanges;
  }

  @JsonProperty("publishNotReadyAddresses")
  public Boolean getPublishNotReadyAddresses() {
    return publishNotReadyAddresses;
  }

  @JsonProperty("publishNotReadyAddresses")
  public void setPublishNotReadyAddresses(Boolean publishNotReadyAddresses) {
    this.publishNotReadyAddresses = publishNotReadyAddresses;
  }

  @JsonProperty("selector")
  public Map<String, String> getSelector() {
    return selector;
  }

  @JsonProperty("selector")
  public void setSelector(Map<String, String> selector) {
    this.selector = selector;
  }

  @JsonProperty("sessionAffinity")
  public String getSessionAffinity() {
    return sessionAffinity;
  }

  @JsonProperty("sessionAffinity")
  public void setSessionAffinity(String sessionAffinity) {
    this.sessionAffinity = sessionAffinity;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
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
