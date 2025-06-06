
package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

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
 * HorizontalPodAutoscalerStatus describes the current status of a horizontal pod autoscaler.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "currentMetrics",
    "currentReplicas",
    "desiredReplicas",
    "lastScaleTime",
    "observedGeneration"
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
public class HorizontalPodAutoscalerStatus implements Editable<HorizontalPodAutoscalerStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HorizontalPodAutoscalerCondition> conditions = new ArrayList<>();
    @JsonProperty("currentMetrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetricStatus> currentMetrics = new ArrayList<>();
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

    public HorizontalPodAutoscalerStatus(List<HorizontalPodAutoscalerCondition> conditions, List<MetricStatus> currentMetrics, Integer currentReplicas, Integer desiredReplicas, String lastScaleTime, Long observedGeneration) {
        super();
        this.conditions = conditions;
        this.currentMetrics = currentMetrics;
        this.currentReplicas = currentReplicas;
        this.desiredReplicas = desiredReplicas;
        this.lastScaleTime = lastScaleTime;
        this.observedGeneration = observedGeneration;
    }

    /**
     * conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or not those conditions are met.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HorizontalPodAutoscalerCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or not those conditions are met.
     */
    @JsonProperty("conditions")
    public void setConditions(List<HorizontalPodAutoscalerCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * currentMetrics is the last read state of the metrics used by this autoscaler.
     */
    @JsonProperty("currentMetrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetricStatus> getCurrentMetrics() {
        return currentMetrics;
    }

    /**
     * currentMetrics is the last read state of the metrics used by this autoscaler.
     */
    @JsonProperty("currentMetrics")
    public void setCurrentMetrics(List<MetricStatus> currentMetrics) {
        this.currentMetrics = currentMetrics;
    }

    /**
     * currentReplicas is current number of replicas of pods managed by this autoscaler, as last seen by the autoscaler.
     */
    @JsonProperty("currentReplicas")
    public Integer getCurrentReplicas() {
        return currentReplicas;
    }

    /**
     * currentReplicas is current number of replicas of pods managed by this autoscaler, as last seen by the autoscaler.
     */
    @JsonProperty("currentReplicas")
    public void setCurrentReplicas(Integer currentReplicas) {
        this.currentReplicas = currentReplicas;
    }

    /**
     * desiredReplicas is the desired number of replicas of pods managed by this autoscaler, as last calculated by the autoscaler.
     */
    @JsonProperty("desiredReplicas")
    public Integer getDesiredReplicas() {
        return desiredReplicas;
    }

    /**
     * desiredReplicas is the desired number of replicas of pods managed by this autoscaler, as last calculated by the autoscaler.
     */
    @JsonProperty("desiredReplicas")
    public void setDesiredReplicas(Integer desiredReplicas) {
        this.desiredReplicas = desiredReplicas;
    }

    /**
     * HorizontalPodAutoscalerStatus describes the current status of a horizontal pod autoscaler.
     */
    @JsonProperty("lastScaleTime")
    public String getLastScaleTime() {
        return lastScaleTime;
    }

    /**
     * HorizontalPodAutoscalerStatus describes the current status of a horizontal pod autoscaler.
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

}
