
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "allowWatchBookmarks",
    "continue",
    "fieldSelector",
    "labelSelector",
    "limit",
    "resourceVersion",
    "resourceVersionMatch",
    "timeoutSeconds",
    "watch"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ListOptions implements KubernetesResource
{

    @JsonProperty("allowWatchBookmarks")
    private Boolean allowWatchBookmarks;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("continue")
    private String _continue;
    @JsonProperty("fieldSelector")
    private String fieldSelector;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "ListOptions";
    @JsonProperty("labelSelector")
    private String labelSelector;
    @JsonProperty("limit")
    private Long limit;
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("resourceVersionMatch")
    private String resourceVersionMatch;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonProperty("watch")
    private Boolean watch;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListOptions() {
    }

    /**
     * 
     * @param _continue
     * @param resourceVersionMatch
     * @param apiVersion
     * @param watch
     * @param kind
     * @param resourceVersion
     * @param labelSelector
     * @param limit
     * @param timeoutSeconds
     * @param fieldSelector
     * @param allowWatchBookmarks
     */
    public ListOptions(Boolean allowWatchBookmarks, String apiVersion, String _continue, String fieldSelector, String kind, String labelSelector, Long limit, String resourceVersion, String resourceVersionMatch, Long timeoutSeconds, Boolean watch) {
        super();
        this.allowWatchBookmarks = allowWatchBookmarks;
        this.apiVersion = apiVersion;
        this._continue = _continue;
        this.fieldSelector = fieldSelector;
        this.kind = kind;
        this.labelSelector = labelSelector;
        this.limit = limit;
        this.resourceVersion = resourceVersion;
        this.resourceVersionMatch = resourceVersionMatch;
        this.timeoutSeconds = timeoutSeconds;
        this.watch = watch;
    }

    @JsonProperty("allowWatchBookmarks")
    public Boolean getAllowWatchBookmarks() {
        return allowWatchBookmarks;
    }

    @JsonProperty("allowWatchBookmarks")
    public void setAllowWatchBookmarks(Boolean allowWatchBookmarks) {
        this.allowWatchBookmarks = allowWatchBookmarks;
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

    @JsonProperty("continue")
    public String getContinue() {
        return _continue;
    }

    @JsonProperty("continue")
    public void setContinue(String _continue) {
        this._continue = _continue;
    }

    @JsonProperty("fieldSelector")
    public String getFieldSelector() {
        return fieldSelector;
    }

    @JsonProperty("fieldSelector")
    public void setFieldSelector(String fieldSelector) {
        this.fieldSelector = fieldSelector;
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

    @JsonProperty("labelSelector")
    public String getLabelSelector() {
        return labelSelector;
    }

    @JsonProperty("labelSelector")
    public void setLabelSelector(String labelSelector) {
        this.labelSelector = labelSelector;
    }

    @JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @JsonProperty("resourceVersion")
    public String getResourceVersion() {
        return resourceVersion;
    }

    @JsonProperty("resourceVersion")
    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    @JsonProperty("resourceVersionMatch")
    public String getResourceVersionMatch() {
        return resourceVersionMatch;
    }

    @JsonProperty("resourceVersionMatch")
    public void setResourceVersionMatch(String resourceVersionMatch) {
        this.resourceVersionMatch = resourceVersionMatch;
    }

    @JsonProperty("timeoutSeconds")
    public Long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonProperty("watch")
    public Boolean getWatch() {
        return watch;
    }

    @JsonProperty("watch")
    public void setWatch(Boolean watch) {
        this.watch = watch;
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
