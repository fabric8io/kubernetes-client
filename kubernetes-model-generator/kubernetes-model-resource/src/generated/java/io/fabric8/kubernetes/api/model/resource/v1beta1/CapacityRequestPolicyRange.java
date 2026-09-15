
package io.fabric8.kubernetes.api.model.resource.v1beta1;

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
 * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p> If the DRAFractionalCapacityRange feature gate is enabled and at least one of Min, Max, or Step is a fractional quantity (i.e. its value is not an integer), milli-unit arithmetic is used instead, supporting values with up to 3 decimal places (e.g. 100m = 0.1). The largest supported value then is 1000 times smaller compared to using 64-bit integers. Otherwise, all comparisons use 64-bit integer arithmetic via resource.Quantity.Value().<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max",
    "min",
    "step"
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
public class CapacityRequestPolicyRange implements Editable<CapacityRequestPolicyRangeBuilder>, KubernetesResource
{

    @JsonProperty("max")
    private Quantity max;
    @JsonProperty("min")
    private Quantity min;
    @JsonProperty("step")
    private Quantity step;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CapacityRequestPolicyRange() {
    }

    public CapacityRequestPolicyRange(Quantity max, Quantity min, Quantity step) {
        super();
        this.max = max;
        this.min = min;
        this.step = step;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p> If the DRAFractionalCapacityRange feature gate is enabled and at least one of Min, Max, or Step is a fractional quantity (i.e. its value is not an integer), milli-unit arithmetic is used instead, supporting values with up to 3 decimal places (e.g. 100m = 0.1). The largest supported value then is 1000 times smaller compared to using 64-bit integers. Otherwise, all comparisons use 64-bit integer arithmetic via resource.Quantity.Value().<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("max")
    public Quantity getMax() {
        return max;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p> If the DRAFractionalCapacityRange feature gate is enabled and at least one of Min, Max, or Step is a fractional quantity (i.e. its value is not an integer), milli-unit arithmetic is used instead, supporting values with up to 3 decimal places (e.g. 100m = 0.1). The largest supported value then is 1000 times smaller compared to using 64-bit integers. Otherwise, all comparisons use 64-bit integer arithmetic via resource.Quantity.Value().<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("max")
    public void setMax(Quantity max) {
        this.max = max;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p> If the DRAFractionalCapacityRange feature gate is enabled and at least one of Min, Max, or Step is a fractional quantity (i.e. its value is not an integer), milli-unit arithmetic is used instead, supporting values with up to 3 decimal places (e.g. 100m = 0.1). The largest supported value then is 1000 times smaller compared to using 64-bit integers. Otherwise, all comparisons use 64-bit integer arithmetic via resource.Quantity.Value().<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("min")
    public Quantity getMin() {
        return min;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p> If the DRAFractionalCapacityRange feature gate is enabled and at least one of Min, Max, or Step is a fractional quantity (i.e. its value is not an integer), milli-unit arithmetic is used instead, supporting values with up to 3 decimal places (e.g. 100m = 0.1). The largest supported value then is 1000 times smaller compared to using 64-bit integers. Otherwise, all comparisons use 64-bit integer arithmetic via resource.Quantity.Value().<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("min")
    public void setMin(Quantity min) {
        this.min = min;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p> If the DRAFractionalCapacityRange feature gate is enabled and at least one of Min, Max, or Step is a fractional quantity (i.e. its value is not an integer), milli-unit arithmetic is used instead, supporting values with up to 3 decimal places (e.g. 100m = 0.1). The largest supported value then is 1000 times smaller compared to using 64-bit integers. Otherwise, all comparisons use 64-bit integer arithmetic via resource.Quantity.Value().<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("step")
    public Quantity getStep() {
        return step;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p> If the DRAFractionalCapacityRange feature gate is enabled and at least one of Min, Max, or Step is a fractional quantity (i.e. its value is not an integer), milli-unit arithmetic is used instead, supporting values with up to 3 decimal places (e.g. 100m = 0.1). The largest supported value then is 1000 times smaller compared to using 64-bit integers. Otherwise, all comparisons use 64-bit integer arithmetic via resource.Quantity.Value().<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("step")
    public void setStep(Quantity step) {
        this.step = step;
    }

    @JsonIgnore
    public CapacityRequestPolicyRangeBuilder edit() {
        return new CapacityRequestPolicyRangeBuilder(this);
    }

    @JsonIgnore
    public CapacityRequestPolicyRangeBuilder toBuilder() {
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
        if (!(o instanceof CapacityRequestPolicyRange)) {
            return false;
        }
        CapacityRequestPolicyRange other = (CapacityRequestPolicyRange) o;
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
        Object this$step = this.getStep();
        Object other$step = other.getStep();
        if (this$step == null ? other$step != null : !this$step.equals(other$step)) {
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
        return other instanceof CapacityRequestPolicyRange;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $max = this.getMax();
        result = result * prime + ($max == null ? 43 : $max.hashCode());
        Object $min = this.getMin();
        result = result * prime + ($min == null ? 43 : $min.hashCode());
        Object $step = this.getStep();
        result = result * prime + ($step == null ? 43 : $step.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CapacityRequestPolicyRange(" + "max=" + this.getMax() + ", min=" + this.getMin() + ", step=" + this.getStep() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
