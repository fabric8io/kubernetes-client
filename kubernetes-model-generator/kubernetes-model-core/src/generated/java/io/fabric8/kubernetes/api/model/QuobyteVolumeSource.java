
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
 * Represents a Quobyte mount that lasts the lifetime of a pod. Quobyte volumes do not support ownership management or SELinux relabeling.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group",
    "readOnly",
    "registry",
    "tenant",
    "user",
    "volume"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class QuobyteVolumeSource implements Editable<QuobyteVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("registry")
    private String registry;
    @JsonProperty("tenant")
    private String tenant;
    @JsonProperty("user")
    private String user;
    @JsonProperty("volume")
    private String volume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public QuobyteVolumeSource() {
    }

    public QuobyteVolumeSource(String group, Boolean readOnly, String registry, String tenant, String user, String volume) {
        super();
        this.group = group;
        this.readOnly = readOnly;
        this.registry = registry;
        this.tenant = tenant;
        this.user = user;
        this.volume = volume;
    }

    /**
     * group to map volume access to Default is no group
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * group to map volume access to Default is no group
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * readOnly here will force the Quobyte volume to be mounted with read-only permissions. Defaults to false.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly here will force the Quobyte volume to be mounted with read-only permissions. Defaults to false.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * registry represents a single or multiple Quobyte Registry services specified as a string as host:port pair (multiple entries are separated with commas) which acts as the central registry for volumes
     */
    @JsonProperty("registry")
    public String getRegistry() {
        return registry;
    }

    /**
     * registry represents a single or multiple Quobyte Registry services specified as a string as host:port pair (multiple entries are separated with commas) which acts as the central registry for volumes
     */
    @JsonProperty("registry")
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    /**
     * tenant owning the given Quobyte volume in the Backend Used with dynamically provisioned Quobyte volumes, value is set by the plugin
     */
    @JsonProperty("tenant")
    public String getTenant() {
        return tenant;
    }

    /**
     * tenant owning the given Quobyte volume in the Backend Used with dynamically provisioned Quobyte volumes, value is set by the plugin
     */
    @JsonProperty("tenant")
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    /**
     * user to map volume access to Defaults to serivceaccount user
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * user to map volume access to Defaults to serivceaccount user
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * volume is a string that references an already created Quobyte volume by name.
     */
    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }

    /**
     * volume is a string that references an already created Quobyte volume by name.
     */
    @JsonProperty("volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @JsonIgnore
    public QuobyteVolumeSourceBuilder edit() {
        return new QuobyteVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public QuobyteVolumeSourceBuilder toBuilder() {
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
