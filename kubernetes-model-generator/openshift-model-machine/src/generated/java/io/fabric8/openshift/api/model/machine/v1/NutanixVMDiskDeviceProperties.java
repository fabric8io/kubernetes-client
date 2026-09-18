
package io.fabric8.openshift.api.model.machine.v1;

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
 * NutanixVMDiskDeviceProperties specifies the disk device properties.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adapterType",
    "deviceIndex",
    "deviceType"
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
public class NutanixVMDiskDeviceProperties implements Editable<NutanixVMDiskDevicePropertiesBuilder>, KubernetesResource
{

    @JsonProperty("adapterType")
    private String adapterType;
    @JsonProperty("deviceIndex")
    private Integer deviceIndex;
    @JsonProperty("deviceType")
    private String deviceType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NutanixVMDiskDeviceProperties() {
    }

    public NutanixVMDiskDeviceProperties(String adapterType, Integer deviceIndex, String deviceType) {
        super();
        this.adapterType = adapterType;
        this.deviceIndex = deviceIndex;
        this.deviceType = deviceType;
    }

    /**
     * adapterType is the adapter type of the disk address. If the deviceType is "Disk", the valid adapterType can be "SCSI", "IDE", "PCI", "SATA" or "SPAPR". If the deviceType is "CDRom", the valid adapterType can be "IDE" or "SATA".
     */
    @JsonProperty("adapterType")
    public String getAdapterType() {
        return adapterType;
    }

    /**
     * adapterType is the adapter type of the disk address. If the deviceType is "Disk", the valid adapterType can be "SCSI", "IDE", "PCI", "SATA" or "SPAPR". If the deviceType is "CDRom", the valid adapterType can be "IDE" or "SATA".
     */
    @JsonProperty("adapterType")
    public void setAdapterType(String adapterType) {
        this.adapterType = adapterType;
    }

    /**
     * deviceIndex is the index of the disk address. The valid values are non-negative integers, with the default value 0. For a Machine VM, the deviceIndex for the disks with the same deviceType.adapterType combination should start from 0 and increase consecutively afterwards. Note that for each Machine VM, the Disk.SCSI.0 and CDRom.IDE.0 are reserved to be used by the VM's system. So for dataDisks of Disk.SCSI and CDRom.IDE, the deviceIndex should start from 1.
     */
    @JsonProperty("deviceIndex")
    public Integer getDeviceIndex() {
        return deviceIndex;
    }

    /**
     * deviceIndex is the index of the disk address. The valid values are non-negative integers, with the default value 0. For a Machine VM, the deviceIndex for the disks with the same deviceType.adapterType combination should start from 0 and increase consecutively afterwards. Note that for each Machine VM, the Disk.SCSI.0 and CDRom.IDE.0 are reserved to be used by the VM's system. So for dataDisks of Disk.SCSI and CDRom.IDE, the deviceIndex should start from 1.
     */
    @JsonProperty("deviceIndex")
    public void setDeviceIndex(Integer deviceIndex) {
        this.deviceIndex = deviceIndex;
    }

    /**
     * deviceType specifies the disk device type. The valid values are "Disk" and "CDRom", and the default is "Disk".
     */
    @JsonProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * deviceType specifies the disk device type. The valid values are "Disk" and "CDRom", and the default is "Disk".
     */
    @JsonProperty("deviceType")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @JsonIgnore
    public NutanixVMDiskDevicePropertiesBuilder edit() {
        return new NutanixVMDiskDevicePropertiesBuilder(this);
    }

    @JsonIgnore
    public NutanixVMDiskDevicePropertiesBuilder toBuilder() {
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
        if (!(o instanceof NutanixVMDiskDeviceProperties)) {
            return false;
        }
        NutanixVMDiskDeviceProperties other = (NutanixVMDiskDeviceProperties) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$adapterType = this.getAdapterType();
        Object other$adapterType = other.getAdapterType();
        if (this$adapterType == null ? other$adapterType != null : !this$adapterType.equals(other$adapterType)) {
            return false;
        }
        Object this$deviceIndex = this.getDeviceIndex();
        Object other$deviceIndex = other.getDeviceIndex();
        if (this$deviceIndex == null ? other$deviceIndex != null : !this$deviceIndex.equals(other$deviceIndex)) {
            return false;
        }
        Object this$deviceType = this.getDeviceType();
        Object other$deviceType = other.getDeviceType();
        if (this$deviceType == null ? other$deviceType != null : !this$deviceType.equals(other$deviceType)) {
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
        return other instanceof NutanixVMDiskDeviceProperties;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $adapterType = this.getAdapterType();
        result = result * prime + ($adapterType == null ? 43 : $adapterType.hashCode());
        Object $deviceIndex = this.getDeviceIndex();
        result = result * prime + ($deviceIndex == null ? 43 : $deviceIndex.hashCode());
        Object $deviceType = this.getDeviceType();
        result = result * prime + ($deviceType == null ? 43 : $deviceType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NutanixVMDiskDeviceProperties(" + "adapterType=" + this.getAdapterType() + ", deviceIndex=" + this.getDeviceIndex() + ", deviceType=" + this.getDeviceType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
