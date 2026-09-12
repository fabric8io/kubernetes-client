
package io.fabric8.autoscaling.api.model.v1;

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
 * GenericStartupBoost defines the startup boost policy for a resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "durationSeconds",
    "factor",
    "quantity",
    "type"
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
public class GenericStartupBoost implements Editable<GenericStartupBoostBuilder>, KubernetesResource
{

    @JsonProperty("durationSeconds")
    private Integer durationSeconds;
    @JsonProperty("factor")
    private Integer factor;
    @JsonProperty("quantity")
    private Quantity quantity;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericStartupBoost() {
    }

    public GenericStartupBoost(Integer durationSeconds, Integer factor, Quantity quantity, String type) {
        super();
        this.durationSeconds = durationSeconds;
        this.factor = factor;
        this.quantity = quantity;
        this.type = type;
    }

    /**
     * durationSeconds indicates for how long to keep the pod boosted after it goes to Ready. Defaults to 0.
     */
    @JsonProperty("durationSeconds")
    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    /**
     * durationSeconds indicates for how long to keep the pod boosted after it goes to Ready. Defaults to 0.
     */
    @JsonProperty("durationSeconds")
    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    /**
     * factor specifies the factor to apply to the resource request. This field is required when Type is "Factor".
     */
    @JsonProperty("factor")
    public Integer getFactor() {
        return factor;
    }

    /**
     * factor specifies the factor to apply to the resource request. This field is required when Type is "Factor".
     */
    @JsonProperty("factor")
    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    /**
     * GenericStartupBoost defines the startup boost policy for a resource.
     */
    @JsonProperty("quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    /**
     * GenericStartupBoost defines the startup boost policy for a resource.
     */
    @JsonProperty("quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    /**
     * type specifies the kind of boost to apply. Supported values are: "Factor", "Quantity". No startupboost will be applied for unrecognized values.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type specifies the kind of boost to apply. Supported values are: "Factor", "Quantity". No startupboost will be applied for unrecognized values.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public GenericStartupBoostBuilder edit() {
        return new GenericStartupBoostBuilder(this);
    }

    @JsonIgnore
    public GenericStartupBoostBuilder toBuilder() {
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
        if (!(o instanceof GenericStartupBoost)) {
            return false;
        }
        GenericStartupBoost other = (GenericStartupBoost) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$durationSeconds = this.getDurationSeconds();
        Object other$durationSeconds = other.getDurationSeconds();
        if (this$durationSeconds == null ? other$durationSeconds != null : !this$durationSeconds.equals(other$durationSeconds)) {
            return false;
        }
        Object this$factor = this.getFactor();
        Object other$factor = other.getFactor();
        if (this$factor == null ? other$factor != null : !this$factor.equals(other$factor)) {
            return false;
        }
        Object this$quantity = this.getQuantity();
        Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof GenericStartupBoost;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $durationSeconds = this.getDurationSeconds();
        result = result * prime + ($durationSeconds == null ? 43 : $durationSeconds.hashCode());
        Object $factor = this.getFactor();
        result = result * prime + ($factor == null ? 43 : $factor.hashCode());
        Object $quantity = this.getQuantity();
        result = result * prime + ($quantity == null ? 43 : $quantity.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GenericStartupBoost(" + "durationSeconds=" + this.getDurationSeconds() + ", factor=" + this.getFactor() + ", quantity=" + this.getQuantity() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
