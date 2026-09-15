
package io.fabric8.kubernetes.api.model.autoscaling.v1;

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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * current status of a horizontal pod autoscaler
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentCPUUtilizationPercentage",
    "currentReplicas",
    "desiredReplicas",
    "lastScaleTime",
    "observedGeneration"
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
public class HorizontalPodAutoscalerStatus implements Editable<HorizontalPodAutoscalerStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentCPUUtilizationPercentage")
    private Integer currentCPUUtilizationPercentage;
    @JsonProperty("currentReplicas")
    private Integer currentReplicas;
    @JsonProperty("desiredReplicas")
    private Integer desiredReplicas;
    @JsonProperty("lastScaleTime")
    private String lastScaleTime;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HorizontalPodAutoscalerStatus() {
    }

    public HorizontalPodAutoscalerStatus(Integer currentCPUUtilizationPercentage, Integer currentReplicas, Integer desiredReplicas, String lastScaleTime, Long observedGeneration) {
        super();
        this.currentCPUUtilizationPercentage = currentCPUUtilizationPercentage;
        this.currentReplicas = currentReplicas;
        this.desiredReplicas = desiredReplicas;
        this.lastScaleTime = lastScaleTime;
        this.observedGeneration = observedGeneration;
    }

    /**
     * currentCPUUtilizationPercentage is the current average CPU utilization over all pods, represented as a percentage of requested CPU, e.g. 70 means that an average pod is using now 70% of its requested CPU.
     */
    @JsonProperty("currentCPUUtilizationPercentage")
    public Integer getCurrentCPUUtilizationPercentage() {
        return currentCPUUtilizationPercentage;
    }

    /**
     * currentCPUUtilizationPercentage is the current average CPU utilization over all pods, represented as a percentage of requested CPU, e.g. 70 means that an average pod is using now 70% of its requested CPU.
     */
    @JsonProperty("currentCPUUtilizationPercentage")
    public void setCurrentCPUUtilizationPercentage(Integer currentCPUUtilizationPercentage) {
        this.currentCPUUtilizationPercentage = currentCPUUtilizationPercentage;
    }

    /**
     * currentReplicas is the current number of replicas of pods managed by this autoscaler.
     */
    @JsonProperty("currentReplicas")
    public Integer getCurrentReplicas() {
        return currentReplicas;
    }

    /**
     * currentReplicas is the current number of replicas of pods managed by this autoscaler.
     */
    @JsonProperty("currentReplicas")
    public void setCurrentReplicas(Integer currentReplicas) {
        this.currentReplicas = currentReplicas;
    }

    /**
     * desiredReplicas is the  desired number of replicas of pods managed by this autoscaler.
     */
    @JsonProperty("desiredReplicas")
    public Integer getDesiredReplicas() {
        return desiredReplicas;
    }

    /**
     * desiredReplicas is the  desired number of replicas of pods managed by this autoscaler.
     */
    @JsonProperty("desiredReplicas")
    public void setDesiredReplicas(Integer desiredReplicas) {
        this.desiredReplicas = desiredReplicas;
    }

    /**
     * current status of a horizontal pod autoscaler
     */
    @JsonProperty("lastScaleTime")
    public String getLastScaleTime() {
        return lastScaleTime;
    }

    /**
     * current status of a horizontal pod autoscaler
     */
    @JsonProperty("lastScaleTime")
    public void setLastScaleTime(String lastScaleTime) {
        this.lastScaleTime = lastScaleTime;
    }

    /**
     * observedGeneration is the most recent generation observed by this autoscaler.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the most recent generation observed by this autoscaler.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonIgnore
    public HorizontalPodAutoscalerStatusBuilder edit() {
        return new HorizontalPodAutoscalerStatusBuilder(this);
    }

    @JsonIgnore
    public HorizontalPodAutoscalerStatusBuilder toBuilder() {
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
        if (!(o instanceof HorizontalPodAutoscalerStatus)) {
            return false;
        }
        HorizontalPodAutoscalerStatus other = (HorizontalPodAutoscalerStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$currentCPUUtilizationPercentage = this.getCurrentCPUUtilizationPercentage();
        Object other$currentCPUUtilizationPercentage = other.getCurrentCPUUtilizationPercentage();
        if (this$currentCPUUtilizationPercentage == null ? other$currentCPUUtilizationPercentage != null : !this$currentCPUUtilizationPercentage.equals(other$currentCPUUtilizationPercentage)) {
            return false;
        }
        Object this$currentReplicas = this.getCurrentReplicas();
        Object other$currentReplicas = other.getCurrentReplicas();
        if (this$currentReplicas == null ? other$currentReplicas != null : !this$currentReplicas.equals(other$currentReplicas)) {
            return false;
        }
        Object this$desiredReplicas = this.getDesiredReplicas();
        Object other$desiredReplicas = other.getDesiredReplicas();
        if (this$desiredReplicas == null ? other$desiredReplicas != null : !this$desiredReplicas.equals(other$desiredReplicas)) {
            return false;
        }
        Object this$lastScaleTime = this.getLastScaleTime();
        Object other$lastScaleTime = other.getLastScaleTime();
        if (this$lastScaleTime == null ? other$lastScaleTime != null : !this$lastScaleTime.equals(other$lastScaleTime)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
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
        return other instanceof HorizontalPodAutoscalerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $currentCPUUtilizationPercentage = this.getCurrentCPUUtilizationPercentage();
        result = result * prime + ($currentCPUUtilizationPercentage == null ? 43 : $currentCPUUtilizationPercentage.hashCode());
        Object $currentReplicas = this.getCurrentReplicas();
        result = result * prime + ($currentReplicas == null ? 43 : $currentReplicas.hashCode());
        Object $desiredReplicas = this.getDesiredReplicas();
        result = result * prime + ($desiredReplicas == null ? 43 : $desiredReplicas.hashCode());
        Object $lastScaleTime = this.getLastScaleTime();
        result = result * prime + ($lastScaleTime == null ? 43 : $lastScaleTime.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HorizontalPodAutoscalerStatus(" + "currentCPUUtilizationPercentage=" + this.getCurrentCPUUtilizationPercentage() + ", currentReplicas=" + this.getCurrentReplicas() + ", desiredReplicas=" + this.getDesiredReplicas() + ", lastScaleTime=" + this.getLastScaleTime() + ", observedGeneration=" + this.getObservedGeneration() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
