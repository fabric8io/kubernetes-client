
package io.fabric8.openshift.api.model.installer.powervs.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
 * MachinePool stores the configuration for a machine pool installed on IBM Power VS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "memoryGiB",
    "procType",
    "processors",
    "smtLevel",
    "sysType",
    "volumeIDs"
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

    @JsonProperty("memoryGiB")
    private Integer memoryGiB;
    @JsonProperty("procType")
    private String procType;
    @JsonProperty("processors")
    private IntOrString processors;
    @JsonProperty("smtLevel")
    private String smtLevel;
    @JsonProperty("sysType")
    private String sysType;
    @JsonProperty("volumeIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumeIDs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(Integer memoryGiB, String procType, IntOrString processors, String smtLevel, String sysType, List<String> volumeIDs) {
        super();
        this.memoryGiB = memoryGiB;
        this.procType = procType;
        this.processors = processors;
        this.smtLevel = smtLevel;
        this.sysType = sysType;
        this.volumeIDs = volumeIDs;
    }

    /**
     * memoryGiB is the size of a virtual machine's memory, in GiB.
     */
    @JsonProperty("memoryGiB")
    public Integer getMemoryGiB() {
        return memoryGiB;
    }

    /**
     * memoryGiB is the size of a virtual machine's memory, in GiB.
     */
    @JsonProperty("memoryGiB")
    public void setMemoryGiB(Integer memoryGiB) {
        this.memoryGiB = memoryGiB;
    }

    /**
     * ProcType defines the processor sharing model for the instance. Must be one of {Capped, Dedicated, Shared}.
     */
    @JsonProperty("procType")
    public String getProcType() {
        return procType;
    }

    /**
     * ProcType defines the processor sharing model for the instance. Must be one of {Capped, Dedicated, Shared}.
     */
    @JsonProperty("procType")
    public void setProcType(String procType) {
        this.procType = procType;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on IBM Power VS.
     */
    @JsonProperty("processors")
    public IntOrString getProcessors() {
        return processors;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on IBM Power VS.
     */
    @JsonProperty("processors")
    public void setProcessors(IntOrString processors) {
        this.processors = processors;
    }

    /**
     * SMTLevel specifies the level of SMT to set the control plane and worker nodes to.
     */
    @JsonProperty("smtLevel")
    public String getSmtLevel() {
        return smtLevel;
    }

    /**
     * SMTLevel specifies the level of SMT to set the control plane and worker nodes to.
     */
    @JsonProperty("smtLevel")
    public void setSmtLevel(String smtLevel) {
        this.smtLevel = smtLevel;
    }

    /**
     * SysType defines the system type for instance.
     */
    @JsonProperty("sysType")
    public String getSysType() {
        return sysType;
    }

    /**
     * SysType defines the system type for instance.
     */
    @JsonProperty("sysType")
    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    /**
     * VolumeIDs is the list of volumes attached to the instance.
     */
    @JsonProperty("volumeIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVolumeIDs() {
        return volumeIDs;
    }

    /**
     * VolumeIDs is the list of volumes attached to the instance.
     */
    @JsonProperty("volumeIDs")
    public void setVolumeIDs(List<String> volumeIDs) {
        this.volumeIDs = volumeIDs;
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
