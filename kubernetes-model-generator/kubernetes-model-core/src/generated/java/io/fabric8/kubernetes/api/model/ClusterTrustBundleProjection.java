
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
 * ClusterTrustBundleProjection describes how to select a set of ClusterTrustBundle objects and project their contents into the pod filesystem.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labelSelector",
    "name",
    "optional",
    "path",
    "signerName",
    "user"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterTrustBundleProjection implements Editable<ClusterTrustBundleProjectionBuilder>, KubernetesResource
{

    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonProperty("name")
    private String name;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("path")
    private String path;
    @JsonProperty("signerName")
    private String signerName;
    @JsonProperty("user")
    private Long user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterTrustBundleProjection() {
    }

    public ClusterTrustBundleProjection(LabelSelector labelSelector, String name, Boolean optional, String path, String signerName, Long user) {
        super();
        this.labelSelector = labelSelector;
        this.name = name;
        this.optional = optional;
        this.path = path;
        this.signerName = signerName;
        this.user = user;
    }

    /**
     * ClusterTrustBundleProjection describes how to select a set of ClusterTrustBundle objects and project their contents into the pod filesystem.
     */
    @JsonProperty("labelSelector")
    public LabelSelector getLabelSelector() {
        return labelSelector;
    }

    /**
     * ClusterTrustBundleProjection describes how to select a set of ClusterTrustBundle objects and project their contents into the pod filesystem.
     */
    @JsonProperty("labelSelector")
    public void setLabelSelector(LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    /**
     * Select a single ClusterTrustBundle by object name.  Mutually-exclusive with signerName and labelSelector.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Select a single ClusterTrustBundle by object name.  Mutually-exclusive with signerName and labelSelector.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * If true, don't block pod startup if the referenced ClusterTrustBundle(s) aren't available.  If using name, then the named ClusterTrustBundle is allowed not to exist.  If using signerName, then the combination of signerName and labelSelector is allowed to match zero ClusterTrustBundles.
     */
    @JsonProperty("optional")
    public Boolean getOptional() {
        return optional;
    }

    /**
     * If true, don't block pod startup if the referenced ClusterTrustBundle(s) aren't available.  If using name, then the named ClusterTrustBundle is allowed not to exist.  If using signerName, then the combination of signerName and labelSelector is allowed to match zero ClusterTrustBundles.
     */
    @JsonProperty("optional")
    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    /**
     * Relative path from the volume root to write the bundle.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Relative path from the volume root to write the bundle.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Select all ClusterTrustBundles that match this signer name. Mutually-exclusive with name.  The contents of all selected ClusterTrustBundles will be unified and deduplicated.
     */
    @JsonProperty("signerName")
    public String getSignerName() {
        return signerName;
    }

    /**
     * Select all ClusterTrustBundles that match this signer name. Mutually-exclusive with name.  The contents of all selected ClusterTrustBundles will be unified and deduplicated.
     */
    @JsonProperty("signerName")
    public void setSignerName(String signerName) {
        this.signerName = signerName;
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
    public ClusterTrustBundleProjectionBuilder edit() {
        return new ClusterTrustBundleProjectionBuilder(this);
    }

    @JsonIgnore
    public ClusterTrustBundleProjectionBuilder toBuilder() {
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
        if (!(o instanceof ClusterTrustBundleProjection)) {
            return false;
        }
        ClusterTrustBundleProjection other = (ClusterTrustBundleProjection) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$labelSelector = this.getLabelSelector();
        Object other$labelSelector = other.getLabelSelector();
        if (this$labelSelector == null ? other$labelSelector != null : !this$labelSelector.equals(other$labelSelector)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        Object this$signerName = this.getSignerName();
        Object other$signerName = other.getSignerName();
        if (this$signerName == null ? other$signerName != null : !this$signerName.equals(other$signerName)) {
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
        return other instanceof ClusterTrustBundleProjection;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $labelSelector = this.getLabelSelector();
        result = result * prime + ($labelSelector == null ? 43 : $labelSelector.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $optional = this.getOptional();
        result = result * prime + ($optional == null ? 43 : $optional.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $signerName = this.getSignerName();
        result = result * prime + ($signerName == null ? 43 : $signerName.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterTrustBundleProjection(" + "labelSelector=" + this.getLabelSelector() + ", name=" + this.getName() + ", optional=" + this.getOptional() + ", path=" + this.getPath() + ", signerName=" + this.getSignerName() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
