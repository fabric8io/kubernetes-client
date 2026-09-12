
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
 * PodSchedulingGroup identifies the runtime scheduling group instance that a Pod belongs to. The scheduler uses this information to apply workload-aware scheduling semantics. Exactly one field must be specified.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "podGroupName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodSchedulingGroup implements Editable<PodSchedulingGroupBuilder>, KubernetesResource
{

    @JsonProperty("podGroupName")
    private String podGroupName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSchedulingGroup() {
    }

    public PodSchedulingGroup(String podGroupName) {
        super();
        this.podGroupName = podGroupName;
    }

    /**
     * PodGroupName specifies the name of the standalone PodGroup object that represents the runtime instance of this group. Must be a DNS subdomain.
     */
    @JsonProperty("podGroupName")
    public String getPodGroupName() {
        return podGroupName;
    }

    /**
     * PodGroupName specifies the name of the standalone PodGroup object that represents the runtime instance of this group. Must be a DNS subdomain.
     */
    @JsonProperty("podGroupName")
    public void setPodGroupName(String podGroupName) {
        this.podGroupName = podGroupName;
    }

    @JsonIgnore
    public PodSchedulingGroupBuilder edit() {
        return new PodSchedulingGroupBuilder(this);
    }

    @JsonIgnore
    public PodSchedulingGroupBuilder toBuilder() {
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
        if (!(o instanceof PodSchedulingGroup)) {
            return false;
        }
        PodSchedulingGroup other = (PodSchedulingGroup) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$podGroupName = this.getPodGroupName();
        Object other$podGroupName = other.getPodGroupName();
        if (this$podGroupName == null ? other$podGroupName != null : !this$podGroupName.equals(other$podGroupName)) {
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
        return other instanceof PodSchedulingGroup;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $podGroupName = this.getPodGroupName();
        result = result * prime + ($podGroupName == null ? 43 : $podGroupName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodSchedulingGroup(" + "podGroupName=" + this.getPodGroupName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
