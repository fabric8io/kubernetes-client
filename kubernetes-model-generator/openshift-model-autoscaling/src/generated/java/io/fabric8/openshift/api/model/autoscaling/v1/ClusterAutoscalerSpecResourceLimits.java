
package io.fabric8.openshift.api.model.autoscaling.v1;

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
 * Constraints of autoscaling resources
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cores",
    "gpus",
    "maxNodesTotal",
    "memory"
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
public class ClusterAutoscalerSpecResourceLimits implements Editable<ClusterAutoscalerSpecResourceLimitsBuilder>, KubernetesResource
{

    @JsonProperty("cores")
    private ClusterAutoscalerSpecRLCores cores;
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterAutoscalerSpecRLGpus> gpus = new ArrayList<>();
    @JsonProperty("maxNodesTotal")
    private Integer maxNodesTotal;
    @JsonProperty("memory")
    private ClusterAutoscalerSpecRLMemory memory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAutoscalerSpecResourceLimits() {
    }

    public ClusterAutoscalerSpecResourceLimits(ClusterAutoscalerSpecRLCores cores, List<ClusterAutoscalerSpecRLGpus> gpus, Integer maxNodesTotal, ClusterAutoscalerSpecRLMemory memory) {
        super();
        this.cores = cores;
        this.gpus = gpus;
        this.maxNodesTotal = maxNodesTotal;
        this.memory = memory;
    }

    /**
     * Constraints of autoscaling resources
     */
    @JsonProperty("cores")
    public ClusterAutoscalerSpecRLCores getCores() {
        return cores;
    }

    /**
     * Constraints of autoscaling resources
     */
    @JsonProperty("cores")
    public void setCores(ClusterAutoscalerSpecRLCores cores) {
        this.cores = cores;
    }

    /**
     * Minimum and maximum number of different GPUs in cluster, in the format &lt;gpu_type&gt;:&lt;min&gt;:&lt;max&gt;.<br><p> Cluster autoscaler will not scale the cluster beyond these numbers. Can be passed multiple times.
     */
    @JsonProperty("gpus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterAutoscalerSpecRLGpus> getGpus() {
        return gpus;
    }

    /**
     * Minimum and maximum number of different GPUs in cluster, in the format &lt;gpu_type&gt;:&lt;min&gt;:&lt;max&gt;.<br><p> Cluster autoscaler will not scale the cluster beyond these numbers. Can be passed multiple times.
     */
    @JsonProperty("gpus")
    public void setGpus(List<ClusterAutoscalerSpecRLGpus> gpus) {
        this.gpus = gpus;
    }

    /**
     * Maximum number of nodes in all node groups.<br><p> Cluster autoscaler will not grow the cluster beyond this number.
     */
    @JsonProperty("maxNodesTotal")
    public Integer getMaxNodesTotal() {
        return maxNodesTotal;
    }

    /**
     * Maximum number of nodes in all node groups.<br><p> Cluster autoscaler will not grow the cluster beyond this number.
     */
    @JsonProperty("maxNodesTotal")
    public void setMaxNodesTotal(Integer maxNodesTotal) {
        this.maxNodesTotal = maxNodesTotal;
    }

    /**
     * Constraints of autoscaling resources
     */
    @JsonProperty("memory")
    public ClusterAutoscalerSpecRLMemory getMemory() {
        return memory;
    }

    /**
     * Constraints of autoscaling resources
     */
    @JsonProperty("memory")
    public void setMemory(ClusterAutoscalerSpecRLMemory memory) {
        this.memory = memory;
    }

    @JsonIgnore
    public ClusterAutoscalerSpecResourceLimitsBuilder edit() {
        return new ClusterAutoscalerSpecResourceLimitsBuilder(this);
    }

    @JsonIgnore
    public ClusterAutoscalerSpecResourceLimitsBuilder toBuilder() {
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

}
