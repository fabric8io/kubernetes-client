
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
 * EnvVarSource represents a source for the value of an EnvVar.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMapKeyRef",
    "fieldRef",
    "fileKeyRef",
    "resourceFieldRef",
    "secretKeyRef"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EnvVarSource implements Editable<EnvVarSourceBuilder>, KubernetesResource
{

    @JsonProperty("configMapKeyRef")
    private ConfigMapKeySelector configMapKeyRef;
    @JsonProperty("fieldRef")
    private ObjectFieldSelector fieldRef;
    @JsonProperty("fileKeyRef")
    private FileKeySelector fileKeyRef;
    @JsonProperty("resourceFieldRef")
    private ResourceFieldSelector resourceFieldRef;
    @JsonProperty("secretKeyRef")
    private SecretKeySelector secretKeyRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvVarSource() {
    }

    public EnvVarSource(ConfigMapKeySelector configMapKeyRef, ObjectFieldSelector fieldRef, FileKeySelector fileKeyRef, ResourceFieldSelector resourceFieldRef, SecretKeySelector secretKeyRef) {
        super();
        this.configMapKeyRef = configMapKeyRef;
        this.fieldRef = fieldRef;
        this.fileKeyRef = fileKeyRef;
        this.resourceFieldRef = resourceFieldRef;
        this.secretKeyRef = secretKeyRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("configMapKeyRef")
    public ConfigMapKeySelector getConfigMapKeyRef() {
        return configMapKeyRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("configMapKeyRef")
    public void setConfigMapKeyRef(ConfigMapKeySelector configMapKeyRef) {
        this.configMapKeyRef = configMapKeyRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("fieldRef")
    public ObjectFieldSelector getFieldRef() {
        return fieldRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("fieldRef")
    public void setFieldRef(ObjectFieldSelector fieldRef) {
        this.fieldRef = fieldRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("fileKeyRef")
    public FileKeySelector getFileKeyRef() {
        return fileKeyRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("fileKeyRef")
    public void setFileKeyRef(FileKeySelector fileKeyRef) {
        this.fileKeyRef = fileKeyRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("resourceFieldRef")
    public ResourceFieldSelector getResourceFieldRef() {
        return resourceFieldRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("resourceFieldRef")
    public void setResourceFieldRef(ResourceFieldSelector resourceFieldRef) {
        this.resourceFieldRef = resourceFieldRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("secretKeyRef")
    public SecretKeySelector getSecretKeyRef() {
        return secretKeyRef;
    }

    /**
     * EnvVarSource represents a source for the value of an EnvVar.
     */
    @JsonProperty("secretKeyRef")
    public void setSecretKeyRef(SecretKeySelector secretKeyRef) {
        this.secretKeyRef = secretKeyRef;
    }

    @JsonIgnore
    public EnvVarSourceBuilder edit() {
        return new EnvVarSourceBuilder(this);
    }

    @JsonIgnore
    public EnvVarSourceBuilder toBuilder() {
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
        if (!(o instanceof EnvVarSource)) {
            return false;
        }
        EnvVarSource other = (EnvVarSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configMapKeyRef = this.getConfigMapKeyRef();
        Object other$configMapKeyRef = other.getConfigMapKeyRef();
        if (this$configMapKeyRef == null ? other$configMapKeyRef != null : !this$configMapKeyRef.equals(other$configMapKeyRef)) {
            return false;
        }
        Object this$fieldRef = this.getFieldRef();
        Object other$fieldRef = other.getFieldRef();
        if (this$fieldRef == null ? other$fieldRef != null : !this$fieldRef.equals(other$fieldRef)) {
            return false;
        }
        Object this$fileKeyRef = this.getFileKeyRef();
        Object other$fileKeyRef = other.getFileKeyRef();
        if (this$fileKeyRef == null ? other$fileKeyRef != null : !this$fileKeyRef.equals(other$fileKeyRef)) {
            return false;
        }
        Object this$resourceFieldRef = this.getResourceFieldRef();
        Object other$resourceFieldRef = other.getResourceFieldRef();
        if (this$resourceFieldRef == null ? other$resourceFieldRef != null : !this$resourceFieldRef.equals(other$resourceFieldRef)) {
            return false;
        }
        Object this$secretKeyRef = this.getSecretKeyRef();
        Object other$secretKeyRef = other.getSecretKeyRef();
        if (this$secretKeyRef == null ? other$secretKeyRef != null : !this$secretKeyRef.equals(other$secretKeyRef)) {
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
        return other instanceof EnvVarSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configMapKeyRef = this.getConfigMapKeyRef();
        result = result * prime + ($configMapKeyRef == null ? 43 : $configMapKeyRef.hashCode());
        Object $fieldRef = this.getFieldRef();
        result = result * prime + ($fieldRef == null ? 43 : $fieldRef.hashCode());
        Object $fileKeyRef = this.getFileKeyRef();
        result = result * prime + ($fileKeyRef == null ? 43 : $fileKeyRef.hashCode());
        Object $resourceFieldRef = this.getResourceFieldRef();
        result = result * prime + ($resourceFieldRef == null ? 43 : $resourceFieldRef.hashCode());
        Object $secretKeyRef = this.getSecretKeyRef();
        result = result * prime + ($secretKeyRef == null ? 43 : $secretKeyRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EnvVarSource(" + "configMapKeyRef=" + this.getConfigMapKeyRef() + ", fieldRef=" + this.getFieldRef() + ", fileKeyRef=" + this.getFileKeyRef() + ", resourceFieldRef=" + this.getResourceFieldRef() + ", secretKeyRef=" + this.getSecretKeyRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
