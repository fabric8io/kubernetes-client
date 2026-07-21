package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class LoadBalancerSettingsConsistentHashLBMaglevFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBMaglevFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LoadBalancerSettingsConsistentHashLBMagLev_Builder maglev;

  public LoadBalancerSettingsConsistentHashLBMaglevFluent() {
  }
  
  public LoadBalancerSettingsConsistentHashLBMaglevFluent(LoadBalancerSettingsConsistentHashLBMaglev instance) {
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
  
  public LoadBalancerSettingsConsistentHashLBMagLev_ buildMaglev() {
    return this.maglev != null ? this.maglev.build() : null;
  }
  
  protected void copyInstance(LoadBalancerSettingsConsistentHashLBMaglev instance) {
    instance = instance != null ? instance : new LoadBalancerSettingsConsistentHashLBMaglev();
    if (instance != null) {
        this.withMaglev(instance.getMaglev());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MaglevNested<A> editMaglev() {
    return this.withNewMaglevLike(Optional.ofNullable(this.buildMaglev()).orElse(null));
  }
  
  public MaglevNested<A> editOrNewMaglev() {
    return this.withNewMaglevLike(Optional.ofNullable(this.buildMaglev()).orElse(new LoadBalancerSettingsConsistentHashLBMagLev_Builder().build()));
  }
  
  public MaglevNested<A> editOrNewMaglevLike(LoadBalancerSettingsConsistentHashLBMagLev_ item) {
    return this.withNewMaglevLike(Optional.ofNullable(this.buildMaglev()).orElse(item));
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
    LoadBalancerSettingsConsistentHashLBMaglevFluent that = (LoadBalancerSettingsConsistentHashLBMaglevFluent) o;
    if (!(Objects.equals(maglev, that.maglev))) {
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
  
  public boolean hasMaglev() {
    return this.maglev != null;
  }
  
  public int hashCode() {
    return Objects.hash(maglev, additionalProperties);
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
    if (!(maglev == null)) {
        sb.append("maglev:");
        sb.append(maglev);
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
  
  public A withMaglev(LoadBalancerSettingsConsistentHashLBMagLev_ maglev) {
    this._visitables.remove("maglev");
    if (maglev != null) {
        this.maglev = new LoadBalancerSettingsConsistentHashLBMagLev_Builder(maglev);
        this._visitables.get("maglev").add(this.maglev);
    } else {
        this.maglev = null;
        this._visitables.get("maglev").remove(this.maglev);
    }
    return (A) this;
  }
  
  public MaglevNested<A> withNewMaglev() {
    return new MaglevNested(null);
  }
  
  public A withNewMaglev(Long tableSize) {
    return (A) this.withMaglev(new LoadBalancerSettingsConsistentHashLBMagLev_(tableSize));
  }
  
  public MaglevNested<A> withNewMaglevLike(LoadBalancerSettingsConsistentHashLBMagLev_ item) {
    return new MaglevNested(item);
  }
  public class MaglevNested<N> extends LoadBalancerSettingsConsistentHashLBMagLev_Fluent<MaglevNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBMagLev_Builder builder;
  
    MaglevNested(LoadBalancerSettingsConsistentHashLBMagLev_ item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBMagLev_Builder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBMaglevFluent.this.withMaglev(builder.build());
    }
    
    public N endMaglev() {
      return and();
    }
    
  }
}