package io.fabric8.knative.sinks.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
public class LogFluent<A extends io.fabric8.knative.sinks.v1alpha1.LogFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String level;
  private Boolean logMask;
  private String loggerName;
  private String marker;
  private Boolean multiline;
  private Boolean showAllProperties;
  private Boolean showBody;
  private Boolean showBodyType;
  private Boolean showCachedStreams;
  private Boolean showExchangePattern;
  private Boolean showHeaders;
  private Boolean showProperties;
  private Boolean showStreams;

  public LogFluent() {
  }
  
  public LogFluent(Log instance) {
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
  
  protected void copyInstance(Log instance) {
    instance = instance != null ? instance : new Log();
    if (instance != null) {
        this.withLevel(instance.getLevel());
        this.withLogMask(instance.getLogMask());
        this.withLoggerName(instance.getLoggerName());
        this.withMarker(instance.getMarker());
        this.withMultiline(instance.getMultiline());
        this.withShowAllProperties(instance.getShowAllProperties());
        this.withShowBody(instance.getShowBody());
        this.withShowBodyType(instance.getShowBodyType());
        this.withShowCachedStreams(instance.getShowCachedStreams());
        this.withShowExchangePattern(instance.getShowExchangePattern());
        this.withShowHeaders(instance.getShowHeaders());
        this.withShowProperties(instance.getShowProperties());
        this.withShowStreams(instance.getShowStreams());
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
    LogFluent that = (LogFluent) o;
    if (!(Objects.equals(level, that.level))) {
      return false;
    }
    if (!(Objects.equals(logMask, that.logMask))) {
      return false;
    }
    if (!(Objects.equals(loggerName, that.loggerName))) {
      return false;
    }
    if (!(Objects.equals(marker, that.marker))) {
      return false;
    }
    if (!(Objects.equals(multiline, that.multiline))) {
      return false;
    }
    if (!(Objects.equals(showAllProperties, that.showAllProperties))) {
      return false;
    }
    if (!(Objects.equals(showBody, that.showBody))) {
      return false;
    }
    if (!(Objects.equals(showBodyType, that.showBodyType))) {
      return false;
    }
    if (!(Objects.equals(showCachedStreams, that.showCachedStreams))) {
      return false;
    }
    if (!(Objects.equals(showExchangePattern, that.showExchangePattern))) {
      return false;
    }
    if (!(Objects.equals(showHeaders, that.showHeaders))) {
      return false;
    }
    if (!(Objects.equals(showProperties, that.showProperties))) {
      return false;
    }
    if (!(Objects.equals(showStreams, that.showStreams))) {
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
  
  public String getLevel() {
    return this.level;
  }
  
  public Boolean getLogMask() {
    return this.logMask;
  }
  
  public String getLoggerName() {
    return this.loggerName;
  }
  
  public String getMarker() {
    return this.marker;
  }
  
  public Boolean getMultiline() {
    return this.multiline;
  }
  
  public Boolean getShowAllProperties() {
    return this.showAllProperties;
  }
  
  public Boolean getShowBody() {
    return this.showBody;
  }
  
  public Boolean getShowBodyType() {
    return this.showBodyType;
  }
  
  public Boolean getShowCachedStreams() {
    return this.showCachedStreams;
  }
  
  public Boolean getShowExchangePattern() {
    return this.showExchangePattern;
  }
  
  public Boolean getShowHeaders() {
    return this.showHeaders;
  }
  
  public Boolean getShowProperties() {
    return this.showProperties;
  }
  
  public Boolean getShowStreams() {
    return this.showStreams;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLevel() {
    return this.level != null;
  }
  
  public boolean hasLogMask() {
    return this.logMask != null;
  }
  
  public boolean hasLoggerName() {
    return this.loggerName != null;
  }
  
  public boolean hasMarker() {
    return this.marker != null;
  }
  
  public boolean hasMultiline() {
    return this.multiline != null;
  }
  
  public boolean hasShowAllProperties() {
    return this.showAllProperties != null;
  }
  
  public boolean hasShowBody() {
    return this.showBody != null;
  }
  
  public boolean hasShowBodyType() {
    return this.showBodyType != null;
  }
  
  public boolean hasShowCachedStreams() {
    return this.showCachedStreams != null;
  }
  
  public boolean hasShowExchangePattern() {
    return this.showExchangePattern != null;
  }
  
  public boolean hasShowHeaders() {
    return this.showHeaders != null;
  }
  
  public boolean hasShowProperties() {
    return this.showProperties != null;
  }
  
  public boolean hasShowStreams() {
    return this.showStreams != null;
  }
  
  public int hashCode() {
    return Objects.hash(level, logMask, loggerName, marker, multiline, showAllProperties, showBody, showBodyType, showCachedStreams, showExchangePattern, showHeaders, showProperties, showStreams, additionalProperties);
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
    if (!(level == null)) {
        sb.append("level:");
        sb.append(level);
        sb.append(",");
    }
    if (!(logMask == null)) {
        sb.append("logMask:");
        sb.append(logMask);
        sb.append(",");
    }
    if (!(loggerName == null)) {
        sb.append("loggerName:");
        sb.append(loggerName);
        sb.append(",");
    }
    if (!(marker == null)) {
        sb.append("marker:");
        sb.append(marker);
        sb.append(",");
    }
    if (!(multiline == null)) {
        sb.append("multiline:");
        sb.append(multiline);
        sb.append(",");
    }
    if (!(showAllProperties == null)) {
        sb.append("showAllProperties:");
        sb.append(showAllProperties);
        sb.append(",");
    }
    if (!(showBody == null)) {
        sb.append("showBody:");
        sb.append(showBody);
        sb.append(",");
    }
    if (!(showBodyType == null)) {
        sb.append("showBodyType:");
        sb.append(showBodyType);
        sb.append(",");
    }
    if (!(showCachedStreams == null)) {
        sb.append("showCachedStreams:");
        sb.append(showCachedStreams);
        sb.append(",");
    }
    if (!(showExchangePattern == null)) {
        sb.append("showExchangePattern:");
        sb.append(showExchangePattern);
        sb.append(",");
    }
    if (!(showHeaders == null)) {
        sb.append("showHeaders:");
        sb.append(showHeaders);
        sb.append(",");
    }
    if (!(showProperties == null)) {
        sb.append("showProperties:");
        sb.append(showProperties);
        sb.append(",");
    }
    if (!(showStreams == null)) {
        sb.append("showStreams:");
        sb.append(showStreams);
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
  
  public A withLevel(String level) {
    this.level = level;
    return (A) this;
  }
  
  public A withLogMask() {
    return withLogMask(true);
  }
  
  public A withLogMask(Boolean logMask) {
    this.logMask = logMask;
    return (A) this;
  }
  
  public A withLoggerName(String loggerName) {
    this.loggerName = loggerName;
    return (A) this;
  }
  
  public A withMarker(String marker) {
    this.marker = marker;
    return (A) this;
  }
  
  public A withMultiline() {
    return withMultiline(true);
  }
  
  public A withMultiline(Boolean multiline) {
    this.multiline = multiline;
    return (A) this;
  }
  
  public A withShowAllProperties() {
    return withShowAllProperties(true);
  }
  
  public A withShowAllProperties(Boolean showAllProperties) {
    this.showAllProperties = showAllProperties;
    return (A) this;
  }
  
  public A withShowBody() {
    return withShowBody(true);
  }
  
  public A withShowBody(Boolean showBody) {
    this.showBody = showBody;
    return (A) this;
  }
  
  public A withShowBodyType() {
    return withShowBodyType(true);
  }
  
  public A withShowBodyType(Boolean showBodyType) {
    this.showBodyType = showBodyType;
    return (A) this;
  }
  
  public A withShowCachedStreams() {
    return withShowCachedStreams(true);
  }
  
  public A withShowCachedStreams(Boolean showCachedStreams) {
    this.showCachedStreams = showCachedStreams;
    return (A) this;
  }
  
  public A withShowExchangePattern() {
    return withShowExchangePattern(true);
  }
  
  public A withShowExchangePattern(Boolean showExchangePattern) {
    this.showExchangePattern = showExchangePattern;
    return (A) this;
  }
  
  public A withShowHeaders() {
    return withShowHeaders(true);
  }
  
  public A withShowHeaders(Boolean showHeaders) {
    this.showHeaders = showHeaders;
    return (A) this;
  }
  
  public A withShowProperties() {
    return withShowProperties(true);
  }
  
  public A withShowProperties(Boolean showProperties) {
    this.showProperties = showProperties;
    return (A) this;
  }
  
  public A withShowStreams() {
    return withShowStreams(true);
  }
  
  public A withShowStreams(Boolean showStreams) {
    this.showStreams = showStreams;
    return (A) this;
  }
  
}