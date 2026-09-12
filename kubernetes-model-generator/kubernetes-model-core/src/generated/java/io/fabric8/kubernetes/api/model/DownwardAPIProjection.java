
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
 * Represents downward API info for projecting into a projected volume. Note that this is identical to a downwardAPI volume source without the default mode.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "items"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DownwardAPIProjection implements Editable<DownwardAPIProjectionBuilder>, KubernetesResource
{

    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DownwardAPIVolumeFile> items = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DownwardAPIProjection() {
    }

    public DownwardAPIProjection(List<DownwardAPIVolumeFile> items) {
        super();
        this.items = items;
    }

    /**
     * Items is a list of DownwardAPIVolume file
     */
    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DownwardAPIVolumeFile> getItems() {
        return items;
    }

    /**
     * Items is a list of DownwardAPIVolume file
     */
    @JsonProperty("items")
    public void setItems(List<DownwardAPIVolumeFile> items) {
        this.items = items;
    }

    @JsonIgnore
    public DownwardAPIProjectionBuilder edit() {
        return new DownwardAPIProjectionBuilder(this);
    }

    @JsonIgnore
    public DownwardAPIProjectionBuilder toBuilder() {
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
        if (!(o instanceof DownwardAPIProjection)) {
            return false;
        }
        DownwardAPIProjection other = (DownwardAPIProjection) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$items = this.getItems();
        Object other$items = other.getItems();
        if (this$items == null ? other$items != null : !this$items.equals(other$items)) {
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
        return other instanceof DownwardAPIProjection;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $items = this.getItems();
        result = result * prime + ($items == null ? 43 : $items.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DownwardAPIProjection(" + "items=" + this.getItems() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
