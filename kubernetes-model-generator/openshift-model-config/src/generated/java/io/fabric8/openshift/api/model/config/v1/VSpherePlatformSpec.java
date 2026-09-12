
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VSpherePlatformSpec holds the desired state of the vSphere infrastructure provider. In the future the cloud provider operator, storage operator and machine operator will use these fields for configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerInternalIPs",
    "failureDomains",
    "ingressIPs",
    "machineNetworks",
    "nodeNetworking",
    "vcenters"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VSpherePlatformSpec implements Editable<VSpherePlatformSpecBuilder>, KubernetesResource
{

    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiServerInternalIPs = new ArrayList<>();
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VSpherePlatformFailureDomainSpec> failureDomains = new ArrayList<>();
    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressIPs = new ArrayList<>();
    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> machineNetworks = new ArrayList<>();
    @JsonProperty("nodeNetworking")
    private VSpherePlatformNodeNetworking nodeNetworking;
    @JsonProperty("vcenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VSpherePlatformVCenterSpec> vcenters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSpherePlatformSpec() {
    }

    public VSpherePlatformSpec(List<String> apiServerInternalIPs, List<VSpherePlatformFailureDomainSpec> failureDomains, List<String> ingressIPs, List<String> machineNetworks, VSpherePlatformNodeNetworking nodeNetworking, List<VSpherePlatformVCenterSpec> vcenters) {
        super();
        this.apiServerInternalIPs = apiServerInternalIPs;
        this.failureDomains = failureDomains;
        this.ingressIPs = ingressIPs;
        this.machineNetworks = machineNetworks;
        this.nodeNetworking = nodeNetworking;
        this.vcenters = vcenters;
    }

    /**
     * apiServerInternalIPs are the IP addresses to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. These are the IPs for a self-hosted load balancer in front of the API servers. In dual stack clusters this list contains two IP addresses, one from IPv4 family and one from IPv6. In single stack clusters a single IP address is expected. When omitted, values from the status.apiServerInternalIPs will be used. Once set, the list cannot be completely removed (but its second entry can).
     */
    @JsonProperty("apiServerInternalIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiServerInternalIPs() {
        return apiServerInternalIPs;
    }

    /**
     * apiServerInternalIPs are the IP addresses to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. These are the IPs for a self-hosted load balancer in front of the API servers. In dual stack clusters this list contains two IP addresses, one from IPv4 family and one from IPv6. In single stack clusters a single IP address is expected. When omitted, values from the status.apiServerInternalIPs will be used. Once set, the list cannot be completely removed (but its second entry can).
     */
    @JsonProperty("apiServerInternalIPs")
    public void setApiServerInternalIPs(List<String> apiServerInternalIPs) {
        this.apiServerInternalIPs = apiServerInternalIPs;
    }

    /**
     * failureDomains contains the definition of region, zone and the vCenter topology. If this is omitted failure domains (regions and zones) will not be used.
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VSpherePlatformFailureDomainSpec> getFailureDomains() {
        return failureDomains;
    }

    /**
     * failureDomains contains the definition of region, zone and the vCenter topology. If this is omitted failure domains (regions and zones) will not be used.
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(List<VSpherePlatformFailureDomainSpec> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * ingressIPs are the external IPs which route to the default ingress controller. The IPs are suitable targets of a wildcard DNS record used to resolve default route host names. In dual stack clusters this list contains two IP addresses, one from IPv4 family and one from IPv6. In single stack clusters a single IP address is expected. When omitted, values from the status.ingressIPs will be used. Once set, the list cannot be completely removed (but its second entry can).
     */
    @JsonProperty("ingressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressIPs() {
        return ingressIPs;
    }

    /**
     * ingressIPs are the external IPs which route to the default ingress controller. The IPs are suitable targets of a wildcard DNS record used to resolve default route host names. In dual stack clusters this list contains two IP addresses, one from IPv4 family and one from IPv6. In single stack clusters a single IP address is expected. When omitted, values from the status.ingressIPs will be used. Once set, the list cannot be completely removed (but its second entry can).
     */
    @JsonProperty("ingressIPs")
    public void setIngressIPs(List<String> ingressIPs) {
        this.ingressIPs = ingressIPs;
    }

    /**
     * machineNetworks are IP networks used to connect all the OpenShift cluster nodes. Each network is provided in the CIDR format and should be IPv4 or IPv6, for example "10.0.0.0/8" or "fd00::/8".
     */
    @JsonProperty("machineNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMachineNetworks() {
        return machineNetworks;
    }

    /**
     * machineNetworks are IP networks used to connect all the OpenShift cluster nodes. Each network is provided in the CIDR format and should be IPv4 or IPv6, for example "10.0.0.0/8" or "fd00::/8".
     */
    @JsonProperty("machineNetworks")
    public void setMachineNetworks(List<String> machineNetworks) {
        this.machineNetworks = machineNetworks;
    }

    /**
     * VSpherePlatformSpec holds the desired state of the vSphere infrastructure provider. In the future the cloud provider operator, storage operator and machine operator will use these fields for configuration.
     */
    @JsonProperty("nodeNetworking")
    public VSpherePlatformNodeNetworking getNodeNetworking() {
        return nodeNetworking;
    }

    /**
     * VSpherePlatformSpec holds the desired state of the vSphere infrastructure provider. In the future the cloud provider operator, storage operator and machine operator will use these fields for configuration.
     */
    @JsonProperty("nodeNetworking")
    public void setNodeNetworking(VSpherePlatformNodeNetworking nodeNetworking) {
        this.nodeNetworking = nodeNetworking;
    }

    /**
     * vcenters holds the connection details for services to communicate with vCenter. Currently, only a single vCenter is supported, but in tech preview 3 vCenters are supported. Once the cluster has been installed, you are unable to change the current number of defined vCenters except in the case where the cluster has been upgraded from a version of OpenShift where the vsphere platform spec was not present.  You may make modifications to the existing vCenters that are defined in the vcenters list in order to match with any added or modified failure domains.
     */
    @JsonProperty("vcenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VSpherePlatformVCenterSpec> getVcenters() {
        return vcenters;
    }

    /**
     * vcenters holds the connection details for services to communicate with vCenter. Currently, only a single vCenter is supported, but in tech preview 3 vCenters are supported. Once the cluster has been installed, you are unable to change the current number of defined vCenters except in the case where the cluster has been upgraded from a version of OpenShift where the vsphere platform spec was not present.  You may make modifications to the existing vCenters that are defined in the vcenters list in order to match with any added or modified failure domains.
     */
    @JsonProperty("vcenters")
    public void setVcenters(List<VSpherePlatformVCenterSpec> vcenters) {
        this.vcenters = vcenters;
    }

    @JsonIgnore
    public VSpherePlatformSpecBuilder edit() {
        return new VSpherePlatformSpecBuilder(this);
    }

    @JsonIgnore
    public VSpherePlatformSpecBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VSpherePlatformSpec)) {
            return false;
        }
        VSpherePlatformSpec other = (VSpherePlatformSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiServerInternalIPs = this.getApiServerInternalIPs();
        Object other$apiServerInternalIPs = other.getApiServerInternalIPs();
        if (this$apiServerInternalIPs == null ? other$apiServerInternalIPs != null : !this$apiServerInternalIPs.equals(other$apiServerInternalIPs)) {
            return false;
        }
        Object this$failureDomains = this.getFailureDomains();
        Object other$failureDomains = other.getFailureDomains();
        if (this$failureDomains == null ? other$failureDomains != null : !this$failureDomains.equals(other$failureDomains)) {
            return false;
        }
        Object this$ingressIPs = this.getIngressIPs();
        Object other$ingressIPs = other.getIngressIPs();
        if (this$ingressIPs == null ? other$ingressIPs != null : !this$ingressIPs.equals(other$ingressIPs)) {
            return false;
        }
        Object this$machineNetworks = this.getMachineNetworks();
        Object other$machineNetworks = other.getMachineNetworks();
        if (this$machineNetworks == null ? other$machineNetworks != null : !this$machineNetworks.equals(other$machineNetworks)) {
            return false;
        }
        Object this$nodeNetworking = this.getNodeNetworking();
        Object other$nodeNetworking = other.getNodeNetworking();
        if (this$nodeNetworking == null ? other$nodeNetworking != null : !this$nodeNetworking.equals(other$nodeNetworking)) {
            return false;
        }
        Object this$vcenters = this.getVcenters();
        Object other$vcenters = other.getVcenters();
        if (this$vcenters == null ? other$vcenters != null : !this$vcenters.equals(other$vcenters)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VSpherePlatformSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiServerInternalIPs = this.getApiServerInternalIPs();
        result = result * prime + ($apiServerInternalIPs == null ? 43 : $apiServerInternalIPs.hashCode());
        Object $failureDomains = this.getFailureDomains();
        result = result * prime + ($failureDomains == null ? 43 : $failureDomains.hashCode());
        Object $ingressIPs = this.getIngressIPs();
        result = result * prime + ($ingressIPs == null ? 43 : $ingressIPs.hashCode());
        Object $machineNetworks = this.getMachineNetworks();
        result = result * prime + ($machineNetworks == null ? 43 : $machineNetworks.hashCode());
        Object $nodeNetworking = this.getNodeNetworking();
        result = result * prime + ($nodeNetworking == null ? 43 : $nodeNetworking.hashCode());
        Object $vcenters = this.getVcenters();
        result = result * prime + ($vcenters == null ? 43 : $vcenters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VSpherePlatformSpec(" + "apiServerInternalIPs=" + this.getApiServerInternalIPs() + ", failureDomains=" + this.getFailureDomains() + ", ingressIPs=" + this.getIngressIPs() + ", machineNetworks=" + this.getMachineNetworks() + ", nodeNetworking=" + this.getNodeNetworking() + ", vcenters=" + this.getVcenters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
