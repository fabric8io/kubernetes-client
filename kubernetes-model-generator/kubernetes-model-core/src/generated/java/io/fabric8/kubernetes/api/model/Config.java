
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "clusters",
    "contexts",
    "current-context",
    "extensions",
    "preferences",
    "users"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Config implements Editable<ConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedCluster> clusters = new ArrayList<>();
    @JsonProperty("contexts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedContext> contexts = new ArrayList<>();
    @JsonProperty("current-context")
    private String currentContext;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedExtension> extensions = new ArrayList<>();
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("preferences")
    private Preferences preferences;
    @JsonProperty("users")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedAuthInfo> users = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedCluster> getClusters() {
        return clusters;
    }

    @JsonProperty("clusters")
    public void setClusters(List<NamedCluster> clusters) {
        this.clusters = clusters;
    }

    @JsonProperty("contexts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedAuthInfo> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(List<NamedAuthInfo> users) {
        this.users = users;
    }

    @JsonIgnore
    public ConfigBuilder edit() {
        return new ConfigBuilder(this);
    }

    @JsonIgnore
    public ConfigBuilder toBuilder() {
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
        if (!(o instanceof Config)) {
            return false;
        }
        Config other = (Config) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$clusters = this.getClusters();
        Object other$clusters = other.getClusters();
        if (this$clusters == null ? other$clusters != null : !this$clusters.equals(other$clusters)) {
            return false;
        }
        Object this$contexts = this.getContexts();
        Object other$contexts = other.getContexts();
        if (this$contexts == null ? other$contexts != null : !this$contexts.equals(other$contexts)) {
            return false;
        }
        Object this$currentContext = this.getCurrentContext();
        Object other$currentContext = other.getCurrentContext();
        if (this$currentContext == null ? other$currentContext != null : !this$currentContext.equals(other$currentContext)) {
            return false;
        }
        Object this$extensions = this.getExtensions();
        Object other$extensions = other.getExtensions();
        if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$preferences = this.getPreferences();
        Object other$preferences = other.getPreferences();
        if (this$preferences == null ? other$preferences != null : !this$preferences.equals(other$preferences)) {
            return false;
        }
        Object this$users = this.getUsers();
        Object other$users = other.getUsers();
        if (this$users == null ? other$users != null : !this$users.equals(other$users)) {
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
        return other instanceof Config;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $clusters = this.getClusters();
        result = result * prime + ($clusters == null ? 43 : $clusters.hashCode());
        Object $contexts = this.getContexts();
        result = result * prime + ($contexts == null ? 43 : $contexts.hashCode());
        Object $currentContext = this.getCurrentContext();
        result = result * prime + ($currentContext == null ? 43 : $currentContext.hashCode());
        Object $extensions = this.getExtensions();
        result = result * prime + ($extensions == null ? 43 : $extensions.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $preferences = this.getPreferences();
        result = result * prime + ($preferences == null ? 43 : $preferences.hashCode());
        Object $users = this.getUsers();
        result = result * prime + ($users == null ? 43 : $users.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Config(" + "apiVersion=" + this.getApiVersion() + ", clusters=" + this.getClusters() + ", contexts=" + this.getContexts() + ", currentContext=" + this.getCurrentContext() + ", extensions=" + this.getExtensions() + ", kind=" + this.getKind() + ", preferences=" + this.getPreferences() + ", users=" + this.getUsers() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
