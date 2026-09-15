
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
import io.fabric8.openshift.api.model.machine.v1.NutanixCategory;
import io.fabric8.openshift.api.model.machine.v1.NutanixGPU;
import io.fabric8.openshift.api.model.machine.v1.NutanixResourceIdentifier;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MachinePool stores the configuration for a machine pool installed on Nutanix.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootType",
    "categories",
    "coresPerSocket",
    "cpus",
    "dataDisks",
    "failureDomains",
    "gpus",
    "memoryMiB",
    "osDisk",
    "project"
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

    @JsonProperty("bootType")
    private String bootType;
    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixCategory> categories = new ArrayList<>();
    @JsonProperty("coresPerSocket")
    private Long coresPerSocket;
    @JsonProperty("cpus")
    private Long cpus;
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DataDisk> dataDisks = new ArrayList<>();
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failureDomains = new ArrayList<>();
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixGPU> gpus = new ArrayList<>();
    @JsonProperty("memoryMiB")
    private Long memoryMiB;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("project")
    private NutanixResourceIdentifier project;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(String bootType, List<NutanixCategory> categories, Long coresPerSocket, Long cpus, List<DataDisk> dataDisks, List<String> failureDomains, List<NutanixGPU> gpus, Long memoryMiB, OSDisk osDisk, NutanixResourceIdentifier project) {
        super();
        this.bootType = bootType;
        this.categories = categories;
        this.coresPerSocket = coresPerSocket;
        this.cpus = cpus;
        this.dataDisks = dataDisks;
        this.failureDomains = failureDomains;
        this.gpus = gpus;
        this.memoryMiB = memoryMiB;
        this.osDisk = osDisk;
        this.project = project;
    }

    /**
     * BootType indicates the boot type (Legacy, UEFI or SecureBoot) the Machine's VM uses to boot. If this field is empty or omitted, the VM will use the default boot type "Legacy" to boot. "SecureBoot" depends on "UEFI" boot, i.e., enabling "SecureBoot" means that "UEFI" boot is also enabled.
     */
    @JsonProperty("bootType")
    public String getBootType() {
        return bootType;
    }

    /**
     * BootType indicates the boot type (Legacy, UEFI or SecureBoot) the Machine's VM uses to boot. If this field is empty or omitted, the VM will use the default boot type "Legacy" to boot. "SecureBoot" depends on "UEFI" boot, i.e., enabling "SecureBoot" means that "UEFI" boot is also enabled.
     */
    @JsonProperty("bootType")
    public void setBootType(String bootType) {
        this.bootType = bootType;
    }

    /**
     * Categories optionally adds one or more prism categories (each with key and value) for the Machine's VM to associate with. All the category key and value pairs specified must already exist in the prism central.
     */
    @JsonProperty("categories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixCategory> getCategories() {
        return categories;
    }

    /**
     * Categories optionally adds one or more prism categories (each with key and value) for the Machine's VM to associate with. All the category key and value pairs specified must already exist in the prism central.
     */
    @JsonProperty("categories")
    public void setCategories(List<NutanixCategory> categories) {
        this.categories = categories;
    }

    /**
     * NumCoresPerSocket is the number of cores per socket in a vm. The number of vCPUs on the vm will be NumCPUs times NumCoresPerSocket. For example: 4 CPUs and 4 Cores per socket will result in 16 VPUs. The AHV scheduler treats socket and core allocation exactly the same so there is no benefit to configuring cores over CPUs.
     */
    @JsonProperty("coresPerSocket")
    public Long getCoresPerSocket() {
        return coresPerSocket;
    }

    /**
     * NumCoresPerSocket is the number of cores per socket in a vm. The number of vCPUs on the vm will be NumCPUs times NumCoresPerSocket. For example: 4 CPUs and 4 Cores per socket will result in 16 VPUs. The AHV scheduler treats socket and core allocation exactly the same so there is no benefit to configuring cores over CPUs.
     */
    @JsonProperty("coresPerSocket")
    public void setCoresPerSocket(Long coresPerSocket) {
        this.coresPerSocket = coresPerSocket;
    }

    /**
     * NumCPUs is the total number of virtual processor cores to assign a vm.
     */
    @JsonProperty("cpus")
    public Long getCpus() {
        return cpus;
    }

    /**
     * NumCPUs is the total number of virtual processor cores to assign a vm.
     */
    @JsonProperty("cpus")
    public void setCpus(Long cpus) {
        this.cpus = cpus;
    }

    /**
     * DataDisks holds information of the data disks to attach to the Machine's VM
     */
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DataDisk> getDataDisks() {
        return dataDisks;
    }

    /**
     * DataDisks holds information of the data disks to attach to the Machine's VM
     */
    @JsonProperty("dataDisks")
    public void setDataDisks(List<DataDisk> dataDisks) {
        this.dataDisks = dataDisks;
    }

    /**
     * FailureDomains optionally configures a list of failure domain names that will be applied to the MachinePool
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFailureDomains() {
        return failureDomains;
    }

    /**
     * FailureDomains optionally configures a list of failure domain names that will be applied to the MachinePool
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(List<String> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * GPUs is a list of GPU devices to attach to the machine's VM.
     */
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixGPU> getGpus() {
        return gpus;
    }

    /**
     * GPUs is a list of GPU devices to attach to the machine's VM.
     */
    @JsonProperty("gpus")
    public void setGpus(List<NutanixGPU> gpus) {
        this.gpus = gpus;
    }

    /**
     * Memory is the size of a VM's memory in MiB.
     */
    @JsonProperty("memoryMiB")
    public Long getMemoryMiB() {
        return memoryMiB;
    }

    /**
     * Memory is the size of a VM's memory in MiB.
     */
    @JsonProperty("memoryMiB")
    public void setMemoryMiB(Long memoryMiB) {
        this.memoryMiB = memoryMiB;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Nutanix.
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Nutanix.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Nutanix.
     */
    @JsonProperty("project")
    public NutanixResourceIdentifier getProject() {
        return project;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Nutanix.
     */
    @JsonProperty("project")
    public void setProject(NutanixResourceIdentifier project) {
        this.project = project;
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
        Object this$bootType = this.getBootType();
        Object other$bootType = other.getBootType();
        if (this$bootType == null ? other$bootType != null : !this$bootType.equals(other$bootType)) {
            return false;
        }
        Object this$categories = this.getCategories();
        Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories)) {
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
        Object this$dataDisks = this.getDataDisks();
        Object other$dataDisks = other.getDataDisks();
        if (this$dataDisks == null ? other$dataDisks != null : !this$dataDisks.equals(other$dataDisks)) {
            return false;
        }
        Object this$failureDomains = this.getFailureDomains();
        Object other$failureDomains = other.getFailureDomains();
        if (this$failureDomains == null ? other$failureDomains != null : !this$failureDomains.equals(other$failureDomains)) {
            return false;
        }
        Object this$gpus = this.getGpus();
        Object other$gpus = other.getGpus();
        if (this$gpus == null ? other$gpus != null : !this$gpus.equals(other$gpus)) {
            return false;
        }
        Object this$memoryMiB = this.getMemoryMiB();
        Object other$memoryMiB = other.getMemoryMiB();
        if (this$memoryMiB == null ? other$memoryMiB != null : !this$memoryMiB.equals(other$memoryMiB)) {
            return false;
        }
        Object this$osDisk = this.getOsDisk();
        Object other$osDisk = other.getOsDisk();
        if (this$osDisk == null ? other$osDisk != null : !this$osDisk.equals(other$osDisk)) {
            return false;
        }
        Object this$project = this.getProject();
        Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) {
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
        Object $bootType = this.getBootType();
        result = result * prime + ($bootType == null ? 43 : $bootType.hashCode());
        Object $categories = this.getCategories();
        result = result * prime + ($categories == null ? 43 : $categories.hashCode());
        Object $coresPerSocket = this.getCoresPerSocket();
        result = result * prime + ($coresPerSocket == null ? 43 : $coresPerSocket.hashCode());
        Object $cpus = this.getCpus();
        result = result * prime + ($cpus == null ? 43 : $cpus.hashCode());
        Object $dataDisks = this.getDataDisks();
        result = result * prime + ($dataDisks == null ? 43 : $dataDisks.hashCode());
        Object $failureDomains = this.getFailureDomains();
        result = result * prime + ($failureDomains == null ? 43 : $failureDomains.hashCode());
        Object $gpus = this.getGpus();
        result = result * prime + ($gpus == null ? 43 : $gpus.hashCode());
        Object $memoryMiB = this.getMemoryMiB();
        result = result * prime + ($memoryMiB == null ? 43 : $memoryMiB.hashCode());
        Object $osDisk = this.getOsDisk();
        result = result * prime + ($osDisk == null ? 43 : $osDisk.hashCode());
        Object $project = this.getProject();
        result = result * prime + ($project == null ? 43 : $project.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "bootType=" + this.getBootType() + ", categories=" + this.getCategories() + ", coresPerSocket=" + this.getCoresPerSocket() + ", cpus=" + this.getCpus() + ", dataDisks=" + this.getDataDisks() + ", failureDomains=" + this.getFailureDomains() + ", gpus=" + this.getGpus() + ", memoryMiB=" + this.getMemoryMiB() + ", osDisk=" + this.getOsDisk() + ", project=" + this.getProject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
