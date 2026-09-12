
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
 * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "averageValue",
    "metricName",
    "selector",
    "target",
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
public class ObjectMetricSource implements Editable<ObjectMetricSourceBuilder>, KubernetesResource
{

    @JsonProperty("averageValue")
    private Quantity averageValue;
    @JsonProperty("metricName")
    private String metricName;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("target")
    private CrossVersionObjectReference target;
    @JsonProperty("targetValue")
    private Quantity targetValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ObjectMetricSource() {
    }

    public ObjectMetricSource(Quantity averageValue, String metricName, LabelSelector selector, CrossVersionObjectReference target, Quantity targetValue) {
        super();
        this.averageValue = averageValue;
        this.metricName = metricName;
        this.selector = selector;
        this.target = target;
        this.targetValue = targetValue;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("averageValue")
    public Quantity getAverageValue() {
        return averageValue;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("averageValue")
    public void setAverageValue(Quantity averageValue) {
        this.averageValue = averageValue;
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
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("target")
    public CrossVersionObjectReference getTarget() {
        return target;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("target")
    public void setTarget(CrossVersionObjectReference target) {
        this.target = target;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("targetValue")
    public Quantity getTargetValue() {
        return targetValue;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("targetValue")
    public void setTargetValue(Quantity targetValue) {
        this.targetValue = targetValue;
    }

    @JsonIgnore
    public ObjectMetricSourceBuilder edit() {
        return new ObjectMetricSourceBuilder(this);
    }

    @JsonIgnore
    public ObjectMetricSourceBuilder toBuilder() {
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
        if (!(o instanceof ObjectMetricSource)) {
            return false;
        }
        ObjectMetricSource other = (ObjectMetricSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$averageValue = this.getAverageValue();
        Object other$averageValue = other.getAverageValue();
        if (this$averageValue == null ? other$averageValue != null : !this$averageValue.equals(other$averageValue)) {
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
        Object this$target = this.getTarget();
        Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
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
        return other instanceof ObjectMetricSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $averageValue = this.getAverageValue();
        result = result * prime + ($averageValue == null ? 43 : $averageValue.hashCode());
        Object $metricName = this.getMetricName();
        result = result * prime + ($metricName == null ? 43 : $metricName.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $target = this.getTarget();
        result = result * prime + ($target == null ? 43 : $target.hashCode());
        Object $targetValue = this.getTargetValue();
        result = result * prime + ($targetValue == null ? 43 : $targetValue.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ObjectMetricSource(" + "averageValue=" + this.getAverageValue() + ", metricName=" + this.getMetricName() + ", selector=" + this.getSelector() + ", target=" + this.getTarget() + ", targetValue=" + this.getTargetValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
