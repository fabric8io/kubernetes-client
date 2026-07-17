package io.fabric8.openshift.api.model.operatorhub.v1;

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
public class FeaturesFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1.FeaturesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean disableCopiedCSVs;
  private String packageServerSyncInterval;

  public FeaturesFluent() {
  }
  
  public FeaturesFluent(Features instance) {
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
  
  protected void copyInstance(Features instance) {
    instance = instance != null ? instance : new Features();
    if (instance != null) {
        this.withDisableCopiedCSVs(instance.getDisableCopiedCSVs());
        this.withPackageServerSyncInterval(instance.getPackageServerSyncInterval());
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
    FeaturesFluent that = (FeaturesFluent) o;
    if (!(Objects.equals(disableCopiedCSVs, that.disableCopiedCSVs))) {
      return false;
    }
    if (!(Objects.equals(packageServerSyncInterval, that.packageServerSyncInterval))) {
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
  
  public Boolean getDisableCopiedCSVs() {
    return this.disableCopiedCSVs;
  }
  
  public String getPackageServerSyncInterval() {
    return this.packageServerSyncInterval;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDisableCopiedCSVs() {
    return this.disableCopiedCSVs != null;
  }
  
  public boolean hasPackageServerSyncInterval() {
    return this.packageServerSyncInterval != null;
  }
  
  public int hashCode() {
    return Objects.hash(disableCopiedCSVs, packageServerSyncInterval, additionalProperties);
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
    if (!(disableCopiedCSVs == null)) {
        sb.append("disableCopiedCSVs:");
        sb.append(disableCopiedCSVs);
        sb.append(",");
    }
    if (!(packageServerSyncInterval == null)) {
        sb.append("packageServerSyncInterval:");
        sb.append(packageServerSyncInterval);
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
  
  public A withDisableCopiedCSVs() {
    return withDisableCopiedCSVs(true);
  }
  
  public A withDisableCopiedCSVs(Boolean disableCopiedCSVs) {
    this.disableCopiedCSVs = disableCopiedCSVs;
    return (A) this;
  }
  
  public A withPackageServerSyncInterval(String packageServerSyncInterval) {
    this.packageServerSyncInterval = packageServerSyncInterval;
    return (A) this;
  }
  
}