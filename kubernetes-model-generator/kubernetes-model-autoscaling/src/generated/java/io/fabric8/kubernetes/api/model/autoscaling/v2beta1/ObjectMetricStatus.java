
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
    "averageValue",
    "currentValue",
    "metricName",
    "selector",
    "target"
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
public class ObjectMetricStatus implements KubernetesResource
{

    @JsonProperty("averageValue")
    private Quantity averageValue;
    @JsonProperty("currentValue")
    private Quantity currentValue;
    @JsonProperty("metricName")
    private String metricName;
    @JsonProperty("selector")
    private io.fabric8.kubernetes.api.model.LabelSelector selector;
    @JsonProperty("target")
    private CrossVersionObjectReference target;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ObjectMetricStatus() {
    }

    public ObjectMetricStatus(Quantity averageValue, Quantity currentValue, String metricName, io.fabric8.kubernetes.api.model.LabelSelector selector, CrossVersionObjectReference target) {
        super();
        this.averageValue = averageValue;
        this.currentValue = currentValue;
        this.metricName = metricName;
        this.selector = selector;
        this.target = target;
    }

    @JsonProperty("averageValue")
    public Quantity getAverageValue() {
        return averageValue;
    }

    @JsonProperty("averageValue")
    public void setAverageValue(Quantity averageValue) {
        this.averageValue = averageValue;
    }

    @JsonProperty("currentValue")
    public Quantity getCurrentValue() {
        return currentValue;
    }

    @JsonProperty("currentValue")
    public void setCurrentValue(Quantity currentValue) {
        this.currentValue = currentValue;
    }

    @JsonProperty("metricName")
    public String getMetricName() {
        return metricName;
    }

    @JsonProperty("metricName")
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    @JsonProperty("selector")
    public io.fabric8.kubernetes.api.model.LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(io.fabric8.kubernetes.api.model.LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("target")
    public CrossVersionObjectReference getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(CrossVersionObjectReference target) {
        this.target = target;
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
