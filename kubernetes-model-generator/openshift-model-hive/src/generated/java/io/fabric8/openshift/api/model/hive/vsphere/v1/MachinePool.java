
package io.fabric8.openshift.api.model.hive.vsphere.v1;

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
 * MachinePool stores the configuration for a machine pool installed on vSphere.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coresPerSocket",
    "cpus",
    "memoryMB",
    "osDisk",
    "resourcePool"
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

    @JsonProperty("coresPerSocket")
    private Integer coresPerSocket;
    @JsonProperty("cpus")
    private Integer cpus;
    @JsonProperty("memoryMB")
    private Long memoryMB;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("resourcePool")
    private String resourcePool;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(Integer coresPerSocket, Integer cpus, Long memoryMB, OSDisk osDisk, String resourcePool) {
        super();
        this.coresPerSocket = coresPerSocket;
        this.cpus = cpus;
        this.memoryMB = memoryMB;
        this.osDisk = osDisk;
        this.resourcePool = resourcePool;
    }

    /**
     * NumCoresPerSocket is the number of cores per socket in a vm. The number of vCPUs on the vm will be NumCPUs/NumCoresPerSocket.
     */
    @JsonProperty("coresPerSocket")
    public Integer getCoresPerSocket() {
        return coresPerSocket;
    }

    /**
     * NumCoresPerSocket is the number of cores per socket in a vm. The number of vCPUs on the vm will be NumCPUs/NumCoresPerSocket.
     */
    @JsonProperty("coresPerSocket")
    public void setCoresPerSocket(Integer coresPerSocket) {
        this.coresPerSocket = coresPerSocket;
    }

    /**
     * NumCPUs is the total number of virtual processor cores to assign a vm.
     */
    @JsonProperty("cpus")
    public Integer getCpus() {
        return cpus;
    }

    /**
     * NumCPUs is the total number of virtual processor cores to assign a vm.
     */
    @JsonProperty("cpus")
    public void setCpus(Integer cpus) {
        this.cpus = cpus;
    }

    /**
     * Memory is the size of a VM's memory in MB.
     */
    @JsonProperty("memoryMB")
    public Long getMemoryMB() {
        return memoryMB;
    }

    /**
     * Memory is the size of a VM's memory in MB.
     */
    @JsonProperty("memoryMB")
    public void setMemoryMB(Long memoryMB) {
        this.memoryMB = memoryMB;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on vSphere.
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on vSphere.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * ResourcePool is the name of the resource pool that will be used for virtual machines. If it is not present, a default value will be used.
     */
    @JsonProperty("resourcePool")
    public String getResourcePool() {
        return resourcePool;
    }

    /**
     * ResourcePool is the name of the resource pool that will be used for virtual machines. If it is not present, a default value will be used.
     */
    @JsonProperty("resourcePool")
    public void setResourcePool(String resourcePool) {
        this.resourcePool = resourcePool;
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
        Object this$coresPerSocket = this.getCoresPerSocket();
        Object other$coresPerSocket = other.getCoresPerSocket();
        if (this$coresPerSocket == null ? other$coresPerSocket != null : !this$coresPerSocket.equals(other$coresPerSocket)) {
            return false;
        }
        Object this$cpus = this.getCpus();
        Object other$cpus = other.getCpus();
        if (this$cpus == null ? other$cpus != null : !this$cpus.equals(other$cpus)) {
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
        Object this$resourcePool = this.getResourcePool();
        Object other$resourcePool = other.getResourcePool();
        if (this$resourcePool == null ? other$resourcePool != null : !this$resourcePool.equals(other$resourcePool)) {
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
        Object $coresPerSocket = this.getCoresPerSocket();
        result = result * prime + ($coresPerSocket == null ? 43 : $coresPerSocket.hashCode());
        Object $cpus = this.getCpus();
        result = result * prime + ($cpus == null ? 43 : $cpus.hashCode());
        Object $memoryMB = this.getMemoryMB();
        result = result * prime + ($memoryMB == null ? 43 : $memoryMB.hashCode());
        Object $osDisk = this.getOsDisk();
        result = result * prime + ($osDisk == null ? 43 : $osDisk.hashCode());
        Object $resourcePool = this.getResourcePool();
        result = result * prime + ($resourcePool == null ? 43 : $resourcePool.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "coresPerSocket=" + this.getCoresPerSocket() + ", cpus=" + this.getCpus() + ", memoryMB=" + this.getMemoryMB() + ", osDisk=" + this.getOsDisk() + ", resourcePool=" + this.getResourcePool() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
