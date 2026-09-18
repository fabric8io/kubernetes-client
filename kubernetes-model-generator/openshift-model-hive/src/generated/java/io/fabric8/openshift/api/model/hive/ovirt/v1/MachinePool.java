
package io.fabric8.openshift.api.model.hive.ovirt.v1;

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
 * MachinePool stores the configuration for a machine pool installed on ovirt.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpu",
    "memoryMB",
    "osDisk",
    "vmType"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("cpu")
    private CPU cpu;
    @JsonProperty("memoryMB")
    private Integer memoryMB;
    @JsonProperty("osDisk")
    private Disk osDisk;
    @JsonProperty("vmType")
    private String vmType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(CPU cpu, Integer memoryMB, Disk osDisk, String vmType) {
        super();
        this.cpu = cpu;
        this.memoryMB = memoryMB;
        this.osDisk = osDisk;
        this.vmType = vmType;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on ovirt.
     */
    @JsonProperty("cpu")
    public CPU getCpu() {
        return cpu;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on ovirt.
     */
    @JsonProperty("cpu")
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    /**
     * MemoryMB is the size of a VM's memory in MiBs.
     */
    @JsonProperty("memoryMB")
    public Integer getMemoryMB() {
        return memoryMB;
    }

    /**
     * MemoryMB is the size of a VM's memory in MiBs.
     */
    @JsonProperty("memoryMB")
    public void setMemoryMB(Integer memoryMB) {
        this.memoryMB = memoryMB;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on ovirt.
     */
    @JsonProperty("osDisk")
    public Disk getOsDisk() {
        return osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on ovirt.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(Disk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * VMType defines the workload type of the VM.
     */
    @JsonProperty("vmType")
    public String getVmType() {
        return vmType;
    }

    /**
     * VMType defines the workload type of the VM.
     */
    @JsonProperty("vmType")
    public void setVmType(String vmType) {
        this.vmType = vmType;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
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
        if (!(o instanceof MachinePool)) {
            return false;
        }
        MachinePool other = (MachinePool) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cpu = this.getCpu();
        Object other$cpu = other.getCpu();
        if (this$cpu == null ? other$cpu != null : !this$cpu.equals(other$cpu)) {
            return false;
        }
        Object this$memoryMB = this.getMemoryMB();
        Object other$memoryMB = other.getMemoryMB();
        if (this$memoryMB == null ? other$memoryMB != null : !this$memoryMB.equals(other$memoryMB)) {
            return false;
        }
        Object this$osDisk = this.getOsDisk();
        Object other$osDisk = other.getOsDisk();
        if (this$osDisk == null ? other$osDisk != null : !this$osDisk.equals(other$osDisk)) {
            return false;
        }
        Object this$vmType = this.getVmType();
        Object other$vmType = other.getVmType();
        if (this$vmType == null ? other$vmType != null : !this$vmType.equals(other$vmType)) {
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
        return other instanceof MachinePool;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cpu = this.getCpu();
        result = result * prime + ($cpu == null ? 43 : $cpu.hashCode());
        Object $memoryMB = this.getMemoryMB();
        result = result * prime + ($memoryMB == null ? 43 : $memoryMB.hashCode());
        Object $osDisk = this.getOsDisk();
        result = result * prime + ($osDisk == null ? 43 : $osDisk.hashCode());
        Object $vmType = this.getVmType();
        result = result * prime + ($vmType == null ? 43 : $vmType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "cpu=" + this.getCpu() + ", memoryMB=" + this.getMemoryMB() + ", osDisk=" + this.getOsDisk() + ", vmType=" + this.getVmType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
