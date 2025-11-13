
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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
