
package io.fabric8.kubernetes.api.model.clusterapi.metal3.v1alpha1;

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
 * HardwareRAIDVolume defines the desired configuration of volume in hardware RAID.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controller",
    "level",
    "name",
    "numberOfPhysicalDisks",
    "physicalDisks",
    "rotational",
    "sizeGibibytes"
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
public class HardwareRAIDVolume implements Editable<HardwareRAIDVolumeBuilder>, KubernetesResource
{

    @JsonProperty("controller")
    private String controller;
    @JsonProperty("level")
    private String level;
    @JsonProperty("name")
    private String name;
    @JsonProperty("numberOfPhysicalDisks")
    private Integer numberOfPhysicalDisks;
    @JsonProperty("physicalDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> physicalDisks = new ArrayList<>();
    @JsonProperty("rotational")
    private Boolean rotational;
    @JsonProperty("sizeGibibytes")
    private Integer sizeGibibytes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HardwareRAIDVolume() {
    }

    public HardwareRAIDVolume(String controller, String level, String name, Integer numberOfPhysicalDisks, List<String> physicalDisks, Boolean rotational, Integer sizeGibibytes) {
        super();
        this.controller = controller;
        this.level = level;
        this.name = name;
        this.numberOfPhysicalDisks = numberOfPhysicalDisks;
        this.physicalDisks = physicalDisks;
        this.rotational = rotational;
        this.sizeGibibytes = sizeGibibytes;
    }

    /**
     * The name of the RAID controller to use.
     */
    @JsonProperty("controller")
    public String getController() {
        return controller;
    }

    /**
     * The name of the RAID controller to use.
     */
    @JsonProperty("controller")
    public void setController(String controller) {
        this.controller = controller;
    }

    /**
     * RAID level for the logical disk. The following levels are supported: 0, 1, 2, 5, 6, 1+0, 5+0, 6+0 (drivers may support only some of them).
     */
    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    /**
     * RAID level for the logical disk. The following levels are supported: 0, 1, 2, 5, 6, 1+0, 5+0, 6+0 (drivers may support only some of them).
     */
    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Name of the volume. Should be unique within the Node. If not specified, the name will be auto-generated.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the volume. Should be unique within the Node. If not specified, the name will be auto-generated.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Integer, number of physical disks to use for the logical disk. Defaults to minimum number of disks required for the particular RAID level.
     */
    @JsonProperty("numberOfPhysicalDisks")
    public Integer getNumberOfPhysicalDisks() {
        return numberOfPhysicalDisks;
    }

    /**
     * Integer, number of physical disks to use for the logical disk. Defaults to minimum number of disks required for the particular RAID level.
     */
    @JsonProperty("numberOfPhysicalDisks")
    public void setNumberOfPhysicalDisks(Integer numberOfPhysicalDisks) {
        this.numberOfPhysicalDisks = numberOfPhysicalDisks;
    }

    /**
     * Optional list of physical disk names to be used for the hardware RAID volumes. The disk names are interpreted by the hardware RAID controller, and the format is hardware specific.
     */
    @JsonProperty("physicalDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPhysicalDisks() {
        return physicalDisks;
    }

    /**
     * Optional list of physical disk names to be used for the hardware RAID volumes. The disk names are interpreted by the hardware RAID controller, and the format is hardware specific.
     */
    @JsonProperty("physicalDisks")
    public void setPhysicalDisks(List<String> physicalDisks) {
        this.physicalDisks = physicalDisks;
    }

    /**
     * Select disks with only rotational (if set to true) or solid-state (if set to false) storage. By default, any disks can be picked.
     */
    @JsonProperty("rotational")
    public Boolean getRotational() {
        return rotational;
    }

    /**
     * Select disks with only rotational (if set to true) or solid-state (if set to false) storage. By default, any disks can be picked.
     */
    @JsonProperty("rotational")
    public void setRotational(Boolean rotational) {
        this.rotational = rotational;
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
    public HardwareRAIDVolumeBuilder edit() {
        return new HardwareRAIDVolumeBuilder(this);
    }

    @JsonIgnore
    public HardwareRAIDVolumeBuilder toBuilder() {
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
