package io.fabric8.openshift.api.model.config.v1;

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
public class LoadBalancerFluent<A extends io.fabric8.openshift.api.model.config.v1.LoadBalancerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IngressPlatformSpecBuilder platform;

  public LoadBalancerFluent() {
  }
  
  public LoadBalancerFluent(LoadBalancer instance) {
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
  
  public IngressPlatformSpec buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  protected void copyInstance(LoadBalancer instance) {
    instance = instance != null ? instance : new LoadBalancer();
    if (instance != null) {
        this.withPlatform(instance.getPlatform());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new IngressPlatformSpecBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(IngressPlatformSpec item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
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
    LoadBalancerFluent that = (LoadBalancerFluent) o;
    if (!(Objects.equals(platform, that.platform))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public int hashCode() {
    return Objects.hash(platform, additionalProperties);
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
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
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
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(IngressPlatformSpec item) {
    return new PlatformNested(item);
  }
  
  public A withPlatform(IngressPlatformSpec platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new IngressPlatformSpecBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  public class PlatformNested<N> extends IngressPlatformSpecFluent<PlatformNested<N>> implements Nested<N>{
  
    IngressPlatformSpecBuilder builder;
  
    PlatformNested(IngressPlatformSpec item) {
      this.builder = new IngressPlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
}