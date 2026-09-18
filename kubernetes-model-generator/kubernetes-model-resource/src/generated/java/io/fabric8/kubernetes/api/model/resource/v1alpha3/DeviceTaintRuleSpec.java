
package io.fabric8.kubernetes.api.model.resource.v1alpha3;

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
 * DeviceTaintRuleSpec specifies the selector and one taint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deviceSelector",
    "taint"
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
public class DeviceTaintRuleSpec implements Editable<DeviceTaintRuleSpecBuilder>, KubernetesResource
{

    @JsonProperty("deviceSelector")
    private DeviceTaintSelector deviceSelector;
    @JsonProperty("taint")
    private DeviceTaint taint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceTaintRuleSpec() {
    }

    public DeviceTaintRuleSpec(DeviceTaintSelector deviceSelector, DeviceTaint taint) {
        super();
        this.deviceSelector = deviceSelector;
        this.taint = taint;
    }

    /**
     * DeviceTaintRuleSpec specifies the selector and one taint.
     */
    @JsonProperty("deviceSelector")
    public DeviceTaintSelector getDeviceSelector() {
        return deviceSelector;
    }

    /**
     * DeviceTaintRuleSpec specifies the selector and one taint.
     */
    @JsonProperty("deviceSelector")
    public void setDeviceSelector(DeviceTaintSelector deviceSelector) {
        this.deviceSelector = deviceSelector;
    }

    /**
     * DeviceTaintRuleSpec specifies the selector and one taint.
     */
    @JsonProperty("taint")
    public DeviceTaint getTaint() {
        return taint;
    }

    /**
     * DeviceTaintRuleSpec specifies the selector and one taint.
     */
    @JsonProperty("taint")
    public void setTaint(DeviceTaint taint) {
        this.taint = taint;
    }

    @JsonIgnore
    public DeviceTaintRuleSpecBuilder edit() {
        return new DeviceTaintRuleSpecBuilder(this);
    }

    @JsonIgnore
    public DeviceTaintRuleSpecBuilder toBuilder() {
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
        if (!(o instanceof DeviceTaintRuleSpec)) {
            return false;
        }
        DeviceTaintRuleSpec other = (DeviceTaintRuleSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$deviceSelector = this.getDeviceSelector();
        Object other$deviceSelector = other.getDeviceSelector();
        if (this$deviceSelector == null ? other$deviceSelector != null : !this$deviceSelector.equals(other$deviceSelector)) {
            return false;
        }
        Object this$taint = this.getTaint();
        Object other$taint = other.getTaint();
        if (this$taint == null ? other$taint != null : !this$taint.equals(other$taint)) {
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
        return other instanceof DeviceTaintRuleSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $deviceSelector = this.getDeviceSelector();
        result = result * prime + ($deviceSelector == null ? 43 : $deviceSelector.hashCode());
        Object $taint = this.getTaint();
        result = result * prime + ($taint == null ? 43 : $taint.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeviceTaintRuleSpec(" + "deviceSelector=" + this.getDeviceSelector() + ", taint=" + this.getTaint() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
