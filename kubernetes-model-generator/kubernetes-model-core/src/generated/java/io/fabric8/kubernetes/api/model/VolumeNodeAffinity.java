
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * VolumeNodeAffinity defines constraints that limit what nodes this volume can be accessed from.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "required"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeNodeAffinity implements Editable<VolumeNodeAffinityBuilder>, KubernetesResource
{

    @JsonProperty("required")
    private NodeSelector required;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeNodeAffinity() {
    }

    public VolumeNodeAffinity(NodeSelector required) {
        super();
        this.required = required;
    }

    /**
     * VolumeNodeAffinity defines constraints that limit what nodes this volume can be accessed from.
     */
    @JsonProperty("required")
    public NodeSelector getRequired() {
        return required;
    }

    /**
     * VolumeNodeAffinity defines constraints that limit what nodes this volume can be accessed from.
     */
    @JsonProperty("required")
    public void setRequired(NodeSelector required) {
        this.required = required;
    }

    @JsonIgnore
    public VolumeNodeAffinityBuilder edit() {
        return new VolumeNodeAffinityBuilder(this);
    }

    @JsonIgnore
    public VolumeNodeAffinityBuilder toBuilder() {
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
        if (!(o instanceof VolumeNodeAffinity)) {
            return false;
        }
        VolumeNodeAffinity other = (VolumeNodeAffinity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$required = this.getRequired();
        Object other$required = other.getRequired();
        if (this$required == null ? other$required != null : !this$required.equals(other$required)) {
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
        return other instanceof VolumeNodeAffinity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $required = this.getRequired();
        result = result * prime + ($required == null ? 43 : $required.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeNodeAffinity(" + "required=" + this.getRequired() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
