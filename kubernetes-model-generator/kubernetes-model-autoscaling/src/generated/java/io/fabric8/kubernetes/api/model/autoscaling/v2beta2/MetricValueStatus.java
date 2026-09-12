
package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

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
 * MetricValueStatus holds the current value for a metric
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "averageUtilization",
    "averageValue",
    "value"
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
public class MetricValueStatus implements Editable<MetricValueStatusBuilder>, KubernetesResource
{

    @JsonProperty("averageUtilization")
    private Integer averageUtilization;
    @JsonProperty("averageValue")
    private Quantity averageValue;
    @JsonProperty("value")
    private Quantity value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetricValueStatus() {
    }

    public MetricValueStatus(Integer averageUtilization, Quantity averageValue, Quantity value) {
        super();
        this.averageUtilization = averageUtilization;
        this.averageValue = averageValue;
        this.value = value;
    }

    /**
     * currentAverageUtilization is the current value of the average of the resource metric across all relevant pods, represented as a percentage of the requested value of the resource for the pods.
     */
    @JsonProperty("averageUtilization")
    public Integer getAverageUtilization() {
        return averageUtilization;
    }

    /**
     * currentAverageUtilization is the current value of the average of the resource metric across all relevant pods, represented as a percentage of the requested value of the resource for the pods.
     */
    @JsonProperty("averageUtilization")
    public void setAverageUtilization(Integer averageUtilization) {
        this.averageUtilization = averageUtilization;
    }

    /**
     * MetricValueStatus holds the current value for a metric
     */
    @JsonProperty("averageValue")
    public Quantity getAverageValue() {
        return averageValue;
    }

    /**
     * MetricValueStatus holds the current value for a metric
     */
    @JsonProperty("averageValue")
    public void setAverageValue(Quantity averageValue) {
        this.averageValue = averageValue;
    }

    /**
     * MetricValueStatus holds the current value for a metric
     */
    @JsonProperty("value")
    public Quantity getValue() {
        return value;
    }

    /**
     * MetricValueStatus holds the current value for a metric
     */
    @JsonProperty("value")
    public void setValue(Quantity value) {
        this.value = value;
    }

    @JsonIgnore
    public MetricValueStatusBuilder edit() {
        return new MetricValueStatusBuilder(this);
    }

    @JsonIgnore
    public MetricValueStatusBuilder toBuilder() {
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
        if (!(o instanceof MetricValueStatus)) {
            return false;
        }
        MetricValueStatus other = (MetricValueStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$averageUtilization = this.getAverageUtilization();
        Object other$averageUtilization = other.getAverageUtilization();
        if (this$averageUtilization == null ? other$averageUtilization != null : !this$averageUtilization.equals(other$averageUtilization)) {
            return false;
        }
        Object this$averageValue = this.getAverageValue();
        Object other$averageValue = other.getAverageValue();
        if (this$averageValue == null ? other$averageValue != null : !this$averageValue.equals(other$averageValue)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof MetricValueStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $averageUtilization = this.getAverageUtilization();
        result = result * prime + ($averageUtilization == null ? 43 : $averageUtilization.hashCode());
        Object $averageValue = this.getAverageValue();
        result = result * prime + ($averageValue == null ? 43 : $averageValue.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetricValueStatus(" + "averageUtilization=" + this.getAverageUtilization() + ", averageValue=" + this.getAverageValue() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
