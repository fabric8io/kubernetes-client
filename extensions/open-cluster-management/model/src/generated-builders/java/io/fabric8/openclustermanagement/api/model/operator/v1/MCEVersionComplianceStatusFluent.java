package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class MCEVersionComplianceStatusFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.MCEVersionComplianceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String currentVersion;
  private Boolean isCompliant;
  private String message;
  private String requiredChannel;

  public MCEVersionComplianceStatusFluent() {
  }
  
  public MCEVersionComplianceStatusFluent(MCEVersionComplianceStatus instance) {
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
  
  protected void copyInstance(MCEVersionComplianceStatus instance) {
    instance = instance != null ? instance : new MCEVersionComplianceStatus();
    if (instance != null) {
        this.withCurrentVersion(instance.getCurrentVersion());
        this.withIsCompliant(instance.getIsCompliant());
        this.withMessage(instance.getMessage());
        this.withRequiredChannel(instance.getRequiredChannel());
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
    MCEVersionComplianceStatusFluent that = (MCEVersionComplianceStatusFluent) o;
    if (!(Objects.equals(currentVersion, that.currentVersion))) {
      return false;
    }
    if (!(Objects.equals(isCompliant, that.isCompliant))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(requiredChannel, that.requiredChannel))) {
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
  
  public String getCurrentVersion() {
    return this.currentVersion;
  }
  
  public Boolean getIsCompliant() {
    return this.isCompliant;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getRequiredChannel() {
    return this.requiredChannel;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentVersion() {
    return this.currentVersion != null;
  }
  
  public boolean hasIsCompliant() {
    return this.isCompliant != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasRequiredChannel() {
    return this.requiredChannel != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentVersion, isCompliant, message, requiredChannel, additionalProperties);
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
    if (!(currentVersion == null)) {
        sb.append("currentVersion:");
        sb.append(currentVersion);
        sb.append(",");
    }
    if (!(isCompliant == null)) {
        sb.append("isCompliant:");
        sb.append(isCompliant);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(requiredChannel == null)) {
        sb.append("requiredChannel:");
        sb.append(requiredChannel);
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
  
  public A withCurrentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
    return (A) this;
  }
  
  public A withIsCompliant() {
    return withIsCompliant(true);
  }
  
  public A withIsCompliant(Boolean isCompliant) {
    this.isCompliant = isCompliant;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withRequiredChannel(String requiredChannel) {
    this.requiredChannel = requiredChannel;
    return (A) this;
  }
  
}