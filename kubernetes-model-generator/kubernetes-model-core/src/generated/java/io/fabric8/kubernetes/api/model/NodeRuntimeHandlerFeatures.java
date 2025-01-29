
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * NodeRuntimeHandlerFeatures is a set of features implemented by the runtime handler.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "recursiveReadOnlyMounts",
    "userNamespaces"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeRuntimeHandlerFeatures implements Editable<NodeRuntimeHandlerFeaturesBuilder>, KubernetesResource
{

    @JsonProperty("recursiveReadOnlyMounts")
    private Boolean recursiveReadOnlyMounts;
    @JsonProperty("userNamespaces")
    private Boolean userNamespaces;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeRuntimeHandlerFeatures() {
    }

    public NodeRuntimeHandlerFeatures(Boolean recursiveReadOnlyMounts, Boolean userNamespaces) {
        super();
        this.recursiveReadOnlyMounts = recursiveReadOnlyMounts;
        this.userNamespaces = userNamespaces;
    }

    /**
     * RecursiveReadOnlyMounts is set to true if the runtime handler supports RecursiveReadOnlyMounts.
     */
    @JsonProperty("recursiveReadOnlyMounts")
    public Boolean getRecursiveReadOnlyMounts() {
        return recursiveReadOnlyMounts;
    }

    /**
     * RecursiveReadOnlyMounts is set to true if the runtime handler supports RecursiveReadOnlyMounts.
     */
    @JsonProperty("recursiveReadOnlyMounts")
    public void setRecursiveReadOnlyMounts(Boolean recursiveReadOnlyMounts) {
        this.recursiveReadOnlyMounts = recursiveReadOnlyMounts;
    }

    /**
     * UserNamespaces is set to true if the runtime handler supports UserNamespaces, including for volumes.
     */
    @JsonProperty("userNamespaces")
    public Boolean getUserNamespaces() {
        return userNamespaces;
    }

    /**
     * UserNamespaces is set to true if the runtime handler supports UserNamespaces, including for volumes.
     */
    @JsonProperty("userNamespaces")
    public void setUserNamespaces(Boolean userNamespaces) {
        this.userNamespaces = userNamespaces;
    }

    @JsonIgnore
    public NodeRuntimeHandlerFeaturesBuilder edit() {
        return new NodeRuntimeHandlerFeaturesBuilder(this);
    }

    @JsonIgnore
    public NodeRuntimeHandlerFeaturesBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
