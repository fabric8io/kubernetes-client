
package io.fabric8.kubernetes.api.model.extensions;

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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * IDRange provides a min/max of an allowed range of IDs. Deprecated: use IDRange from policy API Group instead.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max",
    "min"
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
public class IDRange implements Editable<IDRangeBuilder>, KubernetesResource
{

    @JsonProperty("max")
    private Long max;
    @JsonProperty("min")
    private Long min;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IDRange() {
    }

    public IDRange(Long max, Long min) {
        super();
        this.max = max;
        this.min = min;
    }

    /**
     * max is the end of the range, inclusive.
     */
    @JsonProperty("max")
    public Long getMax() {
        return max;
    }

    /**
     * max is the end of the range, inclusive.
     */
    @JsonProperty("max")
    public void setMax(Long max) {
        this.max = max;
    }

    /**
     * min is the start of the range, inclusive.
     */
    @JsonProperty("min")
    public Long getMin() {
        return min;
    }

    /**
     * min is the start of the range, inclusive.
     */
    @JsonProperty("min")
    public void setMin(Long min) {
        this.min = min;
    }

    @JsonIgnore
    public IDRangeBuilder edit() {
        return new IDRangeBuilder(this);
    }

    @JsonIgnore
    public IDRangeBuilder toBuilder() {
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
        if (!(o instanceof IDRange)) {
            return false;
        }
        IDRange other = (IDRange) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$max = this.getMax();
        Object other$max = other.getMax();
        if (this$max == null ? other$max != null : !this$max.equals(other$max)) {
            return false;
        }
        Object this$min = this.getMin();
        Object other$min = other.getMin();
        if (this$min == null ? other$min != null : !this$min.equals(other$min)) {
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
        return other instanceof IDRange;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $max = this.getMax();
        result = result * prime + ($max == null ? 43 : $max.hashCode());
        Object $min = this.getMin();
        result = result * prime + ($min == null ? 43 : $min.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IDRange(" + "max=" + this.getMax() + ", min=" + this.getMin() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
