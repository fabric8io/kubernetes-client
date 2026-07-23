package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class StatusCheckTemplateFluent<A extends io.fabric8.chaosmesh.v1alpha1.StatusCheckTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String duration;
  private Integer failureThreshold;
  private HTTPStatusCheckBuilder http;
  private Integer intervalSeconds;
  private String mode;
  private Integer recordsHistoryLimit;
  private Integer successThreshold;
  private Integer timeoutSeconds;
  private String type;

  public StatusCheckTemplateFluent() {
  }
  
  public StatusCheckTemplateFluent(StatusCheckTemplate instance) {
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
  
  public HTTPStatusCheck buildHttp() {
    return this.http != null ? this.http.build() : null;
  }
  
  protected void copyInstance(StatusCheckTemplate instance) {
    instance = instance != null ? instance : new StatusCheckTemplate();
    if (instance != null) {
        this.withDuration(instance.getDuration());
        this.withFailureThreshold(instance.getFailureThreshold());
        this.withHttp(instance.getHttp());
        this.withIntervalSeconds(instance.getIntervalSeconds());
        this.withMode(instance.getMode());
        this.withRecordsHistoryLimit(instance.getRecordsHistoryLimit());
        this.withSuccessThreshold(instance.getSuccessThreshold());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpNested<A> editHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(null));
  }
  
  public HttpNested<A> editOrNewHttp() {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(new HTTPStatusCheckBuilder().build()));
  }
  
  public HttpNested<A> editOrNewHttpLike(HTTPStatusCheck item) {
    return this.withNewHttpLike(Optional.ofNullable(this.buildHttp()).orElse(item));
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
    StatusCheckTemplateFluent that = (StatusCheckTemplateFluent) o;
    if (!(Objects.equals(duration, that.duration))) {
      return false;
    }
    if (!(Objects.equals(failureThreshold, that.failureThreshold))) {
      return false;
    }
    if (!(Objects.equals(http, that.http))) {
      return false;
    }
    if (!(Objects.equals(intervalSeconds, that.intervalSeconds))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(recordsHistoryLimit, that.recordsHistoryLimit))) {
      return false;
    }
    if (!(Objects.equals(successThreshold, that.successThreshold))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getDuration() {
    return this.duration;
  }
  
  public Integer getFailureThreshold() {
    return this.failureThreshold;
  }
  
  public Integer getIntervalSeconds() {
    return this.intervalSeconds;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public Integer getRecordsHistoryLimit() {
    return this.recordsHistoryLimit;
  }
  
  public Integer getSuccessThreshold() {
    return this.successThreshold;
  }
  
  public Integer getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDuration() {
    return this.duration != null;
  }
  
  public boolean hasFailureThreshold() {
    return this.failureThreshold != null;
  }
  
  public boolean hasHttp() {
    return this.http != null;
  }
  
  public boolean hasIntervalSeconds() {
    return this.intervalSeconds != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasRecordsHistoryLimit() {
    return this.recordsHistoryLimit != null;
  }
  
  public boolean hasSuccessThreshold() {
    return this.successThreshold != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(duration, failureThreshold, http, intervalSeconds, mode, recordsHistoryLimit, successThreshold, timeoutSeconds, type, additionalProperties);
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
    if (!(duration == null)) {
        sb.append("duration:");
        sb.append(duration);
        sb.append(",");
    }
    if (!(failureThreshold == null)) {
        sb.append("failureThreshold:");
        sb.append(failureThreshold);
        sb.append(",");
    }
    if (!(http == null)) {
        sb.append("http:");
        sb.append(http);
        sb.append(",");
    }
    if (!(intervalSeconds == null)) {
        sb.append("intervalSeconds:");
        sb.append(intervalSeconds);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(recordsHistoryLimit == null)) {
        sb.append("recordsHistoryLimit:");
        sb.append(recordsHistoryLimit);
        sb.append(",");
    }
    if (!(successThreshold == null)) {
        sb.append("successThreshold:");
        sb.append(successThreshold);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withDuration(String duration) {
    this.duration = duration;
    return (A) this;
  }
  
  public A withFailureThreshold(Integer failureThreshold) {
    this.failureThreshold = failureThreshold;
    return (A) this;
  }
  
  public A withHttp(HTTPStatusCheck http) {
    this._visitables.remove("http");
    if (http != null) {
        this.http = new HTTPStatusCheckBuilder(http);
        this._visitables.get("http").add(this.http);
    } else {
        this.http = null;
        this._visitables.get("http").remove(this.http);
    }
    return (A) this;
  }
  
  public A withIntervalSeconds(Integer intervalSeconds) {
    this.intervalSeconds = intervalSeconds;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public HttpNested<A> withNewHttp() {
    return new HttpNested(null);
  }
  
  public HttpNested<A> withNewHttpLike(HTTPStatusCheck item) {
    return new HttpNested(item);
  }
  
  public A withRecordsHistoryLimit(Integer recordsHistoryLimit) {
    this.recordsHistoryLimit = recordsHistoryLimit;
    return (A) this;
  }
  
  public A withSuccessThreshold(Integer successThreshold) {
    this.successThreshold = successThreshold;
    return (A) this;
  }
  
  public A withTimeoutSeconds(Integer timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class HttpNested<N> extends HTTPStatusCheckFluent<HttpNested<N>> implements Nested<N>{
  
    HTTPStatusCheckBuilder builder;
  
    HttpNested(HTTPStatusCheck item) {
      this.builder = new HTTPStatusCheckBuilder(this, item);
    }
  
    public N and() {
      return (N) StatusCheckTemplateFluent.this.withHttp(builder.build());
    }
    
    public N endHttp() {
      return and();
    }
    
  }
}