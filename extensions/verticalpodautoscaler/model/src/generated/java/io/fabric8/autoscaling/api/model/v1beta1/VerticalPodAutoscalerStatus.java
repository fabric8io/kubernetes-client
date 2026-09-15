
package io.fabric8.autoscaling.api.model.v1beta1;

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

/**
 * VerticalPodAutoscalerStatus describes the runtime state of the autoscaler.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "recommendation"
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
public class VerticalPodAutoscalerStatus implements Editable<VerticalPodAutoscalerStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VerticalPodAutoscalerCondition> conditions = new ArrayList<>();
    @JsonProperty("recommendation")
    private RecommendedPodResources recommendation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VerticalPodAutoscalerStatus() {
    }

    public VerticalPodAutoscalerStatus(List<VerticalPodAutoscalerCondition> conditions, RecommendedPodResources recommendation) {
        super();
        this.conditions = conditions;
        this.recommendation = recommendation;
    }

    /**
     * Conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or not those conditions are met.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VerticalPodAutoscalerCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or not those conditions are met.
     */
    @JsonProperty("conditions")
    public void setConditions(List<VerticalPodAutoscalerCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * VerticalPodAutoscalerStatus describes the runtime state of the autoscaler.
     */
    @JsonProperty("recommendation")
    public RecommendedPodResources getRecommendation() {
        return recommendation;
    }

    /**
     * VerticalPodAutoscalerStatus describes the runtime state of the autoscaler.
     */
    @JsonProperty("recommendation")
    public void setRecommendation(RecommendedPodResources recommendation) {
        this.recommendation = recommendation;
    }

    @JsonIgnore
    public VerticalPodAutoscalerStatusBuilder edit() {
        return new VerticalPodAutoscalerStatusBuilder(this);
    }

    @JsonIgnore
    public VerticalPodAutoscalerStatusBuilder toBuilder() {
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
        if (!(o instanceof VerticalPodAutoscalerStatus)) {
            return false;
        }
        VerticalPodAutoscalerStatus other = (VerticalPodAutoscalerStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$recommendation = this.getRecommendation();
        Object other$recommendation = other.getRecommendation();
        if (this$recommendation == null ? other$recommendation != null : !this$recommendation.equals(other$recommendation)) {
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
        return other instanceof VerticalPodAutoscalerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $recommendation = this.getRecommendation();
        result = result * prime + ($recommendation == null ? 43 : $recommendation.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VerticalPodAutoscalerStatus(" + "conditions=" + this.getConditions() + ", recommendation=" + this.getRecommendation() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
