
package io.fabric8.chaosmesh.v1alpha1;

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
 * MemoryStressor defines how to stress memory out
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "oomScoreAdj",
    "options",
    "size",
    "workers"
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
public class MemoryStressor implements Editable<MemoryStressorBuilder>, KubernetesResource
{

    @JsonProperty("oomScoreAdj")
    private Integer oomScoreAdj;
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> options = new ArrayList<>();
    @JsonProperty("size")
    private String size;
    @JsonProperty("workers")
    private Integer workers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MemoryStressor() {
    }

    public MemoryStressor(Integer oomScoreAdj, List<String> options, String size, Integer workers) {
        super();
        this.oomScoreAdj = oomScoreAdj;
        this.options = options;
        this.size = size;
        this.workers = workers;
    }

    /**
     * OOMScoreAdj sets the oom_score_adj of the stress process. See `man 5 proc` to know more about this option.
     */
    @JsonProperty("oomScoreAdj")
    public Integer getOomScoreAdj() {
        return oomScoreAdj;
    }

    /**
     * OOMScoreAdj sets the oom_score_adj of the stress process. See `man 5 proc` to know more about this option.
     */
    @JsonProperty("oomScoreAdj")
    public void setOomScoreAdj(Integer oomScoreAdj) {
        this.oomScoreAdj = oomScoreAdj;
    }

    /**
     * extend stress-ng options
     */
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOptions() {
        return options;
    }

    /**
     * extend stress-ng options
     */
    @JsonProperty("options")
    public void setOptions(List<String> options) {
        this.options = options;
    }

    /**
     * Size specifies N bytes consumed per vm worker, default is the total available memory. One can specify the size as % of total available memory or in units of B, KB/KiB, MB/MiB, GB/GiB, TB/TiB.
     */
    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    /**
     * Size specifies N bytes consumed per vm worker, default is the total available memory. One can specify the size as % of total available memory or in units of B, KB/KiB, MB/MiB, GB/GiB, TB/TiB.
     */
    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Workers specifies N workers to apply the stressor. Maximum 8192 workers can run by stress-ng
     */
    @JsonProperty("workers")
    public Integer getWorkers() {
        return workers;
    }

    /**
     * Workers specifies N workers to apply the stressor. Maximum 8192 workers can run by stress-ng
     */
    @JsonProperty("workers")
    public void setWorkers(Integer workers) {
        this.workers = workers;
    }

    @JsonIgnore
    public MemoryStressorBuilder edit() {
        return new MemoryStressorBuilder(this);
    }

    @JsonIgnore
    public MemoryStressorBuilder toBuilder() {
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
