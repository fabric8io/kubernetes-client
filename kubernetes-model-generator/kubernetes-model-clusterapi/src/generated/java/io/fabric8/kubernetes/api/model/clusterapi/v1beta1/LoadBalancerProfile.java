
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
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

/**
 * LoadBalancerProfile - Profile of the cluster load balancer. At most one of `managedOutboundIPs`, `outboundIPPrefixes`, or `outboundIPs` may be specified. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/load-balancer-standard
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocatedOutboundPorts",
    "idleTimeoutInMinutes",
    "managedOutboundIPs",
    "outboundIPPrefixes",
    "outboundIPs"
})
@ToString
@EqualsAndHashCode
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LoadBalancerProfile implements Editable<LoadBalancerProfileBuilder>, KubernetesResource
{

    @JsonProperty("allocatedOutboundPorts")
    private Integer allocatedOutboundPorts;
    @JsonProperty("idleTimeoutInMinutes")
    private Integer idleTimeoutInMinutes;
    @JsonProperty("managedOutboundIPs")
    private Integer managedOutboundIPs;
    @JsonProperty("outboundIPPrefixes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> outboundIPPrefixes = new ArrayList<>();
    @JsonProperty("outboundIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> outboundIPs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerProfile() {
    }

    public LoadBalancerProfile(Integer allocatedOutboundPorts, Integer idleTimeoutInMinutes, Integer managedOutboundIPs, List<String> outboundIPPrefixes, List<String> outboundIPs) {
        super();
        this.allocatedOutboundPorts = allocatedOutboundPorts;
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
        this.managedOutboundIPs = managedOutboundIPs;
        this.outboundIPPrefixes = outboundIPPrefixes;
        this.outboundIPs = outboundIPs;
    }

    /**
     * AllocatedOutboundPorts - Desired number of allocated SNAT ports per VM. Allowed values must be in the range of 0 to 64000 (inclusive). The default value is 0 which results in Azure dynamically allocating ports.
     */
    @JsonProperty("allocatedOutboundPorts")
    public Integer getAllocatedOutboundPorts() {
        return allocatedOutboundPorts;
    }

    /**
     * AllocatedOutboundPorts - Desired number of allocated SNAT ports per VM. Allowed values must be in the range of 0 to 64000 (inclusive). The default value is 0 which results in Azure dynamically allocating ports.
     */
    @JsonProperty("allocatedOutboundPorts")
    public void setAllocatedOutboundPorts(Integer allocatedOutboundPorts) {
        this.allocatedOutboundPorts = allocatedOutboundPorts;
    }

    /**
     * IdleTimeoutInMinutes - Desired outbound flow idle timeout in minutes. Allowed values must be in the range of 4 to 120 (inclusive). The default value is 30 minutes.
     */
    @JsonProperty("idleTimeoutInMinutes")
    public Integer getIdleTimeoutInMinutes() {
        return idleTimeoutInMinutes;
    }

    /**
     * IdleTimeoutInMinutes - Desired outbound flow idle timeout in minutes. Allowed values must be in the range of 4 to 120 (inclusive). The default value is 30 minutes.
     */
    @JsonProperty("idleTimeoutInMinutes")
    public void setIdleTimeoutInMinutes(Integer idleTimeoutInMinutes) {
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
    }

    /**
     * ManagedOutboundIPs - Desired managed outbound IPs for the cluster load balancer.
     */
    @JsonProperty("managedOutboundIPs")
    public Integer getManagedOutboundIPs() {
        return managedOutboundIPs;
    }

    /**
     * ManagedOutboundIPs - Desired managed outbound IPs for the cluster load balancer.
     */
    @JsonProperty("managedOutboundIPs")
    public void setManagedOutboundIPs(Integer managedOutboundIPs) {
        this.managedOutboundIPs = managedOutboundIPs;
    }

    /**
     * OutboundIPPrefixes - Desired outbound IP Prefix resources for the cluster load balancer.
     */
    @JsonProperty("outboundIPPrefixes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOutboundIPPrefixes() {
        return outboundIPPrefixes;
    }

    /**
     * OutboundIPPrefixes - Desired outbound IP Prefix resources for the cluster load balancer.
     */
    @JsonProperty("outboundIPPrefixes")
    public void setOutboundIPPrefixes(List<String> outboundIPPrefixes) {
        this.outboundIPPrefixes = outboundIPPrefixes;
    }

    /**
     * OutboundIPs - Desired outbound IP resources for the cluster load balancer.
     */
    @JsonProperty("outboundIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOutboundIPs() {
        return outboundIPs;
    }

    /**
     * OutboundIPs - Desired outbound IP resources for the cluster load balancer.
     */
    @JsonProperty("outboundIPs")
    public void setOutboundIPs(List<String> outboundIPs) {
        this.outboundIPs = outboundIPs;
    }

    @JsonIgnore
    public LoadBalancerProfileBuilder edit() {
        return new LoadBalancerProfileBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerProfileBuilder toBuilder() {
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

}
