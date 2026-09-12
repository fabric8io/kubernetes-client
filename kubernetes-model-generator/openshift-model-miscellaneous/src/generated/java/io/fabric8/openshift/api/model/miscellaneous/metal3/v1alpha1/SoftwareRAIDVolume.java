
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
 * SoftwareRAIDVolume defines the desired configuration of volume in software RAID.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "level",
    "physicalDisks",
    "sizeGibibytes"
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
public class SoftwareRAIDVolume implements Editable<SoftwareRAIDVolumeBuilder>, KubernetesResource
{

    @JsonProperty("level")
    private String level;
    @JsonProperty("physicalDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RootDeviceHints> physicalDisks = new ArrayList<>();
    @JsonProperty("sizeGibibytes")
    private Integer sizeGibibytes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SoftwareRAIDVolume() {
    }

    public SoftwareRAIDVolume(String level, List<RootDeviceHints> physicalDisks, Integer sizeGibibytes) {
        super();
        this.level = level;
        this.physicalDisks = physicalDisks;
        this.sizeGibibytes = sizeGibibytes;
    }

    /**
     * RAID level for the logical disk. The following levels are supported: 0, 1 and 1+0.
     */
    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    /**
     * RAID level for the logical disk. The following levels are supported: 0, 1 and 1+0.
     */
    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * A list of device hints, the number of items should be greater than or equal to 2.
     */
    @JsonProperty("physicalDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RootDeviceHints> getPhysicalDisks() {
        return physicalDisks;
    }

    /**
     * A list of device hints, the number of items should be greater than or equal to 2.
     */
    @JsonProperty("physicalDisks")
    public void setPhysicalDisks(List<RootDeviceHints> physicalDisks) {
        this.physicalDisks = physicalDisks;
    }

    /**
     * Size of the logical disk to be created in GiB. If unspecified or set be 0, the maximum capacity of disk will be used for logical disk.
     */
    @JsonProperty("sizeGibibytes")
    public Integer getSizeGibibytes() {
        return sizeGibibytes;
    }

    /**
     * Size of the logical disk to be created in GiB. If unspecified or set be 0, the maximum capacity of disk will be used for logical disk.
     */
    @JsonProperty("sizeGibibytes")
    public void setSizeGibibytes(Integer sizeGibibytes) {
        this.sizeGibibytes = sizeGibibytes;
    }

    @JsonIgnore
    public SoftwareRAIDVolumeBuilder edit() {
        return new SoftwareRAIDVolumeBuilder(this);
    }

    @JsonIgnore
    public SoftwareRAIDVolumeBuilder toBuilder() {
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
        if (!(o instanceof SoftwareRAIDVolume)) {
            return false;
        }
        SoftwareRAIDVolume other = (SoftwareRAIDVolume) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$level = this.getLevel();
        Object other$level = other.getLevel();
        if (this$level == null ? other$level != null : !this$level.equals(other$level)) {
            return false;
        }
        Object this$physicalDisks = this.getPhysicalDisks();
        Object other$physicalDisks = other.getPhysicalDisks();
        if (this$physicalDisks == null ? other$physicalDisks != null : !this$physicalDisks.equals(other$physicalDisks)) {
            return false;
        }
        Object this$sizeGibibytes = this.getSizeGibibytes();
        Object other$sizeGibibytes = other.getSizeGibibytes();
        if (this$sizeGibibytes == null ? other$sizeGibibytes != null : !this$sizeGibibytes.equals(other$sizeGibibytes)) {
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
        return other instanceof SoftwareRAIDVolume;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $level = this.getLevel();
        result = result * prime + ($level == null ? 43 : $level.hashCode());
        Object $physicalDisks = this.getPhysicalDisks();
        result = result * prime + ($physicalDisks == null ? 43 : $physicalDisks.hashCode());
        Object $sizeGibibytes = this.getSizeGibibytes();
        result = result * prime + ($sizeGibibytes == null ? 43 : $sizeGibibytes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SoftwareRAIDVolume(" + "level=" + this.getLevel() + ", physicalDisks=" + this.getPhysicalDisks() + ", sizeGibibytes=" + this.getSizeGibibytes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
