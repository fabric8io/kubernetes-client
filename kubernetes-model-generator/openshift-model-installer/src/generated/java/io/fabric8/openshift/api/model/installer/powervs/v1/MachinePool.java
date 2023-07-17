
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
import io.fabric8.kubernetes.api.model.Container;
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
    "memoryGiB",
    "procType",
    "processors",
    "sysType",
    "volumeIDs"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachinePool implements KubernetesResource
{

    @JsonProperty("memoryGiB")
    private Integer memoryGiB;
    @JsonProperty("procType")
    private String procType;
    @JsonProperty("processors")
    private io.fabric8.kubernetes.api.model.IntOrString processors;
    @JsonProperty("sysType")
    private String sysType;
    @JsonProperty("volumeIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumeIDs = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachinePool() {
    }

    public MachinePool(Integer memoryGiB, String procType, io.fabric8.kubernetes.api.model.IntOrString processors, String sysType, List<String> volumeIDs) {
        super();
        this.memoryGiB = memoryGiB;
        this.procType = procType;
        this.processors = processors;
        this.sysType = sysType;
        this.volumeIDs = volumeIDs;
    }

    @JsonProperty("memoryGiB")
    public Integer getMemoryGiB() {
        return memoryGiB;
    }

    @JsonProperty("memoryGiB")
    public void setMemoryGiB(Integer memoryGiB) {
        this.memoryGiB = memoryGiB;
    }

    @JsonProperty("procType")
    public String getProcType() {
        return procType;
    }

    @JsonProperty("procType")
    public void setProcType(String procType) {
        this.procType = procType;
    }

    @JsonProperty("processors")
    public io.fabric8.kubernetes.api.model.IntOrString getProcessors() {
        return processors;
    }

    @JsonProperty("processors")
    public void setProcessors(io.fabric8.kubernetes.api.model.IntOrString processors) {
        this.processors = processors;
    }

    @JsonProperty("sysType")
    public String getSysType() {
        return sysType;
    }

    @JsonProperty("sysType")
    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    @JsonProperty("volumeIDs")
    public List<String> getVolumeIDs() {
        return volumeIDs;
    }

    @JsonProperty("volumeIDs")
    public void setVolumeIDs(List<String> volumeIDs) {
        this.volumeIDs = volumeIDs;
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
