
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
 * ResourceMetricStatus indicates the current value of a resource metric known to Kubernetes, as specified in requests and limits, describing each pod in the current scale target (e.g. CPU or memory).  Such metrics are built in to Kubernetes, and have special scaling options on top of those available to normal per-pod metrics using the "pods" source.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentAverageUtilization",
    "currentAverageValue",
    "name"
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
public class ResourceMetricStatus implements Editable<ResourceMetricStatusBuilder>, KubernetesResource
{

    @JsonProperty("currentAverageUtilization")
    private Integer currentAverageUtilization;
    @JsonProperty("currentAverageValue")
    private Quantity currentAverageValue;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceMetricStatus() {
    }

    public ResourceMetricStatus(Integer currentAverageUtilization, Quantity currentAverageValue, String name) {
        super();
        this.currentAverageUtilization = currentAverageUtilization;
        this.currentAverageValue = currentAverageValue;
        this.name = name;
    }

    /**
     * currentAverageUtilization is the current value of the average of the resource metric across all relevant pods, represented as a percentage of the requested value of the resource for the pods.  It will only be present if `targetAverageValue` was set in the corresponding metric specification.
     */
    @JsonProperty("currentAverageUtilization")
    public Integer getCurrentAverageUtilization() {
        return currentAverageUtilization;
    }

    /**
     * currentAverageUtilization is the current value of the average of the resource metric across all relevant pods, represented as a percentage of the requested value of the resource for the pods.  It will only be present if `targetAverageValue` was set in the corresponding metric specification.
     */
    @JsonProperty("currentAverageUtilization")
    public void setCurrentAverageUtilization(Integer currentAverageUtilization) {
        this.currentAverageUtilization = currentAverageUtilization;
    }

    /**
     * ResourceMetricStatus indicates the current value of a resource metric known to Kubernetes, as specified in requests and limits, describing each pod in the current scale target (e.g. CPU or memory).  Such metrics are built in to Kubernetes, and have special scaling options on top of those available to normal per-pod metrics using the "pods" source.
     */
    @JsonProperty("currentAverageValue")
    public Quantity getCurrentAverageValue() {
        return currentAverageValue;
    }

    /**
     * ResourceMetricStatus indicates the current value of a resource metric known to Kubernetes, as specified in requests and limits, describing each pod in the current scale target (e.g. CPU or memory).  Such metrics are built in to Kubernetes, and have special scaling options on top of those available to normal per-pod metrics using the "pods" source.
     */
    @JsonProperty("currentAverageValue")
    public void setCurrentAverageValue(Quantity currentAverageValue) {
        this.currentAverageValue = currentAverageValue;
    }

    /**
     * name is the name of the resource in question.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the resource in question.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public ResourceMetricStatusBuilder edit() {
        return new ResourceMetricStatusBuilder(this);
    }

    @JsonIgnore
    public ResourceMetricStatusBuilder toBuilder() {
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
        if (!(o instanceof ResourceMetricStatus)) {
            return false;
        }
        ResourceMetricStatus other = (ResourceMetricStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$currentAverageUtilization = this.getCurrentAverageUtilization();
        Object other$currentAverageUtilization = other.getCurrentAverageUtilization();
        if (this$currentAverageUtilization == null ? other$currentAverageUtilization != null : !this$currentAverageUtilization.equals(other$currentAverageUtilization)) {
            return false;
        }
        Object this$currentAverageValue = this.getCurrentAverageValue();
        Object other$currentAverageValue = other.getCurrentAverageValue();
        if (this$currentAverageValue == null ? other$currentAverageValue != null : !this$currentAverageValue.equals(other$currentAverageValue)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof ResourceMetricStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $currentAverageUtilization = this.getCurrentAverageUtilization();
        result = result * prime + ($currentAverageUtilization == null ? 43 : $currentAverageUtilization.hashCode());
        Object $currentAverageValue = this.getCurrentAverageValue();
        result = result * prime + ($currentAverageValue == null ? 43 : $currentAverageValue.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceMetricStatus(" + "currentAverageUtilization=" + this.getCurrentAverageUtilization() + ", currentAverageValue=" + this.getCurrentAverageValue() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
