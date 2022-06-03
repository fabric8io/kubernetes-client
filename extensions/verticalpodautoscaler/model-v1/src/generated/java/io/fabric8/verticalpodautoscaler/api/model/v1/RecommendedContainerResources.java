
package io.fabric8.verticalpodautoscaler.api.model.v1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "containerName",
    "lowerBound",
    "target",
    "uncappedTarget",
    "upperBound"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class RecommendedContainerResources implements KubernetesResource
{

    @JsonProperty("containerName")
    private java.lang.String containerName;
    @JsonProperty("lowerBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> lowerBound = new LinkedHashMap<String, Quantity>();
    @JsonProperty("target")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> target = new LinkedHashMap<String, Quantity>();
    @JsonProperty("uncappedTarget")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> uncappedTarget = new LinkedHashMap<String, Quantity>();
    @JsonProperty("upperBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> upperBound = new LinkedHashMap<String, Quantity>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RecommendedContainerResources() {
    }

    /**
     * 
     * @param upperBound
     * @param containerName
     * @param uncappedTarget
     * @param lowerBound
     * @param target
     */
    public RecommendedContainerResources(java.lang.String containerName, Map<String, Quantity> lowerBound, Map<String, Quantity> target, Map<String, Quantity> uncappedTarget, Map<String, Quantity> upperBound) {
        super();
        this.containerName = containerName;
        this.lowerBound = lowerBound;
        this.target = target;
        this.uncappedTarget = uncappedTarget;
        this.upperBound = upperBound;
    }

    @JsonProperty("containerName")
    public java.lang.String getContainerName() {
        return containerName;
    }

    @JsonProperty("containerName")
    public void setContainerName(java.lang.String containerName) {
        this.containerName = containerName;
    }

    @JsonProperty("lowerBound")
    public Map<String, Quantity> getLowerBound() {
        return lowerBound;
    }

    @JsonProperty("lowerBound")
    public void setLowerBound(Map<String, Quantity> lowerBound) {
        this.lowerBound = lowerBound;
    }

    @JsonProperty("target")
    public Map<String, Quantity> getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(Map<String, Quantity> target) {
        this.target = target;
    }

    @JsonProperty("uncappedTarget")
    public Map<String, Quantity> getUncappedTarget() {
        return uncappedTarget;
    }

    @JsonProperty("uncappedTarget")
    public void setUncappedTarget(Map<String, Quantity> uncappedTarget) {
        this.uncappedTarget = uncappedTarget;
    }

    @JsonProperty("upperBound")
    public Map<String, Quantity> getUpperBound() {
        return upperBound;
    }

    @JsonProperty("upperBound")
    public void setUpperBound(Map<String, Quantity> upperBound) {
        this.upperBound = upperBound;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
