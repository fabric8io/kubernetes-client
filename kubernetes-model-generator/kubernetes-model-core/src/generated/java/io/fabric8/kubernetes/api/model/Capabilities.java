
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * Adds and removes POSIX capabilities from running containers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "add",
    "drop"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Capabilities implements Editable<CapabilitiesBuilder>, KubernetesResource
{

    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> add = new ArrayList<>();
    @JsonProperty("drop")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> drop = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Capabilities() {
    }

    public Capabilities(List<String> add, List<String> drop) {
        super();
        this.add = add;
        this.drop = drop;
    }

    /**
     * Added capabilities
     */
    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdd() {
        return add;
    }

    /**
     * Added capabilities
     */
    @JsonProperty("add")
    public void setAdd(List<String> add) {
        this.add = add;
    }

    /**
     * Removed capabilities
     */
    @JsonProperty("drop")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDrop() {
        return drop;
    }

    /**
     * Removed capabilities
     */
    @JsonProperty("drop")
    public void setDrop(List<String> drop) {
        this.drop = drop;
    }

    @JsonIgnore
    public CapabilitiesBuilder edit() {
        return new CapabilitiesBuilder(this);
    }

    @JsonIgnore
    public CapabilitiesBuilder toBuilder() {
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
        if (!(o instanceof Capabilities)) {
            return false;
        }
        Capabilities other = (Capabilities) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$add = this.getAdd();
        Object other$add = other.getAdd();
        if (this$add == null ? other$add != null : !this$add.equals(other$add)) {
            return false;
        }
        Object this$drop = this.getDrop();
        Object other$drop = other.getDrop();
        if (this$drop == null ? other$drop != null : !this$drop.equals(other$drop)) {
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
        return other instanceof Capabilities;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $add = this.getAdd();
        result = result * prime + ($add == null ? 43 : $add.hashCode());
        Object $drop = this.getDrop();
        result = result * prime + ($drop == null ? 43 : $drop.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Capabilities(" + "add=" + this.getAdd() + ", drop=" + this.getDrop() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
