
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
 * GroupVersion contains the "group/version" and "version" string of a version. It is made a struct to keep extensibility.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupVersion",
    "version"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GroupVersionForDiscovery implements Editable<GroupVersionForDiscoveryBuilder>, KubernetesResource
{

    @JsonProperty("groupVersion")
    private String groupVersion;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GroupVersionForDiscovery() {
    }

    public GroupVersionForDiscovery(String groupVersion, String version) {
        super();
        this.groupVersion = groupVersion;
        this.version = version;
    }

    /**
     * groupVersion specifies the API group and version in the form "group/version"
     */
    @JsonProperty("groupVersion")
    public String getGroupVersion() {
        return groupVersion;
    }

    /**
     * groupVersion specifies the API group and version in the form "group/version"
     */
    @JsonProperty("groupVersion")
    public void setGroupVersion(String groupVersion) {
        this.groupVersion = groupVersion;
    }

    /**
     * version specifies the version in the form of "version". This is to save the clients the trouble of splitting the GroupVersion.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version specifies the version in the form of "version". This is to save the clients the trouble of splitting the GroupVersion.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public GroupVersionForDiscoveryBuilder edit() {
        return new GroupVersionForDiscoveryBuilder(this);
    }

    @JsonIgnore
    public GroupVersionForDiscoveryBuilder toBuilder() {
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
        if (!(o instanceof GroupVersionForDiscovery)) {
            return false;
        }
        GroupVersionForDiscovery other = (GroupVersionForDiscovery) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$groupVersion = this.getGroupVersion();
        Object other$groupVersion = other.getGroupVersion();
        if (this$groupVersion == null ? other$groupVersion != null : !this$groupVersion.equals(other$groupVersion)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof GroupVersionForDiscovery;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $groupVersion = this.getGroupVersion();
        result = result * prime + ($groupVersion == null ? 43 : $groupVersion.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GroupVersionForDiscovery(" + "groupVersion=" + this.getGroupVersion() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
