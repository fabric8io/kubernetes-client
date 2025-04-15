
package io.fabric8.openshift.api.model.installer.ovirt.v1;

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
 * MachinePool stores the configuration for a machine pool installed on ovirt.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinityGroupsNames",
    "autoPinningPolicy",
    "clone",
    "cpu",
    "format",
    "hugepages",
    "instanceTypeID",
    "memoryMB",
    "osDisk",
    "sparse",
    "vmType"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("affinityGroupsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> affinityGroupsNames = new ArrayList<>();
    @JsonProperty("autoPinningPolicy")
    private String autoPinningPolicy;
    @JsonProperty("clone")
    private Boolean clone;
    @JsonProperty("cpu")
    private CPU cpu;
    @JsonProperty("format")
    private String format;
    @JsonProperty("hugepages")
    private Integer hugepages;
    @JsonProperty("instanceTypeID")
    private String instanceTypeID;
    @JsonProperty("memoryMB")
    private Integer memoryMB;
    @JsonProperty("osDisk")
    private Disk osDisk;
    @JsonProperty("sparse")
    private Boolean sparse;
    @JsonProperty("vmType")
    private String vmType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(List<String> affinityGroupsNames, String autoPinningPolicy, Boolean clone, CPU cpu, String format, Integer hugepages, String instanceTypeID, Integer memoryMB, Disk osDisk, Boolean sparse, String vmType) {
        super();
        this.affinityGroupsNames = affinityGroupsNames;
        this.autoPinningPolicy = autoPinningPolicy;
        this.clone = clone;
        this.cpu = cpu;
        this.format = format;
        this.hugepages = hugepages;
        this.instanceTypeID = instanceTypeID;
        this.memoryMB = memoryMB;
        this.osDisk = osDisk;
        this.sparse = sparse;
        this.vmType = vmType;
    }

    /**
     * AffinityGroupsNames contains a list of oVirt affinity group names that the newly created machines will join. The affinity groups should exist on the oVirt cluster or created by the OpenShift installer.
     */
    @JsonProperty("affinityGroupsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAffinityGroupsNames() {
        return affinityGroupsNames;
    }

    /**
     * AffinityGroupsNames contains a list of oVirt affinity group names that the newly created machines will join. The affinity groups should exist on the oVirt cluster or created by the OpenShift installer.
     */
    @JsonProperty("affinityGroupsNames")
    public void setAffinityGroupsNames(List<String> affinityGroupsNames) {
        this.affinityGroupsNames = affinityGroupsNames;
    }

    /**
     * AutoPinningPolicy defines the policy to automatically set the CPU and NUMA including pinning to the host for the instance. When the field is omitted the default will be "none".
     */
    @JsonProperty("autoPinningPolicy")
    public String getAutoPinningPolicy() {
        return autoPinningPolicy;
    }

    /**
     * AutoPinningPolicy defines the policy to automatically set the CPU and NUMA including pinning to the host for the instance. When the field is omitted the default will be "none".
     */
    @JsonProperty("autoPinningPolicy")
    public void setAutoPinningPolicy(String autoPinningPolicy) {
        this.autoPinningPolicy = autoPinningPolicy;
    }

    /**
     * Clone makes sure that the disks are cloned from the template and are not linked. Defaults to true for high performance and server VM types, false for desktop types.<br><p> <br><p> Note: this option is not documented in the OpenShift documentation. This is intentional as it has sane defaults that shouldn't be changed unless needed for debugging or resolving issues in cooperation with Red Hat support.
     */
    @JsonProperty("clone")
    public Boolean getClone() {
        return clone;
    }

    /**
     * Clone makes sure that the disks are cloned from the template and are not linked. Defaults to true for high performance and server VM types, false for desktop types.<br><p> <br><p> Note: this option is not documented in the OpenShift documentation. This is intentional as it has sane defaults that shouldn't be changed unless needed for debugging or resolving issues in cooperation with Red Hat support.
     */
    @JsonProperty("clone")
    public void setClone(Boolean clone) {
        this.clone = clone;
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
     * Format is the disk format that the disks are in. Can be "cow" or "raw". "raw" disables several features that may be needed, such as incremental backups.
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * Format is the disk format that the disks are in. Can be "cow" or "raw". "raw" disables several features that may be needed, such as incremental backups.
     */
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Hugepages is the size of a VM's hugepages to use in KiBs.
     */
    @JsonProperty("hugepages")
    public Integer getHugepages() {
        return hugepages;
    }

    /**
     * Hugepages is the size of a VM's hugepages to use in KiBs.
     */
    @JsonProperty("hugepages")
    public void setHugepages(Integer hugepages) {
        this.hugepages = hugepages;
    }

    /**
     * InstanceTypeID defines the VM instance type and overrides the hardware parameters of the created VM, including cpu and memory. If InstanceTypeID is passed, all memory and cpu variables will be ignored.
     */
    @JsonProperty("instanceTypeID")
    public String getInstanceTypeID() {
        return instanceTypeID;
    }

    /**
     * InstanceTypeID defines the VM instance type and overrides the hardware parameters of the created VM, including cpu and memory. If InstanceTypeID is passed, all memory and cpu variables will be ignored.
     */
    @JsonProperty("instanceTypeID")
    public void setInstanceTypeID(String instanceTypeID) {
        this.instanceTypeID = instanceTypeID;
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
     * Sparse indicates that sparse provisioning should be used and disks should be not preallocated.
     */
    @JsonProperty("sparse")
    public Boolean getSparse() {
        return sparse;
    }

    /**
     * Sparse indicates that sparse provisioning should be used and disks should be not preallocated.
     */
    @JsonProperty("sparse")
    public void setSparse(Boolean sparse) {
        this.sparse = sparse;
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
