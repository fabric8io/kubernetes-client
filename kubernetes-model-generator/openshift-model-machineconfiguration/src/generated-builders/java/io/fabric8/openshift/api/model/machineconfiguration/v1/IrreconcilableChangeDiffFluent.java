package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class IrreconcilableChangeDiffFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.IrreconcilableChangeDiffFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String diff;
  private String fieldPath;

  public IrreconcilableChangeDiffFluent() {
  }
  
  public IrreconcilableChangeDiffFluent(IrreconcilableChangeDiff instance) {
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
  
  protected void copyInstance(IrreconcilableChangeDiff instance) {
    instance = instance != null ? instance : new IrreconcilableChangeDiff();
    if (instance != null) {
        this.withDiff(instance.getDiff());
        this.withFieldPath(instance.getFieldPath());
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
    IrreconcilableChangeDiffFluent that = (IrreconcilableChangeDiffFluent) o;
    if (!(Objects.equals(diff, that.diff))) {
      return false;
    }
    if (!(Objects.equals(fieldPath, that.fieldPath))) {
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
  
  public String getDiff() {
    return this.diff;
  }
  
  public String getFieldPath() {
    return this.fieldPath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDiff() {
    return this.diff != null;
  }
  
  public boolean hasFieldPath() {
    return this.fieldPath != null;
  }
  
  public int hashCode() {
    return Objects.hash(diff, fieldPath, additionalProperties);
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
    if (!(diff == null)) {
        sb.append("diff:");
        sb.append(diff);
        sb.append(",");
    }
    if (!(fieldPath == null)) {
        sb.append("fieldPath:");
        sb.append(fieldPath);
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
  
  public A withDiff(String diff) {
    this.diff = diff;
    return (A) this;
  }
  
  public A withFieldPath(String fieldPath) {
    this.fieldPath = fieldPath;
    return (A) this;
  }
  
}