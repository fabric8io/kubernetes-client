
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
 * NodeFeatures describes the set of features implemented by the CRI implementation. The features contained in the NodeFeatures should depend only on the cri implementation independent of runtime handlers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "supplementalGroupsPolicy"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeFeatures implements Editable<NodeFeaturesBuilder>, KubernetesResource
{

    @JsonProperty("supplementalGroupsPolicy")
    private Boolean supplementalGroupsPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeFeatures() {
    }

    public NodeFeatures(Boolean supplementalGroupsPolicy) {
        super();
        this.supplementalGroupsPolicy = supplementalGroupsPolicy;
    }

    /**
     * SupplementalGroupsPolicy is set to true if the runtime supports SupplementalGroupsPolicy and ContainerUser.
     */
    @JsonProperty("supplementalGroupsPolicy")
    public Boolean getSupplementalGroupsPolicy() {
        return supplementalGroupsPolicy;
    }

    /**
     * SupplementalGroupsPolicy is set to true if the runtime supports SupplementalGroupsPolicy and ContainerUser.
     */
    @JsonProperty("supplementalGroupsPolicy")
    public void setSupplementalGroupsPolicy(Boolean supplementalGroupsPolicy) {
        this.supplementalGroupsPolicy = supplementalGroupsPolicy;
    }

    @JsonIgnore
    public NodeFeaturesBuilder edit() {
        return new NodeFeaturesBuilder(this);
    }

    @JsonIgnore
    public NodeFeaturesBuilder toBuilder() {
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
        if (!(o instanceof NodeFeatures)) {
            return false;
        }
        NodeFeatures other = (NodeFeatures) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$supplementalGroupsPolicy = this.getSupplementalGroupsPolicy();
        Object other$supplementalGroupsPolicy = other.getSupplementalGroupsPolicy();
        if (this$supplementalGroupsPolicy == null ? other$supplementalGroupsPolicy != null : !this$supplementalGroupsPolicy.equals(other$supplementalGroupsPolicy)) {
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
        return other instanceof NodeFeatures;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $supplementalGroupsPolicy = this.getSupplementalGroupsPolicy();
        result = result * prime + ($supplementalGroupsPolicy == null ? 43 : $supplementalGroupsPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeFeatures(" + "supplementalGroupsPolicy=" + this.getSupplementalGroupsPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
