
package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

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
    "behavior",
    "maxReplicas",
    "metrics",
    "minReplicas",
    "scaleTargetRef"
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
public class HorizontalPodAutoscalerSpec implements KubernetesResource
{

    @JsonProperty("behavior")
    private HorizontalPodAutoscalerBehavior behavior;
    @JsonProperty("maxReplicas")
    private Integer maxReplicas;
    @JsonProperty("metrics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MetricSpec> metrics = new ArrayList<MetricSpec>();
    @JsonProperty("minReplicas")
    private Integer minReplicas;
    @JsonProperty("scaleTargetRef")
    private CrossVersionObjectReference scaleTargetRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HorizontalPodAutoscalerSpec() {
    }

    public HorizontalPodAutoscalerSpec(HorizontalPodAutoscalerBehavior behavior, Integer maxReplicas, List<MetricSpec> metrics, Integer minReplicas, CrossVersionObjectReference scaleTargetRef) {
        super();
        this.behavior = behavior;
        this.maxReplicas = maxReplicas;
        this.metrics = metrics;
        this.minReplicas = minReplicas;
        this.scaleTargetRef = scaleTargetRef;
    }

    @JsonProperty("behavior")
    public HorizontalPodAutoscalerBehavior getBehavior() {
        return behavior;
    }

    @JsonProperty("behavior")
    public void setBehavior(HorizontalPodAutoscalerBehavior behavior) {
        this.behavior = behavior;
    }

    @JsonProperty("maxReplicas")
    public Integer getMaxReplicas() {
        return maxReplicas;
    }

    @JsonProperty("maxReplicas")
    public void setMaxReplicas(Integer maxReplicas) {
        this.maxReplicas = maxReplicas;
    }

    @JsonProperty("metrics")
    public List<MetricSpec> getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(List<MetricSpec> metrics) {
        this.metrics = metrics;
    }

    @JsonProperty("minReplicas")
    public Integer getMinReplicas() {
        return minReplicas;
    }

    @JsonProperty("minReplicas")
    public void setMinReplicas(Integer minReplicas) {
        this.minReplicas = minReplicas;
    }

    @JsonProperty("scaleTargetRef")
    public CrossVersionObjectReference getScaleTargetRef() {
        return scaleTargetRef;
    }

    @JsonProperty("scaleTargetRef")
    public void setScaleTargetRef(CrossVersionObjectReference scaleTargetRef) {
        this.scaleTargetRef = scaleTargetRef;
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
