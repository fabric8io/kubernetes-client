
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
 * FileKeySelector selects a key of the env file.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "optional",
    "path",
    "volumeName"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FileKeySelector implements Editable<FileKeySelectorBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("path")
    private String path;
    @JsonProperty("volumeName")
    private String volumeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FileKeySelector() {
    }

    public FileKeySelector(String key, Boolean optional, String path, String volumeName) {
        super();
        this.key = key;
        this.optional = optional;
        this.path = path;
        this.volumeName = volumeName;
    }

    /**
     * The key within the env file. An invalid key will prevent the pod from starting. The keys defined within a source may consist of any printable ASCII characters except '='. During Alpha stage of the EnvFiles feature gate, the key size is limited to 128 characters.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * The key within the env file. An invalid key will prevent the pod from starting. The keys defined within a source may consist of any printable ASCII characters except '='. During Alpha stage of the EnvFiles feature gate, the key size is limited to 128 characters.
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Specify whether the file or its key must be defined. If the file or key does not exist, then the env var is not published. If optional is set to true and the specified key does not exist, the environment variable will not be set in the Pod's containers.<br><p> <br><p> If optional is set to false and the specified key does not exist, an error will be returned during Pod creation.
     */
    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    /**
     * Specify whether the file or its key must be defined. If the file or key does not exist, then the env var is not published. If optional is set to true and the specified key does not exist, the environment variable will not be set in the Pod's containers.<br><p> <br><p> If optional is set to false and the specified key does not exist, an error will be returned during Pod creation.
     */
    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    /**
     * The path within the volume from which to select the file. Must be relative and may not contain the '..' path or start with '..'.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * The path within the volume from which to select the file. Must be relative and may not contain the '..' path or start with '..'.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * The name of the volume mount containing the env file.
     */
    @JsonProperty("volumeName")
    public String getVolumeName() {
        return volumeName;
    }

    /**
     * The name of the volume mount containing the env file.
     */
    @JsonProperty("volumeName")
    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    @JsonIgnore
    public FileKeySelectorBuilder edit() {
        return new FileKeySelectorBuilder(this);
    }

    @JsonIgnore
    public FileKeySelectorBuilder toBuilder() {
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
        if (!(o instanceof FileKeySelector)) {
            return false;
        }
        FileKeySelector other = (FileKeySelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$key = this.getKey();
        Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        Object this$optional = this.getOptional();
        Object other$optional = other.getOptional();
        if (this$optional == null ? other$optional != null : !this$optional.equals(other$optional)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$volumeName = this.getVolumeName();
        Object other$volumeName = other.getVolumeName();
        if (this$volumeName == null ? other$volumeName != null : !this$volumeName.equals(other$volumeName)) {
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
        return other instanceof FileKeySelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $key = this.getKey();
        result = result * prime + ($key == null ? 43 : $key.hashCode());
        Object $optional = this.getOptional();
        result = result * prime + ($optional == null ? 43 : $optional.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $volumeName = this.getVolumeName();
        result = result * prime + ($volumeName == null ? 43 : $volumeName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FileKeySelector(" + "key=" + this.getKey() + ", optional=" + this.getOptional() + ", path=" + this.getPath() + ", volumeName=" + this.getVolumeName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
