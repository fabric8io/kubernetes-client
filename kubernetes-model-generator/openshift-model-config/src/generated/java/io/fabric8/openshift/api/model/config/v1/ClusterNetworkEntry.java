
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterNetworkEntry is a contiguous block of IP addresses from which pod IPs are allocated.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidr",
    "hostPrefix"
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
public class ClusterNetworkEntry implements Editable<ClusterNetworkEntryBuilder>, KubernetesResource
{

    @JsonProperty("cidr")
    private String cidr;
    @JsonProperty("hostPrefix")
    private Long hostPrefix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterNetworkEntry() {
    }

    public ClusterNetworkEntry(String cidr, Long hostPrefix) {
        super();
        this.cidr = cidr;
        this.hostPrefix = hostPrefix;
    }

    /**
     * The complete block for pod IPs.
     */
    @JsonProperty("cidr")
    public String getCidr() {
        return cidr;
    }

    /**
     * The complete block for pod IPs.
     */
    @JsonProperty("cidr")
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * The size (prefix) of block to allocate to each node. If this field is not used by the plugin, it can be left unset.
     */
    @JsonProperty("hostPrefix")
    public Long getHostPrefix() {
        return hostPrefix;
    }

    /**
     * The size (prefix) of block to allocate to each node. If this field is not used by the plugin, it can be left unset.
     */
    @JsonProperty("hostPrefix")
    public void setHostPrefix(Long hostPrefix) {
        this.hostPrefix = hostPrefix;
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
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterNetworkEntry(" + "cidr=" + this.getCidr() + ", hostPrefix=" + this.getHostPrefix() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
