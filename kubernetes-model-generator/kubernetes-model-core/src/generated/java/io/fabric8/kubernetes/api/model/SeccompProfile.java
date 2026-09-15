
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
 * SeccompProfile defines a pod/container's seccomp profile settings. Only one profile source may be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "localhostProfile",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SeccompProfile implements Editable<SeccompProfileBuilder>, KubernetesResource
{

    @JsonProperty("localhostProfile")
    private String localhostProfile;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SeccompProfile() {
    }

    public SeccompProfile(String localhostProfile, String type) {
        super();
        this.localhostProfile = localhostProfile;
        this.type = type;
    }

    /**
     * localhostProfile indicates a profile defined in a file on the node should be used. The profile must be preconfigured on the node to work. Must be a descending path, relative to the kubelet's configured seccomp profile location. Must be set if type is "Localhost". Must NOT be set for any other type.
     */
    @JsonProperty("localhostProfile")
    public String getLocalhostProfile() {
        return localhostProfile;
    }

    /**
     * localhostProfile indicates a profile defined in a file on the node should be used. The profile must be preconfigured on the node to work. Must be a descending path, relative to the kubelet's configured seccomp profile location. Must be set if type is "Localhost". Must NOT be set for any other type.
     */
    @JsonProperty("localhostProfile")
    public void setLocalhostProfile(String localhostProfile) {
        this.localhostProfile = localhostProfile;
    }

    /**
     * type indicates which kind of seccomp profile will be applied. Valid options are:<br><p> <br><p> Localhost - a profile defined in a file on the node should be used. RuntimeDefault - the container runtime default profile should be used. Unconfined - no profile should be applied.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type indicates which kind of seccomp profile will be applied. Valid options are:<br><p> <br><p> Localhost - a profile defined in a file on the node should be used. RuntimeDefault - the container runtime default profile should be used. Unconfined - no profile should be applied.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public SeccompProfileBuilder edit() {
        return new SeccompProfileBuilder(this);
    }

    @JsonIgnore
    public SeccompProfileBuilder toBuilder() {
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
        if (!(o instanceof SeccompProfile)) {
            return false;
        }
        SeccompProfile other = (SeccompProfile) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$localhostProfile = this.getLocalhostProfile();
        Object other$localhostProfile = other.getLocalhostProfile();
        if (this$localhostProfile == null ? other$localhostProfile != null : !this$localhostProfile.equals(other$localhostProfile)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof SeccompProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $localhostProfile = this.getLocalhostProfile();
        result = result * prime + ($localhostProfile == null ? 43 : $localhostProfile.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SeccompProfile(" + "localhostProfile=" + this.getLocalhostProfile() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
