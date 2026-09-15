
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
 * NodeRuntimeHandlerFeatures is a set of features implemented by the runtime handler.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "recursiveReadOnlyMounts",
    "userNamespaces"
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
        if (!(o instanceof NodeRuntimeHandlerFeatures)) {
            return false;
        }
        NodeRuntimeHandlerFeatures other = (NodeRuntimeHandlerFeatures) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$recursiveReadOnlyMounts = this.getRecursiveReadOnlyMounts();
        Object other$recursiveReadOnlyMounts = other.getRecursiveReadOnlyMounts();
        if (this$recursiveReadOnlyMounts == null ? other$recursiveReadOnlyMounts != null : !this$recursiveReadOnlyMounts.equals(other$recursiveReadOnlyMounts)) {
            return false;
        }
        Object this$userNamespaces = this.getUserNamespaces();
        Object other$userNamespaces = other.getUserNamespaces();
        if (this$userNamespaces == null ? other$userNamespaces != null : !this$userNamespaces.equals(other$userNamespaces)) {
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
        return other instanceof NodeRuntimeHandlerFeatures;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $recursiveReadOnlyMounts = this.getRecursiveReadOnlyMounts();
        result = result * prime + ($recursiveReadOnlyMounts == null ? 43 : $recursiveReadOnlyMounts.hashCode());
        Object $userNamespaces = this.getUserNamespaces();
        result = result * prime + ($userNamespaces == null ? 43 : $userNamespaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeRuntimeHandlerFeatures(" + "recursiveReadOnlyMounts=" + this.getRecursiveReadOnlyMounts() + ", userNamespaces=" + this.getUserNamespaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
