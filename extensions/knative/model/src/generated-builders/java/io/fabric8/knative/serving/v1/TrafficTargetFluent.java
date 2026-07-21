package io.fabric8.knative.serving.v1;

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
public class TrafficTargetFluent<A extends io.fabric8.knative.serving.v1.TrafficTargetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String configurationName;
  private Boolean latestRevision;
  private Long percent;
  private String revisionName;
  private String tag;
  private String url;

  public TrafficTargetFluent() {
  }
  
  public TrafficTargetFluent(TrafficTarget instance) {
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
  
  protected void copyInstance(TrafficTarget instance) {
    instance = instance != null ? instance : new TrafficTarget();
    if (instance != null) {
        this.withConfigurationName(instance.getConfigurationName());
        this.withLatestRevision(instance.getLatestRevision());
        this.withPercent(instance.getPercent());
        this.withRevisionName(instance.getRevisionName());
        this.withTag(instance.getTag());
        this.withUrl(instance.getUrl());
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
    TrafficTargetFluent that = (TrafficTargetFluent) o;
    if (!(Objects.equals(configurationName, that.configurationName))) {
      return false;
    }
    if (!(Objects.equals(latestRevision, that.latestRevision))) {
      return false;
    }
    if (!(Objects.equals(percent, that.percent))) {
      return false;
    }
    if (!(Objects.equals(revisionName, that.revisionName))) {
      return false;
    }
    if (!(Objects.equals(tag, that.tag))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getConfigurationName() {
    return this.configurationName;
  }
  
  public Boolean getLatestRevision() {
    return this.latestRevision;
  }
  
  public Long getPercent() {
    return this.percent;
  }
  
  public String getRevisionName() {
    return this.revisionName;
  }
  
  public String getTag() {
    return this.tag;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigurationName() {
    return this.configurationName != null;
  }
  
  public boolean hasLatestRevision() {
    return this.latestRevision != null;
  }
  
  public boolean hasPercent() {
    return this.percent != null;
  }
  
  public boolean hasRevisionName() {
    return this.revisionName != null;
  }
  
  public boolean hasTag() {
    return this.tag != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(configurationName, latestRevision, percent, revisionName, tag, url, additionalProperties);
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
    if (!(configurationName == null)) {
        sb.append("configurationName:");
        sb.append(configurationName);
        sb.append(",");
    }
    if (!(latestRevision == null)) {
        sb.append("latestRevision:");
        sb.append(latestRevision);
        sb.append(",");
    }
    if (!(percent == null)) {
        sb.append("percent:");
        sb.append(percent);
        sb.append(",");
    }
    if (!(revisionName == null)) {
        sb.append("revisionName:");
        sb.append(revisionName);
        sb.append(",");
    }
    if (!(tag == null)) {
        sb.append("tag:");
        sb.append(tag);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withConfigurationName(String configurationName) {
    this.configurationName = configurationName;
    return (A) this;
  }
  
  public A withLatestRevision() {
    return withLatestRevision(true);
  }
  
  public A withLatestRevision(Boolean latestRevision) {
    this.latestRevision = latestRevision;
    return (A) this;
  }
  
  public A withPercent(Long percent) {
    this.percent = percent;
    return (A) this;
  }
  
  public A withRevisionName(String revisionName) {
    this.revisionName = revisionName;
    return (A) this;
  }
  
  public A withTag(String tag) {
    this.tag = tag;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
}