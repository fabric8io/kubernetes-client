
package io.fabric8.openshift.api.model.clusterautoscaling.v1;

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
    "cores",
    "gpus",
    "maxNodesTotal",
    "memory"
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
public class ResourceLimits implements KubernetesResource
{

    @JsonProperty("cores")
    private ResourceRange cores;
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GPULimit> gpus = new ArrayList<GPULimit>();
    @JsonProperty("maxNodesTotal")
    private Integer maxNodesTotal;
    @JsonProperty("memory")
    private ResourceRange memory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResourceLimits() {
    }

    public ResourceLimits(ResourceRange cores, List<GPULimit> gpus, Integer maxNodesTotal, ResourceRange memory) {
        super();
        this.cores = cores;
        this.gpus = gpus;
        this.maxNodesTotal = maxNodesTotal;
        this.memory = memory;
    }

    @JsonProperty("cores")
    public ResourceRange getCores() {
        return cores;
    }

    @JsonProperty("cores")
    public void setCores(ResourceRange cores) {
        this.cores = cores;
    }

    @JsonProperty("gpus")
    public List<GPULimit> getGpus() {
        return gpus;
    }

    @JsonProperty("gpus")
    public void setGpus(List<GPULimit> gpus) {
        this.gpus = gpus;
    }

    @JsonProperty("maxNodesTotal")
    public Integer getMaxNodesTotal() {
        return maxNodesTotal;
    }

    @JsonProperty("maxNodesTotal")
    public void setMaxNodesTotal(Integer maxNodesTotal) {
        this.maxNodesTotal = maxNodesTotal;
    }

    @JsonProperty("memory")
    public ResourceRange getMemory() {
        return memory;
    }

    @JsonProperty("memory")
    public void setMemory(ResourceRange memory) {
        this.memory = memory;
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
