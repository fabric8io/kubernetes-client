
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paths"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RootPaths implements Editable<RootPathsBuilder>, KubernetesResource
{

    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> paths = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RootPaths() {
    }

    public RootPaths(List<String> paths) {
        super();
        this.paths = paths;
    }

    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPaths() {
        return paths;
    }

    @JsonProperty("paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    @JsonIgnore
    public RootPathsBuilder edit() {
        return new RootPathsBuilder(this);
    }

    @JsonIgnore
    public RootPathsBuilder toBuilder() {
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
        if (!(o instanceof RootPaths)) {
            return false;
        }
        RootPaths other = (RootPaths) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$paths = this.getPaths();
        Object other$paths = other.getPaths();
        if (this$paths == null ? other$paths != null : !this$paths.equals(other$paths)) {
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
        return other instanceof RootPaths;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $paths = this.getPaths();
        result = result * prime + ($paths == null ? 43 : $paths.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RootPaths(" + "paths=" + this.getPaths() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
