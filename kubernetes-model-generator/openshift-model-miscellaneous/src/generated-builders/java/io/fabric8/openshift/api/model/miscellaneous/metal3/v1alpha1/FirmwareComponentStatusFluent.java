package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class FirmwareComponentStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.FirmwareComponentStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String component;
  private String currentVersion;
  private String initialVersion;
  private String lastVersionFlashed;
  private String updatedAt;

  public FirmwareComponentStatusFluent() {
  }
  
  public FirmwareComponentStatusFluent(FirmwareComponentStatus instance) {
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
  
  protected void copyInstance(FirmwareComponentStatus instance) {
    instance = instance != null ? instance : new FirmwareComponentStatus();
    if (instance != null) {
        this.withComponent(instance.getComponent());
        this.withCurrentVersion(instance.getCurrentVersion());
        this.withInitialVersion(instance.getInitialVersion());
        this.withLastVersionFlashed(instance.getLastVersionFlashed());
        this.withUpdatedAt(instance.getUpdatedAt());
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
    FirmwareComponentStatusFluent that = (FirmwareComponentStatusFluent) o;
    if (!(Objects.equals(component, that.component))) {
      return false;
    }
    if (!(Objects.equals(currentVersion, that.currentVersion))) {
      return false;
    }
    if (!(Objects.equals(initialVersion, that.initialVersion))) {
      return false;
    }
    if (!(Objects.equals(lastVersionFlashed, that.lastVersionFlashed))) {
      return false;
    }
    if (!(Objects.equals(updatedAt, that.updatedAt))) {
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
  
  public String getComponent() {
    return this.component;
  }
  
  public String getCurrentVersion() {
    return this.currentVersion;
  }
  
  public String getInitialVersion() {
    return this.initialVersion;
  }
  
  public String getLastVersionFlashed() {
    return this.lastVersionFlashed;
  }
  
  public String getUpdatedAt() {
    return this.updatedAt;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComponent() {
    return this.component != null;
  }
  
  public boolean hasCurrentVersion() {
    return this.currentVersion != null;
  }
  
  public boolean hasInitialVersion() {
    return this.initialVersion != null;
  }
  
  public boolean hasLastVersionFlashed() {
    return this.lastVersionFlashed != null;
  }
  
  public boolean hasUpdatedAt() {
    return this.updatedAt != null;
  }
  
  public int hashCode() {
    return Objects.hash(component, currentVersion, initialVersion, lastVersionFlashed, updatedAt, additionalProperties);
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
    if (!(component == null)) {
        sb.append("component:");
        sb.append(component);
        sb.append(",");
    }
    if (!(currentVersion == null)) {
        sb.append("currentVersion:");
        sb.append(currentVersion);
        sb.append(",");
    }
    if (!(initialVersion == null)) {
        sb.append("initialVersion:");
        sb.append(initialVersion);
        sb.append(",");
    }
    if (!(lastVersionFlashed == null)) {
        sb.append("lastVersionFlashed:");
        sb.append(lastVersionFlashed);
        sb.append(",");
    }
    if (!(updatedAt == null)) {
        sb.append("updatedAt:");
        sb.append(updatedAt);
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
  
  public A withComponent(String component) {
    this.component = component;
    return (A) this;
  }
  
  public A withCurrentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
    return (A) this;
  }
  
  public A withInitialVersion(String initialVersion) {
    this.initialVersion = initialVersion;
    return (A) this;
  }
  
  public A withLastVersionFlashed(String lastVersionFlashed) {
    this.lastVersionFlashed = lastVersionFlashed;
    return (A) this;
  }
  
  public A withUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return (A) this;
  }
  
}