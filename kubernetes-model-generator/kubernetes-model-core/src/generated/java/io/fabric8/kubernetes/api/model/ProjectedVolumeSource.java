
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * Represents a projected volume source
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "defaultMode",
    "defaultUser",
    "sources"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ProjectedVolumeSource implements Editable<ProjectedVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("defaultMode")
    private Integer defaultMode;
    @JsonProperty("defaultUser")
    private Long defaultUser;
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VolumeProjection> sources = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProjectedVolumeSource() {
    }

    public ProjectedVolumeSource(Integer defaultMode, Long defaultUser, List<VolumeProjection> sources) {
        super();
        this.defaultMode = defaultMode;
        this.defaultUser = defaultUser;
        this.sources = sources;
    }

    /**
     * defaultMode are the mode bits used to set permissions on created files by default. Must be an octal value between 0000 and 0777 or a decimal value between 0 and 511. YAML accepts both octal and decimal values, JSON requires decimal values for mode bits. Directories within the path are not affected by this setting. This might be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits set.
     */
    @JsonProperty("defaultMode")
    public Integer getDefaultMode() {
        return defaultMode;
    }

    /**
     * defaultMode are the mode bits used to set permissions on created files by default. Must be an octal value between 0000 and 0777 or a decimal value between 0 and 511. YAML accepts both octal and decimal values, JSON requires decimal values for mode bits. Directories within the path are not affected by this setting. This might be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits set.
     */
    @JsonProperty("defaultMode")
    public void setDefaultMode(Integer defaultMode) {
        this.defaultMode = defaultMode;
    }

    /**
     * defaultUser is Optional: The owner UID of the created files by default. The defaultUser field is only used as a fallback when the item-level user field is unset. (Alpha) This field requires the AtomicWriteVolumeUserFields feature gate to be enabled.
     */
    @JsonProperty("defaultUser")
    public Long getDefaultUser() {
        return defaultUser;
    }

    /**
     * defaultUser is Optional: The owner UID of the created files by default. The defaultUser field is only used as a fallback when the item-level user field is unset. (Alpha) This field requires the AtomicWriteVolumeUserFields feature gate to be enabled.
     */
    @JsonProperty("defaultUser")
    public void setDefaultUser(Long defaultUser) {
        this.defaultUser = defaultUser;
    }

    /**
     * sources is the list of volume projections. Each entry in this list handles one source.
     */
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VolumeProjection> getSources() {
        return sources;
    }

    /**
     * sources is the list of volume projections. Each entry in this list handles one source.
     */
    @JsonProperty("sources")
    public void setSources(List<VolumeProjection> sources) {
        this.sources = sources;
    }

    @JsonIgnore
    public ProjectedVolumeSourceBuilder edit() {
        return new ProjectedVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public ProjectedVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof ProjectedVolumeSource)) {
            return false;
        }
        ProjectedVolumeSource other = (ProjectedVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$defaultMode = this.getDefaultMode();
        Object other$defaultMode = other.getDefaultMode();
        if (this$defaultMode == null ? other$defaultMode != null : !this$defaultMode.equals(other$defaultMode)) {
            return false;
        }
        Object this$defaultUser = this.getDefaultUser();
        Object other$defaultUser = other.getDefaultUser();
        if (this$defaultUser == null ? other$defaultUser != null : !this$defaultUser.equals(other$defaultUser)) {
            return false;
        }
        Object this$sources = this.getSources();
        Object other$sources = other.getSources();
        if (this$sources == null ? other$sources != null : !this$sources.equals(other$sources)) {
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
        return other instanceof ProjectedVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $defaultMode = this.getDefaultMode();
        result = result * prime + ($defaultMode == null ? 43 : $defaultMode.hashCode());
        Object $defaultUser = this.getDefaultUser();
        result = result * prime + ($defaultUser == null ? 43 : $defaultUser.hashCode());
        Object $sources = this.getSources();
        result = result * prime + ($sources == null ? 43 : $sources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProjectedVolumeSource(" + "defaultMode=" + this.getDefaultMode() + ", defaultUser=" + this.getDefaultUser() + ", sources=" + this.getSources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
