
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
 * NodeRuntimeHandler is a set of runtime handler information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "features",
    "name"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeRuntimeHandler implements Editable<NodeRuntimeHandlerBuilder>, KubernetesResource
{

    @JsonProperty("features")
    private NodeRuntimeHandlerFeatures features;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeRuntimeHandler() {
    }

    public NodeRuntimeHandler(NodeRuntimeHandlerFeatures features, String name) {
        super();
        this.features = features;
        this.name = name;
    }

    /**
     * NodeRuntimeHandler is a set of runtime handler information.
     */
    @JsonProperty("features")
    public NodeRuntimeHandlerFeatures getFeatures() {
        return features;
    }

    /**
     * NodeRuntimeHandler is a set of runtime handler information.
     */
    @JsonProperty("features")
    public void setFeatures(NodeRuntimeHandlerFeatures features) {
        this.features = features;
    }

    /**
     * Runtime handler name. Empty for the default runtime handler.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Runtime handler name. Empty for the default runtime handler.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public NodeRuntimeHandlerBuilder edit() {
        return new NodeRuntimeHandlerBuilder(this);
    }

    @JsonIgnore
    public NodeRuntimeHandlerBuilder toBuilder() {
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
        if (!(o instanceof NodeRuntimeHandler)) {
            return false;
        }
        NodeRuntimeHandler other = (NodeRuntimeHandler) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$features = this.getFeatures();
        Object other$features = other.getFeatures();
        if (this$features == null ? other$features != null : !this$features.equals(other$features)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof NodeRuntimeHandler;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $features = this.getFeatures();
        result = result * prime + ($features == null ? 43 : $features.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeRuntimeHandler(" + "features=" + this.getFeatures() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
