
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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "readOnly",
    "secretName",
    "secretNamespace",
    "shareName"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class AzureFilePersistentVolumeSource implements KubernetesResource
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
     * 
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

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    @JsonProperty("secretNamespace")
    public String getSecretNamespace() {
        return secretNamespace;
    }

    @JsonProperty("secretNamespace")
    public void setSecretNamespace(String secretNamespace) {
        this.secretNamespace = secretNamespace;
    }

    @JsonProperty("shareName")
    public String getShareName() {
        return shareName;
    }

    @JsonProperty("shareName")
    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
