
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
 * GroupVersion contains the "group/version" and "version" string of a version. It is made a struct to keep extensibility.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupVersion",
    "version"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
