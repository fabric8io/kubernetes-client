package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class GCESDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.GCESDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String filter;
  private Integer port;
  private String project;
  private String refreshInterval;
  private String tagSeparator;
  private String zone;

  public GCESDConfigFluent() {
  }
  
  public GCESDConfigFluent(GCESDConfig instance) {
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
  
  protected void copyInstance(GCESDConfig instance) {
    instance = instance != null ? instance : new GCESDConfig();
    if (instance != null) {
        this.withFilter(instance.getFilter());
        this.withPort(instance.getPort());
        this.withProject(instance.getProject());
        this.withRefreshInterval(instance.getRefreshInterval());
        this.withTagSeparator(instance.getTagSeparator());
        this.withZone(instance.getZone());
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
    GCESDConfigFluent that = (GCESDConfigFluent) o;
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(project, that.project))) {
      return false;
    }
    if (!(Objects.equals(refreshInterval, that.refreshInterval))) {
      return false;
    }
    if (!(Objects.equals(tagSeparator, that.tagSeparator))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
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
  
  public String getFilter() {
    return this.filter;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public String getProject() {
    return this.project;
  }
  
  public String getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public String getTagSeparator() {
    return this.tagSeparator;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasProject() {
    return this.project != null;
  }
  
  public boolean hasRefreshInterval() {
    return this.refreshInterval != null;
  }
  
  public boolean hasTagSeparator() {
    return this.tagSeparator != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public int hashCode() {
    return Objects.hash(filter, port, project, refreshInterval, tagSeparator, zone, additionalProperties);
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
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(project == null)) {
        sb.append("project:");
        sb.append(project);
        sb.append(",");
    }
    if (!(refreshInterval == null)) {
        sb.append("refreshInterval:");
        sb.append(refreshInterval);
        sb.append(",");
    }
    if (!(tagSeparator == null)) {
        sb.append("tagSeparator:");
        sb.append(tagSeparator);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
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
  
  public A withFilter(String filter) {
    this.filter = filter;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withProject(String project) {
    this.project = project;
    return (A) this;
  }
  
  public A withRefreshInterval(String refreshInterval) {
    this.refreshInterval = refreshInterval;
    return (A) this;
  }
  
  public A withTagSeparator(String tagSeparator) {
    this.tagSeparator = tagSeparator;
    return (A) this;
  }
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  
}