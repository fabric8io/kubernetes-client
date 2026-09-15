
package io.fabric8.autoscaling.api.model.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * RecommendedContainerResources is the recommendation of resources computed by autoscaler for a specific container. Respects the container resource policy if present in the spec. In particular the recommendation is not produced for containers with `ContainerScalingMode` set to 'Off'.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "lowerBound",
    "target",
    "uncappedTarget",
    "upperBound"
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
public class RecommendedContainerResources implements Editable<RecommendedContainerResourcesBuilder>, KubernetesResource
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

    /**
     * Name of the container.
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * Name of the container.
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * Minimum recommended amount of resources. Observes ContainerResourcePolicy. This amount is not guaranteed to be sufficient for the application to operate in a stable way, however running with less resources is likely to have significant impact on performance/availability.
     */
    @JsonProperty("lowerBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getLowerBound() {
        return lowerBound;
    }

    /**
     * Minimum recommended amount of resources. Observes ContainerResourcePolicy. This amount is not guaranteed to be sufficient for the application to operate in a stable way, however running with less resources is likely to have significant impact on performance/availability.
     */
    @JsonProperty("lowerBound")
    public void setLowerBound(Map<String, Quantity> lowerBound) {
        this.lowerBound = lowerBound;
    }

    /**
     * Recommended amount of resources. Observes ContainerResourcePolicy.
     */
    @JsonProperty("target")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getTarget() {
        return target;
    }

    /**
     * Recommended amount of resources. Observes ContainerResourcePolicy.
     */
    @JsonProperty("target")
    public void setTarget(Map<String, Quantity> target) {
        this.target = target;
    }

    /**
     * The most recent recommended resources target computed by the autoscaler for the controlled pods, based only on actual resource usage, not taking into account the ContainerResourcePolicy. May differ from the Recommendation if the actual resource usage causes the target to violate the ContainerResourcePolicy (lower than MinAllowed or higher that MaxAllowed). Used only as status indication, will not affect actual resource assignment.
     */
    @JsonProperty("uncappedTarget")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getUncappedTarget() {
        return uncappedTarget;
    }

    /**
     * The most recent recommended resources target computed by the autoscaler for the controlled pods, based only on actual resource usage, not taking into account the ContainerResourcePolicy. May differ from the Recommendation if the actual resource usage causes the target to violate the ContainerResourcePolicy (lower than MinAllowed or higher that MaxAllowed). Used only as status indication, will not affect actual resource assignment.
     */
    @JsonProperty("uncappedTarget")
    public void setUncappedTarget(Map<String, Quantity> uncappedTarget) {
        this.uncappedTarget = uncappedTarget;
    }

    /**
     * Maximum recommended amount of resources. Observes ContainerResourcePolicy. Any resources allocated beyond this value are likely wasted. This value may be larger than the maximum amount of application is actually capable of consuming.
     */
    @JsonProperty("upperBound")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getUpperBound() {
        return upperBound;
    }

    /**
     * Maximum recommended amount of resources. Observes ContainerResourcePolicy. Any resources allocated beyond this value are likely wasted. This value may be larger than the maximum amount of application is actually capable of consuming.
     */
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
        if (!(o instanceof RecommendedContainerResources)) {
            return false;
        }
        RecommendedContainerResources other = (RecommendedContainerResources) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerName = this.getContainerName();
        Object other$containerName = other.getContainerName();
        if (this$containerName == null ? other$containerName != null : !this$containerName.equals(other$containerName)) {
            return false;
        }
        Object this$lowerBound = this.getLowerBound();
        Object other$lowerBound = other.getLowerBound();
        if (this$lowerBound == null ? other$lowerBound != null : !this$lowerBound.equals(other$lowerBound)) {
            return false;
        }
        Object this$target = this.getTarget();
        Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
            return false;
        }
        Object this$uncappedTarget = this.getUncappedTarget();
        Object other$uncappedTarget = other.getUncappedTarget();
        if (this$uncappedTarget == null ? other$uncappedTarget != null : !this$uncappedTarget.equals(other$uncappedTarget)) {
            return false;
        }
        Object this$upperBound = this.getUpperBound();
        Object other$upperBound = other.getUpperBound();
        if (this$upperBound == null ? other$upperBound != null : !this$upperBound.equals(other$upperBound)) {
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
        return other instanceof RecommendedContainerResources;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerName = this.getContainerName();
        result = result * prime + ($containerName == null ? 43 : $containerName.hashCode());
        Object $lowerBound = this.getLowerBound();
        result = result * prime + ($lowerBound == null ? 43 : $lowerBound.hashCode());
        Object $target = this.getTarget();
        result = result * prime + ($target == null ? 43 : $target.hashCode());
        Object $uncappedTarget = this.getUncappedTarget();
        result = result * prime + ($uncappedTarget == null ? 43 : $uncappedTarget.hashCode());
        Object $upperBound = this.getUpperBound();
        result = result * prime + ($upperBound == null ? 43 : $upperBound.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RecommendedContainerResources(" + "containerName=" + this.getContainerName() + ", lowerBound=" + this.getLowerBound() + ", target=" + this.getTarget() + ", uncappedTarget=" + this.getUncappedTarget() + ", upperBound=" + this.getUpperBound() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
