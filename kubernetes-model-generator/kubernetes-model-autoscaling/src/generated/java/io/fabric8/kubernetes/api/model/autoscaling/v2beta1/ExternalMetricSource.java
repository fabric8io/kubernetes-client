
package io.fabric8.kubernetes.api.model.autoscaling.v2beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
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
    "metricName",
    "metricSelector",
    "targetAverageValue",
    "targetValue"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ExternalMetricSource implements KubernetesResource
{

    @JsonProperty("metricName")
    private String metricName;
    @JsonProperty("metricSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector metricSelector;
    @JsonProperty("targetAverageValue")
    private Quantity targetAverageValue;
    @JsonProperty("targetValue")
    private Quantity targetValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExternalMetricSource() {
    }

    public ExternalMetricSource(String metricName, io.fabric8.kubernetes.api.model.LabelSelector metricSelector, Quantity targetAverageValue, Quantity targetValue) {
        super();
        this.metricName = metricName;
        this.metricSelector = metricSelector;
        this.targetAverageValue = targetAverageValue;
        this.targetValue = targetValue;
    }

    @JsonProperty("metricName")
    public String getMetricName() {
        return metricName;
    }

    @JsonProperty("metricName")
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    @JsonProperty("metricSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getMetricSelector() {
        return metricSelector;
    }

    @JsonProperty("metricSelector")
    public void setMetricSelector(io.fabric8.kubernetes.api.model.LabelSelector metricSelector) {
        this.metricSelector = metricSelector;
    }

    @JsonProperty("targetAverageValue")
    public Quantity getTargetAverageValue() {
        return targetAverageValue;
    }

    @JsonProperty("targetAverageValue")
    public void setTargetAverageValue(Quantity targetAverageValue) {
        this.targetAverageValue = targetAverageValue;
    }

    @JsonProperty("targetValue")
    public Quantity getTargetValue() {
        return targetValue;
    }

    @JsonProperty("targetValue")
    public void setTargetValue(Quantity targetValue) {
        this.targetValue = targetValue;
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
