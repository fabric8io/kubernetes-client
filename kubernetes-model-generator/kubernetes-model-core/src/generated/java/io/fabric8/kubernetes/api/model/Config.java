
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "clusters",
    "contexts",
    "current-context",
    "extensions",
    "preferences",
    "users"
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
public class Config implements KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedCluster> clusters = new ArrayList<NamedCluster>();
    @JsonProperty("contexts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedContext> contexts = new ArrayList<NamedContext>();
    @JsonProperty("current-context")
    private String currentContext;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedExtension> extensions = new ArrayList<NamedExtension>();
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("preferences")
    private Preferences preferences;
    @JsonProperty("users")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedAuthInfo> users = new ArrayList<NamedAuthInfo>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Config() {
    }

    public Config(String apiVersion, List<NamedCluster> clusters, List<NamedContext> contexts, String currentContext, List<NamedExtension> extensions, String kind, Preferences preferences, List<NamedAuthInfo> users) {
        super();
        this.apiVersion = apiVersion;
        this.clusters = clusters;
        this.contexts = contexts;
        this.currentContext = currentContext;
        this.extensions = extensions;
        this.kind = kind;
        this.preferences = preferences;
        this.users = users;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("clusters")
    public List<NamedCluster> getClusters() {
        return clusters;
    }

    @JsonProperty("clusters")
    public void setClusters(List<NamedCluster> clusters) {
        this.clusters = clusters;
    }

    @JsonProperty("contexts")
    public List<NamedContext> getContexts() {
        return contexts;
    }

    @JsonProperty("contexts")
    public void setContexts(List<NamedContext> contexts) {
        this.contexts = contexts;
    }

    @JsonProperty("current-context")
    public String getCurrentContext() {
        return currentContext;
    }

    @JsonProperty("current-context")
    public void setCurrentContext(String currentContext) {
        this.currentContext = currentContext;
    }

    @JsonProperty("extensions")
    public List<NamedExtension> getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(List<NamedExtension> extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("preferences")
    public Preferences getPreferences() {
        return preferences;
    }

    @JsonProperty("preferences")
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    @JsonProperty("users")
    public List<NamedAuthInfo> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(List<NamedAuthInfo> users) {
        this.users = users;
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
