
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "name",
    "preferredVersion",
    "serverAddressByClientCIDRs",
    "versions"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@VelocityTransformations({
    @VelocityTransformation(value = "/manifest.vm", outputPath = "core.properties", gather = true)
})
public class APIGroup implements KubernetesResource
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "APIGroup";
    @JsonProperty("name")
    private String name;
    @JsonProperty("preferredVersion")
    private GroupVersionForDiscovery preferredVersion;
    @JsonProperty("serverAddressByClientCIDRs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServerAddressByClientCIDR> serverAddressByClientCIDRs = new ArrayList<ServerAddressByClientCIDR>();
    @JsonProperty("versions")
    private List<GroupVersionForDiscovery> versions = new ArrayList<GroupVersionForDiscovery>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public APIGroup() {
    }

    /**
     * 
     * @param apiVersion
     * @param versions
     * @param kind
     * @param preferredVersion
     * @param name
     * @param serverAddressByClientCIDRs
     */
    public APIGroup(String apiVersion, String kind, String name, GroupVersionForDiscovery preferredVersion, List<ServerAddressByClientCIDR> serverAddressByClientCIDRs, List<GroupVersionForDiscovery> versions) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.name = name;
        this.preferredVersion = preferredVersion;
        this.serverAddressByClientCIDRs = serverAddressByClientCIDRs;
        this.versions = versions;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("preferredVersion")
    public GroupVersionForDiscovery getPreferredVersion() {
        return preferredVersion;
    }

    @JsonProperty("preferredVersion")
    public void setPreferredVersion(GroupVersionForDiscovery preferredVersion) {
        this.preferredVersion = preferredVersion;
    }

    @JsonProperty("serverAddressByClientCIDRs")
    public List<ServerAddressByClientCIDR> getServerAddressByClientCIDRs() {
        return serverAddressByClientCIDRs;
    }

    @JsonProperty("serverAddressByClientCIDRs")
    public void setServerAddressByClientCIDRs(List<ServerAddressByClientCIDR> serverAddressByClientCIDRs) {
        this.serverAddressByClientCIDRs = serverAddressByClientCIDRs;
    }

    @JsonProperty("versions")
    public List<GroupVersionForDiscovery> getVersions() {
        return versions;
    }

    @JsonProperty("versions")
    public void setVersions(List<GroupVersionForDiscovery> versions) {
        this.versions = versions;
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
