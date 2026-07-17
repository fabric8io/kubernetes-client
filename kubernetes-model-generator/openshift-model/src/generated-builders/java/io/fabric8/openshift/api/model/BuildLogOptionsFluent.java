package io.fabric8.openshift.api.model;

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
public class BuildLogOptionsFluent<A extends io.fabric8.openshift.api.model.BuildLogOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String container;
  private Boolean follow;
  private Boolean insecureSkipTLSVerifyBackend;
  private String kind;
  private Long limitBytes;
  private Boolean nowait;
  private Boolean previous;
  private Long sinceSeconds;
  private String sinceTime;
  private Long tailLines;
  private Boolean timestamps;
  private Long version;

  public BuildLogOptionsFluent() {
  }
  
  public BuildLogOptionsFluent(BuildLogOptions instance) {
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
  
  protected void copyInstance(BuildLogOptions instance) {
    instance = instance != null ? instance : new BuildLogOptions();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withContainer(instance.getContainer());
        this.withFollow(instance.getFollow());
        this.withInsecureSkipTLSVerifyBackend(instance.getInsecureSkipTLSVerifyBackend());
        this.withKind(instance.getKind());
        this.withLimitBytes(instance.getLimitBytes());
        this.withNowait(instance.getNowait());
        this.withPrevious(instance.getPrevious());
        this.withSinceSeconds(instance.getSinceSeconds());
        this.withSinceTime(instance.getSinceTime());
        this.withTailLines(instance.getTailLines());
        this.withTimestamps(instance.getTimestamps());
        this.withVersion(instance.getVersion());
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
    BuildLogOptionsFluent that = (BuildLogOptionsFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(follow, that.follow))) {
      return false;
    }
    if (!(Objects.equals(insecureSkipTLSVerifyBackend, that.insecureSkipTLSVerifyBackend))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(limitBytes, that.limitBytes))) {
      return false;
    }
    if (!(Objects.equals(nowait, that.nowait))) {
      return false;
    }
    if (!(Objects.equals(previous, that.previous))) {
      return false;
    }
    if (!(Objects.equals(sinceSeconds, that.sinceSeconds))) {
      return false;
    }
    if (!(Objects.equals(sinceTime, that.sinceTime))) {
      return false;
    }
    if (!(Objects.equals(tailLines, that.tailLines))) {
      return false;
    }
    if (!(Objects.equals(timestamps, that.timestamps))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getContainer() {
    return this.container;
  }
  
  public Boolean getFollow() {
    return this.follow;
  }
  
  public Boolean getInsecureSkipTLSVerifyBackend() {
    return this.insecureSkipTLSVerifyBackend;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Long getLimitBytes() {
    return this.limitBytes;
  }
  
  public Boolean getNowait() {
    return this.nowait;
  }
  
  public Boolean getPrevious() {
    return this.previous;
  }
  
  public Long getSinceSeconds() {
    return this.sinceSeconds;
  }
  
  public String getSinceTime() {
    return this.sinceTime;
  }
  
  public Long getTailLines() {
    return this.tailLines;
  }
  
  public Boolean getTimestamps() {
    return this.timestamps;
  }
  
  public Long getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasFollow() {
    return this.follow != null;
  }
  
  public boolean hasInsecureSkipTLSVerifyBackend() {
    return this.insecureSkipTLSVerifyBackend != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLimitBytes() {
    return this.limitBytes != null;
  }
  
  public boolean hasNowait() {
    return this.nowait != null;
  }
  
  public boolean hasPrevious() {
    return this.previous != null;
  }
  
  public boolean hasSinceSeconds() {
    return this.sinceSeconds != null;
  }
  
  public boolean hasSinceTime() {
    return this.sinceTime != null;
  }
  
  public boolean hasTailLines() {
    return this.tailLines != null;
  }
  
  public boolean hasTimestamps() {
    return this.timestamps != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, container, follow, insecureSkipTLSVerifyBackend, kind, limitBytes, nowait, previous, sinceSeconds, sinceTime, tailLines, timestamps, version, additionalProperties);
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
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(follow == null)) {
        sb.append("follow:");
        sb.append(follow);
        sb.append(",");
    }
    if (!(insecureSkipTLSVerifyBackend == null)) {
        sb.append("insecureSkipTLSVerifyBackend:");
        sb.append(insecureSkipTLSVerifyBackend);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(limitBytes == null)) {
        sb.append("limitBytes:");
        sb.append(limitBytes);
        sb.append(",");
    }
    if (!(nowait == null)) {
        sb.append("nowait:");
        sb.append(nowait);
        sb.append(",");
    }
    if (!(previous == null)) {
        sb.append("previous:");
        sb.append(previous);
        sb.append(",");
    }
    if (!(sinceSeconds == null)) {
        sb.append("sinceSeconds:");
        sb.append(sinceSeconds);
        sb.append(",");
    }
    if (!(sinceTime == null)) {
        sb.append("sinceTime:");
        sb.append(sinceTime);
        sb.append(",");
    }
    if (!(tailLines == null)) {
        sb.append("tailLines:");
        sb.append(tailLines);
        sb.append(",");
    }
    if (!(timestamps == null)) {
        sb.append("timestamps:");
        sb.append(timestamps);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withContainer(String container) {
    this.container = container;
    return (A) this;
  }
  
  public A withFollow() {
    return withFollow(true);
  }
  
  public A withFollow(Boolean follow) {
    this.follow = follow;
    return (A) this;
  }
  
  public A withInsecureSkipTLSVerifyBackend() {
    return withInsecureSkipTLSVerifyBackend(true);
  }
  
  public A withInsecureSkipTLSVerifyBackend(Boolean insecureSkipTLSVerifyBackend) {
    this.insecureSkipTLSVerifyBackend = insecureSkipTLSVerifyBackend;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLimitBytes(Long limitBytes) {
    this.limitBytes = limitBytes;
    return (A) this;
  }
  
  public A withNowait() {
    return withNowait(true);
  }
  
  public A withNowait(Boolean nowait) {
    this.nowait = nowait;
    return (A) this;
  }
  
  public A withPrevious() {
    return withPrevious(true);
  }
  
  public A withPrevious(Boolean previous) {
    this.previous = previous;
    return (A) this;
  }
  
  public A withSinceSeconds(Long sinceSeconds) {
    this.sinceSeconds = sinceSeconds;
    return (A) this;
  }
  
  public A withSinceTime(String sinceTime) {
    this.sinceTime = sinceTime;
    return (A) this;
  }
  
  public A withTailLines(Long tailLines) {
    this.tailLines = tailLines;
    return (A) this;
  }
  
  public A withTimestamps() {
    return withTimestamps(true);
  }
  
  public A withTimestamps(Boolean timestamps) {
    this.timestamps = timestamps;
    return (A) this;
  }
  
  public A withVersion(Long version) {
    this.version = version;
    return (A) this;
  }
  
}