
package io.fabric8.openshift.api.model.miscellaneous.network.v1;

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
 * ClusterNetworkEntry defines an individual cluster network. The CIDRs cannot overlap with other cluster network CIDRs, CIDRs reserved for external ips, CIDRs reserved for service networks, and CIDRs reserved for ingress ips.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CIDR",
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

    @JsonProperty("CIDR")
    private String cIDR;
    @JsonProperty("hostSubnetLength")
    private Long hostSubnetLength;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterNetworkEntry() {
    }

    public ClusterNetworkEntry(String cIDR, Long hostSubnetLength) {
        super();
        this.cIDR = cIDR;
        this.hostSubnetLength = hostSubnetLength;
    }

    /**
     * CIDR defines the total range of a cluster networks address space.
     */
    @JsonProperty("CIDR")
    public String getCIDR() {
        return cIDR;
    }

    /**
     * CIDR defines the total range of a cluster networks address space.
     */
    @JsonProperty("CIDR")
    public void setCIDR(String cIDR) {
        this.cIDR = cIDR;
    }

    /**
     * hostSubnetLength is the number of bits of the accompanying CIDR address to allocate to each node. eg, 8 would mean that each node would have a /24 slice of the overlay network for its pods.
     */
    @JsonProperty("hostSubnetLength")
    public Long getHostSubnetLength() {
        return hostSubnetLength;
    }

    /**
     * hostSubnetLength is the number of bits of the accompanying CIDR address to allocate to each node. eg, 8 would mean that each node would have a /24 slice of the overlay network for its pods.
     */
    @JsonProperty("hostSubnetLength")
    public void setHostSubnetLength(Long hostSubnetLength) {
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
        Object this$cIDR = this.getCIDR();
        Object other$cIDR = other.getCIDR();
        if (this$cIDR == null ? other$cIDR != null : !this$cIDR.equals(other$cIDR)) {
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
        Object $cIDR = this.getCIDR();
        result = result * prime + ($cIDR == null ? 43 : $cIDR.hashCode());
        Object $hostSubnetLength = this.getHostSubnetLength();
        result = result * prime + ($hostSubnetLength == null ? 43 : $hostSubnetLength.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterNetworkEntry(" + "cIDR=" + this.getCIDR() + ", hostSubnetLength=" + this.getHostSubnetLength() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
