
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "allowWatchBookmarks",
    "continue",
    "fieldSelector",
    "labelSelector",
    "limit",
    "resourceVersion",
    "resourceVersionMatch",
    "sendInitialEvents",
    "shardSelector",
    "timeoutSeconds",
    "watch"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ListOptions implements Editable<ListOptionsBuilder>, KubernetesResource
{

    @JsonProperty("allowWatchBookmarks")
    private Boolean allowWatchBookmarks;
    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("continue")
    private String _continue;
    @JsonProperty("fieldSelector")
    private String fieldSelector;
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
    @JsonProperty("sendInitialEvents")
    private Boolean sendInitialEvents;
    @JsonProperty("shardSelector")
    private String shardSelector;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonProperty("watch")
    private Boolean watch;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListOptions() {
    }

    public ListOptions(Boolean allowWatchBookmarks, String apiVersion, String _continue, String fieldSelector, String kind, String labelSelector, Long limit, String resourceVersion, String resourceVersionMatch, Boolean sendInitialEvents, String shardSelector, Long timeoutSeconds, Boolean watch) {
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
        this.sendInitialEvents = sendInitialEvents;
        this.shardSelector = shardSelector;
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

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

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

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

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

    @JsonProperty("sendInitialEvents")
    public Boolean getSendInitialEvents() {
        return sendInitialEvents;
    }

    @JsonProperty("sendInitialEvents")
    public void setSendInitialEvents(Boolean sendInitialEvents) {
        this.sendInitialEvents = sendInitialEvents;
    }

    @JsonProperty("shardSelector")
    public String getShardSelector() {
        return shardSelector;
    }

    @JsonProperty("shardSelector")
    public void setShardSelector(String shardSelector) {
        this.shardSelector = shardSelector;
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

    @JsonIgnore
    public ListOptionsBuilder edit() {
        return new ListOptionsBuilder(this);
    }

    @JsonIgnore
    public ListOptionsBuilder toBuilder() {
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
        if (!(o instanceof ListOptions)) {
            return false;
        }
        ListOptions other = (ListOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowWatchBookmarks = this.getAllowWatchBookmarks();
        Object other$allowWatchBookmarks = other.getAllowWatchBookmarks();
        if (this$allowWatchBookmarks == null ? other$allowWatchBookmarks != null : !this$allowWatchBookmarks.equals(other$allowWatchBookmarks)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$_continue = this.getContinue();
        Object other$_continue = other.getContinue();
        if (this$_continue == null ? other$_continue != null : !this$_continue.equals(other$_continue)) {
            return false;
        }
        Object this$fieldSelector = this.getFieldSelector();
        Object other$fieldSelector = other.getFieldSelector();
        if (this$fieldSelector == null ? other$fieldSelector != null : !this$fieldSelector.equals(other$fieldSelector)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$labelSelector = this.getLabelSelector();
        Object other$labelSelector = other.getLabelSelector();
        if (this$labelSelector == null ? other$labelSelector != null : !this$labelSelector.equals(other$labelSelector)) {
            return false;
        }
        Object this$limit = this.getLimit();
        Object other$limit = other.getLimit();
        if (this$limit == null ? other$limit != null : !this$limit.equals(other$limit)) {
            return false;
        }
        Object this$resourceVersion = this.getResourceVersion();
        Object other$resourceVersion = other.getResourceVersion();
        if (this$resourceVersion == null ? other$resourceVersion != null : !this$resourceVersion.equals(other$resourceVersion)) {
            return false;
        }
        Object this$resourceVersionMatch = this.getResourceVersionMatch();
        Object other$resourceVersionMatch = other.getResourceVersionMatch();
        if (this$resourceVersionMatch == null ? other$resourceVersionMatch != null : !this$resourceVersionMatch.equals(other$resourceVersionMatch)) {
            return false;
        }
        Object this$sendInitialEvents = this.getSendInitialEvents();
        Object other$sendInitialEvents = other.getSendInitialEvents();
        if (this$sendInitialEvents == null ? other$sendInitialEvents != null : !this$sendInitialEvents.equals(other$sendInitialEvents)) {
            return false;
        }
        Object this$shardSelector = this.getShardSelector();
        Object other$shardSelector = other.getShardSelector();
        if (this$shardSelector == null ? other$shardSelector != null : !this$shardSelector.equals(other$shardSelector)) {
            return false;
        }
        Object this$timeoutSeconds = this.getTimeoutSeconds();
        Object other$timeoutSeconds = other.getTimeoutSeconds();
        if (this$timeoutSeconds == null ? other$timeoutSeconds != null : !this$timeoutSeconds.equals(other$timeoutSeconds)) {
            return false;
        }
        Object this$watch = this.getWatch();
        Object other$watch = other.getWatch();
        if (this$watch == null ? other$watch != null : !this$watch.equals(other$watch)) {
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
        return other instanceof ListOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowWatchBookmarks = this.getAllowWatchBookmarks();
        result = result * prime + ($allowWatchBookmarks == null ? 43 : $allowWatchBookmarks.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $_continue = this.getContinue();
        result = result * prime + ($_continue == null ? 43 : $_continue.hashCode());
        Object $fieldSelector = this.getFieldSelector();
        result = result * prime + ($fieldSelector == null ? 43 : $fieldSelector.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $labelSelector = this.getLabelSelector();
        result = result * prime + ($labelSelector == null ? 43 : $labelSelector.hashCode());
        Object $limit = this.getLimit();
        result = result * prime + ($limit == null ? 43 : $limit.hashCode());
        Object $resourceVersion = this.getResourceVersion();
        result = result * prime + ($resourceVersion == null ? 43 : $resourceVersion.hashCode());
        Object $resourceVersionMatch = this.getResourceVersionMatch();
        result = result * prime + ($resourceVersionMatch == null ? 43 : $resourceVersionMatch.hashCode());
        Object $sendInitialEvents = this.getSendInitialEvents();
        result = result * prime + ($sendInitialEvents == null ? 43 : $sendInitialEvents.hashCode());
        Object $shardSelector = this.getShardSelector();
        result = result * prime + ($shardSelector == null ? 43 : $shardSelector.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $watch = this.getWatch();
        result = result * prime + ($watch == null ? 43 : $watch.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ListOptions(" + "allowWatchBookmarks=" + this.getAllowWatchBookmarks() + ", apiVersion=" + this.getApiVersion() + ", _continue=" + this.getContinue() + ", fieldSelector=" + this.getFieldSelector() + ", kind=" + this.getKind() + ", labelSelector=" + this.getLabelSelector() + ", limit=" + this.getLimit() + ", resourceVersion=" + this.getResourceVersion() + ", resourceVersionMatch=" + this.getResourceVersionMatch() + ", sendInitialEvents=" + this.getSendInitialEvents() + ", shardSelector=" + this.getShardSelector() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", watch=" + this.getWatch() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
