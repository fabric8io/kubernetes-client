
package io.fabric8.openshift.api.model.miscellaneous.network.v1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HostSubnet was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "egressCIDRs",
    "egressIPs",
    "host",
    "hostIP",
    "subnet"
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
@Version("v1")
@Group("network.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HostSubnet implements Editable<HostSubnetBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "network.openshift.io/v1";
    @JsonProperty("egressCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> egressCIDRs = new ArrayList<>();
    @JsonProperty("egressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> egressIPs = new ArrayList<>();
    @JsonProperty("host")
    private String host;
    @JsonProperty("hostIP")
    private String hostIP;
    @JsonProperty("kind")
    private String kind = "HostSubnet";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("subnet")
    private String subnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostSubnet() {
    }

    public HostSubnet(String apiVersion, List<String> egressCIDRs, List<String> egressIPs, String host, String hostIP, String kind, ObjectMeta metadata, String subnet) {
        super();
        this.apiVersion = apiVersion;
        this.egressCIDRs = egressCIDRs;
        this.egressIPs = egressIPs;
        this.host = host;
        this.hostIP = hostIP;
        this.kind = kind;
        this.metadata = metadata;
        this.subnet = subnet;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * egressCIDRs is the list of CIDR ranges available for automatically assigning egress IPs to this node from. If this field is set then EgressIPs should be treated as read-only.
     */
    @JsonProperty("egressCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEgressCIDRs() {
        return egressCIDRs;
    }

    /**
     * egressCIDRs is the list of CIDR ranges available for automatically assigning egress IPs to this node from. If this field is set then EgressIPs should be treated as read-only.
     */
    @JsonProperty("egressCIDRs")
    public void setEgressCIDRs(List<String> egressCIDRs) {
        this.egressCIDRs = egressCIDRs;
    }

    /**
     * egressIPs is the list of automatic egress IP addresses currently hosted by this node. If EgressCIDRs is empty, this can be set by hand; if EgressCIDRs is set then the master will overwrite the value here with its own allocation of egress IPs.
     */
    @JsonProperty("egressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEgressIPs() {
        return egressIPs;
    }

    /**
     * egressIPs is the list of automatic egress IP addresses currently hosted by this node. If EgressCIDRs is empty, this can be set by hand; if EgressCIDRs is set then the master will overwrite the value here with its own allocation of egress IPs.
     */
    @JsonProperty("egressIPs")
    public void setEgressIPs(List<String> egressIPs) {
        this.egressIPs = egressIPs;
    }

    /**
     * host is the name of the node. (This is the same as the object's name, but both fields must be set.)
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * host is the name of the node. (This is the same as the object's name, but both fields must be set.)
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * hostIP is the IP address to be used as a VTEP by other nodes in the overlay network
     */
    @JsonProperty("hostIP")
    public String getHostIP() {
        return hostIP;
    }

    /**
     * hostIP is the IP address to be used as a VTEP by other nodes in the overlay network
     */
    @JsonProperty("hostIP")
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * HostSubnet was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * HostSubnet was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * subnet is the CIDR range of the overlay network assigned to the node for its pods
     */
    @JsonProperty("subnet")
    public String getSubnet() {
        return subnet;
    }

    /**
     * subnet is the CIDR range of the overlay network assigned to the node for its pods
     */
    @JsonProperty("subnet")
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    @JsonIgnore
    public HostSubnetBuilder edit() {
        return new HostSubnetBuilder(this);
    }

    @JsonIgnore
    public HostSubnetBuilder toBuilder() {
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
        if (!(o instanceof HostSubnet)) {
            return false;
        }
        HostSubnet other = (HostSubnet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$egressCIDRs = this.getEgressCIDRs();
        Object other$egressCIDRs = other.getEgressCIDRs();
        if (this$egressCIDRs == null ? other$egressCIDRs != null : !this$egressCIDRs.equals(other$egressCIDRs)) {
            return false;
        }
        Object this$egressIPs = this.getEgressIPs();
        Object other$egressIPs = other.getEgressIPs();
        if (this$egressIPs == null ? other$egressIPs != null : !this$egressIPs.equals(other$egressIPs)) {
            return false;
        }
        Object this$host = this.getHost();
        Object other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
            return false;
        }
        Object this$hostIP = this.getHostIP();
        Object other$hostIP = other.getHostIP();
        if (this$hostIP == null ? other$hostIP != null : !this$hostIP.equals(other$hostIP)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$subnet = this.getSubnet();
        Object other$subnet = other.getSubnet();
        if (this$subnet == null ? other$subnet != null : !this$subnet.equals(other$subnet)) {
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
        return other instanceof HostSubnet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $egressCIDRs = this.getEgressCIDRs();
        result = result * prime + ($egressCIDRs == null ? 43 : $egressCIDRs.hashCode());
        Object $egressIPs = this.getEgressIPs();
        result = result * prime + ($egressIPs == null ? 43 : $egressIPs.hashCode());
        Object $host = this.getHost();
        result = result * prime + ($host == null ? 43 : $host.hashCode());
        Object $hostIP = this.getHostIP();
        result = result * prime + ($hostIP == null ? 43 : $hostIP.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $subnet = this.getSubnet();
        result = result * prime + ($subnet == null ? 43 : $subnet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostSubnet(" + "apiVersion=" + this.getApiVersion() + ", egressCIDRs=" + this.getEgressCIDRs() + ", egressIPs=" + this.getEgressIPs() + ", host=" + this.getHost() + ", hostIP=" + this.getHostIP() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", subnet=" + this.getSubnet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
