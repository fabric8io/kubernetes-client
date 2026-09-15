
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
 * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentAverageValue",
    "currentValue",
    "metricName",
    "metricSelector"
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
public class ExternalMetricStatus implements Editable<ExternalMetricStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentAverageValue")
    private Quantity currentAverageValue;
    @JsonProperty("currentValue")
    private Quantity currentValue;
    @JsonProperty("metricName")
    private String metricName;
    @JsonProperty("metricSelector")
    private LabelSelector metricSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExternalMetricStatus() {
    }

    public ExternalMetricStatus(Quantity currentAverageValue, Quantity currentValue, String metricName, LabelSelector metricSelector) {
        super();
        this.currentAverageValue = currentAverageValue;
        this.currentValue = currentValue;
        this.metricName = metricName;
        this.metricSelector = metricSelector;
    }

    /**
     * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
     */
    @JsonProperty("currentAverageValue")
    public Quantity getCurrentAverageValue() {
        return currentAverageValue;
    }

    /**
     * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
     */
    @JsonProperty("currentAverageValue")
    public void setCurrentAverageValue(Quantity currentAverageValue) {
        this.currentAverageValue = currentAverageValue;
    }

    /**
     * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
     */
    @JsonProperty("currentValue")
    public Quantity getCurrentValue() {
        return currentValue;
    }

    /**
     * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
     */
    @JsonProperty("currentValue")
    public void setCurrentValue(Quantity currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * metricName is the name of a metric used for autoscaling in metric system.
     */
    @JsonProperty("metricName")
    public String getMetricName() {
        return metricName;
    }

    /**
     * metricName is the name of a metric used for autoscaling in metric system.
     */
    @JsonProperty("metricName")
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    /**
     * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
     */
    @JsonProperty("metricSelector")
    public LabelSelector getMetricSelector() {
        return metricSelector;
    }

    /**
     * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
     */
    @JsonProperty("metricSelector")
    public void setMetricSelector(LabelSelector metricSelector) {
        this.metricSelector = metricSelector;
    }

    @JsonIgnore
    public ExternalMetricStatusBuilder edit() {
        return new ExternalMetricStatusBuilder(this);
    }

    @JsonIgnore
    public ExternalMetricStatusBuilder toBuilder() {
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
        if (!(o instanceof ExternalMetricStatus)) {
            return false;
        }
        ExternalMetricStatus other = (ExternalMetricStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$currentAverageValue = this.getCurrentAverageValue();
        Object other$currentAverageValue = other.getCurrentAverageValue();
        if (this$currentAverageValue == null ? other$currentAverageValue != null : !this$currentAverageValue.equals(other$currentAverageValue)) {
            return false;
        }
        Object this$currentValue = this.getCurrentValue();
        Object other$currentValue = other.getCurrentValue();
        if (this$currentValue == null ? other$currentValue != null : !this$currentValue.equals(other$currentValue)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ExternalMetricStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $currentAverageValue = this.getCurrentAverageValue();
        result = result * prime + ($currentAverageValue == null ? 43 : $currentAverageValue.hashCode());
        Object $currentValue = this.getCurrentValue();
        result = result * prime + ($currentValue == null ? 43 : $currentValue.hashCode());
        Object $metricName = this.getMetricName();
        result = result * prime + ($metricName == null ? 43 : $metricName.hashCode());
        Object $metricSelector = this.getMetricSelector();
        result = result * prime + ($metricSelector == null ? 43 : $metricSelector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExternalMetricStatus(" + "currentAverageValue=" + this.getCurrentAverageValue() + ", currentValue=" + this.getCurrentValue() + ", metricName=" + this.getMetricName() + ", metricSelector=" + this.getMetricSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
