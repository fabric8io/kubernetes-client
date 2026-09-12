
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
 * Maps a string key to a path within a volume.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "mode",
    "path",
    "user"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class KeyToPath implements Editable<KeyToPathBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("mode")
    private Integer mode;
    @JsonProperty("path")
    private String path;
    @JsonProperty("user")
    private Long user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KeyToPath() {
    }

    public KeyToPath(String key, Integer mode, String path, Long user) {
        super();
        this.key = key;
        this.mode = mode;
        this.path = path;
        this.user = user;
    }

    /**
     * key is the key to project.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * key is the key to project.
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * mode is Optional: mode bits used to set permissions on this file. Must be an octal value between 0000 and 0777 or a decimal value between 0 and 511. YAML accepts both octal and decimal values, JSON requires decimal values for mode bits. If not specified, the volume defaultMode will be used. This might be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits set.
     */
    @JsonProperty("mode")
    public Integer getMode() {
        return mode;
    }

    /**
     * mode is Optional: mode bits used to set permissions on this file. Must be an octal value between 0000 and 0777 or a decimal value between 0 and 511. YAML accepts both octal and decimal values, JSON requires decimal values for mode bits. If not specified, the volume defaultMode will be used. This might be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits set.
     */
    @JsonProperty("mode")
    public void setMode(Integer mode) {
        this.mode = mode;
    }

    /**
     * path is the relative path of the file to map the key to. May not be an absolute path. May not contain the path element '..'. May not start with the string '..'.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path is the relative path of the file to map the key to. May not be an absolute path. May not contain the path element '..'. May not start with the string '..'.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * user is Optional: The owner UID of the created file. If specified, the item-level user field takes precedence over defaultUser. (Alpha) This field requires the AtomicWriteVolumeUserFields feature gate to be enabled.
     */
    @JsonProperty("user")
    public Long getUser() {
        return user;
    }

    /**
     * user is Optional: The owner UID of the created file. If specified, the item-level user field takes precedence over defaultUser. (Alpha) This field requires the AtomicWriteVolumeUserFields feature gate to be enabled.
     */
    @JsonProperty("user")
    public void setUser(Long user) {
        this.user = user;
    }

    @JsonIgnore
    public KeyToPathBuilder edit() {
        return new KeyToPathBuilder(this);
    }

    @JsonIgnore
    public KeyToPathBuilder toBuilder() {
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
        if (!(o instanceof KeyToPath)) {
            return false;
        }
        KeyToPath other = (KeyToPath) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$key = this.getKey();
        Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$user = this.getUser();
        Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) {
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
        return other instanceof KeyToPath;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $key = this.getKey();
        result = result * prime + ($key == null ? 43 : $key.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KeyToPath(" + "key=" + this.getKey() + ", mode=" + this.getMode() + ", path=" + this.getPath() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
