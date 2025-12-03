
package io.fabric8.kubernetes.api.model.resource.v1beta2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * CapacityRequestPolicy defines how requests consume device capacity.<br><p> <br><p> Must not set more than one ValidRequestValues.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "validRange",
    "validValues"
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
public class CapacityRequestPolicy implements Editable<CapacityRequestPolicyBuilder>, KubernetesResource
{

    @JsonProperty("default")
    private Quantity _default;
    @JsonProperty("validRange")
    private CapacityRequestPolicyRange validRange;
    @JsonProperty("validValues")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Quantity> validValues = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CapacityRequestPolicy() {
    }

    public CapacityRequestPolicy(Quantity _default, CapacityRequestPolicyRange validRange, List<Quantity> validValues) {
        super();
        this._default = _default;
        this.validRange = validRange;
        this.validValues = validValues;
    }

    /**
     * CapacityRequestPolicy defines how requests consume device capacity.<br><p> <br><p> Must not set more than one ValidRequestValues.
     */
    @JsonProperty("default")
    public Quantity getDefault() {
        return _default;
    }

    /**
     * CapacityRequestPolicy defines how requests consume device capacity.<br><p> <br><p> Must not set more than one ValidRequestValues.
     */
    @JsonProperty("default")
    public void setDefault(Quantity _default) {
        this._default = _default;
    }

    /**
     * CapacityRequestPolicy defines how requests consume device capacity.<br><p> <br><p> Must not set more than one ValidRequestValues.
     */
    @JsonProperty("validRange")
    public CapacityRequestPolicyRange getValidRange() {
        return validRange;
    }

    /**
     * CapacityRequestPolicy defines how requests consume device capacity.<br><p> <br><p> Must not set more than one ValidRequestValues.
     */
    @JsonProperty("validRange")
    public void setValidRange(CapacityRequestPolicyRange validRange) {
        this.validRange = validRange;
    }

    /**
     * ValidValues defines a set of acceptable quantity values in consuming requests.<br><p> <br><p> Must not contain more than 10 entries. Must be sorted in ascending order.<br><p> <br><p> If this field is set, Default must be defined and it must be included in ValidValues list.<br><p> <br><p> If the requested amount does not match any valid value but smaller than some valid values, the scheduler calculates the smallest valid value that is greater than or equal to the request. That is: min(ceil(requestedValue) ∈ validValues), where requestedValue ≤ max(validValues).<br><p> <br><p> If the requested amount exceeds all valid values, the request violates the policy, and this device cannot be allocated.
     */
    @JsonProperty("validValues")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Quantity> getValidValues() {
        return validValues;
    }

    /**
     * ValidValues defines a set of acceptable quantity values in consuming requests.<br><p> <br><p> Must not contain more than 10 entries. Must be sorted in ascending order.<br><p> <br><p> If this field is set, Default must be defined and it must be included in ValidValues list.<br><p> <br><p> If the requested amount does not match any valid value but smaller than some valid values, the scheduler calculates the smallest valid value that is greater than or equal to the request. That is: min(ceil(requestedValue) ∈ validValues), where requestedValue ≤ max(validValues).<br><p> <br><p> If the requested amount exceeds all valid values, the request violates the policy, and this device cannot be allocated.
     */
    @JsonProperty("validValues")
    public void setValidValues(List<Quantity> validValues) {
        this.validValues = validValues;
    }

    @JsonIgnore
    public CapacityRequestPolicyBuilder edit() {
        return new CapacityRequestPolicyBuilder(this);
    }

    @JsonIgnore
    public CapacityRequestPolicyBuilder toBuilder() {
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
