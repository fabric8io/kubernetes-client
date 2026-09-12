
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
 * NetNamespace was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "egressIPs",
    "netid",
    "netname"
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
public class NetNamespace implements Editable<NetNamespaceBuilder>, HasMetadata
{

    @JsonProperty("apiVersion")
    private String apiVersion = "network.openshift.io/v1";
    @JsonProperty("egressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> egressIPs = new ArrayList<>();
    @JsonProperty("kind")
    private String kind = "NetNamespace";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("netid")
    private Long netid;
    @JsonProperty("netname")
    private String netname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetNamespace() {
    }

    public NetNamespace(String apiVersion, List<String> egressIPs, String kind, ObjectMeta metadata, Long netid, String netname) {
        super();
        this.apiVersion = apiVersion;
        this.egressIPs = egressIPs;
        this.kind = kind;
        this.metadata = metadata;
        this.netid = netid;
        this.netname = netname;
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
     * egressIPs is a list of reserved IPs that will be used as the source for external traffic coming from pods in this namespace. (If empty, external traffic will be masqueraded to Node IPs.)
     */
    @JsonProperty("egressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEgressIPs() {
        return egressIPs;
    }

    /**
     * egressIPs is a list of reserved IPs that will be used as the source for external traffic coming from pods in this namespace. (If empty, external traffic will be masqueraded to Node IPs.)
     */
    @JsonProperty("egressIPs")
    public void setEgressIPs(List<String> egressIPs) {
        this.egressIPs = egressIPs;
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
     * NetNamespace was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * NetNamespace was used by OpenShift SDN. DEPRECATED: OpenShift SDN is no longer supported and this object is no longer used in any way by OpenShift.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * netid is the network identifier of the network namespace assigned to each overlay network packet. This can be manipulated with the "oc adm pod-network" commands.
     */
    @JsonProperty("netid")
    public Long getNetid() {
        return netid;
    }

    /**
     * netid is the network identifier of the network namespace assigned to each overlay network packet. This can be manipulated with the "oc adm pod-network" commands.
     */
    @JsonProperty("netid")
    public void setNetid(Long netid) {
        this.netid = netid;
    }

    /**
     * netname is the name of the network namespace. (This is the same as the object's name, but both fields must be set.)
     */
    @JsonProperty("netname")
    public String getNetname() {
        return netname;
    }

    /**
     * netname is the name of the network namespace. (This is the same as the object's name, but both fields must be set.)
     */
    @JsonProperty("netname")
    public void setNetname(String netname) {
        this.netname = netname;
    }

    @JsonIgnore
    public NetNamespaceBuilder edit() {
        return new NetNamespaceBuilder(this);
    }

    @JsonIgnore
    public NetNamespaceBuilder toBuilder() {
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
        if (!(o instanceof NetNamespace)) {
            return false;
        }
        NetNamespace other = (NetNamespace) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$egressIPs = this.getEgressIPs();
        Object other$egressIPs = other.getEgressIPs();
        if (this$egressIPs == null ? other$egressIPs != null : !this$egressIPs.equals(other$egressIPs)) {
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
        Object this$netid = this.getNetid();
        Object other$netid = other.getNetid();
        if (this$netid == null ? other$netid != null : !this$netid.equals(other$netid)) {
            return false;
        }
        Object this$netname = this.getNetname();
        Object other$netname = other.getNetname();
        if (this$netname == null ? other$netname != null : !this$netname.equals(other$netname)) {
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
        return other instanceof NetNamespace;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $egressIPs = this.getEgressIPs();
        result = result * prime + ($egressIPs == null ? 43 : $egressIPs.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $netid = this.getNetid();
        result = result * prime + ($netid == null ? 43 : $netid.hashCode());
        Object $netname = this.getNetname();
        result = result * prime + ($netname == null ? 43 : $netname.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetNamespace(" + "apiVersion=" + this.getApiVersion() + ", egressIPs=" + this.getEgressIPs() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", netid=" + this.getNetid() + ", netname=" + this.getNetname() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
