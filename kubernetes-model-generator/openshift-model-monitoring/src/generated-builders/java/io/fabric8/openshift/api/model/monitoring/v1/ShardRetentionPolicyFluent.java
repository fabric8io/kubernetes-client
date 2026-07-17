package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ShardRetentionPolicyFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ShardRetentionPolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private RetainConfigBuilder retain;
  private String whenScaled;

  public ShardRetentionPolicyFluent() {
  }
  
  public ShardRetentionPolicyFluent(ShardRetentionPolicy instance) {
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
  
  public RetainConfig buildRetain() {
    return this.retain != null ? this.retain.build() : null;
  }
  
  protected void copyInstance(ShardRetentionPolicy instance) {
    instance = instance != null ? instance : new ShardRetentionPolicy();
    if (instance != null) {
        this.withRetain(instance.getRetain());
        this.withWhenScaled(instance.getWhenScaled());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RetainNested<A> editOrNewRetain() {
    return this.withNewRetainLike(Optional.ofNullable(this.buildRetain()).orElse(new RetainConfigBuilder().build()));
  }
  
  public RetainNested<A> editOrNewRetainLike(RetainConfig item) {
    return this.withNewRetainLike(Optional.ofNullable(this.buildRetain()).orElse(item));
  }
  
  public RetainNested<A> editRetain() {
    return this.withNewRetainLike(Optional.ofNullable(this.buildRetain()).orElse(null));
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
    ShardRetentionPolicyFluent that = (ShardRetentionPolicyFluent) o;
    if (!(Objects.equals(retain, that.retain))) {
      return false;
    }
    if (!(Objects.equals(whenScaled, that.whenScaled))) {
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
  
  public String getWhenScaled() {
    return this.whenScaled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRetain() {
    return this.retain != null;
  }
  
  public boolean hasWhenScaled() {
    return this.whenScaled != null;
  }
  
  public int hashCode() {
    return Objects.hash(retain, whenScaled, additionalProperties);
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
    if (!(retain == null)) {
        sb.append("retain:");
        sb.append(retain);
        sb.append(",");
    }
    if (!(whenScaled == null)) {
        sb.append("whenScaled:");
        sb.append(whenScaled);
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
  
  public RetainNested<A> withNewRetain() {
    return new RetainNested(null);
  }
  
  public A withNewRetain(String retentionPeriod) {
    return (A) this.withRetain(new RetainConfig(retentionPeriod));
  }
  
  public RetainNested<A> withNewRetainLike(RetainConfig item) {
    return new RetainNested(item);
  }
  
  public A withRetain(RetainConfig retain) {
    this._visitables.remove("retain");
    if (retain != null) {
        this.retain = new RetainConfigBuilder(retain);
        this._visitables.get("retain").add(this.retain);
    } else {
        this.retain = null;
        this._visitables.get("retain").remove(this.retain);
    }
    return (A) this;
  }
  
  public A withWhenScaled(String whenScaled) {
    this.whenScaled = whenScaled;
    return (A) this;
  }
  public class RetainNested<N> extends RetainConfigFluent<RetainNested<N>> implements Nested<N>{
  
    RetainConfigBuilder builder;
  
    RetainNested(RetainConfig item) {
      this.builder = new RetainConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ShardRetentionPolicyFluent.this.withRetain(builder.build());
    }
    
    public N endRetain() {
      return and();
    }
    
  }
}