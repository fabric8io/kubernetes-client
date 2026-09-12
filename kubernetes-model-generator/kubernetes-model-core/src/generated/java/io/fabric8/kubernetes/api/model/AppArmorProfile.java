
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
 * AppArmorProfile defines a pod or container's AppArmor settings.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "localhostProfile",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AppArmorProfile implements Editable<AppArmorProfileBuilder>, KubernetesResource
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
    public AppArmorProfile() {
    }

    public AppArmorProfile(String localhostProfile, String type) {
        super();
        this.localhostProfile = localhostProfile;
        this.type = type;
    }

    /**
     * localhostProfile indicates a profile loaded on the node that should be used. The profile must be preconfigured on the node to work. Must match the loaded name of the profile. Must be set if and only if type is "Localhost".
     */
    @JsonProperty("localhostProfile")
    public String getLocalhostProfile() {
        return localhostProfile;
    }

    /**
     * localhostProfile indicates a profile loaded on the node that should be used. The profile must be preconfigured on the node to work. Must match the loaded name of the profile. Must be set if and only if type is "Localhost".
     */
    @JsonProperty("localhostProfile")
    public void setLocalhostProfile(String localhostProfile) {
        this.localhostProfile = localhostProfile;
    }

    /**
     * type indicates which kind of AppArmor profile will be applied. Valid options are:<br><p>   Localhost - a profile pre-loaded on the node.<br><p>   RuntimeDefault - the container runtime's default profile.<br><p>   Unconfined - no AppArmor enforcement.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type indicates which kind of AppArmor profile will be applied. Valid options are:<br><p>   Localhost - a profile pre-loaded on the node.<br><p>   RuntimeDefault - the container runtime's default profile.<br><p>   Unconfined - no AppArmor enforcement.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AppArmorProfileBuilder edit() {
        return new AppArmorProfileBuilder(this);
    }

    @JsonIgnore
    public AppArmorProfileBuilder toBuilder() {
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
        if (!(o instanceof AppArmorProfile)) {
            return false;
        }
        AppArmorProfile other = (AppArmorProfile) o;
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
        return other instanceof AppArmorProfile;
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
        return "AppArmorProfile(" + "localhostProfile=" + this.getLocalhostProfile() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
