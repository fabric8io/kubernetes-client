
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

/**
 * HorizontalPodAutoscalerSpec describes the desired functionality of the HorizontalPodAutoscaler.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxReplicas",
    "metrics",
    "minReplicas",
    "scaleTargetRef"
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
public class HorizontalPodAutoscalerSpec implements Editable<HorizontalPodAutoscalerSpecBuilder>, KubernetesResource
{

    @JsonProperty("maxReplicas")
    private Integer maxReplicas;
    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetricSpec> metrics = new ArrayList<>();
    @JsonProperty("minReplicas")
    private Integer minReplicas;
    @JsonProperty("scaleTargetRef")
    private CrossVersionObjectReference scaleTargetRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HorizontalPodAutoscalerSpec() {
    }

    public HorizontalPodAutoscalerSpec(Integer maxReplicas, List<MetricSpec> metrics, Integer minReplicas, CrossVersionObjectReference scaleTargetRef) {
        super();
        this.maxReplicas = maxReplicas;
        this.metrics = metrics;
        this.minReplicas = minReplicas;
        this.scaleTargetRef = scaleTargetRef;
    }

    /**
     * maxReplicas is the upper limit for the number of replicas to which the autoscaler can scale up. It cannot be less that minReplicas.
     */
    @JsonProperty("maxReplicas")
    public Integer getMaxReplicas() {
        return maxReplicas;
    }

    /**
     * maxReplicas is the upper limit for the number of replicas to which the autoscaler can scale up. It cannot be less that minReplicas.
     */
    @JsonProperty("maxReplicas")
    public void setMaxReplicas(Integer maxReplicas) {
        this.maxReplicas = maxReplicas;
    }

    /**
     * metrics contains the specifications for which to use to calculate the desired replica count (the maximum replica count across all metrics will be used).  The desired replica count is calculated multiplying the ratio between the target value and the current value by the current number of pods.  Ergo, metrics used must decrease as the pod count is increased, and vice-versa.  See the individual metric source types for more information about how each type of metric must respond.
     */
    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MetricSpec> getMetrics() {
        return metrics;
    }

    /**
     * metrics contains the specifications for which to use to calculate the desired replica count (the maximum replica count across all metrics will be used).  The desired replica count is calculated multiplying the ratio between the target value and the current value by the current number of pods.  Ergo, metrics used must decrease as the pod count is increased, and vice-versa.  See the individual metric source types for more information about how each type of metric must respond.
     */
    @JsonProperty("metrics")
    public void setMetrics(List<MetricSpec> metrics) {
        this.metrics = metrics;
    }

    /**
     * minReplicas is the lower limit for the number of replicas to which the autoscaler can scale down.  It defaults to 1 pod.  minReplicas is allowed to be 0 if the alpha feature gate HPAScaleToZero is enabled and at least one Object or External metric is configured.  Scaling is active as long as at least one metric value is available.
     */
    @JsonProperty("minReplicas")
    public Integer getMinReplicas() {
        return minReplicas;
    }

    /**
     * minReplicas is the lower limit for the number of replicas to which the autoscaler can scale down.  It defaults to 1 pod.  minReplicas is allowed to be 0 if the alpha feature gate HPAScaleToZero is enabled and at least one Object or External metric is configured.  Scaling is active as long as at least one metric value is available.
     */
    @JsonProperty("minReplicas")
    public void setMinReplicas(Integer minReplicas) {
        this.minReplicas = minReplicas;
    }

    /**
     * HorizontalPodAutoscalerSpec describes the desired functionality of the HorizontalPodAutoscaler.
     */
    @JsonProperty("scaleTargetRef")
    public CrossVersionObjectReference getScaleTargetRef() {
        return scaleTargetRef;
    }

    /**
     * HorizontalPodAutoscalerSpec describes the desired functionality of the HorizontalPodAutoscaler.
     */
    @JsonProperty("scaleTargetRef")
    public void setScaleTargetRef(CrossVersionObjectReference scaleTargetRef) {
        this.scaleTargetRef = scaleTargetRef;
    }

    @JsonIgnore
    public HorizontalPodAutoscalerSpecBuilder edit() {
        return new HorizontalPodAutoscalerSpecBuilder(this);
    }

    @JsonIgnore
    public HorizontalPodAutoscalerSpecBuilder toBuilder() {
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
        if (!(o instanceof HorizontalPodAutoscalerSpec)) {
            return false;
        }
        HorizontalPodAutoscalerSpec other = (HorizontalPodAutoscalerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxReplicas = this.getMaxReplicas();
        Object other$maxReplicas = other.getMaxReplicas();
        if (this$maxReplicas == null ? other$maxReplicas != null : !this$maxReplicas.equals(other$maxReplicas)) {
            return false;
        }
        Object this$metrics = this.getMetrics();
        Object other$metrics = other.getMetrics();
        if (this$metrics == null ? other$metrics != null : !this$metrics.equals(other$metrics)) {
            return false;
        }
        Object this$minReplicas = this.getMinReplicas();
        Object other$minReplicas = other.getMinReplicas();
        if (this$minReplicas == null ? other$minReplicas != null : !this$minReplicas.equals(other$minReplicas)) {
            return false;
        }
        Object this$scaleTargetRef = this.getScaleTargetRef();
        Object other$scaleTargetRef = other.getScaleTargetRef();
        if (this$scaleTargetRef == null ? other$scaleTargetRef != null : !this$scaleTargetRef.equals(other$scaleTargetRef)) {
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
        return other instanceof HorizontalPodAutoscalerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxReplicas = this.getMaxReplicas();
        result = result * prime + ($maxReplicas == null ? 43 : $maxReplicas.hashCode());
        Object $metrics = this.getMetrics();
        result = result * prime + ($metrics == null ? 43 : $metrics.hashCode());
        Object $minReplicas = this.getMinReplicas();
        result = result * prime + ($minReplicas == null ? 43 : $minReplicas.hashCode());
        Object $scaleTargetRef = this.getScaleTargetRef();
        result = result * prime + ($scaleTargetRef == null ? 43 : $scaleTargetRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HorizontalPodAutoscalerSpec(" + "maxReplicas=" + this.getMaxReplicas() + ", metrics=" + this.getMetrics() + ", minReplicas=" + this.getMinReplicas() + ", scaleTargetRef=" + this.getScaleTargetRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
