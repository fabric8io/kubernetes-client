
package io.fabric8.kubernetes.api.model.resource.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max",
    "min",
    "step"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("max")
    public Quantity getMax() {
        return max;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("max")
    public void setMax(Quantity max) {
        this.max = max;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("min")
    public Quantity getMin() {
        return min;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("min")
    public void setMin(Quantity min) {
        this.min = min;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
     */
    @JsonProperty("step")
    public Quantity getStep() {
        return step;
    }

    /**
     * CapacityRequestPolicyRange defines a valid range for consumable capacity values.<br><p> <br><p>   - If the requested amount is less than Min, it is rounded up to the Min value.<br><p>   - If Step is set and the requested amount is between Min and Max but not aligned with Step,<br><p>     it will be rounded up to the next value equal to Min + (n &#42; Step).<br><p>   - If Step is not set, the requested amount is used as-is if it falls within the range Min to Max (if set).<br><p>   - If the requested or rounded amount exceeds Max (if set), the request does not satisfy the policy,<br><p>     and the device cannot be allocated.
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

}
