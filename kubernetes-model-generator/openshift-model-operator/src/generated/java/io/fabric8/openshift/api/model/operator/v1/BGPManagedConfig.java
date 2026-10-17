
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * BGPManagedConfig contains configuration options for BGP when routing is "Managed".
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "asNumber",
    "bgpTopology"
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
public class BGPManagedConfig implements Editable<BGPManagedConfigBuilder>, KubernetesResource
{

    @JsonProperty("asNumber")
    private Long asNumber;
    @JsonProperty("bgpTopology")
    private String bgpTopology;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BGPManagedConfig() {
    }

    public BGPManagedConfig(Long asNumber, String bgpTopology) {
        super();
        this.asNumber = asNumber;
        this.bgpTopology = bgpTopology;
    }

    /**
     * asNumber is the 2-byte or 4-byte Autonomous System Number (ASN) to be used in the generated FRR configuration. Valid values are 1 to 4294967295. When omitted, this defaults to 64512.
     */
    @JsonProperty("asNumber")
    public Long getAsNumber() {
        return asNumber;
    }

    /**
     * asNumber is the 2-byte or 4-byte Autonomous System Number (ASN) to be used in the generated FRR configuration. Valid values are 1 to 4294967295. When omitted, this defaults to 64512.
     */
    @JsonProperty("asNumber")
    public void setAsNumber(Long asNumber) {
        this.asNumber = asNumber;
    }

    /**
     * bgpTopology defines the BGP topology to be used. Allowed values are "FullMesh". When set to "FullMesh", every node peers directly with every other node via BGP. This field is required when BGPManagedConfig is specified.
     */
    @JsonProperty("bgpTopology")
    public String getBgpTopology() {
        return bgpTopology;
    }

    /**
     * bgpTopology defines the BGP topology to be used. Allowed values are "FullMesh". When set to "FullMesh", every node peers directly with every other node via BGP. This field is required when BGPManagedConfig is specified.
     */
    @JsonProperty("bgpTopology")
    public void setBgpTopology(String bgpTopology) {
        this.bgpTopology = bgpTopology;
    }

    @JsonIgnore
    public BGPManagedConfigBuilder edit() {
        return new BGPManagedConfigBuilder(this);
    }

    @JsonIgnore
    public BGPManagedConfigBuilder toBuilder() {
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
        if (!(o instanceof BGPManagedConfig)) {
            return false;
        }
        BGPManagedConfig other = (BGPManagedConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$asNumber = this.getAsNumber();
        Object other$asNumber = other.getAsNumber();
        if (this$asNumber == null ? other$asNumber != null : !this$asNumber.equals(other$asNumber)) {
            return false;
        }
        Object this$bgpTopology = this.getBgpTopology();
        Object other$bgpTopology = other.getBgpTopology();
        if (this$bgpTopology == null ? other$bgpTopology != null : !this$bgpTopology.equals(other$bgpTopology)) {
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
        return other instanceof BGPManagedConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $asNumber = this.getAsNumber();
        result = result * prime + ($asNumber == null ? 43 : $asNumber.hashCode());
        Object $bgpTopology = this.getBgpTopology();
        result = result * prime + ($bgpTopology == null ? 43 : $bgpTopology.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BGPManagedConfig(" + "asNumber=" + this.getAsNumber() + ", bgpTopology=" + this.getBgpTopology() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
