package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
public class RetentionConfigFluent<A extends io.fabric8.openclustermanagement.api.model.observability.v1beta2.RetentionConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String blockDuration;
  private String deleteDelay;
  private String retentionInLocal;
  private String retentionResolution1h;
  private String retentionResolution5m;
  private String retentionResolutionRaw;

  public RetentionConfigFluent() {
  }
  
  public RetentionConfigFluent(RetentionConfig instance) {
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
  
  protected void copyInstance(RetentionConfig instance) {
    instance = instance != null ? instance : new RetentionConfig();
    if (instance != null) {
        this.withBlockDuration(instance.getBlockDuration());
        this.withDeleteDelay(instance.getDeleteDelay());
        this.withRetentionInLocal(instance.getRetentionInLocal());
        this.withRetentionResolution1h(instance.getRetentionResolution1h());
        this.withRetentionResolution5m(instance.getRetentionResolution5m());
        this.withRetentionResolutionRaw(instance.getRetentionResolutionRaw());
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
    RetentionConfigFluent that = (RetentionConfigFluent) o;
    if (!(Objects.equals(blockDuration, that.blockDuration))) {
      return false;
    }
    if (!(Objects.equals(deleteDelay, that.deleteDelay))) {
      return false;
    }
    if (!(Objects.equals(retentionInLocal, that.retentionInLocal))) {
      return false;
    }
    if (!(Objects.equals(retentionResolution1h, that.retentionResolution1h))) {
      return false;
    }
    if (!(Objects.equals(retentionResolution5m, that.retentionResolution5m))) {
      return false;
    }
    if (!(Objects.equals(retentionResolutionRaw, that.retentionResolutionRaw))) {
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
  
  public String getBlockDuration() {
    return this.blockDuration;
  }
  
  public String getDeleteDelay() {
    return this.deleteDelay;
  }
  
  public String getRetentionInLocal() {
    return this.retentionInLocal;
  }
  
  public String getRetentionResolution1h() {
    return this.retentionResolution1h;
  }
  
  public String getRetentionResolution5m() {
    return this.retentionResolution5m;
  }
  
  public String getRetentionResolutionRaw() {
    return this.retentionResolutionRaw;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBlockDuration() {
    return this.blockDuration != null;
  }
  
  public boolean hasDeleteDelay() {
    return this.deleteDelay != null;
  }
  
  public boolean hasRetentionInLocal() {
    return this.retentionInLocal != null;
  }
  
  public boolean hasRetentionResolution1h() {
    return this.retentionResolution1h != null;
  }
  
  public boolean hasRetentionResolution5m() {
    return this.retentionResolution5m != null;
  }
  
  public boolean hasRetentionResolutionRaw() {
    return this.retentionResolutionRaw != null;
  }
  
  public int hashCode() {
    return Objects.hash(blockDuration, deleteDelay, retentionInLocal, retentionResolution1h, retentionResolution5m, retentionResolutionRaw, additionalProperties);
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
    if (!(blockDuration == null)) {
        sb.append("blockDuration:");
        sb.append(blockDuration);
        sb.append(",");
    }
    if (!(deleteDelay == null)) {
        sb.append("deleteDelay:");
        sb.append(deleteDelay);
        sb.append(",");
    }
    if (!(retentionInLocal == null)) {
        sb.append("retentionInLocal:");
        sb.append(retentionInLocal);
        sb.append(",");
    }
    if (!(retentionResolution1h == null)) {
        sb.append("retentionResolution1h:");
        sb.append(retentionResolution1h);
        sb.append(",");
    }
    if (!(retentionResolution5m == null)) {
        sb.append("retentionResolution5m:");
        sb.append(retentionResolution5m);
        sb.append(",");
    }
    if (!(retentionResolutionRaw == null)) {
        sb.append("retentionResolutionRaw:");
        sb.append(retentionResolutionRaw);
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
  
  public A withBlockDuration(String blockDuration) {
    this.blockDuration = blockDuration;
    return (A) this;
  }
  
  public A withDeleteDelay(String deleteDelay) {
    this.deleteDelay = deleteDelay;
    return (A) this;
  }
  
  public A withRetentionInLocal(String retentionInLocal) {
    this.retentionInLocal = retentionInLocal;
    return (A) this;
  }
  
  public A withRetentionResolution1h(String retentionResolution1h) {
    this.retentionResolution1h = retentionResolution1h;
    return (A) this;
  }
  
  public A withRetentionResolution5m(String retentionResolution5m) {
    this.retentionResolution5m = retentionResolution5m;
    return (A) this;
  }
  
  public A withRetentionResolutionRaw(String retentionResolutionRaw) {
    this.retentionResolutionRaw = retentionResolutionRaw;
    return (A) this;
  }
  
}