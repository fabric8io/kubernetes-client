
package io.fabric8.openshift.api.model.config.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerInternalIP",
    "apiServerInternalIPs",
    "cloudName",
    "ingressIP",
    "ingressIPs",
    "loadBalancer",
    "machineNetworks",
    "nodeDNSIP"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OpenStackPlatformStatus implements Editable<OpenStackPlatformStatusBuilder> , KubernetesResource
{

    @JsonProperty("apiServerInternalIP")
    private String apiServerInternalIP;
    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiServerInternalIPs = new ArrayList<>();
    @JsonProperty("cloudName")
    private String cloudName;
    @JsonProperty("ingressIP")
    private String ingressIP;
    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressIPs = new ArrayList<>();
    @JsonProperty("loadBalancer")
    private OpenStackPlatformLoadBalancer loadBalancer;
    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> machineNetworks = new ArrayList<>();
    @JsonProperty("nodeDNSIP")
    private String nodeDNSIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenStackPlatformStatus() {
    }

    public OpenStackPlatformStatus(String apiServerInternalIP, List<String> apiServerInternalIPs, String cloudName, String ingressIP, List<String> ingressIPs, OpenStackPlatformLoadBalancer loadBalancer, List<String> machineNetworks, String nodeDNSIP) {
        super();
        this.apiServerInternalIP = apiServerInternalIP;
        this.apiServerInternalIPs = apiServerInternalIPs;
        this.cloudName = cloudName;
        this.ingressIP = ingressIP;
        this.ingressIPs = ingressIPs;
        this.loadBalancer = loadBalancer;
        this.machineNetworks = machineNetworks;
        this.nodeDNSIP = nodeDNSIP;
    }

    @JsonProperty("apiServerInternalIP")
    public String getApiServerInternalIP() {
        return apiServerInternalIP;
    }

    @JsonProperty("apiServerInternalIP")
    public void setApiServerInternalIP(String apiServerInternalIP) {
        this.apiServerInternalIP = apiServerInternalIP;
    }

    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiServerInternalIPs() {
        return apiServerInternalIPs;
    }

    @JsonProperty("apiServerInternalIPs")
    public void setApiServerInternalIPs(List<String> apiServerInternalIPs) {
        this.apiServerInternalIPs = apiServerInternalIPs;
    }

    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    @JsonProperty("ingressIP")
    public String getIngressIP() {
        return ingressIP;
    }

    @JsonProperty("ingressIP")
    public void setIngressIP(String ingressIP) {
        this.ingressIP = ingressIP;
    }

    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressIPs() {
        return ingressIPs;
    }

    @JsonProperty("ingressIPs")
    public void setIngressIPs(List<String> ingressIPs) {
        this.ingressIPs = ingressIPs;
    }

    @JsonProperty("loadBalancer")
    public OpenStackPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty("loadBalancer")
    public void setLoadBalancer(OpenStackPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMachineNetworks() {
        return machineNetworks;
    }

    @JsonProperty("machineNetworks")
    public void setMachineNetworks(List<String> machineNetworks) {
        this.machineNetworks = machineNetworks;
    }

    @JsonProperty("nodeDNSIP")
    public String getNodeDNSIP() {
        return nodeDNSIP;
    }

    @JsonProperty("nodeDNSIP")
    public void setNodeDNSIP(String nodeDNSIP) {
        this.nodeDNSIP = nodeDNSIP;
    }

    @JsonIgnore
    public OpenStackPlatformStatusBuilder edit() {
        return new OpenStackPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public OpenStackPlatformStatusBuilder toBuilder() {
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
