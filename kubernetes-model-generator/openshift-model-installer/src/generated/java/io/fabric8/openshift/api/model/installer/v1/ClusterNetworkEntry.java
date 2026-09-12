
package io.fabric8.openshift.api.model.installer.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterNetworkEntry is a single IP address block for pod IP blocks. IP blocks are allocated with size 2^HostSubnetLength.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidr",
    "hostPrefix",
    "hostSubnetLength"
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
public class ClusterNetworkEntry implements Editable<ClusterNetworkEntryBuilder>, KubernetesResource
{

    @JsonProperty("cidr")
    private String cidr;
    @JsonProperty("hostPrefix")
    private Integer hostPrefix;
    @JsonProperty("hostSubnetLength")
    private Integer hostSubnetLength;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterNetworkEntry() {
    }

    public ClusterNetworkEntry(String cidr, Integer hostPrefix, Integer hostSubnetLength) {
        super();
        this.cidr = cidr;
        this.hostPrefix = hostPrefix;
        this.hostSubnetLength = hostSubnetLength;
    }

    /**
     * ClusterNetworkEntry is a single IP address block for pod IP blocks. IP blocks are allocated with size 2^HostSubnetLength.
     */
    @JsonProperty("cidr")
    public String getCidr() {
        return cidr;
    }

    /**
     * ClusterNetworkEntry is a single IP address block for pod IP blocks. IP blocks are allocated with size 2^HostSubnetLength.
     */
    @JsonProperty("cidr")
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * HostPrefix is the prefix size to allocate to each node from the CIDR. For example, 24 would allocate 2^8=256 adresses to each node. If this field is not used by the plugin, it can be left unset. When multiple CIDRs of the same family (i.e. IPv4/IPv6) are present, their HostPrefix value must be the same.
     */
    @JsonProperty("hostPrefix")
    public Integer getHostPrefix() {
        return hostPrefix;
    }

    /**
     * HostPrefix is the prefix size to allocate to each node from the CIDR. For example, 24 would allocate 2^8=256 adresses to each node. If this field is not used by the plugin, it can be left unset. When multiple CIDRs of the same family (i.e. IPv4/IPv6) are present, their HostPrefix value must be the same.
     */
    @JsonProperty("hostPrefix")
    public void setHostPrefix(Integer hostPrefix) {
        this.hostPrefix = hostPrefix;
    }

    /**
     * The size of blocks to allocate from the larger pool. This is the length in bits - so a 9 here will allocate a /23.
     */
    @JsonProperty("hostSubnetLength")
    public Integer getHostSubnetLength() {
        return hostSubnetLength;
    }

    /**
     * The size of blocks to allocate from the larger pool. This is the length in bits - so a 9 here will allocate a /23.
     */
    @JsonProperty("hostSubnetLength")
    public void setHostSubnetLength(Integer hostSubnetLength) {
        this.hostSubnetLength = hostSubnetLength;
    }

    @JsonIgnore
    public ClusterNetworkEntryBuilder edit() {
        return new ClusterNetworkEntryBuilder(this);
    }

    @JsonIgnore
    public ClusterNetworkEntryBuilder toBuilder() {
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
        if (!(o instanceof ClusterNetworkEntry)) {
            return false;
        }
        ClusterNetworkEntry other = (ClusterNetworkEntry) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cidr = this.getCidr();
        Object other$cidr = other.getCidr();
        if (this$cidr == null ? other$cidr != null : !this$cidr.equals(other$cidr)) {
            return false;
        }
        Object this$hostPrefix = this.getHostPrefix();
        Object other$hostPrefix = other.getHostPrefix();
        if (this$hostPrefix == null ? other$hostPrefix != null : !this$hostPrefix.equals(other$hostPrefix)) {
            return false;
        }
        Object this$hostSubnetLength = this.getHostSubnetLength();
        Object other$hostSubnetLength = other.getHostSubnetLength();
        if (this$hostSubnetLength == null ? other$hostSubnetLength != null : !this$hostSubnetLength.equals(other$hostSubnetLength)) {
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
        return other instanceof ClusterNetworkEntry;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cidr = this.getCidr();
        result = result * prime + ($cidr == null ? 43 : $cidr.hashCode());
        Object $hostPrefix = this.getHostPrefix();
        result = result * prime + ($hostPrefix == null ? 43 : $hostPrefix.hashCode());
        Object $hostSubnetLength = this.getHostSubnetLength();
        result = result * prime + ($hostSubnetLength == null ? 43 : $hostSubnetLength.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterNetworkEntry(" + "cidr=" + this.getCidr() + ", hostPrefix=" + this.getHostPrefix() + ", hostSubnetLength=" + this.getHostSubnetLength() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
