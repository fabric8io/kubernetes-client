
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
    "group",
    "readOnly",
    "registry",
    "tenant",
    "user",
    "volume"
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
public class QuobyteVolumeSource implements KubernetesResource
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
     * 
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

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("registry")
    public String getRegistry() {
        return registry;
    }

    @JsonProperty("registry")
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    @JsonProperty("tenant")
    public String getTenant() {
        return tenant;
    }

    @JsonProperty("tenant")
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(String volume) {
        this.volume = volume;
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
