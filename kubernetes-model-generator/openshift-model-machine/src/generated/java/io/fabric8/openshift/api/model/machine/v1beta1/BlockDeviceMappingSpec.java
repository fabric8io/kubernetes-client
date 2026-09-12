
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * BlockDeviceMappingSpec describes a block device mapping
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deviceName",
    "ebs",
    "noDevice",
    "virtualName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class BlockDeviceMappingSpec implements Editable<BlockDeviceMappingSpecBuilder>, KubernetesResource
{

    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("ebs")
    private EBSBlockDeviceSpec ebs;
    @JsonProperty("noDevice")
    private String noDevice;
    @JsonProperty("virtualName")
    private String virtualName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BlockDeviceMappingSpec() {
    }

    public BlockDeviceMappingSpec(String deviceName, EBSBlockDeviceSpec ebs, String noDevice, String virtualName) {
        super();
        this.deviceName = deviceName;
        this.ebs = ebs;
        this.noDevice = noDevice;
        this.virtualName = virtualName;
    }

    /**
     * The device name exposed to the machine (for example, /dev/sdh or xvdh).
     */
    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * The device name exposed to the machine (for example, /dev/sdh or xvdh).
     */
    @JsonProperty("deviceName")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * BlockDeviceMappingSpec describes a block device mapping
     */
    @JsonProperty("ebs")
    public EBSBlockDeviceSpec getEbs() {
        return ebs;
    }

    /**
     * BlockDeviceMappingSpec describes a block device mapping
     */
    @JsonProperty("ebs")
    public void setEbs(EBSBlockDeviceSpec ebs) {
        this.ebs = ebs;
    }

    /**
     * Suppresses the specified device included in the block device mapping of the AMI.
     */
    @JsonProperty("noDevice")
    public String getNoDevice() {
        return noDevice;
    }

    /**
     * Suppresses the specified device included in the block device mapping of the AMI.
     */
    @JsonProperty("noDevice")
    public void setNoDevice(String noDevice) {
        this.noDevice = noDevice;
    }

    /**
     * The virtual device name (ephemeralN). Machine store volumes are numbered starting from 0. An machine type with 2 available machine store volumes can specify mappings for ephemeral0 and ephemeral1.The number of available machine store volumes depends on the machine type. After you connect to the machine, you must mount the volume.<br><p> <br><p> Constraints: For M3 machines, you must specify machine store volumes in the block device mapping for the machine. When you launch an M3 machine, we ignore any machine store volumes specified in the block device mapping for the AMI.
     */
    @JsonProperty("virtualName")
    public String getVirtualName() {
        return virtualName;
    }

    /**
     * The virtual device name (ephemeralN). Machine store volumes are numbered starting from 0. An machine type with 2 available machine store volumes can specify mappings for ephemeral0 and ephemeral1.The number of available machine store volumes depends on the machine type. After you connect to the machine, you must mount the volume.<br><p> <br><p> Constraints: For M3 machines, you must specify machine store volumes in the block device mapping for the machine. When you launch an M3 machine, we ignore any machine store volumes specified in the block device mapping for the AMI.
     */
    @JsonProperty("virtualName")
    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    @JsonIgnore
    public BlockDeviceMappingSpecBuilder edit() {
        return new BlockDeviceMappingSpecBuilder(this);
    }

    @JsonIgnore
    public BlockDeviceMappingSpecBuilder toBuilder() {
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
        if (!(o instanceof BlockDeviceMappingSpec)) {
            return false;
        }
        BlockDeviceMappingSpec other = (BlockDeviceMappingSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$deviceName = this.getDeviceName();
        Object other$deviceName = other.getDeviceName();
        if (this$deviceName == null ? other$deviceName != null : !this$deviceName.equals(other$deviceName)) {
            return false;
        }
        Object this$ebs = this.getEbs();
        Object other$ebs = other.getEbs();
        if (this$ebs == null ? other$ebs != null : !this$ebs.equals(other$ebs)) {
            return false;
        }
        Object this$noDevice = this.getNoDevice();
        Object other$noDevice = other.getNoDevice();
        if (this$noDevice == null ? other$noDevice != null : !this$noDevice.equals(other$noDevice)) {
            return false;
        }
        Object this$virtualName = this.getVirtualName();
        Object other$virtualName = other.getVirtualName();
        if (this$virtualName == null ? other$virtualName != null : !this$virtualName.equals(other$virtualName)) {
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
        return other instanceof BlockDeviceMappingSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $deviceName = this.getDeviceName();
        result = result * prime + ($deviceName == null ? 43 : $deviceName.hashCode());
        Object $ebs = this.getEbs();
        result = result * prime + ($ebs == null ? 43 : $ebs.hashCode());
        Object $noDevice = this.getNoDevice();
        result = result * prime + ($noDevice == null ? 43 : $noDevice.hashCode());
        Object $virtualName = this.getVirtualName();
        result = result * prime + ($virtualName == null ? 43 : $virtualName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BlockDeviceMappingSpec(" + "deviceName=" + this.getDeviceName() + ", ebs=" + this.getEbs() + ", noDevice=" + this.getNoDevice() + ", virtualName=" + this.getVirtualName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
