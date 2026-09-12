
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
 * ObjectFieldSelector selects an APIVersioned field of an object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "fieldPath"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ObjectFieldSelector implements Editable<ObjectFieldSelectorBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("fieldPath")
    private String fieldPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ObjectFieldSelector() {
    }

    public ObjectFieldSelector(String apiVersion, String fieldPath) {
        super();
        this.apiVersion = apiVersion;
        this.fieldPath = fieldPath;
    }

    /**
     * Version of the schema the FieldPath is written in terms of, defaults to "v1".
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Version of the schema the FieldPath is written in terms of, defaults to "v1".
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Path of the field to select in the specified API version.
     */
    @JsonProperty("fieldPath")
    public String getFieldPath() {
        return fieldPath;
    }

    /**
     * Path of the field to select in the specified API version.
     */
    @JsonProperty("fieldPath")
    public void setFieldPath(String fieldPath) {
        this.fieldPath = fieldPath;
    }

    @JsonIgnore
    public ObjectFieldSelectorBuilder edit() {
        return new ObjectFieldSelectorBuilder(this);
    }

    @JsonIgnore
    public ObjectFieldSelectorBuilder toBuilder() {
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
        if (!(o instanceof ObjectFieldSelector)) {
            return false;
        }
        ObjectFieldSelector other = (ObjectFieldSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$fieldPath = this.getFieldPath();
        Object other$fieldPath = other.getFieldPath();
        if (this$fieldPath == null ? other$fieldPath != null : !this$fieldPath.equals(other$fieldPath)) {
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
        return other instanceof ObjectFieldSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $fieldPath = this.getFieldPath();
        result = result * prime + ($fieldPath == null ? 43 : $fieldPath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ObjectFieldSelector(" + "apiVersion=" + this.getApiVersion() + ", fieldPath=" + this.getFieldPath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
