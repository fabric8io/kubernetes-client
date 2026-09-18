
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
 * NodeConfigSource specifies a source of node configuration. Exactly one subfield (excluding metadata) must be non-nil. This API is deprecated since 1.22
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMap"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeConfigSource implements Editable<NodeConfigSourceBuilder>, KubernetesResource
{

    @JsonProperty("configMap")
    private ConfigMapNodeConfigSource configMap;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeConfigSource() {
    }

    public NodeConfigSource(ConfigMapNodeConfigSource configMap) {
        super();
        this.configMap = configMap;
    }

    /**
     * NodeConfigSource specifies a source of node configuration. Exactly one subfield (excluding metadata) must be non-nil. This API is deprecated since 1.22
     */
    @JsonProperty("configMap")
    public ConfigMapNodeConfigSource getConfigMap() {
        return configMap;
    }

    /**
     * NodeConfigSource specifies a source of node configuration. Exactly one subfield (excluding metadata) must be non-nil. This API is deprecated since 1.22
     */
    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapNodeConfigSource configMap) {
        this.configMap = configMap;
    }

    @JsonIgnore
    public NodeConfigSourceBuilder edit() {
        return new NodeConfigSourceBuilder(this);
    }

    @JsonIgnore
    public NodeConfigSourceBuilder toBuilder() {
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
        if (!(o instanceof NodeConfigSource)) {
            return false;
        }
        NodeConfigSource other = (NodeConfigSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configMap = this.getConfigMap();
        Object other$configMap = other.getConfigMap();
        if (this$configMap == null ? other$configMap != null : !this$configMap.equals(other$configMap)) {
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
        return other instanceof NodeConfigSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configMap = this.getConfigMap();
        result = result * prime + ($configMap == null ? 43 : $configMap.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeConfigSource(" + "configMap=" + this.getConfigMap() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
