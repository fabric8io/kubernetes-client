package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ListOptionsFluent<A extends io.fabric8.kubernetes.api.model.ListOptionsFluent<A>> extends BaseFluent<A>{

  private String _continue;
  private Map<String,Object> additionalProperties;
  private Boolean allowWatchBookmarks;
  private String apiVersion;
  private String fieldSelector;
  private String kind;
  private String labelSelector;
  private Long limit;
  private String resourceVersion;
  private String resourceVersionMatch;
  private Boolean sendInitialEvents;
  private String shardSelector;
  private Long timeoutSeconds;
  private Boolean watch;

  public ListOptionsFluent() {
  }
  
  public ListOptionsFluent(ListOptions instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(ListOptions instance) {
    instance = instance != null ? instance : new ListOptions();
    if (instance != null) {
        this.withAllowWatchBookmarks(instance.getAllowWatchBookmarks());
        this.withApiVersion(instance.getApiVersion());
        this.withContinue(instance.getContinue());
        this.withFieldSelector(instance.getFieldSelector());
        this.withKind(instance.getKind());
        this.withLabelSelector(instance.getLabelSelector());
        this.withLimit(instance.getLimit());
        this.withResourceVersion(instance.getResourceVersion());
        this.withResourceVersionMatch(instance.getResourceVersionMatch());
        this.withSendInitialEvents(instance.getSendInitialEvents());
        this.withShardSelector(instance.getShardSelector());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withWatch(instance.getWatch());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ListOptionsFluent that = (ListOptionsFluent) o;
    if (!(Objects.equals(allowWatchBookmarks, that.allowWatchBookmarks))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(_continue, that._continue))) {
      return false;
    }
    if (!(Objects.equals(fieldSelector, that.fieldSelector))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
      return false;
    }
    if (!(Objects.equals(limit, that.limit))) {
      return false;
    }
    if (!(Objects.equals(resourceVersion, that.resourceVersion))) {
      return false;
    }
    if (!(Objects.equals(resourceVersionMatch, that.resourceVersionMatch))) {
      return false;
    }
    if (!(Objects.equals(sendInitialEvents, that.sendInitialEvents))) {
      return false;
    }
    if (!(Objects.equals(shardSelector, that.shardSelector))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(watch, that.watch))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Boolean getAllowWatchBookmarks() {
    return this.allowWatchBookmarks;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getContinue() {
    return this._continue;
  }
  
  public String getFieldSelector() {
    return this.fieldSelector;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLabelSelector() {
    return this.labelSelector;
  }
  
  public Long getLimit() {
    return this.limit;
  }
  
  public String getResourceVersion() {
    return this.resourceVersion;
  }
  
  public String getResourceVersionMatch() {
    return this.resourceVersionMatch;
  }
  
  public Boolean getSendInitialEvents() {
    return this.sendInitialEvents;
  }
  
  public String getShardSelector() {
    return this.shardSelector;
  }
  
  public Long getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public Boolean getWatch() {
    return this.watch;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowWatchBookmarks() {
    return this.allowWatchBookmarks != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasContinue() {
    return this._continue != null;
  }
  
  public boolean hasFieldSelector() {
    return this.fieldSelector != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
  }
  
  public boolean hasLimit() {
    return this.limit != null;
  }
  
  public boolean hasResourceVersion() {
    return this.resourceVersion != null;
  }
  
  public boolean hasResourceVersionMatch() {
    return this.resourceVersionMatch != null;
  }
  
  public boolean hasSendInitialEvents() {
    return this.sendInitialEvents != null;
  }
  
  public boolean hasShardSelector() {
    return this.shardSelector != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public boolean hasWatch() {
    return this.watch != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowWatchBookmarks, apiVersion, _continue, fieldSelector, kind, labelSelector, limit, resourceVersion, resourceVersionMatch, sendInitialEvents, shardSelector, timeoutSeconds, watch, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowWatchBookmarks == null)) {
        sb.append("allowWatchBookmarks:");
        sb.append(allowWatchBookmarks);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(_continue == null)) {
        sb.append("_continue:");
        sb.append(_continue);
        sb.append(",");
    }
    if (!(fieldSelector == null)) {
        sb.append("fieldSelector:");
        sb.append(fieldSelector);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
        sb.append(",");
    }
    if (!(limit == null)) {
        sb.append("limit:");
        sb.append(limit);
        sb.append(",");
    }
    if (!(resourceVersion == null)) {
        sb.append("resourceVersion:");
        sb.append(resourceVersion);
        sb.append(",");
    }
    if (!(resourceVersionMatch == null)) {
        sb.append("resourceVersionMatch:");
        sb.append(resourceVersionMatch);
        sb.append(",");
    }
    if (!(sendInitialEvents == null)) {
        sb.append("sendInitialEvents:");
        sb.append(sendInitialEvents);
        sb.append(",");
    }
    if (!(shardSelector == null)) {
        sb.append("shardSelector:");
        sb.append(shardSelector);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
        sb.append(",");
    }
    if (!(watch == null)) {
        sb.append("watch:");
        sb.append(watch);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAllowWatchBookmarks() {
    return withAllowWatchBookmarks(true);
  }
  
  public A withAllowWatchBookmarks(Boolean allowWatchBookmarks) {
    this.allowWatchBookmarks = allowWatchBookmarks;
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withContinue(String _continue) {
    this._continue = _continue;
    return (A) this;
  }
  
  public A withFieldSelector(String fieldSelector) {
    this.fieldSelector = fieldSelector;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLabelSelector(String labelSelector) {
    this.labelSelector = labelSelector;
    return (A) this;
  }
  
  public A withLimit(Long limit) {
    this.limit = limit;
    return (A) this;
  }
  
  public A withResourceVersion(String resourceVersion) {
    this.resourceVersion = resourceVersion;
    return (A) this;
  }
  
  public A withResourceVersionMatch(String resourceVersionMatch) {
    this.resourceVersionMatch = resourceVersionMatch;
    return (A) this;
  }
  
  public A withSendInitialEvents() {
    return withSendInitialEvents(true);
  }
  
  public A withSendInitialEvents(Boolean sendInitialEvents) {
    this.sendInitialEvents = sendInitialEvents;
    return (A) this;
  }
  
  public A withShardSelector(String shardSelector) {
    this.shardSelector = shardSelector;
    return (A) this;
  }
  
  public A withTimeoutSeconds(Long timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
    return (A) this;
  }
  
  public A withWatch() {
    return withWatch(true);
  }
  
  public A withWatch(Boolean watch) {
    this.watch = watch;
    return (A) this;
  }
  
}