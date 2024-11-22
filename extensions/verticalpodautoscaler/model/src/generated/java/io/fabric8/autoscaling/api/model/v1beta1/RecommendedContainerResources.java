
package io.fabric8.autoscaling.api.model.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "lowerBound",
    "target",
    "uncappedTarget",
    "upperBound"
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
public class RecommendedContainerResources implements Editable<RecommendedContainerResourcesBuilder> , KubernetesResource
{

    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("lowerBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> lowerBound = new LinkedHashMap<>();
    @JsonProperty("target")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> target = new LinkedHashMap<>();
    @JsonProperty("uncappedTarget")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> uncappedTarget = new LinkedHashMap<>();
    @JsonProperty("upperBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> upperBound = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RecommendedContainerResources() {
    }

    public RecommendedContainerResources(String containerName, Map<String, Quantity> lowerBound, Map<String, Quantity> target, Map<String, Quantity> uncappedTarget, Map<String, Quantity> upperBound) {
        super();
        this.containerName = containerName;
        this.lowerBound = lowerBound;
        this.target = target;
        this.uncappedTarget = uncappedTarget;
        this.upperBound = upperBound;
    }

    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    @JsonProperty("lowerBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getLowerBound() {
        return lowerBound;
    }

    @JsonProperty("lowerBound")
    public void setLowerBound(Map<String, Quantity> lowerBound) {
        this.lowerBound = lowerBound;
    }

    @JsonProperty("target")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(Map<String, Quantity> target) {
        this.target = target;
    }

    @JsonProperty("uncappedTarget")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getUncappedTarget() {
        return uncappedTarget;
    }

    @JsonProperty("uncappedTarget")
    public void setUncappedTarget(Map<String, Quantity> uncappedTarget) {
        this.uncappedTarget = uncappedTarget;
    }

    @JsonProperty("upperBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getUpperBound() {
        return upperBound;
    }

    @JsonProperty("upperBound")
    public void setUpperBound(Map<String, Quantity> upperBound) {
        this.upperBound = upperBound;
    }

    @JsonIgnore
    public RecommendedContainerResourcesBuilder edit() {
        return new RecommendedContainerResourcesBuilder(this);
    }

    @JsonIgnore
    public RecommendedContainerResourcesBuilder toBuilder() {
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
