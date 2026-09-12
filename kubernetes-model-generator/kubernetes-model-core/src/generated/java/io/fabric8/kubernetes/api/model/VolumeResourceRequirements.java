
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
 * VolumeResourceRequirements describes the storage resource requirements for a volume.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "limits",
    "requests"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeResourceRequirements implements Editable<VolumeResourceRequirementsBuilder>, KubernetesResource
{

    @JsonProperty("limits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> limits = new LinkedHashMap<>();
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> requests = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeResourceRequirements() {
    }

    public VolumeResourceRequirements(Map<String, Quantity> limits, Map<String, Quantity> requests) {
        super();
        this.limits = limits;
        this.requests = requests;
    }

    /**
     * Limits describes the maximum amount of compute resources allowed. More info: https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/
     */
    @JsonProperty("limits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getLimits() {
        return limits;
    }

    /**
     * Limits describes the maximum amount of compute resources allowed. More info: https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/
     */
    @JsonProperty("limits")
    public void setLimits(Map<String, Quantity> limits) {
        this.limits = limits;
    }

    /**
     * Requests describes the minimum amount of compute resources required. If Requests is omitted for a container, it defaults to Limits if that is explicitly specified, otherwise to an implementation-defined value. Requests cannot exceed Limits. More info: https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/
     */
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getRequests() {
        return requests;
    }

    /**
     * Requests describes the minimum amount of compute resources required. If Requests is omitted for a container, it defaults to Limits if that is explicitly specified, otherwise to an implementation-defined value. Requests cannot exceed Limits. More info: https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/
     */
    @JsonProperty("requests")
    public void setRequests(Map<String, Quantity> requests) {
        this.requests = requests;
    }

    @JsonIgnore
    public VolumeResourceRequirementsBuilder edit() {
        return new VolumeResourceRequirementsBuilder(this);
    }

    @JsonIgnore
    public VolumeResourceRequirementsBuilder toBuilder() {
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
        if (!(o instanceof VolumeResourceRequirements)) {
            return false;
        }
        VolumeResourceRequirements other = (VolumeResourceRequirements) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$limits = this.getLimits();
        Object other$limits = other.getLimits();
        if (this$limits == null ? other$limits != null : !this$limits.equals(other$limits)) {
            return false;
        }
        Object this$requests = this.getRequests();
        Object other$requests = other.getRequests();
        if (this$requests == null ? other$requests != null : !this$requests.equals(other$requests)) {
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
        return other instanceof VolumeResourceRequirements;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $limits = this.getLimits();
        result = result * prime + ($limits == null ? 43 : $limits.hashCode());
        Object $requests = this.getRequests();
        result = result * prime + ($requests == null ? 43 : $requests.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeResourceRequirements(" + "limits=" + this.getLimits() + ", requests=" + this.getRequests() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
