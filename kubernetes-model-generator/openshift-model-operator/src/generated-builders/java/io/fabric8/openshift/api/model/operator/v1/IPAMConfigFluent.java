package io.fabric8.openshift.api.model.operator.v1;

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
public class IPAMConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.IPAMConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private StaticIPAMConfigBuilder staticIPAMConfig;
  private String type;

  public IPAMConfigFluent() {
  }
  
  public IPAMConfigFluent(IPAMConfig instance) {
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
  
  public StaticIPAMConfig buildStaticIPAMConfig() {
    return this.staticIPAMConfig != null ? this.staticIPAMConfig.build() : null;
  }
  
  protected void copyInstance(IPAMConfig instance) {
    instance = instance != null ? instance : new IPAMConfig();
    if (instance != null) {
        this.withStaticIPAMConfig(instance.getStaticIPAMConfig());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StaticIPAMConfigNested<A> editOrNewStaticIPAMConfig() {
    return this.withNewStaticIPAMConfigLike(Optional.ofNullable(this.buildStaticIPAMConfig()).orElse(new StaticIPAMConfigBuilder().build()));
  }
  
  public StaticIPAMConfigNested<A> editOrNewStaticIPAMConfigLike(StaticIPAMConfig item) {
    return this.withNewStaticIPAMConfigLike(Optional.ofNullable(this.buildStaticIPAMConfig()).orElse(item));
  }
  
  public StaticIPAMConfigNested<A> editStaticIPAMConfig() {
    return this.withNewStaticIPAMConfigLike(Optional.ofNullable(this.buildStaticIPAMConfig()).orElse(null));
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
    IPAMConfigFluent that = (IPAMConfigFluent) o;
    if (!(Objects.equals(staticIPAMConfig, that.staticIPAMConfig))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasStaticIPAMConfig() {
    return this.staticIPAMConfig != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(staticIPAMConfig, type, additionalProperties);
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
    if (!(staticIPAMConfig == null)) {
        sb.append("staticIPAMConfig:");
        sb.append(staticIPAMConfig);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public StaticIPAMConfigNested<A> withNewStaticIPAMConfig() {
    return new StaticIPAMConfigNested(null);
  }
  
  public StaticIPAMConfigNested<A> withNewStaticIPAMConfigLike(StaticIPAMConfig item) {
    return new StaticIPAMConfigNested(item);
  }
  
  public A withStaticIPAMConfig(StaticIPAMConfig staticIPAMConfig) {
    this._visitables.remove("staticIPAMConfig");
    if (staticIPAMConfig != null) {
        this.staticIPAMConfig = new StaticIPAMConfigBuilder(staticIPAMConfig);
        this._visitables.get("staticIPAMConfig").add(this.staticIPAMConfig);
    } else {
        this.staticIPAMConfig = null;
        this._visitables.get("staticIPAMConfig").remove(this.staticIPAMConfig);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class StaticIPAMConfigNested<N> extends StaticIPAMConfigFluent<StaticIPAMConfigNested<N>> implements Nested<N>{
  
    StaticIPAMConfigBuilder builder;
  
    StaticIPAMConfigNested(StaticIPAMConfig item) {
      this.builder = new StaticIPAMConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) IPAMConfigFluent.this.withStaticIPAMConfig(builder.build());
    }
    
    public N endStaticIPAMConfig() {
      return and();
    }
    
  }
}