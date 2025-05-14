
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NodeRuntimeHandler is a set of runtime handler information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "features",
    "name"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
