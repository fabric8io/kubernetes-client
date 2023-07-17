
package io.fabric8.openshift.api.model.installer.ovirt.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachinePool implements KubernetesResource
{

    @JsonProperty("affinityGroupsNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> affinityGroupsNames = new ArrayList<String>();
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
     * 
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

    @JsonProperty("affinityGroupsNames")
    public List<String> getAffinityGroupsNames() {
        return affinityGroupsNames;
    }

    @JsonProperty("affinityGroupsNames")
    public void setAffinityGroupsNames(List<String> affinityGroupsNames) {
        this.affinityGroupsNames = affinityGroupsNames;
    }

    @JsonProperty("autoPinningPolicy")
    public String getAutoPinningPolicy() {
        return autoPinningPolicy;
    }

    @JsonProperty("autoPinningPolicy")
    public void setAutoPinningPolicy(String autoPinningPolicy) {
        this.autoPinningPolicy = autoPinningPolicy;
    }

    @JsonProperty("clone")
    public Boolean getClone() {
        return clone;
    }

    @JsonProperty("clone")
    public void setClone(Boolean clone) {
        this.clone = clone;
    }

    @JsonProperty("cpu")
    public CPU getCpu() {
        return cpu;
    }

    @JsonProperty("cpu")
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("hugepages")
    public Integer getHugepages() {
        return hugepages;
    }

    @JsonProperty("hugepages")
    public void setHugepages(Integer hugepages) {
        this.hugepages = hugepages;
    }

    @JsonProperty("instanceTypeID")
    public String getInstanceTypeID() {
        return instanceTypeID;
    }

    @JsonProperty("instanceTypeID")
    public void setInstanceTypeID(String instanceTypeID) {
        this.instanceTypeID = instanceTypeID;
    }

    @JsonProperty("memoryMB")
    public Integer getMemoryMB() {
        return memoryMB;
    }

    @JsonProperty("memoryMB")
    public void setMemoryMB(Integer memoryMB) {
        this.memoryMB = memoryMB;
    }

    @JsonProperty("osDisk")
    public Disk getOsDisk() {
        return osDisk;
    }

    @JsonProperty("osDisk")
    public void setOsDisk(Disk osDisk) {
        this.osDisk = osDisk;
    }

    @JsonProperty("sparse")
    public Boolean getSparse() {
        return sparse;
    }

    @JsonProperty("sparse")
    public void setSparse(Boolean sparse) {
        this.sparse = sparse;
    }

    @JsonProperty("vmType")
    public String getVmType() {
        return vmType;
    }

    @JsonProperty("vmType")
    public void setVmType(String vmType) {
        this.vmType = vmType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
