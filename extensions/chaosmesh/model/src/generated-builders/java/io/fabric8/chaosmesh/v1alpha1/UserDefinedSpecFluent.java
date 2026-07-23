package io.fabric8.chaosmesh.v1alpha1;

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
public class UserDefinedSpecFluent<A extends io.fabric8.chaosmesh.v1alpha1.UserDefinedSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String attackCmd;
  private String recoverCmd;

  public UserDefinedSpecFluent() {
  }
  
  public UserDefinedSpecFluent(UserDefinedSpec instance) {
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
  
  protected void copyInstance(UserDefinedSpec instance) {
    instance = instance != null ? instance : new UserDefinedSpec();
    if (instance != null) {
        this.withAttackCmd(instance.getAttackCmd());
        this.withRecoverCmd(instance.getRecoverCmd());
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
    UserDefinedSpecFluent that = (UserDefinedSpecFluent) o;
    if (!(Objects.equals(attackCmd, that.attackCmd))) {
      return false;
    }
    if (!(Objects.equals(recoverCmd, that.recoverCmd))) {
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
  
  public String getAttackCmd() {
    return this.attackCmd;
  }
  
  public String getRecoverCmd() {
    return this.recoverCmd;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttackCmd() {
    return this.attackCmd != null;
  }
  
  public boolean hasRecoverCmd() {
    return this.recoverCmd != null;
  }
  
  public int hashCode() {
    return Objects.hash(attackCmd, recoverCmd, additionalProperties);
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
    if (!(attackCmd == null)) {
        sb.append("attackCmd:");
        sb.append(attackCmd);
        sb.append(",");
    }
    if (!(recoverCmd == null)) {
        sb.append("recoverCmd:");
        sb.append(recoverCmd);
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
  
  public A withAttackCmd(String attackCmd) {
    this.attackCmd = attackCmd;
    return (A) this;
  }
  
  public A withRecoverCmd(String recoverCmd) {
    this.recoverCmd = recoverCmd;
    return (A) this;
  }
  
}