
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
 * RAIDConfig contains the configuration that are required to config RAID in Bare Metal server.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hardwareRAIDVolumes",
    "softwareRAIDVolumes"
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
public class RAIDConfig implements Editable<RAIDConfigBuilder>, KubernetesResource
{

    @JsonProperty("hardwareRAIDVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HardwareRAIDVolume> hardwareRAIDVolumes = new ArrayList<>();
    @JsonProperty("softwareRAIDVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SoftwareRAIDVolume> softwareRAIDVolumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RAIDConfig() {
    }

    public RAIDConfig(List<HardwareRAIDVolume> hardwareRAIDVolumes, List<SoftwareRAIDVolume> softwareRAIDVolumes) {
        super();
        this.hardwareRAIDVolumes = hardwareRAIDVolumes;
        this.softwareRAIDVolumes = softwareRAIDVolumes;
    }

    /**
     * The list of logical disks for hardware RAID, if rootDeviceHints isn't used, first volume is root volume. You can set the value of this field to `[]` to clear all the hardware RAID configurations.
     */
    @JsonProperty("hardwareRAIDVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HardwareRAIDVolume> getHardwareRAIDVolumes() {
        return hardwareRAIDVolumes;
    }

    /**
     * The list of logical disks for hardware RAID, if rootDeviceHints isn't used, first volume is root volume. You can set the value of this field to `[]` to clear all the hardware RAID configurations.
     */
    @JsonProperty("hardwareRAIDVolumes")
    public void setHardwareRAIDVolumes(List<HardwareRAIDVolume> hardwareRAIDVolumes) {
        this.hardwareRAIDVolumes = hardwareRAIDVolumes;
    }

    /**
     * The list of logical disks for software RAID, if rootDeviceHints isn't used, first volume is root volume. If HardwareRAIDVolumes is set this item will be invalid. The number of created Software RAID devices must be 1 or 2. If there is only one Software RAID device, it has to be a RAID-1. If there are two, the first one has to be a RAID-1, while the RAID level for the second one can be 0, 1, or 1+0. As the first RAID device will be the deployment device, enforcing a RAID-1 reduces the risk of ending up with a non-booting host in case of a disk failure. Software RAID will always be deleted.
     */
    @JsonProperty("softwareRAIDVolumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SoftwareRAIDVolume> getSoftwareRAIDVolumes() {
        return softwareRAIDVolumes;
    }

    /**
     * The list of logical disks for software RAID, if rootDeviceHints isn't used, first volume is root volume. If HardwareRAIDVolumes is set this item will be invalid. The number of created Software RAID devices must be 1 or 2. If there is only one Software RAID device, it has to be a RAID-1. If there are two, the first one has to be a RAID-1, while the RAID level for the second one can be 0, 1, or 1+0. As the first RAID device will be the deployment device, enforcing a RAID-1 reduces the risk of ending up with a non-booting host in case of a disk failure. Software RAID will always be deleted.
     */
    @JsonProperty("softwareRAIDVolumes")
    public void setSoftwareRAIDVolumes(List<SoftwareRAIDVolume> softwareRAIDVolumes) {
        this.softwareRAIDVolumes = softwareRAIDVolumes;
    }

    @JsonIgnore
    public RAIDConfigBuilder edit() {
        return new RAIDConfigBuilder(this);
    }

    @JsonIgnore
    public RAIDConfigBuilder toBuilder() {
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
