
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
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
    "ports",
    "publishNotReadyAddresses",
    "selector",
    "sessionAffinity",
    "sessionAffinityConfig",
    "type"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class ServiceSpec implements KubernetesResource
{

    @JsonProperty("allocateLoadBalancerNodePorts")
    private Boolean allocateLoadBalancerNodePorts;
    @JsonProperty("clusterIP")
    private java.lang.String clusterIP;
    @JsonProperty("clusterIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> clusterIPs = new ArrayList<java.lang.String>();
    @JsonProperty("externalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> externalIPs = new ArrayList<java.lang.String>();
    @JsonProperty("externalName")
    private java.lang.String externalName;
    @JsonProperty("externalTrafficPolicy")
    private java.lang.String externalTrafficPolicy;
    @JsonProperty("healthCheckNodePort")
    private Integer healthCheckNodePort;
    @JsonProperty("internalTrafficPolicy")
    private java.lang.String internalTrafficPolicy;
    @JsonProperty("ipFamilies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> ipFamilies = new ArrayList<java.lang.String>();
    @JsonProperty("ipFamilyPolicy")
    private java.lang.String ipFamilyPolicy;
    @JsonProperty("loadBalancerClass")
    private java.lang.String loadBalancerClass;
    @JsonProperty("loadBalancerIP")
    private java.lang.String loadBalancerIP;
    @JsonProperty("loadBalancerSourceRanges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> loadBalancerSourceRanges = new ArrayList<java.lang.String>();
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServicePort> ports = new ArrayList<ServicePort>();
    @JsonProperty("publishNotReadyAddresses")
    private Boolean publishNotReadyAddresses;
    @JsonProperty("selector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> selector = new LinkedHashMap<String, String>();
    @JsonProperty("sessionAffinity")
    private java.lang.String sessionAffinity;
    @JsonProperty("sessionAffinityConfig")
    private SessionAffinityConfig sessionAffinityConfig;
    @JsonProperty("type")
    private java.lang.String type;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceSpec() {
    }

    public ServiceSpec(Boolean allocateLoadBalancerNodePorts, java.lang.String clusterIP, List<java.lang.String> clusterIPs, List<java.lang.String> externalIPs, java.lang.String externalName, java.lang.String externalTrafficPolicy, Integer healthCheckNodePort, java.lang.String internalTrafficPolicy, List<java.lang.String> ipFamilies, java.lang.String ipFamilyPolicy, java.lang.String loadBalancerClass, java.lang.String loadBalancerIP, List<java.lang.String> loadBalancerSourceRanges, List<ServicePort> ports, Boolean publishNotReadyAddresses, Map<String, String> selector, java.lang.String sessionAffinity, SessionAffinityConfig sessionAffinityConfig, java.lang.String type) {
        super();
        this.allocateLoadBalancerNodePorts = allocateLoadBalancerNodePorts;
        this.clusterIP = clusterIP;
        this.clusterIPs = clusterIPs;
        this.externalIPs = externalIPs;
        this.externalName = externalName;
        this.externalTrafficPolicy = externalTrafficPolicy;
        this.healthCheckNodePort = healthCheckNodePort;
        this.internalTrafficPolicy = internalTrafficPolicy;
        this.ipFamilies = ipFamilies;
        this.ipFamilyPolicy = ipFamilyPolicy;
        this.loadBalancerClass = loadBalancerClass;
        this.loadBalancerIP = loadBalancerIP;
        this.loadBalancerSourceRanges = loadBalancerSourceRanges;
        this.ports = ports;
        this.publishNotReadyAddresses = publishNotReadyAddresses;
        this.selector = selector;
        this.sessionAffinity = sessionAffinity;
        this.sessionAffinityConfig = sessionAffinityConfig;
        this.type = type;
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
    public java.lang.String getClusterIP() {
        return clusterIP;
    }

    @JsonProperty("clusterIP")
    public void setClusterIP(java.lang.String clusterIP) {
        this.clusterIP = clusterIP;
    }

    @JsonProperty("clusterIPs")
    public List<java.lang.String> getClusterIPs() {
        return clusterIPs;
    }

    @JsonProperty("clusterIPs")
    public void setClusterIPs(List<java.lang.String> clusterIPs) {
        this.clusterIPs = clusterIPs;
    }

    @JsonProperty("externalIPs")
    public List<java.lang.String> getExternalIPs() {
        return externalIPs;
    }

    @JsonProperty("externalIPs")
    public void setExternalIPs(List<java.lang.String> externalIPs) {
        this.externalIPs = externalIPs;
    }

    @JsonProperty("externalName")
    public java.lang.String getExternalName() {
        return externalName;
    }

    @JsonProperty("externalName")
    public void setExternalName(java.lang.String externalName) {
        this.externalName = externalName;
    }

    @JsonProperty("externalTrafficPolicy")
    public java.lang.String getExternalTrafficPolicy() {
        return externalTrafficPolicy;
    }

    @JsonProperty("externalTrafficPolicy")
    public void setExternalTrafficPolicy(java.lang.String externalTrafficPolicy) {
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
    public java.lang.String getInternalTrafficPolicy() {
        return internalTrafficPolicy;
    }

    @JsonProperty("internalTrafficPolicy")
    public void setInternalTrafficPolicy(java.lang.String internalTrafficPolicy) {
        this.internalTrafficPolicy = internalTrafficPolicy;
    }

    @JsonProperty("ipFamilies")
    public List<java.lang.String> getIpFamilies() {
        return ipFamilies;
    }

    @JsonProperty("ipFamilies")
    public void setIpFamilies(List<java.lang.String> ipFamilies) {
        this.ipFamilies = ipFamilies;
    }

    @JsonProperty("ipFamilyPolicy")
    public java.lang.String getIpFamilyPolicy() {
        return ipFamilyPolicy;
    }

    @JsonProperty("ipFamilyPolicy")
    public void setIpFamilyPolicy(java.lang.String ipFamilyPolicy) {
        this.ipFamilyPolicy = ipFamilyPolicy;
    }

    @JsonProperty("loadBalancerClass")
    public java.lang.String getLoadBalancerClass() {
        return loadBalancerClass;
    }

    @JsonProperty("loadBalancerClass")
    public void setLoadBalancerClass(java.lang.String loadBalancerClass) {
        this.loadBalancerClass = loadBalancerClass;
    }

    @JsonProperty("loadBalancerIP")
    public java.lang.String getLoadBalancerIP() {
        return loadBalancerIP;
    }

    @JsonProperty("loadBalancerIP")
    public void setLoadBalancerIP(java.lang.String loadBalancerIP) {
        this.loadBalancerIP = loadBalancerIP;
    }

    @JsonProperty("loadBalancerSourceRanges")
    public List<java.lang.String> getLoadBalancerSourceRanges() {
        return loadBalancerSourceRanges;
    }

    @JsonProperty("loadBalancerSourceRanges")
    public void setLoadBalancerSourceRanges(List<java.lang.String> loadBalancerSourceRanges) {
        this.loadBalancerSourceRanges = loadBalancerSourceRanges;
    }

    @JsonProperty("ports")
    public List<ServicePort> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<ServicePort> ports) {
        this.ports = ports;
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
    public java.lang.String getSessionAffinity() {
        return sessionAffinity;
    }

    @JsonProperty("sessionAffinity")
    public void setSessionAffinity(java.lang.String sessionAffinity) {
        this.sessionAffinity = sessionAffinity;
    }

    @JsonProperty("sessionAffinityConfig")
    public SessionAffinityConfig getSessionAffinityConfig() {
        return sessionAffinityConfig;
    }

    @JsonProperty("sessionAffinityConfig")
    public void setSessionAffinityConfig(SessionAffinityConfig sessionAffinityConfig) {
        this.sessionAffinityConfig = sessionAffinityConfig;
    }

    @JsonProperty("type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(java.lang.String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
