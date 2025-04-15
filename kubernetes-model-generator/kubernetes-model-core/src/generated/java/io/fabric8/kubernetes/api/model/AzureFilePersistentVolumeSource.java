
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
 * AzureFile represents an Azure File Service mount on the host and bind mount to the pod.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "readOnly",
    "secretName",
    "secretNamespace",
    "shareName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AzureFilePersistentVolumeSource implements Editable<AzureFilePersistentVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("secretNamespace")
    private String secretNamespace;
    @JsonProperty("shareName")
    private String shareName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureFilePersistentVolumeSource() {
    }

    public AzureFilePersistentVolumeSource(Boolean readOnly, String secretName, String secretNamespace, String shareName) {
        super();
        this.readOnly = readOnly;
        this.secretName = secretName;
        this.secretNamespace = secretNamespace;
        this.shareName = shareName;
    }

    /**
     * readOnly defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * secretName is the name of secret that contains Azure Storage Account Name and Key
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    /**
     * secretName is the name of secret that contains Azure Storage Account Name and Key
     */
    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    /**
     * secretNamespace is the namespace of the secret that contains Azure Storage Account Name and Key default is the same as the Pod
     */
    @JsonProperty("secretNamespace")
    public String getSecretNamespace() {
        return secretNamespace;
    }

    /**
     * secretNamespace is the namespace of the secret that contains Azure Storage Account Name and Key default is the same as the Pod
     */
    @JsonProperty("secretNamespace")
    public void setSecretNamespace(String secretNamespace) {
        this.secretNamespace = secretNamespace;
    }

    /**
     * shareName is the azure Share Name
     */
    @JsonProperty("shareName")
    public String getShareName() {
        return shareName;
    }

    /**
     * shareName is the azure Share Name
     */
    @JsonProperty("shareName")
    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    @JsonIgnore
    public AzureFilePersistentVolumeSourceBuilder edit() {
        return new AzureFilePersistentVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public AzureFilePersistentVolumeSourceBuilder toBuilder() {
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
