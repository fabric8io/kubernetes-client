
package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

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
 * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type should be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metricName",
    "metricSelector",
    "targetAverageValue",
    "targetValue"
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
public class ExternalMetricSource implements Editable<ExternalMetricSourceBuilder>, KubernetesResource
{

    @JsonProperty("metricName")
    private String metricName;
    @JsonProperty("metricSelector")
    private LabelSelector metricSelector;
    @JsonProperty("targetAverageValue")
    private Quantity targetAverageValue;
    @JsonProperty("targetValue")
    private Quantity targetValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExternalMetricSource() {
    }

    public ExternalMetricSource(String metricName, LabelSelector metricSelector, Quantity targetAverageValue, Quantity targetValue) {
        super();
        this.metricName = metricName;
        this.metricSelector = metricSelector;
        this.targetAverageValue = targetAverageValue;
        this.targetValue = targetValue;
    }

    /**
     * metricName is the name of the metric in question.
     */
    @JsonProperty("metricName")
    public String getMetricName() {
        return metricName;
    }

    /**
     * metricName is the name of the metric in question.
     */
    @JsonProperty("metricName")
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    /**
     * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type should be set.
     */
    @JsonProperty("metricSelector")
    public LabelSelector getMetricSelector() {
        return metricSelector;
    }

    /**
     * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type should be set.
     */
    @JsonProperty("metricSelector")
    public void setMetricSelector(LabelSelector metricSelector) {
        this.metricSelector = metricSelector;
    }

    /**
     * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type should be set.
     */
    @JsonProperty("targetAverageValue")
    public Quantity getTargetAverageValue() {
        return targetAverageValue;
    }

    /**
     * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type should be set.
     */
    @JsonProperty("targetAverageValue")
    public void setTargetAverageValue(Quantity targetAverageValue) {
        this.targetAverageValue = targetAverageValue;
    }

    /**
     * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type should be set.
     */
    @JsonProperty("targetValue")
    public Quantity getTargetValue() {
        return targetValue;
    }

    /**
     * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type should be set.
     */
    @JsonProperty("targetValue")
    public void setTargetValue(Quantity targetValue) {
        this.targetValue = targetValue;
    }

    @JsonIgnore
    public ExternalMetricSourceBuilder edit() {
        return new ExternalMetricSourceBuilder(this);
    }

    @JsonIgnore
    public ExternalMetricSourceBuilder toBuilder() {
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
        if (!(o instanceof ExternalMetricSource)) {
            return false;
        }
        ExternalMetricSource other = (ExternalMetricSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$metricName = this.getMetricName();
        Object other$metricName = other.getMetricName();
        if (this$metricName == null ? other$metricName != null : !this$metricName.equals(other$metricName)) {
            return false;
        }
        Object this$metricSelector = this.getMetricSelector();
        Object other$metricSelector = other.getMetricSelector();
        if (this$metricSelector == null ? other$metricSelector != null : !this$metricSelector.equals(other$metricSelector)) {
            return false;
        }
        Object this$targetAverageValue = this.getTargetAverageValue();
        Object other$targetAverageValue = other.getTargetAverageValue();
        if (this$targetAverageValue == null ? other$targetAverageValue != null : !this$targetAverageValue.equals(other$targetAverageValue)) {
            return false;
        }
        Object this$targetValue = this.getTargetValue();
        Object other$targetValue = other.getTargetValue();
        if (this$targetValue == null ? other$targetValue != null : !this$targetValue.equals(other$targetValue)) {
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
        return other instanceof ExternalMetricSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $metricName = this.getMetricName();
        result = result * prime + ($metricName == null ? 43 : $metricName.hashCode());
        Object $metricSelector = this.getMetricSelector();
        result = result * prime + ($metricSelector == null ? 43 : $metricSelector.hashCode());
        Object $targetAverageValue = this.getTargetAverageValue();
        result = result * prime + ($targetAverageValue == null ? 43 : $targetAverageValue.hashCode());
        Object $targetValue = this.getTargetValue();
        result = result * prime + ($targetValue == null ? 43 : $targetValue.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExternalMetricSource(" + "metricName=" + this.getMetricName() + ", metricSelector=" + this.getMetricSelector() + ", targetAverageValue=" + this.getTargetAverageValue() + ", targetValue=" + this.getTargetValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
