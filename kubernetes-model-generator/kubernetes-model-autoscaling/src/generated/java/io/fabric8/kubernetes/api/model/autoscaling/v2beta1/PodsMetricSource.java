
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
 * PodsMetricSource indicates how to scale on a metric describing each pod in the current scale target (for example, transactions-processed-per-second). The values will be averaged together before being compared to the target value.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metricName",
    "selector",
    "targetAverageValue"
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
public class PodsMetricSource implements Editable<PodsMetricSourceBuilder>, KubernetesResource
{

    @JsonProperty("metricName")
    private String metricName;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("targetAverageValue")
    private Quantity targetAverageValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodsMetricSource() {
    }

    public PodsMetricSource(String metricName, LabelSelector selector, Quantity targetAverageValue) {
        super();
        this.metricName = metricName;
        this.selector = selector;
        this.targetAverageValue = targetAverageValue;
    }

    /**
     * metricName is the name of the metric in question
     */
    @JsonProperty("metricName")
    public String getMetricName() {
        return metricName;
    }

    /**
     * metricName is the name of the metric in question
     */
    @JsonProperty("metricName")
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    /**
     * PodsMetricSource indicates how to scale on a metric describing each pod in the current scale target (for example, transactions-processed-per-second). The values will be averaged together before being compared to the target value.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * PodsMetricSource indicates how to scale on a metric describing each pod in the current scale target (for example, transactions-processed-per-second). The values will be averaged together before being compared to the target value.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * PodsMetricSource indicates how to scale on a metric describing each pod in the current scale target (for example, transactions-processed-per-second). The values will be averaged together before being compared to the target value.
     */
    @JsonProperty("targetAverageValue")
    public Quantity getTargetAverageValue() {
        return targetAverageValue;
    }

    /**
     * PodsMetricSource indicates how to scale on a metric describing each pod in the current scale target (for example, transactions-processed-per-second). The values will be averaged together before being compared to the target value.
     */
    @JsonProperty("targetAverageValue")
    public void setTargetAverageValue(Quantity targetAverageValue) {
        this.targetAverageValue = targetAverageValue;
    }

    @JsonIgnore
    public PodsMetricSourceBuilder edit() {
        return new PodsMetricSourceBuilder(this);
    }

    @JsonIgnore
    public PodsMetricSourceBuilder toBuilder() {
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
        if (!(o instanceof PodsMetricSource)) {
            return false;
        }
        PodsMetricSource other = (PodsMetricSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$metricName = this.getMetricName();
        Object other$metricName = other.getMetricName();
        if (this$metricName == null ? other$metricName != null : !this$metricName.equals(other$metricName)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$targetAverageValue = this.getTargetAverageValue();
        Object other$targetAverageValue = other.getTargetAverageValue();
        if (this$targetAverageValue == null ? other$targetAverageValue != null : !this$targetAverageValue.equals(other$targetAverageValue)) {
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
        return other instanceof PodsMetricSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $metricName = this.getMetricName();
        result = result * prime + ($metricName == null ? 43 : $metricName.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $targetAverageValue = this.getTargetAverageValue();
        result = result * prime + ($targetAverageValue == null ? 43 : $targetAverageValue.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodsMetricSource(" + "metricName=" + this.getMetricName() + ", selector=" + this.getSelector() + ", targetAverageValue=" + this.getTargetAverageValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
