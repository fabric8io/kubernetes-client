
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    "trafficDistribution",
    "type"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ServiceSpec implements Editable<ServiceSpecBuilder>, KubernetesResource
{

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
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServicePort> ports = new ArrayList<>();
    @JsonProperty("publishNotReadyAddresses")
    private Boolean publishNotReadyAddresses;
    @JsonProperty("selector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> selector = new LinkedHashMap<>();
    @JsonProperty("sessionAffinity")
    private String sessionAffinity;
    @JsonProperty("sessionAffinityConfig")
    private SessionAffinityConfig sessionAffinityConfig;
    @JsonProperty("trafficDistribution")
    private String trafficDistribution;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceSpec() {
    }

    public ServiceSpec(Boolean allocateLoadBalancerNodePorts, String clusterIP, List<String> clusterIPs, List<String> externalIPs, String externalName, String externalTrafficPolicy, Integer healthCheckNodePort, String internalTrafficPolicy, List<String> ipFamilies, String ipFamilyPolicy, String loadBalancerClass, String loadBalancerIP, List<String> loadBalancerSourceRanges, List<ServicePort> ports, Boolean publishNotReadyAddresses, Map<String, String> selector, String sessionAffinity, SessionAffinityConfig sessionAffinityConfig, String trafficDistribution, String type) {
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
        this.trafficDistribution = trafficDistribution;
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
    public String getClusterIP() {
        return clusterIP;
    }

    @JsonProperty("clusterIP")
    public void setClusterIP(String clusterIP) {
        this.clusterIP = clusterIP;
    }

    @JsonProperty("clusterIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClusterIPs() {
        return clusterIPs;
    }

    @JsonProperty("clusterIPs")
    public void setClusterIPs(List<String> clusterIPs) {
        this.clusterIPs = clusterIPs;
    }

    @JsonProperty("externalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getLoadBalancerSourceRanges() {
        return loadBalancerSourceRanges;
    }

    @JsonProperty("loadBalancerSourceRanges")
    public void setLoadBalancerSourceRanges(List<String> loadBalancerSourceRanges) {
        this.loadBalancerSourceRanges = loadBalancerSourceRanges;
    }

    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("sessionAffinityConfig")
    public SessionAffinityConfig getSessionAffinityConfig() {
        return sessionAffinityConfig;
    }

    @JsonProperty("sessionAffinityConfig")
    public void setSessionAffinityConfig(SessionAffinityConfig sessionAffinityConfig) {
        this.sessionAffinityConfig = sessionAffinityConfig;
    }

    @JsonProperty("trafficDistribution")
    public String getTrafficDistribution() {
        return trafficDistribution;
    }

    @JsonProperty("trafficDistribution")
    public void setTrafficDistribution(String trafficDistribution) {
        this.trafficDistribution = trafficDistribution;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ServiceSpecBuilder edit() {
        return new ServiceSpecBuilder(this);
    }

    @JsonIgnore
    public ServiceSpecBuilder toBuilder() {
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
